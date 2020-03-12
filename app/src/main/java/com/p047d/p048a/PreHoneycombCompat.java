package com.p047d.p048a;

import android.view.View;
import com.p047d.p049b.FloatProperty;
import com.p047d.p050c.p051a.AnimatorProxy;

/* renamed from: com.d.a.aa */
final class PreHoneycombCompat extends FloatProperty<View> {
    /* renamed from: a */
    public final /* synthetic */ Object mo16169a(Object obj) {
        return Float.valueOf(AnimatorProxy.m3396a((View) obj).f3563d);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo16170a(Object obj, float f) {
        AnimatorProxy.m3396a((View) obj).mo16222b(f);
    }

    PreHoneycombCompat(String str) {
        super(str);
    }
}
