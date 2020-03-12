package org.mozilla.javascript.p113e;

import java.util.HashMap;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Evaluator;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.GeneratedClassLoader;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.NativeFunction;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.SecurityController;
import org.mozilla.javascript.p110b.FunctionNode;
import org.mozilla.javascript.p110b.Name;
import org.mozilla.javascript.p110b.ScriptNode;
//import org.mozilla.p108a.C2126c;
//import org.mozilla.p108a.C2127d;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.e.g */
/* compiled from: Codegen */
public class C2189g implements Evaluator {

    /* renamed from: f */
    private static final Object f6607f = new Object();

    /* renamed from: g */
    private static int f6608g;

    /* renamed from: a */
    ScriptNode[] f6609a;

    /* renamed from: b */
    String f6610b;

    /* renamed from: c */
    String f6611c;

    /* renamed from: d */
    double[] f6612d;

    /* renamed from: e */
    int f6613e;

    /* renamed from: h */
    private CompilerEnvirons f6614h;

    /* renamed from: i */
    private ObjArray f6615i;

    /* renamed from: j */
    private ObjToIntMap f6616j;

    /* renamed from: k */
    private String f6617k = "org.mozilla.javascript.optimizer.OptRuntime";

    /* renamed from: a */
    public final void mo18690a(RhinoException dhVar) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public final String mo18687a(Context lVar, int[] iArr) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public final String mo18686a(RhinoException dhVar, String str) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public final void mo18691a(Script djVar) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public final Object mo18685a(CompilerEnvirons iVar, ScriptNode auVar, String str, boolean z) {
        int i;
        synchronized (f6607f) {
            i = f6608g + 1;
            f6608g = i;
        }
        String str2 = "c";
        if (auVar.f6148E.length() > 0) {
            str2 = auVar.f6148E.replaceAll("\\W", "_");
            if (!Character.isJavaIdentifierStart(str2.charAt(0))) {
                str2 = "_" + str2;
            }
        }
        String str3 = "org.mozilla.javascript.gen." + str2 + "_" + i;
        return new Object[]{str3, m6588a(iVar, str3, auVar, str, z)};
    }

    /* renamed from: a */
    public final Script mo18689a(Object obj) {
        try {
            return (Script) m6577a(obj, (Object) null).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Unable to instantiate compiled class:" + e.toString());
        }
    }

    /* renamed from: a */
    public final Function mo18688a(Context lVar, Scriptable drVar, Object obj) {
        try {
            return (NativeFunction) m6577a(obj, (Object) null).getConstructors()[0].newInstance(new Object[]{drVar, lVar, Integer.valueOf(0)});
        } catch (Exception e) {
            throw new RuntimeException("Unable to instantiate compiled class:" + e.toString());
        }
    }

    /* renamed from: a */
    private Class<?> m6577a(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        String str = (String) objArr[0];
        byte[] bArr = (byte[]) objArr[1];
        GeneratedClassLoader b = SecurityController.m6498b(getClass().getClassLoader(), null);
        try {
            Class<?> a = b.mo18637a(str, bArr);
            b.mo18638a(a);
            return a;
        } catch (IllegalArgumentException | SecurityException e) {
            throw new RuntimeException("Malformed optimizer package " + e);
        }
    }

    /* renamed from: a */
    private byte[] m6588a(CompilerEnvirons iVar, String str, ScriptNode auVar, String str2, boolean z) {
        this.f6614h = iVar;
        m6592f(auVar);
        int i = this.f6614h.f6744g;
        HashMap hashMap = null;
        if (i > 0 && auVar.f6389a == 136) {
            int o = auVar.mo18726o();
            for (int i2 = 0; i2 != o; i2++) {
                OptFunctionNode a = OptFunctionNode.m6606a(auVar, i2);
                if (a.f6618a.f6260q == 1) {
                    String n = a.f6618a.mo18725n();
                    if (n.length() != 0) {
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        hashMap.put(n, a);
                    }
                }
            }
        }
        if (hashMap != null) {
            this.f6615i = new ObjArray();
        }
        new OptTransformer(hashMap, this.f6615i).mo18956a(auVar);
        if (i > 0) {
            new Optimizer().mo19079a(auVar);
        }
        if (z) {
            auVar = auVar.mo18764k(0);
        }
        m6593g(auVar);
        this.f6610b = str;
//        this.f6611c = C2126c.m5540c(str);
//        try {
//            return m6587a(str2);
//        } catch (C2127d e) {
//            throw m6579a(auVar, e.getMessage());
//        }
        return null;
    }

    /* renamed from: a */
    private static RuntimeException m6579a(ScriptNode auVar, String str) {
        return Context.m6759a(auVar instanceof FunctionNode ? ScriptRuntime.m6350a("msg.while.compiling.fn", (Object) ((FunctionNode) auVar).f6254h, (Object) str) : ScriptRuntime.m6349a("msg.while.compiling.script", (Object) str), auVar.f6148E, auVar.mo18794f());
    }

