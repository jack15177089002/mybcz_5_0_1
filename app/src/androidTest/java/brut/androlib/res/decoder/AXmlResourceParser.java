package brut.androlib.res.decoder;

import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import brut.androlib.AndrolibException;
import brut.androlib.res.xml.ResXmlEncoders;
import brut.util.ExtDataInput;
import com.p045c.p046a.LEDataInputStream;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xmlpull.v1.XmlPullParserException;

public class AXmlResourceParser implements XmlResourceParser {
    private static final int ATTRIBUTE_IX_NAME = 1;
    private static final int ATTRIBUTE_IX_NAMESPACE_URI = 0;
    private static final int ATTRIBUTE_IX_VALUE_DATA = 4;
    private static final int ATTRIBUTE_IX_VALUE_STRING = 2;
    private static final int ATTRIBUTE_IX_VALUE_TYPE = 3;
    private static final int ATTRIBUTE_LENGHT = 5;
    private static final int CHUNK_AXML_FILE = 524291;
    private static final int CHUNK_RESOURCEIDS = 524672;
    private static final int CHUNK_XML_END_NAMESPACE = 1048833;
    private static final int CHUNK_XML_END_TAG = 1048835;
    private static final int CHUNK_XML_FIRST = 1048832;
    private static final int CHUNK_XML_LAST = 1048836;
    private static final int CHUNK_XML_START_NAMESPACE = 1048832;
    private static final int CHUNK_XML_START_TAG = 1048834;
    private static final int CHUNK_XML_TEXT = 1048836;
    private static final String E_NOT_SUPPORTED = "Method is not supported.";
    private static final Logger LOGGER = Logger.getLogger(AXmlResourceParser.class.getName());
    private ResAttrDecoder mAttrDecoder;
    private AndrolibException mFirstError;
    private int[] m_attributes;
    private int m_classAttribute;
    private boolean m_decreaseDepth;
    private int m_event;
    private int m_idAttribute;
    private int m_lineNumber;
    private int m_name;
    private int m_namespaceUri;
    private NamespaceStack m_namespaces;
    private boolean m_operational;
    private ExtDataInput m_reader;
    private int[] m_resourceIDs;
    private StringBlock m_strings;
    private int m_styleAttribute;

    final class NamespaceStack {
        private int m_count;
        private int[] m_data = new int[32];
        private int m_dataLength;
        private int m_depth;

        public final void reset() {
            this.m_dataLength = 0;
            this.m_count = 0;
            this.m_depth = 0;
        }

        public final int getTotalCount() {
            return this.m_count;
        }

        public final int getCurrentCount() {
            if (this.m_dataLength == 0) {
                return 0;
            }
            return this.m_data[this.m_dataLength - 1];
        }

        public final int getAccumulatedCount(int i) {
            int i2 = 0;
            if (this.m_dataLength != 0 && i >= 0) {
                if (i > this.m_depth) {
                    i = this.m_depth;
                }
                int i3 = 0;
                while (i != 0) {
                    int i4 = this.m_data[i3];
                    i--;
                    i3 = (i4 * 2) + 2 + i3;
                    i2 += i4;
                }
            }
            return i2;
        }

        public final void push(int i, int i2) {
            if (this.m_depth == 0) {
                increaseDepth();
            }
            ensureDataCapacity(2);
            int i3 = this.m_dataLength - 1;
            int i4 = this.m_data[i3];
            this.m_data[(i3 - 1) - (i4 * 2)] = i4 + 1;
            this.m_data[i3] = i;
            this.m_data[i3 + 1] = i2;
            this.m_data[i3 + 2] = i4 + 1;
            this.m_dataLength += 2;
            this.m_count++;
        }

