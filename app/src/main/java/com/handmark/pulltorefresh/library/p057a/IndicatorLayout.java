package com.handmark.pulltorefresh.library.p057a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.handmark.pulltorefresh.library.C1605ab;
import com.handmark.pulltorefresh.library.C1606ac;
import com.handmark.pulltorefresh.library.C1607ad;
import com.handmark.pulltorefresh.library.C1620n;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.handmark.pulltorefresh.library.a.d */
public final class IndicatorLayout extends FrameLayout implements AnimationListener {

    /* renamed from: a */
    private Animation f3822a;

    /* renamed from: b */
    private Animation f3823b;

    /* renamed from: c */
    private ImageView f3824c;

    /* renamed from: d */
    private final Animation f3825d;

    /* renamed from: e */
    private final Animation f3826e;

    public IndicatorLayout(Context context, C1620n nVar) {
        int i;
        int i2;
        super(context);
        this.f3824c = new ImageView(context);
        Drawable drawable = getResources().getDrawable(C1607ad.indicator_arrow);
        this.f3824c.setImageDrawable(drawable);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C1606ac.indicator_internal_padding);
        this.f3824c.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        addView(this.f3824c);
        switch (C1601e.f3827a[nVar.ordinal()]) {
            case 1:
                i = C1605ab.slide_in_from_bottom;
                i2 = C1605ab.slide_out_to_bottom;
                setBackgroundResource(C1607ad.indicator_bg_bottom);
                this.f3824c.setScaleType(ScaleType.MATRIX);
                Matrix matrix = new Matrix();
                matrix.setRotate(180.0f, ((float) drawable.getIntrinsicWidth()) / 2.0f, ((float) drawable.getIntrinsicHeight()) / 2.0f);
                this.f3824c.setImageMatrix(matrix);
                break;
            default:
                i = C1605ab.slide_in_from_top;
                i2 = C1605ab.slide_out_to_top;
                setBackgroundResource(C1607ad.indicator_bg_top);
                break;
        }
        this.f3822a = AnimationUtils.loadAnimation(context, i);
        this.f3822a.setAnimationListener(this);
        this.f3823b = AnimationUtils.loadAnimation(context, i2);
        this.f3823b.setAnimationListener(this);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.f3825d = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f3825d.setInterpolator(linearInterpolator);
        this.f3825d.setDuration(150);
        this.f3825d.setFillAfter(true);
        this.f3826e = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f3826e.setInterpolator(linearInterpolator);
        this.f3826e.setDuration(150);
        this.f3826e.setFillAfter(true);
    }

    /* renamed from: a */
    public final boolean mo16385a() {
        Animation animation = getAnimation();
        if (animation != null) {
            if (this.f3822a == animation) {
                return true;
            }
            return false;
        } else if (getVisibility() != 0) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: b */
    public final void mo16386b() {
        startAnimation(this.f3823b);
    }

    /* renamed from: c */
    public final void mo16387c() {
        this.f3824c.clearAnimation();
        startAnimation(this.f3822a);
    }

    public final void onAnimationEnd(Animation animation) {
        if (animation == this.f3823b) {
            this.f3824c.clearAnimation();
            setVisibility(8);
        } else if (animation == this.f3822a) {
            setVisibility(0);
        }
        clearAnimation();
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
        setVisibility(0);
    }

    /* renamed from: d */
    public final void mo16388d() {
        this.f3824c.startAnimation(this.f3825d);
    }

    /* renamed from: e */
    public final void mo16389e() {
        this.f3824c.startAnimation(this.f3826e);
    }
}
