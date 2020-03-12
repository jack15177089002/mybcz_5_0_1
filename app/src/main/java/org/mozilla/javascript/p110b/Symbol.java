package org.mozilla.javascript.p110b;

import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;

/* renamed from: org.mozilla.javascript.b.ay */
public final class Symbol {

    /* renamed from: a */
    public int f6169a;

    /* renamed from: b */
    int f6170b = -1;

    /* renamed from: c */
    String f6171c;

    /* renamed from: d */
    Scope f6172d;

    /* renamed from: e */
    private Node f6173e;

    public Symbol() {
    }

    public Symbol(int i, String str) {
        this.f6171c = str;
        if (i == 109 || i == 87 || i == 122 || i == 153 || i == 154) {
            this.f6169a = i;
            return;
        }
        throw new IllegalArgumentException("Invalid declType: " + i);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol (");
        sb.append(Token.m6625a(this.f6169a));
        sb.append(") name=");
        sb.append(this.f6171c);
        if (this.f6173e != null) {
            sb.append(" line=");
            sb.append(this.f6173e.mo18794f());
        }
        return sb.toString();
    }
}
