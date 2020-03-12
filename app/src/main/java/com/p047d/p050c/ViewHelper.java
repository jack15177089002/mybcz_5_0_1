package com.p047d.p050c;

import android.view.View;
import com.p047d.p050c.p051a.AnimatorProxy;

/* renamed from: com.d.c.a */
public final class ViewHelper {
    /* renamed from: a */
    public static void m3389a(View view, float f) {
        if (AnimatorProxy.f3559a) {
            AnimatorProxy.m3396a(view).mo16219a(f);
        } else {
            view.setAlpha(f);
        }
    }

    /* renamed from: b */
    public static void m3390b(View view, float f) {
        if (AnimatorProxy.f3559a) {
            AnimatorProxy.m3396a(view).mo16222b(f);
        } else {
            view.setPivotX(f);
        }
    }

    /* renamed from: c */
    public static void m3391c(View view, float f) {
        if (AnimatorProxy.f3559a) {
            AnimatorProxy.m3396a(view).mo16223c(f);
        } else {
            view.setPivotY(f);
        }
    }

    /* renamed from: d */
    public static void m3392d(View view, float f) {
        if (AnimatorProxy.f3559a) {
            AnimatorProxy.m3396a(view).mo16225e(f);
        } else {
            view.setScaleX(f);
        }
    }

    /* renamed from: e */
    public static void m3393e(View view, float f) {
        if (AnimatorProxy.f3559a) {
            AnimatorProxy.m3396a(view).mo16226f(f);
        } else {
            view.setScaleY(f);
        }
    }

    /* renamed from: a */
    public static float m3388a(View view) {
        return AnimatorProxy.f3559a ? AnimatorProxy.m3396a(view).f3571l : view.getTranslationY();
    }

    /* renamed from: f */
    public static void m3394f(View view, float f) {
        if (AnimatorProxy.f3559a) {
            AnimatorProxy.m3396a(view).mo16228h(f);
        } else {
            view.setTranslationY(f);
        }
    }

    /* renamed from: g */
    public static void m3395g(View view, float f) {
        if (AnimatorProxy.f3559a) {
            AnimatorProxy.m3396a(view).mo16229i(f);
        } else {
            view.setY(f);
        }
    }
}
