//package com.baicizhan.client.p029fm.data.update;
//
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.os.IBinder;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.media.update.MediaUpdatorService;
//import com.baicizhan.client.p029fm.data.FmList;
//import com.baicizhan.client.p029fm.data.load.FmHandler;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//
///* renamed from: com.baicizhan.client.fm.data.update.FmUpdatorService */
//public class FmUpdatorService extends Service {
//    /* access modifiers changed from: private */
//    public static List<FmList> FMLIST_CACHE = new ArrayList();
//    /* access modifiers changed from: private */
//    public boolean mUpdating = false;
//    private FmUpdator mUpdator;
//
//    /* renamed from: com.baicizhan.client.fm.data.update.FmUpdatorService$FmUpdator */
//    class FmUpdator extends FmHandler {
//        final WeakReference<FmUpdatorService> mService;
//
//        FmUpdator(FmUpdatorService fmUpdatorService) {
//            super(fmUpdatorService);
//            this.mService = new WeakReference<>(fmUpdatorService);
//        }
//
//        public void onUpdateFmLearnRecords(int i, Object obj) {
//            FmUpdatorService fmUpdatorService = (FmUpdatorService) this.mService.get();
//            if (fmUpdatorService != null) {
//                if (!FmUpdatorService.FMLIST_CACHE.isEmpty()) {
//                    fmUpdatorService.update();
//                    return;
//                }
//                fmUpdatorService.mUpdating = false;
//                MediaUpdatorService.start(fmUpdatorService);
//                fmUpdatorService.stopSelf();
//                destroy();
//            }
//        }
//    }
//
//    public static void start(Context context, FmList fmList) {
//        FMLIST_CACHE.add(fmList);
//        context.startService(new Intent(context, FmUpdatorService.class));
//    }
//
//    public void onCreate() {
//        super.onCreate();
//        this.mUpdator = new FmUpdator(this);
//    }
//
//    public int onStartCommand(Intent intent, int i, int i2) {
//        if (!this.mUpdating) {
//            this.mUpdating = true;
//            update();
//        }
//        return super.onStartCommand(intent, i, i2);
//    }
//
//    /* access modifiers changed from: private */
//    public void update() {
//        this.mUpdator.updateFmLearnRecords(0, StudyManager.getInstance().getCurrentBookId(), (FmList) FMLIST_CACHE.remove(0), null);
//    }
//
//    public IBinder onBind(Intent intent) {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
//}
