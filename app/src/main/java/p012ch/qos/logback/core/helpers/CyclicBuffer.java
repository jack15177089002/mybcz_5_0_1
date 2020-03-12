package p012ch.qos.logback.core.helpers;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ch.qos.logback.core.helpers.CyclicBuffer */
public class CyclicBuffer<E> {

    /* renamed from: ea */
    E[] f1663ea;
    int first;
    int last;
    int maxSize;
    int numElems;

    public CyclicBuffer(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The maxSize argument (" + i + ") is not a positive integer.");
        }
        init(i);
    }

    public CyclicBuffer(CyclicBuffer<E> cyclicBuffer) {
        this.maxSize = cyclicBuffer.maxSize;
        this.f1663ea = new Object[this.maxSize];
        System.arraycopy(cyclicBuffer.f1663ea, 0, this.f1663ea, 0, this.maxSize);
        this.last = cyclicBuffer.last;
        this.first = cyclicBuffer.first;
        this.numElems = cyclicBuffer.numElems;
    }

    private void init(int i) {
        this.maxSize = i;
        this.f1663ea = new Object[i];
        this.first = 0;
        this.last = 0;
        this.numElems = 0;
    }

    public void clear() {
        init(this.maxSize);
    }

    public void add(E e) {
        this.f1663ea[this.last] = e;
        int i = this.last + 1;
        this.last = i;
        if (i == this.maxSize) {
            this.last = 0;
        }
        if (this.numElems < this.maxSize) {
            this.numElems++;
            return;
        }
        int i2 = this.first + 1;
        this.first = i2;
        if (i2 == this.maxSize) {
            this.first = 0;
        }
    }

    public E get(int i) {
        if (i < 0 || i >= this.numElems) {
            return null;
        }
        return this.f1663ea[(this.first + i) % this.maxSize];
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public E get() {
        if (this.numElems <= 0) {
            return null;
        }
        this.numElems--;
        E e = this.f1663ea[this.first];
        this.f1663ea[this.first] = null;
        int i = this.first + 1;
        this.first = i;
        if (i != this.maxSize) {
            return e;
        }
        this.first = 0;
        return e;
    }

    public List<E> asList() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length(); i++) {
            arrayList.add(get(i));
        }
        return arrayList;
    }

    public int length() {
        return this.numElems;
    }

    public void resize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Negative array size [" + i + "] not allowed.");
        } else if (i != this.numElems) {
            E[] eArr = new Object[i];
            int i2 = i < this.numElems ? i : this.numElems;
            for (int i3 = 0; i3 < i2; i3++) {
                eArr[i3] = this.f1663ea[this.first];
                this.f1663ea[this.first] = null;
                int i4 = this.first + 1;
                this.first = i4;
                if (i4 == this.numElems) {
                    this.first = 0;
                }
            }
            this.f1663ea = eArr;
            this.first = 0;
            this.numElems = i2;
            this.maxSize = i;
            if (i2 == i) {
                this.last = 0;
            } else {
                this.last = i2;
            }
        }
    }
}
