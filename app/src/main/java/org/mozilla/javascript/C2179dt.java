package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.dt */
/* compiled from: ScriptableObject */
final class C2179dt extends C2181dv {

    /* renamed from: a */
    Object f6534a;

    /* renamed from: b */
    Object f6535b;

    C2179dt(String str, int i, int i2) {
        super(str, i, i2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final ScriptableObject mo19058a(Context lVar, Scriptable drVar) {
        boolean z;
        boolean z2 = true;
        int b = mo19062b();
        NativeObject cbVar = new NativeObject();
        ScriptRuntime.m6384a((ScriptableObject) cbVar, drVar, C2193eh.Object);
        String str = "enumerable";
        if ((b & 2) == 0) {
            z = true;
        } else {
            z = false;
        }
        cbVar.defineProperty(str, (Object) Boolean.valueOf(z), 0);
        String str2 = "configurable";
        if ((b & 4) != 0) {
            z2 = false;
        }
        cbVar.defineProperty(str2, (Object) Boolean.valueOf(z2), 0);
        if (this.f6534a != null) {
            cbVar.defineProperty("get", this.f6534a, 0);
        }
        if (this.f6535b != null) {
            cbVar.defineProperty("set", this.f6535b, 0);
        }
        return cbVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo19060a(Object obj, Scriptable drVar, Scriptable drVar2) {
        Object[] objArr;
        if (this.f6535b != null) {
            Context k = Context.m6769k();
            if (this.f6535b instanceof MemberBox) {
                MemberBox bbVar = (MemberBox) this.f6535b;
                Class<?>[] clsArr = bbVar.f6279b;
                Object a = FunctionObject.m5650a(k, drVar2, obj, FunctionObject.m5649a(clsArr[clsArr.length - 1]));
                if (bbVar.f6280c == null) {
                    r9 = drVar2;
                    objArr = new Object[]{a};
                } else {
                    Object[] objArr2 = {drVar2, a};
                    r9 = bbVar.f6280c;
                    objArr = objArr2;
                }
                bbVar.mo18832a(r9, objArr);
            } else if (this.f6535b instanceof Function) {
                Function abVar = (Function) this.f6535b;
                abVar.call(k, abVar.getParentScope(), drVar2, new Object[]{obj});
            }
            return true;
        } else if (this.f6534a == null) {
            return super.mo19060a(obj, drVar, drVar2);
        } else {
            if (!Context.m6769k().mo19138b(11)) {
                return true;
            }
            throw ScriptRuntime.m6414b("msg.set.prop.no.setter", this.f6537c);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Object mo19057a(Scriptable drVar) {
        Object b;
        Object[] objArr;
        if (this.f6534a != null) {
            if (this.f6534a instanceof MemberBox) {
                MemberBox bbVar = (MemberBox) this.f6534a;
                if (bbVar.f6280c == null) {
                    r5 = drVar;
                    objArr = ScriptRuntime.f6517x;
                } else {
                    Object[] objArr2 = {drVar};
                    r5 = bbVar.f6280c;
                    objArr = objArr2;
                }
                return bbVar.mo18832a(r5, objArr);
            } else if (this.f6534a instanceof Function) {
                Function abVar = (Function) this.f6534a;
                return abVar.call(Context.m6769k(), abVar.getParentScope(), drVar, ScriptRuntime.f6517x);
            }
        }
        Object obj = this.f6541g;
        if (!(obj instanceof LazilyLoadedCtor)) {
            return obj;
        }
        LazilyLoadedCtor azVar = (LazilyLoadedCtor) obj;
        try {
            azVar.mo18706a();
            return b;
        } finally {
            this.f6541g = azVar.mo18707b();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo19059a() {
        super.mo19059a();
        this.f6534a = null;
        this.f6535b = null;
    }
}
