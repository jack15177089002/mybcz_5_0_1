package com.baicizhan.client.business.util.Aa;

import android.graphics.Bitmap;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;
//import com.squareup.picasso.RequestHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.f.a.d */
final class BitmapHunter implements Runnable {

    /* renamed from: s */
    private static final Object f3760s = new Object();

    /* renamed from: t */
    private static final ThreadLocal<StringBuilder> f3761t = new C1587e();

    /* renamed from: u */
    private static final AtomicInteger f3762u = new AtomicInteger();

    /* renamed from: v */
    private static final RequestHandler f3763v = new C1588f();

    /* renamed from: a */
    final int f3764a = f3762u.incrementAndGet();

    /* renamed from: b */
    final Picasso f3765b;

    /* renamed from: c */
    final Dispatcher f3766c;

    /* renamed from: d */
    final Cache f3767d;

    /* renamed from: e */
    final Stats f3768e;

    /* renamed from: f */
    final String f3769f;

    /* renamed from: g */
//    final Request f3770g;

    /* renamed from: h */
    final boolean f3771h;

    /* renamed from: i */
    final RequestHandler f3772i;

    /* renamed from: j */
    Action f3773j;

    /* renamed from: k */
    List<Action> f3774k;

    /* renamed from: l */
    Bitmap f3775l;

    /* renamed from: m */
    Future<?> f3776m;

    /* renamed from: n */
    C1573an f3777n;

    /* renamed from: o */
    Exception f3778o;

    /* renamed from: p */
    int f3779p;

    /* renamed from: q */
    int f3780q;

    /* renamed from: r */
    int f3781r;

    private BitmapHunter(Picasso ahVar, Dispatcher qVar, Cache kVar, Stats bbVar, Action aVar, RequestHandler ayVar) {
        this.f3765b = ahVar;
        this.f3766c = qVar;
        this.f3767d = kVar;
        this.f3768e = bbVar;
        this.f3773j = aVar;
        this.f3769f = aVar.f3596h;
//        this.f3770g = aVar.f3590b;
        this.f3781r = aVar.f3590b.f3689q;
        this.f3771h = aVar.f3592d;
        this.f3772i = ayVar;
        this.f3780q = ayVar.getRetryCount();
    }

