package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.a */
final class Arguments extends IdScriptableObject {

    /* renamed from: a */
    private Object f5977a;

    /* renamed from: b */
    private Object f5978b;

    /* renamed from: c */
    private Object f5979c = Integer.valueOf(this.f5982f.length);

    /* renamed from: d */
    private Object f5980d;

    /* renamed from: e */
    private NativeCall f5981e;

    /* renamed from: f */
    private Object[] f5982f;

    public Arguments(NativeCall bhVar) {
        this.f5981e = bhVar;
        Scriptable parentScope = bhVar.getParentScope();
        setParentScope(parentScope);
        setPrototype(ScriptableObject.getObjectPrototype(parentScope));
        this.f5982f = bhVar.f6302b;
        NativeFunction blVar = bhVar.f6301a;
        this.f5978b = blVar;
        this.f5980d = getProperty(getTopLevelScope(parentScope), "Object");
        int b = blVar.mo18681b();
        if (b > 130 || b == 0) {
            this.f5977a = f6533j;
        } else {
            this.f5977a = null;
        }
    }

    public final String getClassName() {
        return "Arguments";
    }

    /* renamed from: a */
    private Object m5640a(int i) {
        if (i < 0 || this.f5982f.length <= i) {
            return f6533j;
        }
        return this.f5982f[i];
    }

    /* renamed from: b */
    private Object m5642b(int i) {
        return this.f5981e.get(this.f5981e.f6301a.mo18680a(i), this.f5981e);
    }

    /* renamed from: a */
    private void m5641a(int i, Object obj) {
        if (m5644d(i)) {
            this.f5981e.put(this.f5981e.f6301a.mo18680a(i), this.f5981e, obj);
        }
        synchronized (this) {
            if (this.f5982f == this.f5981e.f6302b) {
                this.f5982f = (Object[]) this.f5982f.clone();
            }
            this.f5982f[i] = obj;
        }
    }

    /* renamed from: c */
    private void m5643c(int i) {
        synchronized (this) {
            if (this.f5982f[i] != f6533j) {
                if (this.f5982f == this.f5981e.f6302b) {
                    this.f5982f = (Object[]) this.f5982f.clone();
                }
                this.f5982f[i] = f6533j;
            }
        }
    }

    public final boolean has(int i, Scriptable drVar) {
        if (m5640a(i) != f6533j) {
            return true;
        }
        return super.has(i, drVar);
    }

    public final Object get(int i, Scriptable drVar) {
        Object a = m5640a(i);
        if (a == f6533j) {
            return super.get(i, drVar);
        }
        if (m5644d(i)) {
            return m5642b(i);
        }
        return a;
    }

