package p012ch.qos.logback.core.encoder;

import java.io.OutputStream;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: ch.qos.logback.core.encoder.EchoEncoder */
public class EchoEncoder<E> extends EncoderBase<E> {
    public void doEncode(E e) {
        this.outputStream.write((e + CoreConstants.LINE_SEPARATOR).getBytes());
        this.outputStream.flush();
    }

    public void close() {
    }

    public void init(OutputStream outputStream) {
        super.init(outputStream);
    }
}
