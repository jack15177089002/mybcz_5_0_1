package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.aw */
public final class JavaScriptException extends RhinoException {

    /* renamed from: a */
    Object f6090a;

    public JavaScriptException(Object obj, String str, int i) {
        mo19013a(str, i, null, 0);
        this.f6090a = obj;
        if ((obj instanceof NativeError) && Context.m6769k().mo19138b(10)) {
            NativeError bkVar = (NativeError) obj;
            if (!bkVar.has("fileName", bkVar)) {
                bkVar.put("fileName", bkVar, str);
            }
            if (!bkVar.has("lineNumber", bkVar)) {
                bkVar.put("lineNumber", bkVar, Integer.valueOf(i));
            }
            bkVar.mo18877a((RhinoException) this);
        }
    }

    /* renamed from: a */
    public final String mo18703a() {
        if (this.f6090a == null) {
            return "null";
        }
        if (this.f6090a instanceof NativeError) {
            return this.f6090a.toString();
        }
        try {
            return ScriptRuntime.m6436d(this.f6090a);
        } catch (RuntimeException e) {
            if (this.f6090a instanceof Scriptable) {
                return ScriptRuntime.m6404b((Scriptable) this.f6090a);
            }
            return this.f6090a.toString();
        }
    }
}
