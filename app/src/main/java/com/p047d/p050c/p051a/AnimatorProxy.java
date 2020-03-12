package com.p047d.p050c.p051a;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: com.d.c.a.a */
public final class AnimatorProxy extends Animation {

    /* renamed from: a */
    public static final boolean f3559a = (Integer.valueOf(VERSION.SDK).intValue() < 11);

    /* renamed from: m */
    private static final WeakHashMap<View, AnimatorProxy> f3560m = new WeakHashMap<>();

    /* renamed from: b */
    public final WeakReference<View> f3561b;

    /* renamed from: c */
    public float f3562c = 1.0f;

    /* renamed from: d */
    public float f3563d;

    /* renamed from: e */
    public float f3564e;

    /* renamed from: f */
    public float f3565f;

    /* renamed from: g */
    public float f3566g;

    /* renamed from: h */
    public float f3567h;

    /* renamed from: i */
    public float f3568i = 1.0f;

    /* renamed from: j */
    public float f3569j = 1.0f;

    /* renamed from: k */
    public float f3570k;

    /* renamed from: l */
    public float f3571l;

    /* renamed from: n */
    private final Camera f3572n = new Camera();

    /* renamed from: o */
    private boolean f3573o;

    /* renamed from: p */
    private final RectF f3574p = new RectF();

    /* renamed from: q */
    private final RectF f3575q = new RectF();

    /* renamed from: r */
    private final Matrix f3576r = new Matrix();

    /* renamed from: a */
    public static AnimatorProxy m3396a(View view) {
        AnimatorProxy aVar = (AnimatorProxy) f3560m.get(view);
        if (aVar != null && aVar == view.getAnimation()) {
            return aVar;
        }
        AnimatorProxy aVar2 = new AnimatorProxy(view);
        f3560m.put(view, aVar2);
        return aVar2;
    }

    private AnimatorProxy(View view) {
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.f3561b = new WeakReference<>(view);
    }

    /* renamed from: a */
    public final void mo16219a(float f) {
        if (this.f3562c != f) {
            this.f3562c = f;
            View view = (View) this.f3561b.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    /* renamed from: b */
    public final void mo16222b(float f) {
        if (!this.f3573o || this.f3563d != f) {
            mo16218a();
            this.f3573o = true;
            this.f3563d = f;
            mo16221b();
        }
    }

    /* renamed from: c */
    public final void mo16223c(float f) {
        if (!this.f3573o || this.f3564e != f) {
            mo16218a();
            this.f3573o = true;
            this.f3564e = f;
            mo16221b();
        }
    }

    /* renamed from: d */
    public final void mo16224d(float f) {
        if (this.f3567h != f) {
            mo16218a();
            this.f3567h = f;
            mo16221b();
        }
    }

    /* renamed from: e */
    public final void mo16225e(float f) {
        if (this.f3568i != f) {
            mo16218a();
            this.f3568i = f;
            mo16221b();
        }
    }

    /* renamed from: f */
    public final void mo16226f(float f) {
        if (this.f3569j != f) {
            mo16218a();
            this.f3569j = f;
            mo16221b();
        }
    }

    /* renamed from: g */
    public final void mo16227g(float f) {
        if (this.f3570k != f) {
            mo16218a();
            this.f3570k = f;
            mo16221b();
        }
    }

    /* renamed from: h */
    public final void mo16228h(float f) {
        if (this.f3571l != f) {
            mo16218a();
            this.f3571l = f;
            mo16221b();
        }
    }

    /* renamed from: i */
    public final void mo16229i(float f) {
        View view = (View) this.f3561b.get();
        if (view != null) {
            mo16228h(f - ((float) view.getTop()));
        }
    }

    /* renamed from: a */
    public final void mo16218a() {
        View view = (View) this.f3561b.get();
        if (view != null) {
            m3398a(this.f3574p, view);
        }
    }

    /* renamed from: b */
    public final void mo16221b() {
        View view = (View) this.f3561b.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.f3575q;
            m3398a(rectF, view);
            rectF.union(this.f3574p);
            ((View) view.getParent()).invalidate((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
        }
    }

    /* renamed from: a */
    private void m3398a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix matrix = this.f3576r;
        matrix.reset();
        m3397a(matrix, view);
        this.f3576r.mapRect(rectF);
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        if (rectF.right < rectF.left) {
            float f = rectF.right;
            rectF.right = rectF.left;
            rectF.left = f;
        }
        if (rectF.bottom < rectF.top) {
            float f2 = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f2;
        }
    }

    /* renamed from: a */
    private void m3397a(Matrix matrix, View view) {
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        boolean z = this.f3573o;
        float f = z ? this.f3563d : width / 2.0f;
        float f2 = z ? this.f3564e : height / 2.0f;
        float f3 = this.f3565f;
        float f4 = this.f3566g;
        float f5 = this.f3567h;
        if (!(f3 == 0.0f && f4 == 0.0f && f5 == 0.0f)) {
            Camera camera = this.f3572n;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        float f6 = this.f3568i;
        float f7 = this.f3569j;
        if (!(f6 == 1.0f && f7 == 1.0f)) {
            matrix.postScale(f6, f7);
            matrix.postTranslate((-(f / width)) * ((f6 * width) - width), (-(f2 / height)) * ((f7 * height) - height));
        }
        matrix.postTranslate(this.f3570k, this.f3571l);
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f, Transformation transformation) {
        View view = (View) this.f3561b.get();
        if (view != null) {
            transformation.setAlpha(this.f3562c);
            m3397a(transformation.getMatrix(), view);
        }
    }
}
