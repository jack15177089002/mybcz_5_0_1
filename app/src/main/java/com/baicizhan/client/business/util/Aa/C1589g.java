package com.baicizhan.client.business.util.Aa;

/* renamed from: com.f.a.g */
/* compiled from: BitmapHunter */
final class C1589g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Transformation f3782a;

    /* renamed from: b */
    final /* synthetic */ RuntimeException f3783b;

    C1589g(Transformation bhVar, RuntimeException runtimeException) {
        this.f3782a = bhVar;
        this.f3783b = runtimeException;
    }

    public final void run() {
        throw new RuntimeException("Transformation " + this.f3782a.key() + " crashed with exception.", this.f3783b);
    }
}
