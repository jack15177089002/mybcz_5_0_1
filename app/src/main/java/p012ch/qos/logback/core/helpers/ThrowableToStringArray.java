package p012ch.qos.logback.core.helpers;

import java.util.LinkedList;
import java.util.List;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: ch.qos.logback.core.helpers.ThrowableToStringArray */
public class ThrowableToStringArray {
    public static String[] convert(Throwable th) {
        LinkedList linkedList = new LinkedList();
        extract(linkedList, th, null);
        return (String[]) linkedList.toArray(new String[0]);
    }

    private static void extract(List<String> list, Throwable th, StackTraceElement[] stackTraceElementArr) {
        while (true) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int findNumberOfCommonFrames = findNumberOfCommonFrames(stackTrace, stackTraceElementArr);
            list.add(formatFirstLine(th, stackTraceElementArr));
            for (int i = 0; i < stackTrace.length - findNumberOfCommonFrames; i++) {
                list.add("\tat " + stackTrace[i].toString());
            }
            if (findNumberOfCommonFrames != 0) {
                list.add("\t... " + findNumberOfCommonFrames + " common frames omitted");
            }
            th = th.getCause();
            if (th != null) {
                stackTraceElementArr = stackTrace;
            } else {
                return;
            }
        }
    }

    private static String formatFirstLine(Throwable th, StackTraceElement[] stackTraceElementArr) {
        String str = "";
        if (stackTraceElementArr != null) {
            str = CoreConstants.CAUSED_BY;
        }
        String sb = new StringBuilder(String.valueOf(str)).append(th.getClass().getName()).toString();
        if (th.getMessage() != null) {
            return new StringBuilder(String.valueOf(sb)).append(": ").append(th.getMessage()).toString();
        }
        return sb;
    }

    private static int findNumberOfCommonFrames(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        int i = 0;
        if (stackTraceElementArr2 != null) {
            int length = stackTraceElementArr.length - 1;
            int length2 = stackTraceElementArr2.length - 1;
            while (length >= 0 && length2 >= 0 && stackTraceElementArr[length].equals(stackTraceElementArr2[length2])) {
                i++;
                length--;
                length2--;
            }
        }
        return i;
    }
}
