package com.handmark.pulltorefresh.library.p057a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.C1608ae;
import com.handmark.pulltorefresh.library.C1609af;
import com.handmark.pulltorefresh.library.C1610ag;
import com.handmark.pulltorefresh.library.C1611ah;
import com.handmark.pulltorefresh.library.C1620n;
import com.handmark.pulltorefresh.library.C1627u;
import com.handmark.pulltorefresh.library.ILoadingLayout;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.handmark.pulltorefresh.library.a.f */
public abstract class LoadingLayout extends LinearLayout implements ILoadingLayout {

    /* renamed from: a */
    static final Interpolator f3828a = new LinearInterpolator();

    /* renamed from: b */
    protected final ImageView f3829b;

    /* renamed from: c */
    protected final ProgressBar f3830c;

    /* renamed from: d */
    protected final C1620n f3831d;

    /* renamed from: e */
    protected final int f3832e;

    /* renamed from: f */
    private LinearLayout f3833f;

    /* renamed from: g */
    private boolean f3834g;

    /* renamed from: h */
    private final TextView f3835h;

    /* renamed from: i */
    private final TextView f3836i;

    /* renamed from: j */
    private CharSequence f3837j;

    /* renamed from: k */
    private CharSequence f3838k;

    /* renamed from: l */
    private CharSequence f3839l;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo16378a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo16379a(float f);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo16380a(Drawable drawable);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo16381b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo16382c();

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract void mo16383d();

    /* access modifiers changed from: protected */
    public abstract int getDefaultDrawableResId();

