package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.ec */
final class SpecialRef extends Ref {

    /* renamed from: a */
    private Scriptable f6634a;

    /* renamed from: b */
    private int f6635b;

    /* renamed from: c */
    private String f6636c;

    private SpecialRef(Scriptable drVar, int i, String str) {
        this.f6634a = drVar;
        this.f6635b = i;
        this.f6636c = str;
    }

    /* renamed from: a */
    static Ref m6621a(Context lVar, Object obj, String str) {
        int i;
        Scriptable a = ScriptRuntime.m6365a(lVar, obj);
        if (a == null) {
            throw ScriptRuntime.m6453g(obj, str);
        }
        if (str.equals("__proto__")) {
            i = 1;
        } else if (str.equals("__parent__")) {
            i = 2;
        } else {
            throw new IllegalArgumentException(str);
        }
        if (!lVar.mo19138b(5)) {
            i = 0;
        }
        return new SpecialRef(a, i, str);
    }

    /* renamed from: a */
    public final Object mo18999a(Context lVar) {
        switch (this.f6635b) {
            case 0:
                return ScriptRuntime.m6337a(this.f6634a, this.f6636c, lVar);
            case 1:
                return this.f6634a.getPrototype();
            case 2:
                return this.f6634a.getParentScope();
            default:
                throw Kit.m5810a();
        }
    }

    /* renamed from: a */
    public final Object mo19000a(Context lVar, Object obj) {
        switch (this.f6635b) {
            case 0:
                return ScriptRuntime.m6335a(this.f6634a, this.f6636c, obj);
            case 1:
            case 2:
                Scriptable a = ScriptRuntime.m6365a(lVar, obj);
                if (a != null) {
                    Scriptable drVar = a;
                    while (drVar != this.f6634a) {
                        if (this.f6635b == 1) {
                            drVar = drVar.getPrototype();
                            continue;
                        } else {
                            drVar = drVar.getParentScope();
                            continue;
                        }
                        if (drVar == null) {
                        }
                    }
                    throw Context.m6755a("msg.cyclic.value", (Object) this.f6636c);
                }
                if (this.f6635b == 1) {
                    this.f6634a.setPrototype(a);
                    return a;
                }
                this.f6634a.setParentScope(a);
                return a;
            default:
                throw Kit.m5810a();
        }
    }

    /* renamed from: b */
    public final boolean mo19001b(Context lVar) {
        if (this.f6635b == 0) {
            return ScriptRuntime.m6392a(this.f6634a, (Object) this.f6636c, lVar);
        }
        return false;
    }
}
