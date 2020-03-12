package org.mozilla.javascript;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Set;
import org.mozilla.javascript.p110b.AstRoot;
import org.mozilla.javascript.p110b.ScriptNode;
import org.mozilla.javascript.p111c.DebuggableScript;
import org.mozilla.javascript.p111c.Debugger;
import org.mozilla.javascript.p115g.C2195b;
import org.mozilla.javascript.p115g.XMLLib;

/* renamed from: org.mozilla.javascript.l */
public class Context {

    /* renamed from: A */
    private static Class<?> f6766A = Kit.m5805a("org.mozilla.javascript.an");

    /* renamed from: a */
    public static final Object[] f6767a = ScriptRuntime.f6517x;

    /* renamed from: z */
    private static Class<?> f6768z = Kit.m5805a("org.mozilla.javascript.e.g");

    /* renamed from: B */
    private boolean f6769B;

    /* renamed from: C */
    private Object f6770C;

    /* renamed from: D */
    private SecurityController f6771D;

    /* renamed from: E */
    private ClassShutter f6772E;

    /* renamed from: F */
    private ErrorReporter f6773F;

    /* renamed from: G */
    private Locale f6774G;

    /* renamed from: H */
    private WrapFactory f6775H;

    /* renamed from: I */
    private int f6776I;

    /* renamed from: J */
    private ClassLoader f6777J;

    /* renamed from: b */
    final ContextFactory f6778b;

    /* renamed from: c */
    Scriptable f6779c;

    /* renamed from: d */
    boolean f6780d;

    /* renamed from: e */
    NativeCall f6781e;

    /* renamed from: f */
    XMLLib f6782f;

    /* renamed from: g */
    ObjToIntMap f6783g;

    /* renamed from: h */
    Object f6784h;

    /* renamed from: i */
    public int f6785i;

    /* renamed from: j */
    RegExpProxy f6786j;

    /* renamed from: k */
    boolean f6787k;

    /* renamed from: l */
    boolean f6788l;

    /* renamed from: m */
    boolean f6789m;

    /* renamed from: n */
    boolean f6790n;

    /* renamed from: o */
    int f6791o;

    /* renamed from: p */
    int f6792p;

    /* renamed from: q */
    Debugger f6793q;

    /* renamed from: r */
    Set<String> f6794r;

    /* renamed from: s */
    Object f6795s;

    /* renamed from: t */
    ObjArray f6796t;

    /* renamed from: u */
    int f6797u;

    /* renamed from: v */
    int f6798v;

    /* renamed from: w */
    int f6799w;

    /* renamed from: x */
    Scriptable f6800x;

    /* renamed from: y */
    public boolean f6801y;

    public Context() {
        this(ContextFactory.m6787a());
    }

    protected Context(ContextFactory oVar) {
        int i = 0;
        this.f6789m = true;
        this.f6801y = false;
        if (oVar == null) {
            throw new IllegalArgumentException("factory == null");
        }
        this.f6778b = oVar;
        this.f6785i = 0;
        if (f6768z == null) {
            i = -1;
        }
        this.f6791o = i;
        this.f6792p = Integer.MAX_VALUE;
    }

    /* renamed from: a */
    public static Context m6753a() {
        return VMBridge.f6694a.mo19098a(VMBridge.f6694a.mo19095a());
    }

    /* renamed from: b */
    public static Context m6762b() {
        return m6754a(ContextFactory.m6787a());
    }

    /* renamed from: a */
    static final Context m6754a(ContextFactory oVar) {
        Object a = VMBridge.f6694a.mo19095a();
        Context a2 = VMBridge.f6694a.mo19098a(a);
        if (a2 == null) {
            a2 = oVar.mo19146b();
            if (a2.f6776I != 0) {
                throw new IllegalStateException("factory.makeContext() returned Context instance already associated with some thread");
            }
            oVar.mo19147e();
            if (oVar.f6807a && !a2.f6769B) {
                if (a2.f6769B) {
                    throw new IllegalStateException();
                }
                a2.f6769B = true;
                a2.f6770C = null;
            }
            VMBridge.f6694a.mo19099a(a, a2);
        }
        a2.f6776I++;
        return a2;
    }

    /* renamed from: c */
    public static void m6766c() {
        Object a = VMBridge.f6694a.mo19095a();
        Context a2 = VMBridge.f6694a.mo19098a(a);
        if (a2 == null) {
            throw new IllegalStateException("Calling Context.exit without previous Context.enter");
        }
        if (a2.f6776I <= 0) {
            Kit.m5810a();
        }
        int i = a2.f6776I - 1;
        a2.f6776I = i;
        if (i == 0) {
            VMBridge.f6694a.mo19099a(a, null);
            a2.f6778b.mo19148f();
        }
    }

