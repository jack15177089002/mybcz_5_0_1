package org.mozilla.javascript;

import java.security.PrivilegedAction;

/* renamed from: org.mozilla.javascript.cz */
/* compiled from: PolicySecurityController */
final class C2168cz implements PrivilegedAction<Object> {

    /* renamed from: a */
    final /* synthetic */ Context f6469a;

    /* renamed from: b */
    final /* synthetic */ PolicySecurityController f6470b;

    C2168cz(PolicySecurityController cxVar, Context lVar) {
        this.f6470b = cxVar;
        this.f6469a = lVar;
    }

    public final Object run() {
        return this.f6469a.mo19143j();
    }
}
