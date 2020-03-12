package p012ch.qos.logback.core;

import p012ch.qos.logback.core.spi.ContextAware;
import p012ch.qos.logback.core.spi.FilterAttachable;
import p012ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.Appender */
public interface Appender<E> extends ContextAware, FilterAttachable<E>, LifeCycle {
    void doAppend(E e);

    String getName();

    void setName(String str);
}
