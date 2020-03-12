package com.baicizhan.client.framework.asynctask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public abstract class LAsyncTaskFuture<V> extends FutureTask<V> {
    private LAsyncTask<?, ?, ?> mTask = null;

    /* access modifiers changed from: protected */
    public abstract void cancelTask();

    public LAsyncTask<?, ?, ?> getTask() {
        return this.mTask;
    }

    public LAsyncTaskFuture(Callable<V> callable, LAsyncTask<?, ?, ?> lAsyncTask) {
        super(callable);
        this.mTask = lAsyncTask;
    }

    public LAsyncTaskFuture(Runnable runnable, V v, LAsyncTask<?, ?, ?> lAsyncTask) {
        super(runnable, v);
        this.mTask = lAsyncTask;
    }
}
