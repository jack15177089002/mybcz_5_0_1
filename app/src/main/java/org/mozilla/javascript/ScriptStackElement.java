package org.mozilla.javascript;

import java.io.Serializable;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.dq */
public final class ScriptStackElement implements Serializable {

    /* renamed from: a */
    public final String f6530a;

    /* renamed from: b */
    public final String f6531b;

    /* renamed from: c */
    public final int f6532c;

    public ScriptStackElement(String str, String str2, int i) {
        this.f6530a = str;
        this.f6531b = str2;
        this.f6532c = i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        mo19020a(sb);
        return sb.toString();
    }

    /* renamed from: a */
    public final void mo19020a(StringBuilder sb) {
        if (this.f6531b != null) {
            sb.append(this.f6531b).append("()");
        }
        sb.append('@').append(this.f6530a);
        if (this.f6532c >= 0) {
            sb.append(CoreConstants.COLON_CHAR).append(this.f6532c);
        }
    }
}
