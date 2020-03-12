package brut.androlib.res.decoder;

import brut.androlib.res.xml.ResXmlEncoders;
import brut.util.ExtDataInput;
import com.tencent.android.tpush.common.Constants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import p012ch.qos.logback.core.CoreConstants;

public class StringBlock {
    private static final int CHUNK_TYPE = 1835009;
    private static final Logger LOGGER = Logger.getLogger(StringBlock.class.getName());
    private static final CharsetDecoder UTF16LE_DECODER = Charset.forName("UTF-16LE").newDecoder();
    private static final CharsetDecoder UTF8_DECODER = Charset.forName("UTF-8").newDecoder();
    private static final int UTF8_FLAG = 256;
    private boolean m_isUTF8;
    private int[] m_stringOffsets;
    private byte[] m_strings;
    private int[] m_styleOffsets;
    private int[] m_styles;

    public static StringBlock read(ExtDataInput extDataInput) {
        int i;
        extDataInput.skipCheckInt(CHUNK_TYPE);
        int readInt = extDataInput.readInt();
        int readInt2 = extDataInput.readInt();
        int readInt3 = extDataInput.readInt();
        int readInt4 = extDataInput.readInt();
        int readInt5 = extDataInput.readInt();
        int readInt6 = extDataInput.readInt();
        StringBlock stringBlock = new StringBlock();
        stringBlock.m_isUTF8 = (readInt4 & 256) != 0;
        stringBlock.m_stringOffsets = extDataInput.readIntArray(readInt2);
        if (readInt3 != 0) {
            stringBlock.m_styleOffsets = extDataInput.readIntArray(readInt3);
        }
        if (readInt6 == 0) {
            i = readInt;
        } else {
            i = readInt6;
        }
        int i2 = i - readInt5;
        if (i2 % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i2 + ").");
        }
        stringBlock.m_strings = new byte[i2];
        extDataInput.readFully(stringBlock.m_strings);
        if (readInt6 != 0) {
            int i3 = readInt - readInt6;
            if (i3 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i3 + ").");
            }
            stringBlock.m_styles = extDataInput.readIntArray(i3 / 4);
        }
        return stringBlock;
    }

    public int getCount() {
        if (this.m_stringOffsets != null) {
            return this.m_stringOffsets.length;
        }
        return 0;
    }

    public String getString(int i) {
        int i2;
        int i3;
        if (i < 0 || this.m_stringOffsets == null || i >= this.m_stringOffsets.length) {
            return null;
        }
        int i4 = this.m_stringOffsets[i];
        if (!this.m_isUTF8) {
            i3 = getShort(this.m_strings, i4) * 2;
            i2 = i4 + 2;
        } else {
            int i5 = getVarint(this.m_strings, i4)[1] + i4;
            int[] varint = getVarint(this.m_strings, i5);
            i2 = varint[1] + i5;
            i3 = varint[0];
        }
        return decodeString(i2, i3);
    }

    public CharSequence get(int i) {
        return getString(i);
    }

    public String getHTML(int i) {
        String string = getString(i);
        if (string == null) {
            return string;
        }
        int[] style = getStyle(i);
        if (style == null) {
            return ResXmlEncoders.escapeXmlChars(string);
        }
        StringBuilder sb = new StringBuilder(string.length() + 32);
        int[] iArr = new int[(style.length / 3)];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = -1;
            for (int i5 = 0; i5 != style.length; i5 += 3) {
                if (style[i5 + 1] != -1 && (i4 == -1 || style[i4 + 1] > style[i5 + 1])) {
                    i4 = i5;
                }
            }
            int length = i4 != -1 ? style[i4 + 1] : string.length();
            int i6 = i2 - 1;
            int i7 = i3;
            int i8 = i6;
            while (i8 >= 0) {
                int i9 = iArr[i8];
                int i10 = style[i9 + 2];
                if (i10 >= length) {
                    break;
                }
                if (i7 <= i10) {
                    sb.append(ResXmlEncoders.escapeXmlChars(string.substring(i7, i10 + 1)));
                    i7 = i10 + 1;
                }
                outputStyleTag(getString(style[i9]), sb, true);
                i8--;
            }
            int i11 = i8 + 1;
            if (i7 < length) {
                sb.append(ResXmlEncoders.escapeXmlChars(string.substring(i7, length)));
                i3 = length;
            } else {
                i3 = i7;
            }
            if (i4 == -1) {
                return sb.toString();
            }
            outputStyleTag(getString(style[i4]), sb, false);
            style[i4 + 1] = -1;
            i2 = i11 + 1;
            iArr[i11] = i4;
        }
    }

    private void outputStyleTag(String str, StringBuilder sb, boolean z) {
        String substring;
        sb.append('<');
        if (z) {
            sb.append('/');
        }
        int indexOf = str.indexOf(59);
        if (indexOf == -1) {
            sb.append(str);
        } else {
            sb.append(str.substring(0, indexOf));
            if (!z) {
                boolean z2 = true;
                while (z2) {
                    int indexOf2 = str.indexOf(61, indexOf + 1);
                    sb.append(' ').append(str.substring(indexOf + 1, indexOf2)).append("=\"");
                    int indexOf3 = str.indexOf(59, indexOf2 + 1);
                    if (indexOf3 != -1) {
                        substring = str.substring(indexOf2 + 1, indexOf3);
                    } else {
                        substring = str.substring(indexOf2 + 1);
                        z2 = false;
                    }
                    sb.append(ResXmlEncoders.escapeXmlChars(substring)).append(CoreConstants.DOUBLE_QUOTE_CHAR);
                    indexOf = indexOf3;
                }
            }
        }
        sb.append('>');
    }

    public int find(String str) {
        if (str == null) {
            return -1;
        }
        for (int i = 0; i != this.m_stringOffsets.length; i++) {
            int i2 = this.m_stringOffsets[i];
            int i3 = getShort(this.m_strings, i2);
            if (i3 == str.length()) {
                int i4 = i2;
                int i5 = 0;
                while (i5 != i3) {
                    i4 += 2;
                    if (str.charAt(i5) != getShort(this.m_strings, i4)) {
                        break;
                    }
                    i5++;
                }
                if (i5 == i3) {
                    return i;
                }
            }
        }
        return -1;
    }

    private StringBlock() {
    }

    private int[] getStyle(int i) {
        int i2 = 0;
        if (this.m_styleOffsets == null || this.m_styles == null || i >= this.m_styleOffsets.length) {
            return null;
        }
        int i3 = this.m_styleOffsets[i] / 4;
        int i4 = i3;
        int i5 = 0;
        while (i4 < this.m_styles.length && this.m_styles[i4] != -1) {
            i5++;
            i4++;
        }
        if (i5 == 0 || i5 % 3 != 0) {
            return null;
        }
        int[] iArr = new int[i5];
        while (i3 < this.m_styles.length && this.m_styles[i3] != -1) {
            int i6 = i2 + 1;
            int i7 = i3 + 1;
            iArr[i2] = this.m_styles[i3];
            i2 = i6;
            i3 = i7;
        }
        return iArr;
    }

    private String decodeString(int i, int i2) {
        try {
            return (this.m_isUTF8 ? UTF8_DECODER : UTF16LE_DECODER).decode(ByteBuffer.wrap(this.m_strings, i, i2)).toString();
        } catch (CharacterCodingException e) {
            LOGGER.log(Level.WARNING, null, e);
            return null;
        }
    }

    private static final int getShort(byte[] bArr, int i) {
        return ((bArr[i + 1] & Constants.NETWORK_TYPE_UNCONNECTED) << 8) | (bArr[i] & Constants.NETWORK_TYPE_UNCONNECTED);
    }

    private static final int getShort(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        if ((i % 4) / 2 == 0) {
            return i2 & 65535;
        }
        return i2 >>> 16;
    }

    private static final int[] getVarint(byte[] bArr, int i) {
        byte b = bArr[i];
        boolean z = (b & 128) != 0;
        int i2 = b & Byte.MAX_VALUE;
        if (!z) {
            return new int[]{i2, 1};
        }
        return new int[]{(i2 << 8) | (bArr[i + 1] & Constants.NETWORK_TYPE_UNCONNECTED), 2};
    }
}
