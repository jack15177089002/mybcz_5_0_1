//package com.baicizhan.main.plusreview.data.load;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteException;
//import android.util.Log;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.main.plusreview.data.MatchTestlib;
//import com.baicizhan.main.plusreview.data.p034db.MatchResultHelper;
//import com.baicizhan.main.plusreview.data.p034db.MatchResultRecord;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import java.util.ArrayList;
//import java.util.Locale;
//import java.util.Map;
//import java.util.Map.Entry;
//
//public class MatchTestLoader {
//    private static final String DATA_LOCAL_PATH_BASE = "phrase_match_test";
//    public static final int ERR_DB = -3;
//    public static final int ERR_NET = -1;
//    public static final int ERR_NO_DATA = -2;
//    public static final int NO_ERR = 0;
//    /* access modifiers changed from: private */
//    public Context mContext;
//    /* access modifiers changed from: private */
//    public OnDataSyncListener mDataSyncListener;
//    /* access modifiers changed from: private */
//    public OnDownloadListener mLoadListener;
//
//    public interface OnDataSyncListener {
//        void onTestDataSynced(boolean z, int i);
//    }
//
//    public interface OnDownloadListener {
//        void onTestlibLoaded(boolean z, MatchTestlib matchTestlib, int i);
//    }
//
//    /* access modifiers changed from: private */
//    public static final String getDataLocalPath(int i) {
//        return String.format(Locale.US, "%s_%02d.json", new Object[]{DATA_LOCAL_PATH_BASE, Integer.valueOf(i)});
//    }
//
//    private MatchTestLoader() {
//    }
//
//    public static MatchTestLoader createInstance(Context context, OnDownloadListener onDownloadListener) {
//        return createInstance(context, onDownloadListener, null);
//    }
//
//    public static MatchTestLoader createInstance(Context context, OnDataSyncListener onDataSyncListener) {
//        return createInstance(context, null, onDataSyncListener);
//    }
//
//    public static MatchTestLoader createInstance(Context context, OnDownloadListener onDownloadListener, OnDataSyncListener onDataSyncListener) {
//        MatchTestLoader matchTestLoader = new MatchTestLoader();
//        matchTestLoader.mContext = context;
//        matchTestLoader.mLoadListener = onDownloadListener;
//        matchTestLoader.mDataSyncListener = onDataSyncListener;
//        return matchTestLoader;
//    }
//
//    public void destroy() {
//        this.mContext = null;
//    }
//
//    public void load() {
//        load(true);
//    }
//
//    public void load(final boolean z) {
//        BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, MatchTestlib>(BaicizhanThrifts.USERS) {
//            /* access modifiers changed from: protected */
//            /* JADX WARNING: Removed duplicated region for block: B:22:0x0081  */
//            /* JADX WARNING: Removed duplicated region for block: B:25:0x009b  */
//            /* Code decompiled incorrectly, please refer to instructions dump. */
//            public com.baicizhan.main.plusreview.data.MatchTestlib doInBackground(com.baicizhan.online.bs_users.BSUsers.Client r9) {
//                /*
//                    r8 = this;
//                    r4 = 0
//                    r2 = 1
//                    r1 = 0
//                    com.baicizhan.client.business.managers.StudyManager r0 = com.baicizhan.client.business.managers.StudyManager.getInstance()
//                    int r5 = r0.getCurrentBookId()
//                    com.baicizhan.main.plusreview.data.load.MatchTestLoader r0 = com.baicizhan.main.plusreview.data.load.MatchTestLoader.this
//                    android.content.Context r0 = r0.mContext
//                    java.util.Map r0 = com.baicizhan.main.plusreview.data.p034db.MatchResultHelper.getResults(r0, r5)
//                    if (r0 == 0) goto L_0x015c
//                    java.util.Set r0 = r0.entrySet()
//                    java.util.Iterator r3 = r0.iterator()
//                L_0x001f:
//                    boolean r0 = r3.hasNext()
//                    if (r0 == 0) goto L_0x015c
//                    java.lang.Object r0 = r3.next()
//                    java.util.Map$Entry r0 = (java.util.Map.Entry) r0
//                    java.lang.Object r0 = r0.getValue()
//                    com.baicizhan.main.plusreview.data.db.MatchResultRecord r0 = (com.baicizhan.main.plusreview.data.p034db.MatchResultRecord) r0
//                    int r0 = r0.getResult()
//                    if (r0 == 0) goto L_0x003a
//                    r6 = -1
//                    if (r6 != r0) goto L_0x001f
//                L_0x003a:
//                    r0 = r1
//                L_0x003b:
//                    java.lang.String r3 = com.baicizhan.main.plusreview.data.load.MatchTestLoader.getDataLocalPath(r5)
//                    java.io.File r6 = com.baicizhan.client.business.util.PathUtil.getBaicizhanFile(r3)
//                    if (r6 == 0) goto L_0x0159
//                    boolean r3 = r6.exists()
//                    if (r3 == 0) goto L_0x0159
//                    if (r0 == 0) goto L_0x008d
//                    r6.delete()
//                    com.baicizhan.main.plusreview.data.load.MatchTestLoader r3 = com.baicizhan.main.plusreview.data.load.MatchTestLoader.this
//                    android.content.Context r3 = r3.mContext
//                    com.baicizhan.main.plusreview.data.p034db.MatchResultHelper.clearResults(r3, r5)
//                    r3 = r4
//                L_0x005a:
//                    boolean r7 = android.text.TextUtils.isEmpty(r3)
//                    if (r7 != 0) goto L_0x0062
//                    if (r0 == 0) goto L_0x0156
//                L_0x0062:
//                    r9.redo_word_friend()
//                    java.lang.String r3 = r9.get_word_friends_info(r5)
//                    org.slf4j.Logger r0 = com.baicizhan.client.framework.log.C0789L.log
//                    java.lang.String r7 = "phrase match data from server is {}"
//                    r0.info(r7, r3)
//                    java.lang.String r0 = r6.getAbsolutePath()
//                    byte[] r7 = r3.getBytes()
//                    com.baicizhan.client.business.util.FileUtil.saveFile(r0, r7)
//                L_0x007b:
//                    boolean r0 = android.text.TextUtils.isEmpty(r3)
//                    if (r0 == 0) goto L_0x009b
//                    org.slf4j.Logger r0 = com.baicizhan.client.framework.log.C0789L.log
//                    java.lang.String r1 = "phrase match data is {}, not valid, and is from server? {}"
//                    java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
//                    r0.info(r1, r3, r2)
//                L_0x008c:
//                    return r4
//                L_0x008d:
//                    java.lang.String r3 = new java.lang.String
//                    java.lang.String r7 = r6.getAbsolutePath()
//                    byte[] r7 = com.baicizhan.client.business.util.FileUtil.getFileData(r7)
//                    r3.<init>(r7)
//                    goto L_0x005a
//                L_0x009b:
//                    com.baicizhan.main.plusreview.data.MatchTestlib r4 = com.baicizhan.main.plusreview.data.MatchTestlib.parse(r3)
//                    if (r4 == 0) goto L_0x008c
//                    boolean r0 = r4.isEmpty()
//                    if (r0 != 0) goto L_0x008c
//                    if (r2 == 0) goto L_0x00ee
//                    java.util.ArrayList r2 = new java.util.ArrayList
//                    r2.<init>()
//                    java.util.List r0 = r4.getReview_words()
//                    java.util.Iterator r3 = r0.iterator()
//                L_0x00b6:
//                    boolean r0 = r3.hasNext()
//                    if (r0 == 0) goto L_0x00d5
//                    java.lang.Object r0 = r3.next()
//                    com.baicizhan.main.plusreview.data.MatchTestlib$Word r0 = (com.baicizhan.main.plusreview.data.MatchTestlib.Word) r0
//                    com.baicizhan.main.plusreview.data.db.MatchResultRecord r6 = new com.baicizhan.main.plusreview.data.db.MatchResultRecord
//                    r6.<init>()
//                    int r0 = r0.getWord_topic_id()
//                    r6.setTopicId(r0)
//                    r6.setResult(r1)
//                    r2.add(r6)
//                    goto L_0x00b6
//                L_0x00d5:
//                    com.baicizhan.main.plusreview.data.load.MatchTestLoader r0 = com.baicizhan.main.plusreview.data.load.MatchTestLoader.this
//                    android.content.Context r0 = r0.mContext
//                    com.baicizhan.main.plusreview.data.p034db.MatchResultHelper.refreshResults(r0, r5, r2)
//                L_0x00de:
//                    if (r4 == 0) goto L_0x008c
//                    com.baicizhan.main.plusreview.data.load.MatchTestLoader r0 = com.baicizhan.main.plusreview.data.load.MatchTestLoader.this
//                    android.content.Context r0 = r0.mContext
//                    java.util.Map r0 = com.baicizhan.main.plusreview.data.p034db.MatchResultHelper.getResults(r0, r5)
//                    r4.setResult_records(r0)
//                    goto L_0x008c
//                L_0x00ee:
//                    java.util.ArrayList r1 = new java.util.ArrayList
//                    r1.<init>()
//                    java.util.List r0 = r4.getReview_words()
//                    java.util.Iterator r2 = r0.iterator()
//                L_0x00fb:
//                    boolean r0 = r2.hasNext()
//                    if (r0 == 0) goto L_0x0138
//                    java.lang.Object r0 = r2.next()
//                    com.baicizhan.main.plusreview.data.MatchTestlib$Word r0 = (com.baicizhan.main.plusreview.data.MatchTestlib.Word) r0
//                    com.baicizhan.client.business.managers.LearnRecordManager r3 = com.baicizhan.client.business.managers.LearnRecordManager.getInstance()
//                    int r7 = r0.getWord_topic_id()
//                    boolean r3 = r3.isKilled(r7)
//                    if (r3 == 0) goto L_0x0134
//                    java.util.Map r3 = r4.getResult_records()
//                    if (r3 == 0) goto L_0x012a
//                    java.util.Map r3 = r4.getResult_records()
//                    int r0 = r0.getWord_topic_id()
//                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
//                    r3.remove(r0)
//                L_0x012a:
//                    int r0 = r4.getReview_count()
//                    int r0 = r0 + -1
//                    r4.setReview_count(r0)
//                    goto L_0x00fb
//                L_0x0134:
//                    r1.add(r0)
//                    goto L_0x00fb
//                L_0x0138:
//                    r4.setReview_words(r1)
//                    boolean r0 = r4.isEmpty()
//                    if (r0 == 0) goto L_0x00de
//                    if (r6 == 0) goto L_0x00de
//                    boolean r0 = r6.exists()
//                    if (r0 == 0) goto L_0x00de
//                    r6.delete()
//                    com.baicizhan.main.plusreview.data.load.MatchTestLoader r0 = com.baicizhan.main.plusreview.data.load.MatchTestLoader.this
//                    android.content.Context r0 = r0.mContext
//                    com.baicizhan.main.plusreview.data.p034db.MatchResultHelper.clearResults(r0, r5)
//                    goto L_0x00de
//                L_0x0156:
//                    r2 = r1
//                    goto L_0x007b
//                L_0x0159:
//                    r3 = r4
//                    goto L_0x005a
//                L_0x015c:
//                    r0 = r2
//                    goto L_0x003b
//                */
//                throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.main.plusreview.data.load.MatchTestLoader.C11741.doInBackground(com.baicizhan.online.bs_users.BSUsers$Client):com.baicizhan.main.plusreview.data.MatchTestlib");
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                Log.d("whiz", "get match data err: " + exc);
//                if (MatchTestLoader.this.mLoadListener != null && MatchTestLoader.this.mContext != null) {
//                    if (exc instanceof SQLiteException) {
//                        MatchTestLoader.this.mLoadListener.onTestlibLoaded(false, null, -3);
//                    } else {
//                        MatchTestLoader.this.mLoadListener.onTestlibLoaded(false, null, -1);
//                    }
//                }
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(MatchTestlib matchTestlib) {
//                if (MatchTestLoader.this.mLoadListener != null && MatchTestLoader.this.mContext != null) {
//                    if (matchTestlib != null && !matchTestlib.isEmpty()) {
//                        MatchTestLoader.this.mLoadListener.onTestlibLoaded(true, matchTestlib, 0);
//                    } else if (z) {
//                        C0789L.log.info("phrase match data getting retry.");
//                        MatchTestLoader.this.load(false);
//                    } else {
//                        MatchTestLoader.this.mLoadListener.onTestlibLoaded(false, null, -2);
//                    }
//                }
//            }
//        });
//    }
//
//    public void sync(final Map<Integer, MatchResultRecord> map) {
//        BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, Boolean>(BaicizhanThrifts.USERS) {
//            private int mErr = 0;
//
//            /* access modifiers changed from: protected */
//            public Boolean doInBackground(Client client) {
//                if (map == null || map.isEmpty()) {
//                    this.mErr = -2;
//                    return Boolean.valueOf(false);
//                }
//                int currentBookId = StudyManager.getInstance().getCurrentBookId();
//                ArrayList arrayList = new ArrayList();
//                ArrayList arrayList2 = new ArrayList();
//                for (Entry value : map.entrySet()) {
//                    MatchResultRecord matchResultRecord = (MatchResultRecord) value.getValue();
//                    if (matchResultRecord.getResult() != 0) {
//                        arrayList.add(Integer.valueOf(matchResultRecord.getTopicId()));
//                    }
//                    arrayList2.add(matchResultRecord);
//                }
//                if (!arrayList.isEmpty()) {
//                    client.save_word_friend_done_record(currentBookId, arrayList);
//                }
//                MatchResultHelper.refreshResults(MatchTestLoader.this.mContext, currentBookId, arrayList2);
//                this.mErr = 0;
//                return Boolean.valueOf(true);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                Log.d("whiz", "sync match data err: " + exc);
//                if (MatchTestLoader.this.mDataSyncListener != null && MatchTestLoader.this.mContext != null) {
//                    MatchTestLoader.this.mDataSyncListener.onTestDataSynced(false, -1);
//                }
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(Boolean bool) {
//                if (MatchTestLoader.this.mDataSyncListener != null && MatchTestLoader.this.mContext != null) {
//                    if (!bool.booleanValue()) {
//                        MatchTestLoader.this.mDataSyncListener.onTestDataSynced(false, this.mErr);
//                    } else {
//                        MatchTestLoader.this.mDataSyncListener.onTestDataSynced(true, this.mErr);
//                    }
//                }
//            }
//        });
//    }
//}
