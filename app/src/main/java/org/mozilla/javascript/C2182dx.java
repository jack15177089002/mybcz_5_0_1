package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.dx */
/* compiled from: SecurityController */
final class C2182dx implements Script {

    /* renamed from: a */
    final /* synthetic */ Callable f6545a;

    /* renamed from: b */
    final /* synthetic */ Scriptable f6546b;

    /* renamed from: c */
    final /* synthetic */ Object[] f6547c;

    /* renamed from: d */
    final /* synthetic */ SecurityController f6548d;

    C2182dx(SecurityController dwVar, Callable eVar, Scriptable drVar, Object[] objArr) {
        this.f6548d = dwVar;
        this.f6545a = eVar;
        this.f6546b = drVar;
        this.f6547c = objArr;
    }

    /* renamed from: a */
    public final Object mo18678a(Context lVar, Scriptable drVar) {
        return this.f6545a.call(lVar, drVar, this.f6546b, this.f6547c);
    }
}
