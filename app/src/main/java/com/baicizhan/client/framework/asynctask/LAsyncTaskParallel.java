package com.baicizhan.client.framework.asynctask;

import java.security.InvalidParameterException;

public class LAsyncTaskParallel {
    private LAsyncTaskParallelTag mLAsyncTaskParallelTag = null;
    private LAsyncTaskParallelType mLAsyncTaskParallelType = LAsyncTaskParallelType.MAX_PARALLEL;

    public static final class LAsyncTaskParallelTag {
        private static final int MAX_BASE_TAG = 1000;
        private static int mBaseTag = 1000;
        /* access modifiers changed from: private */
        public int mTag = 0;

        public static synchronized LAsyncTaskParallelTag gen() {
            LAsyncTaskParallelTag lAsyncTaskParallelTag;
            synchronized (LAsyncTaskParallelTag.class) {
                lAsyncTaskParallelTag = new LAsyncTaskParallelTag();
                lAsyncTaskParallelTag.mTag = mBaseTag;
                mBaseTag++;
            }
            return lAsyncTaskParallelTag;
        }

        private LAsyncTaskParallelTag() {
        }
    }

    public enum LAsyncTaskParallelType {
        SERIAL,
        TWO_PARALLEL,
        THREE_PARALLEL,
        FOUR_PARALLEL,
        MAX_PARALLEL
    }

    public LAsyncTaskParallel(LAsyncTaskParallelType lAsyncTaskParallelType, LAsyncTaskParallelTag lAsyncTaskParallelTag) {
        if (lAsyncTaskParallelType == null || lAsyncTaskParallelTag == null) {
            throw new InvalidParameterException("LAsyncTaskParallel parameter null");
        }
        this.mLAsyncTaskParallelType = lAsyncTaskParallelType;
        this.mLAsyncTaskParallelTag = lAsyncTaskParallelTag;
    }

    public int getTag() {
        return this.mLAsyncTaskParallelTag.mTag;
    }

    public LAsyncTaskParallelType getType() {
        return this.mLAsyncTaskParallelType;
    }
}
