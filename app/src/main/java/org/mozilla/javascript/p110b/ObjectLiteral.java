package org.mozilla.javascript.p110b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: org.mozilla.javascript.b.an */
public final class ObjectLiteral extends AstNode implements DestructuringForm {

    /* renamed from: h */
    private static final List<ObjectProperty> f6135h = Collections.unmodifiableList(new ArrayList());

    /* renamed from: g */
    public boolean f6136g;

    /* renamed from: i */
    private List<ObjectProperty> f6137i;

    public ObjectLiteral() {
        this.f6389a = 66;
    }

    public ObjectLiteral(int i, int i2) {
        super(i, i2);
        this.f6389a = 66;
    }

    /* renamed from: n */
    public final List<ObjectProperty> mo18725n() {
        return this.f6137i != null ? this.f6137i : f6135h;
    }

    /* renamed from: a */
    public final void mo18741a(List<ObjectProperty> list) {
        if (this.f6137i != null) {
            this.f6137i.clear();
        }
        for (ObjectProperty aoVar : list) {
            m5915a(aoVar);
            if (this.f6137i == null) {
                this.f6137i = new ArrayList();
            }
            this.f6137i.add(aoVar);
            aoVar.mo18790b(this);
        }
    }

    /* renamed from: o */
    public final void mo18726o() {
        this.f6136g = true;
    }

    /* renamed from: p */
    public final boolean mo18742p() {
        return this.f6136g;
    }
}
