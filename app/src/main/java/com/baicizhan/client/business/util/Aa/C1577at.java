package com.baicizhan.client.business.util.Aa;

import java.util.concurrent.FutureTask;

/* renamed from: com.f.a.at */
/* compiled from: PicassoExecutorService */
final class C1577at extends FutureTask<BitmapHunter> implements Comparable<C1577at> {

    /* renamed from: a */
    private final BitmapHunter f3671a;

    public final /* bridge */ /* synthetic */ int compareTo(C1577at obj) {
        C1577at atVar = (C1577at) obj;
        int i = this.f3671a.f3781r;
        int i2 = atVar.f3671a.f3781r;
        return i == i2 ? this.f3671a.f3764a - atVar.f3671a.f3764a : (i2 - 1) - (i - 1);
    }

    public C1577at(BitmapHunter dVar) {
        super(dVar, null);
        this.f3671a = dVar;
    }


}
