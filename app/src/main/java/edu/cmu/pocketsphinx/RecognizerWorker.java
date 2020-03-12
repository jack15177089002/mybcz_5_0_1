package edu.cmu.pocketsphinx;

import android.os.Bundle;
import android.os.Message;
import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: edu.cmu.pocketsphinx.j */
public final class RecognizerWorker extends Thread implements RecognitionListener {

    /* renamed from: a */
    public String f5721a;

    /* renamed from: b */
    public String f5722b;

    /* renamed from: c */
    public String f5723c;

    /* renamed from: d */
    public RecognitionListener f5724d;

    /* renamed from: e */
    private RecognizerTask f5725e;

    /* renamed from: f */
    private String f5726f;

    /* renamed from: g */
    private C2078k f5727g = new C2078k(this);

    static {
        try {
            System.loadLibrary("pocketsphinx_jni");
            PropertyHelper.put("key_sphinxlib_enabled", true);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            PropertyHelper.put("key_sphinxlib_enabled", false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static boolean m5376a() {
        return PropertyHelper.getBoolean("key_sphinxlib_enabled");
    }

    private RecognizerWorker(RecognizerTask eVar) {
        super(eVar);
        this.f5725e = eVar;
    }

    /* renamed from: b */
    public static RecognizerWorker m5377b() {
        return new RecognizerWorker(new RecognizerTask());
    }

    /* renamed from: c */
    public final RecognizerWorker mo18380c() {
        RecognizerTask eVar = this.f5725e;
        String str = this.f5721a;
        String str2 = this.f5722b;
        String str3 = this.f5723c;
        String str4 = this.f5726f;
        Config aVar = new Config();
        aVar.mo18369a("-hmm", str);
        aVar.mo18369a("-dict", str2);
        aVar.mo18369a("-lm", str3);
        aVar.mo18369a("-rawlogdir", str4);
        pocketsphinxJNI.Config_setFloat(aVar.f5692a, aVar, "-samprate", 8000.0d);
        aVar.mo18368a("-maxhmmpf", 2000);
        aVar.mo18368a("-maxwpf", 10);
        aVar.mo18368a("-pl_window", 2);
        aVar.mo18370a("-backtrace", true);
        aVar.mo18370a("-bestpath", false);
        eVar.f5699a = new Decoder(aVar);
        eVar.f5700b = null;
        eVar.f5702d = new LinkedBlockingQueue<>();
        eVar.f5704f = false;
        eVar.f5706h = C2076h.NONE;
        RecognizerTask eVar2 = this.f5725e;
        synchronized (eVar2.f5706h) {
            eVar2.f5706h.notifyAll();
            eVar2.f5706h = C2076h.START;
        }
        if (!isAlive()) {
            super.start();
        }
        return this;
    }

    /* renamed from: d */
    public final RecognizerWorker mo18381d() {
        RecognizerTask eVar = this.f5725e;
        synchronized (eVar.f5706h) {
            eVar.f5706h.notifyAll();
            eVar.f5706h = C2076h.STOP;
        }
        return this;
    }

    /* renamed from: e */
    public final RecognizerWorker mo18382e() {
        RecognizerTask eVar = this.f5725e;
        synchronized (eVar.f5706h) {
            eVar.f5706h.notifyAll();
            eVar.f5706h = C2076h.SHUTDOWN;
        }
        return this;
    }

    /* renamed from: f */
    public final boolean mo18383f() {
        return C2076h.SHUTDOWN == this.f5725e.f5706h;
    }

    public final void onPartialResults(Bundle bundle) {
        Message obtainMessage = this.f5727g.obtainMessage(0);
        obtainMessage.obj = bundle;
        this.f5727g.sendMessage(obtainMessage);
    }

    public final void onResults(Bundle bundle) {
        Message obtainMessage = this.f5727g.obtainMessage(1);
        obtainMessage.obj = bundle;
        this.f5727g.sendMessage(obtainMessage);
    }

    public final void onError(int i) {
        Message obtainMessage = this.f5727g.obtainMessage(2);
        obtainMessage.arg1 = i;
        this.f5727g.sendMessage(obtainMessage);
    }
}
