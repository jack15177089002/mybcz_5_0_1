package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.aj */
public abstract class Loop extends Scope {

    /* renamed from: l */
    protected AstNode f6127l;

    /* renamed from: p */
    protected int f6128p = -1;

    /* renamed from: q */
    protected int f6129q = -1;

    public Loop() {
    }

    public Loop(int i) {
        super(i);
    }

    /* renamed from: n */
    public AstNode mo18725n() {
        return this.f6127l;
    }

    /* renamed from: a */
    public void mo18736a(AstNode eVar) {
        this.f6127l = eVar;
        mo18796g((eVar.mo18798q() + eVar.mo18800s()) - mo18798q());
        eVar.mo18790b(this);
    }

    /* renamed from: d */
    public final void mo18737d(int i, int i2) {
        this.f6128p = i;
        this.f6129q = i2;
    }
}
