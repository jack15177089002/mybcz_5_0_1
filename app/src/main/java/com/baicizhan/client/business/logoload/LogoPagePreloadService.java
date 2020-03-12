//package com.baicizhan.client.business.logoload;
//
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.os.IBinder;
//import com.baicizhan.client.business.logoload.LogoPageLoading.OnLoadCallback;
//
//public class LogoPagePreloadService extends Service implements OnLoadCallback {
//    private LogoPageLoading mLoading = new LogoPageLoading();
//    private boolean mPreloaded = false;
//    private boolean mPreloading = false;
//    private boolean mUpgraded = false;
//
//    public static final void start(Context context) {
//        if (context != null) {
//            context.startService(new Intent(context, LogoPagePreloadService.class));
//        }
//    }
//
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    public int onStartCommand(Intent intent, int i, int i2) {
//        if (!this.mPreloading) {
//            this.mLoading.with(this).setCallback(this).upgrade().preload();
//            this.mPreloading = true;
//        }
//        return 2;
//    }
//
//    public void onLoaded(boolean z, long j) {
//    }
//
//    public void onPreLoaded(boolean z) {
//        if (!z) {
//            this.mPreloaded = true;
//        }
//        stopIfNeeded();
//    }
//
//    public void onUpgraded(boolean z) {
//        this.mUpgraded = true;
//        this.mPreloaded = false;
//    }
//
//    private void stopIfNeeded() {
//        if (this.mPreloaded && this.mUpgraded) {
//            stopSelf();
//            System.exit(0);
//        }
//    }
//
//    public void onDestroy() {
//        this.mLoading.destroy();
//        super.onDestroy();
//    }
//}
