package p012ch.qos.logback.classic.spi;

import java.util.List;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: ch.qos.logback.classic.spi.CallerData */
public class CallerData {
    public static final String CALLER_DATA_NA = ("?#?:?" + CoreConstants.LINE_SEPARATOR);
    public static final StackTraceElement[] EMPTY_CALLER_DATA_ARRAY = new StackTraceElement[0];
    public static final int LINE_NA = -1;
    private static final String LOG4J_CATEGORY = "org.apache.log4j.Category";

    /* renamed from: NA */
    public static final String f1661NA = "?";
    private static final String SLF4J_BOUNDARY = "org.slf4j.Logger";

    public static StackTraceElement[] extract(Throwable th, String str, int i, List<String> list) {
        if (th == null) {
            return null;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        int i2 = -1;
        for (int i3 = 0; i3 < stackTrace.length; i3++) {
            if (!isInFrameworkSpace(stackTrace[i3].getClassName(), str, list)) {
                if (i2 != -1) {
                    break;
                }
            } else {
                i2 = i3 + 1;
            }
        }
        if (i2 == -1) {
            return EMPTY_CALLER_DATA_ARRAY;
        }
        int length = stackTrace.length - i2;
        if (i >= length) {
            i = length;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i];
        for (int i4 = 0; i4 < i; i4++) {
            stackTraceElementArr[i4] = stackTrace[i2 + i4];
        }
        return stackTraceElementArr;
    }

    static boolean isInFrameworkSpace(String str, String str2, List<String> list) {
        if (str.equals(str2) || str.equals(LOG4J_CATEGORY) || str.startsWith(SLF4J_BOUNDARY) || isInFrameworkSpaceList(str, list)) {
            return true;
        }
        return false;
    }

    private static boolean isInFrameworkSpaceList(String str, List<String> list) {
        if (list == null) {
            return false;
        }
        for (String startsWith : list) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static StackTraceElement naInstance() {
        return new StackTraceElement(f1661NA, f1661NA, f1661NA, -1);
    }
}
