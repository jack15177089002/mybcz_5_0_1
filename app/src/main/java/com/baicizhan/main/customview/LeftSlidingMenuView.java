//package com.baicizhan.main.customview;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.graphics.Color;
//import android.text.TextUtils;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.FrameLayout;
//import android.widget.TextView;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.debug.DebugConfig;
//import com.baicizhan.client.business.event.BEvents.FeedbackNewEvent;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.baicizhan.client.business.widget.RedDotImageView;
//import com.baicizhan.client.wordtesting.activity.MainActivity;
//import com.baicizhan.client.wordtesting.activity.VocabStatsActivity;
//import com.baicizhan.main.activity.BindAccountActivity;
//import com.baicizhan.main.activity.DebugActivity;
//import com.baicizhan.main.activity.EverydayNoticeActivity;
//import com.baicizhan.main.activity.FeedbackActivity;
//import com.baicizhan.main.activity.MainTabActivity;
//import com.baicizhan.main.activity.ScheduleManagementActivity;
//import com.baicizhan.main.activity.SettingActivity;
//import com.baicizhan.main.activity.UserConfigActivity;
//import com.baicizhan.main.upgrade.PackageUtils;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.main.utils.GoStoreUtil;
//import com.baicizhan.online.bs_users.BBShoppingAd;
//import com.jiongji.andriod.card.R;
//import java.util.Locale;
//import p000a.p001a.p002a.EventBus;
//
//public class LeftSlidingMenuView extends FrameLayout implements OnClickListener {
//    private static final String TAG = LeftSlidingMenuView.class.getSimpleName();
//    private RedDotImageView mFeedbackIcon;
//    /* access modifiers changed from: private */
//    public TextView mShop;
//    private View mTryUserAlert;
//    private TextView mUserName;
//    private TextView mVocabulary;
//
//    public LeftSlidingMenuView(Context context) {
//        this(context, null);
//    }
//
//    public LeftSlidingMenuView(Context context, AttributeSet attributeSet) {
//        this(context, attributeSet, 0);
//    }
//
//    public LeftSlidingMenuView(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mFeedbackIcon = (RedDotImageView) findViewById(R.id.feedback_icon);
//        findViewById(R.id.user_line).setOnClickListener(this);
//        findViewById(R.id.schedule_line).setOnClickListener(this);
//        findViewById(R.id.alarm_line).setOnClickListener(this);
//        findViewById(R.id.feedback_line).setOnClickListener(this);
//        findViewById(R.id.shopping_line).setOnClickListener(this);
//        findViewById(R.id.vocabulary_test_line).setOnClickListener(this);
//        findViewById(R.id.setting_line).setOnClickListener(this);
//        this.mUserName = (TextView) findViewById(R.id.user_name);
//        this.mVocabulary = (TextView) findViewById(R.id.vocabulary);
//        this.mTryUserAlert = findViewById(R.id.try_user_alert);
//        this.mTryUserAlert.setVisibility(4);
//        this.mShop = (TextView) findViewById(R.id.shopping_text);
//        fetchMenuSettings();
//    }
//
//    public void onOpen() {
//        showAppVersion();
//        UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//        if (currentUser != null) {
//            setNickName(currentUser.getDisplayName());
//            if (currentUser.getLoginType() == 3) {
//                this.mTryUserAlert.setVisibility(0);
//                this.mTryUserAlert.setOnClickListener(this);
//            } else {
//                this.mTryUserAlert.setVisibility(4);
//                this.mTryUserAlert.setOnClickListener(null);
//            }
//            setVocabulary(currentUser.getVocabulary());
//        }
//    }
//
//    private void showAppVersion() {
//        TextView textView = (TextView) findViewById(R.id.app_version);
//        if (DebugConfig.getsIntance().enable) {
//            textView.setOnClickListener(this);
//        }
//        Context context = getContext();
//        String packageVersion = PackageUtils.getPackageVersion(context);
//        if (PackageUtils.isDebug(context)) {
//            textView.setText(String.format(Locale.CHINA, "版本(%s): %s", new Object[]{PackageUtils.getMetaData(context, "DEPLOY_DATE"), packageVersion}));
//            return;
//        }
//        textView.setText(String.format(Locale.CHINA, "版本: %s", new Object[]{packageVersion}));
//    }
//
//    public void setVocabulary(int i) {
//        if (i > 0) {
//            this.mVocabulary.setText(String.format(Locale.CHINA, "单词量 %d", new Object[]{Integer.valueOf(i)}));
//            this.mVocabulary.setVisibility(0);
//            return;
//        }
//        this.mVocabulary.setVisibility(8);
//    }
//
//    public void setNickName(String str) {
//        this.mUserName.setText(str);
//    }
//
//    public void onClick(View view) {
//        int id = view.getId();
//        if (id == R.id.user_line) {
//            userConfig();
//        } else if (id == R.id.schedule_line) {
//            schedule();
//        } else if (id == R.id.alarm_line) {
//            alarm();
//        } else if (id == R.id.feedback_line) {
//            feedback();
//        } else if (id == R.id.shopping_line) {
//            shopping();
//        } else if (id == R.id.vocabulary_test_line) {
//            vocabularyTest();
//        } else if (id == R.id.setting_line) {
//            setting();
//        } else if (id == R.id.try_user_alert) {
//            tryUserAlert();
//        } else if (id == R.id.app_version) {
//            debug();
//        }
//    }
//
//    private void userConfig() {
//        if (CommonUtils.ensureNetworkAvailable(getContext())) {
//            UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//            if (currentUser != null) {
//                Context context = getContext();
//                if (currentUser.getLoginType() == 3) {
//                    startAcitivityForResult(new Intent(context, BindAccountActivity.class), 1);
//                } else {
//                    startAcitivityForResult(new Intent(context, UserConfigActivity.class), 1);
//                }
//            }
//        }
//    }
//
//    private void tryUserAlert() {
//        C10921 r0 = new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                if (i == -1) {
//                    if (CommonUtils.ensureNetworkAvailable(LeftSlidingMenuView.this.getContext())) {
//                        ((Activity) LeftSlidingMenuView.this.getContext()).startActivityForResult(new Intent(LeftSlidingMenuView.this.getContext(), BindAccountActivity.class), 0);
//                    }
//                    dialogInterface.dismiss();
//                } else if (i == -2) {
//                    dialogInterface.dismiss();
//                }
//            }
//        };
//        new Builder(getContext()).setTitle((int) R.string.attention).setMessage((int) R.string.try_user_alert).setPositiveButton((CharSequence) "【好吧，去注册】", (DialogInterface.OnClickListener) r0).setNegativeButton((CharSequence) "【取消】", (DialogInterface.OnClickListener) r0).setCancelable(true).create().show();
//    }
//
//    private void debug() {
//        getContext().startActivity(new Intent(getContext(), DebugActivity.class));
//    }
//
//    private void schedule() {
//        if (CommonUtils.ensureNetworkAvailable(getContext())) {
//            startAcitivityForResult(new Intent(getContext(), ScheduleManagementActivity.class), 4);
//        }
//    }
//
//    private void feedback() {
//        if (CommonUtils.ensureNetworkAvailable(getContext())) {
//            EventBus.m0a().mo9c((Object) new FeedbackNewEvent(false));
//            getContext().startActivity(new Intent(getContext(), FeedbackActivity.class));
//            toggleDrawer(getContext());
//        }
//    }
//
//    private void setting() {
//        startAcitivityForResult(new Intent(getContext(), SettingActivity.class), 2);
//    }
//
//    private void alarm() {
//        if (CommonUtils.ensureNetworkAvailable(getContext())) {
//            startAcitivityForResult(new Intent(getContext(), EverydayNoticeActivity.class), 1);
//        }
//    }
//
//    private void shopping() {
//        GoStoreUtil.getInstance().load(getContext(), 1);
//        OperationStats.statShop();
//    }
//
//    private void vocabularyTest() {
//        Context context = getContext();
//        Class cls = MainActivity.class;
//        UserRecord currentUser = StudyManager.getInstance().getCurrentUser();
//        if (currentUser != null && currentUser.getVocabulary() > 0) {
//            cls = VocabStatsActivity.class;
//        }
//        startAcitivityForResult(new Intent(context, cls), 3);
//        OperationStats.statVocab();
//    }
//
//    private void startAcitivityForResult(Intent intent, int i) {
//        ((Activity) getContext()).startActivityForResult(intent, i);
//        toggleDrawer(getContext());
//    }
//
//    private void toggleDrawer(Context context) {
//        if (context instanceof MainTabActivity) {
//            ((MainTabActivity) context).toggleDrawer();
//        }
//    }
//
//    private void fetchMenuSettings() {
//        GoStoreUtil.getInstance().fetch(new AuthCallback<BBShoppingAd>() {
//            /* access modifiers changed from: protected */
//            public void onSuccess(BBShoppingAd bBShoppingAd) {
//                LeftSlidingMenuView.this.modifyMenu(LeftSlidingMenuView.this.mShop, bBShoppingAd);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Throwable th) {
//            }
//        });
//    }
//
//    /* access modifiers changed from: private */
//    public void modifyMenu(TextView textView, BBShoppingAd bBShoppingAd) {
//        if (textView != null && bBShoppingAd != null) {
//            if (!TextUtils.isEmpty(bBShoppingAd.getText())) {
//                textView.setText(bBShoppingAd.getText());
//            }
//            if (!TextUtils.isEmpty(bBShoppingAd.getColor())) {
//                try {
//                    textView.setTextColor(Color.parseColor(bBShoppingAd.getColor()));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    LogWrapper.m2794e(TAG, "color parse error: " + bBShoppingAd.getColor());
//                }
//            }
//        }
//    }
//
//    public void showFeedbackRedDot(boolean z) {
//        this.mFeedbackIcon.setShowRedDot(z);
//    }
//}
