//package com.baicizhan.client.wordlock.view;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.database.ContentObserver;
//import android.graphics.Typeface;
//import android.os.Handler;
//import android.provider.Settings.System;
//import android.text.format.DateFormat;
//import android.util.AttributeSet;
//import android.view.View;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import com.baicizhan.client.wordlock.C0882R;
//import com.baicizhan.client.wordlock.util.CustomFont;
//import java.lang.ref.WeakReference;
//import java.text.DateFormatSymbols;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Locale;
//
//public class StatusView extends RelativeLayout {
//    private static final String M12 = "h:mm";
//    private static final String M24 = "HH:mm";
//    private AmPm mAmPm;
//    private int mAttached;
//    /* access modifiers changed from: private */
//    public Calendar mCalendar;
//    private SimpleDateFormat mDateFormat;
//    private TextView mDateView;
//    private String mFormat;
//    private ContentObserver mFormatChangeObserver;
//    /* access modifiers changed from: private */
//    public final Handler mHandler;
//    private BroadcastReceiver mIntentReceiver;
//    private TextView mTimeView;
//    private SimpleDateFormat mWeekFormat;
//    private TextView mWeekView;
//
//    class AmPm {
//        private TextView mAmPmTextView;
//        private String mAmString;
//        private String mPmString;
//
//        AmPm(View view, Typeface typeface) {
//            if (!(this.mAmPmTextView == null || typeface == null)) {
//                this.mAmPmTextView.setTypeface(typeface);
//            }
//            String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
//            this.mAmString = amPmStrings[0];
//            this.mPmString = amPmStrings[1];
//        }
//
//        /* access modifiers changed from: 0000 */
//        public void setShowAmPm(boolean z) {
//            if (this.mAmPmTextView != null) {
//                this.mAmPmTextView.setVisibility(z ? 0 : 8);
//            }
//        }
//
//        /* access modifiers changed from: 0000 */
//        public void setIsMorning(boolean z) {
//            if (this.mAmPmTextView != null) {
//                this.mAmPmTextView.setText(z ? this.mAmString : this.mPmString);
//            }
//        }
//    }
//
//    class FormatChangeObserver extends ContentObserver {
//        private Context mContext;
//        private WeakReference<StatusView> mStatus;
//
//        public FormatChangeObserver(StatusView statusView) {
//            super(new Handler());
//            this.mStatus = new WeakReference<>(statusView);
//            this.mContext = statusView.getContext();
//        }
//
//        public void onChange(boolean z) {
//            StatusView statusView = (StatusView) this.mStatus.get();
//            if (statusView != null) {
//                statusView.setTimeFormat();
//                statusView.updateTime();
//                return;
//            }
//            try {
//                this.mContext.getContentResolver().unregisterContentObserver(this);
//            } catch (RuntimeException e) {
//            }
//        }
//    }
//
//    class TimeChangedReceiver extends BroadcastReceiver {
//        private Context mContext;
//        private WeakReference<StatusView> mStatus;
//
//        public TimeChangedReceiver(StatusView statusView) {
//            this.mStatus = new WeakReference<>(statusView);
//            this.mContext = statusView.getContext();
//        }
//
//        public void onReceive(Context context, Intent intent) {
//            final boolean equals = intent.getAction().equals("android.intent.action.TIMEZONE_CHANGED");
//            final StatusView statusView = (StatusView) this.mStatus.get();
//            if (statusView != null) {
//                statusView.mHandler.post(new Runnable() {
//                    public void run() {
//                        if (equals) {
//                            statusView.mCalendar = Calendar.getInstance();
//                        }
//                        statusView.updateTime();
//                    }
//                });
//                return;
//            }
//            try {
//                this.mContext.unregisterReceiver(this);
//            } catch (RuntimeException e) {
//            }
//        }
//    }
//
//    public StatusView(Context context) {
//        this(context, null);
//    }
//
//    public StatusView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        this.mAttached = 0;
//        this.mHandler = new Handler();
//    }
//
//    /* access modifiers changed from: protected */
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mTimeView = (TextView) findViewById(C0882R.C0883id.wordlock_time);
//        CustomFont.setFont(this.mTimeView, 2);
//        this.mAmPm = new AmPm(this, null);
//        this.mCalendar = Calendar.getInstance();
//        setTimeFormat();
//        Locale locale = Locale.getDefault();
//        this.mWeekFormat = new SimpleDateFormat(getBestWeekPattern(), locale);
//        this.mDateFormat = new SimpleDateFormat(getBestDatePattern(), locale);
//        this.mWeekView = (TextView) findViewById(C0882R.C0883id.wordlock_week);
//        CustomFont.setFont(this.mWeekView, 1);
//        this.mDateView = (TextView) findViewById(C0882R.C0883id.wordlock_date);
//        CustomFont.setFont(this.mDateView, 2);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        this.mAttached++;
//        if (this.mIntentReceiver == null) {
//            this.mIntentReceiver = new TimeChangedReceiver(this);
//            IntentFilter intentFilter = new IntentFilter();
//            intentFilter.addAction("android.intent.action.TIME_TICK");
//            intentFilter.addAction("android.intent.action.TIME_SET");
//            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
//            getContext().registerReceiver(this.mIntentReceiver, intentFilter);
//        }
//        if (this.mFormatChangeObserver == null) {
//            this.mFormatChangeObserver = new FormatChangeObserver(this);
//            getContext().getContentResolver().registerContentObserver(System.CONTENT_URI, true, this.mFormatChangeObserver);
//        }
//        updateTime();
//    }
//
//    /* access modifiers changed from: protected */
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        this.mAttached--;
//        if (this.mIntentReceiver != null) {
//            getContext().unregisterReceiver(this.mIntentReceiver);
//        }
//        if (this.mFormatChangeObserver != null) {
//            getContext().getContentResolver().unregisterContentObserver(this.mFormatChangeObserver);
//        }
//        this.mFormatChangeObserver = null;
//        this.mIntentReceiver = null;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void updateTime(Calendar calendar) {
//        this.mCalendar = calendar;
//        updateTime();
//    }
//
//    public void updateTime() {
//        this.mCalendar.setTimeInMillis(System.currentTimeMillis());
//        this.mTimeView.setText(new SimpleDateFormat(this.mFormat, Locale.getDefault()).format(new Date()));
//        this.mAmPm.setIsMorning(this.mCalendar.get(9) == 0);
//        refreshDate();
//    }
//
//    /* access modifiers changed from: private */
//    public void setTimeFormat() {
//        this.mFormat = DateFormat.is24HourFormat(getContext()) ? M24 : M12;
//        this.mAmPm.setShowAmPm(this.mFormat.equals(M12));
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void refreshDate() {
//        maybeSetUpperCaseText(this.mWeekView, this.mWeekFormat.format(new Date()));
//        maybeSetUpperCaseText(this.mDateView, this.mDateFormat.format(new Date()));
//    }
//
//    private void maybeSetUpperCaseText(TextView textView, CharSequence charSequence) {
//        textView.setText(charSequence != null ? charSequence.toString().toUpperCase(Locale.CHINA) : null);
//    }
//
//    private static final String getBestWeekPattern() {
//        return "EEE";
//    }
//
//    private static final String getBestDatePattern() {
//        String country = Locale.getDefault().getCountry();
//        if (country.equals("CN") || country.equals("TW")) {
//            return "MM.dd";
//        }
//        return "dd MMMM";
//    }
//
//    public int getAttached() {
//        return this.mAttached;
//    }
//}
