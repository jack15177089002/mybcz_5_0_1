package com.baicizhan.client.framework.log;

import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.core.boolex.EventEvaluatorBase;

public class BaicizhanCrashEventEvaluator extends EventEvaluatorBase<ILoggingEvent> {
    public boolean evaluate(ILoggingEvent iLoggingEvent) {
        if (iLoggingEvent == null) {
            return false;
        }
        String message = iLoggingEvent.getMessage();
        if (message == null || !message.contains("BCZ-CRASH")) {
            return false;
        }
        return true;
    }
}
