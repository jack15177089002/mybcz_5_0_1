package com.baicizhan.client.business.auth;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
//import com.sina.weibo.sdk.p064a.Oauth2AccessToken;
//import com.sina.weibo.sdk.p067b.WbAppActivator;
//import com.sina.weibo.sdk.p070d.LogUtil;

public abstract class AbsOpenAPI {
    protected static final String API_SERVER = "https://api.weibo.com/2";
    protected static final String HTTPMETHOD_GET = "GET";
    protected static final String HTTPMETHOD_POST = "POST";
    protected static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String TAG = AbsOpenAPI.class.getName();
//    protected Oauth2AccessToken mAccessToken;
    protected String mAppKey;
    protected Context mContext;

//    public AbsOpenAPI(Context context, String str, Oauth2AccessToken bVar) {
//        this.mContext = context;
//        this.mAppKey = str;
//        this.mAccessToken = bVar;
//    }

    /* access modifiers changed from: protected */
//    public void requestAsync(String str, WeiboParameters jVar, String str2, RequestListener gVar) {
//        if (this.mAccessToken == null || TextUtils.isEmpty(str) || jVar == null || TextUtils.isEmpty(str2) || gVar == null) {
//            LogUtil.m3912c(TAG, "Argument error!");
//            return;
//        }
//        jVar.mo16874a("access_token", this.mAccessToken.f4196a);
//        new AsyncWeiboRunner(this.mContext).mo16858a(str, jVar, str2, gVar);
//    }

    /* access modifiers changed from: protected */
//    public String requestSync(String str, WeiboParameters jVar, String str2) {
//        if (this.mAccessToken == null || TextUtils.isEmpty(str) || jVar == null || TextUtils.isEmpty(str2)) {
//            LogUtil.m3912c(TAG, "Argument error!");
//            return "";
//        }
//        jVar.mo16874a("access_token", this.mAccessToken.f4196a);
//        AsyncWeiboRunner aVar = new AsyncWeiboRunner(this.mContext);
//        WbAppActivator.m3805a(aVar.f4383a, jVar.f4403b).mo16792a();
//        return HttpManager.m3936a(aVar.f4383a, str, str2, jVar);
//    }
}
