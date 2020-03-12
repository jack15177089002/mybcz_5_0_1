package com.p047d.p048a;

import android.view.View;
import com.p047d.p049b.Property;
import com.p047d.p050c.p051a.AnimatorProxy;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.d.a.s */
public final class ObjectAnimator extends ValueAnimator {

    /* renamed from: n */
    private static final Map<String, Property> f3539n;

    /* renamed from: o */
    private Object f3540o;

    /* renamed from: p */
    private String f3541p;

    /* renamed from: q */
    private Property f3542q;

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ ValueAnimator mo16188b(long j) {
        super.mo16188b(j);
        return this;
    }

    /* renamed from: f */
    public final /* bridge */ /* synthetic */ ValueAnimator mo16191f() {
        return (ObjectAnimator) super.mo16168d();
    }

    static {
        HashMap hashMap = new HashMap();
        f3539n = hashMap;
        hashMap.put("alpha", C1558t.f3543a);
        f3539n.put("pivotX", C1558t.f3544b);
        f3539n.put("pivotY", C1558t.f3545c);
        f3539n.put("translationX", C1558t.f3546d);
        f3539n.put("translationY", C1558t.f3547e);
        f3539n.put("rotation", C1558t.f3548f);
        f3539n.put("rotationX", C1558t.f3549g);
        f3539n.put("rotationY", C1558t.f3550h);
        f3539n.put("scaleX", C1558t.f3551i);
        f3539n.put("scaleY", C1558t.f3552j);
        f3539n.put("scrollX", C1558t.f3553k);
        f3539n.put("scrollY", C1558t.f3554l);
        f3539n.put("x", C1558t.f3555m);
        f3539n.put("y", C1558t.f3556n);
    }

    public ObjectAnimator() {
    }

    private ObjectAnimator(Object obj, String str) {
        this.f3540o = obj;
        if (this.f3484l != null) {
            PropertyValuesHolder aiVar = this.f3484l[0];
            String str2 = aiVar.f3445a;
            aiVar.f3445a = str;
            this.f3485m.remove(str2);
            this.f3485m.put(str, aiVar);
        }
        this.f3541p = str;
        this.f3479g = false;
    }

    /* renamed from: a */
    public static ObjectAnimator m3360a(Object obj, String str, float... fArr) {
        ObjectAnimator sVar = new ObjectAnimator(obj, str);
        sVar.mo16185a(fArr);
        return sVar;
    }

    /* renamed from: a */
    public final void mo16186a(int... iArr) {
        if (this.f3484l != null && this.f3484l.length != 0) {
            super.mo16186a(iArr);
        } else if (this.f3542q != null) {
            mo16187a(PropertyValuesHolder.m3265a(this.f3542q, iArr));
        } else {
            mo16187a(PropertyValuesHolder.m3267a(this.f3541p, iArr));
        }
    }

    /* renamed from: a */
    public final void mo16185a(float... fArr) {
        if (this.f3484l != null && this.f3484l.length != 0) {
            super.mo16185a(fArr);
        } else if (this.f3542q != null) {
            mo16187a(PropertyValuesHolder.m3264a(this.f3542q, fArr));
        } else {
            mo16187a(PropertyValuesHolder.m3266a(this.f3541p, fArr));
        }
    }

    /* renamed from: a */
    public final void mo16161a() {
        super.mo16161a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final void mo16190e() {
        if (!this.f3479g) {
            if (this.f3542q == null && AnimatorProxy.f3559a && (this.f3540o instanceof View) && f3539n.containsKey(this.f3541p)) {
                Property cVar = (Property) f3539n.get(this.f3541p);
                if (this.f3484l != null) {
                    PropertyValuesHolder aiVar = this.f3484l[0];
                    String str = aiVar.f3445a;
                    aiVar.mo16173a(cVar);
                    this.f3485m.remove(str);
                    this.f3485m.put(this.f3541p, aiVar);
                }
                if (this.f3542q != null) {
                    this.f3541p = cVar.f3557a;
                }
                this.f3542q = cVar;
                this.f3479g = false;
            }
            for (PropertyValuesHolder a : this.f3484l) {
                a.mo16175a(this.f3540o);
            }
            super.mo16190e();
        }
    }

    /* renamed from: a */
    public final ObjectAnimator mo16215a(long j) {
        super.mo16188b(j);
        return this;
    }

    /* renamed from: a */
    public final void mo16163a(Object obj) {
        if (this.f3540o != obj) {
            Object obj2 = this.f3540o;
            this.f3540o = obj;
            if (obj2 == null || obj == null || obj2.getClass() != obj.getClass()) {
                this.f3479g = false;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16183a(float f) {
        super.mo16183a(f);
        for (PropertyValuesHolder b : this.f3484l) {
            b.mo16179b(this.f3540o);
        }
    }

    public final String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.f3540o;
        if (this.f3484l != null) {
            for (PropertyValuesHolder aiVar : this.f3484l) {
                str = new StringBuilder(String.valueOf(str)).append("\n    ").append(aiVar.toString()).toString();
            }
        }
        return str;
    }
}
