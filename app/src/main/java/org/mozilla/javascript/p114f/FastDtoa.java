package org.mozilla.javascript.p114f;

import java.util.Arrays;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.f.e */
public class FastDtoa {

    /* renamed from: a */
    static final /* synthetic */ boolean f6713a = (!FastDtoa.class.desiredAssertionStatus());

    /* renamed from: a */
    private static boolean m6681a(FastDtoaBuilder fVar, long j, long j2, long j3, long j4, long j5) {
        long j6 = j - j5;
        long j7 = j + j5;
        while (j3 < j6 && j2 - j3 >= j4 && (j3 + j4 < j6 || j6 - j3 >= (j3 + j4) - j6)) {
            char[] cArr = fVar.f6715a;
            int i = fVar.f6716b - 1;
            cArr[i] = (char) (cArr[i] - 1);
            j3 += j4;
        }
        if (j3 >= j7 || j2 - j3 < j4 || (j3 + j4 >= j7 && j7 - j3 <= (j3 + j4) - j7)) {
            return 2 * j5 <= j3 && j3 <= j2 - (4 * j5);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m6680a(DiyFp r16, DiyFp r17, DiyFp r18, org.mozilla.javascript.p114f.FastDtoaBuilder r19, int r20) {
        /*
            boolean r2 = f6713a
            if (r2 != 0) goto L_0x001e
            r0 = r16
            int r2 = r0.f6711b
            r0 = r17
            int r3 = r0.f6711b
            if (r2 != r3) goto L_0x0018
            r0 = r17
            int r2 = r0.f6711b
            r0 = r18
            int r3 = r0.f6711b
            if (r2 == r3) goto L_0x001e
        L_0x0018:
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x001e:
            boolean r2 = f6713a
            if (r2 != 0) goto L_0x005f
            r0 = r16
            long r2 = r0.f6710a
            r4 = 1
            long r4 = r4 + r2
            r0 = r18
            long r2 = r0.f6710a
            r6 = 1
            long r6 = r2 - r6
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x004d
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x0056
            r2 = 1
            r3 = r2
        L_0x003b:
            r8 = 0
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x0059
            r2 = 1
        L_0x0042:
            r3 = r3 ^ r2
            r4 = 0
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x005b
            r2 = 1
        L_0x004a:
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x005d
        L_0x004d:
            r2 = 1
        L_0x004e:
            if (r2 != 0) goto L_0x005f
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x0056:
            r2 = 0
            r3 = r2
            goto L_0x003b
        L_0x0059:
            r2 = 0
            goto L_0x0042
        L_0x005b:
            r2 = 0
            goto L_0x004a
        L_0x005d:
            r2 = 0
            goto L_0x004e
        L_0x005f:
            boolean r2 = f6713a
            if (r2 != 0) goto L_0x0079
            r2 = -60
            r0 = r17
            int r3 = r0.f6711b
            if (r2 > r3) goto L_0x0073
            r0 = r17
            int r2 = r0.f6711b
            r3 = -32
            if (r2 <= r3) goto L_0x0079
        L_0x0073:
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x0079:
            r12 = 1
            org.mozilla.javascript.f.c r2 = new org.mozilla.javascript.f.c
            r0 = r16
            long r4 = r0.f6710a
            r6 = 1
            long r4 = r4 - r6
            r0 = r16
            int r3 = r0.f6711b
            r2.<init>(r4, r3)
            org.mozilla.javascript.f.c r7 = new org.mozilla.javascript.f.c
            r0 = r18
            long r4 = r0.f6710a
            r8 = 1
            long r4 = r4 + r8
            r0 = r18
            int r3 = r0.f6711b
            r7.<init>(r4, r3)
            org.mozilla.javascript.f.c r10 = org.mozilla.javascript.p114f.DiyFp.m6671a(r7, r2)
            org.mozilla.javascript.f.c r11 = new org.mozilla.javascript.f.c
            r2 = 1
            r0 = r17
            int r4 = r0.f6711b
            int r4 = -r4
            long r2 = r2 << r4
            r0 = r17
            int r4 = r0.f6711b
            r11.<init>(r2, r4)
            long r2 = r7.f6710a
            int r4 = r11.f6711b
            int r4 = -r4
            long r2 = r2 >>> r4
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r4
            int r6 = (int) r2
            long r2 = r7.f6710a
            long r4 = r11.f6710a
            r8 = 1
            long r4 = r4 - r8
            long r4 = r4 & r2
            int r2 = r11.f6711b
            int r2 = -r2
            int r2 = 64 - r2
            switch(r2) {
                case 0: goto L_0x018e;
                case 1: goto L_0x0188;
                case 2: goto L_0x0188;
                case 3: goto L_0x0188;
                case 4: goto L_0x017f;
                case 5: goto L_0x017f;
                case 6: goto L_0x017f;
                case 7: goto L_0x0176;
                case 8: goto L_0x0176;
                case 9: goto L_0x0176;
                case 10: goto L_0x016d;
                case 11: goto L_0x016d;
                case 12: goto L_0x016d;
                case 13: goto L_0x016d;
                case 14: goto L_0x0164;
                case 15: goto L_0x0164;
                case 16: goto L_0x0164;
                case 17: goto L_0x0159;
                case 18: goto L_0x0159;
                case 19: goto L_0x0159;
                case 20: goto L_0x014e;
                case 21: goto L_0x014e;
                case 22: goto L_0x014e;
                case 23: goto L_0x014e;
                case 24: goto L_0x0144;
                case 25: goto L_0x0144;
                case 26: goto L_0x0144;
                case 27: goto L_0x0139;
                case 28: goto L_0x0139;
                case 29: goto L_0x0139;
                case 30: goto L_0x012e;
                case 31: goto L_0x012e;
                case 32: goto L_0x012e;
                default: goto L_0x00cd;
            }
        L_0x00cd:
            r3 = 0
            r2 = 0
        L_0x00cf:
            long r8 = (long) r3
            r3 = 32
            long r8 = r8 << r3
            r14 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = (long) r2
            long r2 = r2 & r14
            long r8 = r8 | r2
            r2 = 32
            long r2 = r8 >>> r2
            r14 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r14
            int r3 = (int) r2
            r14 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r8 = r8 & r14
            int r2 = (int) r8
            int r2 = r2 + 1
        L_0x00ef:
            if (r2 <= 0) goto L_0x0196
            int r8 = r6 / r3
            int r8 = r8 + 48
            char r8 = (char) r8
            r0 = r19
            r0.mo19108a(r8)
            int r6 = r6 % r3
            int r2 = r2 + -1
            long r8 = (long) r6
            int r14 = r11.f6711b
            int r14 = -r14
            long r8 = r8 << r14
            long r8 = r8 + r4
            long r14 = r10.f6710a
            int r14 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r14 >= 0) goto L_0x0192
            r0 = r19
            int r4 = r0.f6716b
            int r4 = r4 - r20
            int r2 = r2 + r4
            r0 = r19
            r0.f6717c = r2
            r0 = r17
            org.mozilla.javascript.f.c r2 = org.mozilla.javascript.p114f.DiyFp.m6671a(r7, r0)
            long r4 = r2.f6710a
            long r6 = r10.f6710a
            long r2 = (long) r3
            int r10 = r11.f6711b
            int r10 = -r10
            long r10 = r2 << r10
            r12 = 1
            r3 = r19
            boolean r2 = m6681a(r3, r4, r6, r8, r10, r12)
        L_0x012d:
            return r2
        L_0x012e:
            r2 = 1000000000(0x3b9aca00, float:0.0047237873)
            if (r2 > r6) goto L_0x0139
            r3 = 1000000000(0x3b9aca00, float:0.0047237873)
            r2 = 9
            goto L_0x00cf
        L_0x0139:
            r2 = 100000000(0x5f5e100, float:2.3122341E-35)
            if (r2 > r6) goto L_0x0144
            r3 = 100000000(0x5f5e100, float:2.3122341E-35)
            r2 = 8
            goto L_0x00cf
        L_0x0144:
            r2 = 10000000(0x989680, float:1.4012985E-38)
            if (r2 > r6) goto L_0x014e
            r3 = 10000000(0x989680, float:1.4012985E-38)
            r2 = 7
            goto L_0x00cf
        L_0x014e:
            r2 = 1000000(0xf4240, float:1.401298E-39)
            if (r2 > r6) goto L_0x0159
            r3 = 1000000(0xf4240, float:1.401298E-39)
            r2 = 6
            goto L_0x00cf
        L_0x0159:
            r2 = 100000(0x186a0, float:1.4013E-40)
            if (r2 > r6) goto L_0x0164
            r3 = 100000(0x186a0, float:1.4013E-40)
            r2 = 5
            goto L_0x00cf
        L_0x0164:
            r2 = 10000(0x2710, float:1.4013E-41)
            if (r2 > r6) goto L_0x016d
            r3 = 10000(0x2710, float:1.4013E-41)
            r2 = 4
            goto L_0x00cf
        L_0x016d:
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r2 > r6) goto L_0x0176
            r3 = 1000(0x3e8, float:1.401E-42)
            r2 = 3
            goto L_0x00cf
        L_0x0176:
            r2 = 100
            if (r2 > r6) goto L_0x017f
            r3 = 100
            r2 = 2
            goto L_0x00cf
        L_0x017f:
            r2 = 10
            if (r2 > r6) goto L_0x0188
            r3 = 10
            r2 = 1
            goto L_0x00cf
        L_0x0188:
            if (r6 <= 0) goto L_0x018e
            r3 = 1
            r2 = 0
            goto L_0x00cf
        L_0x018e:
            r3 = 0
            r2 = -1
            goto L_0x00cf
        L_0x0192:
            int r3 = r3 / 10
            goto L_0x00ef
        L_0x0196:
            r8 = r4
        L_0x0197:
            r4 = 5
            long r4 = r4 * r8
            r8 = 5
            long r12 = r12 * r8
            long r8 = r10.f6710a
            r14 = 5
            long r8 = r8 * r14
            r10.f6710a = r8
            int r3 = r10.f6711b
            int r3 = r3 + 1
            r10.f6711b = r3
            long r8 = r11.f6710a
            r3 = 1
            long r8 = r8 >>> r3
            r11.f6710a = r8
            int r3 = r11.f6711b
            int r3 = r3 + 1
            r11.f6711b = r3
            int r3 = r11.f6711b
            int r3 = -r3
            long r8 = r4 >>> r3
            r14 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r8 = r8 & r14
            int r3 = (int) r8
            int r3 = r3 + 48
            char r3 = (char) r3
            r0 = r19
            r0.mo19108a(r3)
            long r8 = r11.f6710a
            r14 = 1
            long r8 = r8 - r14
            long r8 = r8 & r4
            int r2 = r2 + -1
            long r4 = r10.f6710a
            int r3 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0197
            r0 = r19
            int r3 = r0.f6716b
            int r3 = r3 - r20
            int r2 = r2 + r3
            r0 = r19
            r0.f6717c = r2
            r0 = r17
            org.mozilla.javascript.f.c r2 = org.mozilla.javascript.p114f.DiyFp.m6671a(r7, r0)
            long r2 = r2.f6710a
            long r4 = r2 * r12
            long r6 = r10.f6710a
            long r10 = r11.f6710a
            r3 = r19
            boolean r2 = m6681a(r3, r4, r6, r8, r10, r12)
            goto L_0x012d
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.p114f.FastDtoa.m6680a(org.mozilla.javascript.f.c, org.mozilla.javascript.f.c, org.mozilla.javascript.f.c, org.mozilla.javascript.f.f, int):boolean");
    }

    /* renamed from: a */
    public static String m6679a(double d) {
        FastDtoaBuilder fVar = new FastDtoaBuilder();
        fVar.f6716b = 0;
        fVar.f6718d = false;
        if (d < 0.0d) {
            fVar.mo19108a(CoreConstants.DASH_CHAR);
            d = -d;
        }
        if (!f6713a && d <= 0.0d) {
            throw new AssertionError();
        } else if (!f6713a && Double.isNaN(d)) {
            throw new AssertionError();
        } else if (f6713a || !Double.isInfinite(d)) {
            long doubleToLongBits = Double.doubleToLongBits(d);
            DiyFp a = DoubleHelper.m6674a(doubleToLongBits);
            DiyFp cVar = new DiyFp();
            DiyFp cVar2 = new DiyFp();
            DoubleHelper.m6675a(doubleToLongBits, cVar, cVar2);
            if (f6713a || cVar2.f6711b == a.f6711b) {
                DiyFp cVar3 = new DiyFp();
                int a2 = CachedPowers.m6670a(a.f6711b + 64, cVar3);
                if (f6713a || (-60 <= a.f6711b + cVar3.f6711b + 64 && -32 >= a.f6711b + cVar3.f6711b + 64)) {
                    DiyFp b = DiyFp.m6672b(a, cVar3);
                    if (!f6713a && b.f6711b != cVar2.f6711b + cVar3.f6711b + 64) {
                        throw new AssertionError();
                    } else if (!m6680a(DiyFp.m6672b(cVar, cVar3), b, DiyFp.m6672b(cVar2, cVar3), fVar, a2)) {
                        return null;
                    } else {
                        if (!fVar.f6718d) {
                            int i = fVar.f6715a[0] == '-' ? 1 : 0;
                            int i2 = fVar.f6717c - i;
                            if (i2 < -5 || i2 > 21) {
                                fVar.mo19109a(i, i2);
                            } else if (fVar.f6717c < fVar.f6716b) {
                                if (i2 > 0) {
                                    System.arraycopy(fVar.f6715a, fVar.f6717c, fVar.f6715a, fVar.f6717c + 1, fVar.f6716b - fVar.f6717c);
                                    fVar.f6715a[fVar.f6717c] = CoreConstants.DOT;
                                    fVar.f6716b++;
                                } else {
                                    int i3 = (i + 2) - i2;
                                    System.arraycopy(fVar.f6715a, i, fVar.f6715a, i3, fVar.f6716b - i);
                                    fVar.f6715a[i] = '0';
                                    fVar.f6715a[i + 1] = CoreConstants.DOT;
                                    if (i2 < 0) {
                                        Arrays.fill(fVar.f6715a, i + 2, i3, '0');
                                    }
                                    fVar.f6716b += 2 - i2;
                                }
                            } else if (fVar.f6717c > fVar.f6716b) {
                                Arrays.fill(fVar.f6715a, fVar.f6716b, fVar.f6717c, '0');
                                fVar.f6716b += fVar.f6717c - fVar.f6716b;
                            }
                            fVar.f6718d = true;
                        }
                        return new String(fVar.f6715a, 0, fVar.f6716b);
                    }
                } else {
                    throw new AssertionError();
                }
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }
}
