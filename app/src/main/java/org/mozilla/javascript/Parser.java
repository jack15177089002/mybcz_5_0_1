package org.mozilla.javascript;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.mozilla.javascript.p110b.ArrayComprehension;
import org.mozilla.javascript.p110b.ArrayComprehensionLoop;
import org.mozilla.javascript.p110b.ArrayLiteral;
import org.mozilla.javascript.p110b.Assignment;
import org.mozilla.javascript.p110b.AstNode;
import org.mozilla.javascript.p110b.AstRoot;
import org.mozilla.javascript.p110b.Block;
import org.mozilla.javascript.p110b.BreakStatement;
import org.mozilla.javascript.p110b.CatchClause;
import org.mozilla.javascript.p110b.Comment;
import org.mozilla.javascript.p110b.ConditionalExpression;
import org.mozilla.javascript.p110b.ContinueStatement;
import org.mozilla.javascript.p110b.DestructuringForm;
import org.mozilla.javascript.p110b.DoLoop;
import org.mozilla.javascript.p110b.ElementGet;
import org.mozilla.javascript.p110b.EmptyExpression;
import org.mozilla.javascript.p110b.EmptyStatement;
import org.mozilla.javascript.p110b.ErrorNode;
import org.mozilla.javascript.p110b.ExpressionStatement;
import org.mozilla.javascript.p110b.FunctionNode;
import org.mozilla.javascript.p110b.GeneratorExpression;
import org.mozilla.javascript.p110b.GeneratorExpressionLoop;
import org.mozilla.javascript.p110b.IdeErrorReporter;
import org.mozilla.javascript.p110b.IfStatement;
import org.mozilla.javascript.p110b.InfixExpression;
import org.mozilla.javascript.p110b.Jump;
import org.mozilla.javascript.p110b.KeywordLiteral;
import org.mozilla.javascript.p110b.Label;
import org.mozilla.javascript.p110b.LabeledStatement;
import org.mozilla.javascript.p110b.LetNode;
import org.mozilla.javascript.p110b.Loop;
import org.mozilla.javascript.p110b.Name;
import org.mozilla.javascript.p110b.NewExpression;
import org.mozilla.javascript.p110b.NumberLiteral;
import org.mozilla.javascript.p110b.ObjectLiteral;
import org.mozilla.javascript.p110b.ObjectProperty;
import org.mozilla.javascript.p110b.ParenthesizedExpression;
import org.mozilla.javascript.p110b.PropertyGet;
import org.mozilla.javascript.p110b.RegExpLiteral;
import org.mozilla.javascript.p110b.ReturnStatement;
import org.mozilla.javascript.p110b.Scope;
import org.mozilla.javascript.p110b.ScriptNode;
import org.mozilla.javascript.p110b.StringLiteral;
import org.mozilla.javascript.p110b.Symbol;
import org.mozilla.javascript.p110b.ThrowStatement;
import org.mozilla.javascript.p110b.TryStatement;
import org.mozilla.javascript.p110b.UnaryExpression;
import org.mozilla.javascript.p110b.VariableDeclaration;
import org.mozilla.javascript.p110b.VariableInitializer;
import org.mozilla.javascript.p110b.WhileLoop;
import org.mozilla.javascript.p110b.WithStatement;
import org.mozilla.javascript.p110b.XmlElemRef;
import org.mozilla.javascript.p110b.XmlExpression;
import org.mozilla.javascript.p110b.XmlLiteral;
import org.mozilla.javascript.p110b.XmlPropRef;
import org.mozilla.javascript.p110b.XmlString;
import org.mozilla.javascript.p110b.Yield;
import org.slf4j.Marker;

/* renamed from: org.mozilla.javascript.ct */
public class Parser {

    /* renamed from: A */
    private int f6426A;

    /* renamed from: a */
    CompilerEnvirons f6427a;

    /* renamed from: b */
    boolean f6428b;

    /* renamed from: c */
    protected int f6429c;

    /* renamed from: d */
    protected boolean f6430d;

    /* renamed from: e */
    ScriptNode f6431e;

    /* renamed from: f */
    Scope f6432f;

    /* renamed from: g */
    int f6433g;

    /* renamed from: h */
    boolean f6434h;

    /* renamed from: i */
    Map<String, LabeledStatement> f6435i = null;

    /* renamed from: j */
    List<Loop> f6436j;

    /* renamed from: k */
    List<Jump> f6437k;

    /* renamed from: l */
    private ErrorReporter f6438l;

    /* renamed from: m */
    private IdeErrorReporter f6439m;

    /* renamed from: n */
    private String f6440n;

    /* renamed from: o */
    private char[] f6441o;

    /* renamed from: p */
    private boolean f6442p;

    /* renamed from: q */
    private TokenStream f6443q;

    /* renamed from: r */
    private int f6444r;

    /* renamed from: s */
    private int f6445s;

    /* renamed from: t */
    private int f6446t;

    /* renamed from: u */
    private List<Comment> f6447u;

    /* renamed from: v */
    private Comment f6448v;

    /* renamed from: w */
    private LabeledStatement f6449w;

    /* renamed from: x */
    private boolean f6450x;

    /* renamed from: y */
    private int f6451y;

    /* renamed from: z */
    private String f6452z;

    public Parser() {
        this(new CompilerEnvirons());
    }

    private Parser(CompilerEnvirons iVar) {
        this(iVar, iVar.f6738a);
    }

    public Parser(CompilerEnvirons iVar, ErrorReporter xVar) {
        this.f6444r = 0;
        this.f6452z = "";
        this.f6427a = iVar;
        this.f6438l = xVar;
        if (xVar instanceof IdeErrorReporter) {
            this.f6439m = (IdeErrorReporter) xVar;
        }
    }

