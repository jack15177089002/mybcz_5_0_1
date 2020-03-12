package com.jiongji.andriod.card.wxapi;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baicizhan.client.business.auth.AuthConstants;
import com.baicizhan.client.business.util.LogWrapper;
import com.baicizhan.client.framework.network.JsonObjectRequest;
import com.baicizhan.client.framework.network.VolleyUtils;
import com.baicizhan.main.auth.ThirdPartyUserInfo;
import com.baicizhan.main.auth.WeixinLogin;
import com.jiongji.andriod.card.R;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f3963a = WXEntryActivity.class.getSimpleName();

    /* renamed from: b */
    private IWXAPI f3964b;

    /* renamed from: a */
    static /* synthetic */ void m3678a(WXEntryActivity wXEntryActivity, ThirdPartyUserInfo thirdPartyUserInfo, ComponentName componentName) {
        WeixinLogin.putLastLoginInfo(thirdPartyUserInfo);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.putExtra(AuthConstants.EXTRA_WEIXIN_RESULT, 0);
        intent.putExtra(AuthConstants.EXTRA_WEIXIN_USER_INFO, thirdPartyUserInfo);
//        intent.setFlags(67108864);
        wXEntryActivity.startActivity(intent);
        wXEntryActivity.finish();
    }

    /* renamed from: a */
    static /* synthetic */ void m3679a(WXEntryActivity wXEntryActivity, String str, String str2, String str3, long j, ComponentName componentName) {
        String str4 = "https://api.weixin.qq.com/sns/userinfo?access_token=" + str + "&openid=" + str3;
        LogWrapper.m2795i(f3963a, "onGetAccessToken url " + str4);
        VolleyUtils.send(new JsonObjectRequest(str4, null, new C1654c(wXEntryActivity, componentName, str, str2, j), new C1655d(wXEntryActivity, componentName)));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(R.style.StandardDefault);
        setContentView(R.layout.activity_wxentry);
        Log.d(f3963a, "+++ WXEntryActivity onCreate");
        LogWrapper.m2793d(f3963a, "+++ WXEntryActivity onCreate");
        this.f3964b = WXAPIFactory.createWXAPI(this, AuthConstants.WEIXIN_APP_ID, false);
        this.f3964b.handleIntent(getIntent(), this);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogWrapper.m2793d(f3963a, "onNewIntent " + intent);
        setIntent(intent);
        this.f3964b.handleIntent(intent, this);
    }

    public void onReq(BaseReq baseReq) {
        LogWrapper.m2793d(f3963a, "onReq " + baseReq.toString());
        switch (baseReq.getType()) {
            case 3:
                LogWrapper.m2793d(f3963a, "onReq COMMAND_GETMESSAGE_FROM_WX");
                return;
            case 4:
                LogWrapper.m2793d(f3963a, "onReq COMMAND_SHOWMESSAGE_FROM_WX");
                return;
            default:
                LogWrapper.m2793d(f3963a, "onReq null");
                return;
        }
    }

    public void onResp(BaseResp baseResp) {
        LogWrapper.m2793d(f3963a, "+++ onResp " + baseResp.toString() + ", " + baseResp.errCode + ", " + baseResp.errCode + ", " + baseResp.transaction);
        String str = baseResp.transaction;
        int indexOf = str.indexOf(45);
        String str2 = "";
        String str3 = "";
        if (indexOf >= 0) {
            str2 = str.substring(0, indexOf);
            str3 = str.substring(indexOf + 1);
        }
        ComponentName unflattenFromString = ComponentName.unflattenFromString(str3);
        if (str2.equals(AuthConstants.WEIXIN_REQ_TYPE_SHARE)) {
            m3676a(baseResp.errCode, baseResp.errStr, unflattenFromString);
        } else if (!str2.equals(AuthConstants.WEIXIN_REQ_TYPE_AUTH)) {
            m3676a(baseResp.errCode, baseResp.errStr, unflattenFromString);
            finish();
        } else if (baseResp.errCode != 0) {
            m3676a(baseResp.errCode, baseResp.errStr, unflattenFromString);
        } else if (baseResp instanceof Resp) {
            VolleyUtils.send(new JsonObjectRequest("https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxce5d9e837051d623&secret=25a18bdaf8119c58c11b3c8fc1a6b6af&code=" + ((Resp) baseResp).code + "&grant_type=authorization_code", null, new C1652a(this, unflattenFromString), new C1653b(this, unflattenFromString)));
        } else {
            m3676a(-4, "微信验证失败，请稍后重试", unflattenFromString);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3676a(int i, String str, ComponentName componentName) {
        LogWrapper.m2793d(f3963a, "back " + i + ", " + str + ", " + componentName);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.putExtra(AuthConstants.EXTRA_WEIXIN_RESULT, i);
        intent.putExtra(AuthConstants.EXTRA_WEIXIN_ERRMSG, str);
//        intent.setFlags(67108864);
        startActivity(intent);
        finish();
    }
}
