package org.mozilla.javascript;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* renamed from: org.mozilla.javascript.ac */
public class FunctionObject extends BaseFunction {

    /* renamed from: c */
    private static boolean f5985c;

    /* renamed from: a */
    MemberBox f5986a;

    /* renamed from: b */
    int f5987b;

    /* renamed from: d */
    private String f5988d;

    /* renamed from: e */
    private transient byte[] f5989e;

    /* renamed from: f */
    private transient boolean f5990f;

    /* renamed from: g */
    private transient int f5991g;

    /* renamed from: h */
    private boolean f5992h;

    public FunctionObject(String str, Member member, Scriptable drVar) {
        if (member instanceof Constructor) {
            this.f5986a = new MemberBox((Constructor) member);
            this.f5992h = true;
        } else {
            this.f5986a = new MemberBox((Method) member);
            this.f5992h = this.f5986a.mo18834a();
        }
        String b = this.f5986a.mo18835b();
        this.f5988d = str;
        Class<?>[] clsArr = this.f5986a.f6279b;
        int length = clsArr.length;
        if (length != 4 || (!clsArr[1].isArray() && !clsArr[2].isArray())) {
            this.f5987b = length;
            if (length > 0) {
                this.f5989e = new byte[length];
                for (int i = 0; i != length; i++) {
                    int a = m5649a(clsArr[i]);
                    if (a == 0) {
                        throw Context.m6756a("msg.bad.parms", (Object) clsArr[i].getName(), (Object) b);
                    }
                    this.f5989e[i] = (byte) a;
                }
            }
        } else if (clsArr[1].isArray()) {
            if (this.f5992h && clsArr[0] == ScriptRuntime.f6507n && clsArr[1].getComponentType() == ScriptRuntime.f6503j && clsArr[2] == ScriptRuntime.f6509p && clsArr[3] == Boolean.TYPE) {
                this.f5987b = -2;
            } else {
                throw Context.m6755a("msg.varargs.ctor", (Object) b);
            }
        } else if (this.f5992h && clsArr[0] == ScriptRuntime.f6507n && clsArr[1] == ScriptRuntime.f6511r && clsArr[2].getComponentType() == ScriptRuntime.f6503j && clsArr[3] == ScriptRuntime.f6509p) {
            this.f5987b = -1;
        } else {
            throw Context.m6755a("msg.varargs.fun", (Object) b);
        }
        if (this.f5986a.f6278a instanceof Method) {
            Class returnType = ((Method) this.f5986a.f6278a).getReturnType();
            if (returnType == Void.TYPE) {
                this.f5990f = true;
            } else {
                this.f5991g = m5649a(returnType);
            }
        } else {
            Class c = this.f5986a.mo18836c();
            if (!ScriptRuntime.f6511r.isAssignableFrom(c)) {
                throw Context.m6755a("msg.bad.ctor.return", (Object) c.getName());
            }
        }
        ScriptRuntime.m6379a((BaseFunction) this, drVar);
    }

    /* renamed from: a */
    public static int m5649a(Class<?> cls) {
        if (cls == ScriptRuntime.f6505l) {
            return 1;
        }
        if (cls == ScriptRuntime.f6500g || cls == Integer.TYPE) {
            return 2;
        }
        if (cls == ScriptRuntime.f6494a || cls == Boolean.TYPE) {
            return 3;
        }
        if (cls == ScriptRuntime.f6498e || cls == Double.TYPE) {
            return 4;
        }
        if (ScriptRuntime.f6511r.isAssignableFrom(cls)) {
            return 5;
        }
        if (cls == ScriptRuntime.f6503j) {
            return 6;
        }
        return 0;
    }

