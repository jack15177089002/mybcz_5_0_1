package p012ch.qos.logback.core.encoder;

import java.io.OutputStream;
import p012ch.qos.logback.core.spi.ContextAware;
import p012ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.encoder.Encoder */
public interface Encoder<E> extends ContextAware, LifeCycle {
    void close();

    void doEncode(E e);

    void init(OutputStream outputStream);
}
