//package com.baicizhan.main.activity;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.graphics.drawable.GradientDrawable;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.KeyEvent;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.View.OnTouchListener;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.TextView.OnEditorActionListener;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.StringUtil;
//import com.baicizhan.client.business.util.SystemUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.business.widget.RoundedButton;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//
//public class ForgetPasswordPageActivity extends Activity implements OnClickListener, OnTouchListener {
//    public static final String EXTRA_USER_EMAIL = "user_email";
//    /* access modifiers changed from: private */
//    public RoundedButton mButton;
//    /* access modifiers changed from: private */
//    public EditText mEmail;
//    /* access modifiers changed from: private */
//    public TextView mHint;
//    /* access modifiers changed from: private */
//    public BczLoadingDialog mProgressDialog;
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        setTheme(R.style.StandardDefault);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.activity_forget_password_page);
//            findViewById(R.id.forget_password_content).setOnClickListener(this);
//            findViewById(R.id.forget_password_content).setOnTouchListener(this);
//            this.mEmail = (EditText) findViewById(R.id.email);
//            this.mHint = (TextView) findViewById(R.id.hint);
//            this.mButton = (RoundedButton) findViewById(R.id.confirm);
//            this.mEmail.setOnEditorActionListener(new OnEditorActionListener() {
//                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//                    if (i == ForgetPasswordPageActivity.this.getResources().getInteger(R.integer.send) || i == 6) {
//                        ForgetPasswordPageActivity.this.forgetPassword();
//                    } else {
//                        SystemUtil.hideIME(textView);
//                    }
//                    return true;
//                }
//            });
//            findViewById(R.id.email_clear).setOnClickListener(this);
//            GradientDrawable gradientDrawable = new GradientDrawable();
//            gradientDrawable.setShape(0);
//            gradientDrawable.setColor(ThemeUtil.getThemeColorWithAttr(this, R.attr.color_common_white));
//            gradientDrawable.setCornerRadius((float) DisplayUtils.dpToPx(this, 4.0f));
//            C1604j.m3631a(this.mEmail, gradientDrawable);
//            Intent intent = getIntent();
//            if (intent != null) {
//                String stringExtra = intent.getStringExtra("user_email");
//                if (!TextUtils.isEmpty(stringExtra)) {
//                    this.mEmail.setText(stringExtra);
//                }
//            }
//            findViewById(R.id.back).setOnClickListener(this);
//            findViewById(R.id.confirm).setOnClickListener(this);
//            this.mProgressDialog = CommonUtils.createProgressDialog(this);
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
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.back /*2131296287*/:
//                finish();
//                return;
//            case R.id.email_clear /*2131296310*/:
//                this.mEmail.setText("");
//                return;
//            case R.id.confirm /*2131296323*/:
//                forgetPassword();
//                return;
//            default:
//                this.mEmail.clearFocus();
//                return;
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void forgetPassword() {
//        int i;
//        SystemUtil.hideIME(this.mEmail);
//        this.mEmail.clearFocus();
//        final String obj = this.mEmail.getText().toString();
//        if (TextUtils.isEmpty(obj)) {
//            i = R.string.main_email_empty;
//        } else if (!StringUtil.isValidEmailAddr(obj)) {
//            i = R.string.main_not_mail_format;
//        } else {
//            i = -1;
//        }
//        if (i != -1) {
//            this.mHint.setText(i);
//            return;
//        }
//        BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            public Integer doInBackground(Client client) {
//                return Integer.valueOf(client.forget_password(obj));
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                ForgetPasswordPageActivity.this.mProgressDialog.hide();
//                CommonUtils.toastThriftErrorMsg(ForgetPasswordPageActivity.this, exc);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(Integer num) {
//                ForgetPasswordPageActivity.this.mProgressDialog.hide();
//                ForgetPasswordPageActivity.this.mHint.setText("找回密码邮件已经发送到您的邮箱，请在当天内查收");
//                ForgetPasswordPageActivity.this.mButton.setText("发送成功");
//                ForgetPasswordPageActivity.this.mButton.setEnabled(false);
//                ForgetPasswordPageActivity.this.mEmail.setImeActionLabel("发送成功", 6);
//            }
//        });
//        this.mProgressDialog.show();
//    }
//
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        SystemUtil.hideIME(view);
//        return false;
//    }
//}
