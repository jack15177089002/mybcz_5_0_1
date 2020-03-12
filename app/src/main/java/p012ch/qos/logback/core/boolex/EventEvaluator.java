package p012ch.qos.logback.core.boolex;

import p012ch.qos.logback.core.spi.ContextAware;
import p012ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.boolex.EventEvaluator */
public interface EventEvaluator<E> extends ContextAware, LifeCycle {
    boolean evaluate(E e);

    String getName();

    void setName(String str);
}
