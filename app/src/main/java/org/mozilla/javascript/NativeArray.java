package org.mozilla.javascript;

import androidx.annotation.NonNull;

import com.baicizhan.client.framework.network.http.HttpStat.ExecuteStatus;
import com.baicizhan.client.framework.network.http.NetWorkError;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.bc */
public final class NativeArray extends IdScriptableObject implements List {

    /* renamed from: c */
    private static final Object f6282c = "Array";

    /* renamed from: d */
    private static final Integer f6283d = Integer.valueOf(-1);

    /* renamed from: g */
    private static int f6284g = 10000;

    /* renamed from: a */
    long f6285a;

    /* renamed from: b */
    boolean f6286b;

    /* renamed from: e */
    private int f6287e;

    /* renamed from: f */
    private Object[] f6288f;

    /* renamed from: a */
    static void m5989a(Scriptable drVar) {
        new NativeArray(0).exportAsJSClass(23, drVar, false);
    }

    /* renamed from: a */
    static void m5988a() {
        f6284g = 200000;
    }

    public NativeArray(long j) {
        this.f6287e = 6;
        this.f6286b = j <= ((long) f6284g);
        if (this.f6286b) {
            int i = (int) j;
            if (i < 10) {
                i = 10;
            }
            this.f6288f = new Object[i];
            Arrays.fill(this.f6288f, Scriptable.f6533j);
        }
        this.f6285a = j;
    }

    public NativeArray(Object[] objArr) {
        this.f6287e = 6;
        this.f6286b = true;
        this.f6288f = objArr;
        this.f6285a = (long) objArr.length;
    }

    public final String getClassName() {
        return "Array";
    }

    /* access modifiers changed from: protected */
    public final int getMaxInstanceId() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public final void setInstanceIdAttributes(int i, int i2) {
        if (i == 1) {
            this.f6287e = i2;
        }
    }

    /* access modifiers changed from: protected */
    public final int findInstanceIdInfo(String str) {
        if (str.equals("length")) {
            return instanceIdInfo(this.f6287e, 1);
        }
        return super.findInstanceIdInfo(str);
    }

    /* access modifiers changed from: protected */
    public final String getInstanceIdName(int i) {
        if (i == 1) {
            return "length";
        }
        return super.getInstanceIdName(i);
    }

    /* access modifiers changed from: protected */
    public final Object getInstanceIdValue(int i) {
        if (i == 1) {
            return ScriptRuntime.m6313a((double) this.f6285a);
        }
        return super.getInstanceIdValue(i);
    }

    /* access modifiers changed from: protected */
    public final void setInstanceIdValue(int i, Object obj) {
        int i2 = 0;
        if (i != 1) {
            super.setInstanceIdValue(i, obj);
        } else if ((this.f6287e & 1) == 0) {
            double b = ScriptRuntime.m6395b(obj);
            long e = ScriptRuntime.m6441e(b);
            if (((double) e) != b) {
                throw ScriptRuntime.m6375a("RangeError", ScriptRuntime.m6448f("msg.arraylength.bad"));
            }
            if (this.f6286b) {
                if (e < this.f6285a) {
                    Arrays.fill(this.f6288f, (int) e, this.f6288f.length, f6533j);
                } else if (e >= 1431655764 || ((double) e) >= ((double) this.f6285a) * 1.5d || !m5991a((int) e)) {
                    this.f6286b = false;
                }
                this.f6285a = e;
            }
            if (e < this.f6285a) {
                if (this.f6285a - e > 4096) {
                    Object[] ids = getIds();
                    while (true) {
                        int i3 = i2;
                        if (i3 >= ids.length) {
                            break;
                        }
                        Object obj2 = ids[i3];
                        if (obj2 instanceof String) {
                            String str = (String) obj2;
                            if (m5978a(str) >= e) {
                                delete(str);
                            }
                        } else {
                            int intValue = ((Integer) obj2).intValue();
                            if (((long) intValue) >= e) {
                                delete(intValue);
                            }
                        }
                        i2 = i3 + 1;
                    }
                } else {
                    for (long j = e; j < this.f6285a; j++) {
                        m5995b((Scriptable) this, j);
                    }
                }
            }
            this.f6285a = e;
        }
    }

    /* access modifiers changed from: protected */
    public final void fillConstructorProperties(IdFunctionObject ahVar) {
        addIdFunctionProperty(ahVar, f6282c, -5, "join", 1);
        addIdFunctionProperty(ahVar, f6282c, -6, "reverse", 0);
        addIdFunctionProperty(ahVar, f6282c, -7, "sort", 1);
        addIdFunctionProperty(ahVar, f6282c, -8, "push", 1);
        addIdFunctionProperty(ahVar, f6282c, -9, "pop", 0);
        addIdFunctionProperty(ahVar, f6282c, -10, "shift", 0);
        addIdFunctionProperty(ahVar, f6282c, -11, "unshift", 1);
        addIdFunctionProperty(ahVar, f6282c, -12, "splice", 2);
        addIdFunctionProperty(ahVar, f6282c, -13, "concat", 1);
        addIdFunctionProperty(ahVar, f6282c, -14, "slice", 2);
        addIdFunctionProperty(ahVar, f6282c, -15, "indexOf", 1);
        addIdFunctionProperty(ahVar, f6282c, -16, "lastIndexOf", 1);
        addIdFunctionProperty(ahVar, f6282c, -17, "every", 1);
        addIdFunctionProperty(ahVar, f6282c, -18, "filter", 1);
        addIdFunctionProperty(ahVar, f6282c, -19, "forEach", 1);
        addIdFunctionProperty(ahVar, f6282c, -20, "map", 1);
        addIdFunctionProperty(ahVar, f6282c, -21, "some", 1);
        addIdFunctionProperty(ahVar, f6282c, -22, "reduce", 1);
        addIdFunctionProperty(ahVar, f6282c, -23, "reduceRight", 1);
        addIdFunctionProperty(ahVar, f6282c, -24, "isArray", 1);
        super.fillConstructorProperties(ahVar);
    }

    /* access modifiers changed from: protected */
    public final void initPrototypeId(int i) {
        String str;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "constructor";
                break;
            case 2:
                str = "toString";
                i2 = 0;
                break;
            case 3:
                str = "toLocaleString";
                i2 = 0;
                break;
            case 4:
                str = "toSource";
                i2 = 0;
                break;
            case 5:
                str = "join";
                break;
            case 6:
                str = "reverse";
                i2 = 0;
                break;
            case 7:
                str = "sort";
                break;
            case 8:
                str = "push";
                break;
            case 9:
                str = "pop";
                i2 = 0;
                break;
            case 10:
                str = "shift";
                i2 = 0;
                break;
            case 11:
                str = "unshift";
                break;
            case 12:
                str = "splice";
                i2 = 2;
                break;
            case 13:
                str = "concat";
                break;
            case 14:
                str = "slice";
                i2 = 2;
                break;
            case 15:
                str = "indexOf";
                break;
            case 16:
                str = "lastIndexOf";
                break;
            case 17:
                str = "every";
                break;
            case 18:
                str = "filter";
                break;
            case 19:
                str = "forEach";
                break;
            case 20:
                str = "map";
                break;
            case 21:
                str = "some";
                break;
            case 22:
                str = "reduce";
                break;
            case 23:
                str = "reduceRight";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(f6282c, i, str, i2);
    }

