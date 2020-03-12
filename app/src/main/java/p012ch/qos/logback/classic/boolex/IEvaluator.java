package p012ch.qos.logback.classic.boolex;

import p012ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.boolex.IEvaluator */
public interface IEvaluator {
    boolean doEvaluate(ILoggingEvent iLoggingEvent);
}
