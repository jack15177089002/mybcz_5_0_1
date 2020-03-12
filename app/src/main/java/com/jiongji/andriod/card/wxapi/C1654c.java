package com.jiongji.andriod.card.wxapi;

import android.content.ComponentName;
import android.util.Log;
import com.android.volley.Response.Listener;
import com.baicizhan.client.business.util.LogWrapper;
import com.baicizhan.main.auth.ThirdPartyUserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.jiongji.andriod.card.wxapi.c */
/* compiled from: WXEntryActivity */
final class C1654c implements Listener<JSONObject> {

    /* renamed from: a */
    final /* synthetic */ ComponentName f3969a;

    /* renamed from: b */
    final /* synthetic */ String f3970b;

    /* renamed from: c */
    final /* synthetic */ String f3971c;

    /* renamed from: d */
    final /* synthetic */ long f3972d;

    /* renamed from: e */
    final /* synthetic */ WXEntryActivity f3973e;

    C1654c(WXEntryActivity wXEntryActivity, ComponentName componentName, String str, String str2, long j) {
        this.f3973e = wXEntryActivity;
        this.f3969a = componentName;
        this.f3970b = str;
        this.f3971c = str2;
        this.f3972d = j;
    }

    public final /* synthetic */ void onResponse(JSONObject obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (jSONObject.has("errcode")) {
                this.f3973e.m3676a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"), this.f3969a);
                return;
            }
            ThirdPartyUserInfo thirdPartyUserInfo = new ThirdPartyUserInfo();
            thirdPartyUserInfo.provider = "weixin";
            thirdPartyUserInfo.country = jSONObject.getString("country");
            thirdPartyUserInfo.province = jSONObject.getString("province");
            thirdPartyUserInfo.city = jSONObject.getString("city");
            if (jSONObject.getInt("sex") == 1) {
                thirdPartyUserInfo.gender = ThirdPartyUserInfo.GENDER_MALE;
            } else {
                thirdPartyUserInfo.gender = ThirdPartyUserInfo.GENDER_FEMALE;
            }
            thirdPartyUserInfo.nickName = jSONObject.getString("nickname");
            thirdPartyUserInfo.unionid = jSONObject.getString("unionid");
            thirdPartyUserInfo.uid = jSONObject.getString("unionid");
            thirdPartyUserInfo.openid = jSONObject.getString("openid");
            thirdPartyUserInfo.atoken = this.f3970b;
            thirdPartyUserInfo.refreshToken = this.f3971c;
            thirdPartyUserInfo.expireAt = this.f3972d;
            thirdPartyUserInfo.imageUrl = jSONObject.getString("headimgurl");
            thirdPartyUserInfo.loginType = 4;
            LogWrapper.m2793d(WXEntryActivity.f3963a, "userinfo " + thirdPartyUserInfo);
            WXEntryActivity.m3678a(this.f3973e, thirdPartyUserInfo, this.f3969a);
        } catch (JSONException e) {
            LogWrapper.m2794e(WXEntryActivity.f3963a, Log.getStackTraceString(e));
            this.f3973e.m3676a(-1, "网络请求失败", this.f3969a);
        }
    }


}