    public final Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        Object obj;
        Object[] objArr2;
        if (!ahVar.mo18643a(f6282c)) {
            return super.execIdCall(ahVar, lVar, drVar, drVar2, objArr);
        }
        int i = ahVar.f5994a;
        Object[] objArr3 = objArr;
        Scriptable drVar3 = drVar2;
        while (true) {
            switch (i) {
                case -24:
                    return Boolean.valueOf(objArr3.length > 0 && (objArr3[0] instanceof NativeArray));
                case -23:
                case -22:
                case -21:
                case -20:
                case -19:
                case -18:
                case NetWorkError.NETWORK_NO_DATA_RECEIVED /*-17*/:
                case NetWorkError.NETWORK_MEMORY_SMALL /*-16*/:
                case NetWorkError.NETWORK_OUTOFMEMORY /*-15*/:
                case NetWorkError.NETWORK_CANCEL /*-14*/:
                case NetWorkError.NETWORK_SOCKET_TIMEOUT /*-13*/:
                case NetWorkError.NETWORK_SOCKET_EXCEPTION /*-12*/:
                case NetWorkError.NETWORK_DATA_TOO_BIG /*-11*/:
                case NetWorkError.NETWORK_UNKNOWN /*-10*/:
                case ExecuteStatus.GETDATA_SUCC /*-9*/:
                case ExecuteStatus.GETDATA_BEFORE /*-8*/:
                case -7:
                case -6:
                case -5:
                    if (objArr3.length > 0) {
                        Scriptable a = ScriptRuntime.m6364a(drVar, objArr3[0]);
                        Object[] objArr4 = new Object[(objArr3.length - 1)];
                        for (int i2 = 0; i2 < objArr4.length; i2++) {
                            objArr4[i2] = objArr3[i2 + 1];
                        }
                        objArr2 = objArr4;
                        drVar3 = a;
                    } else {
                        objArr2 = objArr3;
                    }
                    i = -i;
                    objArr3 = objArr2;
                case 1:
                    if (!(drVar3 == null)) {
                        return ahVar.construct(lVar, drVar, objArr3);
                    }
                    if (objArr3.length == 0) {
                        return new NativeArray(0);
                    }
                    if (lVar.f6785i == 120) {
                        return new NativeArray(objArr3);
                    }
                    Object obj2 = objArr3[0];
                    if (objArr3.length > 1 || !(obj2 instanceof Number)) {
                        return new NativeArray(objArr3);
                    }
                    long g = ScriptRuntime.m6452g(obj2);
                    if (((double) g) == ((Number) obj2).doubleValue()) {
                        return new NativeArray(g);
                    }
                    throw ScriptRuntime.m6375a("RangeError", ScriptRuntime.m6448f("msg.arraylength.bad"));
                case 2:
                    return m5986a(lVar, drVar, drVar3, lVar.mo19138b(4), false);
                case 3:
                    return m5986a(lVar, drVar, drVar3, false, true);
                case 4:
                    return m5986a(lVar, drVar, drVar3, true, false);
                case 5:
                    long a2 = m5979a(lVar, drVar3);
                    int i3 = (int) a2;
                    if (a2 != ((long) i3)) {
                        throw Context.m6755a("msg.arraylength.too.big", (Object) String.valueOf(a2));
                    }
                    String d = (objArr3.length <= 0 || objArr3[0] == Undefined.f6689a) ? "," : ScriptRuntime.m6436d(objArr3[0]);
                    if (drVar3 instanceof NativeArray) {
                        NativeArray bcVar = (NativeArray) drVar3;
                        if (bcVar.f6286b) {
                            StringBuilder sb = new StringBuilder();
                            for (int i4 = 0; i4 < i3; i4++) {
                                if (i4 != 0) {
                                    sb.append(d);
                                }
                                if (i4 < bcVar.f6288f.length) {
                                    Object obj3 = bcVar.f6288f[i4];
                                    if (!(obj3 == null || obj3 == Undefined.f6689a || obj3 == Scriptable.f6533j)) {
                                        sb.append(ScriptRuntime.m6436d(obj3));
                                    }
                                }
                            }
                            return sb.toString();
                        }
                    }
                    if (i3 == 0) {
                        return "";
                    }
                    String[] strArr = new String[i3];
                    int i5 = 0;
                    for (int i6 = 0; i6 != i3; i6++) {
                        Object a3 = m5983a(lVar, drVar3, (long) i6);
                        if (!(a3 == null || a3 == Undefined.f6689a)) {
                            String d2 = ScriptRuntime.m6436d(a3);
                            i5 += d2.length();
                            strArr[i6] = d2;
                        }
                    }
                    StringBuilder sb2 = new StringBuilder(i5 + ((i3 - 1) * d.length()));
                    for (int i7 = 0; i7 != i3; i7++) {
                        if (i7 != 0) {
                            sb2.append(d);
                        }
                        String str = strArr[i7];
                        if (str != null) {
                            sb2.append(str);
                        }
                    }
                    return sb2.toString();
                case 6:
                    return m5994b(lVar, drVar3);
                case 7:
                    return m5987a(lVar, drVar, drVar3, objArr3);
                case 8:
                    return m5984a(lVar, drVar3, objArr3);
                case 9:
                    if (drVar3 instanceof NativeArray) {
                        NativeArray bcVar2 = (NativeArray) drVar3;
                        if (bcVar2.f6286b && bcVar2.f6285a > 0) {
                            bcVar2.f6285a--;
                            Object obj4 = bcVar2.f6288f[(int) bcVar2.f6285a];
                            bcVar2.f6288f[(int) bcVar2.f6285a] = f6533j;
                            return obj4;
                        }
                    }
                    long a4 = m5979a(lVar, drVar3);
                    if (a4 > 0) {
                        a4--;
                        obj = m5983a(lVar, drVar3, a4);
                    } else {
                        obj = Undefined.f6689a;
                    }
                    m5980a(drVar3, a4);
                    return obj;
                case 10:
                    return m5998c(lVar, drVar3);
                case 11:
                    return m5993b(lVar, drVar3, objArr3);
                case 12:
                    return m5992b(lVar, drVar, drVar3, objArr3);
                case 13:
                    return m5999c(lVar, drVar, drVar3, objArr3);
                case 14:
                    return m6000c(lVar, drVar3, objArr3);
                case 15:
                    return m5985a(lVar, drVar3, objArr3, false);
                case 16:
                    return m5985a(lVar, drVar3, objArr3, true);
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    return m5981a(lVar, i, drVar, drVar3, objArr3);
                case 22:
                case 23:
                    return m5982a(lVar, i, drVar3, objArr3);
                default:
                    throw new IllegalArgumentException(String.valueOf(i));
            }
        }
    }

    public final Object get(int i, Scriptable drVar) {
        if (!this.f6286b && isGetterOrSetter(null, i, false)) {
            return super.get(i, drVar);
        }
        if (this.f6288f == null || i < 0 || i >= this.f6288f.length) {
            return super.get(i, drVar);
        }
        return this.f6288f[i];
    }

    public final boolean has(int i, Scriptable drVar) {
        if (!this.f6286b && isGetterOrSetter(null, i, false)) {
            return super.has(i, drVar);
        }
        if (this.f6288f == null || i < 0 || i >= this.f6288f.length) {
            return super.has(i, drVar);
        }
        if (this.f6288f[i] != f6533j) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static long m5977a(Object obj) {
        if (obj instanceof String) {
            return m5978a((String) obj);
        }
        if (obj instanceof Number) {
            return m5975a(((Number) obj).doubleValue());
        }
        return -1;
    }

    /* renamed from: a */
    private static long m5978a(String str) {
        long a = m5975a(ScriptRuntime.m6309a(str));
        if (Long.toString(a).equals(str)) {
            return a;
        }
        return -1;
    }

    /* renamed from: a */
    private static long m5975a(double d) {
        if (d == d) {
            long e = ScriptRuntime.m6441e(d);
            if (((double) e) == d && e != 4294967295L) {
                return e;
            }
        }
        return -1;
    }

    public final void put(String str, Scriptable drVar, Object obj) {
        super.put(str, drVar, obj);
        if (drVar == this) {
            long a = m5978a(str);
            if (a >= this.f6285a) {
                this.f6285a = a + 1;
                this.f6286b = false;
            }
        }
    }

    /* renamed from: a */
    private boolean m5991a(int i) {
        if (i > this.f6288f.length) {
            if (i > 1431655764) {
                this.f6286b = false;
                return false;
            }
            int max = Math.max(i, (int) (((double) this.f6288f.length) * 1.5d));
            Object[] objArr = new Object[max];
            System.arraycopy(this.f6288f, 0, objArr, 0, this.f6288f.length);
            Arrays.fill(objArr, this.f6288f.length, max, Scriptable.f6533j);
            this.f6288f = objArr;
        }
        return true;
    }

    public final void put(int i, Scriptable drVar, Object obj) {
        if (drVar == this && !isSealed() && this.f6288f != null && i >= 0 && (this.f6286b || !isGetterOrSetter(null, i, true))) {
            if (i < this.f6288f.length) {
                this.f6288f[i] = obj;
                if (this.f6285a <= ((long) i)) {
                    this.f6285a = ((long) i) + 1;
                    return;
                }
                return;
            } else if (!this.f6286b || ((double) i) >= ((double) this.f6288f.length) * 1.5d || !m5991a(i + 1)) {
                this.f6286b = false;
            } else {
                this.f6288f[i] = obj;
                this.f6285a = ((long) i) + 1;
                return;
            }
        }
        super.put(i, drVar, obj);
        if (drVar == this && (this.f6287e & 1) == 0 && this.f6285a <= ((long) i)) {
            this.f6285a = ((long) i) + 1;
        }
    }

    public final void delete(int i) {
        if (this.f6288f == null || i < 0 || i >= this.f6288f.length || isSealed() || (!this.f6286b && isGetterOrSetter(null, i, true))) {
            super.delete(i);
        } else {
            this.f6288f[i] = f6533j;
        }
    }

    public final Object[] getIds() {
        int i;
        Object[] objArr;
        Object[] ids = super.getIds();
        if (this.f6288f == null) {
            return ids;
        }
        int length = this.f6288f.length;
        long j = this.f6285a;
        if (((long) length) > j) {
            i = (int) j;
        } else {
            i = length;
        }
        if (i == 0) {
            return ids;
        }
        int length2 = ids.length;
        Object[] objArr2 = new Object[(i + length2)];
        int i2 = 0;
        for (int i3 = 0; i3 != i; i3++) {
            if (this.f6288f[i3] != f6533j) {
                objArr2[i2] = Integer.valueOf(i3);
                i2++;
            }
        }
        if (i2 != i) {
            objArr = new Object[(i2 + length2)];
            System.arraycopy(objArr2, 0, objArr, 0, i2);
        } else {
            objArr = objArr2;
        }
        System.arraycopy(ids, 0, objArr, i2, length2);
        return objArr;
    }

    public final Object[] getAllIds() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(getIds()));
        linkedHashSet.addAll(Arrays.asList(super.getAllIds()));
        return linkedHashSet.toArray();
    }

    /* renamed from: b */
    public final Integer[] mo18842b() {
        Object[] ids = getIds();
        ArrayList arrayList = new ArrayList(ids.length);
        for (Object obj : ids) {
            int f = ScriptRuntime.m6446f(obj);
            if (f >= 0 && ScriptRuntime.m6402b((double) f).equals(ScriptRuntime.m6436d(obj))) {
                arrayList.add(Integer.valueOf(f));
            }
        }
        return (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);
    }

    public final Object getDefaultValue(Class<?> cls) {
        if (cls == ScriptRuntime.f6502i && Context.m6769k().f6785i == 120) {
            return Long.valueOf(this.f6285a);
        }
        return super.getDefaultValue(cls);
    }

    public final int getAttributes(int i) {
        if (this.f6288f == null || i < 0 || i >= this.f6288f.length || this.f6288f[i] == f6533j) {
            return super.getAttributes(i);
        }
        return 0;
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [org.mozilla.javascript.dr] */
    /* JADX WARNING: type inference failed for: r6v2, types: [org.mozilla.javascript.dr] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.mozilla.javascript.ScriptableObject getOwnPropertyDescriptor(Context r7, Object r8) {
        /*
            r6 = this;
            r5 = 1
            r4 = 0
            java.lang.Object[] r0 = r6.f6288f
            if (r0 == 0) goto L_0x005e
            long r0 = m5977a(r8)
            r2 = 0
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x005c
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x005c
            int r0 = (int) r0
        L_0x0018:
            if (r0 < 0) goto L_0x005e
            java.lang.Object[] r1 = r6.f6288f
            int r1 = r1.length
            if (r0 >= r1) goto L_0x005e
            java.lang.Object[] r1 = r6.f6288f
            r1 = r1[r0]
            java.lang.Object r2 = f6533j
            if (r1 == r2) goto L_0x005e
            java.lang.Object[] r1 = r6.f6288f
            r1 = r1[r0]
            org.mozilla.javascript.dr r0 = r6.getParentScope()
            if (r0 != 0) goto L_0x0063
        L_0x0031:
            org.mozilla.javascript.cb r0 = new org.mozilla.javascript.cb
            r0.<init>()
            org.mozilla.javascript.eh r2 = org.mozilla.javascript.C2193eh.Object
            org.mozilla.javascript.ScriptRuntime.m6384a(r0, r6, r2)
            java.lang.String r2 = "value"
            r0.defineProperty(r2, r1, r4)
            java.lang.String r1 = "writable"
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r5)
            r0.defineProperty(r1, r2, r4)
            java.lang.String r1 = "enumerable"
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r5)
            r0.defineProperty(r1, r2, r4)
            java.lang.String r1 = "configurable"
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r5)
            r0.defineProperty(r1, r2, r4)
        L_0x005b:
            return r0
        L_0x005c:
            r0 = -1
            goto L_0x0018
        L_0x005e:
            org.mozilla.javascript.ds r0 = super.getOwnPropertyDescriptor(r7, r8)
            goto L_0x005b
        L_0x0063:
            r6 = r0
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.getOwnPropertyDescriptor(org.mozilla.javascript.l, java.lang.Object):org.mozilla.javascript.ds");
    }

    /* access modifiers changed from: protected */
    public final void defineOwnProperty(Context lVar, Object obj, ScriptableObject dsVar, boolean z) {
        if (this.f6288f != null) {
            Object[] objArr = this.f6288f;
            this.f6288f = null;
            this.f6286b = false;
            for (int i = 0; i < objArr.length; i++) {
                if (objArr[i] != f6533j) {
                    put(i, (Scriptable) this, objArr[i]);
                }
            }
        }
        long a = m5977a(obj);
        if (a >= this.f6285a) {
            this.f6285a = a + 1;
        }
        super.defineOwnProperty(lVar, obj, dsVar, z);
    }

    /* renamed from: a */
    static long m5979a(Context lVar, Scriptable drVar) {
        if (drVar instanceof NativeString) {
            return (long) ((NativeString) drVar).f6384a.length();
        }
        if (drVar instanceof NativeArray) {
            return ((NativeArray) drVar).f6285a;
        }
        return ScriptRuntime.m6452g(ScriptRuntime.m6337a(drVar, "length", lVar));
    }

    /* renamed from: a */
    private static Object m5980a(Scriptable drVar, long j) {
        return ScriptRuntime.m6335a(drVar, "length", (Object) ScriptRuntime.m6313a((double) j));
    }

    /* renamed from: b */
    private static void m5995b(Scriptable drVar, long j) {
        int i = (int) j;
        if (((long) i) == j) {
            drVar.delete(i);
        } else {
            drVar.delete(Long.toString(j));
        }
    }

    /* renamed from: a */
    private static Object m5983a(Context lVar, Scriptable drVar, long j) {
        if (j > 2147483647L) {
            return ScriptRuntime.m6337a(drVar, Long.toString(j), lVar);
        }
        return ScriptRuntime.m6331a(drVar, (int) j);
    }

    /* renamed from: c */
    private static Object m5997c(Scriptable drVar, long j) {
        if (j > 2147483647L) {
            return ScriptableObject.getProperty(drVar, Long.toString(j));
        }
        return ScriptableObject.getProperty(drVar, (int) j);
    }

    /* renamed from: a */
    private static void m5990a(Scriptable drVar, long j, Object obj) {
        if (j > 2147483647L) {
            ScriptRuntime.m6335a(drVar, Long.toString(j), obj);
        } else {
            ScriptRuntime.m6332a(drVar, (int) j, obj);
        }
    }

    /* renamed from: b */
    private static void m5996b(Scriptable drVar, long j, Object obj) {
        if (obj == f6533j) {
            m5995b(drVar, j);
        } else {
            m5990a(drVar, j, obj);
        }
    }

    /* renamed from: a */
    private static String m5986a(Context lVar, Scriptable drVar, Scriptable drVar2, boolean z, boolean z2) {
        String str;
        boolean a;
        boolean z3;
        long j;
        boolean z4;
        long a2 = m5979a(lVar, drVar2);
        StringBuilder sb = new StringBuilder(256);
        if (z) {
            sb.append('[');
            str = ", ";
        } else {
            str = ",";
        }
        if (lVar.f6783g == null) {
            a = false;
            lVar.f6783g = new ObjToIntMap(31);
            z3 = true;
        } else {
            a = lVar.f6783g.mo18966a(drVar2);
            z3 = false;
        }
        if (!a) {
            try {
                lVar.f6783g.mo18968b(drVar2, 0);
                boolean z5 = !z || lVar.f6785i < 150;
                boolean z6 = false;
                long j2 = 0;
                while (j2 < a2) {
                    if (j2 > 0) {
                        sb.append(str);
                    }
                    Object c = m5997c(drVar2, j2);
                    if (c == f6533j || (z5 && (c == null || c == Undefined.f6689a))) {
                        z6 = false;
                    } else if (z) {
                        sb.append(ScriptRuntime.m6354a(lVar, drVar, c));
                        z6 = true;
                    } else if (c instanceof String) {
                        String str2 = (String) c;
                        if (z) {
                            sb.append(CoreConstants.DOUBLE_QUOTE_CHAR);
                            sb.append(ScriptRuntime.m6403b(str2));
                            sb.append(CoreConstants.DOUBLE_QUOTE_CHAR);
                            z6 = true;
                        } else {
                            sb.append(str2);
                            z6 = true;
                        }
                    } else {
                        if (z2) {
                            c = ScriptRuntime.m6426c(c, "toLocaleString", lVar).call(lVar, drVar, ScriptRuntime.m6470m(lVar), ScriptRuntime.f6517x);
                        }
                        sb.append(ScriptRuntime.m6436d(c));
                        z6 = true;
                    }
                    j2++;
                }
                z4 = z6;
                j = j2;
            } catch (Throwable th) {
                if (z3) {
                    lVar.f6783g = null;
                }
                throw th;
            }
        } else {
            j = 0;
            z4 = false;
        }
        if (z3) {
            lVar.f6783g = null;
        }
        if (z) {
            if (z4 || j <= 0) {
                sb.append(']');
            } else {
                sb.append(", ]");
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static Scriptable m5994b(Context lVar, Scriptable drVar) {
        if (drVar instanceof NativeArray) {
            NativeArray bcVar = (NativeArray) drVar;
            if (bcVar.f6286b) {
                int i = 0;
                for (int i2 = ((int) bcVar.f6285a) - 1; i < i2; i2--) {
                    Object obj = bcVar.f6288f[i];
                    bcVar.f6288f[i] = bcVar.f6288f[i2];
                    bcVar.f6288f[i2] = obj;
                    i++;
                }
                return drVar;
            }
        }
        long a = m5979a(lVar, drVar);
        long j = a / 2;
        for (long j2 = 0; j2 < j; j2++) {
            long j3 = (a - j2) - 1;
            Object c = m5997c(drVar, j2);
            m5996b(drVar, j2, m5997c(drVar, j3));
            m5996b(drVar, j3, c);
        }
        return drVar;
    }

    /* renamed from: a */
    private static Scriptable m5987a(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        Comparator beVar;
        if (objArr.length <= 0 || Undefined.f6689a == objArr[0]) {
            beVar = new C2147be();
        } else {
            beVar = new C2146bd(new Object[2], ScriptRuntime.m6413b(objArr[0], lVar), lVar, drVar, ScriptRuntime.m6470m(lVar));
        }
        int a = (int) m5979a(lVar, drVar2);
        Object[] objArr2 = new Object[a];
        for (int i = 0; i != a; i++) {
            objArr2[i] = m5983a(lVar, drVar2, (long) i);
        }
        Arrays.sort(objArr2, beVar);
        for (int i2 = 0; i2 < a; i2++) {
            m5990a(drVar2, (long) i2, objArr2[i2]);
        }
        return drVar2;
    }

    /* renamed from: a */
    private static Object m5984a(Context lVar, Scriptable drVar, Object[] objArr) {
        int i = 0;
        if (drVar instanceof NativeArray) {
            NativeArray bcVar = (NativeArray) drVar;
            if (bcVar.f6286b && bcVar.m5991a(((int) bcVar.f6285a) + objArr.length)) {
                while (i < objArr.length) {
                    Object[] objArr2 = bcVar.f6288f;
                    long j = bcVar.f6285a;
                    bcVar.f6285a = 1 + j;
                    objArr2[(int) j] = objArr[i];
                    i++;
                }
                return ScriptRuntime.m6313a((double) bcVar.f6285a);
            }
        }
        long a = m5979a(lVar, drVar);
        while (i < objArr.length) {
            m5990a(drVar, ((long) i) + a, objArr[i]);
            i++;
        }
        Object a2 = m5980a(drVar, ((long) objArr.length) + a);
        if (lVar.f6785i == 120) {
            return objArr.length == 0 ? Undefined.f6689a : objArr[objArr.length - 1];
        }
        return a2;
    }

    /* renamed from: c */
    private static Object m5998c(Context lVar, Scriptable drVar) {
        Object obj;
        if (drVar instanceof NativeArray) {
            NativeArray bcVar = (NativeArray) drVar;
            if (bcVar.f6286b && bcVar.f6285a > 0) {
                bcVar.f6285a--;
                Object obj2 = bcVar.f6288f[0];
                System.arraycopy(bcVar.f6288f, 1, bcVar.f6288f, 0, (int) bcVar.f6285a);
                bcVar.f6288f[(int) bcVar.f6285a] = f6533j;
                return obj2 == f6533j ? Undefined.f6689a : obj2;
            }
        }
        long a = m5979a(lVar, drVar);
        if (a > 0) {
            a--;
            obj = m5983a(lVar, drVar, 0);
            if (a > 0) {
                for (long j = 1; j <= a; j++) {
                    m5996b(drVar, j - 1, m5997c(drVar, j));
                }
            }
        } else {
            obj = Undefined.f6689a;
        }
        m5980a(drVar, a);
        return obj;
    }

    /* renamed from: b */
    private static Object m5993b(Context lVar, Scriptable drVar, Object[] objArr) {
        if (drVar instanceof NativeArray) {
            NativeArray bcVar = (NativeArray) drVar;
            if (bcVar.f6286b && bcVar.m5991a(((int) bcVar.f6285a) + objArr.length)) {
                System.arraycopy(bcVar.f6288f, 0, bcVar.f6288f, objArr.length, (int) bcVar.f6285a);
                for (int i = 0; i < objArr.length; i++) {
                    bcVar.f6288f[i] = objArr[i];
                }
                bcVar.f6285a += (long) objArr.length;
                return ScriptRuntime.m6313a((double) bcVar.f6285a);
            }
        }
        long a = m5979a(lVar, drVar);
        int length = objArr.length;
        if (objArr.length <= 0) {
            return ScriptRuntime.m6313a((double) a);
        }
        if (a > 0) {
            for (long j = a - 1; j >= 0; j--) {
                m5996b(drVar, ((long) length) + j, m5997c(drVar, j));
            }
        }
        for (int i2 = 0; i2 < objArr.length; i2++) {
            m5990a(drVar, (long) i2, objArr[i2]);
        }
        return m5980a(drVar, ((long) objArr.length) + a);
    }

    /* renamed from: b */
    private static Object m5992b(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        long j;
        long j2;
        int i;
        Object obj;
        NativeArray bcVar = null;
        boolean z = false;
        if (drVar2 instanceof NativeArray) {
            NativeArray bcVar2 = (NativeArray) drVar2;
            bcVar = bcVar2;
            z = bcVar2.f6286b;
        }
        Scriptable topLevelScope = getTopLevelScope(drVar);
        int length = objArr.length;
        if (length == 0) {
            return Context.m6751a(topLevelScope, 0);
        }
        long a = m5979a(lVar, drVar2);
        long a2 = m5976a(ScriptRuntime.m6440e(objArr[0]), a);
        int i2 = length - 1;
        if (objArr.length == 1) {
            j2 = a - a2;
            i = i2;
        } else {
            double e = ScriptRuntime.m6440e(objArr[1]);
            if (e < 0.0d) {
                j = 0;
            } else if (e > ((double) (a - a2))) {
                j = a - a2;
            } else {
                j = (long) e;
            }
            j2 = j;
            i = i2 - 1;
        }
        long j3 = a2 + j2;
        if (j2 != 0) {
            if (j2 == 1 && lVar.f6785i == 120) {
                obj = m5983a(lVar, drVar2, a2);
            } else if (z) {
                int i3 = (int) (j3 - a2);
                Object[] objArr2 = new Object[i3];
                System.arraycopy(bcVar.f6288f, (int) a2, objArr2, 0, i3);
                obj = Context.m6752a(topLevelScope, objArr2);
            } else {
                Scriptable a3 = Context.m6751a(topLevelScope, 0);
                for (long j4 = a2; j4 != j3; j4++) {
                    Object c = m5997c(drVar2, j4);
                    if (c != f6533j) {
                        m5990a(a3, j4 - a2, c);
                    }
                }
                m5980a(a3, j3 - a2);
                obj = a3;
            }
        } else if (lVar.f6785i == 120) {
            obj = Undefined.f6689a;
        } else {
            obj = Context.m6751a(topLevelScope, 0);
        }
        long j5 = ((long) i) - j2;
        if (!z || a + j5 >= 2147483647L || !bcVar.m5991a((int) (a + j5))) {
            if (j5 > 0) {
                for (long j6 = a - 1; j6 >= j3; j6--) {
                    m5996b(drVar2, j6 + j5, m5997c(drVar2, j6));
                }
            } else if (j5 < 0) {
                for (long j7 = j3; j7 < a; j7++) {
                    Scriptable drVar3 = drVar2;
                    m5996b(drVar3, j7 + j5, m5997c(drVar2, j7));
                }
            }
            int length2 = objArr.length - i;
            for (int i4 = 0; i4 < i; i4++) {
                m5990a(drVar2, ((long) i4) + a2, objArr[i4 + length2]);
            }
            m5980a(drVar2, a + j5);
            return obj;
        }
        System.arraycopy(bcVar.f6288f, (int) j3, bcVar.f6288f, (int) (((long) i) + a2), (int) (a - j3));
        if (i > 0) {
            System.arraycopy(objArr, 2, bcVar.f6288f, (int) a2, i);
        }
        if (j5 < 0) {
            Arrays.fill(bcVar.f6288f, (int) (a + j5), (int) a, f6533j);
        }
        bcVar.f6285a = a + j5;
        return obj;
    }

    /* renamed from: c */
    private static Scriptable m5999c(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        long j;
        long j2;
        long j3;
        int i;
        int i2;
        int i3;
        Scriptable topLevelScope = getTopLevelScope(drVar);
        Function a = ScriptRuntime.m6357a(topLevelScope, "Array");
        Scriptable construct = a.construct(lVar, topLevelScope, ScriptRuntime.f6517x);
        if ((drVar2 instanceof NativeArray) && (construct instanceof NativeArray)) {
            NativeArray bcVar = (NativeArray) drVar2;
            NativeArray bcVar2 = (NativeArray) construct;
            if (bcVar.f6286b && bcVar2.f6286b) {
                boolean z = true;
                int i4 = (int) bcVar.f6285a;
                int i5 = 0;
                while (true) {
                    int i6 = i4;
                    boolean z2 = z;
                    i = i6;
                    if (i5 < objArr.length && z2) {
                        if (objArr[i5] instanceof NativeArray) {
//                            NativeArray bcVar3 = objArr[i5];
//                            boolean z3 = bcVar3.f6286b;
//                            i4 = (int) (((long) i) + bcVar3.f6285a);
//                            z = z3;
                        } else {
                            int i7 = i + 1;
                            z = z2;
                            i4 = i7;
                        }
                        i5++;
                    } else if (z2 && bcVar2.m5991a(i)) {
                        System.arraycopy(bcVar.f6288f, 0, bcVar2.f6288f, 0, (int) bcVar.f6285a);
                        i2 = 0;
                        int i8 = (int) bcVar.f6285a;
                        while (true) {
                            i3 = i2;
                            if (i3 >= objArr.length || !z2) {
                                bcVar2.f6285a = (long) i;
                            } else {
                                if (objArr[i3] instanceof NativeArray) {
//                                    NativeArray bcVar4 = objArr[i3];
//                                    System.arraycopy(bcVar4.f6288f, 0, bcVar2.f6288f, i8, (int) bcVar4.f6285a);
//                                    i8 += (int) bcVar4.f6285a;
                                } else {
                                    int i9 = i8 + 1;
                                    bcVar2.f6288f[i8] = objArr[i3];
                                    i8 = i9;
                                }
                                i2 = i3 + 1;
                            }
                            break;
                        }
//                        bcVar2.f6285a = (long) i;
                        return construct;
                    }
                }
//                System.arraycopy(bcVar.f6288f, 0, bcVar2.f6288f, 0, (int) bcVar.f6285a);
//                i2 = 0;
//                int i82 = (int) bcVar.f6285a;
//                while (true) {
//                    i3 = i2;
//                    if (i3 >= objArr.length) {
//                        break;
//                    }
//                    break;
//                    i2 = i3 + 1;
//                }
//                bcVar2.f6285a = (long) i;
//                return construct;
            }
        }
        if (ScriptRuntime.m6439d(drVar2, a)) {
            long a2 = m5979a(lVar, drVar2);
            j = 0;
            while (j < a2) {
                Object c = m5997c(drVar2, j);
                if (c != f6533j) {
                    m5990a(construct, j, c);
                }
                j++;
            }
        } else {
            j = 1;
            m5990a(construct, 0, (Object) drVar2);
        }
        int i10 = 0;
        while (true) {
            j2 = j;
            if (i10 >= objArr.length) {
                break;
            }
            if (ScriptRuntime.m6439d(objArr[i10], a)) {
//                Scriptable drVar3 = objArr[i10];
//                long a3 = m5979a(lVar, drVar3);
//                long j4 = 0;
//                while (j4 < a3) {
//                    Object c2 = m5997c(drVar3, j4);
//                    if (c2 != f6533j) {
//                        m5990a(construct, j2, c2);
//                    }
//                    j4++;
//                    j2++;
//                }
//                j3 = j2;
            } else {
                j3 = 1 + j2;
                m5990a(construct, j2, objArr[i10]);
            }
            i10++;
        }
        m5980a(construct, j2);
        return construct;
    }

    /* renamed from: c */
    private Scriptable m6000c(Context lVar, Scriptable drVar, Object[] objArr) {
        long a;
        Scriptable a2 = Context.m6751a(getTopLevelScope(this), 0);
        long a3 = m5979a(lVar, drVar);
        if (objArr.length == 0) {
            a = 0;
        } else {
            a = m5976a(ScriptRuntime.m6440e(objArr[0]), a3);
            if (objArr.length != 1) {
                a3 = m5976a(ScriptRuntime.m6440e(objArr[1]), a3);
            }
        }
        for (long j = a; j < a3; j++) {
            Object c = m5997c(drVar, j);
            if (c != f6533j) {
                m5990a(a2, j - a, c);
            }
        }
        m5980a(a2, Math.max(0, a3 - a));
        return a2;
    }

    /* renamed from: a */
    private static long m5976a(double d, long j) {
        if (d < 0.0d) {
            if (((double) j) + d < 0.0d) {
                return 0;
            }
            return (long) (((double) j) + d);
        } else if (d <= ((double) j)) {
            return (long) d;
        } else {
            return j;
        }
    }

    /* renamed from: a */
    private static Object m5985a(Context lVar, Scriptable drVar, Object[] objArr, boolean z) {
        long j = 0;
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.f6689a;
        long a = m5979a(lVar, drVar);
        if (z) {
            if (objArr.length < 2) {
                j = a - 1;
            } else {
                j = (long) ScriptRuntime.m6440e(objArr[1]);
                if (j >= a) {
                    j = a - 1;
                } else if (j < 0) {
                    j += a;
                }
                if (j < 0) {
                    return f6283d;
                }
            }
        } else if (objArr.length < 2) {
            j = 0;
        } else {
            long e = (long) ScriptRuntime.m6440e(objArr[1]);
            if (e < 0) {
                e += a;
                if (e < 0) {
                    e = 0;
                }
            }
            if (j > a - 1) {
                return f6283d;
            }
        }
        if (drVar instanceof NativeArray) {
            NativeArray bcVar = (NativeArray) drVar;
            if (bcVar.f6286b) {
                if (z) {
                    for (int i = (int) j; i >= 0; i--) {
                        if (bcVar.f6288f[i] != Scriptable.f6533j && ScriptRuntime.m6430c(bcVar.f6288f[i], obj)) {
                            return Long.valueOf((long) i);
                        }
                    }
                } else {
                    for (int i2 = (int) j; ((long) i2) < a; i2++) {
                        if (bcVar.f6288f[i2] != Scriptable.f6533j && ScriptRuntime.m6430c(bcVar.f6288f[i2], obj)) {
                            return Long.valueOf((long) i2);
                        }
                    }
                }
                return f6283d;
            }
        }
        if (z) {
            while (j >= 0) {
                Object c = m5997c(drVar, j);
                if (c != f6533j && ScriptRuntime.m6430c(c, obj)) {
                    return Long.valueOf(j);
                }
                j--;
            }
        } else {
            while (j < a) {
                Object c2 = m5997c(drVar, j);
                if (c2 != f6533j && ScriptRuntime.m6430c(c2, obj)) {
                    return Long.valueOf(j);
                }
                j++;
            }
        }
        return f6283d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0071, code lost:
        continue;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Object m5981a(Context r16, int r17, Scriptable r18, Scriptable r19, Object[] r20) {
        /*
            r0 = r20
            int r2 = r0.length
            if (r2 <= 0) goto L_0x0013
            r2 = 0
            r2 = r20[r2]
        L_0x0008:
            if (r2 == 0) goto L_0x000e
            boolean r3 = r2 instanceof org.mozilla.javascript.Function
            if (r3 != 0) goto L_0x0016
        L_0x000e:
            java.lang.RuntimeException r2 = org.mozilla.javascript.ScriptRuntime.m6474o(r2)
            throw r2
        L_0x0013:
            java.lang.Object r2 = org.mozilla.javascript.Undefined.f6689a
            goto L_0x0008
        L_0x0016:
            org.mozilla.javascript.ab r2 = (org.mozilla.javascript.Function) r2
            org.mozilla.javascript.dr r4 = org.mozilla.javascript.ScriptableObject.getTopLevelScope(r2)
            r0 = r20
            int r3 = r0.length
            r5 = 2
            if (r3 < r5) goto L_0x002e
            r3 = 1
            r3 = r20[r3]
            if (r3 == 0) goto L_0x002e
            r3 = 1
            r3 = r20[r3]
            java.lang.Object r5 = org.mozilla.javascript.Undefined.f6689a
            if (r3 != r5) goto L_0x0076
        L_0x002e:
            r3 = r4
        L_0x002f:
            r0 = r16
            r1 = r19
            long r12 = m5979a(r0, r1)
            r5 = 20
            r0 = r17
            if (r0 != r5) goto L_0x0082
            int r5 = (int) r12
        L_0x003e:
            r0 = r18
            org.mozilla.javascript.dr r5 = org.mozilla.javascript.Context.m6751a(r0, r5)
            r8 = 0
            r6 = 0
            r10 = r6
            r6 = r8
        L_0x004a:
            int r8 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r8 >= 0) goto L_0x00ab
            r8 = 3
            java.lang.Object[] r14 = new java.lang.Object[r8]
            r0 = r19
            java.lang.Object r8 = m5997c(r0, r10)
            java.lang.Object r9 = org.mozilla.javascript.Scriptable.f6533j
            if (r8 == r9) goto L_0x0071
            r9 = 0
            r14[r9] = r8
            r8 = 1
            java.lang.Long r9 = java.lang.Long.valueOf(r10)
            r14[r8] = r9
            r8 = 2
            r14[r8] = r19
            r0 = r16
            java.lang.Object r8 = r2.call(r0, r4, r3, r14)
            switch(r17) {
                case 17: goto L_0x0084;
                case 18: goto L_0x008d;
                case 19: goto L_0x0071;
                case 20: goto L_0x009e;
                case 21: goto L_0x00a2;
                default: goto L_0x0071;
            }
        L_0x0071:
            r8 = 1
            long r8 = r8 + r10
            r10 = r8
            goto L_0x004a
        L_0x0076:
            r3 = 1
            r3 = r20[r3]
            r0 = r16
            r1 = r18
            org.mozilla.javascript.dr r3 = org.mozilla.javascript.ScriptRuntime.m6410b(r0, r1, r3)
            goto L_0x002f
        L_0x0082:
            r5 = 0
            goto L_0x003e
        L_0x0084:
            boolean r8 = org.mozilla.javascript.ScriptRuntime.m6391a(r8)
            if (r8 != 0) goto L_0x0071
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
        L_0x008c:
            return r2
        L_0x008d:
            boolean r8 = org.mozilla.javascript.ScriptRuntime.m6391a(r8)
            if (r8 == 0) goto L_0x0071
            r8 = 1
            long r8 = r8 + r6
            r15 = 0
            r14 = r14[r15]
            m5990a(r5, r6, r14)
            r6 = r8
            goto L_0x0071
        L_0x009e:
            m5990a(r5, r10, r8)
            goto L_0x0071
        L_0x00a2:
            boolean r8 = org.mozilla.javascript.ScriptRuntime.m6391a(r8)
            if (r8 == 0) goto L_0x0071
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            goto L_0x008c
        L_0x00ab:
            switch(r17) {
                case 17: goto L_0x00b1;
                case 18: goto L_0x00b4;
                case 19: goto L_0x00ae;
                case 20: goto L_0x00b4;
                case 21: goto L_0x00b6;
                default: goto L_0x00ae;
            }
        L_0x00ae:
            java.lang.Object r2 = org.mozilla.javascript.Undefined.f6689a
            goto L_0x008c
        L_0x00b1:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            goto L_0x008c
        L_0x00b4:
            r2 = r5
            goto L_0x008c
        L_0x00b6:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            goto L_0x008c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.m5981a(org.mozilla.javascript.l, int, org.mozilla.javascript.dr, org.mozilla.javascript.dr, java.lang.Object[]):java.lang.Object");
    }

    /* renamed from: a */
    private static Object m5982a(Context lVar, int i, Scriptable drVar, Object[] objArr) {
        Object obj;
        Object obj2 = objArr.length > 0 ? objArr[0] : Undefined.f6689a;
        if (obj2 == null || !(obj2 instanceof Function)) {
            throw ScriptRuntime.m6474o(obj2);
        }
        Function abVar = (Function) obj2;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(abVar);
        long a = m5979a(lVar, drVar);
        boolean z = i == 22;
        Object obj3 = objArr.length > 1 ? objArr[1] : Scriptable.f6533j;
        long j = 0;
        while (true) {
            obj = obj3;
            if (j >= a) {
                break;
            }
            long j2 = z ? j : (a - 1) - j;
            Object c = m5997c(drVar, j2);
            if (c == Scriptable.f6533j) {
                obj3 = obj;
            } else if (obj == Scriptable.f6533j) {
                obj3 = c;
            } else {
                obj3 = abVar.call(lVar, topLevelScope, topLevelScope, new Object[]{obj, c, Long.valueOf(j2), drVar});
            }
            j++;
        }
        if (obj != Scriptable.f6533j) {
            return obj;
        }
        throw ScriptRuntime.m6455g("msg.empty.array.reduce");
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public final Object[] toArray() {
        return toArray(ScriptRuntime.f6517x);
    }

    public final Object[] toArray(Object[] objArr) {
        long j = this.f6285a;
        if (j > 2147483647L) {
            throw new IllegalStateException();
        }
        int i = (int) j;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = get(i2);
        }
        return objArr;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Collection, code=java.util.Collection<java.lang.Object>, for r3v0, types: [java.util.Collection<java.lang.Object>, java.util.Collection] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public final boolean containsAll(Collection<Object> r3) {
//        /*
//            r2 = this;
//            java.util.Iterator r0 = r3.iterator()
//        L_0x0004:
//            boolean r1 = r0.hasNext()
//            if (r1 == 0) goto L_0x0016
//            java.lang.Object r1 = r0.next()
//            boolean r1 = r2.contains(r1)
//            if (r1 != 0) goto L_0x0004
//            r0 = 0
//        L_0x0015:
//            return r0
//        L_0x0016:
//            r0 = 1
//            goto L_0x0015
//        */
////        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.containsAll(java.util.Collection):boolean");
//
//        return false;
//    }

    public final int size() {
        long j = this.f6285a;
        if (j <= 2147483647L) {
            return (int) j;
        }
        throw new IllegalStateException();
    }

    public final Object get(int i) {
        long j = (long) i;
        if (j < 0 || j >= this.f6285a) {
            throw new IndexOutOfBoundsException();
        }
        Object c = m5997c((Scriptable) this, j);
        if (c == Scriptable.f6533j || c == Undefined.f6689a) {
            return null;
        }
        return c instanceof Wrapper ? ((Wrapper) c).mo18879a() : c;
    }

    public final int indexOf(Object obj) {
        int i = 0;
        long j = this.f6285a;
        if (j > 2147483647L) {
            throw new IllegalStateException();
        }
        int i2 = (int) j;
        if (obj == null) {
            while (i < i2) {
                if (get(i) == null) {
                    return i;
                }
                i++;
            }
        } else {
            while (i < i2) {
                if (obj.equals(get(i))) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        long j = this.f6285a;
        if (j > 2147483647L) {
            throw new IllegalStateException();
        }
        int i = (int) j;
        if (obj == null) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (get(i2) == null) {
                    return i2;
                }
            }
        } else {
            for (int i3 = i - 1; i3 >= 0; i3--) {
                if (obj.equals(get(i3))) {
                    return i3;
                }
            }
        }
        return -1;
    }

    public final Iterator iterator() {
        return listIterator(0);
    }

    public final ListIterator listIterator() {
        return listIterator(0);
    }

    public final ListIterator listIterator(int i) {
        long j = this.f6285a;
        if (j > 2147483647L) {
            throw new IllegalStateException();
        }
        int i2 = (int) j;
        if (i >= 0 && i <= i2) {
            return new C2148bf(this, i, i2);
        }
        throw new IndexOutOfBoundsException("Index: " + i);
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(@NonNull Collection c) {
        return false;
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    public final List subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int findPrototypeId(String r9) {
        /*
            r8 = this;
            r4 = 3
            r6 = 112(0x70, float:1.57E-43)
            r2 = 2
            r3 = 1
            r0 = 0
            r1 = 0
            int r5 = r9.length()
            switch(r5) {
                case 3: goto L_0x001b;
                case 4: goto L_0x0047;
                case 5: goto L_0x006f;
                case 6: goto L_0x0098;
                case 7: goto L_0x00d0;
                case 8: goto L_0x00fe;
                case 9: goto L_0x000e;
                case 10: goto L_0x000e;
                case 11: goto L_0x0119;
                case 12: goto L_0x000e;
                case 13: goto L_0x000e;
                case 14: goto L_0x0141;
                default: goto L_0x000e;
            }
        L_0x000e:
            r2 = r1
            r1 = r0
        L_0x0010:
            if (r2 == 0) goto L_0x0147
            if (r2 == r9) goto L_0x0147
            boolean r2 = r2.equals(r9)
            if (r2 != 0) goto L_0x0147
        L_0x001a:
            return r0
        L_0x001b:
            char r4 = r9.charAt(r0)
            r5 = 109(0x6d, float:1.53E-43)
            if (r4 != r5) goto L_0x0034
            char r2 = r9.charAt(r2)
            if (r2 != r6) goto L_0x000e
            char r2 = r9.charAt(r3)
            r3 = 97
            if (r2 != r3) goto L_0x000e
            r0 = 20
            goto L_0x001a
        L_0x0034:
            if (r4 != r6) goto L_0x000e
            char r2 = r9.charAt(r2)
            if (r2 != r6) goto L_0x000e
            char r2 = r9.charAt(r3)
            r3 = 111(0x6f, float:1.56E-43)
            if (r2 != r3) goto L_0x000e
            r0 = 9
            goto L_0x001a
        L_0x0047:
            char r2 = r9.charAt(r2)
            switch(r2) {
                case 105: goto L_0x0051;
                case 109: goto L_0x0058;
                case 114: goto L_0x0060;
                case 115: goto L_0x0067;
                default: goto L_0x004e;
            }
        L_0x004e:
            r2 = r1
            r1 = r0
            goto L_0x0010
        L_0x0051:
            java.lang.String r1 = "join"
            r2 = 5
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0058:
            java.lang.String r1 = "some"
            r2 = 21
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0060:
            java.lang.String r1 = "sort"
            r2 = 7
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0067:
            java.lang.String r1 = "push"
            r2 = 8
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x006f:
            char r2 = r9.charAt(r3)
            r3 = 104(0x68, float:1.46E-43)
            if (r2 != r3) goto L_0x007f
            java.lang.String r1 = "shift"
            r2 = 10
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x007f:
            r3 = 108(0x6c, float:1.51E-43)
            if (r2 != r3) goto L_0x008b
            java.lang.String r1 = "slice"
            r2 = 14
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x008b:
            r3 = 118(0x76, float:1.65E-43)
            if (r2 != r3) goto L_0x000e
            java.lang.String r1 = "every"
            r2 = 17
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0098:
            char r2 = r9.charAt(r0)
            r3 = 99
            if (r2 != r3) goto L_0x00a9
            java.lang.String r1 = "concat"
            r2 = 13
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00a9:
            r3 = 102(0x66, float:1.43E-43)
            if (r2 != r3) goto L_0x00b6
            java.lang.String r1 = "filter"
            r2 = 18
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00b6:
            r3 = 115(0x73, float:1.61E-43)
            if (r2 != r3) goto L_0x00c3
            java.lang.String r1 = "splice"
            r2 = 12
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00c3:
            r3 = 114(0x72, float:1.6E-43)
            if (r2 != r3) goto L_0x000e
            java.lang.String r1 = "reduce"
            r2 = 22
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00d0:
            char r2 = r9.charAt(r0)
            switch(r2) {
                case 102: goto L_0x00db;
                case 105: goto L_0x00e4;
                case 114: goto L_0x00ed;
                case 117: goto L_0x00f5;
                default: goto L_0x00d7;
            }
        L_0x00d7:
            r2 = r1
            r1 = r0
            goto L_0x0010
        L_0x00db:
            java.lang.String r1 = "forEach"
            r2 = 19
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00e4:
            java.lang.String r1 = "indexOf"
            r2 = 15
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00ed:
            java.lang.String r1 = "reverse"
            r2 = 6
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00f5:
            java.lang.String r1 = "unshift"
            r2 = 11
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00fe:
            char r3 = r9.charAt(r4)
            r4 = 111(0x6f, float:1.56E-43)
            if (r3 != r4) goto L_0x010e
            java.lang.String r1 = "toSource"
            r2 = 4
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x010e:
            r4 = 116(0x74, float:1.63E-43)
            if (r3 != r4) goto L_0x000e
            java.lang.String r1 = "toString"
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0119:
            char r2 = r9.charAt(r0)
            r4 = 99
            if (r2 != r4) goto L_0x0127
            java.lang.String r1 = "constructor"
            r2 = r1
            r1 = r3
            goto L_0x0010
        L_0x0127:
            r3 = 108(0x6c, float:1.51E-43)
            if (r2 != r3) goto L_0x0134
            java.lang.String r1 = "lastIndexOf"
            r2 = 16
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0134:
            r3 = 114(0x72, float:1.6E-43)
            if (r2 != r3) goto L_0x000e
            java.lang.String r1 = "reduceRight"
            r2 = 23
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0141:
            java.lang.String r1 = "toLocaleString"
            r2 = r1
            r1 = r4
            goto L_0x0010
        L_0x0147:
            r0 = r1
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.findPrototypeId(java.lang.String):int");
    }
}
