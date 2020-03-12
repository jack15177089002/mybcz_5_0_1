package com.baicizhan.client.business.util.Aa;

import android.os.Message;

/* renamed from: com.f.a.bd */
/* compiled from: Stats */
final class C1583bd implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Message f3738a;

    /* renamed from: b */
    final /* synthetic */ C1582bc f3739b;

    C1583bd(C1582bc bcVar, Message message) {
        this.f3739b = bcVar;
        this.f3738a = message;
    }

    public final void run() {
        throw new AssertionError("Unhandled stats message." + this.f3738a.what);
    }
}
