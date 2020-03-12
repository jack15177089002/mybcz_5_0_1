package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.u */
final class DefaultErrorReporter implements ErrorReporter {

    /* renamed from: a */
    static final DefaultErrorReporter f6826a = new DefaultErrorReporter();

    /* renamed from: b */
    private boolean f6827b;

    /* renamed from: c */
    private ErrorReporter f6828c;

    private DefaultErrorReporter() {
    }

    /* renamed from: a */
    static ErrorReporter m6816a(ErrorReporter xVar) {
        DefaultErrorReporter uVar = new DefaultErrorReporter();
        uVar.f6827b = true;
        uVar.f6828c = xVar;
        return uVar;
    }

    /* renamed from: a */
    public final void mo19167a(String str, String str2, int i, String str3, int i2) {
        String str4;
        if (this.f6827b) {
            String str5 = "SyntaxError";
            if (str.startsWith("TypeError: ")) {
                str5 = "TypeError";
                str4 = str.substring(11);
            } else {
                str4 = str;
            }
            throw ScriptRuntime.m6377a(str5, str4, str2, i, str3, i2);
        } else if (this.f6828c != null) {
            this.f6828c.mo19167a(str, str2, i, str3, i2);
        } else {
            throw mo19168b(str, str2, i, str3, i2);
        }
    }

    /* renamed from: b */
    public final EvaluatorException mo19168b(String str, String str2, int i, String str3, int i2) {
        if (this.f6828c != null) {
            return this.f6828c.mo19168b(str, str2, i, str3, i2);
        }
        return new EvaluatorException(str, str2, i, str3, i2);
    }
}
