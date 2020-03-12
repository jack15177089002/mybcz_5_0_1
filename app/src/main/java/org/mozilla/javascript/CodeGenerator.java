package org.mozilla.javascript;

import org.mozilla.javascript.p110b.FunctionNode;
import org.mozilla.javascript.p110b.Jump;
import org.mozilla.javascript.p110b.Name;
import org.mozilla.javascript.p110b.NumberLiteral;
import org.mozilla.javascript.p110b.ScriptNode;

/* renamed from: org.mozilla.javascript.h */
final class CodeGenerator extends Icode {

    /* renamed from: a */
    CompilerEnvirons f6721a;

    /* renamed from: b */
    InterpreterData f6722b;

    /* renamed from: c */
    ScriptNode f6723c;

    /* renamed from: d */
    private boolean f6724d;

    /* renamed from: e */
    private boolean f6725e;

    /* renamed from: f */
    private int f6726f;

    /* renamed from: g */
    private int f6727g;

    /* renamed from: h */
    private int f6728h;

    /* renamed from: i */
    private int f6729i;

    /* renamed from: j */
    private ObjToIntMap f6730j = new ObjToIntMap(20);

    /* renamed from: k */
    private int f6731k;

    /* renamed from: l */
    private int[] f6732l;

    /* renamed from: m */
    private int f6733m;

    /* renamed from: n */
    private long[] f6734n;

    /* renamed from: o */
    private int f6735o;

    /* renamed from: p */
    private ObjArray f6736p = new ObjArray();

    /* renamed from: q */
    private int f6737q;

