package com.kyleduo.switchbutton;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.kyleduo.switchbutton.b */
/* compiled from: AnimationController */
final class C1656b extends Handler {
    private C1656b() {
    }

    /* synthetic */ C1656b(byte b) {
        this();
    }

    public final void handleMessage(Message message) {
        if (message.what == AnimationController.f3995g && message.obj != null) {
            ((Runnable) message.obj).run();
        }
    }
}
