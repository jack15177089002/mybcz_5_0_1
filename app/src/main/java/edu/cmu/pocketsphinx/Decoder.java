package edu.cmu.pocketsphinx;

/* renamed from: edu.cmu.pocketsphinx.b */
public final class Decoder {

    /* renamed from: a */
    long f5694a;

    /* renamed from: b */
    protected boolean f5695b;

    private Decoder(long j) {
        this.f5695b = true;
        this.f5694a = j;
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        m5367c();
    }

    /* renamed from: c */
    private synchronized void m5367c() {
        if (this.f5694a != 0) {
            if (this.f5695b) {
                this.f5695b = false;
                pocketsphinxJNI.delete_Decoder(this.f5694a);
            }
            this.f5694a = 0;
        }
    }

    public Decoder() {
        this(pocketsphinxJNI.new_Decoder__SWIG_0());
    }

    public Decoder(Config aVar) {
        this(pocketsphinxJNI.new_Decoder__SWIG_1(aVar.f5692a, aVar));
    }

    /* renamed from: a */
    public final int mo18372a() {
        return pocketsphinxJNI.Decoder_endUtt(this.f5694a, this);
    }

    /* renamed from: a */
    public final int mo18373a(short[] sArr, long j) {
        return pocketsphinxJNI.Decoder_processRaw__SWIG_1(this.f5694a, this, sArr, j, false, false);
    }

    /* renamed from: b */
    public final Hypothesis mo18374b() {
        long Decoder_getHyp = pocketsphinxJNI.Decoder_getHyp(this.f5694a, this);
        if (Decoder_getHyp == 0) {
            return null;
        }
        return new Hypothesis(Decoder_getHyp);
    }
}
