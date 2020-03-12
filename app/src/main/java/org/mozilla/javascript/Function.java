package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.ab */
public interface Function extends Scriptable, Callable {
    Object call(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr);

    Scriptable construct(Context lVar, Scriptable drVar, Object[] objArr);
}
