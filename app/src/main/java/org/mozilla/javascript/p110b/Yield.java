package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.bp */
public final class Yield extends AstNode {

    /* renamed from: g */
    public AstNode f6203g;

    public Yield() {
        this.f6389a = 72;
    }

    public Yield(int i, int i2, AstNode eVar) {
        super(i, i2);
        this.f6389a = 72;
        this.f6203g = eVar;
        if (eVar != null) {
            eVar.mo18790b(this);
        }
    }
}
