package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.as */
public final class ReturnStatement extends AstNode {

    /* renamed from: g */
    public AstNode f6141g;

    public ReturnStatement() {
        this.f6389a = 4;
    }

    public ReturnStatement(int i) {
        super(i);
        this.f6389a = 4;
    }

    public ReturnStatement(int i, int i2, AstNode eVar) {
        super(i, i2);
        this.f6389a = 4;
        mo18745a(eVar);
    }

    /* renamed from: a */
    public final void mo18745a(AstNode eVar) {
        this.f6141g = eVar;
        if (eVar != null) {
            eVar.mo18790b(this);
        }
    }
}
