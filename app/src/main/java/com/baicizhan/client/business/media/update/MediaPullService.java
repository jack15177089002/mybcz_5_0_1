//package com.baicizhan.client.business.media.update;
//
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.os.IBinder;
//import com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper;
//import com.baicizhan.client.business.dataset.load.WordMediaLoader;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.framework.log.C0789L;
////import com.baicizhan.online.bs_words.BSWords.Client;
//
//public class MediaPullService extends Service {
//    /* access modifiers changed from: private */
//    public boolean mPulling = false;
//
//    public static void start(Context context) {
//        context.startService(new Intent(context, MediaPullService.class));
//    }
//
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    public void onCreate() {
//        super.onCreate();
//        pull(this, StudyManager.getInstance().getCurrentBookId());
//    }
//
//    private void pull(final Context context, final int i) {
//        if (!this.mPulling) {
//            this.mPulling = true;
////            BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, Void>(BaicizhanThrifts.WORDS) {
////                /* access modifiers changed from: protected */
////                public Void doInBackground(Client client) {
////                    if (!WordMediaRecordHelper.isBookLoaded(context, i)) {
////                        WordMediaLoader.doRefreshAllWordMediaRecords(context, i, client);
////                        WordMediaRecordHelper.setBookLoaded(context, i);
////                    }
////                    return null;
////                }
////
////                /* access modifiers changed from: protected */
////                public void onError(Exception exc) {
////                    C0789L.log.error("pull media(fm and tv) info from server failed.", (Throwable) exc);
////                    MediaPullService.this.mPulling = false;
////                    MediaPullService.this.stopSelf();
////                }
////
////                /* access modifiers changed from: protected */
////                public void onResult(Void voidR) {
////                    C0789L.log.info("pull media(fm and tv) info from server success. bookid [{}]", (Object) Integer.valueOf(i));
////                    MediaPullService.this.mPulling = false;
////                    MediaPullService.this.stopSelf();
////                }
////            });
//        }
//    }
//}
