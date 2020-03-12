package org.mozilla.javascript.p110b;

import java.util.ArrayList;
import java.util.List;

/* renamed from: org.mozilla.javascript.b.aw */
public final class SwitchCase extends AstNode {

    /* renamed from: g */
    public AstNode f6162g;

    /* renamed from: h */
    public List<AstNode> f6163h;

    public SwitchCase() {
        this.f6389a = 115;
    }

    public SwitchCase(int i) {
        super(i);
        this.f6389a = 115;
    }

    /* renamed from: a */
    public final void mo18770a(AstNode eVar) {
        m5915a(eVar);
        if (this.f6163h == null) {
            this.f6163h = new ArrayList();
        }
        mo18796g((eVar.mo18798q() + eVar.mo18800s()) - mo18798q());
        this.f6163h.add(eVar);
        eVar.mo18790b(this);
    }
}
