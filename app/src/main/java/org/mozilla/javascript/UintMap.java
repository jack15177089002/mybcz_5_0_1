package org.mozilla.javascript;

import java.io.Serializable;

/* renamed from: org.mozilla.javascript.ei */
public final class UintMap implements Serializable {

    /* renamed from: a */
    public transient int[] f6683a;

    /* renamed from: b */
    public transient Object[] f6684b;

    /* renamed from: c */
    public int f6685c;

    /* renamed from: d */
    public int f6686d;

    /* renamed from: e */
    transient int f6687e;

    /* renamed from: f */
    private transient int f6688f;

    public UintMap() {
        this(4);
    }

    public UintMap(int i) {
        if (i < 0) {
            Kit.m5810a();
        }
        int i2 = 2;
        while ((1 << i2) < (i * 4) / 3) {
            i2++;
        }
        this.f6685c = i2;
    }

    /* renamed from: a */
    public final int mo19091a(int i, int i2) {
        if (i < 0) {
            Kit.m5810a();
        }
        int a = mo19090a(i);
        if (a < 0) {
            return i2;
        }
        if (this.f6687e != 0) {
            return this.f6683a[a + this.f6687e];
        }
        return 0;
    }

    /* renamed from: b */
    public final void mo19093b(int i, int i2) {
        if (i < 0) {
            Kit.m5810a();
        }
        int a = mo19092a(i, true);
        if (this.f6687e == 0) {
            int i3 = 1 << this.f6685c;
            if (this.f6683a.length != i3 * 2) {
                int[] iArr = new int[(i3 * 2)];
                System.arraycopy(this.f6683a, 0, iArr, 0, i3);
                this.f6683a = iArr;
            }
            this.f6687e = i3;
        }
        this.f6683a[a + this.f6687e] = i2;
    }

    /* renamed from: a */
    private static int m6649a(int i, int i2, int i3) {
        int i4 = 32 - (i3 * 2);
        if (i4 >= 0) {
            return ((i >>> i4) & i2) | 1;
        }
        return ((i2 >>> (-i4)) & i) | 1;
    }

    /* renamed from: a */
    public final int mo19090a(int i) {
        int i2;
        int[] iArr = this.f6683a;
        if (iArr != null) {
            int i3 = i * -1640531527;
            int i4 = i3 >>> (32 - this.f6685c);
            int i5 = iArr[i4];
            if (i5 == i) {
                return i4;
            }
            if (i5 != -1) {
                int i6 = (1 << this.f6685c) - 1;
                int a = m6649a(i3, i6, this.f6685c);
                do {
                    i4 = (i4 + a) & i6;
                    i2 = iArr[i4];
                    if (i2 == i) {
                        return i4;
                    }
                } while (i2 != -1);
            }
        }
        return -1;
    }

    /* renamed from: b */
    private int m6650b(int i) {
        int[] iArr = this.f6683a;
        int i2 = i * -1640531527;
        int i3 = i2 >>> (32 - this.f6685c);
        if (iArr[i3] != -1) {
            int i4 = (1 << this.f6685c) - 1;
            int a = m6649a(i2, i4, this.f6685c);
            do {
                i3 = (i3 + a) & i4;
            } while (iArr[i3] != -1);
        }
        iArr[i3] = i;
        this.f6688f++;
        this.f6686d++;
        return i3;
    }

    /* renamed from: a */
    public final int mo19092a(int i, boolean z) {
        int i2;
        int i3;
        int i4;
        int[] iArr = this.f6683a;
        if (iArr != null) {
            int i5 = i * -1640531527;
            i3 = i5 >>> (32 - this.f6685c);
            int i6 = iArr[i3];
            if (i6 == i) {
                return i3;
            }
            if (i6 != -1) {
                if (i6 == -2) {
                    i2 = i3;
                } else {
                    i2 = -1;
                }
                int i7 = (1 << this.f6685c) - 1;
                int a = m6649a(i5, i7, this.f6685c);
                do {
                    i3 = (i3 + a) & i7;
                    i4 = iArr[i3];
                    if (i4 == i) {
                        return i3;
                    }
                    if (i4 == -2 && i2 < 0) {
                        i2 = i3;
                        continue;
                    }
                } while (i4 != -1);
            } else {
                i2 = -1;
            }
        } else {
            i2 = -1;
            i3 = -1;
        }
        if (i2 < 0) {
            if (iArr == null || this.f6688f * 4 >= (1 << this.f6685c) * 3) {
                if (this.f6683a != null && this.f6686d * 2 >= this.f6688f) {
                    this.f6685c++;
                }
                int i8 = 1 << this.f6685c;
                int[] iArr2 = this.f6683a;
                int i9 = this.f6687e;
                if (i9 != 0 || z) {
                    this.f6687e = i8;
                    this.f6683a = new int[(i8 * 2)];
                } else {
                    this.f6683a = new int[i8];
                }
                for (int i10 = 0; i10 != i8; i10++) {
                    this.f6683a[i10] = -1;
                }
                Object[] objArr = this.f6684b;
                if (objArr != null) {
                    this.f6684b = new Object[i8];
                }
                int i11 = this.f6686d;
                this.f6688f = 0;
                if (i11 != 0) {
                    this.f6686d = 0;
                    int i12 = 0;
                    while (i11 != 0) {
                        int i13 = iArr2[i12];
                        if (!(i13 == -1 || i13 == -2)) {
                            int b = m6650b(i13);
                            if (objArr != null) {
                                this.f6684b[b] = objArr[i12];
                            }
                            if (i9 != 0) {
                                this.f6683a[b + this.f6687e] = iArr2[i9 + i12];
                            }
                            i11--;
                        }
                        i12++;
                    }
                }
                return m6650b(i);
            }
            this.f6688f++;
            i2 = i3;
        }
        iArr[i2] = i;
        this.f6686d++;
        return i2;
    }
}
