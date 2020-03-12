package com.p047d.p048a;

import android.view.animation.Interpolator;

/* renamed from: com.d.a.o */
public abstract class Keyframe implements Cloneable {

    /* renamed from: a */
    float f3527a;

    /* renamed from: b */
    Class f3528b;

    /* renamed from: c */
    Interpolator f3529c = null;

    /* renamed from: d */
    boolean f3530d = false;

    /* renamed from: a */
    public abstract Object mo16209a();

    /* renamed from: a */
    public abstract void mo16210a(Object obj);

    /* renamed from: b */
    public abstract Keyframe clone();

    /* renamed from: a */
    public static Keyframe m3348a(float f, int i) {
        return new C1557q(f, i);
    }

    /* renamed from: a */
    public static Keyframe m3347a(float f, float f2) {
        return new C1556p(f, f2);
    }
}
