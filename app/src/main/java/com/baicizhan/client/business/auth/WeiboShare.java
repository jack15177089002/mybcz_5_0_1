package com.baicizhan.client.business.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
import com.baicizhan.client.business.util.AuthCallback;
import com.sina.weibo.sdk.net.RequestListener;
//import com.sina.weibo.sdk.p064a.AuthInfo;
//import com.sina.weibo.sdk.p064a.Oauth2AccessToken;
//import com.sina.weibo.sdk.p064a.WeiboAuthListener;
//import com.sina.weibo.sdk.p064a.p065a.SsoHandler;
//import com.sina.weibo.sdk.p068c.WeiboException;

public class WeiboShare {
    private Activity mActivity;
    /* access modifiers changed from: private */
    public AuthCallback<Void> mCallback;
    /* access modifiers changed from: private */
    public String mShareText = "";
    /* access modifiers changed from: private */
    public String mShareUrl = "";
//    private SsoHandler mSsoHandler = null;

    public WeiboShare(Activity activity, String str, String str2, AuthCallback<Void> authCallback) {
        this.mActivity = activity;
        this.mShareUrl = str;
        this.mShareText = str2;
        this.mCallback = authCallback;
    }

    public void share() {
//        try {
//            this.mSsoHandler = new SsoHandler(this.mActivity, new AuthInfo(this.mActivity, AuthConstants.CONSUMER_KEY, AuthConstants.REDIRECT_URL, AuthConstants.SCOPE));
//            this.mSsoHandler.mo16762a(new WeiboAuthListener() {
//                public void onComplete(Bundle bundle) {
//                    String string = bundle.getString(BaicizhanCookieInflator.ACCESS_TOKEN);
//                    String string2 = bundle.getString("expires_in");
//                    if (string != null) {
//                        try {
//                            WeiboShare.this.upload(WeiboShare.this.mShareUrl, WeiboShare.this.mShareText, string, string2);
//                        } catch (Exception e) {
//                            if (WeiboShare.this.mCallback != null) {
//                                WeiboShare.this.mCallback.postError(e);
//                            }
//                        }
//                    } else {
//                        WeiboShare.this.mCallback.postError(new Exception("token null"));
//                    }
//                }
//
//                public void onCancel() {
//                    if (WeiboShare.this.mCallback != null) {
//                        WeiboShare.this.mCallback.postError(new Exception("Auth cancel"));
//                    }
//                }
//
//                public void onWeiboException(WeiboException cVar) {
//                    if (WeiboShare.this.mCallback != null) {
//                        WeiboShare.this.mCallback.postError(cVar);
//                    }
//                }
//            });
//        } catch (Exception e) {
//            if (this.mCallback != null) {
//                this.mCallback.postError(e);
//            }
//        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
//        if (this.mSsoHandler != null) {
//            try {
//                this.mSsoHandler.mo16761a(i, i2, intent);
//            } catch (Exception e) {
//                if (this.mCallback != null) {
//                    this.mCallback.postError(e);
//                }
//            }
//        }
    }

    /* access modifiers changed from: private */
    public void upload(String str, String str2, String str3, String str4) {
//        Oauth2AccessToken bVar = new Oauth2AccessToken(str3, str4);
//        String str5 = str2;
//        String str6 = str;
//        new StatusesAPI(this.mActivity, AuthConstants.CONSUMER_KEY, bVar).uploadUrlText(str5, str6, "", "", "", new RequestListener() {
//            public void onComplete(String str) {
//                if (WeiboShare.this.mCallback != null) {
//                    WeiboShare.this.mCallback.postSuccess(null);
//                }
//            }
//
//            public void onWeiboException(WeiboException cVar) {
//                if (WeiboShare.this.mCallback != null) {
//                    WeiboShare.this.mCallback.postError(cVar);
//                }
//            }
//        });
    }
}
