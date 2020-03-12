package com.baicizhan.client.framework.event;

public abstract class AsyncUIEvent<R, E> {
    public static final int ON_ERROR = 2;
    public static final int ON_PROGRESS = 3;
    public static final int ON_SUCCESS = 1;
    private E mError;
    private int mProgress;
    private R mResult;
    private int mSignal;

    public AsyncUIEvent(int i) {
        this.mSignal = i;
    }

    public R getResult() {
        return this.mResult;
    }

    public void setResult(R r) {
        this.mResult = r;
    }

    public E getError() {
        return this.mError;
    }

    public void setError(E e) {
        this.mError = e;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setProgress(int i) {
        this.mProgress = i;
    }

    public int getSignal() {
        return this.mSignal;
    }

    public void setSignal(int i) {
        this.mSignal = i;
    }
}
