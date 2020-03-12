package com.jiongji.andriod.card.wxapi;

import android.content.ComponentName;
import android.util.Log;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.baicizhan.client.business.util.LogWrapper;

/* renamed from: com.jiongji.andriod.card.wxapi.b */
/* compiled from: WXEntryActivity */
final class C1653b implements ErrorListener {

    /* renamed from: a */
    final /* synthetic */ ComponentName f3967a;

    /* renamed from: b */
    final /* synthetic */ WXEntryActivity f3968b;

    C1653b(WXEntryActivity wXEntryActivity, ComponentName componentName) {
        this.f3968b = wXEntryActivity;
        this.f3967a = componentName;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        LogWrapper.m2794e(WXEntryActivity.f3963a, Log.getStackTraceString(volleyError));
        this.f3968b.m3676a(-1, "网络请求失败", this.f3967a);
    }
}
