package org.mozilla.javascript;

import java.io.Serializable;

/* renamed from: org.mozilla.javascript.cr */
public final class ObjToIntMap implements Serializable {
    /* access modifiers changed from: 0000 */

    /* renamed from: a */
    public static final Object f6415a = new Object();

    /* renamed from: b */
    transient Object[] f6416b;

    /* renamed from: c */
    public transient int[] f6417c;

    /* renamed from: d */
    public int f6418d;

    /* renamed from: e */
    private int f6419e;

    /* renamed from: f */
    private transient int f6420f;

    public ObjToIntMap() {
        this(4);
    }

    public ObjToIntMap(int i) {
        if (i < 0) {
            Kit.m5810a();
        }
        int i2 = 2;
        while ((1 << i2) < (i * 4) / 3) {
            i2++;
        }
        this.f6419e = i2;
    }

    /* renamed from: a */
    public final boolean mo18966a(Object obj) {
        if (obj == null) {
            obj = UniqueTag.f6691b;
        }
        return mo18969c(obj) >= 0;
    }

    /* renamed from: a */
    public final int mo18964a(Object obj, int i) {
        if (obj == null) {
            obj = UniqueTag.f6691b;
        }
        int c = mo18969c(obj);
        if (c >= 0) {
            return this.f6417c[c];
        }
        return i;
    }

    /* renamed from: b */
    public final void mo18968b(Object obj, int i) {
        if (obj == null) {
            obj = UniqueTag.f6691b;
        }
        this.f6417c[m6171d(obj)] = i;
    }

    /* renamed from: b */
    public final Object mo18967b(Object obj) {
        boolean z;
        if (obj == null) {
            z = true;
            obj = UniqueTag.f6691b;
        } else {
            z = false;
        }
        int d = m6171d(obj);
        this.f6417c[d] = 0;
        if (z) {
            return null;
        }
        return this.f6416b[d];
    }

    /* renamed from: a */
    public final C2163cs mo18965a() {
        return new C2163cs(this);
    }

    /* renamed from: a */
    private static int m6168a(int i, int i2, int i3) {
        int i4 = 32 - (i3 * 2);
        if (i4 >= 0) {
            return ((i >>> i4) & i2) | 1;
        }
        return ((i2 >>> (-i4)) & i) | 1;
    }

    /* renamed from: c */
    public final int mo18969c(Object obj) {
        if (this.f6416b != null) {
            int hashCode = obj.hashCode();
            int i = hashCode * -1640531527;
            int i2 = i >>> (32 - this.f6419e);
            Object obj2 = this.f6416b[i2];
            if (obj2 != null) {
                int i3 = 1 << this.f6419e;
                if (obj2 == obj) {
                    return i2;
                }
                if (this.f6417c[i3 + i2] != hashCode || !obj2.equals(obj)) {
                    int i4 = i3 - 1;
                    int a = m6168a(i, i4, this.f6419e);
                    while (true) {
                        i2 = (i2 + a) & i4;
                        Object obj3 = this.f6416b[i2];
                        if (obj3 == null) {
                            break;
                        } else if (obj3 == obj) {
                            return i2;
                        } else {
                            if (this.f6417c[i3 + i2] == hashCode && obj3.equals(obj)) {
                                return i2;
                            }
                        }
                    }
                } else {
                    return i2;
                }
            }
        }
        return -1;
    }

    /* renamed from: c */
    private int m6170c(Object obj, int i) {
        int i2 = i * -1640531527;
        int i3 = i2 >>> (32 - this.f6419e);
        int i4 = 1 << this.f6419e;
        if (this.f6416b[i3] != null) {
            int i5 = i4 - 1;
            int a = m6168a(i2, i5, this.f6419e);
            do {
                i3 = (i3 + a) & i5;
            } while (this.f6416b[i3] != null);
        }
        this.f6416b[i3] = obj;
        this.f6417c[i4 + i3] = i;
        this.f6420f++;
        this.f6418d++;
        return i3;
    }

    /* renamed from: d */
    private int m6171d(Object obj) {
        int i;
        int i2 = -1;
        int hashCode = obj.hashCode();
        if (this.f6416b != null) {
            int i3 = hashCode * -1640531527;
            i = i3 >>> (32 - this.f6419e);
            Object obj2 = this.f6416b[i];
            if (obj2 != null) {
                int i4 = 1 << this.f6419e;
                if (obj2 == obj) {
                    return i;
                }
                if (this.f6417c[i4 + i] != hashCode || !obj2.equals(obj)) {
                    if (obj2 == f6415a) {
                        i2 = i;
                    }
                    int i5 = i4 - 1;
                    int a = m6168a(i3, i5, this.f6419e);
                    while (true) {
                        i = (i + a) & i5;
                        Object obj3 = this.f6416b[i];
                        if (obj3 == null) {
                            break;
                        } else if (obj3 == obj) {
                            return i;
                        } else {
                            if (this.f6417c[i4 + i] == hashCode && obj3.equals(obj)) {
                                return i;
                            }
                            if (obj3 == f6415a && i2 < 0) {
                                i2 = i;
                            }
                        }
                    }
                } else {
                    return i;
                }
            }
        } else {
            i = -1;
        }
        if (i2 < 0) {
            if (this.f6416b == null || this.f6420f * 4 >= (1 << this.f6419e) * 3) {
                if (this.f6416b == null) {
                    int i6 = 1 << this.f6419e;
                    this.f6416b = new Object[i6];
                    this.f6417c = new int[(i6 * 2)];
                } else {
                    if (this.f6418d * 2 >= this.f6420f) {
                        this.f6419e++;
                    }
                    int i7 = 1 << this.f6419e;
                    Object[] objArr = this.f6416b;
                    int[] iArr = this.f6417c;
                    int length = objArr.length;
                    this.f6416b = new Object[i7];
                    this.f6417c = new int[(i7 * 2)];
                    int i8 = this.f6418d;
                    this.f6418d = 0;
                    this.f6420f = 0;
                    int i9 = 0;
                    while (i8 != 0) {
                        Object obj4 = objArr[i9];
                        if (!(obj4 == null || obj4 == f6415a)) {
                            this.f6417c[m6170c(obj4, iArr[length + i9])] = iArr[i9];
                            i8--;
                        }
                        i9++;
                    }
                }
                return m6170c(obj, hashCode);
            }
            this.f6420f++;
            i2 = i;
        }
        this.f6416b[i2] = obj;
        this.f6417c[(1 << this.f6419e) + i2] = hashCode;
        this.f6418d++;
        return i2;
    }
}
