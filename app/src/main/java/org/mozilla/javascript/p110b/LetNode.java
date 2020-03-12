package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.ai */
public final class LetNode extends Scope {

    /* renamed from: g */
    public VariableDeclaration f6123g;

    /* renamed from: h */
    public AstNode f6124h;

    /* renamed from: i */
    public int f6125i;

    /* renamed from: j */
    public int f6126j;

    public LetNode() {
        this.f6125i = -1;
        this.f6126j = -1;
        this.f6389a = 158;
    }

    public LetNode(int i) {
        super(i);
        this.f6125i = -1;
        this.f6126j = -1;
        this.f6389a = 158;
    }

    /* renamed from: a */
    public final void mo18734a(VariableDeclaration bcVar) {
        m5915a(bcVar);
        this.f6123g = bcVar;
        bcVar.mo18790b(this);
    }

    /* renamed from: a */
    public final void mo18735a(AstNode eVar) {
        this.f6124h = eVar;
        if (eVar != null) {
            eVar.mo18790b(this);
        }
    }
}
