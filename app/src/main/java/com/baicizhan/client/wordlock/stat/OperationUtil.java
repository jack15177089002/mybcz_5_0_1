//package com.baicizhan.client.wordlock.stat;
//
//import android.content.Context;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.TimeUtil;
//import com.baicizhan.client.wordlock.setting.Settings;
//
//public class OperationUtil {
//    private static final OperationUtil sInstance = new OperationUtil();
//    private volatile int mRevdCount;
//
//    private OperationUtil() {
//    }
//
//    public static OperationUtil getInstance() {
//        return sInstance;
//    }
//
//    public void accumRevdCount() {
//        this.mRevdCount++;
//    }
//
//    public void accumOpenLockCount() {
//        Settings.accumOpenLockCount();
//    }
//
//    public void notifyCloseLock(Context context) {
//        if (this.mRevdCount <= 0) {
//            this.mRevdCount = 0;
//            return;
//        }
//        sendStat(context);
//        Settings.increaseTotalRevdCount(this.mRevdCount);
//        this.mRevdCount = 0;
//        accumOpenLockCount();
//    }
//
//    private boolean sendStat(Context context) {
//        long j = TimeUtil.todayStart();
//        long todayMilliseconds = Settings.getTodayMilliseconds();
//        if (j == todayMilliseconds) {
//            return false;
//        }
//        int totalRevdCount = Settings.getTotalRevdCount();
//        int openLockCount = Settings.getOpenLockCount();
//        if (totalRevdCount > 0 && openLockCount > 0) {
//            OperationStats.statAvgReviewCountPerLock((totalRevdCount + 1) / openLockCount, todayMilliseconds);
//            OperationStats.getInstance().stat(context);
//        }
//        Settings.setTodayMilliseconds(j);
//        Settings.setTotalRevdCount(0);
//        Settings.setOpenLockCount(0);
//        return true;
//    }
//}