    /* renamed from: a */
    public static Object m6744a(Callable eVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        return m6745a(ContextFactory.m6787a(), (ContextAction) new C2198m(eVar, drVar, drVar2, objArr));
    }

    /* renamed from: a */
    public static Object m6745a(ContextFactory oVar, ContextAction nVar) {
        try {
            return nVar.mo18676a(m6754a(oVar));
        } finally {
            m6766c();
        }
    }

    /* renamed from: d */
    public final ErrorReporter mo19139d() {
        if (this.f6773F == null) {
            return DefaultErrorReporter.f6826a;
        }
        return this.f6773F;
    }

    /* renamed from: e */
    public final Locale mo19140e() {
        if (this.f6774G == null) {
            this.f6774G = Locale.getDefault();
        }
        return this.f6774G;
    }

    /* renamed from: a */
    public static void m6760a(String str) {
        int[] iArr = {0};
        String a = m6748a(iArr);
        int i = iArr[0];
        Context k = m6769k();
        if (ContextFactory.m6788a(k, 12)) {
            Context a2 = m6753a();
            if (a2 != null) {
                a2.mo19139d().mo19167a(str, a, i, null, 0);
                return;
            }
            throw new EvaluatorException(str, a, i, null, 0);
        }
        k.mo19139d();
    }

    /* renamed from: a */
    public static EvaluatorException m6759a(String str, String str2, int i) {
        Context a = m6753a();
        if (a != null) {
            return a.mo19139d().mo19168b(str, str2, i, null, 0);
        }
        throw new EvaluatorException(str, str2, i, null, 0);
    }

    /* renamed from: b */
    static EvaluatorException m6763b(String str) {
        return m6765c(ScriptRuntime.m6448f(str));
    }

    /* renamed from: a */
    static EvaluatorException m6755a(String str, Object obj) {
        return m6765c(ScriptRuntime.m6349a(str, obj));
    }

    /* renamed from: a */
    static EvaluatorException m6756a(String str, Object obj, Object obj2) {
        return m6765c(ScriptRuntime.m6350a(str, obj, obj2));
    }

    /* renamed from: a */
    static EvaluatorException m6757a(String str, Object obj, Object obj2, Object obj3) {
        return m6765c(ScriptRuntime.m6351a(str, obj, obj2, obj3));
    }

    /* renamed from: a */
    static EvaluatorException m6758a(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return m6765c(ScriptRuntime.m6352a(str, obj, obj2, obj3, obj4));
    }

    /* renamed from: c */
    public static EvaluatorException m6765c(String str) {
        int[] iArr = {0};
        return m6759a(str, m6748a(iArr), iArr[0]);
    }

    /* renamed from: a */
    public final Object mo19134a(Scriptable drVar, String str) {
        Script a = mo19136a(str, (Evaluator) null, (ErrorReporter) null, (String) null, 0);
        if (a != null) {
            return a.mo18678a(this, drVar);
        }
        return null;
    }

