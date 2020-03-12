package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.z */
public class EvaluatorException extends RhinoException {
    public EvaluatorException(String str) {
        super(str);
    }

    public EvaluatorException(String str, String str2, int i, String str3, int i2) {
        super(str);
        mo19013a(str2, i, str3, i2);
    }
}
