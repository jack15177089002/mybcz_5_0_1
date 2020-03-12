package edu.cmu.pocketsphinx;

public class Lattice {
    protected boolean swigCMemOwn;
    private long swigCPtr;

    protected Lattice(long cPtr, boolean cMemoryOwn) {
        this.swigCMemOwn = cMemoryOwn;
        this.swigCPtr = cPtr;
    }

    protected static long getCPtr(Lattice obj) {
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
                pocketsphinxJNI.delete_Lattice(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public Lattice() {
        this(pocketsphinxJNI.new_Lattice(), true);
    }
}
