//package com.baicizhan.client.wordlock.service;
//
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.os.IBinder;
//import android.util.Log;
//import com.baicizhan.client.business.search.Word;
//import com.baicizhan.client.wordlock.data.WordToReviewCache;
//import com.baicizhan.client.wordlock.data.p033db.LockDataHandler;
//import com.baicizhan.client.wordlock.setting.Settings;
//import java.lang.ref.WeakReference;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import java.util.Locale;
//
//public class WordLockService extends Service {
//    private static final String ACTION_GET_TODAY_REVD_COUNT = "com.baicizhan.client.wordlock.action.GET_TODAY_REVD_COUNT";
//    private static final String ACTION_KILL_WORD = "com.baicizhan.client.wordlock.action.KILL_WORD";
//    private static final String ACTION_REFRESH_TOPN = "com.baicizhan.client.wordlock.action.REFRESH_TOPN";
//    private static final String EXTRA_KILL_ID = "EXTRA_kill_id";
//    private static final String EXTRA_MEM_REVD_IDS = "EXTRA_mem_revd_ids";
//    private DataGetter mDataGetter;
//    /* access modifiers changed from: private */
//    public int mRunningTask = 0;
//
//    final class DataGetter extends LockDataHandler {
//        private final WeakReference<WordLockService> mService;
//
//        DataGetter(WordLockService wordLockService) {
//            super("WordLockService");
//            this.mService = new WeakReference<>(wordLockService);
//        }
//
//        /* access modifiers changed from: protected */
//        public final void onGetUnrevdTopNWords(List<Word> list) {
//            WordLockService wordLockService = (WordLockService) this.mService.get();
//            if (wordLockService != null) {
//                if (list == null || list.isEmpty()) {
//                    Settings.setWordlockHasWord(false);
//                    WordLockDaemon.notifyHasWord(wordLockService, false);
//                } else {
//                    Settings.setWordlockHasWord(true);
//                    WordLockDaemon.notifyHasWord(wordLockService, true);
//                }
//                WordToReviewCache.refresh(list);
//                wordLockService.mRunningTask = wordLockService.mRunningTask - 1;
//                Log.d("whiz", "running task delete [219]: " + wordLockService.mRunningTask);
//                wordLockService.tryStop();
//            }
//        }
//
//        /* access modifiers changed from: protected */
//        public final void onKillWord(String str) {
//            WordLockService wordLockService = (WordLockService) this.mService.get();
//            if (wordLockService != null) {
//                wordLockService.mRunningTask = wordLockService.mRunningTask - 1;
//                Log.d("whiz", "running task delete [234]: " + wordLockService.mRunningTask);
//                wordLockService.tryStop();
//            }
//        }
//
//        /* access modifiers changed from: protected */
//        public final void onGetTodayRvdCount(int i) {
//            WordLockService wordLockService = (WordLockService) this.mService.get();
//            if (wordLockService != null) {
//                wordLockService.mRunningTask = wordLockService.mRunningTask - 1;
//                Log.d("whiz", "running task delete [244]: " + wordLockService.mRunningTask);
//                if (i <= 0) {
//                    wordLockService.tryStop();
//                    return;
//                }
//                Settings.setCachedLockRevdCount(i);
//                wordLockService.tryStop();
//            }
//        }
//
//        /* access modifiers changed from: protected */
//        public final void onClearTodayRvd(Object obj) {
//            getTodayRevdCount((List) obj);
//        }
//    }
//
//    public static final void startForRefreshTopN(Context context, ArrayList<String> arrayList) {
//        if (context != null) {
//            Intent intent = new Intent(context, WordLockService.class);
//            intent.setAction(ACTION_REFRESH_TOPN);
//            intent.putStringArrayListExtra(EXTRA_MEM_REVD_IDS, arrayList);
//            context.startService(intent);
//        }
//    }
//
//    public static final void startForGetTodayRevdCount(Context context, ArrayList<String> arrayList) {
//        if (context != null) {
//            Intent intent = new Intent(context, WordLockService.class);
//            intent.setAction(ACTION_GET_TODAY_REVD_COUNT);
//            intent.putStringArrayListExtra(EXTRA_MEM_REVD_IDS, arrayList);
//            context.startService(intent);
//        }
//    }
//
//    public static final void startForKillWord(Context context, String str) {
//        if (context != null) {
//            Intent intent = new Intent(context, WordLockService.class);
//            intent.setAction(ACTION_KILL_WORD);
//            intent.putExtra(EXTRA_KILL_ID, str);
//            context.startService(intent);
//        }
//    }
//
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    public void onCreate() {
//        super.onCreate();
//        this.mDataGetter = new DataGetter(this);
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//        this.mDataGetter.destroy();
//    }
//
//    public int onStartCommand(Intent intent, int i, int i2) {
//        if (intent != null) {
//            if (!Settings.hasBook()) {
//                Settings.setWordlockHasWord(false);
//                WordLockDaemon.notifyHasWord(this, false);
//                tryStop();
//            } else {
//                String action = intent.getAction();
//                if (ACTION_REFRESH_TOPN.equals(action)) {
//                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra(EXTRA_MEM_REVD_IDS);
//                    refreshTopN(stringArrayListExtra);
//                    getTodayRevdCount(stringArrayListExtra);
//                    this.mRunningTask += 2;
//                } else if (ACTION_GET_TODAY_REVD_COUNT.equals(action)) {
//                    getTodayRevdCount(intent.getStringArrayListExtra(EXTRA_MEM_REVD_IDS));
//                    this.mRunningTask++;
//                } else if (ACTION_KILL_WORD.equals(action)) {
//                    killWord(intent.getStringExtra(EXTRA_KILL_ID));
//                    this.mRunningTask++;
//                }
//            }
//        }
//        return 1;
//    }
//
//    private void refreshTopN(List<String> list) {
//        this.mDataGetter.getUnrevdTopNWords(list);
//    }
//
//    private void killWord(String str) {
//        this.mDataGetter.killWord(str);
//    }
//
//    private void getTodayRevdCount(List<String> list) {
//        if (needClear()) {
//            this.mDataGetter.clearTodayRvd(list);
//        } else {
//            this.mDataGetter.getTodayRevdCount(list);
//        }
//    }
//
//    private static final boolean needClear() {
//        String str = today();
//        String lastDateForLockRevdCount = Settings.getLastDateForLockRevdCount();
//        if (lastDateForLockRevdCount == null) {
//            Settings.setLastDateForLockRevdCount(str);
//            return false;
//        } else if (lastDateForLockRevdCount.equals(str)) {
//            return false;
//        } else {
//            Settings.setCachedLockRevdCount(0);
//            Settings.setLastDateForLockRevdCount(str);
//            return true;
//        }
//    }
//
//    private static final String today() {
//        return new SimpleDateFormat("dd-MMM-yyyy", Locale.CHINA).format(Calendar.getInstance().getTime());
//    }
//
//    /* access modifiers changed from: private */
//    public void tryStop() {
//        if (this.mRunningTask <= 0) {
//            stopSelf();
//        }
//    }
//}
