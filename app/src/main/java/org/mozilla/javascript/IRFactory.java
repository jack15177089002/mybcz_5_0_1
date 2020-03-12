package org.mozilla.javascript;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mozilla.javascript.p110b.ArrayComprehension;
import org.mozilla.javascript.p110b.ArrayLiteral;
import org.mozilla.javascript.p110b.AstNode;
import org.mozilla.javascript.p110b.AstRoot;
import org.mozilla.javascript.p110b.Block;
import org.mozilla.javascript.p110b.CatchClause;
import org.mozilla.javascript.p110b.DoLoop;
import org.mozilla.javascript.p110b.ElementGet;
import org.mozilla.javascript.p110b.EmptyExpression;
import org.mozilla.javascript.p110b.ForInLoop;
import org.mozilla.javascript.p110b.ForLoop;
import org.mozilla.javascript.p110b.FunctionCall;
import org.mozilla.javascript.p110b.FunctionNode;
import org.mozilla.javascript.p110b.GeneratorExpression;
import org.mozilla.javascript.p110b.Jump;
import org.mozilla.javascript.p110b.Label;
import org.mozilla.javascript.p110b.LabeledStatement;
import org.mozilla.javascript.p110b.LetNode;
import org.mozilla.javascript.p110b.Name;
import org.mozilla.javascript.p110b.NewExpression;
import org.mozilla.javascript.p110b.NumberLiteral;
import org.mozilla.javascript.p110b.ObjectLiteral;
import org.mozilla.javascript.p110b.ObjectProperty;
import org.mozilla.javascript.p110b.ParenthesizedExpression;
import org.mozilla.javascript.p110b.PropertyGet;
import org.mozilla.javascript.p110b.Scope;
import org.mozilla.javascript.p110b.ScriptNode;
import org.mozilla.javascript.p110b.StringLiteral;
import org.mozilla.javascript.p110b.SwitchCase;
import org.mozilla.javascript.p110b.SwitchStatement;
import org.mozilla.javascript.p110b.Symbol;
import org.mozilla.javascript.p110b.TryStatement;
import org.mozilla.javascript.p110b.VariableDeclaration;
import org.mozilla.javascript.p110b.VariableInitializer;
import org.mozilla.javascript.p110b.WhileLoop;
import org.mozilla.javascript.p110b.XmlElemRef;
import org.mozilla.javascript.p110b.XmlExpression;
import org.mozilla.javascript.p110b.XmlFragment;
import org.mozilla.javascript.p110b.XmlLiteral;
import org.mozilla.javascript.p110b.XmlPropRef;
import org.mozilla.javascript.p110b.XmlRef;
import org.mozilla.javascript.p110b.XmlString;
import org.slf4j.Marker;

/* renamed from: org.mozilla.javascript.ae */
public final class IRFactory extends Parser {

    /* renamed from: l */
    private Decompiler f5993l = new Decompiler();

    public IRFactory() {
    }

    public IRFactory(CompilerEnvirons iVar, ErrorReporter xVar) {
        super(iVar, xVar);
    }

