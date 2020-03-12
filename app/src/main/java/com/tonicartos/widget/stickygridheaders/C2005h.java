package com.tonicartos.widget.stickygridheaders;

import android.database.DataSetObserver;

/* renamed from: com.tonicartos.widget.stickygridheaders.h */
/* compiled from: StickyGridHeadersGridView */
final class C2005h extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ StickyGridHeadersGridView f5381a;

    C2005h(StickyGridHeadersGridView stickyGridHeadersGridView) {
        this.f5381a = stickyGridHeadersGridView;
    }

    public final void onChanged() {
        this.f5381a.m5106b();
    }

    public final void onInvalidated() {
        this.f5381a.m5106b();
    }
}
