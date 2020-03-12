package com.jeremyfeinstein.slidingmenu.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.jeremyfeinstein.slidingmenu.lib.f */
public final class CustomViewBehind extends ViewGroup {

    /* renamed from: a */
    int f3941a;

    /* renamed from: b */
    View f3942b;

    /* renamed from: c */
    View f3943c;

    /* renamed from: d */
    int f3944d;

    /* renamed from: e */
    int f3945e;

    /* renamed from: f */
    boolean f3946f;

    /* renamed from: g */
    final Paint f3947g;

    /* renamed from: h */
    float f3948h;

    /* renamed from: i */
    Drawable f3949i;

    /* renamed from: j */
    Drawable f3950j;

    /* renamed from: k */
    int f3951k;

    /* renamed from: l */
    float f3952l;

    /* renamed from: m */
    boolean f3953m;

    /* renamed from: n */
    Bitmap f3954n;

    /* renamed from: o */
    View f3955o;

    /* renamed from: p */
    private CustomViewAbove f3956p;

    /* renamed from: q */
    private int f3957q;

    /* renamed from: r */
    private C1644m f3958r;

    /* renamed from: s */
    private boolean f3959s;

    public CustomViewBehind(Context context) {
        this(context, (byte) 0);
    }

    private CustomViewBehind(Context context, byte b) {
        super(context, null);
        this.f3941a = 0;
        this.f3947g = new Paint();
        this.f3953m = true;
        this.f3944d = (int) TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics());
    }

    public final void setCustomViewAbove(CustomViewAbove aVar) {
        this.f3956p = aVar;
    }

    public final void setCanvasTransformer(C1644m mVar) {
        this.f3958r = mVar;
    }

    public final void setWidthOffset(int i) {
        this.f3957q = i;
        requestLayout();
    }

    public final void setMarginThreshold(int i) {
        this.f3944d = i;
    }

    public final int getMarginThreshold() {
        return this.f3944d;
    }

    public final int getBehindWidth() {
        return this.f3942b.getWidth();
    }

    public final void setContent(View view) {
        if (this.f3942b != null) {
            removeView(this.f3942b);
        }
        this.f3942b = view;
        addView(this.f3942b);
    }

    public final View getContent() {
        return this.f3942b;
    }

    public final void setSecondaryContent(View view) {
        if (this.f3943c != null) {
            removeView(this.f3943c);
        }
        this.f3943c = view;
        addView(this.f3943c);
    }

    public final View getSecondaryContent() {
        return this.f3943c;
    }

    public final void setChildrenEnabled(boolean z) {
        this.f3959s = z;
    }

    public final void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
        if (this.f3958r != null) {
            invalidate();
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.f3959s;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return !this.f3959s;
    }

    /* access modifiers changed from: protected */
    public final void dispatchDraw(Canvas canvas) {
        if (this.f3958r != null) {
            canvas.save();
            this.f3958r.transformCanvas(canvas, this.f3956p.getPercentOpen());
            super.dispatchDraw(canvas);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.f3942b.layout(0, 0, i5 - this.f3957q, i6);
        if (this.f3943c != null) {
            this.f3943c.layout(0, 0, i5 - this.f3957q, i6);
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(0, i);
        int defaultSize2 = getDefaultSize(0, i2);
        setMeasuredDimension(defaultSize, defaultSize2);
        int childMeasureSpec = getChildMeasureSpec(i, 0, defaultSize - this.f3957q);
        int childMeasureSpec2 = getChildMeasureSpec(i2, 0, defaultSize2);
        this.f3942b.measure(childMeasureSpec, childMeasureSpec2);
        if (this.f3943c != null) {
            this.f3943c.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    public final void setMode(int i) {
        if (i == 0 || i == 1) {
            if (this.f3942b != null) {
                this.f3942b.setVisibility(0);
            }
            if (this.f3943c != null) {
                this.f3943c.setVisibility(4);
            }
        }
        this.f3945e = i;
    }

    public final int getMode() {
        return this.f3945e;
    }

    public final void setScrollScale(float f) {
        this.f3948h = f;
    }

    public final float getScrollScale() {
        return this.f3948h;
    }

    public final void setShadowDrawable(Drawable drawable) {
        this.f3949i = drawable;
        invalidate();
    }

    public final void setSecondaryShadowDrawable(Drawable drawable) {
        this.f3950j = drawable;
        invalidate();
    }

    public final void setShadowWidth(int i) {
        this.f3951k = i;
        invalidate();
    }

    public final void setFadeEnabled(boolean z) {
        this.f3946f = z;
    }

    public final void setFadeDegree(float f) {
        if (f > 1.0f || f < 0.0f) {
            throw new IllegalStateException("The BehindFadeDegree must be between 0.0f and 1.0f");
        }
        this.f3952l = f;
    }

    public final void setTouchMode(int i) {
        this.f3941a = i;
    }

    /* renamed from: a */
    public final boolean mo16600a(View view, int i, float f) {
        if (this.f3945e == 0 || (this.f3945e == 2 && i == 0)) {
            if (f >= ((float) view.getLeft())) {
                return true;
            }
            return false;
        } else if ((this.f3945e == 1 || (this.f3945e == 2 && i == 2)) && f <= ((float) view.getRight())) {
            return true;
        } else {
            return false;
        }
    }

    public final void setSelectorEnabled(boolean z) {
        this.f3953m = z;
    }

    public final void setSelectedView(View view) {
        if (this.f3955o != null) {
            this.f3955o.setTag(C1639h.selected_view, null);
            this.f3955o = null;
        }
        if (view != null && view.getParent() != null) {
            this.f3955o = view;
            this.f3955o.setTag(C1639h.selected_view, "CustomViewBehindSelectedView");
            invalidate();
        }
    }

    /* access modifiers changed from: 0000 */
    public final int getSelectorTop() {
        return this.f3955o.getTop() + ((this.f3955o.getHeight() - this.f3954n.getHeight()) / 2);
    }

    public final void setSelectorBitmap(Bitmap bitmap) {
        this.f3954n = bitmap;
        refreshDrawableState();
    }
}
