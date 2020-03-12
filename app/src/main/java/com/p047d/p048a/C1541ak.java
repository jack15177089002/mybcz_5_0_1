package com.p047d.p048a;

import android.util.Log;
import com.p047d.p049b.IntProperty;
import com.p047d.p049b.Property;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.d.a.ak */
/* compiled from: PropertyValuesHolder */
final class C1541ak extends PropertyValuesHolder {

    /* renamed from: k */
    IntKeyframeSet f3458k;

    /* renamed from: l */
    int f3459l;

    /* renamed from: m */
    private IntProperty f3460m;

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ PropertyValuesHolder mo16171a() {
        C1541ak akVar = (C1541ak) super.clone();
        akVar.f3458k = (IntKeyframeSet) akVar.f3449e;
        return akVar;
    }

    public C1541ak(String str, int... iArr) {
        super(str, 0);
        mo16177a(iArr);
    }

    public C1541ak(Property cVar, int... iArr) {
        super(cVar, 0);
        mo16177a(iArr);
        if (cVar instanceof IntProperty) {
            this.f3460m = (IntProperty) this.f3446b;
        }
    }

    /* renamed from: a */
    public final void mo16177a(int... iArr) {
        super.mo16177a(iArr);
        this.f3458k = (IntKeyframeSet) this.f3449e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16172a(float f) {
        this.f3459l = this.f3458k.mo16208b(f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final Object mo16178b() {
        return Integer.valueOf(this.f3459l);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo16179b(Object obj) {
        if (this.f3460m != null) {
            this.f3460m.mo16216a(obj, this.f3459l);
        } else if (this.f3446b != null) {
            this.f3446b.mo16217a(obj, Integer.valueOf(this.f3459l));
        } else if (this.f3447c != null) {
            try {
                this.f3451i[0] = Integer.valueOf(this.f3459l);
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
