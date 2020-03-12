package com.handmark.pulltorefresh.library.p057a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView.ScaleType;
import com.handmark.pulltorefresh.library.C1607ad;
import com.handmark.pulltorefresh.library.C1611ah;
import com.handmark.pulltorefresh.library.C1620n;

/* renamed from: com.handmark.pulltorefresh.library.a.h */
public final class RotateLoadingLayout extends LoadingLayout {

    /* renamed from: f */
    private final Animation f3842f;

    /* renamed from: g */
    private final Matrix f3843g = new Matrix();

    /* renamed from: h */
    private float f3844h;

    /* renamed from: i */
    private float f3845i;

    /* renamed from: j */
    private final boolean f3846j;

    public RotateLoadingLayout(Context context, C1620n nVar, int i, TypedArray typedArray) {
        super(context, nVar, i, typedArray);
        this.f3846j = typedArray.getBoolean(C1611ah.PullToRefresh_ptrRotateDrawableWhilePulling, true);
        this.f3829b.setScaleType(ScaleType.MATRIX);
        this.f3829b.setImageMatrix(this.f3843g);
        this.f3842f = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.f3842f.setInterpolator(f3828a);
        this.f3842f.setDuration(1200);
        this.f3842f.setRepeatCount(-1);
        this.f3842f.setRepeatMode(1);
    }

    /* renamed from: a */
    public final void mo16380a(Drawable drawable) {
        if (drawable != null) {
            this.f3844h = (float) Math.round(((float) drawable.getIntrinsicWidth()) / 2.0f);
            this.f3845i = (float) Math.round(((float) drawable.getIntrinsicHeight()) / 2.0f);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo16379a(float f) {
        float max;
        if (this.f3846j) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.f3843g.setRotate(max, this.f3844h, this.f3845i);
        this.f3829b.setImageMatrix(this.f3843g);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo16381b() {
        this.f3829b.startAnimation(this.f3842f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final void mo16383d() {
        this.f3829b.clearAnimation();
        if (this.f3843g != null) {
            this.f3843g.reset();
            this.f3829b.setImageMatrix(this.f3843g);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo16378a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo16382c() {
    }

    /* access modifiers changed from: protected */
    public final int getDefaultDrawableResId() {
        return C1607ad.default_ptr_rotate;
    }
}
