package org.mozilla.javascript;

import java.lang.reflect.Method;
import java.util.Arrays;

/* renamed from: org.mozilla.javascript.av */
/* compiled from: JavaMembers */
final class C2141av {

    /* renamed from: a */
    private final String f6088a;

    /* renamed from: b */
    private final Class<?>[] f6089b;

    private C2141av(String str, Class<?>[] clsArr) {
        this.f6088a = str;
        this.f6089b = clsArr;
    }

    C2141av(Method method) {
        this(method.getName(), method.getParameterTypes());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C2141av)) {
            return false;
        }
        C2141av avVar = (C2141av) obj;
        if (!avVar.f6088a.equals(this.f6088a) || !Arrays.equals(this.f6089b, avVar.f6089b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f6088a.hashCode() ^ this.f6089b.length;
    }
}
