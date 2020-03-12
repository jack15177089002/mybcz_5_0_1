package p012ch.qos.logback.core.pattern.util;

/* renamed from: ch.qos.logback.core.pattern.util.RegularEscapeUtil */
public class RegularEscapeUtil implements IEscapeUtil {
    public void escape(String str, StringBuffer stringBuffer, char c, int i) {
        if (str.indexOf(c) >= 0) {
            stringBuffer.append(c);
            return;
        }
        switch (c) {
            case '\\':
                stringBuffer.append(c);
                return;
            case '_':
                return;
            case 'n':
                stringBuffer.append(10);
                return;
            case 'r':
                stringBuffer.append(13);
                return;
            case 't':
                stringBuffer.append(9);
                return;
            default:
                throw new IllegalArgumentException("Illegal char '" + c + " at column " + i + ". Only \\\\, \\_" + formatEscapeCharsForListing(str) + ", \\t, \\n, \\r combinations are allowed as escape characters.");
        }
    }

    /* access modifiers changed from: 0000 */
    public String formatEscapeCharsForListing(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(", \\").append(str.charAt(i));
        }
        return sb.toString();
    }

    public static String basicEscape(String str) {
        char c;
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                i = i2 + 1;
                c = str.charAt(i2);
                if (c == 'n') {
                    c = 10;
                } else if (c == 'r') {
                    c = 13;
                } else if (c == 't') {
                    c = 9;
                } else if (c == 'f') {
                    c = 12;
                }
            } else {
                int i3 = i2;
                c = charAt;
                i = i3;
            }
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }
}
