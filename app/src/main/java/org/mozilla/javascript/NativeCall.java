package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.bh */
public final class NativeCall extends IdScriptableObject {

    /* renamed from: d */
    private static final Object f6300d = "Call";

    /* renamed from: a */
    NativeFunction f6301a;

    /* renamed from: b */
    Object[] f6302b;

    /* renamed from: c */
    transient NativeCall f6303c;

    /* renamed from: a */
    static void m6003a(Scriptable drVar) {
        new NativeCall().exportAsJSClass(1, drVar, false);
    }

    NativeCall() {
    }

    NativeCall(NativeFunction blVar, Scriptable drVar, Object[] objArr) {
        this.f6301a = blVar;
        setParentScope(drVar);
        this.f6302b = objArr == null ? ScriptRuntime.f6517x : objArr;
        int d = blVar.mo18684d();
        int c = blVar.mo18683c();
        if (d != 0) {
            int i = 0;
            while (i < c) {
                defineProperty(blVar.mo18680a(i), i < objArr.length ? objArr[i] : Undefined.f6689a, 4);
                i++;
            }
        }
        if (!super.has("arguments", this)) {
            defineProperty("arguments", (Object) new Arguments(this), 4);
        }
        if (d != 0) {
            for (int i2 = c; i2 < d; i2++) {
                String a = blVar.mo18680a(i2);
                if (!super.has(a, this)) {
                    if (blVar.mo18682b(i2)) {
                        defineProperty(a, Undefined.f6689a, 13);
                    } else {
                        defineProperty(a, Undefined.f6689a, 4);
                    }
                }
            }
        }
    }

    public final String getClassName() {
        return "Call";
    }

    /* access modifiers changed from: protected */
    public final int findPrototypeId(String str) {
        return str.equals("constructor") ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public final void initPrototypeId(int i) {
        if (i == 1) {
            initPrototypeMethod(f6300d, i, "constructor", 1);
            return;
        }
        throw new IllegalArgumentException(String.valueOf(i));
    }

    public final Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        if (!ahVar.mo18643a(f6300d)) {
            return super.execIdCall(ahVar, lVar, drVar, drVar2, objArr);
        }
        int i = ahVar.f5994a;
        if (i != 1) {
            throw new IllegalArgumentException(String.valueOf(i));
        } else if (drVar2 != null) {
            throw Context.m6755a("msg.only.from.new", (Object) "Call");
        } else {
            ScriptRuntime.m6385a(lVar, "Call");
            NativeCall bhVar = new NativeCall();
            bhVar.setPrototype(getObjectPrototype(drVar));
            return bhVar;
        }
    }
}
