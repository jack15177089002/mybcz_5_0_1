package com.jeremyfeinstein.slidingmenu.lib;

import android.view.animation.Interpolator;

/* renamed from: com.jeremyfeinstein.slidingmenu.lib.b */
/* compiled from: CustomViewAbove */
final class C1634b implements Interpolator {
    C1634b() {
    }

    public final float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
