package com.baicizhan.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.baicizhan.client.business.util.LogWrapper;
import com.baicizhan.client.framework.util.Common;

public class ExitBroadcastReceiver extends BroadcastReceiver {
    public static final String EXTRA_CREATE_TIME = "extra_create_time";
    private static final String TAG = ExitBroadcastReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        LogWrapper.m2793d(TAG, "intent " + intent);
        if (intent != null) {
            LogWrapper.m2795i(TAG, "!!!!!!!!! process exit ... " + Process.myPid() + ", " + Common.getProcessName(context));
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }
}
