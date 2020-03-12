package p012ch.qos.logback.core.helpers;

/* renamed from: ch.qos.logback.core.helpers.Transform */
public class Transform {
    private static final String CDATA_EMBEDED_END = "]]>]]&gt;<![CDATA[";
    private static final String CDATA_END = "]]>";
    private static final int CDATA_END_LEN = 3;
    private static final String CDATA_PSEUDO_END = "]]&gt;";
    private static final String CDATA_START = "<![CDATA[";

    public static String escapeTags(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return (str.indexOf("<") == -1 && str.indexOf(">") == -1) ? str : escapeTags(new StringBuffer(str));
    }

    public static String escapeTags(StringBuffer stringBuffer) {
        for (int i = 0; i < stringBuffer.length(); i++) {
            char charAt = stringBuffer.charAt(i);
            if (charAt == '<') {
                stringBuffer.replace(i, i + 1, "&lt;");
            } else if (charAt == '>') {
                stringBuffer.replace(i, i + 1, "&gt;");
            }
        }
        return stringBuffer.toString();
    }

    public static void appendEscapingCDATA(StringBuilder sb, String str) {
        if (str != null) {
            int indexOf = str.indexOf(CDATA_END);
            if (indexOf < 0) {
                sb.append(str);
                return;
            }
            int i = 0;
            while (indexOf >= 0) {
                sb.append(str.substring(i, indexOf));
                sb.append(CDATA_EMBEDED_END);
                i = CDATA_END_LEN + indexOf;
                if (i < str.length()) {
                    indexOf = str.indexOf(CDATA_END, i);
                } else {
                    return;
                }
            }
            sb.append(str.substring(i));
        }
    }
}
