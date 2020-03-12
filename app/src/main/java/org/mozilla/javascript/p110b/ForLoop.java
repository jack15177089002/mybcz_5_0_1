package org.mozilla.javascript.p110b;

/* renamed from: org.mozilla.javascript.b.v */
public final class ForLoop extends Loop {

    /* renamed from: g */
    public AstNode f6244g;

    /* renamed from: h */
    public AstNode f6245h;

    /* renamed from: i */
    public AstNode f6246i;

    public ForLoop() {
        this.f6389a = 119;
    }

    public ForLoop(int i) {
        super(i);
        this.f6389a = 119;
    }

    /* renamed from: d */
    public final void mo18818d(AstNode eVar) {
        m5915a(eVar);
        this.f6244g = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: e */
    public final void mo18819e(AstNode eVar) {
        m5915a(eVar);
        this.f6245h = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: f */
    public final void mo18820f(AstNode eVar) {
        m5915a(eVar);
        this.f6246i = eVar;
        eVar.mo18790b(this);
    }
}
