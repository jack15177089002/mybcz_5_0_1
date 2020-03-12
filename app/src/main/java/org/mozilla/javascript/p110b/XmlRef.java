package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.bn */
public abstract class XmlRef extends AstNode {

    /* renamed from: j */
    protected Name f6199j;

    /* renamed from: k */
    protected int f6200k = -1;

    /* renamed from: l */
    protected int f6201l = -1;

    public XmlRef() {
    }

    public XmlRef(int i, int i2) {
        super(i, i2);
    }

    /* renamed from: n */
    public final Name mo18725n() {
        return this.f6199j;
    }

    /* renamed from: b */
    public final void mo18786b(Name akVar) {
        this.f6199j = akVar;
        if (akVar != null) {
            akVar.mo18790b(this);
        }
    }

    /* renamed from: o */
    public final boolean mo18726o() {
        return this.f6200k >= 0;
    }

    /* renamed from: i */
    public final void mo18787i(int i) {
        this.f6200k = i;
    }

    /* renamed from: j */
    public final void mo18788j(int i) {
        this.f6201l = i;
    }
}
