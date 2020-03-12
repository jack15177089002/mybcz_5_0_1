package org.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import org.mozilla.javascript.p109a.JSFunction;
import org.mozilla.javascript.p109a.JSGetter;
import org.mozilla.javascript.p109a.JSSetter;
import org.mozilla.javascript.p109a.JSStaticFunction;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.ds */
public abstract class ScriptableObject implements Serializable, Scriptable, ConstProperties {
    static final /* synthetic */ boolean $assertionsDisabled = (!ScriptableObject.class.desiredAssertionStatus());
    public static final int CONST = 13;
    public static final int DONTENUM = 2;
    public static final int EMPTY = 0;
    private static final int INITIAL_SLOT_SIZE = 4;
    public static final int PERMANENT = 4;
    public static final int READONLY = 1;
    private static final int SLOT_CONVERT_ACCESSOR_TO_DATA = 5;
    private static final int SLOT_MODIFY = 2;
    private static final int SLOT_MODIFY_CONST = 3;
    private static final int SLOT_MODIFY_GETTER_SETTER = 4;
    private static final int SLOT_QUERY = 1;
    public static final int UNINITIALIZED_CONST = 8;
    static final long serialVersionUID = 2829861078851942586L;
    private volatile Map<Object, Object> associatedValues;
    private int count;
    private transient C2181dv firstAdded;
    private boolean isExtensible = true;
    private transient C2181dv lastAdded;
    private Scriptable parentScopeObject;
    private Scriptable prototypeObject;
    private transient C2181dv[] slots;

    public abstract String getClassName();

    protected static ScriptableObject buildDataDescriptor(Scriptable drVar, Object obj, int i) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        NativeObject cbVar = new NativeObject();
        ScriptRuntime.m6384a((ScriptableObject) cbVar, drVar, C2193eh.Object);
        cbVar.defineProperty("value", obj, 0);
        String str = "writable";
        if ((i & 1) == 0) {
            z = true;
        } else {
            z = false;
        }
        cbVar.defineProperty(str, (Object) Boolean.valueOf(z), 0);
        String str2 = "enumerable";
        if ((i & 2) == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        cbVar.defineProperty(str2, (Object) Boolean.valueOf(z2), 0);
        String str3 = "configurable";
        if ((i & 4) != 0) {
            z3 = false;
        }
        cbVar.defineProperty(str3, (Object) Boolean.valueOf(z3), 0);
        return cbVar;
    }

