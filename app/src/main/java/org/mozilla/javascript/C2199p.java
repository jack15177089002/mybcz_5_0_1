package org.mozilla.javascript;

import java.security.PrivilegedAction;

/* renamed from: org.mozilla.javascript.p */
/* compiled from: ContextFactory */
final class C2199p implements PrivilegedAction<DefiningClassLoader> {

    /* renamed from: a */
    final /* synthetic */ ClassLoader f6811a;

    /* renamed from: b */
    final /* synthetic */ ContextFactory f6812b;

    C2199p(ContextFactory oVar, ClassLoader classLoader) {
        this.f6812b = oVar;
        this.f6811a = classLoader;
    }

    public final /* synthetic */ Object run() {
        return new DefiningClassLoader(this.f6811a);
    }
}
