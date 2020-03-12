package p012ch.qos.logback.classic.pattern;

import p012ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.ContextNameConverter */
public class ContextNameConverter extends ClassicConverter {
    public String convert(ILoggingEvent iLoggingEvent) {
        return iLoggingEvent.getLoggerContextVO().getName();
    }
}