    CodeGenerator() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo19126a() {
        this.f6724d = true;
        FunctionNode xVar = (FunctionNode) this.f6723c;
        this.f6722b.f6055d = xVar.f6260q;
        this.f6722b.f6054c = xVar.f6261r;
        if (xVar.f6254h != null) {
            this.f6722b.f6052a = xVar.mo18725n();
        }
        if (xVar.f6262s) {
            m6718d(-62);
            m6722f(xVar.f6393e & 65535);
        }
        mo19127a(xVar.mo18938c());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo19127a(Node cmVar) {
        int o = this.f6723c.mo18726o();
        if (o != 0) {
            InterpreterData[] arVarArr = new InterpreterData[o];
            for (int i = 0; i != o; i++) {
                FunctionNode k = this.f6723c.mo18764k(i);
                CodeGenerator hVar = new CodeGenerator();
                hVar.f6721a = this.f6721a;
                hVar.f6723c = k;
                hVar.f6722b = new InterpreterData(this.f6722b);
                hVar.mo19126a();
                arVarArr[i] = hVar.f6722b;
            }
            this.f6722b.f6058g = arVarArr;
        }
        int p = this.f6723c.mo18742p();
        if (p != 0) {
            Context k2 = Context.m6769k();
            RegExpProxy g = ScriptRuntime.m6454g(k2);
            Object[] objArr = new Object[p];
            for (int i2 = 0; i2 != p; i2++) {
                objArr[i2] = g.compileRegExp(k2, this.f6723c.mo18765l(i2), this.f6723c.mo18766m(i2));
            }
            this.f6722b.f6059h = objArr;
        }
        m6707a(cmVar, 0);
        for (int i3 = 0; i3 < this.f6735o; i3++) {
            long j = this.f6734n[i3];
            int i4 = (int) (j >> 32);
            int i5 = (int) j;
            int i6 = this.f6732l[i4];
            if (i6 == -1) {
                throw Kit.m5810a();
            }
            m6710b(i5, i6);
        }
        this.f6735o = 0;
        if (this.f6722b.f6055d == 0) {
            m6714c(64);
        }
        if (this.f6722b.f6060i.length != this.f6726f) {
            byte[] bArr = new byte[this.f6726f];
            System.arraycopy(this.f6722b.f6060i, 0, bArr, 0, this.f6726f);
            this.f6722b.f6060i = bArr;
        }
        if (this.f6730j.f6418d == 0) {
            this.f6722b.f6056e = null;
        } else {
            this.f6722b.f6056e = new String[this.f6730j.f6418d];
            C2163cs a = this.f6730j.mo18965a();
            a.mo18970a();
            while (!a.mo18971b()) {
                String str = (String) a.mo18973d();
                int e = a.mo18974e();
                if (this.f6722b.f6056e[e] != null) {
                    Kit.m5810a();
                }
                this.f6722b.f6056e[e] = str;
                a.mo18972c();
            }
        }
        if (this.f6729i == 0) {
            this.f6722b.f6057f = null;
        } else if (this.f6722b.f6057f.length != this.f6729i) {
            double[] dArr = new double[this.f6729i];
            System.arraycopy(this.f6722b.f6057f, 0, dArr, 0, this.f6729i);
            this.f6722b.f6057f = dArr;
        }
        if (!(this.f6737q == 0 || this.f6722b.f6061j.length == this.f6737q)) {
            int[] iArr = new int[this.f6737q];
            System.arraycopy(this.f6722b.f6061j, 0, iArr, 0, this.f6737q);
            this.f6722b.f6061j = iArr;
        }
        this.f6722b.f6062k = this.f6723c.mo18768v();
        this.f6722b.f6065n = this.f6722b.f6062k + this.f6722b.f6063l + this.f6722b.f6064m;
        InterpreterData arVar = this.f6722b;
        ScriptNode auVar = this.f6723c;
        if (auVar.f6154K == null) {
            ScriptNode.m5916u();
        }
        arVar.f6066o = auVar.f6154K;
        this.f6722b.f6067p = this.f6723c.mo18755B();
        this.f6722b.f6068q = this.f6723c.f6153J;
        this.f6722b.f6071t = this.f6723c.f6146C;
        this.f6722b.f6072u = this.f6723c.f6147D;
        if (this.f6736p.f6407a != 0) {
            InterpreterData arVar2 = this.f6722b;
            ObjArray cqVar = this.f6736p;
            Object[] objArr2 = new Object[cqVar.f6407a];
            cqVar.mo18962a(objArr2);
            arVar2.f6076y = objArr2;
        }
    }

    /* renamed from: b */
    private void m6711b(Node cmVar) {
        int f = cmVar.mo18794f();
        if (f != this.f6728h && f >= 0) {
            if (this.f6722b.f6049A < 0) {
                this.f6722b.f6049A = f;
            }
            this.f6728h = f;
            m6718d(-26);
            m6722f(f & 65535);
        }
    }

    /* renamed from: c */
    private static RuntimeException m6713c(Node cmVar) {
        throw new RuntimeException(cmVar.toString());
    }

    /* renamed from: a */
    private void m6707a(Node cmVar, int i) {
        int i2 = -5;
        int i3 = 0;
        int i4 = cmVar.f6389a;
        Node b = cmVar.mo18930b();
        switch (i4) {
            case -62:
                break;
            case 2:
                m6712b(b, 0);
                m6714c(2);
                m6727k(-1);
                break;
            case 3:
                m6714c(3);
                break;
            case 4:
                m6711b(cmVar);
                if (cmVar.mo18924a(20, 0) == 0) {
                    if (b == null) {
                        m6718d(-22);
                        break;
                    } else {
                        m6712b(b, 1);
                        m6714c(4);
                        m6727k(-1);
                        break;
                    }
                } else {
                    m6718d(-63);
                    m6722f(this.f6728h & 65535);
                    break;
                }
            case 5:
                m6716c(((Jump) cmVar).f6117w, i4);
                break;
            case 6:
            case 7:
                Node cmVar2 = ((Jump) cmVar).f6117w;
                m6712b(b, 0);
                m6716c(cmVar2, i4);
                m6727k(-1);
                break;
            case 50:
                m6711b(cmVar);
                m6712b(b, 0);
                m6714c(50);
                m6722f(this.f6728h & 65535);
                m6727k(-1);
                break;
            case 51:
                m6711b(cmVar);
                m6719d(51, m6717d(cmVar));
                break;
            case 57:
                int d = m6717d(cmVar);
                int d2 = cmVar.mo18941d(14);
                String str = ((Name) b).f6130g;
                m6712b(b.mo18942d(), 0);
                m6706a(str);
                m6725i(d);
                m6714c(57);
                if (d2 != 0) {
                    i3 = 1;
                }
                m6721e(i3);
                m6727k(-1);
                break;
            case 58:
            case 59:
            case 60:
                m6712b(b, 0);
                m6719d(i4, m6717d(cmVar));
                m6727k(-1);
                break;
            case 64:
                m6711b(cmVar);
                m6714c(64);
                break;
            case 81:
                Jump aeVar = (Jump) cmVar;
                int d3 = m6717d((Node) aeVar);
                int b2 = m6708b();
                m6719d(-13, b2);
                int i5 = this.f6726f;
                boolean z = this.f6725e;
                this.f6725e = true;
                while (b != null) {
                    m6707a(b, i);
                    b = b.mo18942d();
                }
                this.f6725e = z;
                Node cmVar3 = aeVar.f6117w;
                if (cmVar3 != null) {
                    int i6 = this.f6732l[m6720e(cmVar3)];
                    m6704a(i5, i6, i6, false, d3, b2);
                }
                Node x = aeVar.mo18729x();
                if (x != null) {
                    int i7 = this.f6732l[m6720e(x)];
                    m6704a(i5, i7, i7, true, d3, b2);
                }
                m6719d(-56, b2);
                m6728l(b2);
                break;
            case 109:
                int d4 = cmVar.mo18941d(1);
                int i8 = this.f6723c.mo18764k(d4).f6260q;
                if (i8 == 3) {
                    m6719d(-20, d4);
                } else if (i8 != 1) {
                    throw Kit.m5810a();
                }
                if (!this.f6724d) {
                    m6719d(-19, d4);
                    m6727k(1);
                    m6718d(-5);
                    m6727k(-1);
                    break;
                }
                break;
            case 114:
                m6711b(cmVar);
                m6712b(b, 0);
                for (Jump aeVar2 = (Jump) b.mo18942d(); aeVar2 != null; aeVar2 = (Jump) aeVar2.mo18942d()) {
                    if (aeVar2.f6389a != 115) {
                        throw m6713c((Node) aeVar2);
                    }
                    Node b3 = aeVar2.mo18930b();
                    m6718d(-1);
                    m6727k(1);
                    m6712b(b3, 0);
                    m6714c(46);
                    m6727k(-1);
                    m6716c(aeVar2.f6117w, -6);
                    m6727k(-1);
                }
                m6718d(-4);
                m6727k(-1);
                break;
            case 123:
            case 128:
            case 129:
            case 130:
            case 132:
                m6711b(cmVar);
                break;
            case 125:
                m6727k(1);
                int d5 = m6717d(cmVar);
                m6719d(-24, d5);
                m6727k(-1);
                while (b != null) {
                    m6707a(b, i);
                    b = b.mo18942d();
                }
                m6719d(-25, d5);
                break;
            case 131:
                int e = m6720e(cmVar);
                if (this.f6732l[e] != -1) {
                    Kit.m5810a();
                }
                this.f6732l[e] = this.f6726f;
                break;
            case 133:
            case 134:
                m6711b(cmVar);
                m6712b(b, 0);
                if (i4 == 133) {
                    i2 = -4;
                }
                m6718d(i2);
                m6727k(-1);
                break;
            case 135:
                m6716c(((Jump) cmVar).f6117w, -23);
                break;
            case 136:
                break;
            case 141:
                int b4 = m6708b();
                cmVar.mo18933b(2, b4);
                m6711b(cmVar);
                while (b != null) {
                    m6707a(b, i);
                    b = b.mo18942d();
                }
                m6719d(-56, b4);
                m6728l(b4);
                break;
            case 160:
                m6718d(-64);
                break;
            default:
                throw m6713c(cmVar);
        }
        while (b != null) {
            m6707a(b, i);
            b = b.mo18942d();
        }
        if (this.f6727g != i) {
            throw Kit.m5810a();
        }
    }

    /* renamed from: b */
    private void m6712b(Node cmVar, int i) {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        int i5 = 0;
        int i6 = cmVar.f6389a;
        Node b = cmVar.mo18930b();
        int i7 = this.f6727g;
        switch (i6) {
            case 8:
            case 73:
                String str = ((Name) b).f6130g;
                m6712b(b, 0);
                m6712b(b.mo18942d(), 0);
                m6705a(i6, str);
                m6727k(-1);
                break;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 36:
            case 46:
            case 47:
            case 52:
            case 53:
                m6712b(b, 0);
                m6712b(b.mo18942d(), 0);
                m6714c(i6);
                m6727k(-1);
                break;
            case 26:
            case 27:
            case 28:
            case 29:
            case 32:
            case 126:
                m6712b(b, 0);
                if (i6 != 126) {
                    m6714c(i6);
                    break;
                } else {
                    m6718d(-4);
                    m6718d(-50);
                    break;
                }
            case 30:
            case 38:
            case 70:
                if (i6 != 30) {
                    int i8 = b.f6389a;
                    switch (i8) {
                        case 33:
                        case 36:
                            Node b2 = b.mo18930b();
                            m6712b(b2, 0);
                            Node d = b2.mo18942d();
                            if (i8 != 33) {
                                m6712b(d, 0);
                                m6718d(-17);
                                break;
                            } else {
                                m6705a(-16, ((Name) d).f6130g);
                                m6727k(1);
                                break;
                            }
                        case 39:
                            m6705a(-15, ((Name) b).f6130g);
                            m6727k(2);
                            break;
                        default:
                            m6712b(b, 0);
                            m6718d(-18);
                            m6727k(1);
                            break;
                    }
                } else {
                    m6712b(b, 0);
                }
                int i9 = 0;
                while (true) {
                    b = b.mo18942d();
                    if (b == null) {
                        int a = cmVar.mo18924a(10, 0);
                        if (a != 0) {
                            m6719d(-21, i9);
                            m6721e(a);
                            if (i6 == 30) {
                                i5 = 1;
                            }
                            m6721e(i5);
                            m6722f(this.f6728h & 65535);
                        } else {
                            if (i6 != 38 || (i & 1) == 0 || this.f6721a.f6740c || this.f6725e) {
                                i4 = i6;
                            } else {
                                i4 = -55;
                            }
                            m6719d(i4, i9);
                            i6 = i4;
                        }
                        if (i6 == 30) {
                            m6727k(-i9);
                        } else {
                            m6727k(-1 - i9);
                        }
                        if (i9 > this.f6722b.f6069r) {
                            this.f6722b.f6069r = i9;
                            break;
                        }
                    } else {
                        m6712b(b, 0);
                        i9++;
                    }
                }
                break;
            case 31:
                if (b.f6389a != 49) {
                    z = false;
                }
                m6712b(b, 0);
                m6712b(b.mo18942d(), 0);
                if (z) {
                    m6718d(0);
                } else {
                    m6714c(31);
                }
                m6727k(-1);
                break;
            case 33:
            case 34:
                m6712b(b, 0);
                m6705a(i6, ((Name) b.mo18942d()).f6130g);
                break;
            case 35:
            case 139:
                m6712b(b, 0);
                Node d2 = b.mo18942d();
                String str2 = ((Name) d2).f6130g;
                Node d3 = d2.mo18942d();
                if (i6 == 139) {
                    m6718d(-1);
                    m6727k(1);
                    m6705a(33, str2);
                    m6727k(-1);
                }
                m6712b(d3, 0);
                m6705a(35, str2);
                m6727k(-1);
                break;
            case 37:
            case 140:
                m6712b(b, 0);
                Node d4 = b.mo18942d();
                m6712b(d4, 0);
                Node d5 = d4.mo18942d();
                if (i6 == 140) {
                    m6718d(-2);
                    m6727k(2);
                    m6714c(36);
                    m6727k(-1);
                    m6727k(-1);
                }
                m6712b(d5, 0);
                m6714c(37);
                m6727k(-2);
                break;
            case 39:
            case 41:
            case 49:
                m6705a(i6, ((Name) cmVar).f6130g);
                m6727k(1);
                break;
            case 40:
                double d6 = ((NumberLiteral) cmVar).f6133g;
                int i10 = (int) d6;
                if (((double) i10) != d6) {
                    int i11 = this.f6729i;
                    if (i11 == 0) {
                        this.f6722b.f6057f = new double[64];
                    } else if (this.f6722b.f6057f.length == i11) {
                        double[] dArr = new double[(i11 * 2)];
                        System.arraycopy(this.f6722b.f6057f, 0, dArr, 0, i11);
                        this.f6722b.f6057f = dArr;
                    }
                    this.f6722b.f6057f[i11] = d6;
                    this.f6729i = i11 + 1;
                    m6719d(40, i11);
                } else if (i10 == 0) {
                    m6718d(-51);
                    if (1.0d / d6 < 0.0d) {
                        m6714c(29);
                    }
                } else if (i10 == 1) {
                    m6718d(-52);
                } else if (((short) i10) == i10) {
                    m6718d(-27);
                    m6722f(65535 & i10);
                } else {
                    m6718d(-28);
                    m6723g(i10);
                }
                m6727k(1);
                break;
            case 42:
            case 43:
            case 44:
            case 45:
            case 63:
                m6714c(i6);
                m6727k(1);
                break;
            case 48:
                m6719d(48, cmVar.mo18941d(4));
                m6727k(1);
                break;
            case 54:
                m6719d(54, m6717d(cmVar));
                m6727k(1);
                break;
            case 55:
                if (this.f6722b.f6054c) {
                    Kit.m5810a();
                }
                m6715c(55, this.f6723c.mo18761f(cmVar));
                m6727k(1);
                break;
            case 56:
                if (this.f6722b.f6054c) {
                    Kit.m5810a();
                }
                int f = this.f6723c.mo18761f(b);
                m6712b(b.mo18942d(), 0);
                m6715c(56, f);
                break;
            case 61:
            case 62:
                m6719d(i6, m6717d(cmVar));
                m6727k(1);
                break;
            case 65:
            case 66:
                int i12 = cmVar.f6389a;
                Object[] objArr = null;
                if (i12 == 65) {
                    i2 = 0;
                    for (Node cmVar2 = b; cmVar2 != null; cmVar2 = cmVar2.mo18942d()) {
                        i2++;
                    }
                } else if (i12 == 66) {
                    objArr = (Object[]) cmVar.mo18937c(12);
                    i2 = objArr.length;
                } else {
                    throw m6713c(cmVar);
                }
                m6719d(-29, i2);
                m6727k(2);
                while (b != null) {
                    int i13 = b.f6389a;
                    if (i13 == 151) {
                        m6712b(b.mo18930b(), 0);
                        m6718d(-57);
                    } else if (i13 == 152) {
                        m6712b(b.mo18930b(), 0);
                        m6718d(-58);
                    } else {
                        m6712b(b, 0);
                        m6718d(-30);
                    }
                    m6727k(-1);
                    b = b.mo18942d();
                }
                if (i12 == 65) {
                    int[] iArr = (int[]) cmVar.mo18937c(11);
                    if (iArr == null) {
                        m6714c(65);
                    } else {
                        int i14 = this.f6736p.f6407a;
                        this.f6736p.mo18961a((Object) iArr);
                        m6719d(-31, i14);
                    }
                } else {
                    int i15 = this.f6736p.f6407a;
                    this.f6736p.mo18961a((Object) objArr);
                    m6719d(66, i15);
                }
                m6727k(-1);
                break;
            case 67:
            case 69:
                m6712b(b, 0);
                m6714c(i6);
                break;
            case 68:
            case 142:
                m6712b(b, 0);
                Node d7 = b.mo18942d();
                if (i6 == 142) {
                    m6718d(-1);
                    m6727k(1);
                    m6714c(67);
                    m6727k(-1);
                }
                m6712b(d7, 0);
                m6714c(68);
                m6727k(-1);
                break;
            case 71:
                m6712b(b, 0);
                m6705a(i6, (String) cmVar.mo18937c(17));
                break;
            case 72:
                if (b != null) {
                    m6712b(b, 0);
                } else {
                    m6718d(-50);
                    m6727k(1);
                }
                m6714c(72);
                m6722f(cmVar.mo18794f() & 65535);
                break;
            case 74:
            case 75:
            case 76:
                m6712b(b, 0);
                m6714c(i6);
                break;
            case 77:
            case 78:
            case 79:
            case 80:
                int a2 = cmVar.mo18924a(16, 0);
                int i16 = 0;
                do {
                    m6712b(b, 0);
                    i16++;
                    b = b.mo18942d();
                } while (b != null);
                m6719d(i6, a2);
                m6727k(1 - i16);
                break;
            case 89:
                Node c = cmVar.mo18938c();
                while (b != c) {
                    m6712b(b, 0);
                    m6718d(-4);
                    m6727k(-1);
                    b = b.mo18942d();
                }
                m6712b(b, i & 1);
                break;
            case 102:
                Node d8 = b.mo18942d();
                Node d9 = d8.mo18942d();
                m6712b(b, 0);
                int i17 = this.f6726f;
                m6724h(7);
                m6727k(-1);
                m6712b(d8, i & 1);
                int i18 = this.f6726f;
                m6724h(5);
                m6709b(i17);
                this.f6727g = i7;
                m6712b(d9, i & 1);
                m6709b(i18);
                break;
            case 104:
            case 105:
                m6712b(b, 0);
                m6718d(-1);
                m6727k(1);
                int i19 = this.f6726f;
                m6724h(i6 == 105 ? 7 : 6);
                m6727k(-1);
                m6718d(-4);
                m6727k(-1);
                m6712b(b.mo18942d(), i & 1);
                m6709b(i19);
                break;
            case 106:
            case 107:
                int d10 = cmVar.mo18941d(13);
                switch (b.f6389a) {
                    case 33:
                        Node b3 = b.mo18930b();
                        m6712b(b3, 0);
                        m6705a(-9, ((Name) b3.mo18942d()).f6130g);
                        m6721e(d10);
                        break;
                    case 36:
                        Node b4 = b.mo18930b();
                        m6712b(b4, 0);
                        m6712b(b4.mo18942d(), 0);
                        m6718d(-10);
                        m6721e(d10);
                        m6727k(-1);
                        break;
                    case 39:
                        m6705a(-8, ((Name) b).f6130g);
                        m6721e(d10);
                        m6727k(1);
                        break;
                    case 55:
                        if (this.f6722b.f6054c) {
                            Kit.m5810a();
                        }
                        m6715c(-7, this.f6723c.mo18761f(b));
                        m6721e(d10);
                        m6727k(1);
                        break;
                    case 67:
                        m6712b(b.mo18930b(), 0);
                        m6718d(-11);
                        m6721e(d10);
                        break;
                    default:
                        throw m6713c(cmVar);
                }
            case 109:
                int d11 = cmVar.mo18941d(1);
                if (this.f6723c.mo18764k(d11).f6260q == 2) {
                    m6719d(-19, d11);
                    m6727k(1);
                    break;
                } else {
                    throw Kit.m5810a();
                }
            case 137:
                if (!this.f6724d || this.f6722b.f6054c) {
                    i3 = -1;
                } else {
                    i3 = this.f6723c.mo18761f(cmVar);
                }
                if (i3 != -1) {
                    m6715c(55, i3);
                    m6727k(1);
                    m6714c(32);
                    break;
                } else {
                    m6705a(-14, ((Name) cmVar).f6130g);
                    m6727k(1);
                    break;
                }
                break;
            case 138:
                m6727k(1);
                break;
            case 146:
                m6711b(cmVar);
                m6712b(b, 0);
                m6718d(-53);
                m6727k(-1);
                int i20 = this.f6726f;
                m6712b(b.mo18942d(), 0);
                m6703a(-54, i20);
                break;
            case 155:
                String str3 = ((Name) b).f6130g;
                m6712b(b, 0);
                m6712b(b.mo18942d(), 0);
                m6705a(-59, str3);
                m6727k(-1);
                break;
            case 156:
                if (this.f6722b.f6054c) {
                    Kit.m5810a();
                }
                int f2 = this.f6723c.mo18761f(b);
                m6712b(b.mo18942d(), 0);
                m6715c(156, f2);
                break;
            case 157:
                Node d12 = b.mo18942d();
                m6707a(b, this.f6727g);
                m6712b(d12, 0);
                break;
            case 159:
                Node b5 = cmVar.mo18930b();
                Node d13 = b5.mo18942d();
                m6712b(b5.mo18930b(), 0);
                m6714c(2);
                m6727k(-1);
                m6712b(d13.mo18930b(), 0);
                m6714c(3);
                break;
            default:
                throw m6713c(cmVar);
        }
        if (i7 + 1 != this.f6727g) {
            Kit.m5810a();
        }
    }

    /* renamed from: d */
    private static int m6717d(Node cmVar) {
        return ((Node) cmVar.mo18937c(3)).mo18941d(2);
    }

    /* renamed from: e */
    private int m6720e(Node cmVar) {
        int i = cmVar.mo18948i();
        if (i == -1) {
            i = this.f6733m;
            if (this.f6732l == null || i == this.f6732l.length) {
                if (this.f6732l == null) {
                    this.f6732l = new int[32];
                } else {
                    int[] iArr = new int[(this.f6732l.length * 2)];
                    System.arraycopy(this.f6732l, 0, iArr, 0, i);
                    this.f6732l = iArr;
                }
            }
            this.f6733m = i + 1;
            this.f6732l[i] = -1;
            cmVar.mo18946e(i);
        }
        return i;
    }

    /* renamed from: c */
    private void m6716c(Node cmVar, int i) {
        int e = m6720e(cmVar);
        if (e >= this.f6733m) {
            Kit.m5810a();
        }
        int i2 = this.f6732l[e];
        if (i2 != -1) {
            m6703a(i, i2);
            return;
        }
        int i3 = this.f6726f;
        m6724h(i);
        int i4 = this.f6735o;
        if (this.f6734n == null || i4 == this.f6734n.length) {
            if (this.f6734n == null) {
                this.f6734n = new long[40];
            } else {
                long[] jArr = new long[(this.f6734n.length * 2)];
                System.arraycopy(this.f6734n, 0, jArr, 0, i4);
                this.f6734n = jArr;
            }
        }
        this.f6735o = i4 + 1;
        this.f6734n[i4] = ((long) i3) | (((long) e) << 32);
    }

    /* renamed from: a */
    private void m6703a(int i, int i2) {
        int i3 = this.f6726f;
        if (i3 <= i2) {
            throw Kit.m5810a();
        }
        m6724h(i);
        m6710b(i3, i2);
    }

    /* renamed from: b */
    private void m6709b(int i) {
        if (this.f6726f < i + 3) {
            throw Kit.m5810a();
        }
        m6710b(i, this.f6726f);
    }

    /* renamed from: b */
    private void m6710b(int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 0 || i3 > 2) {
            int i4 = i + 1;
            if (i3 != ((short) i3)) {
                if (this.f6722b.f6077z == null) {
                    this.f6722b.f6077z = new UintMap();
                }
                this.f6722b.f6077z.mo19093b(i4, i2);
                i3 = 0;
            }
            byte[] bArr = this.f6722b.f6060i;
            bArr[i4] = (byte) (i3 >> 8);
            bArr[i4 + 1] = (byte) i3;
            return;
        }
        throw Kit.m5810a();
    }

