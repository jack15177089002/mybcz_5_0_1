package org.mozilla.javascript;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
//import org.mozilla.p108a.C2126c;
//import org.mozilla.p108a.C2129f;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.as */
public final class JavaAdapter implements IdFunctionCall {

    /* renamed from: a */
    private static final Object f6078a = "JavaAdapter";

    public final Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        if (ahVar.mo18643a(f6078a) && ahVar.f5994a == 1) {
            return m5774a(lVar, drVar, objArr);
        }
        throw ahVar.mo18644b();
    }

    /* JADX WARNING: type inference failed for: r1v28, types: [java.security.CodeSource] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Object m5774a(Context r13, Scriptable r14, Object[] r15) {
        /*
            r5 = 0
            r7 = 0
            int r9 = r15.length
            if (r9 != 0) goto L_0x000c
            java.lang.String r1 = "msg.adapter.zero.args"
            org.mozilla.javascript.w r1 = org.mozilla.javascript.ScriptRuntime.m6455g(r1)
            throw r1
        L_0x000c:
            r8 = r7
        L_0x000d:
            int r1 = r9 + -1
            if (r8 >= r1) goto L_0x002e
            r1 = r15[r8]
            boolean r2 = r1 instanceof org.mozilla.javascript.NativeObject
            if (r2 != 0) goto L_0x002e
            boolean r2 = r1 instanceof org.mozilla.javascript.NativeJavaClass
            if (r2 != 0) goto L_0x002a
            java.lang.String r2 = "msg.not.java.class.arg"
            java.lang.String r3 = java.lang.String.valueOf(r8)
            java.lang.String r1 = org.mozilla.javascript.ScriptRuntime.m6436d(r1)
            org.mozilla.javascript.w r1 = org.mozilla.javascript.ScriptRuntime.m6376a(r2, r3, r1)
            throw r1
        L_0x002a:
            int r1 = r8 + 1
            r8 = r1
            goto L_0x000d
        L_0x002e:
            java.lang.Class[] r10 = new java.lang.Class[r8]
            r6 = r7
            r2 = r7
            r4 = r5
        L_0x0033:
            if (r6 >= r8) goto L_0x0062
            r1 = r15[r6]
            org.mozilla.javascript.bv r1 = (org.mozilla.javascript.NativeJavaClass) r1
            java.lang.Class r3 = r1.mo18881c()
            boolean r1 = r3.isInterface()
            if (r1 != 0) goto L_0x005c
            if (r4 == 0) goto L_0x0054
            java.lang.String r1 = "msg.only.one.super"
            java.lang.String r2 = r4.getName()
            java.lang.String r3 = r3.getName()
            org.mozilla.javascript.w r1 = org.mozilla.javascript.ScriptRuntime.m6376a(r1, r2, r3)
            throw r1
        L_0x0054:
            r1 = r2
            r2 = r3
        L_0x0056:
            int r3 = r6 + 1
            r6 = r3
            r4 = r2
            r2 = r1
            goto L_0x0033
        L_0x005c:
            int r1 = r2 + 1
            r10[r2] = r3
            r2 = r4
            goto L_0x0056
        L_0x0062:
            if (r4 != 0) goto L_0x0066
            java.lang.Class<?> r4 = org.mozilla.javascript.ScriptRuntime.f6503j
        L_0x0066:
            java.lang.Class[] r3 = new java.lang.Class[r2]
            java.lang.System.arraycopy(r10, r7, r3, r7, r2)
            r1 = r15[r8]
            org.mozilla.javascript.dr r6 = org.mozilla.javascript.ScriptableObject.ensureScriptable(r1)
            org.mozilla.javascript.f r7 = org.mozilla.javascript.ClassCache.m6667a(r14)
            java.util.HashMap<org.mozilla.javascript.at, java.lang.Class<?>> r1 = r7.f6700d
            if (r1 != 0) goto L_0x0080
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r7.f6700d = r1
        L_0x0080:
            java.util.HashMap<org.mozilla.javascript.at, java.lang.Class<?>> r10 = r7.f6700d
            org.mozilla.javascript.cr r2 = m5777a(r6)
            org.mozilla.javascript.at r11 = new org.mozilla.javascript.at
            r11.<init>(r4, r3, r2)
            java.lang.Object r1 = r10.get(r11)
            java.lang.Class r1 = (java.lang.Class) r1
            if (r1 != 0) goto L_0x00f1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r12 = "adapter"
            r1.<init>(r12)
            int r12 = r7.mo19104a()
            java.lang.StringBuilder r1 = r1.append(r12)
            java.lang.String r12 = r1.toString()
            byte[] r3 = m5783a(r2, r12, r4, r3)
            org.mozilla.javascript.l r1 = org.mozilla.javascript.Context.m6769k()
            org.mozilla.javascript.dw r1 = r1.mo19145n()
            if (r1 != 0) goto L_0x012e
            r2 = r5
        L_0x00b5:
            java.lang.Class<java.security.CodeSource> r1 = java.security.CodeSource.class
            if (r2 == r1) goto L_0x00bd
            java.lang.Class<java.security.ProtectionDomain> r1 = java.security.ProtectionDomain.class
            if (r2 != r1) goto L_0x013b
        L_0x00bd:
            java.lang.SecurityManager r1 = java.lang.System.getSecurityManager()
            boolean r4 = r1 instanceof org.mozilla.javascript.RhinoSecurityManager
            if (r4 == 0) goto L_0x0134
            org.mozilla.javascript.eb r4 = new org.mozilla.javascript.eb
            r4.<init>(r1)
            java.lang.Object r1 = java.security.AccessController.doPrivileged(r4)
            java.security.ProtectionDomain r1 = (java.security.ProtectionDomain) r1
        L_0x00d0:
            if (r1 != 0) goto L_0x00d8
            java.lang.Class<org.mozilla.javascript.as> r1 = org.mozilla.javascript.JavaAdapter.class
            java.security.ProtectionDomain r1 = r1.getProtectionDomain()
        L_0x00d8:
            java.lang.Class<java.security.CodeSource> r4 = java.security.CodeSource.class
            if (r2 != r4) goto L_0x00df
            if (r1 != 0) goto L_0x0136
            r1 = r5
        L_0x00df:
            org.mozilla.javascript.ad r2 = org.mozilla.javascript.SecurityController.m6498b(r5, r1)
            java.lang.Class r1 = r2.mo18637a(r12, r3)
            r2.mo18638a(r1)
            boolean r2 = r7.f6698b
            if (r2 == 0) goto L_0x00f1
            r10.put(r11, r1)
        L_0x00f1:
            int r2 = r9 - r8
            int r2 = r2 + -1
            if (r2 <= 0) goto L_0x016b
            int r3 = r2 + 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0128 }
            r4 = 0
            r3[r4] = r6     // Catch:{ Exception -> 0x0128 }
            r4 = 1
            org.mozilla.javascript.o r5 = r13.f6778b     // Catch:{ Exception -> 0x0128 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0128 }
            int r4 = r8 + 1
            r5 = 2
            java.lang.System.arraycopy(r15, r4, r3, r5, r2)     // Catch:{ Exception -> 0x0128 }
            org.mozilla.javascript.bv r2 = new org.mozilla.javascript.bv     // Catch:{ Exception -> 0x0128 }
            r4 = 1
            r2.<init>(r14, r1, r4)     // Catch:{ Exception -> 0x0128 }
            org.mozilla.javascript.au r2 = r2.f6354h     // Catch:{ Exception -> 0x0128 }
            org.mozilla.javascript.bx r2 = r2.f6082a     // Catch:{ Exception -> 0x0128 }
            int r4 = r2.mo18884a(r13, r3)     // Catch:{ Exception -> 0x0128 }
            if (r4 >= 0) goto L_0x013d
            java.lang.String r2 = org.mozilla.javascript.NativeJavaMethod.m6080a(r15)     // Catch:{ Exception -> 0x0128 }
            java.lang.String r3 = "msg.no.java.ctor"
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x0128 }
            org.mozilla.javascript.z r1 = org.mozilla.javascript.Context.m6756a(r3, r1, r2)     // Catch:{ Exception -> 0x0128 }
            throw r1     // Catch:{ Exception -> 0x0128 }
        L_0x0128:
            r1 = move-exception
            java.lang.RuntimeException r1 = org.mozilla.javascript.Context.m6746a(r1)
            throw r1
        L_0x012e:
            java.lang.Class r1 = r1.mo18990a()
            r2 = r1
            goto L_0x00b5
        L_0x0134:
            r1 = r5
            goto L_0x00d0
        L_0x0136:
            java.security.CodeSource r1 = r1.getCodeSource()
            goto L_0x00df
        L_0x013b:
            r1 = r5
            goto L_0x00df
        L_0x013d:
            org.mozilla.javascript.bb[] r2 = r2.f6345c     // Catch:{ Exception -> 0x0128 }
            r2 = r2[r4]     // Catch:{ Exception -> 0x0128 }
            java.lang.Object r2 = org.mozilla.javascript.NativeJavaClass.m6075a(r3, r2)     // Catch:{ Exception -> 0x0128 }
        L_0x0145:
            java.lang.String r3 = "self"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r3)     // Catch:{ Exception -> 0x0128 }
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Exception -> 0x0128 }
            boolean r1 = r2 instanceof org.mozilla.javascript.Wrapper     // Catch:{ Exception -> 0x0128 }
            if (r1 == 0) goto L_0x018c
            r0 = r2
            org.mozilla.javascript.eo r0 = (org.mozilla.javascript.Wrapper) r0     // Catch:{ Exception -> 0x0128 }
            r1 = r0
            java.lang.Object r3 = r1.mo18879a()     // Catch:{ Exception -> 0x0128 }
            boolean r1 = r3 instanceof org.mozilla.javascript.Scriptable     // Catch:{ Exception -> 0x0128 }
            if (r1 == 0) goto L_0x018c
            boolean r1 = r3 instanceof org.mozilla.javascript.ScriptableObject     // Catch:{ Exception -> 0x0128 }
            if (r1 == 0) goto L_0x016a
            r0 = r3
            org.mozilla.javascript.ds r0 = (org.mozilla.javascript.ScriptableObject) r0     // Catch:{ Exception -> 0x0128 }
            r1 = r0
            org.mozilla.javascript.ScriptRuntime.m6383a(r1, r14)     // Catch:{ Exception -> 0x0128 }
        L_0x016a:
            return r3
        L_0x016b:
            r2 = 2
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0128 }
            r3 = 0
            java.lang.Class<org.mozilla.javascript.dr> r4 = org.mozilla.javascript.ScriptRuntime.f6511r     // Catch:{ Exception -> 0x0128 }
            r2[r3] = r4     // Catch:{ Exception -> 0x0128 }
            r3 = 1
            java.lang.Class<?> r4 = org.mozilla.javascript.ScriptRuntime.f6508o     // Catch:{ Exception -> 0x0128 }
            r2[r3] = r4     // Catch:{ Exception -> 0x0128 }
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0128 }
            r4 = 0
            r3[r4] = r6     // Catch:{ Exception -> 0x0128 }
            r4 = 1
            org.mozilla.javascript.o r5 = r13.f6778b     // Catch:{ Exception -> 0x0128 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0128 }
            java.lang.reflect.Constructor r2 = r1.getConstructor(r2)     // Catch:{ Exception -> 0x0128 }
            java.lang.Object r2 = r2.newInstance(r3)     // Catch:{ Exception -> 0x0128 }
            goto L_0x0145
        L_0x018c:
            r3 = r2
            goto L_0x016a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.JavaAdapter.m5774a(org.mozilla.javascript.l, org.mozilla.javascript.dr, java.lang.Object[]):java.lang.Object");
    }

    /* renamed from: a */
    private static ObjToIntMap m5777a(Scriptable drVar) {
        Object[] propertyIds = ScriptableObject.getPropertyIds(drVar);
        ObjToIntMap crVar = new ObjToIntMap(propertyIds.length);
        for (int i = 0; i != propertyIds.length; i++) {
            if (propertyIds[i] instanceof String) {
                String str = (String) propertyIds[i];
                Object property = ScriptableObject.getProperty(drVar, str);
                if (property instanceof Function) {
                    int f = ScriptRuntime.m6446f(ScriptableObject.getProperty((Scriptable) (Function) property, "length"));
                    if (f < 0) {
                        f = 0;
                    }
                    crVar.mo18968b(str, f);
                }
            }
        }
        return crVar;
    }

    /* renamed from: a */
    private static byte[] m5783a(ObjToIntMap crVar, String str, Class<?> cls, Class<?>[] clsArr) {
//        C2126c cVar = new C2126c(str, cls.getName(), "<adapter>");
//        cVar.mo18573a("factory", "Lorg/mozilla/javascript/ContextFactory;", 17);
//        cVar.mo18573a("delegee", "Lorg/mozilla/javascript/Scriptable;", 17);
//        cVar.mo18573a("self", "Lorg/mozilla/javascript/Scriptable;", 17);
//        for (int i = 0; i < r9; i++) {
//            if (clsArr[i] != null) {
//                cVar.mo18571a(clsArr[i].getName());
//            }
//        }
//        String replace = cls.getName().replace(CoreConstants.DOT, '/');
//        for (Constructor parameterTypes : cls.getConstructors()) {
//            short s = 3;
//            Class[] parameterTypes2 = parameterTypes.getParameterTypes();
//            if (parameterTypes2.length == 0) {
//                cVar.mo18581b("<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;)V", 1);
//                cVar.mo18564a(42);
//                cVar.mo18580b(183, replace, "<init>", "()V");
//            } else {
//                StringBuilder sb = new StringBuilder("(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;");
//                int length = sb.length();
//                for (Class a : parameterTypes2) {
//                    m5776a(sb, a);
//                }
//                sb.append(")V");
//                cVar.mo18581b("<init>", sb.toString(), 1);
//                cVar.mo18564a(42);
//                s = 3;
//                int i2 = 0;
//                while (i2 < parameterTypes2.length) {
//                    short a2 = (short) (s + m5772a(cVar, (int) s, parameterTypes2[i2]));
//                    i2++;
//                    s = a2;
//                }
//                sb.delete(1, length);
//                cVar.mo18580b(183, replace, "<init>", sb.toString());
//            }
//            cVar.mo18564a(42);
//            cVar.mo18564a(43);
//            cVar.mo18569a(181, str, "delegee", "Lorg/mozilla/javascript/Scriptable;");
//            cVar.mo18564a(42);
//            cVar.mo18564a(44);
//            cVar.mo18569a(181, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
//            cVar.mo18564a(42);
//            cVar.mo18564a(43);
//            cVar.mo18564a(42);
//            cVar.mo18580b(184, "org/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
//            cVar.mo18569a(181, str, "self", "Lorg/mozilla/javascript/Scriptable;");
//            cVar.mo18564a(177);
//            cVar.mo18574a(s);
//        }
//        cVar.mo18581b("<init>", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;)V", 1);
//        cVar.mo18564a(42);
//        cVar.mo18580b(183, replace, "<init>", "()V");
//        cVar.mo18564a(42);
//        cVar.mo18564a(43);
//        cVar.mo18569a(181, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
//        cVar.mo18564a(42);
//        cVar.mo18564a(44);
//        cVar.mo18569a(181, str, "delegee", "Lorg/mozilla/javascript/Scriptable;");
//        cVar.mo18564a(42);
//        cVar.mo18564a(45);
//        cVar.mo18569a(181, str, "self", "Lorg/mozilla/javascript/Scriptable;");
//        cVar.mo18564a(177);
//        cVar.mo18574a(4);
        ObjToIntMap crVar2 = new ObjToIntMap();
        ObjToIntMap crVar3 = new ObjToIntMap();
        for (Class<?> methods : clsArr) {
            Method[] methods2 = methods.getMethods();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= methods2.length) {
                    break;
                }
                Method method = methods2[i4];
                int modifiers = method.getModifiers();
                if (!Modifier.isStatic(modifiers) && !Modifier.isFinal(modifiers)) {
                    String name = method.getName();
                    Class[] parameterTypes3 = method.getParameterTypes();
                    if (!crVar.mo18966a(name)) {
                        try {
                            cls.getMethod(name, parameterTypes3);
                        } catch (NoSuchMethodException e) {
                        }
                    }
                    String str2 = name + m5775a(method, (Class<?>[]) parameterTypes3);
                    if (!crVar2.mo18966a(str2)) {
//                        m5781a(cVar, str, name, (Class<?>[]) parameterTypes3, method.getReturnType(), true);
                        crVar2.mo18968b(str2, 0);
                        crVar3.mo18968b(name, 0);
                    }
                }
                i3 = i4 + 1;
            }
        }
        Method[] a3 = m5784a(cls);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= a3.length) {
                break;
            }
            Method method2 = a3[i6];
            boolean isAbstract = Modifier.isAbstract(method2.getModifiers());
            String name2 = method2.getName();
            if (isAbstract || crVar.mo18966a(name2)) {
                Class[] parameterTypes4 = method2.getParameterTypes();
                String a4 = m5775a(method2, (Class<?>[]) parameterTypes4);
                String str3 = name2 + a4;
                if (!crVar2.mo18966a(str3)) {
//                    m5781a(cVar, str, name2, (Class<?>[]) parameterTypes4, method2.getReturnType(), true);
                    crVar2.mo18968b(str3, 0);
                    crVar3.mo18968b(name2, 0);
                    if (!isAbstract) {
//                        m5780a(cVar, replace, name2, a4, (Class<?>[]) parameterTypes4, method2.getReturnType());
                    }
                }
            }
            i5 = i6 + 1;
        }
        C2163cs csVar = new C2163cs(crVar);
        csVar.mo18970a();
        while (!csVar.mo18971b()) {
            String str4 = (String) csVar.mo18973d();
            if (!crVar3.mo18966a(str4)) {
                int e2 = csVar.mo18974e();
                Class[] clsArr2 = new Class[e2];
                for (int i7 = 0; i7 < e2; i7++) {
                    clsArr2[i7] = ScriptRuntime.f6503j;
                }
//                m5781a(cVar, str, str4, (Class<?>[]) clsArr2, ScriptRuntime.f6503j, false);
            }
            csVar.mo18972c();
        }
