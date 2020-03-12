package com.handmark.pulltorefresh.library;

import android.os.Build.VERSION;
import android.view.animation.Interpolator;

/* renamed from: com.handmark.pulltorefresh.library.v */
/* compiled from: PullToRefreshBase */
final class C1628v implements Runnable {

    /* renamed from: a */
    boolean f3873a = true;

    /* renamed from: b */
    final /* synthetic */ PullToRefreshBase f3874b;

    /* renamed from: c */
    private final Interpolator f3875c;

    /* renamed from: d */
    private final int f3876d;

    /* renamed from: e */
    private final int f3877e;

    /* renamed from: f */
    private final long f3878f;

    /* renamed from: g */
    private C1626t f3879g;

    /* renamed from: h */
    private long f3880h = -1;

    /* renamed from: i */
    private int f3881i = -1;

    public C1628v(PullToRefreshBase gVar, int i, int i2, long j, C1626t tVar) {
        this.f3874b = gVar;
        this.f3877e = i;
        this.f3876d = i2;
        this.f3875c = gVar.mScrollAnimationInterpolator;
        this.f3878f = j;
        this.f3879g = tVar;
    }

    public final void run() {
        if (this.f3880h == -1) {
            this.f3880h = System.currentTimeMillis();
        } else {
            float f = (float) (this.f3877e - this.f3876d);
            this.f3881i = this.f3877e - Math.round(this.f3875c.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.f3880h) * 1000) / this.f3878f, 1000), 0)) / 1000.0f) * f);
            this.f3874b.setHeaderScroll(this.f3881i);
        }
        if (this.f3873a && this.f3876d != this.f3881i) {
            PullToRefreshBase gVar = this.f3874b;
            if (VERSION.SDK_INT >= 16) {
                gVar.postOnAnimation(this);
            } else {
                gVar.postDelayed(this, 16);
            }
        } else if (this.f3879g != null) {
            this.f3879g.mo16490a();
        }
    }
}
