package p012ch.qos.logback.classic.spi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: ch.qos.logback.classic.spi.ThrowableProxy */
public class ThrowableProxy implements IThrowableProxy {
    private static final Method GET_SUPPRESSED_METHOD;
    private static final ThrowableProxy[] NO_SUPPRESSED = new ThrowableProxy[0];
    private boolean calculatedPackageData = false;
    private ThrowableProxy cause;
    private String className;
    int commonFrames;
    private String message;
    private transient PackagingDataCalculator packagingDataCalculator;
    StackTraceElementProxy[] stackTraceElementProxyArray;
    private ThrowableProxy[] suppressed = NO_SUPPRESSED;
    private Throwable throwable;

    static {
        Method method = null;
        try {
            method = Throwable.class.getMethod("getSuppressed", new Class[0]);
        } catch (NoSuchMethodException e) {
        }
        GET_SUPPRESSED_METHOD = method;
    }

    public ThrowableProxy(Throwable th) {
        this.throwable = th;
        this.className = th.getClass().getName();
        this.message = th.getMessage();
        this.stackTraceElementProxyArray = ThrowableProxyUtil.steArrayToStepArray(th.getStackTrace());
        Throwable cause2 = th.getCause();
        if (cause2 != null) {
            this.cause = new ThrowableProxy(cause2);
            this.cause.commonFrames = ThrowableProxyUtil.findNumberOfCommonFrames(cause2.getStackTrace(), this.stackTraceElementProxyArray);
        }
        if (GET_SUPPRESSED_METHOD != null) {
            try {
                Object invoke = GET_SUPPRESSED_METHOD.invoke(th, new Object[0]);
                if (invoke instanceof Throwable[]) {
                    Throwable[] thArr = (Throwable[]) invoke;
                    if (thArr.length > 0) {
                        this.suppressed = new ThrowableProxy[thArr.length];
                        for (int i = 0; i < thArr.length; i++) {
                            this.suppressed[i] = new ThrowableProxy(thArr[i]);
                            this.suppressed[i].commonFrames = ThrowableProxyUtil.findNumberOfCommonFrames(thArr[i].getStackTrace(), this.stackTraceElementProxyArray);
                        }
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
            }
        }
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public String getMessage() {
        return this.message;
    }

    public String getClassName() {
        return this.className;
    }

    public StackTraceElementProxy[] getStackTraceElementProxyArray() {
        return this.stackTraceElementProxyArray;
    }

    public int getCommonFrames() {
        return this.commonFrames;
    }

    public IThrowableProxy getCause() {
        return this.cause;
    }

    public IThrowableProxy[] getSuppressed() {
        return this.suppressed;
    }

    public PackagingDataCalculator getPackagingDataCalculator() {
        if (this.throwable != null && this.packagingDataCalculator == null) {
            this.packagingDataCalculator = new PackagingDataCalculator();
        }
        return this.packagingDataCalculator;
    }

    public void calculatePackagingData() {
        if (!this.calculatedPackageData) {
            PackagingDataCalculator packagingDataCalculator2 = getPackagingDataCalculator();
            if (packagingDataCalculator2 != null) {
                this.calculatedPackageData = true;
                packagingDataCalculator2.calculate(this);
            }
        }
    }

    public void fullDump() {
        StackTraceElementProxy[] stackTraceElementProxyArr;
        StringBuilder sb = new StringBuilder();
        for (StackTraceElementProxy stackTraceElementProxy : this.stackTraceElementProxyArray) {
            sb.append(9).append(stackTraceElementProxy.toString());
            ThrowableProxyUtil.subjoinPackagingData(sb, stackTraceElementProxy);
            sb.append(CoreConstants.LINE_SEPARATOR);
        }
        System.out.println(sb.toString());
    }
}
