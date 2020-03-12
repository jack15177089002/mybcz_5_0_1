package edu.cmu.pocketsphinx;

/* renamed from: edu.cmu.pocketsphinx.c */
public final class Hypothesis {

    /* renamed from: a */
    protected boolean f5696a = false;

    /* renamed from: b */
    private long f5697b;

    protected Hypothesis(long j) {
        this.f5697b = j;
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        m5371b();
    }

    /* renamed from: b */
    private synchronized void m5371b() {
        if (this.f5697b != 0) {
            if (this.f5696a) {
                this.f5696a = false;
                pocketsphinxJNI.delete_Hypothesis(this.f5697b);
            }
            this.f5697b = 0;
        }
    }

    /* renamed from: a */
    public final String mo18376a() {
        return pocketsphinxJNI.Hypothesis_hypstr_get(this.f5697b, this);
    }
}
