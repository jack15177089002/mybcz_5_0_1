package org.mozilla.javascript.p110b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.mozilla.javascript.Kit;

/* renamed from: org.mozilla.javascript.b.at */
public class Scope extends Jump {

    /* renamed from: A */
    protected Scope f6142A;

    /* renamed from: B */
    protected ScriptNode f6143B;

    /* renamed from: g */
    private List<Scope> f6144g;

    /* renamed from: z */
    protected Map<String, Symbol> f6145z;

    public Scope() {
        this.f6389a = 129;
    }

    public Scope(int i) {
        this.f6389a = 129;
        this.f6210m = i;
    }

    public Scope(int i, int i2) {
        this(i);
        this.f6211n = i2;
    }

    /* renamed from: y */
    public final Scope mo18753y() {
        return this.f6142A;
    }

    /* renamed from: b */
    public final void mo18748b(Scope atVar) {
        this.f6142A = atVar;
        this.f6143B = atVar == null ? (ScriptNode) this : atVar.f6143B;
    }

    /* renamed from: c */
    public final void mo18750c(Scope atVar) {
        if (this.f6144g == null) {
            this.f6144g = new ArrayList();
        }
        this.f6144g.add(atVar);
        atVar.mo18748b(this);
    }

    /* renamed from: d */
    public final void mo18752d(Scope atVar) {
        if (this.f6144g != null) {
            for (Scope c : this.f6144g) {
                atVar.mo18750c(c);
            }
            this.f6144g.clear();
            this.f6144g = null;
        }
        if (this.f6145z != null && !this.f6145z.isEmpty()) {
            m5858a(this, atVar);
        }
    }

    /* renamed from: e */
    public static Scope m5859e(Scope atVar) {
        Scope atVar2 = new Scope(atVar.f6389a);
        atVar2.f6145z = atVar.f6145z;
        atVar.f6145z = null;
        atVar2.f6212o = atVar.f6212o;
        atVar2.mo18748b(atVar.f6142A);
        atVar2.mo18748b(atVar2);
        atVar.f6212o = atVar2;
        atVar2.f6143B = atVar.f6143B;
        return atVar2;
    }

    /* renamed from: a */
    public static void m5858a(Scope atVar, Scope atVar2) {
        Map n = atVar.mo18725n();
        Map n2 = atVar2.mo18725n();
        if (!Collections.disjoint(n.keySet(), n2.keySet())) {
            throw Kit.m5810a();
        }
//        for (Entry entry : n.entrySet()) {
//            Symbol ayVar = (Symbol) entry.getValue();
//            ayVar.f6172d = atVar2;
//            n2.put(entry.getKey(), ayVar);
//        }
    }

    /* renamed from: c */
    public final Scope mo18749c(String str) {
        for (Scope atVar = this; atVar != null; atVar = atVar.f6142A) {
            Map<String, Symbol> map = atVar.f6145z;
            if (map != null && map.containsKey(str)) {
                return atVar;
            }
        }
        return null;
    }

    /* renamed from: d */
    public final Symbol mo18751d(String str) {
        if (this.f6145z == null) {
            return null;
        }
        return (Symbol) this.f6145z.get(str);
    }

    /* renamed from: a */
    public final void mo18747a(Symbol ayVar) {
        if (ayVar.f6171c == null) {
            throw new IllegalArgumentException("null symbol name");
        }
        mo18725n();
        this.f6145z.put(ayVar.f6171c, ayVar);
        ayVar.f6172d = this;
        ScriptNode auVar = this.f6143B;
        if (auVar.f6154K != null) {
            throw Kit.m5810a();
        }
        if (ayVar.f6169a == 87) {
            auVar.f6153J++;
        }
        auVar.f6152I.add(ayVar);
    }

    /* renamed from: z */
    public final Map<String, Symbol> mo18754z() {
        return this.f6145z;
    }

    /* renamed from: A */
    public final void mo18746A() {
        this.f6145z = null;
    }

    /* renamed from: n */
    private Map<String, Symbol> mo18725n() {
        if (this.f6145z == null) {
            this.f6145z = new LinkedHashMap(5);
        }
        return this.f6145z;
    }
}
