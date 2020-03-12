package com.baicizhan.client.framework.util.archive;

import com.baicizhan.client.framework.util.Cancelable;

public abstract class ICancel {
    protected Cancelable mCancle = new Cancelable();

    public boolean isCanceled() {
        if (this.mCancle != null) {
            return this.mCancle.mCanceled;
        }
        return false;
    }
}
