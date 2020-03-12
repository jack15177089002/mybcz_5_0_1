package com.kyleduo.switchbutton;

/* renamed from: com.kyleduo.switchbutton.h */
/* compiled from: SwitchButton */
final class C1661h implements C1657c {

    /* renamed from: a */
    final /* synthetic */ SwitchButton f4033a;

    C1661h(SwitchButton switchButton) {
        this.f4033a = switchButton;
    }

    /* renamed from: a */
    public final void mo16654a() {
        this.f4033a.f3985j = true;
    }

    /* renamed from: b */
    public final boolean mo16656b() {
        return this.f4033a.f3981f.right < this.f4033a.f3979d.right && this.f4033a.f3981f.left > this.f4033a.f3979d.left;
    }

    /* renamed from: a */
    public final void mo16655a(int i) {
        this.f4033a.m3683a(i);
        this.f4033a.postInvalidate();
    }

    /* renamed from: c */
    public final void mo16657c() {
        this.f4033a.setCheckedInClass(this.f4033a.getStatusBasedOnPos());
        this.f4033a.f3985j = false;
    }
}
