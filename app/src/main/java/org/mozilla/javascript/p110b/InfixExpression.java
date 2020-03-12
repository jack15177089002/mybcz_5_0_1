package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.ad */
public class InfixExpression extends AstNode {

    /* renamed from: g */
    protected AstNode f6114g;

    /* renamed from: h */
    protected AstNode f6115h;

    /* renamed from: i */
    protected int f6116i = -1;

    public InfixExpression() {
    }

    public InfixExpression(int i) {
        super(i);
    }

    public InfixExpression(int i, int i2) {
        super(i, i2);
    }

    public InfixExpression(int i, AstNode eVar, AstNode eVar2, int i2) {
        mo18730a(i);
        this.f6116i = i2 - eVar.mo18798q();
        mo18721a(eVar, eVar2);
    }

    /* renamed from: a */
    public final void mo18721a(AstNode eVar, AstNode eVar2) {
        m5915a(eVar);
        m5915a(eVar2);
        mo18791c(eVar.mo18798q(), eVar2.mo18798q() + eVar2.mo18800s());
        mo18720a(eVar);
        mo18722d(eVar2);
    }

    /* renamed from: n */
    public final AstNode mo18725n() {
        return this.f6114g;
    }

    /* renamed from: a */
    public final void mo18720a(AstNode eVar) {
        m5915a(eVar);
        this.f6114g = eVar;
        this.f6393e = eVar.mo18794f();
        eVar.mo18790b(this);
    }

    /* renamed from: o */
    public final AstNode mo18726o() {
        return this.f6115h;
    }

    /* renamed from: d */
    public final void mo18722d(AstNode eVar) {
        m5915a(eVar);
        this.f6115h = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: i */
    public final void mo18723i(int i) {
        this.f6116i = i;
    }

    /* renamed from: k */
    public final boolean mo18724k() {
        switch (this.f6389a) {
            case 89:
                if (this.f6115h == null || !this.f6115h.mo18724k()) {
                    return false;
                }
                return true;
            case 104:
            case 105:
                if (this.f6114g == null || !this.f6114g.mo18724k()) {
                    return this.f6115h != null && this.f6115h.mo18724k();
                }
                return true;
            default:
                return super.mo18724k();
        }
    }
}
