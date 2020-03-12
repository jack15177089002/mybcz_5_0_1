package org.mozilla.javascript;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* renamed from: org.mozilla.javascript.dm */
/* compiled from: ScriptRuntime */
final class C2175dm implements C2177do {
    private C2175dm() {
    }

    /* synthetic */ C2175dm(byte b) {
        this();
    }

    /* renamed from: a */
    public final String mo19019a(String str, Object[] objArr) {
        Context a = Context.m6753a();
        try {
            return new MessageFormat(ResourceBundle.getBundle("org.mozilla.javascript.resources.Messages", a != null ? a.mo19140e() : Locale.getDefault()).getString(str)).format(objArr);
        } catch (MissingResourceException e) {
            throw new RuntimeException("no message resource found for message property " + str);
        }
    }
}
