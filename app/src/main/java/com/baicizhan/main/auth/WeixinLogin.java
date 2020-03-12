package com.baicizhan.main.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.android.volley.toolbox.RequestFuture;
import com.baicizhan.client.business.auth.AuthConstants;
import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
import com.baicizhan.client.business.util.AuthCallback;
import com.baicizhan.client.business.util.DeviceUtil;
import com.baicizhan.client.business.util.LogWrapper;
import com.baicizhan.client.framework.network.JsonObjectRequest;
import com.baicizhan.client.framework.network.VolleyUtils;
//import com.baicizhan.main.utils.CommonUtils;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class WeixinLogin {
    private static final String TAG = WeixinLogin.class.getSimpleName();
    public static ThirdPartyUserInfo sLastLoginInfo = null;
    private static IWXAPI sWXAPI;
    /* access modifiers changed from: private */
    public Activity mActivity;
    private AuthCallback<ThirdPartyUserInfo> mCallback;
    private WeixinLoginHandler mWeixinLoginHandler = new WeixinLoginHandler();
    /* access modifiers changed from: private */
    public boolean mWeixinLogining;

    class WeixinLoginHandler extends Handler {
        final WeakReference<WeixinLogin> mLogin;

        private WeixinLoginHandler(WeixinLogin weixinLogin) {
            this.mLogin = new WeakReference<>(weixinLogin);
        }

        public WeixinLoginHandler() {
            this.mLogin = null;
        }

        public void handleMessage(Message message) {
            WeixinLogin weixinLogin = (WeixinLogin) this.mLogin.get();
            if (weixinLogin != null) {
                if (1 == weixinLogin.mActivity.getResources().getConfiguration().orientation) {
                    weixinLogin.mWeixinLogining = true;
                    weixinLogin.doAuth();
                    return;
                }
                weixinLogin.doPostAuth();
            }
        }
    }

    public static void clearLastLoginInfo() {
        sLastLoginInfo = null;
    }

    public static void putLastLoginInfo(ThirdPartyUserInfo thirdPartyUserInfo) {
        sLastLoginInfo = thirdPartyUserInfo;
    }

    public static ThirdPartyUserInfo takeLastLoginInfo() {
        ThirdPartyUserInfo thirdPartyUserInfo = sLastLoginInfo;
        sLastLoginInfo = null;
        return thirdPartyUserInfo;
    }

    public WeixinLogin(Activity activity, AuthCallback<ThirdPartyUserInfo> authCallback) {
        this.mActivity = activity;
        this.mCallback = authCallback;
    }

    private static void ensureAPI(Context context) {
        if (sWXAPI == null) {
            synchronized (WeixinLogin.class) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context.getApplicationContext(), AuthConstants.WEIXIN_APP_ID);
                sWXAPI = createWXAPI;
                createWXAPI.registerApp(AuthConstants.WEIXIN_APP_ID);
            }
        }
    }

    public static boolean isInstalled(Context context) {
        ensureAPI(context);
        return sWXAPI.isWXAppInstalled();
    }

    public void doAuth() {
        if (!isInstalled(this.mActivity)) {
            this.mCallback.postError(new Exception("未安装微信"));
            return;
        }
//        ThirdPartyUserInfo thirdPartyLoginCache = CommonUtils.getThirdPartyLoginCache(this.mActivity);
//        if (thirdPartyLoginCache == null || thirdPartyLoginCache.isExpired() || thirdPartyLoginCache.loginType != 4) {
//            reAuth();
//        } else {
//            this.mCallback.postSuccess(thirdPartyLoginCache);
//        }
    }

    public void reAuth() {
        ensureAPI(this.mActivity);
        Req req = new Req();
        req.transaction = AuthConstants.genWeixinTransaction(AuthConstants.WEIXIN_REQ_TYPE_AUTH, this.mActivity);
        req.scope = "snsapi_userinfo";
        sWXAPI.sendReq(req);
        LogWrapper.m2793d(TAG, "+++ auth sendReq " + req);
    }

    public static boolean waitRefreshAccessToken(ThirdPartyUserInfo thirdPartyUserInfo) {
        if (TextUtils.isEmpty(thirdPartyUserInfo.refreshToken)) {
            LogWrapper.m2793d(TAG, "waitRefreshAccessToken refreshToken null");
            return false;
        }
        String str = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=wxce5d9e837051d623&grant_type=refresh_token&refresh_token=" + thirdPartyUserInfo.refreshToken;
        RequestFuture newFuture = RequestFuture.newFuture();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(str, null, newFuture, newFuture);
        newFuture.setRequest(jsonObjectRequest);
        VolleyUtils.send(jsonObjectRequest);
        try {
            JSONObject jSONObject = (JSONObject) newFuture.get(10, TimeUnit.SECONDS);
            LogWrapper.m2793d(TAG, "refresh_token resp: " + jSONObject.toString());
            if (jSONObject.has("errcode")) {
                return false;
            }
            thirdPartyUserInfo.atoken = jSONObject.getString(BaicizhanCookieInflator.ACCESS_TOKEN);
            thirdPartyUserInfo.refreshToken = jSONObject.getString("refresh_token");
            thirdPartyUserInfo.setExpireIn(jSONObject.getString("expires_in"));
            thirdPartyUserInfo.openid = jSONObject.getString("openid");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void onNewIntent(Intent intent) {
        if (intent.hasExtra(AuthConstants.EXTRA_WEIXIN_RESULT)) {
            Serializable serializableExtra = intent.getSerializableExtra(AuthConstants.EXTRA_WEIXIN_USER_INFO);
            if (serializableExtra != null) {
                this.mCallback.postSuccess((ThirdPartyUserInfo) serializableExtra);
                return;
            }
            this.mCallback.postError(new Exception(intent.getStringExtra(AuthConstants.EXTRA_WEIXIN_ERRMSG)));
        }
    }

    public void resume() {
        if (this.mWeixinLogining) {
            this.mWeixinLogining = false;
            this.mActivity.setRequestedOrientation(0);
        }
    }

    public void cancel() {
        if (this.mWeixinLoginHandler != null) {
            this.mWeixinLoginHandler.removeMessages(0);
        }
    }

    public void auth(boolean z) {
        if (!needPost() || z) {
            doAuth();
            return;
        }
        this.mActivity.setRequestedOrientation(1);
        doPostAuth();
    }

    private static boolean needPost() {
        return DeviceUtil.isMeizu();
    }

    /* access modifiers changed from: private */
    public void doPostAuth() {
        this.mWeixinLoginHandler.sendEmptyMessageDelayed(0, 300);
    }
}
