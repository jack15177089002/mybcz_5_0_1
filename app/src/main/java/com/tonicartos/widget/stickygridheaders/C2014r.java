package com.tonicartos.widget.stickygridheaders;

import android.database.DataSetObserver;

/* renamed from: com.tonicartos.widget.stickygridheaders.r */
/* compiled from: StickyGridHeadersListAdapterWrapper */
final class C2014r extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ StickyGridHeadersListAdapterWrapper f5393a;

    C2014r(StickyGridHeadersListAdapterWrapper qVar) {
        this.f5393a = qVar;
    }

    public final void onChanged() {
        this.f5393a.notifyDataSetChanged();
    }

    public final void onInvalidated() {
        this.f5393a.notifyDataSetInvalidated();
    }
}
