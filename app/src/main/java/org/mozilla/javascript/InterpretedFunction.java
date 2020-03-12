package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.am */
final class InterpretedFunction extends NativeFunction implements Script {

    /* renamed from: a */
    InterpreterData f6014a;

    /* renamed from: b */
    SecurityController f6015b;

    /* renamed from: c */
    Object f6016c;

    private InterpretedFunction(InterpreterData arVar, Object obj) {
        Object obj2;
        this.f6014a = arVar;
        SecurityController n = Context.m6769k().mo19145n();
        if (n != null) {
            obj2 = n.mo18991a(obj);
        } else if (obj != null) {
            throw new IllegalArgumentException();
        } else {
            obj2 = null;
        }
        this.f6015b = n;
        this.f6016c = obj2;
    }

    private InterpretedFunction(InterpretedFunction amVar, int i) {
        this.f6014a = amVar.f6014a.f6058g[i];
        this.f6015b = amVar.f6015b;
        this.f6016c = amVar.f6016c;
    }

    /* renamed from: a */
    static InterpretedFunction m5713a(InterpreterData arVar, Object obj) {
        return new InterpretedFunction(arVar, (Object) null);
    }

    /* renamed from: a */
    static InterpretedFunction m5715a(Scriptable drVar, InterpreterData arVar, Object obj) {
        InterpretedFunction amVar = new InterpretedFunction(arVar, (Object) null);
        ScriptRuntime.m6379a((BaseFunction) amVar, drVar);
        return amVar;
    }

    /* renamed from: a */
    static InterpretedFunction m5714a(Scriptable drVar, InterpretedFunction amVar, int i) {
        InterpretedFunction amVar2 = new InterpretedFunction(amVar, i);
        ScriptRuntime.m6379a((BaseFunction) amVar2, drVar);
        return amVar2;
    }

    public final String getFunctionName() {
        return this.f6014a.f6052a == null ? "" : this.f6014a.f6052a;
    }

    public final Object call(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        if (!ScriptRuntime.m6431c(lVar)) {
            return ScriptRuntime.m6339a((Callable) this, lVar, drVar, drVar2, objArr);
        }
        return Interpreter.m5737a(this, lVar, drVar, drVar2, objArr);
    }

    /* renamed from: a */
    public final Object mo18678a(Context lVar, Scriptable drVar) {
        if (!(this.f6014a.f6055d == 0)) {
            throw new IllegalStateException();
        } else if (!ScriptRuntime.m6431c(lVar)) {
            return ScriptRuntime.m6339a((Callable) this, lVar, drVar, drVar, ScriptRuntime.f6517x);
        } else {
            return Interpreter.m5737a(this, lVar, drVar, drVar, ScriptRuntime.f6517x);
        }
    }

    /* renamed from: a */
    public final String mo18679a() {
        return Interpreter.m5741a(this.f6014a);
    }

    /* renamed from: a */
    public final Object mo18677a(Context lVar, int i, Object obj, Object obj2) {
        return Interpreter.m5739a(lVar, i, obj, obj2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final int mo18681b() {
        return this.f6014a.f6073v;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final int mo18683c() {
        return this.f6014a.f6068q;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final int mo18684d() {
        return this.f6014a.f6066o.length;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final String mo18680a(int i) {
        return this.f6014a.f6066o[i];
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final boolean mo18682b(int i) {
        return this.f6014a.f6067p[i];
    }
}
