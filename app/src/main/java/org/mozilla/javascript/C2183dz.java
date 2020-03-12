package org.mozilla.javascript;

import java.security.PrivilegedAction;

/* renamed from: org.mozilla.javascript.dz */
/* compiled from: SecurityUtilities */
final class C2183dz implements PrivilegedAction<String> {

    /* renamed from: a */
    final /* synthetic */ String f6549a;

    C2183dz(String str) {
        this.f6549a = str;
    }

    public final /* synthetic */ Object run() {
        return System.getProperty(this.f6549a);
    }
}
