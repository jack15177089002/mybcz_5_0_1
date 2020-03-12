//package com.baicizhan.main.selftest.strategy;
//
//import android.content.Context;
//import android.os.AsyncTask;
//import com.baicizhan.client.business.dataset.helpers.KVHelper;
//import com.baicizhan.client.business.dataset.models.TopicLearnRecord;
//import com.baicizhan.client.business.managers.LearnRecordManager;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.google.gson.Gson;//import com.p020b.p021a.Gson;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.List;
//
//public class SelfTestStrategy {
//    private static final int TOKEN_GET = 0;
//    private static final int TOKEN_RESET_ALL = 3;
//    private static final int TOKEN_RESET_TODAY = 2;
//    private static final int TOKEN_SAVE = 1;
//    /* access modifiers changed from: private */
//    public WeakReference<Context> mContext;
//    private boolean mHasToday = false;
//    /* access modifiers changed from: private */
//    public List<TopicLearnRecord> mRecordsToTest;
//    /* access modifiers changed from: private */
//    public OnSelftTestInitListener mSelfTestInitListener;
//
//    public interface OnSelftTestInitListener {
//        void onSelfTestInit(Result result);
//
//        void onSelfTestReset(Result result);
//    }
//
//    class Params {
//        int bookId;
//        List<Integer> ids;
//        int token;
//
//        private Params() {
//        }
//    }
//
//    public class Result {
//        public boolean hasToday;
//        public List<Integer> ids;
//        public boolean today;
//    }
//
//    class TestAccessTask extends AsyncTask<Params, Void, Params> {
//        private TestAccessTask() {
//        }
//
//        /* access modifiers changed from: protected */
//        public Params doInBackground(Params... paramsArr) {
//            Context context = (Context) SelfTestStrategy.this.mContext.get();
//            if (context == null) {
//                return null;
//            }
//            Params params = paramsArr[0];
//            switch (params.token) {
//                case 0:
//                    params.ids = SelfTestStrategy.getTestedIds(context, params.bookId);
//                    break;
//                case 1:
//                    SelfTestStrategy.saveTestedIds(context, params.bookId, params.ids);
//                    break;
//                case 2:
//                    SelfTestStrategy.resest(context, params, true);
//                    break;
//                case 3:
//                    SelfTestStrategy.resest(context, params, false);
//                    break;
//            }
//            return params;
//        }
//
//        /* access modifiers changed from: protected */
//        public void onPostExecute(Params params) {
//            if (params != null) {
//                switch (params.token) {
//                    case 0:
//                        if (SelfTestStrategy.this.mSelfTestInitListener != null) {
//                            SelfTestStrategy.this.mSelfTestInitListener.onSelfTestInit(SelfTestStrategy.this.filterRecordsToTest(params.ids));
//                            return;
//                        }
//                        return;
//                    case 2:
//                    case 3:
//                        if (SelfTestStrategy.this.mSelfTestInitListener != null) {
//                            SelfTestStrategy.this.mRecordsToTest = SelfTestStrategy.getAllTestableRecords();
//                            SelfTestStrategy.this.mSelfTestInitListener.onSelfTestReset(SelfTestStrategy.this.filterRecordsToTest(params.ids));
//                            return;
//                        }
//                        return;
//                    default:
//                        return;
//                }
//            }
//        }
//    }
//
//    private SelfTestStrategy(Context context) {
//        this.mContext = new WeakReference<>(context);
//        this.mRecordsToTest = getAllTestableRecords();
//        for (TopicLearnRecord topicLearnRecord : this.mRecordsToTest) {
//            if (1 == topicLearnRecord.isTodayNew) {
//                this.mHasToday = true;
//                return;
//            }
//        }
//    }
//
//    public static SelfTestStrategy born(Context context) {
//        return new SelfTestStrategy(context);
//    }
//
//    public SelfTestStrategy setInitListener(OnSelftTestInitListener onSelftTestInitListener) {
//        this.mSelfTestInitListener = onSelftTestInitListener;
//        return this;
//    }
//
//    public void init() {
//        if (this.mRecordsToTest != null && !this.mRecordsToTest.isEmpty()) {
//            Params params = new Params();
//            params.token = 0;
//            params.bookId = StudyManager.getInstance().getCurrentBookId();
//            new TestAccessTask().execute(new Params[]{params});
//        } else if (this.mSelfTestInitListener != null) {
//            this.mSelfTestInitListener.onSelfTestInit(null);
//        }
//    }
//
//    public Result save(List<Integer> list) {
//        Params params = new Params();
//        params.token = 1;
//        params.bookId = StudyManager.getInstance().getCurrentBookId();
//        params.ids = list;
//        new TestAccessTask().execute(new Params[]{params});
//        return filterRecordsToTest(list);
//    }
//
//    public boolean hasHistory() {
//        if (this.mRecordsToTest == null) {
//            return false;
//        }
//        for (TopicLearnRecord topicLearnRecord : this.mRecordsToTest) {
//            if (topicLearnRecord.isTodayNew == 0) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void resetToday(List<Integer> list) {
//        doReset(list, 2);
//    }
//
//    public void resetAll(List<Integer> list) {
//        doReset(list, 3);
//    }
//
//    private void doReset(List<Integer> list, int i) {
//        if (i == 3 || i == 2) {
//            Params params = new Params();
//            params.token = i;
//            params.bookId = StudyManager.getInstance().getCurrentBookId();
//            params.ids = list;
//            new TestAccessTask().execute(new Params[]{params});
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public static void resest(Context context, Params params, boolean z) {
//        HashSet hashSet;
//        List testedIds = getTestedIds(context, params.bookId);
//        if (testedIds != null) {
//            hashSet = new HashSet(testedIds);
//        } else {
//            hashSet = new HashSet();
//        }
//        if (params.ids != null) {
//            hashSet.addAll(params.ids);
//        }
//        ArrayList arrayList = new ArrayList();
//        for (TopicLearnRecord topicLearnRecord : getAllTestableRecords()) {
//            if (z && hashSet.contains(Integer.valueOf(topicLearnRecord.topicId)) && topicLearnRecord.isTodayNew == 0) {
//                arrayList.add(Integer.valueOf(topicLearnRecord.topicId));
//            }
//        }
//        clearTestedIds(context, params.bookId);
//        saveTestedIds(context, params.bookId, arrayList);
//        params.ids = arrayList;
//    }
//
//    /* access modifiers changed from: private */
//    public Result filterRecordsToTest(List<Integer> list) {
//        HashSet hashSet;
//        if (this.mRecordsToTest == null) {
//            return null;
//        }
//        if (list != null) {
//            hashSet = new HashSet(list);
//        } else {
//            hashSet = new HashSet();
//        }
//        ArrayList arrayList = new ArrayList();
//        ArrayList arrayList2 = new ArrayList();
//        ArrayList arrayList3 = new ArrayList();
//        for (TopicLearnRecord topicLearnRecord : this.mRecordsToTest) {
//            if (!hashSet.contains(Integer.valueOf(topicLearnRecord.topicId))) {
//                if (topicLearnRecord.isTodayNew == 0) {
//                    arrayList2.add(Integer.valueOf(topicLearnRecord.topicId));
//                } else {
//                    arrayList.add(Integer.valueOf(topicLearnRecord.topicId));
//                }
//                arrayList3.add(topicLearnRecord);
//            }
//        }
//        this.mRecordsToTest = arrayList3;
//        Result result = new Result();
//        if (!arrayList.isEmpty()) {
//            result.today = true;
//            result.ids = arrayList;
//        } else {
//            result.today = false;
//            result.ids = arrayList2;
//        }
//        result.hasToday = this.mHasToday;
//        return result;
//    }
//
//    /* access modifiers changed from: private */
//    public static List<TopicLearnRecord> getAllTestableRecords() {
//        Collection<TopicLearnRecord> allLearnRecords = LearnRecordManager.getInstance().getAllLearnRecords();
//        ArrayList arrayList = new ArrayList();
//        for (TopicLearnRecord topicLearnRecord : allLearnRecords) {
//            if (!topicLearnRecord.isKilled()) {
//                arrayList.add(topicLearnRecord);
//            }
//        }
//        return arrayList;
//    }
//
//    /* access modifiers changed from: private */
//    public static void saveTestedIds(Context context, int i, List<Integer> list) {
//        if (list != null && !list.isEmpty() && i > 0) {
//            List testedIds = getTestedIds(context, i);
//            if (testedIds != null) {
//                list.addAll(testedIds);
//            }
//            KVHelper.setString(context, KVHelper.getSubKey(KVHelper.KEY_USER_SELFTEST, Integer.toString(i)), new Gson().mo3213a((Object) list, new TypeToken<List<Integer>>() {
//            }.getType()), false);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public static List<Integer> getTestedIds(Context context, int i) {
//        if (i <= 0) {
//            return null;
//        }
//        return (List) new Gson().fromJson(KVHelper.getString(context, KVHelper.getSubKey(KVHelper.KEY_USER_SELFTEST, Integer.toString(i)), false), new TypeToken<List<Integer>>() {
//        }.getType());
//    }
//
//    private static void clearTestedIds(Context context, int i) {
//        if (i > 0) {
//            KVHelper.deleteKey(context, KVHelper.getSubKey(KVHelper.KEY_USER_SELFTEST, Integer.toString(i)));
//        }
//    }
//}
