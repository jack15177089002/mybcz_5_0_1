package com.baicizhan.client.framework.asynctask;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.SparseIntArray;
import com.baicizhan.client.framework.asynctask.LAsyncTaskParallel.LAsyncTaskParallelType;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LAsyncTaskExecutor implements Executor {
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 30;
    private static final int MAXIMUM_POOL_SIZE = 256;
    private static final int TASK_MAX_TIME = 180000;
    private static final int TASK_MAX_TIME_ID = 1;
    private static final int TASK_RUN_NEXT_ID = 2;
    public  final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 256, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory, new DiscardPolicy());
    private static LAsyncTaskExecutor sInstance = null;
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new SynchronousQueue();
    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            String str = "LAsyncTask #" + String.valueOf(this.mCount.getAndIncrement());
            if (LSwitcher.isOpened()) {
                C0789L.log.info(str);
            }
            return new Thread(runnable, str);
        }
    };
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                if (message.obj != null && (message.obj instanceof LAsyncTaskRunnable)) {
                    LAsyncTaskExecutor.this.taskTimeOut((LAsyncTaskRunnable) message.obj);
                }
            } else if (message.what == 2 && message.obj != null && (message.obj instanceof LAsyncTaskRunnable)) {
                LAsyncTaskExecutor.this.scheduleNext((LAsyncTaskRunnable) message.obj);
                if (LSwitcher.isOpened()) {
                    C0789L.log.debug(LAsyncTaskExecutor.this.toString());
                }
            }
        }
    };
    private final SparseIntArray mParallelMap = new SparseIntArray();
    private volatile int mRunningHightTaskNum = 0;
    private volatile int mRunningLowTaskNum = 0;
    private volatile int mRunningMiddleTaskNum = 0;
    private volatile int mRunningSuperHightTaskNum = 0;
    private final LinkedList<LAsyncTaskRunnable> mRunningTasks = new LinkedList<>();
    private final LinkedList<LAsyncTaskRunnable> mTimeOutTasks = new LinkedList<>();
    private final LinkedList<LAsyncTaskRunnable> mWaitingTasks = new LinkedList<>();

    abstract class LAsyncTaskRunnable implements Runnable {
        private LAsyncTaskFuture<?> mLAsyncTaskFuture = null;

        public LAsyncTaskRunnable(LAsyncTaskFuture<?> lAsyncTaskFuture) {
            if (lAsyncTaskFuture == null || lAsyncTaskFuture.getTask() == null) {
                throw new InvalidParameterException("parameter is null");
            }
            this.mLAsyncTaskFuture = lAsyncTaskFuture;
        }

        public void runTask() {
            try {
                this.mLAsyncTaskFuture.run();
            } catch (OutOfMemoryError e) {
                System.gc();
            }
        }

        public void cancelTask() {
            this.mLAsyncTaskFuture.cancelTask();
        }

        public boolean isCancelled() {
            return this.mLAsyncTaskFuture.isCancelled();
        }

        public LAsyncTask<?, ?, ?> getTask() {
            return this.mLAsyncTaskFuture.getTask();
        }

        public int getPriority() {
            return this.mLAsyncTaskFuture.getTask().getPriority();
        }

        public void setTimeout(boolean z) {
            this.mLAsyncTaskFuture.getTask().setTimeout(z);
        }

        public boolean IsTimeout() {
            return this.mLAsyncTaskFuture.getTask().isTimeout();
        }

        public int getTag() {
            return this.mLAsyncTaskFuture.getTask().getTag();
        }

        public int getParallelTag() {
            if (this.mLAsyncTaskFuture.getTask().getParallel() != null) {
                return this.mLAsyncTaskFuture.getTask().getParallel().getTag();
            }
            return 0;
        }

        public String getKey() {
            return this.mLAsyncTaskFuture.getTask().getKey();
        }

        public LAsyncTaskParallelType getParallelType() {
            if (this.mLAsyncTaskFuture.getTask().getParallel() != null) {
                return this.mLAsyncTaskFuture.getTask().getParallel().getType();
            }
            return LAsyncTaskParallelType.MAX_PARALLEL;
        }

        public boolean isSelfExecute() {
            return this.mLAsyncTaskFuture.getTask().isSelfExecute();
        }
    }

    private LAsyncTaskExecutor() {
    }

    public String toString() {
        return "mWaitingTasks = " + this.mWaitingTasks.size() + " mRunningTasks = " + this.mRunningTasks.size() + " mTimeOutTasks = " + this.mTimeOutTasks.size();
    }

    public static LAsyncTaskExecutor getInstance() {
        if (sInstance == null) {
            synchronized (LAsyncTaskExecutor.class) {
                if (sInstance == null) {
                    sInstance = new LAsyncTaskExecutor();
                }
            }
        }
        return sInstance;
    }

    public synchronized void execute(Runnable runnable) {
//        if (runnable instanceof LAsyncTaskFuture) {
//            C07883 r0 = new LAsyncTaskRunnable((LAsyncTaskFuture) runnable) {
//                public void run() {
//                    try {
//                        if (getPriority() == 4) {
//                            Process.setThreadPriority(-2);
//                        } else if (getPriority() == 3) {
//                            Process.setThreadPriority(-1);
//                        } else if (getPriority() == 2) {
//                            Process.setThreadPriority(0);
//                        } else {
//                            Process.setThreadPriority(10);
//                        }
//                    } catch (Exception e) {
//                        if (LSwitcher.isOpened()) {
//                            C0789L.log.error(e.getMessage());
//                        }
//                    } catch (Throwable th) {
//                        if (!isSelfExecute()) {
//                            LAsyncTaskExecutor.this.mHandler.sendMessage(LAsyncTaskExecutor.this.mHandler.obtainMessage(2, this));
//                        }
//                        throw th;
//                    }
//                    runTask();
//                    if (!isSelfExecute()) {
//                        LAsyncTaskExecutor.this.mHandler.sendMessage(LAsyncTaskExecutor.this.mHandler.obtainMessage(2, this));
//                    }
//                }
//            };
//            if (r0.isSelfExecute()) {
//                new Thread(r0).start();
//            } else {
//                insertTask(r0);
//                scheduleNext(null);
//                if (LSwitcher.isOpened()) {
//                    C0789L.log.debug(toString());
//                }
//            }
//        }
    }

    private synchronized void insertTask(LAsyncTaskRunnable lAsyncTaskRunnable) {
        if (lAsyncTaskRunnable != null) {
            int size = this.mWaitingTasks.size();
            int i = 0;
            while (i < size && ((LAsyncTaskRunnable) this.mWaitingTasks.get(i)).getPriority() >= lAsyncTaskRunnable.getPriority()) {
                i++;
            }
            this.mWaitingTasks.add(i, lAsyncTaskRunnable);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void taskTimeOut(LAsyncTaskRunnable lAsyncTaskRunnable) {
        removeRunningTask(lAsyncTaskRunnable);
        if (!lAsyncTaskRunnable.isCancelled()) {
            lAsyncTaskRunnable.setTimeout(true);
            this.mTimeOutTasks.add(lAsyncTaskRunnable);
            if (this.mTimeOutTasks.size() > 246) {
                LAsyncTaskRunnable lAsyncTaskRunnable2 = (LAsyncTaskRunnable) this.mTimeOutTasks.poll();
                if (lAsyncTaskRunnable2 != null) {
                    lAsyncTaskRunnable2.cancelTask();
                }
            }
        } else if (LSwitcher.isOpened()) {
            C0789L.log.error("task TimeOut but it's cancelled()");
        }
        scheduleNext(null);
    }

    private synchronized void removeRunningTask(LAsyncTaskRunnable lAsyncTaskRunnable) {
        if (lAsyncTaskRunnable != null) {
            if (lAsyncTaskRunnable.IsTimeout()) {
                this.mTimeOutTasks.remove(lAsyncTaskRunnable);
            } else {
                this.mRunningTasks.remove(lAsyncTaskRunnable);
                this.mHandler.removeMessages(1, lAsyncTaskRunnable);
                switch (lAsyncTaskRunnable.getPriority()) {
                    case 1:
                        this.mRunningLowTaskNum--;
                        break;
                    case 2:
                        this.mRunningMiddleTaskNum--;
                        break;
                    case 3:
                        this.mRunningHightTaskNum--;
                        break;
                    case 4:
                        this.mRunningSuperHightTaskNum--;
                        break;
                }
                int parallelTag = lAsyncTaskRunnable.getParallelTag();
                if (parallelTag != 0) {
                    int i = this.mParallelMap.get(parallelTag) - 1;
                    if (i <= 0) {
                        this.mParallelMap.delete(parallelTag);
                    } else {
                        this.mParallelMap.put(parallelTag, i);
                    }
                    if (i < 0 && LSwitcher.isOpened()) {
                        C0789L.log.error("removeTask error < 0");
                    }
                }
            }
        }
    }

    private synchronized void executeTask(LAsyncTaskRunnable lAsyncTaskRunnable) {
        if (lAsyncTaskRunnable != null) {
            this.mRunningTasks.add(lAsyncTaskRunnable);
            this.mWaitingTasks.remove(lAsyncTaskRunnable);
            THREAD_POOL_EXECUTOR.execute(lAsyncTaskRunnable);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, lAsyncTaskRunnable), 180000);
            switch (lAsyncTaskRunnable.getPriority()) {
                case 1:
                    this.mRunningLowTaskNum++;
                    break;
                case 2:
                    this.mRunningMiddleTaskNum++;
                    break;
                case 3:
                    this.mRunningHightTaskNum++;
                    break;
                case 4:
                    this.mRunningSuperHightTaskNum++;
                    if (this.mRunningSuperHightTaskNum >= 5 && LSwitcher.isOpened()) {
                        C0789L.log.error("SuperHight Task too much num = " + this.mRunningSuperHightTaskNum);
                        break;
                    }
            }
            int parallelTag = lAsyncTaskRunnable.getParallelTag();
            if (parallelTag != 0) {
                this.mParallelMap.put(parallelTag, this.mParallelMap.get(parallelTag, 0) + 1);
            }
        }
    }

    private boolean canParallelExecute(int i, LAsyncTaskParallelType lAsyncTaskParallelType) {
        if (lAsyncTaskParallelType == LAsyncTaskParallelType.SERIAL) {
            if (i <= 0) {
                return true;
            }
        } else if (lAsyncTaskParallelType == LAsyncTaskParallelType.TWO_PARALLEL) {
            if (i < 2) {
                return true;
            }
        } else if (lAsyncTaskParallelType == LAsyncTaskParallelType.THREE_PARALLEL) {
            if (i < 3) {
                return true;
            }
        } else if (lAsyncTaskParallelType != LAsyncTaskParallelType.FOUR_PARALLEL || i < 4) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063 A[LOOP:0: B:3:0x0006->B:28:0x0063, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0031 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void scheduleNext(LAsyncTaskRunnable r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.removeRunningTask(r6)     // Catch:{ all -> 0x003c }
            r0 = 0
            r1 = r0
        L_0x0006:
            java.util.LinkedList<com.baicizhan.client.framework.asynctask.LAsyncTaskExecutor$LAsyncTaskRunnable> r0 = r5.mWaitingTasks     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            if (r1 >= r0) goto L_0x0034
            java.util.LinkedList<com.baicizhan.client.framework.asynctask.LAsyncTaskExecutor$LAsyncTaskRunnable> r0 = r5.mWaitingTasks     // Catch:{ all -> 0x003c }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x003c }
            com.baicizhan.client.framework.asynctask.LAsyncTaskExecutor$LAsyncTaskRunnable r0 = (com.baicizhan.client.framework.asynctask.LAsyncTaskExecutor.LAsyncTaskRunnable) r0     // Catch:{ all -> 0x003c }
            int r2 = r0.getParallelTag()     // Catch:{ all -> 0x003c }
            int r3 = r0.getPriority()     // Catch:{ all -> 0x003c }
            switch(r3) {
                case 1: goto L_0x0057;
                case 2: goto L_0x004b;
                case 3: goto L_0x003f;
                case 4: goto L_0x0036;
                default: goto L_0x0021;
            }     // Catch:{ all -> 0x003c }
        L_0x0021:
            android.util.SparseIntArray r3 = r5.mParallelMap     // Catch:{ all -> 0x003c }
            int r2 = r3.get(r2)     // Catch:{ all -> 0x003c }
            com.baicizhan.client.framework.asynctask.LAsyncTaskParallel$LAsyncTaskParallelType r3 = r0.getParallelType()     // Catch:{ all -> 0x003c }
            boolean r2 = r5.canParallelExecute(r2, r3)     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0063
            r5.executeTask(r0)     // Catch:{ all -> 0x003c }
        L_0x0034:
            monitor-exit(r5)
            return
        L_0x0036:
            if (r2 != 0) goto L_0x0021
            r5.executeTask(r0)     // Catch:{ all -> 0x003c }
            goto L_0x0034
        L_0x003c:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x003f:
            int r3 = r5.mRunningHightTaskNum     // Catch:{ all -> 0x003c }
            int r4 = r5.mRunningMiddleTaskNum     // Catch:{ all -> 0x003c }
            int r3 = r3 + r4
            int r4 = r5.mRunningLowTaskNum     // Catch:{ all -> 0x003c }
            int r3 = r3 + r4
            r4 = 5
            if (r3 < r4) goto L_0x0021
            goto L_0x0034
        L_0x004b:
            int r3 = r5.mRunningHightTaskNum     // Catch:{ all -> 0x003c }
            int r4 = r5.mRunningMiddleTaskNum     // Catch:{ all -> 0x003c }
            int r3 = r3 + r4
            int r4 = r5.mRunningLowTaskNum     // Catch:{ all -> 0x003c }
            int r3 = r3 + r4
            r4 = 4
            if (r3 < r4) goto L_0x0021
            goto L_0x0034
        L_0x0057:
            int r3 = r5.mRunningHightTaskNum     // Catch:{ all -> 0x003c }
            int r4 = r5.mRunningMiddleTaskNum     // Catch:{ all -> 0x003c }
            int r3 = r3 + r4
            int r4 = r5.mRunningLowTaskNum     // Catch:{ all -> 0x003c }
            int r3 = r3 + r4
            r4 = 3
            if (r3 < r4) goto L_0x0021
            goto L_0x0034
        L_0x0063:
            int r0 = r1 + 1
            r1 = r0
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.framework.asynctask.LAsyncTaskExecutor.scheduleNext(com.baicizhan.client.framework.asynctask.LAsyncTaskExecutor$LAsyncTaskRunnable):void");
    }

    public synchronized LinkedList<LAsyncTask<?, ?, ?>> removeAllTask(int i) {
        return removeAllTask(i, null);
    }

    public synchronized LinkedList<LAsyncTask<?, ?, ?>> removeAllTask(int i, String str) {
        LinkedList<LAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        linkedList.addAll(removeAllQueueTask(i, str));
        linkedList.addAll(removeTask(this.mRunningTasks, false, i, str));
        linkedList.addAll(removeTask(this.mTimeOutTasks, false, i, str));
        if (LSwitcher.isOpened()) {
            C0789L.log.debug(getInstance().toString());
        }
        return linkedList;
    }

    public synchronized LinkedList<LAsyncTask<?, ?, ?>> removeAllQueueTask(int i) {
        LinkedList<LAsyncTask<?, ?, ?>> removeTask;
        removeTask = removeTask(this.mWaitingTasks, true, i, null);
        if (LSwitcher.isOpened()) {
            C0789L.log.debug(getInstance().toString());
        }
        return removeTask;
    }

    public synchronized LinkedList<LAsyncTask<?, ?, ?>> removeAllQueueTask(int i, String str) {
        LinkedList<LAsyncTask<?, ?, ?>> removeTask;
        removeTask = removeTask(this.mWaitingTasks, true, i, str);
        if (LSwitcher.isOpened()) {
            C0789L.log.debug(getInstance().toString());
        }
        return removeTask;
    }

    private synchronized LinkedList<LAsyncTask<?, ?, ?>> removeTask(LinkedList<LAsyncTaskRunnable> linkedList, boolean z, int i, String str) {
        LinkedList<LAsyncTask<?, ?, ?>> linkedList2;
        linkedList2 = new LinkedList<>();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            LAsyncTaskRunnable lAsyncTaskRunnable = (LAsyncTaskRunnable) it.next();
            int tag = lAsyncTaskRunnable.getTag();
            String key = lAsyncTaskRunnable.getKey();
            if (tag == i && (str == null || str.equals(key))) {
                if (z) {
                    it.remove();
                }
                lAsyncTaskRunnable.cancelTask();
                linkedList2.add(lAsyncTaskRunnable.getTask());
            }
        }
        return linkedList2;
    }

    public synchronized int findTaskNum(int i) {
        return findTaskNum(this.mWaitingTasks, i) + findTaskNum(this.mRunningTasks, i) + findTaskNum(this.mTimeOutTasks, i);
    }

    public synchronized int findTaskNum(LinkedList<LAsyncTaskRunnable> linkedList, int i) {
        int i2;
        int i3 = 0;
        synchronized (this) {
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    LAsyncTaskRunnable lAsyncTaskRunnable = (LAsyncTaskRunnable) it.next();
                    if (lAsyncTaskRunnable.getTag() != i || lAsyncTaskRunnable.getTask() == null || lAsyncTaskRunnable.getTask().isCancelled()) {
                        i2 = i3;
                    } else {
                        i2 = i3 + 1;
                    }
                    i3 = i2;
                }
            }
        }
        return i3;
    }

    public synchronized void removeTask(LAsyncTask<?, ?, ?> lAsyncTask) {
        Iterator it = this.mWaitingTasks.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            LAsyncTaskRunnable lAsyncTaskRunnable = (LAsyncTaskRunnable) it.next();
            if (lAsyncTaskRunnable != null && lAsyncTaskRunnable.getTask() == lAsyncTask) {
                it.remove();
                break;
            }
        }
        if (LSwitcher.isOpened()) {
            C0789L.log.debug(getInstance().toString());
        }
    }

    public synchronized LAsyncTask<?, ?, ?> searchTask(String str) {
        LAsyncTask<?, ?, ?> searchTask;
        searchTask = searchTask(this.mWaitingTasks, str);
        if (searchTask == null) {
            searchTask = searchTask(this.mRunningTasks, str);
        }
        if (searchTask == null) {
            searchTask = searchTask(this.mTimeOutTasks, str);
        }
        if (searchTask != null && searchTask.isCancelled()) {
            searchTask = null;
        }
        return searchTask;
    }

    public synchronized LinkedList<LAsyncTask<?, ?, ?>> searchAllTask(int i, String str) {
        LinkedList<LAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        linkedList.addAll(searchAllTask(this.mWaitingTasks, i, str));
        linkedList.addAll(searchAllTask(this.mRunningTasks, i, str));
        linkedList.addAll(searchAllTask(this.mTimeOutTasks, i, str));
        return linkedList;
    }

    public synchronized LinkedList<LAsyncTask<?, ?, ?>> searchAllTask(int i) {
        LinkedList<LAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        linkedList.addAll(searchAllTask(this.mWaitingTasks, i));
        linkedList.addAll(searchAllTask(this.mRunningTasks, i));
        linkedList.addAll(searchAllTask(this.mTimeOutTasks, i));
        return linkedList;
    }

    public synchronized LAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return searchTask(this.mWaitingTasks, str);
    }

    public synchronized LinkedList<LAsyncTask<?, ?, ?>> searchWaitingTask(int i) {
        LinkedList<LAsyncTask<?, ?, ?>> linkedList;
        linkedList = new LinkedList<>();
        linkedList.addAll(searchAllTask(this.mWaitingTasks, i));
        linkedList.addAll(searchAllTask(this.mTimeOutTasks, i));
        return linkedList;
    }

    public synchronized LAsyncTask<?, ?, ?> searchActivTask(String str) {
        return searchTask(this.mRunningTasks, str);
    }

    public synchronized LAsyncTask<?, ?, ?> searchTask(LinkedList<LAsyncTaskRunnable> linkedList, String str) {
        LAsyncTask<?, ?, ?> lAsyncTask;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    lAsyncTask = null;
                    break;
                }
                LAsyncTaskRunnable lAsyncTaskRunnable = (LAsyncTaskRunnable) it.next();
                String key = lAsyncTaskRunnable.getKey();
                if (key != null && key.equals(str) && !lAsyncTaskRunnable.getTask().isCancelled()) {
                    lAsyncTask = lAsyncTaskRunnable.getTask();
                    break;
                }
            }
        } else {
            lAsyncTask = null;
        }
        return lAsyncTask;
    }

    public synchronized LinkedList<LAsyncTask<?, ?, ?>> searchAllTask(LinkedList<LAsyncTaskRunnable> linkedList, int i) {
        LinkedList linkedList2;
        if (linkedList == null) {
            linkedList2 = null;
        } else {
            LinkedList linkedList3 = new LinkedList();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                LAsyncTaskRunnable lAsyncTaskRunnable = (LAsyncTaskRunnable) it.next();
                if (lAsyncTaskRunnable.getTag() == i && lAsyncTaskRunnable.getTask() != null && !lAsyncTaskRunnable.getTask().isCancelled()) {
                    linkedList3.add(lAsyncTaskRunnable.getTask());
                }
            }
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }

    public synchronized LinkedList<LAsyncTask<?, ?, ?>> searchAllTask(LinkedList<LAsyncTaskRunnable> linkedList, int i, String str) {
        LinkedList linkedList2;
        if (linkedList == null) {
            linkedList2 = null;
        } else {
            LinkedList linkedList3 = new LinkedList();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                LAsyncTaskRunnable lAsyncTaskRunnable = (LAsyncTaskRunnable) it.next();
                String key = lAsyncTaskRunnable.getKey();
                if (key != null && key.equals(str) && lAsyncTaskRunnable.getTag() == i && lAsyncTaskRunnable.getTask() != null && !lAsyncTaskRunnable.getTask().isCancelled()) {
                    linkedList3.add(lAsyncTaskRunnable.getTask());
                }
            }
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }
}
