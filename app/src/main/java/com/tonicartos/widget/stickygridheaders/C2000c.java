package com.tonicartos.widget.stickygridheaders;

import android.database.DataSetObserver;

/* renamed from: com.tonicartos.widget.stickygridheaders.c */
/* compiled from: StickyGridHeadersBaseAdapterWrapper */
final class C2000c extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ StickyGridHeadersBaseAdapterWrapper f5368a;

    C2000c(StickyGridHeadersBaseAdapterWrapper bVar) {
        this.f5368a = bVar;
    }

    public final void onChanged() {
        StickyGridHeadersBaseAdapterWrapper bVar = this.f5368a;
        bVar.f5361b = 0;
        int numHeaders = bVar.f5360a.getNumHeaders();
        if (numHeaders == 0) {
            bVar.f5361b = bVar.f5360a.getCount();
        } else {
            for (int i = 0; i < numHeaders; i++) {
                bVar.f5361b += bVar.f5360a.getCountForHeader(i) + bVar.f5362c;
            }
        }
        this.f5368a.notifyDataSetChanged();
    }

    public final void onInvalidated() {
        this.f5368a.f5366h.clear();
        this.f5368a.notifyDataSetInvalidated();
    }
}