    /* renamed from: c */
    private void m6714c(int i) {
        if (!(2 <= i && i <= 80)) {
            throw Kit.m5810a();
        }
        m6721e(i);
    }

    /* renamed from: d */
    private void m6718d(int i) {
        if (!Icode.m5697a(i)) {
            throw Kit.m5810a();
        }
        m6721e(i & 255);
    }

    /* renamed from: e */
    private void m6721e(int i) {
        if ((i & -256) != 0) {
            throw Kit.m5810a();
        }
        byte[] bArr = this.f6722b.f6060i;
        int i2 = this.f6726f;
        if (i2 == bArr.length) {
            bArr = m6726j(1);
        }
        bArr[i2] = (byte) i;
        this.f6726f = i2 + 1;
    }

    /* renamed from: f */
    private void m6722f(int i) {
        if ((-65536 & i) != 0) {
            throw Kit.m5810a();
        }
        byte[] bArr = this.f6722b.f6060i;
        int i2 = this.f6726f;
        if (i2 + 2 > bArr.length) {
            bArr = m6726j(2);
        }
        bArr[i2] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
        this.f6726f = i2 + 2;
    }

    /* renamed from: g */
    private void m6723g(int i) {
        byte[] bArr = this.f6722b.f6060i;
        int i2 = this.f6726f;
        if (i2 + 4 > bArr.length) {
            bArr = m6726j(4);
        }
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
        this.f6726f = i2 + 4;
    }

