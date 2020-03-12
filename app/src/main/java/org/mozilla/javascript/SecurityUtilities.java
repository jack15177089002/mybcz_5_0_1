package org.mozilla.javascript;

import java.security.AccessController;

/* renamed from: org.mozilla.javascript.dy */
public final class SecurityUtilities {
    /* renamed from: a */
    public static String m6504a(String str) {
        return (String) AccessController.doPrivileged(new C2183dz(str));
    }
}
