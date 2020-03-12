package com.p047d.p048a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.d.a.r */
class KeyframeSet {

    /* renamed from: a */
    int f3533a;

    /* renamed from: b */
    Keyframe f3534b;

    /* renamed from: c */
    Keyframe f3535c;

    /* renamed from: d */
    Interpolator f3536d;

    /* renamed from: e */
    ArrayList<Keyframe> f3537e = new ArrayList<>();

    /* renamed from: f */
    TypeEvaluator f3538f;

    public KeyframeSet(Keyframe... oVarArr) {
        this.f3533a = oVarArr.length;
        this.f3537e.addAll(Arrays.asList(oVarArr));
        this.f3534b = (Keyframe) this.f3537e.get(0);
        this.f3535c = (Keyframe) this.f3537e.get(this.f3533a - 1);
        this.f3536d = this.f3535c.f3529c;
    }

    /* renamed from: a */
    public KeyframeSet clone() {
        ArrayList<Keyframe> arrayList = this.f3537e;
        int size = this.f3537e.size();
        Keyframe[] oVarArr = new Keyframe[size];
        for (int i = 0; i < size; i++) {
            oVarArr[i] = ((Keyframe) arrayList.get(i)).clone();
        }
        return new KeyframeSet(oVarArr);
    }

    /* renamed from: a */
    public Object mo16206a(float f) {
        if (this.f3533a == 2) {
            if (this.f3536d != null) {
                f = this.f3536d.getInterpolation(f);
            }
            return this.f3538f.mo16182a(f, this.f3534b.mo16209a(), this.f3535c.mo16209a());
        } else if (f <= 0.0f) {
            Keyframe oVar = (Keyframe) this.f3537e.get(1);
            Interpolator interpolator = oVar.f3529c;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            float f2 = this.f3534b.f3527a;
            return this.f3538f.mo16182a((f - f2) / (oVar.f3527a - f2), this.f3534b.mo16209a(), oVar.mo16209a());
        } else if (f >= 1.0f) {
            Keyframe oVar2 = (Keyframe) this.f3537e.get(this.f3533a - 2);
            Interpolator interpolator2 = this.f3535c.f3529c;
            if (interpolator2 != null) {
                f = interpolator2.getInterpolation(f);
            }
            float f3 = oVar2.f3527a;
            return this.f3538f.mo16182a((f - f3) / (this.f3535c.f3527a - f3), oVar2.mo16209a(), this.f3535c.mo16209a());
        } else {
            Keyframe oVar3 = this.f3534b;
            int i = 1;
            while (i < this.f3533a) {
                Keyframe oVar4 = (Keyframe) this.f3537e.get(i);
                if (f < oVar4.f3527a) {
                    Interpolator interpolator3 = oVar4.f3529c;
                    if (interpolator3 != null) {
                        f = interpolator3.getInterpolation(f);
                    }
                    float f4 = oVar3.f3527a;
                    return this.f3538f.mo16182a((f - f4) / (oVar4.f3527a - f4), oVar3.mo16209a(), oVar4.mo16209a());
                }
                i++;
                oVar3 = oVar4;
            }
            return this.f3535c.mo16209a();
        }
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (i < this.f3533a) {
            String sb = new StringBuilder(String.valueOf(str)).append(((Keyframe) this.f3537e.get(i)).mo16209a()).append("  ").toString();
            i++;
            str = sb;
        }
        return str;
    }
}
