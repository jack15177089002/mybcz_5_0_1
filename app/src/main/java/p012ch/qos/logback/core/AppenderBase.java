package p012ch.qos.logback.core;

import java.util.List;
import p012ch.qos.logback.core.filter.Filter;
import p012ch.qos.logback.core.spi.ContextAwareBase;
import p012ch.qos.logback.core.spi.FilterAttachableImpl;
import p012ch.qos.logback.core.spi.FilterReply;
import p012ch.qos.logback.core.status.WarnStatus;

/* renamed from: ch.qos.logback.core.AppenderBase */
public abstract class AppenderBase<E> extends ContextAwareBase implements Appender<E> {
    static final int ALLOWED_REPEATS = 5;
    private int exceptionCount = 0;
    private FilterAttachableImpl<E> fai = new FilterAttachableImpl<>();
    private boolean guard = false;
    public String name;
    protected boolean started = false;
    private int statusRepeatCount = 0;

    public abstract void append(E e);

    public String getName() {
        return this.name;
    }

    public synchronized void doAppend(E e) {
        if (!this.guard) {
            try {
                this.guard = true;
                if (!this.started) {
                    int i = this.statusRepeatCount;
                    this.statusRepeatCount = i + 1;
                    if (i < 5) {
                        addStatus(new WarnStatus("Attempted to append to non started appender [" + this.name + "].", this));
                    }
                } else if (getFilterChainDecision(e) != FilterReply.DENY) {
                    append(e);
                    this.guard = false;
                }
                this.guard = false;
            } catch (Exception e2) {
                int i2 = this.exceptionCount;
                this.exceptionCount = i2 + 1;
                if (i2 < 5) {
                    addError("Appender [" + this.name + "] failed to append.", e2);
                }
                this.guard = false;
            } catch (Throwable th) {
                this.guard = false;
                throw th;
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
