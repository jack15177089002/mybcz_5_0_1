package org.mozilla.javascript;

import java.io.Serializable;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.cq */
public final class ObjArray implements Serializable {

    /* renamed from: a */
    public int f6407a;

    /* renamed from: b */
    private boolean f6408b;

    /* renamed from: c */
    private transient Object f6409c;

    /* renamed from: d */
    private transient Object f6410d;

    /* renamed from: e */
    private transient Object f6411e;

    /* renamed from: f */
    private transient Object f6412f;

    /* renamed from: g */
    private transient Object f6413g;

    /* renamed from: h */
    private transient Object[] f6414h;

    /* renamed from: a */
    public final Object mo18960a(int i) {
        if (i >= 0 && i < this.f6407a) {
            return m6160b(i);
        }
        throw new IndexOutOfBoundsException(i + " ∉ [0, " + this.f6407a + CoreConstants.RIGHT_PARENTHESIS_CHAR);
    }

    /* renamed from: b */
    private Object m6160b(int i) {
        switch (i) {
            case 0:
                return this.f6409c;
            case 1:
                return this.f6410d;
            case 2:
                return this.f6411e;
            case 3:
                return this.f6412f;
            case 4:
                return this.f6413g;
            default:
                return this.f6414h[i - 5];
        }
    }

    /* renamed from: a */
    public final Object mo18959a() {
        int i = this.f6407a;
        if (i != 0) {
            return m6160b(i - 1);
        }
        throw m6161c();
    }

    /* renamed from: b */
    public final Object mo18963b() {
        Object obj;
        if (this.f6408b) {
            throw m6162d();
        }
        int i = this.f6407a - 1;
        switch (i) {
            case -1:
                throw m6161c();
            case 0:
                obj = this.f6409c;
                this.f6409c = null;
                break;
            case 1:
                obj = this.f6410d;
                this.f6410d = null;
                break;
            case 2:
                obj = this.f6411e;
                this.f6411e = null;
                break;
            case 3:
                obj = this.f6412f;
                this.f6412f = null;
                break;
            case 4:
                obj = this.f6413g;
                this.f6413g = null;
                break;
            default:
                obj = this.f6414h[i - 5];
                this.f6414h[i - 5] = null;
                break;
        }
        this.f6407a = i;
        return obj;
    }

    /* renamed from: a */
    public final void mo18961a(Object obj) {
        int i = 10;
        if (this.f6408b) {
            throw m6162d();
        }
        int i2 = this.f6407a;
        if (i2 >= 5) {
            int i3 = (i2 + 1) - 5;
            if (i3 <= 0) {
                throw new IllegalArgumentException();
            } else if (this.f6414h == null) {
                if (10 >= i3) {
                    i3 = 10;
                }
                this.f6414h = new Object[i3];
            } else {
                int length = this.f6414h.length;
                if (length < i3) {
                    if (length > 5) {
                        i = length * 2;
                    }
                    if (i >= i3) {
                        i3 = i;
                    }
                    Object[] objArr = new Object[i3];
                    if (this.f6407a > 5) {
                        System.arraycopy(this.f6414h, 0, objArr, 0, this.f6407a - 5);
                    }
                    this.f6414h = objArr;
                }
            }
        }
        this.f6407a = i2 + 1;
        switch (i2) {
            case 0:
                this.f6409c = obj;
                return;
            case 1:
                this.f6410d = obj;
                return;
            case 2:
                this.f6411e = obj;
                return;
            case 3:
                this.f6412f = obj;
                return;
            case 4:
                this.f6413g = obj;
                return;
            default:
                this.f6414h[i2 - 5] = obj;
                return;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        r5[4] = r4.f6413g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r5[3] = r4.f6412f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        r5[2] = r4.f6411e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        r5[1] = r4.f6410d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
        r5[0] = r4.f6409c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo18962a(Object[] r5) {
        /*
            r4 = this;
            r3 = 0
            int r0 = r4.f6407a
            switch(r0) {
                case 0: goto L_0x0026;
                case 1: goto L_0x0022;
                case 2: goto L_0x001d;
                case 3: goto L_0x0018;
                case 4: goto L_0x0013;
                case 5: goto L_0x000e;
                default: goto L_0x0006;
            }
        L_0x0006:
            java.lang.Object[] r1 = r4.f6414h
            r2 = 5
            int r0 = r0 + -5
            java.lang.System.arraycopy(r1, r3, r5, r2, r0)
        L_0x000e:
            r0 = 4
            java.lang.Object r1 = r4.f6413g
            r5[r0] = r1
        L_0x0013:
            r0 = 3
            java.lang.Object r1 = r4.f6412f
            r5[r0] = r1
        L_0x0018:
            r0 = 2
            java.lang.Object r1 = r4.f6411e
            r5[r0] = r1
        L_0x001d:
            r0 = 1
            java.lang.Object r1 = r4.f6410d
            r5[r0] = r1
        L_0x0022:
            java.lang.Object r0 = r4.f6409c
            r5[r3] = r0
        L_0x0026:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ObjArray.mo18962a(java.lang.Object[]):void");
    }

    /* renamed from: c */
    private static RuntimeException m6161c() {
        throw new RuntimeException("Empty stack");
    }

    /* renamed from: d */
    private static RuntimeException m6162d() {
        throw new IllegalStateException("Attempt to modify sealed array");
    }
}
