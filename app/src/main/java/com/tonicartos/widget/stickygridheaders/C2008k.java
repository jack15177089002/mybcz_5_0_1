package com.tonicartos.widget.stickygridheaders;

import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: com.tonicartos.widget.stickygridheaders.k */
/* compiled from: StickyGridHeadersGridView */
final class C2008k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ StickyGridHeadersGridView f5386a;

    C2008k(StickyGridHeadersGridView stickyGridHeadersGridView) {
        this.f5386a = stickyGridHeadersGridView;
    }

    public final void run() {
        if (this.f5386a.f5339h == 0) {
            this.f5386a.f5339h = 1;
            View a = this.f5386a.mo18176a(this.f5386a.f5338g);
            if (a != null && !a.hasFocusable()) {
                if (!this.f5386a.f5337f) {
                    a.setPressed(true);
                    this.f5386a.setPressed(true);
                    this.f5386a.refreshDrawableState();
                    int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    if (this.f5386a.isLongClickable()) {
                        if (this.f5386a.f5332a == null) {
                            this.f5386a.f5332a = new C2007j(this.f5386a, 0);
                        }
                        this.f5386a.f5332a.mo18249a();
                        this.f5386a.postDelayed(this.f5386a.f5332a, (long) longPressTimeout);
                        return;
                    }
                    this.f5386a.f5339h = 2;
                    return;
                }
                this.f5386a.f5339h = 2;
            }
        }
    }
}
