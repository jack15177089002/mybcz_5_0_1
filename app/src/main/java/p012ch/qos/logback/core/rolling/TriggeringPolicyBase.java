package p012ch.qos.logback.core.rolling;

import p012ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.rolling.TriggeringPolicyBase */
public abstract class TriggeringPolicyBase<E> extends ContextAwareBase implements TriggeringPolicy<E> {
    private boolean start;

    public void start() {
        this.start = true;
    }

    public void stop() {
        this.start = false;
    }

    public boolean isStarted() {
        return this.start;
    }
}
