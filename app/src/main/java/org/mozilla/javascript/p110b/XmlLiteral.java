package org.mozilla.javascript.p110b;

import java.util.ArrayList;
import java.util.List;

/* renamed from: org.mozilla.javascript.b.bk */
public final class XmlLiteral extends AstNode {

    /* renamed from: g */
    public List<XmlFragment> f6197g;

    public XmlLiteral() {
        this.f6197g = new ArrayList();
        this.f6389a = 145;
    }

    public XmlLiteral(int i) {
        super(i);
        this.f6197g = new ArrayList();
        this.f6389a = 145;
    }

    /* renamed from: a */
    public final void mo18784a(XmlFragment bjVar) {
        m5915a(bjVar);
        this.f6197g.add(bjVar);
        bjVar.mo18790b(this);
    }
}
