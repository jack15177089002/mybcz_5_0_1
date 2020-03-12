package com.jiongji.andriod.card.wxapi;

import android.content.ComponentName;
import android.util.Log;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.baicizhan.client.business.util.LogWrapper;

/* renamed from: com.jiongji.andriod.card.wxapi.d */
/* compiled from: WXEntryActivity */
final class C1655d implements ErrorListener {

    /* renamed from: a */
    final /* synthetic */ ComponentName f3974a;

    /* renamed from: b */
    final /* synthetic */ WXEntryActivity f3975b;

    C1655d(WXEntryActivity wXEntryActivity, ComponentName componentName) {
        this.f3975b = wXEntryActivity;
        this.f3974a = componentName;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        LogWrapper.m2794e(WXEntryActivity.f3963a, Log.getStackTraceString(volleyError));
        this.f3975b.m3676a(-1, "网络请求失败", this.f3974a);
    }
}
