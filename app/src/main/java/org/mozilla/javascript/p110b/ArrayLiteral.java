package org.mozilla.javascript.p110b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: org.mozilla.javascript.b.c */
public final class ArrayLiteral extends AstNode implements DestructuringForm {

    /* renamed from: j */
    private static final List<AstNode> f6204j = Collections.unmodifiableList(new ArrayList());

    /* renamed from: g */
    public int f6205g;

    /* renamed from: h */
    public int f6206h;

    /* renamed from: i */
    public boolean f6207i;

    /* renamed from: k */
    private List<AstNode> f6208k;

    public ArrayLiteral() {
        this.f6389a = 65;
    }

    public ArrayLiteral(int i) {
        super(i);
        this.f6389a = 65;
    }

    /* renamed from: n */
    public final List<AstNode> mo18725n() {
        return this.f6208k != null ? this.f6208k : f6204j;
    }

    /* renamed from: a */
    public final void mo18789a(AstNode eVar) {
        m5915a(eVar);
        if (this.f6208k == null) {
            this.f6208k = new ArrayList();
        }
        this.f6208k.add(eVar);
        eVar.mo18790b(this);
    }

    /* renamed from: o */
    public final void mo18726o() {
        this.f6207i = true;
    }

    /* renamed from: p */
    public final boolean mo18742p() {
        return this.f6207i;
    }
}
