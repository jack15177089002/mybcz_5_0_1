package com.tonicartos.widget.stickygridheaders;

import android.view.View;

/* renamed from: com.tonicartos.widget.stickygridheaders.n */
/* compiled from: StickyGridHeadersGridView */
final class C2011n extends C2013p implements Runnable {

    /* renamed from: a */
    int f5387a;

    /* renamed from: b */
    final /* synthetic */ StickyGridHeadersGridView f5388b;

    private C2011n(StickyGridHeadersGridView stickyGridHeadersGridView) {
        this.f5388b = stickyGridHeadersGridView;
        super(stickyGridHeadersGridView, 0);
    }

    /* synthetic */ C2011n(StickyGridHeadersGridView stickyGridHeadersGridView, byte b) {
        this(stickyGridHeadersGridView);
    }

    public final void run() {
        if (!this.f5388b.f5337f && this.f5388b.f5336e != null && this.f5388b.f5336e.getCount() > 0 && this.f5387a != -1 && this.f5387a < this.f5388b.f5336e.getCount() && mo18250b()) {
            View a = this.f5388b.mo18176a(this.f5387a);
            if (a != null) {
                StickyGridHeadersGridView stickyGridHeadersGridView = this.f5388b;
                StickyGridHeadersGridView.m5102a(this.f5388b, this.f5387a);
                if (stickyGridHeadersGridView.f5334c != null) {
                    stickyGridHeadersGridView.playSoundEffect(0);
                    if (a != null) {
                        a.sendAccessibilityEvent(1);
                    }
                }
            }
        }
    }
}