//        return cVar.mo18585c();

        return null;
    }

    /* renamed from: a */
    private static Method[] m5784a(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            m5778a(cls2, arrayList, hashSet);
        }
        while (cls != null) {
            for (Class a : cls.getInterfaces()) {
                m5778a(a, arrayList, hashSet);
            }
            cls = cls.getSuperclass();
        }
        return (Method[]) arrayList.toArray(new Method[arrayList.size()]);
    }

    /* renamed from: a */
    private static void m5778a(Class<?> cls, ArrayList<Method> arrayList, HashSet<String> hashSet) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            String str = declaredMethods[i].getName() + m5775a(declaredMethods[i], (Class<?>[]) declaredMethods[i].getParameterTypes());
            if (!hashSet.contains(str)) {
                int modifiers = declaredMethods[i].getModifiers();
                if (!Modifier.isStatic(modifiers)) {
                    if (Modifier.isFinal(modifiers)) {
                        hashSet.add(str);
                    } else if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                        arrayList.add(declaredMethods[i]);
                        hashSet.add(str);
                    }
                }
            }
        }
    }

    /* renamed from: a */
//    private static void m5782a(C2126c cVar, Class<?>[] clsArr, int i) {
//        int i2;
//        cVar.mo18583c(i);
//        cVar.mo18568a(189, "java/lang/Object");
//        int i3 = 1;
//        for (int i4 = 0; i4 != clsArr.length; i4++) {
//            cVar.mo18564a(89);
//            cVar.mo18583c(i4);
//            Class<?> cls = clsArr[i4];
//            if (!cls.isPrimitive()) {
//                cVar.mo18565a(25, i3);
//                i2 = 1;
//            } else if (cls == Boolean.TYPE) {
//                cVar.mo18568a(187, "java/lang/Boolean");
//                cVar.mo18564a(89);
//                cVar.mo18565a(21, i3);
//                cVar.mo18580b(183, "java/lang/Boolean", "<init>", "(Z)V");
//                i2 = 1;
//            } else if (cls == Character.TYPE) {
//                cVar.mo18565a(21, i3);
//                cVar.mo18580b(184, "java/lang/String", CoreConstants.VALUE_OF, "(C)Ljava/lang/String;");
//                i2 = 1;
//            } else {
//                cVar.mo18568a(187, "java/lang/Double");
//                cVar.mo18564a(89);
//                switch (cls.getName().charAt(0)) {
//                    case 'b':
//                    case 'i':
//                    case 's':
//                        cVar.mo18565a(21, i3);
//                        cVar.mo18564a(135);
//                        i2 = 1;
//                        break;
//                    case 'd':
//                        cVar.mo18565a(24, i3);
//                        i2 = 2;
//                        break;
//                    case 'f':
//                        cVar.mo18565a(23, i3);
//                        cVar.mo18564a(141);
//                        i2 = 1;
//                        break;
//                    case 'l':
//                        cVar.mo18565a(22, i3);
//                        cVar.mo18564a(138);
//                        i2 = 2;
//                        break;
//                    default:
//                        i2 = 1;
//                        break;
//                }
//                cVar.mo18580b(183, "java/lang/Double", "<init>", "(D)V");
//            }
//            i3 += i2;
//            cVar.mo18564a(83);
//        }
//    }

    /* renamed from: a */
