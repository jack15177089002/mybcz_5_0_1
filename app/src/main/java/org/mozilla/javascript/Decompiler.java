package org.mozilla.javascript;

import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.t */
public final class Decompiler {

    /* renamed from: a */
    char[] f6824a = new char[128];

    /* renamed from: b */
    int f6825b;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo19160a(int i) {
        int i2 = this.f6825b;
        mo19163b(109);
        m6806a((char) i);
        return i2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo19159a() {
        int i = this.f6825b;
        m6806a(164);
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo19163b(int i) {
        if (i < 0 || i > 163) {
            throw new IllegalArgumentException();
        }
        m6806a((char) i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo19165c(int i) {
        if (i < 0 || i > 163) {
            throw new IllegalArgumentException();
        }
        m6806a((char) i);
        m6806a(1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo19162a(String str) {
        mo19163b(39);
        mo19166c(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo19164b(String str) {
        mo19163b(41);
        mo19166c(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo19161a(double d) {
        mo19163b(40);
        long j = (long) d;
        if (((double) j) != d) {
            long doubleToLongBits = Double.doubleToLongBits(d);
            m6806a('D');
            m6806a((char) ((int) (doubleToLongBits >> 48)));
            m6806a((char) ((int) (doubleToLongBits >> 32)));
            m6806a((char) ((int) (doubleToLongBits >> 16)));
            m6806a((char) ((int) doubleToLongBits));
            return;
        }
        if (j < 0) {
            Kit.m5810a();
        }
        if (j <= 65535) {
            m6806a('S');
            m6806a((char) ((int) j));
            return;
        }
        m6806a('J');
        m6806a((char) ((int) (j >> 48)));
        m6806a((char) ((int) (j >> 32)));
        m6806a((char) ((int) (j >> 16)));
        m6806a((char) ((int) j));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo19166c(String str) {
        int length = str.length();
        int i = 1;
        if (length >= 32768) {
            i = 2;
        }
        int i2 = i + this.f6825b + length;
        if (i2 > this.f6824a.length) {
            m6807d(i2);
        }
        if (length >= 32768) {
            this.f6824a[this.f6825b] = (char) ((length >>> 16) | 32768);
            this.f6825b++;
        }
        this.f6824a[this.f6825b] = (char) length;
        this.f6825b++;
        str.getChars(0, length, this.f6824a, this.f6825b);
        this.f6825b = i2;
    }

    /* renamed from: a */
    private void m6806a(char c) {
        if (this.f6825b == this.f6824a.length) {
            m6807d(this.f6825b + 1);
        }
        this.f6824a[this.f6825b] = c;
        this.f6825b++;
    }

    /* renamed from: d */
    private void m6807d(int i) {
        if (i <= this.f6824a.length) {
            Kit.m5810a();
        }
        int length = this.f6824a.length * 2;
        if (length >= i) {
            i = length;
        }
        char[] cArr = new char[i];
        System.arraycopy(this.f6824a, 0, cArr, 0, this.f6825b);
        this.f6824a = cArr;
    }

    /* renamed from: a */
    static int m6804a(String str, int i, int i2) {
        if (i2 + 1 < i) {
            return str.charAt(i2 + 1);
        }
        return 0;
    }

    /* renamed from: a */
    static int m6805a(String str, int i, boolean z, StringBuffer stringBuffer) {
        char charAt = str.charAt(i);
        int i2 = i + 1;
        if ((32768 & charAt) != 0) {
            charAt = ((charAt & 32767) << 16) | str.charAt(i2);
            i2++;
        }
        if (stringBuffer != null) {
            String substring = str.substring(i2, i2 + charAt);
            if (!z) {
                stringBuffer.append(substring);
            } else {
                stringBuffer.append(CoreConstants.DOUBLE_QUOTE_CHAR);
                stringBuffer.append(ScriptRuntime.m6403b(substring));
                stringBuffer.append(CoreConstants.DOUBLE_QUOTE_CHAR);
            }
        }
        return charAt + i2;
    }
}
