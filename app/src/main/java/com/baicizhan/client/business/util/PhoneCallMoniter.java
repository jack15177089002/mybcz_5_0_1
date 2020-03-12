package com.baicizhan.client.business.util;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class PhoneCallMoniter {
    private Context mContext;
    /* access modifiers changed from: private */
    public PhoneCallListener mListener;

    class CustomPhoneStateListener extends PhoneStateListener {
        private CustomPhoneStateListener() {
        }

        public void onCallStateChanged(int i, String str) {
            switch (i) {
                case 1:
                case 2:
                    if (PhoneCallMoniter.this.mListener != null) {
                        PhoneCallMoniter.this.mListener.onPhoneCallStart();
                        return;
                    }
                    return;
                default:
                    if (PhoneCallMoniter.this.mListener != null) {
                        PhoneCallMoniter.this.mListener.onPhoneCallStop();
                        return;
                    }
                    return;
            }
        }
    }

    public interface PhoneCallListener {
        void onPhoneCallStart();

        void onPhoneCallStop();
    }

    public static PhoneCallMoniter born(Context context) {
        return new PhoneCallMoniter(context);
    }

    private PhoneCallMoniter(Context context) {
        this.mContext = context;
    }

    public PhoneCallMoniter setListener(PhoneCallListener phoneCallListener) {
        this.mListener = phoneCallListener;
        return this;
    }

    private void listenToPhoneCall() {
        TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        telephonyManager.listen(new CustomPhoneStateListener(), 32);
        switch (telephonyManager.getCallState()) {
            case 1:
            case 2:
                if (this.mListener != null) {
                    this.mListener.onPhoneCallStart();
                    return;
                }
                return;
            default:
                if (this.mListener != null) {
                    this.mListener.onPhoneCallStop();
                    return;
                }
                return;
        }
    }

    public boolean isPhoneCalling() {
        switch (((TelephonyManager) this.mContext.getSystemService("phone")).getCallState()) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public void start() {
        listenToPhoneCall();
    }
}