//    private static void m5779a(C2126c cVar, Class<?> cls, boolean z) {
//        if (cls == Void.TYPE) {
//            cVar.mo18564a(87);
//            cVar.mo18564a(177);
//        } else if (cls == Boolean.TYPE) {
//            cVar.mo18580b(184, "org/mozilla/javascript/Context", "toBoolean", "(Ljava/lang/Object;)Z");
//            cVar.mo18564a(172);
//        } else if (cls == Character.TYPE) {
//            cVar.mo18580b(184, "org/mozilla/javascript/Context", "toString", "(Ljava/lang/Object;)Ljava/lang/String;");
//            cVar.mo18564a(3);
//            cVar.mo18580b(182, "java/lang/String", "charAt", "(I)C");
//            cVar.mo18564a(172);
//        } else if (cls.isPrimitive()) {
//            cVar.mo18580b(184, "org/mozilla/javascript/Context", "toNumber", "(Ljava/lang/Object;)D");
//            switch (cls.getName().charAt(0)) {
//                case 'b':
//                case 'i':
//                case 's':
//                    cVar.mo18564a(142);
//                    cVar.mo18564a(172);
//                    return;
//                case 'd':
//                    cVar.mo18564a(175);
//                    return;
//                case 'f':
//                    cVar.mo18564a(144);
//                    cVar.mo18564a(174);
//                    return;
//                case 'l':
//                    cVar.mo18564a(143);
//                    cVar.mo18564a(173);
//                    return;
//                default:
//                    throw new RuntimeException("Unexpected return type " + cls.toString());
//            }
//        } else {
//            String name = cls.getName();
//            if (z) {
//                cVar.mo18587d(name);
//                cVar.mo18580b(184, "java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
//                cVar.mo18580b(184, "org/mozilla/javascript/JavaAdapter", "convertResult", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
//            }
//            cVar.mo18568a(192, name);
//            cVar.mo18564a(176);
//        }
//    }

    /* renamed from: a */
