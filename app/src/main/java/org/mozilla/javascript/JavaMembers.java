package org.mozilla.javascript;

import java.lang.reflect.Field;

/* renamed from: org.mozilla.javascript.aa */
final class JavaMembers extends NativeJavaMethod {

    /* renamed from: a */
    Field f5983a;

    /* renamed from: b */
    Object f5984b;

    JavaMembers(Scriptable drVar, MemberBox[] bbVarArr, Field field) {
        super(bbVarArr);
        this.f5983a = field;
        setParentScope(drVar);
        setPrototype(ScriptableObject.getFunctionPrototype(drVar));
    }

    public final Object getDefaultValue(Class<?> cls) {
        if (cls == ScriptRuntime.f6509p) {
            return this;
        }
        try {
            Object a = Context.m6769k().mo19142g().mo19103a(this, this.f5983a.get(this.f5984b), this.f5983a.getType());
            if (a instanceof Scriptable) {
                a = ((Scriptable) a).getDefaultValue(cls);
            }
            return a;
        } catch (IllegalAccessException e) {
            throw Context.m6755a("msg.java.internal.private", (Object) this.f5983a.getName());
        }
    }
}
