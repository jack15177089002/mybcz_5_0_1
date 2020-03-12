package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.az */
public final class ThrowStatement extends AstNode {

    /* renamed from: g */
    public AstNode f6174g;

    public ThrowStatement() {
        this.f6389a = 50;
    }

    public ThrowStatement(int i, int i2, AstNode eVar) {
        super(i, i2);
        this.f6389a = 50;
        m5915a(eVar);
        this.f6174g = eVar;
        eVar.mo18790b(this);
    }
}
