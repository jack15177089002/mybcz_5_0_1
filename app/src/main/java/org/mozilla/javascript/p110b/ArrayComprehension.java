package org.mozilla.javascript.p110b;

import java.util.ArrayList;
import java.util.List;

/* renamed from: org.mozilla.javascript.b.a */
public final class ArrayComprehension extends Scope {

    /* renamed from: g */
    public AstNode f6102g;

    /* renamed from: h */
    public List<ArrayComprehensionLoop> f6103h;

    /* renamed from: i */
    public AstNode f6104i;

    /* renamed from: j */
    public int f6105j;

    /* renamed from: k */
    public int f6106k;

    /* renamed from: l */
    public int f6107l;

    public ArrayComprehension() {
        this.f6103h = new ArrayList();
        this.f6105j = -1;
        this.f6106k = -1;
        this.f6107l = -1;
        this.f6389a = 157;
    }

    public ArrayComprehension(int i, int i2) {
        super(i, i2);
        this.f6103h = new ArrayList();
        this.f6105j = -1;
        this.f6106k = -1;
        this.f6107l = -1;
        this.f6389a = 157;
    }

    /* renamed from: a */
    public final void mo18715a(AstNode eVar) {
        m5915a(eVar);
        this.f6102g = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: a */
    public final void mo18714a(List<ArrayComprehensionLoop> list) {
        m5915a(list);
        this.f6103h.clear();
        for (ArrayComprehensionLoop bVar : list) {
            m5915a(bVar);
            this.f6103h.add(bVar);
            bVar.mo18790b(this);
        }
    }
}
