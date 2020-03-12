package com.kyleduo.switchbutton;

import android.os.Message;

/* renamed from: com.kyleduo.switchbutton.d */
/* compiled from: AnimationController */
final class C1658d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AnimationController f4005a;

    C1658d(AnimationController aVar) {
        this.f4005a = aVar;
    }

    public final void run() {
        if (this.f4005a.f3999b) {
            this.f4005a.f3998a.mo16655a(this.f4005a.f4000c);
            if (this.f4005a.f3998a.mo16656b()) {
                Message obtainMessage = this.f4005a.f4004j.obtainMessage();
                obtainMessage.what = AnimationController.f3995g;
                obtainMessage.obj = this;
                this.f4005a.f4004j.sendMessageDelayed(obtainMessage, (long) AnimationController.f3997i);
                return;
            }
            this.f4005a.f3999b = false;
            this.f4005a.f3998a.mo16657c();
        }
    }
}
