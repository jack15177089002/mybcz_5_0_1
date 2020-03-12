package com.p047d.p048a;

import android.util.Log;
import com.p047d.p049b.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.d.a.ai */
public class PropertyValuesHolder implements Cloneable {

    /* renamed from: f */
    static final TypeEvaluator f3438f = new IntEvaluator();

    /* renamed from: g */
    static final TypeEvaluator f3439g = new FloatEvaluator();

    /* renamed from: l */
    private static Class[] f3440l = {Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};

    /* renamed from: m */
    private static Class[] f3441m = {Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};

    /* renamed from: n */
    private static Class[] f3442n = {Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};

    /* renamed from: o */
    private static final HashMap<Class, HashMap<String, Method>> f3443o = new HashMap<>();

    /* renamed from: p */
    private static final HashMap<Class, HashMap<String, Method>> f3444p = new HashMap<>();

    /* renamed from: a */
    String f3445a;

    /* renamed from: b */
    protected Property f3446b;

    /* renamed from: c */
    Method f3447c;

    /* renamed from: d */
    Class f3448d;

    /* renamed from: e */
    KeyframeSet f3449e;

    /* renamed from: h */
    final ReentrantReadWriteLock f3450h;

    /* renamed from: i */
    final Object[] f3451i;

    /* renamed from: j */
    TypeEvaluator f3452j;

    /* renamed from: k */
    private Method f3453k;

    /* renamed from: q */
    private Object f3454q;

    private PropertyValuesHolder(String str) {
        this.f3447c = null;
        this.f3453k = null;
        this.f3449e = null;
        this.f3450h = new ReentrantReadWriteLock();
        this.f3451i = new Object[1];
        this.f3445a = str;
    }

    /* synthetic */ PropertyValuesHolder(String str, byte b) {
        this(str);
    }

    private PropertyValuesHolder(Property cVar) {
        this.f3447c = null;
        this.f3453k = null;
        this.f3449e = null;
        this.f3450h = new ReentrantReadWriteLock();
        this.f3451i = new Object[1];
        this.f3446b = cVar;
        if (cVar != null) {
            this.f3445a = cVar.f3557a;
        }
    }

    /* synthetic */ PropertyValuesHolder(Property cVar, byte b) {
        this(cVar);
    }

    /* renamed from: a */
    public static PropertyValuesHolder m3267a(String str, int... iArr) {
        return new C1541ak(str, iArr);
    }

    /* renamed from: a */
    public static PropertyValuesHolder m3265a(Property<?, Integer> cVar, int... iArr) {
        return new C1541ak((Property) cVar, iArr);
    }

    /* renamed from: a */
    public static PropertyValuesHolder m3266a(String str, float... fArr) {
        return new C1540aj(str, fArr);
    }

    /* renamed from: a */
    public static PropertyValuesHolder m3264a(Property<?, Float> cVar, float... fArr) {
        return new C1540aj((Property) cVar, fArr);
    }

    /* renamed from: a */
    public void mo16177a(int... iArr) {
        this.f3448d = Integer.TYPE;
        int length = iArr.length;
        C1557q[] qVarArr = new C1557q[Math.max(length, 2)];
        if (length == 1) {
            qVarArr[0] = new C1557q();
            qVarArr[1] = (C1557q) Keyframe.m3348a(1.0f, iArr[0]);
        } else {
            qVarArr[0] = (C1557q) Keyframe.m3348a(0.0f, iArr[0]);
            for (int i = 1; i < length; i++) {
                qVarArr[i] = (C1557q) Keyframe.m3348a(((float) i) / ((float) (length - 1)), iArr[i]);
            }
        }
        this.f3449e = new IntKeyframeSet(qVarArr);
    }

    /* renamed from: a */
    public void mo16176a(float... fArr) {
        this.f3448d = Float.TYPE;
        int length = fArr.length;
        C1556p[] pVarArr = new C1556p[Math.max(length, 2)];
        if (length == 1) {
            pVarArr[0] = new C1556p();
            pVarArr[1] = (C1556p) Keyframe.m3347a(1.0f, fArr[0]);
        } else {
            pVarArr[0] = (C1556p) Keyframe.m3347a(0.0f, fArr[0]);
            for (int i = 1; i < length; i++) {
                pVarArr[i] = (C1556p) Keyframe.m3347a(((float) i) / ((float) (length - 1)), fArr[i]);
            }
        }
        this.f3449e = new FloatKeyframeSet(pVarArr);
    }

