package org.mozilla.javascript.p113e;

import com.baicizhan.client.business.dataset.provider.Contracts.ZBOOKWORDINFO.Columns;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.p110b.FunctionNode;
import org.mozilla.javascript.p110b.Jump;
import org.mozilla.javascript.p110b.Name;
import org.mozilla.javascript.p110b.NumberLiteral;
import org.mozilla.javascript.p110b.ScriptNode;
//import org.mozilla.p108a.C2126c;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.e.c */
final class Codegen {

    /* renamed from: A */
    private short f6562A;

    /* renamed from: B */
    private short f6563B;

    /* renamed from: C */
    private short f6564C;

    /* renamed from: D */
    private boolean f6565D;

    /* renamed from: E */
    private int f6566E;

    /* renamed from: F */
    private int f6567F = 0;

    /* renamed from: G */
    private int f6568G = 0;

    /* renamed from: H */
    private Map<Node, C2188f> f6569H;

    /* renamed from: I */
    private List<Node> f6570I;

    /* renamed from: a */
//    C2126c f6571a;

    /* renamed from: b */
    C2189g f6572b;

    /* renamed from: c */
    CompilerEnvirons f6573c;

    /* renamed from: d */
    ScriptNode f6574d;

    /* renamed from: e */
    public int f6575e;

    /* renamed from: f */
    private C2186d f6576f = new C2186d(this);

    /* renamed from: g */
    private int f6577g;

    /* renamed from: h */
    private OptFunctionNode f6578h;

    /* renamed from: i */
    private int[] f6579i;

    /* renamed from: j */
    private short f6580j;

    /* renamed from: k */
    private short f6581k;

    /* renamed from: l */
    private int f6582l;

    /* renamed from: m */
    private boolean f6583m;

    /* renamed from: n */
    private short[] f6584n;

    /* renamed from: o */
    private boolean f6585o;

    /* renamed from: p */
    private boolean f6586p;

    /* renamed from: q */
    private int f6587q;

    /* renamed from: r */
    private int f6588r;

    /* renamed from: s */
    private boolean f6589s;

    /* renamed from: t */
    private short f6590t;

    /* renamed from: u */
    private short f6591u;

    /* renamed from: v */
    private short f6592v;

    /* renamed from: w */
    private short f6593w;

    /* renamed from: x */
    private short f6594x;

    /* renamed from: y */
    private short f6595y;

    /* renamed from: z */
    private short f6596z;

    Codegen() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo19066a() {
//        Node cmVar;
//        this.f6565D = C2189g.m6586a(this.f6574d);
//        m6543c();
//        if (this.f6565D) {
//            this.f6571a.mo18581b(this.f6572b.mo19073d(this.f6574d) + "_gen", "(" + this.f6572b.f6611c + "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;", 10);
//        } else {
//            this.f6571a.mo18581b(this.f6572b.mo19073d(this.f6574d), this.f6572b.mo19074e(this.f6574d), 10);
//        }
//        m6548d();
//        if (this.f6578h != null) {
//            cmVar = this.f6574d.mo18938c();
//        } else {
//            cmVar = this.f6574d;
//        }
//        m6525a(cmVar);
//        m6559f();
//        this.f6571a.mo18574a((short) (this.f6581k + 1));
//        if (this.f6565D) {
//            this.f6571a.mo18581b(this.f6572b.mo19073d(this.f6574d), this.f6572b.mo19074e(this.f6574d), 10);
//            m6543c();
//            short s = this.f6580j;
//            this.f6580j = (short) (s + 1);
//            this.f6593w = s;
//            this.f6581k = this.f6580j;
//            if (this.f6578h != null) {
//                this.f6571a.mo18593i((int) this.f6596z);
//                this.f6571a.mo18580b(185, "org/mozilla/javascript/Scriptable", "getParentScope", "()Lorg/mozilla/javascript/Scriptable;");
//                this.f6571a.mo18590f((int) this.f6590t);
//            }
//            this.f6571a.mo18593i((int) this.f6596z);
//            this.f6571a.mo18593i((int) this.f6590t);
//            this.f6571a.mo18593i((int) this.f6593w);
//            m6523a("createFunctionActivation", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
//            this.f6571a.mo18590f((int) this.f6590t);
//            this.f6571a.mo18568a(187, this.f6572b.f6610b);
//            this.f6571a.mo18564a(89);
//            this.f6571a.mo18593i((int) this.f6590t);
//            this.f6571a.mo18593i((int) this.f6592v);
//            this.f6571a.mo18583c(this.f6575e);
//            this.f6571a.mo18580b(183, this.f6572b.f6610b, "<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V");
//            m6536b();
//            this.f6571a.mo18593i((int) this.f6590t);
//            this.f6571a.mo18593i((int) this.f6595y);
//            this.f6571a.mo18578b(this.f6567F);
//            this.f6571a.mo18578b(this.f6568G);
//            m6538b("createNativeGenerator", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;II)Lorg/mozilla/javascript/Scriptable;");
//            this.f6571a.mo18564a(176);
//            this.f6571a.mo18574a((short) (this.f6581k + 1));
//        }
//        if (this.f6570I != null) {
//            int i = 0;
//            while (true) {
//                int i2 = i;
//                if (i2 < this.f6570I.size()) {
//                    Node cmVar2 = (Node) this.f6570I.get(i2);
//                    int i3 = cmVar2.f6389a;
//                    switch (i3) {
//                        case 65:
//                            String str = this.f6572b.mo19073d(this.f6574d) + "_literal" + (i2 + 1);
//                            m6543c();
//                            short s2 = this.f6580j;
//                            this.f6580j = (short) (s2 + 1);
//                            this.f6593w = s2;
//                            this.f6581k = this.f6580j;
//                            this.f6571a.mo18581b(str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;", 2);
//                            m6531a(cmVar2, cmVar2.mo18930b(), true);
//                            this.f6571a.mo18564a(176);
//                            this.f6571a.mo18574a((short) (this.f6581k + 1));
//                            break;
//                        case 66:
//                            String str2 = this.f6572b.mo19073d(this.f6574d) + "_literal" + (i2 + 1);
//                            m6543c();
//                            short s3 = this.f6580j;
//                            this.f6580j = (short) (s3 + 1);
//                            this.f6593w = s3;
//                            this.f6581k = this.f6580j;
//                            this.f6571a.mo18581b(str2, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;", 2);
//                            m6541b(cmVar2, cmVar2.mo18930b(), true);
//                            this.f6571a.mo18564a(176);
//                            this.f6571a.mo18574a((short) (this.f6581k + 1));
//                            break;
//                        default:
//                            Kit.m5814b(Token.m6625a(i3));
//                            break;
//                    }
//                    i = i2 + 1;
//                } else {
//                    return;
//                }
//            }
//        }
    }

    /* renamed from: b */
    private void m6536b() {
        int o = this.f6574d.mo18726o();
        for (int i = 0; i != o; i++) {
            OptFunctionNode a = OptFunctionNode.m6606a(this.f6574d, i);
            if (a.f6618a.f6260q == 1) {
                m6533a(a, 1);
            }
        }
    }

