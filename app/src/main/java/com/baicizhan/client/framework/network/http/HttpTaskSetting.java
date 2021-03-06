package com.baicizhan.client.framework.network.http;

import com.baicizhan.client.framework.util.TaskSetting;

public class HttpTaskSetting extends TaskSetting {
    private static HttpTaskSetting sInstance = null;
    private TimeOutData mConnectTimeOutData;

    public static HttpTaskSetting getInstance() {
        if (sInstance == null) {
            synchronized (HttpTaskSetting.class) {
                if (sInstance == null) {
                    sInstance = new HttpTaskSetting();
                }
            }
        }
        return sInstance;
    }

    private HttpTaskSetting() {
        this.mConnectTimeOutData = null;
        this.mTimeOutData = new TimeOutData(30000, 20000, 10000);
        this.mConnectTimeOutData = new TimeOutData(20000, 10000, 5000);
        this.mRetryCount = 5;
    }

    public void setTimeOut(int i, int i2, int i3) {
        this.mTimeOutData = new TimeOutData(i, i2, i3);
    }

    public TimeOutData getConnectTimeOutData() {
        return this.mConnectTimeOutData;
    }

    public void setConnectTimeOutData(int i, int i2, int i3) {
        this.mConnectTimeOutData = new TimeOutData(i, i2, i3);
    }
}
