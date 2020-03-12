package org.mozilla.javascript.p113e;

import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.p110b.FunctionNode;
import org.mozilla.javascript.p110b.ScriptNode;

/* renamed from: org.mozilla.javascript.e.h */
public final class OptFunctionNode {

    /* renamed from: a */
    public final FunctionNode f6618a;

    /* renamed from: b */
    boolean[] f6619b;

    /* renamed from: c */
    int f6620c = -1;

    /* renamed from: d */
    boolean f6621d;

    /* renamed from: e */
    boolean f6622e;

    /* renamed from: f */
    boolean f6623f;

    OptFunctionNode(FunctionNode xVar) {
        this.f6618a = xVar;
        xVar.mo18759b(this);
    }

    /* renamed from: a */
    public static OptFunctionNode m6606a(ScriptNode auVar, int i) {
        return (OptFunctionNode) auVar.mo18764k(i).f6155L;
    }

    /* renamed from: a */
    public final boolean mo19076a() {
        return this.f6620c >= 0;
    }

    /* renamed from: a */
    public final boolean mo19077a(int i) {
        return i < this.f6618a.f6153J;
    }

    /* renamed from: b */
    public final boolean mo19078b(int i) {
        int i2 = i - this.f6618a.f6153J;
        if (i2 < 0 || this.f6619b == null) {
            return false;
        }
        return this.f6619b[i2];
    }

    /* renamed from: a */
    public final int mo19075a(Node cmVar) {
        Node b;
        int a = cmVar.mo18924a(7, -1);
        if (a == -1) {
            int i = cmVar.f6389a;
            if (i == 55) {
                b = cmVar;
            } else if (i == 56 || i == 156) {
                b = cmVar.mo18930b();
            } else {
                throw Kit.m5810a();
            }
            a = this.f6618a.mo18761f(b);
            if (a < 0) {
                throw Kit.m5810a();
            }
            cmVar.mo18933b(7, a);
        }
        return a;
    }
}
