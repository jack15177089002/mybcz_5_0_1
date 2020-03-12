package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.d */
public final class BoundFunction extends BaseFunction {

    /* renamed from: a */
    private final Callable f6471a;

    /* renamed from: b */
    private final Scriptable f6472b;

    /* renamed from: c */
    private final Object[] f6473c;

    /* renamed from: d */
    private final int f6474d;

    public BoundFunction(Context lVar, Scriptable drVar, Callable eVar, Scriptable drVar2, Object[] objArr) {
        this.f6471a = eVar;
        this.f6472b = drVar2;
        this.f6473c = objArr;
        if (eVar instanceof BaseFunction) {
            this.f6474d = Math.max(0, ((BaseFunction) eVar).getLength() - objArr.length);
        } else {
            this.f6474d = 0;
        }
        ScriptRuntime.m6379a((BaseFunction) this, drVar);
        BaseFunction a = ScriptRuntime.m6358a();
        NativeObject cbVar = new NativeObject();
        cbVar.put("get", cbVar, a);
        cbVar.put("set", cbVar, a);
        cbVar.put("enumerable", cbVar, Boolean.valueOf(false));
        cbVar.put("configurable", cbVar, Boolean.valueOf(false));
        cbVar.preventExtensions();
        defineOwnProperty(lVar, "caller", cbVar, false);
        defineOwnProperty(lVar, "arguments", cbVar, false);
    }

    public final Object call(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        return this.f6471a.call(lVar, drVar, this.f6472b != null ? this.f6472b : ScriptRuntime.m6438d(lVar), m6287a(this.f6473c, objArr));
    }

    public final Scriptable construct(Context lVar, Scriptable drVar, Object[] objArr) {
        if (this.f6471a instanceof Function) {
            return ((Function) this.f6471a).construct(lVar, drVar, m6287a(this.f6473c, objArr));
        }
        throw ScriptRuntime.m6455g("msg.not.ctor");
    }

    public final boolean hasInstance(Scriptable drVar) {
        if (this.f6471a instanceof Function) {
            return ((Function) this.f6471a).hasInstance(drVar);
        }
        throw ScriptRuntime.m6455g("msg.not.ctor");
    }

    public final int getLength() {
        return this.f6474d;
    }

    /* renamed from: a */
    private static Object[] m6287a(Object[] objArr, Object[] objArr2) {
        Object[] objArr3 = new Object[(objArr.length + objArr2.length)];
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        return objArr3;
    }
}
