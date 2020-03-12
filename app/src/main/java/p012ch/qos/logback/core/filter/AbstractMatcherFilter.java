package p012ch.qos.logback.core.filter;

import p012ch.qos.logback.core.spi.FilterReply;

/* renamed from: ch.qos.logback.core.filter.AbstractMatcherFilter */
public abstract class AbstractMatcherFilter<E> extends Filter<E> {
    public FilterReply onMatch = FilterReply.NEUTRAL;
    public FilterReply onMismatch = FilterReply.NEUTRAL;

    public final void setOnMatch(FilterReply filterReply) {
        this.onMatch = filterReply;
    }

    public final void setOnMismatch(FilterReply filterReply) {
        this.onMismatch = filterReply;
    }

    public final FilterReply getOnMatch() {
        return this.onMatch;
    }

    public final FilterReply getOnMismatch() {
        return this.onMismatch;
    }
}
