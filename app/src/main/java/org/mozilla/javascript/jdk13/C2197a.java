package org.mozilla.javascript.jdk13;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.mozilla.javascript.C2135al;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.InterfaceAdapter;
import org.mozilla.javascript.Scriptable;

/* renamed from: org.mozilla.javascript.jdk13.a */
/* compiled from: VMBridge_jdk13 */
final class C2197a implements InvocationHandler {

    /* renamed from: a */
    final /* synthetic */ Object f6761a;

    /* renamed from: b */
    final /* synthetic */ InterfaceAdapter f6762b;

    /* renamed from: c */
    final /* synthetic */ ContextFactory f6763c;

    /* renamed from: d */
    final /* synthetic */ Scriptable f6764d;

    /* renamed from: e */
    final /* synthetic */ VMBridge_jdk13 f6765e;

    C2197a(VMBridge_jdk13 vMBridge_jdk13, Object obj, InterfaceAdapter akVar, ContextFactory oVar, Scriptable drVar) {
        this.f6765e = vMBridge_jdk13;
        this.f6761a = obj;
        this.f6762b = akVar;
        this.f6763c = oVar;
        this.f6764d = drVar;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        boolean z = false;
        if (method.getDeclaringClass() == Object.class) {
            String name = method.getName();
            if (name.equals("equals")) {
                if (obj == objArr[0]) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if (name.equals("hashCode")) {
                return Integer.valueOf(this.f6761a.hashCode());
            } else {
                if (name.equals("toString")) {
                    return "Proxy[" + this.f6761a.toString() + "]";
                }
            }
        }
        return Context.m6745a(this.f6763c, (ContextAction) new C2135al(this.f6762b, this.f6761a, this.f6764d, obj, method, objArr));
    }
}
