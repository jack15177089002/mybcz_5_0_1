//package com.baicizhan.client.business.media.update;
//
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.os.IBinder;
//import com.baicizhan.client.business.media.update.MediaUpdator.OnMediaUpdateListener;
//
//public class MediaUpdatorService extends Service implements OnMediaUpdateListener {
//    private MediaUpdator mFmUpdator;
//
//    public static void start(Context context) {
//        context.startService(new Intent(context, MediaUpdatorService.class));
//    }
//
//    public void onCreate() {
//        super.onCreate();
//        this.mFmUpdator = MediaUpdator.createInstance(this, this);
//        this.mFmUpdator.update();
//    }
//
//    public IBinder onBind(Intent intent) {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//
//    public void onMediaUpdated(boolean z, int i) {
//        stopSelf();
//    }
//}