    /* renamed from: a */
    public static Object m5650a(Context lVar, Scriptable drVar, Object obj, int i) {
        switch (i) {
            case 1:
                if (obj instanceof String) {
                    return obj;
                }
                return ScriptRuntime.m6436d(obj);
            case 2:
                if (!(obj instanceof Integer)) {
                    return Integer.valueOf(ScriptRuntime.m6446f(obj));
                }
                return obj;
            case 3:
                if (!(obj instanceof Boolean)) {
                    return ScriptRuntime.m6391a(obj) ? Boolean.TRUE : Boolean.FALSE;
                }
                return obj;
            case 4:
                if (!(obj instanceof Double)) {
                    return new Double(ScriptRuntime.m6395b(obj));
                }
                return obj;
            case 5:
                return ScriptRuntime.m6366a(lVar, obj, drVar);
            case 6:
                return obj;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int getArity() {
        if (this.f5987b < 0) {
            return 1;
        }
        return this.f5987b;
    }

    public int getLength() {
        return getArity();
    }

    public String getFunctionName() {
        return this.f5988d == null ? "" : this.f5988d;
    }

    /* renamed from: a */
    static Method m5651a(Method[] methodArr, String str) {
        Method method = null;
        int length = methodArr.length;
        int i = 0;
        while (i != length) {
            Method method2 = methodArr[i];
            if (method2 == null || !str.equals(method2.getName())) {
                method2 = method;
            } else if (method != null) {
                throw Context.m6756a("msg.no.overload", (Object) str, (Object) method2.getDeclaringClass().getName());
            }
            i++;
            method = method2;
        }
        return method;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x000c  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static Method[] m5652b(Class<?> r6) {
        /*
            r1 = 0
            r3 = 0
            boolean r0 = f5985c     // Catch:{ SecurityException -> 0x0026 }
            if (r0 != 0) goto L_0x002a
            java.lang.reflect.Method[] r0 = r6.getDeclaredMethods()     // Catch:{ SecurityException -> 0x0026 }
        L_0x000a:
            if (r0 != 0) goto L_0x0010
            java.lang.reflect.Method[] r0 = r6.getMethods()
        L_0x0010:
            r2 = r3
            r4 = r3
        L_0x0012:
            int r5 = r0.length
            if (r2 >= r5) goto L_0x003b
            boolean r5 = f5985c
            if (r5 == 0) goto L_0x002c
            r5 = r0[r2]
            java.lang.Class r5 = r5.getDeclaringClass()
            if (r5 == r6) goto L_0x0038
        L_0x0021:
            r0[r2] = r1
        L_0x0023:
            int r2 = r2 + 1
            goto L_0x0012
        L_0x0026:
            r0 = move-exception
            r0 = 1
            f5985c = r0
        L_0x002a:
            r0 = r1
            goto L_0x000a
        L_0x002c:
            r5 = r0[r2]
            int r5 = r5.getModifiers()
            boolean r5 = java.lang.reflect.Modifier.isPublic(r5)
            if (r5 == 0) goto L_0x0021
        L_0x0038:
            int r4 = r4 + 1
            goto L_0x0023
        L_0x003b:
            java.lang.reflect.Method[] r4 = new java.lang.reflect.Method[r4]
            r1 = r3
        L_0x003e:
            int r2 = r0.length
            if (r3 >= r2) goto L_0x004f
            r2 = r0[r3]
            if (r2 == 0) goto L_0x004c
            int r2 = r1 + 1
            r5 = r0[r3]
            r4[r1] = r5
            r1 = r2
        L_0x004c:
            int r3 = r3 + 1
            goto L_0x003e
        L_0x004f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.FunctionObject.m5652b(java.lang.Class):java.lang.reflect.Method[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Object call(Context r9, Scriptable r10, Scriptable r11, Object[] r12) {
        /*
            r8 = this;
            r6 = 3
            r3 = 2
            r7 = 0
            r4 = 1
            r2 = 0
            int r5 = r12.length
            r0 = r2
        L_0x0007:
            if (r0 >= r5) goto L_0x001a
            r1 = r12[r0]
            boolean r1 = r1 instanceof org.mozilla.javascript.ConsString
            if (r1 == 0) goto L_0x0017
            r1 = r12[r0]
            java.lang.String r1 = r1.toString()
            r12[r0] = r1
        L_0x0017:
            int r0 = r0 + 1
            goto L_0x0007
        L_0x001a:
            int r0 = r8.f5987b
            if (r0 >= 0) goto L_0x006b
            int r0 = r8.f5987b
            r1 = -1
            if (r0 != r1) goto L_0x003e
            r0 = 4
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r9
            r0[r4] = r11
            r0[r3] = r12
            r0[r6] = r8
            org.mozilla.javascript.bb r1 = r8.f5986a
            java.lang.Object r0 = r1.mo18832a(r7, r0)
            r2 = r4
        L_0x0035:
            if (r2 == 0) goto L_0x003d
            boolean r1 = r8.f5990f
            if (r1 == 0) goto L_0x00f4
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x003d:
            return r0
        L_0x003e:
            if (r11 != 0) goto L_0x005f
            r0 = r4
        L_0x0041:
            if (r0 == 0) goto L_0x0061
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
        L_0x0045:
            r1 = 4
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r9
            r1[r4] = r12
            r1[r3] = r8
            r1[r6] = r0
            org.mozilla.javascript.bb r0 = r8.f5986a
            java.lang.reflect.Member r0 = r0.f6278a
            boolean r0 = r0 instanceof java.lang.reflect.Constructor
            if (r0 == 0) goto L_0x0064
            org.mozilla.javascript.bb r0 = r8.f5986a
            java.lang.Object r0 = r0.mo18833a(r1)
            goto L_0x0035
        L_0x005f:
            r0 = r2
            goto L_0x0041
        L_0x0061:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x0045
        L_0x0064:
            org.mozilla.javascript.bb r0 = r8.f5986a
            java.lang.Object r0 = r0.mo18832a(r7, r1)
            goto L_0x0035
        L_0x006b:
            boolean r0 = r8.f5992h
            if (r0 != 0) goto L_0x0095
            org.mozilla.javascript.bb r0 = r8.f5986a
            java.lang.Class r0 = r0.mo18836c()
            boolean r1 = r0.isInstance(r11)
            if (r1 != 0) goto L_0x0095
            if (r11 != r10) goto L_0x0104
            org.mozilla.javascript.dr r1 = r8.getParentScope()
            if (r10 == r1) goto L_0x0104
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto L_0x008a
            r11 = r1
        L_0x008a:
            if (r0 != 0) goto L_0x0095
            java.lang.String r0 = "msg.incompat.call"
            java.lang.String r1 = r8.f5988d
            org.mozilla.javascript.w r0 = org.mozilla.javascript.ScriptRuntime.m6414b(r0, r1)
            throw r0
        L_0x0095:
            int r0 = r8.f5987b
            if (r0 != r5) goto L_0x00b8
            r1 = r2
            r0 = r12
        L_0x009b:
            int r3 = r8.f5987b
            if (r1 == r3) goto L_0x00be
            r3 = r12[r1]
            byte[] r5 = r8.f5989e
            byte r5 = r5[r1]
            java.lang.Object r5 = m5650a(r9, r10, r3, r5)
            if (r3 == r5) goto L_0x00b5
            if (r0 != r12) goto L_0x00b3
            java.lang.Object r0 = r12.clone()
            java.lang.Object[] r0 = (java.lang.Object[]) r0
        L_0x00b3:
            r0[r1] = r5
        L_0x00b5:
            int r1 = r1 + 1
            goto L_0x009b
        L_0x00b8:
            int r0 = r8.f5987b
            if (r0 != 0) goto L_0x00cf
            java.lang.Object[] r0 = org.mozilla.javascript.ScriptRuntime.f6517x
        L_0x00be:
            org.mozilla.javascript.bb r1 = r8.f5986a
            java.lang.reflect.Member r1 = r1.f6278a
            boolean r1 = r1 instanceof java.lang.reflect.Method
            if (r1 == 0) goto L_0x00ec
            org.mozilla.javascript.bb r1 = r8.f5986a
            java.lang.Object r0 = r1.mo18832a(r11, r0)
            r2 = r4
            goto L_0x0035
        L_0x00cf:
            int r0 = r8.f5987b
            java.lang.Object[] r3 = new java.lang.Object[r0]
            r0 = r2
        L_0x00d4:
            int r1 = r8.f5987b
            if (r0 == r1) goto L_0x0102
            if (r0 >= r5) goto L_0x00e9
            r1 = r12[r0]
        L_0x00dc:
            byte[] r6 = r8.f5989e
            byte r6 = r6[r0]
            java.lang.Object r1 = m5650a(r9, r10, r1, r6)
            r3[r0] = r1
            int r0 = r0 + 1
            goto L_0x00d4
        L_0x00e9:
            java.lang.Object r1 = org.mozilla.javascript.Undefined.f6689a
            goto L_0x00dc
        L_0x00ec:
            org.mozilla.javascript.bb r1 = r8.f5986a
            java.lang.Object r0 = r1.mo18833a(r0)
            goto L_0x0035
        L_0x00f4:
            int r1 = r8.f5991g
            if (r1 != 0) goto L_0x003d
            org.mozilla.javascript.em r1 = r9.mo19142g()
            java.lang.Object r0 = r1.mo19103a(r10, r0, r7)
            goto L_0x003d
        L_0x0102:
            r0 = r3
            goto L_0x00be
        L_0x0104:
            r0 = r2
            goto L_0x008a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.FunctionObject.call(org.mozilla.javascript.l, org.mozilla.javascript.dr, org.mozilla.javascript.dr, java.lang.Object[]):java.lang.Object");
    }

    public Scriptable createObject(Context lVar, Scriptable drVar) {
        if ((this.f5986a.f6278a instanceof Constructor) || this.f5987b == -2) {
            return null;
        }
        try {
            Scriptable drVar2 = (Scriptable) this.f5986a.mo18836c().newInstance();
            drVar2.setPrototype(getClassPrototype());
            drVar2.setParentScope(getParentScope());
            return drVar2;
        } catch (Exception e) {
            throw Context.m6746a((Throwable) e);
        }
    }
}
