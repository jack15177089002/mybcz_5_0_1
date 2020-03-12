//package com.baicizhan.main.auth;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.util.Log;
//import android.webkit.CookieSyncManager;
//import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.main.utils.CommonUtils;
//import com.renren.api.connect.android.AsyncRenren;
//import com.renren.api.connect.android.C1674g;
//import com.renren.api.connect.android.Renren;
//import com.renren.api.connect.android.Util;
//import com.renren.api.connect.android.p059a.AbstractRequestListener;
//import com.renren.api.connect.android.p060b.RenrenAuthError;
//import com.renren.api.connect.android.p060b.RenrenError;
//import com.renren.api.connect.android.p061c.C1664a;
//import com.renren.api.connect.android.p061c.C1669g;
//import com.renren.api.connect.android.p061c.UsersGetInfoHelper;
//import com.renren.api.connect.android.p061c.UsersGetInfoRequestParam;
//import com.renren.api.connect.android.p061c.UsersGetInfoResponseBean;
//import com.renren.api.connect.android.p062d.RenrenAuthListener;
//import com.renren.api.connect.android.p062d.RenrenDialog;
//import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;
//import p012ch.qos.logback.core.joran.action.Action;
//
//public class RenrenLogin {
//    private static final String API_KEY = "2985039411564842bdd4af9fe74d4d1c";
//    private static final String APP_ID = "205943";
//    private static final String SECRET_KEY = "6bee22e76d4a48f7bca0ae0ee534353a";
//    /* access modifiers changed from: private */
//    public static final String TAG = RenrenLogin.class.getSimpleName();
//    Activity mActivity;
//    AuthCallback<ThirdPartyUserInfo> mCallback;
//    Renren mRenren = new Renren(API_KEY, SECRET_KEY, APP_ID, this.mActivity);
//
//    public RenrenLogin(Activity activity, AuthCallback<ThirdPartyUserInfo> authCallback) {
//        this.mActivity = activity;
//        this.mCallback = authCallback;
//    }
//
//    public void auth() {
//        ThirdPartyUserInfo thirdPartyLoginCache = CommonUtils.getThirdPartyLoginCache(this.mActivity);
//        if (thirdPartyLoginCache == null || thirdPartyLoginCache.isExpired() || thirdPartyLoginCache.loginType != 2) {
//            reAuth();
//        } else {
//            this.mCallback.postSuccess(thirdPartyLoginCache);
//        }
//    }
//
//    private void reAuth() {
//        try {
//            Renren renren = this.mRenren;
//            Util.m3754a((Context) this.mActivity);
//            renren.f4042c.mo16676a();
//            this.mRenren.mo16683a((Context) this.mActivity);
//            Renren renren2 = this.mRenren;
//            Activity activity = this.mActivity;
//            C10871 r2 = new RenrenAuthListener() {
//                public void onComplete(Bundle bundle) {
//                    Log.d(RenrenLogin.TAG, "+++ renren onComplete " + bundle);
//                    String string = bundle.getString(BaicizhanCookieInflator.ACCESS_TOKEN);
//                    int lastIndexOf = string.lastIndexOf("-");
//                    String str = (lastIndexOf <= 0 || lastIndexOf >= string.length()) ? "" : string.substring(lastIndexOf + 1);
//                    String string2 = bundle.getString("expires_in");
//                    if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(str)) {
//                        RenrenLogin.this.mCallback.postError(new Exception("onComplete error"));
//                    } else {
//                        RenrenLogin.this.getUserInfo(str, string, Long.valueOf(string2).longValue() + TimeUnit.SECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS));
//                    }
//                }
//
//                public void onRenrenAuthError(RenrenAuthError aVar) {
//                    RenrenLogin.this.mCallback.postError(aVar);
//                }
//
//                public void onCancelLogin() {
//                    RenrenLogin.this.mCallback.postError(new Exception("Login canceled"));
//                }
//
//                public void onCancelAuth(Bundle bundle) {
//                    RenrenLogin.this.mCallback.postError(new Exception("Auth canceled"));
//                }
//            };
//            if (renren2.mo16684a()) {
//                r2.onComplete(new Bundle());
//                return;
//            }
//            C1674g gVar = new C1674g(r2, "http://graph.renren.com/oauth/login_success.html", renren2);
//            CookieSyncManager.createInstance(activity);
//            Bundle bundle = new Bundle();
//            bundle.putString("client_id", renren2.f4041b);
//            bundle.putString("redirect_uri", "http://graph.renren.com/oauth/login_success.html");
//            bundle.putString("response_type", "token");
//            bundle.putString("display", "touch");
//            String[] strArr = Renren.f4040a;
//            if (strArr != null && strArr.length > 0) {
//                bundle.putString(Action.SCOPE_ATTRIBUTE, TextUtils.join(" ", strArr));
//            }
//            String str = "https://graph.renren.com/oauth/authorize?" + Util.m3750a(bundle);
//            if (activity.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
//                Util.m3755a((Context) activity, "没有权限", "应用需要访问互联网的权限");
//            } else {
//                new RenrenDialog(activity, str, gVar).show();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void getUserInfo(String str, final String str2, final long j) {
//        Log.d(TAG, "getUserInfo " + str);
//        UsersGetInfoRequestParam hVar = new UsersGetInfoRequestParam(str.split(","));
//        hVar.f4087b = "uid,name,sex,mainurl,headurl";
//        C10882 r0 = new AbstractRequestListener<UsersGetInfoResponseBean>() {
//            public void onComplete(UsersGetInfoResponseBean iVar) {
//                ArrayList<C1664a> arrayList = iVar.f4088a;
//                if (arrayList == null || arrayList.size() == 0) {
//                    RenrenLogin.this.mCallback.postError(new Exception("getUserInfo empty"));
//                    return;
//                }
//                C1664a aVar = (C1664a) arrayList.get(0);
//                ThirdPartyUserInfo thirdPartyUserInfo = new ThirdPartyUserInfo();
//                thirdPartyUserInfo.provider = "renren";
//                thirdPartyUserInfo.uid = Long.toString(aVar.f4055a);
//                thirdPartyUserInfo.nickName = aVar.f4056b;
//                thirdPartyUserInfo.atoken = str2;
//                thirdPartyUserInfo.expireAt = j;
//                String str = aVar.f4059e;
//                String str2 = aVar.f4058d;
//                if (!TextUtils.isEmpty(str)) {
//                    str2 = str;
//                }
//                thirdPartyUserInfo.imageUrl = str2;
//                if (aVar.f4057c == 1) {
//                    thirdPartyUserInfo.gender = ThirdPartyUserInfo.GENDER_MALE;
//                } else {
//                    thirdPartyUserInfo.gender = ThirdPartyUserInfo.GENDER_FEMALE;
//                }
//                thirdPartyUserInfo.loginType = 2;
//                RenrenLogin.this.mCallback.postSuccess(thirdPartyUserInfo);
//            }
//
//            public void onRenrenError(RenrenError bVar) {
//                RenrenLogin.this.mCallback.postError(bVar);
//            }
//
//            public void onFault(Throwable th) {
//                RenrenLogin.this.mCallback.postError(th);
//            }
//        };
//        AsyncRenren dVar = new AsyncRenren(this.mRenren);
//        dVar.f4090b.execute(new C1669g(new UsersGetInfoHelper(dVar.f4089a), hVar, r0));
//    }
//}
