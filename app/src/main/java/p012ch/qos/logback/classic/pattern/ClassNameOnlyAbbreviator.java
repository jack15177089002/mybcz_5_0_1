package p012ch.qos.logback.classic.pattern;

/* renamed from: ch.qos.logback.classic.pattern.ClassNameOnlyAbbreviator */
public class ClassNameOnlyAbbreviator implements Abbreviator {
    public String abbreviate(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            return str.substring(lastIndexOf + 1, str.length());
        }
        return str;
    }
}
