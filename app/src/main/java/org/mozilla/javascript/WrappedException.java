package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.en */
public final class WrappedException extends EvaluatorException {

    /* renamed from: a */
    Throwable f6696a;

    public WrappedException(Throwable th) {
        super("Wrapped " + th.toString());
        this.f6696a = th;
        Kit.m5811a((RuntimeException) this, th);
        int[] iArr = {0};
        String a = Context.m6748a(iArr);
        int i = iArr[0];
        if (a != null) {
            mo19012a(a);
        }
        if (i != 0) {
            mo19011a(i);
        }
    }
}
