package com.p047d.p048a;

import android.view.View;
import com.p047d.p049b.IntProperty;
import com.p047d.p050c.p051a.AnimatorProxy;

/* renamed from: com.d.a.w */
/* compiled from: PreHoneycombCompat */
final class C1561w extends IntProperty<View> {
    /* renamed from: a */
    public final /* synthetic */ Object mo16169a(Object obj) {
        View view = (View) AnimatorProxy.m3396a((View) obj).f3561b.get();
        return Integer.valueOf(view == null ? 0 : view.getScrollX());
    }

    /* renamed from: a */
    public final /* synthetic */ void mo16216a(Object obj, int i) {
        View view = (View) AnimatorProxy.m3396a((View) obj).f3561b.get();
        if (view != null) {
            view.scrollTo(i, view.getScrollY());
        }
    }

    C1561w(String str) {
        super(str);
    }
}
