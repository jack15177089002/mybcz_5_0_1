package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.bh */
public final class XmlElemRef extends XmlRef {

    /* renamed from: g */
    public AstNode f6192g;

    /* renamed from: h */
    public int f6193h;

    /* renamed from: i */
    public int f6194i;

    public XmlElemRef() {
        this.f6193h = -1;
        this.f6194i = -1;
        this.f6389a = 77;
    }

    public XmlElemRef(int i, int i2) {
        super(i, i2);
        this.f6193h = -1;
        this.f6194i = -1;
        this.f6389a = 77;
    }

    /* renamed from: a */
    public final void mo18783a(AstNode eVar) {
        m5915a(eVar);
        this.f6192g = eVar;
        eVar.mo18790b(this);
    }
}
