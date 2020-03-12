package p012ch.qos.logback.classic.filter;

import p012ch.qos.logback.classic.Level;
import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.core.filter.AbstractMatcherFilter;
import p012ch.qos.logback.core.spi.FilterReply;

/* renamed from: ch.qos.logback.classic.filter.LevelFilter */
public class LevelFilter extends AbstractMatcherFilter<ILoggingEvent> {
    Level level;

    public FilterReply decide(ILoggingEvent iLoggingEvent) {
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }
        if (iLoggingEvent.getLevel().equals(this.level)) {
            return this.onMatch;
        }
        return this.onMismatch;
    }

    public void setLevel(Level level2) {
        this.level = level2;
    }

    public void start() {
        if (this.level != null) {
            super.start();
        }
    }
}
