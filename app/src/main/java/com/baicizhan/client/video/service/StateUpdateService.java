//package com.baicizhan.client.video.service;
//
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.os.IBinder;
//import android.util.Log;
//import com.baicizhan.client.business.media.update.MediaUpdatorService;
//import com.baicizhan.client.video.data.VideoInfo;
//import com.baicizhan.client.video.data.p032db.VideoDataManager;
//import com.baicizhan.client.video.data.p032db.VideoDataManager.OnVideoDataSyncListener;
//import java.util.ArrayList;
//import java.util.List;
//
//public class StateUpdateService extends Service implements OnVideoDataSyncListener {
//    private static List<VideoInfo> sVideos;
//    private VideoDataManager mVDM;
//
//    public static final void start(Context context, List<VideoInfo> list) {
//        if (context != null) {
//            sVideos = list;
//            context.startService(new Intent(context, StateUpdateService.class));
//        }
//    }
//
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    public int onStartCommand(Intent intent, int i, int i2) {
//        Log.d("whiz", "start update");
//        if (sVideos == null) {
//            stopSelf();
//            return 2;
//        }
//        this.mVDM = VideoDataManager.createInstance(null, this);
//        this.mVDM.syncVideoData(new ArrayList(sVideos));
//        sVideos.clear();
//        sVideos = null;
//        return 1;
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//    }
//
//    public void onVideoDataSynced() {
//        MediaUpdatorService.start(this);
//        stopSelf();
//    }
//}
