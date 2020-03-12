package com.baicizhan.main.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
//import com.baicizhan.client.business.managers.LearnRecordManager;
import com.baicizhan.client.business.util.LogWrapper;

public class LearnOperationReceiver extends BroadcastReceiver {
    public static final String ACTION_CANCEL_KILL = "cancel_kill";
    public static final String ACTION_KILL = "kill";
    public static final String EXTRA_BOOK_ID = "book_id";
    public static final String EXTRA_TOPIC_ID = "topic_id";
    private static final String TAG = LearnOperationReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        int i = extras.getInt("book_id");
        int i2 = extras.getInt("topic_id");
        if (ACTION_KILL.equals(action)) {
            kill(context, i, i2);
        } else if (ACTION_CANCEL_KILL.equals(action)) {
            cancelKill(context, i, i2);
        } else {
            LogWrapper.m2793d(TAG, "Unsupported action " + action);
        }
    }

    public void kill(Context context, int i, int i2) {
//        LearnRecordManager instance = LearnRecordManager.getInstance();
//        if (!instance.hasInited() || instance.getBookId() != i) {
//            LearnRecordManager.killInDatabase(context, i, i2);
//        } else {
//            instance.kill(i2, 0);
//        }
    }

    public void cancelKill(Context context, int i, int i2) {
//        LearnRecordManager instance = LearnRecordManager.getInstance();
//        if (!instance.hasInited() || instance.getBookId() != i) {
//            throw new RuntimeException("cancelKill");
//        }
//        instance.cancelKill(i2);
    }
}
