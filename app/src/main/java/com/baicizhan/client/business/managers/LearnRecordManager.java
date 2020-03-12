//package com.baicizhan.client.business.managers;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.net.Uri;
//import android.os.Handler;
//import android.os.HandlerThread;
//import android.support.p004v4.p006b.LruCache;
//import android.text.TextUtils;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.helpers.BookRecordHelper;
//import com.baicizhan.client.business.dataset.helpers.TopicLearnRecordHelper;
//import com.baicizhan.client.business.dataset.models.OfflineStateRecord;
//import com.baicizhan.client.business.dataset.models.ScheduleRecord;
//import com.baicizhan.client.business.dataset.models.TopicLearnRecord;
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_OFFLINE_DOTOPIC_SYNC_IDS;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZBOOKFINISHINFO;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.ProviderUtils;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.util.CollectionUtils;
//import com.baicizhan.client.business.util.CollectionUtils.Filter;
//import com.baicizhan.client.business.util.CollectionUtils.Mapper;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.TimeUtil;
//import com.baicizhan.learning_strategy.bean.ProblemProxy;
//import com.baicizhan.online.bs_users.BBDoneRecord;
//import com.baicizhan.online.bs_users.BBTopicInfo;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//import p012ch.qos.logback.core.CoreConstants;
//
//public class LearnRecordManager {
//    /* access modifiers changed from: private */
//    public static final String TAG = LearnRecordManager.class.getSimpleName();
//    private static final int UPLOAD_BATCH_COUNT = 50;
//    private static LearnRecordManager sInstance = null;
//    private int mBookId = -1;
//    /* access modifiers changed from: private */
//    public Handler mCommitHandler;
//    private HandlerThread mCommitThread = new HandlerThread("LearnRecordManager-Commit");
//    private Context mContext;
//    private boolean mHasInited;
//    /* access modifiers changed from: private */
//    public TopicLearnRecordCache mSyncTableCache = new TopicLearnRecordCache(2, 200);
//    /* access modifiers changed from: private */
//    public Set<Integer> mTodayNewLearnedSet = new HashSet();
//    /* access modifiers changed from: private */
//    public Map<Integer, TopicLearnRecord> mTotalTable = new ConcurrentHashMap();
//    /* access modifiers changed from: private */
//    public TopicLearnRecordCache mTotalTableCache = new TopicLearnRecordCache(1, 200);
//
//    public enum Answer {
//        WRONG,
//        CORRECT,
//        KILL
//    }
//
//    public class TopicLearnProxy {
//        /* access modifiers changed from: private */
//        public TopicLearnRecord syncRecord;
//        /* access modifiers changed from: private */
//        public TopicLearnRecord totalRecord;
//
//        public TopicLearnProxy(TopicLearnRecord topicLearnRecord, TopicLearnRecord topicLearnRecord2) {
//            this.totalRecord = topicLearnRecord;
//            this.syncRecord = topicLearnRecord2;
//        }
//
//        public String toString() {
//            return "TopicLearnProxy{syncRecord=" + this.syncRecord + ", totalRecord=" + this.totalRecord + CoreConstants.CURLY_RIGHT;
//        }
//
//        public int getScore() {
//            return this.syncRecord.topicScore;
//        }
//
//        public boolean isTodayNewLearned() {
//            return this.syncRecord.isTodayNew == 1;
//        }
//
//        /* access modifiers changed from: 0000 */
//        public TopicLearnProxy markResult(ProblemProxy problemProxy) {
//            int score = problemProxy.getScore();
//            this.totalRecord.topicScore = score;
//            this.syncRecord.topicScore = score;
//            this.totalRecord.lastDoTime = problemProxy.getLastLearnedTime();
//            this.syncRecord.lastDoTime = problemProxy.getLastLearnedTime();
//            if (TimeUtil.getBetweenDays(System.currentTimeMillis(), problemProxy.getLastLearnedTime()) == 0) {
//                this.totalRecord.topicDay = 0;
//                this.syncRecord.topicDay = 0;
//            }
//            markDirty();
//            return this;
//        }
//
//        /* access modifiers changed from: 0000 */
//        public TopicLearnProxy onlyMarkResult(int i, long j) {
//            this.totalRecord.topicScore = i;
//            this.syncRecord.topicScore = i;
//            this.totalRecord.lastDoTime = j;
//            this.syncRecord.lastDoTime = j;
//            markDirty();
//            return this;
//        }
//
//        /* access modifiers changed from: 0000 */
//        public TopicLearnProxy markStat(Answer answer, long j) {
//            if (answer == Answer.WRONG) {
//                this.totalRecord.errNum++;
//                this.syncRecord.errNum++;
//            }
//            this.totalRecord.doNum++;
//            this.syncRecord.doNum++;
//            this.totalRecord.totalTime += j;
//            this.syncRecord.totalTime += j;
//            markDirty();
//            return this;
//        }
//
//        /* access modifiers changed from: 0000 */
//        public TopicLearnProxy markDirty() {
//            this.totalRecord.syncState = 0;
//            this.syncRecord.syncState = 0;
//            return this;
//        }
//
//        /* access modifiers changed from: 0000 */
//        public void commit() {
//            LearnRecordManager.this.mTotalTable.put(Integer.valueOf(this.totalRecord.topicId), this.totalRecord);
//            if (this.totalRecord.isTodayNew == 1) {
//                LearnRecordManager.this.mTodayNewLearnedSet.add(Integer.valueOf(this.totalRecord.topicId));
//            }
//            LearnRecordManager.this.mTotalTableCache.put(Integer.valueOf(this.totalRecord.topicId), this.totalRecord);
//            LearnRecordManager.this.mSyncTableCache.put(Integer.valueOf(this.syncRecord.topicId), this.syncRecord);
//            LearnRecordManager.this.mCommitHandler.post(new Runnable() {
//                public void run() {
//                    LearnRecordManager.this.mTotalTableCache.putAndSave(Integer.valueOf(TopicLearnProxy.this.totalRecord.topicId), TopicLearnProxy.this.totalRecord);
//                    LearnRecordManager.this.mSyncTableCache.putAndSave(Integer.valueOf(TopicLearnProxy.this.syncRecord.topicId), TopicLearnProxy.this.syncRecord);
//                }
//            });
//        }
//    }
//
//    class TopicLearnRecordCache extends LruCache<Integer, TopicLearnRecord> {
//        static final int TABLE_SYNC = 2;
//        static final int TABLE_TOTAL = 1;
//        private Map<String, String> columnMap;
//        private Context context;
//        private int table;
//        private Uri uri;
//
//        private TopicLearnRecordCache(int i, int i2) {
//            super(i2);
//            this.table = i;
//        }
//
//        /* access modifiers changed from: 0000 */
//        public void init(Context context2, int i) {
//            this.context = context2;
//            switch (this.table) {
//                case 1:
//                    this.uri = TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i);
//                    this.columnMap = TopicLearnRecord.TOTAL_TABLE_COLUMN_MAP;
//                    break;
//                case 2:
//                    this.uri = TS_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i);
//                    this.columnMap = TopicLearnRecord.SYNCING_TABLE_COLUMN_MAP;
//                    break;
//            }
//            evictAll();
//        }
//
//        /* access modifiers changed from: protected */
//        public TopicLearnRecord create(Integer num) {
//            return (TopicLearnRecord) Cursors.mapToUnique(QueryBuilder.query(this.uri).where("topic_id = " + num, new String[0]).perform(this.context), TopicLearnRecord.class, this.columnMap);
//        }
//
//        public void putAndSave(Integer num, TopicLearnRecord topicLearnRecord) {
//            put(num, topicLearnRecord);
//            try {
//                this.context.getContentResolver().insert(this.uri, Cursors.convertContentValues(topicLearnRecord, TopicLearnRecord.class, this.columnMap, null));
//            } catch (Exception e) {
//                LogWrapper.m2794e(LearnRecordManager.TAG, Log.getStackTraceString(e));
//            }
//        }
//    }
//
//    public static LearnRecordManager getInstance() {
//        if (sInstance == null) {
//            synchronized (LearnRecordManager.class) {
//                if (sInstance == null) {
//                    sInstance = new LearnRecordManager();
//                }
//            }
//        }
//        return sInstance;
//    }
//
//    public LearnRecordManager() {
//        this.mCommitThread.start();
//        this.mCommitHandler = new Handler(this.mCommitThread.getLooper());
//    }
//
//    public boolean hasInited() {
//        return this.mHasInited;
//    }
//
//    public int getBookId() {
//        return this.mBookId;
//    }
//
//    public boolean load(Context context, int i, boolean z) {
//        LogWrapper.m2795i(TAG, "load bookId " + i + ", mBookId " + this.mBookId);
//        this.mContext = context.getApplicationContext();
//        int i2 = this.mBookId;
//        this.mBookId = i;
//        if (!checkSpanDays() && i2 == this.mBookId && !z) {
//            return false;
//        }
//        reload();
//        return true;
//    }
//
//    public void reload() {
//        int i = this.mBookId;
//        clear();
//        this.mBookId = i;
//        this.mTotalTableCache.init(this.mContext, this.mBookId);
//        this.mSyncTableCache.init(this.mContext, this.mBookId);
//        loadFromClient();
//        this.mHasInited = true;
//    }
//
//    public void clear() {
//        this.mBookId = -1;
//        this.mTotalTable.clear();
//        this.mTotalTableCache.evictAll();
//        this.mSyncTableCache.evictAll();
//        this.mTodayNewLearnedSet.clear();
//        this.mHasInited = false;
//    }
//
//    public boolean checkSpanDays() {
//        long currentTimeMillis = System.currentTimeMillis();
//        OfflineStateRecord offlieStateById = BookRecordHelper.getOfflieStateById(this.mContext, this.mBookId);
//        if (offlieStateById == null) {
//            offlieStateById = new OfflineStateRecord();
//            offlieStateById.bookId = this.mBookId;
//            offlieStateById.runTime = currentTimeMillis;
//            offlieStateById.wantMoreCount = 0;
//        }
//        LogWrapper.m2793d(TAG, "get OfflineStateRecord " + offlieStateById);
//        int betweenDays = TimeUtil.getBetweenDays(currentTimeMillis, offlieStateById.runTime);
//        if (betweenDays > 0) {
//            LogWrapper.m2793d(TAG, "span days " + betweenDays);
//            TopicLearnRecordHelper.incBookTopicDay(this.mContext, this.mBookId, betweenDays);
//            offlieStateById.wantMoreCount = 0;
//            offlieStateById.comboCount = 0;
//            offlieStateById.maxComboCount = 0;
//        }
//        offlieStateById.runTime = currentTimeMillis;
//        BookRecordHelper.saveOfflineState(this.mContext, offlieStateById);
//        StudyManager.getInstance().setCurrentOfflineState(offlieStateById);
//        return betweenDays > 0;
//    }
//
//    public void loadFromClient() {
//        LogWrapper.m2795i(TAG, "++++ load local learn records, bookId " + this.mBookId);
//        TopicLearnRecordHelper.createTotalTopicLearnRecordTable(this.mContext, this.mBookId);
//        TopicLearnRecordHelper.createSyncingTopicLearnRecordTable(this.mContext, this.mBookId);
//        this.mTotalTable.clear();
//        Cursor perform = QueryBuilder.query(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(this.mBookId)).projection("topic_id", "topic_obn", "topic_day", "is_today_new").perform(this.mContext);
//        if (perform != null) {
//            ArrayList<TopicLearnRecord> arrayList = new ArrayList<>(Cursors.getCursorRows(perform));
//            perform.moveToFirst();
//            while (!perform.isAfterLast()) {
//                TopicLearnRecord topicLearnRecord = new TopicLearnRecord();
//                topicLearnRecord.topicId = perform.getInt(0);
//                topicLearnRecord.topicScore = perform.getInt(1);
//                topicLearnRecord.topicDay = perform.getInt(2);
//                topicLearnRecord.isTodayNew = perform.getInt(3);
//                arrayList.add(topicLearnRecord);
//                perform.moveToNext();
//            }
//            perform.close();
//            for (TopicLearnRecord topicLearnRecord2 : arrayList) {
//                this.mTotalTable.put(Integer.valueOf(topicLearnRecord2.topicId), topicLearnRecord2);
//            }
//        }
//        LogWrapper.m2795i(TAG, "---- load local learn records total " + this.mTotalTable.size());
//    }
//
//    public boolean mergeWithServer(List<BBTopicInfo> list) {
//        boolean z;
//        boolean z2 = false;
//        boolean z3 = true;
//        LogWrapper.m2795i(TAG, "---- mergeWithServer ");
//        ArrayList arrayList = new ArrayList();
//        ArrayList arrayList2 = new ArrayList();
//        for (BBTopicInfo bBTopicInfo : list) {
//            int topic_id = bBTopicInfo.getTopic_id();
//            int span_days = bBTopicInfo.getSpan_days();
//            int update_days = bBTopicInfo.getUpdate_days();
//            int i = span_days == 0 ? 1 : 0;
//            TopicLearnRecord topicLearnRecord = (TopicLearnRecord) this.mTotalTable.get(Integer.valueOf(topic_id));
//            if (topicLearnRecord == null) {
//                topicLearnRecord = new TopicLearnRecord();
//                topicLearnRecord.topicId = topic_id;
//                z = true;
//            } else {
//                z = false;
//            }
//            if (!(topicLearnRecord.isTodayNew == i && topicLearnRecord.topicDay == update_days)) {
//                topicLearnRecord.isTodayNew = i;
//                topicLearnRecord.topicDay = update_days;
//                z = true;
//            }
//            if (TopicLearnRecord.isKilled(bBTopicInfo.getScore()) || bBTopicInfo.getScore() >= topicLearnRecord.topicScore) {
//                topicLearnRecord.topicScore = bBTopicInfo.getScore();
//                topicLearnRecord.errNum = bBTopicInfo.getWrong_times();
//                topicLearnRecord.doNum = bBTopicInfo.getDone_times();
//                topicLearnRecord.totalTime = (long) bBTopicInfo.getUsed_time();
//                z = true;
//            }
//            if (z) {
//                this.mTotalTable.put(Integer.valueOf(topic_id), topicLearnRecord);
//                arrayList.add(topicLearnRecord);
//                if (topicLearnRecord.isTodayNew == 1) {
//                    TopicLearnRecord topicLearnRecord2 = new TopicLearnRecord();
//                    topicLearnRecord2.topicId = topic_id;
//                    topicLearnRecord2.isTodayNew = 1;
//                    topicLearnRecord2.topicDay = topicLearnRecord.topicDay;
//                    topicLearnRecord2.topicScore = bBTopicInfo.getScore();
//                    topicLearnRecord2.errNum = 0;
//                    topicLearnRecord2.doNum = 0;
//                    topicLearnRecord2.totalTime = 0;
//                    topicLearnRecord2.syncState = 1;
//                    arrayList2.add(topicLearnRecord2);
//                }
//            }
//        }
//        if (arrayList.size() > 0) {
//            LogWrapper.m2793d(TAG, "mergeWithServer total learn records " + this.mBookId + ", " + arrayList.size());
//            TopicLearnRecordHelper.saveTotalTopicLearnRecords(this.mContext, this.mBookId, arrayList);
//            z2 = true;
//        }
//        if (arrayList2.size() > 0) {
//            LogWrapper.m2793d(TAG, "mergeWithServer sync learn records " + this.mBookId + ", " + arrayList2.size());
//            TopicLearnRecordHelper.saveSyncingTopicLearnRecords(this.mContext, this.mBookId, arrayList2);
//        } else {
//            z3 = z2;
//        }
//        LogWrapper.m2793d(TAG, "after merge topic learn records " + this.mTotalTable.size());
//        return z3;
//    }
//
//    public boolean verify() {
//        boolean z;
//        boolean z2;
//        final StudyManager instance = StudyManager.getInstance();
//        ArrayList arrayList = new ArrayList();
//        CollectionUtils.filterInPlace(this.mTotalTable.keySet().iterator(), new Filter<Integer>() {
//            public boolean filter(Integer num) {
//                return instance.isInRoadmap(num.intValue());
//            }
//        }, arrayList);
//        if (arrayList.size() > 0) {
//            LogWrapper.m2795i(TAG, "+++ total removed " + TextUtils.join(", ", arrayList));
//            TopicLearnRecordHelper.deleteTotalTopicLearnRecords(this.mContext, this.mBookId, arrayList);
//            z = true;
//        } else {
//            z = false;
//        }
//        ArrayList arrayList2 = new ArrayList();
//        for (TopicLearnRecord topicLearnRecord : this.mTotalTable.values()) {
//            if (topicLearnRecord.topicDay <= 0 || topicLearnRecord.topicDay >= 8 || topicLearnRecord.topicScore >= 3 || topicLearnRecord.isKilled()) {
//                z2 = false;
//            } else {
//                topicLearnRecord.topicScore = 3;
//                z2 = true;
//            }
//            if (topicLearnRecord.topicDay > 7 && topicLearnRecord.topicScore < 4 && !topicLearnRecord.isKilled()) {
//                topicLearnRecord.topicScore = 4;
//                z2 = true;
//            }
//            if (z2) {
//                TopicLearnRecord topicLearnRecord2 = new TopicLearnRecord();
//                topicLearnRecord2.topicId = topicLearnRecord.topicId;
//                topicLearnRecord2.topicDay = topicLearnRecord.topicDay;
//                topicLearnRecord2.topicScore = topicLearnRecord.topicScore;
//                topicLearnRecord2.syncState = 0;
//                topicLearnRecord2.lastDoTime = topicLearnRecord.lastDoTime;
//                topicLearnRecord2.isTodayNew = topicLearnRecord.isTodayNew;
//                topicLearnRecord2.doNum = 0;
//                topicLearnRecord2.errNum = 0;
//                topicLearnRecord2.totalTime = 0;
//                arrayList2.add(topicLearnRecord2);
//            }
//        }
//        if (arrayList2.size() > 0) {
//            LogWrapper.m2797w(TAG, "fixScore syncing table " + arrayList2.size());
//            TopicLearnRecordHelper.saveSyncingTopicLearnRecords(this.mContext, this.mBookId, arrayList2);
//            z = true;
//        }
//        Uri bookContentUri = TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(this.mBookId);
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("topic_obn", Integer.valueOf(3));
//        this.mContext.getContentResolver().update(bookContentUri, contentValues, "topic_day > 0 and topic_day < 8 and topic_obn < 3 and topic_obn > -1", null);
//        contentValues.put("topic_obn", Integer.valueOf(4));
//        this.mContext.getContentResolver().update(bookContentUri, contentValues, "topic_day > 7 and topic_obn < 4 and topic_obn > -1", null);
//        for (TopicLearnRecord topicLearnRecord3 : this.mTotalTable.values()) {
//            if (topicLearnRecord3.isTodayNew == 1) {
//                this.mTodayNewLearnedSet.add(Integer.valueOf(topicLearnRecord3.topicId));
//            }
//        }
//        LogWrapper.m2793d(TAG, "mTodayNewLearnedSet size " + this.mTodayNewLearnedSet.size());
//        return z;
//    }
//
//    public Map<Integer, TopicLearnRecord> getTotalTable() {
//        return this.mTotalTable;
//    }
//
//    public int getAllLearnedCount() {
//        return this.mTotalTable.size();
//    }
//
//    public int getTodayNewLearnedCount() {
//        return this.mTodayNewLearnedSet.size();
//    }
//
//    public int getTodayTouchCount() {
//        int i = 0;
//        Iterator it = this.mTotalTable.values().iterator();
//        while (true) {
//            int i2 = i;
//            if (!it.hasNext()) {
//                return i2;
//            }
//            if (((TopicLearnRecord) it.next()).topicDay == 0) {
//                i = i2 + 1;
//            } else {
//                i = i2;
//            }
//        }
//    }
//
//    public int getPastLearnedCount() {
//        return getAllLearnedCount() - getTodayNewLearnedCount();
//    }
//
//    public int getRemainCount() {
//        return StudyManager.getInstance().getRoadmapSize() - getAllLearnedCount();
//    }
//
//    public int getRemainCountIncludeToday() {
//        return (StudyManager.getInstance().getRoadmapSize() - getAllLearnedCount()) + getTodayNewLearnedCount();
//    }
//
//    public Collection<TopicLearnRecord> getAllLearnRecords() {
//        return this.mTotalTable.values();
//    }
//
//    public int getTotalTableSize() {
//        return this.mTotalTable.size();
//    }
//
//    public TopicLearnProxy obtainTopicLearnProxy(int i) {
//        TopicLearnRecord topicLearnRecord;
//        TopicLearnRecord topicLearnRecord2 = (TopicLearnRecord) this.mTotalTableCache.get(Integer.valueOf(i));
//        if (topicLearnRecord2 == null) {
//            TopicLearnRecord topicLearnRecord3 = new TopicLearnRecord();
//            topicLearnRecord3.topicId = i;
//            topicLearnRecord3.isTodayNew = 1;
//            topicLearnRecord3.topicScore = TopicLearnRecord.SCORE_UNTOUCH;
//            topicLearnRecord = topicLearnRecord3;
//        } else {
//            topicLearnRecord = topicLearnRecord2;
//        }
//        TopicLearnRecord topicLearnRecord4 = (TopicLearnRecord) this.mSyncTableCache.get(Integer.valueOf(i));
//        if (topicLearnRecord4 == null) {
//            topicLearnRecord4 = new TopicLearnRecord();
//            topicLearnRecord4.topicId = i;
//        }
//        topicLearnRecord4.isTodayNew = topicLearnRecord.isTodayNew;
//        return new TopicLearnProxy(topicLearnRecord, topicLearnRecord4);
//    }
//
//    public boolean isFirstMet(int i) {
//        return ((TopicLearnRecord) this.mTotalTable.get(Integer.valueOf(i))) == null;
//    }
//
//    public void markLocalReviewable(int i) {
//        TopicLearnRecord topicLearnRecord = (TopicLearnRecord) this.mTotalTable.get(Integer.valueOf(i));
//        if (topicLearnRecord != null && topicLearnRecord.topicScore > 4) {
//            topicLearnRecord.topicScore = 4;
//            TopicLearnRecordHelper.updateTopicLearnRecordScore(this.mContext, this.mBookId, i, 4);
//        }
//    }
//
//    public boolean isKilled(int i) {
//        TopicLearnRecord topicLearnRecord = (TopicLearnRecord) this.mTotalTable.get(Integer.valueOf(i));
//        if (topicLearnRecord != null) {
//            return topicLearnRecord.isKilled();
//        }
//        return false;
//    }
//
//    public boolean isTodayNewLearned(int i) {
//        TopicLearnRecord topicLearnRecord = (TopicLearnRecord) this.mTotalTable.get(Integer.valueOf(i));
//        if (topicLearnRecord != null) {
//            return topicLearnRecord.isTodayNew == 1;
//        }
//        return true;
//    }
//
//    private ProblemProxy getProblemProxy(int i) {
//        return (ProblemProxy) StudyManager.getInstance().getProblemProxyMap().get(Integer.valueOf(i));
//    }
//
//    public void kill(int i, long j) {
//        ProblemProxy problemProxy = getProblemProxy(i);
//        if (problemProxy != null) {
//            StudyManager.getInstance().getLearningManager().getSequenceStrategy().kill(problemProxy);
//            obtainTopicLearnProxy(i).markResult(problemProxy).markStat(Answer.KILL, j).commit();
//        }
//    }
//
//    public void cancelKill(int i) {
//        ProblemProxy problemProxy = getProblemProxy(i);
//        if (problemProxy != null) {
//            StudyManager.getInstance().getLearningManager().getSequenceStrategy().cancelKill(problemProxy);
//            obtainTopicLearnProxy(i).markResult(problemProxy).commit();
//        }
//    }
//
//    public void doneCorrect(int i, long j) {
//        ProblemProxy problemProxy = getProblemProxy(i);
//        StudyManager.getInstance().getLearningManager().getSequenceStrategy().doneCorrect(problemProxy, j, null);
//        obtainTopicLearnProxy(i).markResult(problemProxy).markStat(Answer.CORRECT, j).commit();
//    }
//
//    public void doneWrong(int i, long j) {
//        ProblemProxy problemProxy = getProblemProxy(i);
//        StudyManager.getInstance().getLearningManager().getSequenceStrategy().doneWrong(problemProxy, j, null);
//        obtainTopicLearnProxy(i).markResult(problemProxy).markStat(Answer.WRONG, j).commit();
//    }
//
//    public void hint(int i) {
//        StudyManager.getInstance().getLearningManager().getSequenceStrategy().userActionHint(getProblemProxy(i));
//    }
//
//    public void doneWrongForReview(int i) {
//        TopicLearnProxy obtainTopicLearnProxy = obtainTopicLearnProxy(i);
//        if (obtainTopicLearnProxy.getScore() > 4) {
//            obtainTopicLearnProxy.onlyMarkResult(3, System.currentTimeMillis()).markStat(Answer.WRONG, 0).markDirty().commit();
//        }
//    }
//
//    public int getKillCount() {
//        return CollectionUtils.count(this.mTotalTable.values(), (Filter<T>) new Filter<TopicLearnRecord>() {
//            public boolean filter(TopicLearnRecord topicLearnRecord) {
//                return topicLearnRecord.isKilled();
//            }
//        });
//    }
//
//    public static void killInDatabase(Context context, int i, int i2) {
//        long currentTimeMillis = System.currentTimeMillis();
//        TopicLearnRecord totalTopicLearnRecordById = TopicLearnRecordHelper.getTotalTopicLearnRecordById(context, i, i2);
//        if (totalTopicLearnRecordById == null) {
//            totalTopicLearnRecordById = new TopicLearnRecord();
//            totalTopicLearnRecordById.topicId = i2;
//            totalTopicLearnRecordById.isTodayNew = 1;
//        }
//        totalTopicLearnRecordById.topicDay = 0;
//        totalTopicLearnRecordById.topicScore = -1;
//        totalTopicLearnRecordById.lastDoTime = currentTimeMillis;
//        TopicLearnRecord syncingTopicLearnRecordById = TopicLearnRecordHelper.getSyncingTopicLearnRecordById(context, i, i2);
//        if (syncingTopicLearnRecordById == null) {
//            syncingTopicLearnRecordById = new TopicLearnRecord();
//            syncingTopicLearnRecordById.topicId = i2;
//        }
//        syncingTopicLearnRecordById.topicDay = 0;
//        syncingTopicLearnRecordById.topicScore = -1;
//        syncingTopicLearnRecordById.lastDoTime = currentTimeMillis;
//        syncingTopicLearnRecordById.isTodayNew = totalTopicLearnRecordById.isTodayNew;
//        TopicLearnRecordHelper.saveTotalTopicLearnRecord(context, i, totalTopicLearnRecordById);
//        TopicLearnRecordHelper.saveSyncingTopicLearnRecord(context, i, syncingTopicLearnRecordById);
//    }
//
//    public void upload(Context context, int i, Client client) {
//        int uploadRecordsCount = getUploadRecordsCount(context, i);
//        LogWrapper.m2793d(TAG, "upload total count " + uploadRecordsCount);
//        while (uploadRecordsCount > 0) {
//            List batchUploadRecords = getBatchUploadRecords(context, i, 50);
//            if (CollectionUtils.isEmpty((Collection<?>) batchUploadRecords)) {
//                LogWrapper.m2796v(TAG, "upload complete");
//                return;
//            } else {
//                uploadBatch(context, i, client, batchUploadRecords);
//                uploadRecordsCount -= batchUploadRecords.size();
//            }
//        }
//    }
//
//    public static int getUploadRecordsCount(Context context, int i) {
//        return ProviderUtils.queryNumEntries(context, Databases.TOPIC_PROBLEM, TS_OFFLINE_DOTOPIC_SYNC_IDS.getBookTableName(i), "sync_state=  0", null);
//    }
//
//    private static List<BBDoneRecord> getBatchUploadRecords(Context context, int i, int i2) {
//        return CollectionUtils.map((Collection<T>) Cursors.mapToList(QueryBuilder.query(TS_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i)).where("sync_state = 0 LIMIT " + i2, new String[0]).perform(context), TopicLearnRecord.class, TopicLearnRecord.SYNCING_TABLE_COLUMN_MAP), (Mapper<T, R>) new Mapper<TopicLearnRecord, BBDoneRecord>() {
//            public final BBDoneRecord map(TopicLearnRecord topicLearnRecord) {
//                BBDoneRecord bBDoneRecord = new BBDoneRecord();
//                bBDoneRecord.setWord_topic_id(topicLearnRecord.topicId);
//                bBDoneRecord.setCurrent_score(topicLearnRecord.topicScore);
//                bBDoneRecord.setSpan_days(topicLearnRecord.topicDay);
//                bBDoneRecord.setWrong_times(topicLearnRecord.errNum);
//                bBDoneRecord.setDone_times(topicLearnRecord.doNum);
//                bBDoneRecord.setIs_first_do_at_today(topicLearnRecord.isTodayNew);
//                bBDoneRecord.setUsed_time((int) topicLearnRecord.totalTime);
//                return bBDoneRecord;
//            }
//        });
//    }
//
//    private void onBatchUploadSuccess(Context context, int i, List<BBDoneRecord> list) {
//        StringBuilder sb = new StringBuilder("topic_id in (");
//        boolean z = true;
//        for (BBDoneRecord bBDoneRecord : list) {
//            if (z) {
//                z = false;
//            } else {
//                sb.append(",");
//            }
//            sb.append(bBDoneRecord.getWord_topic_id());
//        }
//        sb.append(")");
//        if (context.getContentResolver().delete(TS_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i), sb.toString(), null) < 0) {
//            throw new Exception("上传学习记录错误，数据库操作异常");
//        } else if (i == this.mBookId) {
//            for (BBDoneRecord word_topic_id : list) {
//                this.mSyncTableCache.remove(Integer.valueOf(word_topic_id.getWord_topic_id()));
//            }
//        }
//    }
//
//    private void updateLocalSyncVersion(Context context, int i, long j) {
//        ScheduleRecord currentSchedule = StudyManager.getInstance().getCurrentSchedule();
//        if (currentSchedule != null && currentSchedule.bookId == i) {
//            currentSchedule.remoteSyncVer = j;
//        }
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("sync_state", Long.valueOf(j));
//        context.getContentResolver().update(ZBOOKFINISHINFO.CONTENT_URI, contentValues, "BOOK_ID=" + i, null);
//    }
//
//    private int uploadBatch(Context context, int i, Client client, List<BBDoneRecord> list) {
//        long currentTimeSeconds = TimeUtil.currentTimeSeconds();
//        LogWrapper.m2796v(TAG, "+++++++ upload learn records batch start: " + i + ", " + list.size() + ", timestamp " + currentTimeSeconds);
//        int update_done_data = client.update_done_data(currentTimeSeconds, list, i, false);
//        LogWrapper.m2796v(TAG, "upload learn records result " + update_done_data);
//        if (update_done_data != 0) {
//            return update_done_data;
//        }
//        updateLocalSyncVersion(context, i, currentTimeSeconds);
//        onBatchUploadSuccess(context, i, list);
//        ScheduleRecord currentSchedule = StudyManager.getInstance().getCurrentSchedule();
//        if (currentSchedule == null || currentSchedule.bookId != i) {
//            return 0;
//        }
//        currentSchedule.localSyncVer = currentTimeSeconds;
//        LogWrapper.m2796v(TAG, "upload learn records batch end: " + i + ", version " + currentTimeSeconds);
//        return 0;
//    }
//}
