package com.p047d.p048a;

import android.view.View;
import com.p047d.p049b.IntProperty;
import com.p047d.p050c.p051a.AnimatorProxy;

/* renamed from: com.d.a.x */
/* compiled from: PreHoneycombCompat */
final class C1562x extends IntProperty<View> {
    /* renamed from: a */
    public final /* synthetic */ Object mo16169a(Object obj) {
        View view = (View) AnimatorProxy.m3396a((View) obj).f3561b.get();
        return Integer.valueOf(view == null ? 0 : view.getScrollY());
    }

    /* renamed from: a */
    public final /* synthetic */ void mo16216a(Object obj, int i) {
        View view = (View) AnimatorProxy.m3396a((View) obj).f3561b.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i);
        }
    }

    C1562x(String str) {
        super(str);
    }
}