        public final boolean pop(int i, int i2) {
            if (this.m_dataLength == 0) {
                return false;
            }
            int i3 = this.m_dataLength - 1;
            int i4 = this.m_data[i3];
            int i5 = i3 - 2;
            int i6 = 0;
            while (i6 != i4) {
                if (this.m_data[i5] == i && this.m_data[i5 + 1] == i2) {
                    int i7 = i4 - 1;
                    if (i6 == 0) {
                        this.m_data[i5] = i7;
                        this.m_data[i5 - ((i7 * 2) + 1)] = i7;
                    } else {
                        this.m_data[i3] = i7;
                        this.m_data[i3 - ((i7 * 2) + 3)] = i7;
                        System.arraycopy(this.m_data, i5 + 2, this.m_data, i5, this.m_dataLength - i5);
                    }
                    this.m_dataLength -= 2;
                    this.m_count--;
                    return true;
                }
                i6++;
                i5 -= 2;
            }
            return false;
        }

        public final boolean pop() {
            if (this.m_dataLength == 0) {
                return false;
            }
            int i = this.m_dataLength - 1;
            int i2 = this.m_data[i];
            if (i2 == 0) {
                return false;
            }
            int i3 = i2 - 1;
            int i4 = i - 2;
            this.m_data[i4] = i3;
            this.m_data[i4 - ((i3 * 2) + 1)] = i3;
            this.m_dataLength -= 2;
            this.m_count--;
            return true;
        }

        public final int getPrefix(int i) {
            return get(i, true);
        }

        public final int getUri(int i) {
            return get(i, false);
        }

        public final int findPrefix(int i) {
            return find(i, false);
        }

        public final int findUri(int i) {
            return find(i, true);
        }

        public final int getDepth() {
            return this.m_depth;
        }

        public final void increaseDepth() {
            ensureDataCapacity(2);
            int i = this.m_dataLength;
            this.m_data[i] = 0;
            this.m_data[i + 1] = 0;
            this.m_dataLength += 2;
            this.m_depth++;
        }

        public final void decreaseDepth() {
            if (this.m_dataLength != 0) {
                int i = this.m_dataLength - 1;
                int i2 = this.m_data[i];
                if ((i - 1) - (i2 * 2) != 0) {
                    this.m_dataLength -= (i2 * 2) + 2;
                    this.m_count -= i2;
                    this.m_depth--;
                }
            }
        }

        private void ensureDataCapacity(int i) {
            int length = this.m_data.length - this.m_dataLength;
            if (length <= i) {
                int[] iArr = new int[((length + this.m_data.length) * 2)];
                System.arraycopy(this.m_data, 0, iArr, 0, this.m_dataLength);
                this.m_data = iArr;
            }
        }

        private final int find(int i, boolean z) {
            if (this.m_dataLength == 0) {
                return -1;
            }
            int i2 = this.m_dataLength - 1;
            for (int i3 = this.m_depth; i3 != 0; i3--) {
                i2 -= 2;
                for (int i4 = this.m_data[i2]; i4 != 0; i4--) {
                    if (z) {
                        if (this.m_data[i2] == i) {
                            return this.m_data[i2 + 1];
                        }
                    } else if (this.m_data[i2 + 1] == i) {
                        return this.m_data[i2];
                    }
                    i2 -= 2;
                }
            }
            return -1;
        }

        private final int get(int i, boolean z) {
            if (this.m_dataLength == 0 || i < 0) {
                return -1;
            }
            int i2 = 0;
            int i3 = this.m_depth;
            while (i3 != 0) {
                int i4 = this.m_data[i2];
                if (i >= i4) {
                    i -= i4;
                    i2 += (i4 * 2) + 2;
                    i3--;
                } else {
                    int i5 = (i * 2) + 1 + i2;
                    if (!z) {
                        i5++;
                    }
                    return this.m_data[i5];
                }
            }
            return -1;
        }
    }

    public AXmlResourceParser() {
        this.mAttrDecoder = new ResAttrDecoder();
        this.m_operational = false;
        this.m_namespaces = new NamespaceStack();
        resetEventInfo();
    }

    public AXmlResourceParser(InputStream inputStream) {
        this();
        open(inputStream);
    }