    /* renamed from: d */
    private boolean m5644d(int i) {
        NativeFunction blVar = this.f5981e.f6301a;
        int c = blVar.mo18683c();
        if (i >= c) {
            return false;
        }
        if (i < c - 1) {
            String a = blVar.mo18680a(i);
            for (int i2 = i + 1; i2 < c; i2++) {
                if (a.equals(blVar.mo18680a(i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void put(int i, Scriptable drVar, Object obj) {
        if (m5640a(i) == f6533j) {
            super.put(i, drVar, obj);
        } else {
            m5641a(i, obj);
        }
    }

    public final void delete(int i) {
        if (i >= 0 && i < this.f5982f.length) {
            m5643c(i);
        }
        super.delete(i);
    }

    /* access modifiers changed from: protected */
    public final int getMaxInstanceId() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public final int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int i2 = 0;
        int length = str.length();
        if (length == 6) {
            char charAt = str.charAt(5);
            if (charAt == 'e') {
                i = 1;
                str2 = "callee";
            } else if (charAt == 'h') {
                str2 = "length";
                i = 2;
            } else {
                if (charAt == 'r') {
                    i = 3;
                    str2 = "caller";
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 11) {
                i = 4;
                str2 = "constructor";
            }
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            i2 = i;
        }
        if (i2 == 0) {
            return super.findInstanceIdInfo(str);
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
                return instanceIdInfo(2, i2);
            default:
                throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: protected */
    public final String getInstanceIdName(int i) {
        switch (i) {
            case 1:
                return "callee";
            case 2:
                return "length";
            case 3:
                return "caller";
            case 4:
                return "constructor";
            default:
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public final Object getInstanceIdValue(int i) {
        switch (i) {
            case 1:
                return this.f5978b;
            case 2:
                return this.f5979c;
            case 3:
                Object obj = this.f5977a;
                if (obj == UniqueTag.f6691b) {
                    return null;
                }
                if (obj != null) {
                    return obj;
                }
                NativeCall bhVar = this.f5981e.f6303c;
                if (bhVar != null) {
                    return bhVar.get("arguments", bhVar);
                }
                return obj;
            case 4:
                return this.f5980d;
            default:
                return super.getInstanceIdValue(i);
        }
    }

    /* access modifiers changed from: protected */
    public final void setInstanceIdValue(int i, Object obj) {
        switch (i) {
            case 1:
                this.f5978b = obj;
                return;
            case 2:
                this.f5979c = obj;
                return;
            case 3:
                if (obj == null) {
                    obj = UniqueTag.f6691b;
                }
                this.f5977a = obj;
                return;
            case 4:
                this.f5980d = obj;
                return;
            default:
                super.setInstanceIdValue(i, obj);
                return;
        }
    }

    /* access modifiers changed from: 0000 */
    public final Object[] getIds(boolean z) {
        Object[] ids = super.getIds(z);
        if (this.f5982f.length != 0) {
            boolean[] zArr = new boolean[this.f5982f.length];
            int length = this.f5982f.length;
            for (int i = 0; i != ids.length; i++) {
                Object obj = ids[i];
                if (obj instanceof Integer) {
                    int intValue = ((Integer) obj).intValue();
                    if (intValue >= 0 && intValue < this.f5982f.length && !zArr[intValue]) {
                        zArr[intValue] = true;
                        length--;
                    }
                }
            }
            if (!z) {
                for (int i2 = 0; i2 < zArr.length; i2++) {
                    if (!zArr[i2] && super.has(i2, (Scriptable) this)) {
                        zArr[i2] = true;
                        length--;
                    }
                }
            }
            if (length != 0) {
                Object[] objArr = new Object[(ids.length + length)];
                System.arraycopy(ids, 0, objArr, length, ids.length);
                int i3 = 0;
                for (int i4 = 0; i4 != this.f5982f.length; i4++) {
                    if (!zArr[i4]) {
                        objArr[i3] = Integer.valueOf(i4);
                        i3++;
                    }
                }
                if (i3 != length) {
                    Kit.m5810a();
                }
                return objArr;
            }
        }
        return ids;
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [org.mozilla.javascript.dr] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.mozilla.javascript.ScriptableObject getOwnPropertyDescriptor(Context r7, Object r8) {
        /*
            r6 = this;
            double r0 = org.mozilla.javascript.ScriptRuntime.m6395b(r8)
            int r2 = (int) r0
            double r4 = (double) r2
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x000f
            org.mozilla.javascript.ds r0 = super.getOwnPropertyDescriptor(r7, r8)
        L_0x000e:
            return r0
        L_0x000f:
            java.lang.Object r0 = r6.m5640a(r2)
            java.lang.Object r1 = f6533j
            if (r0 != r1) goto L_0x001c
            org.mozilla.javascript.ds r0 = super.getOwnPropertyDescriptor(r7, r8)
            goto L_0x000e
        L_0x001c:
            boolean r1 = r6.m5644d(r2)
            if (r1 == 0) goto L_0x0026
            java.lang.Object r0 = r6.m5642b(r2)
        L_0x0026:
            boolean r1 = super.has(r2, r6)
            if (r1 == 0) goto L_0x0037
            org.mozilla.javascript.ds r1 = super.getOwnPropertyDescriptor(r7, r8)
            java.lang.String r2 = "value"
            r1.put(r2, r1, r0)
            r0 = r1
            goto L_0x000e
        L_0x0037:
            org.mozilla.javascript.dr r1 = r6.getParentScope()
            if (r1 != 0) goto L_0x0043
        L_0x003d:
            r1 = 0
            org.mozilla.javascript.ds r0 = buildDataDescriptor(r6, r0, r1)
            goto L_0x000e
        L_0x0043:
            r6 = r1
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Arguments.getOwnPropertyDescriptor(org.mozilla.javascript.l, java.lang.Object):org.mozilla.javascript.ds");
    }

    /* access modifiers changed from: protected */
    public final void defineOwnProperty(Context lVar, Object obj, ScriptableObject dsVar, boolean z) {
        super.defineOwnProperty(lVar, obj, dsVar, z);
        double b = ScriptRuntime.m6395b(obj);
        int i = (int) b;
        if (b != ((double) i) || m5640a(i) == f6533j) {
            return;
        }
        if (isAccessorDescriptor(dsVar)) {
            m5643c(i);
            return;
        }
        Object property = getProperty((Scriptable) dsVar, "value");
        if (property != f6533j) {
            m5641a(i, property);
            if (isFalse(getProperty((Scriptable) dsVar, "writable"))) {
                m5643c(i);
            }
        }
    }
}
