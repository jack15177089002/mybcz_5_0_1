package com.baicizhan.client.business.util.Aa;

/* renamed from: com.f.a.i */
/* compiled from: BitmapHunter */
final class C1591i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Transformation f3785a;

    C1591i(Transformation bhVar) {
        this.f3785a = bhVar;
    }

    public final void run() {
        throw new IllegalStateException("Transformation " + this.f3785a.key() + " returned input Bitmap but recycled it.");
    }
}