//    private static void m5781a(C2126c cVar, String str, String str2, Class<?>[] clsArr, Class<?> cls, boolean z) {
//        StringBuilder sb = new StringBuilder();
//        int a = m5773a(clsArr, cls, sb);
//        cVar.mo18581b(str2, sb.toString(), 1);
//        cVar.mo18564a(42);
//        cVar.mo18569a(180, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
//        cVar.mo18564a(42);
//        cVar.mo18569a(180, str, "self", "Lorg/mozilla/javascript/Scriptable;");
//        cVar.mo18564a(42);
//        cVar.mo18569a(180, str, "delegee", "Lorg/mozilla/javascript/Scriptable;");
//        cVar.mo18589e(str2);
//        cVar.mo18580b(184, "org/mozilla/javascript/JavaAdapter", "getFunction", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Lorg/mozilla/javascript/Function;");
//        m5782a(cVar, clsArr, clsArr.length);
//        if (clsArr.length > 64) {
//            throw Context.m6763b("JavaAdapter can not subclass methods with more then 64 arguments.");
//        }
//        long j = 0;
//        for (int i = 0; i != clsArr.length; i++) {
//            if (!clsArr[i].isPrimitive()) {
//                j |= (long) (1 << i);
//            }
//        }
//        int i2 = (int) j;
//        if (((long) i2) == j) {
//            cVar.mo18583c(i2);
//            cVar.mo18564a(133);
//        } else {
//            C2129f fVar = cVar.f5918c;
//            fVar.mo18605b(9);
//            byte[] bArr = fVar.f5957g;
//            int i3 = fVar.f5954d;
//            fVar.f5954d = i3 + 1;
//            bArr[i3] = 5;
//            fVar.f5954d = C2126c.m5535a(j, fVar.f5957g, fVar.f5954d);
//            int i4 = fVar.f5955e;
//            fVar.f5955e += 2;
//            fVar.f5956f.mo19093b(i4, 5);
//            cVar.mo18565a(20, i4);
//        }
//        cVar.mo18580b(184, "org/mozilla/javascript/JavaAdapter", "callMethod", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Function;[Ljava/lang/Object;J)Ljava/lang/Object;");
//        m5779a(cVar, cls, z);
//        cVar.mo18574a((short) a);
//    }

    /* renamed from: a */
