package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.di */
public final class RhinoSecurityManager extends SecurityManager {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Class mo19018a() {
        Class<InterpretedFunction>[] classContext = getClassContext();
        int length = classContext.length;
        for (int i = 0; i < length; i++) {
            Class<InterpretedFunction> cls = classContext[i];
            if ((cls != InterpretedFunction.class && NativeFunction.class.isAssignableFrom(cls)) || C2172dc.class.isAssignableFrom(cls)) {
                return cls;
            }
        }
        return null;
    }
}
