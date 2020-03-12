package org.mozilla.javascript;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.bx */
public class NativeJavaMethod extends BaseFunction {

    /* renamed from: a */
    private String f6343a;

    /* renamed from: b */
    private transient LinkedList<C2173dg> f6344b;

    /* renamed from: c */
    MemberBox[] f6345c;

    NativeJavaMethod(MemberBox[] bbVarArr) {
        this.f6343a = bbVarArr[0].mo18835b();
        this.f6345c = bbVarArr;
    }

    NativeJavaMethod(MemberBox[] bbVarArr, String str) {
        this.f6343a = str;
        this.f6345c = bbVarArr;
    }

    NativeJavaMethod(MemberBox bbVar, String str) {
        this.f6343a = str;
        this.f6345c = new MemberBox[]{bbVar};
    }

    public String getFunctionName() {
        return this.f6343a;
    }

    /* renamed from: a */
    static String m6080a(Object[] objArr) {
        String a;
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 == objArr.length) {
                return stringBuffer.toString();
            }
            Wrapper eoVar = objArr[i2];
            if (eoVar == null) {
                a = "null";
            } else if (eoVar instanceof Boolean) {
                a = "boolean";
            } else if (eoVar instanceof String) {
                a = "string";
            } else if (eoVar instanceof Number) {
                a = "number";
            } else if (!(eoVar instanceof Scriptable)) {
                a = C2140au.m5785a(eoVar.getClass());
            } else if (eoVar instanceof Undefined) {
                a = "undefined";
            } else if (eoVar instanceof Wrapper) {
                a = eoVar.mo18879a().getClass().getName();
            } else if (eoVar instanceof Function) {
                a = "function";
            } else {
                a = "object";
            }
            if (i2 != 0) {
                stringBuffer.append(CoreConstants.COMMA_CHAR);
            }
            stringBuffer.append(a);
            i = i2 + 1;
        }
    }

    /* access modifiers changed from: 0000 */
    public String decompile(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = (i2 & 1) != 0;
        if (!z) {
            stringBuffer.append("function ");
            stringBuffer.append(getFunctionName());
            stringBuffer.append("() {");
        }
        stringBuffer.append("/*\n");
        stringBuffer.append(toString());
        stringBuffer.append(z ? "*/\n" : "*/}\n");
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int length = this.f6345c.length;
        for (int i = 0; i != length; i++) {
            if (this.f6345c[i].f6278a instanceof Method) {
                Method method = (Method) this.f6345c[i].f6278a;
                stringBuffer.append(C2140au.m5785a(method.getReturnType()));
                stringBuffer.append(' ');
                stringBuffer.append(method.getName());
            } else {
                stringBuffer.append(this.f6345c[i].mo18835b());
            }
            stringBuffer.append(C2140au.m5786a(this.f6345c[i].f6279b));
            stringBuffer.append(10);
        }
        return stringBuffer.toString();
    }

    public Object call(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        Object[] objArr2;
        Object a;
        Object newInstance;
        int i = 0;
        if (this.f6345c.length == 0) {
            throw new RuntimeException("No methods defined for call");
        }
        int a2 = mo18884a(lVar, objArr);
        if (a2 < 0) {
            throw Context.m6755a("msg.java.no_such_method", (Object) ((Method) this.f6345c[0].f6278a).getDeclaringClass().getName() + CoreConstants.DOT + getFunctionName() + CoreConstants.LEFT_PARENTHESIS_CHAR + m6080a(objArr) + CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
        MemberBox bbVar = this.f6345c[a2];
        Class<?>[] clsArr = bbVar.f6279b;
        if (bbVar.f6281d) {
            objArr2 = new Object[clsArr.length];
            for (int i2 = 0; i2 < clsArr.length - 1; i2++) {
                objArr2[i2] = Context.m6742a(objArr[i2], clsArr[i2]);
            }
            if (objArr.length != clsArr.length || (objArr[objArr.length - 1] != null && !(objArr[objArr.length - 1] instanceof NativeArray) && !(objArr[objArr.length - 1] instanceof NativeJavaArray))) {
                Class componentType = clsArr[clsArr.length - 1].getComponentType();
                newInstance = Array.newInstance(componentType, (objArr.length - clsArr.length) + 1);
                while (i < Array.getLength(newInstance)) {
                    Array.set(newInstance, i, Context.m6742a(objArr[(clsArr.length - 1) + i], componentType));
                    i++;
                }
            } else {
                newInstance = Context.m6742a(objArr[objArr.length - 1], clsArr[clsArr.length - 1]);
            }
            objArr2[clsArr.length - 1] = newInstance;
        } else {
            Object[] objArr3 = objArr;
            while (i < objArr3.length) {
                Object obj = objArr3[i];
                Object a3 = Context.m6742a(obj, clsArr[i]);
                if (a3 != obj) {
                    if (objArr == objArr3) {
                        objArr3 = (Object[]) objArr3.clone();
                    }
                    objArr3[i] = a3;
                }
                i++;
            }
            objArr2 = objArr3;
        }
        if (bbVar.mo18834a()) {
            a = null;
        } else {
            Class c = bbVar.mo18836c();
            for (Scriptable drVar3 = drVar2; drVar3 != null; drVar3 = drVar3.getPrototype()) {
                if (drVar3 instanceof Wrapper) {
                    a = ((Wrapper) drVar3).mo18879a();
                    if (!c.isInstance(a)) {
                    }
                }
            }
            throw Context.m6757a("msg.nonjava.method", (Object) getFunctionName(), (Object) ScriptRuntime.m6436d((Object) drVar2), (Object) c.getName());
        }
        Object a4 = bbVar.mo18832a(a, objArr2);
        Class returnType = ((Method) bbVar.f6278a).getReturnType();
        Object a5 = lVar.mo19142g().mo19103a(drVar, a4, returnType);
        if (a5 == null && returnType == Void.TYPE) {
            return Undefined.f6689a;
        }
        return a5;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo18884a(Context lVar, Object[] objArr) {
        boolean z;
        if (this.f6345c.length <= 1) {
            return m6079a(lVar, this.f6345c, objArr);
        }
        if (this.f6344b != null) {
            Iterator it = this.f6344b.iterator();
            while (it.hasNext()) {
                C2173dg dgVar = (C2173dg) it.next();
                if (objArr.length == dgVar.f6484a.length) {
                    int length = objArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            z = true;
                            continue;
                            break;
                        }
                        Object obj = objArr[i];
                        if (obj instanceof Wrapper) {
                            obj = ((Wrapper) obj).mo18879a();
                        }
                        if (obj == null) {
                            if (dgVar.f6484a[i] != null) {
                                z = false;
                                continue;
                                break;
                            }
                        } else if (obj.getClass() != dgVar.f6484a[i]) {
                            z = false;
                            continue;
                            break;
                        }
                        i++;
                    }
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return dgVar.f6485b;
                }
            }
        } else {
            this.f6344b = new LinkedList<>();
        }
        int a = m6079a(lVar, this.f6345c, objArr);
        if (this.f6344b.size() >= this.f6345c.length * 2) {
            return a;
        }
        synchronized (this.f6344b) {
            C2173dg dgVar2 = new C2173dg(objArr, a);
            if (!this.f6344b.contains(dgVar2)) {
                this.f6344b.addFirst(dgVar2);
            }
        }
        return a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005e, code lost:
        if (r2 == r24.length) goto L_0x0060;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m6079a(Context r22, MemberBox[] r23, Object[] r24) {
        /*
            r0 = r23
            int r2 = r0.length
            if (r2 != 0) goto L_0x0007
            r5 = -1
        L_0x0006:
            return r5
        L_0x0007:
            r0 = r23
            int r2 = r0.length
            r3 = 1
            if (r2 != r3) goto L_0x003b
            r2 = 0
            r3 = r23[r2]
            java.lang.Class<?>[] r4 = r3.f6279b
            int r2 = r4.length
            boolean r3 = r3.f6281d
            if (r3 == 0) goto L_0x0020
            int r2 = r2 + -1
            r0 = r24
            int r3 = r0.length
            if (r2 <= r3) goto L_0x0027
            r5 = -1
            goto L_0x0006
        L_0x0020:
            r0 = r24
            int r3 = r0.length
            if (r2 == r3) goto L_0x0027
            r5 = -1
            goto L_0x0006
        L_0x0027:
            r3 = 0
        L_0x0028:
            if (r3 == r2) goto L_0x0039
            r5 = r24[r3]
            r6 = r4[r3]
            boolean r5 = org.mozilla.javascript.NativeJavaObject.m6087a(r5, r6)
            if (r5 != 0) goto L_0x0036
            r5 = -1
            goto L_0x0006
        L_0x0036:
            int r3 = r3 + 1
            goto L_0x0028
        L_0x0039:
            r5 = 0
            goto L_0x0006
        L_0x003b:
            r5 = -1
            r3 = 0
            r4 = 0
            r6 = 0
        L_0x003f:
            r0 = r23
            int r2 = r0.length
            if (r6 >= r2) goto L_0x0182
            r13 = r23[r6]
            java.lang.Class<?>[] r14 = r13.f6279b
            int r2 = r14.length
            boolean r7 = r13.f6281d
            if (r7 == 0) goto L_0x005b
            int r2 = r2 + -1
            r0 = r24
            int r7 = r0.length
            if (r2 <= r7) goto L_0x0060
            r2 = r4
            r4 = r5
        L_0x0056:
            int r6 = r6 + 1
            r5 = r4
            r4 = r2
            goto L_0x003f
        L_0x005b:
            r0 = r24
            int r7 = r0.length
            if (r2 != r7) goto L_0x022c
        L_0x0060:
            r7 = 0
        L_0x0061:
            if (r7 >= r2) goto L_0x0070
            r8 = r24[r7]
            r9 = r14[r7]
            boolean r8 = org.mozilla.javascript.NativeJavaObject.m6087a(r8, r9)
            if (r8 == 0) goto L_0x022c
            int r7 = r7 + 1
            goto L_0x0061
        L_0x0070:
            if (r5 >= 0) goto L_0x0075
            r2 = r4
            r4 = r6
            goto L_0x0056
        L_0x0075:
            r8 = 0
            r9 = 0
            r2 = -1
            r12 = r2
        L_0x0079:
            if (r12 == r4) goto L_0x0161
            r2 = -1
            if (r12 != r2) goto L_0x00b0
            r2 = r5
        L_0x007f:
            r15 = r23[r2]
            r2 = 13
            r0 = r22
            boolean r2 = r0.mo19138b(r2)
            if (r2 == 0) goto L_0x00b8
            java.lang.reflect.Member r2 = r15.f6278a
            int r2 = r2.getModifiers()
            r2 = r2 & 1
            java.lang.reflect.Member r7 = r13.f6278a
            int r7 = r7.getModifiers()
            r7 = r7 & 1
            if (r2 == r7) goto L_0x00b8
            java.lang.reflect.Member r2 = r15.f6278a
            int r2 = r2.getModifiers()
            r2 = r2 & 1
            if (r2 != 0) goto L_0x00b3
            int r2 = r8 + 1
            r7 = r9
        L_0x00aa:
            int r8 = r12 + 1
            r12 = r8
            r9 = r7
            r8 = r2
            goto L_0x0079
        L_0x00b0:
            r2 = r3[r12]
            goto L_0x007f
        L_0x00b3:
            int r2 = r9 + 1
            r7 = r2
            r2 = r8
            goto L_0x00aa
        L_0x00b8:
            boolean r0 = r13.f6281d
            r16 = r0
            java.lang.Class<?>[] r0 = r15.f6279b
            r17 = r0
            boolean r0 = r15.f6281d
            r18 = r0
            r7 = 0
            r2 = 0
        L_0x00c6:
            r0 = r24
            int r10 = r0.length
            if (r2 >= r10) goto L_0x0127
            if (r16 == 0) goto L_0x0102
            int r10 = r14.length
            if (r2 < r10) goto L_0x0102
            int r10 = r14.length
            int r10 = r10 + -1
            r10 = r14[r10]
            r11 = r10
        L_0x00d6:
            if (r18 == 0) goto L_0x0106
            r0 = r17
            int r10 = r0.length
            if (r2 < r10) goto L_0x0106
            r0 = r17
            int r10 = r0.length
            int r10 = r10 + -1
            r10 = r17[r10]
        L_0x00e4:
            if (r11 == r10) goto L_0x00ff
            r19 = r24[r2]
            r0 = r19
            int r20 = org.mozilla.javascript.NativeJavaObject.m6089b(r0, r11)
            r0 = r19
            int r19 = org.mozilla.javascript.NativeJavaObject.m6089b(r0, r10)
            r0 = r20
            r1 = r19
            if (r0 >= r1) goto L_0x0109
            r10 = 1
        L_0x00fb:
            r7 = r7 | r10
            r10 = 3
            if (r7 == r10) goto L_0x0127
        L_0x00ff:
            int r2 = r2 + 1
            goto L_0x00c6
        L_0x0102:
            r10 = r14[r2]
            r11 = r10
            goto L_0x00d6
        L_0x0106:
            r10 = r17[r2]
            goto L_0x00e4
        L_0x0109:
            r0 = r20
            r1 = r19
            if (r0 <= r1) goto L_0x0111
            r10 = 2
            goto L_0x00fb
        L_0x0111:
            if (r20 != 0) goto L_0x0125
            boolean r19 = r11.isAssignableFrom(r10)
            if (r19 == 0) goto L_0x011b
            r10 = 2
            goto L_0x00fb
        L_0x011b:
            boolean r10 = r10.isAssignableFrom(r11)
            if (r10 == 0) goto L_0x0123
            r10 = 1
            goto L_0x00fb
        L_0x0123:
            r10 = 3
            goto L_0x00fb
        L_0x0125:
            r10 = 3
            goto L_0x00fb
        L_0x0127:
            r2 = 3
            if (r7 == r2) goto L_0x0161
            r2 = 1
            if (r7 != r2) goto L_0x0132
            int r2 = r8 + 1
            r7 = r9
            goto L_0x00aa
        L_0x0132:
            r2 = 2
            if (r7 != r2) goto L_0x013b
            int r2 = r9 + 1
            r7 = r2
            r2 = r8
            goto L_0x00aa
        L_0x013b:
            if (r7 == 0) goto L_0x0140
            org.mozilla.javascript.Kit.m5810a()
        L_0x0140:
            boolean r2 = r15.mo18834a()
            if (r2 == 0) goto L_0x022c
            java.lang.Class r2 = r15.mo18836c()
            java.lang.Class r7 = r13.mo18836c()
            boolean r2 = r2.isAssignableFrom(r7)
            if (r2 == 0) goto L_0x022c
            r2 = -1
            if (r12 != r2) goto L_0x015b
            r2 = r4
            r4 = r6
            goto L_0x0056
        L_0x015b:
            r3[r12] = r6
            r2 = r4
            r4 = r5
            goto L_0x0056
        L_0x0161:
            int r2 = r4 + 1
            if (r8 != r2) goto L_0x0169
            r2 = 0
            r4 = r6
            goto L_0x0056
        L_0x0169:
            int r2 = r4 + 1
            if (r9 == r2) goto L_0x022c
            if (r3 != 0) goto L_0x0229
            r0 = r23
            int r2 = r0.length
            int r2 = r2 + -1
            int[] r2 = new int[r2]
        L_0x0176:
            r2[r4] = r6
            int r3 = r4 + 1
            r4 = r5
            r21 = r2
            r2 = r3
            r3 = r21
            goto L_0x0056
        L_0x0182:
            if (r5 >= 0) goto L_0x0187
            r5 = -1
            goto L_0x0006
        L_0x0187:
            if (r4 == 0) goto L_0x0006
            java.lang.StringBuffer r7 = new java.lang.StringBuffer
            r7.<init>()
            r2 = -1
            r6 = r2
        L_0x0190:
            if (r6 == r4) goto L_0x01f4
            r2 = -1
            if (r6 != r2) goto L_0x01d3
            r2 = r5
        L_0x0196:
            java.lang.String r8 = "\n    "
            r7.append(r8)
            r8 = r23[r2]
            java.lang.StringBuffer r9 = new java.lang.StringBuffer
            r9.<init>()
            java.lang.reflect.Member r2 = r8.f6278a
            boolean r2 = r2 instanceof java.lang.reflect.Method
            if (r2 == 0) goto L_0x01d6
            java.lang.reflect.Member r2 = r8.f6278a
            java.lang.reflect.Method r2 = (java.lang.reflect.Method) r2
            java.lang.Class r10 = r2.getReturnType()
            r9.append(r10)
            r10 = 32
            r9.append(r10)
            java.lang.String r2 = r2.getName()
            r9.append(r2)
        L_0x01bf:
            java.lang.Class<?>[] r2 = r8.f6279b
            java.lang.String r2 = org.mozilla.javascript.C2140au.m5786a((java.lang.Class<?>[]) r2)
            r9.append(r2)
            java.lang.String r2 = r9.toString()
            r7.append(r2)
            int r2 = r6 + 1
            r6 = r2
            goto L_0x0190
        L_0x01d3:
            r2 = r3[r6]
            goto L_0x0196
        L_0x01d6:
            java.lang.reflect.Member r2 = r8.f6278a
            java.lang.reflect.Constructor r2 = (java.lang.reflect.Constructor) r2
            java.lang.Class r2 = r2.getDeclaringClass()
            java.lang.String r2 = r2.getName()
            r10 = 46
            int r10 = r2.lastIndexOf(r10)
            if (r10 < 0) goto L_0x01f0
            int r10 = r10 + 1
            java.lang.String r2 = r2.substring(r10)
        L_0x01f0:
            r9.append(r2)
            goto L_0x01bf
        L_0x01f4:
            r2 = r23[r5]
            java.lang.String r3 = r2.mo18835b()
            java.lang.Class r2 = r2.mo18836c()
            java.lang.String r2 = r2.getName()
            r4 = 0
            r4 = r23[r4]
            java.lang.reflect.Member r4 = r4.f6278a
            boolean r4 = r4 instanceof java.lang.reflect.Constructor
            if (r4 == 0) goto L_0x021a
            java.lang.String r2 = "msg.constructor.ambiguous"
            java.lang.String r4 = m6080a(r24)
            java.lang.String r5 = r7.toString()
            org.mozilla.javascript.z r2 = org.mozilla.javascript.Context.m6757a(r2, r3, r4, r5)
            throw r2
        L_0x021a:
            java.lang.String r4 = "msg.method.ambiguous"
            java.lang.String r5 = m6080a(r24)
            java.lang.String r6 = r7.toString()
            org.mozilla.javascript.z r2 = org.mozilla.javascript.Context.m6758a(r4, r2, r3, r5, r6)
            throw r2
        L_0x0229:
            r2 = r3
            goto L_0x0176
        L_0x022c:
            r2 = r4
            r4 = r5
            goto L_0x0056
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeJavaMethod.m6079a(org.mozilla.javascript.l, org.mozilla.javascript.bb[], java.lang.Object[]):int");
    }
}
