package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.u */
public class ForInLoop extends Loop {

    /* renamed from: g */
    protected AstNode f6239g;

    /* renamed from: h */
    protected AstNode f6240h;

    /* renamed from: i */
    protected int f6241i;

    /* renamed from: j */
    protected int f6242j;

    /* renamed from: k */
    protected boolean f6243k;

    public ForInLoop() {
        this.f6241i = -1;
        this.f6242j = -1;
        this.f6389a = 119;
    }

    public ForInLoop(int i) {
        super(i);
        this.f6241i = -1;
        this.f6242j = -1;
        this.f6389a = 119;
    }

    /* renamed from: o */
    public final AstNode mo18726o() {
        return this.f6239g;
    }

    /* renamed from: d */
    public final void mo18814d(AstNode eVar) {
        m5915a(eVar);
        this.f6239g = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: p */
    public final AstNode mo18742p() {
        return this.f6240h;
    }

    /* renamed from: e */
    public final void mo18815e(AstNode eVar) {
        m5915a(eVar);
        this.f6240h = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: v */
    public boolean mo18717v() {
        return this.f6243k;
    }

    /* renamed from: a */
    public void mo18716a(boolean z) {
        this.f6243k = z;
    }

    /* renamed from: i */
    public final void mo18816i(int i) {
        this.f6241i = i;
    }

    /* renamed from: j */
    public final void mo18817j(int i) {
        this.f6242j = i;
    }
}
