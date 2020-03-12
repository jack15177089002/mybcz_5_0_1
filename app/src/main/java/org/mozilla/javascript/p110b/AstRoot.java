package org.mozilla.javascript.p110b;

import java.util.SortedSet;
import java.util.TreeSet;

/* renamed from: org.mozilla.javascript.b.g */
public final class AstRoot extends ScriptNode {

    /* renamed from: g */
    public boolean f6213g;

    /* renamed from: h */
    private SortedSet<Comment> f6214h;

    public AstRoot() {
        this.f6389a = 136;
    }

    public AstRoot(byte b) {
        super(0);
        this.f6389a = 136;
    }

    /* renamed from: b */
    public final void mo18803b(Comment kVar) {
        m5915a(kVar);
        if (this.f6214h == null) {
            this.f6214h = new TreeSet(new C2143f());
        }
        this.f6214h.add(kVar);
        kVar.mo18790b(this);
    }
}
