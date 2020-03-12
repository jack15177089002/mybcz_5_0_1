//package com.baicizhan.main.stats.study;
//
//import android.app.Service;
//import android.content.Context;
//import android.content.Intent;
//import android.os.IBinder;
//import android.util.Log;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.online.bs_users.BBDoneWordStatLog;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.baicizhan.online.bs_words.BBSimilarWordVote;
//import com.baicizhan.online.bs_words.BSWords;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import org.p100a.p101a.p107f.C2120g;
//
//public class StudyStats {
//    /* access modifiers changed from: private */
//    public static final String TAG = StudyStats.class.getSimpleName();
//    private static StudyStats sInstance = new StudyStats();
//    private List<BBDoneWordStatLog> mCells = new ArrayList();
//    /* access modifiers changed from: private */
//    public List<List<BBDoneWordStatLog>> mCellsList = new ArrayList();
//    /* access modifiers changed from: private */
//    public List<BBSimilarWordVote> mSimilarWordVotes = Collections.synchronizedList(new ArrayList());
//
//    public class StatsService extends Service {
//        private static final int SEND_SEGMENT = 50;
//        /* access modifiers changed from: private */
//        public int mTaskCount;
//
//        public static void start(Context context) {
//            context.startService(new Intent(context, StatsService.class));
//        }
//
//        public IBinder onBind(Intent intent) {
//            return null;
//        }
//
//        public int onStartCommand(Intent intent, int i, int i2) {
//            sendStats();
//            sendSimilarWordVotes();
//            return 2;
//        }
//
//        private void sendStats() {
//            this.mTaskCount++;
//            if (StudyStats.getsInstance().mCellsList == null || StudyStats.getsInstance().mCellsList.isEmpty()) {
//                this.mTaskCount--;
//                tryStop();
//                return;
//            }
//            final List list = (List) StudyStats.getsInstance().mCellsList.remove(0);
//            final int currentBookId = StudyManager.getInstance().getCurrentBookId();
//            BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, Void>(BaicizhanThrifts.USERS) {
//                /* access modifiers changed from: protected */
//                public Void doInBackground(Client client) {
//                    List list;
//                    boolean z;
//                    boolean z2;
//                    boolean z3;
//                    List list2 = list;
//                    if (list2 == null || list2.isEmpty()) {
//                        z = true;
//                        list = WordDoneRecord.toThrift(WordDoneRecordHelper.getAllRecords(StatsService.this));
//                    } else {
//                        z = false;
//                        list = list2;
//                    }
//                    if (list != null && !list.isEmpty()) {
//                        try {
//                            if (!NetworkUtils.isWiFiConnected(StatsService.this)) {
//                                throw new RuntimeException("halt study stats sending for non wifi networks.");
//                            }
//                            int size = (list.size() + 50) / 50;
//                            int i = 0;
//                            z2 = false;
//                            while (i < size) {
//                                List subList = list.subList(i * 50, Math.min(list.size(), (i + 1) * 50));
//                                int done_word_stat = client.done_word_stat(currentBookId, subList);
//                                if (done_word_stat == 0) {
//                                    z3 = true;
//                                } else {
//                                    z3 = false;
//                                }
//                                LogWrapper.m2793d("whiz", "send study stats seg result: " + done_word_stat + "; first data: " + ((BBDoneWordStatLog) subList.get(0)).getTopic_id());
//                                i++;
//                                z2 = z3;
//                            }
//                            if (z && z2) {
//                                WordDoneRecordHelper.clear(StatsService.this);
//                            }
//                        } catch (Exception e) {
//                            LogWrapper.m2793d("whiz", "send study stats failed." + e);
//                            if (list != null && !list.isEmpty()) {
//                                WordDoneRecordHelper.saveRecords(StatsService.this, WordDoneRecord.fromThrift(list));
//                            }
//                            z2 = false;
//                        }
//                    }
//                    return null;
//                }
//
//                /* access modifiers changed from: protected */
//                public void onError(Exception exc) {
//                    StatsService.this.mTaskCount = StatsService.this.mTaskCount - 1;
//                    exc.printStackTrace();
//                    LogWrapper.m2793d("whiz", "send study stats failed." + exc);
//                    StatsService.this.tryStop();
//                }
//
//                /* access modifiers changed from: protected */
//                public void onResult(Void voidR) {
//                    StatsService.this.mTaskCount = StatsService.this.mTaskCount - 1;
//                    LogWrapper.m2793d("whiz", "send study stats completed.");
//                    StatsService.this.tryStop();
//                }
//            });
//        }
//
//        private void sendSimilarWordVotes() {
//            LogWrapper.m2793d(StudyStats.TAG, "sendSimilarWordVotes");
//            final int currentBookId = StudyManager.getInstance().getCurrentBookId();
//            this.mTaskCount++;
//            if (StudyStats.getsInstance().mSimilarWordVotes.size() == 0) {
//                this.mTaskCount--;
//                tryStop();
//                return;
//            }
//            final ArrayList arrayList = new ArrayList(StudyStats.getsInstance().mSimilarWordVotes);
//            C12242 r2 = new ThriftRequest<BSWords.Client, Integer>(BaicizhanThrifts.WORDS) {
//                /* access modifiers changed from: protected */
//                public Integer doInBackground(BSWords.Client client) {
//                    int similar_words_vote = client.similar_words_vote(currentBookId, arrayList);
//                    LogWrapper.m2793d(StudyStats.TAG, "similar_words_vote " + similar_words_vote);
//                    return Integer.valueOf(similar_words_vote);
//                }
//
//                /* access modifiers changed from: protected */
//                public void onError(Exception exc) {
//                    if (!(exc instanceof C2120g)) {
//                        LogWrapper.m2794e(StudyStats.TAG, Log.getStackTraceString(exc));
//                    }
//                    StatsService.this.mTaskCount = StatsService.this.mTaskCount - 1;
//                    StatsService.this.tryStop();
//                }
//
//                /* access modifiers changed from: protected */
//                public void onResult(Integer num) {
//                    StudyStats.getsInstance().mSimilarWordVotes.clear();
//                    StatsService.this.mTaskCount = StatsService.this.mTaskCount - 1;
//                    StatsService.this.tryStop();
//                }
//            };
//            r2.setTag(StudyStats.TAG);
//            BaicizhanThrifts.getProxy().add(r2);
//        }
//
//        /* access modifiers changed from: private */
//        public boolean tryStop() {
//            if (this.mTaskCount > 0) {
//                return false;
//            }
//            stopSelf();
//            return true;
//        }
//    }
//
//    private StudyStats() {
//    }
//
//    public static StudyStats getsInstance() {
//        return sInstance;
//    }
//
//    public void fillCell(BBDoneWordStatLog bBDoneWordStatLog) {
//        this.mCells.add(bBDoneWordStatLog);
//    }
//
//    public void fillSimilarWordVote(BBSimilarWordVote bBSimilarWordVote) {
//        this.mSimilarWordVotes.add(bBSimilarWordVote);
//    }
//
//    public void stat(Context context) {
//        if (!StudyManager.getInstance().isOfflined()) {
//            this.mCellsList.add(new ArrayList(this.mCells));
//            this.mCells.clear();
//            StatsService.start(context);
//        }
//    }
//}
