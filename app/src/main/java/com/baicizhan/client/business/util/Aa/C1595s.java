package com.baicizhan.client.business.util.Aa;

import android.os.Message;

/* renamed from: com.f.a.s */
/* compiled from: Dispatcher */
final class C1595s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Message f3811a;

    /* renamed from: b */
    final /* synthetic */ C1594r f3812b;

    C1595s(C1594r rVar, Message message) {
        this.f3812b = rVar;
        this.f3811a = message;
    }

    public final void run() {
        throw new AssertionError("Unknown handler message received: " + this.f3811a.what);
    }
}
