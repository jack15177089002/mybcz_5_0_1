package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.cj */
final class NativeScript extends BaseFunction {

    /* renamed from: a */
    private static final Object f6381a = "Script";

    /* renamed from: b */
    private Script f6382b;

    /* renamed from: a */
    static void m6101a(Scriptable drVar) {
        new NativeScript(null).exportAsJSClass(4, drVar, false);
    }

    private NativeScript(Script djVar) {
        this.f6382b = djVar;
    }

    public final String getClassName() {
        return "Script";
    }

    public final Object call(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        if (this.f6382b != null) {
            return this.f6382b.mo18678a(lVar, drVar);
        }
        return Undefined.f6689a;
    }

    public final Scriptable construct(Context lVar, Scriptable drVar, Object[] objArr) {
        throw Context.m6763b("msg.script.is.not.constructor");
    }

    public final int getLength() {
        return 0;
    }

    public final int getArity() {
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public final String decompile(int i, int i2) {
        if (this.f6382b instanceof NativeFunction) {
            return ((NativeFunction) this.f6382b).decompile(i, i2);
        }
        return super.decompile(i, i2);
    }

    /* access modifiers changed from: protected */
    public final void initPrototypeId(int i) {
        String str;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "constructor";
                break;
            case 2:
                str = "toString";
                i2 = 0;
                break;
            case 3:
                str = "compile";
                break;
            case 4:
                str = "exec";
                i2 = 0;
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(f6381a, i, str, i2);
    }

    public final Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        if (!ahVar.mo18643a(f6381a)) {
            return super.execIdCall(ahVar, lVar, drVar, drVar2, objArr);
        }
        int i = ahVar.f5994a;
        switch (i) {
            case 1:
                NativeScript cjVar = new NativeScript(m6100a(lVar, objArr.length == 0 ? "" : ScriptRuntime.m6436d(objArr[0])));
                ScriptRuntime.m6383a((ScriptableObject) cjVar, drVar);
                return cjVar;
            case 2:
                Script djVar = m6099a(drVar2, ahVar).f6382b;
                if (djVar == null) {
                    return "";
                }
                return Context.m6747a(djVar);
            case 3:
                NativeScript a = m6099a(drVar2, ahVar);
                a.f6382b = m6100a(lVar, ScriptRuntime.m6407b(objArr));
                return a;
            case 4:
                throw Context.m6755a("msg.cant.call.indirect", (Object) "exec");
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    /* renamed from: a */
    private static NativeScript m6099a(Scriptable drVar, IdFunctionObject ahVar) {
        if (drVar instanceof NativeScript) {
            return (NativeScript) drVar;
        }
        throw incompatibleCallError(ahVar);
    }

    /* renamed from: a */
    private static Script m6100a(Context lVar, String str) {
        int[] iArr = {0};
        String a = Context.m6748a(iArr);
        if (a == null) {
            a = "<Script object>";
            iArr[0] = 1;
        }
        return lVar.mo19136a(str, (Evaluator) null, DefaultErrorReporter.m6816a(lVar.mo19139d()), a, iArr[0]);
    }

    /* access modifiers changed from: protected */
    public final int findPrototypeId(String str) {
        int i;
        String str2;
        switch (str.length()) {
            case 4:
                i = 4;
                str2 = "exec";
                break;
            case 7:
                i = 3;
                str2 = "compile";
                break;
            case 8:
                i = 2;
                str2 = "toString";
                break;
            case 11:
                i = 1;
                str2 = "constructor";
                break;
            default:
                str2 = null;
                i = 0;
                break;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
