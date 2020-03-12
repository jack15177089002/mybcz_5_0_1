package com.baicizhan.client.business.util.Aa;

import android.os.Process;

/* renamed from: com.f.a.bk */
/* compiled from: Utils */
final class C1585bk extends Thread {
    public C1585bk(Runnable runnable) {
        super(runnable);
    }

    public final void run() {
        Process.setThreadPriority(10);
        super.run();
    }
}
