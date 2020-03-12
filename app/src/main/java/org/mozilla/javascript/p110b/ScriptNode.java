package org.mozilla.javascript.p110b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;

/* renamed from: org.mozilla.javascript.b.au */
public class ScriptNode extends Scope {

    /* renamed from: C */
    public int f6146C;

    /* renamed from: D */
    public int f6147D;

    /* renamed from: E */
    public String f6148E;

    /* renamed from: F */
    public String f6149F;

    /* renamed from: G */
    public int f6150G;

    /* renamed from: H */
    public List<RegExpLiteral> f6151H;

    /* renamed from: I */
    List<Symbol> f6152I;

    /* renamed from: J */
    public int f6153J;

    /* renamed from: K */
    public String[] f6154K;

    /* renamed from: L */
    public Object f6155L;

    /* renamed from: g */
    private List<FunctionNode> f6156g;

    /* renamed from: h */
    private List<FunctionNode> f6157h;

    /* renamed from: i */
    private boolean[] f6158i;

    /* renamed from: j */
    private int f6159j;

    public ScriptNode() {
        this.f6146C = -1;
        this.f6147D = -1;
        this.f6150G = -1;
        this.f6157h = Collections.emptyList();
        this.f6152I = new ArrayList(4);
        this.f6153J = 0;
        this.f6159j = 0;
        this.f6143B = this;
        this.f6389a = 136;
    }

    public ScriptNode(int i) {
        super(i);
        this.f6146C = -1;
        this.f6147D = -1;
        this.f6150G = -1;
        this.f6157h = Collections.emptyList();
        this.f6152I = new ArrayList(4);
        this.f6153J = 0;
        this.f6159j = 0;
        this.f6143B = this;
        this.f6389a = 136;
    }

    /* renamed from: d */
    public final void mo18760d(int i, int i2) {
        this.f6146C = i;
        this.f6147D = i2;
    }

    /* renamed from: i */
    public final void mo18762i(int i) {
        if (i < 0 || this.f6393e >= 0) {
            throw Kit.m5810a();
        }
        this.f6393e = i;
    }

    /* renamed from: j */
    public final void mo18763j(int i) {
        if (i < 0 || this.f6150G >= 0) {
            throw Kit.m5810a();
        }
        this.f6150G = i;
    }

    /* renamed from: o */
    public final int mo18726o() {
        if (this.f6156g == null) {
            return 0;
        }
        return this.f6156g.size();
    }

    /* renamed from: k */
    public final FunctionNode mo18764k(int i) {
        return (FunctionNode) this.f6156g.get(i);
    }

    /* renamed from: a */
    public int mo18757a(FunctionNode xVar) {
        if (xVar == null) {
            throw Kit.m5810a();
        }
        if (this.f6156g == null) {
            this.f6156g = new ArrayList();
        }
        this.f6156g.add(xVar);
        return this.f6156g.size() - 1;
    }

    /* renamed from: p */
    public final int mo18742p() {
        if (this.f6151H == null) {
            return 0;
        }
        return this.f6151H.size();
    }

    /* renamed from: l */
    public final String mo18765l(int i) {
        return ((RegExpLiteral) this.f6151H.get(i)).f6139g;
    }

    /* renamed from: m */
    public final String mo18766m(int i) {
        return ((RegExpLiteral) this.f6151H.get(i)).f6140h;
    }

    /* renamed from: f */
    public final int mo18761f(Node cmVar) {
        if (this.f6154K == null) {
            throw Kit.m5810a();
        }
        Scope g = cmVar.mo18740g();
        Symbol d = g == null ? null : g.mo18751d(((Name) cmVar).f6130g);
        if (d == null) {
            return -1;
        }
        return d.f6170b;
    }

    /* renamed from: n */
    public final String mo18767n(int i) {
        if (this.f6154K != null) {
            return this.f6154K[i];
        }
        throw Kit.m5810a();
    }

    /* renamed from: v */
    public final int mo18768v() {
        if (this.f6154K != null) {
            return this.f6152I.size();
        }
        throw Kit.m5810a();
    }

    /* renamed from: B */
    public final boolean[] mo18755B() {
        if (this.f6154K != null) {
            return this.f6158i;
        }
        throw Kit.m5810a();
    }

    /* renamed from: a */
    public final void mo18758a(boolean z) {
        boolean z2;
        if (!z) {
            ArrayList arrayList = new ArrayList();
            if (this.f6145z != null) {
                for (int i = 0; i < this.f6152I.size(); i++) {
                    Symbol ayVar = (Symbol) this.f6152I.get(i);
                    if (ayVar.f6172d == this) {
                        arrayList.add(ayVar);
                    }
                }
            }
            this.f6152I = arrayList;
        }
        this.f6154K = new String[this.f6152I.size()];
        this.f6158i = new boolean[this.f6152I.size()];
        for (int i2 = 0; i2 < this.f6152I.size(); i2++) {
            Symbol ayVar2 = (Symbol) this.f6152I.get(i2);
            this.f6154K[i2] = ayVar2.f6171c;
            boolean[] zArr = this.f6158i;
            if (ayVar2.f6169a == 154) {
                z2 = true;
            } else {
                z2 = false;
            }
            zArr[i2] = z2;
            ayVar2.f6170b = i2;
        }
    }

    /* renamed from: b */
    public final void mo18759b(Object obj) {
        m5915a(obj);
        if (this.f6155L != null) {
            throw new IllegalStateException();
        }
        this.f6155L = obj;
    }

    /* renamed from: C */
    public final String mo18756C() {
        StringBuilder sb = new StringBuilder("$");
        int i = this.f6159j;
        this.f6159j = i + 1;
        return sb.append(i).toString();
    }
}
