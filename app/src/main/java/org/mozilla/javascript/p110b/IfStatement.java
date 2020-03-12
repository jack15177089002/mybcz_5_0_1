package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.ac */
public final class IfStatement extends AstNode {

    /* renamed from: g */
    public AstNode f6108g;

    /* renamed from: h */
    public AstNode f6109h;

    /* renamed from: i */
    public int f6110i;

    /* renamed from: j */
    public AstNode f6111j;

    /* renamed from: k */
    public int f6112k;

    /* renamed from: l */
    public int f6113l;

    public IfStatement() {
        this.f6110i = -1;
        this.f6112k = -1;
        this.f6113l = -1;
        this.f6389a = 112;
    }

    public IfStatement(int i, int i2) {
        super(i, i2);
        this.f6110i = -1;
        this.f6112k = -1;
        this.f6113l = -1;
        this.f6389a = 112;
    }

    /* renamed from: a */
    public final void mo18718a(AstNode eVar) {
        m5915a(eVar);
        this.f6108g = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: d */
    public final void mo18719d(AstNode eVar) {
        m5915a(eVar);
        this.f6109h = eVar;
        eVar.mo18790b(this);
    }
}
