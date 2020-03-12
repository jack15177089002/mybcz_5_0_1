package p012ch.qos.logback.core.encoder;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.Layout;

/* renamed from: ch.qos.logback.core.encoder.LayoutWrappingEncoder */
public class LayoutWrappingEncoder<E> extends EncoderBase<E> {
    private Charset charset;
    private boolean immediateFlush = true;
    public Layout<E> layout;

    public void setImmediateFlush(boolean z) {
        this.immediateFlush = z;
    }

    public boolean isImmediateFlush() {
        return this.immediateFlush;
    }

    public Layout<E> getLayout() {
        return this.layout;
    }

    public void setLayout(Layout<E> layout2) {
        this.layout = layout2;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public void setCharset(Charset charset2) {
        this.charset = charset2;
    }

    public void init(OutputStream outputStream) {
        super.init(outputStream);
        writeHeader();
    }

    /* access modifiers changed from: 0000 */
    public void writeHeader() {
        if (this.layout != null && this.outputStream != null) {
            StringBuilder sb = new StringBuilder();
            appendIfNotNull(sb, this.layout.getFileHeader());
            appendIfNotNull(sb, this.layout.getPresentationHeader());
            if (sb.length() > 0) {
                sb.append(CoreConstants.LINE_SEPARATOR);
                this.outputStream.write(convertToBytes(sb.toString()));
                this.outputStream.flush();
            }
        }
    }

    public void close() {
        writeFooter();
    }

    /* access modifiers changed from: 0000 */
    public void writeFooter() {
        if (this.layout != null && this.outputStream != null) {
            StringBuilder sb = new StringBuilder();
            appendIfNotNull(sb, this.layout.getPresentationFooter());
            appendIfNotNull(sb, this.layout.getFileFooter());
            if (sb.length() > 0) {
                this.outputStream.write(convertToBytes(sb.toString()));
                this.outputStream.flush();
            }
        }
    }

    private byte[] convertToBytes(String str) {
        if (this.charset == null) {
            return str.getBytes();
        }
        try {
            return str.getBytes(this.charset.name());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("An existing charset cannot possibly be unsupported.");
        }
    }

    public void doEncode(E e) {
        this.outputStream.write(convertToBytes(this.layout.doLayout(e)));
        if (this.immediateFlush) {
            this.outputStream.flush();
        }
    }

    public boolean isStarted() {
        return false;
    }

    public void start() {
        this.started = true;
    }

    public void stop() {
        this.started = false;
        if (this.outputStream != null) {
            try {
                this.outputStream.flush();
            } catch (IOException e) {
            }
        }
    }

    private void appendIfNotNull(StringBuilder sb, String str) {
        if (str != null) {
            sb.append(str);
        }
    }
}
