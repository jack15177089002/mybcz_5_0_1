//package com.baicizhan.main.wordlist.view;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.helpers.MiscRecordHelper;
//import com.baicizhan.client.business.dataset.models.TopicBriefRecord;
//import com.baicizhan.client.business.dataset.models.TopicLearnRecord;
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.managers.LearnRecordManager;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.framework.asynctask.LAsyncTask;
//import com.baicizhan.client.framework.util.Common;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class WordListDataManager {
//    static final int LOAD_COUNT_PER_BULK = 10;
//    private static final int TASK_TYPE_INIT_DATA = 0;
//    private static final int TASK_TYPE_LOAD_DATA = 1;
//    /* access modifiers changed from: private */
//    public Context mContext;
//    /* access modifiers changed from: private */
//    public OnWordBulkLoadListener mListener;
//    /* access modifiers changed from: private */
//    public boolean mLoading = false;
//    private LoadTask mTask;
//    /* access modifiers changed from: private */
//    public int mType;
//
//    class LoadTask extends LAsyncTask<TaskParams, Void, TaskParams> {
//        final WeakReference<WordListDataManager> mMng;
//        final int mType;
//
//        LoadTask(WordListDataManager wordListDataManager, int i) {
//            this.mMng = new WeakReference<>(wordListDataManager);
//            this.mType = i;
//            setKey(Common.md5(WordListDataManager.class.getName()));
//            parallelTask(3);
//        }
//
//        /* access modifiers changed from: protected */
//        public void onPreExecute() {
//            WordListDataManager wordListDataManager = (WordListDataManager) this.mMng.get();
//            if (wordListDataManager != null) {
//                if (this.mType == 0) {
//                    if (wordListDataManager.mListener != null) {
//                        wordListDataManager.mListener.onStartInit();
//                    }
//                } else if (1 == this.mType) {
//                    wordListDataManager.mLoading = true;
//                    if (wordListDataManager.mListener != null) {
//                        wordListDataManager.mListener.onStartLoad();
//                    }
//                }
//            }
//        }
//
//        /* access modifiers changed from: protected */
//        public TaskParams doInBackground(TaskParams... taskParamsArr) {
//            WordListDataManager wordListDataManager = (WordListDataManager) this.mMng.get();
//            if (wordListDataManager == null) {
//                return null;
//            }
//            TaskParams taskParams = taskParamsArr[0];
//            if (this.mType == 0) {
//                return initData(wordListDataManager, taskParams);
//            }
//            if (1 == this.mType) {
//                return loadNextBulk(wordListDataManager, taskParams);
//            }
//            return null;
//        }
//
//        private TaskParams initData(WordListDataManager wordListDataManager, TaskParams taskParams) {
//            taskParams.allwords = WordListDataManager.getAllWords(wordListDataManager.mContext, wordListDataManager.mType);
//            return taskParams;
//        }
//
//        private TaskParams loadNextBulk(WordListDataManager wordListDataManager, TaskParams taskParams) {
//            int i;
//            try {
//                ArrayList arrayList = new ArrayList(taskParams.allwords.size());
//                ArrayList arrayList2 = new ArrayList(taskParams.allwords.subList(taskParams.startIndex, Math.min(10, taskParams.allwords.size() - taskParams.startIndex) + taskParams.startIndex));
//                int i2 = 0;
//                int i3 = 0;
//                while (i2 < arrayList2.size()) {
//                    int i4 = ((OrderedWord) arrayList2.get(i2)).topicId;
//                    Word word = new Word();
//                    word.baseInfo = MiscRecordHelper.getSyntheticTopicBriefRecord(wordListDataManager.mContext, StudyManager.getInstance().getCurrentBookId(), i4);
//                    if (word.baseInfo == null) {
//                        Log.d("whiz", "the word info loaded failed, topic id: " + i4);
//                        taskParams.allwords.remove((taskParams.startIndex + i2) - i3);
//                        i = i3 + 1;
//                    } else {
//                        word.errCount = ((OrderedWord) arrayList2.get(i2)).errCount;
//                        arrayList.add(word);
//                        i = i3;
//                    }
//                    i2++;
//                    i3 = i;
//                }
//                taskParams.words = arrayList;
//                return taskParams;
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//
//        /* access modifiers changed from: protected */
//        public void onPostExecute(TaskParams taskParams) {
//            WordListDataManager wordListDataManager = (WordListDataManager) this.mMng.get();
//            if (wordListDataManager != null) {
//                if (this.mType == 0) {
//                    if (wordListDataManager.mListener == null) {
//                        return;
//                    }
//                    if (taskParams != null) {
//                        wordListDataManager.mListener.onDataInited(taskParams.allwords);
//                    } else {
//                        wordListDataManager.mListener.onDataInited(null);
//                    }
//                } else if (1 == this.mType) {
//                    wordListDataManager.mLoading = false;
//                    if (wordListDataManager.mListener == null) {
//                        return;
//                    }
//                    if (taskParams != null) {
//                        wordListDataManager.mListener.onLoadComplete(taskParams.token, taskParams.words, taskParams.allwords);
//                    } else {
//                        wordListDataManager.mListener.onLoadComplete(-1, null, null);
//                    }
//                }
//            }
//        }
//    }
//
//    public interface OnWordBulkLoadListener {
//        void onDataInited(List<OrderedWord> list);
//
//        void onLoadComplete(int i, List<Word> list, List<OrderedWord> list2);
//
//        void onStartInit();
//
//        void onStartLoad();
//    }
//
//    public class OrderedWord implements Comparable<OrderedWord> {
//        int errCount;
//        int topicId;
//
//        public int compareTo(OrderedWord orderedWord) {
//            return orderedWord.errCount - this.errCount;
//        }
//    }
//
//    class TaskParams {
//        List<OrderedWord> allwords;
//        int startIndex;
//        int token;
//        List<Word> words;
//
//        private TaskParams() {
//        }
//    }
//
//    class Word {
//        TopicBriefRecord baseInfo;
//        int errCount;
//        boolean visible = false;
//
//        Word() {
//        }
//    }
//
//    private WordListDataManager() {
//    }
//
//    static WordListDataManager createInstance(Context context, int i, OnWordBulkLoadListener onWordBulkLoadListener) {
//        WordListDataManager wordListDataManager = new WordListDataManager();
//        wordListDataManager.mContext = context;
//        wordListDataManager.mType = i;
//        wordListDataManager.mListener = onWordBulkLoadListener;
//        return wordListDataManager;
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void destroy() {
//        if (this.mTask != null) {
//            this.mTask.cancel();
//        }
//        this.mContext = null;
//    }
//
//    /* access modifiers changed from: private */
//    public static List<OrderedWord> getAllWords(Context context, int i) {
//        ArrayList arrayList = new ArrayList();
//        switch (i) {
//            case 0:
//                initLearnt(context, arrayList);
//                break;
//            case 1:
//                initUnLearnt(context, arrayList);
//                break;
//            case 2:
//                initKilled(context, arrayList);
//                break;
//        }
//        return arrayList;
//    }
//
//    private static void initLearnt(Context context, List<OrderedWord> list) {
//        int i;
//        Map errCountMap = getErrCountMap(context, StudyManager.getInstance().getCurrentBookId(), 0);
//        LearnRecordManager instance = LearnRecordManager.getInstance();
//        for (TopicLearnRecord topicLearnRecord : instance.getAllLearnRecords()) {
//            if (!instance.isKilled(topicLearnRecord.topicId)) {
//                OrderedWord orderedWord = new OrderedWord();
//                orderedWord.topicId = topicLearnRecord.topicId;
//                if (errCountMap != null) {
//                    i = ((Integer) errCountMap.get(Integer.valueOf(topicLearnRecord.topicId))).intValue();
//                } else {
//                    i = 0;
//                }
//                orderedWord.errCount = i;
//                list.add(orderedWord);
//            }
//        }
//        Collections.sort(list);
//    }
//
//    private static void initUnLearnt(Context context, List<OrderedWord> list) {
//        LearnRecordManager instance = LearnRecordManager.getInstance();
//        StudyManager instance2 = StudyManager.getInstance();
//        Map totalTable = instance.getTotalTable();
//        for (Integer intValue : instance2.getRoadmapOrder()) {
//            int intValue2 = intValue.intValue();
//            if (!totalTable.containsKey(Integer.valueOf(intValue2))) {
//                OrderedWord orderedWord = new OrderedWord();
//                orderedWord.topicId = intValue2;
//                list.add(orderedWord);
//            }
//        }
//    }
//
//    private static void initKilled(Context context, List<OrderedWord> list) {
//        Map errCountMap = getErrCountMap(context, StudyManager.getInstance().getCurrentBookId(), 2);
//        LearnRecordManager instance = LearnRecordManager.getInstance();
//        for (TopicLearnRecord topicLearnRecord : instance.getAllLearnRecords()) {
//            if (instance.isKilled(topicLearnRecord.topicId)) {
//                OrderedWord orderedWord = new OrderedWord();
//                orderedWord.topicId = topicLearnRecord.topicId;
//                orderedWord.errCount = errCountMap != null ? ((Integer) errCountMap.get(Integer.valueOf(topicLearnRecord.topicId))).intValue() : 0;
//                list.add(orderedWord);
//            }
//        }
//        Collections.sort(list);
//    }
//
//    static Map<Integer, Integer> getErrCountMap(Context context, int i, int i2) {
//        HashMap hashMap = null;
//        if (1 != i2) {
//            StringBuilder sb = new StringBuilder("select distinct ");
//            sb.append("topic_id,err_num from ").append(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookTableName(i)).append(" ");
//            if (2 == i2) {
//                sb.append("where topic_obn<?");
//            } else {
//                sb.append("where topic_obn>=?");
//            }
//            Cursor perform = QueryBuilder.rawQuery(Databases.TOPIC_PROBLEM, sb.toString(), "0").perform(context);
//            if (perform != null) {
//                try {
//                    hashMap = new HashMap();
//                    while (perform.moveToNext()) {
//                        hashMap.put(Integer.valueOf(perform.getInt(0)), Integer.valueOf(perform.getInt(1)));
//                    }
//                } finally {
//                    perform.close();
//                }
//            }
//        }
//        return hashMap;
//    }
//
//    static void killWord(int i) {
//        LearnRecordManager.getInstance().kill(i, 0);
//    }
//
//    static void cancelKillWord(int i) {
//        StudyManager.getInstance().addRefreshRequestFlag(4);
//        LearnRecordManager.getInstance().cancelKill(i);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void initData() {
//        TaskParams taskParams = new TaskParams();
//        this.mTask = getTask(this, 0);
//        this.mTask.execute(taskParams);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void loadNextBulk(int i, int i2, List<OrderedWord> list) {
//        if ((list == null || i2 < 0 || i2 >= list.size()) && this.mListener != null) {
//            this.mListener.onLoadComplete(i, null, list);
//            return;
//        }
//        TaskParams taskParams = new TaskParams();
//        taskParams.token = i;
//        taskParams.startIndex = i2;
//        taskParams.allwords = list;
//        this.mTask = getTask(this, 1);
//        this.mTask.execute(taskParams);
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void cancelLoad() {
//        if (this.mTask != null) {
//            this.mTask.cancel();
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public boolean isLoading() {
//        return this.mLoading;
//    }
//
//    private LoadTask getTask(WordListDataManager wordListDataManager, int i) {
//        return new LoadTask(wordListDataManager, i);
//    }
//}