    /* renamed from: a */
    private Method m3268a(Class cls, String str, Class cls2) {
        Class[] clsArr;
        Method method;
        Method method2 = null;
        String str2 = this.f3445a;
        if (!(str2 == null || str2.length() == 0)) {
            str = new StringBuilder(String.valueOf(str)).append(Character.toUpperCase(str2.charAt(0))).append(str2.substring(1)).toString();
        }
        if (cls2 == null) {
            try {
                return cls.getMethod(str, null);
            } catch (NoSuchMethodException e) {
                try {
                    method = cls.getDeclaredMethod(str, null);
                    try {
                        method.setAccessible(true);
                        return method;
                    } catch (Exception e2) {
                    }
                } catch (NoSuchMethodException e3) {
                    method = null;
                    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f3445a + ": " + e);
                    return method;
                }
            }
        } else {
            Class[] clsArr2 = new Class[1];
            if (this.f3448d.equals(Float.class)) {
                clsArr = f3440l;
            } else if (this.f3448d.equals(Integer.class)) {
                clsArr = f3441m;
            } else {
                clsArr = this.f3448d.equals(Double.class) ? f3442n : new Class[]{this.f3448d};
            }
            int length = clsArr.length;
            int i = 0;
            while (i < length) {
                Class cls3 = clsArr[i];
                clsArr2[0] = cls3;
                try {
                    method2 = cls.getMethod(str, clsArr2);
                    this.f3448d = cls3;
                    return method2;
                } catch (NoSuchMethodException e4) {
                    try {
                        method2 = cls.getDeclaredMethod(str, clsArr2);
                        method2.setAccessible(true);
                        this.f3448d = cls3;
                        return method2;
                    } catch (NoSuchMethodException e5) {
                        i++;
                    }
                }
            }
            Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.f3445a + " with value type " + this.f3448d);
            return method2;
        }
        return null;
    }

    /* renamed from: a */
    private Method m3269a(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        Method method;
        Method method2 = null;
        try {
            this.f3450h.writeLock().lock();
            HashMap hashMap2 = (HashMap) hashMap.get(cls);
            if (hashMap2 != null) {
                method2 = (Method) hashMap2.get(this.f3445a);
            }
            if (method2 == null) {
                Method a = m3268a(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f3445a, a);
                method = a;
            } else {
                method = method2;
            }
            return method;
        } finally {
            this.f3450h.writeLock().unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16174a(Class cls) {
        this.f3447c = m3269a(cls, f3443o, "set", this.f3448d);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo16175a(Object obj) {
        if (this.f3446b != null) {
            try {
                this.f3446b.mo16169a(obj);
                Iterator it = this.f3449e.f3537e.iterator();
                while (it.hasNext()) {
                    Keyframe oVar = (Keyframe) it.next();
                    if (!oVar.f3530d) {
                        oVar.mo16210a(this.f3446b.mo16169a(obj));
                    }
                }
                return;
            } catch (ClassCastException e) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f3446b.f3557a + ") on target object " + obj + ". Trying reflection instead");
                this.f3446b = null;
            }
        }
        Class cls = obj.getClass();
        if (this.f3447c == null) {
            mo16174a(cls);
        }
        Iterator it2 = this.f3449e.f3537e.iterator();
        while (it2.hasNext()) {
            Keyframe oVar2 = (Keyframe) it2.next();
            if (!oVar2.f3530d) {
                if (this.f3453k == null) {
                    this.f3453k = m3269a(cls, f3444p, "get", null);
                }
                try {
                    oVar2.mo16210a(this.f3453k.invoke(obj, new Object[0]));
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                } catch (IllegalAccessException e3) {
                    Log.e("PropertyValuesHolder", e3.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public PropertyValuesHolder clone() {
        try {
            PropertyValuesHolder aiVar = (PropertyValuesHolder) super.clone();
            aiVar.f3445a = this.f3445a;
            aiVar.f3446b = this.f3446b;
            aiVar.f3449e = this.f3449e.clone();
            aiVar.f3452j = this.f3452j;
            return aiVar;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo16179b(Object obj) {
        if (this.f3446b != null) {
            this.f3446b.mo16217a(obj, mo16178b());
        }
        if (this.f3447c != null) {
            try {
                this.f3451i[0] = mo16178b();
                this.f3447c.invoke(obj, this.f3451i);
            } catch (InvocationTargetException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (IllegalAccessException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16172a(float f) {
        this.f3454q = this.f3449e.mo16206a(f);
    }

    /* renamed from: a */
    public final void mo16173a(Property cVar) {
        this.f3446b = cVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Object mo16178b() {
        return this.f3454q;
    }

    public String toString() {
        return this.f3445a + ": " + this.f3449e.toString();
    }
}