    static void checkValidAttributes(int i) {
        if ((i & -16) != 0) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    public ScriptableObject() {
    }

    public ScriptableObject(Scriptable drVar, Scriptable drVar2) {
        if (drVar == null) {
            throw new IllegalArgumentException();
        }
        this.parentScopeObject = drVar;
        this.prototypeObject = drVar2;
    }

    public String getTypeOf() {
        return avoidObjectDetection() ? "undefined" : "object";
    }

    public boolean has(String str, Scriptable drVar) {
        return getSlot(str, 0, 1) != null;
    }

    public boolean has(int i, Scriptable drVar) {
        return getSlot((String) null, i, 1) != null;
    }

    public Object get(String str, Scriptable drVar) {
        C2181dv slot = getSlot(str, 0, 1);
        if (slot == null) {
            return Scriptable.f6533j;
        }
        return slot.mo19057a(drVar);
    }

    public Object get(int i, Scriptable drVar) {
        C2181dv slot = getSlot((String) null, i, 1);
        if (slot == null) {
            return Scriptable.f6533j;
        }
        return slot.mo19057a(drVar);
    }

    public void put(String str, Scriptable drVar, Object obj) {
        if (!putImpl(str, 0, drVar, obj)) {
            if (drVar == this) {
                throw Kit.m5810a();
            }
            drVar.put(str, drVar, obj);
        }
    }

    public void put(int i, Scriptable drVar, Object obj) {
        if (!putImpl(null, i, drVar, obj)) {
            if (drVar == this) {
                throw Kit.m5810a();
            }
            drVar.put(i, drVar, obj);
        }
    }

    public void delete(String str) {
        checkNotSealed(str, 0);
        removeSlot(str, 0);
    }

    public void delete(int i) {
        checkNotSealed(null, i);
        removeSlot(null, i);
    }

    public void putConst(String str, Scriptable drVar, Object obj) {
        if (!putConstImpl(str, 0, drVar, obj, 1)) {
            if (drVar == this) {
                throw Kit.m5810a();
            } else if (drVar instanceof ConstProperties) {
                ((ConstProperties) drVar).putConst(str, drVar, obj);
            } else {
                drVar.put(str, drVar, obj);
            }
        }
    }

    public void defineConst(String str, Scriptable drVar) {
        if (!putConstImpl(str, 0, drVar, Undefined.f6689a, 8)) {
            if (drVar == this) {
                throw Kit.m5810a();
            } else if (drVar instanceof ConstProperties) {
                ((ConstProperties) drVar).defineConst(str, drVar);
            }
        }
    }

    public boolean isConst(String str) {
        C2181dv slot = getSlot(str, 0, 1);
        if (slot != null && (slot.mo19062b() & 5) == 5) {
            return true;
        }
        return false;
    }

    public final int getAttributes(String str, Scriptable drVar) {
        return getAttributes(str);
    }

    public final int getAttributes(int i, Scriptable drVar) {
        return getAttributes(i);
    }

    public final void setAttributes(String str, Scriptable drVar, int i) {
        setAttributes(str, i);
    }

    public void setAttributes(int i, Scriptable drVar, int i2) {
        setAttributes(i, i2);
    }

    public int getAttributes(String str) {
        return findAttributeSlot(str, 0, 1).mo19062b();
    }

    public int getAttributes(int i) {
        return findAttributeSlot(null, i, 1).mo19062b();
    }

    public void setAttributes(String str, int i) {
        checkNotSealed(str, 0);
        findAttributeSlot(str, 0, 2).mo19061a(i);
    }

    public void setAttributes(int i, int i2) {
        checkNotSealed(null, i);
        findAttributeSlot(null, i, 2).mo19061a(i2);
    }

    public void setGetterOrSetter(String str, int i, Callable eVar, boolean z) {
        setGetterOrSetter(str, i, eVar, z, false);
    }

    private void setGetterOrSetter(String str, int i, Callable eVar, boolean z, boolean z2) {
        C2179dt dtVar;
        if (str == null || i == 0) {
            if (!z2) {
                checkNotSealed(str, i);
            }
            if (isExtensible()) {
                dtVar = (C2179dt) getSlot(str, i, 4);
            } else {
                C2181dv unwrapSlot = unwrapSlot(getSlot(str, i, 1));
                if (unwrapSlot instanceof C2179dt) {
                    dtVar = (C2179dt) unwrapSlot;
                } else {
                    return;
                }
            }
            if (z2 || (dtVar.mo19062b() & 1) == 0) {
                if (z) {
                    dtVar.f6535b = eVar;
                } else {
                    dtVar.f6534a = eVar;
                }
                dtVar.f6541g = Undefined.f6689a;
                return;
            }
            throw Context.m6755a("msg.modify.readonly", (Object) str);
        }
        throw new IllegalArgumentException(str);
    }

    public Object getGetterOrSetter(String str, int i, boolean z) {
        if (str == null || i == 0) {
            C2181dv unwrapSlot = unwrapSlot(getSlot(str, i, 1));
            if (unwrapSlot == null) {
                return null;
            }
            if (!(unwrapSlot instanceof C2179dt)) {
                return Undefined.f6689a;
            }
            C2179dt dtVar = (C2179dt) unwrapSlot;
            Object obj = z ? dtVar.f6535b : dtVar.f6534a;
            if (obj == null) {
                return Undefined.f6689a;
            }
            return obj;
        }
        throw new IllegalArgumentException(str);
    }

    /* access modifiers changed from: protected */
    public boolean isGetterOrSetter(String str, int i, boolean z) {
        C2181dv unwrapSlot = unwrapSlot(getSlot(str, i, 1));
        if (unwrapSlot instanceof C2179dt) {
            if (z && ((C2179dt) unwrapSlot).f6535b != null) {
                return true;
            }
            if (!z && ((C2179dt) unwrapSlot).f6534a != null) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void addLazilyInitializedValue(String str, int i, LazilyLoadedCtor azVar, int i2) {
        if (str == null || i == 0) {
            checkNotSealed(str, i);
            C2179dt dtVar = (C2179dt) getSlot(str, i, 4);
            dtVar.mo19061a(i2);
            dtVar.f6534a = null;
            dtVar.f6535b = null;
            dtVar.f6541g = azVar;
            return;
        }
        throw new IllegalArgumentException(str);
    }

    public Scriptable getPrototype() {
        return this.prototypeObject;
    }

    public void setPrototype(Scriptable drVar) {
        this.prototypeObject = drVar;
    }

    public Scriptable getParentScope() {
        return this.parentScopeObject;
    }

    public void setParentScope(Scriptable drVar) {
        this.parentScopeObject = drVar;
    }

    public Object[] getIds() {
        return getIds(false);
    }

    public Object[] getAllIds() {
        return getIds(true);
    }

    public Object getDefaultValue(Class<?> cls) {
        return getDefaultValue(this, cls);
    }

    public static Object getDefaultValue(Scriptable drVar, Class<?> cls) {
        boolean z;
        Object[] objArr;
        String str;
        String str2;
        Context lVar = null;
        int i = 0;
        while (i < 2) {
            if (cls == ScriptRuntime.f6505l) {
                z = i == 0;
            } else {
                z = i == 1;
            }
            if (z) {
                str2 = "toString";
                objArr = ScriptRuntime.f6517x;
            } else {
                String str3 = CoreConstants.VALUE_OF;
                objArr = new Object[1];
                if (cls == null) {
                    str = "undefined";
                } else if (cls == ScriptRuntime.f6505l) {
                    str = "string";
                } else if (cls == ScriptRuntime.f6511r) {
                    str = "object";
                } else if (cls == ScriptRuntime.f6509p) {
                    str = "function";
                } else if (cls == ScriptRuntime.f6494a || cls == Boolean.TYPE) {
                    str = "boolean";
                } else if (cls == ScriptRuntime.f6502i || cls == ScriptRuntime.f6495b || cls == Byte.TYPE || cls == ScriptRuntime.f6504k || cls == Short.TYPE || cls == ScriptRuntime.f6500g || cls == Integer.TYPE || cls == ScriptRuntime.f6499f || cls == Float.TYPE || cls == ScriptRuntime.f6498e || cls == Double.TYPE) {
                    str = "number";
                } else {
                    throw Context.m6755a("msg.invalid.type", (Object) cls.toString());
                }
                objArr[0] = str;
                str2 = str3;
            }
            Object property = getProperty(drVar, str2);
            if (property instanceof Function) {
                Function abVar = (Function) property;
                if (lVar == null) {
                    lVar = Context.m6769k();
                }
                Object call = abVar.call(lVar, abVar.getParentScope(), drVar, objArr);
                if (call == null) {
                    continue;
                } else {
                    if (!(!(call instanceof Scriptable) || cls == ScriptRuntime.f6511r || cls == ScriptRuntime.f6509p)) {
                        if (z && (call instanceof Wrapper)) {
                            call = ((Wrapper) call).mo18879a();
                            if (!(call instanceof String)) {
                            }
                        }
                    }
                    return call;
                }
            }
            i++;
        }
        throw ScriptRuntime.m6414b("msg.default.value", cls == null ? "undefined" : cls.getName());
    }

    public boolean hasInstance(Scriptable drVar) {
        return ScriptRuntime.m6393a(drVar, (Scriptable) this);
    }

    public boolean avoidObjectDetection() {
        return false;
    }

    /* access modifiers changed from: protected */
    public Object equivalentValues(Object obj) {
        return this == obj ? Boolean.TRUE : Scriptable.f6533j;
    }

    public static <T extends Scriptable> void defineClass(Scriptable drVar, Class<T> cls) {
        defineClass(drVar, cls, false, false);
    }

    public static <T extends Scriptable> void defineClass(Scriptable drVar, Class<T> cls, boolean z) {
        defineClass(drVar, cls, z, false);
    }

    public static <T extends Scriptable> String defineClass(Scriptable drVar, Class<T> cls, boolean z, boolean z2) {
        BaseFunction buildClassCtor = buildClassCtor(drVar, cls, z, z2);
        if (buildClassCtor == null) {
            return null;
        }
        String className = buildClassCtor.getClassPrototype().getClassName();
        defineProperty(drVar, className, buildClassCtor, 2);
        return className;
    }

    /* JADX WARNING: type inference failed for: r3v13, types: [java.lang.reflect.Member] */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r10v0, types: [java.lang.reflect.Member] */
    /* JADX WARNING: type inference failed for: r3v50 */
    /* JADX WARNING: type inference failed for: r3v51, types: [org.mozilla.javascript.dr] */
    /* JADX WARNING: type inference failed for: r3v52 */
    /* JADX WARNING: type inference failed for: r3v69 */
    /* JADX WARNING: type inference failed for: r3v71 */
    /* JADX WARNING: type inference failed for: r3v72 */
    /* JADX WARNING: type inference failed for: r3v76 */
    /* JADX WARNING: type inference failed for: r3v78, types: [java.lang.reflect.Method] */
    /* JADX WARNING: type inference failed for: r3v80, types: [java.lang.reflect.Member] */
    /* JADX WARNING: type inference failed for: r3v90 */
    /* JADX WARNING: type inference failed for: r3v102 */
    /* JADX WARNING: type inference failed for: r3v103 */
    /* JADX WARNING: type inference failed for: r3v104 */
    /* JADX WARNING: type inference failed for: r3v105 */
    /* JADX WARNING: type inference failed for: r3v106 */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x027e, code lost:
        if (r8 == null) goto L_0x0280;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T extends Scriptable> BaseFunction buildClassCtor(Scriptable r20, Class<T> r21, boolean r22, boolean r23) {
        /*
            java.lang.reflect.Method[] r16 = org.mozilla.javascript.FunctionObject.m5652b(r21)
            r3 = 0
        L_0x0005:
            r0 = r16
            int r4 = r0.length
            if (r3 >= r4) goto L_0x0080
            r4 = r16[r3]
            java.lang.String r5 = r4.getName()
            java.lang.String r6 = "init"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x007d
            java.lang.Class[] r5 = r4.getParameterTypes()
            int r6 = r5.length
            r7 = 3
            if (r6 != r7) goto L_0x005c
            r6 = 0
            r6 = r5[r6]
            java.lang.Class<?> r7 = org.mozilla.javascript.ScriptRuntime.f6507n
            if (r6 != r7) goto L_0x005c
            r6 = 1
            r6 = r5[r6]
            java.lang.Class<org.mozilla.javascript.dr> r7 = org.mozilla.javascript.ScriptRuntime.f6511r
            if (r6 != r7) goto L_0x005c
            r6 = 2
            r6 = r5[r6]
            java.lang.Class r7 = java.lang.Boolean.TYPE
            if (r6 != r7) goto L_0x005c
            int r6 = r4.getModifiers()
            boolean r6 = java.lang.reflect.Modifier.isStatic(r6)
            if (r6 == 0) goto L_0x005c
            r3 = 3
            java.lang.Object[] r5 = new java.lang.Object[r3]
            r3 = 0
            org.mozilla.javascript.l r6 = org.mozilla.javascript.Context.m6769k()
            r5[r3] = r6
            r3 = 1
            r5[r3] = r20
            r6 = 2
            if (r22 == 0) goto L_0x0059
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
        L_0x0051:
            r5[r6] = r3
            r3 = 0
            r4.invoke(r3, r5)
            r4 = 0
        L_0x0058:
            return r4
        L_0x0059:
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            goto L_0x0051
        L_0x005c:
            int r6 = r5.length
            r7 = 1
            if (r6 != r7) goto L_0x007d
            r6 = 0
            r5 = r5[r6]
            java.lang.Class<org.mozilla.javascript.dr> r6 = org.mozilla.javascript.ScriptRuntime.f6511r
            if (r5 != r6) goto L_0x007d
            int r5 = r4.getModifiers()
            boolean r5 = java.lang.reflect.Modifier.isStatic(r5)
            if (r5 == 0) goto L_0x007d
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r5 = 0
            r3[r5] = r20
            r5 = 0
            r4.invoke(r5, r3)
            r4 = 0
            goto L_0x0058
        L_0x007d:
            int r3 = r3 + 1
            goto L_0x0005
        L_0x0080:
            java.lang.reflect.Constructor[] r5 = r21.getConstructors()
            r4 = 0
            r3 = 0
        L_0x0086:
            int r6 = r5.length
            if (r3 >= r6) goto L_0x031e
            r6 = r5[r3]
            java.lang.Class[] r6 = r6.getParameterTypes()
            int r6 = r6.length
            if (r6 != 0) goto L_0x00a1
            r3 = r5[r3]
        L_0x0094:
            if (r3 != 0) goto L_0x00a4
            java.lang.String r3 = "msg.zero.arg.ctor"
            java.lang.String r4 = r21.getName()
            org.mozilla.javascript.z r3 = org.mozilla.javascript.Context.m6755a(r3, r4)
            throw r3
        L_0x00a1:
            int r3 = r3 + 1
            goto L_0x0086
        L_0x00a4:
            java.lang.Object[] r4 = org.mozilla.javascript.ScriptRuntime.f6517x
            java.lang.Object r3 = r3.newInstance(r4)
            r9 = r3
            org.mozilla.javascript.dr r9 = (org.mozilla.javascript.Scriptable) r9
            java.lang.String r6 = r9.getClassName()
            org.mozilla.javascript.dr r3 = getTopLevelScope(r20)
            java.lang.Object r4 = getProperty(r3, r6)
            boolean r3 = r4 instanceof org.mozilla.javascript.BaseFunction
            if (r3 == 0) goto L_0x00d5
            r3 = r4
            org.mozilla.javascript.b r3 = (org.mozilla.javascript.BaseFunction) r3
            java.lang.Object r3 = r3.getPrototypeProperty()
            if (r3 == 0) goto L_0x00d5
            java.lang.Class r3 = r3.getClass()
            r0 = r21
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00d5
            org.mozilla.javascript.b r4 = (org.mozilla.javascript.BaseFunction) r4
            goto L_0x0058
        L_0x00d5:
            r3 = 0
            if (r23 == 0) goto L_0x0104
            java.lang.Class r4 = r21.getSuperclass()
            java.lang.Class<org.mozilla.javascript.dr> r7 = org.mozilla.javascript.ScriptRuntime.f6511r
            boolean r7 = r7.isAssignableFrom(r4)
            if (r7 == 0) goto L_0x0104
            int r7 = r4.getModifiers()
            boolean r7 = java.lang.reflect.Modifier.isAbstract(r7)
            if (r7 != 0) goto L_0x0104
            java.lang.Class r4 = extendsScriptable(r4)
            r0 = r20
            r1 = r22
            r2 = r23
            java.lang.String r4 = defineClass(r0, r4, r1, r2)
            if (r4 == 0) goto L_0x0104
            r0 = r20
            org.mozilla.javascript.dr r3 = getClassPrototype(r0, r4)
        L_0x0104:
            if (r3 != 0) goto L_0x010a
            org.mozilla.javascript.dr r3 = getObjectPrototype(r20)
        L_0x010a:
            r9.setPrototype(r3)
            java.lang.Class<org.mozilla.javascript.a.a> r3 = org.mozilla.javascript.p109a.JSConstructor.class
            r0 = r16
            java.lang.reflect.Member r3 = findAnnotatedMember(r0, r3)
            if (r3 != 0) goto L_0x011d
            java.lang.Class<org.mozilla.javascript.a.a> r3 = org.mozilla.javascript.p109a.JSConstructor.class
            java.lang.reflect.Member r3 = findAnnotatedMember(r5, r3)
        L_0x011d:
            if (r3 != 0) goto L_0x0127
            java.lang.String r3 = "jsConstructor"
            r0 = r16
            java.lang.reflect.Method r3 = org.mozilla.javascript.FunctionObject.m5651a(r0, r3)
        L_0x0127:
            if (r3 != 0) goto L_0x015d
            int r4 = r5.length
            r7 = 1
            if (r4 != r7) goto L_0x013d
            r3 = 0
            r3 = r5[r3]
        L_0x0130:
            if (r3 != 0) goto L_0x015d
            java.lang.String r3 = "msg.ctor.multiple.parms"
            java.lang.String r4 = r21.getName()
            org.mozilla.javascript.z r3 = org.mozilla.javascript.Context.m6755a(r3, r4)
            throw r3
        L_0x013d:
            int r4 = r5.length
            r7 = 2
            if (r4 != r7) goto L_0x0130
            r4 = 0
            r4 = r5[r4]
            java.lang.Class[] r4 = r4.getParameterTypes()
            int r4 = r4.length
            if (r4 != 0) goto L_0x014f
            r3 = 1
            r3 = r5[r3]
            goto L_0x0130
        L_0x014f:
            r4 = 1
            r4 = r5[r4]
            java.lang.Class[] r4 = r4.getParameterTypes()
            int r4 = r4.length
            if (r4 != 0) goto L_0x0130
            r3 = 0
            r3 = r5[r3]
            goto L_0x0130
        L_0x015d:
            r10 = r3
            org.mozilla.javascript.ac r14 = new org.mozilla.javascript.ac
            r0 = r20
            r14.<init>(r6, r10, r0)
            int r3 = r14.f5987b
            r4 = -1
            if (r3 != r4) goto L_0x0178
            r3 = 1
        L_0x016b:
            if (r3 == 0) goto L_0x017a
            java.lang.String r3 = "msg.varargs.ctor"
            java.lang.String r4 = r10.getName()
            org.mozilla.javascript.z r3 = org.mozilla.javascript.Context.m6755a(r3, r4)
            throw r3
        L_0x0178:
            r3 = 0
            goto L_0x016b
        L_0x017a:
            r0 = r20
            org.mozilla.javascript.ScriptRuntime.m6379a(r14, r0)
            r14.setImmunePrototypeProperty(r9)
            r9.setParentScope(r14)
            java.lang.String r3 = "constructor"
            r4 = 7
            org.mozilla.javascript.FunctionObject.defineProperty(r9, r3, r14, r4)
            r0 = r20
            r14.setParentScope(r0)
            r11 = 0
            java.util.HashSet r12 = new java.util.HashSet
            r12.<init>()
            java.util.HashSet r13 = new java.util.HashSet
            r13.<init>()
            r0 = r16
            int r0 = r0.length
            r17 = r0
            r3 = 0
            r15 = r3
        L_0x01a2:
            r0 = r17
            if (r15 >= r0) goto L_0x02fb
            r6 = r16[r15]
            if (r6 == r10) goto L_0x0280
            java.lang.String r18 = r6.getName()
            java.lang.String r3 = "finishInit"
            r0 = r18
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x01e4
            java.lang.Class[] r3 = r6.getParameterTypes()
            int r4 = r3.length
            r5 = 3
            if (r4 != r5) goto L_0x01e4
            r4 = 0
            r4 = r3[r4]
            java.lang.Class<org.mozilla.javascript.dr> r5 = org.mozilla.javascript.ScriptRuntime.f6511r
            if (r4 != r5) goto L_0x01e4
            r4 = 1
            r4 = r3[r4]
            java.lang.Class<org.mozilla.javascript.ac> r5 = org.mozilla.javascript.FunctionObject.class
            if (r4 != r5) goto L_0x01e4
            r4 = 2
            r3 = r3[r4]
            java.lang.Class<org.mozilla.javascript.dr> r4 = org.mozilla.javascript.ScriptRuntime.f6511r
            if (r3 != r4) goto L_0x01e4
            int r3 = r6.getModifiers()
            boolean r3 = java.lang.reflect.Modifier.isStatic(r3)
            if (r3 == 0) goto L_0x01e4
        L_0x01df:
            int r3 = r15 + 1
            r15 = r3
            r11 = r6
            goto L_0x01a2
        L_0x01e4:
            r3 = 36
            r0 = r18
            int r3 = r0.indexOf(r3)
            r4 = -1
            if (r3 != r4) goto L_0x0280
            java.lang.String r3 = "jsConstructor"
            r0 = r18
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x0280
            r4 = 0
            r3 = 0
            java.lang.Class<org.mozilla.javascript.a.b> r5 = org.mozilla.javascript.p109a.JSFunction.class
            boolean r5 = r6.isAnnotationPresent(r5)
            if (r5 == 0) goto L_0x023a
            java.lang.Class<org.mozilla.javascript.a.b> r4 = org.mozilla.javascript.p109a.JSFunction.class
            java.lang.annotation.Annotation r4 = r6.getAnnotation(r4)
            r8 = r4
        L_0x020a:
            if (r8 != 0) goto L_0x0218
            java.lang.String r4 = "jsFunction_"
            r0 = r18
            boolean r4 = r0.startsWith(r4)
            if (r4 == 0) goto L_0x0264
            java.lang.String r3 = "jsFunction_"
        L_0x0218:
            boolean r4 = r8 instanceof org.mozilla.javascript.p109a.JSStaticFunction
            if (r4 != 0) goto L_0x0220
            java.lang.String r4 = "jsStaticFunction_"
            if (r3 != r4) goto L_0x0283
        L_0x0220:
            r4 = 1
            r7 = r4
        L_0x0222:
            if (r7 == 0) goto L_0x0286
            r5 = r12
        L_0x0225:
            r0 = r18
            java.lang.String r4 = getPropertyName(r0, r3, r8)
            boolean r19 = r5.contains(r4)
            if (r19 == 0) goto L_0x0288
            java.lang.String r3 = "duplicate.defineClass.name"
            r0 = r18
            org.mozilla.javascript.z r3 = org.mozilla.javascript.Context.m6756a(r3, r0, r4)
            throw r3
        L_0x023a:
            java.lang.Class<org.mozilla.javascript.a.e> r5 = org.mozilla.javascript.p109a.JSStaticFunction.class
            boolean r5 = r6.isAnnotationPresent(r5)
            if (r5 == 0) goto L_0x024a
            java.lang.Class<org.mozilla.javascript.a.e> r4 = org.mozilla.javascript.p109a.JSStaticFunction.class
            java.lang.annotation.Annotation r4 = r6.getAnnotation(r4)
            r8 = r4
            goto L_0x020a
        L_0x024a:
            java.lang.Class<org.mozilla.javascript.a.c> r5 = org.mozilla.javascript.p109a.JSGetter.class
            boolean r5 = r6.isAnnotationPresent(r5)
            if (r5 == 0) goto L_0x025a
            java.lang.Class<org.mozilla.javascript.a.c> r4 = org.mozilla.javascript.p109a.JSGetter.class
            java.lang.annotation.Annotation r4 = r6.getAnnotation(r4)
            r8 = r4
            goto L_0x020a
        L_0x025a:
            java.lang.Class<org.mozilla.javascript.a.d> r5 = org.mozilla.javascript.p109a.JSSetter.class
            boolean r5 = r6.isAnnotationPresent(r5)
            if (r5 != 0) goto L_0x0280
            r8 = r4
            goto L_0x020a
        L_0x0264:
            java.lang.String r4 = "jsStaticFunction_"
            r0 = r18
            boolean r4 = r0.startsWith(r4)
            if (r4 == 0) goto L_0x0271
            java.lang.String r3 = "jsStaticFunction_"
            goto L_0x0218
        L_0x0271:
            java.lang.String r4 = "jsGet_"
            r0 = r18
            boolean r4 = r0.startsWith(r4)
            if (r4 == 0) goto L_0x027e
            java.lang.String r3 = "jsGet_"
            goto L_0x0218
        L_0x027e:
            if (r8 != 0) goto L_0x0218
        L_0x0280:
            r6 = r11
            goto L_0x01df
        L_0x0283:
            r4 = 0
            r7 = r4
            goto L_0x0222
        L_0x0286:
            r5 = r13
            goto L_0x0225
        L_0x0288:
            r5.add(r4)
            boolean r5 = r8 instanceof org.mozilla.javascript.p109a.JSGetter
            if (r5 != 0) goto L_0x0293
            java.lang.String r5 = "jsGet_"
            if (r3 != r5) goto L_0x02bf
        L_0x0293:
            boolean r3 = r9 instanceof org.mozilla.javascript.ScriptableObject
            if (r3 != 0) goto L_0x02a6
            java.lang.String r3 = "msg.extend.scriptable"
            java.lang.Class r5 = r9.getClass()
            java.lang.String r5 = r5.toString()
            org.mozilla.javascript.z r3 = org.mozilla.javascript.Context.m6756a(r3, r5, r4)
            throw r3
        L_0x02a6:
            java.lang.String r3 = "jsSet_"
            r0 = r16
            java.lang.reflect.Method r7 = findSetterMethod(r0, r4, r3)
            if (r7 == 0) goto L_0x02bd
            r3 = 0
        L_0x02b1:
            r8 = r3 | 6
            r3 = r9
            org.mozilla.javascript.ds r3 = (org.mozilla.javascript.ScriptableObject) r3
            r5 = 0
            r3.defineProperty(r4, r5, r6, r7, r8)
            r6 = r11
            goto L_0x01df
        L_0x02bd:
            r3 = 1
            goto L_0x02b1
        L_0x02bf:
            if (r7 == 0) goto L_0x02d2
            int r3 = r6.getModifiers()
            boolean r3 = java.lang.reflect.Modifier.isStatic(r3)
            if (r3 != 0) goto L_0x02d2
            java.lang.String r3 = "jsStaticFunction must be used with static method."
            org.mozilla.javascript.z r3 = org.mozilla.javascript.Context.m6765c(r3)
            throw r3
        L_0x02d2:
            org.mozilla.javascript.ac r5 = new org.mozilla.javascript.ac
            r5.<init>(r4, r6, r9)
            int r3 = r5.f5987b
            r6 = -2
            if (r3 != r6) goto L_0x02ea
            r3 = 1
        L_0x02dd:
            if (r3 == 0) goto L_0x02ec
            java.lang.String r3 = "msg.varargs.fun"
            java.lang.String r4 = r10.getName()
            org.mozilla.javascript.z r3 = org.mozilla.javascript.Context.m6755a(r3, r4)
            throw r3
        L_0x02ea:
            r3 = 0
            goto L_0x02dd
        L_0x02ec:
            if (r7 == 0) goto L_0x02f9
            r3 = r14
        L_0x02ef:
            r6 = 2
            defineProperty(r3, r4, r5, r6)
            if (r22 == 0) goto L_0x0280
            r5.sealObject()
            goto L_0x0280
        L_0x02f9:
            r3 = r9
            goto L_0x02ef
        L_0x02fb:
            if (r11 == 0) goto L_0x030d
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r20
            r4 = 1
            r3[r4] = r14
            r4 = 2
            r3[r4] = r9
            r4 = 0
            r11.invoke(r4, r3)
        L_0x030d:
            if (r22 == 0) goto L_0x031b
            r14.sealObject()
            boolean r3 = r9 instanceof org.mozilla.javascript.ScriptableObject
            if (r3 == 0) goto L_0x031b
            org.mozilla.javascript.ds r9 = (org.mozilla.javascript.ScriptableObject) r9
            r9.sealObject()
        L_0x031b:
            r4 = r14
            goto L_0x0058
        L_0x031e:
            r3 = r4
            goto L_0x0094
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptableObject.buildClassCtor(org.mozilla.javascript.dr, java.lang.Class, boolean, boolean):org.mozilla.javascript.b");
    }

    private static Member findAnnotatedMember(AccessibleObject[] accessibleObjectArr, Class<? extends Annotation> cls) {
        for (AccessibleObject accessibleObject : accessibleObjectArr) {
            if (accessibleObject.isAnnotationPresent(cls)) {
                return (Member) accessibleObject;
            }
        }
        return null;
    }

    private static Method findSetterMethod(Method[] methodArr, String str, String str2) {
        String str3 = "set" + Character.toUpperCase(str.charAt(0)) + str.substring(1);
        for (Method method : methodArr) {
            JSSetter dVar = (JSSetter) method.getAnnotation(JSSetter.class);
            if (dVar != null && (str.equals(dVar.mo18628a()) || ("".equals(dVar.mo18628a()) && str3.equals(method.getName())))) {
                return method;
            }
        }
        String str4 = str2 + str;
        for (Method method2 : methodArr) {
            if (str4.equals(method2.getName())) {
                return method2;
            }
        }
        return null;
    }

    private static String getPropertyName(String str, String str2, Annotation annotation) {
        if (str2 != null) {
            return str.substring(str2.length());
        }
        String str3 = null;
        if (annotation instanceof JSGetter) {
            str3 = ((JSGetter) annotation).mo18627a();
            if ((str3 == null || str3.length() == 0) && str.length() > 3 && str.startsWith("get")) {
                str3 = str.substring(3);
                if (Character.isUpperCase(str3.charAt(0))) {
                    if (str3.length() == 1) {
                        str3 = str3.toLowerCase();
                    } else if (!Character.isUpperCase(str3.charAt(1))) {
                        str3 = Character.toLowerCase(str3.charAt(0)) + str3.substring(1);
                    }
                }
            }
        } else if (annotation instanceof JSFunction) {
            str3 = ((JSFunction) annotation).mo18626a();
        } else if (annotation instanceof JSStaticFunction) {
            str3 = ((JSStaticFunction) annotation).mo18629a();
        }
        if (str3 == null || str3.length() == 0) {
            return str;
        }
        return str3;
    }

    private static <T extends Scriptable> Class<T> extendsScriptable(Class<?> cls) {
        if (ScriptRuntime.f6511r.isAssignableFrom(cls)) {
            return (Class<T>) cls;
        }
        return null;
    }

    public void defineProperty(String str, Object obj, int i) {
        checkNotSealed(str, 0);
        put(str, (Scriptable) this, obj);
        setAttributes(str, i);
    }

    public static void defineProperty(Scriptable drVar, String str, Object obj, int i) {
        if (!(drVar instanceof ScriptableObject)) {
            drVar.put(str, drVar, obj);
        } else {
            ((ScriptableObject) drVar).defineProperty(str, obj, i);
        }
    }

    public static void defineConstProperty(Scriptable drVar, String str) {
        if (drVar instanceof ConstProperties) {
            ((ConstProperties) drVar).defineConst(str, drVar);
        } else {
            defineProperty(drVar, str, Undefined.f6689a, 13);
        }
    }

    public void defineProperty(String str, Class<?> cls, int i) {
        int i2;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException();
        }
        char[] cArr = new char[(length + 3)];
        str.getChars(0, length, cArr, 3);
        cArr[3] = Character.toUpperCase(cArr[3]);
        cArr[0] = 'g';
        cArr[1] = 'e';
        cArr[2] = 't';
        String str2 = new String(cArr);
        cArr[0] = 's';
        String str3 = new String(cArr);
        Method[] b = FunctionObject.m5652b(cls);
        Method a = FunctionObject.m5651a(b, str2);
        Method a2 = FunctionObject.m5651a(b, str3);
        if (a2 == null) {
            i2 = i | 1;
        } else {
            i2 = i;
        }
        if (a2 == null) {
            a2 = null;
        }
        defineProperty(str, null, a, a2, i2);
    }

    public void defineProperty(String str, Object obj, Method method, Method method2, int i) {
        MemberBox bbVar;
        boolean z;
        boolean z2;
        String str2;
        String str3 = null;
        if (method != null) {
            MemberBox bbVar2 = new MemberBox(method);
            if (!Modifier.isStatic(method.getModifiers())) {
                z2 = obj != null;
                bbVar2.f6280c = obj;
            } else {
                bbVar2.f6280c = Void.TYPE;
                z2 = true;
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 0) {
                if (z2) {
                    str2 = "msg.obj.getter.parms";
                }
                str2 = null;
            } else {
                if (parameterTypes.length == 1) {
                    Class<?> cls = parameterTypes[0];
                    if (cls == ScriptRuntime.f6511r || cls == ScriptRuntime.f6510q) {
                        if (!z2) {
                            str2 = "msg.bad.getter.parms";
                        }
                        str2 = null;
                    }
                }
                str2 = "msg.bad.getter.parms";
            }
            if (str2 != null) {
                throw Context.m6755a(str2, (Object) method.toString());
            }
            bbVar = bbVar2;
        } else {
            bbVar = null;
        }
        if (method2 != null) {
            if (method2.getReturnType() != Void.TYPE) {
                throw Context.m6755a("msg.setter.return", (Object) method2.toString());
            }
            MemberBox bbVar3 = new MemberBox(method2);
            if (!Modifier.isStatic(method2.getModifiers())) {
                z = obj != null;
                bbVar3.f6280c = obj;
            } else {
                bbVar3.f6280c = Void.TYPE;
                z = true;
            }
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            if (parameterTypes2.length == 1) {
                if (z) {
                    str3 = "msg.setter2.expected";
                }
            } else if (parameterTypes2.length == 2) {
                Class<?> cls2 = parameterTypes2[0];
                if (cls2 != ScriptRuntime.f6511r && cls2 != ScriptRuntime.f6510q) {
                    str3 = "msg.setter2.parms";
                } else if (!z) {
                    str3 = "msg.setter1.parms";
                }
            } else {
                str3 = "msg.setter.parms";
            }
//            if (str3 != 0) {
//                throw Context.m6755a(str3, (Object) method2.toString());
//            }
//            str3 = bbVar3;
        }
        C2179dt dtVar = (C2179dt) getSlot(str, 0, 4);
        dtVar.mo19061a(i);
        dtVar.f6534a = bbVar;
        dtVar.f6535b = str3;
    }

    public void defineOwnProperties(Context lVar, ScriptableObject dsVar) {
        Object[] ids = dsVar.getIds();
        for (Object obj : ids) {
            checkPropertyDefinition(ensureScriptableObject(dsVar.get(obj)));
        }
        for (Object obj2 : ids) {
            defineOwnProperty(lVar, obj2, (ScriptableObject) dsVar.get(obj2));
        }
    }

    public void defineOwnProperty(Context lVar, Object obj, ScriptableObject dsVar) {
        checkPropertyDefinition(dsVar);
        defineOwnProperty(lVar, obj, dsVar, true);
    }

    /* access modifiers changed from: protected */
    public void defineOwnProperty(Context lVar, Object obj, ScriptableObject dsVar, boolean z) {
        C2181dv dvVar;
        int applyDescriptorToAttributeBitset;
        C2181dv slot = getSlot(lVar, obj, 1);
        boolean z2 = slot == null;
        if (z) {
            checkPropertyChange(ScriptRuntime.m6436d(obj), slot == null ? null : slot.mo19058a(lVar, this), dsVar);
        }
        boolean isAccessorDescriptor = isAccessorDescriptor(dsVar);
        if (slot == null) {
            dvVar = getSlot(lVar, obj, isAccessorDescriptor ? 4 : 2);
            applyDescriptorToAttributeBitset = applyDescriptorToAttributeBitset(7, dsVar);
        } else {
            dvVar = slot;
            applyDescriptorToAttributeBitset = applyDescriptorToAttributeBitset(slot.mo19062b(), dsVar);
        }
        C2181dv unwrapSlot = unwrapSlot(dvVar);
        if (isAccessorDescriptor) {
            if (!(unwrapSlot instanceof C2179dt)) {
                unwrapSlot = getSlot(lVar, obj, 4);
            }
            C2179dt dtVar = (C2179dt) unwrapSlot;
            Object property = getProperty((Scriptable) dsVar, "get");
            if (property != f6533j) {
                dtVar.f6534a = property;
            }
            Object property2 = getProperty((Scriptable) dsVar, "set");
            if (property2 != f6533j) {
                dtVar.f6535b = property2;
            }
            dtVar.f6541g = Undefined.f6689a;
            dtVar.mo19061a(applyDescriptorToAttributeBitset);
            return;
        }
        if ((unwrapSlot instanceof C2179dt) && isDataDescriptor(dsVar)) {
            unwrapSlot = getSlot(lVar, obj, 5);
        }
        Object property3 = getProperty((Scriptable) dsVar, "value");
        if (property3 != f6533j) {
            unwrapSlot.f6541g = property3;
        } else if (z2) {
            unwrapSlot.f6541g = Undefined.f6689a;
        }
        unwrapSlot.mo19061a(applyDescriptorToAttributeBitset);
    }

    /* access modifiers changed from: protected */
    public void checkPropertyDefinition(ScriptableObject dsVar) {
        Object property = getProperty((Scriptable) dsVar, "get");
        if (property == f6533j || property == Undefined.f6689a || (property instanceof Callable)) {
            Object property2 = getProperty((Scriptable) dsVar, "set");
            if (property2 != f6533j && property2 != Undefined.f6689a && !(property2 instanceof Callable)) {
                throw ScriptRuntime.m6474o(property2);
            } else if (isDataDescriptor(dsVar) && isAccessorDescriptor(dsVar)) {
                throw ScriptRuntime.m6455g("msg.both.data.and.accessor.desc");
            }
        } else {
            throw ScriptRuntime.m6474o(property);
        }
    }

    /* access modifiers changed from: protected */
    public void checkPropertyChange(String str, ScriptableObject dsVar, ScriptableObject dsVar2) {
        if (dsVar == null) {
            if (!isExtensible()) {
                throw ScriptRuntime.m6455g("msg.not.extensible");
            }
        } else if (!isFalse(dsVar.get("configurable", (Scriptable) dsVar))) {
        } else {
            if (isTrue(getProperty((Scriptable) dsVar2, "configurable"))) {
                throw ScriptRuntime.m6414b("msg.change.configurable.false.to.true", str);
            } else if (isTrue(dsVar.get("enumerable", (Scriptable) dsVar)) != isTrue(getProperty((Scriptable) dsVar2, "enumerable"))) {
                throw ScriptRuntime.m6414b("msg.change.enumerable.with.configurable.false", str);
            } else {
                boolean isDataDescriptor = isDataDescriptor(dsVar2);
                boolean isAccessorDescriptor = isAccessorDescriptor(dsVar2);
                if (!isDataDescriptor && !isAccessorDescriptor) {
                    return;
                }
                if (!isDataDescriptor || !isDataDescriptor(dsVar)) {
                    if (!isAccessorDescriptor || !isAccessorDescriptor(dsVar)) {
                        if (isDataDescriptor(dsVar)) {
                            throw ScriptRuntime.m6414b("msg.change.property.data.to.accessor.with.configurable.false", str);
                        }
                        throw ScriptRuntime.m6414b("msg.change.property.accessor.to.data.with.configurable.false", str);
                    } else if (!sameValue(getProperty((Scriptable) dsVar2, "set"), dsVar.get("set", (Scriptable) dsVar))) {
                        throw ScriptRuntime.m6414b("msg.change.setter.with.configurable.false", str);
                    } else if (!sameValue(getProperty((Scriptable) dsVar2, "get"), dsVar.get("get", (Scriptable) dsVar))) {
                        throw ScriptRuntime.m6414b("msg.change.getter.with.configurable.false", str);
                    }
                } else if (!isFalse(dsVar.get("writable", (Scriptable) dsVar))) {
                } else {
                    if (isTrue(getProperty((Scriptable) dsVar2, "writable"))) {
                        throw ScriptRuntime.m6414b("msg.change.writable.false.to.true.with.configurable.false", str);
                    } else if (!sameValue(getProperty((Scriptable) dsVar2, "value"), dsVar.get("value", (Scriptable) dsVar))) {
                        throw ScriptRuntime.m6414b("msg.change.value.with.writable.false", str);
                    }
                }
            }
        }
    }

    protected static boolean isTrue(Object obj) {
        return obj != f6533j && ScriptRuntime.m6391a(obj);
    }

    protected static boolean isFalse(Object obj) {
        return !isTrue(obj);
    }

    /* access modifiers changed from: protected */
    public boolean sameValue(Object obj, Object obj2) {
        Object obj3;
        if (obj == f6533j) {
            return true;
        }
        if (obj2 == f6533j) {
            obj3 = Undefined.f6689a;
        } else {
            obj3 = obj2;
        }
        if ((obj3 instanceof Number) && (obj instanceof Number)) {
            double doubleValue = ((Number) obj3).doubleValue();
            double doubleValue2 = ((Number) obj).doubleValue();
            if (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2)) {
                return true;
            }
            if (doubleValue == 0.0d && Double.doubleToLongBits(doubleValue) != Double.doubleToLongBits(doubleValue2)) {
                return false;
            }
        }
        return ScriptRuntime.m6430c(obj3, obj);
    }

    /* access modifiers changed from: protected */
    public int applyDescriptorToAttributeBitset(int i, ScriptableObject dsVar) {
        Object property = getProperty((Scriptable) dsVar, "enumerable");
        int i2 = property != f6533j ? ScriptRuntime.m6391a(property) ? i & -3 : i | 2 : i;
        Object property2 = getProperty((Scriptable) dsVar, "writable");
        if (property2 != f6533j) {
            i2 = ScriptRuntime.m6391a(property2) ? i2 & -2 : i2 | 1;
        }
        Object property3 = getProperty((Scriptable) dsVar, "configurable");
        if (property3 != f6533j) {
            return ScriptRuntime.m6391a(property3) ? i2 & -5 : i2 | 4;
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public boolean isDataDescriptor(ScriptableObject dsVar) {
        return hasProperty((Scriptable) dsVar, "value") || hasProperty((Scriptable) dsVar, "writable");
    }

    /* access modifiers changed from: protected */
    public boolean isAccessorDescriptor(ScriptableObject dsVar) {
        return hasProperty((Scriptable) dsVar, "get") || hasProperty((Scriptable) dsVar, "set");
    }

    /* access modifiers changed from: protected */
    public boolean isGenericDescriptor(ScriptableObject dsVar) {
        return !isDataDescriptor(dsVar) && !isAccessorDescriptor(dsVar);
    }

    protected static Scriptable ensureScriptable(Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        throw ScriptRuntime.m6414b("msg.arg.not.object", ScriptRuntime.m6469l(obj));
    }

    protected static ScriptableObject ensureScriptableObject(Object obj) {
        if (obj instanceof ScriptableObject) {
            return (ScriptableObject) obj;
        }
        throw ScriptRuntime.m6414b("msg.arg.not.object", ScriptRuntime.m6469l(obj));
    }

    public void defineFunctionProperties(String[] strArr, Class<?> cls, int i) {
        Method[] b = FunctionObject.m5652b(cls);
        for (String str : strArr) {
            Method a = FunctionObject.m5651a(b, str);
            if (a == null) {
                throw Context.m6756a("msg.method.not.found", (Object) str, (Object) cls.getName());
            }
            defineProperty(str, (Object) new FunctionObject(str, a, this), i);
        }
    }

    public static Scriptable getObjectPrototype(Scriptable drVar) {
        return TopLevel.m6647a(getTopLevelScope(drVar), C2193eh.Object);
    }

    public static Scriptable getFunctionPrototype(Scriptable drVar) {
        return TopLevel.m6647a(getTopLevelScope(drVar), C2193eh.Function);
    }

    public static Scriptable getArrayPrototype(Scriptable drVar) {
        return TopLevel.m6647a(getTopLevelScope(drVar), C2193eh.Array);
    }

    public static Scriptable getClassPrototype(Scriptable drVar, String str) {
        Object obj;
        Object property = getProperty(getTopLevelScope(drVar), str);
        if (property instanceof BaseFunction) {
            obj = ((BaseFunction) property).getPrototypeProperty();
        } else if (!(property instanceof Scriptable)) {
            return null;
        } else {
            Scriptable drVar2 = (Scriptable) property;
            obj = drVar2.get("prototype", drVar2);
        }
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        return null;
    }

    public static Scriptable getTopLevelScope(Scriptable drVar) {
        while (true) {
            Scriptable parentScope = drVar.getParentScope();
            if (parentScope == null) {
                return drVar;
            }
            drVar = parentScope;
        }
    }

    public boolean isExtensible() {
        return this.isExtensible;
    }

    public void preventExtensions() {
        this.isExtensible = false;
    }

    public synchronized void sealObject() {
        if (this.count >= 0) {
            for (C2181dv dvVar = this.firstAdded; dvVar != null; dvVar = dvVar.f6543i) {
                Object obj = dvVar.f6541g;
                if (obj instanceof LazilyLoadedCtor) {
                    LazilyLoadedCtor azVar = (LazilyLoadedCtor) obj;
                    try {
                        azVar.mo18706a();
                        dvVar.f6541g = azVar.mo18707b();
                    } catch (Throwable th) {
                        dvVar.f6541g = azVar.mo18707b();
                        throw th;
                    }
                }
            }
            this.count ^= -1;
        }
    }

    public final boolean isSealed() {
        return this.count < 0;
    }

    private void checkNotSealed(String str, int i) {
        if (isSealed()) {
            if (str == null) {
                str = Integer.toString(i);
            }
            throw Context.m6755a("msg.modify.sealed", (Object) str);
        }
    }

    public static Object getProperty(Scriptable drVar, String str) {
        Object obj;
        Scriptable drVar2 = drVar;
        do {
            obj = drVar2.get(str, drVar);
            if (obj != Scriptable.f6533j) {
                break;
            }
            drVar2 = drVar2.getPrototype();
        } while (drVar2 != null);
        return obj;
    }

    public static <T> T getTypedProperty(Scriptable drVar, int i, Class<T> cls) {
        Object property = getProperty(drVar, i);
        if (property == Scriptable.f6533j) {
            property = null;
        }
        return cls.cast(Context.m6742a(property, cls));
    }

    public static Object getProperty(Scriptable drVar, int i) {
        Object obj;
        Scriptable drVar2 = drVar;
        do {
            obj = drVar2.get(i, drVar);
            if (obj != Scriptable.f6533j) {
                break;
            }
            drVar2 = drVar2.getPrototype();
        } while (drVar2 != null);
        return obj;
    }

    public static <T> T getTypedProperty(Scriptable drVar, String str, Class<T> cls) {
        Object property = getProperty(drVar, str);
        if (property == Scriptable.f6533j) {
            property = null;
        }
        return cls.cast(Context.m6742a(property, cls));
    }

    public static boolean hasProperty(Scriptable drVar, String str) {
        return getBase(drVar, str) != null;
    }

    public static void redefineProperty(Scriptable drVar, String str, boolean z) {
        Scriptable base = getBase(drVar, str);
        if (base != null) {
            if ((base instanceof ConstProperties) && ((ConstProperties) base).isConst(str)) {
                throw Context.m6755a("msg.const.redecl", (Object) str);
            } else if (z) {
                throw Context.m6755a("msg.var.redecl", (Object) str);
            }
        }
    }

    public static boolean hasProperty(Scriptable drVar, int i) {
        return getBase(drVar, i) != null;
    }

    public static void putProperty(Scriptable drVar, String str, Object obj) {
        Scriptable base = getBase(drVar, str);
        if (base == null) {
            base = drVar;
        }
        base.put(str, drVar, obj);
    }

    public static void putConstProperty(Scriptable drVar, String str, Object obj) {
        Scriptable base = getBase(drVar, str);
        if (base == null) {
            base = drVar;
        }
        if (base instanceof ConstProperties) {
            ((ConstProperties) base).putConst(str, drVar, obj);
        }
    }

    public static void putProperty(Scriptable drVar, int i, Object obj) {
        Scriptable base = getBase(drVar, i);
        if (base == null) {
            base = drVar;
        }
        base.put(i, drVar, obj);
    }

    public static boolean deleteProperty(Scriptable drVar, String str) {
        Scriptable base = getBase(drVar, str);
        if (base == null) {
            return true;
        }
        base.delete(str);
        if (base.has(str, drVar)) {
            return false;
        }
        return true;
    }

    public static boolean deleteProperty(Scriptable drVar, int i) {
        Scriptable base = getBase(drVar, i);
        if (base == null) {
            return true;
        }
        base.delete(i);
        if (base.has(i, drVar)) {
            return false;
        }
        return true;
    }

    public static Object[] getPropertyIds(Scriptable drVar) {
        int i;
        Object[] objArr = new Object[0];
        if (drVar == null) {
            return ScriptRuntime.f6517x;
        }
        Object[] ids = drVar.getIds();
        ObjToIntMap crVar = null;
        while (true) {
            drVar = drVar.getPrototype();
            if (drVar == null) {
                break;
            }
            Object[] ids2 = drVar.getIds();
            if (ids2.length != 0) {
                if (crVar != null) {
                    objArr = ids;
                } else if (ids.length == 0) {
                    ids = ids2;
                } else {
                    ObjToIntMap crVar2 = new ObjToIntMap(ids.length + ids2.length);
                    for (int i2 = 0; i2 != ids.length; i2++) {
                        crVar2.mo18967b(ids[i2]);
                    }
                    crVar = crVar2;
                    objArr = null;
                }
                for (int i3 = 0; i3 != ids2.length; i3++) {
                    crVar.mo18967b(ids2[i3]);
                }
                ids = objArr;
            }
        }
        if (crVar == null) {
            return ids;
        }
        Object[] objArr2 = new Object[crVar.f6418d];
        int i4 = crVar.f6418d;
        int i5 = 0;
        int i6 = 0;
        while (i4 != 0) {
            Object obj = crVar.f6416b[i5];
            if (obj == null || obj == ObjToIntMap.f6415a) {
                i = i4;
            } else {
                if (obj == UniqueTag.f6691b) {
                    obj = null;
                }
                objArr2[i6] = obj;
                i6++;
                i = i4 - 1;
            }
            i5++;
            i6 = i6;
            i4 = i;
        }
        return objArr2;
    }

    public static Object callMethod(Scriptable drVar, String str, Object[] objArr) {
        return callMethod(null, drVar, str, objArr);
    }

    public static Object callMethod(Context lVar, Scriptable drVar, String str, Object[] objArr) {
        Object property = getProperty(drVar, str);
        if (!(property instanceof Function)) {
            throw ScriptRuntime.m6457h(drVar, str);
        }
        Function abVar = (Function) property;
        Scriptable topLevelScope = getTopLevelScope(drVar);
        if (lVar != null) {
            return abVar.call(lVar, topLevelScope, drVar, objArr);
        }
        return Context.m6744a((Callable) abVar, topLevelScope, drVar, objArr);
    }

    private static Scriptable getBase(Scriptable drVar, String str) {
        while (!drVar.has(str, drVar)) {
            drVar = drVar.getPrototype();
            if (drVar == null) {
                break;
            }
        }
        return drVar;
    }

    private static Scriptable getBase(Scriptable drVar, int i) {
        while (!drVar.has(i, drVar)) {
            drVar = drVar.getPrototype();
            if (drVar == null) {
                break;
            }
        }
        return drVar;
    }

    public final Object getAssociatedValue(Object obj) {
        Map<Object, Object> map = this.associatedValues;
        if (map == null) {
            return null;
        }
        return map.get(obj);
    }

    public static Object getTopScopeValue(Scriptable drVar, Object obj) {
        Scriptable topLevelScope = getTopLevelScope(drVar);
        do {
            if (topLevelScope instanceof ScriptableObject) {
                Object associatedValue = ((ScriptableObject) topLevelScope).getAssociatedValue(obj);
                if (associatedValue != null) {
                    return associatedValue;
                }
            }
            topLevelScope = topLevelScope.getPrototype();
        } while (topLevelScope != null);
        return null;
    }

    public final synchronized Object associateValue(Object obj, Object obj2) {
        Map map;
        if (obj2 == null) {
            throw new IllegalArgumentException();
        }
        map = this.associatedValues;
        if (map == null) {
            map = new HashMap();
            this.associatedValues = map;
        }
        return Kit.m5809a(map, obj, obj2);
    }

    private boolean putImpl(String str, int i, Scriptable drVar, Object obj) {
        C2181dv dvVar;
        if (this != drVar) {
            dvVar = getSlot(str, i, 1);
            if (dvVar == null) {
                return false;
            }
        } else if (!this.isExtensible) {
            dvVar = getSlot(str, i, 1);
            if (dvVar == null) {
                return true;
            }
        } else {
            if (this.count < 0) {
                checkNotSealed(str, i);
            }
            dvVar = getSlot(str, i, 2);
        }
        return dvVar.mo19060a(obj, this, drVar);
    }

    private boolean putConstImpl(String str, int i, Scriptable drVar, Object obj, int i2) {
        C2181dv dvVar;
        if ($assertionsDisabled || i2 != 0) {
            if (this != drVar) {
                dvVar = getSlot(str, i, 1);
                if (dvVar == null) {
                    return false;
                }
            } else if (!isExtensible()) {
                dvVar = getSlot(str, i, 1);
                if (dvVar == null) {
                    return true;
                }
            } else {
                checkNotSealed(str, i);
                C2181dv unwrapSlot = unwrapSlot(getSlot(str, i, 3));
                int b = unwrapSlot.mo19062b();
                if ((b & 1) == 0) {
                    throw Context.m6755a("msg.var.redecl", (Object) str);
                }
                if ((b & 8) != 0) {
                    unwrapSlot.f6541g = obj;
                    if (i2 != 8) {
                        unwrapSlot.mo19061a(b & -9);
                    }
                }
                return true;
            }
            return dvVar.mo19060a(obj, this, drVar);
        }
        throw new AssertionError();
    }

    private C2181dv findAttributeSlot(String str, int i, int i2) {
        C2181dv slot = getSlot(str, i, i2);
        if (slot != null) {
            return slot;
        }
        if (str == null) {
            str = Integer.toString(i);
        }
        throw Context.m6755a("msg.prop.not.found", (Object) str);
    }

    /* access modifiers changed from: private */
    public static C2181dv unwrapSlot(C2181dv dvVar) {
        return dvVar instanceof C2180du ? ((C2180du) dvVar).f6536a : dvVar;
    }

    private C2181dv getSlot(String str, int i, int i2) {
        C2181dv[] dvVarArr = this.slots;
        if (dvVarArr == null && i2 == 1) {
            return null;
        }
        if (str != null) {
            i = str.hashCode();
        }
        if (dvVarArr != null) {
            C2181dv dvVar = dvVarArr[getSlotIndex(dvVarArr.length, i)];
            while (dvVar != null) {
                String str2 = dvVar.f6537c;
                if (i == dvVar.f6538d && (str2 == str || (str != null && str.equals(str2)))) {
                    break;
                }
                dvVar = dvVar.f6542h;
            }
            switch (i2) {
                case 1:
                    return dvVar;
                case 2:
                case 3:
                    if (dvVar != null) {
                        return dvVar;
                    }
                    break;
                case 4:
                    C2181dv unwrapSlot = unwrapSlot(dvVar);
                    if (unwrapSlot instanceof C2179dt) {
                        return unwrapSlot;
                    }
                    break;
                case 5:
                    C2181dv unwrapSlot2 = unwrapSlot(dvVar);
                    if (!(unwrapSlot2 instanceof C2179dt)) {
                        return unwrapSlot2;
                    }
                    break;
            }
        }
        return createSlot(str, i, i2);
    }

    private synchronized C2181dv createSlot(String str, int i, int i2) {
        int i3 = 0;
        C2181dv[] dvVarArr = new C2181dv[0];
        C2181dv dvVar = null;
        C2181dv dvVar2;
        C2181dv[] dvVarArr2 = this.slots;
        if (this.count == 0) {
            C2181dv[] dvVarArr3 = new C2181dv[4];
            this.slots = dvVarArr3;
            dvVarArr = dvVarArr3;
            i3 = getSlotIndex(4, i);
        } else {
            int slotIndex = getSlotIndex(dvVarArr2.length, i);
            C2181dv dvVar3 = dvVarArr2[slotIndex];
            C2181dv dvVar4 = dvVar3;
            C2181dv dvVar5 = dvVar3;
            while (dvVar4 != null && (dvVar4.f6538d != i || (dvVar4.f6537c != str && (str == null || !str.equals(dvVar4.f6537c))))) {
                dvVar5 = dvVar4;
                dvVar4 = dvVar4.f6542h;
            }
            if (dvVar4 != null) {
                C2181dv unwrapSlot = unwrapSlot(dvVar4);
                if (i2 != 4 || (unwrapSlot instanceof C2179dt)) {
                    if (i2 == 5) {
                        if (unwrapSlot instanceof C2179dt) {
                            dvVar2 = new C2181dv(str, i, unwrapSlot.mo19062b());
                        }
                    }
                    dvVar = i2 == 3 ? null : unwrapSlot;
                } else {
                    dvVar2 = new C2179dt(str, i, unwrapSlot.mo19062b());
                }
                dvVar.f6541g = unwrapSlot.f6541g;
                dvVar.f6542h = dvVar4.f6542h;
                if (this.lastAdded != null) {
                    this.lastAdded.f6543i = dvVar;
                }
                if (this.firstAdded == null) {
                    this.firstAdded = dvVar;
                }
                this.lastAdded = dvVar;
                if (dvVar5 == dvVar4) {
                    dvVarArr2[slotIndex] = dvVar;
                } else {
                    dvVar5.f6542h = dvVar;
                }
                dvVar4.mo19059a();
            } else if ((this.count + 1) * 4 > dvVarArr2.length * 3) {
                C2181dv[] dvVarArr4 = new C2181dv[(dvVarArr2.length * 2)];
                copyTable(this.slots, dvVarArr4, this.count);
                this.slots = dvVarArr4;
                dvVarArr = dvVarArr4;
                i3 = getSlotIndex(dvVarArr4.length, i);
            } else {
                i3 = slotIndex;
                dvVarArr = dvVarArr2;
            }
        }
        dvVar = i2 == 4 ? new C2179dt(str, i, 0) : new C2181dv(str, i, 0);
        if (i2 == 3) {
            dvVar.mo19061a(13);
        }
        this.count++;
        if (this.lastAdded != null) {
            this.lastAdded.f6543i = dvVar;
        }
        if (this.firstAdded == null) {
            this.firstAdded = dvVar;
        }
        this.lastAdded = dvVar;
        addKnownAbsentSlot(dvVarArr, dvVar, i3);
        return dvVar;
    }

    private synchronized void removeSlot(String str, int i) {
        C2181dv dvVar;
        if (str != null) {
            i = str.hashCode();
        }
        C2181dv[] dvVarArr = this.slots;
        if (this.count != 0) {
            int slotIndex = getSlotIndex(dvVarArr.length, i);
            C2181dv dvVar2 = dvVarArr[slotIndex];
            C2181dv dvVar3 = dvVar2;
            while (dvVar3 != null && (dvVar3.f6538d != i || (dvVar3.f6537c != str && (str == null || !str.equals(dvVar3.f6537c))))) {
                dvVar2 = dvVar3;
                dvVar3 = dvVar3.f6542h;
            }
            if (dvVar3 != null && (dvVar3.mo19062b() & 4) == 0) {
                this.count--;
                if (dvVar2 == dvVar3) {
                    dvVarArr[slotIndex] = dvVar3.f6542h;
                } else {
                    dvVar2.f6542h = dvVar3.f6542h;
                }
                C2181dv unwrapSlot = unwrapSlot(dvVar3);
                if (unwrapSlot == this.firstAdded) {
                    dvVar = null;
                    this.firstAdded = unwrapSlot.f6543i;
                } else {
                    dvVar = this.firstAdded;
                    while (dvVar.f6543i != unwrapSlot) {
                        dvVar = dvVar.f6543i;
                    }
                    dvVar.f6543i = unwrapSlot.f6543i;
                }
                if (unwrapSlot == this.lastAdded) {
                    this.lastAdded = dvVar;
                }
                dvVar3.mo19059a();
            }
        }
    }

    private static int getSlotIndex(int i, int i2) {
        return (i - 1) & i2;
    }

    private static void copyTable(C2181dv[] dvVarArr, C2181dv[] dvVarArr2, int i) {
        if (i == 0) {
            throw Kit.m5810a();
        }
        int length = dvVarArr2.length;
        int length2 = dvVarArr.length;
        while (true) {
            length2--;
            C2181dv dvVar = dvVarArr[length2];
            while (true) {
                if (dvVar != null) {
                    addKnownAbsentSlot(dvVarArr2, dvVar.f6542h == null ? dvVar : new C2180du(dvVar), getSlotIndex(length, dvVar.f6538d));
                    dvVar = dvVar.f6542h;
                    i--;
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    private static void addKnownAbsentSlot(C2181dv[] dvVarArr, C2181dv dvVar, int i) {
        if (dvVarArr[i] == null) {
            dvVarArr[i] = dvVar;
            return;
        }
        C2181dv dvVar2 = dvVarArr[i];
        for (C2181dv dvVar3 = dvVar2.f6542h; dvVar3 != null; dvVar3 = dvVar3.f6542h) {
            dvVar2 = dvVar3;
        }
        dvVar2.f6542h = dvVar;
    }

    /* access modifiers changed from: 0000 */
    public Object[] getIds(boolean z) {
        Object[] objArr;
        int i;
        C2181dv dvVar;
        C2181dv[] dvVarArr = this.slots;
        Object[] objArr2 = ScriptRuntime.f6517x;
        if (dvVarArr == null) {
            return objArr2;
        }
        C2181dv dvVar2 = this.firstAdded;
        while (dvVar2 != null && dvVar2.f6540f) {
            dvVar2 = dvVar2.f6543i;
        }
        int i2 = 0;
        while (dvVar2 != null) {
            if (z || (dvVar2.mo19062b() & 2) == 0) {
                if (i2 == 0) {
                    objArr2 = new Object[dvVarArr.length];
                }
                int i3 = i2 + 1;
                objArr2[i2] = dvVar2.f6537c != null ? dvVar2.f6537c : Integer.valueOf(dvVar2.f6538d);
                i = i3;
                C2181dv dvVar3 = dvVar2;
                objArr = objArr2;
                dvVar = dvVar3;
            } else {
                i = i2;
                C2181dv dvVar4 = dvVar2;
                objArr = objArr2;
                dvVar = dvVar4;
            }
            do {
                dvVar = dvVar.f6543i;
                if (dvVar == null) {
                    break;
                }
            } while (dvVar.f6540f);
            i2 = i;
            C2181dv dvVar5 = dvVar;
            objArr2 = objArr;
            dvVar2 = dvVar5;
        }
        if (i2 == objArr2.length) {
            return objArr2;
        }
        Object[] objArr3 = new Object[i2];
        System.arraycopy(objArr2, 0, objArr3, 0, i2);
        return objArr3;
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int i = this.count;
        if (i < 0) {
            i ^= -1;
        }
        if (i == 0) {
            objectOutputStream.writeInt(0);
        } else {
            objectOutputStream.writeInt(this.slots.length);
            C2181dv dvVar = this.firstAdded;
            while (dvVar != null && dvVar.f6540f) {
                dvVar = dvVar.f6543i;
            }
            this.firstAdded = dvVar;
            C2181dv dvVar2 = dvVar;
            while (dvVar2 != null) {
                objectOutputStream.writeObject(dvVar2);
                C2181dv dvVar3 = dvVar2.f6543i;
                while (dvVar3 != null && dvVar3.f6540f) {
                    dvVar3 = dvVar3.f6543i;
                }
                dvVar2.f6543i = dvVar3;
                dvVar2 = dvVar3;
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        int i;
        try {
            objectInputStream.defaultReadObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int readInt = 0;
        try {
            readInt = objectInputStream.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (readInt != 0) {
            if (((readInt - 1) & readInt) != 0) {
                if (readInt > 1073741824) {
                    throw new RuntimeException("Property table overflow");
                }
                int i2 = 4;
                while (i2 < readInt) {
                    i2 <<= 1;
                }
                readInt = i2;
            }
            this.slots = new C2181dv[readInt];
            int i3 = this.count;
            if (i3 < 0) {
                i = i3 ^ -1;
            } else {
                i = i3;
            }
            C2181dv dvVar = null;
            for (int i4 = 0; i4 != i; i4++) {
                try {
                    this.lastAdded = (C2181dv) objectInputStream.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (i4 == 0) {
                    this.firstAdded = this.lastAdded;
                } else {
                    dvVar.f6543i = this.lastAdded;
                }
                addKnownAbsentSlot(this.slots, this.lastAdded, getSlotIndex(readInt, this.lastAdded.f6538d));
                dvVar = this.lastAdded;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [org.mozilla.javascript.dr] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ScriptableObject getOwnPropertyDescriptor(Context r3, Object r4) {
        /*
            r2 = this;
            r0 = 1
            org.mozilla.javascript.dv r1 = r2.getSlot(r3, r4, r0)
            if (r1 != 0) goto L_0x0009
            r0 = 0
        L_0x0008:
            return r0
        L_0x0009:
            org.mozilla.javascript.dr r0 = r2.getParentScope()
            if (r0 != 0) goto L_0x0014
        L_0x000f:
            org.mozilla.javascript.ds r0 = r1.mo19058a(r3, r2)
            goto L_0x0008
        L_0x0014:
            r2 = r0
            goto L_0x000f
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptableObject.getOwnPropertyDescriptor(org.mozilla.javascript.l, java.lang.Object):org.mozilla.javascript.ds");
    }

    /* access modifiers changed from: protected */
    public C2181dv getSlot(Context lVar, Object obj, int i) {
        String b = ScriptRuntime.m6406b(lVar, obj);
        if (b == null) {
            return getSlot((String) null, ScriptRuntime.m6468l(lVar), i);
        }
        return getSlot(b, 0, i);
    }

    public int size() {
        return this.count < 0 ? this.count ^ -1 : this.count;
    }

    public boolean isEmpty() {
        return this.count == 0 || this.count == -1;
    }

    public Object get(Object obj) {
        Object obj2;
        if (obj instanceof String) {
            obj2 = get((String) obj, (Scriptable) this);
        } else if (obj instanceof Number) {
            obj2 = get(((Number) obj).intValue(), (Scriptable) this);
        } else {
            obj2 = null;
        }
        if (obj2 == Scriptable.f6533j || obj2 == Undefined.f6689a) {
            return null;
        }
        if (obj2 instanceof Wrapper) {
            return ((Wrapper) obj2).mo18879a();
        }
        return obj2;
    }
}
