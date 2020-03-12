//package com.baicizhan.client.p029fm.data.load;
//
//import android.content.Context;
//import android.os.Handler;
//import android.os.HandlerThread;
//import android.os.Looper;
//import android.os.Message;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper;
//import com.baicizhan.client.p029fm.data.FmList;
//import com.baicizhan.client.p029fm.data.p030db.WordInfoRecordHelper;
//import java.util.ArrayList;
//import java.util.List;
//
///* renamed from: com.baicizhan.client.fm.data.load.FmHandler */
//public class FmHandler extends Handler {
//    private static final int EVENT_GET_FMBORDERS = 3;
//    private static final int EVENT_UPDATE_FM_LEARN_RECORDS = 4;
//    /* access modifiers changed from: private */
//    public Context mContext;
//    private boolean mDestroyed = false;
//    private Looper mLooper = null;
//    private Handler mWorkerThreadHandler;
//
//    /* renamed from: com.baicizhan.client.fm.data.load.FmHandler$WorkerArgs */
//    public final class WorkerArgs {
//        int bookid;
//        Object cookie;
//        List<String> fmborders;
//        FmHandler handler;
//        FmList list;
//
//        protected WorkerArgs() {
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.data.load.FmHandler$WorkerHandler */
//    public class WorkerHandler extends Handler {
//        public WorkerHandler(Looper looper) {
//            super(looper);
//        }
//
//        public void handleMessage(Message message) {
//            WorkerArgs workerArgs = (WorkerArgs) message.obj;
//            int i = message.what;
//            switch (i) {
//                case 3:
//                    String borderMediaPath = WordMediaRecordHelper.getBorderMediaPath(workerArgs.handler.mContext, 2);
//                    String borderMediaPath2 = WordMediaRecordHelper.getBorderMediaPath(workerArgs.handler.mContext, 3);
//                    Log.d("whiz", "get fm border start: " + borderMediaPath + "; end: " + borderMediaPath2);
//                    workerArgs.fmborders = new ArrayList(2);
//                    workerArgs.fmborders.add(borderMediaPath);
//                    workerArgs.fmborders.add(borderMediaPath2);
//                    break;
//                case 4:
//                    WordInfoRecordHelper.updateFmLearnRecords(workerArgs.handler.mContext, workerArgs.bookid, workerArgs.list);
//                    break;
//            }
//            Message obtainMessage = workerArgs.handler.obtainMessage(i);
//            obtainMessage.obj = workerArgs;
//            obtainMessage.arg1 = message.arg1;
//            obtainMessage.sendToTarget();
//        }
//    }
//
//    public FmHandler(Context context) {
//        this.mContext = context;
//        HandlerThread handlerThread = new HandlerThread("FmHandler");
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
//        this.mDestroyed = true;
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
//    public void getFmBorders(int i, Object obj) {
//        if (!this.mDestroyed) {
//            Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(3);
//            WorkerArgs workerArgs = new WorkerArgs();
//            workerArgs.handler = this;
//            workerArgs.cookie = obj;
//            obtainMessage.obj = workerArgs;
//            obtainMessage.arg1 = i;
//            this.mWorkerThreadHandler.sendMessage(obtainMessage);
//        }
//    }
//
//    public void updateFmLearnRecords(int i, int i2, FmList fmList, Object obj) {
//        if (!this.mDestroyed) {
//            Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(4);
//            WorkerArgs workerArgs = new WorkerArgs();
//            workerArgs.handler = this;
//            workerArgs.bookid = i2;
//            workerArgs.list = fmList;
//            workerArgs.cookie = obj;
//            obtainMessage.obj = workerArgs;
//            obtainMessage.arg1 = i;
//            this.mWorkerThreadHandler.sendMessage(obtainMessage);
//        }
//    }
//
//    public void onGetFmBorders(int i, List<String> list, Object obj) {
//    }
//
//    public void onUpdateFmLearnRecords(int i, Object obj) {
//    }
//
//    public void handleMessage(Message message) {
//        if (this.mDestroyed) {
//            this.mContext = null;
//            return;
//        }
//        WorkerArgs workerArgs = (WorkerArgs) message.obj;
//        switch (message.what) {
//            case 3:
//                onGetFmBorders(message.arg1, workerArgs.fmborders, workerArgs.cookie);
//                return;
//            case 4:
//                onUpdateFmLearnRecords(message.arg1, workerArgs.cookie);
//                return;
//            default:
//                return;
//        }
//    }
//}
