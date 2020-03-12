package p012ch.qos.logback.core.util;

/* renamed from: ch.qos.logback.core.util.CharSequenceToRegexMapper */
class CharSequenceToRegexMapper {
    CharSequenceToRegexMapper() {
    }

    /* access modifiers changed from: 0000 */
    public String toRegex(CharSequenceState charSequenceState) {
        int i = charSequenceState.occurrences;
        char c = charSequenceState.f1672c;
        switch (charSequenceState.f1672c) {
            case '\'':
                if (i == 1) {
                    return "";
                }
                throw new IllegalStateException("Too many single quotes");
            case '.':
                return "\\.";
            case 'D':
            case 'F':
            case 'H':
            case 'K':
            case 'S':
            case 'W':
            case 'd':
            case 'h':
            case 'k':
            case 'm':
            case 's':
            case 'w':
            case 'y':
                return number(i);
            case 'E':
                return ".{2,12}";
            case 'G':
            case 'z':
                return ".*";
            case 'M':
                if (i >= 3) {
                    return ".{3,12}";
                }
                return number(i);
            case 'Z':
                return "(\\+|-)\\d{4}";
            case '\\':
                throw new IllegalStateException("Forward slashes are not allowed");
            case 'a':
                return ".{2}";
            default:
                if (i == 1) {
                    return String.valueOf(c);
                }
                return new StringBuilder(String.valueOf(c)).append("{").append(i).append("}").toString();
        }
    }

    private String number(int i) {
        return "\\d{" + i + "}";
    }
}
