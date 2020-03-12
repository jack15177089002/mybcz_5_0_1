package org.mozilla.javascript;

import java.lang.reflect.Array;

/* renamed from: org.mozilla.javascript.bu */
public final class NativeJavaArray extends NativeJavaObject {

    /* renamed from: a */
    Object f6338a;

    /* renamed from: b */
    int f6339b;

    /* renamed from: c */
    Class<?> f6340c;

    public final String getClassName() {
        return "JavaArray";
    }

    /* renamed from: a */
    public static NativeJavaArray m6073a(Scriptable drVar, Object obj) {
        return new NativeJavaArray(drVar, obj);
    }

    /* renamed from: a */
    public final Object mo18879a() {
        return this.f6338a;
    }

    private NativeJavaArray(Scriptable drVar, Object obj) {
        super(drVar, null, ScriptRuntime.f6503j);
        Class cls = obj.getClass();
        if (!cls.isArray()) {
            throw new RuntimeException("Array expected");
        }
        this.f6338a = obj;
        this.f6339b = Array.getLength(obj);
        this.f6340c = cls.getComponentType();
    }

    public final boolean has(String str, Scriptable drVar) {
        return str.equals("length") || super.has(str, drVar);
    }

    public final boolean has(int i, Scriptable drVar) {
        return i >= 0 && i < this.f6339b;
    }

    public final Object get(String str, Scriptable drVar) {
        if (str.equals("length")) {
            return Integer.valueOf(this.f6339b);
        }
        Object obj = super.get(str, drVar);
        if (obj != f6533j || ScriptableObject.hasProperty(getPrototype(), str)) {
            return obj;
        }
        throw Context.m6756a("msg.java.member.not.found", (Object) this.f6338a.getClass().getName(), (Object) str);
    }

    public final Object get(int i, Scriptable drVar) {
        if (i < 0 || i >= this.f6339b) {
            return Undefined.f6689a;
        }
        Context k = Context.m6769k();
        return k.mo19142g().mo19103a(this, Array.get(this.f6338a, i), this.f6340c);
    }

    public final void put(String str, Scriptable drVar, Object obj) {
        if (!str.equals("length")) {
            throw Context.m6755a("msg.java.array.member.not.found", (Object) str);
        }
    }

    public final void put(int i, Scriptable drVar, Object obj) {
        if (i < 0 || i >= this.f6339b) {
            throw Context.m6756a("msg.java.array.index.out.of.bounds", (Object) String.valueOf(i), (Object) String.valueOf(this.f6339b - 1));
        }
        Array.set(this.f6338a, i, Context.m6742a(obj, this.f6340c));
    }

    public final Object getDefaultValue(Class<?> cls) {
        if (cls == null || cls == ScriptRuntime.f6505l) {
            return this.f6338a.toString();
        }
        if (cls == ScriptRuntime.f6494a) {
            return Boolean.TRUE;
        }
        if (cls == ScriptRuntime.f6502i) {
            return ScriptRuntime.f6515v;
        }
        return this;
    }

    public final Object[] getIds() {
        Object[] objArr = new Object[this.f6339b];
        int i = this.f6339b;
        while (true) {
            i--;
            if (i < 0) {
                return objArr;
            }
            objArr[i] = Integer.valueOf(i);
        }
    }

    public final boolean hasInstance(Scriptable drVar) {
        if (!(drVar instanceof Wrapper)) {
            return false;
        }
        return this.f6340c.isInstance(((Wrapper) drVar).mo18879a());
    }

    public final Scriptable getPrototype() {
        if (this.f6350d == null) {
            this.f6350d = ScriptableObject.getArrayPrototype(getParentScope());
        }
        return this.f6350d;
    }
}
