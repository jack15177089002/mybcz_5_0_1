package org.mozilla.javascript;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.au */
/* compiled from: JavaMembers */
final class C2140au {

    /* renamed from: a */
    NativeJavaMethod f6082a;

    /* renamed from: b */
    private Class<?> f6083b;

    /* renamed from: c */
    private Map<String, Object> f6084c;

    /* renamed from: d */
    private Map<String, JavaMembers> f6085d;

    /* renamed from: e */
    private Map<String, Object> f6086e;

    /* renamed from: f */
    private Map<String, JavaMembers> f6087f;

    private C2140au(Scriptable drVar, Class<?> cls, boolean z) {
        try {
            Context a = Context.m6754a(ContextFactory.m6787a());
            ClassShutter f = a.mo19141f();
            if (f != null) {
                cls.getName();
                if (!f.mo19111a()) {
                    throw Context.m6755a("msg.access.prohibited", (Object) cls.getName());
                }
            }
            this.f6084c = new HashMap();
            this.f6086e = new HashMap();
            this.f6083b = cls;
            m5792a(drVar, z, a.mo19138b(13));
        } finally {
            Context.m6766c();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo18699a(String str, boolean z) {
        if ((z ? this.f6086e : this.f6084c).get(str) != null) {
            return true;
        }
        return m5794b(str, z) != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Object mo18695a(Scriptable drVar, String str, Object obj, boolean z) {
        Object obj2;
        Class type;
        Object obj3;
        Object obj4 = (z ? this.f6086e : this.f6084c).get(str);
        if (!z && obj4 == 0) {
            obj4 = this.f6086e.get(str);
        }
        if (obj4 == 0) {
            Map<String, Object> map = z ? this.f6086e : this.f6084c;
            MemberBox b = m5794b(str, z);
            if (b != null) {
                Scriptable functionPrototype = ScriptableObject.getFunctionPrototype(drVar);
                if (b.f6278a instanceof Constructor) {
                    NativeJavaConstructor bwVar = new NativeJavaConstructor(b);
                    bwVar.setPrototype(functionPrototype);
                    map.put(str, bwVar);
                    obj3 = bwVar;
                } else {
                    Object obj5 = map.get(b.mo18835b());
                    if (!(obj5 instanceof NativeJavaMethod) || ((NativeJavaMethod) obj5).f6345c.length <= 1) {
                        obj3 = obj5;
                    } else {
                        NativeJavaMethod bxVar = new NativeJavaMethod(b, str);
                        bxVar.setPrototype(functionPrototype);
                        map.put(str, bxVar);
                        obj3 = bxVar;
                    }
                }
            } else {
                obj3 = 0;
            }
            if (obj4 == 0) {
                return Scriptable.f6533j;
            }
        }
        if (obj4 instanceof Scriptable) {
            return obj4;
        }
        Context k = Context.m6769k();
        try {
            if (obj4 instanceof C2153c) {
                C2153c cVar = (C2153c) obj4;
                if (cVar.f6357a == null) {
                    return Scriptable.f6533j;
                }
                obj2 = cVar.f6357a.mo18832a(obj, Context.f6767a);
                type = ((Method) cVar.f6357a.f6278a).getReturnType();
            } else {
                Field field = (Field) obj4;
                if (z) {
                    obj = null;
                }
                obj2 = field.get(obj);
                type = field.getType();
            }
            return k.mo19142g().mo19103a(ScriptableObject.getTopLevelScope(drVar), obj2, type);
        } catch (Exception e) {
            throw Context.m6746a((Throwable) e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18698a(Scriptable drVar, String str, Object obj, Object obj2, boolean z) {
        Object obj3;
        Map<String, Object> map = z ? this.f6086e : this.f6084c;
        Object obj4 = map.get(str);
        if (!z && obj4 == null) {
            obj4 = this.f6086e.get(str);
        }
        if (obj4 == null) {
            throw mo18696a(str);
        }
        if (obj4 instanceof JavaMembers) {
            obj3 = ((JavaMembers) map.get(str)).f5983a;
        } else {
            obj3 = obj4;
        }
        if (obj3 instanceof C2153c) {
            C2153c cVar = (C2153c) obj3;
            if (cVar.f6358b == null) {
                throw mo18696a(str);
            } else if (cVar.f6359c == null || obj2 == null) {
                try {
                    cVar.f6358b.mo18832a(obj, new Object[]{Context.m6742a(obj2, cVar.f6358b.f6279b[0])});
                } catch (Exception e) {
                    throw Context.m6746a((Throwable) e);
                }
            } else {
                cVar.f6359c.call(Context.m6769k(), ScriptableObject.getTopLevelScope(drVar), drVar, new Object[]{obj2});
            }
        } else if (!(obj3 instanceof Field)) {
            throw Context.m6755a(obj3 == null ? "msg.java.internal.private" : "msg.java.method.assign", (Object) str);
        } else {
            Field field = (Field) obj3;
            try {
                field.set(obj, Context.m6742a(obj2, field.getType()));
            } catch (IllegalAccessException e2) {
                if ((field.getModifiers() & 16) == 0) {
                    throw Context.m6746a((Throwable) e2);
                }
            } catch (IllegalArgumentException e3) {
                throw Context.m6757a("msg.java.internal.field.type", (Object) obj2.getClass().getName(), (Object) field, (Object) obj.getClass().getName());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Object[] mo18700a(boolean z) {
        Map<String, Object> map = z ? this.f6086e : this.f6084c;
        return map.keySet().toArray(new Object[map.size()]);
    }

    /* renamed from: a */
    static String m5785a(Class<?> cls) {
        if (!cls.isArray()) {
            return cls.getName();
        }
        int i = 0;
        do {
            i++;
            cls = cls.getComponentType();
        } while (cls.isArray());
        String name = cls.getName();
        String str = "[]";
        if (i == 1) {
            return name.concat(str);
        }
        StringBuilder sb = new StringBuilder(name.length() + (str.length() * i));
        sb.append(name);
        while (i != 0) {
            i--;
            sb.append(str);
        }
        return sb.toString();
    }

    /* renamed from: a */
    static String m5786a(Class<?>[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return "()";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(CoreConstants.LEFT_PARENTHESIS_CHAR);
        for (int i = 0; i != length; i++) {
            if (i != 0) {
                sb.append(CoreConstants.COMMA_CHAR);
            }
            sb.append(m5785a(clsArr[i]));
        }
        sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        return sb.toString();
    }

    /* renamed from: b */
    private MemberBox m5794b(String str, boolean z) {
        boolean z2;
        MemberBox[] bbVarArr;
        int indexOf = str.indexOf(40);
        if (indexOf < 0) {
            return null;
        }
        Map<String, Object> map = z ? this.f6086e : this.f6084c;
        if (!z || indexOf != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            bbVarArr = this.f6082a.f6345c;
        } else {
            String substring = str.substring(0, indexOf);
            Object obj = map.get(substring);
            if (!z && obj == null) {
                obj = this.f6086e.get(substring);
            }
            if (obj instanceof NativeJavaMethod) {
                bbVarArr = ((NativeJavaMethod) obj).f6345c;
            } else {
                bbVarArr = null;
            }
        }
        if (bbVarArr != null) {
            for (MemberBox bbVar : bbVarArr) {
                String a = m5786a(bbVar.f6279b);
                if (a.length() + indexOf == str.length() && str.regionMatches(indexOf, a, 0, a.length())) {
                    return bbVar;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m5791a(Class<?> cls, Map<C2141av, Method> map, boolean z, boolean z2) {
        Method[] methods;
        Method[] declaredMethods;
        Method[] methods2;
        do {
            if (Modifier.isPublic(cls.getModifiers()) || z2) {
                if (z || z2) {
                    while (cls != null) {
                        try {
                            for (Method method : cls.getDeclaredMethods()) {
                                int modifiers = method.getModifiers();
                                if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers) || z2) {
                                    C2141av avVar = new C2141av(method);
                                    if (!map.containsKey(avVar)) {
                                        if (z2 && !method.isAccessible()) {
                                            method.setAccessible(true);
                                        }
                                        map.put(avVar, method);
                                    }
                                }
                            }
                            cls = cls.getSuperclass();
                        } catch (SecurityException e) {
                            try {
                                for (Method method2 : cls.getMethods()) {
                                    C2141av avVar2 = new C2141av(method2);
                                    if (!map.containsKey(avVar2)) {
                                        map.put(avVar2, method2);
                                    }
                                }
                                return;
                            } catch (SecurityException e2) {
                                Context.m6760a("Could not discover accessible methods of class " + cls.getName() + " due to lack of privileges, attemping superclasses/interfaces.");
                            }
                        }
                    }
                    return;
                }
                for (Method method3 : cls.getMethods()) {
                    C2141av avVar3 = new C2141av(method3);
                    if (!map.containsKey(avVar3)) {
                        map.put(avVar3, method3);
                    }
                }
                return;
            }
            for (Class a : cls.getInterfaces()) {
                m5791a(a, map, z, z2);
            }
            cls = cls.getSuperclass();
        } while (cls != null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x018c A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5792a(org.mozilla.javascript.Scriptable r13, boolean r14, boolean r15) {
        /*
            r12 = this;
            java.lang.Class<?> r0 = r12.f6083b
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            m5791a(r0, r1, r14, r15)
            java.util.Collection r0 = r1.values()
            int r1 = r1.size()
            java.lang.reflect.Method[] r1 = new java.lang.reflect.Method[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            java.lang.reflect.Method[] r0 = (java.lang.reflect.Method[]) r0
            int r5 = r0.length
            r1 = 0
            r4 = r1
        L_0x001d:
            if (r4 >= r5) goto L_0x0061
            r6 = r0[r4]
            int r1 = r6.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
            if (r1 == 0) goto L_0x003f
            java.util.Map<java.lang.String, java.lang.Object> r1 = r12.f6086e
            r2 = r1
        L_0x002e:
            java.lang.String r7 = r6.getName()
            java.lang.Object r1 = r2.get(r7)
            if (r1 != 0) goto L_0x0043
            r2.put(r7, r6)
        L_0x003b:
            int r1 = r4 + 1
            r4 = r1
            goto L_0x001d
        L_0x003f:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r12.f6084c
            r2 = r1
            goto L_0x002e
        L_0x0043:
            boolean r3 = r1 instanceof org.mozilla.javascript.ObjArray
            if (r3 == 0) goto L_0x004d
            org.mozilla.javascript.cq r1 = (org.mozilla.javascript.ObjArray) r1
        L_0x0049:
            r1.mo18961a(r6)
            goto L_0x003b
        L_0x004d:
            boolean r3 = r1 instanceof java.lang.reflect.Method
            if (r3 != 0) goto L_0x0054
            org.mozilla.javascript.Kit.m5810a()
        L_0x0054:
            org.mozilla.javascript.cq r3 = new org.mozilla.javascript.cq
            r3.<init>()
            r3.mo18961a(r1)
            r2.put(r7, r3)
            r1 = r3
            goto L_0x0049
        L_0x0061:
            r0 = 0
            r5 = r0
        L_0x0063:
            r0 = 2
            if (r5 == r0) goto L_0x00d5
            if (r5 != 0) goto L_0x00aa
            r0 = 1
        L_0x0069:
            if (r0 == 0) goto L_0x00ac
            java.util.Map<java.lang.String, java.lang.Object> r0 = r12.f6086e
            r4 = r0
        L_0x006e:
            java.util.Set r0 = r4.entrySet()
            java.util.Iterator r7 = r0.iterator()
        L_0x0076:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x00d1
            java.lang.Object r0 = r7.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getValue()
            boolean r2 = r1 instanceof java.lang.reflect.Method
            if (r2 == 0) goto L_0x00b0
            r2 = 1
            org.mozilla.javascript.bb[] r2 = new org.mozilla.javascript.MemberBox[r2]
            r3 = 0
            org.mozilla.javascript.bb r6 = new org.mozilla.javascript.bb
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1
            r6.<init>(r1)
            r2[r3] = r6
            r1 = r2
        L_0x0098:
            org.mozilla.javascript.bx r2 = new org.mozilla.javascript.bx
            r2.<init>(r1)
            if (r13 == 0) goto L_0x00a2
            org.mozilla.javascript.ScriptRuntime.m6379a(r2, r13)
        L_0x00a2:
            java.lang.Object r0 = r0.getKey()
            r4.put(r0, r2)
            goto L_0x0076
        L_0x00aa:
            r0 = 0
            goto L_0x0069
        L_0x00ac:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r12.f6084c
            r4 = r0
            goto L_0x006e
        L_0x00b0:
            org.mozilla.javascript.cq r1 = (org.mozilla.javascript.ObjArray) r1
            int r8 = r1.f6407a
            r2 = 2
            if (r8 >= r2) goto L_0x00ba
            org.mozilla.javascript.Kit.m5810a()
        L_0x00ba:
            org.mozilla.javascript.bb[] r3 = new org.mozilla.javascript.MemberBox[r8]
            r2 = 0
            r6 = r2
        L_0x00be:
            if (r6 == r8) goto L_0x02c7
            java.lang.Object r2 = r1.mo18960a(r6)
            java.lang.reflect.Method r2 = (java.lang.reflect.Method) r2
            org.mozilla.javascript.bb r9 = new org.mozilla.javascript.bb
            r9.<init>(r2)
            r3[r6] = r9
            int r2 = r6 + 1
            r6 = r2
            goto L_0x00be
        L_0x00d1:
            int r0 = r5 + 1
            r5 = r0
            goto L_0x0063
        L_0x00d5:
            java.lang.reflect.Field[] r3 = r12.m5793a(r14, r15)
            int r4 = r3.length
            r0 = 0
            r2 = r0
        L_0x00dc:
            if (r2 >= r4) goto L_0x0171
            r5 = r3[r2]
            java.lang.String r6 = r5.getName()
            int r0 = r5.getModifiers()
            boolean r7 = java.lang.reflect.Modifier.isStatic(r0)     // Catch:{ SecurityException -> 0x0125 }
            if (r7 == 0) goto L_0x00fe
            java.util.Map<java.lang.String, java.lang.Object> r0 = r12.f6086e     // Catch:{ SecurityException -> 0x0125 }
            r1 = r0
        L_0x00f1:
            java.lang.Object r0 = r1.get(r6)     // Catch:{ SecurityException -> 0x0125 }
            if (r0 != 0) goto L_0x0102
            r1.put(r6, r5)     // Catch:{ SecurityException -> 0x0125 }
        L_0x00fa:
            int r0 = r2 + 1
            r2 = r0
            goto L_0x00dc
        L_0x00fe:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r12.f6084c     // Catch:{ SecurityException -> 0x0125 }
            r1 = r0
            goto L_0x00f1
        L_0x0102:
            boolean r8 = r0 instanceof org.mozilla.javascript.NativeJavaMethod     // Catch:{ SecurityException -> 0x0125 }
            if (r8 == 0) goto L_0x0155
            org.mozilla.javascript.bx r0 = (org.mozilla.javascript.NativeJavaMethod) r0     // Catch:{ SecurityException -> 0x0125 }
            org.mozilla.javascript.aa r8 = new org.mozilla.javascript.aa     // Catch:{ SecurityException -> 0x0125 }
            org.mozilla.javascript.bb[] r0 = r0.f6345c     // Catch:{ SecurityException -> 0x0125 }
            r8.<init>(r13, r0, r5)     // Catch:{ SecurityException -> 0x0125 }
            if (r7 == 0) goto L_0x014f
            java.util.Map<java.lang.String, org.mozilla.javascript.aa> r0 = r12.f6087f     // Catch:{ SecurityException -> 0x0125 }
        L_0x0113:
            if (r0 != 0) goto L_0x011e
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ SecurityException -> 0x0125 }
            r0.<init>()     // Catch:{ SecurityException -> 0x0125 }
            if (r7 == 0) goto L_0x0152
            r12.f6087f = r0     // Catch:{ SecurityException -> 0x0125 }
        L_0x011e:
            r0.put(r6, r8)     // Catch:{ SecurityException -> 0x0125 }
            r1.put(r6, r8)     // Catch:{ SecurityException -> 0x0125 }
            goto L_0x00fa
        L_0x0125:
            r0 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Could not access field "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.String r1 = " of class "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.Class<?> r1 = r12.f6083b
            java.lang.String r1 = r1.getName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = " due to lack of privileges."
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            org.mozilla.javascript.Context.m6760a(r0)
            goto L_0x00fa
        L_0x014f:
            java.util.Map<java.lang.String, org.mozilla.javascript.aa> r0 = r12.f6085d     // Catch:{ SecurityException -> 0x0125 }
            goto L_0x0113
        L_0x0152:
            r12.f6085d = r0     // Catch:{ SecurityException -> 0x0125 }
            goto L_0x011e
        L_0x0155:
            boolean r7 = r0 instanceof java.lang.reflect.Field     // Catch:{ SecurityException -> 0x0125 }
            if (r7 == 0) goto L_0x016d
            java.lang.reflect.Field r0 = (java.lang.reflect.Field) r0     // Catch:{ SecurityException -> 0x0125 }
            java.lang.Class r0 = r0.getDeclaringClass()     // Catch:{ SecurityException -> 0x0125 }
            java.lang.Class r7 = r5.getDeclaringClass()     // Catch:{ SecurityException -> 0x0125 }
            boolean r0 = r0.isAssignableFrom(r7)     // Catch:{ SecurityException -> 0x0125 }
            if (r0 == 0) goto L_0x00fa
            r1.put(r6, r5)     // Catch:{ SecurityException -> 0x0125 }
            goto L_0x00fa
        L_0x016d:
            org.mozilla.javascript.Kit.m5810a()     // Catch:{ SecurityException -> 0x0125 }
            goto L_0x00fa
        L_0x0171:
            r0 = 0
            r8 = r0
        L_0x0173:
            r0 = 2
            if (r8 == r0) goto L_0x0295
            if (r8 != 0) goto L_0x0239
            r0 = 1
            r7 = r0
        L_0x017a:
            if (r7 == 0) goto L_0x023d
            java.util.Map<java.lang.String, java.lang.Object> r0 = r12.f6086e
            r6 = r0
        L_0x017f:
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.util.Set r0 = r6.keySet()
            java.util.Iterator r10 = r0.iterator()
        L_0x018c:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x0274
            java.lang.Object r0 = r10.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "get"
            boolean r1 = r0.startsWith(r1)
            java.lang.String r2 = "set"
            boolean r2 = r0.startsWith(r2)
            java.lang.String r3 = "is"
            boolean r3 = r0.startsWith(r3)
            if (r1 != 0) goto L_0x01b0
            if (r3 != 0) goto L_0x01b0
            if (r2 == 0) goto L_0x018c
        L_0x01b0:
            if (r3 == 0) goto L_0x0242
            r1 = 2
        L_0x01b3:
            java.lang.String r1 = r0.substring(r1)
            int r0 = r1.length()
            if (r0 == 0) goto L_0x018c
            r0 = 0
            char r0 = r1.charAt(r0)
            boolean r2 = java.lang.Character.isUpperCase(r0)
            if (r2 == 0) goto L_0x02c4
            int r2 = r1.length()
            r3 = 1
            if (r2 != r3) goto L_0x0245
            java.lang.String r0 = r1.toLowerCase()
            r2 = r0
        L_0x01d4:
            boolean r0 = r9.containsKey(r2)
            if (r0 != 0) goto L_0x018c
            java.lang.Object r0 = r6.get(r2)
            if (r0 == 0) goto L_0x01f2
            if (r15 == 0) goto L_0x018c
            boolean r3 = r0 instanceof java.lang.reflect.Member
            if (r3 == 0) goto L_0x018c
            java.lang.reflect.Member r0 = (java.lang.reflect.Member) r0
            int r0 = r0.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isPrivate(r0)
            if (r0 == 0) goto L_0x018c
        L_0x01f2:
            java.lang.String r0 = "get"
            org.mozilla.javascript.bb r0 = m5789a(r7, r6, r0, r1)
            if (r0 != 0) goto L_0x02c1
            java.lang.String r0 = "is"
            org.mozilla.javascript.bb r0 = m5789a(r7, r6, r0, r1)
            r3 = r0
        L_0x0201:
            r5 = 0
            r4 = 0
            java.lang.String r0 = "set"
            java.lang.String r0 = r0.concat(r1)
            boolean r1 = r6.containsKey(r0)
            if (r1 == 0) goto L_0x02bd
            java.lang.Object r0 = r6.get(r0)
            boolean r1 = r0 instanceof org.mozilla.javascript.NativeJavaMethod
            if (r1 == 0) goto L_0x02bd
            org.mozilla.javascript.bx r0 = (org.mozilla.javascript.NativeJavaMethod) r0
            if (r3 == 0) goto L_0x026d
            java.lang.reflect.Member r1 = r3.f6278a
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1
            java.lang.Class r1 = r1.getReturnType()
            org.mozilla.javascript.bb[] r5 = r0.f6345c
            org.mozilla.javascript.bb r1 = m5788a(r1, r5, r7)
        L_0x0229:
            org.mozilla.javascript.bb[] r5 = r0.f6345c
            int r5 = r5.length
            r11 = 1
            if (r5 <= r11) goto L_0x02ba
        L_0x022f:
            org.mozilla.javascript.c r4 = new org.mozilla.javascript.c
            r4.<init>(r3, r1, r0)
            r9.put(r2, r4)
            goto L_0x018c
        L_0x0239:
            r0 = 0
            r7 = r0
            goto L_0x017a
        L_0x023d:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r12.f6084c
            r6 = r0
            goto L_0x017f
        L_0x0242:
            r1 = 3
            goto L_0x01b3
        L_0x0245:
            r2 = 1
            char r2 = r1.charAt(r2)
            boolean r2 = java.lang.Character.isUpperCase(r2)
            if (r2 != 0) goto L_0x02c4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            char r0 = java.lang.Character.toLowerCase(r0)
            java.lang.StringBuilder r0 = r2.append(r0)
            r2 = 1
            java.lang.String r2 = r1.substring(r2)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = r0
            goto L_0x01d4
        L_0x026d:
            org.mozilla.javascript.bb[] r1 = r0.f6345c
            org.mozilla.javascript.bb r1 = m5790a(r1, r7)
            goto L_0x0229
        L_0x0274:
            java.util.Set r0 = r9.keySet()
            java.util.Iterator r1 = r0.iterator()
        L_0x027c:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0290
            java.lang.Object r0 = r1.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r2 = r9.get(r0)
            r6.put(r0, r2)
            goto L_0x027c
        L_0x0290:
            int r0 = r8 + 1
            r8 = r0
            goto L_0x0173
        L_0x0295:
            java.lang.reflect.Constructor[] r1 = r12.m5795b(r15)
            int r0 = r1.length
            org.mozilla.javascript.bb[] r2 = new org.mozilla.javascript.MemberBox[r0]
            r0 = 0
        L_0x029d:
            int r3 = r1.length
            if (r0 == r3) goto L_0x02ac
            org.mozilla.javascript.bb r3 = new org.mozilla.javascript.bb
            r4 = r1[r0]
            r3.<init>(r4)
            r2[r0] = r3
            int r0 = r0 + 1
            goto L_0x029d
        L_0x02ac:
            org.mozilla.javascript.bx r0 = new org.mozilla.javascript.bx
            java.lang.Class<?> r1 = r12.f6083b
            java.lang.String r1 = r1.getSimpleName()
            r0.<init>(r2, r1)
            r12.f6082a = r0
            return
        L_0x02ba:
            r0 = r4
            goto L_0x022f
        L_0x02bd:
            r0 = r4
            r1 = r5
            goto L_0x022f
        L_0x02c1:
            r3 = r0
            goto L_0x0201
        L_0x02c4:
            r2 = r1
            goto L_0x01d4
        L_0x02c7:
            r1 = r3
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.C2140au.m5792a(org.mozilla.javascript.dr, boolean, boolean):void");
    }

    /* renamed from: b */
    private Constructor<?>[] m5795b(boolean z) {
        if (z && this.f6083b != ScriptRuntime.f6497d) {
            try {
                Constructor<?>[] declaredConstructors = this.f6083b.getDeclaredConstructors();
                AccessibleObject.setAccessible(declaredConstructors, true);
                return declaredConstructors;
            } catch (SecurityException e) {
                Context.m6760a("Could not access constructor  of class " + this.f6083b.getName() + " due to lack of privileges.");
            }
        }
        return this.f6083b.getConstructors();
    }

    /* renamed from: a */
    private Field[] m5793a(boolean z, boolean z2) {
        Field[] declaredFields;
        if (z2 || z) {
            try {
                ArrayList arrayList = new ArrayList();
                for (Class<?> cls = this.f6083b; cls != null; cls = cls.getSuperclass()) {
                    for (Field field : cls.getDeclaredFields()) {
                        int modifiers = field.getModifiers();
                        if (z2 || Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                            if (!field.isAccessible()) {
                                field.setAccessible(true);
                            }
                            arrayList.add(field);
                        }
                    }
                }
                return (Field[]) arrayList.toArray(new Field[arrayList.size()]);
            } catch (SecurityException e) {
            }
        }
        return this.f6083b.getFields();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        if (((java.lang.reflect.Method) r1.f6278a).getReturnType() == java.lang.Void.TYPE) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.mozilla.javascript.MemberBox m5789a(boolean r6, Map<String, Object> r7, String r8, String r9) {
        /*
            r2 = 0
            java.lang.String r0 = r8.concat(r9)
            boolean r1 = r7.containsKey(r0)
            if (r1 == 0) goto L_0x003d
            java.lang.Object r0 = r7.get(r0)
            boolean r1 = r0 instanceof org.mozilla.javascript.NativeJavaMethod
            if (r1 == 0) goto L_0x003d
            org.mozilla.javascript.bx r0 = (org.mozilla.javascript.NativeJavaMethod) r0
            org.mozilla.javascript.bb[] r3 = r0.f6345c
            int r4 = r3.length
            r0 = 0
        L_0x0019:
            if (r0 >= r4) goto L_0x003b
            r1 = r3[r0]
            java.lang.Class<?>[] r5 = r1.f6279b
            int r5 = r5.length
            if (r5 != 0) goto L_0x0038
            if (r6 == 0) goto L_0x002a
            boolean r5 = r1.mo18834a()
            if (r5 == 0) goto L_0x0038
        L_0x002a:
            java.lang.reflect.Member r0 = r1.f6278a
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0
            java.lang.Class r0 = r0.getReturnType()
            java.lang.Class r3 = java.lang.Void.TYPE
            if (r0 == r3) goto L_0x003b
            r0 = r1
        L_0x0037:
            return r0
        L_0x0038:
            int r0 = r0 + 1
            goto L_0x0019
        L_0x003b:
            r0 = r2
            goto L_0x0037
        L_0x003d:
            r0 = r2
            goto L_0x0037
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.C2140au.m5789a(boolean, java.util.Map, java.lang.String, java.lang.String):org.mozilla.javascript.bb");
    }

    /* renamed from: a */
    private static MemberBox m5788a(Class<?> cls, MemberBox[] bbVarArr, boolean z) {
        for (int i = 1; i <= 2; i++) {
            for (MemberBox bbVar : bbVarArr) {
                if (!z || bbVar.mo18834a()) {
                    Class<?>[] clsArr = bbVar.f6279b;
                    if (clsArr.length != 1) {
                        continue;
                    } else if (i != 1) {
                        if (i != 2) {
                            Kit.m5810a();
                        }
                        if (clsArr[0].isAssignableFrom(cls)) {
                            return bbVar;
                        }
                    } else if (clsArr[0] == cls) {
                        return bbVar;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static MemberBox m5790a(MemberBox[] bbVarArr, boolean z) {
        for (MemberBox bbVar : bbVarArr) {
            if ((!z || bbVar.mo18834a()) && ((Method) bbVar.f6278a).getReturnType() == Void.TYPE && bbVar.f6279b.length == 1) {
                return bbVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Map<String, JavaMembers> mo18697a(Scriptable drVar, Object obj, boolean z) {
        Map<String, JavaMembers> map = z ? this.f6087f : this.f6085d;
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap(map.size());
        for (JavaMembers aaVar : map.values()) {
            JavaMembers aaVar2 = new JavaMembers(drVar, aaVar.f6345c, aaVar.f5983a);
            aaVar2.f5984b = obj;
            hashMap.put(aaVar.f5983a.getName(), aaVar2);
        }
        return hashMap;
    }

    /* renamed from: a */
    static C2140au m5787a(Scriptable drVar, Class<?> cls, Class<?> cls2, boolean z) {
        C2140au auVar;
        ClassCache a = ClassCache.m6667a(drVar);
        if (a.f6699c == null) {
            a.f6699c = new HashMap<>();
        }
        HashMap<Class<?>, C2140au> hashMap = a.f6699c;
        Class<?> cls3 = cls;
        Class<?> cls4 = cls2;
        while (true) {
            auVar = (C2140au) hashMap.get(cls3);
            if (auVar == null) {
                try {
                    auVar = new C2140au(a.f6702f, cls3, z);
                    if (a.f6698b) {
                        hashMap.put(cls3, auVar);
                        if (cls3 != cls) {
                            hashMap.put(cls, auVar);
                        }
                    }
                } catch (SecurityException e) {
                    SecurityException securityException = e;
                    if (cls4 == null || !cls4.isInterface()) {
                        Class<?> superclass = cls3.getSuperclass();
                        if (superclass == null) {
                            if (cls3.isInterface()) {
                                superclass = ScriptRuntime.f6503j;
                            } else {
                                throw securityException;
                            }
                        }
                        cls3 = superclass;
                    } else {
                        cls3 = cls4;
                        cls4 = null;
                    }
                }
            } else if (cls3 != cls) {
                hashMap.put(cls, auVar);
            }
        }
        return auVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final RuntimeException mo18696a(String str) {
        return Context.m6756a("msg.java.member.not.found", (Object) this.f6083b.getName(), (Object) str);
    }
}
