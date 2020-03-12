package com.baicizhan.client.framework.network.http;

public class HttpProgressor {
    private long mCurrentSize;
    private long mTotalSize;

    public HttpProgressor(long j, long j2) {
        this.mCurrentSize = j;
        this.mTotalSize = j2;
    }

    public long getCurrentSize() {
        return this.mCurrentSize;
    }

    public void setCurrentSize(long j) {
        this.mCurrentSize = j;
    }

    public long getTotalSize() {
        return this.mTotalSize;
    }

    public void setTotalSize(long j) {
        this.mTotalSize = j;
    }
}
