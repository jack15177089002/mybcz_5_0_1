package edu.cmu.pocketsphinx;

import android.media.AudioRecord;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: edu.cmu.pocketsphinx.g */
/* compiled from: RecognizerTask */
final class C2075g implements Runnable {

    /* renamed from: a */
    LinkedBlockingQueue<short[]> f5708a;

    /* renamed from: b */
    AudioRecord f5709b;

    /* renamed from: c */
    int f5710c;

    /* renamed from: d */
    boolean f5711d;

    /* renamed from: e */
    final /* synthetic */ RecognizerTask f5712e;

    /* JADX WARNING: type inference failed for: r7v0, types: [java.util.concurrent.LinkedBlockingQueue<short[]>, edu.cmu.pocketsphinx.e] */
    /* JADX WARNING: type inference failed for: r8v0, types: [java.util.concurrent.LinkedBlockingQueue<short[]>, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=null, for r8v0, types: [java.util.concurrent.LinkedBlockingQueue<short[]>, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.concurrent.LinkedBlockingQueue<short[]>, code=null, for r7v0, types: [java.util.concurrent.LinkedBlockingQueue<short[]>, edu.cmu.pocketsphinx.e] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    C2075g(LinkedBlockingQueue<short[]> r7, int r8) {
        /*
            r6 = this;
            r6.f5712e = r7
            r6.<init>()
            r0 = 0
            r6.f5711d = r0     // Catch:{ Exception -> 0x001e }
            r6.f5708a = r8     // Catch:{ Exception -> 0x001e }
            r0 = 1024(0x400, float:1.435E-42)
            r6.f5710c = r0     // Catch:{ Exception -> 0x001e }
            android.media.AudioRecord r0 = new android.media.AudioRecord     // Catch:{ Exception -> 0x001e }
            r1 = 0
            r2 = 8000(0x1f40, float:1.121E-41)
            r3 = 16
            r4 = 2
            r5 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x001e }
            r6.f5709b = r0     // Catch:{ Exception -> 0x001e }
        L_0x001d:
            return
        L_0x001e:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: edu.cmu.pocketsphinx.C2075g.<init>(edu.cmu.pocketsphinx.e, java.util.concurrent.LinkedBlockingQueue):void");
    }

    public final void run() {
        try {
            this.f5709b.startRecording();
            while (!this.f5711d) {
                if (m5374a() <= 0) {
                    break;
                }
            }
            this.f5709b.stop();
            this.f5709b.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private int m5374a() {
        OutOfMemoryError e;
        int i;
        Exception e2;
        try {
            short[] sArr = new short[this.f5710c];
            i = this.f5709b.read(sArr, 0, sArr.length);
            if (i > 0) {
                try {
                    this.f5708a.add(sArr);
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    return i;
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    e.printStackTrace();
                    System.gc();
                    return i;
                }
            }
        } catch (Exception e5) {
            Exception exc = e5;
            i = 0;
            e2 = exc;
        } catch (OutOfMemoryError e6) {
            OutOfMemoryError outOfMemoryError = e6;
            i = 0;
            e = outOfMemoryError;
            e.printStackTrace();
            System.gc();
            return i;
        }
        return i;
    }
}
