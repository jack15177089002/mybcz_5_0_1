package org.mozilla.javascript;

import java.security.AccessController;

/* renamed from: org.mozilla.javascript.dw */
public abstract class SecurityController {

    /* renamed from: a */
    static SecurityController f6544a;

    /* renamed from: a */
    public abstract Object mo18991a(Object obj);

    /* renamed from: a */
    public abstract GeneratedClassLoader mo18993a(ClassLoader classLoader, Object obj);

    /* renamed from: b */
    public static GeneratedClassLoader m6498b(ClassLoader classLoader, Object obj) {
        Context k = Context.m6769k();
        if (classLoader == null) {
            classLoader = k.mo19143j();
        }
        SecurityController n = k.mo19145n();
        if (n == null) {
            return (GeneratedClassLoader) AccessController.doPrivileged(new C2199p(k.f6778b, classLoader));
        }
        return n.mo18993a(classLoader, n.mo18991a(obj));
    }

    /* renamed from: a */
    public Class<?> mo18990a() {
        return null;
    }

    /* renamed from: a */
    public Object mo18992a(Object obj, Context lVar, Callable eVar, Scriptable drVar, Object[] objArr) {
        new C2182dx(this, eVar, drVar, objArr);
        throw new IllegalStateException("callWithDomain should be overridden");
    }
}
