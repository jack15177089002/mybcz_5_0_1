package com.p047d.p048a;

import android.util.Log;
import com.p047d.p049b.FloatProperty;
import com.p047d.p049b.Property;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.d.a.aj */
/* compiled from: PropertyValuesHolder */
final class C1540aj extends PropertyValuesHolder {

    /* renamed from: k */
    FloatKeyframeSet f3455k;

    /* renamed from: l */
    float f3456l;

    /* renamed from: m */
    private FloatProperty f3457m;

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ PropertyValuesHolder mo16171a() {
        C1540aj ajVar = (C1540aj) super.clone();
        ajVar.f3455k = (FloatKeyframeSet) ajVar.f3449e;
        return ajVar;
    }

    public C1540aj(String str, float... fArr) {
        super(str, 0);
        mo16176a(fArr);
    }

    public C1540aj(Property cVar, float... fArr) {
        super(cVar, 0);
        mo16176a(fArr);
        if (cVar instanceof FloatProperty) {
            this.f3457m = (FloatProperty) this.f3446b;
        }
    }

    /* renamed from: a */
    public final void mo16176a(float... fArr) {
        super.mo16176a(fArr);
        this.f3455k = (FloatKeyframeSet) this.f3449e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16172a(float f) {
        this.f3456l = this.f3455k.mo16207b(f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final Object mo16178b() {
        return Float.valueOf(this.f3456l);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo16179b(Object obj) {
        if (this.f3457m != null) {
            this.f3457m.mo16170a(obj, this.f3456l);
        } else if (this.f3446b != null) {
            this.f3446b.mo16217a(obj, Float.valueOf(this.f3456l));
        } else if (this.f3447c != null) {
            try {
                this.f3451i[0] = Float.valueOf(this.f3456l);
                this.f3447c.invoke(obj, this.f3451i);
            } catch (InvocationTargetException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (IllegalAccessException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16174a(Class cls) {
        if (this.f3446b == null) {
            super.mo16174a(cls);
        }
    }
}
