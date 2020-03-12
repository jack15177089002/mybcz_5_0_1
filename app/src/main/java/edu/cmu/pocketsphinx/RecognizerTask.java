package edu.cmu.pocketsphinx;

import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: edu.cmu.pocketsphinx.e */
public class RecognizerTask implements Runnable {

    /* renamed from: i */
    static final /* synthetic */ boolean f5698i = (!RecognizerTask.class.desiredAssertionStatus());

    /* renamed from: a */
    Decoder f5699a;

    /* renamed from: b */
    C2075g f5700b;

    /* renamed from: c */
    Thread f5701c;

    /* renamed from: d */
    LinkedBlockingQueue<short[]> f5702d;

    /* renamed from: e */
    RecognitionListener f5703e = this;

    /* renamed from: f */
    boolean f5704f;

    /* renamed from: g */
    int f5705g = 0;

    /* renamed from: h */
    C2076h f5706h;

    RecognizerTask() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        r12 = r1;
        r1 = r0;
        r0 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        r3 = r1;
        r1 = r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b0 A[Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r13 = this;
            r4 = 0
            r5 = 0
            r2 = 1
            int r1 = edu.cmu.pocketsphinx.C2077i.f5718a
            r0 = r4
        L_0x0006:
            if (r0 != 0) goto L_0x01d2
            edu.cmu.pocketsphinx.h r6 = edu.cmu.pocketsphinx.C2076h.NONE
            edu.cmu.pocketsphinx.h r7 = r13.f5706h     // Catch:{ Exception -> 0x00d6 }
            monitor-enter(r7)     // Catch:{ Exception -> 0x00d6 }
            edu.cmu.pocketsphinx.h r6 = r13.f5706h     // Catch:{ all -> 0x00d3 }
            int r3 = edu.cmu.pocketsphinx.C2077i.f5718a     // Catch:{ all -> 0x00d3 }
            if (r1 != r3) goto L_0x001e
            edu.cmu.pocketsphinx.h r3 = edu.cmu.pocketsphinx.C2076h.NONE     // Catch:{ all -> 0x00d3 }
            if (r6 != r3) goto L_0x001e
            edu.cmu.pocketsphinx.h r3 = r13.f5706h     // Catch:{ InterruptedException -> 0x00ce }
            r3.wait()     // Catch:{ InterruptedException -> 0x00ce }
            edu.cmu.pocketsphinx.h r6 = r13.f5706h     // Catch:{ InterruptedException -> 0x00ce }
        L_0x001e:
            edu.cmu.pocketsphinx.h r3 = edu.cmu.pocketsphinx.C2076h.NONE     // Catch:{ all -> 0x00d3 }
            r13.f5706h = r3     // Catch:{ all -> 0x00d3 }
            monitor-exit(r7)     // Catch:{ all -> 0x00d3 }
        L_0x0023:
            int[] r3 = edu.cmu.pocketsphinx.C2074f.f5707a     // Catch:{ Exception -> 0x0112 }
            int r6 = r6.ordinal()     // Catch:{ Exception -> 0x0112 }
            r3 = r3[r6]     // Catch:{ Exception -> 0x0112 }
            switch(r3) {
                case 1: goto L_0x00dc;
                case 2: goto L_0x00e3;
                case 3: goto L_0x011e;
                case 4: goto L_0x0197;
                default: goto L_0x002e;
            }
        L_0x002e:
            r12 = r1
            r1 = r0
            r0 = r12
        L_0x0031:
            r3 = r1
            r1 = r0
        L_0x0033:
            int r0 = edu.cmu.pocketsphinx.C2077i.f5719b
            if (r1 != r0) goto L_0x01db
            edu.cmu.pocketsphinx.g r0 = r13.f5700b
            if (r0 == 0) goto L_0x01db
            java.util.concurrent.LinkedBlockingQueue<short[]> r0 = r13.f5702d     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            java.lang.Object r0 = r0.take()     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            short[] r0 = (short[]) r0     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            int r6 = r13.f5705g     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            int r6 = r6 + 1
            r13.f5705g = r6     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            r6 = 0
            if (r0 == 0) goto L_0x01d8
            int r8 = r0.length     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            if (r8 <= 0) goto L_0x01d8
            edu.cmu.pocketsphinx.b r6 = r13.f5699a     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            int r7 = r0.length     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            long r8 = (long) r7     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            r6.mo18373a(r0, r8)     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            double r6 = m5373a(r0)     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            edu.cmu.pocketsphinx.b r0 = r13.f5699a     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            edu.cmu.pocketsphinx.c r0 = r0.mo18374b()     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            if (r0 == 0) goto L_0x01d8
            java.lang.String r8 = r0.mo18376a()     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            if (r8 == r5) goto L_0x01d5
            java.lang.Class r9 = r13.getClass()     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            java.lang.String r9 = r9.getName()     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            java.lang.String r11 = "Hypothesis: "
            r10.<init>(r11)     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            java.lang.String r11 = r0.mo18376a()     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            java.lang.String r10 = r10.toString()     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            android.util.Log.d(r9, r10)     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            edu.cmu.pocketsphinx.d r9 = r13.f5703e     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            if (r9 == 0) goto L_0x01d5
            if (r0 == 0) goto L_0x01d5
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            r9.<init>()     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            java.lang.String r10 = "hyp"
            java.lang.String r0 = r0.mo18376a()     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            r9.putString(r10, r0)     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            java.lang.String r0 = "volume"
            r9.putDouble(r0, r6)     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            java.lang.String r0 = "recordBuffSizeCount"
            int r10 = r13.f5705g     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            r9.putInt(r0, r10)     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            edu.cmu.pocketsphinx.d r0 = r13.f5703e     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            r0.onPartialResults(r9)     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            r0 = r2
        L_0x00ad:
            r5 = r8
        L_0x00ae:
            if (r0 != 0) goto L_0x00cb
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            r0.<init>()     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            java.lang.String r8 = "hyp"
            r0.putString(r8, r5)     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            java.lang.String r8 = "volume"
            r0.putDouble(r8, r6)     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            java.lang.String r6 = "recordBuffSizeCount"
            int r7 = r13.f5705g     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            r0.putInt(r6, r7)     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            edu.cmu.pocketsphinx.d r6 = r13.f5703e     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
            r6.onPartialResults(r0)     // Catch:{ InterruptedException -> 0x01c3, Exception -> 0x01c7 }
        L_0x00cb:
            r0 = r3
            goto L_0x0006
        L_0x00ce:
            r3 = move-exception
            edu.cmu.pocketsphinx.h r6 = edu.cmu.pocketsphinx.C2076h.SHUTDOWN     // Catch:{ all -> 0x00d3 }
            goto L_0x001e
        L_0x00d3:
            r3 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00d3 }
            throw r3     // Catch:{ Exception -> 0x00d6 }
        L_0x00d6:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x0023
        L_0x00dc:
            int r3 = edu.cmu.pocketsphinx.C2077i.f5718a     // Catch:{ Exception -> 0x0112 }
            if (r1 != r3) goto L_0x002e
            r3 = r0
            goto L_0x0033
        L_0x00e3:
            int r3 = edu.cmu.pocketsphinx.C2077i.f5718a     // Catch:{ Exception -> 0x0112 }
            if (r1 != r3) goto L_0x002e
            edu.cmu.pocketsphinx.g r3 = new edu.cmu.pocketsphinx.g     // Catch:{ OutOfMemoryError -> 0x010a, Exception -> 0x0119 }
            java.util.concurrent.LinkedBlockingQueue<short[]> r6 = r13.f5702d     // Catch:{ OutOfMemoryError -> 0x010a, Exception -> 0x0119 }
            r3.<init>(r13, r6)     // Catch:{ OutOfMemoryError -> 0x010a, Exception -> 0x0119 }
            r13.f5700b = r3     // Catch:{ OutOfMemoryError -> 0x010a, Exception -> 0x0119 }
            java.lang.Thread r3 = new java.lang.Thread     // Catch:{ OutOfMemoryError -> 0x010a, Exception -> 0x0119 }
            edu.cmu.pocketsphinx.g r6 = r13.f5700b     // Catch:{ OutOfMemoryError -> 0x010a, Exception -> 0x0119 }
            r3.<init>(r6)     // Catch:{ OutOfMemoryError -> 0x010a, Exception -> 0x0119 }
            r13.f5701c = r3     // Catch:{ OutOfMemoryError -> 0x010a, Exception -> 0x0119 }
            edu.cmu.pocketsphinx.b r3 = r13.f5699a     // Catch:{ OutOfMemoryError -> 0x010a, Exception -> 0x0119 }
            long r6 = r3.f5694a     // Catch:{ OutOfMemoryError -> 0x010a, Exception -> 0x0119 }
            edu.cmu.pocketsphinx.pocketsphinxJNI.Decoder_startUtt__SWIG_0(r6, r3)     // Catch:{ OutOfMemoryError -> 0x010a, Exception -> 0x0119 }
            java.lang.Thread r3 = r13.f5701c     // Catch:{ OutOfMemoryError -> 0x010a, Exception -> 0x0119 }
            r3.start()     // Catch:{ OutOfMemoryError -> 0x010a, Exception -> 0x0119 }
        L_0x0105:
            int r1 = edu.cmu.pocketsphinx.C2077i.f5719b     // Catch:{ Exception -> 0x0112 }
            r3 = r0
            goto L_0x0033
        L_0x010a:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ Exception -> 0x0112 }
            java.lang.System.gc()     // Catch:{ Exception -> 0x0112 }
            goto L_0x0105
        L_0x0112:
            r3 = move-exception
        L_0x0113:
            r3.printStackTrace()
            r3 = r0
            goto L_0x0033
        L_0x0119:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ Exception -> 0x0112 }
            goto L_0x0105
        L_0x011e:
            int r3 = edu.cmu.pocketsphinx.C2077i.f5718a     // Catch:{ Exception -> 0x0112 }
            if (r1 == r3) goto L_0x002e
            boolean r3 = f5698i     // Catch:{ Exception -> 0x0112 }
            if (r3 != 0) goto L_0x0130
            edu.cmu.pocketsphinx.g r3 = r13.f5700b     // Catch:{ Exception -> 0x0112 }
            if (r3 != 0) goto L_0x0130
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ Exception -> 0x0112 }
            r3.<init>()     // Catch:{ Exception -> 0x0112 }
            throw r3     // Catch:{ Exception -> 0x0112 }
        L_0x0130:
            edu.cmu.pocketsphinx.g r3 = r13.f5700b     // Catch:{ Exception -> 0x0112 }
            r6 = 1
            r3.f5711d = r6     // Catch:{ Exception -> 0x0112 }
            java.lang.Thread r3 = r13.f5701c     // Catch:{ InterruptedException -> 0x0152 }
            r3.join()     // Catch:{ InterruptedException -> 0x0152 }
            r3 = r0
        L_0x013b:
            java.util.concurrent.LinkedBlockingQueue<short[]> r0 = r13.f5702d     // Catch:{ Exception -> 0x014d }
            java.lang.Object r0 = r0.poll()     // Catch:{ Exception -> 0x014d }
            short[] r0 = (short[]) r0     // Catch:{ Exception -> 0x014d }
            if (r0 == 0) goto L_0x0155
            edu.cmu.pocketsphinx.b r6 = r13.f5699a     // Catch:{ Exception -> 0x014d }
            int r7 = r0.length     // Catch:{ Exception -> 0x014d }
            long r8 = (long) r7     // Catch:{ Exception -> 0x014d }
            r6.mo18373a(r0, r8)     // Catch:{ Exception -> 0x014d }
            goto L_0x013b
        L_0x014d:
            r0 = move-exception
            r12 = r0
            r0 = r3
            r3 = r12
            goto L_0x0113
        L_0x0152:
            r0 = move-exception
            r3 = r2
            goto L_0x013b
        L_0x0155:
            edu.cmu.pocketsphinx.b r0 = r13.f5699a     // Catch:{ Exception -> 0x014d }
            r0.mo18372a()     // Catch:{ Exception -> 0x014d }
            r0 = 0
            r13.f5700b = r0     // Catch:{ Exception -> 0x014d }
            r0 = 0
            r13.f5701c = r0     // Catch:{ Exception -> 0x014d }
            edu.cmu.pocketsphinx.b r0 = r13.f5699a     // Catch:{ Exception -> 0x014d }
            edu.cmu.pocketsphinx.c r0 = r0.mo18374b()     // Catch:{ Exception -> 0x014d }
            edu.cmu.pocketsphinx.d r6 = r13.f5703e     // Catch:{ Exception -> 0x014d }
            if (r6 == 0) goto L_0x017f
            if (r0 != 0) goto L_0x0183
            java.lang.Class r0 = r13.getClass()     // Catch:{ Exception -> 0x014d }
            java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x014d }
            java.lang.String r6 = "Recognition failure"
            android.util.Log.d(r0, r6)     // Catch:{ Exception -> 0x014d }
            edu.cmu.pocketsphinx.d r0 = r13.f5703e     // Catch:{ Exception -> 0x014d }
            r6 = -1
            r0.onError(r6)     // Catch:{ Exception -> 0x014d }
        L_0x017f:
            int r1 = edu.cmu.pocketsphinx.C2077i.f5718a     // Catch:{ Exception -> 0x014d }
            goto L_0x0033
        L_0x0183:
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ Exception -> 0x014d }
            r6.<init>()     // Catch:{ Exception -> 0x014d }
            java.lang.String r7 = "hyp"
            java.lang.String r0 = r0.mo18376a()     // Catch:{ Exception -> 0x014d }
            r6.putString(r7, r0)     // Catch:{ Exception -> 0x014d }
            edu.cmu.pocketsphinx.d r0 = r13.f5703e     // Catch:{ Exception -> 0x014d }
            r0.onResults(r6)     // Catch:{ Exception -> 0x014d }
            goto L_0x017f
        L_0x0197:
            edu.cmu.pocketsphinx.g r3 = r13.f5700b     // Catch:{ Exception -> 0x0112 }
            if (r3 == 0) goto L_0x01b3
            edu.cmu.pocketsphinx.g r3 = r13.f5700b     // Catch:{ Exception -> 0x0112 }
            r6 = 1
            r3.f5711d = r6     // Catch:{ Exception -> 0x0112 }
            boolean r3 = f5698i     // Catch:{ Exception -> 0x0112 }
            if (r3 != 0) goto L_0x01ae
            java.lang.Thread r3 = r13.f5701c     // Catch:{ Exception -> 0x0112 }
            if (r3 != 0) goto L_0x01ae
            java.lang.AssertionError r3 = new java.lang.AssertionError     // Catch:{ Exception -> 0x0112 }
            r3.<init>()     // Catch:{ Exception -> 0x0112 }
            throw r3     // Catch:{ Exception -> 0x0112 }
        L_0x01ae:
            java.lang.Thread r3 = r13.f5701c     // Catch:{ InterruptedException -> 0x01d3 }
            r3.join()     // Catch:{ InterruptedException -> 0x01d3 }
        L_0x01b3:
            edu.cmu.pocketsphinx.b r3 = r13.f5699a     // Catch:{ Exception -> 0x0112 }
            r3.mo18372a()     // Catch:{ Exception -> 0x0112 }
            r3 = 0
            r13.f5700b = r3     // Catch:{ Exception -> 0x0112 }
            r3 = 0
            r13.f5701c = r3     // Catch:{ Exception -> 0x0112 }
            int r0 = edu.cmu.pocketsphinx.C2077i.f5718a     // Catch:{ Exception -> 0x0112 }
            r1 = r2
            goto L_0x0031
        L_0x01c3:
            r0 = move-exception
            r0 = r3
            goto L_0x0006
        L_0x01c7:
            r0 = move-exception
            r12 = r0
            r0 = r5
            r5 = r12
            r5.printStackTrace()
        L_0x01ce:
            r5 = r0
            r0 = r3
            goto L_0x0006
        L_0x01d2:
            return
        L_0x01d3:
            r3 = move-exception
            goto L_0x01b3
        L_0x01d5:
            r0 = r4
            goto L_0x00ad
        L_0x01d8:
            r0 = r4
            goto L_0x00ae
        L_0x01db:
            r0 = r5
            goto L_0x01ce
        */
        throw new UnsupportedOperationException("Method not decompiled: edu.cmu.pocketsphinx.RecognizerTask.run():void");
    }

    /* renamed from: a */
    private static double m5373a(short[] sArr) {
        double d = 0.0d;
        for (short abs : sArr) {
            d += (double) Math.abs(abs);
        }
        return Math.log10((d / ((double) sArr.length)) + 1.0d) * 10.0d;
    }
}
