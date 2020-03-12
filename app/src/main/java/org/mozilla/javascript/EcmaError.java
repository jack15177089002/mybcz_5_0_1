package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.w */
public final class EcmaError extends RhinoException {

    /* renamed from: a */
    String f6830a;

    /* renamed from: b */
    String f6831b;

    EcmaError(String str, String str2, String str3, int i, String str4, int i2) {
        mo19013a(str3, i, str4, i2);
        this.f6830a = str;
        this.f6831b = str2;
    }

    /* renamed from: a */
    public final String mo18703a() {
        return this.f6830a + ": " + this.f6831b;
    }
}
