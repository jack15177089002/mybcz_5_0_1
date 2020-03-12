package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.ak */
public final class Name extends AstNode {

    /* renamed from: g */
    public String f6130g;

    /* renamed from: h */
    public Scope f6131h;

    public Name() {
        this.f6389a = 39;
    }

    public Name(int i, String str) {
        super(i);
        this.f6389a = 39;
        mo18739c(str);
        mo18796g(str.length());
    }

    /* renamed from: c */
    public final void mo18739c(String str) {
        m5915a(str);
        this.f6130g = str;
        mo18796g(str.length());
    }

    /* renamed from: a */
    public final void mo18738a(Scope atVar) {
        this.f6131h = atVar;
    }

    /* renamed from: g */
    public final Scope mo18740g() {
        return this.f6131h;
    }

    /* renamed from: n */
    public final int mo18725n() {
        if (this.f6130g == null) {
            return 0;
        }
        return this.f6130g.length();
    }
}
