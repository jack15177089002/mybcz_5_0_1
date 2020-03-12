package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.bw */
public final class NativeJavaConstructor extends BaseFunction {

    /* renamed from: a */
    MemberBox f6342a;

    public NativeJavaConstructor(MemberBox bbVar) {
        this.f6342a = bbVar;
    }

    public final Object call(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        return NativeJavaClass.m6076a(lVar, drVar, objArr, this.f6342a);
    }

    public final String getFunctionName() {
        return "<init>".concat(C2140au.m5786a(this.f6342a.f6279b));
    }

    public final String toString() {
        return "[JavaConstructor " + this.f6342a.mo18835b() + "]";
    }
}
