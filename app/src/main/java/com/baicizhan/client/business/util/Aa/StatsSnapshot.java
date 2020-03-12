package com.baicizhan.client.business.util.Aa;

import p012ch.qos.logback.core.CoreConstants;

/* renamed from: com.f.a.be */
public final class StatsSnapshot {

    /* renamed from: a */
    public final int f3740a;

    /* renamed from: b */
    public final int f3741b;

    /* renamed from: c */
    public final long f3742c;

    /* renamed from: d */
    public final long f3743d;

    /* renamed from: e */
    public final long f3744e;

    /* renamed from: f */
    public final long f3745f;

    /* renamed from: g */
    public final long f3746g;

    /* renamed from: h */
    public final long f3747h;

    /* renamed from: i */
    public final long f3748i;

    /* renamed from: j */
    public final long f3749j;

    /* renamed from: k */
    public final int f3750k;

    /* renamed from: l */
    public final int f3751l;

    /* renamed from: m */
    public final int f3752m;

    /* renamed from: n */
    public final long f3753n;

    public StatsSnapshot(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.f3740a = i;
        this.f3741b = i2;
        this.f3742c = j;
        this.f3743d = j2;
        this.f3744e = j3;
        this.f3745f = j4;
        this.f3746g = j5;
        this.f3747h = j6;
        this.f3748i = j7;
        this.f3749j = j8;
        this.f3750k = i3;
        this.f3751l = i4;
        this.f3752m = i5;
        this.f3753n = j9;
    }

    public final String toString() {
        return "StatsSnapshot{maxSize=" + this.f3740a + ", size=" + this.f3741b + ", cacheHits=" + this.f3742c + ", cacheMisses=" + this.f3743d + ", downloadCount=" + this.f3750k + ", totalDownloadSize=" + this.f3744e + ", averageDownloadSize=" + this.f3747h + ", totalOriginalBitmapSize=" + this.f3745f + ", totalTransformedBitmapSize=" + this.f3746g + ", averageOriginalBitmapSize=" + this.f3748i + ", averageTransformedBitmapSize=" + this.f3749j + ", originalBitmapCount=" + this.f3751l + ", transformedBitmapCount=" + this.f3752m + ", timeStamp=" + this.f3753n + CoreConstants.CURLY_RIGHT;
    }
}
