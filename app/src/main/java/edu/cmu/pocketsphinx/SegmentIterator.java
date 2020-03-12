package edu.cmu.pocketsphinx;

public class SegmentIterator {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected SegmentIterator(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(SegmentIterator obj) {
        if (obj == null) {
            return 0;
        }
        return obj.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                pocketsphinxJNI.delete_SegmentIterator(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public SegmentIterator() {
        this(pocketsphinxJNI.new_SegmentIterator(), true);
    }
}
