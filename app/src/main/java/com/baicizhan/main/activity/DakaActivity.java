//package com.baicizhan.main.activity;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.BitmapFactory;
//import android.graphics.drawable.GradientDrawable;
//import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextUtils;
//import android.text.TextWatcher;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.WindowManager.LayoutParams;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//import com.baicizhan.client.business.auth.WXShareProxy;
//import com.baicizhan.client.business.auth.WeiboShare;
//import com.baicizhan.client.business.auth.WeixinShare;
//import com.baicizhan.client.business.dataset.helpers.BookRecordHelper;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.dataset.models.ScheduleRecord;
//import com.baicizhan.client.business.managers.LearnRecordManager;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.PicassoUtil.Corners;
//import com.baicizhan.client.business.util.PicassoUtil.RoundedTransformation;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.TimeUtil;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.online.bs_users.BBDakaInfo;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import com.p055f.p056a.C1574ao;
//import com.p055f.p056a.C1578av;
//import com.p055f.p056a.C1584bj;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.FetchAction;
//import com.p055f.p056a.Picasso;
//import com.p055f.p056a.Request;
//import com.p055f.p056a.RequestCreator;
//import com.p055f.p056a.Transformation;
//import java.util.Locale;
//
//public class DakaActivity extends Activity implements OnClickListener {
//    public static final String EXTRA_PORTRAIT_MODE = "portrait_mode";
//    private static final int MAX_CONTENT_LEN = 140;
//    static final String TAG = DakaActivity.class.getSimpleName();
//    /* access modifiers changed from: private */
//    public BBDakaInfo mDakaInfo;
//    ThriftRequest<Client, BBDakaInfo> mDakaInfoRequest;
//    ThriftRequest<Client, Integer> mDakaNotifyRequest;
//    private TextView mLeftCount;
//    private boolean mPortraitMode;
//    /* access modifiers changed from: private */
//    public BczLoadingDialog mProgressDialog;
//    Transformation mRoundedCornerTrans;
//    AuthCallback<Void> mShareCallback = new AuthCallback<Void>() {
//        /* access modifiers changed from: protected */
//        public void onSuccess(Void voidR) {
//            Toast.makeText(DakaActivity.this, "打卡成功", 0).show();
//            final int i = DakaActivity.this.mDakaInfo.daka_id;
//            DakaActivity.this.mDakaNotifyRequest = new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//                /* access modifiers changed from: protected */
//                public Integer doInBackground(Client client) {
//                    return Integer.valueOf(client.daka_success_notify(i));
//                }
//
//                /* access modifiers changed from: protected */
//                public void onError(Exception exc) {
//                }
//
//                /* access modifiers changed from: protected */
//                public void onResult(Integer num) {
//                }
//            };
//            BaicizhanThrifts.getProxy().add(DakaActivity.this.mDakaNotifyRequest);
//            DakaActivity.this.finish();
//        }
//
//        /* access modifiers changed from: protected */
//        public void onError(Throwable th) {
//            DakaActivity.this.onDakaFailed(th.getMessage());
//        }
//    };
//    private EditText mText;
//    private ImageView mTitle;
//    private WXShareProxy mWXShareProxy;
//    private WeiboShare mWeiboShare;
//    private WeixinShare mWeixinShare;
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            ScheduleRecord currentSchedule = StudyManager.getInstance().getCurrentSchedule();
//            long currentTimeMillis = System.currentTimeMillis();
//            if (TimeUtil.getBetweenDays(currentSchedule.lastDakaTime * 1000, currentTimeMillis) > 0) {
//                currentSchedule.dakaDays++;
//                currentSchedule.lastDakaTime = currentTimeMillis / 1000;
//            }
//            currentSchedule.dakaDays = Math.max(currentSchedule.dakaDays, 1);
//            BookRecordHelper.updateSchedule(this, currentSchedule, "dakaDays", "lastDakaTime");
//            if (StudyManager.getInstance().getCurrentSchedule() == null) {
//                finish();
//                return;
//            }
//            this.mProgressDialog = CommonUtils.createProgressDialog(this);
//            String string = Settings.getString(Settings.PREF_DAKA_TITLE_IMAGE);
//            LogWrapper.m2793d(TAG, "preload image " + string);
//            if (!TextUtils.isEmpty(string)) {
//                RequestCreator a = Picasso.with((Context) this).load(string);
//                long nanoTime = System.nanoTime();
//                if (a.f3709e) {
//                    throw new IllegalStateException("Fit cannot be used with fetch.");
//                } else if (a.f3706b.mo16328a()) {
//                    if (!(a.f3706b.f3703n != 0)) {
//                        C1578av avVar = a.f3706b;
//                        int i = C1574ao.f3658a;
//                        if (i == 0) {
//                            throw new IllegalArgumentException("Priority invalid.");
//                        } else if (avVar.f3703n != 0) {
//                            throw new IllegalStateException("Priority already set.");
//                        } else {
//                            avVar.f3703n = i;
//                        }
//                    }
//                    Request a2 = a.mo16329a(nanoTime);
//                    a.f3705a.mo16308b((Action) new FetchAction(a.f3705a, a2, a.f3707c, C1584bj.m3552a(a2, new StringBuilder()), a.f3713i));
//                }
//            }
//            if (getIntent().hasExtra("portrait_mode")) {
//                this.mPortraitMode = getIntent().getBooleanExtra("portrait_mode", false);
//            } else {
//                this.mPortraitMode = PropertyHelper.getBoolean("portrait_mode");
//            }
//            if (this.mPortraitMode) {
//                setRequestedOrientation(1);
//            } else {
//                setRequestedOrientation(0);
//            }
//            getWindow().setBackgroundDrawable(null);
//            LayoutParams attributes = getWindow().getAttributes();
//            attributes.dimAmount = 0.5f;
//            attributes.flags |= 2;
//            getWindow().setAttributes(attributes);
//            getWindow().addFlags(2);
//            setContentView(R.layout.activity_daka);
//            int dpToPx = DisplayUtils.dpToPx(this, 8.0f);
//            this.mRoundedCornerTrans = new RoundedTransformation(dpToPx, Corners.TOP);
//            View findViewById = findViewById(R.id.daka_card);
//            GradientDrawable gradientDrawable = new GradientDrawable();
//            gradientDrawable.setShape(0);
//            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, (float) dpToPx, (float) dpToPx, (float) dpToPx, (float) dpToPx});
//            gradientDrawable.setColor(ThemeUtil.getThemeColorWithAttr(this, R.attr.color_common_white));
//            C1604j.m3631a(findViewById, gradientDrawable);
//            this.mTitle = (ImageView) findViewById(R.id.title);
//            this.mText = (EditText) findViewById(R.id.text);
//            GradientDrawable gradientDrawable2 = new GradientDrawable();
//            gradientDrawable2.setShape(0);
//            gradientDrawable2.setCornerRadius((float) DisplayUtils.dpToPx(this, 4.0f));
//            gradientDrawable2.setStroke(1, ThemeUtil.getThemeColorWithAttr(this, R.attr.color_button_text_mediabar));
//            gradientDrawable2.setColor(ThemeUtil.getThemeColorWithAttr(this, R.attr.color_common_white));
//            C1604j.m3631a(this.mText, gradientDrawable2);
//            this.mText.addTextChangedListener(new TextWatcher() {
//                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
//                }
//
//                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
//                }
//
//                public void afterTextChanged(Editable editable) {
//                    DakaActivity.this.updateLeftCount();
//                }
//            });
//            this.mLeftCount = (TextView) findViewById(R.id.left_count);
//            final int i2 = StudyManager.getInstance().getCurrentSchedule().dakaDays;
//            final int todayTouchCount = LearnRecordManager.getInstance().getTodayTouchCount();
//            this.mDakaInfoRequest = new ThriftRequest<Client, BBDakaInfo>(BaicizhanThrifts.USERS) {
//                /* access modifiers changed from: protected */
//                public BBDakaInfo doInBackground(Client client) {
//                    BBDakaInfo do_daka = client.do_daka(i2, todayTouchCount);
//                    LogWrapper.m2793d(DakaActivity.TAG, "do_daka " + i2 + ", " + todayTouchCount + ", " + do_daka);
//                    return do_daka;
//                }
//
//                /* access modifiers changed from: protected */
//                public void onError(Exception exc) {
//                    DakaActivity.this.mProgressDialog.hide();
//                    DakaActivity.this.onDakaFailed(CommonUtils.getThriftErrorMsg(DakaActivity.this, exc));
//                }
//
//                /* access modifiers changed from: protected */
//                public void onResult(BBDakaInfo bBDakaInfo) {
//                    DakaActivity.this.onGetDakaInfo(bBDakaInfo);
//                }
//            };
//            this.mDakaInfoRequest.setTag(TAG);
//            BaicizhanThrifts.getProxy().add(this.mDakaInfoRequest);
//            this.mProgressDialog.show();
//            this.mWXShareProxy = WXShareProxy.born(this);
//        }
//    }
//
//    public void onResume() {
//        super.onResume();
//        UMStats.traceOnActivityResume(this);
//        this.mWXShareProxy.resume();
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
//        this.mWXShareProxy.cancel();
//    }
//
//    /* access modifiers changed from: private */
//    public void onGetDakaInfo(BBDakaInfo bBDakaInfo) {
//        this.mDakaInfo = bBDakaInfo;
//        LogWrapper.m2793d(TAG, "load image " + bBDakaInfo.getShare_img_url());
//        RequestCreator a = Picasso.with((Context) this).load(bBDakaInfo.getShare_img_url());
//        a.f3708d = true;
//        a.mo16332a(this.mRoundedCornerTrans).error(R.drawable.checkin_default_normal_default).into(this.mTitle, (Callback) new Callback() {
//            public void onSuccess() {
//                DakaActivity.this.mProgressDialog.hide();
//            }
//
//            public void onError() {
//                DakaActivity.this.mProgressDialog.hide();
//            }
//        });
//        Settings.putString(Settings.PREF_DAKA_TITLE_IMAGE, bBDakaInfo.getShare_img_url());
//        this.mText.setText(this.mDakaInfo.getWeibo_share_txt());
//        updateLeftCount();
//        findViewById(R.id.close).setOnClickListener(this);
//        findViewById(R.id.share_to_weibo).setOnClickListener(this);
//        findViewById(R.id.share_to_weixin_timeline).setOnClickListener(this);
//        findViewById(R.id.share_to_weixin_session).setOnClickListener(this);
//    }
//
//    /* access modifiers changed from: private */
//    public void onDakaFailed(String str) {
//        Toast.makeText(this, str, 0).show();
//        finish();
//    }
//
//    /* access modifiers changed from: private */
//    public void updateLeftCount() {
//        int length = 140 - this.mText.getText().length();
//        this.mLeftCount.setText(String.format(Locale.CHINA, "还可以输入%d个字", new Object[]{Integer.valueOf(length)}));
//    }
//
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.close /*2131296297*/:
//                finish();
//                return;
//            case R.id.share_to_weibo /*2131296301*/:
//                this.mWeiboShare = new WeiboShare(this, this.mDakaInfo.getShare_img_url(), this.mText.getText().toString(), this.mShareCallback);
//                this.mWeiboShare.share();
//                OperationStats.statDakaWB();
//                return;
//            case R.id.share_to_weixin_timeline /*2131296302*/:
//                this.mWeixinShare = new WeixinShare(this, this.mDakaInfo.getWeixin_share_url(), this.mText.getText().toString(), this.mDakaInfo.getWeixin_share_title(), BitmapFactory.decodeResource(getResources(), R.drawable.iph_xueba), 1, this.mShareCallback);
//                this.mWXShareProxy.share(this.mWeixinShare, this.mPortraitMode);
//                OperationStats.statDakaWXMoments();
//                return;
//            case R.id.share_to_weixin_session /*2131296303*/:
//                this.mWeixinShare = new WeixinShare(this, this.mDakaInfo.getWeixin_share_url(), this.mText.getText().toString(), this.mDakaInfo.getWeixin_share_title(), BitmapFactory.decodeResource(getResources(), R.drawable.iph_xueba), 0, this.mShareCallback);
//                this.mWXShareProxy.share(this.mWeixinShare, this.mPortraitMode);
//                OperationStats.statDakaWXFriend();
//                return;
//            default:
//                return;
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onActivityResult(int i, int i2, Intent intent) {
//        super.onActivityResult(i, i2, intent);
//        if (this.mWeiboShare != null) {
//            this.mWeiboShare.onActivityResult(i, i2, intent);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        if (this.mWeixinShare != null) {
//            this.mWeixinShare.onNewIntent(intent);
//        }
//    }
//}
