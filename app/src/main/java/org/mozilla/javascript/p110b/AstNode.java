package org.mozilla.javascript.p110b;

import java.util.HashMap;
import java.util.Map;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;
import org.slf4j.Marker;

/* renamed from: org.mozilla.javascript.b.e */
public abstract class AstNode extends Node implements Comparable<AstNode> {

    /* renamed from: g */
    private static Map<Integer, String> f6209g;

    /* renamed from: m */
    protected int f6210m;

    /* renamed from: n */
    protected int f6211n;

    /* renamed from: o */
    protected AstNode f6212o;

    public /* synthetic */ int compareTo(AstNode obj) {
        AstNode eVar = (AstNode) obj;
        if (equals(eVar)) {
            return 0;
        }
        int r = mo18799r();
        int r2 = eVar.mo18799r();
        if (r < r2) {
            return -1;
        }
        if (r2 < r) {
            return 1;
        }
        int i = this.f6211n;
        int i2 = eVar.f6211n;
        if (i < i2) {
            return -1;
        }
        if (i2 < i) {
            return 1;
        }
        return hashCode() - eVar.hashCode();
    }

    static {
        HashMap hashMap = new HashMap();
        f6209g = hashMap;
        hashMap.put(Integer.valueOf(52), "in");
        f6209g.put(Integer.valueOf(32), "typeof");
        f6209g.put(Integer.valueOf(53), "instanceof");
        f6209g.put(Integer.valueOf(31), "delete");
        f6209g.put(Integer.valueOf(89), ",");
        f6209g.put(Integer.valueOf(103), ":");
        f6209g.put(Integer.valueOf(104), "||");
        f6209g.put(Integer.valueOf(105), "&&");
        f6209g.put(Integer.valueOf(106), "++");
        f6209g.put(Integer.valueOf(107), "--");
        f6209g.put(Integer.valueOf(9), "|");
        f6209g.put(Integer.valueOf(10), "^");
        f6209g.put(Integer.valueOf(11), "&");
        f6209g.put(Integer.valueOf(12), "==");
        f6209g.put(Integer.valueOf(13), "!=");
        f6209g.put(Integer.valueOf(14), "<");
        f6209g.put(Integer.valueOf(16), ">");
        f6209g.put(Integer.valueOf(15), "<=");
        f6209g.put(Integer.valueOf(17), ">=");
        f6209g.put(Integer.valueOf(18), "<<");
        f6209g.put(Integer.valueOf(19), ">>");
        f6209g.put(Integer.valueOf(20), ">>>");
        f6209g.put(Integer.valueOf(21), Marker.ANY_NON_NULL_MARKER);
        f6209g.put(Integer.valueOf(22), "-");
        f6209g.put(Integer.valueOf(23), Marker.ANY_MARKER);
        f6209g.put(Integer.valueOf(24), "/");
        f6209g.put(Integer.valueOf(25), "%");
        f6209g.put(Integer.valueOf(26), "!");
        f6209g.put(Integer.valueOf(27), "~");
        f6209g.put(Integer.valueOf(28), Marker.ANY_NON_NULL_MARKER);
        f6209g.put(Integer.valueOf(29), "-");
        f6209g.put(Integer.valueOf(46), "===");
        f6209g.put(Integer.valueOf(47), "!==");
        f6209g.put(Integer.valueOf(90), "=");
        f6209g.put(Integer.valueOf(91), "|=");
        f6209g.put(Integer.valueOf(93), "&=");
        f6209g.put(Integer.valueOf(94), "<<=");
        f6209g.put(Integer.valueOf(95), ">>=");
        f6209g.put(Integer.valueOf(96), ">>>=");
        f6209g.put(Integer.valueOf(97), "+=");
        f6209g.put(Integer.valueOf(98), "-=");
        f6209g.put(Integer.valueOf(99), "*=");
        f6209g.put(Integer.valueOf(100), "/=");
        f6209g.put(Integer.valueOf(101), "%=");
        f6209g.put(Integer.valueOf(92), "^=");
        f6209g.put(Integer.valueOf(126), "void");
    }

    public AstNode() {
        super(-1);
        this.f6210m = -1;
        this.f6211n = 1;
    }

    public AstNode(int i) {
        this();
        this.f6210m = i;
    }

    public AstNode(int i, int i2) {
        this();
        this.f6210m = i;
        this.f6211n = i2;
    }

    /* renamed from: q */
    public final int mo18798q() {
        return this.f6210m;
    }

    /* renamed from: f */
    public final void mo18795f(int i) {
        this.f6210m = i;
    }

    /* renamed from: r */
    public final int mo18799r() {
        int i = this.f6210m;
        for (AstNode eVar = this.f6212o; eVar != null; eVar = eVar.f6212o) {
            i += eVar.f6210m;
        }
        return i;
    }

    /* renamed from: s */
    public final int mo18800s() {
        return this.f6211n;
    }

    /* renamed from: g */
    public final void mo18796g(int i) {
        this.f6211n = i;
    }

    /* renamed from: c */
    public final void mo18791c(int i, int i2) {
        this.f6210m = i;
        this.f6211n = i2 - i;
    }

    /* renamed from: h */
    public final void mo18797h(int i) {
        this.f6210m -= i;
    }

    /* renamed from: t */
    public final AstNode mo18801t() {
        return this.f6212o;
    }

    /* renamed from: b */
    public final void mo18790b(AstNode eVar) {
        if (eVar != this.f6212o) {
            if (this.f6212o != null) {
                mo18797h(-this.f6212o.f6210m);
            }
            this.f6212o = eVar;
            if (eVar != null) {
                mo18797h(eVar.f6210m);
            }
        }
    }

    /* renamed from: c */
    public final void mo18792c(AstNode eVar) {
        m5915a(eVar);
        this.f6211n = (eVar.f6210m + eVar.f6211n) - this.f6210m;
        mo18935b((Node) eVar);
        eVar.mo18790b(this);
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
            case 109:
            case 110:
            case 111:
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
            default:
                return false;
        }
    }

    /* renamed from: a */
    protected static void m5915a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("arg cannot be null");
        }
    }

    /* renamed from: u */
    public static RuntimeException m5916u() {
        throw Kit.m5810a();
    }

    /* renamed from: f */
    public final int mo18794f() {
        while (this.f6393e == -1) {
            if (this.f6212o == null) {
                return -1;
            }
//            this = this.f6212o;
        }
        return this.f6393e;
    }
}
