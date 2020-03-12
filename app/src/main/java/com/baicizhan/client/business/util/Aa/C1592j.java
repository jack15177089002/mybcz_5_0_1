package com.baicizhan.client.business.util.Aa;

/* renamed from: com.f.a.j */
/* compiled from: BitmapHunter */
final class C1592j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Transformation f3786a;

    C1592j(Transformation bhVar) {
        this.f3786a = bhVar;
    }

    public final void run() {
        throw new IllegalStateException("Transformation " + this.f3786a.key() + " mutated input Bitmap but failed to recycle the original.");
    }
}
