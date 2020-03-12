package org.mozilla.javascript;

import java.security.PrivilegedAction;
import java.security.ProtectionDomain;

/* renamed from: org.mozilla.javascript.ea */
/* compiled from: SecurityUtilities */
final class C2190ea implements PrivilegedAction<ProtectionDomain> {

    /* renamed from: a */
    final /* synthetic */ Class f6632a;

    C2190ea(Class cls) {
        this.f6632a = cls;
    }

    public final /* synthetic */ Object run() {
        return this.f6632a.getProtectionDomain();
    }
}
