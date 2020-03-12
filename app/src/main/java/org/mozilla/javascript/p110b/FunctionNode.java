package org.mozilla.javascript.p110b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mozilla.javascript.Node;

/* renamed from: org.mozilla.javascript.b.x */
public final class FunctionNode extends ScriptNode {

    /* renamed from: g */
    public static final List<AstNode> f6252g = Collections.unmodifiableList(new ArrayList());

    /* renamed from: M */
    private int f6253M;

    /* renamed from: h */
    public Name f6254h;

    /* renamed from: i */
    public List<AstNode> f6255i;

    /* renamed from: j */
    public AstNode f6256j;

    /* renamed from: k */
    public boolean f6257k;

    /* renamed from: l */
    public int f6258l;

    /* renamed from: p */
    public int f6259p;

    /* renamed from: q */
    public int f6260q;

    /* renamed from: r */
    public boolean f6261r;

    /* renamed from: s */
    public boolean f6262s;

    /* renamed from: t */
    public List<Node> f6263t;

    /* renamed from: u */
    public Map<Node, int[]> f6264u;

    /* renamed from: v */
    public AstNode f6265v;

    public FunctionNode() {
        this.f6253M = C2144y.f6266a;
        this.f6258l = -1;
        this.f6259p = -1;
        this.f6389a = 109;
    }

    public FunctionNode(int i, Name akVar) {
        super(i);
        this.f6253M = C2144y.f6266a;
        this.f6258l = -1;
        this.f6259p = -1;
        this.f6389a = 109;
        this.f6254h = akVar;
        if (akVar != null) {
            akVar.mo18790b(this);
        }
    }

    /* renamed from: n */
    public final String mo18725n() {
        return this.f6254h != null ? this.f6254h.f6130g : "";
    }

    /* renamed from: a */
    public final void mo18826a(AstNode eVar) {
        m5915a(eVar);
        if (this.f6255i == null) {
            this.f6255i = new ArrayList();
        }
        this.f6255i.add(eVar);
        eVar.mo18790b(this);
    }

    /* renamed from: d */
    public final void mo18828d(AstNode eVar) {
        m5915a(eVar);
        this.f6256j = eVar;
        if (Boolean.TRUE.equals(eVar.mo18937c(25))) {
            this.f6257k = true;
        }
        int q = eVar.mo18798q() + eVar.mo18800s();
        eVar.mo18790b(this);
        mo18796g(q - this.f6210m);
        mo18760d(this.f6210m, q);
    }

    /* renamed from: a */
    public final void mo18827a(Node cmVar, int[] iArr) {
        if (this.f6264u == null) {
            this.f6264u = new HashMap();
        }
        this.f6264u.put(cmVar, iArr);
    }

    /* renamed from: a */
    public final int mo18757a(FunctionNode xVar) {
        int a = super.mo18757a(xVar);
        if (mo18726o() > 0) {
            this.f6261r = true;
        }
        return a;
    }
}
