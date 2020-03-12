//package com.baicizhan.main.activity;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.graphics.drawable.GradientDrawable;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.PicassoUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.main.auth.ThirdPartyUserInfo;
//import com.baicizhan.main.auth.WeiboLogin;
//import com.baicizhan.main.auth.WeixinLogin;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.online.structs.BELogicException;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import java.util.Locale;
//import org.p100a.p101a.p107f.C2120g;
//
//public class BindAccountActivity extends Activity implements OnClickListener {
//    /* access modifiers changed from: private */
//    public static final String TAG = BindAccountActivity.class.getSimpleName();
//    private final int REQUEST_CODE_EMAIL_BIND = 1;
//    private AuthCallback<ThirdPartyUserInfo> mAuthCallback = new AuthCallback<ThirdPartyUserInfo>() {
//        /* access modifiers changed from: protected */
//        public void onSuccess(ThirdPartyUserInfo thirdPartyUserInfo) {
//            Log.d(BindAccountActivity.TAG, "mAuthCallback success " + thirdPartyUserInfo);
//            Toast.makeText(BindAccountActivity.this, "获取认证数据，绑定中请稍候...", 1).show();
//            UserRecord thirdPartyInfoToUserRecord = CommonUtils.thirdPartyInfoToUserRecord(thirdPartyUserInfo);
//            CommonUtils.saveThirdPartyLoginCache(BindAccountActivity.this, thirdPartyUserInfo);
//            CommonUtils.login((Context) BindAccountActivity.this, thirdPartyInfoToUserRecord, BindAccountActivity.this.mLoginCallback, 1);
//        }
//
//        /* access modifiers changed from: protected */
//        public void onError(Throwable th) {
//            Toast.makeText(BindAccountActivity.this, "认证失败:" + th.getMessage(), 0).show();
//        }
//    };
//    /* access modifiers changed from: private */
//    public AuthCallback<UserRecord> mLoginCallback = new AuthCallback<UserRecord>() {
//        /* access modifiers changed from: protected */
//        public void onSuccess(UserRecord userRecord) {
//            BindAccountActivity.this.startActivity(new Intent(BindAccountActivity.this, MainTabActivity.class));
//            BindAccountActivity.this.finish();
//        }
//
//        /* access modifiers changed from: protected */
//        public void onError(Throwable th) {
//            BindAccountActivity.this.onServerError(th);
//        }
//    };
//    /* access modifiers changed from: private */
//    public BczLoadingDialog mProgressDialog;
//    private WeiboLogin mWeiboLogin;
//    private WeixinLogin mWeixinLogin;
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.activity_bind_account);
//            View findViewById = findViewById(R.id.card);
//            GradientDrawable gradientDrawable = new GradientDrawable();
//            gradientDrawable.setShape(0);
//            gradientDrawable.setCornerRadius((float) DisplayUtils.dpToPx(this, 8.0f));
//            gradientDrawable.setColor(ThemeUtil.getThemeColorWithAttr(this, R.attr.color_window_bg));
//            C1604j.m3631a(findViewById, gradientDrawable);
//            findViewById(R.id.back).setOnClickListener(this);
//            findViewById(R.id.logout).setOnClickListener(this);
//            findViewById(R.id.bind_email).setOnClickListener(this);
//            findViewById(R.id.bind_weibo).setOnClickListener(this);
//            findViewById(R.id.bind_weixin).setOnClickListener(this);
//            UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//            ImageView imageView = (ImageView) findViewById(R.id.user_image);
//            TextView textView = (TextView) findViewById(R.id.user_nickname);
//            if (currentUser != null) {
//                PicassoUtil.loadUserImage(this, imageView, currentUser.getImage());
//                textView.setText(currentUser.getDisplayName());
//            }
//            this.mProgressDialog = CommonUtils.createProgressDialog(this);
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
//        if (id == R.id.back) {
//            finish();
//        } else if (id == R.id.logout) {
//            changeAccount();
//        } else if (id == R.id.bind_email) {
//            bindEmail();
//        } else if (id == R.id.bind_weibo) {
//            bindWeibo();
//        } else if (id == R.id.bind_weixin) {
//            bindWeixin();
//        }
//    }
//
//    private void changeAccount() {
//        new Builder(this).setTitle((int) R.string.attention).setMessage((int) R.string.main_try_user_logout_sure).setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                BindAccountActivity.this.logout();
//            }
//        }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null).create().show();
//    }
//
//    /* access modifiers changed from: private */
//    public void logout() {
//        final UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//        if (!this.mProgressDialog.isShowing()) {
//            this.mProgressDialog.show();
//            new AsyncTask<Void, Void, Void>() {
//                /* access modifiers changed from: protected */
//                public Void doInBackground(Void... voidArr) {
//                    CommonUtils.logout(BindAccountActivity.this);
//                    return null;
//                }
//
//                /* access modifiers changed from: protected */
//                public void onPostExecute(Void voidR) {
//                    super.onPostExecute(voidR);
//                    BindAccountActivity.this.mProgressDialog.dismiss();
//                    Intent intent = new Intent(BindAccountActivity.this, IntroductionPageActivity.class);
//                    intent.setFlags(268468224);
//                    if (currentUser != null) {
//                        intent.putExtra(IntroductionPageActivity.EXTRA_KEY_LAST_ACCOUNT, String.format(Locale.CHINA, "注意，您刚才使用的是%s账号%s登录", new Object[]{currentUser.getVerboseLoginType(), currentUser.getUser()}));
//                        intent.putExtra("extra_last_account_name", currentUser.getUser());
//                    }
//                    BindAccountActivity.this.startActivity(intent);
//                    BindAccountActivity.this.finish();
//                }
//            }.execute(new Void[0]);
//        }
//    }
//
//    private void bindEmail() {
//        Intent intent = new Intent(this, EmailRegisterPageActivity.class);
//        intent.putExtra(EmailRegisterPageActivity.EXTRA_IS_BIND, 1);
//        startActivityForResult(intent, 1);
//    }
//
//    private void bindWeibo() {
//        this.mWeiboLogin = new WeiboLogin(this, this.mAuthCallback);
//        this.mWeiboLogin.auth();
//    }
//
//    private void bindWeixin() {
//        this.mWeixinLogin = new WeixinLogin(this, this.mAuthCallback);
//        this.mWeixinLogin.auth(false);
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
//        Log.d(TAG, "BindAccountActivity onActivityResult " + i + ", " + i2);
//        if (i == 1 && i2 == -1) {
//            finish();
//        }
//        if (this.mWeiboLogin != null) {
//            this.mWeiboLogin.authBack(i, i2, intent);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void onServerError(Throwable th) {
//        if (th instanceof BELogicException) {
//            Toast.makeText(this, ((BELogicException) th).getMessage(), 0).show();
//        } else if (th instanceof C2120g) {
//            Toast.makeText(this, R.string.network_error_retry_later, 0).show();
//        }
//    }
//}
