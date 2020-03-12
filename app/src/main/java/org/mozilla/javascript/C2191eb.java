package org.mozilla.javascript;

import java.security.PrivilegedAction;
import java.security.ProtectionDomain;

/* renamed from: org.mozilla.javascript.eb */
/* compiled from: SecurityUtilities */
final class C2191eb implements PrivilegedAction<ProtectionDomain> {

    /* renamed from: a */
    final /* synthetic */ SecurityManager f6633a;

    C2191eb(SecurityManager securityManager) {
        this.f6633a = securityManager;
    }

    public final /* synthetic */ Object run() {
        Class a = ((RhinoSecurityManager) this.f6633a).mo19018a();
        if (a == null) {
            return null;
        }
        return a.getProtectionDomain();
    }
}
