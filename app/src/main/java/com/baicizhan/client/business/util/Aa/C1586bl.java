package com.baicizhan.client.business.util.Aa;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.f.a.bl */
/* compiled from: Utils */
final class C1586bl implements ThreadFactory {
    C1586bl() {
    }

    public final Thread newThread(Runnable runnable) {
        return new C1585bk(runnable);
    }
}
