package com.p047d.p048a;

/* renamed from: com.d.a.p */
/* compiled from: Keyframe */
final class C1556p extends Keyframe {

    /* renamed from: e */
    float f3531e;

    /* renamed from: b */
    public final /* synthetic */ Keyframe mo16211b() {
        C1556p pVar = new C1556p(this.f3527a, this.f3531e);
        pVar.f3529c = this.f3529c;
        return pVar;
    }

    C1556p(float f, float f2) {
        this.f3527a = f;
        this.f3531e = f2;
        this.f3528b = Float.TYPE;
        this.f3530d = true;
    }

    C1556p() {
        this.f3527a = 0.0f;
        this.f3528b = Float.TYPE;
    }

    /* renamed from: a */
    public final Object mo16209a() {
        return Float.valueOf(this.f3531e);
    }

    /* renamed from: a */
    public final void mo16210a(Object obj) {
        if (obj != null && obj.getClass() == Float.class) {
            this.f3531e = ((Float) obj).floatValue();
            this.f3530d = true;
        }
    }
}
