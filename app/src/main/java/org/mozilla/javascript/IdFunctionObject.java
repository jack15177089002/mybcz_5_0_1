package org.mozilla.javascript;

import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.ah */
public final class IdFunctionObject extends BaseFunction {

    /* renamed from: a */
    public final int f5994a;

    /* renamed from: b */
    String f5995b;

    /* renamed from: c */
    private final IdFunctionCall f5996c;

    /* renamed from: d */
    private final Object f5997d;

    /* renamed from: e */
    private int f5998e;

    /* renamed from: f */
    private boolean f5999f;

    public IdFunctionObject(IdFunctionCall agVar, Object obj, int i, String str, int i2, Scriptable drVar) {
        super(drVar, null);
        if (i2 < 0) {
            throw new IllegalArgumentException();
        } else if (str == null) {
            throw new IllegalArgumentException();
        } else {
            this.f5996c = agVar;
            this.f5997d = obj;
            this.f5994a = i;
            this.f5998e = i2;
            this.f5995b = str;
        }
    }

    /* renamed from: a */
    public final boolean mo18643a(Object obj) {
        if (obj == null) {
            return this.f5997d == null;
        }
        return obj.equals(this.f5997d);
    }

    /* renamed from: a */
    public final void mo18642a(Scriptable drVar) {
        this.f5999f = true;
        setImmunePrototypeProperty(drVar);
    }

    /* renamed from: b */
    public final void mo18645b(Scriptable drVar) {
        ScriptableObject.defineProperty(drVar, this.f5995b, this, 2);
    }

    /* renamed from: a */
    public final void mo18641a() {
        mo18645b(getParentScope());
    }

    public final Scriptable getPrototype() {
        Scriptable prototype = super.getPrototype();
        if (prototype != null) {
            return prototype;
        }
        Scriptable functionPrototype = getFunctionPrototype(getParentScope());
        setPrototype(functionPrototype);
        return functionPrototype;
    }

    public final Object call(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        return this.f5996c.execIdCall(this, lVar, drVar, drVar2, objArr);
    }

    public final Scriptable createObject(Context lVar, Scriptable drVar) {
        if (this.f5999f) {
            return null;
        }
        throw ScriptRuntime.m6414b("msg.not.ctor", this.f5995b);
    }

    /* access modifiers changed from: 0000 */
    public final String decompile(int i, int i2) {
        boolean z;
        StringBuffer stringBuffer = new StringBuffer();
        if ((i2 & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            stringBuffer.append("function ");
            stringBuffer.append(getFunctionName());
            stringBuffer.append("() { ");
        }
        stringBuffer.append("[native code for ");
        if (this.f5996c instanceof Scriptable) {
            stringBuffer.append(((Scriptable) this.f5996c).getClassName());
            stringBuffer.append(CoreConstants.DOT);
        }
        stringBuffer.append(getFunctionName());
        stringBuffer.append(", arity=");
        stringBuffer.append(getArity());
        stringBuffer.append(z ? "]\n" : "] }\n");
        return stringBuffer.toString();
    }

    public final int getArity() {
        return this.f5998e;
    }

    public final int getLength() {
        return getArity();
    }

    public final String getFunctionName() {
        return this.f5995b == null ? "" : this.f5995b;
    }

    /* renamed from: b */
    public final RuntimeException mo18644b() {
        return new IllegalArgumentException("BAD FUNCTION ID=" + this.f5994a + " MASTER=" + this.f5996c);
    }
}
