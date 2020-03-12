//package com.baicizhan.main.activity;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.graphics.drawable.GradientDrawable;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.util.Log;
//import android.view.KeyEvent;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.View.OnTouchListener;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.TextView.OnEditorActionListener;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.StringUtil;
//import com.baicizhan.client.business.util.SystemUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.online.structs.BELogicException;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import org.p100a.p101a.p107f.C2120g;
//
//public class EmailLoginPageActivity extends Activity implements OnClickListener, OnTouchListener {
//    public static final String EXTRA_KEY_LAST_ACCOUNT_NAME = "extra_last_account_name";
//    public static final String EXTRA_USER_EMAIL = "user_email";
//    private static final int REQUEST_CODE_EMAIL_REGISTER = 1;
//    /* access modifiers changed from: private */
//    public static final String TAG = EmailLoginPageActivity.class.getSimpleName();
//    /* access modifiers changed from: private */
//    public EditText mEmailEditText;
//    /* access modifiers changed from: private */
//    public TextView mHint;
//    private String mLastAccount;
//    private String mLastEmail;
//    /* access modifiers changed from: private */
//    public EditText mPasswordEditText;
//    /* access modifiers changed from: private */
//    public BczLoadingDialog mProgressDialog;
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        setTheme(R.style.StandardDefault);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.activity_email_login_page);
//            this.mEmailEditText = (EditText) findViewById(R.id.email);
//            this.mPasswordEditText = (EditText) findViewById(R.id.password);
//            setEditBackground(this.mEmailEditText);
//            setEditBackground(this.mPasswordEditText);
//            this.mPasswordEditText.setOnEditorActionListener(new OnEditorActionListener() {
//                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//                    if (i == EmailLoginPageActivity.this.getResources().getInteger(R.integer.login) || i == 6) {
//                        EmailLoginPageActivity.this.doLogin();
//                    }
//                    return true;
//                }
//            });
//            this.mLastEmail = Settings.getLastEmail();
//            if (!TextUtils.isEmpty(this.mLastEmail)) {
//                this.mEmailEditText.setText(this.mLastEmail);
//                this.mPasswordEditText.requestFocus();
//            }
//            findViewById(R.id.email_login_bg).setOnTouchListener(this);
//            findViewById(R.id.email_clear).setOnClickListener(this);
//            findViewById(R.id.password_clear).setOnClickListener(this);
//            this.mHint = (TextView) findViewById(R.id.hint);
//            findViewById(R.id.back).setOnClickListener(this);
//            findViewById(R.id.register).setOnClickListener(this);
//            findViewById(R.id.login).setOnClickListener(this);
//            findViewById(R.id.forget_password).setOnClickListener(this);
//            this.mProgressDialog = new BczLoadingDialog(this);
//            this.mProgressDialog.setMessage((CharSequence) getString(R.string.main_comfriming_from_server));
//            this.mProgressDialog.setCancelable(false);
//            Intent intent = getIntent();
//            if (intent != null) {
//                String stringExtra = intent.getStringExtra("user_email");
//                if (!TextUtils.isEmpty(stringExtra)) {
//                    this.mEmailEditText.setText(stringExtra);
//                }
//                this.mLastAccount = getIntent().getStringExtra("extra_last_account_name");
//            }
//        }
//    }
//
//    public void onResume() {
//        super.onResume();
//        UMStats.traceOnActivityResume(this);
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
//    }
//
//    public void setEditBackground(View view) {
//        GradientDrawable gradientDrawable = new GradientDrawable();
//        gradientDrawable.setShape(0);
//        gradientDrawable.setColor(ThemeUtil.getThemeColorWithAttr(this, R.attr.color_common_white));
//        gradientDrawable.setCornerRadius((float) DisplayUtils.dpToPx(this, 4.0f));
//        C1604j.m3631a(view, gradientDrawable);
//    }
//
//    public void onClick(View view) {
//        this.mEmailEditText.clearFocus();
//        int id = view.getId();
//        if (id == R.id.back) {
//            finish();
//        } else if (id == R.id.register) {
//            gotoRegister();
//        } else if (id == R.id.login) {
//            doLogin();
//        } else if (id == R.id.forget_password) {
//            Intent intent = new Intent(this, ForgetPasswordPageActivity.class);
//            intent.putExtra("user_email", this.mEmailEditText.getText().toString());
//            startActivity(intent);
//        } else if (id == R.id.email_clear) {
//            this.mEmailEditText.setText("");
//        } else if (id == R.id.password_clear) {
//            this.mPasswordEditText.setText("");
//        }
//    }
//
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        SystemUtil.hideIME(view);
//        return false;
//    }
//
//    /* access modifiers changed from: private */
//    public void doLogin() {
//        SystemUtil.hideIME(this.mPasswordEditText);
//        this.mHint.setText(null);
//        emailLogin(this.mEmailEditText.getText().toString().trim(), this.mPasswordEditText.getText().toString().trim());
//    }
//
//    private void emailLogin(String str, String str2) {
//        if (TextUtils.isEmpty(str)) {
//            this.mHint.setText("邮箱不能为空");
//        } else if (!StringUtil.isValidEmailAddr(str)) {
//            this.mHint.setText(R.string.main_not_mail_format);
//        } else if (TextUtils.isEmpty(str2)) {
//            this.mHint.setText("密码不能为空");
//        } else {
//            UserRecord userRecord = new UserRecord();
//            userRecord.setUser(str);
//            userRecord.setPasswordMD5(StringUtil.md5Hex(str2, true));
//            userRecord.setLoginType(0);
//            C09872 r1 = new AuthCallback<UserRecord>() {
//                /* access modifiers changed from: protected */
//                public void onSuccess(UserRecord userRecord) {
//                    Log.d(EmailLoginPageActivity.TAG, "email login sucess");
//                    Intent intent = new Intent(EmailLoginPageActivity.this, MainTabActivity.class);
//                    intent.setFlags(268468224);
//                    EmailLoginPageActivity.this.startActivity(intent);
//                    EmailLoginPageActivity.this.setResult(-1);
//                    EmailLoginPageActivity.this.mProgressDialog.hide();
//                    EmailLoginPageActivity.this.finish();
//                }
//
//                /* access modifiers changed from: protected */
//                public void onError(Throwable th) {
//                    if (th instanceof C2120g) {
//                        EmailLoginPageActivity.this.mHint.setText(EmailLoginPageActivity.this.getString(R.string.network_error_retry_later));
//                    } else if (th instanceof BELogicException) {
//                        BELogicException bELogicException = (BELogicException) th;
//                        if (10 == bELogicException.code) {
//                            EmailLoginPageActivity.this.askIfRegister();
//                        } else {
//                            EmailLoginPageActivity.this.mHint.setText(bELogicException.getMessage());
//                        }
//                    } else {
//                        EmailLoginPageActivity.this.mHint.setText("错误:" + th.toString());
//                    }
//                    EmailLoginPageActivity.this.mProgressDialog.dismiss();
//                    Log.e(EmailLoginPageActivity.TAG, "email login error " + Log.getStackTraceString(th));
//                }
//            };
//            this.mProgressDialog.show();
//            CommonUtils.login((Context) this, userRecord, (AuthCallback<UserRecord>) r1, 0);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void askIfRegister() {
//        new Builder(this).setTitle((int) R.string.attention).setMessage((int) R.string.main_login_user_not_exists).setNegativeButton((int) R.string.main_login_reinput_email, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                EmailLoginPageActivity.this.mEmailEditText.setText(null);
//                EmailLoginPageActivity.this.mEmailEditText.requestFocus();
//                EmailLoginPageActivity.this.mPasswordEditText.setText(null);
//            }
//        }).setPositiveButton((int) R.string.main_login_goto_register, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                EmailLoginPageActivity.this.gotoRegister();
//            }
//        }).create().show();
//    }
//
//    /* access modifiers changed from: private */
//    public void gotoRegister() {
//        Intent intent = new Intent(this, EmailRegisterPageActivity.class);
//        if (!isAccountRegistered()) {
//            intent.putExtra("user_email", this.mEmailEditText.getText().toString());
//            intent.putExtra(EmailRegisterPageActivity.EXTRA_USER_PASS, this.mPasswordEditText.getText().toString());
//        }
//        startActivityForResult(intent, 1);
//    }
//
//    private boolean isAccountRegistered() {
//        return (!TextUtils.isEmpty(this.mLastAccount) && this.mLastAccount.equals(this.mEmailEditText.getText().toString())) || (!TextUtils.isEmpty(this.mLastEmail) && this.mLastEmail.equals(this.mEmailEditText.getText().toString()));
//    }
//
//    /* access modifiers changed from: protected */
//    public void onActivityResult(int i, int i2, Intent intent) {
//        super.onActivityResult(i, i2, intent);
//        if (i == 1 && i2 == -1) {
//            setResult(-1);
//            finish();
//        }
//    }
//}
