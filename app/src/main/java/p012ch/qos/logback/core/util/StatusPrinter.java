package p012ch.qos.logback.core.util;

import java.io.PrintStream;
import java.util.List;
import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.helpers.ThrowableToStringArray;
import p012ch.qos.logback.core.status.Status;
import p012ch.qos.logback.core.status.StatusManager;
import p012ch.qos.logback.core.status.StatusUtil;

/* renamed from: ch.qos.logback.core.util.StatusPrinter */
public class StatusPrinter {
    static CachingDateFormatter cachingDateFormat = new CachingDateFormatter("HH:mm:ss,SSS");

    /* renamed from: ps */
    private static PrintStream f1673ps = System.out;

    public static void setPrintStream(PrintStream printStream) {
        f1673ps = printStream;
    }

    public static void printInCaseOfErrorsOrWarnings(Context context) {
        printInCaseOfErrorsOrWarnings(context, 0);
    }

    public static void printInCaseOfErrorsOrWarnings(Context context, long j) {
        if (context == null) {
            throw new IllegalArgumentException("Context argument cannot be null");
        }
        StatusManager statusManager = context.getStatusManager();
        if (statusManager == null) {
            f1673ps.println("WARN: Context named \"" + context.getName() + "\" has no status manager");
        } else if (new StatusUtil(context).getHighestLevel(j) > 0) {
            print(statusManager, j);
        }
    }

    public static void printIfErrorsOccured(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context argument cannot be null");
        }
        StatusManager statusManager = context.getStatusManager();
        if (statusManager == null) {
            f1673ps.println("WARN: Context named \"" + context.getName() + "\" has no status manager");
        } else if (new StatusUtil(context).getHighestLevel(0) == 2) {
            print(statusManager);
        }
    }

    public static void print(Context context) {
        print(context, 0);
    }

    public static void print(Context context, long j) {
        if (context == null) {
            throw new IllegalArgumentException("Context argument cannot be null");
        }
        StatusManager statusManager = context.getStatusManager();
        if (statusManager == null) {
            f1673ps.println("WARN: Context named \"" + context.getName() + "\" has no status manager");
        } else {
            print(statusManager, j);
        }
    }

    public static void print(StatusManager statusManager) {
        print(statusManager, 0);
    }

    public static void print(StatusManager statusManager, long j) {
        StringBuilder sb = new StringBuilder();
        buildStrFromStatusList(sb, StatusUtil.filterStatusListByTimeThreshold(statusManager.getCopyOfStatusList(), j));
        f1673ps.println(sb.toString());
    }

    public static void print(List<Status> list) {
        StringBuilder sb = new StringBuilder();
        buildStrFromStatusList(sb, list);
        f1673ps.println(sb.toString());
    }

    private static void buildStrFromStatusList(StringBuilder sb, List<Status> list) {
        if (list != null) {
            for (Status buildStr : list) {
                buildStr(sb, "", buildStr);
            }
        }
    }

    private static void appendThrowable(StringBuilder sb, Throwable th) {
        String[] convert;
        for (String str : ThrowableToStringArray.convert(th)) {
            if (!str.startsWith(CoreConstants.CAUSED_BY)) {
                if (Character.isDigit(str.charAt(0))) {
                    sb.append("\t... ");
                } else {
                    sb.append("\tat ");
                }
            }
            sb.append(str).append(CoreConstants.LINE_SEPARATOR);
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=ch.qos.logback.core.status.Status, code=ch.qos.logback.core.status.Status<ch.qos.logback.core.status.Status>, for r6v0, types: [java.lang.Object, ch.qos.logback.core.status.Status<ch.qos.logback.core.status.Status>, ch.qos.logback.core.status.Status] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public static void buildStr(StringBuilder r4, String r5, p012ch.qos.logback.core.status.Status<p012ch.qos.logback.core.status.Status> r6) {
//        /*
//            boolean r0 = r6.hasChildren()
//            if (r0 == 0) goto L_0x005f
//            java.lang.StringBuilder r0 = new java.lang.StringBuilder
//            java.lang.String r1 = java.lang.String.valueOf(r5)
//            r0.<init>(r1)
//            java.lang.String r1 = "+ "
//            java.lang.StringBuilder r0 = r0.append(r1)
//            java.lang.String r0 = r0.toString()
//        L_0x0019:
//            ch.qos.logback.core.util.CachingDateFormatter r1 = cachingDateFormat
//            if (r1 == 0) goto L_0x0034
//            ch.qos.logback.core.util.CachingDateFormatter r1 = cachingDateFormat
//            java.lang.Long r2 = r6.getDate()
//            long r2 = r2.longValue()
//            java.lang.String r1 = r1.format(r2)
//            java.lang.StringBuilder r1 = r4.append(r1)
//            java.lang.String r2 = " "
//            r1.append(r2)
//        L_0x0034:
//            java.lang.StringBuilder r0 = r4.append(r0)
//            java.lang.StringBuilder r0 = r0.append(r6)
//            java.lang.String r1 = p012ch.qos.logback.core.CoreConstants.LINE_SEPARATOR
//            r0.append(r1)
//            java.lang.Throwable r0 = r6.getThrowable()
//            if (r0 == 0) goto L_0x004e
//            java.lang.Throwable r0 = r6.getThrowable()
//            appendThrowable(r4, r0)
//        L_0x004e:
//            boolean r0 = r6.hasChildren()
//            if (r0 == 0) goto L_0x005e
//            java.util.Iterator r1 = r6.iterator()
//        L_0x0058:
//            boolean r0 = r1.hasNext()
//            if (r0 != 0) goto L_0x0073
//        L_0x005e:
//            return
//        L_0x005f:
//            java.lang.StringBuilder r0 = new java.lang.StringBuilder
//            java.lang.String r1 = java.lang.String.valueOf(r5)
//            r0.<init>(r1)
//            java.lang.String r1 = "|-"
//            java.lang.StringBuilder r0 = r0.append(r1)
//            java.lang.String r0 = r0.toString()
//            goto L_0x0019
//        L_0x0073:
//            java.lang.Object r0 = r1.next()
//            ch.qos.logback.core.status.Status r0 = (p012ch.qos.logback.core.status.Status) r0
//            java.lang.StringBuilder r2 = new java.lang.StringBuilder
//            java.lang.String r3 = java.lang.String.valueOf(r5)
//            r2.<init>(r3)
//            java.lang.String r3 = "  "
//            java.lang.StringBuilder r2 = r2.append(r3)
//            java.lang.String r2 = r2.toString()
//            buildStr(r4, r2, r0)
//            goto L_0x0058
//        */
//        throw new UnsupportedOperationException("Method not decompiled: p012ch.qos.logback.core.util.StatusPrinter.buildStr(java.lang.StringBuilder, java.lang.String, ch.qos.logback.core.status.Status):void");
//    }
}
