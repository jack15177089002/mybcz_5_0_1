//package com.baicizhan.main.resource;
//
//import android.app.Activity;
//import android.content.Context;
//import android.support.p004v4.p006b.LruCache;
//import android.text.TextUtils;
//import android.util.Log;
//import android.util.SparseArray;
//import com.baicizhan.client.business.dataset.helpers.TopicRecordHelper;
//import com.baicizhan.client.business.dataset.models.SimilarWordRecord;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.business.download_service.AbstractDownloadTask;
//import com.baicizhan.client.business.download_service.AbstractDownloadTask.Listener;
//import com.baicizhan.client.business.download_service.ChannelPriority;
//import com.baicizhan.client.business.download_service.DownloadService;
//import com.baicizhan.client.business.managers.LearnRecordManager;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.CollectionUtils;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.framework.network.NetworkUtils;
//import com.baicizhan.learning_strategy.bean.ProblemProxy;
//import com.baicizhan.learning_strategy.iface.LearningManager;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.online.bs_words.BBSimilarWordInfo;
//import com.baicizhan.online.bs_words.BBWordMediaV2;
//import com.baicizhan.online.bs_words.BBWordPackage;
//import com.baicizhan.online.bs_words.BSWords.Client;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import org.p100a.p101a.p107f.C2120g;
//
//public class TopicResourceManager {
//    public static final String TAG = TopicResourceManager.class.getSimpleName();
//    private static TopicResourceManager sInstance = null;
//    /* access modifiers changed from: private */
//    public int mBookId = -1;
//    /* access modifiers changed from: private */
//    public Context mContext;
//    private boolean mMobileOfflineDownloadEnabled = false;
//    private boolean mMobileProblemDownloadEnabled = false;
//    private OfflineResourceRepo mOfflineResRepo = new OfflineResourceRepo();
//    private final LruCache<Long, TopicRecord> mSimilarRecordCache = new LruCache<>(128);
//    /* access modifiers changed from: private */
//    public final SparseArray<List<SimilarWordRecord>> mSimilarWordRecords = new SparseArray<>();
//    /* access modifiers changed from: private */
//    public final TopicRecordCache mTopicRecordCache = new TopicRecordCache(500);
//    /* access modifiers changed from: private */
//    public TopicWaitingHall mTopicWaitingHall = new TopicWaitingHall();
//    /* access modifiers changed from: private */
//    public WordMediaRecordCache mWordMediaRecordCache = new WordMediaRecordCache(500);
//
//    public static TopicResourceManager getInstance() {
//        if (sInstance == null) {
//            synchronized (TopicResourceManager.class) {
//                if (sInstance == null) {
//                    sInstance = new TopicResourceManager();
//                }
//            }
//        }
//        return sInstance;
//    }
//
//    public Context getContext() {
//        return this.mContext;
//    }
//
//    public int getBookId() {
//        return this.mBookId;
//    }
//
//    public OfflineResourceRepo getOfflineResRepo() {
//        return this.mOfflineResRepo;
//    }
//
//    public boolean isMobileOfflineDownloadEnabled() {
//        return this.mMobileOfflineDownloadEnabled;
//    }
//
//    public void setMobileOfflineDownloadEnabled(boolean z) {
//        this.mMobileOfflineDownloadEnabled = z;
//    }
//
//    public boolean isMobileProblemDownloadEnabled() {
//        return this.mMobileProblemDownloadEnabled;
//    }
//
//    public void setMobileProblemDownloadEnabled(boolean z) {
//        this.mMobileProblemDownloadEnabled = z;
//    }
//
//    public TopicRecord getSimilarTopicRecord(int i, int i2) {
//        return (TopicRecord) this.mSimilarRecordCache.get(Long.valueOf((((long) i) << 32) | ((long) i2)));
//    }
//
//    public void putSimilarTopicRecord(int i, TopicRecord topicRecord) {
//        this.mSimilarRecordCache.put(Long.valueOf((((long) i) << 32) | ((long) topicRecord.topicId)), topicRecord);
//    }
//
//    public TopicRecord getIntegratedTopicRecord(int i) {
//        TopicRecord topicRecord = (TopicRecord) this.mTopicRecordCache.get(Integer.valueOf(i));
//        if (topicRecord == null || !TopicResourceChecker.checkIntegrity(topicRecord)) {
//            return null;
//        }
//        return topicRecord;
//    }
//
//    public void putTopicRecord(TopicRecord topicRecord) {
//        topicRecord.bookId = this.mBookId;
//        this.mTopicRecordCache.putAndSave(topicRecord);
//    }
//
//    public synchronized void reInit(Context context, int i) {
//        LogWrapper.m2795i(TAG, "reInit TopicResourceManager");
//        this.mContext = context.getApplicationContext();
//        this.mBookId = i;
//        this.mOfflineResRepo.reInit(this.mContext, this.mBookId);
//        DownloadService.getInstance().clearAllTask();
//        TopicDownloadTask.resetCtrlState();
//        release();
//        this.mTopicRecordCache.reinit(this.mContext, this.mBookId);
//        this.mWordMediaRecordCache.reinit(this.mContext, this.mBookId);
//        this.mMobileOfflineDownloadEnabled = false;
//        this.mMobileProblemDownloadEnabled = false;
//    }
//
//    public void release() {
//        this.mTopicRecordCache.evictAll();
//        this.mWordMediaRecordCache.evictAll();
//        this.mTopicWaitingHall.clearup();
//        this.mSimilarRecordCache.evictAll();
//        synchronized (this.mSimilarWordRecords) {
//            this.mSimilarWordRecords.clear();
//        }
//    }
//
//    public TopicRecord getExistTopicRecord(int i) {
//        return (TopicRecord) this.mTopicRecordCache.get(Integer.valueOf(i));
//    }
//
//    public WordMediaRecord getWordMediaRecord(int i) {
//        return (WordMediaRecord) this.mWordMediaRecordCache.get(Integer.toString(i));
//    }
//
//    public TopicWaitingHall getTopicWaitingHall() {
//        return this.mTopicWaitingHall;
//    }
//
//    public List<SimilarWordRecord> getTopicSimilarWordRecords(int i) {
//        List<SimilarWordRecord> list;
//        synchronized (this.mSimilarWordRecords) {
//            list = (List) this.mSimilarWordRecords.get(i);
//        }
//        return list;
//    }
//
//    public int loadNextProblems(Activity activity, LearningManager learningManager, int i, boolean z) {
//        try {
//            List<ProblemProxy> next = learningManager.getSequenceStrategy().getNext(this.mTopicWaitingHall.getTotalWaiterCount(), i);
//            if (CollectionUtils.isEmpty((Collection<?>) next)) {
//                return 0;
//            }
//            ArrayList arrayList = new ArrayList(next.size());
//            for (ProblemProxy id : next) {
//                arrayList.add(Integer.valueOf(id.getId()));
//            }
//            loadNextProblems(activity, arrayList, z);
//            return arrayList.size();
//        } catch (Exception e) {
//            return 0;
//        }
//    }
//
//    public void loadNextProblems(Activity activity, List<Integer> list, boolean z) {
//        LogWrapper.m2796v(TAG, "loadNextProblems " + list.size() + ": " + TextUtils.join(", ", list));
//        this.mTopicWaitingHall.addWaiterCount(list.size());
//        final Activity activity2 = activity;
//        final List<Integer> list2 = list;
//        final boolean z2 = z;
//        BaicizhanThrifts.getProxy().add(new ThriftRequest<Client, Integer>(BaicizhanThrifts.WORDS) {
//            /* access modifiers changed from: protected */
//            public Integer doInBackground(Client client) {
//                int activeNetworkType = NetworkUtils.getActiveNetworkType(activity2);
//                Set<Integer> computeRelatedTopics = CommonUtils.computeRelatedTopics(list2);
//                ArrayList arrayList = new ArrayList();
//                Map bookTopicRecords = TopicRecordHelper.getBookTopicRecords(TopicResourceManager.this.mContext, TopicResourceManager.this.mBookId, computeRelatedTopics);
//                for (Integer intValue : computeRelatedTopics) {
//                    int intValue2 = intValue.intValue();
//                    TopicRecord topicRecord = (TopicRecord) bookTopicRecords.get(Integer.valueOf(intValue2));
//                    if (topicRecord == null) {
//                        TopicRecord unpackTopicRecord = AssetTopicRecordManager.getInstance().unpackTopicRecord(TopicResourceManager.this.mBookId, intValue2);
//                        if (unpackTopicRecord != null) {
//                            TopicResourceManager.this.mTopicRecordCache.put(Integer.valueOf(intValue2), unpackTopicRecord);
//                        } else {
//                            LogWrapper.m2796v(TopicResourceManager.TAG, "check null " + intValue2);
//                            arrayList.add(Integer.valueOf(intValue2));
//                        }
//                    } else {
//                        TopicResourceManager.this.mTopicRecordCache.put(Integer.valueOf(intValue2), topicRecord);
//                        if (!TopicResourceChecker.checkIntegrity(topicRecord)) {
//                            arrayList.add(Integer.valueOf(intValue2));
//                        } else if (!z2 && activeNetworkType == 0 && list2.contains(Integer.valueOf(intValue2)) && LearnRecordManager.getInstance().isFirstMet(intValue2) && !TopicResourceChecker.checkUpdateFlagMD5(topicRecord)) {
//                            LogWrapper.m2796v(TopicResourceManager.TAG, "check update " + intValue2);
//                            arrayList.add(Integer.valueOf(intValue2));
//                        }
//                    }
//                }
//                LogWrapper.m2796v(TopicResourceManager.TAG, "need download " + TextUtils.join(",", arrayList));
//                if (activeNetworkType != 0 && !CollectionUtils.isEmpty((Collection<?>) arrayList)) {
//                    if (!new SyncNetworkPermissionGranter().grant(activity2)) {
//                        LogWrapper.m2796v(TopicResourceManager.TAG, "user grant denied");
//                        return Integer.valueOf(-1);
//                    }
//                    LogWrapper.m2796v(TopicResourceManager.TAG, "user grant passed");
//                }
//                SparseArray sparseArray = new SparseArray(arrayList.size());
//                if (!CollectionUtils.isEmpty((Collection<?>) arrayList)) {
//                    for (BBWordPackage bBWordPackage : client.get_word_package(arrayList, TopicResourceManager.this.mBookId)) {
//                        sparseArray.put(bBWordPackage.getTopic_id(), bBWordPackage);
//                    }
//                }
//                HashSet hashSet = new HashSet();
//                for (int i = 0; i < list2.size(); i++) {
//                    int intValue3 = ((Integer) list2.get(i)).intValue();
//                    ProblemAsset problemAsset = new ProblemAsset(intValue3, StudyManager.getInstance().getTopicOptionsById(intValue3));
//                    for (Integer intValue4 : problemAsset.getOptions()) {
//                        int intValue5 = intValue4.intValue();
//                        TopicResourceManager.this.mTopicWaitingHall.register(intValue5, problemAsset);
//                        TopicRecord topicRecord2 = (TopicRecord) TopicResourceManager.this.mTopicRecordCache.get(Integer.valueOf(intValue5));
//                        if (topicRecord2 != null && !arrayList.contains(Integer.valueOf(intValue5))) {
//                            TopicResourceManager.this.mTopicWaitingHall.notifyTopicFinish(topicRecord2);
//                        } else if (!hashSet.contains(Integer.valueOf(intValue5))) {
//                            hashSet.add(Integer.valueOf(intValue5));
//                            C11931 r0 = new Listener() {
//                                public void onSuccess(AbstractDownloadTask abstractDownloadTask) {
//                                    TopicResourceManager.this.mTopicWaitingHall.notifyTopicFinish((TopicRecord) TopicResourceManager.this.mTopicRecordCache.get(Integer.valueOf(((TopicDownloadTask) abstractDownloadTask).getTopicId())));
//                                }
//
//                                public void onError(AbstractDownloadTask abstractDownloadTask, Throwable th) {
//                                    ((TopicDownloadTask) abstractDownloadTask).getTopicId();
//                                    TopicResourceManager.this.mTopicWaitingHall.notifyTopicError(th);
//                                }
//                            };
//                            TopicDownloadTask topicDownloadTask = new TopicDownloadTask(TopicResourceManager.this.mBookId, intValue5);
//                            topicDownloadTask.setListener(r0);
//                            topicDownloadTask.setWordPackage((BBWordPackage) sparseArray.get(intValue5));
//                            topicDownloadTask.setExistTopicRecord((TopicRecord) bookTopicRecords.get(Integer.valueOf(intValue5)));
//                            DownloadService.getInstance().add(ChannelPriority.HIGH, topicDownloadTask);
//                        }
//                    }
//                }
//                checkWordTV(client, list2);
//                if (activeNetworkType == 0) {
//                    checkSimilarInfo(client, list2);
//                }
//                return Integer.valueOf(0);
//            }
//
//            private void checkWordTV(Client client, List<Integer> list) {
//                try {
//                    ArrayList arrayList = new ArrayList();
//                    ArrayList arrayList2 = new ArrayList(list.size());
//                    for (Integer intValue : list) {
//                        arrayList2.add(Integer.toString(intValue.intValue()));
//                    }
//                    Map bulkQuery = TopicResourceManager.this.mWordMediaRecordCache.bulkQuery(arrayList2);
//                    for (Integer intValue2 : list) {
//                        int intValue3 = intValue2.intValue();
//                        WordMediaRecord wordMediaRecord = (WordMediaRecord) bulkQuery.get(Integer.toString(intValue3));
//                        if (wordMediaRecord == null || TextUtils.isEmpty(wordMediaRecord.getTvSnapshotPath()) || !PathUtil.isBaicizhanResourceFileExist(wordMediaRecord.getTvSnapshotPath())) {
//                            arrayList.add(Integer.valueOf(intValue3));
//                        }
//                    }
//                    if (arrayList.size() > 0) {
//                        List<BBWordMediaV2> word_media_by_topic_ids_v2 = client.word_media_by_topic_ids_v2(arrayList);
//                        ArrayList arrayList3 = new ArrayList(word_media_by_topic_ids_v2.size());
//                        for (BBWordMediaV2 fromBBWordMedia : word_media_by_topic_ids_v2) {
//                            arrayList3.add(WordMediaRecord.fromBBWordMedia(fromBBWordMedia));
//                        }
//                        TopicResourceManager.this.mWordMediaRecordCache.bulkInsert(arrayList3);
//                    }
//                } catch (Exception e) {
//                    if (!(e instanceof C2120g)) {
//                        LogWrapper.m2794e(TopicResourceManager.TAG, Log.getStackTraceString(e));
//                    }
//                }
//            }
//
//            private void checkSimilarInfo(Client client, List<Integer> list) {
//                try {
//                    ArrayList arrayList = new ArrayList();
//                    synchronized (TopicResourceManager.this.mSimilarWordRecords) {
//                        for (Integer intValue : list) {
//                            int intValue2 = intValue.intValue();
//                            if (TopicResourceManager.this.mSimilarWordRecords.get(intValue2) == null) {
//                                arrayList.add(Integer.valueOf(intValue2));
//                            }
//                        }
//                    }
//                    if (arrayList.size() > 0) {
//                        for (BBSimilarWordInfo fromBBSimilarWordInfo : client.get_similar_words_info(TopicResourceManager.this.mBookId, arrayList)) {
//                            SimilarWordRecord fromBBSimilarWordInfo2 = SimilarWordRecord.fromBBSimilarWordInfo(fromBBSimilarWordInfo);
//                            synchronized (TopicResourceManager.this.mSimilarWordRecords) {
//                                List list2 = (List) TopicResourceManager.this.mSimilarWordRecords.get(fromBBSimilarWordInfo2.topic_id);
//                                if (list2 == null) {
//                                    list2 = new ArrayList(4);
//                                    TopicResourceManager.this.mSimilarWordRecords.put(fromBBSimilarWordInfo2.topic_id, list2);
//                                }
//                                list2.add(fromBBSimilarWordInfo2);
//                            }
//                        }
//                    }
//                } catch (Exception e) {
//                    if (!(e instanceof C2120g)) {
//                        LogWrapper.m2794e(TopicResourceManager.TAG, Log.getStackTraceString(e));
//                    }
//                }
//            }
//
//            /* access modifiers changed from: protected */
//            public void onError(Exception exc) {
//                if (!(exc instanceof C2120g)) {
//                    LogWrapper.m2794e(TopicResourceManager.TAG, Log.getStackTraceString(exc));
//                }
//                TopicResourceManager.this.mTopicWaitingHall.subWaiterCount(list2.size());
//                TopicResourceManager.this.mTopicWaitingHall.notifyTopicError(exc);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onResult(Integer num) {
//                if (num.intValue() == -1) {
//                    LogWrapper.m2794e(TopicResourceManager.TAG, "loadNextProblem failed, reason: grant false");
//                }
//            }
//        });
//    }
//
//    public void downloadTopic(int i, Listener listener) {
//        TopicDownloadTask topicDownloadTask = new TopicDownloadTask(this.mBookId, i);
//        topicDownloadTask.setListener(listener);
//        DownloadService.getInstance().add(ChannelPriority.HIGH, topicDownloadTask);
//    }
//
//    public ProblemAsset getIntegrityProblemAsset(int i) {
//        int[] topicOptionsById = StudyManager.getInstance().getTopicOptionsById(i);
//        if (topicOptionsById == null) {
//            return null;
//        }
//        TopicRecord topicRecord = (TopicRecord) this.mTopicRecordCache.get(Integer.valueOf(i));
//        if (topicRecord == null || !TopicResourceChecker.checkIntegrity(topicRecord)) {
//            return null;
//        }
//        ProblemAsset problemAsset = new ProblemAsset(i, topicOptionsById);
//        problemAsset.addOptionRecord(topicRecord);
//        for (int valueOf : topicOptionsById) {
//            TopicRecord topicRecord2 = (TopicRecord) this.mTopicRecordCache.get(Integer.valueOf(valueOf));
//            if (topicRecord2 == null || !TopicResourceChecker.checkIntegrity(topicRecord2)) {
//                return null;
//            }
//            problemAsset.addOptionRecord(topicRecord2);
//        }
//        if (problemAsset.isComplete()) {
//            return problemAsset;
//        }
//        return null;
//    }
//}
