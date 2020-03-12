//package com.baicizhan.main.plusreview.data.load;
//
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.os.IBinder;
//import com.baicizhan.main.plusreview.data.MatchTestCache;
//import com.baicizhan.main.plusreview.data.load.MatchTestLoader.OnDataSyncListener;
//
//public class MatchTestSyncService extends Service implements OnDataSyncListener {
//    private MatchTestLoader mMatchTestLoader;
//
//    public static void start(Context context) {
//        context.startService(new Intent(context, MatchTestSyncService.class));
//    }
//
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    public void onCreate() {
//        super.onCreate();
//        this.mMatchTestLoader = MatchTestLoader.createInstance((Context) this, (OnDataSyncListener) this);
//        this.mMatchTestLoader.sync(MatchTestCache.getCache().getTestlib().getResult_records());
//    }
//
//    public void onTestDataSynced(boolean z, int i) {
//        stopSelf();
//    }
//}
