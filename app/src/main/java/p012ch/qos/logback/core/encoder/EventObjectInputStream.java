package p012ch.qos.logback.core.encoder;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ch.qos.logback.core.encoder.EventObjectInputStream */
public class EventObjectInputStream<E> extends InputStream {
    List<E> buffer = new ArrayList();
    int index = 0;
    NonClosableInputStream ncis;

    EventObjectInputStream(InputStream inputStream) {
        this.ncis = new NonClosableInputStream(inputStream);
    }

    public int read() {
        throw new UnsupportedOperationException("Only the readEvent method is supported.");
    }

    public int available() {
        return this.ncis.available();
    }

    public E readEvent() {
        E fromBuffer = getFromBuffer();
        if (fromBuffer != null) {
            return fromBuffer;
        }
        internalReset();
        int readHeader = readHeader();
        if (readHeader == -1) {
            return null;
        }
        readPayload(readHeader);
        readFooter(readHeader);
        return getFromBuffer();
    }

    private void internalReset() {
        this.index = 0;
        this.buffer.clear();
    }

    /* access modifiers changed from: 0000 */
    public E getFromBuffer() {
        if (this.index >= this.buffer.size()) {
            return null;
        }
        List<E> list = this.buffer;
        int i = this.index;
        this.index = i + 1;
        return list.get(i);
    }

    /* access modifiers changed from: 0000 */
    public int readHeader() {
        int i = -1;
        byte[] bArr = new byte[16];
        if (this.ncis.read(bArr) != -1) {
            if (ByteArrayUtil.readInt(bArr, 0) != 1853421169) {
                throw new IllegalStateException("Does not look like data created by ObjectStreamEncoder");
            }
            i = ByteArrayUtil.readInt(bArr, 4);
            if (ByteArrayUtil.readInt(bArr, 12) != (1853421169 ^ i)) {
                throw new IllegalStateException("Invalid checksum");
            }
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    public E readEvents(ObjectInputStream objectInputStream) {
        ClassNotFoundException e;
        E e2;
        try {
            e2 = objectInputStream.readObject();
            try {
                this.buffer.add(e2);
            } catch (ClassNotFoundException e3) {
                e = e3;
                e.printStackTrace();
                return e2;
            }
        } catch (ClassNotFoundException e4) {
            ClassNotFoundException classNotFoundException = e4;
            e2 = null;
            e = classNotFoundException;
        }
        return e2;
    }

    /* access modifiers changed from: 0000 */
    public void readFooter(int i) {
        byte[] bArr = new byte[8];
        if (this.ncis.read(bArr) == -1) {
            throw new IllegalStateException("Looks like a corrupt stream");
        } else if (ByteArrayUtil.readInt(bArr, 0) != 640373619) {
            throw new IllegalStateException("Looks like a corrupt stream");
        } else if (ByteArrayUtil.readInt(bArr, 4) != (640373619 ^ i)) {
            throw new IllegalStateException("Invalid checksum");
        }
    }

    /* access modifiers changed from: 0000 */
    public void readPayload(int i) {
        ArrayList arrayList = new ArrayList(i);
        ObjectInputStream objectInputStream = new ObjectInputStream(this.ncis);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(readEvents(objectInputStream));
        }
        objectInputStream.close();
    }

    public void close() {
        this.ncis.realClose();
    }
}
