package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.am */
public final class NumberLiteral extends AstNode {

    /* renamed from: g */
    public double f6133g;

    /* renamed from: h */
    private String f6134h;

    public NumberLiteral() {
        this.f6389a = 40;
    }

    private NumberLiteral(int i, String str) {
        super(i);
        this.f6389a = 40;
        m5915a(str);
        this.f6134h = str;
        mo18796g(str.length());
    }

    public NumberLiteral(int i, String str, double d) {
        this(i, str);
        mo18931b(d);
    }
}
