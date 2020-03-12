package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.dp */
/* compiled from: ScriptRuntime */
final class C2178dp implements Callable {

    /* renamed from: a */
    String f6528a;

    /* renamed from: b */
    Callable f6529b;

    C2178dp(Callable eVar, String str) {
        this.f6529b = eVar;
        this.f6528a = str;
    }

    public final Object call(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        return this.f6529b.call(lVar, drVar, drVar2, new Object[]{this.f6528a, ScriptRuntime.m6369a(objArr, (int[]) null, drVar)});
    }
}
