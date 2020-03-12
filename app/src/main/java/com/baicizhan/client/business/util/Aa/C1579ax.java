package com.baicizhan.client.business.util.Aa;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.f.a.ax */
/* compiled from: RequestCreator */
final class C1579ax implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AtomicInteger f3716a;

    /* renamed from: b */
    final /* synthetic */ CountDownLatch f3717b;

    C1579ax(AtomicInteger atomicInteger, CountDownLatch countDownLatch) {
        this.f3716a = atomicInteger;
        this.f3717b = countDownLatch;
    }

    public final void run() {
        this.f3716a.set(RequestCreator.m3531b());
        this.f3717b.countDown();
    }
}
