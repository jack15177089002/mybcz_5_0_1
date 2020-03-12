package org.mozilla.javascript;

import java.util.Comparator;

/* renamed from: org.mozilla.javascript.bd */
/* compiled from: NativeArray */
final class C2146bd implements Comparator<Object> {

    /* renamed from: a */
    final /* synthetic */ Object[] f6289a;

    /* renamed from: b */
    final /* synthetic */ Callable f6290b;

    /* renamed from: c */
    final /* synthetic */ Context f6291c;

    /* renamed from: d */
    final /* synthetic */ Scriptable f6292d;

    /* renamed from: e */
    final /* synthetic */ Scriptable f6293e;

    C2146bd(Object[] objArr, Callable eVar, Context lVar, Scriptable drVar, Scriptable drVar2) {
        this.f6289a = objArr;
        this.f6290b = eVar;
        this.f6291c = lVar;
        this.f6292d = drVar;
        this.f6293e = drVar2;
    }

    public final int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj2 == Undefined.f6689a || obj2 == Scriptable.f6533j) {
            return -1;
        }
        if (obj == Undefined.f6689a || obj == Scriptable.f6533j) {
            return 1;
        }
        this.f6289a[0] = obj;
        this.f6289a[1] = obj2;
        double b = ScriptRuntime.m6395b(this.f6290b.call(this.f6291c, this.f6292d, this.f6293e, this.f6289a));
        if (b < 0.0d) {
            return -1;
        }
        if (b > 0.0d) {
            return 1;
        }
        return 0;
    }
}
