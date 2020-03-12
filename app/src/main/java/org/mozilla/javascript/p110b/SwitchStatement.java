package org.mozilla.javascript.p110b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: org.mozilla.javascript.b.ax */
public final class SwitchStatement extends Jump {

    /* renamed from: g */
    public static final List<SwitchCase> f6164g = Collections.unmodifiableList(new ArrayList());

    /* renamed from: h */
    public AstNode f6165h;

    /* renamed from: i */
    public List<SwitchCase> f6166i;

    /* renamed from: j */
    public int f6167j;

    /* renamed from: k */
    public int f6168k;

    public SwitchStatement() {
        this.f6167j = -1;
        this.f6168k = -1;
        this.f6389a = 114;
    }

    public SwitchStatement(int i) {
        this.f6167j = -1;
        this.f6168k = -1;
        this.f6389a = 114;
        this.f6210m = i;
    }

    /* renamed from: a */
    public final void mo18772a(AstNode eVar) {
        m5915a(eVar);
        this.f6165h = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: a */
    public final void mo18771a(SwitchCase awVar) {
        m5915a(awVar);
        if (this.f6166i == null) {
            this.f6166i = new ArrayList();
        }
        this.f6166i.add(awVar);
        awVar.mo18790b(this);
    }
}
