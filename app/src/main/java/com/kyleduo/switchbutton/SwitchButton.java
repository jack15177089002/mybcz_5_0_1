package com.kyleduo.switchbutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;

public class SwitchButton extends CompoundButton {

    /* renamed from: a */
    private static boolean f3976a = false;

    /* renamed from: b */
    private boolean f3977b;

    /* renamed from: c */
    private Configuration f3978c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Rect f3979d;

    /* renamed from: e */
    private Rect f3980e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Rect f3981f;

    /* renamed from: g */
    private RectF f3982g;

    /* renamed from: h */
    private AnimationController f3983h;

    /* renamed from: i */
    private C1661h f3984i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f3985j;

    /* renamed from: k */
    private float f3986k;

    /* renamed from: l */
    private float f3987l;

    /* renamed from: m */
    private float f3988m;

    /* renamed from: n */
    private float f3989n;

    /* renamed from: o */
    private int f3990o;

    /* renamed from: p */
    private int f3991p;

    /* renamed from: q */
    private Paint f3992q;

    /* renamed from: r */
    private Rect f3993r;

    /* renamed from: s */
    private OnCheckedChangeListener f3994s;

    @SuppressLint({"NewApi"})
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        int i2;
        int i3;
        int i4;
        super(context, attributeSet, i);
        this.f3977b = false;
        this.f3984i = new C1661h(this);
        this.f3985j = false;
        this.f3993r = null;
        this.f3978c = Configuration.m3702a(getContext().getResources().getDisplayMetrics().density);
        this.f3990o = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f3991p = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        AnimationController a = AnimationController.m3690a();
        C1661h hVar = this.f3984i;
        if (hVar == null) {
            throw new IllegalArgumentException("onAnimateListener can not be null");
        }
        a.f3998a = hVar;
        this.f3983h = a;
        this.f3993r = new Rect();
        if (f3976a) {
            this.f3992q = new Paint();
            this.f3992q.setStyle(Style.STROKE);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchButton);
        this.f3978c.mo16660a(obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchButton_thumb_margin, this.f3978c.mo16659a()));
        this.f3978c.mo16662a(obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchButton_thumb_marginTop, this.f3978c.f4011f), obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchButton_thumb_marginBottom, this.f3978c.f4012g), obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchButton_thumb_marginLeft, this.f3978c.f4013h), obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchButton_thumb_marginRight, this.f3978c.f4014i));
        this.f3978c.f4017l = (float) obtainStyledAttributes.getInt(R.styleable.SwitchButton_radius, C1659f.f4029f);
        this.f3978c.mo16661a(obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchButton_thumb_width, -1), obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchButton_thumb_height, -1));
        this.f3978c.mo16666b(obtainStyledAttributes.getFloat(R.styleable.SwitchButton_measureFactor, -1.0f));
        Configuration eVar = this.f3978c;
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchButton_insetLeft, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchButton_insetTop, 0);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchButton_insetRight, 0);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchButton_insetBottom, 0);
        if (dimensionPixelSize > 0) {
            dimensionPixelSize = -dimensionPixelSize;
        }
        eVar.f4018m.left = dimensionPixelSize;
        if (dimensionPixelSize2 > 0) {
            i2 = -dimensionPixelSize2;
        } else {
            i2 = dimensionPixelSize2;
        }
        eVar.f4018m.top = i2;
        if (dimensionPixelSize3 > 0) {
            i3 = -dimensionPixelSize3;
        } else {
            i3 = dimensionPixelSize3;
        }
        eVar.f4018m.right = i3;
        if (dimensionPixelSize4 > 0) {
            i4 = -dimensionPixelSize4;
        } else {
            i4 = dimensionPixelSize4;
        }
        eVar.f4018m.bottom = i4;
        this.f3983h.mo16652a(obtainStyledAttributes.getInteger(R.styleable.SwitchButton_animationVelocity, -1));
        if (this.f3978c != null) {
            this.f3978c.mo16663a(m3681a(obtainStyledAttributes, R.styleable.SwitchButton_offDrawable, R.styleable.SwitchButton_offColor, C1659f.f4024a));
            this.f3978c.mo16667b(m3681a(obtainStyledAttributes, R.styleable.SwitchButton_onDrawable, R.styleable.SwitchButton_onColor, C1659f.f4025b));
            Configuration eVar2 = this.f3978c;
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.SwitchButton_thumbDrawable);
            if (drawable == 0) {
                int color = obtainStyledAttributes.getColor(R.styleable.SwitchButton_thumbColor, C1659f.f4026c);
                int color2 = obtainStyledAttributes.getColor(R.styleable.SwitchButton_thumbPressedColor, C1659f.f4027d);
                StateListDrawable stateListDrawable = new StateListDrawable();
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(this.f3978c.mo16664b());
                gradientDrawable.setColor(color);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(this.f3978c.mo16664b());
                gradientDrawable2.setColor(color2);
                stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, gradientDrawable2);
                stateListDrawable.addState(new int[0], gradientDrawable);
                drawable = stateListDrawable;
            }
            eVar2.mo16669c(drawable);
        }
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchButton(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private Drawable m3681a(TypedArray typedArray, int i, int i2, int i3) {
        Drawable drawable = typedArray.getDrawable(i);
        if (drawable != null) {
            return drawable;
        }
        int color = typedArray.getColor(i2, i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f3978c.mo16664b());
        gradientDrawable.setColor(color);
        return gradientDrawable;
    }

    public void setConfiguration(Configuration eVar) {
        if (this.f3978c == null) {
            this.f3978c = Configuration.m3702a(eVar.f4015j);
        }
        this.f3978c.mo16663a(eVar.f4007b != null ? eVar.f4007b : eVar.mo16665b(eVar.f4010e));
        this.f3978c.mo16667b(eVar.f4006a != null ? eVar.f4006a : eVar.mo16665b(eVar.f4009d));
        this.f3978c.mo16669c(eVar.mo16668c());
        this.f3978c.mo16662a(eVar.f4011f, eVar.f4012g, eVar.f4013h, eVar.f4014i);
        this.f3978c.mo16661a(eVar.mo16674h(), eVar.mo16675i());
        this.f3978c.f4016k = eVar.f4016k;
        this.f3978c.mo16666b(eVar.mo16670d());
        this.f3983h.mo16652a(this.f3978c.f4016k);
        requestLayout();
        m3682a();
        setChecked(this.f3977b);
    }

    public Configuration getConfiguration() {
        return this.f3978c;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int h = (int) ((((float) this.f3978c.mo16674h()) * this.f3978c.mo16670d()) + ((float) getPaddingLeft()) + ((float) getPaddingRight()));
        int i3 = this.f3978c.f4013h + this.f3978c.f4014i;
        if (i3 > 0) {
            h += i3;
        }
        if (mode == 1073741824) {
            h = Math.max(size, h);
        } else if (mode == Integer.MIN_VALUE) {
            h = Math.min(size, h);
        }
        int i4 = this.f3978c.f4018m.left + this.f3978c.f4018m.right + h;
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i5 = this.f3978c.mo16675i() + getPaddingTop() + getPaddingBottom();
        int i6 = this.f3978c.f4011f + this.f3978c.f4012g;
        if (i6 > 0) {
            i5 += i6;
        }
        if (mode2 == 1073741824) {
            i5 = Math.max(size2, i5);
        } else if (mode2 == Integer.MIN_VALUE) {
            i5 = Math.min(size2, i5);
        }
        setMeasuredDimension(i4, i5 + this.f3978c.f4018m.top + this.f3978c.f4018m.bottom);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m3682a();
    }

    /* renamed from: a */
    private void m3682a() {
        int i;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            this.f3980e = null;
        } else {
            if (this.f3980e == null) {
                this.f3980e = new Rect();
            }
            this.f3980e.set(getPaddingLeft() + (this.f3978c.f4013h > 0 ? 0 : -this.f3978c.f4013h), getPaddingTop() + (this.f3978c.f4011f > 0 ? 0 : -this.f3978c.f4011f), (-this.f3978c.mo16671e()) + ((measuredWidth - getPaddingRight()) - (this.f3978c.f4014i > 0 ? 0 : -this.f3978c.f4014i)), ((measuredHeight - getPaddingBottom()) - (this.f3978c.f4012g > 0 ? 0 : -this.f3978c.f4012g)) + (-this.f3978c.mo16672f()));
        }
        int measuredWidth2 = getMeasuredWidth();
        int measuredHeight2 = getMeasuredHeight();
        if (measuredWidth2 <= 0 || measuredHeight2 <= 0) {
            this.f3979d = null;
        } else {
            if (this.f3979d == null) {
                this.f3979d = new Rect();
            }
            int paddingLeft = getPaddingLeft();
            if (this.f3978c.f4013h > 0) {
                i = this.f3978c.f4013h;
            } else {
                i = 0;
            }
            this.f3979d.set(paddingLeft + i, getPaddingTop() + (this.f3978c.f4011f > 0 ? this.f3978c.f4011f : 0), (-this.f3978c.mo16671e()) + ((measuredWidth2 - getPaddingRight()) - (this.f3978c.f4014i > 0 ? this.f3978c.f4014i : 0)), ((measuredHeight2 - getPaddingBottom()) - (this.f3978c.f4012g > 0 ? this.f3978c.f4012g : 0)) + (-this.f3978c.mo16672f()));
            this.f3989n = (float) (this.f3979d.left + (((this.f3979d.right - this.f3979d.left) - this.f3978c.mo16674h()) / 2));
        }
        int measuredWidth3 = getMeasuredWidth();
        int measuredHeight3 = getMeasuredHeight();
        if (measuredWidth3 <= 0 || measuredHeight3 <= 0) {
            this.f3981f = null;
        } else {
            if (this.f3981f == null) {
                this.f3981f = new Rect();
            }
            int i2 = this.f3977b ? this.f3979d.right - this.f3978c.mo16674h() : this.f3979d.left;
            int h = this.f3978c.mo16674h() + i2;
            int i3 = this.f3979d.top;
            this.f3981f.set(i2, i3, h, this.f3978c.mo16675i() + i3);
        }
        if (this.f3980e != null) {
            this.f3978c.f4006a.setBounds(this.f3980e);
            this.f3978c.f4007b.setBounds(this.f3980e);
        }
        if (this.f3981f != null) {
            this.f3978c.f4008c.setBounds(this.f3981f);
        }
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.f3982g = new RectF(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z = false;
        super.onDraw(canvas);
        canvas.getClipBounds(this.f3993r);
        if (this.f3993r != null && this.f3978c.mo16673g()) {
            this.f3993r.inset(this.f3978c.mo16671e() / 2, this.f3978c.mo16672f() / 2);
            canvas.clipRect(this.f3993r, Op.REPLACE);
            canvas.translate((float) this.f3978c.f4018m.left, (float) this.f3978c.f4018m.top);
        }
        if (!isEnabled()) {
            if (!(this.f3978c.f4008c instanceof StateListDrawable) || !(this.f3978c.f4006a instanceof StateListDrawable) || !(this.f3978c.f4007b instanceof StateListDrawable)) {
                z = true;
            }
        }
        if (z) {
            canvas.saveLayerAlpha(this.f3982g, 127, 31);
        }
        this.f3978c.f4007b.draw(canvas);
        Drawable drawable = this.f3978c.f4006a;
        int i = 255;
        if (!(this.f3979d == null || this.f3979d.right == this.f3979d.left)) {
            int h = (this.f3979d.right - this.f3978c.mo16674h()) - this.f3979d.left;
            if (h > 0) {
                i = ((this.f3981f.left - this.f3979d.left) * 255) / h;
            }
        }
        drawable.setAlpha(i);
        this.f3978c.f4006a.draw(canvas);
        this.f3978c.f4008c.draw(canvas);
        if (z) {
            canvas.restore();
        }
        if (f3976a) {
            this.f3992q.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.f3980e, this.f3992q);
            this.f3992q.setColor(Color.parseColor("#00FF00"));
            canvas.drawRect(this.f3979d, this.f3992q);
            this.f3992q.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.f3981f, this.f3992q);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f3985j || !isEnabled()) {
            return false;
        }
        float x = motionEvent.getX() - this.f3986k;
        float y = motionEvent.getY() - this.f3987l;
        switch (motionEvent.getAction()) {
            case 0:
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                this.f3986k = motionEvent.getX();
                this.f3987l = motionEvent.getY();
                this.f3988m = this.f3986k;
                setPressed(true);
                break;
            case 1:
            case 3:
                setPressed(false);
                boolean statusBasedOnPos = getStatusBasedOnPos();
                float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                if (x < ((float) this.f3990o) && y < ((float) this.f3990o) && eventTime < ((float) this.f3991p)) {
                    performClick();
                    break;
                } else {
                    m3685a(statusBasedOnPos);
                    break;
                }
                break;
            case 2:
                float x2 = motionEvent.getX();
                m3683a((int) (x2 - this.f3988m));
                this.f3988m = x2;
                break;
        }
        invalidate();
        return true;
    }

    /* access modifiers changed from: private */
    public boolean getStatusBasedOnPos() {
        return ((float) this.f3981f.left) > this.f3989n;
    }

    public void invalidate() {
        if (this.f3993r == null || !this.f3978c.mo16673g()) {
            super.invalidate();
        } else {
            invalidate(this.f3993r);
        }
    }

    public boolean performClick() {
        return super.performClick();
    }

    public void setChecked(boolean z) {
        if (this.f3981f != null) {
            m3683a(z ? getMeasuredWidth() : -getMeasuredWidth());
        }
        setCheckedInClass$25decb5(z);
    }

    public boolean isChecked() {
        return this.f3977b;
    }

    public void toggle() {
        m3685a(!this.f3977b);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        setDrawableState(this.f3978c.f4008c);
        setDrawableState(this.f3978c.f4006a);
        setDrawableState(this.f3978c.f4007b);
    }

    private void setDrawableState(Drawable drawable) {
        if (drawable != null) {
            drawable.setState(getDrawableState());
            invalidate();
        }
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        if (onCheckedChangeListener == null) {
            throw new IllegalArgumentException("onCheckedChangeListener can not be null");
        }
        this.f3994s = onCheckedChangeListener;
    }

    /* access modifiers changed from: private */
    public void setCheckedInClass(boolean z) {
        setCheckedInClass$25decb5(z);
    }

    private void setCheckedInClass$25decb5(boolean z) {
        if (this.f3977b != z) {
            this.f3977b = z;
            refreshDrawableState();
            if (this.f3994s != null) {
                this.f3994s.onCheckedChanged(this, this.f3977b);
            }
        }
    }

    /* renamed from: a */
    private void m3685a(boolean z) {
        if (!this.f3985j) {
            int i = this.f3981f.left;
            int i2 = z ? this.f3979d.right - this.f3978c.mo16674h() : this.f3979d.left;
            AnimationController aVar = this.f3983h;
            aVar.f3999b = true;
            aVar.f4001d = i;
            aVar.f4002e = i2;
            aVar.f4000c = aVar.f4003f;
            if (aVar.f4002e > aVar.f4001d) {
                aVar.f4000c = Math.abs(aVar.f4003f);
            } else if (aVar.f4002e < aVar.f4001d) {
                aVar.f4000c = -Math.abs(aVar.f4003f);
            } else {
                aVar.f3999b = false;
                aVar.f3998a.mo16657c();
                return;
            }
            aVar.f3998a.mo16654a();
            new C1658d(aVar).run();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3683a(int i) {
        int i2 = this.f3981f.left + i;
        int i3 = this.f3981f.right + i;
        if (i2 < this.f3979d.left) {
            i2 = this.f3979d.left;
            i3 = this.f3978c.mo16674h() + i2;
        }
        if (i3 > this.f3979d.right) {
            i3 = this.f3979d.right;
            i2 = i3 - this.f3978c.mo16674h();
        }
        this.f3981f.set(i2, this.f3981f.top, i3, this.f3981f.bottom);
        this.f3978c.f4008c.setBounds(this.f3981f);
    }
}
