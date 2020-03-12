package org.mozilla.javascript.p110b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: org.mozilla.javascript.b.ba */
public final class TryStatement extends AstNode {

    /* renamed from: g */
    public static final List<CatchClause> f6175g = Collections.unmodifiableList(new ArrayList());

    /* renamed from: h */
    public AstNode f6176h;

    /* renamed from: i */
    public List<CatchClause> f6177i;

    /* renamed from: j */
    public AstNode f6178j;

    /* renamed from: k */
    public int f6179k;

    public TryStatement() {
        this.f6179k = -1;
        this.f6389a = 81;
    }

    public TryStatement(int i, int i2) {
        super(i, i2);
        this.f6179k = -1;
        this.f6389a = 81;
    }

    /* renamed from: a */
    public final void mo18775a(AstNode eVar) {
        m5915a(eVar);
        this.f6176h = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: a */
    public final void mo18774a(List<CatchClause> list) {
        if (list == null) {
            this.f6177i = null;
            return;
        }
        if (this.f6177i != null) {
            this.f6177i.clear();
        }
        for (CatchClause jVar : list) {
            m5915a(jVar);
            if (this.f6177i == null) {
                this.f6177i = new ArrayList();
            }
            this.f6177i.add(jVar);
            jVar.mo18790b(this);
        }
    }
}
