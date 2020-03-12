package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.ap */
public final class ParenthesizedExpression extends AstNode {

    /* renamed from: g */
    public AstNode f6138g;

    public ParenthesizedExpression() {
        this.f6389a = 87;
    }

    public ParenthesizedExpression(AstNode eVar) {
        this(eVar != null ? eVar.mo18798q() : 0, eVar != null ? eVar.mo18800s() : 1, eVar);
    }

    private ParenthesizedExpression(int i, int i2, AstNode eVar) {
        super(i, i2);
        this.f6389a = 87;
        m5915a(eVar);
        this.f6138g = eVar;
        eVar.mo18790b(this);
    }
}
