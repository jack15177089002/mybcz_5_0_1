package com.baicizhan.client.business.util.Aa;

import android.content.Context;
import android.graphics.Bitmap;

//import com.squareup.picasso.Cache;

import java.util.LinkedHashMap;

/* renamed from: com.f.a.ab */
/* compiled from: LruCache */
public class zzzzzzzzzzz {

    /* renamed from: b */
    LinkedHashMap<String, Bitmap> hashMap;

    /* renamed from: c */
    private int f3602c;

    /* renamed from: d */
    private int f3603d;

    /* renamed from: e */
    private int f3604e;

    /* renamed from: f */
    private int f3605f;

    /* renamed from: g */
    private int f3606g;

    /* renamed from: h */
    private int f3607h;

    public zzzzzzzzzzz(Context context) {
//        this(C1584bj.m3565c(context));
    }

    public zzzzzzzzzzz(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.f3602c = i;
        this.hashMap = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* renamed from: a */
    public Bitmap get(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap bitmap = (Bitmap) this.hashMap.get(str);
            if (bitmap != null) {
                this.f3606g++;
                return bitmap;
            }
            this.f3607h++;
            return null;
        }
    }

    public final void set(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
//            this.f3604e++;
//            this.f3603d += C1584bj.m3546a(bitmap);
//            Bitmap bitmap2 = (Bitmap) this.hashMap.put(str, bitmap);
//            if (bitmap2 != null) {
//                this.f3603d -= C1584bj.m3546a(bitmap2);
//            }
        }
        mo16282a(this.f3602c);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo16282a(int r4) {
        /*
            r3 = this;
        L_0x0000:
            monitor-enter(r3)
            int r0 = r3.f3603d     // Catch:{ all -> 0x0032 }
            if (r0 < 0) goto L_0x0011
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.hashMap     // Catch:{ all -> 0x0032 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0035
            int r0 = r3.f3603d     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0035
        L_0x0011:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r1.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.Class r2 = r3.getClass()     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0032 }
            r0.<init>(r1)     // Catch:{ all -> 0x0032 }
            throw r0     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0032 }
            throw r0
        L_0x0035:
            int r0 = r3.f3603d     // Catch:{ all -> 0x0032 }
            if (r0 <= r4) goto L_0x0041
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.hashMap     // Catch:{ all -> 0x0032 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0043
        L_0x0041:
            monitor-exit(r3)     // Catch:{ all -> 0x0032 }
            return
        L_0x0043:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.hashMap     // Catch:{ all -> 0x0032 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0032 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x0032 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0032 }
            java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0032 }
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch:{ all -> 0x0032 }
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.hashMap     // Catch:{ all -> 0x0032 }
            r2.remove(r1)     // Catch:{ all -> 0x0032 }
            int r1 = r3.f3603d     // Catch:{ all -> 0x0032 }
            int r0 = com.p055f.p056a.C1584bj.m3546a(r0)     // Catch:{ all -> 0x0032 }
            int r0 = r1 - r0
            r3.f3603d = r0     // Catch:{ all -> 0x0032 }
            int r0 = r3.f3605f     // Catch:{ all -> 0x0032 }
            int r0 = r0 + 1
            r3.f3605f = r0     // Catch:{ all -> 0x0032 }
            monitor-exit(r3)     // Catch:{ all -> 0x0032 }
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p055f.p056a.C1566ab.mo16282a(int):void");
    }

    /* renamed from: a */
    public final synchronized int mo16280a() {
        return this.f3603d;
    }

    /* renamed from: b */
    public final synchronized int mo16284b() {
        return this.f3602c;
    }


}
