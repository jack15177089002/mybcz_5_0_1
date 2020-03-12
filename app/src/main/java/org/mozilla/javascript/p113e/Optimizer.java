package org.mozilla.javascript.p113e;

import java.util.HashMap;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.p110b.Jump;
import org.mozilla.javascript.p110b.ScriptNode;

/* renamed from: org.mozilla.javascript.e.k */
final class Optimizer {

    /* renamed from: a */
    OptFunctionNode f6629a;

    /* renamed from: b */
    private boolean f6630b;

    /* renamed from: c */
    private boolean f6631c;

    Optimizer() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo19079a(ScriptNode auVar) {
        int o = auVar.mo18726o();
        for (int i = 0; i != o; i++) {
            OptFunctionNode a = OptFunctionNode.m6606a(auVar, i);
            if (!a.f6618a.f6261r) {
                this.f6630b = a.mo19076a();
                this.f6629a = a;
                ObjArray cqVar = new ObjArray();
                m6618a((Node) a.f6618a, cqVar);
                Node[] cmVarArr = new Node[cqVar.f6407a];
                cqVar.mo18962a((Object[]) cmVarArr);
                int i2 = a.f6618a.f6153J;
                int v = a.f6618a.mo18768v();
                int[] iArr = new int[v];
                for (int i3 = 0; i3 != i2; i3++) {
                    iArr[i3] = 3;
                }
                for (int i4 = i2; i4 != v; i4++) {
                    iArr[i4] = 0;
                }
                HashMap hashMap = new HashMap();
                ObjArray cqVar2 = new ObjArray();
                int i5 = 0;
                for (int i6 = 0; i6 < cmVarArr.length; i6++) {
                    switch (cmVarArr[i6].f6389a) {
                        case 5:
                        case 6:
                        case 7:
                            C2185b a2 = C2184a.m6506a(i5, i6);
                            if (cmVarArr[i5].f6389a == 131) {
                                hashMap.put(cmVarArr[i5], a2);
                            }
                            cqVar2.mo18961a((Object) a2);
                            i5 = i6 + 1;
                            break;
                        case 131:
                            if (i6 == i5) {
                                break;
                            } else {
                                C2185b a3 = C2184a.m6506a(i5, i6 - 1);
                                if (cmVarArr[i5].f6389a == 131) {
                                    hashMap.put(cmVarArr[i5], a3);
                                }
                                cqVar2.mo18961a((Object) a3);
                                i5 = i6;
                                break;
                            }
                    }
                }
                if (i5 != cmVarArr.length) {
                    C2185b a4 = C2184a.m6506a(i5, cmVarArr.length - 1);
                    if (cmVarArr[i5].f6389a == 131) {
                        hashMap.put(cmVarArr[i5], a4);
                    }
                    cqVar2.mo18961a((Object) a4);
                }
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 < cqVar2.f6407a) {
                        C2185b bVar = (C2185b) cqVar2.mo18960a(i8);
                        Node cmVar = cmVarArr[bVar.f6561c.f6552c];
                        int i9 = cmVar.f6389a;
                        if (i9 != 5 && i8 < cqVar2.f6407a - 1) {
                            C2185b bVar2 = (C2185b) cqVar2.mo18960a(i8 + 1);
                            bVar.mo19064a(bVar2);
                            bVar2.mo19065b(bVar);
                        }
                        if (i9 == 7 || i9 == 6 || i9 == 5) {
                            Node cmVar2 = ((Jump) cmVar).f6117w;
                            C2185b bVar3 = (C2185b) hashMap.get(cmVar2);
                            cmVar2.mo18925a(6, (Object) bVar3.f6561c);
                            bVar.mo19064a(bVar3);
                            bVar3.mo19065b(bVar);
                        }
                        i7 = i8 + 1;
                    } else {
                        C2184a[] aVarArr = new C2184a[cqVar2.f6407a];
                        int i10 = 0;
                        while (true) {
                            int i11 = i10;
                            if (i11 < cqVar2.f6407a) {
                                C2185b bVar4 = (C2185b) cqVar2.mo18960a(i11);
                                C2184a aVar = bVar4.f6561c;
                                aVar.f6550a = C2185b.m6514a(bVar4.f6559a);
                                aVar.f6551b = C2185b.m6514a(bVar4.f6560b);
                                aVar.f6553d = i11;
                                aVarArr[i11] = aVar;
                                i10 = i11 + 1;
                            } else {
                                C2184a.m6508a(a, cmVarArr, aVarArr, iArr);
                                C2184a.m6512b(a, cmVarArr, aVarArr, iArr);
                                for (int i12 = i2; i12 != v; i12++) {
                                    if (iArr[i12] == 1) {
                                        int i13 = i12 - a.f6618a.f6153J;
                                        if (i13 < 0) {
                                            Kit.m5810a();
                                        }
                                        if (a.f6619b == null) {
                                            a.f6619b = new boolean[(a.f6618a.mo18768v() - a.f6618a.f6153J)];
                                        }
                                        a.f6619b[i13] = true;
                                    }
                                }
                                if (!a.f6618a.f6261r) {
                                    this.f6631c = false;
                                    for (Node a5 : cmVarArr) {
                                        m6615a(a5, 1);
                                    }
                                    a.f6621d = this.f6631c;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m6616a(Node cmVar) {
        if (this.f6630b && cmVar.f6389a == 55) {
            if (this.f6629a.mo19077a(this.f6629a.mo19075a(cmVar))) {
                this.f6631c = true;
            }
        }
    }

    /* renamed from: b */
    private boolean m6619b(Node cmVar) {
        if (this.f6630b && cmVar.f6389a == 55) {
            if (this.f6629a.mo19077a(this.f6629a.mo19075a(cmVar))) {
                cmVar.mo18932b(8);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private int m6615a(Node cmVar, int i) {
        while (true) {
            switch (cmVar.f6389a) {
                case 9:
                case 10:
                case 11:
                case 18:
                case 19:
                case 22:
                case 23:
                case 24:
                case 25:
                    Node b = cmVar.mo18930b();
                    Node d = b.mo18942d();
                    int a = m6615a(b, 1);
                    int a2 = m6615a(d, 1);
                    m6616a(b);
                    m6616a(d);
                    if (a == 1) {
                        if (a2 == 1) {
                            cmVar.mo18933b(8, 0);
                            return 1;
                        } else if (m6619b(d)) {
                            return 1;
                        } else {
                            cmVar.mo18947e(d);
                            cmVar.mo18935b(new Node(150, d));
                            cmVar.mo18933b(8, 0);
                            return 1;
                        }
                    } else if (a2 != 1) {
                        if (!m6619b(b)) {
                            cmVar.mo18947e(b);
                            cmVar.mo18927a(new Node(150, b));
                        }
                        if (!m6619b(d)) {
                            cmVar.mo18947e(d);
                            cmVar.mo18935b(new Node(150, d));
                        }
                        cmVar.mo18933b(8, 0);
                        return 1;
                    } else if (m6619b(b)) {
                        return 1;
                    } else {
                        cmVar.mo18947e(b);
                        cmVar.mo18927a(new Node(150, b));
                        cmVar.mo18933b(8, 0);
                        return 1;
                    }
                case 14:
                case 15:
                case 16:
                case 17:
                    Node b2 = cmVar.mo18930b();
                    Node d2 = b2.mo18942d();
                    int a3 = m6615a(b2, 1);
                    int a4 = m6615a(d2, 1);
                    m6616a(b2);
                    m6616a(d2);
                    if (m6619b(b2)) {
                        if (m6619b(d2)) {
                            return 0;
                        }
                        if (a4 == 1) {
                            cmVar.mo18933b(8, 2);
                        }
                    } else if (m6619b(d2)) {
                        if (a3 == 1) {
                            cmVar.mo18933b(8, 1);
                        }
                    } else if (a3 == 1) {
                        if (a4 == 1) {
                            cmVar.mo18933b(8, 0);
                        } else {
                            cmVar.mo18933b(8, 1);
                        }
                    } else if (a4 == 1) {
                        cmVar.mo18933b(8, 2);
                    }
                    return 0;
                case 21:
                    Node b3 = cmVar.mo18930b();
                    Node d3 = b3.mo18942d();
                    int a5 = m6615a(b3, 1);
                    int a6 = m6615a(d3, 1);
                    if (m6619b(b3)) {
                        if (m6619b(d3)) {
                            return 0;
                        }
                        if (a6 == 1) {
                            cmVar.mo18933b(8, 2);
                        }
                    } else if (m6619b(d3)) {
                        if (a5 == 1) {
                            cmVar.mo18933b(8, 1);
                        }
                    } else if (a5 == 1) {
                        if (a6 == 1) {
                            cmVar.mo18933b(8, 0);
                            return 1;
                        }
                        cmVar.mo18933b(8, 1);
                    } else if (a6 == 1) {
                        cmVar.mo18933b(8, 2);
                    }
                    return 0;
                case 36:
                    Node b4 = cmVar.mo18930b();
                    Node d4 = b4.mo18942d();
                    if (m6615a(b4, 1) == 1 && !m6619b(b4)) {
                        cmVar.mo18947e(b4);
                        cmVar.mo18927a(new Node(149, b4));
                    }
                    if (m6615a(d4, 1) == 1 && !m6619b(d4)) {
                        cmVar.mo18933b(8, 2);
                    }
                    return 0;
                case 37:
                case 140:
                    Node b5 = cmVar.mo18930b();
                    Node d5 = b5.mo18942d();
                    Node d6 = d5.mo18942d();
                    if (m6615a(b5, 1) == 1 && !m6619b(b5)) {
                        cmVar.mo18947e(b5);
                        cmVar.mo18927a(new Node(149, b5));
                    }
                    if (m6615a(d5, 1) == 1 && !m6619b(d5)) {
                        cmVar.mo18933b(8, 1);
                    }
                    if (m6615a(d6, 1) == 1 && !m6619b(d6)) {
                        cmVar.mo18947e(d6);
                        cmVar.mo18935b(new Node(149, d6));
                    }
                    return 0;
                case 38:
                    Node b6 = cmVar.mo18930b();
                    m6617a(b6, b6.mo18930b());
                    Node d7 = b6.mo18942d();
                    if (((OptFunctionNode) cmVar.mo18937c(9)) != null) {
                        for (Node cmVar2 = d7; cmVar2 != null; cmVar2 = cmVar2.mo18942d()) {
                            if (m6615a(cmVar2, 1) == 1) {
                                m6616a(cmVar2);
                            }
                        }
                    } else {
                        m6617a(cmVar, d7);
                    }
                    return 0;
                case 40:
                    cmVar.mo18933b(8, 0);
                    return 1;
                case 55:
                    int a7 = this.f6629a.mo19075a(cmVar);
                    if (this.f6630b && this.f6629a.mo19077a(a7) && i == 1) {
                        cmVar.mo18933b(8, 0);
                        return 1;
                    } else if (!this.f6629a.mo19078b(a7)) {
                        return 0;
                    } else {
                        cmVar.mo18933b(8, 0);
                        return 1;
                    }
                case 56:
                    Node d8 = cmVar.mo18930b().mo18942d();
                    int a8 = m6615a(d8, 1);
                    int a9 = this.f6629a.mo19075a(cmVar);
                    if (!this.f6630b || !this.f6629a.mo19077a(a9)) {
                        if (this.f6629a.mo19078b(a9)) {
                            if (a8 != 1) {
                                cmVar.mo18947e(d8);
                                cmVar.mo18935b(new Node(150, d8));
                            }
                            cmVar.mo18933b(8, 0);
                            m6616a(d8);
                            return 1;
                        }
                        if (a8 == 1 && !m6619b(d8)) {
                            cmVar.mo18947e(d8);
                            cmVar.mo18935b(new Node(149, d8));
                        }
                        return 0;
                    } else if (a8 != 1) {
                        return a8;
                    } else {
                        if (!m6619b(d8)) {
                            cmVar.mo18933b(8, 0);
                            return 1;
                        }
                        m6616a(d8);
                        return 0;
                    }
                case 106:
                case 107:
                    Node b7 = cmVar.mo18930b();
                    if (b7.f6389a == 55) {
                        if (m6615a(b7, 1) != 1 || m6619b(b7)) {
                            return 0;
                        }
                        cmVar.mo18933b(8, 0);
                        m6616a(b7);
                        return 1;
                    } else if (b7.f6389a != 36 && b7.f6389a != 33) {
                        return 0;
                    } else {
                        i = 1;
                        cmVar = b7;
                    }
                    break;
                case 133:
                    if (m6615a(cmVar.mo18930b(), 1) == 1) {
                        cmVar.mo18933b(8, 0);
                    }
                    return 0;
                default:
                    m6617a(cmVar, cmVar.mo18930b());
                    return 0;
            }
        }
    }

    /* renamed from: a */
    private void m6617a(Node cmVar, Node cmVar2) {
        while (cmVar2 != null) {
            Node d = cmVar2.mo18942d();
            if (m6615a(cmVar2, 0) == 1 && !m6619b(cmVar2)) {
                cmVar.mo18947e(cmVar2);
                Node cmVar3 = new Node(149, cmVar2);
                if (d == null) {
                    cmVar.mo18935b(cmVar3);
                } else {
                    cmVar.mo18928a(cmVar3, d);
                }
            }
            cmVar2 = d;
        }
    }

    /* renamed from: a */
    private static void m6618a(Node cmVar, ObjArray cqVar) {
        int i = cmVar.f6389a;
        if (i == 129 || i == 141 || i == 132 || i == 109) {
            for (Node b = cmVar.mo18930b(); b != null; b = b.mo18942d()) {
                m6618a(b, cqVar);
            }
            return;
        }
        cqVar.mo18961a((Object) cmVar);
    }
}
