package org.mozilla.javascript.p110b;

import java.util.ArrayList;
import java.util.List;
import org.mozilla.javascript.Node;

/* renamed from: org.mozilla.javascript.b.bc */
public final class VariableDeclaration extends AstNode {

    /* renamed from: g */
    public List<VariableInitializer> f6182g;

    /* renamed from: h */
    public boolean f6183h;

    public VariableDeclaration() {
        this.f6182g = new ArrayList();
        this.f6389a = 122;
    }

    public VariableDeclaration(int i) {
        super(i);
        this.f6182g = new ArrayList();
        this.f6389a = 122;
    }

    /* renamed from: a */
    public final void mo18778a(VariableInitializer bdVar) {
        m5915a(bdVar);
        this.f6182g.add(bdVar);
        bdVar.mo18790b(this);
    }

    /* renamed from: a */
    public final Node mo18730a(int i) {
        if (i == 122 || i == 154 || i == 153) {
            return super.mo18730a(i);
        }
        throw new IllegalArgumentException("invalid decl type: " + i);
    }
}
