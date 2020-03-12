package org.mozilla.javascript;

import java.io.Serializable;
import java.util.HashMap;

/* renamed from: org.mozilla.javascript.f */
public final class ClassCache implements Serializable {

    /* renamed from: a */
    static final Object f6697a = "ClassCache";

    /* renamed from: b */
    volatile boolean f6698b = true;

    /* renamed from: c */
    transient HashMap<Class<?>, C2140au> f6699c;

    /* renamed from: d */
    transient HashMap<C2139at, Class<?>> f6700d;

    /* renamed from: e */
    transient HashMap<Class<?>, Object> f6701e;

    /* renamed from: f */
    Scriptable f6702f;

    /* renamed from: g */
    private int f6703g;

    /* renamed from: a */
    public static ClassCache m6667a(Scriptable drVar) {
        ClassCache fVar = (ClassCache) ScriptableObject.getTopScopeValue(drVar, f6697a);
        if (fVar != null) {
            return fVar;
        }
        throw new RuntimeException("Can't find top level scope for ClassCache.get");
    }

    /* renamed from: a */
    public final synchronized int mo19104a() {
        int i;
        i = this.f6703g + 1;
        this.f6703g = i;
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final synchronized void mo19105a(Class<?> cls, Object obj) {
        if (this.f6698b) {
            if (this.f6701e == null) {
                this.f6701e = new HashMap<>();
            }
            this.f6701e.put(cls, obj);
        }
    }
}
