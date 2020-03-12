package com.baicizhan.client.framework.asynctask;

import android.os.Handler;
import android.os.Message;
import com.baicizhan.client.framework.asynctask.LAsyncTaskParallel.LAsyncTaskParallelTag;
import com.baicizhan.client.framework.asynctask.LAsyncTaskParallel.LAsyncTaskParallelType;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class LAsyncTask<Params, Progress, Result> {
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    private static final LAsyncTaskExecutor sDefaultExecutor = LAsyncTaskExecutor.getInstance();
    private final InternalHandler sHandler = new InternalHandler();
    private boolean isSelfExecute = false;
    /* access modifiers changed from: private */
    public final LAsyncTaskFuture<Result> mFuture = new LAsyncTaskFuture<Result>(this.mWorker, this) {
        /* access modifiers changed from: protected */
        public void done() {
            try {
                LAsyncTask.this.postResult(get());
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
                LAsyncTask.this.postResult(null);
            } catch (CancellationException e3) {
                LAsyncTask.this.postResult(null);
            } catch (Throwable th) {
                throw new RuntimeException("An error occured while executing doInBackground()", th);
            }
        }

        /* access modifiers changed from: protected */
        public void cancelTask() {
            LAsyncTask.this.cancel();
        }
    };
    private boolean mIsTimeout = false;
    private String mKey = null;
    private LAsyncTaskParallel mParallel = null;
    private final AtomicBoolean mPreCancelInvoked = new AtomicBoolean(false);
    private int mPriority = 1;
    private volatile LAsyncTaskStatus mStatus = LAsyncTaskStatus.PENDING;
    private int mTag = 0;
    private final AtomicBoolean mTaskInvoked = new AtomicBoolean(false);
    private final WorkerRunnable<Params, Result> mWorker = new WorkerRunnable<Params, Result>() {
        public Result call() {
            if (!LAsyncTask.this.mFuture.isCancelled()) {
                return LAsyncTask.this.postResult(LAsyncTask.this.doInBackground(this.mParams));
            }
            return null;
        }
    };

    class InternalHandler extends Handler {
        private InternalHandler() {
        }

        public void handleMessage(Message message) {
            LAsyncTaskResult lAsyncTaskResult = (LAsyncTaskResult) message.obj;
            switch (message.what) {
                case 1:
                    lAsyncTaskResult.mTask.finish(lAsyncTaskResult.mData[0]);
                    return;
                case 2:
                    lAsyncTaskResult.mTask.onProgressUpdate(lAsyncTaskResult.mData);
                    return;
                default:
                    return;
            }
        }
    }

    class LAsyncTaskResult<Data> {
        final Data[] mData;
        final LAsyncTask mTask;

        LAsyncTaskResult(LAsyncTask lAsyncTask, Data... dataArr) {
            this.mTask = lAsyncTask;
            this.mData = dataArr;
        }
    }

    public enum LAsyncTaskStatus {
        PENDING,
        RUNNING,
        FINISHED
    }

    abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        private WorkerRunnable() {
        }
    }

    public abstract Result doInBackground(Params... paramsArr);

    public int setPriority(int i) {
        if (this.mStatus != LAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        int i2 = this.mPriority;
        this.mPriority = i;
        return i2;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getTag() {
        return this.mTag;
    }

    public int setTag(int i) {
        if (this.mStatus != LAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        int i2 = this.mTag;
        this.mTag = i;
        return i2;
    }

    public String getKey() {
        return this.mKey;
    }

    public String setKey(String str) {
        if (this.mStatus != LAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        String str2 = this.mKey;
        this.mKey = str;
        return str2;
    }

    public LAsyncTaskParallel getParallel() {
        return this.mParallel;
    }

    public void setParallel(LAsyncTaskParallel lAsyncTaskParallel) {
        if (this.mStatus != LAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        } else if (lAsyncTaskParallel != null) {
            this.mParallel = lAsyncTaskParallel;
        }
    }

    public boolean isSelfExecute() {
        return this.isSelfExecute;
    }

    public void setSelfExecute(boolean z) {
        if (this.mStatus != LAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        this.isSelfExecute = z;
    }

    /* access modifiers changed from: 0000 */
    public void setTimeout(boolean z) {
        this.mIsTimeout = z;
    }

    public boolean isTimeout() {
        return this.mIsTimeout;
    }

    /* access modifiers changed from: private */
    public Result postResult(Result result) {
        if (!this.mTaskInvoked.compareAndSet(false, true)) {
            return null;
        }
        sHandler.obtainMessage(1, new LAsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    public final LAsyncTaskStatus getStatus() {
        return this.mStatus;
    }

    public void cancel() {
        cancel(true);
    }

    /* access modifiers changed from: protected */
    public void onPreCancel() {
    }

    public void onPreExecute() {
    }

    public void onPostExecute(Result result) {
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Progress... progressArr) {
    }

    /* access modifiers changed from: protected */
    public void onCancelled(Result result) {
        onCancelled();
    }

    public void onCancelled() {
    }

    public final boolean isCancelled() {
        return this.mFuture.isCancelled();
    }

    public final boolean cancel(boolean z) {
        if (!this.isSelfExecute) {
            sDefaultExecutor.removeTask(this);
        }
        boolean cancel = this.mFuture.cancel(z);
        if (this.mPreCancelInvoked.compareAndSet(false, true)) {
            onPreCancel();
        }
        return cancel;
    }

    public final Result get() {
        try {
            return this.mFuture.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public final Result get(long j, TimeUnit timeUnit) {
        try {
            return this.mFuture.get(j, timeUnit);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public final LAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final LAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.mStatus != LAsyncTaskStatus.PENDING) {
            switch (this.mStatus) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.mStatus = LAsyncTaskStatus.RUNNING;
        onPreExecute();
        this.mWorker.mParams = paramsArr;
        executor.execute(this.mFuture);
        return this;
    }

    /* access modifiers changed from: protected */
    public final void publishProgress(Progress... progressArr) {
        if (!isCancelled()) {
            sHandler.obtainMessage(2, new LAsyncTaskResult(this, progressArr)).sendToTarget();
        }
    }

    /* access modifiers changed from: private */
    public void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.mStatus = LAsyncTaskStatus.FINISHED;
    }

    public static LinkedList<LAsyncTask<?, ?, ?>> removeAllTask(int i) {
        return sDefaultExecutor.removeAllTask(i);
    }

    public static LinkedList<LAsyncTask<?, ?, ?>> removeAllTask(int i, String str) {
        return sDefaultExecutor.removeAllTask(i, str);
    }

    public static LinkedList<LAsyncTask<?, ?, ?>> removeAllQueueTask(int i) {
        return sDefaultExecutor.removeAllQueueTask(i);
    }

    public static LinkedList<LAsyncTask<?, ?, ?>> removeAllQueueTask(int i, String str) {
        return sDefaultExecutor.removeAllQueueTask(i, str);
    }

    public static LinkedList<LAsyncTask<?, ?, ?>> searchAllTask(int i) {
        return sDefaultExecutor.searchAllTask(i);
    }

    public static LinkedList<LAsyncTask<?, ?, ?>> searchAllTask(int i, String str) {
        return sDefaultExecutor.searchAllTask(i, str);
    }

    public static LAsyncTask<?, ?, ?> searchTask(String str) {
        return sDefaultExecutor.searchTask(str);
    }

    public static LAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return sDefaultExecutor.searchWaitingTask(str);
    }

    public static LinkedList<LAsyncTask<?, ?, ?>> searchWaitingTask(int i) {
        return sDefaultExecutor.searchWaitingTask(i);
    }

    public static LAsyncTask<?, ?, ?> searchActivTask(String str) {
        return sDefaultExecutor.searchActivTask(str);
    }

    public static int findTaskNum(int i) {
        return sDefaultExecutor.findTaskNum(i);
    }

    public void parallelTask(int i) {
        switch (i) {
            case 1:
                setParallel(new LAsyncTaskParallel(LAsyncTaskParallelType.SERIAL, LAsyncTaskParallelTag.gen()));
                return;
            case 2:
                setParallel(new LAsyncTaskParallel(LAsyncTaskParallelType.TWO_PARALLEL, LAsyncTaskParallelTag.gen()));
                return;
            case 3:
                setParallel(new LAsyncTaskParallel(LAsyncTaskParallelType.THREE_PARALLEL, LAsyncTaskParallelTag.gen()));
                return;
            case 4:
                setParallel(new LAsyncTaskParallel(LAsyncTaskParallelType.FOUR_PARALLEL, LAsyncTaskParallelTag.gen()));
                return;
            default:
                setParallel(new LAsyncTaskParallel(LAsyncTaskParallelType.MAX_PARALLEL, LAsyncTaskParallelTag.gen()));
                return;
        }
    }
}