    public AndrolibException getFirstError() {
        return this.mFirstError;
    }

    public ResAttrDecoder getAttrDecoder() {
        return this.mAttrDecoder;
    }

    public void setAttrDecoder(ResAttrDecoder resAttrDecoder) {
        this.mAttrDecoder = resAttrDecoder;
    }

    public void open(InputStream inputStream) {
        close();
        if (inputStream != null) {
            this.m_reader = new ExtDataInput((DataInput) new LEDataInputStream(inputStream));
        }
    }

    public void close() {
        if (this.m_operational) {
            this.m_operational = false;
            this.m_reader = null;
            this.m_strings = null;
            this.m_resourceIDs = null;
            this.m_namespaces.reset();
            resetEventInfo();
        }
    }

    public int next() {
        if (this.m_reader == null) {
            throw new XmlPullParserException("Parser is not opened.", this, null);
        }
        try {
            doNext();
            return this.m_event;
        } catch (IOException e) {
            close();
            throw e;
        }
    }

    public int nextToken() {
        return next();
    }

    public int nextTag() {
        int next = next();
        if (next == 4 && isWhitespace()) {
            next = next();
        }
        if (next == 2 || next == 3) {
            return next;
        }
        throw new XmlPullParserException("Expected start or end tag.", this, null);
    }

    public String nextText() {
        if (getEventType() != 2) {
            throw new XmlPullParserException("Parser must be on START_TAG to read next text.", this, null);
        }
        int next = next();
        if (next == 4) {
            String text = getText();
            if (next() == 3) {
                return text;
            }
            throw new XmlPullParserException("Event TEXT must be immediately followed by END_TAG.", this, null);
        } else if (next == 3) {
            return "";
        } else {
            throw new XmlPullParserException("Parser must be on START_TAG or TEXT to read text.", this, null);
        }
    }

    public void require(int i, String str, String str2) {
        if (i != getEventType() || ((str != null && !str.equals(getNamespace())) || (str2 != null && !str2.equals(getName())))) {
            throw new XmlPullParserException(new StringBuilder(String.valueOf(TYPES[i])).append(" is expected.").toString(), this, null);
        }
    }

    public int getDepth() {
        return this.m_namespaces.getDepth() - 1;
    }

    public int getEventType() {
        return this.m_event;
    }

    public int getLineNumber() {
        return this.m_lineNumber;
    }

    public String getName() {
        if (this.m_name == -1 || (this.m_event != 2 && this.m_event != 3)) {
            return null;
        }
        return this.m_strings.getString(this.m_name);
    }

    public String getText() {
        if (this.m_name == -1 || this.m_event != 4) {
            return null;
        }
        return this.m_strings.getString(this.m_name);
    }

    public char[] getTextCharacters(int[] iArr) {
        String text = getText();
        if (text == null) {
            return null;
        }
        iArr[0] = 0;
        iArr[1] = text.length();
        char[] cArr = new char[text.length()];
        text.getChars(0, text.length(), cArr, 0);
        return cArr;
    }

    public String getNamespace() {
        return this.m_strings.getString(this.m_namespaceUri);
    }

    public String getPrefix() {
        return this.m_strings.getString(this.m_namespaces.findPrefix(this.m_namespaceUri));
    }

    public String getPositionDescription() {
        return "XML line #" + getLineNumber();
    }

    public int getNamespaceCount(int i) {
        return this.m_namespaces.getAccumulatedCount(i);
    }

    public String getNamespacePrefix(int i) {
        return this.m_strings.getString(this.m_namespaces.getPrefix(i));
    }

    public String getNamespaceUri(int i) {
        return this.m_strings.getString(this.m_namespaces.getUri(i));
    }

    public String getClassAttribute() {
        if (this.m_classAttribute == -1) {
            return null;
        }
        return this.m_strings.getString(this.m_attributes[getAttributeOffset(this.m_classAttribute) + 2]);
    }

