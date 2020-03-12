package p012ch.qos.logback.classic.android;

import java.util.HashMap;
import java.util.Map;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.LocatorImpl;
import org.xmlpull.v1.XmlPullParser;
import p012ch.qos.logback.core.joran.event.SaxEventRecorder;

/* renamed from: ch.qos.logback.classic.android.ASaxEventRecorder */
public class ASaxEventRecorder extends SaxEventRecorder {
    private Map<String, String> elemAttrs = null;
    private String elemNameToWatch = null;
    private StatePassFilter filter = new StatePassFilter(new String[0]);
    private int[] holderForStartAndLength = new int[2];

    /* renamed from: ch.qos.logback.classic.android.ASaxEventRecorder$StatePassFilter */
    class StatePassFilter {
        private int _depth = 0;
        private final String[] _states;

        public StatePassFilter(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this._states = strArr;
        }

        public boolean checkStart(String str) {
            if (this._depth == this._states.length) {
                return true;
            }
            if (str.equals(this._states[this._depth])) {
                this._depth++;
            }
            return false;
        }

        public boolean checkEnd(String str) {
            if (this._depth > 0 && str.equals(this._states[this._depth - 1])) {
                this._depth--;
                return false;
            } else if (this._depth == this._states.length) {
                return true;
            } else {
                return false;
            }
        }

        public int size() {
            return this._states.length;
        }

        public int depth() {
            return this._depth;
        }

        public void reset() {
            this._depth = 0;
        }

        public boolean passed() {
            return this._depth == this._states.length;
        }
    }

    public void setFilter(String... strArr) {
        this.filter = new StatePassFilter(strArr);
    }

    public void setAttributeWatch(String str) {
        this.elemNameToWatch = str;
    }

    public Map<String, String> getAttributeWatchValues() {
        return this.elemAttrs;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3.filter.reset();
        endDocument();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<p012ch.qos.logback.core.joran.event.SaxEvent> recordEvents(org.xml.sax.InputSource r4) {
        /*
            r3 = this;
            java.io.InputStream r0 = r4.getByteStream()
            if (r0 != 0) goto L_0x000e
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Input source must specify an input stream"
            r0.<init>(r1)
            throw r0
        L_0x000e:
            brut.androlib.res.decoder.AXmlResourceParser r1 = new brut.androlib.res.decoder.AXmlResourceParser     // Catch:{ Exception -> 0x002c }
            r1.<init>(r0)     // Catch:{ Exception -> 0x002c }
            r0 = 0
            r3.elemAttrs = r0     // Catch:{ Exception -> 0x002c }
        L_0x0016:
            int r0 = r1.next()     // Catch:{ Exception -> 0x002c }
            if (r0 >= 0) goto L_0x0021
        L_0x001c:
            java.util.List r0 = r3.getSaxEventList()     // Catch:{ Exception -> 0x002c }
            return r0
        L_0x0021:
            if (r0 != 0) goto L_0x003c
            ch.qos.logback.classic.android.ASaxEventRecorder$StatePassFilter r0 = r3.filter     // Catch:{ Exception -> 0x002c }
            r0.reset()     // Catch:{ Exception -> 0x002c }
            r3.startDocument(r1)     // Catch:{ Exception -> 0x002c }
            goto L_0x0016
        L_0x002c:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            r3.addError(r1, r0)
            ch.qos.logback.core.joran.spi.JoranException r1 = new ch.qos.logback.core.joran.spi.JoranException
            java.lang.String r2 = "Can't parse Android XML resource"
            r1.<init>(r2, r0)
            throw r1
        L_0x003c:
            r2 = 1
            if (r2 != r0) goto L_0x0048
            ch.qos.logback.classic.android.ASaxEventRecorder$StatePassFilter r0 = r3.filter     // Catch:{ Exception -> 0x002c }
            r0.reset()     // Catch:{ Exception -> 0x002c }
            r3.endDocument()     // Catch:{ Exception -> 0x002c }
            goto L_0x001c
        L_0x0048:
            r2 = 2
            if (r2 != r0) goto L_0x004f
            r3.startElement(r1)     // Catch:{ Exception -> 0x002c }
            goto L_0x0016
        L_0x004f:
            r2 = 3
            if (r2 != r0) goto L_0x0056
            r3.endElement(r1)     // Catch:{ Exception -> 0x002c }
            goto L_0x0016
        L_0x0056:
            r2 = 4
            if (r2 != r0) goto L_0x0016
            r3.characters(r1)     // Catch:{ Exception -> 0x002c }
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: p012ch.qos.logback.classic.android.ASaxEventRecorder.recordEvents(org.xml.sax.InputSource):java.util.List");
    }

    private void startDocument(XmlPullParser xmlPullParser) {
        super.startDocument();
        super.setDocumentLocator(new LocatorImpl());
    }

    private void characters(XmlPullParser xmlPullParser) {
        if (this.filter.passed()) {
            super.characters(xmlPullParser.getTextCharacters(this.holderForStartAndLength), this.holderForStartAndLength[0], this.holderForStartAndLength[1]);
        }
    }

    private void endElement(XmlPullParser xmlPullParser) {
        String name = xmlPullParser.getName();
        if (this.filter.checkEnd(name)) {
            endElement(xmlPullParser.getNamespace(), name, name);
        }
    }

    private void startElement(XmlPullParser xmlPullParser) {
        String name = xmlPullParser.getName();
        if (this.filter.checkStart(name)) {
            AttributesImpl attributesImpl = new AttributesImpl();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= xmlPullParser.getAttributeCount()) {
                    break;
                }
                attributesImpl.addAttribute(xmlPullParser.getAttributeNamespace(i2), xmlPullParser.getAttributeName(i2), xmlPullParser.getAttributeName(i2), xmlPullParser.getAttributeType(i2), xmlPullParser.getAttributeValue(i2));
                i = i2 + 1;
            }
            startElement(xmlPullParser.getNamespace(), name, name, attributesImpl);
        }
        checkForWatchedAttributes(xmlPullParser);
    }

    private void checkForWatchedAttributes(XmlPullParser xmlPullParser) {
        String str;
        if (this.elemNameToWatch != null && this.elemAttrs == null && xmlPullParser.getName().equals(this.elemNameToWatch)) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                String str2 = "";
                String attributeNamespace = xmlPullParser.getAttributeNamespace(i);
                if (attributeNamespace.length() > 0) {
                    int lastIndexOf = attributeNamespace.lastIndexOf("/");
                    if (lastIndexOf >= 0 && lastIndexOf + 1 < attributeNamespace.length()) {
                        attributeNamespace = attributeNamespace.substring(lastIndexOf + 1);
                    }
                    str = new StringBuilder(String.valueOf(attributeNamespace)).append(":").toString();
                } else {
                    str = str2;
                }
                hashMap.put(new StringBuilder(String.valueOf(str)).append(xmlPullParser.getAttributeName(i)).toString(), xmlPullParser.getAttributeValue(i));
            }
            this.elemAttrs = hashMap;
        }
    }
}
