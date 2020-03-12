//package com.baicizhan.main.activity;
//
//import android.app.Activity;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.res.ColorStateList;
//import android.graphics.drawable.GradientDrawable;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.RadioGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.dataset.helpers.UserRecordHelper;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.managers.LearnRecordManager;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.ColorStateListUtils;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.business.util.PicassoUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.widget.BczDialog;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.online.bs_users.BBProfile;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import java.util.Locale;
//
//public class UserConfigActivity extends Activity implements OnClickListener {
//    /* access modifiers changed from: private */
//    public static final String TAG = UserConfigActivity.class.getSimpleName();
//    BczDialog mAlertDialog;
//    TextView mButton1;
//    TextView mButton2;
//    BczLoadingDialog mProgressDialog;
//    RadioGroup mSexGroup;
//    boolean mUnderEditMode = false;
//    ImageView mUserImage;
//    EditText mUserNickName;
//    UserRecord mUserRecord;
//
//    /* access modifiers changed from: private */
//    public static int buttonId2Sex(int i) {
//        if (i == R.id.sex_male_button) {
//            return 1;
//        }
//        if (i == R.id.sex_female_button) {
//            return 2;
//        }
//        if (i == R.id.sex_unknown_button) {
//        }
//        return 3;
//    }
//
//    private static int sex2ButtonId(int i) {
//        if (i == 1) {
//            return R.id.sex_male_button;
//        }
//        if (i == 2) {
//            return R.id.sex_female_button;
//        }
//        return R.id.sex_unknown_button;
//    }
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        int i;
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.activity_user_config);
//            this.mUserRecord = StudyManager.getInstance().getCurrentUser();
//            GradientDrawable gradientDrawable = new GradientDrawable();
//            gradientDrawable.setShape(0);
//            gradientDrawable.setCornerRadius((float) DisplayUtils.dpToPx(this, 20.0f));
//            gradientDrawable.setColor(ThemeUtil.getThemeColorWithAttr(this, R.attr.color_window_bg));
//            C1604j.m3631a(findViewById(R.id.config_card), gradientDrawable);
//            this.mUserImage = (ImageView) findViewById(R.id.user_image);
//            this.mUserNickName = (EditText) findViewById(R.id.user_nickname);
//            this.mSexGroup = (RadioGroup) findViewById(R.id.sex_group);
//            this.mButton1 = (TextView) findViewById(R.id.button1);
//            this.mButton2 = (TextView) findViewById(R.id.button2);
//            findViewById(R.id.back).setOnClickListener(this);
//            this.mButton1.setOnClickListener(this);
//            this.mButton2.setOnClickListener(this);
//            ColorStateList simpleThemeColorStateListWithAttr = ColorStateListUtils.getSimpleThemeColorStateListWithAttr(this, R.attr.color_currentpage, R.attr.color_progress);
//            this.mButton1.setTextColor(simpleThemeColorStateListWithAttr);
//            this.mButton2.setTextColor(simpleThemeColorStateListWithAttr);
//            this.mUserNickName.setOnClickListener(this);
//            this.mProgressDialog = CommonUtils.createProgressDialog(this);
//            refresh();
//            exitEditMode();
//            PicassoUtil.loadAccountUserImage(this, PathUtil.getBaicizhanAppRoot(), this.mUserRecord.getImage(), this.mUserImage, R.drawable.userinfo_photo_normal_default);
//            switch (this.mUserRecord.getLoginType()) {
//                case 0:
//                    i = R.attr.drawable_mail;
//                    break;
//                case 1:
//                    i = R.attr.drawable_weibo;
//                    break;
//                case 2:
//                    i = R.attr.drawable_renren;
//                    break;
//                case 4:
//                    i = R.attr.drawable_wechat;
//                    break;
//                default:
//                    i = 0;
//                    break;
//            }
//            if (i > 0) {
//                int themeResourceIdWithAttr = ThemeUtil.getThemeResourceIdWithAttr(this, i);
//                if (themeResourceIdWithAttr > 0) {
//                    this.mUserNickName.setCompoundDrawablesWithIntrinsicBounds(0, 0, themeResourceIdWithAttr, 0);
//                    this.mUserNickName.setCompoundDrawablePadding(DisplayUtils.dpToPx(this, 5.0f));
//                }
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
//        if (this.mAlertDialog != null) {
//            this.mAlertDialog.dismiss();
//        }
//        BaicizhanThrifts.getProxy().cancelAllWithTag(TAG);
//    }
//
//    /* access modifiers changed from: private */
//    public void refresh() {
//        this.mSexGroup.check(sex2ButtonId(this.mUserRecord.getSex()));
//        this.mUserNickName.setText(this.mUserRecord.getDisplayName());
//    }
//
//    private void enterEditMode() {
//        this.mUnderEditMode = true;
//        this.mButton1.setText(R.string.main_alert_negative_cancel);
//        this.mButton2.setText(R.string.main_alert_positive_confirm);
//        for (int i = 0; i < this.mSexGroup.getChildCount(); i++) {
//            View childAt = this.mSexGroup.getChildAt(i);
//            if (this.mSexGroup.getCheckedRadioButtonId() != childAt.getId()) {
//                childAt.setVisibility(0);
//            }
//        }
//        this.mUserNickName.setCursorVisible(true);
//    }
//
//    /* access modifiers changed from: private */
//    public void exitEditMode() {
//        this.mUnderEditMode = false;
//        refresh();
//        this.mButton1.setText("修改资料");
//        this.mButton2.setText("退出帐号");
//        for (int i = 0; i < this.mSexGroup.getChildCount(); i++) {
//            View childAt = this.mSexGroup.getChildAt(i);
//            if (this.mSexGroup.getCheckedRadioButtonId() != childAt.getId()) {
//                childAt.setVisibility(8);
//            }
//        }
//        this.mUserNickName.clearFocus();
//        this.mUserNickName.setCursorVisible(false);
//    }
//
//    public void onClick(View view) {
//        int id = view.getId();
//        if (id == R.id.back) {
//            finish();
//        } else if (id == R.id.user_nickname) {
//            enterEditMode();
//        } else if (id == R.id.button1) {
//            if (this.mUnderEditMode) {
//                exitEditMode();
//            } else {
//                enterEditMode();
//            }
//        } else if (id != R.id.button2) {
//        } else {
//            if (this.mUnderEditMode) {
//                updateProfile();
//            } else {
//                tryChangeAccount();
//            }
//        }
//    }
//
//    private void updateProfile() {
//        LogWrapper.m2793d(TAG, "updateProfile");
//        final String trim = this.mUserNickName.getText().toString().trim();
//        if (TextUtils.isEmpty(trim)) {
//            Toast.makeText(this, "昵称不能为空", 0).show();
//            return;
//        }
//        C10821 r1 = new ThriftRequest<Client, BBProfile>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            public BBProfile doInBackground(Client client) {
//                BBProfile update_profile = client.update_profile(UserConfigActivity.buttonId2Sex(UserConfigActivity.this.mSexGroup.getCheckedRadioButtonId()), trim);
//                LogWrapper.m2793d(UserConfigActivity.TAG, "update_profile " + update_profile);
//                UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//                currentUser.setSex(update_profile.getGender());
//                currentUser.setNickName(update_profile.getNick_name());
//                UserRecordHelper.updateUserRecord(UserConfigActivity.this, currentUser, "sex", "nickName");
//                return update_profile;
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                UserConfigActivity.this.mProgressDialog.hide();
//                CommonUtils.toastThriftErrorMsg(UserConfigActivity.this, exc);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(BBProfile bBProfile) {
//                UserConfigActivity.this.mProgressDialog.hide();
//                UserConfigActivity.this.refresh();
//                UserConfigActivity.this.exitEditMode();
//                Toast.makeText(UserConfigActivity.this, "修改成功", 0).show();
//            }
//        };
//        this.mProgressDialog.show();
//        r1.setTag(TAG);
//        BaicizhanThrifts.getProxy().add(r1);
//    }
//
//    private void tryChangeAccount() {
//        if (LearnRecordManager.getUploadRecordsCount(this, StudyManager.getInstance().getCurrentBookId()) == 0) {
//            C10832 r0 = new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    if (i == -1) {
//                        UserConfigActivity.this.changeAccount();
//                    }
//                    dialogInterface.dismiss();
//                }
//            };
//            this.mAlertDialog = new Builder(this).setTitle((CharSequence) "提示").setMessage((CharSequence) "是否要登出该用户").setPositiveButton((int) R.string.main_alert_positive_confirm, (DialogInterface.OnClickListener) r0).setNegativeButton((int) R.string.main_alert_negative_cancel, (DialogInterface.OnClickListener) r0).create();
//            this.mAlertDialog.show();
//            return;
//        }
//        this.mAlertDialog = new Builder(this).setTitle((CharSequence) "重要提示").setMessage((CharSequence) "少侠啊～～！！！学习记录没有保存到服务器，强行切换会丢失的啊啊啊啊啊！！再回来就啥都没有了啊！！！").setPositiveButton((CharSequence) "知道了", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                UserConfigActivity.this.finish();
//            }
//        }).create();
//        this.mAlertDialog.show();
//    }
//
//    /* access modifiers changed from: private */
//    public void changeAccount() {
//        final UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//        this.mProgressDialog.show();
//        new AsyncTask<Void, Void, Void>() {
//            /* access modifiers changed from: protected */
//            public Void doInBackground(Void... voidArr) {
//                CommonUtils.logout(UserConfigActivity.this);
//                return null;
//            }
//
//            /* access modifiers changed from: protected */
//            public void onPostExecute(Void voidR) {
//                super.onPostExecute(voidR);
//                UserConfigActivity.this.mProgressDialog.dismiss();
//                LogWrapper.m2793d(UserConfigActivity.TAG, "changeAccountSuccess start IntroductionPageActivity");
//                Intent intent = new Intent(UserConfigActivity.this, IntroductionPageActivity.class);
//                intent.setFlags(268468224);
//                if (currentUser != null) {
//                    String format = String.format(Locale.CHINA, "注意，您刚才使用的是%s账号%s登录", new Object[]{currentUser.getVerboseLoginType(), currentUser.getUser()});
//                    intent.putExtra(IntroductionPageActivity.EXTRA_KEY_LAST_ACCOUNT, format);
//                    intent.putExtra("extra_last_account_name", currentUser.getUser());
//                    LogWrapper.m2793d("test", "lastAccount " + format);
//                    if (currentUser.getLoginType() == 0) {
//                        Settings.setLastEmail(currentUser.getEmail());
//                    }
//                }
//                UserConfigActivity.this.startActivity(intent);
//                UserConfigActivity.this.finish();
//            }
//        }.execute(new Void[0]);
//    }
//}