    /* renamed from: f */
    private static void m6592f(ScriptNode auVar) {
        int o = auVar.mo18726o();
        for (int i = 0; i != o; i++) {
            FunctionNode k = auVar.mo18764k(i);
            new OptFunctionNode(k);
            m6592f(k);
        }
    }

    /* renamed from: g */
    private void m6593g(ScriptNode auVar) {
        ObjArray cqVar = new ObjArray();
        m6585a(auVar, cqVar);
        int i = cqVar.f6407a;
        this.f6609a = new ScriptNode[i];
        cqVar.mo18962a((Object[]) this.f6609a);
        this.f6616j = new ObjToIntMap(i);
        for (int i2 = 0; i2 != i; i2++) {
            this.f6616j.mo18968b(this.f6609a[i2], i2);
        }
    }

    /* renamed from: a */
    private static void m6585a(ScriptNode auVar, ObjArray cqVar) {
        cqVar.mo18961a((Object) auVar);
        int o = auVar.mo18726o();
        for (int i = 0; i != o; i++) {
            m6585a((ScriptNode) auVar.mo18764k(i), cqVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x027f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0223  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m6587a(String r13) {
        /*
            r12 = this;
            org.mozilla.javascript.b.au[] r0 = r12.f6609a
            r1 = 0
            r0 = r0[r1]
            int r0 = r0.f6389a
            r1 = 136(0x88, float:1.9E-43)
            if (r0 != r1) goto L_0x0086
            r0 = 1
            r1 = r0
        L_0x000d:
            org.mozilla.javascript.b.au[] r0 = r12.f6609a
            int r0 = r0.length
            r2 = 1
            if (r0 > r2) goto L_0x0015
            if (r1 != 0) goto L_0x0089
        L_0x0015:
            r0 = 1
        L_0x0016:
            r2 = 0
            org.mozilla.javascript.i r3 = r12.f6614h
            boolean r3 = r3.f6740c
            if (r3 == 0) goto L_0x0024
            org.mozilla.javascript.b.au[] r2 = r12.f6609a
            r3 = 0
            r2 = r2[r3]
            java.lang.String r2 = r2.f6148E
        L_0x0024:
            org.mozilla.a.c r7 = new org.mozilla.a.c
            java.lang.String r3 = r12.f6610b
            java.lang.String r4 = "org.mozilla.javascript.NativeFunction"
            r7.<init>(r3, r4, r2)
            java.lang.String r2 = "_id"
            java.lang.String r3 = "I"
            r4 = 2
            r7.mo18573a(r2, r3, r4)
            if (r0 == 0) goto L_0x00e2
            java.lang.String r0 = "<init>"
            java.lang.String r2 = "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V"
            r3 = 1
            r7.mo18581b(r0, r2, r3)
            r0 = 0
            r7.mo18593i(r0)
            r0 = 183(0xb7, float:2.56E-43)
            java.lang.String r2 = "org.mozilla.javascript.NativeFunction"
            java.lang.String r3 = "<init>"
            java.lang.String r4 = "()V"
            r7.mo18580b(r0, r2, r3, r4)
            r0 = 42
            r7.mo18564a(r0)
            r0 = 3
            r7.mo18591g(r0)
            r0 = 181(0xb5, float:2.54E-43)
            java.lang.String r2 = r7.f5916a
            java.lang.String r3 = "_id"
            java.lang.String r4 = "I"
            r7.mo18569a(r0, r2, r3, r4)
            r0 = 42
            r7.mo18564a(r0)
            r0 = 2
            r7.mo18593i(r0)
            r0 = 1
            r7.mo18593i(r0)
            org.mozilla.javascript.b.au[] r0 = r12.f6609a
            r2 = 0
            r0 = r0[r2]
            int r0 = r0.f6389a
            r2 = 136(0x88, float:1.9E-43)
            if (r0 != r2) goto L_0x008b
            r0 = 1
            r2 = r0
        L_0x007c:
            org.mozilla.javascript.b.au[] r0 = r12.f6609a
            int r8 = r0.length
            if (r2 != r8) goto L_0x008e
            java.lang.RuntimeException r0 = m6578a()
            throw r0
        L_0x0086:
            r0 = 0
            r1 = r0
            goto L_0x000d
        L_0x0089:
            r0 = 0
            goto L_0x0016
        L_0x008b:
            r0 = 0
            r2 = r0
            goto L_0x007c
        L_0x008e:
            r0 = 2
            int r3 = r8 - r2
            if (r0 > r3) goto L_0x00d3
            r0 = 1
            r6 = r0
        L_0x0095:
            r0 = 0
            r4 = 0
            if (r6 == 0) goto L_0x03f0
            r0 = 3
            r7.mo18591g(r0)
            int r0 = r2 + 1
            int r3 = r8 + -1
            int r0 = r7.mo18576b(r0, r3)
            r3 = r0
        L_0x00a6:
            r5 = r2
            r0 = r4
        L_0x00a8:
            if (r5 == r8) goto L_0x00de
            if (r6 == 0) goto L_0x00dc
            if (r5 != r2) goto L_0x00d6
            r7.mo18594j(r3)
            short r0 = r7.f5919d
            r4 = r0
        L_0x00b4:
            org.mozilla.javascript.b.au[] r0 = r12.f6609a
            r0 = r0[r5]
            java.lang.Object r0 = r0.f6155L
            org.mozilla.javascript.e.h r0 = (org.mozilla.javascript.p113e.OptFunctionNode) r0
            r9 = 183(0xb7, float:2.56E-43)
            java.lang.String r10 = r12.f6610b
            java.lang.String r0 = r12.m6581a(r0)
            java.lang.String r11 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V"
            r7.mo18580b(r9, r10, r0, r11)
            r0 = 177(0xb1, float:2.48E-43)
            r7.mo18564a(r0)
            int r0 = r5 + 1
            r5 = r0
            r0 = r4
            goto L_0x00a8
        L_0x00d3:
            r0 = 0
            r6 = r0
            goto L_0x0095
        L_0x00d6:
            int r4 = r5 + -1
            int r4 = r4 - r2
            r7.mo18579b(r3, r4, r0)
        L_0x00dc:
            r4 = r0
            goto L_0x00b4
        L_0x00de:
            r0 = 4
            r7.mo18574a(r0)
        L_0x00e2:
            if (r1 == 0) goto L_0x018a
            java.lang.String r0 = "org/mozilla/javascript/Script"
            r7.mo18571a(r0)
            java.lang.String r0 = "<init>"
            java.lang.String r1 = "()V"
            r2 = 1
            r7.mo18581b(r0, r1, r2)
            r0 = 42
            r7.mo18564a(r0)
            r0 = 183(0xb7, float:2.56E-43)
            java.lang.String r1 = "org.mozilla.javascript.NativeFunction"
            java.lang.String r2 = "<init>"
            java.lang.String r3 = "()V"
            r7.mo18580b(r0, r1, r2, r3)
            r0 = 42
            r7.mo18564a(r0)
            r0 = 0
            r7.mo18583c(r0)
            r0 = 181(0xb5, float:2.54E-43)
            java.lang.String r1 = r7.f5916a
            java.lang.String r2 = "_id"
            java.lang.String r3 = "I"
            r7.mo18569a(r0, r1, r2, r3)
            r0 = 177(0xb1, float:2.48E-43)
            r7.mo18564a(r0)
            r0 = 1
            r7.mo18574a(r0)
            java.lang.String r0 = "main"
            java.lang.String r1 = "([Ljava/lang/String;)V"
            r2 = 9
            r7.mo18581b(r0, r1, r2)
            r0 = 187(0xbb, float:2.62E-43)
            java.lang.String r1 = r7.f5916a
            r7.mo18568a(r0, r1)
            r0 = 89
            r7.mo18564a(r0)
            r0 = 183(0xb7, float:2.56E-43)
            java.lang.String r1 = r7.f5916a
            java.lang.String r2 = "<init>"
            java.lang.String r3 = "()V"
            r7.mo18580b(r0, r1, r2, r3)
            r0 = 42
            r7.mo18564a(r0)
            r0 = 184(0xb8, float:2.58E-43)
            java.lang.String r1 = r12.f6617k
            java.lang.String r2 = "main"
            java.lang.String r3 = "(Lorg/mozilla/javascript/Script;[Ljava/lang/String;)V"
            r7.mo18580b(r0, r1, r2, r3)
            r0 = 177(0xb1, float:2.48E-43)
            r7.mo18564a(r0)
            r0 = 1
            r7.mo18574a(r0)
            java.lang.String r0 = "exec"
            java.lang.String r1 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;"
            r2 = 17
            r7.mo18581b(r0, r1, r2)
            r0 = 42
            r7.mo18564a(r0)
            r0 = 1
            r7.mo18593i(r0)
            r0 = 2
            r7.mo18593i(r0)
            r0 = 89
            r7.mo18564a(r0)
            r0 = 1
            r7.mo18564a(r0)
            r0 = 182(0xb6, float:2.55E-43)
            java.lang.String r1 = r7.f5916a
            java.lang.String r2 = "call"
            java.lang.String r3 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;"
            r7.mo18580b(r0, r1, r2, r3)
            r0 = 176(0xb0, float:2.47E-43)
            r7.mo18564a(r0)
            r0 = 3
            r7.mo18574a(r0)
        L_0x018a:
            java.lang.String r0 = "call"
            java.lang.String r1 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;"
            r2 = 17
            r7.mo18581b(r0, r1, r2)
            int r0 = r7.mo18562a()
            r1 = 1
            r7.mo18593i(r1)
            r1 = 184(0xb8, float:2.58E-43)
            java.lang.String r2 = "org/mozilla/javascript/ScriptRuntime"
            java.lang.String r3 = "hasTopCall"
            java.lang.String r4 = "(Lorg/mozilla/javascript/Context;)Z"
            r7.mo18580b(r1, r2, r3, r4)
            r1 = 154(0x9a, float:2.16E-43)
            r7.mo18565a(r1, r0)
            r1 = 0
            r7.mo18593i(r1)
            r1 = 1
            r7.mo18593i(r1)
            r1 = 2
            r7.mo18593i(r1)
            r1 = 3
            r7.mo18593i(r1)
            r1 = 4
            r7.mo18593i(r1)
            r1 = 184(0xb8, float:2.58E-43)
            java.lang.String r2 = "org/mozilla/javascript/ScriptRuntime"
            java.lang.String r3 = "doTopCall"
            java.lang.String r4 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;"
            r7.mo18580b(r1, r2, r3, r4)
            r1 = 176(0xb0, float:2.47E-43)
            r7.mo18564a(r1)
            r7.mo18595k(r0)
            r0 = 0
            r7.mo18593i(r0)
            r0 = 1
            r7.mo18593i(r0)
            r0 = 2
            r7.mo18593i(r0)
            r0 = 3
            r7.mo18593i(r0)
            r0 = 4
            r7.mo18593i(r0)
            org.mozilla.javascript.b.au[] r0 = r12.f6609a
            int r5 = r0.length
            r0 = 2
            if (r0 > r5) goto L_0x0274
            r0 = 1
            r4 = r0
        L_0x01ee:
            r0 = 0
            r2 = 0
            if (r4 == 0) goto L_0x03ed
            r0 = 42
            r7.mo18564a(r0)
            r0 = 180(0xb4, float:2.52E-43)
            java.lang.String r1 = r7.f5916a
            java.lang.String r3 = "_id"
            java.lang.String r6 = "I"
            r7.mo18569a(r0, r1, r3, r6)
            r0 = 1
            int r1 = r5 + -1
            int r0 = r7.mo18576b(r0, r1)
            r1 = r0
        L_0x020a:
            r0 = 0
            r3 = r0
            r0 = r2
        L_0x020d:
            if (r3 == r5) goto L_0x0299
            org.mozilla.javascript.b.au[] r2 = r12.f6609a
            r6 = r2[r3]
            if (r4 == 0) goto L_0x027d
            if (r3 != 0) goto L_0x0278
            r7.mo18594j(r1)
            short r0 = r7.f5919d
            r2 = r0
        L_0x021d:
            int r0 = r6.f6389a
            r8 = 109(0x6d, float:1.53E-43)
            if (r0 != r8) goto L_0x027f
            java.lang.Object r0 = r6.f6155L
            org.mozilla.javascript.e.h r0 = (org.mozilla.javascript.p113e.OptFunctionNode) r0
            boolean r8 = r0.mo19076a()
            if (r8 == 0) goto L_0x027f
            org.mozilla.javascript.b.x r0 = r0.f6618a
            int r8 = r0.f6153J
            if (r8 == 0) goto L_0x027f
            r0 = 0
        L_0x0234:
            if (r0 == r8) goto L_0x027f
            r9 = 190(0xbe, float:2.66E-43)
            r7.mo18564a(r9)
            r7.mo18583c(r0)
            int r9 = r7.mo18562a()
            int r10 = r7.mo18562a()
            r11 = 164(0xa4, float:2.3E-43)
            r7.mo18565a(r11, r9)
            r11 = 4
            r7.mo18593i(r11)
            r7.mo18583c(r0)
            r11 = 50
            r7.mo18564a(r11)
            r11 = 167(0xa7, float:2.34E-43)
            r7.mo18565a(r11, r10)
            r7.mo18595k(r9)
            m6589b(r7)
            r7.mo18595k(r10)
            r7.mo18577b()
            r10 = 0
            r7.mo18563a(r10)
            r9 = 4
            r7.mo18593i(r9)
            int r0 = r0 + 1
            goto L_0x0234
        L_0x0274:
            r0 = 0
            r4 = r0
            goto L_0x01ee
        L_0x0278:
            int r2 = r3 + -1
            r7.mo18579b(r1, r2, r0)
        L_0x027d:
            r2 = r0
            goto L_0x021d
        L_0x027f:
            r0 = 184(0xb8, float:2.58E-43)
            java.lang.String r8 = r12.f6610b
            java.lang.String r9 = r12.mo19073d(r6)
            java.lang.String r6 = r12.mo19074e(r6)
            r7.mo18580b(r0, r8, r9, r6)
            r0 = 176(0xb0, float:2.47E-43)
            r7.mo18564a(r0)
            int r0 = r3 + 1
            r3 = r0
            r0 = r2
            goto L_0x020d
        L_0x0299:
            r0 = 5
            r7.mo18574a(r0)
            r0 = 0
            r1 = 0
        L_0x029f:
            org.mozilla.javascript.b.au[] r2 = r12.f6609a
            int r2 = r2.length
            if (r1 >= r2) goto L_0x02b2
            org.mozilla.javascript.b.au[] r2 = r12.f6609a
            r2 = r2[r1]
            boolean r2 = m6586a(r2)
            if (r2 == 0) goto L_0x02af
            r0 = 1
        L_0x02af:
            int r1 = r1 + 1
            goto L_0x029f
        L_0x02b2:
            if (r0 == 0) goto L_0x035c
            java.lang.String r0 = "resumeGenerator"
            java.lang.String r1 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"
            r2 = 17
            r7.mo18581b(r0, r1, r2)
            r0 = 0
            r7.mo18593i(r0)
            r0 = 1
            r7.mo18593i(r0)
            r0 = 2
            r7.mo18593i(r0)
            r0 = 4
            r7.mo18593i(r0)
            r0 = 5
            r7.mo18593i(r0)
            r0 = 3
            r7.mo18591g(r0)
            r0 = 42
            r7.mo18564a(r0)
            r0 = 180(0xb4, float:2.52E-43)
            java.lang.String r1 = r7.f5916a
            java.lang.String r2 = "_id"
            java.lang.String r3 = "I"
            r7.mo18569a(r0, r1, r2, r3)
            r0 = 0
            org.mozilla.javascript.b.au[] r1 = r12.f6609a
            int r1 = r1.length
            int r1 = r1 + -1
            int r1 = r7.mo18576b(r0, r1)
            r7.mo18594j(r1)
            int r2 = r7.mo18562a()
            r0 = 0
        L_0x02f7:
            org.mozilla.javascript.b.au[] r3 = r12.f6609a
            int r3 = r3.length
            if (r0 >= r3) goto L_0x034d
            org.mozilla.javascript.b.au[] r3 = r12.f6609a
            r3 = r3[r0]
            r4 = 6
            r7.mo18579b(r1, r0, r4)
            boolean r4 = m6586a(r3)
            if (r4 == 0) goto L_0x0347
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "("
            r4.<init>(r5)
            java.lang.String r5 = r12.f6611c
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r5 = 184(0xb8, float:2.58E-43)
            java.lang.String r6 = r12.f6610b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r3 = r12.mo19073d(r3)
            java.lang.StringBuilder r3 = r8.append(r3)
            java.lang.String r8 = "_gen"
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            r7.mo18580b(r5, r6, r3, r4)
            r3 = 176(0xb0, float:2.47E-43)
            r7.mo18564a(r3)
        L_0x0344:
            int r0 = r0 + 1
            goto L_0x02f7
        L_0x0347:
            r3 = 167(0xa7, float:2.34E-43)
            r7.mo18565a(r3, r2)
            goto L_0x0344
        L_0x034d:
            r7.mo18595k(r2)
            m6589b(r7)
            r0 = 176(0xb0, float:2.47E-43)
            r7.mo18564a(r0)
            r0 = 6
            r7.mo18574a(r0)
        L_0x035c:
            r12.m6583a(r7, r13)
            org.mozilla.javascript.b.au[] r0 = r12.f6609a
            int r2 = r0.length
            r0 = 0
            r1 = r0
        L_0x0364:
            if (r1 == r2) goto L_0x03e2
            org.mozilla.javascript.b.au[] r0 = r12.f6609a
            r0 = r0[r1]
            org.mozilla.javascript.e.c r3 = new org.mozilla.javascript.e.c
            r3.<init>()
            r3.f6571a = r7
            r3.f6572b = r12
            org.mozilla.javascript.i r4 = r12.f6614h
            r3.f6573c = r4
            r3.f6574d = r0
            r3.f6575e = r1
            r3.mo19066a()     // Catch:{ d -> 0x03d8 }
            int r3 = r0.f6389a
            r4 = 109(0x6d, float:1.53E-43)
            if (r3 != r4) goto L_0x03d4
            java.lang.Object r0 = r0.f6155L
            org.mozilla.javascript.e.h r0 = (org.mozilla.javascript.p113e.OptFunctionNode) r0
            java.lang.String r3 = r12.m6581a(r0)
            java.lang.String r4 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V"
            r5 = 18
            r7.mo18581b(r3, r4, r5)
            r3 = 42
            r7.mo18564a(r3)
            r3 = 1
            r7.mo18593i(r3)
            r3 = 2
            r7.mo18593i(r3)
            r3 = 182(0xb6, float:2.55E-43)
            java.lang.String r4 = "org/mozilla/javascript/NativeFunction"
            java.lang.String r5 = "initScriptFunction"
            java.lang.String r6 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V"
            r7.mo18580b(r3, r4, r5, r6)
            org.mozilla.javascript.b.x r3 = r0.f6618a
            int r3 = r3.mo18742p()
            if (r3 == 0) goto L_0x03c2
            r3 = 1
            r7.mo18593i(r3)
            r3 = 184(0xb8, float:2.58E-43)
            java.lang.String r4 = r12.f6610b
            java.lang.String r5 = "_reInit"
            java.lang.String r6 = "(Lorg/mozilla/javascript/Context;)V"
            r7.mo18580b(r3, r4, r5, r6)
        L_0x03c2:
            r3 = 177(0xb1, float:2.48E-43)
            r7.mo18564a(r3)
            r3 = 3
            r7.mo18574a(r3)
            boolean r3 = r0.mo19076a()
            if (r3 == 0) goto L_0x03d4
            r12.m6584a(r7, r0)
        L_0x03d4:
            int r0 = r1 + 1
            r1 = r0
            goto L_0x0364
        L_0x03d8:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            java.lang.RuntimeException r0 = m6579a(r0, r1)
            throw r0
        L_0x03e2:
            r12.m6590c(r7)
            r12.m6591d(r7)
            byte[] r0 = r7.mo18585c()
            return r0
        L_0x03ed:
            r1 = r0
            goto L_0x020a
        L_0x03f0:
            r3 = r0
            goto L_0x00a6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.p113e.C2189g.m6587a(java.lang.String):byte[]");
    }

    /* renamed from: a */
//    private void m6584a(C2126c cVar, OptFunctionNode hVar) {
//        cVar.mo18581b(mo19072c((ScriptNode) hVar.f6618a), mo19074e(hVar.f6618a), 10);
//        int i = hVar.f6618a.f6153J;
//        int i2 = (i * 3) + 4 + 1;
//        cVar.mo18593i(0);
//        cVar.mo18593i(1);
//        cVar.mo18593i(2);
//        cVar.mo18580b(182, "org/mozilla/javascript/BaseFunction", "createObject", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
//        cVar.mo18590f(i2);
//        cVar.mo18593i(0);
//        cVar.mo18593i(1);
//        cVar.mo18593i(2);
//        cVar.mo18593i(i2);
//        for (int i3 = 0; i3 < i; i3++) {
//            cVar.mo18593i((i3 * 3) + 4);
//            cVar.mo18592h((i3 * 3) + 5);
//        }
//        cVar.mo18593i((i * 3) + 4);
//        cVar.mo18580b(184, this.f6610b, mo19073d((ScriptNode) hVar.f6618a), mo19074e(hVar.f6618a));
//        int a = cVar.mo18562a();
//        cVar.mo18564a(89);
//        cVar.mo18568a(193, "org/mozilla/javascript/Scriptable");
//        cVar.mo18565a(153, a);
//        cVar.mo18568a(192, "org/mozilla/javascript/Scriptable");
//        cVar.mo18564a(176);
//        cVar.mo18595k(a);
//        cVar.mo18593i(i2);
//        cVar.mo18564a(176);
//        cVar.mo18574a((short) (i2 + 1));
//    }

    /* renamed from: a */
    static boolean m6586a(ScriptNode auVar) {
        return auVar.f6389a == 109 && ((FunctionNode) auVar).f6262s;
    }

    /* renamed from: a */
//    private void m6583a(C2126c cVar, String str) {
//        short s;
//        int i;
//        int i2;
//        cVar.mo18581b("getLanguageVersion", "()I", 1);
//        cVar.mo18583c(this.f6614h.f6739b);
//        cVar.mo18564a(172);
//        cVar.mo18574a(1);
//        int i3 = 0;
//        while (true) {
//            int i4 = i3;
//            if (i4 != 6) {
//                if (i4 != 4 || str != null) {
//                    switch (i4) {
//                        case 0:
//                            cVar.mo18581b("getFunctionName", "()Ljava/lang/String;", 1);
//                            s = 1;
//                            break;
//                        case 1:
//                            cVar.mo18581b("getParamCount", "()I", 1);
//                            s = 1;
//                            break;
//                        case 2:
//                            cVar.mo18581b("getParamAndVarCount", "()I", 1);
//                            s = 1;
//                            break;
//                        case 3:
//                            cVar.mo18581b("getParamOrVarName", "(I)Ljava/lang/String;", 1);
//                            s = 2;
//                            break;
//                        case 4:
//                            cVar.mo18581b("getEncodedSource", "()Ljava/lang/String;", 1);
//                            cVar.mo18589e(str);
//                            s = 1;
//                            break;
//                        case 5:
//                            cVar.mo18581b("getParamOrVarConst", "(I)Z", 1);
//                            s = 3;
//                            break;
//                        default:
//                            throw Kit.m5810a();
//                    }
//                    int length = this.f6609a.length;
//                    int i5 = 0;
//                    if (length > 1) {
//                        cVar.mo18564a(42);
//                        cVar.mo18569a(180, cVar.f5916a, "_id", "I");
//                        i = cVar.mo18576b(1, length - 1);
//                    } else {
//                        i = 0;
//                    }
//                    int i6 = 0;
//                    while (i6 != length) {
//                        ScriptNode auVar = this.f6609a[i6];
//                        if (i6 == 0) {
//                            if (length > 1) {
//                                cVar.mo18594j(i);
//                                i2 = cVar.f5919d;
//                            }
//                            i2 = i5;
//                        } else {
//                            cVar.mo18579b(i, i6 - 1, i5);
//                            i2 = i5;
//                        }
//                        switch (i4) {
//                            case 0:
//                                if (auVar.f6389a == 136) {
//                                    cVar.mo18589e("");
//                                } else {
//                                    cVar.mo18589e(((FunctionNode) auVar).mo18725n());
//                                }
//                                cVar.mo18564a(176);
//                                break;
//                            case 1:
//                                cVar.mo18583c(auVar.f6153J);
//                                cVar.mo18564a(172);
//                                break;
//                            case 2:
//                                cVar.mo18583c(auVar.mo18768v());
//                                cVar.mo18564a(172);
//                                break;
//                            case 3:
//                                int v = auVar.mo18768v();
//                                if (v != 0) {
//                                    if (v != 1) {
//                                        cVar.mo18591g(1);
//                                        int b = cVar.mo18576b(1, v - 1);
//                                        for (int i7 = 0; i7 != v; i7++) {
//                                            if (cVar.f5919d != 0) {
//                                                Kit.m5810a();
//                                            }
//                                            String n = auVar.mo18767n(i7);
//                                            if (i7 == 0) {
//                                                cVar.mo18594j(b);
//                                            } else {
//                                                cVar.mo18579b(b, i7 - 1, 0);
//                                            }
//                                            cVar.mo18589e(n);
//                                            cVar.mo18564a(176);
//                                        }
//                                        break;
//                                    } else {
//                                        cVar.mo18589e(auVar.mo18767n(0));
//                                        cVar.mo18564a(176);
//                                        break;
//                                    }
//                                } else {
//                                    cVar.mo18564a(1);
//                                    cVar.mo18564a(176);
//                                    break;
//                                }
//                            case 4:
//                                cVar.mo18583c(auVar.f6146C);
//                                cVar.mo18583c(auVar.f6147D);
//                                cVar.mo18580b(182, "java/lang/String", "substring", "(II)Ljava/lang/String;");
//                                cVar.mo18564a(176);
//                                break;
//                            case 5:
//                                int v2 = auVar.mo18768v();
//                                boolean[] B = auVar.mo18755B();
//                                if (v2 != 0) {
//                                    if (v2 != 1) {
//                                        cVar.mo18591g(1);
//                                        int b2 = cVar.mo18576b(1, v2 - 1);
//                                        for (int i8 = 0; i8 != v2; i8++) {
//                                            if (cVar.f5919d != 0) {
//                                                Kit.m5810a();
//                                            }
//                                            if (i8 == 0) {
//                                                cVar.mo18594j(b2);
//                                            } else {
//                                                cVar.mo18579b(b2, i8 - 1, 0);
//                                            }
//                                            cVar.mo18575a(B[i8]);
//                                            cVar.mo18564a(172);
//                                        }
//                                        break;
//                                    } else {
//                                        cVar.mo18575a(B[0]);
//                                        cVar.mo18564a(172);
//                                        break;
//                                    }
//                                } else {
//                                    cVar.mo18564a(3);
//                                    cVar.mo18564a(172);
//                                    break;
//                                }
//                            default:
//                                throw Kit.m5810a();
//                        }
//                        i6++;
//                        i5 = i2;
//                    }
//                    cVar.mo18574a(s);
//                }
//                i3 = i4 + 1;
//            } else {
//                return;
//            }
//        }
//    }

    /* renamed from: c */
//    private void m6590c(C2126c cVar) {
//        int i = 0;
//        for (int i2 = 0; i2 != this.f6609a.length; i2++) {
//            i += this.f6609a[i2].mo18742p();
//        }
//        if (i != 0) {
//            cVar.mo18581b("_reInit", "(Lorg/mozilla/javascript/Context;)V", 10);
//            cVar.mo18573a("_reInitDone", "Z", 74);
//            cVar.mo18569a(178, this.f6610b, "_reInitDone", "Z");
//            int a = cVar.mo18562a();
//            cVar.mo18565a(153, a);
//            cVar.mo18564a(177);
//            cVar.mo18595k(a);
//            cVar.mo18593i(0);
//            cVar.mo18580b(184, "org/mozilla/javascript/ScriptRuntime", "checkRegExpProxy", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/RegExpProxy;");
//            cVar.mo18590f(1);
//            for (int i3 = 0; i3 != this.f6609a.length; i3++) {
//                ScriptNode auVar = this.f6609a[i3];
//                int p = auVar.mo18742p();
//                for (int i4 = 0; i4 != p; i4++) {
//                    String a2 = mo19070a(auVar, i4);
//                    String str = "Ljava/lang/Object;";
//                    String l = auVar.mo18765l(i4);
//                    String m = auVar.mo18766m(i4);
//                    cVar.mo18573a(a2, str, 10);
//                    cVar.mo18593i(1);
//                    cVar.mo18593i(0);
//                    cVar.mo18589e(l);
//                    if (m == null) {
//                        cVar.mo18564a(1);
//                    } else {
//                        cVar.mo18589e(m);
//                    }
//                    cVar.mo18580b(185, "org/mozilla/javascript/RegExpProxy", "compileRegExp", "(Lorg/mozilla/javascript/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;");
//                    cVar.mo18569a(179, this.f6610b, a2, str);
//                }
//            }
//            cVar.mo18583c(1);
//            cVar.mo18569a(179, this.f6610b, "_reInitDone", "Z");
//            cVar.mo18564a(177);
//            cVar.mo18574a(2);
//        }
//    }

    /* renamed from: d */
//    private void m6591d(C2126c cVar) {
//        int i = this.f6613e;
//        if (i != 0) {
//            cVar.mo18581b("<clinit>", "()V", 24);
//            double[] dArr = this.f6612d;
//            for (int i2 = 0; i2 != i; i2++) {
//                double d = dArr[i2];
//                String str = "_k" + i2;
//                String a = m6580a(d);
//                cVar.mo18573a(str, a, 10);
//                int i3 = (int) d;
//                if (((double) i3) == d) {
//                    cVar.mo18583c(i3);
//                    cVar.mo18580b(184, "java/lang/Integer", CoreConstants.VALUE_OF, "(I)Ljava/lang/Integer;");
//                } else {
//                    cVar.mo18563a(d);
//                    m6582a(cVar);
//                }
//                cVar.mo18569a(179, this.f6610b, str, a);
//            }
//            cVar.mo18564a(177);
//            cVar.mo18574a(0);
//        }
//    }

    /* renamed from: a */
//    static void m6582a(C2126c cVar) {
//        cVar.mo18580b(184, "org/mozilla/javascript/optimizer/OptRuntime", "wrapDouble", "(D)Ljava/lang/Double;");
//    }

    /* renamed from: a */
    static String m6580a(double d) {
        if (((double) ((int) d)) == d) {
            return "Ljava/lang/Integer;";
        }
        return "Ljava/lang/Double;";
    }

    /* renamed from: b */
//    static void m6589b(C2126c cVar) {
//        cVar.mo18569a(178, "org/mozilla/javascript/Undefined", "instance", "Ljava/lang/Object;");
//    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=org.mozilla.javascript.b.au, code=java.lang.Object, for r3v0, types: [java.lang.Object, org.mozilla.javascript.b.au] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo19071b(Object r3) {
        /*
            r2 = this;
            org.mozilla.javascript.cr r0 = r2.f6616j
            if (r3 != 0) goto L_0x0006
            org.mozilla.javascript.ek r3 = org.mozilla.javascript.UniqueTag.f6691b
        L_0x0006:
            int r1 = r0.mo18969c(r3)
            if (r1 < 0) goto L_0x0011
            int[] r0 = r0.f6417c
            r0 = r0[r1]
        L_0x0010:
            return r0
        L_0x0011:
            org.mozilla.javascript.Kit.m5810a()
            r0 = 0
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.p113e.C2189g.mo19071b(org.mozilla.javascript.b.au):int");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final String mo19072c(ScriptNode auVar) {
        return "_n" + mo19071b(auVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public final String mo19073d(ScriptNode auVar) {
        String str;
        StringBuilder sb = new StringBuilder("_c_");
        if (auVar instanceof FunctionNode) {
            Name akVar = ((FunctionNode) auVar).f6254h;
            str = akVar == null ? "anonymous" : akVar.f6130g;
        } else {
            str = "script";
        }
        return sb.append(str).append("_").append(mo19071b(auVar)).toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final String mo19074e(ScriptNode auVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(CoreConstants.LEFT_PARENTHESIS_CHAR);
        stringBuffer.append(this.f6611c);
        stringBuffer.append("Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;");
        if (auVar.f6389a == 109) {
            OptFunctionNode hVar = (OptFunctionNode) auVar.f6155L;
            if (hVar.mo19076a()) {
                int i = hVar.f6618a.f6153J;
                for (int i2 = 0; i2 != i; i2++) {
                    stringBuffer.append("Ljava/lang/Object;D");
                }
            }
        }
        stringBuffer.append("[Ljava/lang/Object;)Ljava/lang/Object;");
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private String m6581a(OptFunctionNode hVar) {
        return "_i" + mo19071b((ScriptNode) hVar.f6618a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final String mo19070a(ScriptNode auVar, int i) {
        return "_re" + mo19071b(auVar) + "_" + i;
    }

    /* renamed from: a */
    static RuntimeException m6578a() {
        throw new RuntimeException("Bad tree in codegen");
    }
}
