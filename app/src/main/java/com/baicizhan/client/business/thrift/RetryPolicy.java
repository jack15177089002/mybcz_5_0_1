package com.baicizhan.client.business.thrift;

public interface RetryPolicy {
    int getConnectTimeout(int i, int i2);

    int getReadTimeout(int i, int i2);
}
