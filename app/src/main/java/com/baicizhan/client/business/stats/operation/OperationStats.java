package com.baicizhan.client.business.stats.operation;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
import com.baicizhan.client.business.util.TimeUtil;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.online.bs_users.BSUsers.Client;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationStats {
    private static final OperationStats sInstance = new OperationStats();
    private Map<String, OperationRecord> mCells = new HashMap();

    public class StatsService extends Service {
        private static final String KEY_CELLS = "cells";
        private static final int SEND_SEGMENT = 50;
        private ArrayList<OperationRecord> mCells = new ArrayList<>();
        private ArrayList<ArrayList<OperationRecord>> mCellsList = new ArrayList<>();
        /* access modifiers changed from: private */
        public int mTaskCount;

        /* access modifiers changed from: private */
        public  void start(Context context, ArrayList<OperationRecord> arrayList) {
            Intent intent = new Intent(context, StatsService.class);
            intent.putExtra(KEY_CELLS, arrayList);
            context.startService(intent);
        }

        public IBinder onBind(Intent intent) {
            return null;
        }

        public int onStartCommand(Intent intent, int i, int i2) {
            if (intent == null) {
                tryStop();
            } else {
//                sendStats(intent.getParcelableArrayListExtra(KEY_CELLS));
            }
            return 2;
        }

//        private void sendStats(final ArrayList<OperationRecord> arrayList) {
//            this.mTaskCount++;
//            BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, Void>(BaicizhanThrifts.USERS) {
//                /* access modifiers changed from: protected */
//                public Void doInBackground(Client client) {
//                    List list;
//                    boolean z;
//                    boolean z2 = false;
//                    new ArrayList();
//                    if (arrayList == null || arrayList.isEmpty()) {
//                        z = true;
//                        list = OperationRecord.toThrift(OperationHelper.getAllRecords(StatsService.this));
//                    } else {
//                        z = false;
//                        list = OperationRecord.toThrift(arrayList);
//                    }
//                    if (list != null && !list.isEmpty()) {
//                        try {
//                            if (!NetworkUtils.isWiFiConnected(StatsService.this)) {
//                                throw new RuntimeException("halt operation stats sending for non wifi networks.");
//                            }
//                            int size = (list.size() + 50) / 50;
//                            boolean z3 = false;
//                            for (int i = 0; i < size; i++) {
//                                z3 = client.user_operation_stat(list.subList(i * 50, Math.min(list.size(), (i + 1) * 50))) == 0;
//                            }
//                            z2 = z3;
//                            if (z && z2) {
//                                OperationHelper.clear(StatsService.this);
//                            }
//                        } catch (Exception e) {
//                            C0789L.log.error("send study stats failed.", (Throwable) e);
//                            if (arrayList != null && !arrayList.isEmpty()) {
//                                OperationHelper.saveRecords(StatsService.this, arrayList);
//                            }
//                        }
//                    }
//                    return null;
//                }
//
//                /* access modifiers changed from: protected */
//                public void onError(Exception exc) {
//                    StatsService.this.mTaskCount = StatsService.this.mTaskCount - 1;
//                    exc.printStackTrace();
//                    C0789L.log.error("send operation stats failed.", (Throwable) exc);
//                    StatsService.this.tryStop();
//                }
//
//                /* access modifiers changed from: protected */
//                public void onResult(Void voidR) {
//                    StatsService.this.mTaskCount = StatsService.this.mTaskCount - 1;
//                    StatsService.this.tryStop();
//                }
//            });
//        }

        public void tryStop() {
            if (this.mTaskCount <= 0) {
                stopSelf();
            }
        }
    }

    private OperationStats() {
    }

    public static OperationStats getInstance() {
        return sInstance;
    }

    public void fillCell(String str) {
        OperationRecord operationRecord = new OperationRecord();
        operationRecord.setOpName(str);
        operationRecord.setOpValue(1);
        operationRecord.setOpTime(TimeUtil.todayStart());
        fillCell(operationRecord);
    }

    public void fillCell(OperationRecord operationRecord) {
        if (operationRecord != null) {
            String str = operationRecord.getOpName() + operationRecord.getOpTime();
            if (this.mCells.containsKey(str)) {
                ((OperationRecord) this.mCells.get(str)).setOpValue(((OperationRecord) this.mCells.get(str)).getOpValue() + 1);
            } else {
                this.mCells.put(str, operationRecord);
            }
        }
    }

    public void stat(Context context) {
//        StatsService.start(context, new ArrayList(this.mCells.values()));
        this.mCells.clear();
    }

    public static void statRecite() {
        getInstance().fillCell("b_recite");
    }

    public static void statMedia() {
        getInstance().fillCell("b_media");
    }

    public static void statMediaTV() {
        getInstance().fillCell("b_media_tv");
    }

    public static void statMediaFM() {
        getInstance().fillCell("b_media_fm");
    }

    public static void statReview() {
        getInstance().fillCell("b_review");
    }

    public static void statReviewListen() {
        getInstance().fillCell("b_review_listen");
    }

    public static void statReviewRead() {
        getInstance().fillCell("b_review_read");
    }

    public static void statReviewSpell() {
        getInstance().fillCell("b_review_spell");
    }

    public static void statReviewMatch() {
        getInstance().fillCell("b_review_match");
    }

    public static void statMenu() {
        getInstance().fillCell("b_menu");
    }

    public static void statMenuList() {
        getInstance().fillCell("b_menu_list");
    }

    public static void statMenuListen() {
        getInstance().fillCell("b_menu_listen");
    }

    public static void statMenuCheck() {
        getInstance().fillCell("b_menu_check");
    }

    public static void statVocab() {
        getInstance().fillCell("b_vocab");
    }

    public static void statVocabTest() {
        getInstance().fillCell("b_vocab_test");
    }

    public static void statCart() {
        getInstance().fillCell("b_cart");
    }

    public static void statShop() {
        getInstance().fillCell("b_shop");
    }

    public static void statNotify() {
        getInstance().fillCell("m_notify");
    }

    public static void statLoad(String str) {
        getInstance().fillCell("m_load_" + str);
    }

    public static void statNativeIndex() {
        getInstance().fillCell("m_native_index");
    }

    public static void statNative(String str) {
        getInstance().fillCell("m_native_" + str);
    }

    public static void statWikiTV() {
        getInstance().fillCell("b_wiki_tv");
    }

    public static void statWikiShareWXFriend() {
        getInstance().fillCell("b_wiki_share_wx_friend");
    }

    public static void statWikiShareEXMoments() {
        getInstance().fillCell("b_wiki_share_wx_moments");
    }

    public static void statNotification() {
        getInstance().fillCell("b_notification");
    }

    public static void statNotificationShare(int i) {
        getInstance().fillCell("b_notification_share_" + i);
    }

    public static void statNotificationShareWXFriend(int i) {
        getInstance().fillCell("b_notification_share_wx_friend_" + i);
    }

    public static void statNotificationShareWXMoments(int i) {
        getInstance().fillCell("b_notification_share_wx_moments_" + i);
    }

    public static void statDakaWXFriend() {
        getInstance().fillCell("b_daka_wx_friend");
    }

    public static void statDakaWXMoments() {
        getInstance().fillCell("b_daka_wx_moments");
    }

    public static void statDakaWB() {
        getInstance().fillCell("b_daka_wb");
    }

    public static void statVocabShare() {
        getInstance().fillCell("b_vocab_share");
    }

    public static void statVocabShareWXFriend() {
        getInstance().fillCell("b_vocab_share_wx_friend");
    }

    public static void statVocabShareWXMoments() {
        getInstance().fillCell("b_vocab_share_wx_moments");
    }

    public static void statVocabAgain() {
        getInstance().fillCell("b_vocab_again");
    }

    public static void statMoreReviewTingyin() {
        getInstance().fillCell("b_more_review_tingyin");
    }

    public static void statMoreReviewDuju() {
        getInstance().fillCell("b_more_review_duju");
    }

    public static void statMoreReviewPinxie() {
        getInstance().fillCell("b_more_review_pinxie");
    }

    public static void statMoreReviewDapei() {
        getInstance().fillCell("b_more_review_dapei");
    }

    public static void statPK() {
        getInstance().fillCell("b_pk");
    }

    public static void statPKShare() {
        getInstance().fillCell("b_pk_share");
    }

    public static void statPKShareWXFriend() {
        getInstance().fillCell("b_pk_share_wx_friend");
    }

    public static void statPKShareWXMoments() {
        getInstance().fillCell("b_pk_share_wx_moments");
    }

    public static void statSimilaYes() {
        getInstance().fillCell("b_simila_yes");
    }

    public static void statSimilaNo() {
        getInstance().fillCell("b_simila_no");
    }

    public static void statAvgReviewCountPerLock(int i, long j) {
        OperationRecord operationRecord = new OperationRecord();
        operationRecord.setOpName("b_avg_review_count_per_lock");
        operationRecord.setOpValue(i);
        operationRecord.setOpTime(j);
        getInstance().fillCell(operationRecord);
    }
}
