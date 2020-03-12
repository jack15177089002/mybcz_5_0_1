package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.bi */
public final class NativeContinuation extends IdScriptableObject implements Function {

    /* renamed from: b */
    private static final Object f6304b = "Continuation";

    /* renamed from: a */
    Object f6305a;

    public final String getClassName() {
        return "Continuation";
    }

    public final Scriptable construct(Context lVar, Scriptable drVar, Object[] objArr) {
        throw Context.m6765c("Direct call is not supported");
    }

    public final Object call(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        return Interpreter.m5738a(this, lVar, drVar, objArr);
    }

    /* renamed from: a */
    public static boolean m6004a(IdFunctionObject ahVar) {
        if (!ahVar.mo18643a(f6304b) || ahVar.f5994a != 1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void initPrototypeId(int i) {
        switch (i) {
            case 1:
                initPrototypeMethod(f6304b, i, "constructor", 0);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    public final Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        if (!ahVar.mo18643a(f6304b)) {
            return super.execIdCall(ahVar, lVar, drVar, drVar2, objArr);
        }
        int i = ahVar.f5994a;
        switch (i) {
            case 1:
                throw Context.m6765c("Direct call is not supported");
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    /* access modifiers changed from: protected */
    public final int findPrototypeId(String str) {
        String str2;
        int i;
        if (str.length() == 11) {
            i = 1;
            str2 = "constructor";
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
