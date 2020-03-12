package org.mozilla.javascript.p113e;

import java.util.Map;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.NodeTransformer;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.p110b.Name;
import org.mozilla.javascript.p110b.ScriptNode;

/* renamed from: org.mozilla.javascript.e.j */
final class OptTransformer extends NodeTransformer {

    /* renamed from: a */
    private Map<String, OptFunctionNode> f6627a;

    /* renamed from: b */
    private ObjArray f6628b;

    OptTransformer(Map<String, OptFunctionNode> map, ObjArray cqVar) {
        this.f6627a = map;
        this.f6628b = cqVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18957a(Node cmVar, ScriptNode auVar) {
        m6612c(cmVar, auVar);
        super.mo18957a(cmVar, auVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo18958b(Node cmVar, ScriptNode auVar) {
        m6612c(cmVar, auVar);
        super.mo18958b(cmVar, auVar);
    }

    /* renamed from: c */
    private void m6612c(Node cmVar, ScriptNode auVar) {
        if (auVar.f6389a == 109) {
            Node b = cmVar.mo18930b();
            int i = 0;
            Node d = b.mo18942d();
            while (d != null) {
                d = d.mo18942d();
                i++;
            }
            if (i == 0) {
                ((OptFunctionNode) auVar.f6155L).f6622e = true;
            }
            if (this.f6627a != null) {
                String str = null;
                if (b.f6389a == 39) {
                    str = ((Name) b).f6130g;
                } else if (b.f6389a == 33) {
                    str = ((Name) b.mo18930b().mo18942d()).f6130g;
                } else if (b.f6389a == 34) {
                    throw Kit.m5810a();
                }
                if (str != null) {
                    OptFunctionNode hVar = (OptFunctionNode) this.f6627a.get(str);
                    if (hVar != null && i == hVar.f6618a.f6153J && !hVar.f6618a.f6261r && i <= 32) {
                        cmVar.mo18925a(9, (Object) hVar);
                        if (!hVar.mo19076a()) {
                            int i2 = this.f6628b.f6407a;
                            this.f6628b.mo18961a((Object) hVar);
                            if (i2 < 0 || hVar.f6620c >= 0) {
                                Kit.m5810a();
                            }
                            hVar.f6620c = i2;
                        }
                    }
                }
            }
        }
    }
}
