package p012ch.qos.logback.classic.util;

/* renamed from: ch.qos.logback.classic.util.LoggerNameUtil */
public class LoggerNameUtil {
    public static int getFirstSeparatorIndexOf(String str) {
        return getSeparatorIndexOf(str, 0);
    }

    public static int getSeparatorIndexOf(String str, int i) {
        int indexOf = str.indexOf(46, i);
        int indexOf2 = str.indexOf(36, i);
        if (indexOf == -1 && indexOf2 == -1) {
            return -1;
        }
        if (indexOf == -1) {
            return indexOf2;
        }
        if (indexOf2 == -1) {
            return indexOf;
        }
        return indexOf < indexOf2 ? indexOf : indexOf2;
    }
}
