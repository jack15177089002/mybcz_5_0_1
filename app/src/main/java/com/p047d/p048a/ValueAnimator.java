package com.p047d.p048a;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.d.a.am */
public class ValueAnimator extends Animator {
    /* access modifiers changed from: private */

    /* renamed from: C */
    public static long f3461C = 10;

    /* renamed from: n */
    private static ThreadLocal<C1547as> f3462n = new ThreadLocal<>();
    /* access modifiers changed from: private */

    /* renamed from: o */
    public static final ThreadLocal<ArrayList<ValueAnimator>> f3463o = new C1542an();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public static final ThreadLocal<ArrayList<ValueAnimator>> f3464p = new C1543ao();
    /* access modifiers changed from: private */

    /* renamed from: q */
    public static final ThreadLocal<ArrayList<ValueAnimator>> f3465q = new C1544ap();
    /* access modifiers changed from: private */

    /* renamed from: r */
    public static final ThreadLocal<ArrayList<ValueAnimator>> f3466r = new C1545aq();
    /* access modifiers changed from: private */

    /* renamed from: s */
    public static final ThreadLocal<ArrayList<ValueAnimator>> f3467s = new C1546ar();

    /* renamed from: t */
    private static final Interpolator f3468t = new AccelerateDecelerateInterpolator();

    /* renamed from: u */
    private static final TypeEvaluator f3469u = new IntEvaluator();

    /* renamed from: v */
    private static final TypeEvaluator f3470v = new FloatEvaluator();

    /* renamed from: A */
    private boolean f3471A = false;

    /* renamed from: B */
    private long f3472B = 300;

    /* renamed from: D */
    private ArrayList<C1548at> f3473D = null;

    /* renamed from: b */
    long f3474b;

    /* renamed from: c */
    long f3475c = -1;

    /* renamed from: d */
    public float f3476d = 0.0f;

    /* renamed from: e */
    int f3477e = 0;
    /* access modifiers changed from: 0000 */

    /* renamed from: f */
    public boolean f3478f = false;

    /* renamed from: g */
    boolean f3479g = false;

    /* renamed from: h */
    public long f3480h = 0;

    /* renamed from: i */
    public int f3481i = 0;

    /* renamed from: j */
    public int f3482j = 1;

    /* renamed from: k */
    public Interpolator f3483k = f3468t;

    /* renamed from: l */
    PropertyValuesHolder[] f3484l;

    /* renamed from: m */
    HashMap<String, PropertyValuesHolder> f3485m;

    /* renamed from: w */
    private boolean f3486w = false;

    /* renamed from: x */
    private int f3487x = 0;

    /* renamed from: y */
    private boolean f3488y = false;

    /* renamed from: z */
    private long f3489z;

    /* renamed from: b */
    public static ValueAnimator m3296b(int... iArr) {
        ValueAnimator amVar = new ValueAnimator();
        amVar.mo16186a(iArr);
        return amVar;
    }

    /* renamed from: b */
    public static ValueAnimator m3295b(float... fArr) {
        ValueAnimator amVar = new ValueAnimator();
        amVar.mo16185a(fArr);
        return amVar;
    }

