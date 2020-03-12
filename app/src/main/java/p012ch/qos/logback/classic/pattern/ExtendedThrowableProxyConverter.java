package p012ch.qos.logback.classic.pattern;

import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.classic.spi.StackTraceElementProxy;
import p012ch.qos.logback.classic.spi.ThrowableProxyUtil;

/* renamed from: ch.qos.logback.classic.pattern.ExtendedThrowableProxyConverter */
public class ExtendedThrowableProxyConverter extends ThrowableProxyConverter {
    /* access modifiers changed from: protected */
    public void extraData(StringBuilder sb, StackTraceElementProxy stackTraceElementProxy) {
        ThrowableProxyUtil.subjoinPackagingData(sb, stackTraceElementProxy);
    }

    /* access modifiers changed from: protected */
    public void prepareLoggingEvent(ILoggingEvent iLoggingEvent) {
    }
}