    public String getIdAttribute() {
        if (this.m_idAttribute == -1) {
            return null;
        }
        return this.m_strings.getString(this.m_attributes[getAttributeOffset(this.m_idAttribute) + 2]);
    }

    public int getIdAttributeResourceValue(int i) {
        if (this.m_idAttribute == -1) {
            return i;
        }
        int attributeOffset = getAttributeOffset(this.m_idAttribute);
        return this.m_attributes[attributeOffset + 3] == 1 ? this.m_attributes[attributeOffset + 4] : i;
    }

    public int getStyleAttribute() {
        if (this.m_styleAttribute == -1) {
            return 0;
        }
        return this.m_attributes[getAttributeOffset(this.m_styleAttribute) + 4];
    }

    public int getAttributeCount() {
        if (this.m_event != 2) {
            return -1;
        }
        return this.m_attributes.length / 5;
    }

    public String getAttributeNamespace(int i) {
        int i2 = this.m_attributes[getAttributeOffset(i) + 0];
        if (i2 == -1) {
            return "";
        }
        return this.m_strings.getString(i2);
    }

    public String getAttributePrefix(int i) {
        int findPrefix = this.m_namespaces.findPrefix(this.m_attributes[getAttributeOffset(i) + 0]);
        if (findPrefix == -1) {
            return "";
        }
        return this.m_strings.getString(findPrefix);
    }

    public String getAttributeName(int i) {
        int i2 = this.m_attributes[getAttributeOffset(i) + 1];
        if (i2 == -1) {
            return "";
        }
        return this.m_strings.getString(i2);
    }

    public int getAttributeNameResource(int i) {
        int i2 = this.m_attributes[getAttributeOffset(i) + 1];
        if (this.m_resourceIDs == null || i2 < 0 || i2 >= this.m_resourceIDs.length) {
            return 0;
        }
        return this.m_resourceIDs[i2];
    }

    public int getAttributeValueType(int i) {
        return this.m_attributes[getAttributeOffset(i) + 3];
    }

    public int getAttributeValueData(int i) {
        return this.m_attributes[getAttributeOffset(i) + 4];
    }

    public String getAttributeValue(int i) {
        int attributeOffset = getAttributeOffset(i);
        int i2 = this.m_attributes[attributeOffset + 3];
        int i3 = this.m_attributes[attributeOffset + 4];
        int i4 = this.m_attributes[attributeOffset + 2];
        if (this.mAttrDecoder != null) {
            try {
                return this.mAttrDecoder.decode(i2, i3, i4 == -1 ? null : ResXmlEncoders.escapeXmlChars(this.m_strings.getString(i4)), getAttributeNameResource(i));
            } catch (AndrolibException e) {
                setFirstError(e);
                LOGGER.log(Level.WARNING, String.format("Could not decode attr value, using undecoded value instead: ns=%s, name=%s, value=0x%08x", new Object[]{getAttributePrefix(i), getAttributeName(i), Integer.valueOf(i3)}), e);
            }
        }
        return TypedValue.coerceToString(i2, i3);
    }

    public boolean getAttributeBooleanValue(int i, boolean z) {
        return getAttributeIntValue(i, z ? 1 : 0) != 0;
    }

    public float getAttributeFloatValue(int i, float f) {
        int attributeOffset = getAttributeOffset(i);
        if (this.m_attributes[attributeOffset + 3] == 4) {
            return Float.intBitsToFloat(this.m_attributes[attributeOffset + 4]);
        }
        return f;
    }

    public int getAttributeIntValue(int i, int i2) {
        int attributeOffset = getAttributeOffset(i);
        int i3 = this.m_attributes[attributeOffset + 3];
        if (i3 < 16 || i3 > 31) {
            return i2;
        }
        return this.m_attributes[attributeOffset + 4];
    }

    public int getAttributeUnsignedIntValue(int i, int i2) {
        return getAttributeIntValue(i, i2);
    }

