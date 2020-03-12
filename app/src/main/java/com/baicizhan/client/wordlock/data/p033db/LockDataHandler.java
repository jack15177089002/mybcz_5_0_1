//package com.baicizhan.client.wordlock.data.p033db;
//
//import android.app.Application;
//import android.os.Handler;
//import android.os.HandlerThread;
//import android.os.Looper;
//import android.os.Message;
//import com.baicizhan.client.business.search.Word;
//import com.baicizhan.client.business.search.p028db.SearchHelper;
//import com.baicizhan.client.wordlock.WordLockAppHandler;
//import java.util.ArrayList;
//import java.util.List;
//
///* renamed from: com.baicizhan.client.wordlock.data.db.LockDataHandler */
//public class LockDataHandler extends Handler {
//    private static final int EVENT_ADD_SEARCH_HISTORY = 6;
//    private static final int EVENT_CLEAR_TODAY_RVD = 5;
//    private static final int EVENT_GET_TODAY_RVD_COUNT = 4;
//    private static final int EVENT_KILL_WORD = 3;
//    private static final int EVENT_QUERY = 0;
//    private Looper mLooper = null;
//    private Handler mWorkerThreadHandler;
//
//    /* renamed from: com.baicizhan.client.wordlock.data.db.LockDataHandler$WorkerArgs */
//    public final class WorkerArgs {
//        public Object cookie;
//        public Handler handler;
//        public String killid;
//        public List<Word> result_words;
//        public List<String> revd_ids;
//        public int today_rvd_count;
//
//        protected WorkerArgs() {
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.wordlock.data.db.LockDataHandler$WorkerHandler */
//    public class WorkerHandler extends Handler {
//        public WorkerHandler(Looper looper) {
//            super(looper);
//        }
//
//        public void handleMessage(Message message) {
//            WorkerArgs workerArgs = (WorkerArgs) message.obj;
//            int i = message.what;
//            Application app = WordLockAppHandler.getApp();
//            switch (i) {
//                case 0:
//                    workerArgs.result_words = WordLockHelper.getUnrevdTopNWords(app, workerArgs.revd_ids);
//                    break;
//                case 3:
//                    WordLockHelper.killWord(app, workerArgs.killid);
//                    break;
//                case 4:
//                    workerArgs.today_rvd_count = WordLockHelper.getTodayRevdCount(app, workerArgs.revd_ids);
//                    break;
//                case 5:
//                    WordLockHelper.clearTodayRvd(app);
//                    break;
//                case 6:
//                    SearchHelper.addSearchHistory(app, (Word) workerArgs.result_words.get(0));
//                    break;
//            }
//            Message obtainMessage = workerArgs.handler.obtainMessage(i);
//            obtainMessage.obj = workerArgs;
//            obtainMessage.arg1 = message.arg1;
//            obtainMessage.sendToTarget();
//        }
//    }
//
//    public LockDataHandler(String str) {
//        HandlerThread handlerThread = new HandlerThread(str);
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
//    public void cancelOperation(int i) {
//        this.mWorkerThreadHandler.removeMessages(i);
//    }
//
//    public void getUnrevdTopNWords(List<String> list) {
//        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(0);
//        WorkerArgs workerArgs = new WorkerArgs();
//        workerArgs.handler = this;
//        workerArgs.revd_ids = list;
//        obtainMessage.obj = workerArgs;
//        this.mWorkerThreadHandler.sendMessage(obtainMessage);
//    }
//
//    public void killWord(String str) {
//        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(3);
//        WorkerArgs workerArgs = new WorkerArgs();
//        workerArgs.handler = this;
//        workerArgs.killid = str;
//        obtainMessage.obj = workerArgs;
//        this.mWorkerThreadHandler.sendMessage(obtainMessage);
//    }
//
//    public void getTodayRevdCount(List<String> list) {
//        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(4);
//        WorkerArgs workerArgs = new WorkerArgs();
//        workerArgs.handler = this;
//        workerArgs.revd_ids = list;
//        obtainMessage.obj = workerArgs;
//        this.mWorkerThreadHandler.sendMessage(obtainMessage);
//    }
//
//    public void clearTodayRvd(Object obj) {
//        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(5);
//        WorkerArgs workerArgs = new WorkerArgs();
//        workerArgs.handler = this;
//        workerArgs.cookie = obj;
//        obtainMessage.obj = workerArgs;
//        this.mWorkerThreadHandler.sendMessage(obtainMessage);
//    }
//
//    public void addSearchHistory(Word word) {
//        Message obtainMessage = this.mWorkerThreadHandler.obtainMessage(6);
//        WorkerArgs workerArgs = new WorkerArgs();
//        workerArgs.handler = this;
//        workerArgs.result_words = new ArrayList();
//        workerArgs.result_words.add(word);
//        obtainMessage.obj = workerArgs;
//        this.mWorkerThreadHandler.sendMessage(obtainMessage);
//    }
//
//    public void onGetUnrevdTopNWords(List<Word> list) {
//    }
//
//    public void onKillWord(String str) {
//    }
//
//    public void onGetTodayRvdCount(int i) {
//    }
//
//    public void onClearTodayRvd(Object obj) {
//    }
//
//    /* access modifiers changed from: protected */
//    public void onAddSearchHistory() {
//    }
//
//    public void handleMessage(Message message) {
//        WorkerArgs workerArgs = (WorkerArgs) message.obj;
//        switch (message.what) {
//            case 0:
//                onGetUnrevdTopNWords(workerArgs.result_words);
//                return;
//            case 3:
//                onKillWord(workerArgs.killid);
//                return;
//            case 4:
//                onGetTodayRvdCount(workerArgs.today_rvd_count);
//                return;
//            case 5:
//                onClearTodayRvd(workerArgs.cookie);
//                return;
//            case 6:
//                onAddSearchHistory();
//                return;
//            default:
//                return;
//        }
//    }
//}
