package org.mozilla.javascript.jdk13;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.InterfaceAdapter;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.VMBridge;

public class VMBridge_jdk13 extends VMBridge {

    /* renamed from: b */
    private ThreadLocal<Object[]> f6760b = new ThreadLocal<>();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo19095a() {
        Object[] objArr = (Object[]) this.f6760b.get();
        if (objArr != null) {
            return objArr;
        }
        Object[] objArr2 = new Object[1];
        this.f6760b.set(objArr2);
        return objArr2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Context mo19098a(Object obj) {
        return (Context) ((Object[]) obj)[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo19099a(Object obj, Context lVar) {
        ((Object[]) obj)[0] = lVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final ClassLoader mo19100b() {
        return Thread.currentThread().getContextClassLoader();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final boolean mo19101b(Object obj) {
        if (!(obj instanceof AccessibleObject)) {
            return false;
        }
        AccessibleObject accessibleObject = (AccessibleObject) obj;
        if (accessibleObject.isAccessible()) {
            return true;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e) {
        }
        return accessibleObject.isAccessible();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo19097a(Class<?>[] clsArr) {
        try {
            return Proxy.getProxyClass(clsArr[0].getClassLoader(), clsArr).getConstructor(new Class[]{InvocationHandler.class});
        } catch (NoSuchMethodException e) {
            throw Kit.m5811a((RuntimeException) new IllegalStateException(), (Throwable) e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Object mo19096a(Object obj, ContextFactory oVar, InterfaceAdapter akVar, Object obj2, Scriptable drVar) {
        try {
            return ((Constructor) obj).newInstance(new Object[]{new C2197a(this, obj2, akVar, oVar, drVar)});
        } catch (InvocationTargetException e) {
            throw Context.m6746a((Throwable) e);
        } catch (IllegalAccessException e2) {
            throw Kit.m5811a((RuntimeException) new IllegalStateException(), (Throwable) e2);
        } catch (InstantiationException e3) {
            throw Kit.m5811a((RuntimeException) new IllegalStateException(), (Throwable) e3);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final boolean mo19102c() {
        return false;
    }
}