    /* renamed from: c */
    private void m6543c() {
        this.f6584n = null;
        if (this.f6574d.f6389a == 109) {
            this.f6578h = (OptFunctionNode) this.f6574d.f6155L;
            this.f6583m = !this.f6578h.f6618a.f6261r;
            if (this.f6583m) {
                int v = this.f6578h.f6618a.mo18768v();
                if (v != 0) {
                    this.f6584n = new short[v];
                }
            }
            this.f6585o = this.f6578h.mo19076a();
            if (this.f6585o && !this.f6583m) {
                C2189g.m6578a();
            }
        } else {
            this.f6578h = null;
            this.f6583m = false;
            this.f6585o = false;
        }
        this.f6579i = new int[1024];
        this.f6596z = 0;
        this.f6592v = 1;
        this.f6590t = 2;
        this.f6595y = 3;
        this.f6581k = 4;
        this.f6580j = 4;
        this.f6591u = -1;
        this.f6593w = -1;
        this.f6562A = -1;
        this.f6563B = -1;
        this.f6588r = -1;
        this.f6587q = -1;
        this.f6564C = -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:137:0x021c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01fb  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6548d() {
        /*
            r14 = this;
            r11 = 178(0xb2, float:2.5E-43)
            r2 = 2
            r4 = -1
            r7 = 0
            r3 = 1
            boolean r0 = r14.f6585o
            if (r0 == 0) goto L_0x006c
            org.mozilla.javascript.b.au r0 = r14.f6574d
            int r1 = r0.f6153J
            short r0 = r14.f6580j
            r5 = 4
            if (r0 == r5) goto L_0x0016
            org.mozilla.javascript.Kit.m5810a()
        L_0x0016:
            r0 = r7
        L_0x0017:
            if (r0 == r1) goto L_0x0029
            short[] r5 = r14.f6584n
            short r6 = r14.f6580j
            r5[r0] = r6
            short r5 = r14.f6580j
            int r5 = r5 + 3
            short r5 = (short) r5
            r14.f6580j = r5
            int r0 = r0 + 1
            goto L_0x0017
        L_0x0029:
            org.mozilla.javascript.e.h r0 = r14.f6578h
            boolean r0 = r0.f6621d
            if (r0 != 0) goto L_0x006c
            r14.f6586p = r3
            r0 = r7
        L_0x0032:
            if (r0 == r1) goto L_0x006c
            short[] r5 = r14.f6584n
            short r5 = r5[r0]
            org.mozilla.a.c r6 = r14.f6571a
            r6.mo18593i(r5)
            org.mozilla.a.c r6 = r14.f6571a
            java.lang.String r8 = "java/lang/Void"
            java.lang.String r9 = "TYPE"
            java.lang.String r10 = "Ljava/lang/Class;"
            r6.mo18569a(r11, r8, r9, r10)
            org.mozilla.a.c r6 = r14.f6571a
            int r6 = r6.mo18562a()
            org.mozilla.a.c r8 = r14.f6571a
            r9 = 166(0xa6, float:2.33E-43)
            r8.mo18565a(r9, r6)
            org.mozilla.a.c r8 = r14.f6571a
            int r9 = r5 + 1
            r8.mo18592h(r9)
            r14.m6571m()
            org.mozilla.a.c r8 = r14.f6571a
            r8.mo18590f(r5)
            org.mozilla.a.c r5 = r14.f6571a
            r5.mo18595k(r6)
            int r0 = r0 + 1
            goto L_0x0032
        L_0x006c:
            org.mozilla.javascript.e.h r0 = r14.f6578h
            if (r0 == 0) goto L_0x008b
            org.mozilla.a.c r0 = r14.f6571a
            short r1 = r14.f6596z
            r0.mo18593i(r1)
            org.mozilla.a.c r0 = r14.f6571a
            r1 = 185(0xb9, float:2.59E-43)
            java.lang.String r5 = "org/mozilla/javascript/Scriptable"
            java.lang.String r6 = "getParentScope"
            java.lang.String r8 = "()Lorg/mozilla/javascript/Scriptable;"
            r0.mo18580b(r1, r5, r6, r8)
            org.mozilla.a.c r0 = r14.f6571a
            short r1 = r14.f6590t
            r0.mo18590f(r1)
        L_0x008b:
            short r0 = r14.f6580j
            int r1 = r0 + 1
            short r1 = (short) r1
            r14.f6580j = r1
            r14.f6593w = r0
            short r0 = r14.f6580j
            r14.f6581k = r0
            boolean r0 = r14.f6565D
            if (r0 == 0) goto L_0x0121
            short r0 = r14.f6580j
            int r1 = r0 + 1
            short r1 = (short) r1
            r14.f6580j = r1
            r14.f6594x = r0
            short r0 = r14.f6580j
            r14.f6581k = r0
            org.mozilla.a.c r0 = r14.f6571a
            short r1 = r14.f6595y
            r0.mo18593i(r1)
            short r0 = r14.f6580j
            int r1 = r0 + 1
            short r1 = (short) r1
            r14.f6580j = r1
            r14.f6564C = r0
            short r0 = r14.f6580j
            r14.f6581k = r0
            org.mozilla.a.c r0 = r14.f6571a
            r1 = 192(0xc0, float:2.69E-43)
            java.lang.String r5 = "org/mozilla/javascript/optimizer/OptRuntime$GeneratorState"
            r0.mo18568a(r1, r5)
            org.mozilla.a.c r0 = r14.f6571a
            r1 = 89
            r0.mo18564a(r1)
            org.mozilla.a.c r0 = r14.f6571a
            short r1 = r14.f6564C
            r0.mo18590f(r1)
            org.mozilla.a.c r0 = r14.f6571a
            r1 = 180(0xb4, float:2.52E-43)
            java.lang.String r5 = "org/mozilla/javascript/optimizer/OptRuntime$GeneratorState"
            java.lang.String r6 = "thisObj"
            java.lang.String r8 = "Lorg/mozilla/javascript/Scriptable;"
            r0.mo18569a(r1, r5, r6, r8)
            org.mozilla.a.c r0 = r14.f6571a
            short r1 = r14.f6595y
            r0.mo18590f(r1)
            int r0 = r14.f6588r
            if (r0 != r4) goto L_0x00f4
            org.mozilla.a.c r0 = r14.f6571a
            int r0 = r0.mo18562a()
            r14.f6588r = r0
        L_0x00f4:
            org.mozilla.javascript.b.au r0 = r14.f6574d
            org.mozilla.javascript.b.x r0 = (org.mozilla.javascript.p110b.FunctionNode) r0
            java.util.List<org.mozilla.javascript.cm> r0 = r0.f6263t
            if (r0 == 0) goto L_0x0121
            org.mozilla.a.c r1 = r14.f6571a
            short r5 = r14.f6564C
            r1.mo18593i(r5)
            org.mozilla.a.c r1 = r14.f6571a
            r5 = 180(0xb4, float:2.52E-43)
            java.lang.String r6 = "org/mozilla/javascript/optimizer/OptRuntime$GeneratorState"
            java.lang.String r8 = "resumptionPoint"
            java.lang.String r9 = "I"
            r1.mo18569a(r5, r6, r8, r9)
            org.mozilla.a.c r1 = r14.f6571a
            int r0 = r0.size()
            int r0 = r0 + 0
            int r0 = r1.mo18576b(r7, r0)
            r14.f6566E = r0
            r14.m6522a(r4, r7, r7)
        L_0x0121:
            org.mozilla.javascript.e.h r0 = r14.f6578h
            if (r0 != 0) goto L_0x0143
            org.mozilla.javascript.b.au r0 = r14.f6574d
            int r0 = r0.mo18742p()
            if (r0 == 0) goto L_0x0143
            org.mozilla.a.c r0 = r14.f6571a
            short r1 = r14.f6592v
            r0.mo18593i(r1)
            org.mozilla.a.c r0 = r14.f6571a
            r1 = 184(0xb8, float:2.58E-43)
            org.mozilla.javascript.e.g r5 = r14.f6572b
            java.lang.String r5 = r5.f6610b
            java.lang.String r6 = "_reInit"
            java.lang.String r8 = "(Lorg/mozilla/javascript/Context;)V"
            r0.mo18580b(r1, r5, r6, r8)
        L_0x0143:
            org.mozilla.javascript.i r0 = r14.f6573c
            boolean r0 = r0.f6748k
            if (r0 == 0) goto L_0x014c
            r14.m6568j()
        L_0x014c:
            boolean r0 = r14.f6583m
            if (r0 == 0) goto L_0x02d5
            org.mozilla.javascript.b.au r0 = r14.f6574d
            int r0 = r0.f6153J
            if (r0 <= 0) goto L_0x0199
            boolean r1 = r14.f6585o
            if (r1 != 0) goto L_0x0199
            org.mozilla.a.c r1 = r14.f6571a
            short r5 = r14.f6593w
            r1.mo18593i(r5)
            org.mozilla.a.c r1 = r14.f6571a
            r5 = 190(0xbe, float:2.66E-43)
            r1.mo18564a(r5)
            org.mozilla.a.c r1 = r14.f6571a
            r1.mo18583c(r0)
            org.mozilla.a.c r1 = r14.f6571a
            int r1 = r1.mo18562a()
            org.mozilla.a.c r5 = r14.f6571a
            r6 = 162(0xa2, float:2.27E-43)
            r5.mo18565a(r6, r1)
            org.mozilla.a.c r5 = r14.f6571a
            short r6 = r14.f6593w
            r5.mo18593i(r6)
            org.mozilla.a.c r5 = r14.f6571a
            r5.mo18583c(r0)
            java.lang.String r0 = "padArguments"
            java.lang.String r5 = "([Ljava/lang/Object;I)[Ljava/lang/Object;"
            r14.m6523a(r0, r5)
            org.mozilla.a.c r0 = r14.f6571a
            short r5 = r14.f6593w
            r0.mo18590f(r5)
            org.mozilla.a.c r0 = r14.f6571a
            r0.mo18595k(r1)
        L_0x0199:
            org.mozilla.javascript.e.h r0 = r14.f6578h
            org.mozilla.javascript.b.x r0 = r0.f6618a
            int r8 = r0.f6153J
            org.mozilla.javascript.e.h r0 = r14.f6578h
            org.mozilla.javascript.b.x r0 = r0.f6618a
            int r9 = r0.mo18768v()
            org.mozilla.javascript.e.h r0 = r14.f6578h
            org.mozilla.javascript.b.x r0 = r0.f6618a
            boolean[] r10 = r0.mo18755B()
            r6 = r7
            r1 = r4
        L_0x01b1:
            if (r6 == r9) goto L_0x02d9
            if (r6 >= r8) goto L_0x0221
            boolean r0 = r14.f6585o
            if (r0 != 0) goto L_0x03d5
            short r0 = r14.m6572n()
            org.mozilla.a.c r5 = r14.f6571a
            short r11 = r14.f6593w
            r5.mo18593i(r11)
            org.mozilla.a.c r5 = r14.f6571a
            r5.mo18583c(r6)
            org.mozilla.a.c r5 = r14.f6571a
            r11 = 50
            r5.mo18564a(r11)
        L_0x01d0:
            org.mozilla.a.c r5 = r14.f6571a
            r5.mo18590f(r0)
            r5 = r1
            r1 = r0
        L_0x01d7:
            if (r1 < 0) goto L_0x01f5
            boolean r0 = r10[r6]
            if (r0 == 0) goto L_0x01f1
            org.mozilla.a.c r0 = r14.f6571a
            r0.mo18583c(r7)
            org.mozilla.a.c r11 = r14.f6571a
            org.mozilla.javascript.e.h r0 = r14.f6578h
            boolean r0 = r0.mo19078b(r6)
            if (r0 == 0) goto L_0x02ce
            r0 = r2
        L_0x01ed:
            int r0 = r0 + r1
            r11.mo18586d(r0)
        L_0x01f1:
            short[] r0 = r14.f6584n
            r0[r6] = r1
        L_0x01f5:
            org.mozilla.javascript.i r0 = r14.f6573c
            boolean r0 = r0.f6740c
            if (r0 == 0) goto L_0x021c
            org.mozilla.javascript.e.h r0 = r14.f6578h
            org.mozilla.javascript.b.x r0 = r0.f6618a
            java.lang.String r11 = r0.mo18767n(r6)
            org.mozilla.javascript.e.h r0 = r14.f6578h
            boolean r0 = r0.mo19078b(r6)
            if (r0 == 0) goto L_0x02d1
            java.lang.String r0 = "D"
        L_0x020d:
            org.mozilla.a.c r12 = r14.f6571a
            int r12 = r12.f5917b
            if (r1 >= 0) goto L_0x0217
            short[] r1 = r14.f6584n
            short r1 = r1[r6]
        L_0x0217:
            org.mozilla.a.c r13 = r14.f6571a
            r13.mo18572a(r11, r0, r12, r1)
        L_0x021c:
            int r0 = r6 + 1
            r6 = r0
            r1 = r5
            goto L_0x01b1
        L_0x0221:
            org.mozilla.javascript.e.h r0 = r14.f6578h
            boolean r0 = r0.mo19078b(r6)
            if (r0 == 0) goto L_0x027e
            boolean r5 = r10[r6]
            short r0 = r14.m6518a(r2, r5)
            r11 = 1023(0x3ff, float:1.434E-42)
            if (r0 >= r11) goto L_0x0277
            int[] r11 = r14.f6579i
            r11[r0] = r3
            int[] r11 = r14.f6579i
            int r12 = r0 + 1
            r11[r12] = r3
            if (r5 == 0) goto L_0x0245
            int[] r5 = r14.f6579i
            int r11 = r0 + 2
            r5[r11] = r3
        L_0x0245:
            short r5 = r14.f6580j
            if (r0 != r5) goto L_0x0264
            short r5 = r14.f6580j
            int r5 = r5 + 2
        L_0x024d:
            r11 = 1024(0x400, float:1.435E-42)
            if (r5 >= r11) goto L_0x0277
            int[] r11 = r14.f6579i
            r11 = r11[r5]
            if (r11 != 0) goto L_0x0274
            short r5 = (short) r5
            r14.f6580j = r5
            short r5 = r14.f6581k
            short r11 = r14.f6580j
            if (r5 >= r11) goto L_0x0264
            short r5 = r14.f6580j
            r14.f6581k = r5
        L_0x0264:
            org.mozilla.a.c r5 = r14.f6571a
            r12 = 0
            r5.mo18563a(r12)
            org.mozilla.a.c r5 = r14.f6571a
            r5.mo18588e(r0)
            r5 = r1
            r1 = r0
            goto L_0x01d7
        L_0x0274:
            int r5 = r5 + 1
            goto L_0x024d
        L_0x0277:
            java.lang.String r0 = "Program too complex (out of locals)"
            org.mozilla.javascript.z r0 = org.mozilla.javascript.Context.m6765c(r0)
            throw r0
        L_0x027e:
            boolean r5 = r10[r6]
            short r0 = r14.m6518a(r3, r5)
            r11 = 1023(0x3ff, float:1.434E-42)
            if (r0 >= r11) goto L_0x02c0
            int[] r11 = r14.f6579i
            r11[r0] = r3
            if (r5 == 0) goto L_0x0294
            int[] r5 = r14.f6579i
            int r11 = r0 + 1
            r5[r11] = r3
        L_0x0294:
            short r5 = r14.f6580j
            if (r0 != r5) goto L_0x02b3
            short r5 = r14.f6580j
            int r5 = r5 + 2
        L_0x029c:
            r11 = 1024(0x400, float:1.435E-42)
            if (r5 >= r11) goto L_0x02c0
            int[] r11 = r14.f6579i
            r11 = r11[r5]
            if (r11 != 0) goto L_0x02bd
            short r5 = (short) r5
            r14.f6580j = r5
            short r5 = r14.f6581k
            short r11 = r14.f6580j
            if (r5 >= r11) goto L_0x02b3
            short r5 = r14.f6580j
            r14.f6581k = r5
        L_0x02b3:
            if (r1 != r4) goto L_0x02c7
            org.mozilla.a.c r1 = r14.f6571a
            org.mozilla.javascript.p113e.C2189g.m6589b(r1)
            r1 = r0
            goto L_0x01d0
        L_0x02bd:
            int r5 = r5 + 1
            goto L_0x029c
        L_0x02c0:
            java.lang.String r0 = "Program too complex (out of locals)"
            org.mozilla.javascript.z r0 = org.mozilla.javascript.Context.m6765c(r0)
            throw r0
        L_0x02c7:
            org.mozilla.a.c r5 = r14.f6571a
            r5.mo18593i(r1)
            goto L_0x01d0
        L_0x02ce:
            r0 = r3
            goto L_0x01ed
        L_0x02d1:
            java.lang.String r0 = "Ljava/lang/Object;"
            goto L_0x020d
        L_0x02d5:
            boolean r0 = r14.f6565D
            if (r0 == 0) goto L_0x02da
        L_0x02d9:
            return
        L_0x02da:
            org.mozilla.javascript.e.h r0 = r14.f6578h
            if (r0 == 0) goto L_0x0369
            java.lang.String r0 = "activation"
            org.mozilla.a.c r1 = r14.f6571a
            short r2 = r14.f6596z
            r1.mo18593i(r2)
            org.mozilla.a.c r1 = r14.f6571a
            short r2 = r14.f6590t
            r1.mo18593i(r2)
            org.mozilla.a.c r1 = r14.f6571a
            short r2 = r14.f6593w
            r1.mo18593i(r2)
            java.lang.String r1 = "createFunctionActivation"
            java.lang.String r2 = "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;"
            r14.m6523a(r1, r2)
            org.mozilla.a.c r1 = r14.f6571a
            short r2 = r14.f6590t
            r1.mo18590f(r2)
            org.mozilla.a.c r1 = r14.f6571a
            short r2 = r14.f6592v
            r1.mo18593i(r2)
            org.mozilla.a.c r1 = r14.f6571a
            short r2 = r14.f6590t
            r1.mo18593i(r2)
            java.lang.String r1 = "enterActivationFunction"
            java.lang.String r2 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V"
            r14.m6523a(r1, r2)
        L_0x0318:
            org.mozilla.a.c r1 = r14.f6571a
            int r1 = r1.mo18562a()
            r14.f6587q = r1
            org.mozilla.a.c r1 = r14.f6571a
            int r1 = r1.mo18562a()
            r14.f6588r = r1
            org.mozilla.a.c r1 = r14.f6571a
            int r2 = r14.f6587q
            r1.mo18595k(r2)
            r14.m6536b()
            org.mozilla.javascript.i r1 = r14.f6573c
            boolean r1 = r1.f6740c
            if (r1 == 0) goto L_0x0345
            org.mozilla.a.c r1 = r14.f6571a
            java.lang.String r2 = "Lorg/mozilla/javascript/Scriptable;"
            org.mozilla.a.c r5 = r14.f6571a
            int r5 = r5.f5917b
            short r6 = r14.f6590t
            r1.mo18572a(r0, r2, r5, r6)
        L_0x0345:
            org.mozilla.javascript.e.h r0 = r14.f6578h
            if (r0 != 0) goto L_0x0394
            short r0 = r14.m6572n()
            r14.f6591u = r0
            org.mozilla.a.c r0 = r14.f6571a
            org.mozilla.javascript.p113e.C2189g.m6589b(r0)
            org.mozilla.a.c r0 = r14.f6571a
            short r1 = r14.f6591u
            r0.mo18590f(r1)
            org.mozilla.javascript.b.au r0 = r14.f6574d
            int r0 = r0.f6150G
            if (r0 == r4) goto L_0x02d9
            org.mozilla.a.c r1 = r14.f6571a
            short r0 = (short) r0
            r1.mo18582b(r0)
            goto L_0x02d9
        L_0x0369:
            java.lang.String r0 = "global"
            org.mozilla.a.c r1 = r14.f6571a
            short r2 = r14.f6596z
            r1.mo18593i(r2)
            org.mozilla.a.c r1 = r14.f6571a
            short r2 = r14.f6595y
            r1.mo18593i(r2)
            org.mozilla.a.c r1 = r14.f6571a
            short r2 = r14.f6592v
            r1.mo18593i(r2)
            org.mozilla.a.c r1 = r14.f6571a
            short r2 = r14.f6590t
            r1.mo18593i(r2)
            org.mozilla.a.c r1 = r14.f6571a
            r1.mo18583c(r7)
            java.lang.String r1 = "initScript"
            java.lang.String r2 = "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Z)V"
            r14.m6523a(r1, r2)
            goto L_0x0318
        L_0x0394:
            org.mozilla.javascript.e.h r0 = r14.f6578h
            boolean r0 = r0.f6622e
            if (r0 == 0) goto L_0x03b2
            short r0 = r14.m6572n()
            r14.f6562A = r0
            org.mozilla.a.c r0 = r14.f6571a
            java.lang.String r1 = "org/mozilla/javascript/ScriptRuntime"
            java.lang.String r2 = "emptyArgs"
            java.lang.String r4 = "[Ljava/lang/Object;"
            r0.mo18569a(r11, r1, r2, r4)
            org.mozilla.a.c r0 = r14.f6571a
            short r1 = r14.f6562A
            r0.mo18590f(r1)
        L_0x03b2:
            org.mozilla.javascript.e.h r0 = r14.f6578h
            boolean r0 = r0.f6623f
            if (r0 == 0) goto L_0x02d9
            short r0 = r14.m6572n()
            r14.f6563B = r0
            org.mozilla.a.c r0 = r14.f6571a
            r0.mo18583c(r3)
            org.mozilla.a.c r0 = r14.f6571a
            r1 = 189(0xbd, float:2.65E-43)
            java.lang.String r2 = "java/lang/Object"
            r0.mo18568a(r1, r2)
            org.mozilla.a.c r0 = r14.f6571a
            short r1 = r14.f6563B
            r0.mo18590f(r1)
            goto L_0x02d9
        L_0x03d5:
            r5 = r1
            r1 = r4
            goto L_0x01d7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.p113e.Codegen.m6548d():void");
    }

    /* renamed from: b */
    private void m6537b(int i) {
//        this.f6571a.mo18593i((int) this.f6564C);
//        this.f6571a.mo18578b(i);
//        this.f6571a.mo18569a(181, "org/mozilla/javascript/optimizer/OptRuntime$GeneratorState", "resumptionPoint", "I");
    }

    /* renamed from: e */
    private void m6553e() {
//        this.f6571a.mo18593i((int) this.f6564C);
        m6538b("getGeneratorStackState", "(Ljava/lang/Object;)[Ljava/lang/Object;");
    }

    /* renamed from: f */
    private void m6559f() {
//        if (this.f6573c.f6748k) {
//            m6569k();
//        }
//        if (this.f6565D) {
//            Map<Node, int[]> map = ((FunctionNode) this.f6574d).f6264u;
//            if (map != null) {
//                List<Node> list = ((FunctionNode) this.f6574d).f6263t;
//                for (int i = 0; i < list.size(); i++) {
//                    Node cmVar = (Node) list.get(i);
//                    int[] iArr = (int[]) map.get(cmVar);
//                    if (iArr != null) {
//                        this.f6571a.mo18584c(this.f6566E, m6535b(cmVar));
//                        m6561g();
//                        for (int i2 = 0; i2 < iArr.length; i2++) {
//                            this.f6571a.mo18564a(89);
//                            this.f6571a.mo18578b(i2);
//                            this.f6571a.mo18564a(50);
//                            this.f6571a.mo18590f(iArr[i2]);
//                        }
//                        this.f6571a.mo18564a(87);
//                        this.f6571a.mo18565a(167, m6542c(cmVar));
//                    }
//                }
//            }
//            if (this.f6569H != null) {
////                for (Node cmVar2 : this.f6569H.keySet()) {
////                    if (cmVar2.f6389a == 125) {
////                        C2188f fVar = (C2188f) this.f6569H.get(cmVar2);
////                        this.f6571a.mo18570a(fVar.f6606b, 1);
////                        int b = this.f6571a.mo18576b(0, fVar.f6605a.size() - 1);
////                        this.f6571a.mo18594j(b);
////                        int i3 = 0;
////                        int i4 = 0;
////                        while (i4 < fVar.f6605a.size()) {
////                            this.f6571a.mo18584c(b, i3);
////                            this.f6571a.mo18565a(167, ((Integer) fVar.f6605a.get(i4)).intValue());
////                            i4++;
////                            i3++;
////                        }
////                    }
////                }
//            }
//        }
//        if (this.f6588r != -1) {
//            this.f6571a.mo18595k(this.f6588r);
//        }
//        if (this.f6583m) {
//            this.f6571a.mo18564a(176);
//        } else if (this.f6565D) {
//            if (((FunctionNode) this.f6574d).f6263t != null) {
//                this.f6571a.mo18594j(this.f6566E);
//            }
//            m6537b(-1);
//            this.f6571a.mo18593i((int) this.f6590t);
//            m6538b("throwStopIteration", "(Ljava/lang/Object;)V");
//            C2189g.m6589b(this.f6571a);
//            this.f6571a.mo18564a(176);
//        } else if (this.f6578h == null) {
//            this.f6571a.mo18593i((int) this.f6591u);
//            this.f6571a.mo18564a(176);
//        } else {
//            m6565h();
//            this.f6571a.mo18564a(176);
//            int a = this.f6571a.mo18562a();
//            this.f6571a.mo18596l(a);
//            short n = m6572n();
//            this.f6571a.mo18590f((int) n);
//            m6565h();
//            this.f6571a.mo18593i((int) n);
//            m6534a(n);
//            this.f6571a.mo18564a(191);
//            this.f6571a.mo18567a(this.f6587q, this.f6588r, a, (String) null);
//        }
    }

    /* renamed from: g */
    private void m6561g() {
//        this.f6571a.mo18593i((int) this.f6564C);
        m6538b("getGeneratorLocalsState", "(Ljava/lang/Object;)[Ljava/lang/Object;");
    }

    /* renamed from: h */
    private void m6565h() {
        if (this.f6578h == null || this.f6583m) {
            throw Kit.m5810a();
        }
//        this.f6571a.mo18593i((int) this.f6592v);
        m6523a("exitActivationFunction", "(Lorg/mozilla/javascript/Context;)V");
    }

    /* renamed from: a */
    private void m6525a(Node cmVar) {
        m6555e(cmVar);
        int i = cmVar.f6389a;
        Node b = cmVar.mo18930b();
//        switch (i) {
//            case 2:
//                m6529a(b, cmVar);
//                this.f6571a.mo18593i((int) this.f6592v);
//                this.f6571a.mo18593i((int) this.f6590t);
//                m6523a("enterWith", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
//                this.f6571a.mo18590f((int) this.f6590t);
//                short s = this.f6590t;
//                int[] iArr = this.f6579i;
//                iArr[s] = iArr[s] + 1;
//                return;
//            case 3:
//                this.f6571a.mo18593i((int) this.f6590t);
//                m6523a("leaveWith", "(Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
//                this.f6571a.mo18590f((int) this.f6590t);
//                short s2 = this.f6590t;
//                int[] iArr2 = this.f6579i;
//                iArr2[s2] = iArr2[s2] - 1;
//                return;
//            case 4:
//            case 64:
//                if (!this.f6565D) {
//                    if (b != null) {
//                        m6529a(b, cmVar);
//                    } else if (i == 4) {
//                        C2189g.m6589b(this.f6571a);
//                    } else if (this.f6591u < 0) {
//                        throw C2189g.m6578a();
//                    } else {
//                        this.f6571a.mo18593i((int) this.f6591u);
//                    }
//                }
//                if (this.f6573c.f6748k) {
//                    m6569k();
//                }
//                if (this.f6588r == -1) {
//                    if (!this.f6583m) {
//                        throw C2189g.m6578a();
//                    }
//                    this.f6588r = this.f6571a.mo18562a();
//                }
//                this.f6571a.mo18565a(167, this.f6588r);
//                return;
//            case 5:
//            case 6:
//            case 7:
//            case 135:
//                if (this.f6573c.f6748k) {
//                    m6569k();
//                }
//                Jump aeVar = (Jump) cmVar;
//                Node cmVar2 = aeVar.f6117w;
//                if (i == 6 || i == 7) {
//                    if (b == null) {
//                        throw C2189g.m6578a();
//                    }
//                    int c = m6542c(cmVar2);
//                    int a = this.f6571a.mo18562a();
//                    if (i == 6) {
//                        m6530a(b, (Node) aeVar, c, a);
//                    } else {
//                        m6530a(b, (Node) aeVar, a, c);
//                    }
//                    this.f6571a.mo18595k(a);
//                    return;
//                } else if (i != 135) {
//                    m6526a(cmVar2, 167);
//                    return;
//                } else if (this.f6565D) {
//                    m6549d(cmVar2);
//                    return;
//                } else {
//                    int a2 = this.f6571a.mo18562a();
//                    int a3 = this.f6571a.mo18562a();
//                    this.f6571a.mo18595k(a2);
//                    m6527a(cmVar2, a2, a3);
//                    this.f6571a.mo18595k(a3);
//                    return;
//                }
//            case 50:
//                m6529a(b, cmVar);
//                if (this.f6573c.f6748k) {
//                    m6569k();
//                }
//                m6567i();
//                return;
//            case 51:
//                if (this.f6573c.f6748k) {
//                    m6569k();
//                }
//                this.f6571a.mo18593i(m6566i(cmVar));
//                this.f6571a.mo18564a(191);
//                return;
//            case 57:
//                this.f6571a.f5919d = 0;
//                int i2 = m6566i(cmVar);
//                int d = cmVar.mo18941d(14);
//                String str = ((Name) b).f6130g;
//                m6529a(b.mo18942d(), cmVar);
//                if (d == 0) {
//                    this.f6571a.mo18564a(1);
//                } else {
//                    this.f6571a.mo18593i(i2);
//                }
//                this.f6571a.mo18589e(str);
//                this.f6571a.mo18593i((int) this.f6592v);
//                this.f6571a.mo18593i((int) this.f6590t);
//                m6523a("newCatchScope", "(Ljava/lang/Throwable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
//                this.f6571a.mo18590f(i2);
//                return;
//            case 58:
//            case 59:
//            case 60:
//                m6529a(b, cmVar);
//                this.f6571a.mo18593i((int) this.f6592v);
//                int i3 = i == 58 ? 0 : i == 59 ? 1 : 2;
//                this.f6571a.mo18583c(i3);
//                m6523a("enumInit", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;I)Ljava/lang/Object;");
//                this.f6571a.mo18590f(m6566i(cmVar));
//                return;
//            case 81:
//                Jump aeVar2 = (Jump) cmVar;
//                short n = m6572n();
//                this.f6571a.mo18593i((int) this.f6590t);
//                this.f6571a.mo18590f((int) n);
//                int a4 = this.f6571a.mo18562a();
//                this.f6571a.mo18570a(a4, 0);
//                Node cmVar3 = aeVar2.f6117w;
//                Node x = aeVar2.mo18729x();
//                int[] iArr3 = new int[5];
//                C2186d dVar = this.f6576f;
//                dVar.f6597a.add(new C2187e(dVar, aeVar2, m6558f(aeVar2.mo18729x())));
//                if (cmVar3 != null) {
//                    iArr3[0] = this.f6571a.mo18562a();
//                    iArr3[1] = this.f6571a.mo18562a();
//                    iArr3[2] = this.f6571a.mo18562a();
//                    Context a5 = Context.m6753a();
//                    if (a5 != null && a5.mo19138b(13)) {
//                        iArr3[3] = this.f6571a.mo18562a();
//                    }
//                }
//                if (x != null) {
//                    iArr3[4] = this.f6571a.mo18562a();
//                }
//                C2186d dVar2 = this.f6576f;
//                dVar2.mo19068a();
//                for (int i4 = 0; i4 < 5; i4++) {
//                    if (iArr3[i4] != 0) {
//                        int i5 = iArr3[i4];
//                        C2187e a6 = dVar2.mo19068a();
//                        a6.f6601c[i4] = i5;
//                        a6.f6602d[i4] = a4;
//                    }
//                }
//                if (this.f6565D && x != null) {
//                    C2188f fVar = new C2188f();
//                    if (this.f6569H == null) {
//                        this.f6569H = new HashMap();
//                    }
//                    this.f6569H.put(x, fVar);
//                    this.f6569H.put(x.mo18942d(), fVar);
//                }
//                while (b != null) {
//                    if (b == cmVar3) {
//                        int c2 = m6542c(cmVar3);
//                        this.f6576f.mo19067a(0, c2);
//                        this.f6576f.mo19067a(1, c2);
//                        this.f6576f.mo19067a(2, c2);
//                        this.f6576f.mo19067a(3, c2);
//                    }
//                    m6525a(b);
//                    b = b.mo18942d();
//                }
//                int a7 = this.f6571a.mo18562a();
//                this.f6571a.mo18565a(167, a7);
//                int i6 = m6566i(aeVar2);
//                if (cmVar3 != null) {
//                    int i7 = cmVar3.mo18948i();
//                    m6521a(0, n, i7, i6, iArr3[0]);
//                    m6521a(1, n, i7, i6, iArr3[1]);
//                    m6521a(2, n, i7, i6, iArr3[2]);
//                    Context a8 = Context.m6753a();
//                    if (a8 != null && a8.mo19138b(13)) {
//                        m6521a(3, n, i7, i6, iArr3[3]);
//                    }
//                }
//                if (x != null) {
//                    int a9 = this.f6571a.mo18562a();
//                    int a10 = this.f6571a.mo18562a();
//                    this.f6571a.mo18596l(a9);
//                    if (!this.f6565D) {
//                        this.f6571a.mo18595k(iArr3[4]);
//                    }
//                    this.f6571a.mo18590f(i6);
//                    this.f6571a.mo18593i((int) n);
//                    this.f6571a.mo18590f((int) this.f6590t);
//                    int i8 = x.mo18948i();
//                    if (this.f6565D) {
//                        m6549d(x);
//                    } else {
//                        m6527a(x, iArr3[4], a10);
//                    }
//                    this.f6571a.mo18593i(i6);
//                    if (this.f6565D) {
//                        this.f6571a.mo18568a(192, "java/lang/Throwable");
//                    }
//                    this.f6571a.mo18564a(191);
//                    this.f6571a.mo18595k(a10);
//                    if (this.f6565D) {
//                        this.f6571a.mo18567a(a4, i8, a9, (String) null);
//                    }
//                }
//                m6534a(n);
//                this.f6571a.mo18595k(a7);
//                if (!this.f6565D) {
//                    this.f6576f.f6597a.removeLast();
//                    return;
//                }
//                return;
//            case 109:
//                OptFunctionNode a11 = OptFunctionNode.m6606a(this.f6574d, cmVar.mo18941d(1));
//                int i9 = a11.f6618a.f6260q;
//                if (i9 == 3) {
//                    m6533a(a11, i9);
//                    return;
//                } else if (i9 != 1) {
//                    throw C2189g.m6578a();
//                } else {
//                    return;
//                }
//            case 114:
//                if (this.f6573c.f6748k) {
//                    m6569k();
//                }
//                m6524a((Jump) cmVar, b);
//                return;
//            case 123:
//            case 128:
//            case 129:
//            case 130:
//            case 132:
//            case 136:
//                if (this.f6573c.f6748k) {
//                    m6544c(1);
//                }
//                while (b != null) {
//                    m6525a(b);
//                    b = b.mo18942d();
//                }
//                return;
//            case 125:
//                if (this.f6565D) {
//                    if (this.f6573c.f6748k) {
//                        m6568j();
//                    }
//                    this.f6571a.f5919d = 1;
//                    short n2 = m6572n();
//                    int a12 = this.f6571a.mo18562a();
//                    int a13 = this.f6571a.mo18562a();
//                    this.f6571a.mo18595k(a12);
//                    this.f6571a.mo18580b(184, "java/lang/Integer", CoreConstants.VALUE_OF, "(I)Ljava/lang/Integer;");
//                    this.f6571a.mo18590f((int) n2);
//                    while (b != null) {
//                        m6525a(b);
//                        b = b.mo18942d();
//                    }
//                    this.f6571a.mo18593i((int) n2);
//                    this.f6571a.mo18568a(192, "java/lang/Integer");
//                    this.f6571a.mo18580b(182, "java/lang/Integer", "intValue", "()I");
//                    C2188f fVar2 = (C2188f) this.f6569H.get(cmVar);
//                    fVar2.f6606b = this.f6571a.mo18562a();
//                    this.f6571a.mo18565a(167, fVar2.f6606b);
//                    m6534a((short) n2);
//                    this.f6571a.mo18595k(a13);
//                    return;
//                }
//                return;
//            case 131:
//                if (this.f6573c.f6748k) {
//                    m6569k();
//                }
//                this.f6571a.mo18595k(m6542c(cmVar));
//                if (this.f6573c.f6748k) {
//                    m6568j();
//                    return;
//                }
//                return;
//            case 133:
//                if (b.f6389a == 56) {
//                    m6551d(b, b.mo18930b(), false);
//                    return;
//                } else if (b.f6389a == 156) {
//                    m6557e(b, b.mo18930b(), false);
//                    return;
//                } else if (b.f6389a == 72) {
//                    m6532a(b, false);
//                    return;
//                } else {
//                    m6529a(b, cmVar);
//                    if (cmVar.mo18924a(8, -1) != -1) {
//                        this.f6571a.mo18564a(88);
//                        return;
//                    } else {
//                        this.f6571a.mo18564a(87);
//                        return;
//                    }
//                }
//            case 134:
//                m6529a(b, cmVar);
//                if (this.f6591u < 0) {
//                    this.f6591u = m6572n();
//                }
//                this.f6571a.mo18590f((int) this.f6591u);
//                return;
//            case 141:
//                boolean z = this.f6589s;
//                this.f6589s = true;
//                short n3 = m6572n();
//                if (this.f6565D) {
//                    this.f6571a.mo18564a(1);
//                    this.f6571a.mo18590f((int) n3);
//                }
//                cmVar.mo18933b(2, (int) n3);
//                while (b != null) {
//                    m6525a(b);
//                    b = b.mo18942d();
//                }
//                m6534a((short) n3);
//                cmVar.mo18932b(2);
//                this.f6589s = z;
//                return;
//            case 160:
//                return;
//            default:
//                throw C2189g.m6578a();
//        }
    }

    /* renamed from: i */
    private void m6567i() {
//        this.f6571a.mo18568a(187, "org/mozilla/javascript/JavaScriptException");
//        this.f6571a.mo18564a(90);
//        this.f6571a.mo18564a(95);
//        this.f6571a.mo18589e(this.f6574d.f6148E);
//        this.f6571a.mo18583c(this.f6582l);
//        this.f6571a.mo18580b(183, "org/mozilla/javascript/JavaScriptException", "<init>", "(Ljava/lang/Object;Ljava/lang/String;I)V");
//        this.f6571a.mo18564a(191);
    }

    /* renamed from: b */
    private int m6535b(Node cmVar) {
        return ((FunctionNode) this.f6574d).f6263t.indexOf(cmVar) + 1;
    }

    /* renamed from: a */
    private void m6529a(Node cmVar, Node cmVar2) {
        String str;
        String str2;
        String str3;
        String str4;
        short n;
//        while (true) {
//            Node cmVar3 = cmVar;
//            int i = cmVar3.f6389a;
//            Node b = cmVar3.mo18930b();
//            switch (i) {
//                case 8:
//                    m6545c(cmVar3, b);
//                    return;
//                case 9:
//                case 10:
//                case 11:
//                case 18:
//                case 19:
//                case 20:
//                    int a = cmVar3.mo18924a(8, -1);
//                    m6529a(b, cmVar3);
//                    if (i == 20) {
//                        m6523a("toUint32", "(Ljava/lang/Object;)J");
//                        m6529a(b.mo18942d(), cmVar3);
//                        m6523a("toInt32", "(Ljava/lang/Object;)I");
////                        this.f6571a.mo18583c(31);
////                        this.f6571a.mo18564a(126);
////                        this.f6571a.mo18564a(125);
////                        this.f6571a.mo18564a(138);
//                        m6571m();
//                        return;
//                    }
//                    if (a == -1) {
//                        m6523a("toInt32", "(Ljava/lang/Object;)I");
//                        m6529a(b.mo18942d(), cmVar3);
//                        m6523a("toInt32", "(Ljava/lang/Object;)I");
//                    } else {
//                        m6523a("toInt32", "(D)I");
//                        m6529a(b.mo18942d(), cmVar3);
//                        m6523a("toInt32", "(D)I");
//                    }
////                    switch (i) {
////                        case 9:
////                            this.f6571a.mo18564a(128);
////                            break;
////                        case 10:
////                            this.f6571a.mo18564a(130);
////                            break;
////                        case 11:
////                            this.f6571a.mo18564a(126);
////                            break;
////                        case 18:
////                            this.f6571a.mo18564a(120);
////                            break;
////                        case 19:
////                            this.f6571a.mo18564a(122);
////                            break;
////                        default:
////                            throw C2189g.m6578a();
////                    }
////                    this.f6571a.mo18564a(135);
//                    if (a == -1) {
//                        m6571m();
//                        return;
//                    }
//                    return;
//                case 12:
//                case 13:
//                case 46:
//                case 47:
//                    int a2 = this.f6571a.mo18562a();
//                    int a3 = this.f6571a.mo18562a();
//                    m6546c(cmVar3, b, a2, a3);
//                    m6519a(a2, a3);
//                    return;
//                case 14:
//                case 15:
//                case 16:
//                case 17:
//                case 52:
//                case 53:
//                    int a4 = this.f6571a.mo18562a();
//                    int a5 = this.f6571a.mo18562a();
//                    m6540b(cmVar3, b, a4, a5);
//                    m6519a(a4, a5);
//                    return;
//                case 21:
//                    m6529a(b, cmVar3);
//                    m6529a(b.mo18942d(), cmVar3);
//                    switch (cmVar3.mo18924a(8, -1)) {
//                        case 0:
//                            this.f6571a.mo18564a(99);
//                            return;
//                        case 1:
//                            m6538b("add", "(DLjava/lang/Object;)Ljava/lang/Object;");
//                            return;
//                        case 2:
//                            m6538b("add", "(Ljava/lang/Object;D)Ljava/lang/Object;");
//                            return;
//                        default:
//                            if (b.f6389a == 41) {
//                                m6523a("add", "(Ljava/lang/CharSequence;Ljava/lang/Object;)Ljava/lang/CharSequence;");
//                                return;
//                            } else if (b.mo18942d().f6389a == 41) {
//                                m6523a("add", "(Ljava/lang/Object;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;");
//                                return;
//                            } else {
//                                this.f6571a.mo18593i((int) this.f6592v);
//                                m6523a("add", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                                return;
//                            }
//                    }
//                case 22:
//                    m6528a(cmVar3, 103, b, cmVar2);
//                    return;
//                case 23:
//                    m6528a(cmVar3, 107, b, cmVar2);
//                    return;
//                case 24:
//                case 25:
//                    m6528a(cmVar3, i == 24 ? 111 : 115, b, cmVar2);
//                    return;
//                case 26:
//                    int a6 = this.f6571a.mo18562a();
//                    int a7 = this.f6571a.mo18562a();
//                    int a8 = this.f6571a.mo18562a();
//                    m6530a(b, cmVar3, a6, a7);
//                    this.f6571a.mo18595k(a6);
//                    this.f6571a.mo18569a(178, "java/lang/Boolean", "FALSE", "Ljava/lang/Boolean;");
//                    this.f6571a.mo18565a(167, a8);
//                    this.f6571a.mo18595k(a7);
//                    this.f6571a.mo18569a(178, "java/lang/Boolean", "TRUE", "Ljava/lang/Boolean;");
//                    this.f6571a.mo18595k(a8);
//                    this.f6571a.mo18577b();
//                    return;
//                case 27:
//                    m6529a(b, cmVar3);
//                    m6523a("toInt32", "(Ljava/lang/Object;)I");
//                    this.f6571a.mo18583c(-1);
//                    this.f6571a.mo18564a(130);
//                    this.f6571a.mo18564a(135);
//                    m6571m();
//                    return;
//                case 28:
//                case 29:
//                    m6529a(b, cmVar3);
//                    m6570l();
//                    if (i == 29) {
//                        this.f6571a.mo18564a(119);
//                    }
//                    m6571m();
//                    return;
//                case 30:
//                case 38:
//                    int a9 = cmVar3.mo18924a(10, 0);
//                    if (a9 == 0) {
//                        OptFunctionNode hVar = (OptFunctionNode) cmVar3.mo18937c(9);
//                        if (hVar != null) {
//                            Node d = b.mo18942d();
//                            String str5 = this.f6572b.f6610b;
//                            if (i == 30) {
//                                m6529a(b, cmVar3);
//                                n = 0;
//                            } else {
//                                m6539b(b, cmVar3);
//                                n = m6572n();
//                                this.f6571a.mo18590f((int) n);
//                            }
//                            int a10 = this.f6571a.mo18562a();
//                            int a11 = this.f6571a.mo18562a();
//                            this.f6571a.mo18564a(89);
//                            this.f6571a.mo18568a(193, str5);
//                            this.f6571a.mo18565a(153, a11);
//                            this.f6571a.mo18568a(192, str5);
//                            this.f6571a.mo18564a(89);
//                            this.f6571a.mo18569a(180, str5, "_id", "I");
//                            this.f6571a.mo18583c(this.f6572b.mo19071b((ScriptNode) hVar.f6618a));
//                            this.f6571a.mo18565a(160, a11);
//                            this.f6571a.mo18593i((int) this.f6592v);
//                            this.f6571a.mo18593i((int) this.f6590t);
//                            if (i == 30) {
//                                this.f6571a.mo18564a(1);
//                            } else {
//                                this.f6571a.mo18593i((int) n);
//                            }
//                            for (Node cmVar4 = d; cmVar4 != null; cmVar4 = cmVar4.mo18942d()) {
//                                int h = m6564h(cmVar4);
//                                if (h >= 0) {
//                                    this.f6571a.mo18593i(h);
//                                    this.f6571a.mo18592h(h + 1);
//                                } else if (cmVar4.mo18924a(8, -1) == 0) {
//                                    this.f6571a.mo18569a(178, "java/lang/Void", Columns.TYPE, "Ljava/lang/Class;");
//                                    m6529a(cmVar4, cmVar3);
//                                } else {
//                                    m6529a(cmVar4, cmVar3);
//                                    this.f6571a.mo18563a(0.0d);
//                                }
//                            }
//                            this.f6571a.mo18569a(178, "org/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
//                            this.f6571a.mo18580b(184, this.f6572b.f6610b, i == 30 ? this.f6572b.mo19072c((ScriptNode) hVar.f6618a) : this.f6572b.mo19073d((ScriptNode) hVar.f6618a), this.f6572b.mo19074e(hVar.f6618a));
//                            this.f6571a.mo18565a(167, a10);
//                            this.f6571a.mo18595k(a11);
//                            this.f6571a.mo18593i((int) this.f6592v);
//                            this.f6571a.mo18593i((int) this.f6590t);
//                            if (i != 30) {
//                                this.f6571a.mo18593i((int) n);
//                                m6534a(n);
//                            }
//                            m6547c(cmVar3, d, true);
//                            if (i == 30) {
//                                m6523a("newObject", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
//                            } else {
//                                this.f6571a.mo18580b(185, "org/mozilla/javascript/Callable", "call", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
//                            }
//                            this.f6571a.mo18595k(a10);
//                            return;
//                        } else if (i == 38) {
//                            if (cmVar3.f6389a != 38) {
//                                throw C2189g.m6578a();
//                            }
//                            Node d2 = b.mo18942d();
//                            int i2 = b.f6389a;
//                            if (d2 == null) {
//                                if (i2 == 39) {
//                                    this.f6571a.mo18589e(((Name) b).f6130g);
//                                    str4 = "callName0";
//                                    str3 = "(Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
//                                } else if (i2 == 33) {
//                                    Node b2 = b.mo18930b();
//                                    m6529a(b2, cmVar3);
//                                    this.f6571a.mo18589e(((Name) b2.mo18942d()).f6130g);
//                                    str4 = "callProp0";
//                                    str3 = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
//                                } else if (i2 == 34) {
//                                    throw Kit.m5810a();
//                                } else {
//                                    m6539b(b, cmVar3);
//                                    str4 = "call0";
//                                    str3 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
//                                }
//                            } else if (i2 == 39) {
//                                String str6 = ((Name) b).f6130g;
//                                m6547c(cmVar3, d2, false);
//                                this.f6571a.mo18589e(str6);
//                                str4 = "callName";
//                                str3 = "([Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
//                            } else {
//                                int i3 = 0;
//                                for (Node cmVar5 = d2; cmVar5 != null; cmVar5 = cmVar5.mo18942d()) {
//                                    i3++;
//                                }
//                                m6539b(b, cmVar3);
//                                if (i3 == 1) {
//                                    m6529a(d2, cmVar3);
//                                    str4 = "call1";
//                                    str3 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
//                                } else if (i3 == 2) {
//                                    m6529a(d2, cmVar3);
//                                    m6529a(d2.mo18942d(), cmVar3);
//                                    str4 = "call2";
//                                    str3 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
//                                } else {
//                                    m6547c(cmVar3, d2, false);
//                                    str4 = "callN";
//                                    str3 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
//                                }
//                            }
//                            this.f6571a.mo18593i((int) this.f6592v);
//                            this.f6571a.mo18593i((int) this.f6590t);
//                        } else if (cmVar3.f6389a != 30) {
//                            throw C2189g.m6578a();
//                        } else {
//                            Node d3 = b.mo18942d();
//                            m6529a(b, cmVar3);
//                            this.f6571a.mo18593i((int) this.f6592v);
//                            this.f6571a.mo18593i((int) this.f6590t);
//                            m6547c(cmVar3, d3, false);
//                            m6523a("newObject", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
//                            return;
//                        }
//                    } else {
//                        this.f6571a.mo18593i((int) this.f6592v);
//                        if (i == 30) {
//                            m6529a(b, cmVar3);
//                        } else {
//                            m6539b(b, cmVar3);
//                        }
//                        m6547c(cmVar3, b.mo18942d(), false);
//                        if (i == 30) {
//                            str4 = "newObjectSpecial";
//                            str3 = "(Lorg/mozilla/javascript/Context;Ljava/lang/Object;[Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;";
//                            this.f6571a.mo18593i((int) this.f6590t);
//                            this.f6571a.mo18593i((int) this.f6595y);
//                            this.f6571a.mo18583c(a9);
//                        } else {
//                            String str7 = "callSpecial";
//                            String str8 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;ILjava/lang/String;I)Ljava/lang/Object;";
//                            this.f6571a.mo18593i((int) this.f6590t);
//                            this.f6571a.mo18593i((int) this.f6595y);
//                            this.f6571a.mo18583c(a9);
//                            String str9 = this.f6574d.f6148E;
//                            C2126c cVar = this.f6571a;
//                            if (str9 == null) {
//                                str9 = "";
//                            }
//                            cVar.mo18589e(str9);
//                            this.f6571a.mo18583c(this.f6582l);
//                            str3 = str8;
//                            str4 = str7;
//                        }
//                    }
//                    m6538b(str4, str3);
//                    return;
//                case 31:
//                    boolean z = b.f6389a == 49;
//                    m6529a(b, cmVar3);
//                    m6529a(b.mo18942d(), cmVar3);
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    this.f6571a.mo18575a(z);
//                    m6523a("delete", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Z)Ljava/lang/Object;");
//                    return;
//                case 32:
//                    m6529a(b, cmVar3);
//                    m6523a("typeof", "(Ljava/lang/Object;)Ljava/lang/String;");
//                    return;
//                case 33:
//                case 34:
//                    m6529a(b, cmVar3);
//                    Node d4 = b.mo18942d();
//                    m6529a(d4, cmVar3);
//                    if (cmVar3.f6389a == 34) {
//                        this.f6571a.mo18593i((int) this.f6592v);
//                        m6523a("getObjectPropNoWarn", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                        return;
//                    } else if (b.f6389a == 43 && d4.f6389a == 41) {
//                        this.f6571a.mo18593i((int) this.f6592v);
//                        m6523a("getObjectProp", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                        return;
//                    } else {
//                        this.f6571a.mo18593i((int) this.f6592v);
//                        this.f6571a.mo18593i((int) this.f6590t);
//                        m6523a("getObjectProp", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
//                        return;
//                    }
//                case 35:
//                case 139:
//                    m6529a(b, cmVar3);
//                    Node d5 = b.mo18942d();
//                    if (i == 139) {
//                        this.f6571a.mo18564a(89);
//                    }
//                    m6529a(d5, cmVar3);
//                    Node d6 = d5.mo18942d();
//                    if (i == 139) {
//                        this.f6571a.mo18564a(90);
//                        if (b.f6389a == 43 && d5.f6389a == 41) {
//                            this.f6571a.mo18593i((int) this.f6592v);
//                            m6523a("getObjectProp", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                        } else {
//                            this.f6571a.mo18593i((int) this.f6592v);
//                            m6523a("getObjectProp", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                        }
//                    }
//                    m6529a(d6, cmVar3);
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    m6523a("setObjectProp", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                    return;
//                case 36:
//                    m6529a(b, cmVar3);
//                    m6529a(b.mo18942d(), cmVar3);
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    if (cmVar3.mo18924a(8, -1) != -1) {
//                        m6523a("getObjectIndex", "(Ljava/lang/Object;DLorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                        return;
//                    }
//                    this.f6571a.mo18593i((int) this.f6590t);
//                    m6523a("getObjectElem", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
//                    return;
//                case 37:
//                case 140:
//                    m6529a(b, cmVar3);
//                    Node d7 = b.mo18942d();
//                    if (i == 140) {
//                        this.f6571a.mo18564a(89);
//                    }
//                    m6529a(d7, cmVar3);
//                    Node d8 = d7.mo18942d();
//                    boolean z2 = cmVar3.mo18924a(8, -1) != -1;
//                    if (i == 140) {
//                        if (z2) {
//                            this.f6571a.mo18564a(93);
//                            this.f6571a.mo18593i((int) this.f6592v);
//                            m6538b("getObjectIndex", "(Ljava/lang/Object;DLorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                        } else {
//                            this.f6571a.mo18564a(90);
//                            this.f6571a.mo18593i((int) this.f6592v);
//                            m6523a("getObjectElem", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                        }
//                    }
//                    m6529a(d8, cmVar3);
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    if (z2) {
//                        m6523a("setObjectIndex", "(Ljava/lang/Object;DLjava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                        return;
//                    } else {
//                        m6523a("setObjectElem", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                        return;
//                    }
//                case 39:
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    this.f6571a.mo18593i((int) this.f6590t);
//                    this.f6571a.mo18589e(((Name) cmVar3).f6130g);
//                    m6523a("name", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/Object;");
//                    return;
//                case 40:
//                    double d9 = ((NumberLiteral) cmVar3).f6133g;
//                    if (cmVar3.mo18924a(8, -1) != -1) {
//                        this.f6571a.mo18563a(d9);
//                        return;
//                    }
//                    C2189g gVar = this.f6572b;
//                    C2126c cVar2 = this.f6571a;
//                    if (d9 == 0.0d) {
//                        if (1.0d / d9 > 0.0d) {
//                            cVar2.mo18569a(178, "org/mozilla/javascript/optimizer/OptRuntime", "zeroObj", "Ljava/lang/Double;");
//                            return;
//                        }
//                        cVar2.mo18563a(d9);
//                        C2189g.m6582a(cVar2);
//                        return;
//                    } else if (d9 == 1.0d) {
//                        cVar2.mo18569a(178, "org/mozilla/javascript/optimizer/OptRuntime", "oneObj", "Ljava/lang/Double;");
//                        return;
//                    } else if (d9 == -1.0d) {
//                        cVar2.mo18569a(178, "org/mozilla/javascript/optimizer/OptRuntime", "minusOneObj", "Ljava/lang/Double;");
//                        return;
//                    } else if (d9 != d9) {
//                        cVar2.mo18569a(178, "org/mozilla/javascript/ScriptRuntime", "NaNobj", "Ljava/lang/Double;");
//                        return;
//                    } else if (gVar.f6613e >= 2000) {
//                        cVar2.mo18563a(d9);
//                        C2189g.m6582a(cVar2);
//                        return;
//                    } else {
//                        int i4 = gVar.f6613e;
//                        int i5 = 0;
//                        if (i4 == 0) {
//                            gVar.f6612d = new double[64];
//                        } else {
//                            double[] dArr = gVar.f6612d;
//                            while (i5 != i4 && dArr[i5] != d9) {
//                                i5++;
//                            }
//                            if (i4 == dArr.length) {
//                                double[] dArr2 = new double[(i4 * 2)];
//                                System.arraycopy(gVar.f6612d, 0, dArr2, 0, i4);
//                                gVar.f6612d = dArr2;
//                            }
//                        }
//                        if (i5 == i4) {
//                            gVar.f6612d[i4] = d9;
//                            gVar.f6613e = i4 + 1;
//                        }
//                        cVar2.mo18569a(178, gVar.f6610b, "_k" + i5, C2189g.m6580a(d9));
//                        return;
//                    }
//                case 41:
//                    this.f6571a.mo18589e(((Name) cmVar3).f6130g);
//                    return;
//                case 42:
//                    this.f6571a.mo18564a(1);
//                    return;
//                case 43:
//                    this.f6571a.mo18593i((int) this.f6595y);
//                    return;
//                case 44:
//                    this.f6571a.mo18569a(178, "java/lang/Boolean", "FALSE", "Ljava/lang/Boolean;");
//                    return;
//                case 45:
//                    this.f6571a.mo18569a(178, "java/lang/Boolean", "TRUE", "Ljava/lang/Boolean;");
//                    return;
//                case 48:
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    this.f6571a.mo18593i((int) this.f6590t);
//                    this.f6571a.mo18569a(178, this.f6572b.f6610b, this.f6572b.mo19070a(this.f6574d, cmVar3.mo18941d(4)), "Ljava/lang/Object;");
//                    this.f6571a.mo18580b(184, "org/mozilla/javascript/ScriptRuntime", "wrapRegExp", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
//                    return;
//                case 49:
//                    while (b != null) {
//                        m6529a(b, cmVar3);
//                        b = b.mo18942d();
//                    }
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    this.f6571a.mo18593i((int) this.f6590t);
//                    this.f6571a.mo18589e(((Name) cmVar3).f6130g);
//                    m6523a("bind", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Lorg/mozilla/javascript/Scriptable;");
//                    return;
//                case 54:
//                    this.f6571a.mo18593i(m6566i(cmVar3));
//                    return;
//                case 55:
//                    if (!this.f6583m) {
//                        Kit.m5810a();
//                    }
//                    int a12 = this.f6578h.mo19075a(cmVar3);
//                    short s = this.f6584n[a12];
//                    if (m6552d(a12)) {
//                        if (cmVar3.mo18924a(8, -1) != -1) {
//                            m6554e((int) s);
//                            return;
//                        } else {
//                            m6560f((int) s);
//                            return;
//                        }
//                    } else if (this.f6578h.mo19078b(a12)) {
//                        this.f6571a.mo18592h((int) s);
//                        return;
//                    } else {
//                        this.f6571a.mo18593i((int) s);
//                        return;
//                    }
//                case 56:
//                    m6551d(cmVar3, b, true);
//                    return;
//                case 61:
//                case 62:
//                    this.f6571a.mo18593i(m6566i(cmVar3));
//                    if (i == 61) {
//                        m6523a("enumNext", "(Ljava/lang/Object;)Ljava/lang/Boolean;");
//                        return;
//                    }
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    m6523a("enumId", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                    return;
//                case 63:
//                    this.f6571a.mo18564a(42);
//                    return;
//                case 65:
//                    m6531a(cmVar3, b, false);
//                    return;
//                case 66:
//                    m6541b(cmVar3, b, false);
//                    return;
//                case 67:
//                    m6529a(b, cmVar3);
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    m6523a("refGet", "(Lorg/mozilla/javascript/Ref;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                    return;
//                case 68:
//                case 142:
//                    m6529a(b, cmVar3);
//                    Node d10 = b.mo18942d();
//                    if (i == 142) {
//                        this.f6571a.mo18564a(89);
//                        this.f6571a.mo18593i((int) this.f6592v);
//                        m6523a("refGet", "(Lorg/mozilla/javascript/Ref;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                    }
//                    m6529a(d10, cmVar3);
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    m6523a("refSet", "(Lorg/mozilla/javascript/Ref;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                    return;
//                case 69:
//                    m6529a(b, cmVar3);
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    m6523a("refDel", "(Lorg/mozilla/javascript/Ref;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                    return;
//                case 70:
//                    m6539b(b, cmVar3);
//                    m6547c(cmVar3, b.mo18942d(), false);
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    m6523a("callRef", "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Ref;");
//                    return;
//                case 71:
//                    String str10 = (String) cmVar3.mo18937c(17);
//                    m6529a(b, cmVar3);
//                    this.f6571a.mo18589e(str10);
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    m6523a("specialRef", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Ref;");
//                    return;
//                case 72:
//                    m6532a(cmVar3, true);
//                    return;
//                case 73:
//                    m6550d(cmVar3, b);
//                    return;
//                case 74:
//                    m6529a(b, cmVar3);
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    m6523a("setDefaultNamespace", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
//                    return;
//                case 75:
//                    m6529a(b, cmVar3);
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    m6523a("escapeAttributeValue", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/String;");
//                    return;
//                case 76:
//                    m6529a(b, cmVar3);
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    m6523a("escapeTextValue", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/String;");
//                    return;
//                case 77:
//                case 78:
//                case 79:
//                case 80:
//                    int a13 = cmVar3.mo18924a(16, 0);
//                    do {
//                        m6529a(b, cmVar3);
//                        b = b.mo18942d();
//                    } while (b != null);
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    switch (i) {
//                        case 77:
//                            str = "memberRef";
//                            str2 = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;I)Lorg/mozilla/javascript/Ref;";
//                            break;
//                        case 78:
//                            str = "memberRef";
//                            str2 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;I)Lorg/mozilla/javascript/Ref;";
//                            break;
//                        case 79:
//                            str = "nameRef";
//                            str2 = "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Lorg/mozilla/javascript/Ref;";
//                            this.f6571a.mo18593i((int) this.f6590t);
//                            break;
//                        case 80:
//                            str = "nameRef";
//                            str2 = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Lorg/mozilla/javascript/Ref;";
//                            this.f6571a.mo18593i((int) this.f6590t);
//                            break;
//                        default:
//                            throw Kit.m5810a();
//                    }
//                    this.f6571a.mo18583c(a13);
//                    m6523a(str, str2);
//                    return;
//                case 89:
//                    cmVar = b;
//                    for (Node d11 = b.mo18942d(); d11 != null; d11 = d11.mo18942d()) {
//                        m6529a(cmVar, cmVar3);
//                        this.f6571a.mo18564a(87);
//                        cmVar = d11;
//                    }
//                    cmVar2 = cmVar3;
//                    break;
//                case 102:
//                    Node d12 = b.mo18942d();
//                    Node d13 = d12.mo18942d();
//                    m6529a(b, cmVar3);
//                    m6523a("toBoolean", "(Ljava/lang/Object;)Z");
//                    int a14 = this.f6571a.mo18562a();
//                    this.f6571a.mo18565a(153, a14);
//                    short s2 = this.f6571a.f5919d;
//                    m6529a(d12, cmVar3);
//                    int a15 = this.f6571a.mo18562a();
//                    this.f6571a.mo18565a(167, a15);
//                    this.f6571a.mo18570a(a14, s2);
//                    m6529a(d13, cmVar3);
//                    this.f6571a.mo18595k(a15);
//                    return;
//                case 104:
//                case 105:
//                    m6529a(b, cmVar3);
//                    this.f6571a.mo18564a(89);
//                    m6523a("toBoolean", "(Ljava/lang/Object;)Z");
//                    int a16 = this.f6571a.mo18562a();
//                    if (i == 105) {
//                        this.f6571a.mo18565a(153, a16);
//                    } else {
//                        this.f6571a.mo18565a(154, a16);
//                    }
//                    this.f6571a.mo18564a(87);
//                    m6529a(b.mo18942d(), cmVar3);
//                    this.f6571a.mo18595k(a16);
//                    return;
//                case 106:
//                case 107:
//                    int d14 = cmVar3.mo18941d(13);
//                    Node b3 = cmVar3.mo18930b();
//                    switch (b3.f6389a) {
//                        case 33:
//                            Node b4 = b3.mo18930b();
//                            m6529a(b4, cmVar3);
//                            m6529a(b4.mo18942d(), cmVar3);
//                            this.f6571a.mo18593i((int) this.f6592v);
//                            this.f6571a.mo18583c(d14);
//                            m6523a("propIncrDecr", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;I)Ljava/lang/Object;");
//                            return;
//                        case 34:
//                            throw Kit.m5810a();
//                        case 36:
//                            Node b5 = b3.mo18930b();
//                            m6529a(b5, cmVar3);
//                            m6529a(b5.mo18942d(), cmVar3);
//                            this.f6571a.mo18593i((int) this.f6592v);
//                            this.f6571a.mo18583c(d14);
//                            if (b5.mo18942d().mo18924a(8, -1) != -1) {
//                                m6538b("elemIncrDecr", "(Ljava/lang/Object;DLorg/mozilla/javascript/Context;I)Ljava/lang/Object;");
//                                return;
//                            } else {
//                                m6523a("elemIncrDecr", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;I)Ljava/lang/Object;");
//                                return;
//                            }
//                        case 39:
//                            this.f6571a.mo18593i((int) this.f6590t);
//                            this.f6571a.mo18589e(((Name) b3).f6130g);
//                            this.f6571a.mo18593i((int) this.f6592v);
//                            this.f6571a.mo18583c(d14);
//                            m6523a("nameIncrDecr", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;I)Ljava/lang/Object;");
//                            return;
//                        case 55:
//                            if (!this.f6583m) {
//                                Kit.m5810a();
//                            }
//                            boolean z3 = (d14 & 2) != 0;
//                            int a17 = this.f6578h.mo19075a(b3);
//                            short s3 = this.f6584n[a17];
//                            if (cmVar3.mo18924a(8, -1) != -1) {
//                                short s4 = m6552d(a17) ? (short) 1 : 0;
//                                this.f6571a.mo18592h(s3 + s4);
//                                if (z3) {
//                                    this.f6571a.mo18564a(92);
//                                }
//                                this.f6571a.mo18563a(1.0d);
//                                if ((d14 & 1) == 0) {
//                                    this.f6571a.mo18564a(99);
//                                } else {
//                                    this.f6571a.mo18564a(103);
//                                }
//                                if (!z3) {
//                                    this.f6571a.mo18564a(92);
//                                }
//                                this.f6571a.mo18588e(s4 + s3);
//                                return;
//                            }
//                            if (m6552d(a17)) {
//                                m6560f((int) s3);
//                            } else {
//                                this.f6571a.mo18593i((int) s3);
//                            }
//                            if (z3) {
//                                this.f6571a.mo18564a(89);
//                            }
//                            m6570l();
//                            this.f6571a.mo18563a(1.0d);
//                            if ((d14 & 1) == 0) {
//                                this.f6571a.mo18564a(99);
//                            } else {
//                                this.f6571a.mo18564a(103);
//                            }
//                            m6571m();
//                            if (!z3) {
//                                this.f6571a.mo18564a(89);
//                            }
//                            this.f6571a.mo18590f((int) s3);
//                            return;
//                        case 67:
//                            m6529a(b3.mo18930b(), cmVar3);
//                            this.f6571a.mo18593i((int) this.f6592v);
//                            this.f6571a.mo18583c(d14);
//                            m6523a("refIncrDecr", "(Lorg/mozilla/javascript/Ref;Lorg/mozilla/javascript/Context;I)Ljava/lang/Object;");
//                            return;
//                        default:
//                            C2189g.m6578a();
//                            return;
//                    }
//                case 109:
//                    if (this.f6578h != null || cmVar2.f6389a != 136) {
//                        OptFunctionNode a18 = OptFunctionNode.m6606a(this.f6574d, cmVar3.mo18941d(1));
//                        int i6 = a18.f6618a.f6260q;
//                        if (i6 != 2) {
//                            throw C2189g.m6578a();
//                        }
//                        m6533a(a18, i6);
//                        return;
//                    }
//                    return;
//                case 126:
//                    m6529a(b, cmVar3);
//                    this.f6571a.mo18564a(87);
//                    C2189g.m6589b(this.f6571a);
//                    return;
//                case 137:
//                    if (this.f6583m) {
//                        int f = this.f6578h.f6618a.mo18761f(cmVar3);
//                        if (f >= 0) {
//                            if (this.f6578h.mo19078b(f)) {
//                                this.f6571a.mo18589e("number");
//                                return;
//                            } else if (m6552d(f)) {
//                                short s5 = this.f6584n[f];
//                                this.f6571a.mo18593i((int) s5);
//                                this.f6571a.mo18569a(178, "java/lang/Void", Columns.TYPE, "Ljava/lang/Class;");
//                                int a19 = this.f6571a.mo18562a();
//                                this.f6571a.mo18565a(165, a19);
//                                short s6 = this.f6571a.f5919d;
//                                this.f6571a.mo18593i((int) s5);
//                                m6523a("typeof", "(Ljava/lang/Object;)Ljava/lang/String;");
//                                int a20 = this.f6571a.mo18562a();
//                                this.f6571a.mo18565a(167, a20);
//                                this.f6571a.mo18570a(a19, s6);
//                                this.f6571a.mo18589e("number");
//                                this.f6571a.mo18595k(a20);
//                                return;
//                            } else {
//                                this.f6571a.mo18593i((int) this.f6584n[f]);
//                                m6523a("typeof", "(Ljava/lang/Object;)Ljava/lang/String;");
//                                return;
//                            }
//                        }
//                    }
//                    this.f6571a.mo18593i((int) this.f6590t);
//                    this.f6571a.mo18589e(((Name) cmVar3).f6130g);
//                    m6523a("typeofName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/String;");
//                    return;
//                case 138:
//                    return;
//                case 146:
//                    m6555e(cmVar3);
//                    m6529a(b, cmVar3);
//                    this.f6571a.mo18593i((int) this.f6590t);
//                    m6523a("enterDotQuery", "(Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
//                    this.f6571a.mo18590f((int) this.f6590t);
//                    this.f6571a.mo18564a(1);
//                    int a21 = this.f6571a.mo18562a();
//                    this.f6571a.mo18595k(a21);
//                    this.f6571a.mo18564a(87);
//                    m6529a(b.mo18942d(), cmVar3);
//                    m6523a("toBoolean", "(Ljava/lang/Object;)Z");
//                    this.f6571a.mo18593i((int) this.f6590t);
//                    m6523a("updateDotQuery", "(ZLorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
//                    this.f6571a.mo18564a(89);
//                    this.f6571a.mo18565a(198, a21);
//                    this.f6571a.mo18593i((int) this.f6590t);
//                    m6523a("leaveDotQuery", "(Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
//                    this.f6571a.mo18590f((int) this.f6590t);
//                    return;
//                case 149:
//                    int i7 = -1;
//                    if (b.f6389a == 40) {
//                        i7 = b.mo18924a(8, -1);
//                    }
//                    if (i7 != -1) {
//                        b.mo18932b(8);
//                        m6529a(b, cmVar3);
//                        b.mo18933b(8, i7);
//                        return;
//                    }
//                    m6529a(b, cmVar3);
//                    m6571m();
//                    return;
//                case 150:
//                    m6529a(b, cmVar3);
//                    m6570l();
//                    return;
//                case 155:
//                    m6556e(cmVar3, b);
//                    return;
//                case 156:
//                    m6557e(cmVar3, b, true);
//                    return;
//                case 157:
//                    cmVar = b.mo18942d();
//                    m6525a(b);
//                    cmVar2 = cmVar3;
//                    break;
//                case 159:
//                    Node d15 = b.mo18942d();
//                    Node d16 = d15.mo18942d();
//                    m6525a(b);
//                    m6529a(d15.mo18930b(), d15);
//                    m6525a(d16);
//                    return;
//                default:
//                    throw new RuntimeException("Unexpected node type " + i);
//            }
//        }
    }

    /* renamed from: a */
    private void m6532a(Node cmVar, boolean z) {
        int i;
        boolean z2;
//        int i2 = this.f6571a.f5919d;
//        if (this.f6568G > i2) {
//            i = this.f6568G;
//        } else {
//            i = i2;
//        }
//        this.f6568G = i;
//        if (this.f6571a.f5919d != 0) {
//            m6553e();
//            for (int i3 = 0; i3 < i2; i3++) {
//                this.f6571a.mo18564a(90);
//                this.f6571a.mo18564a(95);
//                this.f6571a.mo18578b(i3);
//                this.f6571a.mo18564a(95);
//                this.f6571a.mo18564a(83);
//            }
//            this.f6571a.mo18564a(87);
//        }
//        Node b = cmVar.mo18930b();
//        if (b != null) {
//            m6529a(b, cmVar);
//        } else {
//            C2189g.m6589b(this.f6571a);
//        }
//        int b2 = m6535b(cmVar);
//        m6537b(b2);
//        int i4 = 0;
//        for (int i5 = 0; i5 < this.f6580j; i5++) {
//            if (this.f6579i[i5] != 0) {
//                i4++;
//            }
//        }
//        if (i4 == 0) {
//            ((FunctionNode) this.f6574d).mo18827a(cmVar, null);
//            z2 = false;
//        } else {
//            this.f6567F = this.f6567F > i4 ? this.f6567F : i4;
//            int[] iArr = new int[i4];
//            int i6 = 0;
//            for (int i7 = 0; i7 < this.f6580j; i7++) {
//                if (this.f6579i[i7] != 0) {
//                    iArr[i6] = i7;
//                    i6++;
//                }
//            }
//            ((FunctionNode) this.f6574d).mo18827a(cmVar, iArr);
//            m6561g();
//            for (int i8 = 0; i8 < i4; i8++) {
//                this.f6571a.mo18564a(89);
//                this.f6571a.mo18578b(i8);
//                this.f6571a.mo18593i(iArr[i8]);
//                this.f6571a.mo18564a(83);
//            }
//            this.f6571a.mo18564a(87);
//            z2 = true;
//        }
//        this.f6571a.mo18564a(176);
//        m6522a(m6542c(cmVar), z2, b2);
//        if (i2 != 0) {
//            m6553e();
//            for (int i9 = 0; i9 < i2; i9++) {
//                this.f6571a.mo18564a(89);
//                this.f6571a.mo18578b((i2 - i9) - 1);
//                this.f6571a.mo18564a(50);
//                this.f6571a.mo18564a(95);
//            }
//            this.f6571a.mo18564a(87);
//        }
//        if (z) {
//            this.f6571a.mo18593i((int) this.f6593w);
//        }
    }

    /* renamed from: a */
    private void m6522a(int i, boolean z, int i2) {
//        int a = this.f6571a.mo18562a();
//        int a2 = this.f6571a.mo18562a();
//        this.f6571a.mo18595k(a);
//        this.f6571a.mo18593i((int) this.f6593w);
//        m6567i();
//        this.f6571a.mo18595k(a2);
//        this.f6571a.mo18593i((int) this.f6593w);
//        this.f6571a.mo18568a(192, "java/lang/Throwable");
//        this.f6571a.mo18564a(191);
//        if (i != -1) {
//            this.f6571a.mo18595k(i);
//        }
//        if (!z) {
//            this.f6571a.mo18584c(this.f6566E, i2);
//        }
//        this.f6571a.mo18591g((int) this.f6594x);
//        this.f6571a.mo18578b(2);
//        this.f6571a.mo18565a(159, a2);
//        this.f6571a.mo18591g((int) this.f6594x);
//        this.f6571a.mo18578b(1);
//        this.f6571a.mo18565a(159, a);
    }

    /* renamed from: a */
    private void m6530a(Node cmVar, Node cmVar2, int i, int i2) {
        int i3 = i;
        Node cmVar3 = cmVar;
//        while (true) {
//            int i4 = cmVar3.f6389a;
//            Node b = cmVar3.mo18930b();
//            switch (i4) {
//                case 12:
//                case 13:
//                case 46:
//                case 47:
//                    m6546c(cmVar3, b, i3, i2);
//                    return;
//                case 14:
//                case 15:
//                case 16:
//                case 17:
//                case 52:
//                case 53:
//                    m6540b(cmVar3, b, i3, i2);
//                    return;
//                case 26:
//                    cmVar2 = cmVar3;
//                    cmVar3 = b;
//                    int i5 = i3;
//                    i3 = i2;
//                    i2 = i5;
//                    break;
//                case 104:
//                case 105:
//                    int a = this.f6571a.mo18562a();
//                    if (i4 == 105) {
//                        m6530a(b, cmVar3, a, i2);
//                    } else {
//                        m6530a(b, cmVar3, i3, a);
//                    }
//                    this.f6571a.mo18595k(a);
//                    cmVar2 = cmVar3;
//                    cmVar3 = b.mo18942d();
//                    break;
//                default:
//                    m6529a(cmVar3, cmVar2);
//                    m6523a("toBoolean", "(Ljava/lang/Object;)Z");
//                    this.f6571a.mo18565a(154, i3);
//                    this.f6571a.mo18565a(167, i2);
//                    return;
//            }
//        }
    }

    /* renamed from: a */
    private void m6533a(OptFunctionNode hVar, int i) {
//        int b = this.f6572b.mo19071b((ScriptNode) hVar.f6618a);
//        this.f6571a.mo18568a(187, this.f6572b.f6610b);
//        this.f6571a.mo18564a(89);
//        this.f6571a.mo18593i((int) this.f6590t);
//        this.f6571a.mo18593i((int) this.f6592v);
//        this.f6571a.mo18583c(b);
//        this.f6571a.mo18580b(183, this.f6572b.f6610b, "<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V");
//        if (i != 2) {
//            this.f6571a.mo18583c(i);
//            this.f6571a.mo18593i((int) this.f6590t);
//            this.f6571a.mo18593i((int) this.f6592v);
//            m6538b("initFunction", "(Lorg/mozilla/javascript/NativeFunction;ILorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;)V");
//        }
    }

    /* renamed from: c */
    private int m6542c(Node cmVar) {
        int i = cmVar.mo18948i();
        if (i != -1) {
            return i;
        }
//        int a = this.f6571a.mo18562a();
//        cmVar.mo18946e(a);
//        return a;
        return -1;
    }

    /* renamed from: d */
    private void m6549d(Node cmVar) {
//        C2188f fVar = (C2188f) this.f6569H.get(cmVar);
//        this.f6571a.mo18578b(fVar.f6605a.size());
//        m6526a(cmVar, 167);
//        int a = this.f6571a.mo18562a();
//        this.f6571a.mo18595k(a);
//        fVar.f6605a.add(Integer.valueOf(a));
    }

    /* renamed from: a */
    private void m6531a(Node cmVar, Node cmVar2, boolean z) {
//        int i = 0;
//        for (Node cmVar3 = cmVar2; cmVar3 != null; cmVar3 = cmVar3.mo18942d()) {
//            i++;
//        }
//        if (z || ((i <= 10 && this.f6571a.f5917b <= 30000) || this.f6583m || this.f6565D || this.f6589s)) {
//            m6562g(i);
//            for (int i2 = 0; i2 != i; i2++) {
//                this.f6571a.mo18564a(89);
//                this.f6571a.mo18583c(i2);
//                m6529a(cmVar2, cmVar);
//                this.f6571a.mo18564a(83);
//                cmVar2 = cmVar2.mo18942d();
//            }
//            int[] iArr = (int[]) cmVar.mo18937c(11);
//            if (iArr == null) {
//                this.f6571a.mo18564a(1);
//                this.f6571a.mo18564a(3);
//            } else {
//                this.f6571a.mo18589e(OptRuntime.m6611a(iArr));
//                this.f6571a.mo18583c(iArr.length);
//            }
//            this.f6571a.mo18593i((int) this.f6592v);
//            this.f6571a.mo18593i((int) this.f6590t);
//            m6538b("newArrayLiteral", "([Ljava/lang/Object;Ljava/lang/String;ILorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
//            return;
//        }
//        if (this.f6570I == null) {
//            this.f6570I = new LinkedList();
//        }
//        this.f6570I.add(cmVar);
//        String str = this.f6572b.mo19073d(this.f6574d) + "_literal" + this.f6570I.size();
//        this.f6571a.mo18593i((int) this.f6596z);
//        this.f6571a.mo18593i((int) this.f6592v);
//        this.f6571a.mo18593i((int) this.f6590t);
//        this.f6571a.mo18593i((int) this.f6595y);
//        this.f6571a.mo18593i((int) this.f6593w);
//        this.f6571a.mo18580b(182, this.f6572b.f6610b, str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
    }

    /* renamed from: b */
    private void m6541b(Node cmVar, Node cmVar2, boolean z) {
        boolean z2;
//        Object[] objArr = (Object[]) cmVar.mo18937c(12);
//        int length = objArr.length;
//        if (z || ((length <= 10 && this.f6571a.f5917b <= 30000) || this.f6583m || this.f6565D || this.f6589s)) {
//            m6562g(length);
//            for (int i = 0; i != length; i++) {
//                this.f6571a.mo18564a(89);
//                this.f6571a.mo18583c(i);
//                Object obj = objArr[i];
//                if (obj instanceof String) {
//                    this.f6571a.mo18589e((String) obj);
//                } else {
//                    this.f6571a.mo18583c(((Integer) obj).intValue());
//                    m6523a("wrapInt", "(I)Ljava/lang/Integer;");
//                }
//                this.f6571a.mo18564a(83);
//            }
//            m6562g(length);
//            Node cmVar3 = cmVar2;
//            for (int i2 = 0; i2 != length; i2++) {
//                this.f6571a.mo18564a(89);
//                this.f6571a.mo18583c(i2);
//                int i3 = cmVar3.f6389a;
//                if (i3 == 151 || i3 == 152) {
//                    m6529a(cmVar3.mo18930b(), cmVar);
//                } else {
//                    m6529a(cmVar3, cmVar);
//                }
//                this.f6571a.mo18564a(83);
//                cmVar3 = cmVar3.mo18942d();
//            }
//            int i4 = 0;
//            Node cmVar4 = cmVar2;
//            while (true) {
//                if (i4 == length) {
//                    z2 = false;
//                    break;
//                }
//                int i5 = cmVar4.f6389a;
//                if (i5 == 151 || i5 == 152) {
//                    z2 = true;
//                } else {
//                    cmVar4 = cmVar4.mo18942d();
//                    i4++;
//                }
//            }
//            z2 = true;
//            if (z2) {
//                this.f6571a.mo18583c(length);
//                this.f6571a.mo18565a(188, 10);
//                for (int i6 = 0; i6 != length; i6++) {
//                    this.f6571a.mo18564a(89);
//                    this.f6571a.mo18583c(i6);
//                    int i7 = cmVar2.f6389a;
//                    if (i7 == 151) {
//                        this.f6571a.mo18564a(2);
//                    } else if (i7 == 152) {
//                        this.f6571a.mo18564a(4);
//                    } else {
//                        this.f6571a.mo18564a(3);
//                    }
//                    this.f6571a.mo18564a(79);
//                    cmVar2 = cmVar2.mo18942d();
//                }
//            } else {
//                this.f6571a.mo18564a(1);
//            }
//            this.f6571a.mo18593i((int) this.f6592v);
//            this.f6571a.mo18593i((int) this.f6590t);
//            m6523a("newObjectLiteral", "([Ljava/lang/Object;[Ljava/lang/Object;[ILorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
//            return;
//        }
//        if (this.f6570I == null) {
//            this.f6570I = new LinkedList();
//        }
//        this.f6570I.add(cmVar);
//        String str = this.f6572b.mo19073d(this.f6574d) + "_literal" + this.f6570I.size();
//        this.f6571a.mo18593i((int) this.f6596z);
//        this.f6571a.mo18593i((int) this.f6592v);
//        this.f6571a.mo18593i((int) this.f6590t);
//        this.f6571a.mo18593i((int) this.f6595y);
//        this.f6571a.mo18593i((int) this.f6593w);
//        this.f6571a.mo18580b(182, this.f6572b.f6610b, str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
    }

    /* renamed from: c */
    private void m6547c(Node cmVar, Node cmVar2, boolean z) {
//        int i = 0;
//        for (Node cmVar3 = cmVar2; cmVar3 != null; cmVar3 = cmVar3.mo18942d()) {
//            i++;
//        }
//        if (i != 1 || this.f6563B < 0) {
//            m6562g(i);
//        } else {
//            this.f6571a.mo18593i((int) this.f6563B);
//        }
//        for (int i2 = 0; i2 != i; i2++) {
//            if (!this.f6565D) {
//                this.f6571a.mo18564a(89);
//                this.f6571a.mo18583c(i2);
//            }
//            if (!z) {
//                m6529a(cmVar2, cmVar);
//            } else {
//                int h = m6564h(cmVar2);
//                if (h >= 0) {
//                    m6560f(h);
//                } else {
//                    m6529a(cmVar2, cmVar);
//                    if (cmVar2.mo18924a(8, -1) == 0) {
//                        m6571m();
//                    }
//                }
//            }
//            if (this.f6565D) {
//                short n = m6572n();
//                this.f6571a.mo18590f((int) n);
//                this.f6571a.mo18568a(192, "[Ljava/lang/Object;");
//                this.f6571a.mo18564a(89);
//                this.f6571a.mo18583c(i2);
//                this.f6571a.mo18593i((int) n);
//                m6534a(n);
//            }
//            this.f6571a.mo18564a(83);
//            cmVar2 = cmVar2.mo18942d();
//        }
    }

    /* renamed from: b */
    private void m6539b(Node cmVar, Node cmVar2) {
        int i = cmVar.f6389a;
//        switch (cmVar.f6389a) {
//            case 33:
//            case 36:
//                Node b = cmVar.mo18930b();
//                m6529a(b, cmVar);
//                Node d = b.mo18942d();
//                if (i != 33) {
//                    if (cmVar.mo18924a(8, -1) == -1) {
//                        m6529a(d, cmVar);
//                        this.f6571a.mo18593i((int) this.f6592v);
//                        m6523a("getElemFunctionAndThis", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Callable;");
//                        break;
//                    } else {
//                        throw C2189g.m6578a();
//                    }
//                } else {
//                    this.f6571a.mo18589e(((Name) d).f6130g);
//                    this.f6571a.mo18593i((int) this.f6592v);
//                    this.f6571a.mo18593i((int) this.f6590t);
//                    m6523a("getPropFunctionAndThis", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;");
//                    break;
//                }
//            case 34:
//                throw Kit.m5810a();
//            case 39:
//                this.f6571a.mo18589e(((Name) cmVar).f6130g);
//                this.f6571a.mo18593i((int) this.f6592v);
//                this.f6571a.mo18593i((int) this.f6590t);
//                m6523a("getNameFunctionAndThis", "(Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;");
//                break;
//            default:
//                m6529a(cmVar, cmVar2);
//                this.f6571a.mo18593i((int) this.f6592v);
//                m6523a("getValueFunctionAndThis", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Callable;");
//                break;
//        }
//        this.f6571a.mo18593i((int) this.f6592v);
        m6523a("lastStoredScriptable", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Scriptable;");
    }

    /* renamed from: e */
    private void m6555e(Node cmVar) {
        this.f6582l = cmVar.mo18794f();
        if (this.f6582l != -1) {
//            this.f6571a.mo18582b((short) this.f6582l);
        }
    }

    /* renamed from: a */
    private void m6521a(int i, short s, int i2, int i3, int i4) {
//        if (i4 == 0) {
//            i4 = this.f6571a.mo18562a();
//        }
//        this.f6571a.mo18596l(i4);
//        this.f6571a.mo18590f(i3);
//        this.f6571a.mo18593i((int) s);
//        this.f6571a.mo18590f((int) this.f6590t);
//        m6517a(i);
//        this.f6571a.mo18565a(167, i2);
    }

    /* renamed from: a */
    static String m6517a(int i) {
        if (i == 0) {
            return "org/mozilla/javascript/JavaScriptException";
        }
        if (i == 1) {
            return "org/mozilla/javascript/EvaluatorException";
        }
        if (i == 2) {
            return "org/mozilla/javascript/EcmaError";
        }
        if (i == 3) {
            return "java/lang/Throwable";
        }
        if (i == 4) {
            return null;
        }
        throw Kit.m5810a();
    }

    /* renamed from: a */
    private void m6527a(Node cmVar, int i, int i2) {
        Node f = m6558f(cmVar);
        f.mo18951l();
        Node b = f.mo18930b();
        C2186d dVar = this.f6576f;
        ListIterator listIterator = dVar.f6597a.listIterator(dVar.f6597a.size());
        while (listIterator.hasPrevious()) {
            C2187e eVar = (C2187e) listIterator.previous();
            for (int i3 = 0; i3 < 5; i3++) {
                if (eVar.f6601c[i3] != 0 && eVar.f6603e == null) {
                    dVar.mo19069a(eVar, i3, i);
                    eVar.f6602d[i3] = 0;
                    eVar.f6603e = f;
                }
            }
            if (eVar.f6600b == f) {
                break;
            }
        }
        for (Node cmVar2 = b; cmVar2 != null; cmVar2 = cmVar2.mo18942d()) {
            m6525a(cmVar2);
        }
        C2186d dVar2 = this.f6576f;
        ListIterator listIterator2 = dVar2.f6597a.listIterator(dVar2.f6597a.size());
        while (listIterator2.hasPrevious()) {
            C2187e eVar2 = (C2187e) listIterator2.previous();
            for (int i4 = 0; i4 < 5; i4++) {
                if (eVar2.f6601c[i4] != 0 && eVar2.f6603e == f) {
                    eVar2.f6602d[i4] = i2;
                    eVar2.f6603e = null;
                }
            }
            if (eVar2.f6600b == f) {
                return;
            }
        }
    }

    /* renamed from: f */
    private static Node m6558f(Node cmVar) {
        if (cmVar == null) {
            return null;
        }
        if (cmVar.f6389a == 125) {
            return cmVar;
        }
        if (cmVar != null && cmVar.f6389a == 131) {
            Node d = cmVar.mo18942d();
            if (d != null && d.f6389a == 125) {
                return d;
            }
        }
        throw Kit.m5814b("bad finally target");
    }

    /* renamed from: a */
    private void m6524a(Jump aeVar, Node cmVar) {
        m6529a(cmVar, (Node) aeVar);
        short n = m6572n();
//        this.f6571a.mo18590f((int) n);
//        for (Jump aeVar2 = (Jump) cmVar.mo18942d(); aeVar2 != null; aeVar2 = (Jump) aeVar2.mo18942d()) {
//            if (aeVar2.f6389a != 115) {
//                throw C2189g.m6578a();
//            }
//            m6529a(aeVar2.mo18930b(), (Node) aeVar2);
//            this.f6571a.mo18593i((int) n);
//            m6523a("shallowEq", "(Ljava/lang/Object;Ljava/lang/Object;)Z");
//            m6526a(aeVar2.f6117w, 154);
//        }
        m6534a(n);
    }

    /* renamed from: j */
    private void m6568j() {
//        this.f6577g = this.f6571a.f5917b;
    }

    /* renamed from: k */
    private void m6569k() {

//        m6544c(Math.max(this.f6571a.f5917b - this.f6577g, 1));
    }

    /* renamed from: c */
    private void m6544c(int i) {
//        this.f6571a.mo18593i((int) this.f6592v);
//        this.f6571a.mo18583c(i);
        m6523a("addInstructionCount", "(Lorg/mozilla/javascript/Context;I)V");
    }

    /* renamed from: g */
    private static boolean m6563g(Node cmVar) {
        int i = cmVar.f6389a;
        return i == 22 || i == 25 || i == 24 || i == 23;
    }

    /* renamed from: a */
    private void m6528a(Node cmVar, int i, Node cmVar2, Node cmVar3) {
        if (cmVar.mo18924a(8, -1) != -1) {
            m6529a(cmVar2, cmVar);
            m6529a(cmVar2.mo18942d(), cmVar);
//            this.f6571a.mo18564a(i);
            return;
        }
        boolean g = m6563g(cmVar3);
        m6529a(cmVar2, cmVar);
        if (!m6563g(cmVar2)) {
            m6570l();
        }
        m6529a(cmVar2.mo18942d(), cmVar);
        if (!m6563g(cmVar2.mo18942d())) {
            m6570l();
        }
//        this.f6571a.mo18564a(i);
        if (!g) {
            m6571m();
        }
    }

    /* renamed from: h */
    private int m6564h(Node cmVar) {
        if (cmVar.f6389a == 55 && this.f6585o && !this.f6586p) {
            int a = this.f6578h.mo19075a(cmVar);
            if (this.f6578h.mo19077a(a)) {
                return this.f6584n[a];
            }
        }
        return -1;
    }

    /* renamed from: d */
    private boolean m6552d(int i) {
        return this.f6578h.mo19077a(i) && this.f6585o && !this.f6586p;
    }

    /* renamed from: a */
    private void m6520a(int i, int i2, int i3) {
        if (i2 == -1) {
            throw C2189g.m6578a();
        }
//        switch (i) {
//            case 14:
//                this.f6571a.mo18564a(152);
//                this.f6571a.mo18565a(155, i2);
//                break;
//            case 15:
//                this.f6571a.mo18564a(152);
//                this.f6571a.mo18565a(158, i2);
//                break;
//            case 16:
//                this.f6571a.mo18564a(151);
//                this.f6571a.mo18565a(157, i2);
//                break;
//            case 17:
//                this.f6571a.mo18564a(151);
//                this.f6571a.mo18565a(156, i2);
//                break;
//            default:
//                throw C2189g.m6578a();
//        }
        if (i3 != -1) {
//            this.f6571a.mo18565a(167, i3);
        }
    }

    /* renamed from: b */
    private void m6540b(Node cmVar, Node cmVar2, int i, int i2) {
        if (i == -1 || i2 == -1) {
            throw C2189g.m6578a();
        }
        int i3 = cmVar.f6389a;
        Node d = cmVar2.mo18942d();
        if (i3 == 53 || i3 == 52) {
            m6529a(cmVar2, cmVar);
            m6529a(d, cmVar);
//            this.f6571a.mo18593i((int) this.f6592v);
//            m6523a(i3 == 53 ? "instanceOf" : "in", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Z");
//            this.f6571a.mo18565a(154, i);
//            this.f6571a.mo18565a(167, i2);
            return;
        }
        int a = cmVar.mo18924a(8, -1);
        int h = m6564h(cmVar2);
        int h2 = m6564h(d);
        if (a != -1) {
            if (a != 2) {
                m6529a(cmVar2, cmVar);
            } else if (h != -1) {
                m6554e(h);
            } else {
                m6529a(cmVar2, cmVar);
                m6570l();
            }
            if (a != 1) {
                m6529a(d, cmVar);
            } else if (h2 != -1) {
                m6554e(h2);
            } else {
                m6529a(d, cmVar);
                m6570l();
            }
            m6520a(i3, i, i2);
            return;
        }
        if (h == -1 || h2 == -1) {
            m6529a(cmVar2, cmVar);
            m6529a(d, cmVar);
        } else {
//            short s = this.f6571a.f5919d;
//            int a2 = this.f6571a.mo18562a();
//            this.f6571a.mo18593i(h);
//            this.f6571a.mo18569a(178, "java/lang/Void", Columns.TYPE, "Ljava/lang/Class;");
//            this.f6571a.mo18565a(166, a2);
//            this.f6571a.mo18592h(h + 1);
//            m6554e(h2);
//            m6520a(i3, i, i2);
//            if (s != this.f6571a.f5919d) {
//                throw C2189g.m6578a();
//            }
//            this.f6571a.mo18595k(a2);
//            int a3 = this.f6571a.mo18562a();
//            this.f6571a.mo18593i(h2);
//            this.f6571a.mo18569a(178, "java/lang/Void", Columns.TYPE, "Ljava/lang/Class;");
//            this.f6571a.mo18565a(166, a3);
//            this.f6571a.mo18593i(h);
//            m6570l();
//            this.f6571a.mo18592h(h2 + 1);
//            m6520a(i3, i, i2);
//            if (s != this.f6571a.f5919d) {
//                throw C2189g.m6578a();
//            }
//            this.f6571a.mo18595k(a3);
//            this.f6571a.mo18593i(h);
//            this.f6571a.mo18593i(h2);
        }
//        if (i3 == 17 || i3 == 16) {
//            this.f6571a.mo18564a(95);
//        }
//        m6523a((i3 == 14 || i3 == 16) ? "cmp_LT" : "cmp_LE", "(Ljava/lang/Object;Ljava/lang/Object;)Z");
//        this.f6571a.mo18565a(154, i);
//        this.f6571a.mo18565a(167, i2);
    }

    /* renamed from: c */
    private void m6546c(Node cmVar, Node cmVar2, int i, int i2) {
//        String str;
//        int i3;
//        if (i == -1 || i2 == -1) {
//            throw C2189g.m6578a();
//        }
//        short s = this.f6571a.f5919d;
//        int i4 = cmVar.f6389a;
//        Node d = cmVar2.mo18942d();
//        if (cmVar2.f6389a == 42 || d.f6389a == 42) {
//            if (cmVar2.f6389a == 42) {
//                cmVar2 = d;
//            }
//            m6529a(cmVar2, cmVar);
//            if (i4 == 46 || i4 == 47) {
//                this.f6571a.mo18565a(i4 == 46 ? 198 : 199, i);
//                i = i2;
//            } else {
//                if (i4 == 12) {
//                    int i5 = i2;
//                    i2 = i;
//                    i = i5;
//                } else if (i4 != 13) {
//                    throw C2189g.m6578a();
//                }
//                this.f6571a.mo18564a(89);
//                int a = this.f6571a.mo18562a();
//                this.f6571a.mo18565a(199, a);
//                short s2 = this.f6571a.f5919d;
//                this.f6571a.mo18564a(87);
//                this.f6571a.mo18565a(167, i2);
//                this.f6571a.mo18570a(a, s2);
//                C2189g.m6589b(this.f6571a);
//                this.f6571a.mo18565a(165, i2);
//            }
//            this.f6571a.mo18565a(167, i);
//        } else {
//            int h = m6564h(cmVar2);
//            if (h != -1 && d.f6389a == 149) {
//                Node b = d.mo18930b();
//                if (b.f6389a == 40) {
//                    this.f6571a.mo18593i(h);
//                    this.f6571a.mo18569a(178, "java/lang/Void", Columns.TYPE, "Ljava/lang/Class;");
//                    int a2 = this.f6571a.mo18562a();
//                    this.f6571a.mo18565a(166, a2);
//                    this.f6571a.mo18592h(h + 1);
//                    this.f6571a.mo18563a(((NumberLiteral) b).f6133g);
//                    this.f6571a.mo18564a(151);
//                    if (i4 == 12) {
//                        this.f6571a.mo18565a(153, i);
//                    } else {
//                        this.f6571a.mo18565a(154, i);
//                    }
//                    this.f6571a.mo18565a(167, i2);
//                    this.f6571a.mo18595k(a2);
//                }
//            }
//            m6529a(cmVar2, cmVar);
//            m6529a(d, cmVar);
//            switch (i4) {
//                case 12:
//                    str = "eq";
//                    i3 = 154;
//                    break;
//                case 13:
//                    str = "eq";
//                    i3 = 153;
//                    break;
//                case 46:
//                    str = "shallowEq";
//                    i3 = 154;
//                    break;
//                case 47:
//                    str = "shallowEq";
//                    i3 = 153;
//                    break;
//                default:
//                    throw C2189g.m6578a();
//            }
//            m6523a(str, "(Ljava/lang/Object;Ljava/lang/Object;)Z");
//            this.f6571a.mo18565a(i3, i);
//            this.f6571a.mo18565a(167, i2);
//        }
//        if (s != this.f6571a.f5919d) {
//            throw C2189g.m6578a();
//        }
    }

    /* renamed from: c */
    private void m6545c(Node cmVar, Node cmVar2) {
        String str = ((Name) cmVar.mo18930b()).f6130g;
        while (cmVar2 != null) {
            m6529a(cmVar2, cmVar);
            cmVar2 = cmVar2.mo18942d();
        }
//        this.f6571a.mo18593i((int) this.f6592v);
//        this.f6571a.mo18593i((int) this.f6590t);
//        this.f6571a.mo18589e(str);
        m6523a("setName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/Object;");
    }

    /* renamed from: d */
    private void m6550d(Node cmVar, Node cmVar2) {
        String str = ((Name) cmVar.mo18930b()).f6130g;
        while (cmVar2 != null) {
            m6529a(cmVar2, cmVar);
            cmVar2 = cmVar2.mo18942d();
        }
//        this.f6571a.mo18593i((int) this.f6592v);
//        this.f6571a.mo18593i((int) this.f6590t);
//        this.f6571a.mo18589e(str);
        m6523a("strictSetName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/Object;");
    }

    /* renamed from: e */
    private void m6556e(Node cmVar, Node cmVar2) {
        String str = ((Name) cmVar.mo18930b()).f6130g;
        while (cmVar2 != null) {
            m6529a(cmVar2, cmVar);
            cmVar2 = cmVar2.mo18942d();
        }
//        this.f6571a.mo18593i((int) this.f6592v);
//        this.f6571a.mo18589e(str);
        m6523a("setConst", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Ljava/lang/String;)Ljava/lang/Object;");
    }

    /* renamed from: d */
    private void m6551d(Node cmVar, Node cmVar2, boolean z) {
//        if (!this.f6583m) {
//            Kit.m5810a();
//        }
//        int a = this.f6578h.mo19075a(cmVar);
//        m6529a(cmVar2.mo18942d(), cmVar);
//        boolean z2 = cmVar.mo18924a(8, -1) != -1;
//        short s = this.f6584n[a];
//        if (this.f6578h.f6618a.mo18755B()[a]) {
//            if (z) {
//                return;
//            }
//            if (z2) {
//                this.f6571a.mo18564a(88);
//            } else {
//                this.f6571a.mo18564a(87);
//            }
//        } else if (!m6552d(a)) {
//            boolean b = this.f6578h.mo19078b(a);
//            if (!z2) {
//                if (b) {
//                    Kit.m5810a();
//                }
//                this.f6571a.mo18590f((int) s);
//                if (z) {
//                    this.f6571a.mo18593i((int) s);
//                }
//            } else if (b) {
//                this.f6571a.mo18588e((int) s);
//                if (z) {
//                    this.f6571a.mo18592h((int) s);
//                }
//            } else {
//                if (z) {
//                    this.f6571a.mo18564a(92);
//                }
//                m6571m();
//                this.f6571a.mo18590f((int) s);
//            }
//        } else if (z2) {
//            if (z) {
//                this.f6571a.mo18564a(92);
//            }
//            this.f6571a.mo18593i((int) s);
//            this.f6571a.mo18569a(178, "java/lang/Void", Columns.TYPE, "Ljava/lang/Class;");
//            int a2 = this.f6571a.mo18562a();
//            int a3 = this.f6571a.mo18562a();
//            this.f6571a.mo18565a(165, a2);
//            short s2 = this.f6571a.f5919d;
//            m6571m();
//            this.f6571a.mo18590f((int) s);
//            this.f6571a.mo18565a(167, a3);
//            this.f6571a.mo18570a(a2, s2);
//            this.f6571a.mo18588e(s + 1);
//            this.f6571a.mo18595k(a3);
//        } else {
//            if (z) {
//                this.f6571a.mo18564a(89);
//            }
//            this.f6571a.mo18590f((int) s);
//        }
    }

    /* renamed from: e */
    private void m6557e(Node cmVar, Node cmVar2, boolean z) {
        if (!this.f6583m) {
            Kit.m5810a();
        }
        int a = this.f6578h.mo19075a(cmVar);
        m6529a(cmVar2.mo18942d(), cmVar);
        boolean z2 = cmVar.mo18924a(8, -1) != -1;
        short s = this.f6584n[a];
//        int a2 = this.f6571a.mo18562a();
//        int a3 = this.f6571a.mo18562a();
//        if (z2) {
//            this.f6571a.mo18591g(s + 2);
//            this.f6571a.mo18565a(154, a3);
//            short s2 = this.f6571a.f5919d;
//            this.f6571a.mo18583c(1);
//            this.f6571a.mo18586d(s + 2);
//            this.f6571a.mo18588e((int) s);
//            if (z) {
//                this.f6571a.mo18592h((int) s);
//                this.f6571a.mo18570a(a3, s2);
//            } else {
//                this.f6571a.mo18565a(167, a2);
//                this.f6571a.mo18570a(a3, s2);
//                this.f6571a.mo18564a(88);
//            }
//        } else {
//            this.f6571a.mo18591g(s + 1);
//            this.f6571a.mo18565a(154, a3);
//            short s3 = this.f6571a.f5919d;
//            this.f6571a.mo18583c(1);
//            this.f6571a.mo18586d(s + 1);
//            this.f6571a.mo18590f((int) s);
//            if (z) {
//                this.f6571a.mo18593i((int) s);
//                this.f6571a.mo18570a(a3, s3);
//            } else {
//                this.f6571a.mo18565a(167, a2);
//                this.f6571a.mo18570a(a3, s3);
//                this.f6571a.mo18564a(87);
//            }
//        }
//        this.f6571a.mo18595k(a2);
    }

    /* renamed from: i */
    private static int m6566i(Node cmVar) {
        return ((Node) cmVar.mo18937c(3)).mo18941d(2);
    }

    /* renamed from: e */
    private void m6554e(int i) {
//        this.f6571a.mo18593i(i);
//        this.f6571a.mo18569a(178, "java/lang/Void", Columns.TYPE, "Ljava/lang/Class;");
//        int a = this.f6571a.mo18562a();
//        this.f6571a.mo18565a(165, a);
//        short s = this.f6571a.f5919d;
//        this.f6571a.mo18593i(i);
//        m6570l();
//        int a2 = this.f6571a.mo18562a();
//        this.f6571a.mo18565a(167, a2);
//        this.f6571a.mo18570a(a, s);
//        this.f6571a.mo18592h(i + 1);
//        this.f6571a.mo18595k(a2);
    }

    /* renamed from: f */
    private void m6560f(int i) {
//        this.f6571a.mo18593i(i);
//        this.f6571a.mo18569a(178, "java/lang/Void", Columns.TYPE, "Ljava/lang/Class;");
//        int a = this.f6571a.mo18562a();
//        this.f6571a.mo18565a(165, a);
//        short s = this.f6571a.f5919d;
//        this.f6571a.mo18593i(i);
//        int a2 = this.f6571a.mo18562a();
//        this.f6571a.mo18565a(167, a2);
//        this.f6571a.mo18570a(a, s);
//        this.f6571a.mo18592h(i + 1);
//        m6571m();
//        this.f6571a.mo18595k(a2);
    }

    /* renamed from: a */
    private void m6526a(Node cmVar, int i) {

//        this.f6571a.mo18565a(i, m6542c(cmVar));
    }

    /* renamed from: l */
    private void m6570l() {
        m6523a("toNumber", "(Ljava/lang/Object;)D");
    }

    /* renamed from: g */
    private void m6562g(int i) {
//        if (i != 0) {
//            this.f6571a.mo18583c(i);
//            this.f6571a.mo18568a(189, "java/lang/Object");
//        } else if (this.f6562A >= 0) {
//            this.f6571a.mo18593i((int) this.f6562A);
//        } else {
//            this.f6571a.mo18569a(178, "org/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
//        }
    }

    /* renamed from: a */
    private void m6523a(String str, String str2) {
//        this.f6571a.mo18580b(184, "org.mozilla.javascript.ScriptRuntime", str, str2);
    }

    /* renamed from: b */
    private void m6538b(String str, String str2) {
//        this.f6571a.mo18580b(184, "org/mozilla/javascript/optimizer/OptRuntime", str, str2);
    }

    /* renamed from: a */
    private void m6519a(int i, int i2) {
//        this.f6571a.mo18595k(i2);
//        int a = this.f6571a.mo18562a();
//        this.f6571a.mo18569a(178, "java/lang/Boolean", "FALSE", "Ljava/lang/Boolean;");
//        this.f6571a.mo18565a(167, a);
//        this.f6571a.mo18595k(i);
//        this.f6571a.mo18569a(178, "java/lang/Boolean", "TRUE", "Ljava/lang/Boolean;");
//        this.f6571a.mo18595k(a);
//        this.f6571a.mo18577b();
    }

    /* renamed from: m */
    private void m6571m() {
        m6538b("wrapDouble", "(D)Ljava/lang/Double;");
    }

    /* renamed from: n */
    private short m6572n() {
        short s = this.f6580j;
        this.f6579i[s] = 1;
        int i = this.f6580j;
        while (true) {
            i++;
            if (i >= 1024) {
                throw Context.m6765c("Program too complex (out of locals)");
            } else if (this.f6579i[i] == 0) {
                this.f6580j = (short) i;
                if (this.f6581k < this.f6580j) {
                    this.f6581k = this.f6580j;
                }
                return s;
            }
        }
    }

    /* renamed from: a */
    private short m6518a(int i, boolean z) {
        short s;
        if (z) {
            i++;
        }
        short s2 = this.f6580j;
        while (true) {
            s = s2;
            if (s >= 1023) {
                break;
            }
            int i2 = 0;
            while (i2 < i && this.f6579i[s + i2] == 0) {
                i2++;
            }
            if (i2 >= i) {
                break;
            }
            s2 = (short) (s + 1);
        }
        return s;
    }

    /* renamed from: a */
    private void m6534a(short s) {
        if (s < this.f6580j) {
            this.f6580j = s;
        }
        this.f6579i[s] = 0;
    }
}