    /* renamed from: a */
    public final Object mo19133a(Scriptable drVar, Reader reader) {
        Script djVar = (Script) m6743a(null, reader, null, null, 0, false, null, null);
        if (djVar != null) {
            return djVar.mo18678a(this, drVar);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Script mo19136a(String str, Evaluator yVar, ErrorReporter xVar, String str2, int i) {
        try {
            return (Script) m6743a(null, null, str, str2, i, false, yVar, xVar);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final Function mo19135a(Scriptable drVar, String str, Evaluator yVar, ErrorReporter xVar, String str2) {
        try {
            return (Function) m6743a(drVar, null, str, str2, 1, true, yVar, xVar);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /* renamed from: a */
    public static String m6747a(Script djVar) {
        return ((NativeFunction) djVar).decompile(0, 0);
    }

    /* renamed from: a */
    public static Scriptable m6750a(Scriptable drVar) {
        NativeObject cbVar = new NativeObject();
        ScriptRuntime.m6384a((ScriptableObject) cbVar, drVar, C2193eh.Object);
        return cbVar;
    }

    /* renamed from: a */
    public static Scriptable m6751a(Scriptable drVar, int i) {
        NativeArray bcVar = new NativeArray((long) i);
        ScriptRuntime.m6384a((ScriptableObject) bcVar, drVar, C2193eh.Array);
        return bcVar;
    }

    /* renamed from: a */
    public static Scriptable m6752a(Scriptable drVar, Object[] objArr) {
        if (objArr.getClass().getComponentType() != ScriptRuntime.f6503j) {
            throw new IllegalArgumentException();
        }
        NativeArray bcVar = new NativeArray(objArr);
        ScriptRuntime.m6384a((ScriptableObject) bcVar, drVar, C2193eh.Array);
        return bcVar;
    }

    /* renamed from: b */
    public static Object[] m6764b(Scriptable drVar) {
        return ScriptRuntime.m6451f(drVar);
    }

    /* renamed from: a */
    public static Scriptable m6749a(Object obj, Scriptable drVar) {
        return ScriptRuntime.m6364a(drVar, obj);
    }

    /* renamed from: b */
    public static Object m6761b(Object obj, Scriptable drVar) {
        if ((obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Scriptable)) {
            return obj;
        }
        if (obj instanceof Character) {
            return String.valueOf(((Character) obj).charValue());
        }
        return m6769k().mo19142g().mo19103a(drVar, obj, null);
    }

    /* renamed from: a */
    public static Object m6742a(Object obj, Class<?> cls) {
        return NativeJavaObject.m6085a(cls, obj);
    }

    /* renamed from: a */
    public static RuntimeException m6746a(Throwable th) {
        Throwable th2 = th;
        while (th2 instanceof InvocationTargetException) {
            th2 = ((InvocationTargetException) th2).getTargetException();
        }
        if (th2 instanceof Error) {
            Context k = m6769k();
            if (k == null || !ContextFactory.m6788a(k, 13)) {
                throw ((Error) th2);
            }
        }
        if (th2 instanceof RhinoException) {
            throw ((RhinoException) th2);
        }
        throw new WrappedException(th2);
    }

    /* renamed from: a */
    public final void mo19137a(int i) {
        int i2;
        int i3 = -1;
        if (this.f6769B) {
            throw new IllegalStateException();
        }
        if (i == -2) {
            i2 = -1;
        } else {
            i2 = i;
        }
        if (!(-1 <= i2 && i2 <= 9)) {
            throw new IllegalArgumentException("Optimization level outside [-1..9]: " + i2);
        }
        if (f6768z != null) {
            i3 = i2;
        }
        this.f6791o = i3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public final synchronized ClassShutter mo19141f() {
        return this.f6772E;
    }

    /* renamed from: g */
    public final WrapFactory mo19142g() {
        if (this.f6775H == null) {
            this.f6775H = new WrapFactory();
        }
        return this.f6775H;
    }

    /* renamed from: b */
    public final boolean mo19138b(int i) {
        return ContextFactory.m6788a(this, i);
    }

    /* renamed from: h */
    public static C2195b m6767h() {
        if (ContextFactory.m6789c()) {
            return C2195b.m6692a("org.mozilla.javascript.xmlimpl.XMLLibImpl");
        }
        if (Kit.m5805a("org.apache.xmlbeans.XmlCursor") != null) {
            return C2195b.m6692a("org.mozilla.javascript.xml.impl.xmlbeans.XMLLibImpl");
        }
        return null;
    }

    /* renamed from: i */
    protected static void m6768i() {
        ContextFactory.m6790d();
    }

    /* renamed from: j */
    public final ClassLoader mo19143j() {
        if (this.f6777J == null) {
            ContextFactory oVar = this.f6778b;
            ClassLoader classLoader = oVar.f6808b;
            if (classLoader == null) {
                ClassLoader b = VMBridge.f6694a.mo19100b();
                if (b != null && Kit.m5813a(b)) {
                    return b;
                }
                Class<?> cls = oVar.getClass();
                if (cls != ScriptRuntime.f6508o) {
                    classLoader = cls.getClassLoader();
                } else {
                    classLoader = getClass().getClassLoader();
                }
            }
            this.f6777J = classLoader;
        }
        return this.f6777J;
    }

    /* renamed from: k */
    static Context m6769k() {
        Context a = m6753a();
        if (a != null) {
            return a;
        }
        throw new RuntimeException("No Context associated with current Thread");
    }

    /* renamed from: a */
    private Object m6743a(Scriptable drVar, Reader reader, String str, String str2, int i, boolean z, Evaluator yVar, ErrorReporter xVar) {
        boolean z2;
        AstRoot a;
        Evaluator yVar2;
        boolean z3 = false;
        if (str2 == null) {
            str2 = "unnamed script";
        }
        if (!((str == null) ^ (reader == null))) {
            Kit.m5810a();
        }
        if (drVar == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!(z2 ^ z)) {
            Kit.m5810a();
        }
        CompilerEnvirons iVar = new CompilerEnvirons();
        ErrorReporter d = mo19139d();
        if (d == null) {
            throw new IllegalArgumentException();
        }
        iVar.f6738a = d;
        iVar.f6739b = this.f6785i;
        if (!this.f6788l || this.f6787k) {
            z3 = true;
        }
        iVar.f6740c = z3;
        iVar.f6741d = ContextFactory.m6788a(this, 3);
        iVar.f6742e = ContextFactory.m6788a(this, 2);
        iVar.f6746i = ContextFactory.m6788a(this, 11);
        iVar.f6747j = ContextFactory.m6788a(this, 12);
        iVar.f6743f = ContextFactory.m6788a(this, 6);
        iVar.f6744g = this.f6791o;
        iVar.f6745h = this.f6789m;
        iVar.f6754q = this.f6794r;
        iVar.f6748k = this.f6801y;
        if (xVar == null) {
            xVar = iVar.f6738a;
        }
        if (!(this.f6793q == null || reader == null)) {
            str = Kit.m5812a(reader);
            reader = null;
        }
        Parser ctVar = new Parser(iVar, xVar);
        if (z) {
            ctVar.f6428b = true;
        }
        if (str != null) {
            a = ctVar.mo18976a(str, str2, i);
        } else {
            a = ctVar.mo18975a(reader, str2, i);
        }
        if (!z || (a.mo18930b() != null && a.mo18930b().f6389a == 109)) {
            ScriptNode a2 = new IRFactory(iVar, xVar).mo18639a(a);
            if (yVar == null) {
                if (this.f6791o < 0 || f6768z == null) {
                    yVar2 = null;
                } else {
                    yVar2 = (Evaluator) Kit.m5806a(f6768z);
                }
                if (yVar2 == null) {
                    yVar2 = m6770l();
                }
            } else {
                yVar2 = yVar;
            }
            Object a3 = yVar2.mo18685a(iVar, a2, a2.f6149F, z);
            if (this.f6793q != null) {
                if (str == null) {
                    Kit.m5810a();
                }
                if (!(a3 instanceof DebuggableScript)) {
                    throw new RuntimeException("NOT SUPPORTED");
                }
            }
            if (z) {
                return yVar2.mo18688a(this, drVar, a3);
            }
            return yVar2.mo18689a(a3);
        }
        throw new IllegalArgumentException("compileFunction only accepts source with single JS function: " + str);
    }

    /* renamed from: l */
    static Evaluator m6770l() {
        return (Evaluator) Kit.m5806a(f6766A);
    }

    /* renamed from: a */
    static String m6748a(int[] iArr) {
        Context a = m6753a();
        if (a == null) {
            return null;
        }
        if (a.f6795s != null) {
            Evaluator l = m6770l();
            if (l != null) {
                return l.mo18687a(a, iArr);
            }
        }
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        new RuntimeException().printStackTrace(new PrintWriter(charArrayWriter));
        String charArrayWriter2 = charArrayWriter.toString();
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < charArrayWriter2.length(); i4++) {
            char charAt = charArrayWriter2.charAt(i4);
            if (charAt == ':') {
                i = i4;
            } else if (charAt == '(') {
                i3 = i4;
            } else if (charAt == ')') {
                i2 = i4;
            } else if (charAt == 10 && i3 != -1 && i2 != -1 && i != -1 && i3 < i && i < i2) {
                String substring = charArrayWriter2.substring(i3 + 1, i);
                if (!substring.endsWith(".java")) {
                    try {
                        iArr[0] = Integer.parseInt(charArrayWriter2.substring(i + 1, i2));
                        if (iArr[0] < 0) {
                            iArr[0] = 0;
                        }
                        return substring;
                    } catch (NumberFormatException e) {
                    }
                }
                i = -1;
                i2 = -1;
                i3 = -1;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public final RegExpProxy mo19144m() {
        if (this.f6786j == null) {
            Class a = Kit.m5805a("org.mozilla.javascript.regexp.RegExpImpl");
            if (a != null) {
                this.f6786j = (RegExpProxy) Kit.m5806a(a);
            }
        }
        return this.f6786j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public final SecurityController mo19145n() {
        SecurityController dwVar = SecurityController.f6544a;
        return dwVar != null ? dwVar : this.f6771D;
    }
}
