package com.p047d.p048a;

import android.view.View;
import com.p047d.p049b.FloatProperty;
import com.p047d.p050c.p051a.AnimatorProxy;

/* renamed from: com.d.a.y */
/* compiled from: PreHoneycombCompat */
final class C1563y extends FloatProperty<View> {
    /* renamed from: a */
    public final /* synthetic */ Object mo16169a(Object obj) {
        AnimatorProxy a = AnimatorProxy.m3396a((View) obj);
        View view = (View) a.f3561b.get();
        return Float.valueOf(view == null ? 0.0f : ((float) view.getLeft()) + a.f3570k);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo16170a(Object obj, float f) {
        AnimatorProxy a = AnimatorProxy.m3396a((View) obj);
        View view = (View) a.f3561b.get();
        if (view != null) {
            a.mo16227g(f - ((float) view.getLeft()));
        }
    }

    C1563y(String str) {
        super(str);
    }
}
