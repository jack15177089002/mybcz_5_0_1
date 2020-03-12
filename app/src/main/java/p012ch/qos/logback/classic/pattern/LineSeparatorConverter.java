package p012ch.qos.logback.classic.pattern;

import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: ch.qos.logback.classic.pattern.LineSeparatorConverter */
public class LineSeparatorConverter extends ClassicConverter {
    public String convert(ILoggingEvent iLoggingEvent) {
        return CoreConstants.LINE_SEPARATOR;
    }
}
