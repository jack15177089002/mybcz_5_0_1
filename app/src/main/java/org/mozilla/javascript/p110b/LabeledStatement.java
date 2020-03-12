package org.mozilla.javascript.p110b;

import java.util.ArrayList;
import java.util.List;

/* renamed from: org.mozilla.javascript.b.ah */
public final class LabeledStatement extends AstNode {

    /* renamed from: g */
    public List<Label> f6121g;

    /* renamed from: h */
    public AstNode f6122h;

    public LabeledStatement() {
        this.f6121g = new ArrayList();
        this.f6389a = 133;
    }

    public LabeledStatement(int i) {
        super(i);
        this.f6121g = new ArrayList();
        this.f6389a = 133;
    }

    /* renamed from: a */
    public final void mo18731a(Label agVar) {
        m5915a(agVar);
        this.f6121g.add(agVar);
        agVar.mo18790b(this);
    }

    /* renamed from: c */
    public final Label mo18733c(String str) {
        for (Label agVar : this.f6121g) {
            if (str.equals(agVar.f6120g)) {
                return agVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final void mo18732a(AstNode eVar) {
        m5915a(eVar);
        this.f6122h = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: n */
    public final Label mo18725n() {
        return (Label) this.f6121g.get(0);
    }
}
