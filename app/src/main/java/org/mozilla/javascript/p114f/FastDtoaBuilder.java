package org.mozilla.javascript.p114f;

import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.f.f */
public final class FastDtoaBuilder {

    /* renamed from: e */
    static final char[] f6714e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: a */
    final char[] f6715a = new char[25];

    /* renamed from: b */
    int f6716b = 0;

    /* renamed from: c */
    int f6717c;

    /* renamed from: d */
    boolean f6718d = false;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo19108a(char c) {
        char[] cArr = this.f6715a;
        int i = this.f6716b;
        this.f6716b = i + 1;
        cArr[i] = c;
    }

    public final String toString() {
        return "[chars:" + new String(this.f6715a, 0, this.f6716b) + ", point:" + this.f6717c + "]";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo19109a(int i, int i2) {
        if (this.f6716b - i > 1) {
            int i3 = i + 1;
            System.arraycopy(this.f6715a, i3, this.f6715a, i3 + 1, this.f6716b - i3);
            this.f6715a[i3] = CoreConstants.DOT;
            this.f6716b++;
        }
        char[] cArr = this.f6715a;
        int i4 = this.f6716b;
        this.f6716b = i4 + 1;
        cArr[i4] = 'e';
        char c = '+';
        int i5 = i2 - 1;
        if (i5 < 0) {
            c = CoreConstants.DASH_CHAR;
            i5 = -i5;
        }
        char[] cArr2 = this.f6715a;
        int i6 = this.f6716b;
        this.f6716b = i6 + 1;
        cArr2[i6] = c;
        int i7 = i5 > 99 ? this.f6716b + 2 : i5 > 9 ? this.f6716b + 1 : this.f6716b;
        this.f6716b = i7 + 1;
        while (true) {
            int i8 = i7 - 1;
            this.f6715a[i7] = f6714e[i5 % 10];
            i5 /= 10;
            if (i5 != 0) {
                i7 = i8;
            } else {
                return;
            }
        }
    }
}
