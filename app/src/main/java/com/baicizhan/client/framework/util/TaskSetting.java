package com.baicizhan.client.framework.util;

import com.baicizhan.client.framework.network.http.TimeOutData;

public class TaskSetting {
    public int mRetryCount = 1;
    public TimeOutData mTimeOutData = null;

    public int getRetryCount() {
        return this.mRetryCount;
    }

    public void setRetryCount(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.mRetryCount = i;
    }

    public TimeOutData getTimeOutData() {
        return this.mTimeOutData;
    }
}
