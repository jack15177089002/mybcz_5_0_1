package com.baicizhan.client.business.managers;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.baicizhan.client.business.dataset.models.RoadmapRecord;
import com.baicizhan.client.business.download_service.QiniuResourceDownloader;
import com.baicizhan.client.business.thrift.BaicizhanCookieInflator;
import com.baicizhan.client.business.thrift.BaicizhanThrifts;
import com.baicizhan.client.business.util.LogWrapper;
import com.baicizhan.client.business.util.StoragePathDetector;
//import com.baicizhan.client.business.dataset.models.BookRecord;
//import com.baicizhan.client.business.dataset.models.OfflineStateRecord;
//import com.baicizhan.client.business.dataset.models.ScheduleRecord;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.learning_strategy.bean.ProblemProxy;
//import com.baicizhan.learning_strategy.core.StringLoader;
//import com.baicizhan.learning_strategy.iface.LearningManager;
//import com.baicizhan.learning_strategy.iface.ObjectCreator;
//import com.baicizhan.learning_strategy.impl.ObjectCreatorProxy;
//import com.baicizhan.online.bs_users.BBCheckInfo;
//import com.baicizhan.online.bs_users.BBUserLimit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StudyManager {
    public static final int REQUEST_REFRESH_LEARNING_MANAGER = 4;
    public static final int REQUEST_REFRESH_LEARNING_MODE = 8;
    public static final int REQUEST_REFRESH_SCHEDULE = 1;
    private static final String TAG = StudyManager.class.getSimpleName();
    private static StudyManager sInstance = null;
//    private BBCheckInfo mCheckInfo = null;
//    private BookRecord mCurrentBook;
//    private OfflineStateRecord mCurrentOfflineState;
    private Map<Integer, RoadmapRecord> mCurrentRoadmap = Collections.emptyMap();
//    private ScheduleRecord mCurrentSchedule;
    private boolean mIsOfflined;
//    private LearningManager mLearningManager;
//    private ObjectCreator mProblemProxyCreator;
//    private Map<Integer, ProblemProxy> mProblemProxyMap = new ConcurrentHashMap();
    private int mRefreshRequestFlag;
    private List<Integer> mRoadmapOrder = Collections.emptyList();
    private int mTodayNewCount;
    private Map<Integer, String> mUpdateMD5 = Collections.emptyMap();
//    private volatile UserRecord mUser;
//    private BBUserLimit mUserLimit = null;

    public static StudyManager getInstance() {
        if (sInstance == null) {
            synchronized (StudyManager.class) {
                if (sInstance == null) {
                    sInstance = new StudyManager();
                }
            }
        }
        return sInstance;
    }

    private StudyManager() {
    }

    public boolean isAlive() {
//        return this.mLearningManager != null;

        return false;
    }

    public boolean checkRestart(Activity activity) {
        if (getInstance().isAlive()) {
            return false;
        }
        LogWrapper.m2795i(TAG, "checkRestart " + activity.getComponentName());
        Intent intent = new Intent();
        intent.setClassName(StoragePathDetector.PACKAGE_NAME, "com.baicizhan.main.activity.MainTabActivity");
        intent.setFlags(268468224);
        activity.startActivity(intent);
        activity.finish();
        return true;
    }

    public boolean isOfflined() {
        return this.mIsOfflined;
    }

    public void setIsOfflined(boolean z) {
        this.mIsOfflined = z;
    }

//    public BBCheckInfo getCheckInfo() {
//        return this.mCheckInfo;
//    }

//    public void setCheckInfo(BBCheckInfo bBCheckInfo) {
//        this.mCheckInfo = bBCheckInfo;
//        if (bBCheckInfo != null) {
//            BaicizhanThrifts.updateServiceUrl(bBCheckInfo.getData_dns(), bBCheckInfo.getOther_data_dns());
//            QiniuResourceDownloader.setDns(bBCheckInfo.getRes_dns(), bBCheckInfo.getOther_res_dns());
//        }
//    }

//    public UserRecord getCurrentUser() {
//        return this.mUser;
//    }

//    public void setCurrentUser(UserRecord userRecord) {
//        this.mUser = userRecord;
//        if (!TextUtils.isEmpty(this.mUser.getToken())) {
//            BaicizhanThrifts.getProxy().putCookie(BaicizhanCookieInflator.ACCESS_TOKEN, userRecord.getToken());
//        }
//    }

    public int getTodayNewCount() {
        return this.mTodayNewCount;
    }

    public void setTodayNewCount(int i) {
        this.mTodayNewCount = i;
    }

