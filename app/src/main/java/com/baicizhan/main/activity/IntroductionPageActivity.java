//package com.baicizhan.main.activity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.res.Resources;
//import android.os.Bundle;
//import android.support.p004v4.app.Fragment;
//import android.support.p004v4.app.FragmentActivity;
//import android.text.TextUtils;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.ColorStateListUtils;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.business.widget.RoundedButton;
//import com.baicizhan.main.auth.RenrenLogin;
//import com.baicizhan.main.auth.ThirdPartyUserInfo;
//import com.baicizhan.main.auth.WeiboLogin;
//import com.baicizhan.main.auth.WeixinLogin;
//import com.baicizhan.main.fragment.ElseLoginFragment;
//import com.baicizhan.main.fragment.ElseLoginFragment.OnElseLoginListener;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.online.bs_users.BBCreateTryResult;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.baicizhan.online.structs.BELogicException;
//import com.jiongji.andriod.card.R;
//import org.p100a.p101a.p107f.C2120g;
//import p012ch.qos.logback.core.spi.AbstractComponentTracker;
//
//public class IntroductionPageActivity extends FragmentActivity implements OnClickListener, OnElseLoginListener {
//    public static final String EXTRA_KEY_LAST_ACCOUNT = "extra_last_account";
//    public static final String EXTRA_KEY_LAST_ACCOUNT_NAME = "extra_last_account_name";
//    private static final int MAX_LOGIN_LOCK_TIME = 10000;
//    private static final int REQUEST_CODE_EMAIL_LOGIN = 1;
//    /* access modifiers changed from: private */
//    public static final String TAG = IntroductionPageActivity.class.getSimpleName();
//    private AuthCallback<ThirdPartyUserInfo> mAuthCallback = new AuthCallback<ThirdPartyUserInfo>() {
//        /* access modifiers changed from: protected */
//        public void onSuccess(ThirdPartyUserInfo thirdPartyUserInfo) {
//            LogWrapper.m2795i(IntroductionPageActivity.TAG, "third party auth success: " + thirdPartyUserInfo);
//            UserRecord thirdPartyInfoToUserRecord = CommonUtils.thirdPartyInfoToUserRecord(thirdPartyUserInfo);
//            CommonUtils.saveThirdPartyLoginCache(IntroductionPageActivity.this, thirdPartyUserInfo);
//            IntroductionPageActivity.this.onThirdPartyAuthPassed(thirdPartyInfoToUserRecord);
//        }
//
//        /* access modifiers changed from: protected */
//        public void onError(Throwable th) {
//            IntroductionPageActivity.this.releaseLoginLock();
//            LogWrapper.m2797w(IntroductionPageActivity.TAG, "third party auth failed: " + th.getMessage());
//            CommonUtils.clearThirdPartyLoginCache(IntroductionPageActivity.this);
//            Toast.makeText(IntroductionPageActivity.this, "认证失败 " + th.getMessage(), 0).show();
//        }
//    };
//    private String mLastAccount;
//    private long mLastLoginLockTime = 0;
//    private boolean mLoginLock = false;
//    /* access modifiers changed from: private */
//    public BczLoadingDialog mProgressDialog;
//    private RenrenLogin mRenrenLogin;
//    private WeiboLogin mWeiboLogin;
//    private WeixinLogin mWeixinLogin;
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        LogWrapper.m2793d(TAG, "IntroductionPageActivity onCreate");
//        setTheme(R.style.StandardDefault);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.activity_introduction_page);
//            Settings.putLong(Settings.PREF_LAST_USER_INFO_TIME, 0);
//            RoundedButton roundedButton = (RoundedButton) findViewById(R.id.login_weixin);
//            RoundedButton roundedButton2 = (RoundedButton) findViewById(R.id.login_email);
//            View findViewById = findViewById(R.id.register);
//            roundedButton.setOnClickListener(this);
//            roundedButton2.setOnClickListener(this);
//            findViewById.setOnClickListener(this);
//            if (WeixinLogin.isInstalled(this)) {
//                roundedButton.setVisibility(0);
//                findViewById.setVisibility(8);
//            } else {
//                roundedButton.setVisibility(8);
//                findViewById.setVisibility(0);
//            }
//            findViewById(R.id.login_else).setOnClickListener(this);
//            findViewById(R.id.login_try).setOnClickListener(this);
//            Resources resources = getResources();
//            roundedButton.setFillColor(ColorStateListUtils.getSimpleColorStateList(resources.getColor(R.color.C41), resources.getColor(R.color.C46)));
//            roundedButton2.setFillColor(ColorStateListUtils.getSimpleColorStateList(resources.getColor(R.color.C44), resources.getColor(R.color.C12)));
//            this.mProgressDialog = CommonUtils.createProgressDialog(this);
//            this.mProgressDialog.setMessage((CharSequence) "登录中，请稍候");
//            this.mLastAccount = getIntent().getStringExtra("extra_last_account_name");
//            String stringExtra = getIntent().getStringExtra(EXTRA_KEY_LAST_ACCOUNT);
//            if (!TextUtils.isEmpty(stringExtra)) {
//                TextView textView = (TextView) findViewById(R.id.login_tip);
//                textView.setVisibility(0);
//                textView.setText(stringExtra);
//            }
//            ThirdPartyUserInfo takeLastLoginInfo = WeixinLogin.takeLastLoginInfo();
//            if (takeLastLoginInfo != null) {
//                this.mAuthCallback.postSuccess(takeLastLoginInfo);
//            }
//        }
//    }
//
//    public void onResume() {
//        super.onResume();
//        UMStats.traceOnActivityResume(this);
//        if (this.mWeixinLogin != null) {
//            this.mWeixinLogin.resume();
//        }
//    }
//
//    public void onPause() {
//        super.onPause();
//        UMStats.traceOnActivityPause(this);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDestroy() {
//        super.onDestroy();
//        BaicizhanThrifts.getProxy().cancelAllWithTag(TAG);
//        if (this.mProgressDialog != null) {
//            this.mProgressDialog.dismiss();
//        }
//        if (this.mWeixinLogin != null) {
//            this.mWeixinLogin.cancel();
//        }
//    }
//
//    public void onClick(View view) {
//        int id = view.getId();
//        if (id == R.id.login_weixin) {
//            loginWeixin();
//        } else if (id == R.id.login_try) {
//            loginTry();
//        } else if (id == R.id.login_email) {
//            loginEmail();
//        } else if (id == R.id.register) {
//            registerEmail();
//        } else if (id == R.id.login_else) {
//            loginElse();
//        }
//    }
//
//    private void loginWeibo() {
//        if (aquireLoginLock()) {
//            this.mWeiboLogin = new WeiboLogin(this, this.mAuthCallback);
//            this.mWeiboLogin.auth();
//        }
//    }
//
//    private void loginWeixin() {
//        if (aquireLoginLock()) {
//            this.mWeixinLogin = new WeixinLogin(this, this.mAuthCallback);
//            this.mWeixinLogin.auth(false);
//        }
//    }
//
//    private void loginRenren() {
//        if (aquireLoginLock()) {
//            this.mRenrenLogin = new RenrenLogin(this, this.mAuthCallback);
//            this.mRenrenLogin.auth();
//        }
//    }
//
//    private void loginTry() {
//        if (aquireLoginLock()) {
//            this.mProgressDialog.show();
//            C10032 r0 = new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//                /* access modifiers changed from: protected */
//                public Integer doInBackground(Client client) {
//                    BBCreateTryResult have_a_try = client.have_a_try();
//                    UserRecord userRecord = new UserRecord();
//                    userRecord.setUser(have_a_try.getEmail());
//                    userRecord.setPasswordMD5(have_a_try.getDigest_token());
//                    userRecord.setLoginType(3);
//                    CommonUtils.login((Context) IntroductionPageActivity.this, client, userRecord, 0);
//                    LogWrapper.m2795i(IntroductionPageActivity.TAG, "hava_a_try " + userRecord);
//                    return Integer.valueOf(0);
//                }
//
//                /* access modifiers changed from: protected */
//                public void onError(Exception exc) {
//                    IntroductionPageActivity.this.mProgressDialog.hide();
//                    IntroductionPageActivity.this.onServerError(exc);
//                }
//
//                /* access modifiers changed from: protected */
//                public void onResult(Integer num) {
//                    IntroductionPageActivity.this.mProgressDialog.hide();
//                    if (num.intValue() == 0) {
//                        IntroductionPageActivity.this.onLoginSuccess();
//                    } else {
//                        onError(new Exception("未知错误"));
//                    }
//                }
//            };
//            r0.setTag(TAG);
//            BaicizhanThrifts.getProxy().add(r0);
//        }
//    }
//
//    private void loginElse() {
//        getSupportFragmentManager().mo313a().mo182a((Fragment) ElseLoginFragment.newInstance(), "loginelse").mo177a().mo186c();
//    }
//
//    /* access modifiers changed from: private */
//    public void onThirdPartyAuthPassed(final UserRecord userRecord) {
//        this.mProgressDialog.show();
//        C10043 r0 = new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            public Integer doInBackground(Client client) {
//                CommonUtils.login((Context) IntroductionPageActivity.this, client, userRecord, 0);
//                return Integer.valueOf(0);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                IntroductionPageActivity.this.mProgressDialog.hide();
//                IntroductionPageActivity.this.onServerError(exc);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(Integer num) {
//                IntroductionPageActivity.this.mProgressDialog.hide();
//                if (num.intValue() == 0) {
//                    IntroductionPageActivity.this.onLoginSuccess();
//                } else {
//                    onError(new Exception("未知错误"));
//                }
//            }
//        };
//        r0.setTag(TAG);
//        BaicizhanThrifts.getProxy().add(r0);
//    }
//
//    /* access modifiers changed from: private */
//    public void onLoginSuccess() {
//        startActivity(new Intent(this, MainTabActivity.class));
//        releaseLoginLock();
//        finish();
//    }
//
//    /* access modifiers changed from: private */
//    public void onServerError(Exception exc) {
//        releaseLoginLock();
//        LogWrapper.m2797w(TAG, "onServerError " + Log.getStackTraceString(exc));
//        if (exc instanceof BELogicException) {
//            Toast.makeText(this, ((BELogicException) exc).getMessage(), 0).show();
//        } else if (exc instanceof C2120g) {
//            Toast.makeText(this, R.string.network_error_retry_later, 0).show();
//        }
//    }
//
//    private void loginEmail() {
//        if (aquireLoginLock()) {
//            Intent intent = new Intent(this, EmailLoginPageActivity.class);
//            intent.putExtra("extra_last_account_name", this.mLastAccount);
//            startActivityForResult(intent, 1);
//            overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
//        }
//    }
//
//    private void registerEmail() {
//        if (aquireLoginLock()) {
//            Intent intent = new Intent(this, EmailRegisterPageActivity.class);
//            intent.putExtra("extra_last_account_name", this.mLastAccount);
//            startActivityForResult(intent, 1);
//            overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        if (this.mWeixinLogin != null) {
//            this.mWeixinLogin.onNewIntent(intent);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onActivityResult(int i, int i2, Intent intent) {
//        super.onActivityResult(i, i2, intent);
//        LogWrapper.m2793d(TAG, "onActivityResult " + i + ", " + i2 + "," + intent);
//        if (i2 == 0) {
//            releaseLoginLock();
//        }
//        if (this.mWeiboLogin != null) {
//            this.mWeiboLogin.authBack(i, i2, intent);
//        }
//    }
//
//    private boolean aquireLoginLock() {
//        long currentTimeMillis = System.currentTimeMillis();
//        if (this.mLoginLock && currentTimeMillis - this.mLastLoginLockTime < AbstractComponentTracker.LINGERING_TIMEOUT) {
//            return false;
//        }
//        this.mLoginLock = true;
//        this.mLastLoginLockTime = currentTimeMillis;
//        return true;
//    }
//
//    /* access modifiers changed from: private */
//    public void releaseLoginLock() {
//        this.mLoginLock = false;
//    }
//
//    public void onLoginRenren() {
//        loginRenren();
//    }
//
//    public void onLoginWeibo() {
//        loginWeibo();
//    }
//}
