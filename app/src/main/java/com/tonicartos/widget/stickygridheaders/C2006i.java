package com.tonicartos.widget.stickygridheaders;

import android.view.View;

/* renamed from: com.tonicartos.widget.stickygridheaders.i */
/* compiled from: StickyGridHeadersGridView */
final class C2006i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ View f5382a;

    /* renamed from: b */
    final /* synthetic */ C2011n f5383b;

    /* renamed from: c */
    final /* synthetic */ StickyGridHeadersGridView f5384c;

    C2006i(StickyGridHeadersGridView stickyGridHeadersGridView, View view, C2011n nVar) {
        this.f5384c = stickyGridHeadersGridView;
        this.f5382a = view;
        this.f5383b = nVar;
    }

    public final void run() {
        this.f5384c.f5339h = -1;
        this.f5382a.setPressed(false);
        this.f5384c.setPressed(false);
        if (!this.f5384c.f5337f) {
            this.f5383b.run();
        }
    }
}