    /* renamed from: h */
    private void m6724h(int i) {
        byte[] bArr = this.f6722b.f6060i;
        int i2 = this.f6726f;
        if (i2 + 3 > bArr.length) {
            bArr = m6726j(3);
        }
        bArr[i2] = (byte) i;
        this.f6726f = i2 + 1 + 2;
    }

    /* renamed from: c */
    private void m6715c(int i, int i2) {
        switch (i) {
            case -7:
                break;
            case 55:
            case 56:
                if (i2 < 128) {
                    m6718d(i == 55 ? -48 : -49);
                    m6721e(i2);
                    return;
                }
                break;
            case 156:
                if (i2 < 128) {
                    m6718d(-61);
                    m6721e(i2);
                    return;
                }
                m6719d(-60, i2);
                return;
            default:
                throw Kit.m5810a();
        }
        m6719d(i, i2);
    }

    /* renamed from: a */
    private void m6705a(int i, String str) {
        m6706a(str);
        if (Icode.m5697a(i)) {
            m6718d(i);
        } else {
            m6714c(i);
        }
    }

    /* renamed from: d */
    private void m6719d(int i, int i2) {
        m6725i(i2);
        if (Icode.m5697a(i)) {
            m6718d(i);
        } else {
            m6714c(i);
        }
    }

