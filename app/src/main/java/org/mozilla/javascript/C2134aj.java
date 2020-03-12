package org.mozilla.javascript;

import java.io.Serializable;

/* renamed from: org.mozilla.javascript.aj */
/* compiled from: IdScriptableObject */
final class C2134aj implements Serializable {

    /* renamed from: a */
    IdScriptableObject f6000a;

    /* renamed from: b */
    int f6001b;

    /* renamed from: c */
    Object[] f6002c;

    /* renamed from: d */
    short[] f6003d;

    /* renamed from: e */
    int f6004e;

    /* renamed from: f */
    IdFunctionObject f6005f;

    /* renamed from: g */
    private short f6006g;

    C2134aj(IdScriptableObject aiVar, int i) {
        if (aiVar == null) {
            throw new IllegalArgumentException();
        } else if (i <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.f6000a = aiVar;
            this.f6001b = i;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18671a(int i, String str, Object obj, int i2) {
        if (i <= 0 || i > this.f6001b) {
            throw new IllegalArgumentException();
        } else if (str == null) {
            throw new IllegalArgumentException();
        } else if (obj == Scriptable.f6533j) {
            throw new IllegalArgumentException();
        } else {
            ScriptableObject.checkValidAttributes(i2);
            if (this.f6000a.findPrototypeId(str) != i) {
                throw new IllegalArgumentException(str);
            } else if (i != this.f6004e) {
                m5703b(i, str, obj, i2);
            } else if (!(obj instanceof IdFunctionObject)) {
                throw new IllegalArgumentException("consructor should be initialized with IdFunctionObject");
            } else {
                this.f6005f = (IdFunctionObject) obj;
                this.f6006g = (short) i2;
            }
        }
    }

    /* renamed from: b */
    private void m5703b(int i, String str, Object obj, int i2) {
        Object[] objArr = this.f6002c;
        if (objArr == null) {
            throw new IllegalStateException();
        }
        if (obj == null) {
            obj = UniqueTag.f6691b;
        }
        int i3 = (i - 1) * 2;
        synchronized (this) {
            if (objArr[i3] == null) {
                objArr[i3] = obj;
                objArr[i3 + 1] = str;
                this.f6003d[i - 1] = (short) i2;
            } else if (!str.equals(objArr[i3 + 1])) {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo18668a(String str) {
        return this.f6000a.findPrototypeId(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Object mo18669a(int i) {
        Object d = mo18675d(i);
        if (d == UniqueTag.f6691b) {
            return null;
        }
        return d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18672a(int i, Scriptable drVar, Object obj) {
        if (obj == Scriptable.f6533j) {
            throw new IllegalArgumentException();
        }
        mo18675d(i);
        if ((this.f6003d[i - 1] & 1) != 0) {
            return;
        }
        if (drVar == this.f6000a) {
            if (obj == null) {
                obj = UniqueTag.f6691b;
            }
            int i2 = (i - 1) * 2;
            synchronized (this) {
                this.f6002c[i2] = obj;
            }
            return;
        }
        drVar.put((String) this.f6002c[((i - 1) * 2) + 1], drVar, obj);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo18673b(int i) {
        mo18675d(i);
        if ((this.f6003d[i - 1] & 4) == 0) {
            int i2 = (i - 1) * 2;
            synchronized (this) {
                this.f6002c[i2] = Scriptable.f6533j;
                this.f6003d[i - 1] = 0;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final int mo18674c(int i) {
        mo18675d(i);
        return this.f6003d[i - 1];
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18670a(int i, int i2) {
        ScriptableObject.checkValidAttributes(i2);
        mo18675d(i);
        synchronized (this) {
            this.f6003d[i - 1] = (short) i2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final Object mo18675d(int i) {
        Object[] objArr = this.f6002c;
        if (objArr == null) {
            synchronized (this) {
                objArr = this.f6002c;
                if (objArr == null) {
                    objArr = new Object[(this.f6001b * 2)];
                    this.f6002c = objArr;
                    this.f6003d = new short[this.f6001b];
                }
            }
        }
        int i2 = (i - 1) * 2;
        Object obj = objArr[i2];
        if (obj != null) {
            return obj;
        }
        if (i == this.f6004e) {
            m5703b(this.f6004e, "constructor", this.f6005f, this.f6006g);
            this.f6005f = null;
        } else {
            this.f6000a.initPrototypeId(i);
        }
        Object obj2 = objArr[i2];
        if (obj2 != null) {
            return obj2;
        }
        throw new IllegalStateException(this.f6000a.getClass().getName() + ".initPrototypeId(int id) did not initialize id=" + i);
    }
}
