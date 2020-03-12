package com.baicizhan.client.video.view;

import com.baicizhan.client.framework.util.IBackoffPolicy;

public class SimpleBackoff {
    /* access modifiers changed from: private */
    public int mLastRetried;
    private SimpleBFPolicy mPolicy = new SimpleBFPolicy();

    class SimpleBFPolicy implements IBackoffPolicy {
        private SimpleBFPolicy() {
        }

        public long getBackoff(int i, int i2) {
            SimpleBackoff.this.mLastRetried = i2 + 1;
            switch (i2) {
                case 0:
                    return 2000;
                case 1:
                case 2:
                    return 4000;
                default:
                    return -1;
            }
        }
    }

    public long getBackoff() {
        return this.mPolicy.getBackoff(0, this.mLastRetried);
    }

    public void reset() {
        this.mLastRetried = 0;
    }
}