    public int getAttributeResourceValue(int i, int i2) {
        int attributeOffset = getAttributeOffset(i);
        if (this.m_attributes[attributeOffset + 3] == 1) {
            return this.m_attributes[attributeOffset + 4];
        }
        return i2;
    }

    public String getAttributeValue(String str, String str2) {
        int findAttribute = findAttribute(str, str2);
        if (findAttribute == -1) {
            return null;
        }
        return getAttributeValue(findAttribute);
    }

    public boolean getAttributeBooleanValue(String str, String str2, boolean z) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? z : getAttributeBooleanValue(findAttribute, z);
    }

    public float getAttributeFloatValue(String str, String str2, float f) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? f : getAttributeFloatValue(findAttribute, f);
    }

    public int getAttributeIntValue(String str, String str2, int i) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? i : getAttributeIntValue(findAttribute, i);
    }

    public int getAttributeUnsignedIntValue(String str, String str2, int i) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? i : getAttributeUnsignedIntValue(findAttribute, i);
    }

    public int getAttributeResourceValue(String str, String str2, int i) {
        int findAttribute = findAttribute(str, str2);
        return findAttribute == -1 ? i : getAttributeResourceValue(findAttribute, i);
    }

    public int getAttributeListValue(int i, String[] strArr, int i2) {
        return 0;
    }

    public int getAttributeListValue(String str, String str2, String[] strArr, int i) {
        return 0;
    }

    public String getAttributeType(int i) {
        return "CDATA";
    }

    public boolean isAttributeDefault(int i) {
        return false;
    }

    public void setInput(InputStream inputStream, String str) {
        open(inputStream);
    }

    public void setInput(Reader reader) {
        throw new XmlPullParserException(E_NOT_SUPPORTED);
    }

    public String getInputEncoding() {
        return null;
    }

    public int getColumnNumber() {
        return -1;
    }

    public boolean isEmptyElementTag() {
        return false;
    }

    public boolean isWhitespace() {
        return false;
    }

    public void defineEntityReplacementText(String str, String str2) {
        throw new XmlPullParserException(E_NOT_SUPPORTED);
    }

    public String getNamespace(String str) {
        throw new RuntimeException(E_NOT_SUPPORTED);
    }

    public Object getProperty(String str) {
        return null;
    }

    public void setProperty(String str, Object obj) {
        throw new XmlPullParserException(E_NOT_SUPPORTED);
    }

    public boolean getFeature(String str) {
        return false;
    }

    public void setFeature(String str, boolean z) {
        throw new XmlPullParserException(E_NOT_SUPPORTED);
    }

    /* access modifiers changed from: 0000 */
    public final StringBlock getStrings() {
        return this.m_strings;
    }

    private final int getAttributeOffset(int i) {
        if (this.m_event != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.m_attributes.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    private final int findAttribute(String str, String str2) {
        int i;
        if (this.m_strings == null || str2 == null) {
            return -1;
        }
        int find = this.m_strings.find(str2);
        if (find == -1) {
            return -1;
        }
        if (str != null) {
            i = this.m_strings.find(str);
        } else {
            i = -1;
        }
        for (int i2 = 0; i2 != this.m_attributes.length; i2++) {
            if (find == this.m_attributes[i2 + 1] && (i == -1 || i == this.m_attributes[i2 + 0])) {
                return i2 / 5;
            }
        }
        return -1;
    }

    private final void resetEventInfo() {
        this.m_event = -1;
        this.m_lineNumber = -1;
        this.m_name = -1;
        this.m_namespaceUri = -1;
        this.m_attributes = null;
        this.m_idAttribute = -1;
        this.m_classAttribute = -1;
        this.m_styleAttribute = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b9, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r1 + ").");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void doNext() {
        /*
            r9 = this;
            r8 = 0
            r2 = 1048834(0x100102, float:1.46973E-39)
            r7 = 1048832(0x100100, float:1.469727E-39)
            r0 = 3
            r6 = 1
            brut.androlib.res.decoder.StringBlock r1 = r9.m_strings
            if (r1 != 0) goto L_0x0029
            brut.util.ExtDataInput r1 = r9.m_reader
            r3 = 524291(0x80003, float:7.34688E-40)
            r1.skipCheckInt(r3)
            brut.util.ExtDataInput r1 = r9.m_reader
            r1.skipInt()
            brut.util.ExtDataInput r1 = r9.m_reader
            brut.androlib.res.decoder.StringBlock r1 = brut.androlib.res.decoder.StringBlock.read(r1)
            r9.m_strings = r1
            brut.androlib.res.decoder.AXmlResourceParser$NamespaceStack r1 = r9.m_namespaces
            r1.increaseDepth()
            r9.m_operational = r6
        L_0x0029:
            int r1 = r9.m_event
            if (r1 != r6) goto L_0x002e
        L_0x002d:
            return
        L_0x002e:
            int r3 = r9.m_event
            r9.resetEventInfo()
        L_0x0033:
            boolean r1 = r9.m_decreaseDepth
            if (r1 == 0) goto L_0x003e
            r9.m_decreaseDepth = r8
            brut.androlib.res.decoder.AXmlResourceParser$NamespaceStack r1 = r9.m_namespaces
            r1.decreaseDepth()
        L_0x003e:
            if (r3 != r0) goto L_0x0053
            brut.androlib.res.decoder.AXmlResourceParser$NamespaceStack r1 = r9.m_namespaces
            int r1 = r1.getDepth()
            if (r1 != r6) goto L_0x0053
            brut.androlib.res.decoder.AXmlResourceParser$NamespaceStack r1 = r9.m_namespaces
            int r1 = r1.getCurrentCount()
            if (r1 != 0) goto L_0x0053
            r9.m_event = r6
            goto L_0x002d
        L_0x0053:
            if (r3 != 0) goto L_0x0084
            r1 = r2
        L_0x0056:
            r4 = 524672(0x80180, float:7.35222E-40)
            if (r1 != r4) goto L_0x0098
            brut.util.ExtDataInput r1 = r9.m_reader
            int r1 = r1.readInt()
            r4 = 8
            if (r1 < r4) goto L_0x0069
            int r4 = r1 % 4
            if (r4 == 0) goto L_0x008b
        L_0x0069:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid resource ids size ("
            r2.<init>(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r2 = ")."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0084:
            brut.util.ExtDataInput r1 = r9.m_reader
            int r1 = r1.readInt()
            goto L_0x0056
        L_0x008b:
            brut.util.ExtDataInput r4 = r9.m_reader
            int r1 = r1 / 4
            int r1 = r1 + -2
            int[] r1 = r4.readIntArray(r1)
            r9.m_resourceIDs = r1
            goto L_0x0033
        L_0x0098:
            if (r1 < r7) goto L_0x009f
            r4 = 1048836(0x100104, float:1.469732E-39)
            if (r1 <= r4) goto L_0x00ba
        L_0x009f:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid chunk type ("
            r2.<init>(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r2 = ")."
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00ba:
            if (r1 != r2) goto L_0x00c3
            r4 = -1
            if (r3 != r4) goto L_0x00c3
            r9.m_event = r8
            goto L_0x002d
        L_0x00c3:
            brut.util.ExtDataInput r4 = r9.m_reader
            r4.skipInt()
            brut.util.ExtDataInput r4 = r9.m_reader
            int r4 = r4.readInt()
            brut.util.ExtDataInput r5 = r9.m_reader
            r5.skipInt()
            if (r1 == r7) goto L_0x00da
            r5 = 1048833(0x100101, float:1.469728E-39)
            if (r1 != r5) goto L_0x0100
        L_0x00da:
            if (r1 != r7) goto L_0x00ef
            brut.util.ExtDataInput r1 = r9.m_reader
            int r1 = r1.readInt()
            brut.util.ExtDataInput r4 = r9.m_reader
            int r4 = r4.readInt()
            brut.androlib.res.decoder.AXmlResourceParser$NamespaceStack r5 = r9.m_namespaces
            r5.push(r1, r4)
            goto L_0x0033
        L_0x00ef:
            brut.util.ExtDataInput r1 = r9.m_reader
            r1.skipInt()
            brut.util.ExtDataInput r1 = r9.m_reader
            r1.skipInt()
            brut.androlib.res.decoder.AXmlResourceParser$NamespaceStack r1 = r9.m_namespaces
            r1.pop()
            goto L_0x0033
        L_0x0100:
            r9.m_lineNumber = r4
            if (r1 != r2) goto L_0x0169
            brut.util.ExtDataInput r1 = r9.m_reader
            int r1 = r1.readInt()
            r9.m_namespaceUri = r1
            brut.util.ExtDataInput r1 = r9.m_reader
            int r1 = r1.readInt()
            r9.m_name = r1
            brut.util.ExtDataInput r1 = r9.m_reader
            r1.skipInt()
            brut.util.ExtDataInput r1 = r9.m_reader
            int r1 = r1.readInt()
            int r2 = r1 >>> 16
            int r2 = r2 + -1
            r9.m_idAttribute = r2
            r2 = 65535(0xffff, float:9.1834E-41)
            r1 = r1 & r2
            brut.util.ExtDataInput r2 = r9.m_reader
            int r2 = r2.readInt()
            r9.m_classAttribute = r2
            int r2 = r9.m_classAttribute
            int r2 = r2 >>> 16
            int r2 = r2 + -1
            r9.m_styleAttribute = r2
            int r2 = r9.m_classAttribute
            r3 = 65535(0xffff, float:9.1834E-41)
            r2 = r2 & r3
            int r2 = r2 + -1
            r9.m_classAttribute = r2
            brut.util.ExtDataInput r2 = r9.m_reader
            int r1 = r1 * 5
            int[] r1 = r2.readIntArray(r1)
            r9.m_attributes = r1
        L_0x014d:
            int[] r1 = r9.m_attributes
            int r1 = r1.length
            if (r0 < r1) goto L_0x015c
            brut.androlib.res.decoder.AXmlResourceParser$NamespaceStack r0 = r9.m_namespaces
            r0.increaseDepth()
            r0 = 2
            r9.m_event = r0
            goto L_0x002d
        L_0x015c:
            int[] r1 = r9.m_attributes
            int[] r2 = r9.m_attributes
            r2 = r2[r0]
            int r2 = r2 >>> 24
            r1[r0] = r2
            int r0 = r0 + 5
            goto L_0x014d
        L_0x0169:
            r4 = 1048835(0x100103, float:1.469731E-39)
            if (r1 != r4) goto L_0x0184
            brut.util.ExtDataInput r1 = r9.m_reader
            int r1 = r1.readInt()
            r9.m_namespaceUri = r1
            brut.util.ExtDataInput r1 = r9.m_reader
            int r1 = r1.readInt()
            r9.m_name = r1
            r9.m_event = r0
            r9.m_decreaseDepth = r6
            goto L_0x002d
        L_0x0184:
            r4 = 1048836(0x100104, float:1.469732E-39)
            if (r1 != r4) goto L_0x0033
            brut.util.ExtDataInput r0 = r9.m_reader
            int r0 = r0.readInt()
            r9.m_name = r0
            brut.util.ExtDataInput r0 = r9.m_reader
            r0.skipInt()
            brut.util.ExtDataInput r0 = r9.m_reader
            r0.skipInt()
            r0 = 4
            r9.m_event = r0
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: brut.androlib.res.decoder.AXmlResourceParser.doNext():void");
    }

    private void setFirstError(AndrolibException androlibException) {
        if (this.mFirstError == null) {
            this.mFirstError = androlibException;
        }
    }
}
