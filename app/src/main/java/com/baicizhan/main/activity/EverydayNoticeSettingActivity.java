//package com.baicizhan.main.activity;
//
//import android.app.Activity;
//import android.graphics.drawable.GradientDrawable;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.CompoundButton;
//import android.widget.CompoundButton.OnCheckedChangeListener;
//import android.widget.Toast;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.stats.UMStats;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.widget.BczLoadingDialog;
//import com.baicizhan.client.framework.util.DisplayUtils;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.main.utils.NoticeManager;
//import com.baicizhan.online.bs_users.BBUserNotifySetting;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//import com.kyleduo.switchbutton.SwitchButton;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Locale;
//import java.util.concurrent.TimeUnit;
//import kankan.wheel.widget.WheelView;
//import kankan.wheel.widget.p098a.NumericWheelAdapter;
//
//public class EverydayNoticeSettingActivity extends Activity implements OnClickListener {
//    /* access modifiers changed from: private */
//    public static final String TAG = EverydayNoticeSettingActivity.class.getSimpleName();
//    View mDatePickerView;
//    NumericWheelAdapter mHourAdapter;
//    WheelView mHourWheelView;
//    NumericWheelAdapter mMinuteAdapter;
//    WheelView mMinuteWheelView;
//    OnCheckedChangeListener mOnCheckedChangeListener = new OnCheckedChangeListener() {
//        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
//            Log.d(EverydayNoticeSettingActivity.TAG, "notice isChecke ..." + z);
//            if (z) {
//                EverydayNoticeSettingActivity.this.mDatePickerView.setVisibility(0);
//            } else {
//                EverydayNoticeSettingActivity.this.mDatePickerView.setVisibility(4);
//            }
//        }
//    };
//    BczLoadingDialog mProgressDialog;
//    ThriftRequest<Client, Integer> mSetNoticeRequest;
//    SwitchButton mSwitcher;
//
//    /* access modifiers changed from: protected */
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        ThemeUtil.setThemeOnActivityCreate(this);
//        if (!StudyManager.getInstance().checkRestart(this)) {
//            setContentView(R.layout.activity_everyday_notice_setting);
//            findViewById(R.id.back).setOnClickListener(this);
//            findViewById(R.id.confirm).setOnClickListener(this);
//            this.mSwitcher = (SwitchButton) findViewById(R.id.switcher);
//            this.mSwitcher.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
//            this.mDatePickerView = findViewById(R.id.notice_date_picker);
//            GradientDrawable gradientDrawable = new GradientDrawable();
//            gradientDrawable.setShape(0);
//            float dpToPx = (float) DisplayUtils.dpToPx(this, 10.0f);
//            gradientDrawable.setCornerRadii(new float[]{dpToPx, dpToPx, dpToPx, dpToPx, 0.0f, 0.0f, 0.0f, 0.0f});
//            gradientDrawable.setColor(ThemeUtil.getThemeColorWithAttr(this, R.attr.color_window_bg));
//            C1604j.m3631a(this.mDatePickerView, gradientDrawable);
//            this.mHourWheelView = (WheelView) findViewById(R.id.notice_hour);
//            this.mHourWheelView.setWheelForeground(R.drawable.wheel_val_holo);
//            this.mHourAdapter = new NumericWheelAdapter(this, 23, "%d时");
//            this.mHourAdapter.setItemResource(R.layout.notice_item_view);
//            this.mHourWheelView.setViewAdapter(this.mHourAdapter);
//            this.mHourWheelView.setDrawShadows(false);
//            this.mMinuteWheelView = (WheelView) findViewById(R.id.notice_minute);
//            this.mMinuteWheelView.setWheelForeground(R.drawable.wheel_val_holo);
//            this.mMinuteAdapter = new NumericWheelAdapter(this, 59, "%d分");
//            this.mMinuteAdapter.setItemResource(R.layout.notice_item_view);
//            this.mMinuteWheelView.setViewAdapter(this.mMinuteAdapter);
//            this.mMinuteWheelView.setDrawShadows(false);
//            long notifySettingTimeMillis = NoticeManager.getsInstance().getNotifySettingTimeMillis();
//            if (notifySettingTimeMillis > 0) {
//                Calendar instance = Calendar.getInstance();
//                instance.setTimeInMillis(notifySettingTimeMillis);
//                int i = instance.get(11);
//                int i2 = instance.get(12);
//                this.mHourWheelView.setCurrentItem(i);
//                this.mMinuteWheelView.setCurrentItem(i2);
//                this.mSwitcher.setChecked(true);
//                LogWrapper.m2793d(TAG, "notice set " + i + ", " + i2);
//            } else {
//                LogWrapper.m2793d(TAG, "notice not set ");
//                this.mSwitcher.setChecked(false);
//            }
//            this.mOnCheckedChangeListener.onCheckedChanged(this.mSwitcher, this.mSwitcher.isChecked());
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
//        this.mProgressDialog.dismiss();
//    }
//
//    public void onClick(View view) {
//        int id = view.getId();
//        if (id == R.id.back) {
//            finish();
//        } else if (id == R.id.confirm) {
//            confirm();
//        }
//    }
//
//    private void confirm() {
//        if (this.mSwitcher.isChecked()) {
//            setAlarm(this.mHourWheelView.getCurrentItem(), this.mMinuteWheelView.getCurrentItem());
//        } else {
//            cancelAlarm();
//        }
//    }
//
//    private void setAlarm(int i, int i2) {
//        final long notifySettingTimeMillis = NoticeManager.toNotifySettingTimeMillis(i, i2);
//        this.mSetNoticeRequest = new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            public Integer doInBackground(Client client) {
//                BBUserNotifySetting bBUserNotifySetting = new BBUserNotifySetting();
//                bBUserNotifySetting.setUse_notify(1);
//                bBUserNotifySetting.setUse_time(TimeUnit.SECONDS.convert(notifySettingTimeMillis, TimeUnit.MILLISECONDS));
//                return Integer.valueOf(client.set_notify_info(bBUserNotifySetting));
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                EverydayNoticeSettingActivity.this.mProgressDialog.hide();
//                CommonUtils.toastThriftErrorMsg(EverydayNoticeSettingActivity.this, exc);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(Integer num) {
//                EverydayNoticeSettingActivity.this.mProgressDialog.hide();
//                if (num.intValue() == 0) {
//                    NoticeManager.getsInstance().setNotifySettingTimeMillis(EverydayNoticeSettingActivity.this, notifySettingTimeMillis);
//                    if (notifySettingTimeMillis > System.currentTimeMillis()) {
//                        NoticeManager.markNoticedToday(false);
//                    }
//                    Toast.makeText(EverydayNoticeSettingActivity.this, "单词提醒开启，下次提醒时间是\n" + new SimpleDateFormat("MM月dd日 HH:mm", Locale.CHINA).format(new Date(notifySettingTimeMillis)), 1).show();
//                    EverydayNoticeSettingActivity.this.finish();
//                }
//            }
//        };
//        BaicizhanThrifts.getProxy().add(this.mSetNoticeRequest);
//        this.mProgressDialog.setMessage((CharSequence) "设置中，请稍候...");
//        this.mProgressDialog.show();
//    }
//
//    private void cancelAlarm() {
//        this.mSetNoticeRequest = new ThriftRequest<Client, Integer>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            public Integer doInBackground(Client client) {
//                BBUserNotifySetting bBUserNotifySetting = new BBUserNotifySetting();
//                bBUserNotifySetting.setUse_notify(0);
//                bBUserNotifySetting.setUse_time(0);
//                return Integer.valueOf(client.set_notify_info(bBUserNotifySetting));
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                EverydayNoticeSettingActivity.this.mProgressDialog.hide();
//                CommonUtils.toastThriftErrorMsg(EverydayNoticeSettingActivity.this, exc);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(Integer num) {
//                EverydayNoticeSettingActivity.this.mProgressDialog.hide();
//                NoticeManager.getsInstance().setNotifySettingTimeMillis(EverydayNoticeSettingActivity.this, 0);
//                Toast.makeText(EverydayNoticeSettingActivity.this, "单词提醒已关闭", 0).show();
//                EverydayNoticeSettingActivity.this.finish();
//            }
//        };
//        BaicizhanThrifts.getProxy().add(this.mSetNoticeRequest);
//        this.mProgressDialog.setMessage((CharSequence) "取消中，请稍候...");
//        this.mProgressDialog.show();
//    }
//}
