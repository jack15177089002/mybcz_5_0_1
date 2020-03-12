package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.t */
public final class ExpressionStatement extends AstNode {

    /* renamed from: g */
    public AstNode f6238g;

    public ExpressionStatement() {
        this.f6389a = 133;
    }

    public ExpressionStatement(AstNode eVar, boolean z) {
        this(eVar);
        if (z) {
            this.f6389a = 134;
        }
    }

    public ExpressionStatement(AstNode eVar) {
        this(eVar.mo18798q(), eVar.mo18800s(), eVar);
    }

    private ExpressionStatement(int i, int i2, AstNode eVar) {
        super(i, i2);
        this.f6389a = 133;
        m5915a(eVar);
        this.f6238g = eVar;
        eVar.mo18790b(this);
        this.f6393e = eVar.mo18794f();
    }

    /* renamed from: k */
    public final boolean mo18724k() {
        return this.f6389a == 134 || this.f6238g.mo18724k();
    }
}
