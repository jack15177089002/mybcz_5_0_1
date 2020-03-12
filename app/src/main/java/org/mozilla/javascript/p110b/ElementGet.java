package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.p */
public final class ElementGet extends AstNode {

    /* renamed from: g */
    public AstNode f6234g;

    /* renamed from: h */
    public AstNode f6235h;

    /* renamed from: i */
    public int f6236i;

    /* renamed from: j */
    public int f6237j;

    public ElementGet() {
        this.f6236i = -1;
        this.f6237j = -1;
        this.f6389a = 36;
    }

    public ElementGet(int i, int i2) {
        super(i, i2);
        this.f6236i = -1;
        this.f6237j = -1;
        this.f6389a = 36;
    }

    /* renamed from: a */
    public final void mo18812a(AstNode eVar) {
        m5915a(eVar);
        this.f6234g = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: d */
    public final void mo18813d(AstNode eVar) {
        m5915a(eVar);
        this.f6235h = eVar;
        eVar.mo18790b(this);
    }
}
