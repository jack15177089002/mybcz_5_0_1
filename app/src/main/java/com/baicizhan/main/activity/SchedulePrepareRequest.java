//package com.baicizhan.main.activity;
//
//import android.content.Context;
//import android.os.Handler;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.helpers.BookRecordHelper;
//import com.baicizhan.client.business.dataset.helpers.KVHelper;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
//import com.baicizhan.client.business.dataset.helpers.TopicRecordHelper;
//import com.baicizhan.client.business.dataset.helpers.UserRecordHelper;
//import com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper;
//import com.baicizhan.client.business.dataset.models.BookRecord;
//import com.baicizhan.client.business.dataset.models.RoadmapRecord;
//import com.baicizhan.client.business.dataset.models.ScheduleRecord;
//import com.baicizhan.client.business.dataset.models.TopicLearnRecord;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.managers.BookListManager;
//import com.baicizhan.client.business.managers.LearnRecordManager;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.thrift.TEnhancedHttpClient;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.CollectionUtils;
//import com.baicizhan.client.business.util.CollectionUtils.Mapper;
//import com.baicizhan.client.business.util.ConstantsUtil;
//import com.baicizhan.client.business.util.FileUtils;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.Profiler;
//import com.baicizhan.client.business.util.TimeUtil;
//import com.baicizhan.learning_strategy.bean.ProblemProxy;
//import com.baicizhan.learning_strategy.iface.LearningManager;
//import com.baicizhan.main.utils.CommonUtils;
//import com.baicizhan.main.utils.RoadmapUtils;
//import com.baicizhan.online.bs_users.BBBasicInfo;
//import com.baicizhan.online.bs_users.BBCheckInfo;
//import com.baicizhan.online.bs_users.BBLearnInfo;
//import com.baicizhan.online.bs_users.BBRoadMapElement;
//import com.baicizhan.online.bs_users.BBSelectTip;
//import com.baicizhan.online.bs_users.BBUserBasicInfo;
//import com.baicizhan.online.bs_users.BBUserLimit;
//import com.baicizhan.online.bs_users.BBUserTailoredBookInfo;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import com.jiongji.andriod.card.R;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//import org.p100a.p101a.p107f.C2120g;
//
//public abstract class SchedulePrepareRequest extends ThriftRequest<Client, Integer> {
//    public static final int MSG_PROGRESS = 1;
//    public static final int RESULT_CANCELED = 2;
//    public static final int RESULT_NEW_SCHEDULE = 1;
//    public static final int RESULT_OK = 0;
//    private static final String TAG = SchedulePrepareRequest.class.getSimpleName();
//    private BBBasicInfo basicInfo;
//    Context context;
//    Handler handler;
//    private boolean learnRecordUpdated = false;
//    StudyManager manager;
//    Profiler profiler = new Profiler();
//    int requestFlag;
//    int result = 0;
//    private boolean roadmapUpdated = false;
//    private boolean scheduleUpdated = false;
//
//    public class PrepareException extends Exception {
//        public static final int EMPTY_SCHEDULE = 3;
//        public static final int FORCE_SELECT = 2;
//        public static final int INVALID_USER = 1;
//        public static final int LEARNING_MANAGER_NULL = 4;
//        private static final long serialVersionUID = 1;
//        private int code;
//
//        public PrepareException(int i, String str) {
//            super(str);
//            this.code = i;
//        }
//
//        public int getCode() {
//            return this.code;
//        }
//
//        public String toString() {
//            return "PrepareException{code=" + this.code + "message=" + getMessage() + "}";
//        }
//    }
//
//    public SchedulePrepareRequest(String str, Context context2, Handler handler2, int i) {
//        super(str);
//        this.context = context2;
//        this.handler = handler2;
//        this.requestFlag = i;
//        this.manager = StudyManager.getInstance();
//    }
//
//    public void cancel() {
//        super.cancel();
//        LogWrapper.m2795i(TAG, "cancel request " + this);
//    }
//
//    /* access modifiers changed from: protected */
//    public Integer doInBackground(Client client) {
//        TEnhancedHttpClient httpClient = getHttpClient();
//        if (httpClient != null) {
//            httpClient.setMaxRetryCount(1);
//            httpClient.setConnectTimeout(3000);
//            httpClient.setReadTimeout(3000);
//        }
//        this.profiler.openFunc(TAG, "doInBackground");
//        if (this.manager.getCurrentUser() == null) {
//            UserRecord currentUserRecord = UserRecordHelper.getCurrentUserRecord(this.context);
//            if (currentUserRecord != null) {
//                this.manager.setCurrentUser(currentUserRecord);
//            } else {
//                throw new PrepareException(1, "账号信息错误");
//            }
//        }
//        this.profiler.openFunc(TAG, "tryCheckIn");
//        tryCheckIn(client);
//        this.profiler.closeAndPrintFunc(TAG, "tryCheckIn");
//        if (isCanceled()) {
//            return Integer.valueOf(2);
//        }
//        this.profiler.openFunc(TAG, "loadSchedule");
//        loadSchedule(client);
//        this.profiler.closeAndPrintFunc(TAG, "loadSchedule");
//        if (isCanceled()) {
//            return Integer.valueOf(2);
//        }
//        this.profiler.openFunc(TAG, "loadRoadmap");
//        loadRoadmap(client);
//        this.profiler.closeAndPrintFunc(TAG, "loadRoadmap");
//        if (isCanceled()) {
//            return Integer.valueOf(2);
//        }
//        this.profiler.openFunc(TAG, "loadLearnRecord");
//        loadLearnRecord(client);
//        this.profiler.closeAndPrintFunc(TAG, "loadLearnRecord");
//        if (isCanceled()) {
//            return Integer.valueOf(2);
//        }
//        this.profiler.openFunc(TAG, "fixSchedule");
//        fixSchedule();
//        this.profiler.openFunc(TAG, "fixSchedule");
//        if (isCanceled()) {
//            return Integer.valueOf(2);
//        }
//        this.profiler.openFunc(TAG, "prepareLearningManager");
//        prepareLearningManager();
//        this.profiler.closeAndPrintFunc(TAG, "prepareLearningManager");
//        this.profiler.closeAndPrintFunc(TAG, "doInBackground");
//        LogWrapper.m2795i(TAG, "prepare schedule finish result " + this.result);
//        return Integer.valueOf(this.result);
//    }
//
//    private void tryCheckIn(Client client) {
//        if (this.manager.isOfflined() || this.manager.getCheckInfo() == null) {
//            try {
//                this.profiler.openFunc(TAG, "check_infos");
//                BBCheckInfo check_infos = client.check_infos();
//                this.profiler.closeAndPrintFunc(TAG, "check_infos");
//                LogWrapper.m2793d(TAG, "thrift check_infos offline " + check_infos);
//                this.manager.setCheckInfo(check_infos);
//                CommonUtils.login(this.context, client, this.manager.getCurrentUser(), 0);
//                this.manager.setIsOfflined(false);
//            } catch (Exception e) {
//                if (!(e instanceof C2120g)) {
//                    Log.e(TAG, Log.getStackTraceString(e));
//                }
//                this.manager.setIsOfflined(true);
//                LogWrapper.m2793d(TAG, "tryCheckIn failed");
//                this.manager.setIsOfflined(true);
//            }
//        }
//    }
//
//    private void loadSchedule(Client client) {
//        ScheduleRecord scheduleRecord = null;
//        if (!this.manager.hasValidSchedule() || (this.requestFlag & 1) > 0) {
//            scheduleRecord = loadScheduleFromServer(client);
//        }
//        if (scheduleRecord == null) {
//            if (this.manager.hasValidSchedule()) {
//                LogWrapper.m2795i(TAG, "use current schedule");
//                return;
//            }
//            scheduleRecord = BookRecordHelper.getCurrentSchedule(this.context);
//            LogWrapper.m2795i(TAG, "load schedule from local " + scheduleRecord);
//            if (scheduleRecord == null) {
//                throw new PrepareException(3, "找不到学习计划");
//            }
//        }
//        onGetSchedule(client, scheduleRecord);
//    }
//
//    private ScheduleRecord loadScheduleFromServer(Client client) {
//        ScheduleRecord scheduleRecord;
//        try {
//            if (this.manager.isOfflined()) {
//                return null;
//            }
//            LogWrapper.m2793d(TAG, "<server> loadScheduleFromServer");
//            this.profiler.openFunc(TAG, "user_basic_info");
//            this.basicInfo = client.user_basic_info();
//            this.profiler.closeAndPrintFunc(TAG, "user_basic_info");
//            LogWrapper.m2793d(TAG, "thrift user_basic_info " + this.basicInfo);
//            BBLearnInfo learn_info = this.basicInfo.getLearn_info();
//            UserRecord currentUser = this.manager.getCurrentUser();
//            BBUserBasicInfo user_info = this.basicInfo.getUser_info();
//            currentUser.setSex(user_info.getGender_id());
//            currentUser.setNickName(user_info.getNickname());
//            currentUser.setVocabulary(learn_info.vocab_count);
//            UserRecordHelper.updateUserRecord(this.context, currentUser, "sex", "nickName");
//            LogWrapper.m2793d(TAG, "setNickName " + user_info.getNickname());
//            if (user_info.getCurrent_word_level_id() > 0) {
//                scheduleRecord = new ScheduleRecord();
//                scheduleRecord.isCurrentSelect = 1;
//                scheduleRecord.bookId = user_info.getCurrent_word_level_id();
//                scheduleRecord.remoteSyncVer = learn_info.getLast_sync_done_score_time();
//                scheduleRecord.dakaDays = learn_info.getTotal_daka_days();
//                scheduleRecord.lastDakaTime = learn_info.getLast_daka_at();
//                scheduleRecord.dueTime = learn_info.getCurrent_target_end_time();
//            } else {
//                scheduleRecord = null;
//            }
//            BBUserLimit user_limit = this.basicInfo.getUser_limit();
//            if (user_limit != null) {
//                this.manager.setUserLimit(user_limit);
//                KVHelper.setLong(this.context, KVHelper.KEY_USER_HAS_WORD_FRIENDS, (long) user_limit.getHas_word_friends());
//                BBSelectTip select_date_tip = user_limit.getSelect_date_tip();
//                if (select_date_tip != null && select_date_tip.getShould_select_date() == 1) {
//                    if (scheduleRecord != null) {
//                        BookRecord bookById = BookListManager.getInstance().getBookById(scheduleRecord.bookId);
//                        this.manager.setCurrentSchedule(scheduleRecord);
//                        this.manager.setCurrentBook(bookById);
//                        LogWrapper.m2793d(TAG, "set temp schedule " + scheduleRecord + ", " + bookById);
//                    }
//                    throw new PrepareException(2, null);
//                }
//            } else {
//                KVHelper.setLong(this.context, KVHelper.KEY_USER_HAS_WORD_FRIENDS, 0);
//            }
//            if (scheduleRecord != null) {
//                return scheduleRecord;
//            }
//            throw new PrepareException(3, "word_level_id 0");
//        } catch (PrepareException e) {
//            throw e;
//        } catch (Exception e2) {
//            if (e2 instanceof C2120g) {
//                return null;
//            }
//            LogWrapper.m2794e(TAG, Log.getStackTraceString(e2));
//            return null;
//        }
//    }
//
//    private void onGetSchedule(Client client, ScheduleRecord scheduleRecord) {
//        BookListManager instance = BookListManager.getInstance();
//        this.profiler.openFunc(TAG, "lazyLoadCurrentBookRecord");
//        BookRecord lazyLoadCurrentBookRecord = instance.lazyLoadCurrentBookRecord(this.context, client, scheduleRecord.bookId);
//        this.profiler.closeAndPrintFunc(TAG, "lazyLoadCurrentBookRecord");
//        if (lazyLoadCurrentBookRecord == null) {
//            throw new PrepareException(3, "找不到计划对应书:" + scheduleRecord.bookId);
//        }
//        if (!(this.basicInfo == null || this.basicInfo.getLearn_info() == null)) {
//            lazyLoadCurrentBookRecord.updateCurrentBookInfo(this.basicInfo.getLearn_info());
//            try {
//                BBUserTailoredBookInfo bBUserTailoredBookInfo = new BBUserTailoredBookInfo();
//                bBUserTailoredBookInfo.setBook_id(lazyLoadCurrentBookRecord.bookId);
//                bBUserTailoredBookInfo.setLast_touch_at(lazyLoadCurrentBookRecord.localBookResVer);
//                lazyLoadCurrentBookRecord.remoteBookResVer = client.get_book_last_updated_time(bBUserTailoredBookInfo).getLast_touch_at();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        LogWrapper.m2793d(TAG, "getBook " + lazyLoadCurrentBookRecord);
//        if (scheduleRecord.dueTime == 0) {
//            scheduleRecord.dueTime = lazyLoadCurrentBookRecord.dueTime;
//        }
//        ScheduleRecord currentSchedule = this.manager.getCurrentSchedule();
//        if (currentSchedule == null || currentSchedule.bookId != scheduleRecord.bookId) {
//            LogWrapper.m2795i(TAG, "update new schedule " + scheduleRecord);
//            this.scheduleUpdated = true;
//            this.result = 1;
//            ScheduleRecord scheduleById = BookRecordHelper.getScheduleById(this.context, scheduleRecord.bookId);
//            if (scheduleById != null) {
//                scheduleRecord.localSyncVer = scheduleById.localSyncVer;
//            }
//            this.manager.clearCurrentScheduleData();
//            this.manager.setCurrentSchedule(scheduleRecord);
//            LearnRecordManager.getInstance().clear();
//        } else {
//            LogWrapper.m2795i(TAG, "update old schedule");
//            this.result = 0;
//            currentSchedule.remoteSyncVer = scheduleRecord.remoteSyncVer;
//            currentSchedule.dakaDays = scheduleRecord.dakaDays;
//            currentSchedule.lastDakaTime = scheduleRecord.lastDakaTime;
//            this.manager.setCurrentSchedule(currentSchedule);
//        }
//        lazyLoadCurrentBookRecord.dueTime = scheduleRecord.dueTime;
//        this.manager.setCurrentBook(lazyLoadCurrentBookRecord);
//        BookRecordHelper.saveScheduleAsCurrentSelected(this.context, scheduleRecord);
//        PropertyHelper.put(PropertyHelper.CURRENT_BOOK_ID, lazyLoadCurrentBookRecord.bookId);
//    }
//
//    private void loadRoadmap(Client client) {
//        BookRecord currentBook = this.manager.getCurrentBook();
//        LogWrapper.m2795i(TAG, "check roadmap version: " + currentBook.localRoadmapVer + " - " + currentBook.remoteRoadmapVer);
//        if ((currentBook.localRoadmapVer == 0 || (currentBook.remoteRoadmapVer > 0 && currentBook.localRoadmapVer != currentBook.remoteRoadmapVer)) && loadRoadmapFromServer(client)) {
//            this.roadmapUpdated = true;
//        } else if (this.manager.getRoadmapSize() > 0) {
//            LogWrapper.m2793d(TAG, "skip roadmap, size " + this.manager.getRoadmapSize());
//        } else {
//            List loadRoadmap = RoadmapUtils.loadRoadmap(this.context, currentBook.bookId);
//            LogWrapper.m2793d(TAG, "<client> loadRoadmap" + loadRoadmap.size());
//            if (!CollectionUtils.isEmpty((Collection<?>) loadRoadmap)) {
//                this.manager.setCurrentRoadmap(loadRoadmap);
//            } else if (!loadRoadmapFromServer(client)) {
//                currentBook.localRoadmapVer = 0;
//                BookRecordHelper.saveBookRecord(this.context, currentBook);
//                throw new Exception("加载学习路线图失败");
//            }
//        }
//    }
//
//    private boolean loadRoadmapFromServer(Client client) {
//        try {
//            if (this.manager.isOfflined()) {
//                return false;
//            }
//            this.profiler.openFunc(TAG, "loadRoadmapFromServer");
//            BookRecord currentBook = this.manager.getCurrentBook();
//            int i = currentBook.bookId;
//            LogWrapper.m2793d(TAG, "<server> loadRoadmapFromServer");
//            this.profiler.openFunc(TAG, "roadmap_by_word_level");
//            List roadmap_by_word_level = client.roadmap_by_word_level(i);
//            this.profiler.closeAndPrintFunc(TAG, "roadmap_by_word_level");
//            LogWrapper.m2793d(TAG, "thrift roadmap_by_word_level size " + roadmap_by_word_level.size());
//            if (!CollectionUtils.isEmpty((Collection<?>) roadmap_by_word_level)) {
//                List map = CollectionUtils.map((Collection<T>) roadmap_by_word_level, (Mapper<T, R>) new Mapper<BBRoadMapElement, RoadmapRecord>() {
//                    public RoadmapRecord map(BBRoadMapElement bBRoadMapElement) {
//                        RoadmapRecord roadmapRecord = new RoadmapRecord();
//                        roadmapRecord.f2231id = bBRoadMapElement.getTopic_id();
//                        roadmapRecord.options = new int[bBRoadMapElement.getOptions().size()];
//                        int i = 0;
//                        while (true) {
//                            int i2 = i;
//                            if (i2 >= roadmapRecord.options.length) {
//                                return roadmapRecord;
//                            }
//                            roadmapRecord.options[i2] = ((Integer) bBRoadMapElement.getOptions().get(i2)).intValue();
//                            i = i2 + 1;
//                        }
//                    }
//                });
//                if (RoadmapUtils.saveRoadmap(i, map)) {
//                    LogWrapper.m2793d(TAG, "save roadmap " + i + "size " + map.size());
//                    this.manager.setCurrentRoadmap(map);
//                    currentBook.localRoadmapVer = currentBook.remoteRoadmapVer;
//                    BookRecordHelper.saveBookRecord(this.context, currentBook);
//                    LogWrapper.m2793d(TAG, "loeadRoadmapFromServer success");
//                    this.profiler.closeAndPrintFunc(TAG, "loadRoadmapFromServer");
//                    return true;
//                }
//            }
//            this.profiler.closeAndPrintFunc(TAG, "loadRoadmapFromServer");
//            LogWrapper.m2793d(TAG, "loeadRoadmapFromServer failed");
//            return false;
//        } catch (Exception e) {
//            if (!(e instanceof C2120g)) {
//                LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//            }
//        } finally {
//            this.profiler.closeAndPrintFunc(TAG, "loadRoadmapFromServer");
//        }
//    }
//
//    private void loadLearnRecord(Client client) {
//        boolean z = true;
//        ScheduleRecord currentSchedule = this.manager.getCurrentSchedule();
//        LogWrapper.m2793d(TAG, "check learn record version: " + currentSchedule.localSyncVer + " - " + currentSchedule.remoteSyncVer);
//        LearnRecordManager instance = LearnRecordManager.getInstance();
//        Context context2 = this.context;
//        int i = currentSchedule.bookId;
//        if (this.result != 1) {
//            z = false;
//        }
//        this.learnRecordUpdated = instance.load(context2, i, z);
//        if (!this.manager.isOfflined() && currentSchedule.remoteSyncVer != 0 && (currentSchedule.localSyncVer == 0 || currentSchedule.localSyncVer != currentSchedule.remoteSyncVer)) {
//            try {
//                LogWrapper.m2793d(TAG, "<server> get_learned_words_list");
//                this.profiler.openFunc(TAG, "get_learned_words_list");
//                notifyProgress("下载学习记录...");
//                List list = client.get_learned_words_list();
//                this.profiler.closeAndPrintFunc(TAG, "get_learned_words_list");
//                LogWrapper.m2793d(TAG, "thrift get_learned_words_list " + list.size());
//                if (instance.mergeWithServer(list)) {
//                    this.learnRecordUpdated = true;
//                }
//                currentSchedule.localSyncVer = currentSchedule.remoteSyncVer;
//            } catch (Exception e) {
//                if (!(e instanceof C2120g)) {
//                    LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//                }
//            }
//        }
//        this.learnRecordUpdated = instance.verify() | this.learnRecordUpdated;
//    }
//
//    private void fixSchedule() {
//        int i;
//        int i2;
//        int roadmapSize = this.manager.getRoadmapSize();
//        BookRecord currentBook = this.manager.getCurrentBook();
//        ScheduleRecord currentSchedule = this.manager.getCurrentSchedule();
//        currentBook.finishCount = LearnRecordManager.getInstance().getTotalTableSize();
//        if (roadmapSize > 0) {
//            currentBook.wordCount = roadmapSize;
//        }
//        int bookRemainCount = CommonUtils.getBookRemainCount(currentBook);
//        int remainDays = currentBook.getRemainDays();
//        if (remainDays <= 0) {
//            LogWrapper.m2793d(TAG, "RemainDay 0: " + currentBook);
//            throw new PrepareException(2, "无效的学习计划，请重新选择");
//        }
//        int i3 = bookRemainCount / remainDays;
//        if (bookRemainCount % remainDays != 0) {
//            i3++;
//        }
//        int i4 = this.manager.getCurrentOfflineState().wantMoreCount;
//        int max = Math.max(LearnRecordManager.getInstance().getTodayNewLearnedCount(), Math.min(bookRemainCount, i3 + i4));
//        currentSchedule.completeReviewMode = false;
//        LearnRecordManager instance = LearnRecordManager.getInstance();
//        if (bookRemainCount == 0 && instance.getTodayNewLearnedCount() == 0) {
//            i2 = instance.getTotalTableSize() - instance.getKillCount();
//            LogWrapper.m2793d(TAG, "allReviewCount " + i2);
//            int i5 = Settings.getInt(Settings.PREF_COMPLETE_REVIEW_COUNT);
//            if (i5 == 0) {
//                i5 = 100;
//            }
//            if (i5 <= i2) {
//                i2 = i5;
//            }
//            currentSchedule.completeReviewMode = true;
//            i = i2;
//        } else {
//            int i6 = max;
//            i = i3;
//            i2 = i6;
//        }
//        currentSchedule.dailyNewCount = i;
//        this.manager.setTodayNewCount(i2);
//        LogWrapper.m2793d(TAG, String.format(Locale.CHINA, "fixSchedule [totalCount %d, learned %d, remainCount %d, remainDays %d, dailyNewCount %d, todayNewCount %d, wantMoreCount %d]", new Object[]{Integer.valueOf(roadmapSize), Integer.valueOf(LearnRecordManager.getInstance().getTotalTableSize()), Integer.valueOf(bookRemainCount), Integer.valueOf(remainDays), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4)}));
//        this.profiler.openFunc(TAG, "createBookTopicResourceTable");
//        TopicRecordHelper.createBookTopicResourceTable(this.context, currentBook.bookId, this.manager.getCurrentRoadmap());
//        this.profiler.closeAndPrintFunc(TAG, "createBookTopicResourceTable");
//        WordMediaRecordHelper.createTablesIfNotExists(this.context, currentBook.bookId);
//        BookRecordHelper.saveBookRecord(this.context, currentBook);
//        BookRecordHelper.updateSchedule(this.context, currentSchedule, new String[0]);
//        LogWrapper.m2793d(TAG, "save current book " + currentBook);
//        LogWrapper.m2793d(TAG, "save current schedule " + currentSchedule);
//    }
//
//    private void prepareLearningManager() {
//        try {
//            setLearningManagerMode(initLearningManager());
//        } catch (Exception e) {
//            LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//            throw e;
//        }
//    }
//
//    private LearningManager initLearningManager() {
//        boolean z;
//        if (this.manager.getLearningManager() == null) {
//            this.profiler.openFunc(TAG, "readScript");
//            String readTextStringFromRaw = FileUtils.readTextStringFromRaw(this.context.getResources(), R.raw.learning_strategy);
//            this.profiler.closeAndPrintFunc(TAG, "readScript");
//            this.profiler.openFunc(TAG, "loadLearningManager");
//            boolean loadLearningManager = StudyManager.getInstance().loadLearningManager(readTextStringFromRaw);
//            this.profiler.closeAndPrintFunc(TAG, "loadLearningManager");
//            if (!loadLearningManager) {
//                throw new PrepareException(4, "学习策略加载失败");
//            }
//        }
//        LearningManager learningManager = this.manager.getLearningManager();
//        if (!learningManager.isInited() || this.scheduleUpdated || this.roadmapUpdated || this.learnRecordUpdated || (this.requestFlag & 4) != 0) {
//            this.profiler.openFunc(TAG, "createProxy");
//            long currentTimeMillis = System.currentTimeMillis();
//            this.profiler.openFunc(TAG, "releaseProxy");
//            Map problemProxyMap = this.manager.getProblemProxyMap();
//            problemProxyMap.clear();
//            this.profiler.closeAndPrintFunc(TAG, "releaseProxy");
//            this.profiler.openFunc(TAG, "problems");
//            List createProblemProxies = this.manager.createProblemProxies(this.manager.getRoadmapSize());
//            List roadmapOrder = this.manager.getRoadmapOrder();
//            for (int i = 0; i < createProblemProxies.size(); i++) {
//                ProblemProxy problemProxy = (ProblemProxy) createProblemProxies.get(i);
//                int intValue = ((Integer) roadmapOrder.get(i)).intValue();
//                problemProxy.setId(intValue);
//                problemProxyMap.put(Integer.valueOf(intValue), problemProxy);
//            }
//            this.profiler.closeAndPrintFunc(TAG, "problems");
//            this.profiler.openFunc(TAG, "doneProblems");
//            HashMap hashMap = new HashMap();
//            long j = currentTimeMillis - TimeUtil.DAY_MILLIS;
//            for (TopicLearnRecord topicLearnRecord : LearnRecordManager.getInstance().getTotalTable().values()) {
//                ProblemProxy problemProxy2 = (ProblemProxy) problemProxyMap.get(Integer.valueOf(topicLearnRecord.topicId));
//                problemProxy2.setId(topicLearnRecord.topicId);
//                problemProxy2.setScore(topicLearnRecord.topicScore);
//                if (topicLearnRecord.topicDay == 0) {
//                    problemProxy2.setLastLearnedTime(currentTimeMillis);
//                } else {
//                    problemProxy2.setLastLearnedTime(j);
//                }
//                if (topicLearnRecord.isTodayNew == 1) {
//                    z = true;
//                } else {
//                    z = false;
//                }
//                problemProxy2.setTodayNewLearned(z);
//                problemProxy2.setReviewMoreCount(0);
//                problemProxy2.setGroupId(0);
//                hashMap.put(Integer.valueOf(topicLearnRecord.topicId), problemProxy2);
//            }
//            this.profiler.closeAndPrintFunc(TAG, "doneProblems");
//            this.profiler.closeAndPrintFunc(TAG, "createProxy");
//            LogWrapper.m2793d(TAG, "LearningManager.init problems " + createProblemProxies.size() + ", done " + hashMap.size());
//            this.profiler.openFunc(TAG, "lm.init");
//            learningManager.init(createProblemProxies, hashMap);
//            this.profiler.closeAndPrintFunc(TAG, "lm.init");
//            return learningManager;
//        }
//        LogWrapper.m2795i(TAG, "loadLeaningManager skip");
//        return learningManager;
//    }
//
//    private void setLearningManagerMode(LearningManager learningManager) {
//        this.profiler.openFunc(TAG, "setLearningManagerMode");
//        learningManager.setSequenceModeNewAndReview(this.manager.getTodayNewCount(), ConstantsUtil.NEW_AND_REVIEW_EXTRA_ARGS);
//        learningManager.setTypeModeLearning(null);
//        LogWrapper.m2795i(TAG, "try setSequenceModeNewAndReview " + this.manager.getTodayNewCount() + ", getNewLearningCount " + learningManager.getSequenceStrategy().getNewLearningCount() + ", getReviewCount " + learningManager.getSequenceStrategy().getReviewCount());
//        this.profiler.closeAndPrintFunc(TAG, "setLearningManagerMode");
//    }
//
//    private void notifyProgress(String str) {
//        if (this.handler != null) {
//            this.handler.sendMessage(this.handler.obtainMessage(1, 0, 0, str));
//        }
//    }
//}
