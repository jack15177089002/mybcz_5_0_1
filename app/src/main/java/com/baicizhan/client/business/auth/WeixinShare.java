package com.baicizhan.client.business.auth;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.baicizhan.client.business.util.AuthCallback;
import com.baicizhan.client.business.util.LogWrapper;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.ByteArrayOutputStream;

public class WeixinShare {
    private static final String TAG = WeixinShare.class.getSimpleName();
    private static final int THUMB_SIZE = 150;
    public static final int WXSceneSession = 0;
    public static final int WXSceneTimeline = 1;
    private IWXAPI api;
    private AuthCallback<Void> mCallback;
    private Req mReq;

    public WeixinShare(Activity activity, String str, String str2, String str3, Bitmap bitmap, int i, AuthCallback<Void> authCallback) {
        this.mCallback = authCallback;
        this.api = WXAPIFactory.createWXAPI(activity, AuthConstants.WEIXIN_APP_ID, true);
        this.api.registerApp(AuthConstants.WEIXIN_APP_ID);
        if (!this.api.isWXAppInstalled()) {
            if (this.mCallback != null) {
                this.mCallback.postError(new Exception("未安装微信"));
            }
        } else if (i != 1 || this.api.getWXAppSupportAPI() >= 553779201 || this.mCallback == null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = str;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXWebpageObject;
            wXMediaMessage.description = str2;
            wXMediaMessage.title = str3;
            wXMediaMessage.thumbData = bmpToByteArray(Bitmap.createScaledBitmap(bitmap, 150, 150, true), true);
            this.mReq = new Req();
            this.mReq.transaction = AuthConstants.genWeixinTransaction(AuthConstants.WEIXIN_REQ_TYPE_SHARE, activity);
            this.mReq.message = wXMediaMessage;
            this.mReq.scene = i;
        } else {
            this.mCallback.postError(new Exception("您的微信版本不支持朋友圈功能"));
        }
    }

    public void share() {
        if (this.mReq != null) {
            this.api.sendReq(this.mReq);
        }
    }

    public void onNewIntent(Intent intent) {
        LogWrapper.m2793d(TAG, "*** onNewIntent " + intent);
        if (!intent.hasExtra(AuthConstants.EXTRA_WEIXIN_RESULT)) {
            LogWrapper.m2793d(TAG, "not intent for me");
            return;
        }
        int intExtra = intent.getIntExtra(AuthConstants.EXTRA_WEIXIN_RESULT, 0);
        if (intExtra != 0) {
            String stringExtra = intent.getStringExtra(AuthConstants.EXTRA_WEIXIN_ERRMSG);
            if (intExtra != -2 && this.mCallback != null) {
                this.mCallback.postError(new Exception(stringExtra));
            }
        } else if (this.mCallback != null) {
            this.mCallback.postSuccess(null);
        }
    }

    private static byte[] bmpToByteArray(Bitmap bitmap, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (z) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArray;
    }
}
