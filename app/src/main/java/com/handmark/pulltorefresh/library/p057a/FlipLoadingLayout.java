package com.handmark.pulltorefresh.library.p057a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView.ScaleType;
import com.handmark.pulltorefresh.library.C1607ad;
import com.handmark.pulltorefresh.library.C1620n;
import com.handmark.pulltorefresh.library.C1627u;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.handmark.pulltorefresh.library.a.b */
public final class FlipLoadingLayout extends LoadingLayout {

    /* renamed from: f */
    private final Animation f3819f;

    /* renamed from: g */
    private final Animation f3820g;

    public FlipLoadingLayout(Context context, C1620n nVar, int i, TypedArray typedArray) {
        super(context, nVar, i, typedArray);
        int i2 = nVar == C1620n.PULL_FROM_START ? -180 : 180;
        this.f3819f = new RotateAnimation(0.0f, (float) i2, 1, 0.5f, 1, 0.5f);
        this.f3819f.setInterpolator(f3828a);
        this.f3819f.setDuration(150);
        this.f3819f.setFillAfter(true);
        this.f3820g = new RotateAnimation((float) i2, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f3820g.setInterpolator(f3828a);
        this.f3820g.setDuration(150);
        this.f3820g.setFillAfter(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo16380a(Drawable drawable) {
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            LayoutParams layoutParams = this.f3829b.getLayoutParams();
            int max = Math.max(intrinsicHeight, intrinsicWidth);
            layoutParams.height = max;
            layoutParams.width = max;
            this.f3829b.requestLayout();
            this.f3829b.setScaleType(ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.postTranslate(((float) (layoutParams.width - intrinsicWidth)) / 2.0f, ((float) (layoutParams.height - intrinsicHeight)) / 2.0f);
            matrix.postRotate(getDrawableRotationAngle(), ((float) layoutParams.width) / 2.0f, ((float) layoutParams.height) / 2.0f);
            this.f3829b.setImageMatrix(matrix);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo16379a(float f) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo16378a() {
        if (this.f3819f == this.f3829b.getAnimation()) {
            this.f3829b.startAnimation(this.f3820g);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo16381b() {
        this.f3829b.clearAnimation();
        this.f3829b.setVisibility(4);
        this.f3830c.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final void mo16382c() {
        this.f3829b.startAnimation(this.f3819f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final void mo16383d() {
        this.f3829b.clearAnimation();
        this.f3830c.setVisibility(8);
        this.f3829b.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public final int getDefaultDrawableResId() {
        return C1607ad.default_ptr_flip;
    }

    private float getDrawableRotationAngle() {
        switch (C1600c.f3821a[this.f3831d.ordinal()]) {
            case 1:
                if (this.f3832e == C1627u.f3871b) {
                    return 90.0f;
                }
                return 180.0f;
            case 2:
                if (this.f3832e == C1627u.f3871b) {
                    return 270.0f;
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }
}
