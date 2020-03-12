//package com.baicizhan.client.p029fm.data.load;
//
//import android.content.Context;
//import android.database.Cursor;
//import com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper;
//import com.baicizhan.client.business.dataset.load.WordMediaLoader;
//import com.baicizhan.client.business.dataset.models.TopicLearnRecord;
//import com.baicizhan.client.business.dataset.models.WordMediaMidRecord;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.business.dataset.provider.Contracts.BOOK_TS_OFFLINE_ROAD_MAP_IDS;
//import com.baicizhan.client.business.dataset.provider.Contracts.BOOK_TS_OFFLINE_ROAD_MAP_IDS.Columns;
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_WORD_RADIO_HALF_TIME;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_WORD_STATION_DATA_ALL;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZBOOKWORDINFO;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.ProviderUtils;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.client.p029fm.data.FmList;
//import com.baicizhan.client.p029fm.data.FmMidList;
//import com.baicizhan.client.p029fm.data.p030db.WordIdRecordHelper;
//import com.baicizhan.client.p029fm.data.p030db.WordInfoRecordHelper;
//import com.baicizhan.learning_strategy.bean.ProblemProxy;
//import com.baicizhan.learning_strategy.iface.LearningManager;
//import com.baicizhan.learning_strategy.iface.SequenceStrategy;
////import com.baicizhan.online.bs_words.BSWords.Client;
//import com.google.gson.Gson;//import com.p020b.p021a.Gson;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import org.slf4j.Logger;
//
///* renamed from: com.baicizhan.client.fm.data.load.FmListLoader */
//public class FmListLoader {
//    public static final int ERR_NETWORKS = -1;
//    public static final int NO_ERR = 0;
//    private static final int SEND_SEGMENT = 50;
//    private volatile int mCancelType;
//    /* access modifiers changed from: private */
//    public Context mContext;
//    /* access modifiers changed from: private */
//    public OnFmListLoadListener mListener;
//
//    /* renamed from: com.baicizhan.client.fm.data.load.FmListLoader$FmListParams */
//    class FmListParams {
//        /* access modifiers changed from: private */
//        public Object cookie;
//        /* access modifiers changed from: private */
//        public FmList list;
//        /* access modifiers changed from: private */
//        public FmMidList midlist;
//
//        private FmListParams() {
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.data.load.FmListLoader$FmParams */
//    class FmParams {
//        /* access modifiers changed from: private */
//        public Object cookie;
//        /* access modifiers changed from: private */
//        public List<WordMediaRecord> fmrecords;
//        /* access modifiers changed from: private */
//        public List<String> wordids;
//
//        private FmParams() {
//        }
//    }
//
//    /* renamed from: com.baicizhan.client.fm.data.load.FmListLoader$OnFmListLoadListener */
//    public interface OnFmListLoadListener {
//        void onGetFmInfos(List<WordMediaRecord> list, Object obj);
//
//        void onGetFmList(FmList fmList, FmMidList fmMidList, Object obj);
//
//        void onGetWordIds(List<String> list, List<WordMediaRecord> list2, Object obj);
//    }
//
//    /* renamed from: com.baicizhan.client.fm.data.load.FmListLoader$UpdateInfo */
//    class UpdateInfo {
//        /* access modifiers changed from: private */
//        public int tapescript_id;
//        private long tv_updated_at;
//        /* access modifiers changed from: private */
//        public long updated_at;
//
//        private UpdateInfo() {
//        }
//    }
//
//    private FmListLoader(Context context) {
//        this.mContext = context;
//    }
//
//    public static FmListLoader born(Context context) {
//        return new FmListLoader(context);
//    }
//
//    public FmListLoader setListener(OnFmListLoadListener onFmListLoadListener) {
//        this.mListener = onFmListLoadListener;
//        return this;
//    }
//
//    public void getFmList(int i, int i2, Object obj) {
//        final int i3 = i;
//        final int i4 = i2;
//        final Object obj2 = obj;
////        BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, FmListParams>(BaicizhanThrifts.WORDS) {
////            /* access modifiers changed from: protected */
////            public FmListParams doInBackground(Client client) {
////                FmListParams fmListParams = new FmListParams();
////                fmListParams.list = FmListLoader.getFmList(client, FmListLoader.this.mContext, i3, i4);
////                fmListParams.midlist = FmListLoader.getFmMidList(client, FmListLoader.this.mContext);
////                fmListParams.cookie = obj2;
////                return fmListParams;
////            }
////
////            /* access modifiers changed from: protected */
////            public void onError(Exception exc) {
////                C0789L.log.error("get fm list failed.", (Throwable) exc);
////                if (FmListLoader.this.mListener != null) {
////                    FmListLoader.this.mListener.onGetFmList(null, null, null);
////                }
////            }
////
////            /* access modifiers changed from: protected */
////            public void onResult(FmListParams fmListParams) {
////                if (FmListLoader.this.mListener != null) {
////                    FmListLoader.this.mListener.onGetFmList(fmListParams.list, fmListParams.midlist, fmListParams.cookie);
////                }
////            }
////        });
//    }
//
//    public void getFmList(int i, List<String> list, Object obj) {
//        final int i2 = i;
//        final List<String> list2 = list;
//        final Object obj2 = obj;
////        BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, FmListParams>(BaicizhanThrifts.WORDS) {
////            /* access modifiers changed from: protected */
////            public FmListParams doInBackground(Client client) {
////                FmListParams fmListParams = new FmListParams();
////                Client client2 = client;
////                fmListParams.list = FmListLoader.getFmList(client2, FmListLoader.this.mContext, i2, list2, FmListLoader.getWordsWithoutFm(client, FmListLoader.this.mContext, i2), false);
////                fmListParams.midlist = FmListLoader.getFmMidList(client, FmListLoader.this.mContext);
////                fmListParams.cookie = obj2;
////                return fmListParams;
////            }
////
////            /* access modifiers changed from: protected */
////            public void onError(Exception exc) {
////                C0789L.log.error("get fm list failed.", (Throwable) exc);
////                if (FmListLoader.this.mListener != null) {
////                    FmListLoader.this.mListener.onGetFmList(null, null, null);
////                }
////            }
////
////            /* access modifiers changed from: protected */
////            public void onResult(FmListParams fmListParams) {
////                if (FmListLoader.this.mListener != null) {
////                    FmListLoader.this.mListener.onGetFmList(fmListParams.list, fmListParams.midlist, fmListParams.cookie);
////                }
////            }
////        });
//    }
//
////    public static FmList getFmList(Client client, Context context, int i, int i2) {
////        int i3;
////        List<TopicLearnRecord> topicLearntRecords = WordInfoRecordHelper.getTopicLearntRecords(context, i);
////        HashMap hashMap = new HashMap();
////        HashSet hashSet = new HashSet();
////        for (TopicLearnRecord topicLearnRecord : topicLearntRecords) {
////            if (topicLearnRecord.radioState > 0) {
////                hashMap.put(Integer.valueOf(topicLearnRecord.topicId), Integer.valueOf(topicLearnRecord.radioState));
////            }
////            if (TopicLearnRecord.isFmSkipped(topicLearnRecord.radioSkipState)) {
////                hashSet.add(Integer.valueOf(topicLearnRecord.topicId));
////            }
////        }
////        Set wordsWithoutFm = getWordsWithoutFm(client, context, i);
////        hashSet.addAll(wordsWithoutFm);
////        List loadRawFmlist = loadRawFmlist(i2, hashMap, hashSet);
////        Logger logger = C0789L.log;
////        String str = "get fm list, load raw data [{}], size [{}], planCount [{}], viewed size [{}], skipped size [{}]";
////        Object[] objArr = new Object[5];
////        objArr[0] = loadRawFmlist;
////        if (loadRawFmlist != null) {
////            i3 = loadRawFmlist.size();
////        } else {
////            i3 = 0;
////        }
////        objArr[1] = Integer.valueOf(i3);
////        objArr[2] = Integer.valueOf(i2);
////        objArr[3] = Integer.valueOf(hashMap.size());
////        objArr[4] = Integer.valueOf(hashSet.size());
////        logger.info(str, objArr);
////        return getFmList(client, context, i, loadRawFmlist, wordsWithoutFm, true);
////    }
//
//    /* access modifiers changed from: private */
//    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
//        if (r0.isEmpty() != false) goto L_0x0012;
//     */
//    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
////    public static Set<Integer> getWordsWithoutFm(com.baicizhan.online.bs_words.BSWords.Client r9, Context r10, int r11) {
////        /*
////            java.util.HashSet r2 = new java.util.HashSet
////            r2.<init>()
////            r0 = 0
////            java.util.Set r0 = com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper.getMediaIds(r10, r11, r0)
////            if (r0 == 0) goto L_0x0012
////            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0089 }
////            if (r1 == 0) goto L_0x005b
////        L_0x0012:
////            boolean r1 = com.baicizhan.client.framework.network.NetworkUtils.isNetworkAvailable(r10)     // Catch:{ Exception -> 0x0089 }
////            if (r1 == 0) goto L_0x005b
////            java.util.List r3 = com.baicizhan.client.business.dataset.load.WordMediaLoader.refreshWordMediaUpdRecords(r10, r11, r9)     // Catch:{ Exception -> 0x0089 }
////            if (r3 == 0) goto L_0x005b
////            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ Exception -> 0x0089 }
////            r1.<init>()     // Catch:{ Exception -> 0x0089 }
////            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0049 }
////        L_0x0027:
////            boolean r0 = r3.hasNext()     // Catch:{ Exception -> 0x0049 }
////            if (r0 == 0) goto L_0x005a
////            java.lang.Object r0 = r3.next()     // Catch:{ Exception -> 0x0049 }
////            com.baicizhan.client.business.dataset.models.WordMediaUpdRecord r0 = (com.baicizhan.client.business.dataset.models.WordMediaUpdRecord) r0     // Catch:{ Exception -> 0x0049 }
////            long r4 = r0.getFmupdate()     // Catch:{ Exception -> 0x0049 }
////            r6 = 0
////            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
////            if (r4 == 0) goto L_0x0027
////            java.lang.String r0 = r0.getWordid()     // Catch:{ Exception -> 0x0049 }
////            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0049 }
////            r1.add(r0)     // Catch:{ Exception -> 0x0049 }
////            goto L_0x0027
////        L_0x0049:
////            r0 = move-exception
////        L_0x004a:
////            r0.printStackTrace()
////        L_0x004d:
////            if (r1 == 0) goto L_0x0055
////            boolean r0 = r1.isEmpty()
////            if (r0 == 0) goto L_0x005d
////        L_0x0055:
////            java.util.Set r0 = getWordsWithoutFmFromOldTables(r10, r11)
////        L_0x0059:
////            return r0
////        L_0x005a:
////            r0 = r1
////        L_0x005b:
////            r1 = r0
////            goto L_0x004d
////        L_0x005d:
////            com.baicizhan.client.business.managers.StudyManager r0 = com.baicizhan.client.business.managers.StudyManager.getInstance()
////            java.util.Map r0 = r0.getCurrentRoadmap()
////            if (r0 != 0) goto L_0x0069
////            r0 = 0
////            goto L_0x0059
////        L_0x0069:
////            java.util.Set r0 = r0.keySet()
////            java.util.Iterator r3 = r0.iterator()
////        L_0x0071:
////            boolean r0 = r3.hasNext()
////            if (r0 == 0) goto L_0x0087
////            java.lang.Object r0 = r3.next()
////            java.lang.Integer r0 = (java.lang.Integer) r0
////            boolean r4 = r1.contains(r0)
////            if (r4 != 0) goto L_0x0071
////            r2.add(r0)
////            goto L_0x0071
////        L_0x0087:
////            r0 = r2
////            goto L_0x0059
////        L_0x0089:
////            r1 = move-exception
////            r8 = r1
////            r1 = r0
////            r0 = r8
////            goto L_0x004a
////        */
////        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.p029fm.data.load.FmListLoader.getWordsWithoutFm(com.baicizhan.online.bs_words.BSWords$Client, android.content.Context, int):java.util.Set");
////    }
//
//    /* JADX INFO: finally extract failed */
//    private static Set<Integer> getWordsWithoutFmFromOldTables(Context context, int i) {
//        byte[] bArr;
//        HashSet hashSet = null;
//        boolean queryTableExists = ProviderUtils.queryTableExists(context, Databases.DO_EXAMPLE_INFO, ZBOOKWORDINFO.TABLE_NAME);
//        boolean queryTableExists2 = ProviderUtils.queryTableExists(context, Databases.TOPIC_PROBLEM, BOOK_TS_OFFLINE_ROAD_MAP_IDS.getBookTableName(i));
//        if (queryTableExists && queryTableExists2) {
//            StringBuilder sb = new StringBuilder("select distinct ");
//            sb.append("ALL_WORD from ZBOOKWORDINFO where BOOK_ID=? and TYPE=?");
//            Cursor perform = QueryBuilder.rawQuery(Databases.DO_EXAMPLE_INFO, sb.toString(), String.valueOf(i), "2").perform(context);
//            if (perform != null) {
////                try {
////                    if (perform.moveToFirst()) {
////                        bArr = perform.getBlob(0);
////                    } else {
////                        bArr = null;
////                    }
////                    perform.close();
////                    List<UpdateInfo> list = (List) new Gson().fromJson(new String(bArr), new TypeToken<List<UpdateInfo>>() {
////                    }.getType());
////                    HashSet hashSet2 = new HashSet(list.size());
////                    for (UpdateInfo updateInfo : list) {
////                        if (updateInfo.updated_at != 0) {
////                            hashSet2.add(Integer.valueOf(updateInfo.tapescript_id));
////                        }
////                    }
////                    if (!hashSet2.isEmpty()) {
////                        StringBuilder sb2 = new StringBuilder("select distinct ");
////                        sb2.append("topic_id, tapescript_id from ").append(BOOK_TS_OFFLINE_ROAD_MAP_IDS.getBookTableName(i));
////                        Cursor perform2 = QueryBuilder.rawQuery(Databases.TOPIC_PROBLEM, sb2.toString(), new String[0]).perform(context);
////                        if (perform2 != null) {
////                            try {
////                                hashSet = new HashSet();
////                                while (perform2.moveToNext()) {
////                                    if (!hashSet2.contains(Integer.valueOf(perform2.getInt(1)))) {
////                                        hashSet.add(Integer.valueOf(perform2.getInt(0)));
////                                    }
////                                }
////                            } finally {
////                                perform2.close();
////                            }
////                        }
////                    }
////                } catch (Throwable th) {
////                    perform.close();
////                    throw th;
////                }
//            }
//        }
//        return hashSet;
//    }
//
//    private static List<String> loadRawFmlist(int i, Map<Integer, Integer> map, Set<Integer> set) {
//        StudyManager.getInstance().addRefreshRequestFlag(4);
//        LearningManager learningManager = StudyManager.getInstance().getLearningManager();
//        HashMap hashMap = new HashMap();
//        hashMap.put("learnedList", map);
//        hashMap.put("skippedList", set);
//        StudyManager.getInstance().addRefreshRequestFlag(8);
//        learningManager.setSequenceModeMultiMedia(i, hashMap);
//        learningManager.setTypeModeMultiMedia(null);
//        SequenceStrategy sequenceStrategy = learningManager.getSequenceStrategy();
//        List<ProblemProxy> next = sequenceStrategy.getNext(0, sequenceStrategy.getReviewCount());
//        ArrayList arrayList = new ArrayList(next.size());
//        for (ProblemProxy id : next) {
//            arrayList.add(String.valueOf(id.getId()));
//        }
//        return arrayList;
//    }
//
////    public static FmList getFmList(Client client, Context context, int i, List<String> list, Set<Integer> set, boolean z) {
////        if (list == null || list.isEmpty()) {
////            return null;
////        }
////        HashSet<String> hashSet = new HashSet<>(list.size());
////        for (String add : list) {
////            hashSet.add(add);
////        }
////        FmList fmList = new FmList();
////        fmList.injectSequenceIds(list);
////        ArrayList arrayList = new ArrayList();
////        boolean isMediaRecordOldTablesExists = isMediaRecordOldTablesExists(context, i);
////        List<WordMediaRecord> wordMediaRecords = WordMediaRecordHelper.getWordMediaRecords(context, i, hashSet, 0);
////        if (wordMediaRecords != null) {
////            for (WordMediaRecord wordid : wordMediaRecords) {
////                hashSet.remove(wordid.getWordid());
////            }
////        } else {
////            wordMediaRecords = new ArrayList<>();
////        }
////        C0789L.log.info("get fm list from new tables [{}]", (Object) wordMediaRecords);
////        if (!hashSet.isEmpty() && isMediaRecordOldTablesExists) {
////            List mediaRecordsFromOldTables = getMediaRecordsFromOldTables(context, i, hashSet);
////            C0789L.log.info("get fm list from old tables [{}]", (Object) mediaRecordsFromOldTables);
////            if (mediaRecordsFromOldTables != null) {
////                wordMediaRecords.addAll(mediaRecordsFromOldTables);
////            }
////            for (WordMediaRecord wordid2 : wordMediaRecords) {
////                hashSet.remove(wordid2.getWordid());
////            }
////        }
////        for (String str : hashSet) {
////            if (set != null && !set.contains(Integer.valueOf(str))) {
////                arrayList.add(Integer.valueOf(str));
////            }
////        }
////        try {
////            if (!arrayList.isEmpty() && NetworkUtils.isNetworkAvailable(context) && z) {
////                ArrayList arrayList2 = new ArrayList(arrayList.size());
////                int size = (arrayList.size() + 50) / 50;
////                for (int i2 = 0; i2 < size; i2++) {
////                    ArrayList arrayList3 = new ArrayList(50);
////                    int min = Math.min(arrayList.size(), (i2 + 1) * 50);
////                    for (int i3 = i2 * 50; i3 < min; i3++) {
////                        arrayList3.add(arrayList.get(i3));
////                    }
////                    arrayList2.addAll(client.word_media_by_topic_ids_v2(arrayList3));
////                }
////                List<WordMediaRecord> fromList = WordMediaRecord.fromList(arrayList2);
////                WordMediaRecordHelper.insertWordMediaRecords(context, i, fromList);
////                for (WordMediaRecord wordMediaRecord : fromList) {
////                    if (wordMediaRecord.getFmupdate() > 0) {
////                        wordMediaRecords.add(wordMediaRecord);
////                    }
////                }
////            }
////        } catch (Exception e) {
////            C0789L.log.error("get fm list failed.", (Throwable) e);
////            if (wordMediaRecords == null || wordMediaRecords.isEmpty()) {
////                throw e;
////            }
////        }
////        fmList.injectWordMediaRecords(wordMediaRecords);
////        if (z) {
////            fmList.injectLearnRecords(WordInfoRecordHelper.getTopicLearnRecords(context, i, hashSet));
////        }
////        fmList.adapt();
////        return fmList;
////    }
//
//    private static boolean isMediaRecordOldTablesExists(Context context, int i) {
//        return ProviderUtils.queryTableExists(context, Databases.TOPIC_PROBLEM, BOOK_TS_OFFLINE_ROAD_MAP_IDS.getBookTableName(i)) && ProviderUtils.queryTableExists(context, Databases.WORD_RADIO_TOPIC, TS_WORD_STATION_DATA_ALL.TABLE_NAME);
//    }
//
//    private static WordMediaRecord getMediaRecordFromOldTables(Context context, int i, String str) {
//        int i2;
//        StringBuilder sb = new StringBuilder("select distinct ");
//        sb.append("tapescript_id from ").append(BOOK_TS_OFFLINE_ROAD_MAP_IDS.getBookTableName(i)).append(" where topic_id=?");
//        Cursor perform = QueryBuilder.rawQuery(Databases.TOPIC_PROBLEM, sb.toString(), str).perform(context);
//        if (perform == null) {
//            return null;
//        }
//        try {
//            if (perform.moveToFirst()) {
//                i2 = perform.getInt(0);
//            } else {
//                i2 = 0;
//            }
//            if (i2 <= 0) {
//                return null;
//            }
//            WordMediaRecord wordMediaRecord = (WordMediaRecord) Cursors.mapToUnique(QueryBuilder.query(TS_WORD_STATION_DATA_ALL.CONTENT_URI).where("ws_id=?", String.valueOf(i2)).perform(context), WordMediaRecord.class, WordMediaRecord.OLD_COLUMN_MAP);
//            if (wordMediaRecord == null) {
//                return wordMediaRecord;
//            }
//            wordMediaRecord.setWordid(str);
//            return wordMediaRecord;
//        } finally {
//            perform.close();
//        }
//    }
//
//    /* JADX INFO: finally extract failed */
//    private static List<WordMediaRecord> getMediaRecordsFromOldTables(Context context, int i, Set<String> set) {
//        Cursor perform = QueryBuilder.query(BOOK_TS_OFFLINE_ROAD_MAP_IDS.getBookContentUri(i)).whereIn("topic_id", set, 200).perform(context);
//        if (perform == null) {
//            return null;
//        }
//        HashMap hashMap = new HashMap();
//        while (perform.moveToNext()) {
//            try {
//                hashMap.put(Integer.valueOf(perform.getInt(perform.getColumnIndex(Columns.TAPESCRIPT_ID))), Integer.valueOf(perform.getInt(perform.getColumnIndex("topic_id"))));
//            } catch (Throwable th) {
//                perform.close();
//                throw th;
//            }
//        }
//        perform.close();
//        if (hashMap.isEmpty()) {
//            return null;
//        }
//        List<WordMediaRecord> mapToList = Cursors.mapToList(QueryBuilder.query(TS_WORD_STATION_DATA_ALL.CONTENT_URI).whereIn("ws_id", hashMap.keySet(), 200).perform(context), WordMediaRecord.class, WordMediaRecord.OLD_COLUMN_MAP);
//        for (WordMediaRecord wordMediaRecord : mapToList) {
//            wordMediaRecord.setWordid(String.valueOf(hashMap.get(Integer.valueOf(wordMediaRecord.getTapId()))));
//        }
//        return mapToList;
//    }
//
//    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
//        if (r0.isEmpty() != false) goto L_0x000d;
//     */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
////    public static com.baicizhan.client.p029fm.data.FmMidList getFmMidList(com.baicizhan.online.bs_words.BSWords.Client r4, Context r5) {
////        /*
////            r0 = 0
////            java.util.List r0 = com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper.getWordMediaMidRecords(r5, r0)
////            if (r0 == 0) goto L_0x000d
////            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x002e }
////            if (r1 == 0) goto L_0x001e
////        L_0x000d:
////            boolean r1 = com.baicizhan.client.framework.network.NetworkUtils.isNetworkAvailable(r5)     // Catch:{ Exception -> 0x002e }
////            if (r1 == 0) goto L_0x001e
////            com.baicizhan.online.bs_words.BBWordMediaHalftimeList r1 = r4.get_word_media_halftime_list()     // Catch:{ Exception -> 0x002e }
////            java.util.List r0 = com.baicizhan.client.business.dataset.thrifadapt.WordMediaMidRecordAdapter.fromList(r1)     // Catch:{ Exception -> 0x002e }
////            com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper.refreshWordMediaMidRecords(r5, r0)     // Catch:{ Exception -> 0x002e }
////        L_0x001e:
////            if (r0 == 0) goto L_0x0026
////            boolean r1 = r0.isEmpty()
////            if (r1 == 0) goto L_0x002a
////        L_0x0026:
////            java.util.List r0 = getMediaMidRecordFromOldTable(r5)
////        L_0x002a:
////            if (r0 != 0) goto L_0x0037
////            r0 = 0
////        L_0x002d:
////            return r0
////        L_0x002e:
////            r1 = move-exception
////            r3 = r1
////            r1 = r0
////            r0 = r3
////            r0.printStackTrace()
////            r0 = r1
////            goto L_0x001e
////        L_0x0037:
////            java.util.ArrayList r1 = new java.util.ArrayList
////            int r2 = r0.size()
////            r1.<init>(r2)
////            java.util.Iterator r2 = r0.iterator()
////        L_0x0044:
////            boolean r0 = r2.hasNext()
////            if (r0 == 0) goto L_0x0058
////            java.lang.Object r0 = r2.next()
////            com.baicizhan.client.business.dataset.models.WordMediaMidRecord r0 = (com.baicizhan.client.business.dataset.models.WordMediaMidRecord) r0
////            java.lang.String r0 = r0.getPath()
////            r1.add(r0)
////            goto L_0x0044
////        L_0x0058:
////            com.baicizhan.client.fm.data.FmMidList r0 = new com.baicizhan.client.fm.data.FmMidList
////            r0.<init>(r1)
////            goto L_0x002d
////        */
////        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.p029fm.data.load.FmListLoader.getFmMidList(com.baicizhan.online.bs_words.BSWords$Client, android.content.Context):com.baicizhan.client.fm.data.FmMidList");
////    }
//
//    private static List<WordMediaMidRecord> getMediaMidRecordFromOldTable(Context context) {
//        if (!ProviderUtils.queryTableExists(context, Databases.WORD_RADIO_TOPIC, TS_WORD_RADIO_HALF_TIME.TABLE_NAME)) {
//            return null;
//        }
//        return Cursors.mapToList(QueryBuilder.query(TS_WORD_RADIO_HALF_TIME.CONTENT_URI).where("ws_word_tv=?", "0").perform(context), WordMediaMidRecord.class, WordMediaMidRecord.OLD_COLUMN_MAP);
//    }
//
////    public void getWordIds(final int i, final Object obj) {
////        BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, FmParams>(BaicizhanThrifts.WORDS) {
////            /* access modifiers changed from: protected */
////            public FmParams doInBackground(Client client) {
////                FmParams fmParams = new FmParams();
////                if (WordMediaRecordHelper.isWordMediaUpdRecordsEmpty(FmListLoader.this.mContext, i)) {
////                    WordMediaLoader.refreshWordMediaUpdRecords(FmListLoader.this.mContext, i, client);
////                }
////                fmParams.wordids = WordMediaRecordHelper.getAllExistWordMediaRecordsFromUpdate(FmListLoader.this.mContext, i, 0);
////                if (WordMediaRecordHelper.isBookLoaded(FmListLoader.this.mContext, i)) {
////                    fmParams.fmrecords = WordIdRecordHelper.getFmRecords(FmListLoader.this.mContext, i);
////                }
////                fmParams.cookie = obj;
////                return fmParams;
////            }
////
////            /* access modifiers changed from: protected */
////            public void onError(Exception exc) {
////                if (FmListLoader.this.mListener != null) {
////                    FmListLoader.this.mListener.onGetWordIds(null, null, null);
////                }
////            }
////
////            /* access modifiers changed from: protected */
////            public void onResult(FmParams fmParams) {
////                if (FmListLoader.this.mListener != null) {
////                    FmListLoader.this.mListener.onGetWordIds(fmParams.wordids, fmParams.fmrecords, fmParams.cookie);
////                }
////            }
////        });
////    }
//
////    public void getFmInfos(final int i, final Object obj) {
////        BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, FmParams>(BaicizhanThrifts.WORDS) {
////            /* access modifiers changed from: protected */
////            public FmParams doInBackground(Client client) {
////                FmParams fmParams = new FmParams();
////                if (!WordMediaRecordHelper.isBookLoaded(FmListLoader.this.mContext, i)) {
////                    WordMediaLoader.doRefreshAllWordMediaRecords(FmListLoader.this.mContext, i, client);
////                    WordMediaRecordHelper.setBookLoaded(FmListLoader.this.mContext, i);
////                }
////                fmParams.fmrecords = WordIdRecordHelper.getFmRecords(FmListLoader.this.mContext, i);
////                fmParams.cookie = obj;
////                return fmParams;
////            }
////
////            /* access modifiers changed from: protected */
////            public void onError(Exception exc) {
////                if (FmListLoader.this.mListener != null) {
////                    FmListLoader.this.mListener.onGetFmInfos(null, null);
////                }
////            }
////
////            /* access modifiers changed from: protected */
////            public void onResult(FmParams fmParams) {
////                if (FmListLoader.this.mListener != null) {
////                    FmListLoader.this.mListener.onGetFmInfos(fmParams.fmrecords, fmParams.cookie);
////                }
////            }
////        });
////    }
//}
