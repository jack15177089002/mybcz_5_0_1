package p012ch.qos.logback.core.sift;

import p012ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.sift.AbstractDiscriminator */
public abstract class AbstractDiscriminator<E> extends ContextAwareBase implements Discriminator<E> {
    public boolean started;

    public void start() {
        this.started = true;
    }

    public void stop() {
        this.started = false;
    }

    public boolean isStarted() {
        return this.started;
    }
}
