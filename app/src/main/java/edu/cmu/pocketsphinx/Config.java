package edu.cmu.pocketsphinx;

/* renamed from: edu.cmu.pocketsphinx.a */
public final class Config {

    /* renamed from: a */
    long f5692a;

    /* renamed from: b */
    protected boolean f5693b;

    private Config(long j) {
        this.f5693b = true;
        this.f5692a = j;
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        m5363a();
    }

    /* renamed from: a */
    private synchronized void m5363a() {
        if (this.f5692a != 0) {
            if (this.f5693b) {
                this.f5693b = false;
                pocketsphinxJNI.delete_Config(this.f5692a);
            }
            this.f5692a = 0;
        }
    }

    public Config() {
        this(pocketsphinxJNI.new_Config__SWIG_0());
    }

    /* renamed from: a */
    public final void mo18370a(String str, boolean z) {
        pocketsphinxJNI.Config_setBoolean(this.f5692a, this, str, z);
    }

    /* renamed from: a */
    public final void mo18368a(String str, int i) {
        pocketsphinxJNI.Config_setInt(this.f5692a, this, str, i);
    }

    /* renamed from: a */
    public final void mo18369a(String str, String str2) {
        pocketsphinxJNI.Config_setString(this.f5692a, this, str, str2);
    }
}
