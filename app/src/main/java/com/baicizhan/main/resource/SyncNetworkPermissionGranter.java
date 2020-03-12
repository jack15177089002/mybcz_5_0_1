//package com.baicizhan.main.resource;
//
//import android.app.Activity;
//import android.content.DialogInterface;
//import android.content.DialogInterface.OnClickListener;
//import android.util.Log;
//import com.baicizhan.client.business.util.AuthCallback;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.widget.BczDialog;
//import com.baicizhan.client.business.widget.BczDialog.Builder;
//import com.jiongji.andriod.card.R;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class SyncNetworkPermissionGranter {
//    private static final long MAX_GRANT_WAIT_TIME_SECONDS = 60;
//    private static final String TAG = SyncNetworkPermissionGranter.class.getSimpleName();
//    private Activity mActivity;
//    /* access modifiers changed from: private */
//    public Condition mCondition = this.mLock.newCondition();
//    private BczDialog mDialog;
//    /* access modifiers changed from: private */
//    public boolean mGranted = false;
//    /* access modifiers changed from: private */
//    public Lock mLock = new ReentrantLock();
//    /* access modifiers changed from: private */
//    public boolean mSetted = false;
//
//    SyncNetworkPermissionGranter() {
//    }
//
//    /* JADX INFO: finally extract failed */
//    public boolean grant(Activity activity) {
//        if (TopicResourceManager.getInstance().isMobileProblemDownloadEnabled()) {
//            return true;
//        }
//        this.mActivity = activity;
//        AuthCallback.post(new Runnable() {
//            public void run() {
//                SyncNetworkPermissionGranter.this.prompt();
//            }
//        });
//        this.mLock.lock();
//        do {
//            try {
//                if (this.mSetted) {
//                    break;
//                }
//                LogWrapper.m2793d(TAG, "start await");
//            } catch (Exception e) {
//                LogWrapper.m2793d(TAG, Log.getStackTraceString(e));
//                cleanup();
//                this.mLock.unlock();
//                return false;
//            } catch (Throwable th) {
//                this.mLock.unlock();
//                throw th;
//            }
//        } while (this.mCondition.await(MAX_GRANT_WAIT_TIME_SECONDS, TimeUnit.SECONDS));
//        if (!this.mGranted) {
//            cleanup();
//        }
//        boolean z = this.mGranted;
//        this.mLock.unlock();
//        return z;
//    }
//
//    private void cleanup() {
//        LogWrapper.m2793d(TAG, "cleanup " + this.mActivity);
//        if (this.mDialog != null) {
//            this.mDialog.dismiss();
//            this.mDialog = null;
//        }
//        if (this.mActivity != null) {
//            this.mActivity.finish();
//            this.mActivity = null;
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void prompt() {
//        C11912 r0 = new OnClickListener() {
//            public void onClick(DialogInterface dialogInterface, int i) {
//                if (i == -1) {
//                    SyncNetworkPermissionGranter.this.mGranted = true;
//                    TopicResourceManager.getInstance().setMobileProblemDownloadEnabled(true);
//                } else if (i == -2) {
//                    SyncNetworkPermissionGranter.this.mGranted = false;
//                    TopicResourceManager.getInstance().setMobileOfflineDownloadEnabled(false);
//                }
//                SyncNetworkPermissionGranter.this.mLock.lock();
//                try {
//                    SyncNetworkPermissionGranter.this.mSetted = true;
//                    SyncNetworkPermissionGranter.this.mCondition.signal();
//                    dialogInterface.dismiss();
//                } finally {
//                    SyncNetworkPermissionGranter.this.mLock.unlock();
//                }
//            }
//        };
//        this.mDialog = new Builder(this.mActivity).setMessage((int) R.string.main_alert_message_download_problem).setPositiveButton((int) R.string.main_alert_positive_wealthy, (OnClickListener) r0).setNegativeButton((int) R.string.main_alert_negative_giveup, (OnClickListener) r0).create();
//        this.mDialog.setCancelable(false);
//        this.mDialog.show();
//    }
//}
