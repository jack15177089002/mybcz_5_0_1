package org.mozilla.javascript;

import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.util.Map;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.bv */
public final class NativeJavaClass extends NativeJavaObject implements Function {

    /* renamed from: a */
    private Map<String, JavaMembers> f6341a;

    public NativeJavaClass() {
    }

    private NativeJavaClass(Scriptable drVar, Class<?> cls) {
        this(drVar, cls, false);
    }

    public NativeJavaClass(Scriptable drVar, Class<?> cls, boolean z) {
        super(drVar, cls, null, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo18880b() {
        Class cls = (Class) this.f6352f;
        this.f6354h = C2140au.m5787a(this.f6351e, cls, cls, this.f6355i);
        this.f6341a = this.f6354h.mo18697a((Scriptable) this, (Object) cls, true);
    }

    public final String getClassName() {
        return "JavaClass";
    }

    public final boolean has(String str, Scriptable drVar) {
        return this.f6354h.mo18699a(str, true) || "__javaObject__".equals(str);
    }

    public final Object get(String str, Scriptable drVar) {
        if (str.equals("prototype")) {
            return null;
        }
        if (this.f6341a != null) {
            Object obj = this.f6341a.get(str);
            if (obj != null) {
                return obj;
            }
        }
        if (this.f6354h.mo18699a(str, true)) {
            return this.f6354h.mo18695a((Scriptable) this, str, this.f6352f, true);
        }
        Context k = Context.m6769k();
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(drVar);
        WrapFactory g = k.mo19142g();
        if ("__javaObject__".equals(str)) {
            return g.mo19103a(topLevelScope, this.f6352f, ScriptRuntime.f6497d);
        }
        Class cls = (Class) super.mo18879a();
        String str2 = cls.getName() + CoreConstants.DOLLAR + str;
        ClassLoader classLoader = cls.getClassLoader();
        Class a = classLoader == null ? Kit.m5805a(str2) : Kit.m5804a(classLoader, str2);
        if (a != null) {
            NativeJavaClass bvVar = new NativeJavaClass(topLevelScope, a);
            bvVar.setParentScope(this);
            return bvVar;
        }
        throw this.f6354h.mo18696a(str);
    }

    public final void put(String str, Scriptable drVar, Object obj) {
        this.f6354h.mo18698a(this, str, this.f6352f, obj, true);
    }

    public final Object[] getIds() {
        return this.f6354h.mo18700a(true);
    }

    /* renamed from: c */
    public final Class<?> mo18881c() {
        return (Class) super.mo18879a();
    }

    public final Object getDefaultValue(Class<?> cls) {
        if (cls == null || cls == ScriptRuntime.f6505l) {
            return toString();
        }
        if (cls == ScriptRuntime.f6494a) {
            return Boolean.TRUE;
        }
        if (cls == ScriptRuntime.f6502i) {
            return ScriptRuntime.f6515v;
        }
        return this;
    }

    public final Object call(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        if (objArr.length != 1 || !(objArr[0] instanceof Scriptable)) {
            return construct(lVar, drVar, objArr);
        }
        Class cls = (Class) super.mo18879a();
        Scriptable drVar3 = objArr[0];
        do {
            if ((drVar3 instanceof Wrapper) && cls.isInstance(((Wrapper) drVar3).mo18879a())) {
                return drVar3;
            }
            drVar3 = drVar3.getPrototype();
        } while (drVar3 != null);
        return construct(lVar, drVar, objArr);
    }

    public final Scriptable construct(Context lVar, Scriptable drVar, Object[] objArr) {
        String message;
        Class cls = (Class) super.mo18879a();
        int modifiers = cls.getModifiers();
        if (!Modifier.isInterface(modifiers) && !Modifier.isAbstract(modifiers)) {
            NativeJavaMethod bxVar = this.f6354h.f6082a;
            int a = bxVar.mo18884a(lVar, objArr);
            if (a >= 0) {
                return m6076a(lVar, drVar, objArr, bxVar.f6345c[a]);
            }
            throw Context.m6756a("msg.no.java.ctor", (Object) cls.getName(), (Object) NativeJavaMethod.m6080a(objArr));
        } else if (objArr.length == 0) {
            throw Context.m6763b("msg.adapter.zero.args");
        } else {
            Scriptable topLevelScope = ScriptableObject.getTopLevelScope(this);
            String str = "";
            try {
                if (!"Dalvik".equals(System.getProperty("java.vm.name")) || !cls.isInterface()) {
                    Object obj = topLevelScope.get("JavaAdapter", topLevelScope);
                    if (obj != f6533j) {
                        return ((Function) obj).construct(lVar, topLevelScope, new Object[]{this, objArr[0]});
                    }
                    message = str;
                    throw Context.m6756a("msg.cant.instantiate", (Object) message, (Object) cls.getName());
                }
                Object a2 = m6086a(cls, ScriptableObject.ensureScriptableObject(objArr[0]));
                lVar.mo19142g();
                return WrapFactory.m6664b(drVar, a2, null);
            } catch (Exception e) {
                message = e.getMessage();
                if (message == null) {
                    message = str;
                }
            }
        }
    }

    /* renamed from: a */
    static Scriptable m6076a(Context lVar, Scriptable drVar, Object[] objArr, MemberBox bbVar) {
        Object a = m6075a(objArr, bbVar);
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(drVar);
        lVar.mo19142g();
        if (a instanceof Scriptable) {
            return (Scriptable) a;
        }
        return a.getClass().isArray() ? NativeJavaArray.m6073a(topLevelScope, a) : WrapFactory.m6664b(topLevelScope, a, null);
    }

    /* renamed from: a */
    static Object m6075a(Object[] objArr, MemberBox bbVar) {
        Object[] objArr2;
        Object newInstance;
        int i = 0;
        Class<?>[] clsArr = bbVar.f6279b;
        if (bbVar.f6281d) {
            Object[] objArr3 = new Object[clsArr.length];
            for (int i2 = 0; i2 < clsArr.length - 1; i2++) {
                objArr3[i2] = Context.m6742a(objArr[i2], clsArr[i2]);
            }
            if (objArr.length != clsArr.length || (objArr[objArr.length - 1] != null && !(objArr[objArr.length - 1] instanceof NativeArray) && !(objArr[objArr.length - 1] instanceof NativeJavaArray))) {
                Class componentType = clsArr[clsArr.length - 1].getComponentType();
                newInstance = Array.newInstance(componentType, (objArr.length - clsArr.length) + 1);
                while (i < Array.getLength(newInstance)) {
                    Array.set(newInstance, i, Context.m6742a(objArr[(clsArr.length - 1) + i], componentType));
                    i++;
                }
            } else {
                newInstance = Context.m6742a(objArr[objArr.length - 1], clsArr[clsArr.length - 1]);
            }
            objArr3[clsArr.length - 1] = newInstance;
            objArr2 = objArr3;
        } else {
            objArr2 = objArr;
            while (i < objArr2.length) {
                Object obj = objArr2[i];
                Object a = Context.m6742a(obj, clsArr[i]);
                if (a != obj) {
                    if (objArr2 == objArr) {
                        objArr2 = (Object[]) objArr.clone();
                    }
                    objArr2[i] = a;
                }
                i++;
            }
        }
        return bbVar.mo18833a(objArr2);
    }

    public final String toString() {
        return "[JavaClass " + ((Class) super.mo18879a()).getName() + "]";
    }

    public final boolean hasInstance(Scriptable drVar) {
        if (!(drVar instanceof Wrapper) || (drVar instanceof NativeJavaClass)) {
            return false;
        }
        return ((Class) super.mo18879a()).isInstance(((Wrapper) drVar).mo18879a());
    }
}
