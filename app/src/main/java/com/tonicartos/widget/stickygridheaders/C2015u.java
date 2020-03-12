package com.tonicartos.widget.stickygridheaders;

import android.database.DataSetObserver;

/* renamed from: com.tonicartos.widget.stickygridheaders.u */
/* compiled from: StickyGridHeadersSimpleAdapterWrapper */
final class C2015u extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ StickyGridHeadersSimpleAdapterWrapper f5396a;

    private C2015u(StickyGridHeadersSimpleAdapterWrapper tVar) {
        this.f5396a = tVar;
    }

    /* synthetic */ C2015u(StickyGridHeadersSimpleAdapterWrapper tVar, byte b) {
        this(tVar);
    }

    public final void onChanged() {
        this.f5396a.f5395b = this.f5396a.mo18259a(this.f5396a.f5394a);
        this.f5396a.notifyDataSetChanged();
    }

    public final void onInvalidated() {
        this.f5396a.f5395b = this.f5396a.mo18259a(this.f5396a.f5394a);
        this.f5396a.notifyDataSetInvalidated();
    }
}
