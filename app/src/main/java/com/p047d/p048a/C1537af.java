package com.p047d.p048a;

import android.view.View;
import com.p047d.p049b.FloatProperty;
import com.p047d.p050c.p051a.AnimatorProxy;

/* renamed from: com.d.a.af */
/* compiled from: PreHoneycombCompat */
final class C1537af extends FloatProperty<View> {
    /* renamed from: a */
    public final /* synthetic */ Object mo16169a(Object obj) {
        return Float.valueOf(AnimatorProxy.m3396a((View) obj).f3565f);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo16170a(Object obj, float f) {
        AnimatorProxy a = AnimatorProxy.m3396a((View) obj);
        if (a.f3565f != f) {
            a.mo16218a();
            a.f3565f = f;
            a.mo16221b();
        }
    }

    C1537af(String str) {
        super(str);
    }
}
