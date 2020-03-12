package org.mozilla.javascript;

import java.lang.reflect.Method;

/* renamed from: org.mozilla.javascript.al */
/* compiled from: InterfaceAdapter */
public final class C2135al implements ContextAction {

    /* renamed from: a */
    final /* synthetic */ Object f6008a;

    /* renamed from: b */
    final /* synthetic */ Scriptable f6009b;

    /* renamed from: c */
    final /* synthetic */ Object f6010c;

    /* renamed from: d */
    final /* synthetic */ Method f6011d;

    /* renamed from: e */
    final /* synthetic */ Object[] f6012e;

    /* renamed from: f */
    final /* synthetic */ InterfaceAdapter f6013f;

    public C2135al(InterfaceAdapter akVar, Object obj, Scriptable drVar, Object obj2, Method method, Object[] objArr) {
        this.f6013f = akVar;
        this.f6008a = obj;
        this.f6009b = drVar;
        this.f6010c = obj2;
        this.f6011d = method;
        this.f6012e = objArr;
    }

    /* renamed from: a */
    public final Object mo18676a(Context lVar) {
        Callable eVar;
        Object obj = this.f6008a;
        Scriptable drVar = this.f6009b;
        Object obj2 = this.f6010c;
        Method method = this.f6011d;
        Object[] objArr = this.f6012e;
        if (obj instanceof Callable) {
            eVar = (Callable) obj;
        } else {
            Scriptable drVar2 = (Scriptable) obj;
            String name = method.getName();
            Object property = ScriptableObject.getProperty(drVar2, name);
            if (property == ScriptableObject.f6533j) {
                Context.m6760a(ScriptRuntime.m6349a("msg.undefined.function.interface", (Object) name));
                Class returnType = method.getReturnType();
                if (returnType != Void.TYPE) {
                    return Context.m6742a((Object) null, returnType);
                }
                return null;
            } else if (!(property instanceof Callable)) {
                throw Context.m6755a("msg.not.function.interface", (Object) name);
            } else {
                eVar = (Callable) property;
            }
        }
        WrapFactory g = lVar.mo19142g();
        if (objArr == null) {
            objArr = ScriptRuntime.f6517x;
        } else {
            int length = objArr.length;
            for (int i = 0; i != length; i++) {
                Object obj3 = objArr[i];
                if (!(obj3 instanceof String) && !(obj3 instanceof Number) && !(obj3 instanceof Boolean)) {
                    objArr[i] = g.mo19103a(drVar, obj3, null);
                }
            }
        }
        Object call = eVar.call(lVar, drVar, WrapFactory.m6664b(drVar, obj2, null), objArr);
        Class returnType2 = method.getReturnType();
        return returnType2 == Void.TYPE ? null : Context.m6742a(call, returnType2);
    }
}
