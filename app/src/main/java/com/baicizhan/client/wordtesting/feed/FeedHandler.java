//package com.baicizhan.client.wordtesting.feed;
//
//import android.os.Handler;
//import android.os.HandlerThread;
//import android.os.Looper;
//import android.os.Message;
//import com.baicizhan.client.business.book.Book;
//import com.baicizhan.client.business.book.BookSyncTask;
//import java.util.List;
//
//public class FeedHandler extends Handler {
//    private static final int EVENT_WRITE_BACK_REVIEW = 0;
//    private Looper mLooper;
//    private Handler mWorkerThreadHandler = new WorkerHandler(this.mLooper);
//
//    final class WorkerArgs {
//        public Handler handler;
//        public List<String> words;
//
//        private WorkerArgs() {
//        }
//    }
//
//    class WorkerHandler extends Handler {
//        private FeedDaos mDaos = new FeedDaos();
//
//        public WorkerHandler(Looper looper) {
//            super(looper);
//        }
//
//        public void handleMessage(Message message) {
//            WorkerArgs workerArgs = (WorkerArgs) message.obj;
//            int i = message.what;
//            int i2 = message.arg1;
//            switch (i2) {
//                case 0:
//                    int i3 = -1;
//                    Book book = BookSyncTask.getBook();
//                    if (book != null) {
//                        i3 = book.getId();
//                    }
//                    if (i3 >= 0) {
//                        this.mDaos.writebackWords2Review(i3, workerArgs.words);
//                        break;
//                    }
//                    break;
//            }
//            Message obtainMessage = workerArgs.handler.obtainMessage(i);
//            obtainMessage.obj = workerArgs;
//            obtainMessage.arg1 = i2;
//            obtainMessage.sendToTarget();
//        }
//    }
//
//    public FeedHandler() {
//        HandlerThread handlerThread = new HandlerThread("DaosHandlerWorker");
//        handlerThread.start();
//        this.mLooper = handlerThread.getLooper();
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
//    public void writebackWords2Review(int i, List<String> list) {
//        this.mWorkerThreadHandler.removeMessages(i);
//        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(i);
//        WorkerArgs workerArgs = new WorkerArgs();
//        workerArgs.handler = this;
//        workerArgs.words = list;
//        obtainMessage.arg1 = 0;
//        obtainMessage.obj = workerArgs;
//        this.mWorkerThreadHandler.sendMessage(obtainMessage);
//    }
//
//    public void onWroteback(int i) {
//    }
//
//    public void handleMessage(Message message) {
//        int i = message.what;
//        switch (message.arg1) {
//            case 0:
//                onWroteback(i);
//                return;
//            default:
//                return;
//        }
//    }
//}
