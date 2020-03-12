package com.baicizhan.client.business.util.Aa;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.f.a.aw */
public final class RequestCreator {

    /* renamed from: j */
    private static int f3704j = 0;

    /* renamed from: a */
    public final Picasso f3705a;

    /* renamed from: b */
    public final C1578av f3706b;

    /* renamed from: c */
    public boolean f3707c;

    /* renamed from: d */
    public boolean f3708d;

    /* renamed from: e */
    public boolean f3709e;

    /* renamed from: f */
    public boolean f3710f;

    /* renamed from: g */
    public int f3711g;

    /* renamed from: h */
    public Drawable f3712h;

    /* renamed from: i */
    public Object f3713i;

    /* renamed from: k */
    private int f3714k;

    /* renamed from: l */
    private Drawable f3715l;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m3531b() {
        if (C1584bj.m3562b()) {
            int i = f3704j;
            f3704j = i + 1;
            return i;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicInteger atomicInteger = new AtomicInteger();
        Picasso.f3624a.post(new C1579ax(atomicInteger, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            C1584bj.m3559a((Throwable) e);
        }
        return atomicInteger.get();
    }

    RequestCreator(Picasso ahVar, Uri uri, int i) {
        this.f3710f = true;
        if (ahVar.f3637n) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.f3705a = ahVar;
        this.f3706b = new C1578av(uri, i);
    }

    RequestCreator() {
        this.f3710f = true;
        this.f3705a = null;
        this.f3706b = new C1578av(null, 0);
    }

    /* renamed from: a */
    public final RequestCreator mo16330a(int i) {
        if (!this.f3710f) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (i == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        } else if (this.f3712h != null) {
            throw new IllegalStateException("Placeholder image already set.");
        } else {
            this.f3711g = i;
            return this;
        }
    }

    /* renamed from: b */
    public final RequestCreator mo16335b(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Error image resource invalid.");
        } else if (this.f3715l != null) {
            throw new IllegalStateException("Error image already set.");
        } else {
            this.f3714k = i;
            return this;
        }
    }

    /* renamed from: a */
    public final RequestCreator mo16331a(int i, int i2) {
        this.f3706b.mo16327a(i, i2);
        return this;
    }

    /* renamed from: a */
    public final RequestCreator mo16332a(Transformation bhVar) {
        C1578av avVar = this.f3706b;
        if (bhVar == null) {
            throw new IllegalArgumentException("Transformation must not be null.");
        } else if (bhVar.key() == null) {
            throw new IllegalArgumentException("Transformation key must not be null.");
        } else {
            if (avVar.f3701l == null) {
                avVar.f3701l = new ArrayList(2);
            }
            avVar.f3701l.add(bhVar);
            return this;
        }
    }

    /* renamed from: a */
    public final void mo16334a(Target bfVar) {
        Drawable drawable = null;
        long nanoTime = System.nanoTime();
        C1584bj.m3555a();
        if (this.f3709e) {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        } else if (!this.f3706b.mo16328a()) {
            this.f3705a.mo16306a((Object) bfVar);
            if (this.f3710f) {
                drawable = m3532c();
            }
            bfVar.onPrepareLoad(drawable);
        } else {
            Request a = mo16329a(nanoTime);
//            String a2 = C1584bj.m3551a(a);
//            if (!this.f3707c) {
//                Bitmap b = this.f3705a.mo16307b(a2);
//                if (b != null) {
//                    this.f3705a.mo16306a((Object) bfVar);
//                    bfVar.onBitmapLoaded(b, C1573an.MEMORY);
//                    return;
//                }
//            }
//            if (this.f3710f) {
//                drawable = m3532c();
//            }
//            bfVar.onPrepareLoad(drawable);
//            this.f3705a.mo16305a((Action) new TargetAction(this.f3705a, bfVar, a, this.f3707c, this.f3714k, this.f3715l, a2, this.f3713i));
        }
    }

    /* renamed from: a */
    public final void mo16333a(ImageView imageView, Callback mVar) {
        long nanoTime = System.nanoTime();
        C1584bj.m3555a();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f3706b.mo16328a()) {
            this.f3705a.mo16306a((Object) imageView);
            if (this.f3710f) {
                PicassoDrawable.m3521a(imageView, m3532c());
            }
        } else {
            if (this.f3709e) {
                C1578av avVar = this.f3706b;
                if ((avVar.f3693d == 0 && avVar.f3694e == 0) ? false : true) {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width == 0 || height == 0) {
                    if (this.f3710f) {
                        PicassoDrawable.m3521a(imageView, m3532c());
                    }
                    this.f3705a.f3633j.put(imageView, new DeferredRequestCreator(this, imageView, mVar));
                    return;
                }
                this.f3706b.mo16327a(width, height);
            }
            Request a = mo16329a(nanoTime);
//            String a2 = C1584bj.m3551a(a);
//            if (!this.f3707c) {
//                Bitmap b = this.f3705a.mo16307b(a2);
//                if (b != null) {
//                    this.f3705a.mo16306a((Object) imageView);
//                    PicassoDrawable.m3520a(imageView, this.f3705a.f3628e, b, C1573an.MEMORY, this.f3708d, this.f3705a.f3635l);
//                    if (this.f3705a.f3636m) {
//                        C1584bj.m3558a("Main", "completed", a.mo16322b(), "from " + C1573an.MEMORY);
//                    }
//                    if (mVar != null) {
//                        mVar.onSuccess();
//                        return;
//                    }
//                    return;
//                }
//            }
            if (this.f3710f) {
                PicassoDrawable.m3521a(imageView, m3532c());
            }
//            this.f3705a.mo16305a((Action) new ImageViewAction(this.f3705a, imageView, a, this.f3707c, this.f3708d, this.f3714k, this.f3715l, a2, this.f3713i, mVar));
        }
    }

