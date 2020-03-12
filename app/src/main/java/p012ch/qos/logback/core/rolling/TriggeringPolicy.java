package p012ch.qos.logback.core.rolling;

import java.io.File;
import p012ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.rolling.TriggeringPolicy */
public interface TriggeringPolicy<E> extends LifeCycle {
    boolean isTriggeringEvent(File file, E e);
}
