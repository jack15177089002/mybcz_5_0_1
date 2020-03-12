//package com.baicizhan.main.activity;
//
//import android.app.Activity;
//import android.content.Context;
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
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.TextView.OnEditorActionListener;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.StringUtil;
//import com.baicizhan.client.business.util.SystemUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.baicizhan.online.structs.BELogicException;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import org.p100a.p101a.p107f.C2120g;
//
//public class EmailRegisterPageActivity extends Activity implements OnClickListener, OnTouchListener {
//    public static final String EXTRA_IS_BIND = "is_bind";
//    public static final String EXTRA_USER_EMAIL = "user_email";
//    public static final String EXTRA_USER_PASS = "user_pass";
//    private static final int MIN_PASSWORD_LENGTH = 6;
//    /* access modifiers changed from: private */
//    public static final String TAG = EmailRegisterPageActivity.class.getSimpleName();
//    private EditText mEmailEditText;
//    private TextView mHint;
//    /* access modifiers changed from: private */
//    public int mIsBind;
//    private EditText mPasswordConfirmEditText;
//    private EditText mPasswordEditText;
//    private BczLoadingDialog mProgressDialog;
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        int i;
//        super.onCreate(bundle);
//        setTheme(R.style.StandardDefault);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.activity_email_register_page);
//            this.mEmailEditText = (EditText) findViewById(R.id.email);
//            this.mPasswordEditText = (EditText) findViewById(R.id.password);
//            this.mPasswordConfirmEditText = (EditText) findViewById(R.id.confirm_password);
//            this.mHint = (TextView) findViewById(R.id.hint);
//            this.mPasswordConfirmEditText.setOnEditorActionListener(new OnEditorActionListener() {
//                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//                    if (i == EmailRegisterPageActivity.this.getResources().getInteger(R.integer.register) || i == 6) {
//                        EmailRegisterPageActivity.this.doRegister();
//                    }
//                    return true;
//                }
//            });
//            setEditBackground(this.mEmailEditText);
//            setEditBackground(this.mPasswordEditText);
//            setEditBackground(this.mPasswordConfirmEditText);
//            findViewById(R.id.email_register_bg).setOnTouchListener(this);
//            findViewById(R.id.email_clear).setOnClickListener(this);
//            findViewById(R.id.password_clear).setOnClickListener(this);
//            findViewById(R.id.confirm_password_clear).setOnClickListener(this);
//            findViewById(R.id.back).setOnClickListener(this);
//            Button button = (Button) findViewById(R.id.register);
//            button.setOnClickListener(this);
//            this.mProgressDialog = new BczLoadingDialog(this);
//            this.mProgressDialog.setMessage((CharSequence) getString(R.string.main_comfriming_from_server));
//            this.mProgressDialog.setCancelable(false);
//            Intent intent = getIntent();
//            if (intent != null) {
//                String stringExtra = intent.getStringExtra("user_email");
//                if (!TextUtils.isEmpty(stringExtra)) {
//                    this.mEmailEditText.setText(stringExtra);
//                    String stringExtra2 = intent.getStringExtra(EXTRA_USER_PASS);
//                    if (!TextUtils.isEmpty(stringExtra2)) {
//                        this.mPasswordEditText.setText(stringExtra2);
//                        this.mPasswordConfirmEditText.requestFocus();
//                    } else {
//                        this.mPasswordEditText.requestFocus();
//                    }
//                }
//                this.mIsBind = intent.getIntExtra(EXTRA_IS_BIND, 0);
//            }
//            if (this.mIsBind == 1) {
//                i = R.string.main_bind_email;
//            } else {
//                i = R.string.main_register_email;
//            }
//            button.setText(i);
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
//    public void onClick(View view) {
//        int id = view.getId();
//        if (id == R.id.back) {
//            finish();
//        } else if (id == R.id.register) {
//            doRegister();
//        } else if (id == R.id.email_clear) {
//            this.mEmailEditText.setText("");
//        } else if (id == R.id.password_clear) {
//            this.mPasswordEditText.setText("");
//        } else if (id == R.id.confirm_password_clear) {
//            this.mPasswordConfirmEditText.setText("");
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void doRegister() {
//        SystemUtil.hideIME(this.mPasswordConfirmEditText);
//        String trim = this.mEmailEditText.getText().toString().trim();
//        String trim2 = this.mPasswordEditText.getText().toString().trim();
//        if (inputCheck(trim, trim2, this.mPasswordConfirmEditText.getText().toString())) {
//            emailRegisterAndLogin(trim, trim2);
//        }
//    }
//
//    private void emailRegisterAndLogin(String str, String str2) {
//        if (this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
//            this.mProgressDialog.show();
//        }
//        final UserRecord userRecord = new UserRecord();
//        userRecord.setUser(str);
//        userRecord.setPasswordMD5(StringUtil.md5Hex(str2, true));
//        userRecord.setLoginType(0);
//        BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            public Integer doInBackground(Client client) {
//                if (EmailRegisterPageActivity.this.mIsBind == 0) {
//                    int register_user = client.register_user(userRecord.getUser(), userRecord.getPasswordMD5());
//                    Log.d(EmailRegisterPageActivity.TAG, "register_user " + register_user);
//                    return Integer.valueOf(register_user);
//                }
//                int bind_try_user = client.bind_try_user(userRecord.getUser(), userRecord.getPasswordMD5());
//                Log.d(EmailRegisterPageActivity.TAG, "bind_try_user " + bind_try_user);
//                return Integer.valueOf(bind_try_user);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                EmailRegisterPageActivity.this.onServerError(exc);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(Integer num) {
//                if (num.intValue() == 0) {
//                    Toast.makeText(EmailRegisterPageActivity.this, "注册成功，正在登录中....", 1).show();
//                    CommonUtils.login((Context) EmailRegisterPageActivity.this, userRecord, (AuthCallback<UserRecord>) new AuthCallback<UserRecord>() {
//                        /* access modifiers changed from: protected */
//                        public void onSuccess(UserRecord userRecord) {
//                            Log.d(EmailRegisterPageActivity.TAG, "email login sucess");
//                            if (EmailRegisterPageActivity.this.mIsBind == 0) {
//                                Intent intent = new Intent(EmailRegisterPageActivity.this, MainTabActivity.class);
//                                intent.setFlags(268468224);
//                                EmailRegisterPageActivity.this.startActivity(intent);
//                            }
//                            EmailRegisterPageActivity.this.setResult(-1);
//                            EmailRegisterPageActivity.this.finish();
//                        }
//
//                        /* access modifiers changed from: protected */
//                        public void onError(Throwable th) {
//                            EmailRegisterPageActivity.this.onServerError(th);
//                        }
//                    }, EmailRegisterPageActivity.this.mIsBind);
//                }
//            }
//        });
//    }
//
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        SystemUtil.hideIME(view);
//        return false;
//    }
//
//    /* access modifiers changed from: private */
//    public void onServerError(Throwable th) {
//        if (th instanceof BELogicException) {
//            this.mHint.setText(((BELogicException) th).getMessage());
//        } else if (th instanceof C2120g) {
//            this.mHint.setText(R.string.network_error_retry_later);
//        }
//    }
//
//    private boolean inputCheck(String str, String str2, String str3) {
//        int i;
//        if (TextUtils.isEmpty(str)) {
//            i = R.string.main_email_empty;
//        } else if (!StringUtil.isValidEmailAddr(str)) {
//            i = R.string.main_not_mail_format;
//        } else {
//            i = -1;
//        }
//        if (TextUtils.isEmpty(str2)) {
//            i = R.string.main_password_is_empty;
//        } else if (str2.length() < 6) {
//            i = R.string.main_password_length_error;
//        } else if (!str2.equals(str3)) {
//            i = R.string.main_password_not_same;
//        }
//        if (i == -1) {
//            return true;
//        }
//        this.mHint.setText(getString(i));
//        return false;
//    }
//}
