package org.mozilla.javascript.p110b;

import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;

/* renamed from: org.mozilla.javascript.b.ae */
public class Jump extends AstNode {

    /* renamed from: w */
    public Node f6117w;

    /* renamed from: x */
    public Node f6118x;

    /* renamed from: y */
    public Jump f6119y;

    public Jump() {
        this.f6389a = -1;
    }

    public Jump(int i) {
        this.f6389a = i;
    }

    public Jump(int i, Node cmVar) {
        this(i);
        mo18935b(cmVar);
    }

    public Jump(Node cmVar, int i) {
        this(81, cmVar);
        this.f6393e = i;
    }

    /* renamed from: w */
    public final Jump mo18728w() {
        if (this.f6389a == 120 || this.f6389a == 121) {
            return this.f6119y;
        }
        throw Kit.m5810a();
    }

    /* renamed from: b */
    public final void mo18727b(Jump aeVar) {
        if (this.f6389a != 120 && this.f6389a != 121) {
            throw Kit.m5810a();
        } else if (aeVar == null) {
            throw Kit.m5810a();
        } else if (this.f6119y != null) {
            throw Kit.m5810a();
        } else {
            this.f6119y = aeVar;
        }
    }

    /* renamed from: x */
    public final Node mo18729x() {
        if (this.f6389a == 81) {
            return this.f6118x;
        }
        throw Kit.m5810a();
    }
}
