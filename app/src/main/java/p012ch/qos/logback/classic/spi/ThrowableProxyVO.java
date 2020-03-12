package p012ch.qos.logback.classic.spi;

import java.io.Serializable;
import java.util.Arrays;

/* renamed from: ch.qos.logback.classic.spi.ThrowableProxyVO */
public class ThrowableProxyVO implements IThrowableProxy, Serializable {
    private static final long serialVersionUID = -773438177285807139L;
    private IThrowableProxy cause;
    private String className;
    private int commonFramesCount;
    private String message;
    private StackTraceElementProxy[] stackTraceElementProxyArray;
    private IThrowableProxy[] suppressed;

    public String getMessage() {
        return this.message;
    }

    public String getClassName() {
        return this.className;
    }

    public int getCommonFrames() {
        return this.commonFramesCount;
    }

    public IThrowableProxy getCause() {
        return this.cause;
    }

    public StackTraceElementProxy[] getStackTraceElementProxyArray() {
        return this.stackTraceElementProxyArray;
    }

    public IThrowableProxy[] getSuppressed() {
        return this.suppressed;
    }

    public int hashCode() {
        return (this.className == null ? 0 : this.className.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ThrowableProxyVO throwableProxyVO = (ThrowableProxyVO) obj;
        if (this.className == null) {
            if (throwableProxyVO.className != null) {
                return false;
            }
        } else if (!this.className.equals(throwableProxyVO.className)) {
            return false;
        }
        if (!Arrays.equals(this.stackTraceElementProxyArray, throwableProxyVO.stackTraceElementProxyArray)) {
            return false;
        }
        if (!Arrays.equals(this.suppressed, throwableProxyVO.suppressed)) {
            return false;
        }
        if (this.cause == null) {
            if (throwableProxyVO.cause != null) {
                return false;
            }
            return true;
        } else if (!this.cause.equals(throwableProxyVO.cause)) {
            return false;
        } else {
            return true;
        }
    }

    public static ThrowableProxyVO build(IThrowableProxy iThrowableProxy) {
        if (iThrowableProxy == null) {
            return null;
        }
        ThrowableProxyVO throwableProxyVO = new ThrowableProxyVO();
        throwableProxyVO.className = iThrowableProxy.getClassName();
        throwableProxyVO.message = iThrowableProxy.getMessage();
        throwableProxyVO.commonFramesCount = iThrowableProxy.getCommonFrames();
        throwableProxyVO.stackTraceElementProxyArray = iThrowableProxy.getStackTraceElementProxyArray();
        IThrowableProxy cause2 = iThrowableProxy.getCause();
        if (cause2 != null) {
            throwableProxyVO.cause = build(cause2);
        }
        IThrowableProxy[] suppressed2 = iThrowableProxy.getSuppressed();
        if (suppressed2 != null) {
            throwableProxyVO.suppressed = new IThrowableProxy[suppressed2.length];
            for (int i = 0; i < suppressed2.length; i++) {
                throwableProxyVO.suppressed[i] = build(suppressed2[i]);
            }
        }
        return throwableProxyVO;
    }
}
