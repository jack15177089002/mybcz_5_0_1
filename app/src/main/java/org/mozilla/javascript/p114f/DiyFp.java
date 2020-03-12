package org.mozilla.javascript.p114f;

/* renamed from: org.mozilla.javascript.f.c */
class DiyFp {

    /* renamed from: c */
    static final /* synthetic */ boolean f6709c = (!DiyFp.class.desiredAssertionStatus());

    /* renamed from: a */
    long f6710a;

    /* renamed from: b */
    int f6711b;

    DiyFp() {
        this.f6710a = 0;
        this.f6711b = 0;
    }

    DiyFp(long j, int i) {
        this.f6710a = j;
        this.f6711b = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (((r8 < 0) ^ ((r6 > r8) ^ (r6 < 0))) != false) goto L_0x003c;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static DiyFp m6671a(DiyFp r12, DiyFp r13) {
        /*
            r10 = 0
            r1 = 1
            r0 = 0
            org.mozilla.javascript.f.c r4 = new org.mozilla.javascript.f.c
            long r2 = r12.f6710a
            int r5 = r12.f6711b
            r4.<init>(r2, r5)
            boolean r2 = f6709c
            if (r2 != 0) goto L_0x001d
            int r2 = r4.f6711b
            int r3 = r13.f6711b
            if (r2 == r3) goto L_0x001d
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x001d:
            boolean r2 = f6709c
            if (r2 != 0) goto L_0x004b
            long r6 = r4.f6710a
            long r8 = r13.f6710a
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x003c
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x0045
            r3 = r1
        L_0x002e:
            int r2 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r2 >= 0) goto L_0x0047
            r2 = r1
        L_0x0033:
            r3 = r3 ^ r2
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 >= 0) goto L_0x0049
            r2 = r1
        L_0x0039:
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x003d
        L_0x003c:
            r0 = r1
        L_0x003d:
            if (r0 != 0) goto L_0x004b
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0045:
            r3 = r0
            goto L_0x002e
        L_0x0047:
            r2 = r0
            goto L_0x0033
        L_0x0049:
            r2 = r0
            goto L_0x0039
        L_0x004b:
            long r0 = r4.f6710a
            long r2 = r13.f6710a
            long r0 = r0 - r2
            r4.f6710a = r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.p114f.DiyFp.m6671a(org.mozilla.javascript.f.c, org.mozilla.javascript.f.c):org.mozilla.javascript.f.c");
    }

    /* renamed from: b */
    static DiyFp m6672b(DiyFp cVar, DiyFp cVar2) {
        DiyFp cVar3 = new DiyFp(cVar.f6710a, cVar.f6711b);
        long j = cVar3.f6710a >>> 32;
        long j2 = cVar3.f6710a & 4294967295L;
        long j3 = cVar2.f6710a >>> 32;
        long j4 = cVar2.f6710a & 4294967295L;
        long j5 = j * j3;
        long j6 = j3 * j2;
        long j7 = j * j4;
        long j8 = (j7 >>> 32) + j5 + (j6 >>> 32) + ((((((j2 * j4) >>> 32) + (4294967295L & j7)) + (4294967295L & j6)) + 2147483648L) >>> 32);
        cVar3.f6711b += cVar2.f6711b + 64;
        cVar3.f6710a = j8;
        return cVar3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo19106a() {
        if (f6709c || this.f6710a != 0) {
            long j = this.f6710a;
            int i = this.f6711b;
            while ((-18014398509481984L & j) == 0) {
                j <<= 10;
                i -= 10;
            }
            while ((Long.MIN_VALUE & j) == 0) {
                j <<= 1;
                i--;
            }
            this.f6710a = j;
            this.f6711b = i;
            return;
        }
        throw new AssertionError();
    }

    public String toString() {
        return "[DiyFp f:" + this.f6710a + ", e:" + this.f6711b + "]";
    }
}
