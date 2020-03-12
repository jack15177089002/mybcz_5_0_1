package org.mozilla.javascript;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessController;

/* renamed from: org.mozilla.javascript.az */
public final class LazilyLoadedCtor implements Serializable {

    /* renamed from: a */
    private final ScriptableObject f6095a;

    /* renamed from: b */
    private final String f6096b;

    /* renamed from: c */
    private final String f6097c;

    /* renamed from: d */
    private final boolean f6098d = false;

    /* renamed from: e */
    private final boolean f6099e = true;

    /* renamed from: f */
    private Object f6100f;

    /* renamed from: g */
    private int f6101g = 0;

    LazilyLoadedCtor(ScriptableObject dsVar, String str, String str2) {
        this.f6095a = dsVar;
        this.f6096b = str;
        this.f6097c = str2;
        dsVar.addLazilyInitializedValue(str, 0, this, 2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18706a() {
        synchronized (this) {
            if (this.f6101g == 1) {
                throw new IllegalStateException("Recursive initialization for " + this.f6096b);
            } else if (this.f6101g == 0) {
                this.f6101g = 1;
                Object obj = Scriptable.f6533j;
                try {
                    obj = this.f6099e ? AccessController.doPrivileged(new C2145ba(this)) : m5816c();
                } finally {
                    this.f6100f = obj;
                    this.f6101g = 2;
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final Object mo18707b() {
        if (this.f6101g == 2) {
            return this.f6100f;
        }
        throw new IllegalStateException(this.f6096b);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public Object m5816c() {
        Class a = Kit.m5805a(this.f6097c);
        if (a != null) {
            try {
                BaseFunction buildClassCtor = ScriptableObject.buildClassCtor(this.f6095a, a, this.f6098d, false);
                if (buildClassCtor != null) {
                    return buildClassCtor;
                }
                Object obj = this.f6095a.get(this.f6096b, (Scriptable) this.f6095a);
                if (obj != Scriptable.f6533j) {
                    return obj;
                }
            } catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();
                if (targetException instanceof RuntimeException) {
                    throw ((RuntimeException) targetException);
                }
            } catch (IllegalAccessException | InstantiationException | SecurityException | RhinoException e2) {
            }
        }
        return Scriptable.f6533j;
    }
}
