package org.mozilla.javascript;

import java.security.AccessController;
import java.security.ProtectionDomain;

/* renamed from: org.mozilla.javascript.v */
public final class DefiningClassLoader extends ClassLoader implements GeneratedClassLoader {

    /* renamed from: a */
    private final ClassLoader f6829a;

    public DefiningClassLoader() {
        this.f6829a = getClass().getClassLoader();
    }

    public DefiningClassLoader(ClassLoader classLoader) {
        this.f6829a = classLoader;
    }

    /* renamed from: a */
    public final Class<?> mo18637a(String str, byte[] bArr) {
        return super.defineClass(str, bArr, 0, bArr.length, (ProtectionDomain) AccessController.doPrivileged(new C2190ea(getClass())));
    }

    /* renamed from: a */
    public final void mo18638a(Class<?> cls) {
        resolveClass(cls);
    }

    public final Class<?> loadClass(String str, boolean z) {
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            if (this.f6829a != null) {
                findLoadedClass = this.f6829a.loadClass(str);
            } else {
                findLoadedClass = findSystemClass(str);
            }
        }
        if (z) {
            resolveClass(findLoadedClass);
        }
        return findLoadedClass;
    }
}
