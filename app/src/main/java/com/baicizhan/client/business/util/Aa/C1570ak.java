package com.baicizhan.client.business.util.Aa;

import android.os.Handler;
import android.os.Process;
import java.lang.ref.ReferenceQueue;

/* renamed from: com.f.a.ak */
/* compiled from: Picasso */
final class C1570ak extends Thread {

    /* renamed from: a */
    private final ReferenceQueue<?> f3649a;

    /* renamed from: b */
    private final Handler f3650b;

    C1570ak(ReferenceQueue<?> referenceQueue, Handler handler) {
        this.f3649a = referenceQueue;
        this.f3650b = handler;
        setDaemon(true);
        setName("Picasso-refQueue");
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                this.f3650b.sendMessage(this.f3650b.obtainMessage(3, ((C1581b) this.f3649a.remove()).f3721a));
            } catch (InterruptedException e) {
                return;
            } catch (Exception e2) {
                this.f3650b.post(new C1571al(this, e2));
                return;
            }
        }
    }
}
