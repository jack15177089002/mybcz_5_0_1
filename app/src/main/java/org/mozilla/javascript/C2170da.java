package org.mozilla.javascript;

import java.security.CodeSource;
import java.security.PrivilegedExceptionAction;

/* renamed from: org.mozilla.javascript.da */
/* compiled from: PolicySecurityController */
final class C2170da implements PrivilegedExceptionAction<Object> {

    /* renamed from: a */
    final /* synthetic */ ClassLoader f6480a;

    /* renamed from: b */
    final /* synthetic */ CodeSource f6481b;

    /* renamed from: c */
    final /* synthetic */ PolicySecurityController f6482c;

    C2170da(PolicySecurityController cxVar, ClassLoader classLoader, CodeSource codeSource) {
        this.f6482c = cxVar;
        this.f6480a = classLoader;
        this.f6481b = codeSource;
    }

    public final Object run() {
        return new C2171db(this.f6480a, this.f6481b).mo18637a(C2172dc.class.getName() + "Impl", PolicySecurityController.f6464b).newInstance();
    }
}
