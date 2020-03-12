package com.baicizhan.client.business.util.Aa;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: com.f.a.bb */
final class Stats {

    /* renamed from: a */
    final HandlerThread f3723a = new HandlerThread("Picasso-Stats", 10);

    /* renamed from: b */
    final Cache f3724b;

    /* renamed from: c */
    final Handler f3725c;

    /* renamed from: d */
    long f3726d;

    /* renamed from: e */
    long f3727e;

    /* renamed from: f */
    long f3728f;

    /* renamed from: g */
    long f3729g;

    /* renamed from: h */
    long f3730h;

    /* renamed from: i */
    long f3731i;

    /* renamed from: j */
    long f3732j;

    /* renamed from: k */
    long f3733k;

    /* renamed from: l */
    int f3734l;

    /* renamed from: m */
    int f3735m;

    /* renamed from: n */
    int f3736n;

    Stats(Cache kVar) {
        this.f3724b = kVar;
        this.f3723a.start();
        this.f3725c = new C1582bc(this.f3723a.getLooper(), this);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16337a() {
        this.f3725c.sendEmptyMessage(0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16338a(Bitmap bitmap, int i) {
        this.f3725c.sendMessage(this.f3725c.obtainMessage(i, C1584bj.m3546a(bitmap), 0));
    }
}