//    public boolean hasValidSchedule() {
//        return (this.mCurrentBook == null || this.mCurrentSchedule == null) ? false : true;
//    }
//
//    public ScheduleRecord getCurrentSchedule() {
//        return this.mCurrentSchedule;
//    }
//
//    public void setCurrentSchedule(ScheduleRecord scheduleRecord) {
//        this.mCurrentSchedule = scheduleRecord;
//    }
//
//    public int getCurrentBookId() {
//        if (this.mCurrentSchedule != null) {
//            return this.mCurrentSchedule.bookId;
//        }
//        return 0;
//    }
//
//    public BookRecord getCurrentBook() {
//        return this.mCurrentBook;
//    }
//
//    public void setCurrentBook(BookRecord bookRecord) {
//        this.mCurrentBook = bookRecord;
//    }
//
//    public OfflineStateRecord getCurrentOfflineState() {
//        return this.mCurrentOfflineState;
//    }
//
//    public void setCurrentOfflineState(OfflineStateRecord offlineStateRecord) {
//        this.mCurrentOfflineState = offlineStateRecord;
//    }

//    public BBUserLimit getUserLimit() {
//        return this.mUserLimit;
//    }

//    public void setUserLimit(BBUserLimit bBUserLimit) {
//        this.mUserLimit = bBUserLimit;
//    }

    public int[] getTopicOptionsById(int i) {
        RoadmapRecord roadmapRecord = (RoadmapRecord) this.mCurrentRoadmap.get(Integer.valueOf(i));
        if (roadmapRecord != null) {
            return roadmapRecord.options;
        }
        return null;
    }

    public boolean isInRoadmap(int i) {
        return this.mCurrentRoadmap.containsKey(Integer.valueOf(i));
    }

    public int getRoadmapSize() {
        return this.mRoadmapOrder.size();
    }

    public Map<Integer, RoadmapRecord> getCurrentRoadmap() {
        return this.mCurrentRoadmap;
    }

    public List<Integer> getRoadmapOrder() {
        return this.mRoadmapOrder;
    }

    public String getTopicUpdateFlagMD5(int i) {
        if (this.mUpdateMD5 == null || this.mUpdateMD5.size() == 0) {
            return null;
        }
        return (String) this.mUpdateMD5.get(Integer.valueOf(i));
    }

    public boolean hasValidTopicUpdateInfos() {
        return this.mUpdateMD5.size() > 0 && this.mUpdateMD5.size() == this.mRoadmapOrder.size();
    }

    public void setBookUpdateFlagMD5(Map<Integer, String> map) {
        this.mUpdateMD5 = map;
    }

    public void setCurrentRoadmap(List<RoadmapRecord> list) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList(list.size());
        for (RoadmapRecord roadmapRecord : list) {
            hashMap.put(Integer.valueOf(roadmapRecord.f2231id), roadmapRecord);
            arrayList.add(Integer.valueOf(roadmapRecord.f2231id));
        }
        this.mRoadmapOrder = arrayList;
        this.mCurrentRoadmap = hashMap;
    }

    public void setRoadmapOrder(List<Integer> list) {
        this.mRoadmapOrder = list;
    }

//    public LearningManager getLearningManager() {
//        return this.mLearningManager;
//    }
//
//    public boolean loadLearningManager(String str) {
//        if (this.mLearningManager != null) {
//            return true;
//        }
//        this.mLearningManager = new StringLoader(str).load();
//        if (this.mLearningManager == null) {
//            LogWrapper.m2794e("StudyManager", "loadLearningManager failed");
//            return false;
//        }
//        try {
//            this.mProblemProxyCreator = new ObjectCreatorProxy();
//            return true;
//        } catch (Exception e) {
//            this.mProblemProxyCreator = null;
//            return true;
//        }
//    }

//    public List<ProblemProxy> createProblemProxies(int i) {
//        return this.mProblemProxyCreator.createProblems(i);
//    }
//
//    public Map<Integer, ProblemProxy> getProblemProxyMap() {
//        return this.mProblemProxyMap;
//    }

    public synchronized void clearPersonalData() {
//        this.mUser = null;
//        this.mCheckInfo = null;
//        this.mUserLimit = null;
//        BookListManager.getInstance().clear();
        clearCurrentScheduleData();
    }

    public synchronized void clearCurrentScheduleData() {
        LogWrapper.m2793d("StudyManager", "clearCurrentScheduleData");
        this.mTodayNewCount = 0;
//        this.mCurrentBook = null;
//        this.mCurrentSchedule = null;
//        this.mCurrentOfflineState = null;
        this.mCurrentRoadmap = Collections.emptyMap();
        this.mRoadmapOrder = Collections.emptyList();
        this.mUpdateMD5 = Collections.emptyMap();
//        LearnRecordManager.getInstance().clear();
    }

    public synchronized int takeRefreshRequestFlag() {
        int i;
        i = this.mRefreshRequestFlag;
        this.mRefreshRequestFlag = 0;
        return i;
    }

    public synchronized void addRefreshRequestFlag(int i) {
        this.mRefreshRequestFlag |= i;
    }
}
