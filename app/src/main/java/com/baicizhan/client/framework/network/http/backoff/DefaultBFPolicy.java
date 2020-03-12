package com.baicizhan.client.framework.network.http.backoff;

import com.baicizhan.client.framework.util.IBackoffPolicy;

public class DefaultBFPolicy implements IBackoffPolicy {
    private static final int _CYCLE_COUNT = 1;
    private static final long _SEC = 1000;

    public long getBackoff(int i, int i2) {
        int i3 = (i2 % (i / 1)) + 1;
        if (1 == i3 % 2) {
            return ((long) ((i3 + 1) / 2)) * 1000;
        }
        return ((long) i3) * 1000;
    }
}
