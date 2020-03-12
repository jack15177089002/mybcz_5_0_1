package com.p047d.p048a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* renamed from: com.d.a.n */
final class IntKeyframeSet extends KeyframeSet {

    /* renamed from: g */
    private int f3523g;

    /* renamed from: h */
    private int f3524h;

    /* renamed from: i */
    private int f3525i;

    /* renamed from: j */
    private boolean f3526j = true;

    /* renamed from: a */
    public final /* synthetic */ KeyframeSet mo16205a() {
        ArrayList arrayList = this.f3537e;
        int size = this.f3537e.size();
        C1557q[] qVarArr = new C1557q[size];
        for (int i = 0; i < size; i++) {
            qVarArr[i] = (C1557q) ((Keyframe) arrayList.get(i)).clone();
        }
        return new IntKeyframeSet(qVarArr);
    }

    public IntKeyframeSet(C1557q... qVarArr) {
        super(qVarArr);
    }

    /* renamed from: a */
    public final Object mo16206a(float f) {
        return Integer.valueOf(mo16208b(f));
    }

    /* renamed from: b */
    public final int mo16208b(float f) {
        int i = 1;
        if (this.f3533a == 2) {
            if (this.f3526j) {
                this.f3526j = false;
                this.f3523g = ((C1557q) this.f3537e.get(0)).f3532e;
                this.f3524h = ((C1557q) this.f3537e.get(1)).f3532e;
                this.f3525i = this.f3524h - this.f3523g;
            }
            if (this.f3536d != null) {
                f = this.f3536d.getInterpolation(f);
            }
            if (this.f3538f == null) {
                return this.f3523g + ((int) (((float) this.f3525i) * f));
            }
            return ((Number) this.f3538f.mo16182a(f, Integer.valueOf(this.f3523g), Integer.valueOf(this.f3524h))).intValue();
        } else if (f <= 0.0f) {
            C1557q qVar = (C1557q) this.f3537e.get(0);
            C1557q qVar2 = (C1557q) this.f3537e.get(1);
            int i2 = qVar.f3532e;
            int i3 = qVar2.f3532e;
            float f2 = qVar.f3527a;
            float f3 = qVar2.f3527a;
            Interpolator interpolator = qVar2.f3529c;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            float f4 = (f - f2) / (f3 - f2);
            if (this.f3538f == null) {
                return ((int) (f4 * ((float) (i3 - i2)))) + i2;
            }
            return ((Number) this.f3538f.mo16182a(f4, Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
        } else if (f >= 1.0f) {
            C1557q qVar3 = (C1557q) this.f3537e.get(this.f3533a - 2);
            C1557q qVar4 = (C1557q) this.f3537e.get(this.f3533a - 1);
            int i4 = qVar3.f3532e;
            int i5 = qVar4.f3532e;
            float f5 = qVar3.f3527a;
            float f6 = qVar4.f3527a;
            Interpolator interpolator2 = qVar4.f3529c;
            if (interpolator2 != null) {
                f = interpolator2.getInterpolation(f);
            }
            float f7 = (f - f5) / (f6 - f5);
            if (this.f3538f == null) {
                return ((int) (f7 * ((float) (i5 - i4)))) + i4;
            }
            return ((Number) this.f3538f.mo16182a(f7, Integer.valueOf(i4), Integer.valueOf(i5))).intValue();
        } else {
            C1557q qVar5 = (C1557q) this.f3537e.get(0);
            while (true) {
                C1557q qVar6 = qVar5;
                if (i >= this.f3533a) {
                    return ((Number) ((Keyframe) this.f3537e.get(this.f3533a - 1)).mo16209a()).intValue();
                }
                qVar5 = (C1557q) this.f3537e.get(i);
                if (f < qVar5.f3527a) {
                    Interpolator interpolator3 = qVar5.f3529c;
                    if (interpolator3 != null) {
                        f = interpolator3.getInterpolation(f);
                    }
                    float f8 = (f - qVar6.f3527a) / (qVar5.f3527a - qVar6.f3527a);
                    int i6 = qVar6.f3532e;
                    int i7 = qVar5.f3532e;
                    if (this.f3538f == null) {
                        return ((int) (((float) (i7 - i6)) * f8)) + i6;
                    }
                    return ((Number) this.f3538f.mo16182a(f8, Integer.valueOf(i6), Integer.valueOf(i7))).intValue();
                }
                i++;
            }
        }
    }
}
