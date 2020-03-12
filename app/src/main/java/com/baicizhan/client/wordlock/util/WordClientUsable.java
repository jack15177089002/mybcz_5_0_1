package com.baicizhan.client.wordlock.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class WordClientUsable {
    private BroadcastReceiver mAlarmClockReceiver;
    /* access modifiers changed from: private */
    public Callback mCallback;
    private final Context mContext;
    private boolean mStarted;

    public interface Callback {
        void onWordClientDisabled();
    }

    class CustomPhoneStateListener extends PhoneStateListener {
        private CustomPhoneStateListener() {
        }

        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                case 2:
                    if (WordClientUsable.this.mCallback != null) {
                        WordClientUsable.this.mCallback.onWordClientDisabled();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public WordClientUsable(Context context) {
        this(context, null);
    }

    public WordClientUsable(Context context, Callback callback) {
        this.mStarted = false;
        this.mAlarmClockReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                Log.d("whiz", "alarm action: " + intent.getAction());
//                if (WordClientUsable.this.mCallback != null && AlarmClockAdapter.isAlarmAlert(intent.getAction())) {
//                    WordClientUsable.this.mCallback.onWordClientDisabled();
//                }
            }
        };
        this.mContext = context;
        if (context == null) {
            throw new RuntimeException("word client usable must not has a null context.");
        }
        this.mCallback = callback;
    }

    private void listenToPhoneCall() {
        TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        telephonyManager.listen(new CustomPhoneStateListener(), 32);
        switch (telephonyManager.getCallState()) {
            case 1:
            case 2:
                if (this.mCallback != null) {
                    this.mCallback.onWordClientDisabled();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private boolean isPhoneCalling() {
        switch (((TelephonyManager) this.mContext.getSystemService("phone")).getCallState()) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public void start() {
//        AlarmClockAdapter.registerAlarmAlert(this.mContext, this.mAlarmClockReceiver);
        listenToPhoneCall();
        this.mStarted = true;
    }

    public void stop() {
        if (this.mStarted) {
            this.mContext.unregisterReceiver(this.mAlarmClockReceiver);
        }
        this.mStarted = false;
    }

    public boolean isUsable() {
//        return !AlarmClockAdapter.isAlarmRinging() && !isPhoneCalling();

        return false;
    }
}
