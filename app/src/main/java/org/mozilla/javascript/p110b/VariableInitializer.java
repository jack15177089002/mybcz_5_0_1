package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.bd */
public final class VariableInitializer extends AstNode {

    /* renamed from: g */
    public AstNode f6184g;

    /* renamed from: h */
    public AstNode f6185h;

    public VariableInitializer() {
        this.f6389a = 122;
    }

    public VariableInitializer(int i, int i2) {
        super(i, i2);
        this.f6389a = 122;
    }

    /* renamed from: n */
    public final boolean mo18725n() {
        return !(this.f6184g instanceof Name);
    }

    /* renamed from: a */
    public final void mo18779a(AstNode eVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("invalid target arg");
        }
        this.f6184g = eVar;
        eVar.mo18790b(this);
    }
}
