package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.j */
public final class CatchClause extends AstNode {

    /* renamed from: g */
    public Name f6217g;

    /* renamed from: h */
    public AstNode f6218h;

    /* renamed from: i */
    public Block f6219i;

    /* renamed from: j */
    public int f6220j;

    /* renamed from: k */
    public int f6221k;

    /* renamed from: l */
    public int f6222l;

    public CatchClause() {
        this.f6220j = -1;
        this.f6221k = -1;
        this.f6222l = -1;
        this.f6389a = 124;
    }

    public CatchClause(int i) {
        super(i);
        this.f6220j = -1;
        this.f6221k = -1;
        this.f6222l = -1;
        this.f6389a = 124;
    }

    /* renamed from: a */
    public final void mo18805a(Name akVar) {
        m5915a(akVar);
        this.f6217g = akVar;
        akVar.mo18790b(this);
    }

    /* renamed from: a */
    public final void mo18806a(Block hVar) {
        m5915a(hVar);
        this.f6219i = hVar;
        hVar.mo18790b(this);
    }
}
