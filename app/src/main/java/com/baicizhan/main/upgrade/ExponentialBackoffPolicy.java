//package com.baicizhan.main.upgrade;
//
//import com.baicizhan.client.framework.util.IBackoffPolicy;
//
//public class ExponentialBackoffPolicy implements IBackoffPolicy {
//    private float mBackoffMultiplier;
//    private int mCurrentTimeoutMs;
//
//    public ExponentialBackoffPolicy(int i, float f) {
//        this.mCurrentTimeoutMs = i;
//        this.mBackoffMultiplier = f;
//    }
//
//    public long getBackoff(int i, int i2) {
//        int i3 = this.mCurrentTimeoutMs;
//        this.mCurrentTimeoutMs = (int) (((float) this.mCurrentTimeoutMs) * this.mBackoffMultiplier);
//        return (long) i3;
//    }
//}
