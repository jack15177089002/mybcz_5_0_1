//package com.baicizhan.main.auth;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.util.Log;
//import com.baicizhan.client.business.auth.AuthConstants;
//import com.baicizhan.client.business.auth.UsersAPI;
//import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.main.utils.CommonUtils;
//import com.sina.weibo.sdk.net.RequestListener;
//import com.sina.weibo.sdk.p064a.AuthInfo;
//import com.sina.weibo.sdk.p064a.Oauth2AccessToken;
//import com.sina.weibo.sdk.p064a.WeiboAuthListener;
//import com.sina.weibo.sdk.p064a.p065a.SsoHandler;
//import com.sina.weibo.sdk.p068c.WeiboException;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class WeiboLogin {
//    /* access modifiers changed from: private */
//    public static final String TAG = WeiboLogin.class.getSimpleName();
//    private Activity mActivity;
//    /* access modifiers changed from: private */
//    public AuthCallback<ThirdPartyUserInfo> mCallback;
//    private SsoHandler mSsoHandler;
//
//    public WeiboLogin(Activity activity, AuthCallback<ThirdPartyUserInfo> authCallback) {
//        this.mActivity = activity;
//        this.mCallback = authCallback;
//    }
//
//    public void auth() {
//        ThirdPartyUserInfo thirdPartyLoginCache = CommonUtils.getThirdPartyLoginCache(this.mActivity);
//        if (thirdPartyLoginCache == null || thirdPartyLoginCache.isExpired() || thirdPartyLoginCache.loginType != 1) {
//            reAuth();
//        } else {
//            this.mCallback.postSuccess(thirdPartyLoginCache);
//        }
//    }
//
//    public void authBack(int i, int i2, Intent intent) {
//        if (this.mSsoHandler != null) {
//            try {
//                this.mSsoHandler.mo16761a(i, i2, intent);
//            } catch (Exception e) {
//                if (this.mCallback != null) {
//                    this.mCallback.postError(e);
//                }
//            }
//        }
//    }
//
//    private void reAuth() {
//        try {
//            LogWrapper.m2793d(TAG, "++++ weibo reAuth");
//            System.setProperty("weibo4j.oauth.consumerKey", AuthConstants.CONSUMER_KEY);
//            System.setProperty("weibo4j.oauth.consumerSecret", AuthConstants.CONSUMER_SECRET);
//            this.mSsoHandler = new SsoHandler(this.mActivity, new AuthInfo(this.mActivity, AuthConstants.CONSUMER_KEY, AuthConstants.REDIRECT_URL, AuthConstants.SCOPE));
//            LogWrapper.m2793d(TAG, "++++ start authorize");
//            this.mSsoHandler.mo16762a(new WeiboAuthListener() {
//                public void onWeiboException(WeiboException cVar) {
//                    LogWrapper.m2793d(WeiboLogin.TAG, "onWeiboException " + cVar);
//                    WeiboLogin.this.mCallback.postError(cVar);
//                }
//
//                public void onComplete(Bundle bundle) {
//                    LogWrapper.m2793d(WeiboLogin.TAG, "onComplete " + bundle);
//                    String string = bundle.getString("uid");
//                    String string2 = bundle.getString(BaicizhanCookieInflator.ACCESS_TOKEN);
//                    String string3 = bundle.getString("expires_in");
//                    if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string)) {
//                        LogWrapper.m2794e(WeiboLogin.TAG, "token or uid null " + string2 + ", " + string);
//                        if (WeiboLogin.this.mCallback != null) {
//                            WeiboLogin.this.mCallback.postError(new Exception("验证失败"));
//                            return;
//                        }
//                        return;
//                    }
//                    try {
//                        WeiboLogin.this.getWeiboUserInfo(Long.parseLong(string), string2, string3);
//                    } catch (Exception e) {
//                        if (WeiboLogin.this.mCallback != null) {
//                            WeiboLogin.this.mCallback.postError(e);
//                        }
//                    }
//                }
//
//                public void onCancel() {
//                    LogWrapper.m2793d(WeiboLogin.TAG, "onWeiboException onCancel");
//                    if (WeiboLogin.this.mCallback != null) {
//                        WeiboLogin.this.mCallback.postError(new Exception("Auth canceled"));
//                    }
//                }
//            });
//        } catch (Exception e) {
//            if (this.mCallback != null) {
//                this.mCallback.postError(e);
//            }
//        }
//    }
//
//    public void getWeiboUserInfo(long j, String str, String str2) {
//        try {
//            LogWrapper.m2793d(TAG, "+++ getWeiboUserInfo " + j + ", " + str + ", " + str2);
//            UsersAPI usersAPI = new UsersAPI(this.mActivity, AuthConstants.CONSUMER_KEY, new Oauth2AccessToken(str, str2));
//            final ThirdPartyUserInfo thirdPartyUserInfo = new ThirdPartyUserInfo();
//            thirdPartyUserInfo.provider = "weibo";
//            thirdPartyUserInfo.uid = Long.toString(j);
//            thirdPartyUserInfo.atoken = str;
//            thirdPartyUserInfo.setExpireIn(str2);
//            usersAPI.show(j, (RequestListener) new RequestListener() {
//                public void onComplete(String str) {
//                    if (!TextUtils.isEmpty(str)) {
//                        try {
//                            JSONObject jSONObject = new JSONObject(str);
//                            if (jSONObject.has("city")) {
//                                thirdPartyUserInfo.city = jSONObject.getString("city");
//                            }
//                            if (jSONObject.has("screen_name")) {
//                                thirdPartyUserInfo.nickName = jSONObject.getString("screen_name");
//                            }
//                            if (jSONObject.has("avatar_hd")) {
//                                thirdPartyUserInfo.imageUrl = jSONObject.getString("avatar_hd");
//                            }
//                            if (jSONObject.has("gendar")) {
//                                thirdPartyUserInfo.gender = jSONObject.getString("gender");
//                            }
//                            thirdPartyUserInfo.loginType = 1;
//                            if (WeiboLogin.this.mCallback != null) {
//                                WeiboLogin.this.mCallback.postSuccess(thirdPartyUserInfo);
//                            }
//                        } catch (JSONException e) {
//                            if (WeiboLogin.this.mCallback != null) {
//                                WeiboLogin.this.mCallback.postError(e);
//                            }
//                        }
//                    } else if (WeiboLogin.this.mCallback != null) {
//                        WeiboLogin.this.mCallback.postError(new Exception("onComplete empty"));
//                    }
//                }
//
//                public void onWeiboException(WeiboException cVar) {
//                    LogWrapper.m2794e(WeiboLogin.TAG, Log.getStackTraceString(cVar));
//                    if (WeiboLogin.this.mCallback != null) {
//                        WeiboLogin.this.mCallback.postError(cVar);
//                    }
//                }
//            });
//        } catch (Exception e) {
//            LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//            if (this.mCallback != null) {
//                this.mCallback.postError(e);
//            }
//        }
//    }
//}
