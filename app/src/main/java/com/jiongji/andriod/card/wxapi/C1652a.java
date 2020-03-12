package com.jiongji.andriod.card.wxapi;

import android.content.ComponentName;
import android.util.Log;
import com.android.volley.Response.Listener;
import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
import com.baicizhan.client.business.util.LogWrapper;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.jiongji.andriod.card.wxapi.a */
/* compiled from: WXEntryActivity */
final class C1652a implements Listener<JSONObject> {

    /* renamed from: a */
    final /* synthetic */ ComponentName f3965a;

    /* renamed from: b */
    final /* synthetic */ WXEntryActivity f3966b;

    C1652a(WXEntryActivity wXEntryActivity, ComponentName componentName) {
        this.f3966b = wXEntryActivity;
        this.f3965a = componentName;
    }

    public final /* synthetic */ void onResponse(JSONObject obj) {
        long j;
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (jSONObject.has("errcode")) {
                this.f3966b.m3676a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"), this.f3965a);
                return;
            }
            LogWrapper.m2793d(WXEntryActivity.f3963a, "getAccessToken " + jSONObject);
            String string = jSONObject.getString(BaicizhanCookieInflator.ACCESS_TOKEN);
            String string2 = jSONObject.getString("openid");
            try {
                j = TimeUnit.SECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS) + Long.valueOf(jSONObject.getString("expires_in")).longValue();
            } catch (NumberFormatException e) {
                j = 0;
            }
            WXEntryActivity.m3679a(this.f3966b, string, jSONObject.getString("refresh_token"), string2, j, this.f3965a);
        } catch (JSONException e2) {
            LogWrapper.m2794e(WXEntryActivity.f3963a, Log.getStackTraceString(e2));
            this.f3966b.m3676a(-1, "获取token失败", this.f3965a);
        }
    }


}
