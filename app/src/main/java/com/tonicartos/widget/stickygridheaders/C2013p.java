package com.tonicartos.widget.stickygridheaders;

/* renamed from: com.tonicartos.widget.stickygridheaders.p */
/* compiled from: StickyGridHeadersGridView */
class C2013p {

    /* renamed from: a */
    private int f5389a;

    /* renamed from: c */
    final /* synthetic */ StickyGridHeadersGridView f5390c;

    private C2013p(StickyGridHeadersGridView stickyGridHeadersGridView) {
        this.f5390c = stickyGridHeadersGridView;
    }

    /* synthetic */ C2013p(StickyGridHeadersGridView stickyGridHeadersGridView, byte b) {
        this(stickyGridHeadersGridView);
    }

    /* renamed from: a */
    public final void mo18249a() {
        this.f5389a = this.f5390c.getWindowAttachCount();
    }

    /* renamed from: b */
    public final boolean mo18250b() {
        return this.f5390c.hasWindowFocus() && this.f5390c.getWindowAttachCount() == this.f5389a;
    }
}
