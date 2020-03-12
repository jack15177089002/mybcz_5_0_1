package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.m */
/* compiled from: Context */
final class C2198m implements ContextAction {

    /* renamed from: a */
    final /* synthetic */ Callable f6802a;

    /* renamed from: b */
    final /* synthetic */ Scriptable f6803b;

    /* renamed from: c */
    final /* synthetic */ Scriptable f6804c;

    /* renamed from: d */
    final /* synthetic */ Object[] f6805d;

    C2198m(Callable eVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        this.f6802a = eVar;
        this.f6803b = drVar;
        this.f6804c = drVar2;
        this.f6805d = objArr;
    }

    /* renamed from: a */
    public final Object mo18676a(Context lVar) {
        return this.f6802a.call(lVar, this.f6803b, this.f6804c, this.f6805d);
    }
}
