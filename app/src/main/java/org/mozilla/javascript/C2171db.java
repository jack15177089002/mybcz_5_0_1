package org.mozilla.javascript;

import java.security.CodeSource;
import java.security.SecureClassLoader;

/* renamed from: org.mozilla.javascript.db */
/* compiled from: PolicySecurityController */
final class C2171db extends SecureClassLoader implements GeneratedClassLoader {

    /* renamed from: a */
    private final CodeSource f6483a;

    C2171db(ClassLoader classLoader, CodeSource codeSource) {
        super(classLoader);
        this.f6483a = codeSource;
    }

    /* renamed from: a */
    public final Class<?> mo18637a(String str, byte[] bArr) {
        return defineClass(str, bArr, 0, bArr.length, this.f6483a);
    }

    /* renamed from: a */
    public final void mo18638a(Class<?> cls) {
        resolveClass(cls);
    }
}
