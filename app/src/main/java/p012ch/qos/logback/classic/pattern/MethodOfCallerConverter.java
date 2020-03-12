package p012ch.qos.logback.classic.pattern;

import p012ch.qos.logback.classic.spi.CallerData;
import p012ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.MethodOfCallerConverter */
public class MethodOfCallerConverter extends ClassicConverter {
    public String convert(ILoggingEvent iLoggingEvent) {
        StackTraceElement[] callerData = iLoggingEvent.getCallerData();
        if (callerData == null || callerData.length <= 0) {
            return CallerData.f1661NA;
        }
        return callerData[0].getMethodName();
    }
}
