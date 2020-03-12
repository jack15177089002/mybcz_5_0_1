package org.mozilla.javascript;

import java.io.Serializable;

/* renamed from: org.mozilla.javascript.cl */
public final class NativeWith implements Serializable, IdFunctionCall, Scriptable {

    /* renamed from: c */
    private static final Object f6385c = "With";

    /* renamed from: a */
    protected Scriptable f6386a;

    /* renamed from: b */
    protected Scriptable f6387b;

    /* renamed from: a */
    static void m6108a(Scriptable drVar) {
        NativeWith clVar = new NativeWith();
        clVar.setParentScope(drVar);
        clVar.setPrototype(ScriptableObject.getObjectPrototype(drVar));
        IdFunctionObject ahVar = new IdFunctionObject(clVar, f6385c, 1, "With", 0, drVar);
        ahVar.mo18642a((Scriptable) clVar);
        ahVar.mo18641a();
    }

    private NativeWith() {
    }

    protected NativeWith(Scriptable drVar, Scriptable drVar2) {
        this.f6387b = drVar;
        this.f6386a = drVar2;
    }

    public final String getClassName() {
        return "With";
    }

    public final boolean has(String str, Scriptable drVar) {
        return this.f6386a.has(str, this.f6386a);
    }

    public final boolean has(int i, Scriptable drVar) {
        return this.f6386a.has(i, this.f6386a);
    }

    public final Object get(String str, Scriptable drVar) {
        if (drVar == this) {
            drVar = this.f6386a;
        }
        return this.f6386a.get(str, drVar);
    }

    public final Object get(int i, Scriptable drVar) {
        if (drVar == this) {
            drVar = this.f6386a;
        }
        return this.f6386a.get(i, drVar);
    }

    public final void put(String str, Scriptable drVar, Object obj) {
        if (drVar == this) {
            drVar = this.f6386a;
        }
        this.f6386a.put(str, drVar, obj);
    }

    public final void put(int i, Scriptable drVar, Object obj) {
        if (drVar == this) {
            drVar = this.f6386a;
        }
        this.f6386a.put(i, drVar, obj);
    }

    public final void delete(String str) {
        this.f6386a.delete(str);
    }

    public final void delete(int i) {
        this.f6386a.delete(i);
    }

    public final Scriptable getPrototype() {
        return this.f6386a;
    }

    public final void setPrototype(Scriptable drVar) {
        this.f6386a = drVar;
    }

    public final Scriptable getParentScope() {
        return this.f6387b;
    }

    public final void setParentScope(Scriptable drVar) {
        this.f6387b = drVar;
    }

    public final Object[] getIds() {
        return this.f6386a.getIds();
    }

    public final Object getDefaultValue(Class<?> cls) {
        return this.f6386a.getDefaultValue(cls);
    }

    public final boolean hasInstance(Scriptable drVar) {
        return this.f6386a.hasInstance(drVar);
    }

    /* renamed from: a */
    protected static Object m6106a() {
        throw new IllegalStateException();
    }

    public final Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        if (!ahVar.mo18643a(f6385c) || ahVar.f5994a != 1) {
            throw ahVar.mo18644b();
        }
        throw Context.m6755a("msg.cant.call.indirect", (Object) "With");
    }

    /* renamed from: a */
    static boolean m6109a(Object obj) {
        if (!(obj instanceof IdFunctionObject)) {
            return false;
        }
        IdFunctionObject ahVar = (IdFunctionObject) obj;
        if (!ahVar.mo18643a(f6385c) || ahVar.f5994a != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    static Object m6107a(Context lVar, Scriptable drVar, Object[] objArr) {
        ScriptRuntime.m6385a(lVar, "With");
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(drVar);
        NativeWith clVar = new NativeWith();
        clVar.setPrototype(objArr.length == 0 ? ScriptableObject.getObjectPrototype(topLevelScope) : ScriptRuntime.m6410b(lVar, topLevelScope, objArr[0]));
        clVar.setParentScope(topLevelScope);
        return clVar;
    }
}
