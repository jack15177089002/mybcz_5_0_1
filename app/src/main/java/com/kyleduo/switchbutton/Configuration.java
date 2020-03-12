package com.kyleduo.switchbutton;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import java.lang.reflect.Field;

/* renamed from: com.kyleduo.switchbutton.e */
public final class Configuration implements Cloneable {

    /* renamed from: a */
    Drawable f4006a = null;

    /* renamed from: b */
    Drawable f4007b = null;

    /* renamed from: c */
    Drawable f4008c = null;

    /* renamed from: d */
    int f4009d = C1659f.f4025b;

    /* renamed from: e */
    int f4010e = C1659f.f4024a;

    /* renamed from: f */
    int f4011f = 0;

    /* renamed from: g */
    int f4012g = 0;

    /* renamed from: h */
    int f4013h = 0;

    /* renamed from: i */
    int f4014i = 0;

    /* renamed from: j */
    float f4015j;

    /* renamed from: k */
    int f4016k = -1;

    /* renamed from: l */
    float f4017l = -1.0f;

    /* renamed from: m */
    Rect f4018m;

    /* renamed from: n */
    private int f4019n = C1659f.f4026c;

    /* renamed from: o */
    private int f4020o = C1659f.f4027d;

    /* renamed from: p */
    private int f4021p = -1;

    /* renamed from: q */
    private int f4022q = -1;

    /* renamed from: r */
    private float f4023r = 0.0f;

    private Configuration() {
    }

    /* renamed from: a */
    public static Configuration m3702a(float f) {
        Configuration eVar = new Configuration();
        eVar.f4015j = f;
        eVar.mo16660a(eVar.mo16659a());
        eVar.f4018m = new Rect(C1659f.f4031h, C1659f.f4031h, C1659f.f4031h, C1659f.f4031h);
        return eVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16663a(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("off drawable can not be null");
        }
        this.f4007b = drawable;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo16667b(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("on drawable can not be null");
        }
        this.f4006a = drawable;
    }

    /* renamed from: c */
    public final void mo16669c(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("thumb drawable can not be null");
        }
        this.f4008c = drawable;
    }

    /* renamed from: a */
    public final void mo16662a(int i, int i2, int i3, int i4) {
        this.f4011f = i;
        this.f4012g = i2;
        this.f4013h = i3;
        this.f4014i = i4;
    }

    /* renamed from: a */
    public final void mo16660a(int i) {
        mo16662a(i, i, i, i);
    }

    /* renamed from: a */
    public final int mo16659a() {
        return (int) (((float) C1659f.f4028e) * this.f4015j);
    }

    /* renamed from: b */
    public final float mo16664b() {
        if (this.f4017l < 0.0f) {
            return (float) C1659f.f4029f;
        }
        return this.f4017l;
    }

    /* renamed from: a */
    public final void mo16661a(int i, int i2) {
        if (i > 0) {
            this.f4021p = i;
        }
        if (i2 > 0) {
            this.f4022q = i2;
        }
    }

    /* renamed from: c */
    public final Drawable mo16668c() {
        int[] iArr;
        if (this.f4008c != null) {
            return this.f4008c;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable b = mo16665b(this.f4019n);
        Drawable b2 = mo16665b(this.f4020o);
        try {
            Field declaredField = View.class.getDeclaredField("PRESSED_ENABLED_STATE_SET");
            declaredField.setAccessible(true);
            iArr = (int[]) declaredField.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            iArr = null;
        }
        if (iArr != null) {
            stateListDrawable.addState(iArr, b2);
        }
        stateListDrawable.addState(new int[0], b);
        return stateListDrawable;
    }

    /* renamed from: d */
    public final float mo16670d() {
        if (this.f4023r <= 0.0f) {
            this.f4023r = C1659f.f4030g;
        }
        return this.f4023r;
    }

    /* renamed from: b */
    public final void mo16666b(float f) {
        if (f <= 0.0f) {
            this.f4023r = C1659f.f4030g;
        }
        this.f4023r = f;
    }

    /* renamed from: e */
    public final int mo16671e() {
        return this.f4018m.left + this.f4018m.right;
    }

    /* renamed from: f */
    public final int mo16672f() {
        return this.f4018m.top + this.f4018m.bottom;
    }

    /* renamed from: g */
    public final boolean mo16673g() {
        return ((this.f4018m.left + this.f4018m.right) + this.f4018m.top) + this.f4018m.bottom != 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final Drawable mo16665b(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(mo16664b());
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final int mo16674h() {
        int i = this.f4021p;
        if (i >= 0) {
            return i;
        }
        if (this.f4008c != null) {
            int intrinsicWidth = this.f4008c.getIntrinsicWidth();
            if (intrinsicWidth > 0) {
                return intrinsicWidth;
            }
        }
        if (this.f4015j > 0.0f) {
            return (int) (((float) C1660g.f4032a) * this.f4015j);
        }
        throw new IllegalArgumentException("density must be a positive number");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public final int mo16675i() {
        int i = this.f4022q;
        if (i >= 0) {
            return i;
        }
        if (this.f4008c != null) {
            int intrinsicHeight = this.f4008c.getIntrinsicHeight();
            if (intrinsicHeight > 0) {
                return intrinsicHeight;
            }
        }
        if (this.f4015j > 0.0f) {
            return (int) (((float) C1660g.f4032a) * this.f4015j);
        }
        throw new IllegalArgumentException("density must be a positive number");
    }
}
