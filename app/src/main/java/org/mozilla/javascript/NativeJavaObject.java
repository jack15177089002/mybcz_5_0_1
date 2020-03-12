package org.mozilla.javascript;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

/* renamed from: org.mozilla.javascript.by */
public class NativeJavaObject implements Serializable, Scriptable, Wrapper {

    /* renamed from: b */
    private static final Object f6346b = "Coerced Interface";

    /* renamed from: c */
    private static Method f6347c;

    /* renamed from: k */
    private static Method f6348k;

    /* renamed from: a */
    private transient Map<String, JavaMembers> f6349a;

    /* renamed from: d */
    protected Scriptable f6350d;

    /* renamed from: e */
    protected Scriptable f6351e;

    /* renamed from: f */
    protected transient Object f6352f;

    /* renamed from: g */
    protected transient Class<?> f6353g;

    /* renamed from: h */
    protected transient C2140au f6354h;

    /* renamed from: i */
    protected transient boolean f6355i;

    public NativeJavaObject() {
    }

    public NativeJavaObject(Scriptable drVar, Object obj, Class<?> cls) {
        this(drVar, obj, cls, false);
    }

    public NativeJavaObject(Scriptable drVar, Object obj, Class<?> cls, boolean z) {
        this.f6351e = drVar;
        this.f6352f = obj;
        this.f6353g = cls;
        this.f6355i = z;
        mo18880b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo18880b() {
        Class<?> cls;
        if (this.f6352f != null) {
            cls = this.f6352f.getClass();
        } else {
            cls = this.f6353g;
        }
        this.f6354h = C2140au.m5787a(this.f6351e, cls, this.f6353g, this.f6355i);
        this.f6349a = this.f6354h.mo18697a((Scriptable) this, this.f6352f, false);
    }

    public boolean has(String str, Scriptable drVar) {
        return this.f6354h.mo18699a(str, false);
    }

    public boolean has(int i, Scriptable drVar) {
        return false;
    }

    public Object get(String str, Scriptable drVar) {
        if (this.f6349a != null) {
            Object obj = this.f6349a.get(str);
            if (obj != null) {
                return obj;
            }
        }
        return this.f6354h.mo18695a((Scriptable) this, str, this.f6352f, false);
    }

    public Object get(int i, Scriptable drVar) {
        throw this.f6354h.mo18696a(Integer.toString(i));
    }

    public void put(String str, Scriptable drVar, Object obj) {
        if (this.f6350d == null || this.f6354h.mo18699a(str, false)) {
            this.f6354h.mo18698a(this, str, this.f6352f, obj, false);
            return;
        }
        this.f6350d.put(str, this.f6350d, obj);
    }

    public void put(int i, Scriptable drVar, Object obj) {
        throw this.f6354h.mo18696a(Integer.toString(i));
    }

    public boolean hasInstance(Scriptable drVar) {
        return false;
    }

    public void delete(String str) {
    }

    public void delete(int i) {
    }

    public Scriptable getPrototype() {
        if (this.f6350d != null || !(this.f6352f instanceof String)) {
            return this.f6350d;
        }
        return TopLevel.m6647a(ScriptableObject.getTopLevelScope(this.f6351e), C2193eh.String);
    }

    public void setPrototype(Scriptable drVar) {
        this.f6350d = drVar;
    }

    public Scriptable getParentScope() {
        return this.f6351e;
    }

    public void setParentScope(Scriptable drVar) {
        this.f6351e = drVar;
    }

    public Object[] getIds() {
        return this.f6354h.mo18700a(false);
    }

    /* renamed from: a */
    public Object mo18879a() {
        return this.f6352f;
    }

    public String getClassName() {
        return "JavaObject";
    }

    public Object getDefaultValue(Class<?> cls) {
        String str;
        if (cls == null && (this.f6352f instanceof Boolean)) {
            cls = ScriptRuntime.f6494a;
        }
        if (cls == null || cls == ScriptRuntime.f6505l) {
            return this.f6352f.toString();
        }
        if (cls == ScriptRuntime.f6494a) {
            str = "booleanValue";
        } else if (cls == ScriptRuntime.f6502i) {
            str = "doubleValue";
        } else {
            throw Context.m6763b("msg.default.value");
        }
        Object obj = get(str, (Scriptable) this);
        if (obj instanceof Function) {
            Function abVar = (Function) obj;
            return abVar.call(Context.m6769k(), abVar.getParentScope(), this, ScriptRuntime.f6517x);
        } else if (cls != ScriptRuntime.f6502i || !(this.f6352f instanceof Boolean)) {
            return this.f6352f.toString();
        } else {
            return ScriptRuntime.m6313a(((Boolean) this.f6352f).booleanValue() ? 1.0d : 0.0d);
        }
    }

    /* renamed from: a */
    public static boolean m6087a(Object obj, Class<?> cls) {
        return m6089b(obj, cls) < 99;
    }

    /* renamed from: b */
    static int m6089b(Object obj, Class<?> cls) {
        int a = m6083a(obj);
        switch (a) {
            case 0:
                if (cls == ScriptRuntime.f6505l || cls == ScriptRuntime.f6503j) {
                    return 1;
                }
            case 1:
                if (!cls.isPrimitive()) {
                    return 1;
                }
                break;
            case 2:
                if (cls == Boolean.TYPE) {
                    return 1;
                }
                if (cls == ScriptRuntime.f6494a) {
                    return 2;
                }
                if (cls == ScriptRuntime.f6503j) {
                    return 3;
                }
                if (cls == ScriptRuntime.f6505l) {
                    return 4;
                }
                break;
            case 3:
                if (cls.isPrimitive()) {
                    if (cls == Double.TYPE) {
                        return 1;
                    }
                    if (cls != Boolean.TYPE) {
                        return m6082a(cls) + 1;
                    }
                } else if (cls == ScriptRuntime.f6505l) {
                    return 9;
                } else {
                    if (cls == ScriptRuntime.f6503j) {
                        return 10;
                    }
                    if (ScriptRuntime.f6502i.isAssignableFrom(cls)) {
                        return 2;
                    }
                }
                break;
            case 4:
                if (cls == ScriptRuntime.f6505l) {
                    return 1;
                }
                if (cls.isInstance(obj)) {
                    return 2;
                }
                if (cls.isPrimitive()) {
                    if (cls == Character.TYPE) {
                        return 3;
                    }
                    if (cls != Boolean.TYPE) {
                        return 4;
                    }
                }
                break;
            case 5:
                if (cls == ScriptRuntime.f6497d) {
                    return 1;
                }
                if (cls == ScriptRuntime.f6503j) {
                    return 3;
                }
                if (cls == ScriptRuntime.f6505l) {
                    return 4;
                }
                break;
            case 6:
            case 7:
                if (obj instanceof Wrapper) {
                    obj = ((Wrapper) obj).mo18879a();
                }
                if (cls.isInstance(obj)) {
                    return 0;
                }
                if (cls == ScriptRuntime.f6505l) {
                    return 2;
                }
                if (cls.isPrimitive() && cls != Boolean.TYPE) {
                    if (a == 7) {
                        return 99;
                    }
                    return m6082a(cls) + 2;
                }
            case 8:
                if (cls != ScriptRuntime.f6503j && cls.isInstance(obj)) {
                    return 1;
                }
                if (cls.isArray()) {
                    if (obj instanceof NativeArray) {
                        return 2;
                    }
                } else if (cls == ScriptRuntime.f6503j) {
                    return 3;
                } else {
                    if (cls == ScriptRuntime.f6505l) {
                        return 4;
                    }
                    if (cls == ScriptRuntime.f6506m) {
                        if (obj instanceof NativeDate) {
                            return 1;
                        }
                    } else if (cls.isInterface()) {
                        if ((obj instanceof NativeObject) || (obj instanceof NativeFunction)) {
                            return 1;
                        }
                        return 12;
                    } else if (cls.isPrimitive() && cls != Boolean.TYPE) {
                        return m6082a(cls) + 4;
                    }
                }
                break;
        }
        return 99;
    }

    /* renamed from: a */
    private static int m6082a(Class<?> cls) {
        if (cls == Double.TYPE) {
            return 1;
        }
        if (cls == Float.TYPE) {
            return 2;
        }
        if (cls == Long.TYPE) {
            return 3;
        }
        if (cls == Integer.TYPE) {
            return 4;
        }
        if (cls == Short.TYPE) {
            return 5;
        }
        if (cls == Character.TYPE) {
            return 6;
        }
        if (cls == Byte.TYPE) {
            return 7;
        }
        if (cls == Boolean.TYPE) {
            return 99;
        }
        return 8;
    }

    /* renamed from: a */
    private static int m6083a(Object obj) {
        if (obj == null) {
            return 1;
        }
        if (obj == Undefined.f6689a) {
            return 0;
        }
        if (obj instanceof CharSequence) {
            return 4;
        }
        if (obj instanceof Number) {
            return 3;
        }
        if (obj instanceof Boolean) {
            return 2;
        }
        if (obj instanceof Scriptable) {
            if (obj instanceof NativeJavaClass) {
                return 5;
            }
            if (obj instanceof NativeJavaArray) {
                return 7;
            }
            if (obj instanceof Wrapper) {
                return 6;
            }
            return 8;
        } else if (obj instanceof Class) {
            return 5;
        } else {
            if (obj.getClass().isArray()) {
                return 7;
            }
            return 6;
        }
    }

    /* renamed from: a */
    static Object m6085a(Class<?> cls, Object obj) {
        if (obj != null && obj.getClass() == cls) {
            return obj;
        }
        switch (m6083a(obj)) {
            case 0:
                if (cls == ScriptRuntime.f6505l || cls == ScriptRuntime.f6503j) {
                    return "undefined";
                }
                m6091c("undefined", cls);
                return obj;
            case 1:
                if (cls.isPrimitive()) {
                    m6091c(obj, cls);
                }
                return null;
            case 2:
                if (cls == Boolean.TYPE || cls == ScriptRuntime.f6494a || cls == ScriptRuntime.f6503j) {
                    return obj;
                }
                if (cls == ScriptRuntime.f6505l) {
                    return obj.toString();
                }
                m6091c(obj, cls);
                return obj;
            case 3:
                if (cls == ScriptRuntime.f6505l) {
                    return ScriptRuntime.m6436d(obj);
                }
                if (cls == ScriptRuntime.f6503j) {
                    return m6090b(Double.TYPE, obj);
                }
                if ((cls.isPrimitive() && cls != Boolean.TYPE) || ScriptRuntime.f6502i.isAssignableFrom(cls)) {
                    return m6090b(cls, obj);
                }
                m6091c(obj, cls);
                return obj;
            case 4:
                if (cls == ScriptRuntime.f6505l || cls.isInstance(obj)) {
                    return obj.toString();
                }
                if (cls == Character.TYPE || cls == ScriptRuntime.f6496c) {
                    if (((CharSequence) obj).length() == 1) {
                        return Character.valueOf(((CharSequence) obj).charAt(0));
                    }
                    return m6090b(cls, obj);
                } else if ((cls.isPrimitive() && cls != Boolean.TYPE) || ScriptRuntime.f6502i.isAssignableFrom(cls)) {
                    return m6090b(cls, obj);
                } else {
                    m6091c(obj, cls);
                    return obj;
                }
            case 5:
                if (obj instanceof Wrapper) {
                    obj = ((Wrapper) obj).mo18879a();
                }
                if (cls == ScriptRuntime.f6497d || cls == ScriptRuntime.f6503j) {
                    return obj;
                }
                if (cls == ScriptRuntime.f6505l) {
                    return obj.toString();
                }
                m6091c(obj, cls);
                return obj;
            case 6:
            case 7:
                if (obj instanceof Wrapper) {
                    obj = ((Wrapper) obj).mo18879a();
                }
                if (cls.isPrimitive()) {
                    if (cls == Boolean.TYPE) {
                        m6091c(obj, cls);
                    }
                    return m6090b(cls, obj);
                } else if (cls == ScriptRuntime.f6505l) {
                    return obj.toString();
                } else {
                    if (cls.isInstance(obj)) {
                        return obj;
                    }
                    m6091c(obj, cls);
                    return obj;
                }
            case 8:
                if (cls == ScriptRuntime.f6505l) {
                    return ScriptRuntime.m6436d(obj);
                }
                if (cls.isPrimitive()) {
                    if (cls == Boolean.TYPE) {
                        m6091c(obj, cls);
                    }
                    return m6090b(cls, obj);
                } else if (cls.isInstance(obj)) {
                    return obj;
                } else {
                    if (cls == ScriptRuntime.f6506m && (obj instanceof NativeDate)) {
                        return new Date((long) ((NativeDate) obj).f6314a);
                    }
                    if (cls.isArray() && (obj instanceof NativeArray)) {
                        NativeArray bcVar = (NativeArray) obj;
                        long j = bcVar.f6285a;
                        Class componentType = cls.getComponentType();
                        Object newInstance = Array.newInstance(componentType, (int) j);
                        for (int i = 0; ((long) i) < j; i++) {
                            try {
                                Array.set(newInstance, i, m6085a(componentType, bcVar.get(i, bcVar)));
                            } catch (EvaluatorException e) {
                                m6091c(obj, cls);
                            }
                        }
                        return newInstance;
                    } else if (obj instanceof Wrapper) {
                        Object a = ((Wrapper) obj).mo18879a();
                        if (cls.isInstance(a)) {
                            return a;
                        }
                        m6091c(a, cls);
                        return a;
                    } else if (cls.isInterface() && ((obj instanceof NativeObject) || (obj instanceof NativeFunction))) {
                        return m6086a(cls, (ScriptableObject) obj);
                    } else {
                        m6091c(obj, cls);
                        return obj;
                    }
                }
            default:
                return obj;
        }
    }

    /* renamed from: a */
    protected static Object m6086a(Class<?> cls, ScriptableObject dsVar) {
        InterfaceAdapter akVar;
        Object a = Kit.m5808a(f6346b, (Object) cls);
        Object associatedValue = dsVar.getAssociatedValue(a);
        if (associatedValue != null) {
            return associatedValue;
        }
        Context k = Context.m6769k();
        if (!cls.isInterface()) {
            throw new IllegalArgumentException();
        }
        Scriptable d = ScriptRuntime.m6438d(k);
        ClassCache a2 = ClassCache.m6667a(d);
        InterfaceAdapter akVar2 = (InterfaceAdapter) (a2.f6701e == null ? null : a2.f6701e.get(cls));
        ContextFactory oVar = k.f6778b;
        if (akVar2 == null) {
            Method[] methods = cls.getMethods();
            if (dsVar instanceof Callable) {
                int length = methods.length;
                if (length == 0) {
                    throw Context.m6755a("msg.no.empty.interface.conversion", (Object) cls.getName());
                } else if (length > 1) {
                    String name = methods[0].getName();
                    for (int i = 1; i < length; i++) {
                        if (!name.equals(methods[i].getName())) {
                            throw Context.m6755a("msg.no.function.interface.conversion", (Object) cls.getName());
                        }
                    }
                }
            }
            akVar = new InterfaceAdapter(cls);
            a2.mo19105a(cls, akVar);
        } else {
            akVar = akVar2;
        }
        return dsVar.associateValue(a, VMBridge.f6694a.mo19096a(akVar.f6007a, oVar, akVar, dsVar, d));
    }

    /* renamed from: b */
    private static Object m6090b(Class<?> cls, Object obj) {
        double d = 0.0d;
        Class<?> cls2 = obj.getClass();
        if (cls == Character.TYPE || cls == ScriptRuntime.f6496c) {
            if (cls2 == ScriptRuntime.f6496c) {
                return obj;
            }
            return Character.valueOf((char) ((int) m6084a(obj, ScriptRuntime.f6496c, 0.0d, 65535.0d)));
        } else if (cls == ScriptRuntime.f6503j || cls == ScriptRuntime.f6498e || cls == Double.TYPE) {
            if (cls2 != ScriptRuntime.f6498e) {
                return new Double(m6088b(obj));
            }
            return obj;
        } else if (cls == ScriptRuntime.f6499f || cls == Float.TYPE) {
            if (cls2 == ScriptRuntime.f6499f) {
                return obj;
            }
            double b = m6088b(obj);
            if (Double.isInfinite(b) || Double.isNaN(b) || b == 0.0d) {
                return new Float((float) b);
            }
            double abs = Math.abs(b);
            if (abs < 1.401298464324817E-45d) {
                if (b <= 0.0d) {
                    d = -0.0d;
                }
                return new Float(d);
            } else if (abs <= 3.4028234663852886E38d) {
                return new Float((float) b);
            } else {
                return new Float(b > 0.0d ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY);
            }
        } else if (cls == ScriptRuntime.f6500g || cls == Integer.TYPE) {
            if (cls2 == ScriptRuntime.f6500g) {
                return obj;
            }
            return Integer.valueOf((int) m6084a(obj, ScriptRuntime.f6500g, -2.147483648E9d, 2.147483647E9d));
        } else if (cls == ScriptRuntime.f6501h || cls == Long.TYPE) {
            if (cls2 == ScriptRuntime.f6501h) {
                return obj;
            }
            return Long.valueOf(m6084a(obj, ScriptRuntime.f6501h, Double.longBitsToDouble(-4332462841530417152L), Double.longBitsToDouble(4890909195324358655L)));
        } else if (cls == ScriptRuntime.f6504k || cls == Short.TYPE) {
            if (cls2 == ScriptRuntime.f6504k) {
                return obj;
            }
            return Short.valueOf((short) ((int) m6084a(obj, ScriptRuntime.f6504k, -32768.0d, 32767.0d)));
        } else if (cls != ScriptRuntime.f6495b && cls != Byte.TYPE) {
            return new Double(m6088b(obj));
        } else {
            if (cls2 == ScriptRuntime.f6495b) {
                return obj;
            }
            return Byte.valueOf((byte) ((int) m6084a(obj, ScriptRuntime.f6495b, -128.0d, 127.0d)));
        }
    }

    /* renamed from: b */
    private static double m6088b(Object obj) {
        Method method = null;
        Object obj2 = obj;
        while (!(obj2 instanceof Number)) {
            if (obj2 instanceof String) {
                return ScriptRuntime.m6309a((String) obj2);
            }
            if (!(obj2 instanceof Scriptable)) {
                try {
                    method = obj2.getClass().getMethod("doubleValue");
                } catch (NoSuchMethodException | SecurityException e) {
                }
                if (method != null) {
                    try {
                        return ((Number) method.invoke(obj2)).doubleValue();
                    } catch (IllegalAccessException e2) {
                        m6091c(obj2, Double.TYPE);
                    } catch (InvocationTargetException e3) {
                        m6091c(obj2, Double.TYPE);
                    }
                }
                return ScriptRuntime.m6309a(obj2.toString());
            } else if (!(obj2 instanceof Wrapper)) {
                return ScriptRuntime.m6395b(obj2);
            } else {
                obj2 = ((Wrapper) obj2).mo18879a();
            }
        }
        return ((Number) obj2).doubleValue();
    }

    /* renamed from: a */
    private static long m6084a(Object obj, Class<?> cls, double d, double d2) {
        double ceil;
        double b = m6088b(obj);
        if (Double.isInfinite(b) || Double.isNaN(b)) {
            m6091c(ScriptRuntime.m6436d(obj), cls);
        }
        if (b > 0.0d) {
            ceil = Math.floor(b);
        } else {
            ceil = Math.ceil(b);
        }
        if (ceil < d || ceil > d2) {
            m6091c(ScriptRuntime.m6436d(obj), cls);
        }
        return (long) ceil;
    }

    /* renamed from: c */
    private static void m6091c(Object obj, Class<?> cls) {
        throw Context.m6756a("msg.conversion.not.allowed", (Object) String.valueOf(obj), (Object) C2140au.m5785a(cls));
    }

    static {
        Class[] clsArr = new Class[2];
        Class a = Kit.m5805a("org.mozilla.javascript.as");
        if (a != null) {
            try {
                clsArr[0] = ScriptRuntime.f6503j;
                clsArr[1] = Kit.m5805a("java.io.ObjectOutputStream");
                f6347c = a.getMethod("writeAdapterObject", clsArr);
                clsArr[0] = ScriptRuntime.f6511r;
                clsArr[1] = Kit.m5805a("java.io.ObjectInputStream");
                f6348k = a.getMethod("readAdapterObject", clsArr);
            } catch (NoSuchMethodException e) {
                f6347c = null;
                f6348k = null;
            }
        }
    }
}
