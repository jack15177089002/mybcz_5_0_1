package org.mozilla.javascript.p113e;

import java.util.BitSet;
import org.mozilla.javascript.Node;

/* renamed from: org.mozilla.javascript.e.a */
/* compiled from: Block */
final class C2184a {

    /* renamed from: a */
    C2184a[] f6550a;

    /* renamed from: b */
    C2184a[] f6551b;

    /* renamed from: c */
    int f6552c;

    /* renamed from: d */
    int f6553d;

    /* renamed from: e */
    private int f6554e;

    /* renamed from: f */
    private BitSet f6555f;

    /* renamed from: g */
    private BitSet f6556g;

    /* renamed from: h */
    private BitSet f6557h;

    /* renamed from: i */
    private BitSet f6558i;

    private C2184a(int i, int i2) {
        this.f6554e = i;
        this.f6552c = i2;
    }

    /* renamed from: a */
    static C2185b m6506a(int i, int i2) {
        C2185b bVar = new C2185b(0);
        bVar.f6561c = new C2184a(i, i2);
        return bVar;
    }

    /* renamed from: a */
    static void m6508a(OptFunctionNode hVar, Node[] cmVarArr, C2184a[] aVarArr, int[] iArr) {
        boolean z;
        for (C2184a aVar : aVarArr) {
            int v = hVar.f6618a.mo18768v();
            aVar.f6557h = new BitSet(v);
            aVar.f6558i = new BitSet(v);
            aVar.f6555f = new BitSet(v);
            aVar.f6556g = new BitSet(v);
            for (int i = aVar.f6554e; i <= aVar.f6552c; i++) {
                aVar.m6507a(hVar, cmVarArr[i]);
            }
            aVar.f6558i.flip(0, v);
        }
        boolean[] zArr = new boolean[aVarArr.length];
        boolean[] zArr2 = new boolean[aVarArr.length];
        int length = aVarArr.length - 1;
        zArr[length] = true;
        int i2 = length;
        boolean z2 = false;
        while (true) {
            if (zArr[i2] || !zArr2[i2]) {
                zArr2[i2] = true;
                zArr[i2] = false;
                if (aVarArr[i2].m6510a()) {
                    C2184a[] aVarArr2 = aVarArr[i2].f6551b;
                    if (aVarArr2 != null) {
                        boolean z3 = z2;
                        for (C2184a aVar2 : aVarArr2) {
                            int i3 = aVar2.f6553d;
                            zArr[i3] = true;
                            if (i3 > i2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            z3 |= z;
                        }
                        z2 = z3;
                    }
                }
            }
            if (i2 != 0) {
                i2--;
            } else if (z2) {
                i2 = aVarArr.length - 1;
                z2 = false;
            } else {
                aVarArr[0].m6509a(iArr);
                return;
            }
        }
    }

    /* renamed from: b */
    static void m6512b(OptFunctionNode hVar, Node[] cmVarArr, C2184a[] aVarArr, int[] iArr) {
        boolean z;
        boolean[] zArr = new boolean[aVarArr.length];
        boolean[] zArr2 = new boolean[aVarArr.length];
        zArr[0] = true;
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (zArr[i] || !zArr2[i]) {
                zArr2[i] = true;
                zArr[i] = false;
                C2184a aVar = aVarArr[i];
                boolean z3 = false;
                for (int i2 = aVar.f6554e; i2 <= aVar.f6552c; i2++) {
                    Node cmVar = cmVarArr[i2];
                    if (cmVar != null) {
                        z3 |= m6513b(hVar, cmVar, iArr);
                    }
                }
                if (z3) {
                    C2184a[] aVarArr2 = aVarArr[i].f6550a;
                    if (aVarArr2 != null) {
                        boolean z4 = z2;
                        for (C2184a aVar2 : aVarArr2) {
                            int i3 = aVar2.f6553d;
                            zArr[i3] = true;
                            if (i3 < i) {
                                z = true;
                            } else {
                                z = false;
                            }
                            z4 |= z;
                        }
                        z2 = z4;
                    }
                }
            }
            if (i != aVarArr.length - 1) {
                i++;
            } else if (z2) {
                z2 = false;
                i = 0;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private static boolean m6511a(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        int i4 = iArr[i] | i2;
        iArr[i] = i4;
        return i3 != i4;
    }

    /* renamed from: a */
    private void m6509a(int[] iArr) {
        for (int i = 0; i != iArr.length; i++) {
            if (this.f6555f.get(i)) {
                m6511a(iArr, i, 3);
            }
        }
    }

    /* renamed from: a */
    private void m6507a(OptFunctionNode hVar, Node cmVar) {
        do {
            switch (cmVar.f6389a) {
                case 55:
                    int a = hVar.mo19075a(cmVar);
                    if (!this.f6558i.get(a)) {
                        this.f6557h.set(a);
                        return;
                    }
                    return;
                case 56:
                    m6507a(hVar, cmVar.mo18930b().mo18942d());
                    this.f6558i.set(hVar.mo19075a(cmVar));
                    return;
                case 106:
                case 107:
                    cmVar = cmVar.mo18930b();
                    break;
                case 137:
                    int f = hVar.f6618a.mo18761f(cmVar);
                    if (f >= 0 && !this.f6558i.get(f)) {
                        this.f6557h.set(f);
                        return;
                    }
                    return;
                default:
                    for (Node b = cmVar.mo18930b(); b != null; b = b.mo18942d()) {
                        m6507a(hVar, b);
                    }
                    return;
            }
        } while (cmVar.f6389a != 55);
        int a2 = hVar.mo19075a(cmVar);
        if (!this.f6558i.get(a2)) {
            this.f6557h.set(a2);
        }
        this.f6558i.set(a2);
    }

    /* renamed from: a */
    private boolean m6510a() {
        this.f6556g.clear();
        if (this.f6550a != null) {
            for (C2184a aVar : this.f6550a) {
                this.f6556g.or(aVar.f6555f);
            }
        }
        BitSet bitSet = this.f6555f;
        BitSet bitSet2 = this.f6556g;
        BitSet bitSet3 = this.f6557h;
        BitSet bitSet4 = this.f6558i;
        int cardinality = bitSet.cardinality();
        bitSet.or(bitSet2);
        bitSet.and(bitSet4);
        bitSet.or(bitSet3);
        if (bitSet.cardinality() != cardinality) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static int m6505a(OptFunctionNode hVar, Node cmVar, int[] iArr) {
        while (true) {
            switch (cmVar.f6389a) {
                case 8:
                case 35:
                case 37:
                case 56:
                case 89:
                    cmVar = cmVar.mo18938c();
                case 9:
                case 10:
                case 11:
                case 18:
                case 19:
                case 20:
                case 22:
                case 23:
                case 24:
                case 25:
                case 27:
                case 28:
                case 29:
                case 40:
                case 106:
                case 107:
                    return 1;
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 26:
                case 31:
                case 44:
                case 45:
                case 46:
                case 47:
                case 52:
                case 53:
                case 69:
                    return 3;
                case 21:
                    Node b = cmVar.mo18930b();
                    return m6505a(hVar, b.mo18942d(), iArr) | m6505a(hVar, b, iArr);
                case 30:
                case 38:
                case 70:
                    return 3;
                case 32:
                case 41:
                case 137:
                    return 3;
                case 33:
                case 36:
                case 39:
                case 43:
                    return 3;
                case 42:
                case 48:
                case 65:
                case 66:
                case 157:
                    return 3;
                case 55:
                    return iArr[hVar.mo19075a(cmVar)];
                case 102:
                    Node d = cmVar.mo18930b().mo18942d();
                    return m6505a(hVar, d, iArr) | m6505a(hVar, d.mo18942d(), iArr);
                case 104:
                case 105:
                    Node b2 = cmVar.mo18930b();
                    return m6505a(hVar, b2.mo18942d(), iArr) | m6505a(hVar, b2, iArr);
                case 126:
                    return 3;
                default:
                    return 3;
            }
        }
    }

    /* renamed from: b */
    private static boolean m6513b(OptFunctionNode hVar, Node cmVar, int[] iArr) {
        boolean z = false;
        Node b = cmVar.mo18930b();
        Node cmVar2 = b;
        while (cmVar2 != null) {
            boolean b2 = m6513b(hVar, cmVar2, iArr) | z;
            cmVar2 = cmVar2.mo18942d();
            z = b2;
        }
        switch (cmVar.f6389a) {
            case 56:
                return z | m6511a(iArr, hVar.mo19075a(cmVar), m6505a(hVar, b.mo18942d(), iArr));
            case 106:
            case 107:
                if (b.f6389a == 55) {
                    return z | m6511a(iArr, hVar.mo19075a(b), 1);
                }
                return z;
            default:
                return z;
        }
    }
}