//    private static int m5772a(C2126c cVar, int i, Class<?> cls) {
//        if (!cls.isPrimitive()) {
//            cVar.mo18593i(i);
//            return 1;
//        }
//        switch (cls.getName().charAt(0)) {
//            case 'b':
//            case 'c':
//            case 'i':
//            case 's':
//            case 'z':
//                cVar.mo18591g(i);
//                return 1;
//            case 'd':
//                cVar.mo18592h(i);
//                return 2;
//            case 'f':
//                cVar.mo18566a(34, 23, i);
//                return 1;
//            case 'l':
//                cVar.mo18566a(30, 22, i);
//                return 2;
//            default:
//                throw Kit.m5810a();
//        }
//    }

    /* renamed from: a */
//    private static void m5780a(C2126c cVar, String str, String str2, String str3, Class<?>[] clsArr, Class<?> cls) {
//        cVar.mo18581b("super$" + str2, str3, 1);
//        cVar.mo18565a(25, 0);
//        int i = 1;
//        for (Class<?> a : clsArr) {
//            i += m5772a(cVar, i, a);
//        }
//        cVar.mo18580b(183, str, str2, str3);
//        if (cls.equals(Void.TYPE)) {
//            cVar.mo18564a(177);
//        } else if (cls.isPrimitive()) {
//            switch (cls.getName().charAt(0)) {
//                case 'b':
//                case 'c':
//                case 'i':
//                case 's':
//                case 'z':
//                    cVar.mo18564a(172);
//                    break;
//                case 'd':
//                    cVar.mo18564a(175);
//                    break;
//                case 'f':
//                    cVar.mo18564a(174);
//                    break;
//                case 'l':
//                    cVar.mo18564a(173);
//                    break;
//            }
//        } else {
//            cVar.mo18564a(176);
//        }
//        cVar.mo18574a((short) (i + 1));
//    }

    /* renamed from: a */
    private static String m5775a(Method method, Class<?>[] clsArr) {
        StringBuilder sb = new StringBuilder();
        m5773a(clsArr, method.getReturnType(), sb);
        return sb.toString();
    }

    /* renamed from: a */
    private static int m5773a(Class<?>[] clsArr, Class<?> cls, StringBuilder sb) {
        sb.append(CoreConstants.LEFT_PARENTHESIS_CHAR);
        int length = clsArr.length + 1;
        int i = length;
        for (Class<?> cls2 : clsArr) {
            m5776a(sb, cls2);
            if (cls2 == Long.TYPE || cls2 == Double.TYPE) {
                i++;
            }
        }
        sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        m5776a(sb, cls);
        return i;
    }

    /* renamed from: a */
    private static StringBuilder m5776a(StringBuilder sb, Class<?> cls) {
        char upperCase;
        while (cls.isArray()) {
            sb.append('[');
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            if (cls == Boolean.TYPE) {
                upperCase = 'Z';
            } else if (cls == Long.TYPE) {
                upperCase = 'J';
            } else {
                upperCase = Character.toUpperCase(cls.getName().charAt(0));
            }
            sb.append(upperCase);
        } else {
            sb.append('L');
            sb.append(cls.getName().replace(CoreConstants.DOT, '/'));
            sb.append(';');
        }
        return sb;
    }
}
