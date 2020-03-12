package p012ch.qos.logback.core.sift;

import p012ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.sift.Discriminator */
public interface Discriminator<E> extends LifeCycle {
    String getDiscriminatingValue(E e);

    String getKey();
}