    /* renamed from: a */
    public void mo16186a(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            if (this.f3484l == null || this.f3484l.length == 0) {
                mo16187a(PropertyValuesHolder.m3267a("", iArr));
            } else {
                this.f3484l[0].mo16177a(iArr);
            }
            this.f3479g = false;
        }
    }

    /* renamed from: a */
    public void mo16185a(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            if (this.f3484l == null || this.f3484l.length == 0) {
                mo16187a(PropertyValuesHolder.m3266a("", fArr));
            } else {
                this.f3484l[0].mo16176a(fArr);
            }
            this.f3479g = false;
        }
    }

    /* renamed from: a */
    public final void mo16187a(PropertyValuesHolder... aiVarArr) {
        this.f3484l = aiVarArr;
        this.f3485m = new HashMap<>(1);
        for (int i = 0; i <= 0; i++) {
            PropertyValuesHolder aiVar = aiVarArr[0];
            this.f3485m.put(aiVar.f3445a, aiVar);
        }
        this.f3479g = false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo16190e() {
        if (!this.f3479g) {
            for (PropertyValuesHolder aiVar : this.f3484l) {
                if (aiVar.f3452j == null) {
                    TypeEvaluator alVar = aiVar.f3448d == Integer.class ? PropertyValuesHolder.f3438f : aiVar.f3448d == Float.class ? PropertyValuesHolder.f3439g : null;
                    aiVar.f3452j = alVar;
                }
                if (aiVar.f3452j != null) {
                    aiVar.f3449e.f3538f = aiVar.f3452j;
                }
            }
            this.f3479g = true;
        }
    }

    /* renamed from: b */
    public ValueAnimator mo16188b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f3472B = j;
        return this;
    }

    /* renamed from: a */
    private void mo16215a(long j) {
        mo16190e();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f3477e != 1) {
            this.f3475c = j;
            this.f3477e = 2;
        }
        this.f3474b = currentAnimationTimeMillis - j;
        mo16189c(currentAnimationTimeMillis);
    }

    /* renamed from: g */
    public final Object mo16192g() {
        if (this.f3484l == null || this.f3484l.length <= 0) {
            return null;
        }
        return this.f3484l[0].mo16178b();
    }

    /* renamed from: a */
    public final void mo16184a(C1548at atVar) {
        if (this.f3473D == null) {
            this.f3473D = new ArrayList<>();
        }
        this.f3473D.add(atVar);
    }

    /* renamed from: a */
    public void mo16161a() {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.f3486w = false;
        this.f3487x = 0;
        this.f3477e = 0;
        this.f3471A = true;
        this.f3488y = false;
        ((ArrayList) f3464p.get()).add(this);
        if (this.f3480h == 0) {
            mo16215a((!this.f3479g || this.f3477e == 0) ? 0 : AnimationUtils.currentAnimationTimeMillis() - this.f3474b);
            this.f3477e = 0;
            this.f3478f = true;
            if (this.f3437a != null) {
                ArrayList arrayList = (ArrayList) this.f3437a.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((C1549b) arrayList.get(i)).onAnimationStart(this);
                }
            }
        }
        C1547as asVar = (C1547as) f3462n.get();
        if (asVar == null) {
            asVar = new C1547as((byte) 0);
            f3462n.set(asVar);
        }
        asVar.sendEmptyMessage(0);
    }

    /* renamed from: b */
    public final void mo16164b() {
        if (this.f3477e != 0 || ((ArrayList) f3464p.get()).contains(this) || ((ArrayList) f3465q.get()).contains(this)) {
            if (this.f3478f && this.f3437a != null) {
                Iterator it = ((ArrayList) this.f3437a.clone()).iterator();
                while (it.hasNext()) {
                    ((C1549b) it.next()).onAnimationCancel(this);
                }
            }
            m3306n();
        }
    }

    /* renamed from: c */
    public final void mo16166c() {
        if (!((ArrayList) f3463o.get()).contains(this) && !((ArrayList) f3464p.get()).contains(this)) {
            this.f3488y = false;
            m3307o();
        } else if (!this.f3479g) {
            mo16190e();
        }
        if (this.f3481i <= 0 || (this.f3481i & 1) != 1) {
            mo16183a(1.0f);
        } else {
            mo16183a(0.0f);
        }
        m3306n();
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m3306n() {
        ((ArrayList) f3463o.get()).remove(this);
        ((ArrayList) f3464p.get()).remove(this);
        ((ArrayList) f3465q.get()).remove(this);
        this.f3477e = 0;
        if (this.f3478f && this.f3437a != null) {
            ArrayList arrayList = (ArrayList) this.f3437a.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((C1549b) arrayList.get(i)).onAnimationEnd(this);
            }
        }
        this.f3478f = false;
        this.f3471A = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m3307o() {
        mo16190e();
        ((ArrayList) f3463o.get()).add(this);
        if (this.f3480h > 0 && this.f3437a != null) {
            ArrayList arrayList = (ArrayList) this.f3437a.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((C1549b) arrayList.get(i)).onAnimationStart(this);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m3294a(ValueAnimator amVar, long j) {
        if (!amVar.f3488y) {
            amVar.f3488y = true;
            amVar.f3489z = j;
        } else {
            long j2 = j - amVar.f3489z;
            if (j2 > amVar.f3480h) {
                amVar.f3474b = j - (j2 - amVar.f3480h);
                amVar.f3477e = 1;
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final boolean mo16189c(long j) {
        float f;
        boolean z;
        boolean z2 = false;
        if (this.f3477e == 0) {
            this.f3477e = 1;
            if (this.f3475c < 0) {
                this.f3474b = j;
            } else {
                this.f3474b = j - this.f3475c;
                this.f3475c = -1;
            }
        }
        switch (this.f3477e) {
            case 1:
            case 2:
                float f2 = this.f3472B > 0 ? ((float) (j - this.f3474b)) / ((float) this.f3472B) : 1.0f;
                if (f2 < 1.0f) {
                    f = f2;
                } else if (this.f3487x < this.f3481i || this.f3481i == -1) {
                    if (this.f3437a != null) {
                        int size = this.f3437a.size();
                        for (int i = 0; i < size; i++) {
                            ((C1549b) this.f3437a.get(i)).onAnimationRepeat(this);
                        }
                    }
                    if (this.f3482j == 2) {
                        if (this.f3486w) {
                            z = false;
                        } else {
                            z = true;
                        }
                        this.f3486w = z;
                    }
                    this.f3487x += (int) f2;
                    f = f2 % 1.0f;
                    this.f3474b += this.f3472B;
                } else {
                    f = Math.min(f2, 1.0f);
                    z2 = true;
                }
                if (this.f3486w) {
                    f = 1.0f - f;
                }
                mo16183a(f);
                break;
        }
        return z2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16183a(float f) {
        float interpolation = this.f3483k.getInterpolation(f);
        this.f3476d = interpolation;
        for (PropertyValuesHolder a : this.f3484l) {
            a.mo16172a(interpolation);
        }
        if (this.f3473D != null) {
            int size = this.f3473D.size();
            for (int i = 0; i < size; i++) {
                ((C1548at) this.f3473D.get(i)).onAnimationUpdate(this);
            }
        }
    }

    /* renamed from: f */
    public ValueAnimator mo16168d() {
        ValueAnimator amVar = (ValueAnimator) super.clone();
        if (this.f3473D != null) {
            ArrayList<C1548at> arrayList = this.f3473D;
            amVar.f3473D = new ArrayList<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                amVar.f3473D.add((C1548at) arrayList.get(i));
            }
        }
        amVar.f3475c = -1;
        amVar.f3486w = false;
        amVar.f3487x = 0;
        amVar.f3479g = false;
        amVar.f3477e = 0;
        amVar.f3488y = false;
        PropertyValuesHolder[] aiVarArr = this.f3484l;
        if (aiVarArr != null) {
            int length = aiVarArr.length;
            amVar.f3484l = new PropertyValuesHolder[length];
            amVar.f3485m = new HashMap<>(length);
            for (int i2 = 0; i2 < length; i2++) {
                PropertyValuesHolder a = aiVarArr[i2].clone();
                amVar.f3484l[i2] = a;
                amVar.f3485m.put(a.f3445a, a);
            }
        }
        return amVar;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f3484l != null) {
            for (PropertyValuesHolder aiVar : this.f3484l) {
                str = new StringBuilder(String.valueOf(str)).append("\n    ").append(aiVar.toString()).toString();
            }
        }
        return str;
    }
}
