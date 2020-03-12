package com.baicizhan.client.business.util.Aa;

import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.f.a.as */
final class PicassoExecutorService extends ThreadPoolExecutor {
    PicassoExecutorService() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C1586bl());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16318a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    public final Future<?> submit(Runnable runnable) {
        C1577at atVar = new C1577at((BitmapHunter) runnable);
        execute(atVar);
        return atVar;
    }
}
