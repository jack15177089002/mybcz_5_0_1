package org.mozilla.javascript.p110b;

import org.mozilla.javascript.Kit;

/* renamed from: org.mozilla.javascript.b.l */
public final class ConditionalExpression extends AstNode {

    /* renamed from: g */
    public AstNode f6225g;

    /* renamed from: h */
    public AstNode f6226h;

    /* renamed from: i */
    public AstNode f6227i;

    /* renamed from: j */
    public int f6228j;

    /* renamed from: k */
    public int f6229k;

    public ConditionalExpression() {
        this.f6228j = -1;
        this.f6229k = -1;
        this.f6389a = 102;
    }

    public ConditionalExpression(int i, int i2) {
        super(i, i2);
        this.f6228j = -1;
        this.f6229k = -1;
        this.f6389a = 102;
    }

    /* renamed from: a */
    public final void mo18807a(AstNode eVar) {
        m5915a(eVar);
        this.f6225g = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: d */
    public final void mo18808d(AstNode eVar) {
        m5915a(eVar);
        this.f6226h = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: e */
    public final void mo18809e(AstNode eVar) {
        m5915a(eVar);
        this.f6227i = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: k */
    public final boolean mo18724k() {
        if (this.f6225g != null && this.f6226h != null && this.f6227i != null) {
            return this.f6226h.mo18724k() && this.f6227i.mo18724k();
        }
        throw Kit.m5810a();
    }
}
