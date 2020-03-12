package org.mozilla.javascript;

import java.util.Iterator;
import org.mozilla.javascript.p110b.Comment;
import org.mozilla.javascript.p110b.Jump;
import org.mozilla.javascript.p110b.Name;
import org.mozilla.javascript.p110b.NumberLiteral;
import org.mozilla.javascript.p110b.Scope;

/* renamed from: org.mozilla.javascript.cm */
public class Node implements Iterable<Node> {
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final Node f6388g = new Node(-1);

    /* renamed from: a */
    public int f6389a;

    /* renamed from: b */
    protected Node f6390b;

    /* renamed from: c */
    protected Node f6391c;

    /* renamed from: d */
    protected Node f6392d;

    /* renamed from: e */
    public int f6393e;

    /* renamed from: f */
    protected C2162co f6394f;

    public Node(int i) {
        this.f6389a = -1;
        this.f6393e = -1;
        this.f6389a = i;
    }

    public Node(int i, Node cmVar) {
        this.f6389a = -1;
        this.f6393e = -1;
        this.f6389a = i;
        this.f6392d = cmVar;
        this.f6391c = cmVar;
        cmVar.f6390b = null;
    }

    public Node(int i, Node cmVar, Node cmVar2) {
        this.f6389a = -1;
        this.f6393e = -1;
        this.f6389a = i;
        this.f6391c = cmVar;
        this.f6392d = cmVar2;
        cmVar.f6390b = cmVar2;
        cmVar2.f6390b = null;
    }

    public Node(int i, Node cmVar, Node cmVar2, Node cmVar3) {
        this.f6389a = -1;
        this.f6393e = -1;
        this.f6389a = i;
        this.f6391c = cmVar;
        this.f6392d = cmVar3;
        cmVar.f6390b = cmVar2;
        cmVar2.f6390b = cmVar3;
        cmVar3.f6390b = null;
    }

    public Node(int i, int i2) {
        this.f6389a = -1;
        this.f6393e = -1;
        this.f6389a = i;
        this.f6393e = i2;
    }

    public Node(int i, Node cmVar, int i2) {
        this(i, cmVar);
        this.f6393e = i2;
    }

    public Node(Node cmVar, Node cmVar2, Node cmVar3, int i) {
        this(124, cmVar, cmVar2, cmVar3);
        this.f6393e = i;
    }

    /* renamed from: a */
    public static Node m6110a(double d) {
        NumberLiteral amVar = new NumberLiteral();
        amVar.f6133g = d;
        return amVar;
    }

    /* renamed from: a */
    public static Node m6112a(String str) {
        return m6111a(41, str);
    }

    /* renamed from: a */
    public static Node m6111a(int i, String str) {
        Name akVar = new Name();
        akVar.mo18739c(str);
        akVar.mo18730a(i);
        return akVar;
    }

    /* renamed from: a */
    public Node mo18730a(int i) {
        this.f6389a = i;
        return this;
    }

    /* renamed from: a */
    public final void mo18926a(Comment kVar) {
        mo18925a(24, (Object) kVar);
    }

    /* renamed from: a */
    public final boolean mo18929a() {
        return this.f6391c != null;
    }

    /* renamed from: b */
    public final Node mo18930b() {
        return this.f6391c;
    }

    /* renamed from: c */
    public final Node mo18938c() {
        return this.f6392d;
    }

    /* renamed from: d */
    public final Node mo18942d() {
        return this.f6390b;
    }

    /* renamed from: f */
    private Node mo18761f(Node cmVar) {
        if (cmVar == this.f6391c) {
            return null;
        }
        Node cmVar2 = this.f6391c;
        while (cmVar2.f6390b != cmVar) {
            cmVar2 = cmVar2.f6390b;
            if (cmVar2 == null) {
                throw new RuntimeException("node is not a child");
            }
        }
        return cmVar2;
    }

    /* renamed from: n */
    private Node mo18725n() {
        while (this.f6390b != null) {
//            this = this.f6390b;
        }
        return this;
    }

    /* renamed from: a */
    public final void mo18927a(Node cmVar) {
        cmVar.f6390b = this.f6391c;
        this.f6391c = cmVar;
        if (this.f6392d == null) {
            this.f6392d = cmVar;
        }
    }

    /* renamed from: b */
    public final void mo18935b(Node cmVar) {
        cmVar.f6390b = null;
        if (this.f6392d == null) {
            this.f6392d = cmVar;
            this.f6391c = cmVar;
            return;
        }
        this.f6392d.f6390b = cmVar;
        this.f6392d = cmVar;
    }

    /* renamed from: c */
    public final void mo18939c(Node cmVar) {
        Node n = cmVar.mo18725n();
        n.f6390b = this.f6391c;
        this.f6391c = cmVar;
        if (this.f6392d == null) {
            this.f6392d = n;
        }
    }

    /* renamed from: d */
    public final void mo18943d(Node cmVar) {
        if (this.f6392d != null) {
            this.f6392d.f6390b = cmVar;
        }
        this.f6392d = cmVar.mo18725n();
        if (this.f6391c == null) {
            this.f6391c = cmVar;
        }
    }

