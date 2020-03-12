package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.dr */
public interface Scriptable {

    /* renamed from: j */
    public static final Object f6533j = UniqueTag.f6690a;

    void delete(int i);

    void delete(String str);

    Object get(int i, Scriptable drVar);

    Object get(String str, Scriptable drVar);

    String getClassName();

    Object getDefaultValue(Class<?> cls);

    Object[] getIds();

    Scriptable getParentScope();

    Scriptable getPrototype();

    boolean has(int i, Scriptable drVar);

    boolean has(String str, Scriptable drVar);

    boolean hasInstance(Scriptable drVar);

    void put(int i, Scriptable drVar, Object obj);

    void put(String str, Scriptable drVar, Object obj);

    void setParentScope(Scriptable drVar);

    void setPrototype(Scriptable drVar);
}
