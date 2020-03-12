package com.baicizhan.client.business.util.Aa;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import java.util.List;

/* renamed from: com.f.a.av */
/* compiled from: Request */
public final class C1578av {

    /* renamed from: a */
    Uri f3690a;

    /* renamed from: b */
    int f3691b;

    /* renamed from: c */
    String f3692c;

    /* renamed from: d */
    int f3693d;

    /* renamed from: e */
    int f3694e;

    /* renamed from: f */
    public boolean f3695f;

    /* renamed from: g */
    public boolean f3696g;

    /* renamed from: h */
    float f3697h;

    /* renamed from: i */
    float f3698i;

    /* renamed from: j */
    float f3699j;

    /* renamed from: k */
    boolean f3700k;

    /* renamed from: l */
    List<Transformation> f3701l;

    /* renamed from: m */
    Config f3702m;

    /* renamed from: n */
    public int f3703n;

    C1578av(Uri uri, int i) {
        this.f3690a = uri;
        this.f3691b = i;
    }

    /* renamed from: a */
    public final boolean mo16328a() {
        return (this.f3690a == null && this.f3691b == 0) ? false : true;
    }

    /* renamed from: a */
    public final C1578av mo16327a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Width must be positive number or 0.");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("Height must be positive number or 0.");
        } else if (i2 == 0 && i == 0) {
            throw new IllegalArgumentException("At least one dimension has to be positive number.");
        } else {
            this.f3693d = i;
            this.f3694e = i2;
            return this;
        }
    }
}
