package com.baicizhan.client.framework.util;

public interface IBackoffPolicy {
    long getBackoff(int i, int i2);
}
