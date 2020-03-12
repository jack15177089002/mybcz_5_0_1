package com.tonicartos.widget.stickygridheaders;

import android.view.View;

/* renamed from: com.tonicartos.widget.stickygridheaders.j */
/* compiled from: StickyGridHeadersGridView */
final class C2007j extends C2013p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ StickyGridHeadersGridView f5385a;

    private C2007j(StickyGridHeadersGridView stickyGridHeadersGridView) {
        this.f5385a = stickyGridHeadersGridView;
        super(stickyGridHeadersGridView, 0);
    }

    /* synthetic */ C2007j(StickyGridHeadersGridView stickyGridHeadersGridView, byte b) {
        this(stickyGridHeadersGridView);
    }

    public final void run() {
        boolean z;
        View a = this.f5385a.mo18176a(this.f5385a.f5338g);
        if (a != null) {
            StickyGridHeadersGridView.m5102a(this.f5385a, this.f5385a.f5338g);
            if (!mo18250b() || this.f5385a.f5337f) {
                z = false;
            } else {
                StickyGridHeadersGridView stickyGridHeadersGridView = this.f5385a;
                if (stickyGridHeadersGridView.f5335d != null) {
                    z = stickyGridHeadersGridView.f5335d.mo18245a();
                } else {
                    z = false;
                }
                if (z) {
                    if (a != null) {
                        a.sendAccessibilityEvent(2);
                    }
                    stickyGridHeadersGridView.performHapticFeedback(0);
                }
            }
            if (z) {
                this.f5385a.f5339h = -2;
                this.f5385a.setPressed(false);
                a.setPressed(false);
                return;
            }
            this.f5385a.f5339h = 2;
        }
    }
}
