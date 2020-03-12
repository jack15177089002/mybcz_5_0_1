package com.baicizhan.client.business.thrift;

public class ManualRetryPolicy implements RetryPolicy {
    private final int[] connectTimeouts;
    private final int[] readTimeouts;

    public ManualRetryPolicy(int[] iArr) {
        this.connectTimeouts = iArr;
        this.readTimeouts = iArr;
    }

    public ManualRetryPolicy(int[] iArr, int[] iArr2) {
        this.connectTimeouts = iArr;
        this.readTimeouts = iArr2;
    }

    public int getReadTimeout(int i, int i2) {
        if (i >= this.readTimeouts.length) {
            i = this.readTimeouts.length - 1;
        }
        return this.readTimeouts[i];
    }

    public int getConnectTimeout(int i, int i2) {
        if (i >= this.connectTimeouts.length) {
            i = this.connectTimeouts.length - 1;
        }
        return this.connectTimeouts[i];
    }
}
