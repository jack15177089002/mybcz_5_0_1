package org.mozilla.javascript;

import java.io.Serializable;

/* renamed from: org.mozilla.javascript.j */
public final class ConsString implements Serializable, CharSequence {

    /* renamed from: a */
    private CharSequence f6756a;

    /* renamed from: b */
    private CharSequence f6757b;

    /* renamed from: c */
    private final int f6758c;

    /* renamed from: d */
    private int f6759d = 1;

    public ConsString(CharSequence charSequence, CharSequence charSequence2) {
        this.f6756a = charSequence;
        this.f6757b = charSequence2;
        this.f6758c = charSequence.length() + charSequence2.length();
        if (charSequence instanceof ConsString) {
            this.f6759d += ((ConsString) charSequence).f6759d;
        }
        if (charSequence2 instanceof ConsString) {
            this.f6759d += ((ConsString) charSequence2).f6759d;
        }
        if (this.f6759d > 2000) {
            m6731a();
        }
    }

    public final String toString() {
        return this.f6759d == 0 ? (String) this.f6756a : m6731a();
    }

    /* renamed from: a */
    private synchronized String m6731a() {
        if (this.f6759d > 0) {
            StringBuilder sb = new StringBuilder(this.f6758c);
            m6733a(sb);
            this.f6756a = sb.toString();
            this.f6757b = "";
            this.f6759d = 0;
        }
        return (String) this.f6756a;
    }

    /* renamed from: a */
    private synchronized void m6733a(StringBuilder sb) {
        m6732a(this.f6756a, sb);
        m6732a(this.f6757b, sb);
    }

    /* renamed from: a */
    private static void m6732a(CharSequence charSequence, StringBuilder sb) {
        if (charSequence instanceof ConsString) {
            ((ConsString) charSequence).m6733a(sb);
        } else {
            sb.append(charSequence);
        }
    }

    public final int length() {
        return this.f6758c;
    }

    public final char charAt(int i) {
        return (this.f6759d == 0 ? (String) this.f6756a : m6731a()).charAt(i);
    }

    public final CharSequence subSequence(int i, int i2) {
        return (this.f6759d == 0 ? (String) this.f6756a : m6731a()).substring(i, i2);
    }
}
