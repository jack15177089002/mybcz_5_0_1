package org.mozilla.javascript;

import java.util.Arrays;

/* renamed from: org.mozilla.javascript.at */
/* compiled from: JavaAdapter */
final class C2139at {

    /* renamed from: a */
    Class<?> f6079a;

    /* renamed from: b */
    Class<?>[] f6080b;

    /* renamed from: c */
    ObjToIntMap f6081c;

    C2139at(Class<?> cls, Class<?>[] clsArr, ObjToIntMap crVar) {
        this.f6079a = cls;
        this.f6080b = clsArr;
        this.f6081c = crVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C2139at)) {
            return false;
        }
        C2139at atVar = (C2139at) obj;
        if (this.f6079a != atVar.f6079a) {
            return false;
        }
        if (this.f6080b != atVar.f6080b) {
            if (this.f6080b.length != atVar.f6080b.length) {
                return false;
            }
            for (int i = 0; i < this.f6080b.length; i++) {
                if (this.f6080b[i] != atVar.f6080b[i]) {
                    return false;
                }
            }
        }
        if (this.f6081c.f6418d != atVar.f6081c.f6418d) {
            return false;
        }
        C2163cs csVar = new C2163cs(this.f6081c);
        csVar.mo18970a();
        while (!csVar.mo18971b()) {
            String str = (String) csVar.mo18973d();
            int e = csVar.mo18974e();
            if (e != atVar.f6081c.mo18964a(str, e + 1)) {
                return false;
            }
            csVar.mo18972c();
        }
        return true;
    }

    public final int hashCode() {
        return (this.f6079a.hashCode() + Arrays.hashCode(this.f6080b)) ^ this.f6081c.f6418d;
    }
}
