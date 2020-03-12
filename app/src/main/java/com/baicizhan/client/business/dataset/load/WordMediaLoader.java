//package com.baicizhan.client.business.dataset.load;
//
//import android.content.Context;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.helpers.BookRecordHelper;
//import com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper;
//import com.baicizhan.client.business.dataset.models.BookRecord;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.business.dataset.models.WordMediaUpdRecord;
//import com.baicizhan.client.business.dataset.thrifadapt.PrimaryAdapter;
//import com.baicizhan.client.business.dataset.thrifadapt.WordMediaReviewRecordAdapter;
//import com.baicizhan.client.business.dataset.thrifadapt.WordMediaUpdRecordAdapter;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
////import com.baicizhan.online.bs_users.BSUsers.Client;
////import com.baicizhan.online.bs_words.BSWords;
//import java.util.ArrayList;
//import java.util.List;
//
//public class WordMediaLoader {
//    public static final int ERR_NETWORKS = -1;
//    public static final int NO_ERR = 0;
//    private static final int SEND_SEGMENT = 50;
//    /* access modifiers changed from: private */
//    public Context mContext;
//    /* access modifiers changed from: private */
//    public OnWordMediaLoaderListener mListener;
//    /* access modifiers changed from: private */
//    public OnWordMediaReviewSyncListener mListener2;
//
//    public interface OnWordMediaLoaderListener {
//        void onInserted(boolean z, int i, List<WordMediaRecord> list);
//
//        void onMidRefreshed(boolean z, int i);
//
//        void onUpdated(boolean z, int i);
//    }
//
//    public interface OnWordMediaReviewSyncListener {
//        void onWordMeidaReviewSynced(boolean z, int i);
//    }
//
//    public static WordMediaLoader createLoader(Context context, OnWordMediaLoaderListener onWordMediaLoaderListener, OnWordMediaReviewSyncListener onWordMediaReviewSyncListener) {
//        WordMediaLoader wordMediaLoader = new WordMediaLoader(context);
//        wordMediaLoader.mListener = onWordMediaLoaderListener;
//        wordMediaLoader.mListener2 = onWordMediaReviewSyncListener;
//        return wordMediaLoader;
//    }
//
//    private WordMediaLoader(Context context) {
//        this.mContext = context;
//    }
//
//    public void destroy() {
//        this.mContext = null;
//    }
//
//    public void update(int i) {
//        if (this.mContext != null) {
////            refreshWordMediaUpdRecords(i);
//        }
//    }
//
//    public void updateReviewRecords(int i) {
//        if (this.mContext != null) {
////            refreshWordMediaReviewRecords(i);
//        }
//    }
//
////    public void syncUpdateReviewRecords(Client client, int i) {
////        if (this.mContext != null) {
////            syncRefreshWordMediaReviewRecords(client, i);
////        }
////    }
//
//    public void refreshMid() {
//        if (this.mContext != null) {
////            refreshWordMediaMidRecords();
//        }
//    }
//
//    public void insert(int i, List<String> list) {
//        if (this.mContext != null) {
////            requestWordMediaRecords(i, list);
//        }
//    }
//
////    public static List<WordMediaRecord> doRequestWordMediaRecords(List<Integer> list, BSWords.Client client) {
////        ArrayList arrayList = new ArrayList(list.size());
////        int size = (list.size() + 50) / 50;
////        for (int i = 0; i < size; i++) {
////            ArrayList arrayList2 = new ArrayList(50);
////            int min = Math.min(list.size(), (i + 1) * 50);
////            for (int i2 = i * 50; i2 < min; i2++) {
////                arrayList2.add(list.get(i2));
////            }
////            arrayList.addAll(client.word_media_by_topic_ids_v2(arrayList2));
////            Log.d("whiz", "get word media seg records, out: " + i + "; part: " + size + "; send ids size: " + arrayList2.size());
////        }
////        return WordMediaRecord.fromList(arrayList);
////    }
//
////    public static void doRefreshAllWordMediaRecords(Context context, int i, BSWords.Client client) {
////        List allWordMediaRecordsFromUpdate;
////        List arrayList = new ArrayList();
////        if (WordMediaRecordHelper.isWordMediaUpdRecordsEmpty(context, i)) {
////            List<WordMediaUpdRecord> refreshWordMediaUpdRecords = refreshWordMediaUpdRecords(context, i, client);
////            if (refreshWordMediaUpdRecords != null && !refreshWordMediaUpdRecords.isEmpty()) {
////                for (WordMediaUpdRecord wordid : refreshWordMediaUpdRecords) {
////                    arrayList.add(wordid.getWordid());
////                }
////                allWordMediaRecordsFromUpdate = arrayList;
////            } else {
////                return;
////            }
////        } else {
////            allWordMediaRecordsFromUpdate = WordMediaRecordHelper.getAllWordMediaRecordsFromUpdate(context, i);
////        }
////        if (allWordMediaRecordsFromUpdate != null && !allWordMediaRecordsFromUpdate.isEmpty()) {
////            WordMediaRecordHelper.updateWordMediaRecords(context, i, doRequestWordMediaRecords(PrimaryAdapter.toList(allWordMediaRecordsFromUpdate), client), true);
////        }
////    }
//
////    public static List<WordMediaUpdRecord> refreshWordMediaUpdRecords(Context context, int i, BSWords.Client client) {
////        List<WordMediaUpdRecord> fromList = WordMediaUpdRecordAdapter.fromList(client.get_word_media_update_info(i));
////        if (fromList == null || fromList.isEmpty()) {
////            return null;
////        }
////        WordMediaRecordHelper.refreshWordMediaUpdRecords(context, i, fromList);
////        return fromList;
////    }
////
////    private void refreshWordMediaUpdRecords(final int i) {
////        BaicizhanThrifts.getProxy().add(new ThriftRequest<BSWords.Client, Void>(BaicizhanThrifts.WORDS) {
////            /* access modifiers changed from: protected */
////            public Void doInBackground(BSWords.Client client) {
////                BookRecord currentBook = StudyManager.getInstance().getCurrentBook();
////                if (currentBook == null || currentBook.localRadioResVer != currentBook.remoteRadioResVer || WordMediaRecordHelper.isWordMediaUpdRecordsEmpty(WordMediaLoader.this.mContext, i)) {
////                    List fromList = WordMediaUpdRecordAdapter.fromList(client.get_word_media_update_info(i));
////                    if (fromList == null || fromList.isEmpty()) {
////                        updateBookRecord(currentBook);
////                    } else {
////                        WordMediaRecordHelper.refreshWordMediaUpdRecords(WordMediaLoader.this.mContext, i, fromList);
////                        List wordMediaRecordsToUpdate = WordMediaRecordHelper.getWordMediaRecordsToUpdate(WordMediaLoader.this.mContext, i);
////                        if (wordMediaRecordsToUpdate == null || wordMediaRecordsToUpdate.isEmpty()) {
////                            updateBookRecord(currentBook);
////                        } else {
////                            WordMediaRecordHelper.updateWordMediaRecords(WordMediaLoader.this.mContext, i, WordMediaLoader.doRequestWordMediaRecords(PrimaryAdapter.toList(wordMediaRecordsToUpdate), client), false);
////                            updateBookRecord(currentBook);
////                        }
////                    }
////                }
////                return null;
////            }
////
////            private void updateBookRecord(BookRecord bookRecord) {
////                if (bookRecord != null) {
////                    bookRecord.localRadioResVer = bookRecord.remoteRadioResVer;
////                    BookRecordHelper.saveBookRecord(WordMediaLoader.this.mContext, bookRecord);
////                }
////            }
////
////            /* access modifiers changed from: protected */
////            public void onError(Exception exc) {
////                if (WordMediaLoader.this.mListener != null) {
////                    WordMediaLoader.this.mListener.onUpdated(false, -1);
////                }
////            }
////
////            /* access modifiers changed from: protected */
////            public void onResult(Void voidR) {
////                if (WordMediaLoader.this.mListener != null) {
////                    WordMediaLoader.this.mListener.onUpdated(true, 0);
////                }
////            }
////        });
////    }
////
////    private void requestWordMediaRecords(final int i, final List<String> list) {
////        BaicizhanThrifts.getProxy().add(new ThriftRequest<BSWords.Client, List<WordMediaRecord>>(BaicizhanThrifts.WORDS) {
////            /* access modifiers changed from: protected */
////            public List<WordMediaRecord> doInBackground(BSWords.Client client) {
////                List<WordMediaRecord> doRequestWordMediaRecords = WordMediaLoader.doRequestWordMediaRecords(PrimaryAdapter.toList(list), client);
////                WordMediaRecordHelper.insertWordMediaRecords(WordMediaLoader.this.mContext, i, doRequestWordMediaRecords);
////                return doRequestWordMediaRecords;
////            }
////
////            /* access modifiers changed from: protected */
////            public void onError(Exception exc) {
////                if (WordMediaLoader.this.mListener != null) {
////                    WordMediaLoader.this.mListener.onInserted(false, -1, null);
////                }
////            }
////
////            /* access modifiers changed from: protected */
////            public void onResult(List<WordMediaRecord> list) {
////                if (WordMediaLoader.this.mListener != null) {
////                    WordMediaLoader.this.mListener.onInserted(true, 0, list);
////                }
////            }
////        });
////    }
////
////    private void refreshWordMediaMidRecords() {
////        BaicizhanThrifts.getProxy().add(new ThriftRequest<BSWords.Client, Void>(BaicizhanThrifts.WORDS) {
////            /* access modifiers changed from: protected */
////            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0063, code lost:
////                if (android.text.TextUtils.isEmpty(r4) == false) goto L_0x0065;
////             */
////            /* Code decompiled incorrectly, please refer to instructions dump. */
////            public Void doInBackground(com.baicizhan.online.bs_words.BSWords.Client r8) {
////                /*
////                    r7 = this;
////                    r6 = 0
////                    com.baicizhan.client.business.managers.StudyManager r0 = com.baicizhan.client.business.managers.StudyManager.getInstance()
////                    com.baicizhan.online.bs_users.BBCheckInfo r0 = r0.getCheckInfo()
////                    if (r0 == 0) goto L_0x0066
////                    long r0 = r0.getUpdate_at_of_word_fm_halftime_audio()
////                    com.baicizhan.client.business.dataset.load.WordMediaLoader r2 = com.baicizhan.client.business.dataset.load.WordMediaLoader.this
////                    android.content.Context r2 = r2.mContext
////                    r4 = 0
////                    boolean r0 = com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper.refreshWordMediaMidUpdTime(r2, r0, r4)
////                    com.baicizhan.client.business.dataset.load.WordMediaLoader r1 = com.baicizhan.client.business.dataset.load.WordMediaLoader.this
////                    android.content.Context r1 = r1.mContext
////                    r2 = 0
////                    java.util.List r1 = com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper.getWordMediaMidRecords(r1, r2)
////                    com.baicizhan.client.business.dataset.load.WordMediaLoader r2 = com.baicizhan.client.business.dataset.load.WordMediaLoader.this
////                    android.content.Context r2 = r2.mContext
////                    r3 = 1
////                    java.util.List r2 = com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper.getWordMediaMidRecords(r2, r3)
////                    com.baicizhan.client.business.dataset.load.WordMediaLoader r3 = com.baicizhan.client.business.dataset.load.WordMediaLoader.this
////                    android.content.Context r3 = r3.mContext
////                    r4 = 2
////                    java.lang.String r3 = com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper.getBorderMediaPath(r3, r4)
////                    com.baicizhan.client.business.dataset.load.WordMediaLoader r4 = com.baicizhan.client.business.dataset.load.WordMediaLoader.this
////                    android.content.Context r4 = r4.mContext
////                    r5 = 3
////                    java.lang.String r4 = com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper.getBorderMediaPath(r4, r5)
////                    if (r0 != 0) goto L_0x0066
////                    if (r1 == 0) goto L_0x0066
////                    boolean r0 = r1.isEmpty()
////                    if (r0 != 0) goto L_0x0066
////                    if (r2 == 0) goto L_0x0066
////                    boolean r0 = r2.isEmpty()
////                    if (r0 != 0) goto L_0x0066
////                    boolean r0 = android.text.TextUtils.isEmpty(r3)
////                    if (r0 != 0) goto L_0x0066
////                    boolean r0 = android.text.TextUtils.isEmpty(r4)
////                    if (r0 != 0) goto L_0x0066
////                L_0x0065:
////                    return r6
////                L_0x0066:
////                    com.baicizhan.online.bs_words.BBWordMediaHalftimeList r0 = r8.get_word_media_halftime_list()
////                    java.util.List r0 = com.baicizhan.client.business.dataset.thrifadapt.WordMediaMidRecordAdapter.fromList(r0)
////                    com.baicizhan.client.business.dataset.load.WordMediaLoader r1 = com.baicizhan.client.business.dataset.load.WordMediaLoader.this
////                    android.content.Context r1 = r1.mContext
////                    com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper.refreshWordMediaMidRecords(r1, r0)
////                    goto L_0x0065
////                */
////                throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.dataset.load.WordMediaLoader.C05873.doInBackground(com.baicizhan.online.bs_words.BSWords$Client):java.lang.Void");
////            }
////
////            /* access modifiers changed from: protected */
////            public void onError(Exception exc) {
////                if (WordMediaLoader.this.mListener != null) {
////                    WordMediaLoader.this.mListener.onMidRefreshed(false, -1);
////                }
////            }
////
////            /* access modifiers changed from: protected */
////            public void onResult(Void voidR) {
////                if (WordMediaLoader.this.mListener != null) {
////                    WordMediaLoader.this.mListener.onMidRefreshed(true, 0);
////                }
////            }
////        });
////    }
////
////    private void refreshWordMediaReviewRecords(final int i) {
////        BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, Void>(BaicizhanThrifts.USERS) {
////            /* access modifiers changed from: protected */
////            public Void doInBackground(Client client) {
////                WordMediaLoader.this.syncRefreshWordMediaReviewRecords(client, i);
////                return null;
////            }
////
////            /* access modifiers changed from: protected */
////            public void onError(Exception exc) {
////                if (WordMediaLoader.this.mListener2 != null) {
////                    WordMediaLoader.this.mListener2.onWordMeidaReviewSynced(false, -1);
////                }
////            }
////
////            /* access modifiers changed from: protected */
////            public void onResult(Void voidR) {
////                if (WordMediaLoader.this.mListener2 != null) {
////                    WordMediaLoader.this.mListener2.onWordMeidaReviewSynced(true, 0);
////                }
////            }
////        });
////    }
////
////    /* access modifiers changed from: private */
////    public void syncRefreshWordMediaReviewRecords(Client client, int i) {
////        List list = WordMediaReviewRecordAdapter.toList(WordMediaRecordHelper.getWordMediaReviewRecordsNeedSync(this.mContext, i));
////        int size = (list.size() + 50) / 50;
////        for (int i2 = 0; i2 < size; i2++) {
////            ArrayList arrayList = new ArrayList(50);
////            int min = Math.min(list.size(), (i2 + 1) * 50);
////            for (int i3 = i2 * 50; i3 < min; i3++) {
////                arrayList.add(list.get(i3));
////            }
////            client.sync_user_word_media_record(arrayList);
////            Log.d("whiz", "sync user word media record, out: " + i2 + "; part: " + size + "; send segs size: " + arrayList.size());
////        }
////        WordMediaRecordHelper.refreshWordMediaReviewRecords(this.mContext, i, WordMediaReviewRecordAdapter.fromList(client.get_user_word_media_record(i)));
////    }
//}
