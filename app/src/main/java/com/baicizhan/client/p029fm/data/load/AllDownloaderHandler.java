//package com.baicizhan.client.p029fm.data.load;
//
//import android.os.Handler;
//import android.os.HandlerThread;
//import android.os.Looper;
//import android.os.Message;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.p029fm.util.FmUtil;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
///* renamed from: com.baicizhan.client.fm.data.load.AllDownloaderHandler */
//public class AllDownloaderHandler extends Handler {
//    private static final int EVENT_GET_UNDOWNLOADED = 0;
//    private Looper mLooper = null;
//    private Handler mWorkerThreadHandler;
//
//    /* renamed from: com.baicizhan.client.fm.data.load.AllDownloaderHandler$WorkerArgs */
//    public final class WorkerArgs {
//        Object cookie;
//        AllDownloaderHandler handler;
//        List<WordMediaRecord> records;
//
//        protected WorkerArgs() {
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.data.load.AllDownloaderHandler$WorkerHandler */
//    public class WorkerHandler extends Handler {
//        public WorkerHandler(Looper looper) {
//            super(looper);
//        }
//
//        public void handleMessage(Message message) {
//            WorkerArgs workerArgs = (WorkerArgs) message.obj;
//            int i = message.what;
//            switch (i) {
//                case 0:
//                    String baicizhanAppRoot = PathUtil.getBaicizhanAppRoot();
//                    List<WordMediaRecord> list = workerArgs.records;
//                    if (list != null) {
//                        ArrayList arrayList = new ArrayList();
//                        for (WordMediaRecord wordMediaRecord : list) {
//                            File file = new File(FmUtil.reformFmPath(baicizhanAppRoot + wordMediaRecord.getFmpath()));
//                            File file2 = new File(FmUtil.reformFmPath(baicizhanAppRoot + wordMediaRecord.getHighfmpath()));
//                            if (!file.exists() && !file2.exists()) {
//                                arrayList.add(wordMediaRecord);
//                            }
//                        }
//                        workerArgs.records = arrayList;
//                        break;
//                    }
//                    break;
//            }
//            Message obtainMessage = workerArgs.handler.obtainMessage(i);
//            obtainMessage.obj = workerArgs;
//            obtainMessage.arg1 = message.arg1;
//            obtainMessage.sendToTarget();
//        }
//    }
//
//    public AllDownloaderHandler() {
//        HandlerThread handlerThread = new HandlerThread("AllDownloaderHandler");
//        handlerThread.start();
//        this.mLooper = handlerThread.getLooper();
//        this.mWorkerThreadHandler = createHandler(this.mLooper);
//    }
//
//    /* access modifiers changed from: protected */
//    public Handler createHandler(Looper looper) {
//        return new WorkerHandler(looper);
//    }
//
//    public void destroy() {
//        if (this.mLooper != null) {
//            this.mLooper.quit();
//            this.mLooper = null;
//            removeCallbacksAndMessages(null);
//            if (this.mWorkerThreadHandler != null) {
//                this.mWorkerThreadHandler.removeCallbacksAndMessages(null);
//            }
//        }
//    }
//
//    public void getUnDownloadedMedias(int i, List<WordMediaRecord> list, Object obj) {
//        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(0);
//        WorkerArgs workerArgs = new WorkerArgs();
//        workerArgs.handler = this;
//        workerArgs.records = list;
//        workerArgs.cookie = obj;
//        obtainMessage.obj = workerArgs;
//        obtainMessage.arg1 = i;
//        this.mWorkerThreadHandler.sendMessage(obtainMessage);
//    }
//
//    /* access modifiers changed from: protected */
//    public void onGetUnDownloadedMedias(int i, List<WordMediaRecord> list, Object obj) {
//    }
//
//    public void handleMessage(Message message) {
//        WorkerArgs workerArgs = (WorkerArgs) message.obj;
//        switch (message.what) {
//            case 0:
//                onGetUnDownloadedMedias(message.arg1, workerArgs.records, workerArgs.cookie);
//                return;
//            default:
//                return;
//        }
//    }
//}
