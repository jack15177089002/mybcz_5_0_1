package org.mozilla.javascript.p110b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: org.mozilla.javascript.b.w */
public class FunctionCall extends AstNode {

    /* renamed from: g */
    protected static final List<AstNode> f6247g = Collections.unmodifiableList(new ArrayList());

    /* renamed from: h */
    protected AstNode f6248h;

    /* renamed from: i */
    protected List<AstNode> f6249i;

    /* renamed from: j */
    protected int f6250j;

    /* renamed from: k */
    protected int f6251k;

    public FunctionCall() {
        this.f6250j = -1;
        this.f6251k = -1;
        this.f6389a = 38;
    }

    public FunctionCall(int i) {
        super(i);
        this.f6250j = -1;
        this.f6251k = -1;
        this.f6389a = 38;
    }

    /* renamed from: n */
    public final AstNode mo18725n() {
        return this.f6248h;
    }

    /* renamed from: a */
    public final void mo18822a(AstNode eVar) {
        m5915a(eVar);
        this.f6248h = eVar;
        eVar.mo18790b(this);
    }

    /* renamed from: o */
    public final List<AstNode> mo18726o() {
        return this.f6249i != null ? this.f6249i : f6247g;
    }

    /* renamed from: a */
    public final void mo18821a(List<AstNode> list) {
        if (list == null) {
            this.f6249i = null;
            return;
        }
        if (this.f6249i != null) {
            this.f6249i.clear();
        }
        for (AstNode eVar : list) {
            m5915a(eVar);
            if (this.f6249i == null) {
                this.f6249i = new ArrayList();
            }
            this.f6249i.add(eVar);
            eVar.mo18790b(this);
        }
    }

    /* renamed from: i */
    public final void mo18824i(int i) {
        this.f6250j = i;
    }

    /* renamed from: j */
    public final void mo18825j(int i) {
        this.f6251k = i;
    }

    /* renamed from: d */
    public final void mo18823d(int i, int i2) {
        this.f6250j = i;
        this.f6251k = i2;
    }
}