    /* renamed from: a */
    public final void mo18928a(Node cmVar, Node cmVar2) {
        if (cmVar.f6390b != null) {
            throw new RuntimeException("newChild had siblings in addChildBefore");
        } else if (this.f6391c == cmVar2) {
            cmVar.f6390b = this.f6391c;
            this.f6391c = cmVar;
        } else {
            mo18936b(cmVar, mo18761f(cmVar2));
        }
    }

    /* renamed from: b */
    public final void mo18936b(Node cmVar, Node cmVar2) {
        if (cmVar.f6390b != null) {
            throw new RuntimeException("newChild had siblings in addChildAfter");
        }
        cmVar.f6390b = cmVar2.f6390b;
        cmVar2.f6390b = cmVar;
        if (this.f6392d == cmVar2) {
            this.f6392d = cmVar;
        }
    }

    /* renamed from: e */
    public final void mo18947e(Node cmVar) {
        Node f = mo18761f(cmVar);
        if (f == null) {
            this.f6391c = this.f6391c.f6390b;
        } else {
            f.f6390b = cmVar.f6390b;
        }
        if (cmVar == this.f6392d) {
            this.f6392d = f;
        }
        cmVar.f6390b = null;
    }

    /* renamed from: c */
    public final void mo18940c(Node cmVar, Node cmVar2) {
        cmVar2.f6390b = cmVar.f6390b;
        if (cmVar == this.f6391c) {
            this.f6391c = cmVar2;
        } else {
            mo18761f(cmVar).f6390b = cmVar2;
        }
        if (cmVar == this.f6392d) {
            this.f6392d = cmVar2;
        }
        cmVar.f6390b = null;
    }

    /* renamed from: d */
    public final void mo18944d(Node cmVar, Node cmVar2) {
        Node cmVar3 = cmVar.f6390b;
        cmVar2.f6390b = cmVar3.f6390b;
        cmVar.f6390b = cmVar2;
        if (cmVar3 == this.f6392d) {
            this.f6392d = cmVar2;
        }
        cmVar3.f6390b = null;
    }

    /* renamed from: e */
    public final void mo18945e() {
        this.f6392d = null;
        this.f6391c = null;
    }

    public Iterator<Node> iterator() {
        return new C2161cn(this);
    }

    /* renamed from: f */
    private C2162co mo18795f(int i) {
        C2162co coVar = this.f6394f;
        while (coVar != null && i != coVar.f6401b) {
            coVar = coVar.f6400a;
        }
        return coVar;
    }

    /* renamed from: g */
    private C2162co mo18796g(int i) {
        C2162co f = mo18795f(i);
        if (f != null) {
            return f;
        }
        C2162co coVar = new C2162co((byte) 0);
        coVar.f6401b = i;
        coVar.f6400a = this.f6394f;
        this.f6394f = coVar;
        return coVar;
    }

    /* renamed from: b */
    public final void mo18932b(int i) {
        C2162co coVar = this.f6394f;
        if (coVar != null) {
            C2162co coVar2 = null;
            while (coVar.f6401b != i) {
                C2162co coVar3 = coVar.f6400a;
                if (coVar3 != null) {
                    C2162co coVar4 = coVar;
                    coVar = coVar3;
                    coVar2 = coVar4;
                } else {
                    return;
                }
            }
            if (coVar2 == null) {
                this.f6394f = coVar.f6400a;
            } else {
                coVar2.f6400a = coVar.f6400a;
            }
        }
    }

    /* renamed from: c */
    public final Object mo18937c(int i) {
        C2162co f = mo18795f(i);
        if (f == null) {
            return null;
        }
        return f.f6403d;
    }

    /* renamed from: a */
    public final int mo18924a(int i, int i2) {
        C2162co f = mo18795f(i);
        return f == null ? i2 : f.f6402c;
    }

    /* renamed from: d */
    public final int mo18941d(int i) {
        C2162co f = mo18795f(i);
        if (f == null) {
            Kit.m5810a();
        }
        return f.f6402c;
    }

    /* renamed from: a */
    public final void mo18925a(int i, Object obj) {
        if (obj == null) {
            mo18932b(i);
        } else {
            mo18796g(i).f6403d = obj;
        }
    }

    /* renamed from: b */
    public final void mo18933b(int i, int i2) {
        mo18796g(i).f6402c = i2;
    }

    /* renamed from: f */
    public int mo18794f() {
        return this.f6393e;
    }

    /* renamed from: b */
    public final void mo18931b(double d) {
        ((NumberLiteral) this).f6133g = d;
    }

    /* renamed from: b */
    public final void mo18934b(String str) {
        if (str == null) {
            Kit.m5810a();
        }
        ((Name) this).mo18739c(str);
    }

    /* renamed from: g */
    public Scope mo18740g() {
        return ((Name) this).f6131h;
    }

    /* renamed from: a */
    public void mo18738a(Scope atVar) {
        if (atVar == null) {
            Kit.m5810a();
        }
        if (!(this instanceof Name)) {
            throw Kit.m5810a();
        }
        ((Name) this).f6131h = atVar;
    }

