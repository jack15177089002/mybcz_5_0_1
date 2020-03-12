package p012ch.qos.logback.core;

import java.util.List;
import p012ch.qos.logback.core.filter.Filter;
import p012ch.qos.logback.core.spi.ContextAwareBase;
import p012ch.qos.logback.core.spi.FilterAttachableImpl;
import p012ch.qos.logback.core.spi.FilterReply;
import p012ch.qos.logback.core.status.WarnStatus;

/* renamed from: ch.qos.logback.core.UnsynchronizedAppenderBase */
public abstract class UnsynchronizedAppenderBase<E> extends ContextAwareBase implements Appender<E> {
    static final int ALLOWED_REPEATS = 3;
    private int exceptionCount = 0;
    private FilterAttachableImpl<E> fai = new FilterAttachableImpl<>();
    private ThreadLocal<Boolean> guard = new ThreadLocal<>();
    protected String name;
    protected boolean started = false;
    private int statusRepeatCount = 0;

    /* access modifiers changed from: protected */
    public abstract void append(E e);

    public String getName() {
        return this.name;
    }

    public void doAppend(E e) {
        if (!Boolean.TRUE.equals(this.guard.get())) {
            try {
                this.guard.set(Boolean.TRUE);
                if (!this.started) {
                    int i = this.statusRepeatCount;
                    this.statusRepeatCount = i + 1;
                    if (i < 3) {
                        addStatus(new WarnStatus("Attempted to append to non started appender [" + this.name + "].", this));
                    }
                } else if (getFilterChainDecision(e) != FilterReply.DENY) {
                    append(e);
                    this.guard.set(Boolean.FALSE);
                }
            } catch (Exception e2) {
                int i2 = this.exceptionCount;
                this.exceptionCount = i2 + 1;
                if (i2 < 3) {
                    addError("Appender [" + this.name + "] failed to append.", e2);
                }
            } finally {
                this.guard.set(Boolean.FALSE);
            }
        }
    }

    public void setName(String str) {
        this.name = str;
    }

    public void start() {
        this.started = true;
    }

    public void stop() {
        this.started = false;
    }

    public boolean isStarted() {
        return this.started;
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getClass().getName())).append("[").append(this.name).append("]").toString();
    }

    public void addFilter(Filter<E> filter) {
        this.fai.addFilter(filter);
    }

    public void clearAllFilters() {
        this.fai.clearAllFilters();
    }

    public List<Filter<E>> getCopyOfAttachedFiltersList() {
        return this.fai.getCopyOfAttachedFiltersList();
    }

    public FilterReply getFilterChainDecision(E e) {
        return this.fai.getFilterChainDecision(e);
    }
}
