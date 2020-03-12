package com.baicizhan.client.business.util.Aa;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

//import com.squareup.picasso.Picasso;
//import com.squareup.picasso.Request;

import java.lang.ref.WeakReference;

/* renamed from: com.f.a.a */
abstract class Action<T> {

    /* renamed from: a */
    final Picasso f3589a;

    /* renamed from: b */
    final Request f3590b;

    /* renamed from: c */
    final WeakReference<T> f3591c = null;

    /* renamed from: d */
    final boolean f3592d;

    /* renamed from: e */
    final boolean f3593e;

    /* renamed from: f */
    final int f3594f;

    /* renamed from: g */
    final Drawable f3595g;

    /* renamed from: h */
    final String f3596h;

    /* renamed from: i */
    final Object f3597i;

    /* renamed from: j */
    boolean f3598j;

    /* renamed from: k */
    boolean f3599k;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo16276a();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo16277a(Bitmap bitmap, C1573an anVar);

    Action(Picasso ahVar, T t, Request auVar, boolean z, boolean z2, int i, Drawable drawable, String str, Object obj) {
        this.f3589a = ahVar;
        this.f3590b = auVar;
//        this.f3591c = t == null ? null : new C1581b(this, t, ahVar.f3634k);
        this.f3592d = z;
        this.f3593e = z2;
        this.f3594f = i;
        this.f3595g = drawable;
        this.f3596h = str;
        if (obj == 0) {
            obj = this;
        }
        this.f3597i = obj;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo16278b() {
        this.f3599k = true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public T mo16279c() {
        if (this.f3591c == null) {
            return null;
        }
        return this.f3591c.get();
    }
}
