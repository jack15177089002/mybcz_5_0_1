package org.mozilla.javascript.p114f;

/* renamed from: org.mozilla.javascript.f.d */
public class DoubleHelper {

    /* renamed from: a */
    static final /* synthetic */ boolean f6712a = (!DoubleHelper.class.desiredAssertionStatus());

    /* renamed from: a */
    static DiyFp m6674a(long j) {
        long c = m6677c(j);
        int b = m6676b(j);
        if (f6712a || c != 0) {
            while ((4503599627370496L & c) == 0) {
                c <<= 1;
                b--;
            }
            return new DiyFp(c << 11, b - 11);
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    private static int m6676b(long j) {
        if (m6678d(j)) {
            return -1074;
        }
        return ((int) (((9218868437227405312L & j) >>> 52) & 4294967295L)) - 1075;
    }

    /* renamed from: c */
    private static long m6677c(long j) {
        long j2 = 4503599627370495L & j;
        if (!m6678d(j)) {
            return j2 + 4503599627370496L;
        }
        return j2;
    }

    /* renamed from: d */
    private static boolean m6678d(long j) {
        return (9218868437227405312L & j) == 0;
    }

    /* renamed from: a */
    static void m6675a(long j, DiyFp cVar, DiyFp cVar2) {
        boolean z = false;
        if (!f6712a) {
            if ((j & 9218868437227405312L) == 9218868437227405312L) {
                throw new AssertionError();
            }
        }
        DiyFp cVar3 = new DiyFp(m6677c(j), m6676b(j));
        if (cVar3.f6710a == 4503599627370496L) {
            z = true;
        }
        cVar2.f6710a = (cVar3.f6710a << 1) + 1;
        cVar2.f6711b = cVar3.f6711b - 1;
        cVar2.mo19106a();
        if (!z || cVar3.f6711b == -1074) {
            cVar.f6710a = (cVar3.f6710a << 1) - 1;
            cVar.f6711b = cVar3.f6711b - 1;
        } else {
            cVar.f6710a = (cVar3.f6710a << 2) - 1;
            cVar.f6711b = cVar3.f6711b - 2;
        }
        cVar.f6710a <<= cVar.f6711b - cVar2.f6711b;
        cVar.f6711b = cVar2.f6711b;
    }
}