    public final void run() {
        String hexString;
        try {
//            Request auVar = this.f3770g;
//            if (auVar.f3676d != null) {
//                hexString = String.valueOf(auVar.f3676d.getPath());
//            } else {
//                hexString = Integer.toHexString(auVar.f3677e);
//            }
//            StringBuilder sb = (StringBuilder) f3761t.get();
//            sb.ensureCapacity(hexString.length() + 8);
//            sb.replace(8, sb.length(), hexString);
//            Thread.currentThread().setName(sb.toString());
//            if (this.f3765b.f3636m) {
//                C1584bj.m3557a("Hunter", "executing", C1584bj.m3553a(this));
//            }
            this.f3775l = m3571c();
            if (this.f3775l == null) {
                this.f3766c.mo16357a(this);
            } else {
                Dispatcher qVar = this.f3766c;
                qVar.f3802i.sendMessage(qVar.f3802i.obtainMessage(4, this));
            }
//        } catch (C1599x e) {
//            this.f3778o = e;
//            this.f3766c.mo16357a(this);
//        } catch (IOException e2) {
//            this.f3778o = e2;
//            Dispatcher qVar2 = this.f3766c;
//            qVar2.f3802i.sendMessageDelayed(qVar2.f3802i.obtainMessage(5, this), 500);
        } catch (OutOfMemoryError e3) {
            StringWriter stringWriter = new StringWriter();
            Stats bbVar = this.f3768e;
            StatsSnapshot beVar = new StatsSnapshot(bbVar.f3724b.mo16284b(), bbVar.f3724b.mo16280a(), bbVar.f3726d, bbVar.f3727e, bbVar.f3728f, bbVar.f3729g, bbVar.f3730h, bbVar.f3731i, bbVar.f3732j, bbVar.f3733k, bbVar.f3734l, bbVar.f3735m, bbVar.f3736n, System.currentTimeMillis());
            PrintWriter printWriter = new PrintWriter(stringWriter);
            printWriter.println("===============BEGIN PICASSO STATS ===============");
            printWriter.println("Memory Cache Stats");
            printWriter.print("  Max Cache Size: ");
            printWriter.println(beVar.f3740a);
            printWriter.print("  Cache Size: ");
            printWriter.println(beVar.f3741b);
            printWriter.print("  Cache % Full: ");
            printWriter.println((int) Math.ceil((double) ((((float) beVar.f3741b) / ((float) beVar.f3740a)) * 100.0f)));
            printWriter.print("  Cache Hits: ");
            printWriter.println(beVar.f3742c);
            printWriter.print("  Cache Misses: ");
            printWriter.println(beVar.f3743d);
            printWriter.println("Network Stats");
            printWriter.print("  Download Count: ");
            printWriter.println(beVar.f3750k);
            printWriter.print("  Total Download Size: ");
            printWriter.println(beVar.f3744e);
            printWriter.print("  Average Download Size: ");
            printWriter.println(beVar.f3747h);
            printWriter.println("Bitmap Stats");
            printWriter.print("  Total Bitmaps Decoded: ");
            printWriter.println(beVar.f3751l);
            printWriter.print("  Total Bitmap Size: ");
            printWriter.println(beVar.f3745f);
            printWriter.print("  Total Transformed Bitmaps: ");
            printWriter.println(beVar.f3752m);
            printWriter.print("  Total Transformed Bitmap Size: ");
            printWriter.println(beVar.f3746g);
            printWriter.print("  Average Bitmap Size: ");
            printWriter.println(beVar.f3748i);
            printWriter.print("  Average Transformed Bitmap Size: ");
            printWriter.println(beVar.f3749j);
            printWriter.println("===============END PICASSO STATS ===============");
            printWriter.flush();
            this.f3778o = new RuntimeException(stringWriter.toString(), e3);
            this.f3766c.mo16357a(this);
        } catch (Exception e4) {
            this.f3778o = e4;
            this.f3766c.mo16357a(this);
        } finally {
            Thread.currentThread().setName("Picasso-Idle");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f3  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Bitmap m3571c() {
        /*
            r15 = this;
            r2 = 1
            r3 = 0
            r0 = 0
            boolean r1 = r15.f3771h
            if (r1 != 0) goto L_0x0030
            com.f.a.k r0 = r15.f3767d
            java.lang.String r1 = r15.f3769f
            android.graphics.Bitmap r0 = r0.mo16281a(r1)
            if (r0 == 0) goto L_0x0030
            com.f.a.bb r1 = r15.f3768e
            r1.mo16337a()
            com.f.a.an r1 = com.p055f.p056a.C1573an.MEMORY
            r15.f3777n = r1
            com.f.a.ah r1 = r15.f3765b
            boolean r1 = r1.f3636m
            if (r1 == 0) goto L_0x002f
            java.lang.String r1 = "Hunter"
            java.lang.String r2 = "decoded"
            com.f.a.au r3 = r15.f3770g
            java.lang.String r3 = r3.mo16321a()
            java.lang.String r4 = "from cache"
            com.p055f.p056a.C1584bj.m3558a(r1, r2, r3, r4)
        L_0x002f:
            return r0
        L_0x0030:
            com.f.a.au r4 = r15.f3770g
            int r1 = r15.f3780q
            if (r1 != 0) goto L_0x0130
            r1 = r2
        L_0x0037:
            r4.f3675c = r1
            com.f.a.ay r1 = r15.f3772i
            com.f.a.au r4 = r15.f3770g
            com.f.a.az r1 = r1.load(r4)
            if (r1 == 0) goto L_0x004d
            android.graphics.Bitmap r0 = r1.f3719b
            com.f.a.an r4 = r1.f3718a
            r15.f3777n = r4
            int r1 = r1.f3720c
            r15.f3779p = r1
        L_0x004d:
            if (r0 == 0) goto L_0x002f
            com.f.a.ah r1 = r15.f3765b
            boolean r1 = r1.f3636m
            if (r1 == 0) goto L_0x0062
            java.lang.String r1 = "Hunter"
            java.lang.String r4 = "decoded"
            com.f.a.au r5 = r15.f3770g
            java.lang.String r5 = r5.mo16321a()
            com.p055f.p056a.C1584bj.m3557a(r1, r4, r5)
        L_0x0062:
            com.f.a.bb r1 = r15.f3768e
            r4 = 2
            r1.mo16338a(r0, r4)
            com.f.a.au r1 = r15.f3770g
            boolean r4 = r1.mo16324d()
            if (r4 != 0) goto L_0x0076
            boolean r1 = r1.mo16325e()
            if (r1 == 0) goto L_0x0133
        L_0x0076:
            if (r2 != 0) goto L_0x007c
            int r1 = r15.f3779p
            if (r1 == 0) goto L_0x002f
        L_0x007c:
            java.lang.Object r7 = f3760s
            monitor-enter(r7)
            com.f.a.au r1 = r15.f3770g     // Catch:{ all -> 0x013b }
            boolean r1 = r1.mo16324d()     // Catch:{ all -> 0x013b }
            if (r1 != 0) goto L_0x008b
            int r1 = r15.f3779p     // Catch:{ all -> 0x013b }
            if (r1 == 0) goto L_0x0100
        L_0x008b:
            com.f.a.au r2 = r15.f3770g     // Catch:{ all -> 0x013b }
            int r8 = r15.f3779p     // Catch:{ all -> 0x013b }
            int r1 = r0.getWidth()     // Catch:{ all -> 0x013b }
            int r4 = r0.getHeight()     // Catch:{ all -> 0x013b }
            android.graphics.Matrix r5 = new android.graphics.Matrix     // Catch:{ all -> 0x013b }
            r5.<init>()     // Catch:{ all -> 0x013b }
            boolean r6 = r2.mo16324d()     // Catch:{ all -> 0x013b }
            if (r6 == 0) goto L_0x017d
            int r9 = r2.f3680h     // Catch:{ all -> 0x013b }
            int r10 = r2.f3681i     // Catch:{ all -> 0x013b }
            float r6 = r2.f3684l     // Catch:{ all -> 0x013b }
            r11 = 0
            int r11 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r11 == 0) goto L_0x00b8
            boolean r11 = r2.f3687o     // Catch:{ all -> 0x013b }
            if (r11 == 0) goto L_0x0136
            float r11 = r2.f3685m     // Catch:{ all -> 0x013b }
            float r12 = r2.f3686n     // Catch:{ all -> 0x013b }
            r5.setRotate(r6, r11, r12)     // Catch:{ all -> 0x013b }
        L_0x00b8:
            boolean r6 = r2.f3682j     // Catch:{ all -> 0x013b }
            if (r6 == 0) goto L_0x014e
            float r2 = (float) r9     // Catch:{ all -> 0x013b }
            float r6 = (float) r1     // Catch:{ all -> 0x013b }
            float r2 = r2 / r6
            float r6 = (float) r10     // Catch:{ all -> 0x013b }
            float r9 = (float) r4     // Catch:{ all -> 0x013b }
            float r6 = r6 / r9
            int r9 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x013e
            float r9 = (float) r4     // Catch:{ all -> 0x013b }
            float r6 = r6 / r2
            float r6 = r6 * r9
            double r10 = (double) r6     // Catch:{ all -> 0x013b }
            double r10 = java.lang.Math.ceil(r10)     // Catch:{ all -> 0x013b }
            int r6 = (int) r10     // Catch:{ all -> 0x013b }
            int r4 = r4 - r6
            int r4 = r4 / 2
            r13 = r2
            r2 = r4
            r4 = r6
            r6 = r13
            r14 = r1
            r1 = r3
            r3 = r14
        L_0x00d9:
            r5.preScale(r6, r6)     // Catch:{ all -> 0x013b }
        L_0x00dc:
            if (r8 == 0) goto L_0x00e2
            float r6 = (float) r8     // Catch:{ all -> 0x013b }
            r5.preRotate(r6)     // Catch:{ all -> 0x013b }
        L_0x00e2:
            r6 = 1
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x013b }
            if (r1 == r0) goto L_0x00ed
            r0.recycle()     // Catch:{ all -> 0x013b }
            r0 = r1
        L_0x00ed:
            com.f.a.ah r1 = r15.f3765b     // Catch:{ all -> 0x013b }
            boolean r1 = r1.f3636m     // Catch:{ all -> 0x013b }
            if (r1 == 0) goto L_0x0100
            java.lang.String r1 = "Hunter"
            java.lang.String r2 = "transformed"
            com.f.a.au r3 = r15.f3770g     // Catch:{ all -> 0x013b }
            java.lang.String r3 = r3.mo16321a()     // Catch:{ all -> 0x013b }
            com.p055f.p056a.C1584bj.m3557a(r1, r2, r3)     // Catch:{ all -> 0x013b }
        L_0x0100:
            com.f.a.au r1 = r15.f3770g     // Catch:{ all -> 0x013b }
            boolean r1 = r1.mo16325e()     // Catch:{ all -> 0x013b }
            if (r1 == 0) goto L_0x0125
            com.f.a.au r1 = r15.f3770g     // Catch:{ all -> 0x013b }
            java.util.List<com.f.a.bh> r1 = r1.f3679g     // Catch:{ all -> 0x013b }
            android.graphics.Bitmap r0 = m3569a(r1, r0)     // Catch:{ all -> 0x013b }
            com.f.a.ah r1 = r15.f3765b     // Catch:{ all -> 0x013b }
            boolean r1 = r1.f3636m     // Catch:{ all -> 0x013b }
            if (r1 == 0) goto L_0x0125
            java.lang.String r1 = "Hunter"
            java.lang.String r2 = "transformed"
            com.f.a.au r3 = r15.f3770g     // Catch:{ all -> 0x013b }
            java.lang.String r3 = r3.mo16321a()     // Catch:{ all -> 0x013b }
            java.lang.String r4 = "from custom transformations"
            com.p055f.p056a.C1584bj.m3558a(r1, r2, r3, r4)     // Catch:{ all -> 0x013b }
        L_0x0125:
            monitor-exit(r7)     // Catch:{ all -> 0x013b }
            if (r0 == 0) goto L_0x002f
            com.f.a.bb r1 = r15.f3768e
            r2 = 3
            r1.mo16338a(r0, r2)
            goto L_0x002f
        L_0x0130:
            r1 = r3
            goto L_0x0037
        L_0x0133:
            r2 = r3
            goto L_0x0076
        L_0x0136:
            r5.setRotate(r6)     // Catch:{ all -> 0x013b }
            goto L_0x00b8
        L_0x013b:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x013b }
            throw r0
        L_0x013e:
            float r9 = (float) r1
            float r2 = r2 / r6
            float r2 = r2 * r9
            double r10 = (double) r2
            double r10 = java.lang.Math.ceil(r10)     // Catch:{ all -> 0x013b }
            int r2 = (int) r10     // Catch:{ all -> 0x013b }
            int r1 = r1 - r2
            int r1 = r1 / 2
            r13 = r2
            r2 = r3
            r3 = r13
            goto L_0x00d9
        L_0x014e:
            boolean r2 = r2.f3683k     // Catch:{ all -> 0x013b }
            if (r2 == 0) goto L_0x0167
            float r2 = (float) r9     // Catch:{ all -> 0x013b }
            float r6 = (float) r1     // Catch:{ all -> 0x013b }
            float r2 = r2 / r6
            float r6 = (float) r10     // Catch:{ all -> 0x013b }
            float r9 = (float) r4     // Catch:{ all -> 0x013b }
            float r6 = r6 / r9
            int r9 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r9 >= 0) goto L_0x0165
        L_0x015c:
            r5.preScale(r2, r2)     // Catch:{ all -> 0x013b }
            r2 = r3
            r13 = r1
            r1 = r3
            r3 = r13
            goto L_0x00dc
        L_0x0165:
            r2 = r6
            goto L_0x015c
        L_0x0167:
            if (r9 != 0) goto L_0x016b
            if (r10 == 0) goto L_0x017d
        L_0x016b:
            if (r9 != r1) goto L_0x016f
            if (r10 == r4) goto L_0x017d
        L_0x016f:
            if (r9 == 0) goto L_0x0183
            float r2 = (float) r9     // Catch:{ all -> 0x013b }
            float r6 = (float) r1     // Catch:{ all -> 0x013b }
            float r2 = r2 / r6
            r6 = r2
        L_0x0175:
            if (r10 == 0) goto L_0x0188
            float r2 = (float) r10     // Catch:{ all -> 0x013b }
            float r9 = (float) r4     // Catch:{ all -> 0x013b }
            float r2 = r2 / r9
        L_0x017a:
            r5.preScale(r6, r2)     // Catch:{ all -> 0x013b }
        L_0x017d:
            r2 = r3
            r13 = r1
            r1 = r3
            r3 = r13
            goto L_0x00dc
        L_0x0183:
            float r2 = (float) r10
            float r6 = (float) r4
            float r2 = r2 / r6
            r6 = r2
            goto L_0x0175
        L_0x0188:
            float r2 = (float) r9
            float r9 = (float) r1
            float r2 = r2 / r9
            goto L_0x017a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p055f.p056a.BitmapHunter.m3571c():android.graphics.Bitmap");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16344a(Action aVar) {
        boolean z;
        boolean z2;
        int i;
        boolean z3 = true;
        int i2 = 0;
        if (this.f3773j == aVar) {
            this.f3773j = null;
            z = true;
        } else if (this.f3774k != null) {
            z = this.f3774k.remove(aVar);
        } else {
            z = false;
        }
        if (z && aVar.f3590b.f3689q == this.f3781r) {
            int i3 = C1574ao.f3658a;
            if (this.f3774k == null || this.f3774k.isEmpty()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (this.f3773j == null && !z2) {
                z3 = false;
            }
            if (z3) {
                if (this.f3773j != null) {
                    i = this.f3773j.f3590b.f3689q;
                } else {
                    i = i3;
                }
                if (z2) {
                    int size = this.f3774k.size();
                    while (i2 < size) {
                        int i4 = ((Action) this.f3774k.get(i2)).f3590b.f3689q;
                        if (i4 - 1 <= i - 1) {
                            i4 = i;
                        }
                        i2++;
                        i = i4;
                    }
                }
            } else {
                i = i3;
            }
            this.f3781r = i;
        }
//        if (this.f3765b.f3636m) {
//            C1584bj.m3558a("Hunter", "removed", aVar.f3590b.mo16321a(), C1584bj.m3554a(this, "from "));
//        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo16345a() {
        if (this.f3773j != null) {
            return false;
        }
        if ((this.f3774k == null || this.f3774k.isEmpty()) && this.f3776m != null && this.f3776m.cancel(false)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final boolean mo16346b() {
        return this.f3776m != null && this.f3776m.isCancelled();
    }

    /* renamed from: a */
    static BitmapHunter m3570a(Picasso ahVar, Dispatcher qVar, Cache kVar, Stats bbVar, Action aVar) {
//        Request auVar = aVar.f3590b;
//        List<RequestHandler> list = ahVar.f3627d;
//        int size = list.size();
//        for (int i = 0; i < size; i++) {
//            RequestHandler ayVar = (RequestHandler) list.get(i);
//            if (ayVar.canHandleRequest(auVar)) {
//                return new BitmapHunter(ahVar, qVar, kVar, bbVar, aVar, ayVar);
//            }
//        }
        return new BitmapHunter(ahVar, qVar, kVar, bbVar, aVar, f3763v);
    }

    /* renamed from: a */
    private static Bitmap m3569a(List<Transformation> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        Bitmap bitmap2 = bitmap;
        while (i < size) {
            Transformation bhVar = (Transformation) list.get(i);
//            try {
//                Bitmap transform = bhVar.transform(bitmap2);
//                if (transform == null) {
//                    StringBuilder append = new StringBuilder("Transformation ").append(bhVar.key()).append(" returned null after ").append(i).append(" previous transformation(s).\n\nTransformation list:\n");
//                    for (Transformation key : list) {
//                        append.append(key.key()).append(10);
//                    }
//                    Picasso.f3624a.post(new C1590h(append));
//                    return null;
//                } else if (transform == bitmap2 && bitmap2.isRecycled()) {
//                    Picasso.f3624a.post(new C1591i(bhVar));
//                    return null;
//                } else if (transform == bitmap2 || bitmap2.isRecycled()) {
//                    i++;
//                    bitmap2 = transform;
//                } else {
//                    Picasso.f3624a.post(new C1592j(bhVar));
//                    return null;
//                }
//            } catch (RuntimeException e) {
//                Picasso.f3624a.post(new C1589g(bhVar, e));
//                return null;
//            }
        }
        return bitmap2;
    }
}