    /* renamed from: h */
    public static Node m6116h() {
        return new Node(131);
    }

    /* renamed from: i */
    public final int mo18948i() {
        if (!(this.f6389a == 131 || this.f6389a == 72)) {
            Kit.m5810a();
        }
        return mo18924a(15, -1);
    }

    /* renamed from: e */
    public final void mo18946e(int i) {
        if (!(this.f6389a == 131 || this.f6389a == 72)) {
            Kit.m5810a();
        }
        mo18933b(15, i);
    }

    /* renamed from: j */
    public final boolean mo18950j() {
        int o = mo18726o();
        return (o & 4) == 0 || (o & 11) == 0;
    }

    /* renamed from: o */
    private int mo18726o() {
        Node cmVar = this;
        while (true) {
            switch (cmVar.f6389a) {
                case 4:
                    if (cmVar.f6391c != null) {
                        return 4;
                    }
                    return 2;
                case 50:
                case 121:
                    return 0;
                case 72:
                    return 8;
                case 120:
                    ((Jump) cmVar).mo18728w().mo18933b(18, 1);
                    return 0;
                case 129:
                case 141:
                    if (cmVar.f6391c == null) {
                        return 1;
                    }
                    switch (cmVar.f6391c.f6389a) {
                        case 7:
                            Node cmVar2 = cmVar.f6391c;
                            Node cmVar3 = cmVar2.f6390b;
                            Node cmVar4 = ((Jump) cmVar2).f6117w;
                            int o = cmVar3.mo18726o();
                            return cmVar4 != null ? cmVar4.mo18726o() | o : o | 1;
                        case 81:
                            return 0;
                        case 114:
                            return 0;
                        case 130:
                            Node cmVar5 = cmVar.f6391c;
                            return cmVar5.mo18924a(18, 0) | cmVar5.f6390b.mo18726o();
                        default:
                            Node cmVar6 = cmVar.f6391c;
                            int i = 1;
                            while ((i & 1) != 0 && cmVar6 != null) {
                                i = (i & -2) | cmVar6.mo18726o();
                                cmVar6 = cmVar6.f6390b;
                            }
                            return i;
                    }
                case 131:
                    if (cmVar.f6390b != null) {
                        cmVar = cmVar.f6390b;
                        break;
                    } else {
                        return 1;
                    }
                case 132:
                    Node cmVar7 = cmVar.f6391c;
                    while (cmVar7.f6390b != cmVar.f6392d) {
                        cmVar7 = cmVar7.f6390b;
                    }
                    if (cmVar7.f6389a != 6) {
                        return 1;
                    }
                    int o2 = ((Jump) cmVar7).f6117w.f6390b.mo18726o();
                    if (cmVar7.f6391c.f6389a == 45) {
                        o2 &= -2;
                    }
                    return cmVar.mo18924a(18, 0) | o2;
                case 133:
                    if (cmVar.f6391c != null) {
                        cmVar = cmVar.f6391c;
                        break;
                    } else {
                        return 1;
                    }
                default:
                    return 1;
            }
        }
    }

    /* renamed from: k */
    public boolean mo18724k() {
        switch (this.f6389a) {
            case -1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 30:
            case 31:
            case 35:
            case 37:
            case 38:
            case 50:
            case 51:
            case 56:
            case 57:
            case 64:
            case 68:
            case 69:
            case 70:
            case 72:
            case 81:
            case 82:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 106:
            case 107:
            case 112:
            case 113:
            case 114:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 129:
            case 130:
            case 131:
            case 132:
            case 134:
            case 135:
            case 139:
            case 140:
            case 141:
            case 142:
            case 153:
            case 154:
            case 158:
            case 159:
                return true;
            case 89:
            case 133:
                if (this.f6392d != null) {
                    return this.f6392d.mo18724k();
                }
                return true;
            case 102:
                if (this.f6391c == null || this.f6391c.f6390b == null || this.f6391c.f6390b.f6390b == null) {
                    Kit.m5810a();
                }
                if (!this.f6391c.f6390b.mo18724k() || !this.f6391c.f6390b.f6390b.mo18724k()) {
                    return false;
                }
                return true;
            case 104:
            case 105:
                if (this.f6391c == null || this.f6392d == null) {
                    Kit.m5810a();
                }
                return this.f6391c.mo18724k() || this.f6392d.mo18724k();
            default:
                return false;
        }
    }

    /* renamed from: l */
    public final void mo18951l() {
        if (this.f6389a == 125) {
            mo18742p();
        } else {
            Kit.m5810a();
        }
    }

    /* renamed from: p */
    private void mo18742p() {
        if (this.f6389a == 131 || this.f6389a == 72) {
            mo18946e(-1);
        }
        for (Node cmVar = this.f6391c; cmVar != null; cmVar = cmVar.f6390b) {
            cmVar.mo18742p();
        }
    }

    public String toString() {
        return String.valueOf(this.f6389a);
    }
}
