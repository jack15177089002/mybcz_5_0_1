package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.bb */
public final class UnaryExpression extends AstNode {

    /* renamed from: g */
    public AstNode f6180g;

    /* renamed from: h */
    public boolean f6181h;

    public UnaryExpression() {
    }

    public UnaryExpression(int i, int i2) {
        super(i, i2);
    }

    public UnaryExpression(int i, int i2, AstNode eVar) {
        this(i, i2, eVar, false);
    }

    public UnaryExpression(int i, int i2, AstNode eVar, boolean z) {
        m5915a(eVar);
        mo18791c(z ? eVar.mo18798q() : i2, z ? i2 + 2 : eVar.mo18798q() + eVar.mo18800s());
        mo18777i(i);
        mo18776a(eVar);
        this.f6181h = z;
    }

    /* renamed from: i */
    public final void mo18777i(int i) {
        if (!(i >= -1 && i <= 163)) {
            throw new IllegalArgumentException("Invalid token: " + i);
        }
        mo18730a(i);
    }

    /* renamed from: a */
    public final void mo18776a(AstNode eVar) {
        m5915a(eVar);
        this.f6180g = eVar;
        eVar.mo18790b(this);
    }
}
