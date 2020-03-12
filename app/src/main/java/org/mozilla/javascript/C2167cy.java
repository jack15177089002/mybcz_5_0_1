package org.mozilla.javascript;

import java.security.CodeSource;
import java.security.PrivilegedAction;

/* renamed from: org.mozilla.javascript.cy */
/* compiled from: PolicySecurityController */
final class C2167cy implements PrivilegedAction<Object> {

    /* renamed from: a */
    final /* synthetic */ ClassLoader f6466a;

    /* renamed from: b */
    final /* synthetic */ Object f6467b;

    /* renamed from: c */
    final /* synthetic */ PolicySecurityController f6468c;

    C2167cy(PolicySecurityController cxVar, ClassLoader classLoader, Object obj) {
        this.f6468c = cxVar;
        this.f6466a = classLoader;
        this.f6467b = obj;
    }

    public final Object run() {
        return new C2171db(this.f6466a, (CodeSource) this.f6467b);
    }
}
