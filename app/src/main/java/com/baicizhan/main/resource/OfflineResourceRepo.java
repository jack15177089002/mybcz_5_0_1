//package com.baicizhan.main.resource;
//
//import android.content.Context;
//import android.os.AsyncTask;
//import android.os.Build.VERSION;
//import com.baicizhan.client.business.download_service.AbstractDownloadTask;
//import com.baicizhan.client.business.download_service.AbstractDownloadTask.Listener;
//import com.baicizhan.client.business.download_service.ChannelPriority;
//import com.baicizhan.client.business.download_service.DownloadService;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.thrift.ThriftRequest;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.online.bs_words.BBWordPackage;
//import com.baicizhan.online.bs_words.BSWords.Client;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class OfflineResourceRepo {
//    private static final float DEFAULT_ZPK_SIZE = 0.05f;
//    private static final int MAX_PROGRESS = 100;
//    private static final float MEGA_BYTES = 1048576.0f;
//    /* access modifiers changed from: private */
//    public static final String TAG = OfflineResourceRepo.class.getSimpleName();
//    /* access modifiers changed from: private */
//    public int mBookId;
//    private AsyncTask<Void, Void, List<Integer>> mCheckMediaTask = null;
//    private AsyncTask<Void, Void, List<Integer>> mCheckTextTask = null;
//    /* access modifiers changed from: private */
//    public Context mContext;
//    /* access modifiers changed from: private */
//    public DLState mDLState;
//    /* access modifiers changed from: private */
//    public AtomicInteger mDoneProgress = new AtomicInteger(0);
//    private float mMeanSize = 0.0f;
//    /* access modifiers changed from: private */
//    public List<Integer> mMediaAbsents = Collections.emptyList();
//    /* access modifiers changed from: private */
//    public OfflineResourceListener mOfflineResourceListener;
//    /* access modifiers changed from: private */
//    public List<AbstractDownloadTask> mPendingTasks = Collections.synchronizedList(new ArrayList());
//    /* access modifiers changed from: private */
//    public RepoState mRepoState;
//    /* access modifiers changed from: private */
//    public AtomicInteger mRunningTaskCount = new AtomicInteger(0);
//    /* access modifiers changed from: private */
//    public List<Integer> mTextAbsents = Collections.emptyList();
//    Listener mTopicDownloadTask = new Listener() {
//        public void onSuccess(AbstractDownloadTask abstractDownloadTask) {
//            TopicDownloadTask topicDownloadTask = (TopicDownloadTask) abstractDownloadTask;
//            if (topicDownloadTask.getBookId() != OfflineResourceRepo.this.mBookId) {
//                LogWrapper.m2797w(OfflineResourceRepo.TAG, "pack download success with conflict book " + topicDownloadTask.getBookId() + ", current " + OfflineResourceRepo.this.mBookId);
//                return;
//            }
//            OfflineResourceRepo.this.mDoneProgress.addAndGet(1);
//            if (!(OfflineResourceRepo.this.mOfflineResourceListener == null || OfflineResourceRepo.this.mDLState == DLState.STATE_PAUSE)) {
//                OfflineResourceRepo.this.mOfflineResourceListener.onStateChanged(OfflineResourceRepo.this);
//            }
//            if (OfflineResourceRepo.this.mRunningTaskCount.decrementAndGet() != 0) {
//                return;
//            }
//            if (OfflineResourceRepo.this.mPendingTasks.size() > 0) {
//                OfflineResourceRepo.this.setDLState(DLState.STATE_FAIL);
//                return;
//            }
//            if (OfflineResourceRepo.this.mRepoState == RepoState.STATE_TEXT_INCOMPLETE) {
//                OfflineResourceRepo.this.setRepoState(RepoState.STATE_TEXT_COMPLETED);
//                OfflineResourceRepo.this.checkResComplete();
//            } else {
//                OfflineResourceRepo.this.setRepoState(RepoState.STATE_RES_COMPLETED);
//            }
//            OfflineResourceRepo.this.setDLState(DLState.STATE_FINISH);
//        }
//
//        public void onError(AbstractDownloadTask abstractDownloadTask, Throwable th) {
//            OfflineResourceRepo.this.mPendingTasks.add(abstractDownloadTask);
//            if (OfflineResourceRepo.this.mRunningTaskCount.decrementAndGet() == 0) {
//                OfflineResourceRepo.this.setDLState(DLState.STATE_FAIL);
//            }
//        }
//    };
//    private AtomicInteger mTotalProgress = new AtomicInteger(0);
//    private float mTotalSize = 0.0f;
//    private AsyncTask<Void, Void, Void> mUpdateFlagMD5CompatTask = null;
//    /* access modifiers changed from: private */
//    public final Map<Integer, BBWordPackage> mWordPackages = new HashMap();
//
//    public enum DLState {
//        STATE_INIT,
//        STATE_PREPARE,
//        STATE_RUNNING,
//        STATE_PAUSE,
//        STATE_FAIL,
//        STATE_FINISH
//    }
//
//    public interface OfflineResourceListener {
//        void onError(String str);
//
//        void onStateChanged(OfflineResourceRepo offlineResourceRepo);
//    }
//
//    public enum RepoState {
//        STATE_INIT,
//        STATE_TEXT_INCOMPLETE,
//        STATE_TEXT_COMPLETED,
//        STATE_MEDIA_INCOMPLETE,
//        STATE_RES_COMPLETED
//    }
//
//    public RepoState getRepoState() {
//        return this.mRepoState;
//    }
//
//    /* access modifiers changed from: private */
//    public void setRepoState(RepoState repoState) {
//        LogWrapper.m2793d(TAG, "setRepoState " + repoState);
//        this.mRepoState = repoState;
//        if (this.mOfflineResourceListener != null) {
//            this.mOfflineResourceListener.onStateChanged(this);
//        }
//    }
//
//    public DLState getDLState() {
//        return this.mDLState;
//    }
//
//    public void setDLState(DLState dLState) {
//        LogWrapper.m2793d(TAG, "setDLState " + dLState);
//        this.mDLState = dLState;
//        if (this.mOfflineResourceListener != null) {
//            this.mOfflineResourceListener.onStateChanged(this);
//        }
//    }
//
//    public void setOfflineResourceListener(OfflineResourceListener offlineResourceListener) {
//        this.mOfflineResourceListener = offlineResourceListener;
//    }
//
//    public BBWordPackage getWordPackage(int i) {
//        return (BBWordPackage) this.mWordPackages.get(Integer.valueOf(i));
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void reInit(Context context, int i) {
//        this.mContext = context;
//        this.mBookId = i;
//        this.mRepoState = RepoState.STATE_INIT;
//        this.mDLState = DLState.STATE_INIT;
//        this.mWordPackages.clear();
//        this.mTextAbsents.clear();
//        this.mMediaAbsents.clear();
//        this.mTotalProgress.set(0);
//        this.mDoneProgress.set(0);
//        this.mRunningTaskCount.set(0);
//        this.mPendingTasks.clear();
//        checkText();
//    }
//
//    private void checkText() {
//        setRepoState(RepoState.STATE_INIT);
//        if (this.mCheckTextTask != null) {
//            this.mCheckTextTask.cancel(true);
//        }
//        this.mCheckTextTask = new AsyncTask<Void, Void, List<Integer>>() {
//            /* access modifiers changed from: protected */
//            public List<Integer> doInBackground(Void... voidArr) {
//                TopicUpdateFlagMD5Loader.load(OfflineResourceRepo.this.mContext);
//                new TopicResourceTableDivider(OfflineResourceRepo.this.mContext, OfflineResourceRepo.this.mBookId).transfer();
//                return TopicResourceChecker.queryTextAbsentTopics(OfflineResourceRepo.this.mContext, OfflineResourceRepo.this.mBookId);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onPostExecute(List<Integer> list) {
//                super.onPostExecute(list);
//                OfflineResourceRepo.this.mTextAbsents = list;
//                if (OfflineResourceRepo.this.mTextAbsents.size() == 0) {
//                    OfflineResourceRepo.this.setRepoState(RepoState.STATE_TEXT_COMPLETED);
//                    OfflineResourceRepo.this.checkResComplete();
//                } else {
//                    OfflineResourceRepo.this.setRepoState(RepoState.STATE_TEXT_INCOMPLETE);
//                }
//                OfflineResourceRepo.this.updateFlagMD5Compat();
//            }
//        };
//        if (VERSION.SDK_INT >= 11) {
//            this.mCheckTextTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
//        } else {
//            this.mCheckTextTask.execute(new Void[0]);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void updateFlagMD5Compat() {
//        if (this.mUpdateFlagMD5CompatTask != null) {
//            this.mUpdateFlagMD5CompatTask.cancel(true);
//        }
//        this.mUpdateFlagMD5CompatTask = new AsyncTask<Void, Void, Void>() {
//            /* access modifiers changed from: protected */
//            public Void doInBackground(Void... voidArr) {
//                TopicUpdateFlagMD5Loader.compat(OfflineResourceRepo.this.mContext);
//                return null;
//            }
//        };
//        if (VERSION.SDK_INT >= 11) {
//            this.mUpdateFlagMD5CompatTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
//        } else {
//            this.mUpdateFlagMD5CompatTask.execute(new Void[0]);
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void checkResComplete() {
//        if (this.mCheckMediaTask != null) {
//            this.mCheckMediaTask.cancel(true);
//        }
//        LogWrapper.m2793d(TAG, "checkResComplete");
//        this.mCheckMediaTask = new AsyncTask<Void, Void, List<Integer>>() {
//            /* access modifiers changed from: protected */
//            public List<Integer> doInBackground(Void... voidArr) {
//                return TopicResourceChecker.queryMediaAbsentTopics(OfflineResourceRepo.this.mContext, OfflineResourceRepo.this.mBookId);
//            }
//
//            /* access modifiers changed from: protected */
//            public void onPostExecute(List<Integer> list) {
//                super.onPostExecute(list);
//                OfflineResourceRepo.this.mMediaAbsents = list;
//                if (OfflineResourceRepo.this.mMediaAbsents.size() == 0) {
//                    OfflineResourceRepo.this.setRepoState(RepoState.STATE_RES_COMPLETED);
//                    return;
//                }
//                LogWrapper.m2795i(OfflineResourceRepo.TAG, "media missed " + OfflineResourceRepo.this.mMediaAbsents.size());
//                OfflineResourceRepo.this.setRepoState(RepoState.STATE_MEDIA_INCOMPLETE);
//            }
//        };
//        if (VERSION.SDK_INT >= 11) {
//            this.mCheckMediaTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
//        } else {
//            this.mCheckMediaTask.execute(new Void[0]);
//        }
//    }
//
//    public void resumeOfflineDownload() {
//        DownloadService.getInstance().adjustPoolSize(4);
//        if (this.mRepoState == RepoState.STATE_TEXT_INCOMPLETE) {
//            switch (this.mDLState) {
//                case STATE_INIT:
//                    prepareBatchDownload();
//                    return;
//                case STATE_PAUSE:
//                case STATE_FAIL:
//                    DownloadService.getInstance().resume(ChannelPriority.LOW);
//                    this.mRunningTaskCount.addAndGet(this.mPendingTasks.size());
//                    for (AbstractDownloadTask add : this.mPendingTasks) {
//                        DownloadService.getInstance().add(ChannelPriority.LOW, add);
//                    }
//                    this.mPendingTasks.clear();
//                    setDLState(DLState.STATE_RUNNING);
//                    return;
//                default:
//                    return;
//            }
//        } else if (this.mRepoState == RepoState.STATE_MEDIA_INCOMPLETE) {
//            switch (this.mDLState) {
//                case STATE_INIT:
//                    prepareSyncing();
//                    return;
//                case STATE_PAUSE:
//                case STATE_FAIL:
//                    DownloadService.getInstance().resume(ChannelPriority.LOW);
//                    this.mRunningTaskCount.addAndGet(this.mPendingTasks.size());
//                    for (AbstractDownloadTask add2 : this.mPendingTasks) {
//                        DownloadService.getInstance().add(ChannelPriority.LOW, add2);
//                    }
//                    this.mPendingTasks.clear();
//                    setDLState(DLState.STATE_RUNNING);
//                    return;
//                default:
//                    return;
//            }
//        }
//    }
//
//    public void pauseOfflineDownload() {
//        setDLState(DLState.STATE_PAUSE);
//        DownloadService.getInstance().pause(ChannelPriority.LOW);
//    }
//
//    public int getCurrentProgress() {
//        int i = this.mTotalProgress.get();
//        int i2 = this.mDoneProgress.get();
//        if (i == 0 || i2 >= i) {
//            return 100;
//        }
//        return (i2 * 100) / i;
//    }
//
//    public float getTotalSize() {
//        return this.mTotalSize;
//    }
//
//    public float getCurrentProgressSize() {
//        return this.mMeanSize * ((float) this.mDoneProgress.get());
//    }
//
//    private void prepareDownload(List<Integer> list) {
//        ArrayList arrayList;
//        setDLState(DLState.STATE_PREPARE);
//        BaicizhanThrifts.getProxy().cancelAllWithTag(TAG);
//        if (this.mWordPackages.size() == 0) {
//            arrayList = new ArrayList(list);
//        } else {
//            ArrayList arrayList2 = new ArrayList();
//            for (Integer intValue : list) {
//                int intValue2 = intValue.intValue();
//                if (!this.mWordPackages.containsKey(Integer.valueOf(intValue2))) {
//                    arrayList2.add(Integer.valueOf(intValue2));
//                }
//            }
//            arrayList = arrayList2;
//        }
//        final int currentBookId = StudyManager.getInstance().getCurrentBookId();
//        if (arrayList.size() > 0) {
//            final AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
//            int i = 0;
//            while (i < arrayList.size()) {
//                int min = Math.min(arrayList.size(), i + 500);
//                final List subList = arrayList.subList(i, min);
//                final List<Integer> list2 = list;
//                C11874 r0 = new ThriftRequest<Client, List<BBWordPackage>>(BaicizhanThrifts.WORDS) {
//                    /* access modifiers changed from: protected */
//                    public List<BBWordPackage> doInBackground(Client client) {
//                        return client.get_word_package(subList, currentBookId);
//                    }
//
//                    /* access modifiers changed from: protected */
//                    public void onError(Exception exc) {
//                        if (OfflineResourceRepo.this.mOfflineResourceListener != null && OfflineResourceRepo.this.mDLState == DLState.STATE_PREPARE) {
//                            OfflineResourceRepo.this.mOfflineResourceListener.onError("获取单词包下载列表失败，请检查您的网络");
//                            OfflineResourceRepo.this.setDLState(DLState.STATE_INIT);
//                        }
//                    }
//
//                    /* access modifiers changed from: protected */
//                    public void onResult(List<BBWordPackage> list) {
//                        synchronized (OfflineResourceRepo.this.mWordPackages) {
//                            for (BBWordPackage bBWordPackage : list) {
//                                OfflineResourceRepo.this.mWordPackages.put(Integer.valueOf(bBWordPackage.getTopic_id()), bBWordPackage);
//                            }
//                        }
//                        if (atomicInteger.addAndGet(-list.size()) == 0) {
//                            LogWrapper.m2796v(OfflineResourceRepo.TAG, "lanchDownload");
//                            OfflineResourceRepo.this.launchDownload(list2);
//                            OfflineResourceRepo.this.setDLState(DLState.STATE_RUNNING);
//                        }
//                    }
//                };
//                r0.setTag(TAG);
//                BaicizhanThrifts.getProxy().add(r0);
//                i = min;
//            }
//            return;
//        }
//        launchDownload(list);
//    }
//
//    /* access modifiers changed from: private */
//    public void launchDownload(List<Integer> list) {
//        float f;
//        this.mPendingTasks.clear();
//        this.mRunningTaskCount.set(list.size());
//        float f2 = 0.0f;
//        for (Integer intValue : list) {
//            int intValue2 = intValue.intValue();
//            BBWordPackage bBWordPackage = (BBWordPackage) this.mWordPackages.get(Integer.valueOf(intValue2));
//            if (bBWordPackage != null) {
//                f = (float) bBWordPackage.getZpk_size();
//            } else {
//                f = 0.0f;
//            }
//            float f3 = f + f2;
//            launchTopicDownloadTask(intValue2);
//            f2 = f3;
//        }
//        this.mMeanSize = f2 > 0.0f ? (f2 / ((float) list.size())) / MEGA_BYTES : DEFAULT_ZPK_SIZE;
//        this.mTotalSize = this.mMeanSize * ((float) this.mTotalProgress.get());
//    }
//
//    public void prepareBatchDownload() {
//        if (this.mDLState != DLState.STATE_PREPARE) {
//            this.mTotalProgress.set(StudyManager.getInstance().getRoadmapSize());
//            this.mDoneProgress.set(this.mTotalProgress.get() - this.mTextAbsents.size());
//            prepareDownload(this.mTextAbsents);
//        }
//    }
//
//    private void launchTopicDownloadTask(int i) {
//        TopicDownloadTask topicDownloadTask = new TopicDownloadTask(this.mBookId, i);
//        topicDownloadTask.randomizeInitialDnsIndex();
//        topicDownloadTask.setWordPackage((BBWordPackage) this.mWordPackages.get(Integer.valueOf(i)));
//        topicDownloadTask.setListener(this.mTopicDownloadTask);
//        DownloadService.getInstance().add(ChannelPriority.LOW, topicDownloadTask);
//    }
//
//    private void prepareSyncing() {
//        if (this.mDLState != DLState.STATE_PREPARE) {
//            this.mTotalProgress.set(this.mMediaAbsents.size());
//            this.mDoneProgress.set(0);
//            prepareDownload(this.mMediaAbsents);
//        }
//    }
//}
