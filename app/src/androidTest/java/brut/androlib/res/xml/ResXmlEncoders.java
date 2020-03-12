package brut.androlib.res.xml;

import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;
import java.util.List;
import p012ch.qos.logback.core.CoreConstants;

public final class ResXmlEncoders {
    public static String escapeXmlChars(String str) {
        return str.replace("&", "&amp;").replace("<", "&lt;");
    }

    public static String encodeAsResXmlAttr(String str) {
        if (str.isEmpty()) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder(str.length() + 10);
        switch (charArray[0]) {
            case '#':
            case '?':
            case '@':
                sb.append(CoreConstants.ESCAPE_CHAR);
                break;
        }
        for (char c : charArray) {
            switch (c) {
                case 10:
                    sb.append("\\n");
                    continue;
                case '\"':
                    sb.append("&quot;");
                    continue;
                case '\\':
                    sb.append(CoreConstants.ESCAPE_CHAR);
                    break;
                default:
                    if (!isPrintableChar(c)) {
                        sb.append(String.format("\\u%04x", new Object[]{Integer.valueOf(c)}));
                        continue;
                    }
                    break;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static String encodeAsXmlValue(String str) {
        boolean z;
        boolean z2;
        if (str.isEmpty()) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder(str.length() + 10);
        switch (charArray[0]) {
            case '#':
            case '?':
            case '@':
                sb.append(CoreConstants.ESCAPE_CHAR);
                break;
        }
        int length = charArray.length;
        int i = 0;
        boolean z3 = true;
        boolean z4 = false;
        int i2 = 0;
        boolean z5 = false;
        while (i < length) {
            char c = charArray[i];
            if (!z5) {
                if (c != ' ') {
                    switch (c) {
                        case 10:
                        case '\'':
                            z2 = false;
                            z = true;
                            break;
                        case '\"':
                            sb.append(CoreConstants.ESCAPE_CHAR);
                            z = z4;
                            z2 = false;
                            break;
                        case '<':
                            if (!z4) {
                                z = z4;
                                z5 = true;
                                z2 = false;
                                break;
                            } else {
                                sb.insert(i2, CoreConstants.DOUBLE_QUOTE_CHAR).append(CoreConstants.DOUBLE_QUOTE_CHAR);
                                z = z4;
                                z5 = true;
                                z2 = false;
                                break;
                            }
                        case '\\':
                            sb.append(CoreConstants.ESCAPE_CHAR);
                            z = z4;
                            z2 = false;
                            break;
                        default:
                            if (isPrintableChar(c)) {
                                z = z4;
                                z2 = false;
                                break;
                            } else {
                                sb.append(String.format("\\u%04x", new Object[]{Integer.valueOf(c)}));
                                z = z4;
                                z2 = false;
                                continue;
                            }
                    }
                } else {
                    if (z3) {
                        z4 = true;
                    }
                    z = z4;
                    z2 = true;
                }
            } else if (c == '>') {
                i2 = sb.length() + 1;
                z5 = false;
                z2 = z3;
                z = false;
            } else {
                boolean z6 = z3;
                z = z4;
                z2 = z6;
            }
            sb.append(c);
            i++;
            boolean z7 = z2;
            z4 = z;
            z3 = z7;
        }
        if (z4 || z3) {
            sb.insert(i2, CoreConstants.DOUBLE_QUOTE_CHAR).append(CoreConstants.DOUBLE_QUOTE_CHAR);
        }
        return sb.toString();
    }

    public static boolean hasMultipleNonPositionalSubstitutions(String str) {
        return findNonPositionalSubstitutions(str, 2).size() > 1;
    }

    public static String enumerateNonPositionalSubstitutions(String str) {
        List<Integer> findNonPositionalSubstitutions = findNonPositionalSubstitutions(str, -1);
        if (findNonPositionalSubstitutions.size() < 2) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        for (Integer intValue : findNonPositionalSubstitutions) {
            Integer valueOf = Integer.valueOf(intValue.intValue() + 1);
            int i3 = i + 1;
            sb.append(str.substring(i2, valueOf.intValue())).append(i3).append(CoreConstants.DOLLAR);
            i2 = valueOf.intValue();
            i = i3;
        }
        sb.append(str.substring(i2));
        return sb.toString();
    }

    private static List<Integer> findNonPositionalSubstitutions(String str, int i) {
        char charAt;
        int i2 = 0;
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int indexOf = str.indexOf(37, i3);
            int i4 = indexOf + 1;
            if (i4 == 0 || i4 == length) {
                break;
            }
            i3 = i4 + 1;
            char charAt2 = str.charAt(i4);
            if (charAt2 != '%') {
                if (charAt2 >= '0' && charAt2 <= '9' && i3 < length) {
                    do {
                        int i5 = i3;
                        i3 = i5 + 1;
                        charAt = str.charAt(i5);
                        if (charAt < '0' || charAt > '9') {
                        }
                    } while (i3 < length);
                    if (charAt == '$') {
                        continue;
                    }
                }
                arrayList.add(Integer.valueOf(indexOf));
                if (i != -1) {
                    i2++;
                    if (i2 >= i) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return arrayList;
    }

    private static boolean isPrintableChar(char c) {
        UnicodeBlock of = UnicodeBlock.of(c);
        return (Character.isISOControl(c) || c == 65535 || of == null || of == UnicodeBlock.SPECIALS) ? false : true;
    }
}
