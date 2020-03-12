package com.p047d.p048a;

/* renamed from: com.d.a.q */
/* compiled from: Keyframe */
final class C1557q extends Keyframe {

    /* renamed from: e */
    int f3532e;

    /* renamed from: b */
    public final /* synthetic */ Keyframe mo16211b() {
        C1557q qVar = new C1557q(this.f3527a, this.f3532e);
        qVar.f3529c = this.f3529c;
        return qVar;
    }

    C1557q(float f, int i) {
        this.f3527a = f;
        this.f3532e = i;
        this.f3528b = Integer.TYPE;
        this.f3530d = true;
    }

    C1557q() {
        this.f3527a = 0.0f;
        this.f3528b = Integer.TYPE;
    }

    /* renamed from: a */
    public final Object mo16209a() {
        return Integer.valueOf(this.f3532e);
    }

    /* renamed from: a */
    public final void mo16210a(Object obj) {
        if (obj != null && obj.getClass() == Integer.class) {
            this.f3532e = ((Integer) obj).intValue();
            this.f3530d = true;
        }
    }
}
