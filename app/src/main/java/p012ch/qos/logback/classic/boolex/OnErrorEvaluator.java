package p012ch.qos.logback.classic.boolex;

import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.core.boolex.EventEvaluatorBase;

/* renamed from: ch.qos.logback.classic.boolex.OnErrorEvaluator */
public class OnErrorEvaluator extends EventEvaluatorBase<ILoggingEvent> {
    public boolean evaluate(ILoggingEvent iLoggingEvent) {
        return iLoggingEvent.getLevel().levelInt >= 40000;
    }
}
