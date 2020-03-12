package org.mozilla.javascript;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* renamed from: org.mozilla.javascript.bb */
final class MemberBox implements Serializable {

    /* renamed from: e */
    private static final Class<?>[] f6277e = {Boolean.TYPE, Byte.TYPE, Character.TYPE, Double.TYPE, Float.TYPE, Integer.TYPE, Long.TYPE, Short.TYPE, Void.TYPE};

    /* renamed from: a */
    transient Member f6278a;

    /* renamed from: b */
    transient Class<?>[] f6279b;

    /* renamed from: c */
    transient Object f6280c;

    /* renamed from: d */
    transient boolean f6281d = VMBridge.f6694a.mo19102c();

    MemberBox(Method method) {
        this.f6278a = method;
        this.f6279b = method.getParameterTypes();
    }

    MemberBox(Constructor<?> constructor) {
        this.f6278a = constructor;
        this.f6279b = constructor.getParameterTypes();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo18834a() {
        return Modifier.isStatic(this.f6278a.getModifiers());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final String mo18835b() {
        return this.f6278a.getName();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final Class<?> mo18836c() {
        return this.f6278a.getDeclaringClass();
    }

    public final String toString() {
        return this.f6278a.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Object mo18832a(Object obj, Object[] objArr) {
        Method method = (Method) this.f6278a;
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            Method a = m5969a(method, this.f6279b);
            if (a != null) {
                this.f6278a = a;
                method = a;
            } else if (!VMBridge.f6694a.mo19101b(method)) {
                throw Context.m6746a((Throwable) e);
            }
            return method.invoke(obj, objArr);
        } catch (InvocationTargetException e2) {
            e = e2;
            do {
                e = ((InvocationTargetException) e).getTargetException();
            } while (e instanceof InvocationTargetException);
            if (e instanceof ContinuationPending) {
                throw ((ContinuationPending) e);
            }
            throw Context.m6746a(e);
        } catch (Exception e3) {
            throw Context.m6746a((Throwable) e3);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Object mo18833a(Object[] objArr) {
        Constructor constructor = (Constructor) this.f6278a;
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException e) {
            if (VMBridge.f6694a.mo19101b(constructor)) {
                return constructor.newInstance(objArr);
            }
            throw Context.m6746a((Throwable) e);
        } catch (Exception e2) {
            throw Context.m6746a((Throwable) e2);
        }
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 129 */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        if (java.lang.reflect.Modifier.isPublic(r3) == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        if (java.lang.reflect.Modifier.isStatic(r3) != false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0064, code lost:
        r0 = r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Method m5969a(Method r7, Class<?>[] r8) {
        /*
            int r0 = r7.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isPublic(r0)
            if (r1 == 0) goto L_0x0066
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            if (r0 != 0) goto L_0x0066
            java.lang.Class r0 = r7.getDeclaringClass()
            int r1 = r0.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isPublic(r1)
            if (r1 != 0) goto L_0x0066
            java.lang.String r2 = r7.getName()
            java.lang.Class[] r3 = r0.getInterfaces()
            r1 = 0
            int r4 = r3.length
        L_0x0028:
            if (r1 == r4) goto L_0x0040
            r5 = r3[r1]
            int r6 = r5.getModifiers()
            boolean r6 = java.lang.reflect.Modifier.isPublic(r6)
            if (r6 == 0) goto L_0x003c
            java.lang.reflect.Method r0 = r5.getMethod(r2, r8)     // Catch:{ NoSuchMethodException -> 0x003b, SecurityException -> 0x0068 }
        L_0x003a:
            return r0
        L_0x003b:
            r5 = move-exception
        L_0x003c:
            int r1 = r1 + 1
            goto L_0x0028
        L_0x003f:
            r1 = move-exception
        L_0x0040:
            java.lang.Class r0 = r0.getSuperclass()
            if (r0 == 0) goto L_0x0066
            int r1 = r0.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isPublic(r1)
            if (r1 == 0) goto L_0x0040
            java.lang.reflect.Method r1 = r0.getMethod(r2, r8)     // Catch:{ NoSuchMethodException -> 0x006a, SecurityException -> 0x003f }
            int r3 = r1.getModifiers()     // Catch:{ NoSuchMethodException -> 0x006a, SecurityException -> 0x003f }
            boolean r4 = java.lang.reflect.Modifier.isPublic(r3)     // Catch:{ NoSuchMethodException -> 0x006a, SecurityException -> 0x003f }
            if (r4 == 0) goto L_0x0040
            boolean r3 = java.lang.reflect.Modifier.isStatic(r3)     // Catch:{ NoSuchMethodException -> 0x006a, SecurityException -> 0x003f }
            if (r3 != 0) goto L_0x0040
            r0 = r1
            goto L_0x003a
        L_0x0066:
            r0 = 0
            goto L_0x003a
        L_0x0068:
            r5 = move-exception
            goto L_0x003c
        L_0x006a:
            r1 = move-exception
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.MemberBox.m5969a(java.lang.reflect.Method, java.lang.Class[]):java.lang.reflect.Method");
    }
}