    public LoadingLayout(Context context, C1620n nVar, int i, TypedArray typedArray) {
        super(context);
        this.f3831d = nVar;
        this.f3832e = i;
        switch (C1602g.f3840a[i - 1]) {
            case 1:
                LayoutInflater.from(context).inflate(C1609af.pull_to_refresh_header_horizontal, this);
                break;
            default:
                LayoutInflater.from(context).inflate(C1609af.pull_to_refresh_header_vertical, this);
                break;
        }
        this.f3833f = (LinearLayout) findViewById(C1608ae.fl_inner);
        this.f3835h = (TextView) this.f3833f.findViewById(C1608ae.pull_to_refresh_text);
        this.f3830c = (ProgressBar) this.f3833f.findViewById(C1608ae.pull_to_refresh_progress);
        this.f3836i = (TextView) this.f3833f.findViewById(C1608ae.pull_to_refresh_sub_text);
        this.f3829b = (ImageView) this.f3833f.findViewById(C1608ae.pull_to_refresh_image);
        LayoutParams layoutParams = (LayoutParams) this.f3833f.getLayoutParams();
        switch (C1602g.f3841b[nVar.ordinal()]) {
            case 1:
                layoutParams.gravity = i == C1627u.f3870a ? 48 : 3;
                this.f3837j = context.getString(C1610ag.pull_to_refresh_from_bottom_pull_label);
                this.f3838k = context.getString(C1610ag.pull_to_refresh_from_bottom_refreshing_label);
                this.f3839l = context.getString(C1610ag.pull_to_refresh_from_bottom_release_label);
                break;
            default:
                layoutParams.gravity = i == C1627u.f3870a ? 80 : 5;
                this.f3837j = context.getString(C1610ag.pull_to_refresh_pull_label);
                this.f3838k = context.getString(C1610ag.pull_to_refresh_refreshing_label);
                this.f3839l = context.getString(C1610ag.pull_to_refresh_release_label);
                break;
        }
        if (typedArray.hasValue(C1611ah.PullToRefresh_ptrHeaderBackground)) {
            Drawable drawable = typedArray.getDrawable(C1611ah.PullToRefresh_ptrHeaderBackground);
            if (drawable != null) {
                C1604j.m3631a(this, drawable);
            }
        }
        if (typedArray.hasValue(C1611ah.PullToRefresh_ptrHeaderTextAppearance)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(C1611ah.PullToRefresh_ptrHeaderTextAppearance, typedValue);
            setTextAppearance(typedValue.data);
        }
        if (typedArray.hasValue(C1611ah.PullToRefresh_ptrSubHeaderTextAppearance)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(C1611ah.PullToRefresh_ptrSubHeaderTextAppearance, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        if (typedArray.hasValue(C1611ah.PullToRefresh_ptrHeaderTextSize)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(C1611ah.PullToRefresh_ptrHeaderTextSize, 0);
            if (this.f3835h != null) {
                this.f3835h.setTextSize(0, (float) dimensionPixelSize);
            }
        }
        if (typedArray.hasValue(C1611ah.PullToRefresh_ptrHeaderSubTextSize)) {
            int dimensionPixelSize2 = typedArray.getDimensionPixelSize(C1611ah.PullToRefresh_ptrHeaderSubTextSize, 0);
            if (this.f3836i != null) {
                this.f3836i.setTextSize(0, (float) dimensionPixelSize2);
            }
        }
        if (typedArray.hasValue(C1611ah.PullToRefresh_ptrHeaderTextColor)) {
            ColorStateList colorStateList = typedArray.getColorStateList(C1611ah.PullToRefresh_ptrHeaderTextColor);
            if (colorStateList != null) {
                setTextColor(colorStateList);
            }
        }
        if (typedArray.hasValue(C1611ah.PullToRefresh_ptrHeaderSubTextColor)) {
            ColorStateList colorStateList2 = typedArray.getColorStateList(C1611ah.PullToRefresh_ptrHeaderSubTextColor);
            if (colorStateList2 != null) {
                setSubTextColor(colorStateList2);
            }
        }
        Drawable drawable2 = null;
        if (typedArray.hasValue(C1611ah.PullToRefresh_ptrDrawable)) {
            drawable2 = typedArray.getDrawable(C1611ah.PullToRefresh_ptrDrawable);
        }
        switch (C1602g.f3841b[nVar.ordinal()]) {
            case 1:
                if (!typedArray.hasValue(C1611ah.PullToRefresh_ptrDrawableEnd)) {
                    if (typedArray.hasValue(C1611ah.PullToRefresh_ptrDrawableBottom)) {
                        C1603i.m3630a("ptrDrawableBottom", "ptrDrawableEnd");
                        drawable2 = typedArray.getDrawable(C1611ah.PullToRefresh_ptrDrawableBottom);
                        break;
                    }
                } else {
                    drawable2 = typedArray.getDrawable(C1611ah.PullToRefresh_ptrDrawableEnd);
                    break;
                }
                break;
            default:
                if (!typedArray.hasValue(C1611ah.PullToRefresh_ptrDrawableStart)) {
                    if (typedArray.hasValue(C1611ah.PullToRefresh_ptrDrawableTop)) {
                        C1603i.m3630a("ptrDrawableTop", "ptrDrawableStart");
                        drawable2 = typedArray.getDrawable(C1611ah.PullToRefresh_ptrDrawableTop);
                        break;
                    }
                } else {
                    drawable2 = typedArray.getDrawable(C1611ah.PullToRefresh_ptrDrawableStart);
                    break;
                }
                break;
        }
        if (drawable2 == null) {
            drawable2 = context.getResources().getDrawable(getDefaultDrawableResId());
        }
        setLoadingDrawable(drawable2);
        mo16399i();
    }

    public final void setHeight(int i) {
        getLayoutParams().height = i;
        requestLayout();
    }

    public final void setWidth(int i) {
        getLayoutParams().width = i;
        requestLayout();
    }

    public final int getContentSize() {
        switch (C1602g.f3840a[this.f3832e - 1]) {
            case 1:
                return this.f3833f.getWidth();
            default:
                return this.f3833f.getHeight();
        }
    }

    /* renamed from: e */
    public final void mo16394e() {
        if (this.f3835h.getVisibility() == 0) {
            this.f3835h.setVisibility(4);
        }
        if (this.f3830c.getVisibility() == 0) {
            this.f3830c.setVisibility(4);
        }
        if (this.f3829b.getVisibility() == 0) {
            this.f3829b.setVisibility(4);
        }
        if (this.f3836i.getVisibility() == 0) {
            this.f3836i.setVisibility(4);
        }
    }

    /* renamed from: b */
    public final void mo16393b(float f) {
        if (!this.f3834g) {
            mo16379a(f);
        }
    }

    /* renamed from: f */
    public final void mo16395f() {
        if (this.f3835h != null) {
            this.f3835h.setText(this.f3837j);
        }
        mo16378a();
    }

    /* renamed from: g */
    public final void mo16396g() {
        if (this.f3835h != null) {
            this.f3835h.setText(this.f3838k);
        }
        if (this.f3834g) {
            ((AnimationDrawable) this.f3829b.getDrawable()).start();
        } else {
            mo16381b();
        }
        if (this.f3836i != null) {
            this.f3836i.setVisibility(8);
        }
    }

    /* renamed from: h */
    public final void mo16398h() {
        if (this.f3835h != null) {
            this.f3835h.setText(this.f3839l);
        }
        mo16382c();
    }

    /* renamed from: i */
    public final void mo16399i() {
        if (this.f3835h != null) {
            this.f3835h.setText(this.f3837j);
        }
        this.f3829b.setVisibility(0);
        if (this.f3834g) {
            ((AnimationDrawable) this.f3829b.getDrawable()).stop();
        } else {
            mo16383d();
        }
        if (this.f3836i == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f3836i.getText())) {
            this.f3836i.setVisibility(8);
        } else {
            this.f3836i.setVisibility(0);
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    public final void setLoadingDrawable(Drawable drawable) {
        this.f3829b.setImageDrawable(drawable);
        this.f3834g = drawable instanceof AnimationDrawable;
        mo16380a(drawable);
    }

    public void setPullLabel(CharSequence charSequence) {
        this.f3837j = charSequence;
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        this.f3838k = charSequence;
    }

    public void setReleaseLabel(CharSequence charSequence) {
        this.f3839l = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.f3835h.setTypeface(typeface);
    }

    /* renamed from: j */
    public final void mo16400j() {
        if (4 == this.f3835h.getVisibility()) {
            this.f3835h.setVisibility(0);
        }
        if (4 == this.f3830c.getVisibility()) {
            this.f3830c.setVisibility(0);
        }
        if (4 == this.f3829b.getVisibility()) {
            this.f3829b.setVisibility(0);
        }
        if (4 == this.f3836i.getVisibility()) {
            this.f3836i.setVisibility(0);
        }
    }

    private void setSubHeaderText(CharSequence charSequence) {
        if (this.f3836i == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f3836i.setVisibility(8);
            return;
        }
        this.f3836i.setText(charSequence);
        if (8 == this.f3836i.getVisibility()) {
            this.f3836i.setVisibility(0);
        }
    }

    private void setSubTextAppearance(int i) {
        if (this.f3836i != null) {
            this.f3836i.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        if (this.f3836i != null) {
            this.f3836i.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        if (this.f3835h != null) {
            this.f3835h.setTextAppearance(getContext(), i);
        }
        if (this.f3836i != null) {
            this.f3836i.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (this.f3835h != null) {
            this.f3835h.setTextColor(colorStateList);
        }
        if (this.f3836i != null) {
            this.f3836i.setTextColor(colorStateList);
        }
    }
}
