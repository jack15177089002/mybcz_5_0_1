package com.baicizhan.client.business.util.Aa;

import android.content.Context;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* renamed from: com.f.a.aj */
/* compiled from: Picasso */
public final class C1569aj {

    /* renamed from: a */
    public Cache f3640a;

    /* renamed from: b */
    public List<RequestHandler> f3641b;

    /* renamed from: c */
    private final Context f3642c;

    /* renamed from: d */
    private Downloader f3643d;

    /* renamed from: e */
    private ExecutorService f3644e;

    /* renamed from: f */
    private C1572am f3645f;

    /* renamed from: g */
    private C1575ap f3646g;

    /* renamed from: h */
    private boolean f3647h;

    /* renamed from: i */
    private boolean f3648i;

    public C1569aj(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.f3642c = context.getApplicationContext();
    }

    /* renamed from: a */
    public final Picasso mo16310a() {
        Context context = this.f3642c;
        if (this.f3643d == null) {
//            this.f3643d = C1584bj.m3549a(context);
        }
        if (this.f3640a == null) {
            this.f3640a = new C1566ab(context);
        }
        if (this.f3644e == null) {
            this.f3644e = new PicassoExecutorService();
        }
        if (this.f3646g == null) {
            this.f3646g = C1575ap.f3662a;
        }
        Stats bbVar = new Stats(this.f3640a);
        return new Picasso(context, new Dispatcher(context, this.f3644e, Picasso.f3624a, this.f3643d, this.f3640a, bbVar), this.f3640a, this.f3645f, this.f3646g, this.f3641b, bbVar, this.f3647h, this.f3648i);
    }
}
