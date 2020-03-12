package edu.cmu.pocketsphinx;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: edu.cmu.pocketsphinx.k */
/* compiled from: RecognizerWorker */
final class C2078k extends Handler {

    /* renamed from: a */
    WeakReference<RecognizerWorker> f5728a;

    C2078k(RecognizerWorker jVar) {
        super(Looper.getMainLooper());
        this.f5728a = new WeakReference<>(jVar);
    }

    public final void handleMessage(Message message) {
        RecognizerWorker jVar = (RecognizerWorker) this.f5728a.get();
        if (jVar != null) {
            switch (message.what) {
                case 0:
                    Bundle bundle = (Bundle) message.obj;
                    if (jVar.f5724d != null) {
                        jVar.f5724d.onPartialResults(bundle);
                        return;
                    }
                    return;
                case 1:
                    Bundle bundle2 = (Bundle) message.obj;
                    if (jVar.f5724d != null) {
                        jVar.f5724d.onResults(bundle2);
                        return;
                    }
                    return;
                case 2:
                    int i = message.arg1;
                    if (jVar.f5724d != null) {
                        jVar.f5724d.onError(i);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