    /* renamed from: a */
    private void m6706a(String str) {
        int a = this.f6730j.mo18964a(str, -1);
        if (a == -1) {
            a = this.f6730j.f6418d;
            this.f6730j.mo18968b(str, a);
        }
        if (a < 4) {
            m6718d(-41 - a);
        } else if (a <= 255) {
            m6718d(-45);
            m6721e(a);
        } else if (a <= 65535) {
            m6718d(-46);
            m6722f(a);
        } else {
            m6718d(-47);
            m6723g(a);
        }
    }

    /* renamed from: i */
    private void m6725i(int i) {
        if (i < 0) {
            Kit.m5810a();
        }
        if (i < 6) {
            m6718d(-32 - i);
        } else if (i <= 255) {
            m6718d(-38);
            m6721e(i);
        } else if (i <= 65535) {
            m6718d(-39);
            m6722f(i);
        } else {
            m6718d(-40);
            m6723g(i);
        }
    }

    /* renamed from: a */
    private void m6704a(int i, int i2, int i3, boolean z, int i4, int i5) {
        int i6 = 0;
        int i7 = this.f6737q;
        int[] iArr = this.f6722b.f6061j;
        if (iArr == null) {
            if (i7 != 0) {
                Kit.m5810a();
            }
            iArr = new int[12];
            this.f6722b.f6061j = iArr;
        } else if (iArr.length == i7) {
            iArr = new int[(iArr.length * 2)];
            System.arraycopy(this.f6722b.f6061j, 0, iArr, 0, i7);
            this.f6722b.f6061j = iArr;
        }
        iArr[i7 + 0] = i;
        iArr[i7 + 1] = i2;
        iArr[i7 + 2] = i3;
        int i8 = i7 + 3;
        if (z) {
            i6 = 1;
        }
        iArr[i8] = i6;
        iArr[i7 + 4] = i4;
        iArr[i7 + 5] = i5;
        this.f6737q = i7 + 6;
    }

    /* renamed from: j */
    private byte[] m6726j(int i) {
        int length = this.f6722b.f6060i.length;
        int i2 = this.f6726f;
        if (i2 + i <= length) {
            throw Kit.m5810a();
        }
        int i3 = length * 2;
        if (i2 + i > i3) {
            i3 = i2 + i;
        }
        byte[] bArr = new byte[i3];
        System.arraycopy(this.f6722b.f6060i, 0, bArr, 0, i2);
        this.f6722b.f6060i = bArr;
        return bArr;
    }

    /* renamed from: k */
    private void m6727k(int i) {
        if (i <= 0) {
            this.f6727g += i;
            return;
        }
        int i2 = this.f6727g + i;
        if (i2 > this.f6722b.f6064m) {
            this.f6722b.f6064m = i2;
        }
        this.f6727g = i2;
    }

    /* renamed from: b */
    private int m6708b() {
        int i = this.f6731k;
        this.f6731k++;
        if (this.f6731k > this.f6722b.f6063l) {
            this.f6722b.f6063l = this.f6731k;
        }
        return i;
    }

    /* renamed from: l */
    private void m6728l(int i) {
        this.f6731k--;
        if (i != this.f6731k) {
            Kit.m5810a();
        }
    }
}