    /* renamed from: c */
    private Drawable m3532c() {
        if (this.f3711g != 0) {
            return this.f3705a.f3628e.getResources().getDrawable(this.f3711g);
        }
        return this.f3712h;
    }

    /* renamed from: a */
    public final Request mo16329a(long j) {
        int b = m3531b();
        C1578av avVar = this.f3706b;
        if (avVar.f3696g && avVar.f3695f) {
            throw new IllegalStateException("Center crop and center inside can not be used together.");
        } else if (avVar.f3695f && (avVar.f3693d == 0 || avVar.f3694e == 0)) {
            throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
        } else if (!avVar.f3696g || !(avVar.f3693d == 0 || avVar.f3694e == 0)) {
            if (avVar.f3703n == 0) {
                avVar.f3703n = C1574ao.f3659b;
            }
//            Request auVar = new Request(avVar.f3690a, avVar.f3691b, avVar.f3692c, avVar.f3701l, avVar.f3693d, avVar.f3694e, avVar.f3695f, avVar.f3696g, avVar.f3697h, avVar.f3698i, avVar.f3699j, avVar.f3700k, avVar.f3702m, avVar.f3703n, 0);
//            auVar.f3673a = b;
//            auVar.f3674b = j;
//            boolean z = this.f3705a.f3636m;
//            if (z) {
//                C1584bj.m3558a("Main", "created", auVar.mo16322b(), auVar.toString());
//            }
//            Picasso ahVar = this.f3705a;
//            Request a = ahVar.f3626c.mo16313a(auVar);
//            if (a == null) {
//                throw new IllegalStateException("Request transformer " + ahVar.f3626c.getClass().getCanonicalName() + " returned null for " + auVar);
//            }
//            if (a != auVar) {
//                a.f3673a = b;
//                a.f3674b = j;
//                if (z) {
//                    C1584bj.m3558a("Main", "changed", a.mo16321a(), "into " + a);
//                }
//            }
//            return a;
        } else {
            throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
        }

        return null;
    }
}