    /* renamed from: a */
    public final ScriptNode mo18639a(AstRoot gVar) {
        this.f6431e = gVar;
        this.f6430d = gVar.f6213g;
        ScriptNode auVar = (ScriptNode) m5686b((AstNode) gVar);
        auVar.mo18760d(this.f5993l.f6825b, this.f5993l.f6825b);
        if (this.f6427a.f6745h) {
            Decompiler tVar = this.f5993l;
            if (tVar.f6825b < 0) {
                Kit.m5810a();
            }
            auVar.f6149F = new String(tVar.f6824a, 0, tVar.f6825b + 0);
        }
        this.f5993l = null;
        return auVar;
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [org.mozilla.javascript.cm] */
    /* JADX WARNING: type inference failed for: r1v2, types: [org.mozilla.javascript.cm] */
    /* JADX WARNING: type inference failed for: r1v13, types: [org.mozilla.javascript.cm] */
    /* JADX WARNING: type inference failed for: r1v14, types: [org.mozilla.javascript.cm] */
    /* JADX WARNING: type inference failed for: r1v26, types: [org.mozilla.javascript.cm] */
    /* JADX WARNING: type inference failed for: r1v31, types: [org.mozilla.javascript.cm] */
    /* JADX WARNING: type inference failed for: r1v46, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v66 */
    /* JADX WARNING: type inference failed for: r0v67, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r1v48 */
    /* JADX WARNING: type inference failed for: r0v68, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r1v49 */
    /* JADX WARNING: type inference failed for: r1v67, types: [org.mozilla.javascript.b.e] */
    /* JADX WARNING: type inference failed for: r1v68, types: [org.mozilla.javascript.cm] */
    /* JADX WARNING: type inference failed for: r1v69, types: [org.mozilla.javascript.cm] */
    /* JADX WARNING: type inference failed for: r0v121 */
    /* JADX WARNING: type inference failed for: r1v71 */
    /* JADX WARNING: type inference failed for: r1v72 */
    /* JADX WARNING: type inference failed for: r1v73 */
    /* JADX WARNING: type inference failed for: r1v74 */
    /* JADX WARNING: type inference failed for: r0v127 */
    /* JADX WARNING: type inference failed for: r1v75 */
    /* JADX WARNING: type inference failed for: r1v76 */
    /* JADX WARNING: type inference failed for: r1v77 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v0
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], org.mozilla.javascript.cm, ?[OBJECT, ARRAY]]
  uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], org.mozilla.javascript.cm, java.util.List, ?[OBJECT, ARRAY]]
  mth insns count: 488
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 11 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Node m5686b(AstNode r9) {
        /*
            r8 = this;
            r5 = 4
            r2 = 1
            r1 = 0
            r4 = 82
            r3 = 0
            int r0 = r9.f6389a
            switch(r0) {
                case 4: goto L_0x0283;
                case 30: goto L_0x0226;
                case 33: goto L_0x0151;
                case 36: goto L_0x012c;
                case 38: goto L_0x00db;
                case 39: goto L_0x0210;
                case 40: goto L_0x021b;
                case 41: goto L_0x02d2;
                case 42: goto L_0x0207;
                case 43: goto L_0x0207;
                case 44: goto L_0x0207;
                case 45: goto L_0x0207;
                case 48: goto L_0x0236;
                case 50: goto L_0x02eb;
                case 65: goto L_0x0030;
                case 66: goto L_0x022e;
                case 72: goto L_0x0358;
                case 81: goto L_0x030d;
                case 102: goto L_0x0175;
                case 109: goto L_0x011c;
                case 112: goto L_0x01ad;
                case 114: goto L_0x02e3;
                case 117: goto L_0x0315;
                case 118: goto L_0x0100;
                case 119: goto L_0x0108;
                case 120: goto L_0x00be;
                case 121: goto L_0x00e3;
                case 123: goto L_0x031d;
                case 128: goto L_0x0028;
                case 129: goto L_0x00b8;
                case 136: goto L_0x02ca;
                case 157: goto L_0x0029;
                case 160: goto L_0x0207;
                case 162: goto L_0x0124;
                default: goto L_0x000b;
            }
        L_0x000b:
            boolean r0 = r9 instanceof org.mozilla.javascript.p110b.ExpressionStatement
            if (r0 == 0) goto L_0x038a
            org.mozilla.javascript.b.t r9 = (org.mozilla.javascript.p110b.ExpressionStatement) r9
            org.mozilla.javascript.b.e r0 = r9.f6238g
            org.mozilla.javascript.cm r1 = r8.m5686b(r0)
            org.mozilla.javascript.t r0 = r8.f5993l
            r0.mo19165c(r4)
            org.mozilla.javascript.cm r0 = new org.mozilla.javascript.cm
            int r2 = r9.f6389a
            int r3 = r9.mo18794f()
            r0.<init>(r2, r1, r3)
            r9 = r0
        L_0x0028:
            return r9
        L_0x0029:
            org.mozilla.javascript.b.a r9 = (org.mozilla.javascript.p110b.ArrayComprehension) r9
            org.mozilla.javascript.cm r9 = r8.m5657a(r9)
            goto L_0x0028
        L_0x0030:
            org.mozilla.javascript.b.c r9 = (org.mozilla.javascript.p110b.ArrayLiteral) r9
            boolean r0 = r9.f6207i
            if (r0 != 0) goto L_0x0028
            org.mozilla.javascript.t r0 = r8.f5993l
            r2 = 83
            r0.mo19163b(r2)
            java.util.List r5 = r9.mo18725n()
            org.mozilla.javascript.cm r4 = new org.mozilla.javascript.cm
            r0 = 65
            r4.<init>(r0)
            r2 = r3
        L_0x0049:
            int r0 = r5.size()
            if (r2 >= r0) goto L_0x0085
            java.lang.Object r0 = r5.get(r2)
            org.mozilla.javascript.b.e r0 = (org.mozilla.javascript.p110b.AstNode) r0
            int r6 = r0.f6389a
            r7 = 128(0x80, float:1.794E-43)
            if (r6 == r7) goto L_0x0075
            org.mozilla.javascript.cm r0 = r8.m5686b(r0)
            r4.mo18935b(r0)
        L_0x0062:
            int r0 = r5.size()
            int r0 = r0 + -1
            if (r2 >= r0) goto L_0x0071
            org.mozilla.javascript.t r0 = r8.f5993l
            r6 = 89
            r0.mo19163b(r6)
        L_0x0071:
            int r0 = r2 + 1
            r2 = r0
            goto L_0x0049
        L_0x0075:
            if (r1 != 0) goto L_0x0534
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x007c:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.add(r1)
            r1 = r0
            goto L_0x0062
        L_0x0085:
            org.mozilla.javascript.t r0 = r8.f5993l
            r2 = 84
            r0.mo19163b(r2)
            r0 = 21
            int r2 = r9.f6205g
            r4.mo18933b(r0, r2)
            if (r1 == 0) goto L_0x00b5
            int r0 = r1.size()
            int[] r2 = new int[r0]
        L_0x009b:
            int r0 = r1.size()
            if (r3 >= r0) goto L_0x00b0
            java.lang.Object r0 = r1.get(r3)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r2[r3] = r0
            int r3 = r3 + 1
            goto L_0x009b
        L_0x00b0:
            r0 = 11
            r4.mo18925a(r0, r2)
        L_0x00b5:
            r9 = r4
            goto L_0x0028
        L_0x00b8:
            org.mozilla.javascript.cm r9 = r8.m5692c(r9)
            goto L_0x0028
        L_0x00be:
            org.mozilla.javascript.b.i r9 = (org.mozilla.javascript.p110b.BreakStatement) r9
            org.mozilla.javascript.t r0 = r8.f5993l
            r1 = 120(0x78, float:1.68E-43)
            r0.mo19163b(r1)
            org.mozilla.javascript.b.ak r0 = r9.f6215g
            if (r0 == 0) goto L_0x00d4
            org.mozilla.javascript.t r0 = r8.f5993l
            org.mozilla.javascript.b.ak r1 = r9.f6215g
            java.lang.String r1 = r1.f6130g
            r0.mo19162a(r1)
        L_0x00d4:
            org.mozilla.javascript.t r0 = r8.f5993l
            r0.mo19165c(r4)
            goto L_0x0028
        L_0x00db:
            org.mozilla.javascript.b.w r9 = (org.mozilla.javascript.p110b.FunctionCall) r9
            org.mozilla.javascript.cm r9 = r8.m5674a(r9)
            goto L_0x0028
        L_0x00e3:
            org.mozilla.javascript.b.m r9 = (org.mozilla.javascript.p110b.ContinueStatement) r9
            org.mozilla.javascript.t r0 = r8.f5993l
            r1 = 121(0x79, float:1.7E-43)
            r0.mo19163b(r1)
            org.mozilla.javascript.b.ak r0 = r9.f6230g
            if (r0 == 0) goto L_0x00f9
            org.mozilla.javascript.t r0 = r8.f5993l
            org.mozilla.javascript.b.ak r1 = r9.f6230g
            java.lang.String r1 = r1.f6130g
            r0.mo19162a(r1)
        L_0x00f9:
            org.mozilla.javascript.t r0 = r8.f5993l
            r0.mo19165c(r4)
            goto L_0x0028
        L_0x0100:
            org.mozilla.javascript.b.o r9 = (org.mozilla.javascript.p110b.DoLoop) r9
            org.mozilla.javascript.cm r9 = r8.m5671a(r9)
            goto L_0x0028
        L_0x0108:
            boolean r0 = r9 instanceof org.mozilla.javascript.p110b.ForInLoop
            if (r0 == 0) goto L_0x0114
            org.mozilla.javascript.b.u r9 = (org.mozilla.javascript.p110b.ForInLoop) r9
            org.mozilla.javascript.cm r9 = r8.m5672a(r9)
            goto L_0x0028
        L_0x0114:
            org.mozilla.javascript.b.v r9 = (org.mozilla.javascript.p110b.ForLoop) r9
            org.mozilla.javascript.cm r9 = r8.m5673a(r9)
            goto L_0x0028
        L_0x011c:
            org.mozilla.javascript.b.x r9 = (org.mozilla.javascript.p110b.FunctionNode) r9
            org.mozilla.javascript.cm r9 = r8.m5675a(r9)
            goto L_0x0028
        L_0x0124:
            org.mozilla.javascript.b.z r9 = (org.mozilla.javascript.p110b.GeneratorExpression) r9
            org.mozilla.javascript.cm r9 = r8.m5677a(r9)
            goto L_0x0028
        L_0x012c:
            org.mozilla.javascript.b.p r9 = (org.mozilla.javascript.p110b.ElementGet) r9
            org.mozilla.javascript.b.e r0 = r9.f6234g
            org.mozilla.javascript.cm r0 = r8.m5686b(r0)
            org.mozilla.javascript.t r1 = r8.f5993l
            r2 = 83
            r1.mo19163b(r2)
            org.mozilla.javascript.b.e r1 = r9.f6235h
            org.mozilla.javascript.cm r1 = r8.m5686b(r1)
            org.mozilla.javascript.t r2 = r8.f5993l
            r3 = 84
            r2.mo19163b(r3)
            org.mozilla.javascript.cm r9 = new org.mozilla.javascript.cm
            r2 = 36
            r9.<init>(r2, r0, r1)
            goto L_0x0028
        L_0x0151:
            org.mozilla.javascript.b.aq r9 = (org.mozilla.javascript.p110b.PropertyGet) r9
            org.mozilla.javascript.b.e r0 = r9.mo18725n()
            org.mozilla.javascript.cm r2 = r8.m5686b(r0)
            org.mozilla.javascript.b.e r0 = r9.mo18726o()
            org.mozilla.javascript.b.ak r0 = (org.mozilla.javascript.p110b.Name) r0
            java.lang.String r0 = r0.f6130g
            org.mozilla.javascript.t r4 = r8.f5993l
            r5 = 108(0x6c, float:1.51E-43)
            r4.mo19163b(r5)
            org.mozilla.javascript.t r4 = r8.f5993l
            r4.mo19162a(r0)
            org.mozilla.javascript.cm r9 = r8.m5679a(r2, r1, r0, r3)
            goto L_0x0028
        L_0x0175:
            org.mozilla.javascript.b.l r9 = (org.mozilla.javascript.p110b.ConditionalExpression) r9
            org.mozilla.javascript.b.e r0 = r9.f6225g
            org.mozilla.javascript.cm r3 = r8.m5686b(r0)
            org.mozilla.javascript.t r0 = r8.f5993l
            r1 = 102(0x66, float:1.43E-43)
            r0.mo19163b(r1)
            org.mozilla.javascript.b.e r0 = r9.f6226h
            org.mozilla.javascript.cm r0 = r8.m5686b(r0)
            org.mozilla.javascript.t r1 = r8.f5993l
            r4 = 103(0x67, float:1.44E-43)
            r1.mo19163b(r4)
            org.mozilla.javascript.b.e r1 = r9.f6227i
            org.mozilla.javascript.cm r9 = r8.m5686b(r1)
            int r1 = m5694d(r3)
            if (r1 != r2) goto L_0x01a0
            r9 = r0
            goto L_0x0028
        L_0x01a0:
            r2 = -1
            if (r1 == r2) goto L_0x0028
            org.mozilla.javascript.cm r1 = new org.mozilla.javascript.cm
            r2 = 102(0x66, float:1.43E-43)
            r1.<init>(r2, r3, r0, r9)
            r9 = r1
            goto L_0x0028
        L_0x01ad:
            org.mozilla.javascript.b.ac r9 = (org.mozilla.javascript.p110b.IfStatement) r9
            org.mozilla.javascript.t r0 = r8.f5993l
            r2 = 112(0x70, float:1.57E-43)
            r0.mo19163b(r2)
            org.mozilla.javascript.t r0 = r8.f5993l
            r2 = 87
            r0.mo19163b(r2)
            org.mozilla.javascript.b.e r0 = r9.f6108g
            org.mozilla.javascript.cm r0 = r8.m5686b(r0)
            org.mozilla.javascript.t r2 = r8.f5993l
            r3 = 88
            r2.mo19163b(r3)
            org.mozilla.javascript.t r2 = r8.f5993l
            r3 = 85
            r2.mo19165c(r3)
            org.mozilla.javascript.b.e r2 = r9.f6109h
            org.mozilla.javascript.cm r2 = r8.m5686b(r2)
            org.mozilla.javascript.b.e r3 = r9.f6111j
            if (r3 == 0) goto L_0x01f6
            org.mozilla.javascript.t r1 = r8.f5993l
            r3 = 86
            r1.mo19163b(r3)
            org.mozilla.javascript.t r1 = r8.f5993l
            r3 = 113(0x71, float:1.58E-43)
            r1.mo19163b(r3)
            org.mozilla.javascript.t r1 = r8.f5993l
            r3 = 85
            r1.mo19165c(r3)
            org.mozilla.javascript.b.e r1 = r9.f6111j
            org.mozilla.javascript.cm r1 = r8.m5686b(r1)
        L_0x01f6:
            org.mozilla.javascript.t r3 = r8.f5993l
            r4 = 86
            r3.mo19165c(r4)
            int r3 = r9.mo18794f()
            org.mozilla.javascript.cm r9 = m5683a(r0, r2, r1, r3)
            goto L_0x0028
        L_0x0207:
            org.mozilla.javascript.t r0 = r8.f5993l
            int r1 = r9.f6389a
            r0.mo19163b(r1)
            goto L_0x0028
        L_0x0210:
            org.mozilla.javascript.b.ak r9 = (org.mozilla.javascript.p110b.Name) r9
            org.mozilla.javascript.t r0 = r8.f5993l
            java.lang.String r1 = r9.f6130g
            r0.mo19162a(r1)
            goto L_0x0028
        L_0x021b:
            org.mozilla.javascript.b.am r9 = (org.mozilla.javascript.p110b.NumberLiteral) r9
            org.mozilla.javascript.t r0 = r8.f5993l
            double r2 = r9.f6133g
            r0.mo19161a(r2)
            goto L_0x0028
        L_0x0226:
            org.mozilla.javascript.b.al r9 = (org.mozilla.javascript.p110b.NewExpression) r9
            org.mozilla.javascript.cm r9 = r8.m5662a(r9)
            goto L_0x0028
        L_0x022e:
            org.mozilla.javascript.b.an r9 = (org.mozilla.javascript.p110b.ObjectLiteral) r9
            org.mozilla.javascript.cm r9 = r8.m5663a(r9)
            goto L_0x0028
        L_0x0236:
            org.mozilla.javascript.b.ar r9 = (org.mozilla.javascript.p110b.RegExpLiteral) r9
            org.mozilla.javascript.t r0 = r8.f5993l
            java.lang.String r1 = r9.f6139g
            java.lang.String r2 = r9.f6140h
            r3 = 48
            r0.mo19163b(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "/"
            r3.<init>(r4)
            java.lang.StringBuilder r1 = r3.append(r1)
            r3 = 47
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.mo19166c(r1)
            org.mozilla.javascript.b.au r0 = r8.f6431e
            if (r9 != 0) goto L_0x0266
            org.mozilla.javascript.p110b.ScriptNode.m5916u()
        L_0x0266:
            java.util.List<org.mozilla.javascript.b.ar> r1 = r0.f6151H
            if (r1 != 0) goto L_0x0271
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.f6151H = r1
        L_0x0271:
            java.util.List<org.mozilla.javascript.b.ar> r1 = r0.f6151H
            r1.add(r9)
            java.util.List<org.mozilla.javascript.b.ar> r0 = r0.f6151H
            int r0 = r0.size()
            int r0 = r0 + -1
            r9.mo18933b(r5, r0)
            goto L_0x0028
        L_0x0283:
            org.mozilla.javascript.b.as r9 = (org.mozilla.javascript.p110b.ReturnStatement) r9
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r2 = 25
            java.lang.Object r2 = r9.mo18937c(r2)
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x02b3
            org.mozilla.javascript.t r2 = r8.f5993l
            java.lang.String r3 = " "
            r2.mo19162a(r3)
        L_0x029a:
            org.mozilla.javascript.b.e r2 = r9.f6141g
            if (r2 != 0) goto L_0x02b9
        L_0x029e:
            if (r0 != 0) goto L_0x02a5
            org.mozilla.javascript.t r0 = r8.f5993l
            r0.mo19165c(r4)
        L_0x02a5:
            if (r2 != 0) goto L_0x02be
            org.mozilla.javascript.cm r0 = new org.mozilla.javascript.cm
            int r1 = r9.mo18794f()
            r0.<init>(r5, r1)
            r9 = r0
            goto L_0x0028
        L_0x02b3:
            org.mozilla.javascript.t r2 = r8.f5993l
            r2.mo19163b(r5)
            goto L_0x029a
        L_0x02b9:
            org.mozilla.javascript.cm r1 = r8.m5686b(r2)
            goto L_0x029e
        L_0x02be:
            org.mozilla.javascript.cm r0 = new org.mozilla.javascript.cm
            int r2 = r9.mo18794f()
            r0.<init>(r5, r1, r2)
            r9 = r0
            goto L_0x0028
        L_0x02ca:
            org.mozilla.javascript.b.au r9 = (org.mozilla.javascript.p110b.ScriptNode) r9
            org.mozilla.javascript.cm r9 = r8.m5665a(r9)
            goto L_0x0028
        L_0x02d2:
            org.mozilla.javascript.b.av r9 = (org.mozilla.javascript.p110b.StringLiteral) r9
            org.mozilla.javascript.t r0 = r8.f5993l
            java.lang.String r1 = r9.f6160g
            r0.mo19164b(r1)
            java.lang.String r0 = r9.f6160g
            org.mozilla.javascript.cm r9 = org.mozilla.javascript.Node.m6112a(r0)
            goto L_0x0028
        L_0x02e3:
            org.mozilla.javascript.b.ax r9 = (org.mozilla.javascript.p110b.SwitchStatement) r9
            org.mozilla.javascript.cm r9 = r8.m5666a(r9)
            goto L_0x0028
        L_0x02eb:
            org.mozilla.javascript.b.az r9 = (org.mozilla.javascript.p110b.ThrowStatement) r9
            org.mozilla.javascript.t r0 = r8.f5993l
            r1 = 50
            r0.mo19163b(r1)
            org.mozilla.javascript.b.e r0 = r9.f6174g
            org.mozilla.javascript.cm r1 = r8.m5686b(r0)
            org.mozilla.javascript.t r0 = r8.f5993l
            r0.mo19165c(r4)
            org.mozilla.javascript.cm r0 = new org.mozilla.javascript.cm
            r2 = 50
            int r3 = r9.mo18794f()
            r0.<init>(r2, r1, r3)
            r9 = r0
            goto L_0x0028
        L_0x030d:
            org.mozilla.javascript.b.ba r9 = (org.mozilla.javascript.p110b.TryStatement) r9
            org.mozilla.javascript.cm r9 = r8.m5667a(r9)
            goto L_0x0028
        L_0x0315:
            org.mozilla.javascript.b.be r9 = (org.mozilla.javascript.p110b.WhileLoop) r9
            org.mozilla.javascript.cm r9 = r8.m5669a(r9)
            goto L_0x0028
        L_0x031d:
            org.mozilla.javascript.b.bf r9 = (org.mozilla.javascript.p110b.WithStatement) r9
            org.mozilla.javascript.t r0 = r8.f5993l
            r1 = 123(0x7b, float:1.72E-43)
            r0.mo19163b(r1)
            org.mozilla.javascript.t r0 = r8.f5993l
            r1 = 87
            r0.mo19163b(r1)
            org.mozilla.javascript.b.e r0 = r9.f6187g
            org.mozilla.javascript.cm r0 = r8.m5686b(r0)
            org.mozilla.javascript.t r1 = r8.f5993l
            r2 = 88
            r1.mo19163b(r2)
            org.mozilla.javascript.t r1 = r8.f5993l
            r2 = 85
            r1.mo19165c(r2)
            org.mozilla.javascript.b.e r1 = r9.f6188h
            org.mozilla.javascript.cm r1 = r8.m5686b(r1)
            org.mozilla.javascript.t r2 = r8.f5993l
            r3 = 86
            r2.mo19165c(r3)
            int r2 = r9.mo18794f()
            org.mozilla.javascript.cm r9 = r8.m5682a(r0, r1, r2)
            goto L_0x0028
        L_0x0358:
            org.mozilla.javascript.b.bp r9 = (org.mozilla.javascript.p110b.Yield) r9
            org.mozilla.javascript.t r0 = r8.f5993l
            r2 = 72
            r0.mo19163b(r2)
            org.mozilla.javascript.b.e r0 = r9.f6203g
            if (r0 != 0) goto L_0x0375
        L_0x0365:
            if (r1 == 0) goto L_0x037c
            org.mozilla.javascript.cm r0 = new org.mozilla.javascript.cm
            r2 = 72
            int r3 = r9.mo18794f()
            r0.<init>(r2, r1, r3)
            r9 = r0
            goto L_0x0028
        L_0x0375:
            org.mozilla.javascript.b.e r0 = r9.f6203g
            org.mozilla.javascript.cm r1 = r8.m5686b(r0)
            goto L_0x0365
        L_0x037c:
            org.mozilla.javascript.cm r0 = new org.mozilla.javascript.cm
            r1 = 72
            int r2 = r9.mo18794f()
            r0.<init>(r1, r2)
            r9 = r0
            goto L_0x0028
        L_0x038a:
            boolean r0 = r9 instanceof org.mozilla.javascript.p110b.Assignment
            if (r0 == 0) goto L_0x03c8
            org.mozilla.javascript.b.d r9 = (org.mozilla.javascript.p110b.Assignment) r9
            org.mozilla.javascript.b.e r0 = r9.mo18725n()
            org.mozilla.javascript.b.e r1 = m6208a(r0)
            boolean r0 = r1 instanceof org.mozilla.javascript.p110b.DestructuringForm
            if (r0 == 0) goto L_0x03c1
            r0 = r1
            org.mozilla.javascript.b.n r0 = (org.mozilla.javascript.p110b.DestructuringForm) r0
            boolean r0 = r0.mo18742p()
            if (r0 == 0) goto L_0x03c1
        L_0x03a5:
            if (r2 == 0) goto L_0x03c3
            r8.m5695d(r1)
        L_0x03aa:
            org.mozilla.javascript.t r0 = r8.f5993l
            int r2 = r9.f6389a
            r0.mo19163b(r2)
            int r0 = r9.f6389a
            org.mozilla.javascript.b.e r2 = r9.mo18726o()
            org.mozilla.javascript.cm r2 = r8.m5686b(r2)
            org.mozilla.javascript.cm r9 = r8.m5691c(r0, r1, r2)
            goto L_0x0028
        L_0x03c1:
            r2 = r3
            goto L_0x03a5
        L_0x03c3:
            org.mozilla.javascript.cm r1 = r8.m5686b(r1)
            goto L_0x03aa
        L_0x03c8:
            boolean r0 = r9 instanceof org.mozilla.javascript.p110b.UnaryExpression
            if (r0 == 0) goto L_0x044e
            org.mozilla.javascript.b.bb r9 = (org.mozilla.javascript.p110b.UnaryExpression) r9
            int r1 = r9.f6389a
            r0 = 74
            if (r1 != r0) goto L_0x03fe
            org.mozilla.javascript.t r0 = r8.f5993l
            r1 = 116(0x74, float:1.63E-43)
            r0.mo19163b(r1)
            org.mozilla.javascript.t r0 = r8.f5993l
            java.lang.String r1 = " xml"
            r0.mo19162a(r1)
            org.mozilla.javascript.t r0 = r8.f5993l
            java.lang.String r1 = " namespace"
            r0.mo19162a(r1)
            org.mozilla.javascript.t r0 = r8.f5993l
            r1 = 90
            r0.mo19163b(r1)
            org.mozilla.javascript.b.e r0 = r9.f6180g
            org.mozilla.javascript.cm r0 = r8.m5686b(r0)
            r1 = 74
            org.mozilla.javascript.cm r9 = m5655a(r1, r0)
            goto L_0x0028
        L_0x03fe:
            boolean r0 = r9.f6181h
            if (r0 != 0) goto L_0x0431
            r0 = r2
        L_0x0403:
            if (r0 == 0) goto L_0x040a
            org.mozilla.javascript.t r0 = r8.f5993l
            r0.mo19163b(r1)
        L_0x040a:
            org.mozilla.javascript.b.e r0 = r9.f6180g
            org.mozilla.javascript.cm r0 = r8.m5686b(r0)
            boolean r4 = r9.f6181h
            if (r4 == 0) goto L_0x0419
            org.mozilla.javascript.t r4 = r8.f5993l
            r4.mo19163b(r1)
        L_0x0419:
            r4 = 106(0x6a, float:1.49E-43)
            if (r1 == r4) goto L_0x0421
            r4 = 107(0x6b, float:1.5E-43)
            if (r1 != r4) goto L_0x0448
        L_0x0421:
            boolean r4 = r9.f6181h
            org.mozilla.javascript.cm r0 = m5693c(r0)
            int r5 = r0.f6389a
            switch(r5) {
                case 33: goto L_0x0433;
                case 36: goto L_0x0433;
                case 39: goto L_0x0433;
                case 67: goto L_0x0433;
                default: goto L_0x042c;
            }
        L_0x042c:
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.m5810a()
            throw r0
        L_0x0431:
            r0 = r3
            goto L_0x0403
        L_0x0433:
            org.mozilla.javascript.cm r9 = new org.mozilla.javascript.cm
            r9.<init>(r1, r0)
            r0 = 107(0x6b, float:1.5E-43)
            if (r1 != r0) goto L_0x0531
            r0 = r2
        L_0x043d:
            if (r4 == 0) goto L_0x0441
            r0 = r0 | 2
        L_0x0441:
            r1 = 13
            r9.mo18933b(r1, r0)
            goto L_0x0028
        L_0x0448:
            org.mozilla.javascript.cm r9 = m5655a(r1, r0)
            goto L_0x0028
        L_0x044e:
            boolean r0 = r9 instanceof org.mozilla.javascript.p110b.XmlMemberGet
            if (r0 == 0) goto L_0x0486
            org.mozilla.javascript.b.bl r9 = (org.mozilla.javascript.p110b.XmlMemberGet) r9
            org.mozilla.javascript.b.e r0 = r9.mo18726o()
            org.mozilla.javascript.b.bn r0 = (org.mozilla.javascript.p110b.XmlRef) r0
            org.mozilla.javascript.b.e r1 = r9.mo18725n()
            org.mozilla.javascript.cm r1 = r8.m5686b(r1)
            boolean r2 = r0.mo18726o()
            if (r2 == 0) goto L_0x0469
            r3 = 2
        L_0x0469:
            int r2 = r9.f6389a
            r4 = 143(0x8f, float:2.0E-43)
            if (r2 != r4) goto L_0x047e
            r3 = r3 | 4
            org.mozilla.javascript.t r2 = r8.f5993l
            r4 = 143(0x8f, float:2.0E-43)
            r2.mo19163b(r4)
        L_0x0478:
            org.mozilla.javascript.cm r9 = r8.m5681a(r1, r0, r3)
            goto L_0x0028
        L_0x047e:
            org.mozilla.javascript.t r2 = r8.f5993l
            r4 = 108(0x6c, float:1.51E-43)
            r2.mo19163b(r4)
            goto L_0x0478
        L_0x0486:
            boolean r0 = r9 instanceof org.mozilla.javascript.p110b.InfixExpression
            if (r0 == 0) goto L_0x04b6
            org.mozilla.javascript.b.ad r9 = (org.mozilla.javascript.p110b.InfixExpression) r9
            org.mozilla.javascript.b.e r0 = r9.mo18725n()
            org.mozilla.javascript.cm r0 = r8.m5686b(r0)
            org.mozilla.javascript.t r1 = r8.f5993l
            int r2 = r9.f6389a
            r1.mo19163b(r2)
            org.mozilla.javascript.b.e r1 = r9.mo18726o()
            org.mozilla.javascript.cm r1 = r8.m5686b(r1)
            boolean r2 = r9 instanceof org.mozilla.javascript.p110b.XmlDotQuery
            if (r2 == 0) goto L_0x04ae
            org.mozilla.javascript.t r2 = r8.f5993l
            r3 = 88
            r2.mo19163b(r3)
        L_0x04ae:
            int r2 = r9.f6389a
            org.mozilla.javascript.cm r9 = m5685b(r2, r0, r1)
            goto L_0x0028
        L_0x04b6:
            boolean r0 = r9 instanceof org.mozilla.javascript.p110b.VariableDeclaration
            if (r0 == 0) goto L_0x04d9
            org.mozilla.javascript.b.bc r9 = (org.mozilla.javascript.p110b.VariableDeclaration) r9
            org.mozilla.javascript.t r0 = r8.f5993l
            int r1 = r9.f6389a
            r0.mo19163b(r1)
            r8.m5668a(r9)
            org.mozilla.javascript.b.e r0 = r9.mo18801t()
            boolean r1 = r0 instanceof org.mozilla.javascript.p110b.Loop
            if (r1 != 0) goto L_0x0028
            boolean r0 = r0 instanceof org.mozilla.javascript.p110b.LetNode
            if (r0 != 0) goto L_0x0028
            org.mozilla.javascript.t r0 = r8.f5993l
            r0.mo19165c(r4)
            goto L_0x0028
        L_0x04d9:
            boolean r0 = r9 instanceof org.mozilla.javascript.p110b.ParenthesizedExpression
            if (r0 == 0) goto L_0x04e5
            org.mozilla.javascript.b.ap r9 = (org.mozilla.javascript.p110b.ParenthesizedExpression) r9
            org.mozilla.javascript.cm r9 = r8.m5664a(r9)
            goto L_0x0028
        L_0x04e5:
            boolean r0 = r9 instanceof org.mozilla.javascript.p110b.LabeledStatement
            if (r0 == 0) goto L_0x04f1
            org.mozilla.javascript.b.ah r9 = (org.mozilla.javascript.p110b.LabeledStatement) r9
            org.mozilla.javascript.cm r9 = r8.m5660a(r9)
            goto L_0x0028
        L_0x04f1:
            boolean r0 = r9 instanceof org.mozilla.javascript.p110b.LetNode
            if (r0 == 0) goto L_0x04fd
            org.mozilla.javascript.b.ai r9 = (org.mozilla.javascript.p110b.LetNode) r9
            org.mozilla.javascript.cm r9 = r8.m5661a(r9)
            goto L_0x0028
        L_0x04fd:
            boolean r0 = r9 instanceof org.mozilla.javascript.p110b.XmlRef
            if (r0 == 0) goto L_0x0510
            org.mozilla.javascript.b.bn r9 = (org.mozilla.javascript.p110b.XmlRef) r9
            boolean r0 = r9.mo18726o()
            if (r0 == 0) goto L_0x050a
            r3 = 2
        L_0x050a:
            org.mozilla.javascript.cm r9 = r8.m5681a(r1, r9, r3)
            goto L_0x0028
        L_0x0510:
            boolean r0 = r9 instanceof org.mozilla.javascript.p110b.XmlLiteral
            if (r0 == 0) goto L_0x051c
            org.mozilla.javascript.b.bk r9 = (org.mozilla.javascript.p110b.XmlLiteral) r9
            org.mozilla.javascript.cm r9 = r8.m5670a(r9)
            goto L_0x0028
        L_0x051c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Can't transform: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0531:
            r0 = r3
            goto L_0x043d
        L_0x0534:
            r0 = r1
            goto L_0x007c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.IRFactory.m5686b(org.mozilla.javascript.b.e):org.mozilla.javascript.cm");
    }

    /* renamed from: a */
    private Node m5657a(ArrayComprehension aVar) {
        int f = aVar.mo18794f();
        Scope a = m6204a(157, f);
        String C = this.f6431e.mo18756C();
        mo18984a(a);
        try {
            mo18980a(153, C, false);
            Node cmVar = new Node(129, f);
            cmVar.mo18935b(new Node(133, m5691c(90, mo18986b(C), m5684b(30, mo18986b("Array"))), f));
            cmVar.mo18935b(m5658a(aVar, C));
            a.mo18935b(cmVar);
            a.mo18935b(mo18986b(C));
            return a;
        } finally {
            mo18979a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x016a A[LOOP:3: B:26:0x0168->B:27:0x016a, LOOP_END] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Node m5658a(ArrayComprehension r18, String r19) {
        /*
            r17 = this;
            r0 = r17
            org.mozilla.javascript.t r2 = r0.f5993l
            r3 = 83
            r2.mo19163b(r3)
            int r6 = r18.mo18794f()
            r0 = r18
            org.mozilla.javascript.b.e r2 = r0.f6102g
            r0 = r17
            org.mozilla.javascript.cm r9 = r0.m5686b(r2)
            r0 = r18
            java.util.List<org.mozilla.javascript.b.b> r12 = r0.f6103h
            int r7 = r12.size()
            org.mozilla.javascript.cm[] r13 = new org.mozilla.javascript.Node[r7]
            org.mozilla.javascript.cm[] r14 = new org.mozilla.javascript.Node[r7]
            r2 = 0
            r5 = r2
        L_0x0025:
            if (r5 >= r7) goto L_0x00cf
            java.lang.Object r2 = r12.get(r5)
            org.mozilla.javascript.b.b r2 = (org.mozilla.javascript.p110b.ArrayComprehensionLoop) r2
            r0 = r17
            org.mozilla.javascript.t r3 = r0.f5993l
            java.lang.String r4 = " "
            r3.mo19162a(r4)
            r0 = r17
            org.mozilla.javascript.t r3 = r0.f5993l
            r4 = 119(0x77, float:1.67E-43)
            r3.mo19163b(r4)
            boolean r3 = r2.mo18717v()
            if (r3 == 0) goto L_0x004e
            r0 = r17
            org.mozilla.javascript.t r3 = r0.f5993l
            java.lang.String r4 = "each "
            r3.mo19162a(r4)
        L_0x004e:
            r0 = r17
            org.mozilla.javascript.t r3 = r0.f5993l
            r4 = 87
            r3.mo19163b(r4)
            org.mozilla.javascript.b.e r3 = r2.mo18726o()
            int r4 = r3.f6389a
            r8 = 39
            if (r4 != r8) goto L_0x00a0
            org.mozilla.javascript.b.ak r3 = (org.mozilla.javascript.p110b.Name) r3
            java.lang.String r3 = r3.f6130g
            r0 = r17
            org.mozilla.javascript.t r4 = r0.f5993l
            r4.mo19162a(r3)
            r4 = r9
        L_0x006d:
            r0 = r17
            org.mozilla.javascript.cm r8 = r0.mo18986b(r3)
            r9 = 153(0x99, float:2.14E-43)
            r10 = 0
            r0 = r17
            r0.mo18980a(r9, r3, r10)
            r13[r5] = r8
            r0 = r17
            org.mozilla.javascript.t r3 = r0.f5993l
            r8 = 52
            r3.mo19163b(r8)
            org.mozilla.javascript.b.e r2 = r2.mo18742p()
            r0 = r17
            org.mozilla.javascript.cm r2 = r0.m5686b(r2)
            r14[r5] = r2
            r0 = r17
            org.mozilla.javascript.t r2 = r0.f5993l
            r3 = 88
            r2.mo19163b(r3)
            int r2 = r5 + 1
            r5 = r2
            r9 = r4
            goto L_0x0025
        L_0x00a0:
            r0 = r17
            r0.m5695d(r3)
            r0 = r17
            org.mozilla.javascript.b.au r4 = r0.f6431e
            java.lang.String r4 = r4.mo18756C()
            r8 = 87
            r10 = 0
            r0 = r17
            r0.mo18980a(r8, r4, r10)
            r8 = 89
            r10 = 90
            r0 = r17
            org.mozilla.javascript.cm r11 = r0.mo18986b(r4)
            r0 = r17
            org.mozilla.javascript.cm r3 = r0.m5691c(r10, r3, r11)
            org.mozilla.javascript.cm r3 = m5685b(r8, r3, r9)
            r16 = r4
            r4 = r3
            r3 = r16
            goto L_0x006d
        L_0x00cf:
            r2 = 38
            r0 = r17
            r1 = r19
            org.mozilla.javascript.cm r3 = r0.mo18986b(r1)
            r4 = 0
            java.lang.String r5 = "push"
            r8 = 0
            r0 = r17
            org.mozilla.javascript.cm r3 = r0.m5679a(r3, r4, r5, r8)
            r0 = r17
            org.mozilla.javascript.cm r15 = r0.m5684b(r2, r3)
            org.mozilla.javascript.cm r2 = new org.mozilla.javascript.cm
            r3 = 133(0x85, float:1.86E-43)
            r2.<init>(r3, r15, r6)
            r0 = r18
            org.mozilla.javascript.b.e r3 = r0.f6104i
            if (r3 == 0) goto L_0x0129
            r0 = r17
            org.mozilla.javascript.t r3 = r0.f5993l
            java.lang.String r4 = " "
            r3.mo19162a(r4)
            r0 = r17
            org.mozilla.javascript.t r3 = r0.f5993l
            r4 = 112(0x70, float:1.57E-43)
            r3.mo19163b(r4)
            r0 = r17
            org.mozilla.javascript.t r3 = r0.f5993l
            r4 = 87
            r3.mo19163b(r4)
            r0 = r18
            org.mozilla.javascript.b.e r3 = r0.f6104i
            r0 = r17
            org.mozilla.javascript.cm r3 = r0.m5686b(r3)
            r4 = 0
            org.mozilla.javascript.cm r2 = m5683a(r3, r2, r4, r6)
            r0 = r17
            org.mozilla.javascript.t r3 = r0.f5993l
            r4 = 88
            r3.mo19163b(r4)
        L_0x0129:
            r10 = 0
            int r3 = r7 + -1
            r11 = r3
            r7 = r2
            r3 = r10
        L_0x012f:
            if (r11 < 0) goto L_0x015d
            java.lang.Object r2 = r12.get(r11)     // Catch:{ all -> 0x0166 }
            org.mozilla.javascript.b.b r2 = (org.mozilla.javascript.p110b.ArrayComprehensionLoop) r2     // Catch:{ all -> 0x0166 }
            int r4 = r2.mo18794f()     // Catch:{ all -> 0x0166 }
            r5 = 132(0x84, float:1.85E-43)
            org.mozilla.javascript.b.at r4 = m6204a(r5, r4)     // Catch:{ all -> 0x0166 }
            r0 = r17
            r0.mo18984a(r4)     // Catch:{ all -> 0x0166 }
            int r10 = r3 + 1
            r3 = 153(0x99, float:2.14E-43)
            r5 = r13[r11]     // Catch:{ all -> 0x017e }
            r6 = r14[r11]     // Catch:{ all -> 0x017e }
            boolean r8 = r2.mo18717v()     // Catch:{ all -> 0x017e }
            r2 = r17
            org.mozilla.javascript.cm r7 = r2.m5656a(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x017e }
            int r2 = r11 + -1
            r11 = r2
            r3 = r10
            goto L_0x012f
        L_0x015d:
            r2 = 0
        L_0x015e:
            if (r2 >= r3) goto L_0x0171
            r17.mo18979a()
            int r2 = r2 + 1
            goto L_0x015e
        L_0x0166:
            r2 = move-exception
        L_0x0167:
            r4 = 0
        L_0x0168:
            if (r4 >= r3) goto L_0x0170
            r17.mo18979a()
            int r4 = r4 + 1
            goto L_0x0168
        L_0x0170:
            throw r2
        L_0x0171:
            r0 = r17
            org.mozilla.javascript.t r2 = r0.f5993l
            r3 = 84
            r2.mo19163b(r3)
            r15.mo18935b(r9)
            return r7
        L_0x017e:
            r2 = move-exception
            r3 = r10
            goto L_0x0167
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.IRFactory.m5658a(org.mozilla.javascript.b.a, java.lang.String):org.mozilla.javascript.cm");
    }

    /* renamed from: c */
    private Node m5692c(AstNode eVar) {
        if (eVar instanceof Scope) {
            mo18984a((Scope) eVar);
        }
        try {
            ArrayList<Node> arrayList = new ArrayList<>();
            Iterator it = eVar.iterator();
            while (it.hasNext()) {
                arrayList.add(m5686b((AstNode) ((Node) it.next())));
            }
            eVar.mo18945e();
            for (Node b : arrayList) {
                eVar.mo18935b(b);
            }
            return eVar;
        } finally {
            if (eVar instanceof Scope) {
                mo18979a();
            }
        }
    }

    /* renamed from: a */
    private Node m5671a(DoLoop oVar) {
        oVar.mo18730a(132);
        mo18984a((Scope) oVar);
        try {
            this.f5993l.mo19163b(118);
            this.f5993l.mo19165c(85);
            Node b = m5686b(oVar.mo18725n());
            this.f5993l.mo19163b(86);
            this.f5993l.mo19163b(117);
            this.f5993l.mo19163b(87);
            Node b2 = m5686b(oVar.f6232g);
            this.f5993l.mo19163b(88);
            this.f5993l.mo19165c(82);
            return m5659a((Jump) oVar, 0, b, b2, (Node) null, (Node) null);
        } finally {
            mo18979a();
        }
    }

    /* renamed from: a */
    private Node m5672a(ForInLoop uVar) {
        this.f5993l.mo19163b(119);
        if (uVar.mo18717v()) {
            this.f5993l.mo19162a("each ");
        }
        this.f5993l.mo19163b(87);
        uVar.mo18730a(132);
        mo18984a((Scope) uVar);
        int i = -1;
        try {
            AstNode o = uVar.mo18726o();
            if (o instanceof VariableDeclaration) {
                i = ((VariableDeclaration) o).f6389a;
            }
            Node b = m5686b(o);
            this.f5993l.mo19163b(52);
            Node b2 = m5686b(uVar.mo18742p());
            this.f5993l.mo19163b(88);
            this.f5993l.mo19165c(85);
            Node b3 = m5686b(uVar.mo18725n());
            this.f5993l.mo19165c(86);
            return m5656a(i, (Node) uVar, b, b2, b3, uVar.mo18717v());
        } finally {
            mo18979a();
        }
    }

    /* renamed from: a */
    private Node m5673a(ForLoop vVar) {
        Node cmVar;
        this.f5993l.mo19163b(119);
        this.f5993l.mo19163b(87);
        vVar.mo18730a(132);
        Scope atVar = this.f6432f;
        this.f6432f = vVar;
        try {
            Node b = m5686b(vVar.f6244g);
            this.f5993l.mo19163b(82);
            Node b2 = m5686b(vVar.f6245h);
            this.f5993l.mo19163b(82);
            Node b3 = m5686b(vVar.f6246i);
            this.f5993l.mo19163b(88);
            this.f5993l.mo19165c(85);
            Node b4 = m5686b(vVar.mo18725n());
            this.f5993l.mo19165c(86);
            if (b.f6389a == 153) {
                Scope e = Scope.m5859e(vVar);
                e.mo18730a(153);
                e.mo18943d(b);
                e.mo18935b(m5659a((Jump) vVar, 2, b4, b2, new Node(128), b3));
                cmVar = e;
            } else {
                cmVar = m5659a((Jump) vVar, 2, b4, b2, b, b3);
            }
            return cmVar;
        } finally {
            this.f6432f = atVar;
        }
    }

    /* renamed from: a */
    private Node m5675a(FunctionNode xVar) {
        int i = xVar.f6260q;
        int a = this.f5993l.mo19160a(i);
        Node b = m5687b(xVar);
        int a2 = this.f6431e.mo18757a(xVar);
        C2166cw cwVar = new C2166cw(this, xVar);
        try {
            Node cmVar = (Node) xVar.mo18937c(23);
            xVar.mo18932b(23);
            int f = xVar.f6256j.mo18794f();
            this.f6429c++;
            Node b2 = m5686b(xVar.f6256j);
            if (!xVar.f6257k) {
                this.f5993l.mo19163b(86);
            }
            xVar.mo18760d(a, this.f5993l.mo19159a());
            if (i != 2 && !xVar.f6257k) {
                this.f5993l.mo19163b(1);
            }
            if (cmVar != null) {
                b2.mo18927a(new Node(133, cmVar, f));
            }
            int i2 = xVar.f6260q;
            Node a3 = m5676a(xVar, a2, b2, i2);
            if (b != null) {
                a3 = m5691c(90, b, a3);
                if (i2 != 2) {
                    a3 = m5678a(a3, xVar.mo18794f());
                }
            }
            return a3;
        } finally {
            this.f6429c--;
            cwVar.mo18989a();
        }
    }

    /* renamed from: a */
    private Node m5674a(FunctionCall wVar) {
        Node b = m5684b(38, m5686b(wVar.mo18725n()));
        b.f6393e = wVar.mo18794f();
        this.f5993l.mo19163b(87);
        List o = wVar.mo18726o();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < o.size()) {
                b.mo18935b(m5686b((AstNode) o.get(i2)));
                if (i2 < o.size() - 1) {
                    this.f5993l.mo19163b(89);
                }
                i = i2 + 1;
            } else {
                this.f5993l.mo19163b(88);
                return b;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private Node m5677a(GeneratorExpression zVar) {
        FunctionNode xVar = new FunctionNode();
        xVar.f6148E = this.f6431e.mo18756C();
        xVar.f6262s = true;
        xVar.f6260q = 2;
        xVar.f6261r = true;
        int i = xVar.f6260q;
        int a = this.f5993l.mo19160a(i);
        Node b = m5687b(xVar);
        int a2 = this.f6431e.mo18757a(xVar);
        C2166cw cwVar = new C2166cw(this, xVar);
        try {
            Node cmVar = (Node) xVar.mo18937c(23);
            xVar.mo18932b(23);
            int i2 = zVar.f6393e;
            this.f6429c++;
            Node b2 = m5688b(zVar);
            if (!xVar.f6257k) {
                this.f5993l.mo19163b(86);
            }
            xVar.mo18760d(a, this.f5993l.mo19159a());
            if (i != 2 && !xVar.f6257k) {
                this.f5993l.mo19163b(1);
            }
            if (cmVar != null) {
                b2.mo18927a(new Node(133, cmVar, i2));
            }
            int i3 = xVar.f6260q;
            Node a3 = m5676a(xVar, a2, b2, i3);
            if (b != null) {
                a3 = m5691c(90, b, a3);
                if (i3 != 2) {
                    a3 = m5678a(a3, xVar.mo18794f());
                }
            }
            this.f6429c--;
            cwVar.mo18989a();
            Node b3 = m5684b(38, a3);
            b3.f6393e = zVar.mo18794f();
            this.f5993l.mo19163b(87);
            this.f5993l.mo19163b(88);
            return b3;
        } catch (Throwable th) {
            this.f6429c--;
            cwVar.mo18989a();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0115 A[LOOP:3: B:23:0x0113->B:24:0x0115, LOOP_END] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Node m5688b(GeneratorExpression r15) {
        /*
            r14 = this;
            org.mozilla.javascript.t r0 = r14.f5993l
            r1 = 87
            r0.mo19163b(r1)
            int r5 = r15.mo18794f()
            org.mozilla.javascript.b.e r0 = r15.f6270g
            org.mozilla.javascript.cm r3 = r14.m5686b(r0)
            java.util.List<org.mozilla.javascript.b.aa> r9 = r15.f6271h
            int r6 = r9.size()
            org.mozilla.javascript.cm[] r10 = new org.mozilla.javascript.Node[r6]
            org.mozilla.javascript.cm[] r11 = new org.mozilla.javascript.Node[r6]
            r0 = 0
            r4 = r0
        L_0x001d:
            if (r4 >= r6) goto L_0x009a
            java.lang.Object r0 = r9.get(r4)
            org.mozilla.javascript.b.aa r0 = (org.mozilla.javascript.p110b.GeneratorExpressionLoop) r0
            org.mozilla.javascript.t r1 = r14.f5993l
            java.lang.String r2 = " "
            r1.mo19162a(r2)
            org.mozilla.javascript.t r1 = r14.f5993l
            r2 = 119(0x77, float:1.67E-43)
            r1.mo19163b(r2)
            org.mozilla.javascript.t r1 = r14.f5993l
            r2 = 87
            r1.mo19163b(r2)
            org.mozilla.javascript.b.e r1 = r0.mo18726o()
            int r2 = r1.f6389a
            r7 = 39
            if (r2 != r7) goto L_0x0077
            org.mozilla.javascript.b.ak r1 = (org.mozilla.javascript.p110b.Name) r1
            java.lang.String r1 = r1.f6130g
            org.mozilla.javascript.t r2 = r14.f5993l
            r2.mo19162a(r1)
            r2 = r3
        L_0x004e:
            org.mozilla.javascript.cm r3 = r14.mo18986b(r1)
            r7 = 153(0x99, float:2.14E-43)
            r8 = 0
            r14.mo18980a(r7, r1, r8)
            r10[r4] = r3
            org.mozilla.javascript.t r1 = r14.f5993l
            r3 = 52
            r1.mo19163b(r3)
            org.mozilla.javascript.b.e r0 = r0.mo18742p()
            org.mozilla.javascript.cm r0 = r14.m5686b(r0)
            r11[r4] = r0
            org.mozilla.javascript.t r0 = r14.f5993l
            r1 = 88
            r0.mo19163b(r1)
            int r0 = r4 + 1
            r4 = r0
            r3 = r2
            goto L_0x001d
        L_0x0077:
            r14.m5695d(r1)
            org.mozilla.javascript.b.au r2 = r14.f6431e
            java.lang.String r2 = r2.mo18756C()
            r7 = 87
            r8 = 0
            r14.mo18980a(r7, r2, r8)
            r7 = 89
            r8 = 90
            org.mozilla.javascript.cm r12 = r14.mo18986b(r2)
            org.mozilla.javascript.cm r1 = r14.m5691c(r8, r1, r12)
            org.mozilla.javascript.cm r1 = m5685b(r7, r1, r3)
            r13 = r2
            r2 = r1
            r1 = r13
            goto L_0x004e
        L_0x009a:
            org.mozilla.javascript.cm r1 = new org.mozilla.javascript.cm
            r0 = 72
            int r2 = r15.mo18794f()
            r1.<init>(r0, r3, r2)
            org.mozilla.javascript.cm r0 = new org.mozilla.javascript.cm
            r2 = 133(0x85, float:1.86E-43)
            r0.<init>(r2, r1, r5)
            org.mozilla.javascript.b.e r1 = r15.f6272i
            if (r1 == 0) goto L_0x00d7
            org.mozilla.javascript.t r1 = r14.f5993l
            java.lang.String r2 = " "
            r1.mo19162a(r2)
            org.mozilla.javascript.t r1 = r14.f5993l
            r2 = 112(0x70, float:1.57E-43)
            r1.mo19163b(r2)
            org.mozilla.javascript.t r1 = r14.f5993l
            r2 = 87
            r1.mo19163b(r2)
            org.mozilla.javascript.b.e r1 = r15.f6272i
            org.mozilla.javascript.cm r1 = r14.m5686b(r1)
            r2 = 0
            org.mozilla.javascript.cm r0 = m5683a(r1, r0, r2, r5)
            org.mozilla.javascript.t r1 = r14.f5993l
            r2 = 88
            r1.mo19163b(r2)
        L_0x00d7:
            r7 = 0
            int r1 = r6 + -1
            r8 = r1
            r5 = r0
            r1 = r7
        L_0x00dd:
            if (r8 < 0) goto L_0x0108
            java.lang.Object r0 = r9.get(r8)     // Catch:{ all -> 0x0111 }
            org.mozilla.javascript.b.aa r0 = (org.mozilla.javascript.p110b.GeneratorExpressionLoop) r0     // Catch:{ all -> 0x0111 }
            int r2 = r0.mo18794f()     // Catch:{ all -> 0x0111 }
            r3 = 132(0x84, float:1.85E-43)
            org.mozilla.javascript.b.at r2 = m6204a(r3, r2)     // Catch:{ all -> 0x0111 }
            r14.mo18984a(r2)     // Catch:{ all -> 0x0111 }
            int r7 = r1 + 1
            r1 = 153(0x99, float:2.14E-43)
            r3 = r10[r8]     // Catch:{ all -> 0x0124 }
            r4 = r11[r8]     // Catch:{ all -> 0x0124 }
            boolean r6 = r0.mo18717v()     // Catch:{ all -> 0x0124 }
            r0 = r14
            org.mozilla.javascript.cm r5 = r0.m5656a(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0124 }
            int r0 = r8 + -1
            r8 = r0
            r1 = r7
            goto L_0x00dd
        L_0x0108:
            r0 = 0
        L_0x0109:
            if (r0 >= r1) goto L_0x011c
            r14.mo18979a()
            int r0 = r0 + 1
            goto L_0x0109
        L_0x0111:
            r0 = move-exception
        L_0x0112:
            r2 = 0
        L_0x0113:
            if (r2 >= r1) goto L_0x011b
            r14.mo18979a()
            int r2 = r2 + 1
            goto L_0x0113
        L_0x011b:
            throw r0
        L_0x011c:
            org.mozilla.javascript.t r0 = r14.f5993l
            r1 = 88
            r0.mo19163b(r1)
            return r5
        L_0x0124:
            r0 = move-exception
            r1 = r7
            goto L_0x0112
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.IRFactory.m5688b(org.mozilla.javascript.b.z):org.mozilla.javascript.cm");
    }

    /* renamed from: a */
    private Node m5660a(LabeledStatement ahVar) {
        for (Label agVar : ahVar.f6121g) {
            this.f5993l.mo19162a(agVar.f6120g);
            this.f5993l.mo19165c(103);
        }
        Label n = ahVar.mo18725n();
        Node b = m5686b(ahVar.f6122h);
        Node h = Node.m6116h();
        Node cmVar = new Node(129, (Node) n, b, h);
        n.f6117w = h;
        return cmVar;
    }

    /* renamed from: a */
    private Node m5661a(LetNode aiVar) {
        mo18984a((Scope) aiVar);
        try {
            this.f5993l.mo19163b(153);
            this.f5993l.mo19163b(87);
            Node a = m5668a(aiVar.f6123g);
            this.f5993l.mo19163b(88);
            aiVar.mo18935b(a);
            boolean z = aiVar.f6389a == 158;
            if (aiVar.f6124h != null) {
                if (z) {
                    this.f5993l.mo19162a(" ");
                } else {
                    this.f5993l.mo19165c(85);
                }
                aiVar.mo18935b(m5686b(aiVar.f6124h));
                if (!z) {
                    this.f5993l.mo19165c(86);
                }
            }
            return aiVar;
        } finally {
            mo18979a();
        }
    }

    /* renamed from: a */
    private Node m5662a(NewExpression alVar) {
        this.f5993l.mo19163b(30);
        Node b = m5684b(30, m5686b(alVar.mo18725n()));
        b.f6393e = alVar.mo18794f();
        List o = alVar.mo18726o();
        this.f5993l.mo19163b(87);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= o.size()) {
                break;
            }
            b.mo18935b(m5686b((AstNode) o.get(i2)));
            if (i2 < o.size() - 1) {
                this.f5993l.mo19163b(89);
            }
            i = i2 + 1;
        }
        this.f5993l.mo19163b(88);
        if (alVar.f6132l != null) {
            b.mo18935b(m5663a(alVar.f6132l));
        }
        return b;
    }

    /* JADX WARNING: type inference failed for: r14v2, types: [org.mozilla.javascript.cm] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Node m5663a(ObjectLiteral r14) {
        /*
            r13 = this;
            r12 = 152(0x98, float:2.13E-43)
            r11 = 151(0x97, float:2.12E-43)
            r10 = 66
            boolean r0 = r14.f6136g
            if (r0 == 0) goto L_0x000b
        L_0x000a:
            return r14
        L_0x000b:
            org.mozilla.javascript.t r0 = r13.f5993l
            r1 = 85
            r0.mo19163b(r1)
            java.util.List r1 = r14.mo18725n()
            org.mozilla.javascript.cm r14 = new org.mozilla.javascript.cm
            r14.<init>(r10)
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x0030
            java.lang.Object[] r0 = org.mozilla.javascript.ScriptRuntime.f6517x
        L_0x0023:
            org.mozilla.javascript.t r1 = r13.f5993l
            r2 = 86
            r1.mo19163b(r2)
            r1 = 12
            r14.mo18925a(r1, r0)
            goto L_0x000a
        L_0x0030:
            int r5 = r1.size()
            r0 = 0
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.util.Iterator r6 = r1.iterator()
            r2 = r0
        L_0x003c:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x00df
            java.lang.Object r0 = r6.next()
            org.mozilla.javascript.b.ao r0 = (org.mozilla.javascript.p110b.ObjectProperty) r0
            boolean r1 = r0.mo18742p()
            if (r1 == 0) goto L_0x009d
            org.mozilla.javascript.t r1 = r13.f5993l
            r1.mo19163b(r11)
        L_0x0053:
            int r3 = r2 + 1
            org.mozilla.javascript.b.e r1 = r0.mo18725n()
            boolean r7 = r1 instanceof org.mozilla.javascript.p110b.Name
            if (r7 == 0) goto L_0x00a9
            org.mozilla.javascript.b.ak r1 = (org.mozilla.javascript.p110b.Name) r1
            java.lang.String r1 = r1.f6130g
            org.mozilla.javascript.t r7 = r13.f5993l
            r7.mo19162a(r1)
            java.lang.Object r1 = org.mozilla.javascript.ScriptRuntime.m6435d(r1)
        L_0x006a:
            r4[r2] = r1
            boolean r1 = r0.mo18742p()
            if (r1 != 0) goto L_0x007d
            boolean r1 = r0.mo18743v()
            if (r1 != 0) goto L_0x007d
            org.mozilla.javascript.t r1 = r13.f5993l
            r1.mo19163b(r10)
        L_0x007d:
            org.mozilla.javascript.b.e r1 = r0.mo18726o()
            org.mozilla.javascript.cm r1 = r13.m5686b(r1)
            boolean r2 = r0.mo18742p()
            if (r2 == 0) goto L_0x00d2
            org.mozilla.javascript.cm r0 = m5655a(r11, r1)
        L_0x008f:
            r14.mo18935b(r0)
            if (r3 >= r5) goto L_0x009b
            org.mozilla.javascript.t r0 = r13.f5993l
            r1 = 89
            r0.mo19163b(r1)
        L_0x009b:
            r2 = r3
            goto L_0x003c
        L_0x009d:
            boolean r1 = r0.mo18743v()
            if (r1 == 0) goto L_0x0053
            org.mozilla.javascript.t r1 = r13.f5993l
            r1.mo19163b(r12)
            goto L_0x0053
        L_0x00a9:
            boolean r7 = r1 instanceof org.mozilla.javascript.p110b.StringLiteral
            if (r7 == 0) goto L_0x00bb
            org.mozilla.javascript.b.av r1 = (org.mozilla.javascript.p110b.StringLiteral) r1
            java.lang.String r1 = r1.f6160g
            org.mozilla.javascript.t r7 = r13.f5993l
            r7.mo19164b(r1)
            java.lang.Object r1 = org.mozilla.javascript.ScriptRuntime.m6435d(r1)
            goto L_0x006a
        L_0x00bb:
            boolean r7 = r1 instanceof org.mozilla.javascript.p110b.NumberLiteral
            if (r7 == 0) goto L_0x00cd
            org.mozilla.javascript.b.am r1 = (org.mozilla.javascript.p110b.NumberLiteral) r1
            double r8 = r1.f6133g
            org.mozilla.javascript.t r1 = r13.f5993l
            r1.mo19161a(r8)
            java.lang.Object r1 = org.mozilla.javascript.ScriptRuntime.m6447f(r8)
            goto L_0x006a
        L_0x00cd:
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.m5810a()
            throw r0
        L_0x00d2:
            boolean r0 = r0.mo18743v()
            if (r0 == 0) goto L_0x00dd
            org.mozilla.javascript.cm r0 = m5655a(r12, r1)
            goto L_0x008f
        L_0x00dd:
            r0 = r1
            goto L_0x008f
        L_0x00df:
            r0 = r4
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.IRFactory.m5663a(org.mozilla.javascript.b.an):org.mozilla.javascript.cm");
    }

    /* renamed from: a */
    private Node m5664a(ParenthesizedExpression apVar) {
        AstNode eVar = apVar.f6138g;
        this.f5993l.mo19163b(87);
        AstNode eVar2 = eVar;
        int i = 1;
        while (eVar2 instanceof ParenthesizedExpression) {
            this.f5993l.mo19163b(87);
            i++;
            eVar2 = ((ParenthesizedExpression) eVar2).f6138g;
        }
        Node b = m5686b(eVar2);
        for (int i2 = 0; i2 < i; i2++) {
            this.f5993l.mo19163b(88);
        }
        b.mo18925a(19, (Object) Boolean.TRUE);
        return b;
    }

    /* renamed from: a */
    private Node m5665a(ScriptNode auVar) {
        this.f5993l.mo19163b(136);
        if (this.f6432f != null) {
            Kit.m5810a();
        }
        this.f6432f = auVar;
        Node cmVar = new Node(129);
        Iterator it = auVar.iterator();
        while (it.hasNext()) {
            cmVar.mo18935b(m5686b((AstNode) ((Node) it.next())));
        }
        auVar.mo18945e();
        Node b = cmVar.mo18930b();
        if (b != null) {
            auVar.mo18943d(b);
        }
        return auVar;
    }

    /* renamed from: a */
    private Node m5666a(SwitchStatement axVar) {
        this.f5993l.mo19163b(114);
        this.f5993l.mo19163b(87);
        Node b = m5686b(axVar.f6165h);
        this.f5993l.mo19163b(88);
        axVar.mo18935b(b);
        Node cmVar = new Node(129, (Node) axVar, axVar.mo18794f());
        this.f5993l.mo19165c(85);
        for (SwitchCase awVar : axVar.f6166i != null ? axVar.f6166i : SwitchStatement.f6164g) {
            AstNode eVar = awVar.f6162g;
            Node cmVar2 = null;
            if (eVar != null) {
                this.f5993l.mo19163b(115);
                cmVar2 = m5686b(eVar);
            } else {
                this.f5993l.mo19163b(116);
            }
            this.f5993l.mo19165c(103);
            List<AstNode> list = awVar.f6163h;
            Block hVar = new Block();
            if (list != null) {
                for (AstNode b2 : list) {
                    hVar.mo18935b(m5686b(b2));
                }
            }
            if (cmVar.f6389a != 129) {
                throw Kit.m5810a();
            }
            Jump aeVar = (Jump) cmVar.mo18930b();
            if (aeVar.f6389a != 114) {
                throw Kit.m5810a();
            }
            Node h = Node.m6116h();
            if (cmVar2 != null) {
                Jump aeVar2 = new Jump(115, cmVar2);
                aeVar2.f6117w = h;
                aeVar.mo18935b((Node) aeVar2);
            } else if (aeVar.f6389a != 114) {
                throw Kit.m5810a();
            } else if (h.f6389a != 131) {
                throw Kit.m5810a();
            } else if (aeVar.f6118x != null) {
                throw Kit.m5810a();
            } else {
                aeVar.f6118x = h;
            }
            cmVar.mo18935b(h);
            cmVar.mo18935b((Node) hVar);
        }
        this.f5993l.mo19165c(86);
        if (cmVar.f6389a != 129) {
            throw Kit.m5810a();
        }
        Jump aeVar3 = (Jump) cmVar.mo18930b();
        if (aeVar3.f6389a != 114) {
            throw Kit.m5810a();
        }
        Node h2 = Node.m6116h();
        aeVar3.f6117w = h2;
        if (aeVar3.f6389a != 114) {
            throw Kit.m5810a();
        }
        Node cmVar3 = aeVar3.f6118x;
        if (cmVar3 == null) {
            cmVar3 = h2;
        }
        cmVar.mo18936b((Node) m5690c(5, cmVar3), (Node) aeVar3);
        cmVar.mo18935b(h2);
        return cmVar;
    }

    /* renamed from: a */
    private Node m5667a(TryStatement baVar) {
        Node qVar;
        Node cmVar;
        this.f5993l.mo19163b(81);
        this.f5993l.mo19165c(85);
        Node b = m5686b(baVar.f6176h);
        this.f5993l.mo19165c(86);
        Block hVar = new Block();
        for (CatchClause jVar : baVar.f6177i != null ? baVar.f6177i : TryStatement.f6175g) {
            this.f5993l.mo19163b(124);
            this.f5993l.mo19163b(87);
            String str = jVar.f6217g.f6130g;
            this.f5993l.mo19162a(str);
            AstNode eVar = jVar.f6218h;
            if (eVar != null) {
                this.f5993l.mo19162a(" ");
                this.f5993l.mo19163b(112);
                qVar = m5686b(eVar);
            } else {
                qVar = new EmptyExpression();
            }
            this.f5993l.mo19163b(88);
            this.f5993l.mo19165c(85);
            Node b2 = m5686b((AstNode) jVar.f6219i);
            this.f5993l.mo19165c(86);
            int f = jVar.mo18794f();
            if (qVar == null) {
                cmVar = new Node(128);
            } else {
                cmVar = qVar;
            }
            hVar.mo18935b(new Node(mo18986b(str), cmVar, b2, f));
        }
        Node cmVar2 = null;
        if (baVar.f6178j != null) {
            this.f5993l.mo19163b(125);
            this.f5993l.mo19165c(85);
            cmVar2 = m5686b(baVar.f6178j);
            this.f5993l.mo19165c(86);
        }
        int f2 = baVar.mo18794f();
        boolean z = cmVar2 != null && (cmVar2.f6389a != 129 || cmVar2.mo18929a());
        if (b.f6389a == 129 && !b.mo18929a() && !z) {
            return b;
        }
        boolean a = hVar.mo18929a();
        if (!z && !a) {
            return b;
        }
        Node cmVar3 = new Node(141);
        Jump aeVar = new Jump(b, f2);
        aeVar.mo18925a(3, (Object) cmVar3);
        if (a) {
            Node h = Node.m6116h();
            aeVar.mo18935b((Node) m5690c(5, h));
            Node h2 = Node.m6116h();
            aeVar.f6117w = h2;
            aeVar.mo18935b(h2);
            Node cmVar4 = new Node(141);
            Node b3 = hVar.mo18930b();
            boolean z2 = false;
            Node cmVar5 = b3;
            int i = 0;
            while (cmVar5 != null) {
                int f3 = cmVar5.mo18794f();
                Node b4 = cmVar5.mo18930b();
                Node d = b4.mo18942d();
                Node d2 = d.mo18942d();
                cmVar5.mo18947e(b4);
                cmVar5.mo18947e(d);
                cmVar5.mo18947e(d2);
                d2.mo18935b(new Node(3));
                d2.mo18935b((Node) m5690c(5, h));
                if (d.f6389a == 128) {
                    z2 = true;
                } else {
                    d2 = m5683a(d, d2, (Node) null, f3);
                }
                Node cmVar6 = new Node(57, b4, m5689b(cmVar3));
                cmVar6.mo18925a(3, (Object) cmVar4);
                cmVar6.mo18933b(14, i);
                cmVar4.mo18935b(cmVar6);
                cmVar4.mo18935b(m5682a(m5689b(cmVar4), d2, f3));
                cmVar5 = cmVar5.mo18942d();
                i++;
            }
            aeVar.mo18935b(cmVar4);
            if (!z2) {
                Node cmVar7 = new Node(51);
                cmVar7.mo18925a(3, (Object) cmVar3);
                aeVar.mo18935b(cmVar7);
            }
            aeVar.mo18935b(h);
        }
        if (z) {
            Node h3 = Node.m6116h();
            if (aeVar.f6389a != 81) {
                throw Kit.m5810a();
            } else if (h3.f6389a != 131) {
                throw Kit.m5810a();
            } else if (aeVar.f6118x != null) {
                throw Kit.m5810a();
            } else {
                aeVar.f6118x = h3;
                aeVar.mo18935b((Node) m5690c(135, h3));
                Node h4 = Node.m6116h();
                aeVar.mo18935b((Node) m5690c(5, h4));
                aeVar.mo18935b(h3);
                Node cmVar8 = new Node(125, cmVar2);
                cmVar8.mo18925a(3, (Object) cmVar3);
                aeVar.mo18935b(cmVar8);
                aeVar.mo18935b(h4);
            }
        }
        cmVar3.mo18935b((Node) aeVar);
        return cmVar3;
    }

    /* renamed from: a */
    private Node m5668a(VariableDeclaration bcVar) {
        Node b;
        List<VariableInitializer> list = bcVar.f6182g;
        int size = list.size();
        int i = 0;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return bcVar;
            }
            VariableInitializer bdVar = (VariableInitializer) it.next();
            AstNode eVar = bdVar.f6184g;
            AstNode eVar2 = bdVar.f6185h;
            if (bdVar.mo18725n()) {
                m5695d(eVar);
                b = eVar;
            } else {
                b = m5686b(eVar);
            }
            Node cmVar = null;
            if (eVar2 != null) {
                this.f5993l.mo19163b(90);
                cmVar = m5686b(eVar2);
            }
            if (bdVar.mo18725n()) {
                if (cmVar != null) {
                    bcVar.mo18935b(mo18977a(bcVar.f6389a, b, cmVar));
                }
                bcVar.mo18935b(b);
            } else {
                if (cmVar != null) {
                    b.mo18935b(cmVar);
                }
                bcVar.mo18935b(b);
            }
            i = i2 + 1;
            if (i2 < size - 1) {
                this.f5993l.mo19163b(89);
            }
        }
    }

    /* renamed from: a */
    private Node m5669a(WhileLoop beVar) {
        this.f5993l.mo19163b(117);
        beVar.mo18730a(132);
        mo18984a((Scope) beVar);
        try {
            this.f5993l.mo19163b(87);
            Node b = m5686b(beVar.f6186g);
            this.f5993l.mo19163b(88);
            this.f5993l.mo19165c(85);
            Node b2 = m5686b(beVar.mo18725n());
            this.f5993l.mo19165c(86);
            return m5659a((Jump) beVar, 1, b2, b, (Node) null, (Node) null);
        } finally {
            mo18979a();
        }
    }

    /* renamed from: a */
    private Node m5670a(XmlLiteral bkVar) {
        Node b;
        Node a;
        Node cmVar = new Node(30, bkVar.mo18794f());
        List<XmlFragment> list = bkVar.f6197g;
        cmVar.mo18935b(mo18986b(((XmlString) list.get(0)).f6202g.trim().startsWith("<>") ? "XMLList" : "XML"));
        Node cmVar2 = null;
        Iterator it = list.iterator();
        while (true) {
            Node cmVar3 = cmVar2;
            if (it.hasNext()) {
                XmlFragment bjVar = (XmlFragment) it.next();
                if (bjVar instanceof XmlString) {
                    String str = ((XmlString) bjVar).f6202g;
                    this.f5993l.mo19162a(str);
                    if (cmVar3 == null) {
                        cmVar2 = Node.m6112a(str);
                    } else {
                        cmVar2 = m5685b(21, cmVar3, Node.m6112a(str));
                    }
                } else {
                    XmlExpression biVar = (XmlExpression) bjVar;
                    boolean z = biVar.f6196h;
                    this.f5993l.mo19163b(85);
                    if (biVar.f6195g instanceof EmptyExpression) {
                        b = Node.m6112a("");
                    } else {
                        b = m5686b(biVar.f6195g);
                    }
                    this.f5993l.mo19163b(86);
                    if (z) {
                        a = m5685b(21, m5685b(21, Node.m6112a("\""), m5655a(75, b)), Node.m6112a("\""));
                    } else {
                        a = m5655a(76, b);
                    }
                    cmVar2 = m5685b(21, cmVar3, a);
                }
            } else {
                cmVar.mo18935b(cmVar3);
                return cmVar;
            }
        }
    }

    /* renamed from: a */
    private Node m5681a(Node cmVar, XmlRef bnVar, int i) {
        if ((i & 2) != 0) {
            this.f5993l.mo19163b(147);
        }
        Name n = bnVar.mo18725n();
        String str = n != null ? n.f6130g : null;
        if (str != null) {
            this.f5993l.mo19162a(str);
            this.f5993l.mo19163b(144);
        }
        if (bnVar instanceof XmlPropRef) {
            String str2 = ((XmlPropRef) bnVar).f6198g.f6130g;
            this.f5993l.mo19162a(str2);
            return m5679a(cmVar, str, str2, i);
        }
        this.f5993l.mo19163b(83);
        Node b = m5686b(((XmlElemRef) bnVar).f6192g);
        this.f5993l.mo19163b(84);
        if (str != null || i != 0) {
            return m5680a(cmVar, str, b, i);
        }
        if (cmVar != null) {
            return new Node(36, cmVar, b);
        }
        throw Kit.m5810a();
    }

    /* renamed from: a */
    private static Node m5678a(Node cmVar, int i) {
        return new Node(133, cmVar, i);
    }

    /* renamed from: a */
    private static Node m5676a(FunctionNode xVar, int i, Node cmVar, int i2) {
        xVar.f6260q = i2;
        xVar.mo18935b(cmVar);
        if (xVar.mo18726o() != 0) {
            xVar.f6261r = true;
        }
        if (i2 == 2) {
            Name akVar = xVar.f6254h;
            if (!(akVar == null || akVar.mo18725n() == 0 || xVar.mo18751d(akVar.f6130g) != null)) {
                xVar.mo18747a(new Symbol(109, akVar.f6130g));
                cmVar.mo18939c(new Node(133, new Node(8, Node.m6111a(49, akVar.f6130g), new Node(63))));
            }
        }
        Node c = cmVar.mo18938c();
        if (c == null || c.f6389a != 4) {
            cmVar.mo18935b(new Node(4));
        }
        Node a = Node.m6111a(109, xVar.mo18725n());
        a.mo18933b(1, i);
        return a;
    }

    /* renamed from: a */
    private static Node m5659a(Jump aeVar, int i, Node cmVar, Node cmVar2, Node cmVar3, Node cmVar4) {
        Node h = Node.m6116h();
        Node h2 = Node.m6116h();
        if (i == 2 && cmVar2.f6389a == 128) {
            cmVar2 = new Node(45);
        }
        Jump aeVar2 = new Jump(6, cmVar2);
        aeVar2.f6117w = h;
        Node h3 = Node.m6116h();
        aeVar.mo18935b(h);
        aeVar.mo18943d(cmVar);
        if (i == 1 || i == 2) {
            aeVar.mo18943d(new Node(128, aeVar.mo18794f()));
        }
        aeVar.mo18935b(h2);
        aeVar.mo18935b((Node) aeVar2);
        aeVar.mo18935b(h3);
        aeVar.f6117w = h3;
        if (i == 1 || i == 2) {
            aeVar.mo18927a((Node) m5690c(5, h2));
            if (i == 2) {
                int i2 = cmVar3.f6389a;
                if (i2 != 128) {
                    if (!(i2 == 122 || i2 == 153)) {
                        cmVar3 = new Node(133, cmVar3);
                    }
                    aeVar.mo18927a(cmVar3);
                }
                h2 = Node.m6116h();
                aeVar.mo18936b(h2, cmVar);
                if (cmVar4.f6389a != 128) {
                    aeVar.mo18936b(new Node(133, cmVar4), h2);
                }
            }
        }
        if (aeVar.f6389a != 132) {
            throw Kit.m5810a();
        } else if (h2.f6389a != 131) {
            throw Kit.m5810a();
        } else if (aeVar.f6118x != null) {
            throw Kit.m5810a();
        } else {
            aeVar.f6118x = h2;
            return aeVar;
        }
    }

    /* renamed from: a */
    private Node m5656a(int i, Node cmVar, Node cmVar2, Node cmVar3, Node cmVar4, boolean z) {
        int i2;
        Node cmVar5;
        Node a;
        int i3 = -1;
        int i4 = 0;
        int i5 = cmVar2.f6389a;
        if (i5 == 122 || i5 == 153) {
            cmVar5 = cmVar2.mo18938c();
            int i6 = cmVar5.f6389a;
            if (i6 == 65 || i6 == 66) {
                i4 = 0;
                if (cmVar5 instanceof ArrayLiteral) {
                    i4 = ((ArrayLiteral) cmVar5).f6205g;
                    i2 = i6;
                    i3 = i6;
                } else {
                    i2 = i6;
                    i3 = i6;
                }
            } else if (i6 == 39) {
                cmVar5 = Node.m6111a(39, ((Name) cmVar5).f6130g);
                i2 = i5;
            } else {
                mo18981a("msg.bad.for.in.lhs");
                return null;
            }
        } else if (i5 == 65 || i5 == 66) {
            i4 = 0;
            if (cmVar2 instanceof ArrayLiteral) {
                i4 = ((ArrayLiteral) cmVar2).f6205g;
                i2 = i5;
                cmVar5 = cmVar2;
                i3 = i5;
            } else {
                i2 = i5;
                cmVar5 = cmVar2;
                i3 = i5;
            }
        } else {
            cmVar5 = m5693c(cmVar2);
            if (cmVar5 == null) {
                mo18981a("msg.bad.for.in.lhs");
                return null;
            }
            i2 = i5;
        }
        Node cmVar6 = new Node(141);
        int i7 = z ? 59 : i3 != -1 ? 60 : 58;
        Node cmVar7 = new Node(i7, cmVar3);
        cmVar7.mo18925a(3, (Object) cmVar6);
        Node cmVar8 = new Node(61);
        cmVar8.mo18925a(3, (Object) cmVar6);
        Node cmVar9 = new Node(62);
        cmVar9.mo18925a(3, (Object) cmVar6);
        Node cmVar10 = new Node(129);
        if (i3 != -1) {
            Node a2 = mo18977a(i, cmVar5, cmVar9);
            if (z || (i3 != 66 && i4 == 2)) {
                a = a2;
            } else {
                mo18981a("msg.bad.for.in.destruct");
                a = a2;
            }
        } else {
            a = mo18978a(cmVar5, cmVar9);
        }
        cmVar10.mo18935b(new Node(133, a));
        cmVar10.mo18935b(cmVar4);
        Node a3 = m5659a((Jump) cmVar, 1, cmVar10, cmVar8, (Node) null, (Node) null);
        a3.mo18927a(cmVar7);
        if (i2 == 122 || i2 == 153) {
            a3.mo18927a(cmVar2);
        }
        cmVar6.mo18935b(a3);
        return cmVar6;
    }

    /* renamed from: a */
    private Node m5682a(Node cmVar, Node cmVar2, int i) {
        mo18987b();
        Node cmVar3 = new Node(129, i);
        cmVar3.mo18935b(new Node(2, cmVar));
        cmVar3.mo18943d(new Node(123, cmVar2, i));
        cmVar3.mo18935b(new Node(3));
        return cmVar3;
    }

    /* renamed from: a */
    private static Node m5683a(Node cmVar, Node cmVar2, Node cmVar3, int i) {
        int d = m5694d(cmVar);
        if (d == 1) {
            return cmVar2;
        }
        if (d != -1) {
            Node cmVar4 = new Node(129, i);
            Node h = Node.m6116h();
            Jump aeVar = new Jump(7, cmVar);
            aeVar.f6117w = h;
            cmVar4.mo18935b((Node) aeVar);
            cmVar4.mo18943d(cmVar2);
            if (cmVar3 != null) {
                Node h2 = Node.m6116h();
                cmVar4.mo18935b((Node) m5690c(5, h2));
                cmVar4.mo18935b(h);
                cmVar4.mo18943d(cmVar3);
                cmVar4.mo18935b(h2);
            } else {
                cmVar4.mo18935b(h);
            }
            return cmVar4;
        } else if (cmVar3 != null) {
            return cmVar3;
        } else {
            return new Node(129, i);
        }
    }

    /* renamed from: a */
    private static Node m5655a(int i, Node cmVar) {
        int i2;
        Node cmVar2;
        int i3 = cmVar.f6389a;
        switch (i) {
            case 26:
                int d = m5694d(cmVar);
                if (d != 0) {
                    if (d == 1) {
                        i2 = 44;
                    } else {
                        i2 = 45;
                    }
                    if (i3 != 45 && i3 != 44) {
                        return new Node(i2);
                    }
                    cmVar.mo18730a(i2);
                    return cmVar;
                }
                break;
            case 27:
                if (i3 == 40) {
                    cmVar.mo18931b((double) (ScriptRuntime.m6433d(((NumberLiteral) cmVar).f6133g) ^ -1));
                    return cmVar;
                }
                break;
            case 29:
                if (i3 == 40) {
                    cmVar.mo18931b(-((NumberLiteral) cmVar).f6133g);
                    return cmVar;
                }
                break;
            case 31:
                if (i3 == 39) {
                    cmVar.mo18730a(49);
                    cmVar2 = new Node(i, cmVar, Node.m6112a(((Name) cmVar).f6130g));
                } else if (i3 == 33 || i3 == 36) {
                    Node b = cmVar.mo18930b();
                    Node c = cmVar.mo18938c();
                    cmVar.mo18947e(b);
                    cmVar.mo18947e(c);
                    cmVar2 = new Node(i, b, c);
                } else if (i3 == 67) {
                    Node b2 = cmVar.mo18930b();
                    cmVar.mo18947e(b2);
                    cmVar2 = new Node(69, b2);
                } else {
                    cmVar2 = new Node(i, new Node(45), cmVar);
                }
                return cmVar2;
            case 32:
                if (i3 == 39) {
                    cmVar.mo18730a(137);
                    return cmVar;
                }
                break;
        }
        return new Node(i, cmVar);
    }

    /* renamed from: b */
    private Node m5684b(int i, Node cmVar) {
        int i2;
        int i3 = 0;
        if (cmVar.f6389a == 39) {
            String str = ((Name) cmVar).f6130g;
            if (str.equals("eval")) {
                i3 = 1;
            } else {
                if (str.equals("With")) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                i3 = i2;
            }
        } else if (cmVar.f6389a == 33 && ((Name) cmVar.mo18938c()).f6130g.equals("eval")) {
            i3 = 1;
        }
        Node cmVar2 = new Node(i, cmVar);
        if (i3 != 0) {
            mo18987b();
            cmVar2.mo18933b(10, i3);
        }
        return cmVar2;
    }

    /* renamed from: a */
    private Node m5679a(Node cmVar, String str, String str2, int i) {
        if (str != null || i != 0) {
            return m5680a(cmVar, str, Node.m6112a(str2), i | 1);
        }
        if (cmVar == null) {
            return mo18986b(str2);
        }
        mo18982a(str2, 33);
        if (!ScriptRuntime.m6445e(str2)) {
            return new Node(33, cmVar, Node.m6112a(str2));
        }
        Node cmVar2 = new Node(71, cmVar);
        cmVar2.mo18925a(17, (Object) str2);
        return new Node(67, cmVar2);
    }

    /* renamed from: a */
    private Node m5680a(Node cmVar, String str, Node cmVar2, int i) {
        Node cmVar3;
        Node cmVar4;
        if (str == null) {
            cmVar3 = null;
        } else if (str.equals(Marker.ANY_MARKER)) {
            cmVar3 = new Node(42);
        } else {
            cmVar3 = mo18986b(str);
        }
        if (cmVar == null) {
            if (str == null) {
                cmVar4 = new Node(79, cmVar2);
            } else {
                cmVar4 = new Node(80, cmVar3, cmVar2);
            }
        } else if (str == null) {
            cmVar4 = new Node(77, cmVar, cmVar2);
        } else {
            cmVar4 = new Node(78, cmVar, cmVar3, cmVar2);
        }
        if (i != 0) {
            cmVar4.mo18933b(16, i);
        }
        return new Node(67, cmVar4);
    }

    /* renamed from: b */
    private static Node m5685b(int i, Node cmVar, Node cmVar2) {
        String a;
        switch (i) {
            case 21:
                if (cmVar.f6389a == 41) {
                    if (cmVar2.f6389a == 41) {
                        a = ((Name) cmVar2).f6130g;
                    } else if (cmVar2.f6389a == 40) {
                        a = ScriptRuntime.m6347a(((NumberLiteral) cmVar2).f6133g, 10);
                    }
                    cmVar.mo18934b(((Name) cmVar).f6130g.concat(a));
                    return cmVar;
                } else if (cmVar.f6389a == 40) {
                    if (cmVar2.f6389a == 40) {
                        cmVar.mo18931b(((NumberLiteral) cmVar).f6133g + ((NumberLiteral) cmVar2).f6133g);
                        return cmVar;
                    } else if (cmVar2.f6389a == 41) {
                        cmVar2.mo18934b(ScriptRuntime.m6347a(((NumberLiteral) cmVar).f6133g, 10).concat(((Name) cmVar2).f6130g));
                        return cmVar2;
                    }
                }
                break;
            case 22:
                if (cmVar.f6389a == 40) {
                    double d = ((NumberLiteral) cmVar).f6133g;
                    if (cmVar2.f6389a == 40) {
                        cmVar.mo18931b(d - ((NumberLiteral) cmVar2).f6133g);
                        return cmVar;
                    } else if (d == 0.0d) {
                        return new Node(29, cmVar2);
                    }
                } else if (cmVar2.f6389a == 40 && ((NumberLiteral) cmVar2).f6133g == 0.0d) {
                    return new Node(28, cmVar);
                }
                break;
            case 23:
                if (cmVar.f6389a == 40) {
                    double d2 = ((NumberLiteral) cmVar).f6133g;
                    if (cmVar2.f6389a == 40) {
                        cmVar.mo18931b(d2 * ((NumberLiteral) cmVar2).f6133g);
                        return cmVar;
                    } else if (d2 == 1.0d) {
                        return new Node(28, cmVar2);
                    }
                } else if (cmVar2.f6389a == 40 && ((NumberLiteral) cmVar2).f6133g == 1.0d) {
                    return new Node(28, cmVar);
                }
                break;
            case 24:
                if (cmVar2.f6389a == 40) {
                    double d3 = ((NumberLiteral) cmVar2).f6133g;
                    if (cmVar.f6389a == 40) {
                        cmVar.mo18931b(((NumberLiteral) cmVar).f6133g / d3);
                        return cmVar;
                    } else if (d3 == 1.0d) {
                        return new Node(28, cmVar);
                    }
                }
                break;
            case 104:
                int d4 = m5694d(cmVar);
                if (d4 == 1) {
                    return cmVar;
                }
                if (d4 == -1) {
                    return cmVar2;
                }
                break;
            case 105:
                int d5 = m5694d(cmVar);
                if (d5 == -1) {
                    return cmVar;
                }
                if (d5 == 1) {
                    return cmVar2;
                }
                break;
        }
        return new Node(i, cmVar, cmVar2);
    }

    /* renamed from: c */
    private Node m5691c(int i, Node cmVar, Node cmVar2) {
        int i2;
        Node c = m5693c(cmVar);
        if (c != null) {
            switch (i) {
                case 90:
                    return mo18978a(c, cmVar2);
                case 91:
                    i2 = 9;
                    break;
                case 92:
                    i2 = 10;
                    break;
                case 93:
                    i2 = 11;
                    break;
                case 94:
                    i2 = 18;
                    break;
                case 95:
                    i2 = 19;
                    break;
                case 96:
                    i2 = 20;
                    break;
                case 97:
                    i2 = 21;
                    break;
                case 98:
                    i2 = 22;
                    break;
                case 99:
                    i2 = 23;
                    break;
                case 100:
                    i2 = 24;
                    break;
                case 101:
                    i2 = 25;
                    break;
                default:
                    throw Kit.m5810a();
            }
            int i3 = c.f6389a;
            switch (i3) {
                case 33:
                case 36:
                    return new Node(i3 == 33 ? 139 : 140, c.mo18930b(), c.mo18938c(), new Node(i2, new Node(138), cmVar2));
                case 39:
                    return new Node(8, Node.m6111a(49, ((Name) c).f6130g), new Node(i2, c, cmVar2));
                case 67:
                    Node b = c.mo18930b();
                    mo18985a(b);
                    return new Node(142, b, new Node(i2, new Node(138), cmVar2));
                default:
                    throw Kit.m5810a();
            }
        } else if (cmVar.f6389a != 65 && cmVar.f6389a != 66) {
            mo18981a("msg.bad.assign.left");
            return cmVar2;
        } else if (i == 90) {
            return mo18977a(-1, cmVar, cmVar2);
        } else {
            mo18981a("msg.bad.destruct.op");
            return cmVar2;
        }
    }

    /* renamed from: b */
    private static Node m5689b(Node cmVar) {
        if (141 != cmVar.f6389a) {
            throw Kit.m5810a();
        }
        Node cmVar2 = new Node(54);
        cmVar2.mo18925a(3, (Object) cmVar);
        return cmVar2;
    }

    /* renamed from: c */
    private static Jump m5690c(int i, Node cmVar) {
        Jump aeVar = new Jump(i);
        aeVar.f6117w = cmVar;
        return aeVar;
    }

    /* renamed from: c */
    private static Node m5693c(Node cmVar) {
        switch (cmVar.f6389a) {
            case 33:
            case 36:
            case 39:
            case 67:
                return cmVar;
            case 38:
                cmVar.mo18730a(70);
                return new Node(67, cmVar);
            default:
                return null;
        }
    }

    /* renamed from: d */
    private static int m5694d(Node cmVar) {
        switch (cmVar.f6389a) {
            case 40:
                double d = ((NumberLiteral) cmVar).f6133g;
                if (d != d || d == 0.0d) {
                    return -1;
                }
                return 1;
            case 42:
            case 44:
                return -1;
            case 45:
                return 1;
            default:
                return 0;
        }
    }

    /* renamed from: b */
    private Node m5687b(FunctionNode xVar) {
        Node cmVar;
        if (xVar.f6254h != null) {
            this.f5993l.mo19162a(xVar.mo18725n());
            cmVar = null;
        } else if (xVar.f6265v != null) {
            cmVar = m5686b(xVar.f6265v);
        } else {
            cmVar = null;
        }
        this.f5993l.mo19163b(87);
        List<AstNode> list = xVar.f6255i != null ? xVar.f6255i : FunctionNode.f6252g;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            m5695d((AstNode) list.get(i2));
            if (i2 < list.size() - 1) {
                this.f5993l.mo19163b(89);
            }
            i = i2 + 1;
        }
        this.f5993l.mo19163b(88);
        if (!xVar.f6257k) {
            this.f5993l.mo19165c(85);
        }
        return cmVar;
    }

    /* renamed from: d */
    private void m5695d(AstNode eVar) {
        int i = 0;
        AstNode eVar2 = eVar;
        while (true) {
            switch (eVar2.f6389a) {
                case 33:
                    PropertyGet aqVar = (PropertyGet) eVar2;
                    m5695d(aqVar.mo18725n());
                    this.f5993l.mo19163b(108);
                    eVar2 = (Name) aqVar.mo18726o();
                case 36:
                    ElementGet pVar = (ElementGet) eVar2;
                    m5695d(pVar.f6234g);
                    this.f5993l.mo19163b(83);
                    m5695d(pVar.f6235h);
                    this.f5993l.mo19163b(84);
                    return;
                case 39:
                    this.f5993l.mo19162a(((Name) eVar2).f6130g);
                    return;
                case 40:
                    this.f5993l.mo19161a(((NumberLiteral) eVar2).f6133g);
                    return;
                case 41:
                    this.f5993l.mo19164b(((StringLiteral) eVar2).f6160g);
                    return;
                case 43:
                    this.f5993l.mo19163b(eVar2.f6389a);
                    return;
                case 65:
                    ArrayLiteral cVar = (ArrayLiteral) eVar2;
                    this.f5993l.mo19163b(83);
                    List n = cVar.mo18725n();
                    int size = n.size();
                    while (i < size) {
                        m5695d((AstNode) n.get(i));
                        if (i < size - 1) {
                            this.f5993l.mo19163b(89);
                        }
                        i++;
                    }
                    this.f5993l.mo19163b(84);
                    return;
                case 66:
                    ObjectLiteral anVar = (ObjectLiteral) eVar2;
                    this.f5993l.mo19163b(85);
                    List n2 = anVar.mo18725n();
                    int size2 = n2.size();
                    while (i < size2) {
                        ObjectProperty aoVar = (ObjectProperty) n2.get(i);
                        boolean equals = Boolean.TRUE.equals(aoVar.mo18937c(26));
                        m5695d(aoVar.mo18725n());
                        if (!equals) {
                            this.f5993l.mo19163b(103);
                            m5695d(aoVar.mo18726o());
                        }
                        if (i < size2 - 1) {
                            this.f5993l.mo19163b(89);
                        }
                        i++;
                    }
                    this.f5993l.mo19163b(86);
                    return;
                case 128:
                    return;
                default:
                    Kit.m5814b("unexpected token: " + Token.m6625a(eVar2.f6389a));
                    return;
            }
        }
    }
}
