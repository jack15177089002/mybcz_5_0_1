package p012ch.qos.logback.core.spi;

import java.util.ArrayList;
import java.util.List;
import p012ch.qos.logback.core.helpers.CyclicBuffer;

/* renamed from: ch.qos.logback.core.spi.CyclicBufferTracker */
public class CyclicBufferTracker<E> extends AbstractComponentTracker<CyclicBuffer<E>> {
    static final int DEFAULT_BUFFER_SIZE = 256;
    static final int DEFAULT_NUMBER_OF_BUFFERS = 64;
    int bufferSize = 256;

    public CyclicBufferTracker() {
        setMaxComponents(64);
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public void setBufferSize(int i) {
        this.bufferSize = i;
    }

    /* access modifiers changed from: protected */
    public void processPriorToRemoval(CyclicBuffer<E> cyclicBuffer) {
        cyclicBuffer.clear();
    }

    /* access modifiers changed from: protected */
    public CyclicBuffer<E> buildComponent(String str) {
        return new CyclicBuffer<>(this.bufferSize);
    }

    /* access modifiers changed from: protected */
    public boolean isComponentStale(CyclicBuffer<E> cyclicBuffer) {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public List<String> liveKeysAsOrderedList() {
        return new ArrayList(this.liveMap.keySet());
    }

    /* access modifiers changed from: 0000 */
    public List<String> lingererKeysAsOrderedList() {
        return new ArrayList(this.lingerersMap.keySet());
    }
}
