package org.mozilla.javascript;

import java.util.Arrays;

/* renamed from: org.mozilla.javascript.dg */
/* compiled from: NativeJavaMethod */
final class C2173dg {

    /* renamed from: a */
    final Class<?>[] f6484a;

    /* renamed from: b */
    final int f6485b;

    C2173dg(Object[] objArr, int i) {
        this.f6485b = i;
        this.f6484a = new Class[objArr.length];
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = objArr[i2];
            if (obj instanceof Wrapper) {
                obj = ((Wrapper) obj).mo18879a();
            }
            this.f6484a[i2] = obj == null ? null : obj.getClass();
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C2173dg)) {
            return false;
        }
        C2173dg dgVar = (C2173dg) obj;
        if (!Arrays.equals(this.f6484a, dgVar.f6484a) || this.f6485b != dgVar.f6485b) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f6484a);
    }
}