    /* renamed from: c */
    private void m6236c(String str, String str2) {
        if (this.f6427a.f6746i) {
            mo18983a(str, str2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18983a(String str, String str2) {
        m6240d(str, str2);
        if (this.f6427a.f6747j) {
            mo18988b(str, str2);
        } else if (this.f6439m == null) {
            this.f6443q.mo19086c();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo18988b(String str, String str2) {
        int i;
        int i2 = 1;
        this.f6446t++;
        String d = m6240d(str, str2);
        if (this.f6439m == null) {
            String str3 = "";
            if (this.f6443q != null) {
                i = this.f6443q.f6655j;
                str3 = this.f6443q.mo19086c();
                TokenStream efVar = this.f6443q;
                int i3 = efVar.f6658m - efVar.f6653h;
                if (efVar.f6654i >= 0) {
                    i3--;
                }
                i2 = i3;
            } else {
                i = 1;
            }
            this.f6438l.mo19167a(d, this.f6440n, i, str3, i2);
        }
    }

    /* renamed from: d */
    private static String m6240d(String str, String str2) {
        return str2 == null ? ScriptRuntime.m6448f(str) : ScriptRuntime.m6349a(str, (Object) str2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18981a(String str) {
        if (this.f6443q == null) {
            m6235c(str);
        } else {
            m6235c(str);
        }
    }

    /* renamed from: c */
    private void m6235c(String str) {
        mo18988b(str, (String) null);
        if (!this.f6427a.f6751n) {
            throw new C2165cv(0);
        }
    }

    /* renamed from: b */
    private static int m6226b(AstNode eVar) {
        return eVar.mo18798q() + eVar.mo18800s();
    }

    /* renamed from: c */
    private Comment m6233c() {
        Comment kVar = this.f6448v;
        this.f6448v = null;
        return kVar;
    }

    /* renamed from: d */
    private static int m6239d(String str) {
        int i = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) == 10) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: d */
    private int m6237d() {
        boolean z;
        int i;
        String sb;
        int i2;
        if (this.f6444r != 0) {
            return this.f6445s;
        }
        int i3 = this.f6443q.f6655j;
        boolean z2 = false;
        int a = this.f6443q.mo19082a();
        while (true) {
            if (a != 1 && a != 161) {
                break;
            }
            if (a == 1) {
                i = i3 + 1;
                z = true;
            } else if (this.f6427a.f6749l) {
                TokenStream efVar = this.f6443q;
                if (efVar.f6656k != null) {
                    if (efVar.mo19088e()) {
                        Kit.m5810a();
                    }
                    sb = efVar.f6656k.substring(efVar.f6660o, efVar.f6661p);
                } else {
                    if (!efVar.mo19088e()) {
                        Kit.m5810a();
                    }
                    StringBuilder sb2 = new StringBuilder(efVar.f6666u);
                    sb2.append(efVar.f6657l, efVar.f6667v, efVar.mo19087d() - efVar.f6666u.length());
                    efVar.f6667v = -1;
                    sb = sb2.toString();
                }
                if (this.f6447u == null) {
                    this.f6447u = new ArrayList();
                }
                Comment kVar = new Comment(this.f6443q.f6660o, this.f6443q.mo19087d(), this.f6443q.f6662q, sb);
                if (this.f6443q.f6662q == C2192ee.f6639c && this.f6427a.f6750m) {
                    this.f6448v = kVar;
                }
                kVar.f6393e = i3;
                this.f6447u.add(kVar);
                boolean z3 = z2;
                i = m6239d(sb) + i3;
                z = z3;
            } else {
                z = z2;
                i = i3;
            }
            a = this.f6443q.mo19082a();
            i3 = i;
            z2 = z;
        }
        this.f6445s = a;
        if (z2) {
            i2 = 65536;
        } else {
            i2 = 0;
        }
        this.f6444r = i2 | a;
        return this.f6445s;
    }

    /* renamed from: e */
    private int m6242e() {
        int d = m6237d();
        this.f6444r = 0;
        return d;
    }

    /* renamed from: a */
    private boolean m6221a(int i) {
        if (m6237d() != i) {
            return false;
        }
        this.f6444r = 0;
        return true;
    }

    /* renamed from: f */
    private int m6244f() {
        int d = m6237d();
        if ((this.f6444r & 65536) != 0) {
            return 1;
        }
        return d;
    }

    /* renamed from: a */
    private boolean m6223a(int i, String str) {
        if (m6221a(i)) {
            return true;
        }
        m6235c(str);
        return false;
    }

    /* renamed from: g */
    private void m6246g() {
        if (!this.f6427a.f6743f) {
            mo18981a("msg.XML.not.available");
        }
    }

    /* renamed from: h */
    private boolean m6248h() {
        return this.f6429c != 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18984a(Scope atVar) {
        Scope y = atVar.mo18753y();
        if (y == null) {
            this.f6432f.mo18750c(atVar);
        } else if (y != this.f6432f) {
            m6202T();
        }
        this.f6432f = atVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18979a() {
        this.f6432f = this.f6432f.mo18753y();
    }

    /* renamed from: a */
    private void m6219a(Loop ajVar) {
        if (this.f6436j == null) {
            this.f6436j = new ArrayList();
        }
        this.f6436j.add(ajVar);
        if (this.f6437k == null) {
            this.f6437k = new ArrayList();
        }
        this.f6437k.add(ajVar);
        mo18984a((Scope) ajVar);
        if (this.f6449w != null) {
            this.f6449w.mo18732a((AstNode) ajVar);
            Label n = this.f6449w.mo18725n();
            if (n.f6389a != 130) {
                throw Kit.m5810a();
            } else if (n.f6119y != null) {
                throw Kit.m5810a();
            } else {
                n.f6119y = ajVar;
                ajVar.mo18797h(-this.f6449w.mo18798q());
            }
        }
    }

    /* renamed from: i */
    private void m6249i() {
        Loop ajVar = (Loop) this.f6436j.remove(this.f6436j.size() - 1);
        this.f6437k.remove(this.f6437k.size() - 1);
        if (ajVar.mo18801t() != null) {
            ajVar.mo18797h(ajVar.mo18801t().mo18798q());
        }
        mo18979a();
    }

    /* renamed from: j */
    private void m6250j() {
        this.f6437k.remove(this.f6437k.size() - 1);
    }

    /* renamed from: a */
    public final AstRoot mo18976a(String str, String str2, int i) {
        if (this.f6442p) {
            throw new IllegalStateException("parser reused");
        }
        this.f6440n = str2;
        if (this.f6427a.f6753p) {
            this.f6441o = str.toCharArray();
        }
        this.f6443q = new TokenStream(this, null, str, i);
        try {
            AstRoot k = m6251k();
            this.f6442p = true;
            return k;
        } catch (IOException e) {
            throw new IllegalStateException();
        } catch (Throwable th) {
            this.f6442p = true;
            throw th;
        }
    }

    /* renamed from: a */
    public final AstRoot mo18975a(Reader reader, String str, int i) {
        if (this.f6442p) {
            throw new IllegalStateException("parser reused");
        } else if (this.f6427a.f6753p) {
            return mo18976a(m6203a(reader), str, i);
        } else {
            try {
                this.f6440n = str;
                this.f6443q = new TokenStream(this, reader, null, i);
                return m6251k();
            } finally {
                this.f6442p = true;
            }
        }
    }

    /* renamed from: k */
    private AstRoot m6251k() {
        int i;
        AstNode n;
        int i2;
        AstRoot gVar = new AstRoot(0);
        this.f6431e = gVar;
        this.f6432f = gVar;
        int i3 = this.f6443q.f6655j;
        boolean z = this.f6430d;
        this.f6430d = false;
        boolean z2 = true;
        int i4 = 0;
        while (true) {
            try {
                int d = m6237d();
                if (d <= 0) {
                    break;
                }
                if (d == 109) {
                    this.f6444r = 0;
                    try {
                        if (this.f6428b) {
                            i2 = 2;
                        } else {
                            i2 = 1;
                        }
                        n = m6230b(i2);
                    } catch (C2165cv e) {
                    }
                } else {
                    n = m6254n();
                    if (z2) {
                        String c = m6231c(n);
                        if (c == null) {
                            z2 = false;
                        } else if (c.equals("use strict")) {
                            this.f6430d = true;
                            gVar.f6213g = true;
                        }
                    }
                }
                i4 = m6226b(n);
                gVar.mo18935b((Node) n);
                n.mo18790b(gVar);
            } catch (StackOverflowError e2) {
                String d2 = m6240d("msg.too.deep.parser.recursion", null);
                if (!this.f6427a.f6753p) {
                    throw Context.m6759a(d2, this.f6440n, this.f6443q.f6655j);
                }
                this.f6430d = z;
                i = i4;
            } catch (Throwable th) {
                this.f6430d = z;
                throw th;
            }
        }
        this.f6430d = z;
        i = i4;
        if (this.f6446t != 0) {
            String d3 = m6240d("msg.got.syntax.errors", String.valueOf(this.f6446t));
            if (!this.f6427a.f6753p) {
                throw this.f6438l.mo19168b(d3, this.f6440n, i3, null, 0);
            }
        }
        if (this.f6447u != null) {
            i = Math.max(i, m6226b((AstNode) this.f6447u.get(this.f6447u.size() - 1)));
            for (Comment b : this.f6447u) {
                gVar.mo18803b(b);
            }
        }
        gVar.mo18796g(i + 0);
        gVar.f6148E = this.f6440n;
        gVar.mo18762i(i3);
        gVar.mo18763j(this.f6443q.f6655j);
        return gVar;
    }

    /* renamed from: l */
    private AstNode m6252l() {
        boolean z;
        AstNode b;
        int i;
        if (m6221a(85)) {
            z = false;
        } else if (this.f6427a.f6739b < 180) {
            mo18981a("msg.no.brace.body");
            z = false;
        } else {
            z = true;
        }
        this.f6429c++;
        int i2 = this.f6443q.f6660o;
        Block hVar = new Block(i2);
        boolean z2 = this.f6430d;
        hVar.f6393e = this.f6443q.f6655j;
        if (z) {
            try {
                ReturnStatement asVar = new ReturnStatement(this.f6443q.f6655j);
                asVar.mo18745a(m6264x());
                asVar.mo18925a(25, (Object) Boolean.TRUE);
                hVar.mo18925a(25, (Object) Boolean.TRUE);
                hVar.mo18792c(asVar);
            } catch (C2165cv e) {
                this.f6429c--;
                this.f6430d = z2;
            } catch (Throwable th) {
                this.f6429c--;
                this.f6430d = z2;
                throw th;
            }
        } else {
            boolean z3 = true;
            while (true) {
                switch (m6237d()) {
                    case -1:
                    case 0:
                    case 86:
                        break;
                    case 109:
                        this.f6444r = 0;
                        b = m6230b(1);
                        continue;
                    default:
                        b = m6254n();
                        if (!z3) {
                            break;
                        } else {
                            String c = m6231c(b);
                            if (c != null) {
                                if (!c.equals("use strict")) {
                                    break;
                                } else {
                                    this.f6430d = true;
                                    break;
                                }
                            } else {
                                z3 = false;
                                continue;
                            }
                        }
                }
                hVar.mo18792c(b);
            }
        }
        this.f6429c--;
        this.f6430d = z2;
        int i3 = this.f6443q.f6661p;
        m6233c();
        if (z || !m6223a(86, "msg.no.brace.after.body")) {
            i = i3;
        } else {
            i = this.f6443q.f6661p;
        }
        hVar.mo18796g(i - i2);
        return hVar;
    }

    /* renamed from: c */
    private static String m6231c(AstNode eVar) {
        if (eVar instanceof ExpressionStatement) {
            AstNode eVar2 = ((ExpressionStatement) eVar).f6238g;
            if (eVar2 instanceof StringLiteral) {
                return ((StringLiteral) eVar2).f6160g;
            }
        }
        return null;
    }

    /* renamed from: b */
    private FunctionNode m6230b(int i) {
        AstNode eVar;
        Name akVar;
        AstNode eVar2;
        int i2;
        int i3;
        Name akVar2;
        AstNode eVar3;
        HashMap hashMap = null;
        int i4 = this.f6443q.f6655j;
        int i5 = this.f6443q.f6660o;
        if (m6221a(39)) {
            Name b = m6227b(true, 39);
            if (this.f6430d) {
                String str = b.f6130g;
                if ("eval".equals(str) || "arguments".equals(str)) {
                    mo18981a("msg.bad.id.strict");
                }
            }
            if (!m6221a(87)) {
                if (this.f6427a.f6742e) {
                    eVar3 = m6213a(false, (AstNode) b);
                    akVar2 = null;
                } else {
                    akVar2 = b;
                    eVar3 = null;
                }
                m6223a(87, "msg.no.paren.parms");
                akVar = akVar2;
                eVar = eVar3;
            } else {
                eVar = null;
                akVar = b;
            }
        } else if (!m6221a(87)) {
            if (this.f6427a.f6742e) {
                eVar2 = m6211a(false);
            } else {
                eVar2 = null;
            }
            m6223a(87, "msg.no.paren.parms");
            eVar = eVar2;
            akVar = null;
        } else {
            eVar = null;
            akVar = null;
        }
        if (this.f6445s == 87) {
            i2 = this.f6443q.f6660o;
        } else {
            i2 = -1;
        }
        if (eVar != null) {
            i3 = 2;
        } else {
            i3 = i;
        }
        if (!(i3 == 2 || akVar == null || akVar.mo18725n() <= 0)) {
            mo18980a(109, akVar.f6130g, false);
        }
        FunctionNode xVar = new FunctionNode(i5, akVar);
        xVar.f6260q = i;
        if (i2 != -1) {
            xVar.f6258l = i2 - i5;
        }
        xVar.mo18926a(m6233c());
        C2166cw cwVar = new C2166cw(this, xVar);
        try {
            if (m6221a(88)) {
                xVar.f6259p = this.f6443q.f6660o - xVar.mo18798q();
            } else {
                HashSet hashSet = new HashSet();
                do {
                    int d = m6237d();
                    if (d == 83 || d == 85) {
                        AstNode K = m6193K();
                        m6247g(K);
                        xVar.mo18826a(K);
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        String C = this.f6431e.mo18756C();
                        mo18980a(87, C, false);
                        hashMap.put(C, K);
                    } else if (m6223a(39, "msg.no.parm")) {
                        xVar.mo18826a((AstNode) m6227b(false, 39));
                        String str2 = this.f6443q.f6647b;
                        mo18980a(87, str2, false);
                        if (this.f6430d) {
                            if ("eval".equals(str2) || "arguments".equals(str2)) {
                                mo18981a("msg.bad.id.strict");
                            }
                            if (hashSet.contains(str2)) {
                                mo18988b("msg.dup.param.strict", str2);
                            }
                            hashSet.add(str2);
                        }
                    } else {
                        xVar.mo18826a((AstNode) m6201S());
                    }
                } while (m6221a(89));
                if (hashMap != null) {
                    Node cmVar = new Node(89);
                    for (Entry entry : hashMap.entrySet()) {
                        cmVar.mo18935b(mo18977a(122, (Node) entry.getValue(), mo18986b((String) entry.getKey())));
                    }
                    xVar.mo18925a(23, (Object) cmVar);
                }
                if (m6223a(88, "msg.no.paren.after.parms")) {
                    xVar.f6259p = this.f6443q.f6660o - xVar.mo18798q();
                }
            }
            xVar.mo18828d(m6252l());
            xVar.mo18760d(i5, this.f6443q.f6661p);
            xVar.mo18796g(this.f6443q.f6661p - i5);
            if (this.f6427a.f6746i && !xVar.f6256j.mo18950j()) {
                m6236c((akVar == null || akVar.mo18725n() <= 0) ? "msg.anon.no.return.value" : "msg.no.return.value", akVar == null ? "" : akVar.f6130g);
            }
            if (eVar != null) {
                Kit.m5810a();
                xVar.f6265v = eVar;
                if (eVar != null) {
                    eVar.mo18790b(xVar);
                }
            }
            xVar.f6148E = this.f6440n;
            xVar.mo18762i(i4);
            xVar.mo18763j(this.f6443q.f6655j);
            if (this.f6427a.f6753p) {
                xVar.mo18748b(this.f6432f);
            }
            return xVar;
        } finally {
            cwVar.mo18989a();
        }
    }

    /* renamed from: d */
    private AstNode m6241d(AstNode eVar) {
        if (this.f6445s != 85 && !this.f6427a.f6753p) {
            m6202T();
        }
        int i = this.f6443q.f6660o;
        if (eVar == null) {
            eVar = new Block(i);
        }
        eVar.f6393e = this.f6443q.f6655j;
        while (true) {
            int d = m6237d();
            if (d <= 0 || d == 86) {
                eVar.mo18796g(this.f6443q.f6660o - i);
            } else {
                eVar.mo18792c(m6254n());
            }
        }
        eVar.mo18796g(this.f6443q.f6660o - i);
        return eVar;
    }

    /* renamed from: m */
    private C2164cu m6253m() {
        C2164cu cuVar = new C2164cu(0);
        if (m6223a(87, "msg.no.paren.cond")) {
            cuVar.f6454b = this.f6443q.f6660o;
        }
        cuVar.f6453a = m6263w();
        if (m6223a(88, "msg.no.paren.after.cond")) {
            cuVar.f6455c = this.f6443q.f6660o;
        }
        if (cuVar.f6453a instanceof Assignment) {
            cuVar.f6453a.mo18798q();
            cuVar.f6453a.mo18800s();
            m6236c("msg.equal.as.assign", "");
        }
        return cuVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP_START] */
    /* renamed from: n */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AstNode m6254n() {
        /*
            r4 = this;
            org.mozilla.javascript.ef r0 = r4.f6443q
            int r2 = r0.f6660o
            org.mozilla.javascript.b.e r0 = r4.m6255o()     // Catch:{ cv -> 0x0049 }
            if (r0 == 0) goto L_0x0033
            org.mozilla.javascript.i r1 = r4.f6427a     // Catch:{ cv -> 0x0049 }
            boolean r1 = r1.f6746i     // Catch:{ cv -> 0x0049 }
            if (r1 == 0) goto L_0x002f
            boolean r1 = r0.mo18724k()     // Catch:{ cv -> 0x0049 }
            if (r1 != 0) goto L_0x002f
            int r1 = r0.mo18798q()     // Catch:{ cv -> 0x0049 }
            int r3 = r4.m6238d(r1)     // Catch:{ cv -> 0x0049 }
            java.lang.Math.max(r1, r3)     // Catch:{ cv -> 0x0049 }
            boolean r1 = r0 instanceof org.mozilla.javascript.p110b.EmptyStatement     // Catch:{ cv -> 0x0049 }
            if (r1 == 0) goto L_0x0030
            java.lang.String r1 = "msg.extra.trailing.semi"
        L_0x0027:
            java.lang.String r3 = ""
            m6245f(r0)     // Catch:{ cv -> 0x0049 }
            r4.m6236c(r1, r3)     // Catch:{ cv -> 0x0049 }
        L_0x002f:
            return r0
        L_0x0030:
            java.lang.String r1 = "msg.no.side.effects"
            goto L_0x0027
        L_0x0033:
            int r0 = r4.m6244f()
            r1 = 0
            r4.f6444r = r1
            switch(r0) {
                case -1: goto L_0x003e;
                case 0: goto L_0x003e;
                case 1: goto L_0x003e;
                case 82: goto L_0x003e;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0033
        L_0x003e:
            org.mozilla.javascript.b.r r0 = new org.mozilla.javascript.b.r
            org.mozilla.javascript.ef r1 = r4.f6443q
            int r1 = r1.f6660o
            int r1 = r1 - r2
            r0.<init>(r2, r1)
            goto L_0x002f
        L_0x0049:
            r0 = move-exception
            goto L_0x0033
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.m6254n():org.mozilla.javascript.b.e");
    }

    /* renamed from: o */
    private AstNode m6255o() {
        AstNode v;
        int i;
        Name akVar;
        int i2;
        Name akVar2;
        int i3;
        int i4;
        int i5;
        AstNode eVar;
        boolean z;
        int i6;
        List list;
        int i7;
        if (!(this.f6449w == null || this.f6449w.f6122h == null)) {
            this.f6449w = null;
        }
        int d = m6237d();
        switch (d) {
            case -1:
                this.f6444r = 0;
                return m6201S();
            case 4:
            case 72:
                v = m6207a(d, false);
                break;
            case 39:
                v = m6262v();
                if (!(v instanceof ExpressionStatement)) {
                    return v;
                }
                break;
            case 50:
                if (this.f6445s != 50) {
                    m6202T();
                }
                this.f6444r = 0;
                int i8 = this.f6443q.f6660o;
                int i9 = this.f6443q.f6655j;
                if (m6244f() == 1) {
                    mo18981a("msg.bad.throw.eol");
                }
                AstNode w = m6263w();
                AstNode azVar = new ThrowStatement(i8, m6226b(w), w);
                azVar.f6393e = i9;
                v = azVar;
                break;
            case 81:
                if (this.f6445s != 81) {
                    m6202T();
                }
                this.f6444r = 0;
                Comment c = m6233c();
                int i10 = this.f6443q.f6660o;
                int i11 = this.f6443q.f6655j;
                if (m6237d() != 85) {
                    mo18981a("msg.no.brace.try");
                }
                AstNode n = m6254n();
                int b = m6226b(n);
                List list2 = null;
                boolean z2 = false;
                int d2 = m6237d();
                if (d2 == 124) {
                    while (m6221a(124)) {
                        int i12 = this.f6443q.f6655j;
                        if (z2) {
                            mo18981a("msg.catch.unreachable");
                        }
                        int i13 = this.f6443q.f6660o;
                        int i14 = -1;
                        if (m6223a(87, "msg.no.paren.catch")) {
                            i4 = this.f6443q.f6660o;
                        } else {
                            i4 = -1;
                        }
                        m6223a(39, "msg.bad.catchcond");
                        Name b2 = m6227b(false, 39);
                        String str = b2.f6130g;
                        if (this.f6430d && ("eval".equals(str) || "arguments".equals(str))) {
                            mo18981a("msg.bad.id.strict");
                        }
                        if (m6221a(112)) {
                            i5 = this.f6443q.f6660o;
                            eVar = m6263w();
                            z = z2;
                        } else {
                            i5 = -1;
                            eVar = null;
                            z = true;
                        }
                        if (m6223a(88, "msg.bad.catchcond")) {
                            i14 = this.f6443q.f6660o;
                        }
                        m6223a(85, "msg.no.brace.catchblock");
                        Block hVar = (Block) m6241d((AstNode) null);
                        int b3 = m6226b((AstNode) hVar);
                        CatchClause jVar = new CatchClause(i13);
                        jVar.mo18805a(b2);
                        jVar.f6218h = eVar;
                        if (eVar != null) {
                            eVar.mo18790b(jVar);
                        }
                        jVar.mo18806a(hVar);
                        if (i5 != -1) {
                            jVar.f6220j = i5 - i13;
                        }
                        jVar.f6221k = i4;
                        jVar.f6222l = i14;
                        jVar.f6393e = i12;
                        if (m6223a(86, "msg.no.brace.after.body")) {
                            i6 = this.f6443q.f6661p;
                        } else {
                            i6 = b3;
                        }
                        jVar.mo18796g(i6 - i13);
                        if (list2 == null) {
                            list = new ArrayList();
                        } else {
                            list = list2;
                        }
                        list.add(jVar);
                        list2 = list;
                        z2 = z;
                        b = i6;
                    }
                } else if (d2 != 125) {
                    m6223a(125, "msg.try.no.catchfinally");
                }
                AstNode eVar2 = null;
                if (m6221a(125)) {
                    i3 = this.f6443q.f6660o;
                    eVar2 = m6254n();
                    b = m6226b(eVar2);
                } else {
                    i3 = -1;
                }
                TryStatement baVar = new TryStatement(i10, b - i10);
                baVar.mo18775a(n);
                baVar.mo18774a(list2);
                baVar.f6178j = eVar2;
                if (eVar2 != null) {
                    eVar2.mo18790b(baVar);
                }
                if (i3 != -1) {
                    baVar.f6179k = i3 - i10;
                }
                baVar.f6393e = i11;
                if (c != null) {
                    baVar.mo18926a(c);
                }
                return baVar;
            case 82:
                this.f6444r = 0;
                int i15 = this.f6443q.f6660o;
                EmptyStatement rVar = new EmptyStatement(i15, this.f6443q.f6661p - i15);
                rVar.f6393e = this.f6443q.f6655j;
                return rVar;
            case 85:
                return m6261u();
            case 109:
                this.f6444r = 0;
                return m6230b(3);
            case 112:
                if (this.f6445s != 112) {
                    m6202T();
                }
                this.f6444r = 0;
                int i16 = this.f6443q.f6660o;
                int i17 = this.f6443q.f6655j;
                C2164cu m = m6253m();
                AstNode n2 = m6254n();
                AstNode eVar3 = null;
                if (m6221a(113)) {
                    int i18 = this.f6443q.f6660o - i16;
                    eVar3 = m6254n();
                    i7 = i18;
                } else {
                    i7 = -1;
                }
                IfStatement acVar = new IfStatement(i16, m6226b(eVar3 != null ? eVar3 : n2) - i16);
                acVar.mo18718a(m.f6453a);
                int i19 = m.f6454b - i16;
                int i20 = m.f6455c - i16;
                acVar.f6112k = i19;
                acVar.f6113l = i20;
                acVar.mo18719d(n2);
                acVar.f6111j = eVar3;
                if (eVar3 != null) {
                    eVar3.mo18790b(acVar);
                }
                acVar.f6110i = i7;
                acVar.f6393e = i17;
                return acVar;
            case 114:
                return m6256p();
            case 116:
                if (this.f6445s != 116) {
                    m6202T();
                }
                this.f6444r = 0;
                m6246g();
                mo18987b();
                int i21 = this.f6443q.f6655j;
                int i22 = this.f6443q.f6660o;
                if (!m6221a(39) || !"xml".equals(this.f6443q.f6647b)) {
                    mo18981a("msg.bad.namespace");
                }
                if (!m6221a(39) || !"namespace".equals(this.f6443q.f6647b)) {
                    mo18981a("msg.bad.namespace");
                }
                if (!m6221a(90)) {
                    mo18981a("msg.bad.namespace");
                }
                AstNode w2 = m6263w();
                UnaryExpression bbVar = new UnaryExpression(i22, m6226b(w2) - i22);
                bbVar.mo18777i(74);
                bbVar.mo18776a(w2);
                bbVar.f6393e = i21;
                v = new ExpressionStatement(bbVar, true);
                break;
            case 117:
                return m6257q();
            case 118:
                return m6258r();
            case 119:
                return m6259s();
            case 120:
                if (this.f6445s != 120) {
                    m6202T();
                }
                this.f6444r = 0;
                int i23 = this.f6443q.f6655j;
                int i24 = this.f6443q.f6660o;
                int i25 = this.f6443q.f6661p;
                if (m6244f() == 39) {
                    Name b4 = m6227b(false, 39);
                    i2 = m6226b((AstNode) b4);
                    akVar2 = b4;
                } else {
                    i2 = i25;
                    akVar2 = null;
                }
                LabeledStatement t = m6260t();
                Jump n3 = t == null ? null : t.mo18725n();
                if (n3 == null && akVar2 == null) {
                    if (this.f6437k == null || this.f6437k.size() == 0) {
                        m6235c("msg.bad.break");
                    } else {
                        n3 = (Jump) this.f6437k.get(this.f6437k.size() - 1);
                    }
                }
                BreakStatement iVar = new BreakStatement(i24, i2 - i24);
                iVar.f6215g = akVar2;
                if (akVar2 != null) {
                    akVar2.mo18790b(iVar);
                }
                if (n3 != null) {
                    iVar.mo18804a(n3);
                }
                iVar.f6393e = i23;
                v = iVar;
                break;
            case 121:
                if (this.f6445s != 121) {
                    m6202T();
                }
                this.f6444r = 0;
                int i26 = this.f6443q.f6655j;
                int i27 = this.f6443q.f6660o;
                int i28 = this.f6443q.f6661p;
                if (m6244f() == 39) {
                    Name b5 = m6227b(false, 39);
                    i = m6226b((AstNode) b5);
                    akVar = b5;
                } else {
                    i = i28;
                    akVar = null;
                }
                LabeledStatement t2 = m6260t();
                Loop ajVar = null;
                if (t2 != null || akVar != null) {
                    if (t2 == null || !(t2.f6122h instanceof Loop)) {
                        m6235c("msg.continue.nonloop");
                    }
                    ajVar = t2 == null ? null : (Loop) t2.f6122h;
                } else if (this.f6436j == null || this.f6436j.size() == 0) {
                    mo18981a("msg.continue.outside");
                } else {
                    ajVar = (Loop) this.f6436j.get(this.f6436j.size() - 1);
                }
                ContinueStatement mVar = new ContinueStatement(i27, i - i27);
                if (ajVar != null) {
                    mVar.mo18810a(ajVar);
                }
                mVar.f6230g = akVar;
                if (akVar != null) {
                    akVar.mo18790b(mVar);
                }
                mVar.f6393e = i26;
                v = mVar;
                break;
            case 122:
            case 154:
                this.f6444r = 0;
                int i29 = this.f6443q.f6655j;
                AstNode a = m6205a(this.f6445s, this.f6443q.f6660o, true);
                a.f6393e = i29;
                v = a;
                break;
            case 123:
                if (this.f6430d) {
                    mo18981a("msg.no.with.strict");
                }
                if (this.f6445s != 123) {
                    m6202T();
                }
                this.f6444r = 0;
                Comment c2 = m6233c();
                int i30 = this.f6443q.f6655j;
                int i31 = this.f6443q.f6660o;
                int i32 = -1;
                int i33 = -1;
                if (m6223a(87, "msg.no.paren.with")) {
                    i32 = this.f6443q.f6660o;
                }
                AstNode w3 = m6263w();
                if (m6223a(88, "msg.no.paren.after.with")) {
                    i33 = this.f6443q.f6660o;
                }
                AstNode n4 = m6254n();
                WithStatement bfVar = new WithStatement(i31, m6226b(n4) - i31);
                bfVar.mo18926a(c2);
                bfVar.mo18781a(w3);
                bfVar.mo18782d(n4);
                bfVar.f6189i = i32;
                bfVar.f6190j = i33;
                bfVar.f6393e = i30;
                return bfVar;
            case 153:
                if (this.f6445s != 153) {
                    m6202T();
                }
                this.f6444r = 0;
                int i34 = this.f6443q.f6655j;
                int i35 = this.f6443q.f6660o;
                v = m6237d() == 87 ? m6212a(true, i35) : m6205a(153, i35, true);
                v.f6393e = i34;
                if (!(v instanceof VariableDeclaration) || m6237d() != 82) {
                    return v;
                }
            case 160:
                this.f6444r = 0;
                AstNode afVar = new KeywordLiteral(this.f6443q.f6660o, this.f6443q.f6661p - this.f6443q.f6660o, d);
                afVar.f6393e = this.f6443q.f6655j;
                v = afVar;
                break;
            default:
                int i36 = this.f6443q.f6655j;
                AstNode tVar = new ExpressionStatement(m6263w(), !m6248h());
                tVar.f6393e = i36;
                v = tVar;
                break;
        }
        m6243e(v);
        return v;
    }

    /* renamed from: e */
    private void m6243e(AstNode eVar) {
        m6237d();
        int i = this.f6444r;
        int q = eVar.mo18798q();
        switch (65535 & i) {
            case -1:
            case 0:
            case 86:
                m6234c(q, m6245f(eVar));
                return;
            case 82:
                this.f6444r = 0;
                eVar.mo18796g(this.f6443q.f6661p - q);
                return;
            default:
                if ((i & 65536) == 0) {
                    mo18981a("msg.no.semi.stmt");
                    return;
                } else {
                    m6234c(q, m6245f(eVar));
                    return;
                }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008c, code lost:
        r6 = new org.mozilla.javascript.p110b.SwitchCase(r4);
        r6.f6162g = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0093, code lost:
        if (r0 == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0095, code lost:
        r0.mo18790b(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0098, code lost:
        r6.mo18796g(r8.f6443q.f6661p - r2);
        r6.f6393e = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a2, code lost:
        r0 = m6237d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a8, code lost:
        if (r0 == 86) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ac, code lost:
        if (r0 == 115) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
        if (r0 == 116) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b2, code lost:
        if (r0 == 0) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b4, code lost:
        r6.mo18770a(m6254n());
     */
    /* renamed from: p */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.mozilla.javascript.p110b.SwitchStatement m6256p() {
        /*
            r8 = this;
            r1 = 0
            int r0 = r8.f6445s
            r2 = 114(0x72, float:1.6E-43)
            if (r0 == r2) goto L_0x000a
            r8.m6202T()
        L_0x000a:
            r8.f6444r = r1
            org.mozilla.javascript.ef r0 = r8.f6443q
            int r2 = r0.f6660o
            org.mozilla.javascript.b.ax r3 = new org.mozilla.javascript.b.ax
            r3.<init>(r2)
            r0 = 87
            java.lang.String r4 = "msg.no.paren.switch"
            boolean r0 = r8.m6223a(r0, r4)
            if (r0 == 0) goto L_0x0026
            org.mozilla.javascript.ef r0 = r8.f6443q
            int r0 = r0.f6660o
            int r0 = r0 - r2
            r3.f6167j = r0
        L_0x0026:
            org.mozilla.javascript.ef r0 = r8.f6443q
            int r0 = r0.f6655j
            r3.f6393e = r0
            org.mozilla.javascript.b.e r0 = r8.m6263w()
            r3.mo18772a(r0)
            java.util.List<org.mozilla.javascript.b.ae> r0 = r8.f6437k
            if (r0 != 0) goto L_0x003e
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r8.f6437k = r0
        L_0x003e:
            java.util.List<org.mozilla.javascript.b.ae> r0 = r8.f6437k
            r0.add(r3)
            r0 = 88
            java.lang.String r4 = "msg.no.paren.after.switch"
            boolean r0 = r8.m6223a(r0, r4)     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0054
            org.mozilla.javascript.ef r0 = r8.f6443q     // Catch:{ all -> 0x007c }
            int r0 = r0.f6660o     // Catch:{ all -> 0x007c }
            int r0 = r0 - r2
            r3.f6168k = r0     // Catch:{ all -> 0x007c }
        L_0x0054:
            r0 = 85
            java.lang.String r4 = "msg.no.brace.switch"
            r8.m6223a(r0, r4)     // Catch:{ all -> 0x007c }
        L_0x005b:
            int r0 = r8.m6242e()     // Catch:{ all -> 0x007c }
            org.mozilla.javascript.ef r4 = r8.f6443q     // Catch:{ all -> 0x007c }
            int r4 = r4.f6660o     // Catch:{ all -> 0x007c }
            org.mozilla.javascript.ef r5 = r8.f6443q     // Catch:{ all -> 0x007c }
            int r5 = r5.f6655j     // Catch:{ all -> 0x007c }
            switch(r0) {
                case 86: goto L_0x0073;
                case 115: goto L_0x0081;
                case 116: goto L_0x00bc;
                default: goto L_0x006a;
            }     // Catch:{ all -> 0x007c }
        L_0x006a:
            java.lang.String r0 = "msg.bad.switch"
            r8.mo18981a(r0)     // Catch:{ all -> 0x007c }
        L_0x006f:
            r8.m6250j()
            return r3
        L_0x0073:
            org.mozilla.javascript.ef r0 = r8.f6443q     // Catch:{ all -> 0x007c }
            int r0 = r0.f6661p     // Catch:{ all -> 0x007c }
            int r0 = r0 - r2
            r3.mo18796g(r0)     // Catch:{ all -> 0x007c }
            goto L_0x006f
        L_0x007c:
            r0 = move-exception
            r8.m6250j()
            throw r0
        L_0x0081:
            org.mozilla.javascript.b.e r0 = r8.m6263w()     // Catch:{ all -> 0x007c }
            r6 = 103(0x67, float:1.44E-43)
            java.lang.String r7 = "msg.no.colon.case"
            r8.m6223a(r6, r7)     // Catch:{ all -> 0x007c }
        L_0x008c:
            org.mozilla.javascript.b.aw r6 = new org.mozilla.javascript.b.aw     // Catch:{ all -> 0x007c }
            r6.<init>(r4)     // Catch:{ all -> 0x007c }
            r6.f6162g = r0     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0098
            r0.mo18790b(r6)     // Catch:{ all -> 0x007c }
        L_0x0098:
            org.mozilla.javascript.ef r0 = r8.f6443q     // Catch:{ all -> 0x007c }
            int r0 = r0.f6661p     // Catch:{ all -> 0x007c }
            int r0 = r0 - r2
            r6.mo18796g(r0)     // Catch:{ all -> 0x007c }
            r6.f6393e = r5     // Catch:{ all -> 0x007c }
        L_0x00a2:
            int r0 = r8.m6237d()     // Catch:{ all -> 0x007c }
            r4 = 86
            if (r0 == r4) goto L_0x00cd
            r4 = 115(0x73, float:1.61E-43)
            if (r0 == r4) goto L_0x00cd
            r4 = 116(0x74, float:1.63E-43)
            if (r0 == r4) goto L_0x00cd
            if (r0 == 0) goto L_0x00cd
            org.mozilla.javascript.b.e r0 = r8.m6254n()     // Catch:{ all -> 0x007c }
            r6.mo18770a(r0)     // Catch:{ all -> 0x007c }
            goto L_0x00a2
        L_0x00bc:
            if (r1 == 0) goto L_0x00c3
            java.lang.String r0 = "msg.double.switch.default"
            r8.mo18981a(r0)     // Catch:{ all -> 0x007c }
        L_0x00c3:
            r1 = 1
            r0 = 0
            r6 = 103(0x67, float:1.44E-43)
            java.lang.String r7 = "msg.no.colon.case"
            r8.m6223a(r6, r7)     // Catch:{ all -> 0x007c }
            goto L_0x008c
        L_0x00cd:
            r3.mo18771a(r6)     // Catch:{ all -> 0x007c }
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.m6256p():org.mozilla.javascript.b.ax");
    }

    /* renamed from: q */
    private WhileLoop m6257q() {
        if (this.f6445s != 117) {
            m6202T();
        }
        this.f6444r = 0;
        int i = this.f6443q.f6660o;
        WhileLoop beVar = new WhileLoop(i);
        beVar.f6393e = this.f6443q.f6655j;
        m6219a((Loop) beVar);
        try {
            C2164cu m = m6253m();
            beVar.mo18780d(m.f6453a);
            beVar.mo18737d(m.f6454b - i, m.f6455c - i);
            AstNode n = m6254n();
            beVar.mo18796g(m6226b(n) - i);
            beVar.mo18736a(n);
            return beVar;
        } finally {
            m6249i();
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: r */
    private DoLoop m6258r() {
        if (this.f6445s != 118) {
            m6202T();
        }
        this.f6444r = 0;
        int i = this.f6443q.f6660o;
        DoLoop oVar = new DoLoop(i);
        oVar.f6393e = this.f6443q.f6655j;
        m6219a((Loop) oVar);
        try {
            AstNode n = m6254n();
            m6223a(117, "msg.no.while.do");
            oVar.f6233h = this.f6443q.f6660o - i;
            C2164cu m = m6253m();
            oVar.mo18811d(m.f6453a);
            oVar.mo18737d(m.f6454b - i, m.f6455c - i);
            int b = m6226b(n);
            oVar.mo18736a(n);
            m6249i();
            if (m6221a(82)) {
                b = this.f6443q.f6661p;
            }
            oVar.mo18796g(b - i);
            return oVar;
        } catch (Throwable th) {
            m6249i();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005a A[Catch:{ all -> 0x0176, all -> 0x016b }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0076 A[Catch:{ all -> 0x0176, all -> 0x016b }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0091 A[Catch:{ all -> 0x0176, all -> 0x016b }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009b A[Catch:{ all -> 0x0176, all -> 0x016b }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0102 A[Catch:{ all -> 0x0176, all -> 0x016b }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x015b A[Catch:{ all -> 0x0176, all -> 0x016b }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017e  */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Loop m6259s() {
        /*
            r16 = this;
            r7 = 88
            r6 = 82
            r5 = 0
            r1 = -1
            r8 = 1
            r0 = r16
            int r2 = r0.f6445s
            r3 = 119(0x77, float:1.67E-43)
            if (r2 == r3) goto L_0x0012
            r16.m6202T()
        L_0x0012:
            r0 = r16
            r0.f6444r = r5
            r0 = r16
            org.mozilla.javascript.ef r2 = r0.f6443q
            int r12 = r2.f6660o
            r0 = r16
            org.mozilla.javascript.ef r2 = r0.f6443q
            int r13 = r2.f6655j
            r3 = 0
            org.mozilla.javascript.b.at r14 = new org.mozilla.javascript.b.at
            r14.<init>()
            r0 = r16
            r0.mo18984a(r14)
            r2 = 39
            r0 = r16
            boolean r2 = r0.m6221a(r2)     // Catch:{ all -> 0x016b }
            if (r2 == 0) goto L_0x00fe
            java.lang.String r2 = "each"
            r0 = r16
            org.mozilla.javascript.ef r4 = r0.f6443q     // Catch:{ all -> 0x016b }
            java.lang.String r4 = r4.f6647b     // Catch:{ all -> 0x016b }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x016b }
            if (r2 == 0) goto L_0x00f7
            r0 = r16
            org.mozilla.javascript.ef r2 = r0.f6443q     // Catch:{ all -> 0x016b }
            int r2 = r2.f6660o     // Catch:{ all -> 0x016b }
            int r2 = r2 - r12
            r10 = r2
            r11 = r8
        L_0x004e:
            r2 = 87
            java.lang.String r4 = "msg.no.paren.for"
            r0 = r16
            boolean r2 = r0.m6223a(r2, r4)     // Catch:{ all -> 0x016b }
            if (r2 == 0) goto L_0x017e
            r0 = r16
            org.mozilla.javascript.ef r2 = r0.f6443q     // Catch:{ all -> 0x016b }
            int r2 = r2.f6660o     // Catch:{ all -> 0x016b }
            int r2 = r2 - r12
            r9 = r2
        L_0x0062:
            int r2 = r16.m6237d()     // Catch:{ all -> 0x016b }
            r0 = r16
            org.mozilla.javascript.b.e r2 = r0.m6232c(r2)     // Catch:{ all -> 0x016b }
            r4 = 52
            r0 = r16
            boolean r4 = r0.m6221a(r4)     // Catch:{ all -> 0x016b }
            if (r4 == 0) goto L_0x0102
            r0 = r16
            org.mozilla.javascript.ef r4 = r0.f6443q     // Catch:{ all -> 0x016b }
            int r4 = r4.f6660o     // Catch:{ all -> 0x016b }
            int r5 = r4 - r12
            org.mozilla.javascript.b.e r4 = r16.m6263w()     // Catch:{ all -> 0x016b }
            r6 = r5
            r7 = r8
            r5 = r4
        L_0x0085:
            r4 = 88
            java.lang.String r15 = "msg.no.paren.for.ctrl"
            r0 = r16
            boolean r4 = r0.m6223a(r4, r15)     // Catch:{ all -> 0x016b }
            if (r4 == 0) goto L_0x017b
            r0 = r16
            org.mozilla.javascript.ef r1 = r0.f6443q     // Catch:{ all -> 0x016b }
            int r1 = r1.f6660o     // Catch:{ all -> 0x016b }
            int r1 = r1 - r12
            r4 = r1
        L_0x0099:
            if (r7 == 0) goto L_0x015b
            org.mozilla.javascript.b.u r3 = new org.mozilla.javascript.b.u     // Catch:{ all -> 0x016b }
            r3.<init>(r12)     // Catch:{ all -> 0x016b }
            boolean r1 = r2 instanceof org.mozilla.javascript.p110b.VariableDeclaration     // Catch:{ all -> 0x016b }
            if (r1 == 0) goto L_0x00b7
            r0 = r2
            org.mozilla.javascript.b.bc r0 = (org.mozilla.javascript.p110b.VariableDeclaration) r0     // Catch:{ all -> 0x016b }
            r1 = r0
            java.util.List<org.mozilla.javascript.b.bd> r1 = r1.f6182g     // Catch:{ all -> 0x016b }
            int r1 = r1.size()     // Catch:{ all -> 0x016b }
            if (r1 <= r8) goto L_0x00b7
            java.lang.String r1 = "msg.mult.index"
            r0 = r16
            r0.mo18981a(r1)     // Catch:{ all -> 0x016b }
        L_0x00b7:
            r3.mo18814d(r2)     // Catch:{ all -> 0x016b }
            r3.mo18815e(r5)     // Catch:{ all -> 0x016b }
            r3.mo18816i(r6)     // Catch:{ all -> 0x016b }
            r3.mo18716a(r11)     // Catch:{ all -> 0x016b }
            r3.mo18817j(r10)     // Catch:{ all -> 0x016b }
            r1 = r3
        L_0x00c7:
            r0 = r16
            org.mozilla.javascript.b.at r2 = r0.f6432f     // Catch:{ all -> 0x016b }
            r2.mo18752d(r1)     // Catch:{ all -> 0x016b }
            r16.mo18979a()     // Catch:{ all -> 0x016b }
            r0 = r16
            r0.m6219a(r1)     // Catch:{ all -> 0x016b }
            org.mozilla.javascript.b.e r2 = r16.m6254n()     // Catch:{ all -> 0x0176 }
            int r3 = m6226b(r2)     // Catch:{ all -> 0x0176 }
            int r3 = r3 - r12
            r1.mo18796g(r3)     // Catch:{ all -> 0x0176 }
            r1.mo18736a(r2)     // Catch:{ all -> 0x0176 }
            r16.m6249i()     // Catch:{ all -> 0x016b }
            r0 = r16
            org.mozilla.javascript.b.at r2 = r0.f6432f
            if (r2 != r14) goto L_0x00f1
            r16.mo18979a()
        L_0x00f1:
            r1.mo18737d(r9, r4)
            r1.f6393e = r13
            return r1
        L_0x00f7:
            java.lang.String r2 = "msg.no.paren.for"
            r0 = r16
            r0.mo18981a(r2)     // Catch:{ all -> 0x016b }
        L_0x00fe:
            r10 = r1
            r11 = r5
            goto L_0x004e
        L_0x0102:
            r3 = 82
            java.lang.String r4 = "msg.no.semi.for"
            r0 = r16
            r0.m6223a(r3, r4)     // Catch:{ all -> 0x016b }
            int r3 = r16.m6237d()     // Catch:{ all -> 0x016b }
            if (r3 != r6) goto L_0x014d
            org.mozilla.javascript.b.q r4 = new org.mozilla.javascript.b.q     // Catch:{ all -> 0x016b }
            r0 = r16
            org.mozilla.javascript.ef r3 = r0.f6443q     // Catch:{ all -> 0x016b }
            int r3 = r3.f6660o     // Catch:{ all -> 0x016b }
            r6 = 1
            r4.<init>(r3, r6)     // Catch:{ all -> 0x016b }
            r0 = r16
            org.mozilla.javascript.ef r3 = r0.f6443q     // Catch:{ all -> 0x016b }
            int r3 = r3.f6655j     // Catch:{ all -> 0x016b }
            r4.f6393e = r3     // Catch:{ all -> 0x016b }
        L_0x0125:
            r3 = 82
            java.lang.String r6 = "msg.no.semi.for.cond"
            r0 = r16
            r0.m6223a(r3, r6)     // Catch:{ all -> 0x016b }
            r0 = r16
            org.mozilla.javascript.ef r3 = r0.f6443q     // Catch:{ all -> 0x016b }
            int r6 = r3.f6661p     // Catch:{ all -> 0x016b }
            int r3 = r16.m6237d()     // Catch:{ all -> 0x016b }
            if (r3 != r7) goto L_0x0152
            org.mozilla.javascript.b.q r3 = new org.mozilla.javascript.b.q     // Catch:{ all -> 0x016b }
            r7 = 1
            r3.<init>(r6, r7)     // Catch:{ all -> 0x016b }
            r0 = r16
            org.mozilla.javascript.ef r6 = r0.f6443q     // Catch:{ all -> 0x016b }
            int r6 = r6.f6655j     // Catch:{ all -> 0x016b }
            r3.f6393e = r6     // Catch:{ all -> 0x016b }
            r6 = r1
            r7 = r5
            r5 = r4
            goto L_0x0085
        L_0x014d:
            org.mozilla.javascript.b.e r4 = r16.m6263w()     // Catch:{ all -> 0x016b }
            goto L_0x0125
        L_0x0152:
            org.mozilla.javascript.b.e r3 = r16.m6263w()     // Catch:{ all -> 0x016b }
            r6 = r1
            r7 = r5
            r5 = r4
            goto L_0x0085
        L_0x015b:
            org.mozilla.javascript.b.v r1 = new org.mozilla.javascript.b.v     // Catch:{ all -> 0x016b }
            r1.<init>(r12)     // Catch:{ all -> 0x016b }
            r1.mo18818d(r2)     // Catch:{ all -> 0x016b }
            r1.mo18819e(r5)     // Catch:{ all -> 0x016b }
            r1.mo18820f(r3)     // Catch:{ all -> 0x016b }
            goto L_0x00c7
        L_0x016b:
            r1 = move-exception
            r0 = r16
            org.mozilla.javascript.b.at r2 = r0.f6432f
            if (r2 != r14) goto L_0x0175
            r16.mo18979a()
        L_0x0175:
            throw r1
        L_0x0176:
            r1 = move-exception
            r16.m6249i()     // Catch:{ all -> 0x016b }
            throw r1     // Catch:{ all -> 0x016b }
        L_0x017b:
            r4 = r1
            goto L_0x0099
        L_0x017e:
            r9 = r1
            goto L_0x0062
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.m6259s():org.mozilla.javascript.b.aj");
    }

    /* renamed from: c */
    private AstNode m6232c(int i) {
        AstNode a;
        try {
            this.f6434h = true;
            if (i == 82) {
                a = new EmptyExpression(this.f6443q.f6660o, 1);
                a.f6393e = this.f6443q.f6655j;
            } else if (i == 122 || i == 153) {
                this.f6444r = 0;
                a = m6205a(i, this.f6443q.f6660o, false);
            } else {
                a = m6263w();
                m6247g(a);
            }
            return a;
        } finally {
            this.f6434h = false;
        }
    }

    /* renamed from: t */
    private LabeledStatement m6260t() {
        LabeledStatement ahVar = null;
        if (m6244f() == 39) {
            this.f6444r = 0;
            if (this.f6435i != null) {
                ahVar = (LabeledStatement) this.f6435i.get(this.f6443q.f6647b);
            }
            if (ahVar == null) {
                mo18981a("msg.undef.label");
            }
        }
        return ahVar;
    }

    /* renamed from: a */
    private static final boolean m6222a(int i, int i2, int i3) {
        return (i & i3) != i3 && (i2 & i3) == i3;
    }

    /* renamed from: a */
    private AstNode m6207a(int i, boolean z) {
        AstNode eVar;
        int i2 = 4;
        if (!m6248h()) {
            mo18981a(i == 4 ? "msg.bad.return" : "msg.bad.yield");
        }
        this.f6444r = 0;
        int i3 = this.f6443q.f6655j;
        int i4 = this.f6443q.f6660o;
        int i5 = this.f6443q.f6661p;
        AstNode eVar2 = null;
        switch (m6244f()) {
            case -1:
            case 0:
            case 1:
            case 72:
            case 82:
            case 84:
            case 86:
            case 88:
                break;
            default:
                eVar2 = m6263w();
                i5 = m6226b(eVar2);
                break;
        }
        int i6 = this.f6433g;
        if (i == 4) {
            int i7 = this.f6433g;
            if (eVar2 == null) {
                i2 = 2;
            }
            this.f6433g = i2 | i7;
            ReturnStatement asVar = new ReturnStatement(i4, i5 - i4, eVar2);
            if (m6222a(i6, this.f6433g, 6)) {
                m6236c("msg.return.inconsistent", "");
                eVar = asVar;
            } else {
                eVar = asVar;
            }
        } else {
            if (!m6248h()) {
                mo18981a("msg.bad.yield");
            }
            this.f6433g |= 8;
            AstNode bpVar = new Yield(i4, i5 - i4, eVar2);
            mo18987b();
            if (m6248h()) {
                ((FunctionNode) this.f6431e).f6262s = true;
            }
            eVar = !z ? new ExpressionStatement(bpVar) : bpVar;
        }
        if (m6248h() && m6222a(i6, this.f6433g, 12)) {
            Name akVar = ((FunctionNode) this.f6431e).f6254h;
            if (akVar == null || akVar.mo18725n() == 0) {
                mo18988b("msg.anon.generator.returns", "");
            } else {
                mo18988b("msg.generator.returns", akVar.f6130g);
            }
        }
        eVar.f6393e = i3;
        return eVar;
    }

    /* renamed from: u */
    private AstNode m6261u() {
        if (this.f6445s != 85) {
            m6202T();
        }
        this.f6444r = 0;
        int i = this.f6443q.f6660o;
        Scope atVar = new Scope(i);
        atVar.f6393e = this.f6443q.f6655j;
        mo18984a(atVar);
        try {
            m6241d((AstNode) atVar);
            m6223a(86, "msg.no.brace.block");
            atVar.mo18796g(this.f6443q.f6661p - i);
            return atVar;
        } finally {
            mo18979a();
        }
    }

    /* renamed from: a */
    private void m6218a(Label agVar, LabeledStatement ahVar) {
        if (m6237d() != 103) {
            m6202T();
        }
        this.f6444r = 0;
        String str = agVar.f6120g;
        if (this.f6435i == null) {
            this.f6435i = new HashMap();
        } else {
            LabeledStatement ahVar2 = (LabeledStatement) this.f6435i.get(str);
            if (ahVar2 != null) {
                if (this.f6427a.f6753p) {
                    Label c = ahVar2.mo18733c(str);
                    c.mo18799r();
                    c.mo18800s();
                    m6235c("msg.dup.label");
                }
                agVar.mo18798q();
                agVar.mo18800s();
                m6235c("msg.dup.label");
            }
        }
        ahVar.mo18731a(agVar);
        this.f6435i.put(str, ahVar);
    }

    /* renamed from: v */
    private AstNode m6262v() {
        AstNode eVar;
        AstNode eVar2;
        boolean z = true;
        if (this.f6445s != 39) {
            throw m6202T();
        }
        int i = this.f6443q.f6660o;
        this.f6444r |= 131072;
        AstNode w = m6263w();
        if (w.f6389a != 130) {
            if (m6248h()) {
                z = false;
            }
            ExpressionStatement tVar = new ExpressionStatement(w, z);
            tVar.f6393e = w.f6393e;
            return tVar;
        }
        LabeledStatement ahVar = new LabeledStatement(i);
        m6218a((Label) w, ahVar);
        ahVar.f6393e = this.f6443q.f6655j;
        while (true) {
            if (m6237d() != 39) {
                eVar = null;
                break;
            }
            this.f6444r |= 131072;
            AstNode w2 = m6263w();
            if (w2.f6389a != 130) {
                if (m6248h()) {
                    z = false;
                }
                ExpressionStatement tVar2 = new ExpressionStatement(w2, z);
                m6243e(tVar2);
                eVar = tVar2;
            } else {
                m6218a((Label) w2, ahVar);
            }
        }
        try {
            this.f6449w = ahVar;
            if (eVar == null) {
                eVar2 = m6255o();
            } else {
                eVar2 = eVar;
            }
            this.f6449w = null;
            for (Label agVar : ahVar.f6121g) {
                this.f6435i.remove(agVar.f6120g);
            }
            ahVar.mo18796g(eVar2.mo18801t() == null ? m6226b(eVar2) - i : m6226b(eVar2));
            ahVar.mo18732a(eVar2);
            return ahVar;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.f6449w = null;
            for (Label agVar2 : ahVar.f6121g) {
                this.f6435i.remove(agVar2.f6120g);
            }
            throw th2;
        }
    }

    /* renamed from: a */
    private VariableDeclaration m6205a(int i, int i2, boolean z) {
        int i3;
        AstNode eVar;
        AstNode eVar2;
        int i4;
        AstNode eVar3;
        VariableDeclaration bcVar = new VariableDeclaration(i2);
        bcVar.mo18730a(i);
        bcVar.f6393e = this.f6443q.f6655j;
        Comment c = m6233c();
        if (c != null) {
            bcVar.mo18926a(c);
        }
        do {
            int d = m6237d();
            int i5 = this.f6443q.f6660o;
            int i6 = this.f6443q.f6661p;
            if (d == 83 || d == 85) {
                AstNode K = m6193K();
                int b = m6226b(K);
                if (!(K instanceof DestructuringForm)) {
                    m6235c("msg.bad.assign.left");
                }
                m6247g(K);
                i3 = b;
                eVar = K;
                eVar2 = null;
            } else {
                m6223a(39, "msg.bad.var");
                eVar2 = m6227b(false, 39);
                eVar2.f6393e = this.f6443q.f6655j;
                if (this.f6430d) {
                    if ("eval".equals(this.f6443q.f6647b) || "arguments".equals(this.f6443q.f6647b)) {
                        mo18981a("msg.bad.id.strict");
                    }
                }
                mo18980a(i, this.f6443q.f6647b, this.f6434h);
                i3 = i6;
                eVar = null;
            }
            int i7 = this.f6443q.f6655j;
            Comment c2 = m6233c();
            if (m6221a(90)) {
                eVar3 = m6264x();
                i4 = m6226b(eVar3);
            } else {
                i4 = i3;
                eVar3 = null;
            }
            VariableInitializer bdVar = new VariableInitializer(i5, i4 - i5);
            if (eVar != null) {
                if (eVar3 == null && !this.f6434h) {
                    mo18981a("msg.destruct.assign.no.init");
                }
                bdVar.mo18779a(eVar);
            } else {
                bdVar.mo18779a(eVar2);
            }
            bdVar.f6185h = eVar3;
            if (eVar3 != null) {
                eVar3.mo18790b(bdVar);
            }
            bdVar.mo18730a(i);
            bdVar.mo18926a(c2);
            bdVar.f6393e = i7;
            bcVar.mo18778a(bdVar);
        } while (m6221a(89));
        bcVar.mo18796g(i4 - i2);
        bcVar.f6183h = z;
        return bcVar;
    }

    /* renamed from: a */
    private AstNode m6212a(boolean z, int i) {
        boolean z2 = false;
        LetNode aiVar = new LetNode(i);
        aiVar.f6393e = this.f6443q.f6655j;
        if (m6223a(87, "msg.no.paren.after.let")) {
            aiVar.f6125i = this.f6443q.f6660o - i;
        }
        mo18984a((Scope) aiVar);
        try {
            aiVar.mo18734a(m6205a(153, this.f6443q.f6660o, z));
            if (m6223a(88, "msg.no.paren.let")) {
                aiVar.f6126j = this.f6443q.f6660o - i;
            }
            if (!z || m6237d() != 85) {
                AstNode w = m6263w();
                aiVar.mo18796g(m6226b(w) - i);
                aiVar.mo18735a(w);
                if (z) {
                    if (!m6248h()) {
                        z2 = true;
                    }
                    ExpressionStatement tVar = new ExpressionStatement(aiVar, z2);
                    tVar.f6393e = aiVar.mo18794f();
                    mo18979a();
                    return tVar;
                }
            } else {
                this.f6444r = 0;
                int i2 = this.f6443q.f6660o;
                AstNode d = m6241d((AstNode) null);
                m6223a(86, "msg.no.curly.let");
                d.mo18796g(this.f6443q.f6661p - i2);
                aiVar.mo18796g(this.f6443q.f6661p - i);
                aiVar.mo18735a(d);
                aiVar.mo18730a(153);
            }
            return aiVar;
        } finally {
            mo18979a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo18980a(int i, String str, boolean z) {
        if (str == null) {
            if (!this.f6427a.f6753p) {
                m6202T();
            } else {
                return;
            }
        }
        Scope c = this.f6432f.mo18749c(str);
        Symbol ayVar = c != null ? c.mo18751d(str) : null;
        int i2 = ayVar != null ? ayVar.f6169a : -1;
        if (ayVar == null || !(i2 == 154 || i == 154 || (c == this.f6432f && i2 == 153))) {
            switch (i) {
                case 87:
                    if (ayVar != null) {
                        mo18983a("msg.dup.parms", str);
                    }
                    this.f6431e.mo18747a(new Symbol(i, str));
                    return;
                case 109:
                case 122:
                case 154:
                    if (ayVar == null) {
                        this.f6431e.mo18747a(new Symbol(i, str));
                        return;
                    } else if (i2 == 122) {
                        m6236c("msg.var.redecl", str);
                        return;
                    } else if (i2 == 87) {
                        m6236c("msg.var.hides.arg", str);
                        return;
                    } else {
                        return;
                    }
                case 153:
                    if (z || (this.f6432f.f6389a != 112 && !(this.f6432f instanceof Loop))) {
                        this.f6432f.mo18747a(new Symbol(i, str));
                        return;
                    } else {
                        mo18988b("msg.let.decl.not.in.block", (String) null);
                        return;
                    }
                default:
                    throw m6202T();
            }
        } else {
            String str2 = i2 == 154 ? "msg.const.redecl" : i2 == 153 ? "msg.let.redecl" : i2 == 122 ? "msg.var.redecl" : i2 == 109 ? "msg.fn.redecl" : "msg.parm.redecl";
            mo18988b(str2, str);
        }
    }

    /* renamed from: w */
    private AstNode m6263w() {
        AstNode x = m6264x();
        x.mo18798q();
        while (m6221a(89)) {
            int i = this.f6443q.f6660o;
            if (this.f6427a.f6746i && !x.mo18724k()) {
                m6245f(x);
                m6236c("msg.no.side.effects", "");
            }
            if (m6237d() == 72) {
                mo18981a("msg.yield.parenthesized");
            }
            x = new InfixExpression(89, x, m6264x(), i);
        }
        return x;
    }

    /* renamed from: x */
    private AstNode m6264x() {
        AstNode eVar;
        int d = m6237d();
        if (d == 72) {
            return m6207a(d, true);
        }
        AstNode y = m6265y();
        if (m6221a(102)) {
            int i = this.f6443q.f6655j;
            int i2 = this.f6443q.f6660o;
            int i3 = -1;
            AstNode x = m6264x();
            if (m6223a(103, "msg.no.colon.cond")) {
                i3 = this.f6443q.f6660o;
            }
            AstNode x2 = m6264x();
            int q = y.mo18798q();
            ConditionalExpression lVar = new ConditionalExpression(q, m6226b(x2) - q);
            lVar.f6393e = i;
            lVar.mo18807a(y);
            lVar.mo18808d(x);
            lVar.mo18809e(x2);
            lVar.f6228j = i2 - q;
            lVar.f6229k = i3 - q;
            eVar = lVar;
        } else {
            eVar = y;
        }
        int d2 = m6237d();
        if (90 <= d2 && d2 <= 101) {
            this.f6444r = 0;
            Comment c = m6233c();
            m6247g(eVar);
            Assignment dVar = new Assignment(d2, eVar, m6264x(), this.f6443q.f6660o);
            if (c != null) {
                dVar.mo18926a(c);
            }
            return dVar;
        } else if (d2 != 82 || this.f6448v == null) {
            return eVar;
        } else {
            eVar.mo18926a(m6233c());
            return eVar;
        }
    }

    /* renamed from: y */
    private AstNode m6265y() {
        AstNode z = m6266z();
        if (!m6221a(104)) {
            return z;
        }
        return new InfixExpression(104, z, m6265y(), this.f6443q.f6660o);
    }

    /* renamed from: z */
    private AstNode m6266z() {
        AstNode A = m6183A();
        while (m6221a(9)) {
            A = new InfixExpression(9, A, m6183A(), this.f6443q.f6660o);
        }
        if (!m6221a(105)) {
            return A;
        }
        return new InfixExpression(105, A, m6266z(), this.f6443q.f6660o);
    }

    /* renamed from: A */
    private AstNode m6183A() {
        AstNode B = m6184B();
        while (m6221a(10)) {
            B = new InfixExpression(10, B, m6184B(), this.f6443q.f6660o);
        }
        return B;
    }

    /* renamed from: B */
    private AstNode m6184B() {
        AstNode C = m6185C();
        while (m6221a(11)) {
            C = new InfixExpression(11, C, m6185C(), this.f6443q.f6660o);
        }
        return C;
    }

    /* renamed from: C */
    private AstNode m6185C() {
        AstNode D = m6186D();
        while (true) {
            int d = m6237d();
            int i = this.f6443q.f6660o;
            switch (d) {
                case 12:
                case 13:
                case 46:
                case 47:
                    this.f6444r = 0;
                    if (this.f6427a.f6739b == 120) {
                        if (d == 12) {
                            d = 46;
                        } else if (d == 13) {
                            d = 47;
                        }
                    }
                    D = new InfixExpression(d, D, m6186D(), i);
                default:
                    return D;
            }
        }
    }

    /* renamed from: D */
    private AstNode m6186D() {
        AstNode E = m6187E();
        while (true) {
            int d = m6237d();
            int i = this.f6443q.f6660o;
            switch (d) {
                case 14:
                case 15:
                case 16:
                case 17:
                case 53:
                    break;
                case 52:
                    if (this.f6434h) {
                        break;
                    } else {
                        continue;
                    }
            }
            this.f6444r = 0;
            E = new InfixExpression(d, E, m6187E(), i);
        }
        return E;
    }

    /* renamed from: E */
    private AstNode m6187E() {
        AstNode F = m6188F();
        while (true) {
            int d = m6237d();
            int i = this.f6443q.f6660o;
            switch (d) {
                case 18:
                case 19:
                case 20:
                    this.f6444r = 0;
                    F = new InfixExpression(d, F, m6188F(), i);
                default:
                    return F;
            }
        }
    }

    /* renamed from: F */
    private AstNode m6188F() {
        AstNode G = m6189G();
        while (true) {
            int d = m6237d();
            int i = this.f6443q.f6660o;
            if (d != 21 && d != 22) {
                return G;
            }
            this.f6444r = 0;
            G = new InfixExpression(d, G, m6189G(), i);
        }
    }

    /* renamed from: G */
    private AstNode m6189G() {
        AstNode H = m6190H();
        while (true) {
            int d = m6237d();
            int i = this.f6443q.f6660o;
            switch (d) {
                case 23:
                case 24:
                case 25:
                    this.f6444r = 0;
                    H = new InfixExpression(d, H, m6190H(), i);
                default:
                    return H;
            }
        }
    }

    /* renamed from: H */
    private AstNode m6190H() {
        int b;
        AstNode eVar;
        int d = m6237d();
        int i = this.f6443q.f6655j;
        switch (d) {
            case -1:
                this.f6444r = 0;
                return m6201S();
            case 14:
                if (this.f6427a.f6743f) {
                    this.f6444r = 0;
                    if (this.f6445s != 14) {
                        m6202T();
                    }
                    int i2 = this.f6443q.f6660o;
                    TokenStream efVar = this.f6443q;
                    efVar.f6665t = 0;
                    efVar.f6663r = false;
                    efVar.f6664s = false;
                    if (!(efVar.f6652g == 0 || efVar.f6651f[efVar.f6652g + -1] != 10)) {
                        b = -1;
                    } else {
                        efVar.mo19085b(60);
                        b = efVar.mo19084b();
                    }
                    if (b == 145 || b == 148) {
                        XmlLiteral bkVar = new XmlLiteral(i2);
                        bkVar.f6393e = this.f6443q.f6655j;
                        while (true) {
                            switch (b) {
                                case 145:
                                    bkVar.mo18784a(new XmlString(this.f6443q.f6660o, this.f6443q.f6647b));
                                    m6223a(85, "msg.syntax");
                                    int i3 = this.f6443q.f6660o;
                                    AstNode w = m6237d() == 86 ? new EmptyExpression(i3, this.f6443q.f6661p - i3) : m6263w();
                                    m6223a(86, "msg.syntax");
                                    XmlExpression biVar = new XmlExpression(i3, w);
                                    biVar.f6196h = this.f6443q.f6663r;
                                    biVar.mo18796g(this.f6443q.f6661p - i3);
                                    bkVar.mo18784a(biVar);
                                    b = this.f6443q.mo19084b();
                                case 148:
                                    bkVar.mo18784a(new XmlString(this.f6443q.f6660o, this.f6443q.f6647b));
                                    eVar = bkVar;
                                    break;
                                default:
                                    mo18981a("msg.syntax");
                                    eVar = m6201S();
                                    break;
                            }
                        }
                    } else {
                        mo18981a("msg.syntax");
                        eVar = m6201S();
                    }
                    return m6213a(true, eVar);
                }
                break;
            case 21:
                this.f6444r = 0;
                UnaryExpression bbVar = new UnaryExpression(28, this.f6443q.f6660o, m6190H());
                bbVar.f6393e = i;
                return bbVar;
            case 22:
                this.f6444r = 0;
                UnaryExpression bbVar2 = new UnaryExpression(29, this.f6443q.f6660o, m6190H());
                bbVar2.f6393e = i;
                return bbVar2;
            case 26:
            case 27:
            case 32:
            case 126:
                this.f6444r = 0;
                UnaryExpression bbVar3 = new UnaryExpression(d, this.f6443q.f6660o, m6190H());
                bbVar3.f6393e = i;
                return bbVar3;
            case 31:
                this.f6444r = 0;
                UnaryExpression bbVar4 = new UnaryExpression(d, this.f6443q.f6660o, m6190H());
                bbVar4.f6393e = i;
                return bbVar4;
            case 106:
            case 107:
                this.f6444r = 0;
                UnaryExpression bbVar5 = new UnaryExpression(d, this.f6443q.f6660o, m6211a(true));
                bbVar5.f6393e = i;
                m6220a(bbVar5);
                return bbVar5;
        }
        AstNode a = m6211a(true);
        int f = m6244f();
        if (f != 106 && f != 107) {
            return a;
        }
        this.f6444r = 0;
        UnaryExpression bbVar6 = new UnaryExpression(f, this.f6443q.f6660o, a, true);
        bbVar6.f6393e = i;
        m6220a(bbVar6);
        return bbVar6;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: I */
    private List<AstNode> m6191I() {
        if (m6221a(88)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = this.f6434h;
        this.f6434h = false;
        do {
            try {
                if (m6237d() == 72) {
                    mo18981a("msg.yield.parenthesized");
                }
                AstNode x = m6264x();
                if (m6237d() == 119) {
                    try {
                        arrayList.add(m6210a(x, 0, true));
                    } catch (IOException e) {
                    }
                } else {
                    arrayList.add(x);
                }
            } catch (Throwable th) {
                this.f6434h = z;
                throw th;
            }
        } while (m6221a(89));
        this.f6434h = z;
        m6223a(88, "msg.no.paren.arg");
        return arrayList;
    }

    /* renamed from: a */
    private AstNode m6211a(boolean z) {
        AstNode eVar;
        int d = m6237d();
        int i = this.f6443q.f6655j;
        if (d != 30) {
            eVar = m6194L();
        } else {
            this.f6444r = 0;
            int i2 = this.f6443q.f6660o;
            NewExpression alVar = new NewExpression(i2);
            AstNode a = m6211a(false);
            int b = m6226b(a);
            alVar.mo18822a(a);
            if (m6221a(87)) {
                int i3 = this.f6443q.f6660o;
                List I = m6191I();
                if (I != null && I.size() > 65536) {
                    mo18981a("msg.too.many.constructor.args");
                }
                int i4 = this.f6443q.f6660o;
                b = this.f6443q.f6661p;
                if (I != null) {
                    alVar.mo18821a(I);
                }
                alVar.mo18823d(i3 - i2, i4 - i2);
            }
            if (m6221a(85)) {
                ObjectLiteral P = m6198P();
                b = m6226b((AstNode) P);
                alVar.f6132l = P;
                P.mo18790b(alVar);
            }
            alVar.mo18796g(b - i2);
            eVar = alVar;
        }
        eVar.f6393e = i;
        return m6213a(z, eVar);
    }

    /* JADX WARNING: type inference failed for: r11v0, types: [org.mozilla.javascript.b.e] */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [org.mozilla.javascript.b.e, org.mozilla.javascript.cm] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r11v1, types: [org.mozilla.javascript.b.w, org.mozilla.javascript.cm] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r11v2, types: [org.mozilla.javascript.b.p, org.mozilla.javascript.cm] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r11v3, types: [org.mozilla.javascript.cm, org.mozilla.javascript.b.bg] */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r2v18, types: [org.mozilla.javascript.b.aq] */
    /* JADX WARNING: type inference failed for: r2v19, types: [org.mozilla.javascript.cm, org.mozilla.javascript.b.ad] */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r2v20, types: [org.mozilla.javascript.b.bl] */
    /* JADX WARNING: type inference failed for: r1v9, types: [org.mozilla.javascript.b.s] */
    /* JADX WARNING: type inference failed for: r1v10, types: [org.mozilla.javascript.cm] */
    /* JADX WARNING: type inference failed for: r0v55, types: [org.mozilla.javascript.b.aq, org.mozilla.javascript.cm] */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r2v56 */
    /* JADX WARNING: type inference failed for: r2v57 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=org.mozilla.javascript.b.e, code=null, for r11v0, types: [org.mozilla.javascript.b.e] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v2
  assigns: []
  uses: []
  mth insns count: 223
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
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 14 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AstNode m6213a(boolean r10, AstNode r11) {
        /*
            r9 = this;
            if (r11 != 0) goto L_0x0005
            r9.m6202T()
        L_0x0005:
            int r3 = r11.mo18798q()
            r1 = r11
        L_0x000a:
            int r4 = r9.m6237d()
            switch(r4) {
                case 83: goto L_0x01c2;
                case 87: goto L_0x01fd;
                case 108: goto L_0x0012;
                case 143: goto L_0x0012;
                case 146: goto L_0x017e;
                default: goto L_0x0011;
            }
        L_0x0011:
            return r1
        L_0x0012:
            org.mozilla.javascript.ef r0 = r9.f6443q
            int r5 = r0.f6655j
            if (r1 != 0) goto L_0x001b
            r9.m6202T()
        L_0x001b:
            r0 = 0
            org.mozilla.javascript.ef r2 = r9.f6443q
            int r2 = r2.f6655j
            org.mozilla.javascript.ef r6 = r9.f6443q
            int r6 = r6.f6660o
            r7 = 0
            r9.f6444r = r7
            r7 = 143(0x8f, float:2.0E-43)
            if (r4 != r7) goto L_0x002f
            r9.m6246g()
            r0 = 4
        L_0x002f:
            org.mozilla.javascript.i r7 = r9.f6427a
            boolean r7 = r7.f6743f
            if (r7 != 0) goto L_0x0064
            int r0 = r9.m6242e()
            r4 = 39
            if (r0 == r4) goto L_0x0052
            org.mozilla.javascript.i r0 = r9.f6427a
            boolean r0 = r0.f6741d
            if (r0 == 0) goto L_0x004d
            org.mozilla.javascript.ef r0 = r9.f6443q
            java.lang.String r0 = r0.f6647b
            boolean r0 = org.mozilla.javascript.TokenStream.m6627a(r0)
            if (r0 != 0) goto L_0x0052
        L_0x004d:
            java.lang.String r0 = "msg.no.name.after.dot"
            r9.mo18981a(r0)
        L_0x0052:
            r0 = 1
            r4 = 33
            org.mozilla.javascript.b.ak r4 = r9.m6227b(r0, r4)
            org.mozilla.javascript.b.aq r0 = new org.mozilla.javascript.b.aq
            r0.<init>(r1, r4, r6)
            r0.f6393e = r2
            r1 = r0
        L_0x0061:
            r1.f6393e = r5
            goto L_0x000a
        L_0x0064:
            int r2 = r9.m6242e()
            switch(r2) {
                case 23: goto L_0x00d6;
                case 39: goto L_0x00d0;
                case 50: goto L_0x00bd;
                case 147: goto L_0x00e9;
                default: goto L_0x006b;
            }
        L_0x006b:
            org.mozilla.javascript.i r7 = r9.f6427a
            boolean r7 = r7.f6741d
            if (r7 == 0) goto L_0x016c
            switch(r2) {
                case 4: goto L_0x0128;
                case 30: goto L_0x0120;
                case 31: goto L_0x00fc;
                case 32: goto L_0x0138;
                case 42: goto L_0x0124;
                case 43: goto L_0x0130;
                case 44: goto L_0x0108;
                case 45: goto L_0x0134;
                case 50: goto L_0x0164;
                case 52: goto L_0x0118;
                case 53: goto L_0x0160;
                case 72: goto L_0x014c;
                case 81: goto L_0x0168;
                case 109: goto L_0x0110;
                case 112: goto L_0x0114;
                case 113: goto L_0x0104;
                case 114: goto L_0x012c;
                case 115: goto L_0x00f1;
                case 116: goto L_0x00f8;
                case 117: goto L_0x0144;
                case 118: goto L_0x0100;
                case 119: goto L_0x010c;
                case 120: goto L_0x00ee;
                case 121: goto L_0x00f4;
                case 122: goto L_0x013c;
                case 123: goto L_0x0148;
                case 124: goto L_0x0150;
                case 125: goto L_0x015c;
                case 126: goto L_0x0140;
                case 153: goto L_0x011c;
                case 154: goto L_0x0154;
                case 160: goto L_0x0158;
                default: goto L_0x0074;
            }
        L_0x0074:
            r2 = 0
        L_0x0075:
            if (r2 == 0) goto L_0x016c
            org.mozilla.javascript.ef r7 = r9.f6443q
            int r7 = r7.f6660o
            org.mozilla.javascript.ef r8 = r9.f6443q
            int r8 = r8.f6655j
            r9.m6216a(r7, r2, r8)
            r2 = -1
            org.mozilla.javascript.b.e r0 = r9.m6229b(r2, r0)
        L_0x0087:
            boolean r7 = r0 instanceof org.mozilla.javascript.p110b.XmlRef
            if (r7 == 0) goto L_0x0177
            org.mozilla.javascript.b.bl r2 = new org.mozilla.javascript.b.bl
            r2.<init>()
        L_0x0090:
            if (r7 == 0) goto L_0x009b
            r7 = 108(0x6c, float:1.51E-43)
            if (r4 != r7) goto L_0x009b
            r4 = 108(0x6c, float:1.51E-43)
            r2.mo18730a(r4)
        L_0x009b:
            int r4 = r1.mo18798q()
            r2.mo18795f(r4)
            int r7 = m6226b(r0)
            int r7 = r7 - r4
            r2.mo18796g(r7)
            int r4 = r6 - r4
            r2.mo18723i(r4)
            int r4 = r1.mo18794f()
            r2.f6393e = r4
            r2.mo18720a(r1)
            r2.mo18722d(r0)
            r1 = r2
            goto L_0x0061
        L_0x00bd:
            org.mozilla.javascript.ef r2 = r9.f6443q
            int r2 = r2.f6660o
            java.lang.String r7 = "throw"
            org.mozilla.javascript.ef r8 = r9.f6443q
            int r8 = r8.f6655j
            r9.m6216a(r2, r7, r8)
            r2 = -1
            org.mozilla.javascript.b.e r0 = r9.m6229b(r2, r0)
            goto L_0x0087
        L_0x00d0:
            r2 = -1
            org.mozilla.javascript.b.e r0 = r9.m6229b(r2, r0)
            goto L_0x0087
        L_0x00d6:
            org.mozilla.javascript.ef r2 = r9.f6443q
            int r2 = r2.f6660o
            java.lang.String r7 = "*"
            org.mozilla.javascript.ef r8 = r9.f6443q
            int r8 = r8.f6655j
            r9.m6216a(r2, r7, r8)
            r2 = -1
            org.mozilla.javascript.b.e r0 = r9.m6229b(r2, r0)
            goto L_0x0087
        L_0x00e9:
            org.mozilla.javascript.b.e r0 = r9.m6192J()
            goto L_0x0087
        L_0x00ee:
            java.lang.String r2 = "break"
            goto L_0x0075
        L_0x00f1:
            java.lang.String r2 = "case"
            goto L_0x0075
        L_0x00f4:
            java.lang.String r2 = "continue"
            goto L_0x0075
        L_0x00f8:
            java.lang.String r2 = "default"
            goto L_0x0075
        L_0x00fc:
            java.lang.String r2 = "delete"
            goto L_0x0075
        L_0x0100:
            java.lang.String r2 = "do"
            goto L_0x0075
        L_0x0104:
            java.lang.String r2 = "else"
            goto L_0x0075
        L_0x0108:
            java.lang.String r2 = "false"
            goto L_0x0075
        L_0x010c:
            java.lang.String r2 = "for"
            goto L_0x0075
        L_0x0110:
            java.lang.String r2 = "function"
            goto L_0x0075
        L_0x0114:
            java.lang.String r2 = "if"
            goto L_0x0075
        L_0x0118:
            java.lang.String r2 = "in"
            goto L_0x0075
        L_0x011c:
            java.lang.String r2 = "let"
            goto L_0x0075
        L_0x0120:
            java.lang.String r2 = "new"
            goto L_0x0075
        L_0x0124:
            java.lang.String r2 = "null"
            goto L_0x0075
        L_0x0128:
            java.lang.String r2 = "return"
            goto L_0x0075
        L_0x012c:
            java.lang.String r2 = "switch"
            goto L_0x0075
        L_0x0130:
            java.lang.String r2 = "this"
            goto L_0x0075
        L_0x0134:
            java.lang.String r2 = "true"
            goto L_0x0075
        L_0x0138:
            java.lang.String r2 = "typeof"
            goto L_0x0075
        L_0x013c:
            java.lang.String r2 = "var"
            goto L_0x0075
        L_0x0140:
            java.lang.String r2 = "void"
            goto L_0x0075
        L_0x0144:
            java.lang.String r2 = "while"
            goto L_0x0075
        L_0x0148:
            java.lang.String r2 = "with"
            goto L_0x0075
        L_0x014c:
            java.lang.String r2 = "yield"
            goto L_0x0075
        L_0x0150:
            java.lang.String r2 = "catch"
            goto L_0x0075
        L_0x0154:
            java.lang.String r2 = "const"
            goto L_0x0075
        L_0x0158:
            java.lang.String r2 = "debugger"
            goto L_0x0075
        L_0x015c:
            java.lang.String r2 = "finally"
            goto L_0x0075
        L_0x0160:
            java.lang.String r2 = "instanceof"
            goto L_0x0075
        L_0x0164:
            java.lang.String r2 = "throw"
            goto L_0x0075
        L_0x0168:
            java.lang.String r2 = "try"
            goto L_0x0075
        L_0x016c:
            java.lang.String r0 = "msg.no.name.after.dot"
            r9.mo18981a(r0)
            org.mozilla.javascript.b.s r1 = r9.m6201S()
            goto L_0x0061
        L_0x0177:
            org.mozilla.javascript.b.aq r2 = new org.mozilla.javascript.b.aq
            r2.<init>()
            goto L_0x0090
        L_0x017e:
            r0 = 0
            r9.f6444r = r0
            org.mozilla.javascript.ef r0 = r9.f6443q
            int r4 = r0.f6660o
            r2 = -1
            org.mozilla.javascript.ef r0 = r9.f6443q
            int r5 = r0.f6655j
            r9.m6246g()
            r9.mo18987b()
            org.mozilla.javascript.b.e r6 = r9.m6263w()
            int r0 = m6226b(r6)
            r7 = 88
            java.lang.String r8 = "msg.no.paren"
            boolean r7 = r9.m6223a(r7, r8)
            if (r7 == 0) goto L_0x01aa
            org.mozilla.javascript.ef r0 = r9.f6443q
            int r2 = r0.f6660o
            org.mozilla.javascript.ef r0 = r9.f6443q
            int r0 = r0.f6661p
        L_0x01aa:
            org.mozilla.javascript.b.bg r11 = new org.mozilla.javascript.b.bg
            int r0 = r0 - r3
            r11.<init>(r3, r0)
            r11.mo18720a(r1)
            r11.mo18722d(r6)
            r11.mo18723i(r4)
            int r0 = r2 - r3
            r11.f6191j = r0
            r11.f6393e = r5
            r1 = r11
            goto L_0x000a
        L_0x01c2:
            r0 = 0
            r9.f6444r = r0
            org.mozilla.javascript.ef r0 = r9.f6443q
            int r4 = r0.f6660o
            r2 = -1
            org.mozilla.javascript.ef r0 = r9.f6443q
            int r5 = r0.f6655j
            org.mozilla.javascript.b.e r6 = r9.m6263w()
            int r0 = m6226b(r6)
            r7 = 84
            java.lang.String r8 = "msg.no.bracket.index"
            boolean r7 = r9.m6223a(r7, r8)
            if (r7 == 0) goto L_0x01e8
            org.mozilla.javascript.ef r0 = r9.f6443q
            int r2 = r0.f6660o
            org.mozilla.javascript.ef r0 = r9.f6443q
            int r0 = r0.f6661p
        L_0x01e8:
            org.mozilla.javascript.b.p r11 = new org.mozilla.javascript.b.p
            int r0 = r0 - r3
            r11.<init>(r3, r0)
            r11.mo18812a(r1)
            r11.mo18813d(r6)
            r11.f6236i = r4
            r11.f6237j = r2
            r11.f6393e = r5
            r1 = r11
            goto L_0x000a
        L_0x01fd:
            if (r10 == 0) goto L_0x0011
            org.mozilla.javascript.ef r0 = r9.f6443q
            int r2 = r0.f6655j
            r0 = 0
            r9.f6444r = r0
            int r0 = r1.f6389a
            r4 = 39
            if (r0 != r4) goto L_0x0219
            java.lang.String r4 = "eval"
            r0 = r1
            org.mozilla.javascript.b.ak r0 = (org.mozilla.javascript.p110b.Name) r0
            java.lang.String r0 = r0.f6130g
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x0232
        L_0x0219:
            int r0 = r1.f6389a
            r4 = 33
            if (r0 != r4) goto L_0x0235
            java.lang.String r4 = "eval"
            r0 = r1
            org.mozilla.javascript.b.aq r0 = (org.mozilla.javascript.p110b.PropertyGet) r0
            org.mozilla.javascript.b.e r0 = r0.mo18726o()
            org.mozilla.javascript.b.ak r0 = (org.mozilla.javascript.p110b.Name) r0
            java.lang.String r0 = r0.f6130g
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0235
        L_0x0232:
            r9.mo18987b()
        L_0x0235:
            org.mozilla.javascript.b.w r11 = new org.mozilla.javascript.b.w
            r11.<init>(r3)
            r11.mo18822a(r1)
            r11.f6393e = r2
            org.mozilla.javascript.ef r0 = r9.f6443q
            int r0 = r0.f6660o
            int r0 = r0 - r3
            r11.mo18824i(r0)
            java.util.List r0 = r9.m6191I()
            if (r0 == 0) goto L_0x025a
            int r1 = r0.size()
            r2 = 65536(0x10000, float:9.18355E-41)
            if (r1 <= r2) goto L_0x025a
            java.lang.String r1 = "msg.too.many.function.args"
            r9.mo18981a(r1)
        L_0x025a:
            r11.mo18821a(r0)
            org.mozilla.javascript.ef r0 = r9.f6443q
            int r0 = r0.f6660o
            int r0 = r0 - r3
            r11.mo18825j(r0)
            org.mozilla.javascript.ef r0 = r9.f6443q
            int r0 = r0.f6661p
            int r0 = r0 - r3
            r11.mo18796g(r0)
            r1 = r11
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.m6213a(boolean, org.mozilla.javascript.b.e):org.mozilla.javascript.b.e");
    }

    /* renamed from: J */
    private AstNode m6192J() {
        int e = m6242e();
        int i = this.f6443q.f6660o;
        switch (e) {
            case 23:
                m6216a(this.f6443q.f6660o, Marker.ANY_MARKER, this.f6443q.f6655j);
                return m6229b(i, 0);
            case 39:
                return m6229b(i, 0);
            case 83:
                return m6206a(i, (Name) null, -1);
            default:
                mo18981a("msg.no.name.after.xmlAttr");
                return m6201S();
        }
    }

    /* renamed from: b */
    private AstNode m6229b(int i, int i2) {
        int i3;
        Name akVar;
        int i4;
        if (i != -1) {
            i3 = i;
        } else {
            i3 = this.f6443q.f6660o;
        }
        int i5 = this.f6443q.f6655j;
        Name b = m6227b(true, this.f6445s);
        if (m6221a(144)) {
            int i6 = this.f6443q.f6660o;
            switch (m6242e()) {
                case 23:
                    m6216a(this.f6443q.f6660o, Marker.ANY_MARKER, this.f6443q.f6655j);
                    i4 = i6;
                    akVar = b;
                    b = m6227b(false, -1);
                    break;
                case 39:
                    i4 = i6;
                    akVar = b;
                    b = m6227b(false, 39);
                    break;
                case 83:
                    return m6206a(i, b, i6);
                default:
                    mo18981a("msg.no.name.after.coloncolon");
                    return m6201S();
            }
        } else {
            akVar = null;
            i4 = -1;
        }
        if (akVar == null && i2 == 0 && i == -1) {
            return b;
        }
        XmlPropRef bmVar = new XmlPropRef(i3, m6226b((AstNode) b) - i3);
        bmVar.mo18787i(i);
        bmVar.mo18786b(akVar);
        bmVar.mo18788j(i4);
        bmVar.mo18785a(b);
        bmVar.f6393e = i5;
        return bmVar;
    }

    /* renamed from: a */
    private XmlElemRef m6206a(int i, Name akVar, int i2) {
        int i3 = -1;
        int i4 = this.f6443q.f6660o;
        int i5 = i != -1 ? i : i4;
        AstNode w = m6263w();
        int b = m6226b(w);
        if (m6223a(84, "msg.no.bracket.index")) {
            i3 = this.f6443q.f6660o;
            b = this.f6443q.f6661p;
        }
        XmlElemRef bhVar = new XmlElemRef(i5, b - i5);
        bhVar.mo18786b(akVar);
        bhVar.mo18788j(i2);
        bhVar.mo18787i(i);
        bhVar.mo18783a(w);
        bhVar.f6193h = i4;
        bhVar.f6194i = i3;
        return bhVar;
    }

    /* renamed from: K */
    private AstNode m6193K() {
        try {
            this.f6450x = true;
            return m6194L();
        } finally {
            this.f6450x = false;
        }
    }

    /* renamed from: L */
    private AstNode m6194L() {
        int i;
        int i2 = 1;
        m6237d();
        int i3 = this.f6444r;
        this.f6444r = 0;
        int i4 = 65535 & i3;
        switch (i4) {
            case -1:
                break;
            case 0:
                mo18981a("msg.unexpected.eof");
                break;
            case 24:
            case 100:
                this.f6443q.mo19083a(i4);
                int i5 = this.f6443q.f6660o;
                RegExpLiteral arVar = new RegExpLiteral(i5, this.f6443q.f6661p - i5);
                arVar.mo18744c(this.f6443q.f6647b);
                TokenStream efVar = this.f6443q;
                String str = efVar.f6646a;
                efVar.f6646a = null;
                arVar.f6140h = str;
                return arVar;
            case 39:
                String str2 = this.f6443q.f6647b;
                int i6 = this.f6443q.f6660o;
                int i7 = this.f6443q.f6655j;
                if ((i3 & 131072) == 0 || m6237d() != 103) {
                    m6216a(i6, str2, i7);
                    return this.f6427a.f6743f ? m6229b(-1, 0) : m6227b(true, 39);
                }
                Label agVar = new Label(i6, this.f6443q.f6661p - i6);
                String trim = str2 == null ? null : str2.trim();
                if (trim == null || "".equals(trim)) {
                    throw new IllegalArgumentException("invalid label name");
                }
                agVar.f6120g = trim;
                agVar.f6393e = this.f6443q.f6655j;
                return agVar;
            case 40:
                String str3 = this.f6443q.f6647b;
                if (this.f6430d && this.f6443q.f6649d) {
                    mo18981a("msg.no.octal.strict");
                }
                return new NumberLiteral(this.f6443q.f6660o, str3, this.f6443q.f6648c);
            case 41:
                return m6200R();
            case 42:
            case 43:
            case 44:
            case 45:
                int i8 = this.f6443q.f6660o;
                return new KeywordLiteral(i8, this.f6443q.f6661p - i8, i4);
            case 83:
                if (this.f6445s != 83) {
                    m6202T();
                }
                int i9 = this.f6443q.f6660o;
                int i10 = this.f6443q.f6661p;
                ArrayList<AstNode> arrayList = new ArrayList<>();
                ArrayLiteral cVar = new ArrayLiteral(i9);
                int i11 = 0;
                int i12 = -1;
                boolean z = true;
                while (true) {
                    int d = m6237d();
                    if (d == 89) {
                        this.f6444r = 0;
                        i12 = this.f6443q.f6661p;
                        if (!z) {
                            z = true;
                        } else {
                            arrayList.add(new EmptyExpression(this.f6443q.f6660o, 1));
                            i11++;
                        }
                    } else if (d == 84) {
                        this.f6444r = 0;
                        int i13 = this.f6443q.f6661p;
                        int size = arrayList.size();
                        if (!z) {
                            i2 = 0;
                        }
                        cVar.f6205g = size + i2;
                        cVar.f6206h = i11;
                        if (i12 != -1) {
                            m6217a(i9, (List<?>) arrayList, i12);
                            i = i13;
                        } else {
                            i = i13;
                        }
                    } else if (d == 119 && !z && arrayList.size() == 1) {
                        return m6209a((AstNode) arrayList.get(0), i9);
                    } else {
                        if (d == 0) {
                            mo18981a("msg.no.bracket.arg");
                            i = i10;
                        } else {
                            if (!z) {
                                mo18981a("msg.no.bracket.arg");
                            }
                            arrayList.add(m6264x());
                            i12 = -1;
                            z = false;
                        }
                    }
                }
                for (AstNode a : arrayList) {
                    cVar.mo18789a(a);
                }
                cVar.mo18796g(i - i9);
                return cVar;
            case 85:
                return m6198P();
            case 87:
                return m6195M();
            case 109:
                return m6230b(2);
            case 127:
                mo18981a("msg.reserved.id");
                break;
            case 147:
                m6246g();
                return m6192J();
            case 153:
                return m6212a(false, this.f6443q.f6660o);
            default:
                mo18981a("msg.syntax");
                break;
        }
        return m6201S();
    }

    /* renamed from: M */
    private AstNode m6195M() {
        AstNode eVar;
        boolean z = this.f6434h;
        this.f6434h = false;
        try {
            Comment c = m6233c();
            int i = this.f6443q.f6655j;
            int i2 = this.f6443q.f6660o;
            AstNode w = m6263w();
            if (m6237d() != 119) {
                ParenthesizedExpression apVar = new ParenthesizedExpression(w);
                if (c == null) {
                    c = m6233c();
                }
                if (c != null) {
                    apVar.mo18926a(c);
                }
                m6223a(88, "msg.no.paren");
                apVar.mo18796g(this.f6443q.f6661p - apVar.mo18798q());
                apVar.f6393e = i;
                this.f6434h = z;
                eVar = apVar;
            }
            return eVar;
        } finally {
            this.f6434h = z;
        }
    }

    /* renamed from: a */
    private AstNode m6209a(AstNode eVar, int i) {
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        while (m6237d() == 119) {
            arrayList.add(m6196N());
        }
        C2164cu cuVar = null;
        if (m6237d() == 112) {
            this.f6444r = 0;
            i2 = this.f6443q.f6660o - i;
            cuVar = m6253m();
        }
        m6223a(84, "msg.no.bracket.arg");
        ArrayComprehension aVar = new ArrayComprehension(i, this.f6443q.f6661p - i);
        aVar.mo18715a(eVar);
        aVar.mo18714a((List<ArrayComprehensionLoop>) arrayList);
        if (cuVar != null) {
            aVar.f6105j = i2;
            AstNode eVar2 = cuVar.f6453a;
            aVar.f6104i = eVar2;
            if (eVar2 != null) {
                eVar2.mo18790b(aVar);
            }
            aVar.f6106k = cuVar.f6454b - i;
            aVar.f6107l = cuVar.f6455c - i;
        }
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0080 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ad A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b6 A[Catch:{ all -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cd  */
    /* renamed from: N */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ArrayComprehensionLoop m6196N() {
        /*
            r12 = this;
            r0 = 1
            r10 = 39
            r1 = 0
            r3 = -1
            int r2 = r12.m6242e()
            r4 = 119(0x77, float:1.67E-43)
            if (r2 == r4) goto L_0x0010
            r12.m6202T()
        L_0x0010:
            org.mozilla.javascript.ef r2 = r12.f6443q
            int r8 = r2.f6660o
            org.mozilla.javascript.b.b r9 = new org.mozilla.javascript.b.b
            r9.<init>(r8)
            r12.mo18984a(r9)
            r2 = 39
            boolean r2 = r12.m6221a(r2)     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x00ab
            org.mozilla.javascript.ef r2 = r12.f6443q     // Catch:{ all -> 0x00c4 }
            java.lang.String r2 = r2.f6647b     // Catch:{ all -> 0x00c4 }
            java.lang.String r4 = "each"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x00a6
            org.mozilla.javascript.ef r2 = r12.f6443q     // Catch:{ all -> 0x00c4 }
            int r2 = r2.f6660o     // Catch:{ all -> 0x00c4 }
            int r2 = r2 - r8
            r7 = r2
        L_0x0036:
            r2 = 87
            java.lang.String r4 = "msg.no.paren.for"
            boolean r2 = r12.m6223a(r2, r4)     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x00cd
            org.mozilla.javascript.ef r2 = r12.f6443q     // Catch:{ all -> 0x00c4 }
            int r2 = r2.f6660o     // Catch:{ all -> 0x00c4 }
            int r2 = r2 - r8
            r6 = r2
        L_0x0046:
            r2 = 0
            int r4 = r12.m6237d()     // Catch:{ all -> 0x00c4 }
            switch(r4) {
                case 39: goto L_0x00b6;
                case 83: goto L_0x00ad;
                case 85: goto L_0x00ad;
                default: goto L_0x004e;
            }     // Catch:{ all -> 0x00c4 }
        L_0x004e:
            java.lang.String r4 = "msg.bad.var"
            r12.mo18981a(r4)     // Catch:{ all -> 0x00c4 }
            r5 = r2
        L_0x0054:
            int r2 = r5.f6389a     // Catch:{ all -> 0x00c4 }
            if (r2 != r10) goto L_0x0062
            r2 = 153(0x99, float:2.14E-43)
            org.mozilla.javascript.ef r4 = r12.f6443q     // Catch:{ all -> 0x00c4 }
            java.lang.String r4 = r4.f6647b     // Catch:{ all -> 0x00c4 }
            r10 = 1
            r12.mo18980a(r2, r4, r10)     // Catch:{ all -> 0x00c4 }
        L_0x0062:
            r2 = 52
            java.lang.String r4 = "msg.in.after.for.name"
            boolean r2 = r12.m6223a(r2, r4)     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x00cb
            org.mozilla.javascript.ef r2 = r12.f6443q     // Catch:{ all -> 0x00c4 }
            int r2 = r2.f6660o     // Catch:{ all -> 0x00c4 }
            int r2 = r2 - r8
            r4 = r2
        L_0x0072:
            org.mozilla.javascript.b.e r10 = r12.m6263w()     // Catch:{ all -> 0x00c4 }
            r2 = 88
            java.lang.String r11 = "msg.no.paren.for.ctrl"
            boolean r2 = r12.m6223a(r2, r11)     // Catch:{ all -> 0x00c4 }
            if (r2 == 0) goto L_0x00c9
            org.mozilla.javascript.ef r2 = r12.f6443q     // Catch:{ all -> 0x00c4 }
            int r2 = r2.f6660o     // Catch:{ all -> 0x00c4 }
            int r2 = r2 - r8
        L_0x0085:
            org.mozilla.javascript.ef r11 = r12.f6443q     // Catch:{ all -> 0x00c4 }
            int r11 = r11.f6661p     // Catch:{ all -> 0x00c4 }
            int r8 = r11 - r8
            r9.mo18796g(r8)     // Catch:{ all -> 0x00c4 }
            r9.mo18814d(r5)     // Catch:{ all -> 0x00c4 }
            r9.mo18815e(r10)     // Catch:{ all -> 0x00c4 }
            r9.mo18816i(r4)     // Catch:{ all -> 0x00c4 }
            r9.mo18817j(r7)     // Catch:{ all -> 0x00c4 }
            if (r7 == r3) goto L_0x00c2
        L_0x009c:
            r9.mo18716a(r0)     // Catch:{ all -> 0x00c4 }
            r9.mo18737d(r6, r2)     // Catch:{ all -> 0x00c4 }
            r12.mo18979a()
            return r9
        L_0x00a6:
            java.lang.String r2 = "msg.no.paren.for"
            r12.mo18981a(r2)     // Catch:{ all -> 0x00c4 }
        L_0x00ab:
            r7 = r3
            goto L_0x0036
        L_0x00ad:
            org.mozilla.javascript.b.e r2 = r12.m6193K()     // Catch:{ all -> 0x00c4 }
            m6247g(r2)     // Catch:{ all -> 0x00c4 }
            r5 = r2
            goto L_0x0054
        L_0x00b6:
            r2 = 0
            r12.f6444r = r2     // Catch:{ all -> 0x00c4 }
            r2 = 0
            r4 = 39
            org.mozilla.javascript.b.ak r2 = r12.m6227b(r2, r4)     // Catch:{ all -> 0x00c4 }
            r5 = r2
            goto L_0x0054
        L_0x00c2:
            r0 = r1
            goto L_0x009c
        L_0x00c4:
            r0 = move-exception
            r12.mo18979a()
            throw r0
        L_0x00c9:
            r2 = r3
            goto L_0x0085
        L_0x00cb:
            r4 = r3
            goto L_0x0072
        L_0x00cd:
            r6 = r3
            goto L_0x0046
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.m6196N():org.mozilla.javascript.b.b");
    }

    /* renamed from: a */
    private AstNode m6210a(AstNode eVar, int i, boolean z) {
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        while (m6237d() == 119) {
            arrayList.add(m6197O());
        }
        C2164cu cuVar = null;
        if (m6237d() == 112) {
            this.f6444r = 0;
            i2 = this.f6443q.f6660o - i;
            cuVar = m6253m();
        }
        if (!z) {
            m6223a(88, "msg.no.paren.let");
        }
        GeneratorExpression zVar = new GeneratorExpression(i, this.f6443q.f6661p - i);
        zVar.mo18830a(eVar);
        zVar.mo18829a((List<GeneratorExpressionLoop>) arrayList);
        if (cuVar != null) {
            zVar.f6273j = i2;
            AstNode eVar2 = cuVar.f6453a;
            zVar.f6272i = eVar2;
            if (eVar2 != null) {
                eVar2.mo18790b(zVar);
            }
            zVar.f6274k = cuVar.f6454b - i;
            zVar.f6275l = cuVar.f6455c - i;
        }
        return zVar;
    }

    /* renamed from: O */
    private GeneratorExpressionLoop m6197O() {
        int i;
        AstNode b;
        int i2;
        int i3 = -1;
        if (m6242e() != 119) {
            m6202T();
        }
        int i4 = this.f6443q.f6660o;
        GeneratorExpressionLoop aaVar = new GeneratorExpressionLoop(i4);
        mo18984a((Scope) aaVar);
        try {
            if (m6223a(87, "msg.no.paren.for")) {
                i = this.f6443q.f6660o - i4;
            } else {
                i = -1;
            }
            switch (m6237d()) {
                case 39:
                    this.f6444r = 0;
                    b = m6227b(false, 39);
                    break;
                case 83:
                case 85:
                    AstNode K = m6193K();
                    m6247g(K);
                    b = K;
                    break;
                default:
                    mo18981a("msg.bad.var");
                    b = null;
                    break;
            }
            if (b.f6389a == 39) {
                mo18980a(153, this.f6443q.f6647b, true);
            }
            if (m6223a(52, "msg.in.after.for.name")) {
                i2 = this.f6443q.f6660o - i4;
            } else {
                i2 = -1;
            }
            AstNode w = m6263w();
            if (m6223a(88, "msg.no.paren.for.ctrl")) {
                i3 = this.f6443q.f6660o - i4;
            }
            aaVar.mo18796g(this.f6443q.f6661p - i4);
            aaVar.mo18814d(b);
            aaVar.mo18815e(w);
            aaVar.mo18816i(i2);
            aaVar.mo18737d(i, i3);
            return aaVar;
        } finally {
            mo18979a();
        }
    }

    /* renamed from: P */
    private ObjectLiteral m6198P() {
        String str;
        char c;
        int i = this.f6443q.f6660o;
        int i2 = this.f6443q.f6655j;
        int i3 = -1;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = null;
        HashSet hashSet2 = null;
        if (this.f6430d) {
            hashSet = new HashSet();
            hashSet2 = new HashSet();
        }
        Comment c2 = m6233c();
        while (true) {
            int d = m6237d();
            Comment c3 = m6233c();
            switch (d) {
                case 39:
                    Name b = m6227b(false, 39);
                    String str2 = this.f6443q.f6647b;
                    int i4 = this.f6443q.f6660o;
                    this.f6444r = 0;
                    int d2 = m6237d();
                    if (("get".equals(str2) || "set".equals(str2)) && d2 != 89 && d2 != 103 && d2 != 86) {
                        boolean equals = "get".equals(str2);
                        c = equals ? (char) 2 : 4;
                        AstNode Q = m6199Q();
                        if (Q != null) {
                            str = this.f6443q.f6647b;
                            FunctionNode b2 = m6230b(2);
                            Name akVar = b2.f6254h;
                            if (!(akVar == null || akVar.mo18725n() == 0)) {
                                mo18981a("msg.bad.prop");
                            }
                            ObjectProperty aoVar = new ObjectProperty(i4);
                            if (equals) {
                                aoVar.f6389a = 151;
                            } else {
                                aoVar.f6389a = 152;
                            }
                            int b3 = m6226b((AstNode) b2);
                            aoVar.mo18720a(Q);
                            aoVar.mo18722d(b2);
                            aoVar.mo18796g(b3 - i4);
                            Q.mo18926a(c3);
                            arrayList.add(aoVar);
                            break;
                        } else {
                            str = null;
                            break;
                        }
                    } else {
                        b.mo18926a(c3);
                        arrayList.add(m6228b((AstNode) b, d));
                        str = str2;
                        c = 1;
                        break;
                    }
                    break;
                case 86:
                    if (i3 != -1) {
                        m6217a(i, (List<?>) arrayList, i3);
                        break;
                    }
                    break;
                default:
                    AstNode Q2 = m6199Q();
                    if (Q2 != null) {
                        String str3 = this.f6443q.f6647b;
                        Q2.mo18926a(c3);
                        arrayList.add(m6228b(Q2, d));
                        str = str3;
                        c = 1;
                        break;
                    } else {
                        str = null;
                        c = 1;
                        break;
                    }
            }
            if (this.f6430d && str != null) {
                switch (c) {
                    case 1:
                        if (hashSet.contains(str) || hashSet2.contains(str)) {
                            mo18988b("msg.dup.obj.lit.prop.strict", str);
                        }
                        hashSet.add(str);
                        hashSet2.add(str);
                        break;
                    case 2:
                        if (hashSet.contains(str)) {
                            mo18988b("msg.dup.obj.lit.prop.strict", str);
                        }
                        hashSet.add(str);
                        break;
                    case 4:
                        if (hashSet2.contains(str)) {
                            mo18988b("msg.dup.obj.lit.prop.strict", str);
                        }
                        hashSet2.add(str);
                        break;
                }
            }
            m6233c();
            if (m6221a(89)) {
                i3 = this.f6443q.f6661p;
            }
        }
        m6223a(86, "msg.no.brace.prop");
        ObjectLiteral anVar = new ObjectLiteral(i, this.f6443q.f6661p - i);
        if (c2 != null) {
            anVar.mo18926a(c2);
        }
        anVar.mo18741a(arrayList);
        anVar.f6393e = i2;
        return anVar;
    }

    /* renamed from: Q */
    private AstNode m6199Q() {
        AstNode amVar;
        switch (m6237d()) {
            case 39:
                amVar = m6227b(false, 39);
                break;
            case 40:
                amVar = new NumberLiteral(this.f6443q.f6660o, this.f6443q.f6647b, this.f6443q.f6648c);
                break;
            case 41:
                amVar = m6200R();
                break;
            default:
                if (this.f6427a.f6741d && TokenStream.m6627a(this.f6443q.f6647b)) {
                    amVar = m6227b(false, 39);
                    break;
                } else {
                    mo18981a("msg.bad.prop");
                    return null;
                }
        }
        this.f6444r = 0;
        return amVar;
    }

    /* renamed from: b */
    private ObjectProperty m6228b(AstNode eVar, int i) {
        int d = m6237d();
        if ((d == 89 || d == 86) && i == 39 && this.f6427a.f6739b >= 180) {
            if (!this.f6450x) {
                mo18981a("msg.bad.object.init");
            }
            Name akVar = new Name(eVar.mo18798q(), ((Name) eVar).f6130g);
            ObjectProperty aoVar = new ObjectProperty();
            aoVar.mo18925a(26, (Object) Boolean.TRUE);
            aoVar.mo18721a(eVar, akVar);
            return aoVar;
        }
        m6223a(103, "msg.no.colon.prop");
        ObjectProperty aoVar2 = new ObjectProperty();
        aoVar2.mo18723i(this.f6443q.f6660o);
        aoVar2.mo18721a(eVar, m6264x());
        return aoVar2;
    }

    /* renamed from: b */
    private Name m6227b(boolean z, int i) {
        int i2 = this.f6443q.f6660o;
        String str = this.f6443q.f6647b;
        int i3 = this.f6443q.f6655j;
        if (!"".equals(this.f6452z)) {
            i2 = this.f6451y;
            str = this.f6452z;
            i3 = this.f6426A;
            this.f6451y = 0;
            this.f6452z = "";
            this.f6426A = 0;
        }
        int i4 = i3;
        String str2 = str;
        int i5 = i4;
        if (str2 == null) {
            if (this.f6427a.f6753p) {
                str2 = "";
            } else {
                m6202T();
            }
        }
        Name akVar = new Name(i2, str2);
        akVar.f6393e = i5;
        if (z) {
            mo18982a(str2, i);
        }
        return akVar;
    }

    /* renamed from: R */
    private StringLiteral m6200R() {
        int i = this.f6443q.f6660o;
        StringLiteral avVar = new StringLiteral(i, this.f6443q.f6661p - i);
        avVar.f6393e = this.f6443q.f6655j;
        avVar.mo18769c(this.f6443q.f6647b);
        avVar.f6161h = (char) this.f6443q.f6650e;
        return avVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18982a(String str, int i) {
        boolean z = true;
        if (m6248h()) {
            if (!"arguments".equals(str) && ((this.f6427a.f6754q == null || !this.f6427a.f6754q.contains(str)) && !("length".equals(str) && i == 33 && this.f6427a.f6739b == 120))) {
                z = false;
            }
            if (z) {
                mo18987b();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo18987b() {
        if (m6248h()) {
            ((FunctionNode) this.f6431e).f6261r = true;
        }
    }

    /* renamed from: a */
    private void m6220a(UnaryExpression bbVar) {
        int i = m6208a(bbVar.f6180g).f6389a;
        if (i != 39 && i != 33 && i != 36 && i != 67 && i != 38) {
            mo18981a(bbVar.f6389a == 106 ? "msg.bad.incr" : "msg.bad.decr");
        }
    }

    /* renamed from: S */
    private ErrorNode m6201S() {
        ErrorNode sVar = new ErrorNode(this.f6443q.f6660o, this.f6443q.f6661p - this.f6443q.f6660o);
        sVar.f6393e = this.f6443q.f6655j;
        return sVar;
    }

    /* renamed from: f */
    private static int m6245f(AstNode eVar) {
        return eVar.mo18798q() + eVar.mo18800s();
    }

    /* renamed from: a */
    private void m6216a(int i, String str, int i2) {
        this.f6451y = i;
        this.f6452z = str;
        this.f6426A = i2;
    }

    /* renamed from: d */
    private int m6238d(int i) {
        char c;
        if (this.f6441o == null) {
            return -1;
        }
        if (i <= 0) {
            return 0;
        }
        char[] cArr = this.f6441o;
        if (i >= cArr.length) {
            i = cArr.length - 1;
        }
        do {
            i--;
            if (i >= 0) {
                c = cArr[i];
                if (c == 10) {
                    break;
                }
            } else {
                return 0;
            }
        } while (c != 13);
        return i + 1;
    }

    /* renamed from: c */
    private void m6234c(int i, int i2) {
        if (this.f6427a.f6746i) {
            Math.max(i, m6238d(i2));
            m6236c("msg.missing.semi", "");
        }
    }

    /* renamed from: a */
    private void m6217a(int i, List<?> list, int i2) {
        if (this.f6427a.f6752o) {
            if (!list.isEmpty()) {
                i = ((AstNode) list.get(0)).mo18798q();
            }
            Math.max(i, m6238d(i2));
            mo18983a("msg.extra.trailing.comma", (String) null);
        }
    }

    /* renamed from: a */
    private static String m6203a(Reader reader) {
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            char[] cArr = new char[1024];
            StringBuilder sb = new StringBuilder(1024);
            while (true) {
                int read = bufferedReader.read(cArr, 0, 1024);
                if (read == -1) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } finally {
            bufferedReader.close();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Node mo18977a(int i, Node cmVar, Node cmVar2) {
        String C = this.f6431e.mo18756C();
        Node a = m6215a(i, cmVar, cmVar2, C);
        a.mo18938c().mo18935b(mo18986b(C));
        return a;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private Node m6215a(int i, Node cmVar, Node cmVar2, String str) {
        boolean z = true;
        Scope a = m6204a(158, cmVar.mo18794f());
        a.mo18927a(new Node(153, m6214a(39, str, cmVar2)));
        try {
            mo18984a(a);
            mo18980a(153, str, true);
            mo18979a();
            Node cmVar3 = new Node(89);
            a.mo18935b(cmVar3);
            ArrayList arrayList = new ArrayList();
            switch (cmVar.f6389a) {
                case 33:
                case 36:
                    switch (i) {
                        case 122:
                        case 153:
                        case 154:
                            mo18981a("msg.bad.assign.left");
                            break;
                    }
                    cmVar3.mo18935b(mo18978a(cmVar, mo18986b(str)));
                    break;
                case 65:
                    z = m6225a((ArrayLiteral) cmVar, i, str, cmVar3, (List<String>) arrayList);
                    break;
                case 66:
                    z = m6224a((ObjectLiteral) cmVar, i, str, cmVar3, (List<String>) arrayList);
                    break;
                default:
                    mo18981a("msg.bad.assign.left");
                    break;
            }
            if (z) {
                cmVar3.mo18935b(Node.m6110a(0.0d));
            }
            a.mo18925a(22, (Object) arrayList);
            return a;
        } catch (Throwable th) {
            mo18979a();
            throw th;
        }
    }

    /* renamed from: a */
    private boolean m6225a(ArrayLiteral cVar, int i, String str, Node cmVar, List<String> list) {
        int i2 = i == 154 ? 155 : 8;
        int i3 = 0;
        Iterator it = cVar.mo18725n().iterator();
        boolean z = true;
        while (true) {
            int i4 = i3;
            if (!it.hasNext()) {
                return z;
            }
            AstNode eVar = (AstNode) it.next();
            if (eVar.f6389a == 128) {
                i3 = i4 + 1;
            } else {
                Node cmVar2 = new Node(36, mo18986b(str), Node.m6110a((double) i4));
                if (eVar.f6389a == 39) {
                    String str2 = ((Name) eVar).f6130g;
                    cmVar.mo18935b(new Node(i2, m6214a(49, str2, (Node) null), cmVar2));
                    if (i != -1) {
                        mo18980a(i, str2, true);
                        list.add(str2);
                    }
                } else {
                    cmVar.mo18935b(m6215a(i, eVar, cmVar2, this.f6431e.mo18756C()));
                }
                i3 = i4 + 1;
                z = false;
            }
        }
    }

    /* renamed from: a */
    private boolean m6224a(ObjectLiteral anVar, int i, String str, Node cmVar, List<String> list) {
        int i2;
        int i3;
        Node cmVar2;
        if (i == 154) {
            i2 = 155;
        } else {
            i2 = 8;
        }
        boolean z = true;
        for (ObjectProperty aoVar : anVar.mo18725n()) {
            if (this.f6443q != null) {
                i3 = this.f6443q.f6655j;
            } else {
                i3 = 0;
            }
            AstNode n = aoVar.mo18725n();
            if (n instanceof Name) {
                cmVar2 = new Node(33, mo18986b(str), Node.m6112a(((Name) n).f6130g));
            } else if (n instanceof StringLiteral) {
                cmVar2 = new Node(33, mo18986b(str), Node.m6112a(((StringLiteral) n).f6160g));
            } else if (n instanceof NumberLiteral) {
                cmVar2 = new Node(36, mo18986b(str), Node.m6110a((double) ((int) ((NumberLiteral) n).f6133g)));
            } else {
                throw m6202T();
            }
            cmVar2.f6393e = i3;
            AstNode o = aoVar.mo18726o();
            if (o.f6389a == 39) {
                String str2 = ((Name) o).f6130g;
                cmVar.mo18935b(new Node(i2, m6214a(49, str2, (Node) null), cmVar2));
                if (i != -1) {
                    mo18980a(i, str2, true);
                    list.add(str2);
                }
            } else {
                cmVar.mo18935b(m6215a(i, o, cmVar2, this.f6431e.mo18756C()));
            }
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final Node mo18986b(String str) {
        mo18982a(str, 39);
        return Node.m6111a(39, str);
    }

    /* renamed from: a */
    private Node m6214a(int i, String str, Node cmVar) {
        Node b = mo18986b(str);
        b.mo18730a(i);
        if (cmVar != null) {
            b.mo18935b(cmVar);
        }
        return b;
    }

    /* renamed from: a */
    protected static Scope m6204a(int i, int i2) {
        Scope atVar = new Scope();
        atVar.mo18730a(i);
        atVar.f6393e = i2;
        return atVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Node mo18978a(Node cmVar, Node cmVar2) {
        Node b;
        Node c;
        int i;
        int i2 = cmVar.f6389a;
        switch (i2) {
            case 33:
            case 36:
                if (cmVar instanceof PropertyGet) {
                    b = ((PropertyGet) cmVar).mo18725n();
                    c = (Name) ((PropertyGet) cmVar).mo18726o();
                } else if (cmVar instanceof ElementGet) {
                    b = ((ElementGet) cmVar).f6234g;
                    c = ((ElementGet) cmVar).f6235h;
                } else {
                    b = cmVar.mo18930b();
                    c = cmVar.mo18938c();
                }
                if (i2 == 33) {
                    i = 35;
                    c.mo18730a(41);
                } else {
                    i = 37;
                }
                return new Node(i, b, c, cmVar2);
            case 39:
                if (this.f6430d && "eval".equals(((Name) cmVar).f6130g)) {
                    String str = ((Name) cmVar).f6130g;
                    mo18981a("msg.bad.id.strict");
                }
                cmVar.mo18730a(49);
                return new Node(8, cmVar, cmVar2);
            case 67:
                Node b2 = cmVar.mo18930b();
                mo18985a(b2);
                return new Node(68, b2, cmVar2);
            default:
                throw m6202T();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo18985a(Node cmVar) {
        if ((cmVar.mo18924a(16, 0) & 4) != 0) {
            mo18981a("msg.bad.assign.left");
        }
    }

    /* renamed from: a */
    protected static AstNode m6208a(AstNode eVar) {
        AstNode eVar2 = eVar;
        while (eVar2 instanceof ParenthesizedExpression) {
            eVar2 = ((ParenthesizedExpression) eVar2).f6138g;
        }
        return eVar2;
    }

    /* renamed from: g */
    private static void m6247g(AstNode eVar) {
        AstNode eVar2 = eVar;
        while (!(eVar2 instanceof DestructuringForm)) {
            if (eVar2 instanceof ParenthesizedExpression) {
                eVar2 = ((ParenthesizedExpression) eVar2).f6138g;
            } else {
                return;
            }
        }
        ((DestructuringForm) eVar2).mo18726o();
    }

    /* renamed from: T */
    private RuntimeException m6202T() {
        throw Kit.m5814b("ts.cursor=" + this.f6443q.f6659n + ", ts.tokenBeg=" + this.f6443q.f6660o + ", currentToken=" + this.f6445s);
    }
}
