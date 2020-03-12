package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.k */
public interface ConstProperties {
    void defineConst(String str, Scriptable drVar);

    boolean isConst(String str);

    void putConst(String str, Scriptable drVar, Object obj);
}
