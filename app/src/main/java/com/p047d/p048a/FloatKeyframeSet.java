package com.p047d.p048a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* renamed from: com.d.a.l */
final class FloatKeyframeSet extends KeyframeSet {

    /* renamed from: g */
    private float f3519g;

    /* renamed from: h */
    private float f3520h;

    /* renamed from: i */
    private float f3521i;

    /* renamed from: j */
    private boolean f3522j = true;

    /* renamed from: a */
    public final /* synthetic */ KeyframeSet mo16205a() {
        ArrayList arrayList = this.f3537e;
        int size = this.f3537e.size();
        C1556p[] pVarArr = new C1556p[size];
        for (int i = 0; i < size; i++) {
            pVarArr[i] = (C1556p) ((Keyframe) arrayList.get(i)).clone();
        }
        return new FloatKeyframeSet(pVarArr);
    }

    public FloatKeyframeSet(C1556p... pVarArr) {
        super(pVarArr);
    }

    /* renamed from: a */
    public final Object mo16206a(float f) {
        return Float.valueOf(mo16207b(f));
    }

    /* renamed from: b */
    public final float mo16207b(float f) {
        int i = 1;
        if (this.f3533a == 2) {
            if (this.f3522j) {
                this.f3522j = false;
                this.f3519g = ((C1556p) this.f3537e.get(0)).f3531e;
                this.f3520h = ((C1556p) this.f3537e.get(1)).f3531e;
                this.f3521i = this.f3520h - this.f3519g;
            }
            if (this.f3536d != null) {
                f = this.f3536d.getInterpolation(f);
            }
            if (this.f3538f == null) {
                return this.f3519g + (this.f3521i * f);
            }
            return ((Number) this.f3538f.mo16182a(f, Float.valueOf(this.f3519g), Float.valueOf(this.f3520h))).floatValue();
        } else if (f <= 0.0f) {
            C1556p pVar = (C1556p) this.f3537e.get(0);
            C1556p pVar2 = (C1556p) this.f3537e.get(1);
            float f2 = pVar.f3531e;
            float f3 = pVar2.f3531e;
            float f4 = pVar.f3527a;
            float f5 = pVar2.f3527a;
            Interpolator interpolator = pVar2.f3529c;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            float f6 = (f - f4) / (f5 - f4);
            if (this.f3538f == null) {
                return (f6 * (f3 - f2)) + f2;
            }
            return ((Number) this.f3538f.mo16182a(f6, Float.valueOf(f2), Float.valueOf(f3))).floatValue();
        } else if (f >= 1.0f) {
            C1556p pVar3 = (C1556p) this.f3537e.get(this.f3533a - 2);
            C1556p pVar4 = (C1556p) this.f3537e.get(this.f3533a - 1);
            float f7 = pVar3.f3531e;
            float f8 = pVar4.f3531e;
            float f9 = pVar3.f3527a;
            float f10 = pVar4.f3527a;
            Interpolator interpolator2 = pVar4.f3529c;
            if (interpolator2 != null) {
                f = interpolator2.getInterpolation(f);
            }
            float f11 = (f - f9) / (f10 - f9);
            if (this.f3538f == null) {
                return (f11 * (f8 - f7)) + f7;
            }
            return ((Number) this.f3538f.mo16182a(f11, Float.valueOf(f7), Float.valueOf(f8))).floatValue();
        } else {
            C1556p pVar5 = (C1556p) this.f3537e.get(0);
            while (true) {
                C1556p pVar6 = pVar5;
                if (i >= this.f3533a) {
                    return ((Number) ((Keyframe) this.f3537e.get(this.f3533a - 1)).mo16209a()).floatValue();
                }
                pVar5 = (C1556p) this.f3537e.get(i);
                if (f < pVar5.f3527a) {
                    Interpolator interpolator3 = pVar5.f3529c;
                    if (interpolator3 != null) {
                        f = interpolator3.getInterpolation(f);
                    }
                    float f12 = (f - pVar6.f3527a) / (pVar5.f3527a - pVar6.f3527a);
                    float f13 = pVar6.f3531e;
                    float f14 = pVar5.f3531e;
                    if (this.f3538f == null) {
                        return ((f14 - f13) * f12) + f13;
                    }
                    return ((Number) this.f3538f.mo16182a(f12, Float.valueOf(f13), Float.valueOf(f14))).floatValue();
                }
                i++;
            }
        }
    }
}
