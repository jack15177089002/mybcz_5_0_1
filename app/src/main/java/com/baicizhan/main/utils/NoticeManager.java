//package com.baicizhan.main.utils;
//
//import android.app.AlarmManager;
//import android.app.PendingIntent;
//import android.content.Context;
//import android.content.Intent;
//import com.baicizhan.client.business.dataset.helpers.MiscRecordHelper;
//import com.baicizhan.client.business.dataset.models.NoticeFinishRecord;
//import com.baicizhan.client.business.dataset.models.NoticeItemRecord;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.CollectionUtils;
//import com.baicizhan.client.business.util.CollectionUtils.Mapper;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.TimeUtil;
//import com.baicizhan.main.receiver.NoticeBroadcastReceiver;
//import com.baicizhan.online.bs_users.BBCheckInfo;
//import com.baicizhan.online.bs_users.BBUserNotifyMsg;
//import com.baicizhan.online.bs_users.BBUserNotifyResult;
//import com.baicizhan.online.bs_users.BBUserNotifySetting;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import java.util.Calendar;
//import java.util.Collection;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//public class NoticeManager {
//    private static final String TAG = NoticeManager.class.getSimpleName();
//    private static NoticeManager sInstance = null;
//
//    public static NoticeManager getsInstance() {
//        if (sInstance == null) {
//            synchronized (NoticeManager.class) {
//                if (sInstance == null) {
//                    sInstance = new NoticeManager();
//                }
//            }
//        }
//        return sInstance;
//    }
//
//    public void update(Context context, Client client) {
//        try {
//            BBCheckInfo checkInfo = StudyManager.getInstance().getCheckInfo();
//            if (checkInfo != null) {
//                long j = Settings.getLong(Settings.PREF_NOTICE_RESOURCE_VERSION);
//                long update_at_of_notify_info = checkInfo.getUpdate_at_of_notify_info();
//                LogWrapper.m2793d(TAG, "check notice version: " + j + " - " + update_at_of_notify_info);
//                if (j != update_at_of_notify_info) {
//                    List map = CollectionUtils.map((Collection<T>) client.get_all_notify_msgs(), (Mapper<T, R>) new Mapper<BBUserNotifyMsg, NoticeItemRecord>() {
//                        public NoticeItemRecord map(BBUserNotifyMsg bBUserNotifyMsg) {
//                            NoticeItemRecord noticeItemRecord = new NoticeItemRecord();
//                            noticeItemRecord.f2229id = bBUserNotifyMsg.getNtf_id();
//                            noticeItemRecord.person = bBUserNotifyMsg.getNtf_person();
//                            noticeItemRecord.day = bBUserNotifyMsg.getNtf_day();
//                            noticeItemRecord.time = bBUserNotifyMsg.getNtf_time();
//                            noticeItemRecord.content = bBUserNotifyMsg.getNtf_content();
//                            return noticeItemRecord;
//                        }
//                    });
//                    MiscRecordHelper.insertNoticeItemRecords(context, map);
//                    LogWrapper.m2793d(TAG, "save notice items " + map.size());
//                    Settings.putLong(Settings.PREF_NOTICE_RESOURCE_VERSION, update_at_of_notify_info);
//                }
//                BBUserNotifyResult bBUserNotifyResult = client.get_notify_info();
//                LogWrapper.m2793d(TAG, "get_notify_info " + bBUserNotifyResult);
//                if (!CollectionUtils.isEmpty((Collection<?>) bBUserNotifyResult.getNotify_msg())) {
//                    MiscRecordHelper.insertNoticeFinishRecords(context, CollectionUtils.map((Collection<T>) bBUserNotifyResult.getNotify_msg(), (Mapper<T, R>) new Mapper<BBUserNotifyMsg, NoticeFinishRecord>() {
//                        int index = 0;
//
//                        public NoticeFinishRecord map(BBUserNotifyMsg bBUserNotifyMsg) {
//                            NoticeFinishRecord noticeFinishRecord = new NoticeFinishRecord();
//                            noticeFinishRecord.f2228id = bBUserNotifyMsg.getNtf_id();
//                            noticeFinishRecord.person = bBUserNotifyMsg.getNtf_person();
//                            noticeFinishRecord.time = (long) this.index;
//                            noticeFinishRecord.status = 0;
//                            noticeFinishRecord.content = bBUserNotifyMsg.getNtf_content();
//                            this.index++;
//                            return noticeFinishRecord;
//                        }
//                    }));
//                }
//                BBUserNotifySetting notify_setting = bBUserNotifyResult.getNotify_setting();
//                if (notify_setting == null) {
//                    return;
//                }
//                if (notify_setting.getUse_notify() == 1) {
//                    setNotifySettingTimeMillis(context, TimeUnit.MILLISECONDS.convert(notify_setting.getUse_time(), TimeUnit.SECONDS));
//                } else {
//                    setNotifySettingTimeMillis(context, 0);
//                }
//            }
//        } catch (Exception e) {
//            apply(context, getNotifySettingTimeMillis());
//        }
//    }
//
//    public long getNotifySettingTimeMillis() {
//        return Settings.getLong(Settings.PREF_NOTICE_SETTING_TIME);
//    }
//
//    public void setNotifySettingTimeMillis(Context context, long j) {
//        Settings.putLong(Settings.PREF_NOTICE_SETTING_TIME, j);
//        apply(context, j);
//    }
//
//    private void apply(final Context context, final long j) {
//        AuthCallback.post(new Runnable() {
//            public void run() {
//                NoticeManager.this.applyInMainThread(context, j);
//            }
//        });
//    }
//
//    /* access modifiers changed from: private */
//    public void applyInMainThread(Context context, long j) {
//        LogWrapper.m2793d(TAG, "applyInMainThread " + j);
//        if (j > 0) {
//            Settings.putLong(Settings.PREF_NOTICE_SETTING_TIME, j);
//            setAlarm(context, j);
//            return;
//        }
//        Settings.putLong(Settings.PREF_NOTICE_SETTING_TIME, 0);
//        cancelAlarm(context);
//    }
//
//    public static long toNotifySettingTimeMillis(int i, int i2) {
//        Calendar instance = Calendar.getInstance();
//        long timeInMillis = instance.getTimeInMillis();
//        instance.set(11, i);
//        instance.set(12, i2);
//        instance.set(13, 0);
//        long timeInMillis2 = instance.getTimeInMillis();
//        if (timeInMillis2 < timeInMillis) {
//            return timeInMillis2 + TimeUtil.DAY_MILLIS;
//        }
//        return timeInMillis2;
//    }
//
//    public static void markNoticedToday(boolean z) {
//        Settings.putLong(Settings.PREF_LAST_REMIND_TIME, z ? System.currentTimeMillis() : 0);
//    }
//
//    private static void cancelAlarm(Context context) {
//        LogWrapper.m2793d(TAG, "cancelAlarm ...");
//        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
//        Intent intent = new Intent(context, NoticeBroadcastReceiver.class);
//        intent.setAction(NoticeBroadcastReceiver.ACTION_NOTICE_ALARM);
//        alarmManager.cancel(PendingIntent.getBroadcast(context, 0, intent, 0));
//    }
//
//    private static void setAlarm(Context context, long j) {
//        Calendar instance = Calendar.getInstance();
//        instance.setTimeInMillis(j);
//        setAlarm(context, instance.get(11), instance.get(12));
//    }
//
//    private static void setAlarm(Context context, int i, int i2) {
//        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
//        long notifySettingTimeMillis = toNotifySettingTimeMillis(i, i2);
//        LogWrapper.m2793d(TAG, "setAlarm " + i + ", " + i2 + ", " + notifySettingTimeMillis);
//        Intent intent = new Intent(context, NoticeBroadcastReceiver.class);
//        intent.setAction(NoticeBroadcastReceiver.ACTION_NOTICE_ALARM);
//        alarmManager.setRepeating(0, notifySettingTimeMillis, TimeUtil.DAY_MILLIS, PendingIntent.getBroadcast(context, 0, intent, 268435456));
//    }
//}
