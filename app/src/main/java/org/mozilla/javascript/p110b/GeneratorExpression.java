package org.mozilla.javascript.p110b;

import java.util.ArrayList;
import java.util.List;

/* renamed from: org.mozilla.javascript.b.z */
public final class GeneratorExpression extends Scope {

    /* renamed from: g */
    public AstNode f6270g;

    /* renamed from: h */
    public List<GeneratorExpressionLoop> f6271h;

    /* renamed from: i */
    public AstNode f6272i;

    /* renamed from: j */
    public int f6273j;

    /* renamed from: k */
    public int f6274k;

    /* renamed from: l */
    public int f6275l;

    public GeneratorExpression() {
        this.f6271h = new ArrayList();
        this.f6273j = -1;
        this.f6274k = -1;
        this.f6275l = -1;
        this.f6389a = 162;
    }

    public GeneratorExpression(int i, int i2) {
        super(i, i2);
        this.f6271h = new ArrayList();
        this.f6273j = -1;
        this.f6274k = -1;
        this.f6275l = -1;
        this.f6389a = 162;
    }

    /* renamed from: a */
    public final void mo18830a(AstNode eVar) {
        m5915a(eVar);
        this.f6270g = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: a */
    public final void mo18829a(List<GeneratorExpressionLoop> list) {
        m5915a(list);
        this.f6271h.clear();
        for (GeneratorExpressionLoop aaVar : list) {
            m5915a(aaVar);
            this.f6271h.add(aaVar);
            aaVar.mo18790b(this);
        }
    }
}
