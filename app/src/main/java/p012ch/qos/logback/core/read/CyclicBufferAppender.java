package p012ch.qos.logback.core.read;

import com.baicizhan.main.utils.GuideFlags;
import p012ch.qos.logback.core.AppenderBase;
import p012ch.qos.logback.core.helpers.CyclicBuffer;

/* renamed from: ch.qos.logback.core.read.CyclicBufferAppender */
public class CyclicBufferAppender<E> extends AppenderBase<E> {

    /* renamed from: cb */
    CyclicBuffer<E> f1666cb;
    int maxSize = GuideFlags.FLAG_PATTERN_3;

    public void start() {
        this.f1666cb = new CyclicBuffer<>(this.maxSize);
        super.start();
    }

    public void stop() {
        this.f1666cb = null;
        super.stop();
    }

    /* access modifiers changed from: protected */
    public void append(E e) {
        if (isStarted()) {
            this.f1666cb.add(e);
        }
    }

    public int getLength() {
        if (isStarted()) {
            return this.f1666cb.length();
        }
        return 0;
    }

    public E get(int i) {
        if (isStarted()) {
            return this.f1666cb.get(i);
        }
        return null;
    }

    public void reset() {
        this.f1666cb.clear();
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public void setMaxSize(int i) {
        this.maxSize = i;
    }
}
