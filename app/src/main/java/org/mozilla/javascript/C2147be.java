package org.mozilla.javascript;

import java.util.Comparator;

/* renamed from: org.mozilla.javascript.be */
/* compiled from: NativeArray */
final class C2147be implements Comparator<Object> {
    C2147be() {
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
        return ScriptRuntime.m6436d(obj).compareTo(ScriptRuntime.m6436d(obj2));
    }
}
