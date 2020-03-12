package p012ch.qos.logback.classic.filter;

import p012ch.qos.logback.classic.Level;
import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.core.filter.Filter;
import p012ch.qos.logback.core.spi.FilterReply;

/* renamed from: ch.qos.logback.classic.filter.ThresholdFilter */
public class ThresholdFilter extends Filter<ILoggingEvent> {
    Level level;

    public FilterReply decide(ILoggingEvent iLoggingEvent) {
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }
        if (iLoggingEvent.getLevel().isGreaterOrEqual(this.level)) {
            return FilterReply.NEUTRAL;
        }
        return FilterReply.DENY;
    }

    public void setLevel(String str) {
        this.level = Level.toLevel(str);
    }

    public void start() {
        if (this.level != null) {
            super.start();
        }
    }
}
