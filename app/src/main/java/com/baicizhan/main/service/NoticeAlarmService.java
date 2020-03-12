//package com.baicizhan.main.service;
//
//import android.app.Notification;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.content.res.Resources;
//import android.net.Uri;
//import android.os.Build.VERSION;
//import android.os.IBinder;
//import android.text.TextUtils;
//import com.baicizhan.client.business.dataset.helpers.MiscRecordHelper;
//import com.baicizhan.client.business.dataset.models.NoticeFinishRecord;
//import com.baicizhan.client.business.dataset.models.NoticeItemRecord;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.util.CollectionUtils;
//import com.baicizhan.client.business.util.CollectionUtils.Filter;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.TimeUtil;
//import com.baicizhan.main.activity.LoadingPageActivity;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.main.utils.NoticeManager;
//import com.jiongji.andriod.card.R;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//
//public class NoticeAlarmService extends Service {
//    private static final String TAG = NoticeAlarmService.class.getSimpleName();
//    private int messageNotificationID = 600000;
//
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    public void onCreate() {
//        super.onCreate();
//        LogWrapper.m2793d(TAG, "NoticeAlarmService onCreate");
//    }
//
//    public int onStartCommand(Intent intent, int i, int i2) {
//        LogWrapper.m2793d(TAG, "NoticeAlarmService onStartCommand");
//        if (intent == null || !"android.intent.action.RUN".equals(intent.getAction())) {
//            LogWrapper.m2793d(TAG, "Intent mismatch " + intent);
//            return 2;
//        }
//        long currentTimeMillis = System.currentTimeMillis();
//        long j = Settings.getLong(Settings.PREF_LAST_REMIND_TIME);
//        if (TimeUtil.getBetweenDays(currentTimeMillis, j) == 0) {
//            LogWrapper.m2793d(TAG, "already reminded " + j);
//            return 2;
//        }
//        Notification notification = new Notification();
//        if (VERSION.SDK_INT >= 21) {
//            notification.icon = R.drawable.ic_baicizhan_white;
//        } else {
//            notification.icon = R.drawable.ic_baicizhan;
//        }
//        notification.tickerText = "百词斩";
//        notification.flags |= 16;
//        notification.defaults = 4;
//        notification.when = System.currentTimeMillis();
//        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
//        NoticeItemRecord genNoticeItemRecord = genNoticeItemRecord();
//        if (genNoticeItemRecord == null) {
//            LogWrapper.m2793d(TAG, "genNoticeItemRecords null");
//            return 0;
//        }
//        LogWrapper.m2793d(TAG, "genNoticeItemRecords " + genNoticeItemRecord);
//        boolean isApplicationRunningForeground = CommonUtils.isApplicationRunningForeground(getApplicationContext());
//        LogWrapper.m2793d(TAG, "isApplicationRunningForeground " + isApplicationRunningForeground);
//        if (!isApplicationRunningForeground) {
//            notification.sound = Uri.parse("android.resource://" + getPackageName() + "/2131034122");
//            Intent intent2 = new Intent(this, LoadingPageActivity.class);
//            intent2.putExtra(LoadingPageActivity.EXTRA_FROM_NOTICE, true);
//            PendingIntent activity = PendingIntent.getActivity(this, 0, intent2, 0);
//            LogWrapper.m2793d(TAG, "notification " + genNoticeItemRecord.content);
//            notification.setLatestEventInfo(this, "百词斩", genNoticeItemRecord.content, activity);
//            notificationManager.notify(this.messageNotificationID, notification);
//            this.messageNotificationID++;
//            NoticeFinishRecord noticeFinishRecord = new NoticeFinishRecord();
//            noticeFinishRecord.f2228id = genNoticeItemRecord.f2229id;
//            noticeFinishRecord.person = genNoticeItemRecord.person;
//            noticeFinishRecord.status = 0;
//            noticeFinishRecord.time = System.currentTimeMillis();
//            noticeFinishRecord.content = genNoticeItemRecord.content;
//            MiscRecordHelper.insertNoticeFinishRecord(this, noticeFinishRecord);
//        }
//        NoticeManager.markNoticedToday(true);
//        return 1;
//    }
//
//    private List<NoticeItemRecord> getDefaultNoticeItemRecords(Context context) {
//        Resources resources = context.getResources();
//        int[] intArray = resources.getIntArray(R.array.notice_ids);
//        int[] intArray2 = resources.getIntArray(R.array.notice_persons);
//        String[] stringArray = resources.getStringArray(R.array.notice_contents);
//        int min = Math.min(Math.min(intArray.length, intArray2.length), stringArray.length);
//        ArrayList arrayList = new ArrayList(min);
//        for (int i = 0; i < min; i++) {
//            NoticeItemRecord noticeItemRecord = new NoticeItemRecord();
//            noticeItemRecord.f2229id = intArray[i];
//            noticeItemRecord.person = intArray2[i];
//            noticeItemRecord.content = stringArray[i];
//            arrayList.add(noticeItemRecord);
//        }
//        return arrayList;
//    }
//
//    private NoticeItemRecord genNoticeItemRecord() {
//        List allNoticeItemRecord = MiscRecordHelper.getAllNoticeItemRecord(this);
//        if (CollectionUtils.isEmpty((Collection<?>) allNoticeItemRecord)) {
//            allNoticeItemRecord = getDefaultNoticeItemRecords(this);
//        }
//        final Set usedNoticeItemIds = MiscRecordHelper.getUsedNoticeItemIds(this);
//        LogWrapper.m2795i(TAG, "used ids " + TextUtils.join(",", usedNoticeItemIds));
//        List filter = CollectionUtils.filter((Collection<T>) allNoticeItemRecord, (Filter<T>) new Filter<NoticeItemRecord>() {
//            public boolean filter(NoticeItemRecord noticeItemRecord) {
//                return !usedNoticeItemIds.contains(Integer.valueOf(noticeItemRecord.f2229id));
//            }
//        });
//        if (!CollectionUtils.isEmpty((Collection<?>) filter)) {
//            return (NoticeItemRecord) filter.get(0);
//        }
//        LogWrapper.m2797w(TAG, "all id has used");
//        MiscRecordHelper.clearAllUsedNoticeIds(this);
//        if (CollectionUtils.isEmpty((Collection<?>) allNoticeItemRecord)) {
//            return null;
//        }
//        return (NoticeItemRecord) allNoticeItemRecord.get(0);
//    }
//}
