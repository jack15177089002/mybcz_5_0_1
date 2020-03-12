package com.baicizhan.client.framework.handler;

public interface AnsynInvokeHandler<R, E> {
    void onError(E e);

    void onProgress(int i);

    void onSuccess(R r);
}
