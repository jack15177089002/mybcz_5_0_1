//package com.baicizhan.client.wordtesting.service;
//
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.os.IBinder;
//import com.baicizhan.client.business.event.BEvents.WordScoreUpdatedEvent;
//import com.baicizhan.client.wordtesting.feed.FeedHandler;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
////import p000a.p001a.p002a.EventBus;
//
//public class WritebackReviewService extends Service {
//    private FeedReviewHandler mHandler;
//
//    class FeedReviewHandler extends FeedHandler {
//        final WeakReference<WritebackReviewService> mService;
//
//        FeedReviewHandler(WritebackReviewService writebackReviewService) {
//            this.mService = new WeakReference<>(writebackReviewService);
//        }
//
//        public void onWroteback(int i) {
//            WritebackReviewService writebackReviewService = (WritebackReviewService) this.mService.get();
////            EventBus.m0a().mo9c((Object) new WordScoreUpdatedEvent(0));
////            if (writebackReviewService != null) {
////                writebackReviewService.stopSelf();
////            }
//        }
//    }
//
//    public static final void start(Context context, ArrayList<String> arrayList) {
//        if (context != null && arrayList != null && !arrayList.isEmpty()) {
//            Intent intent = new Intent(context, WritebackReviewService.class);
//            intent.putStringArrayListExtra("words", arrayList);
//            context.startService(intent);
//        }
//    }
//
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    public int onStartCommand(Intent intent, int i, int i2) {
//        if (intent == null) {
//            return 2;
//        }
//        ArrayList stringArrayListExtra = intent.getStringArrayListExtra("words");
//        if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
//            stopSelf();
//            return 2;
//        }
//        this.mHandler = new FeedReviewHandler(this);
//        this.mHandler.writebackWords2Review(0, stringArrayListExtra);
//        return 1;
//    }
//
//    public void onDestroy() {
//        this.mHandler.destroy();
//        super.onDestroy();
//    }
//}
