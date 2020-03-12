package org.mozilla.javascript;

import java.util.Iterator;

/* renamed from: org.mozilla.javascript.el */
public abstract class VMBridge {

    /* renamed from: a */
    static final VMBridge f6694a;

    /* renamed from: a */
    public abstract Object mo19095a();

    /* renamed from: a */
    public abstract Context mo19098a(Object obj);

    /* renamed from: a */
    public abstract void mo19099a(Object obj, Context lVar);

    /* renamed from: b */
    public abstract ClassLoader mo19100b();

    /* renamed from: b */
    public abstract boolean mo19101b(Object obj);

    /* renamed from: c */
    public abstract boolean mo19102c();

    static {
        String[] strArr = {"org.mozilla.javascript.VMBridge_custom", "org.mozilla.javascript.jdk15.VMBridge_jdk15", "org.mozilla.javascript.jdk13.VMBridge_jdk13", "org.mozilla.javascript.jdk11.VMBridge_jdk11"};
        for (int i = 0; i != 4; i++) {
            Class a = Kit.m5805a(strArr[i]);
            if (a != null) {
                VMBridge elVar = (VMBridge) Kit.m5806a(a);
                if (elVar != null) {
                    f6694a = elVar;
                    return;
                }
            }
        }
        throw new IllegalStateException("Failed to create VMBridge instance");
    }

    /* renamed from: a */
    public Object mo19097a(Class<?>[] clsArr) {
        throw Context.m6765c("VMBridge.getInterfaceProxyHelper is not supported");
    }

    /* renamed from: a */
    public Object mo19096a(Object obj, ContextFactory oVar, InterfaceAdapter akVar, Object obj2, Scriptable drVar) {
        throw Context.m6765c("VMBridge.newInterfaceProxy is not supported");
    }

    /* renamed from: c */
    public static Iterator<?> m6655c(Object obj) {
        if (!(obj instanceof Wrapper)) {
            return null;
        }
        Object a = ((Wrapper) obj).mo18879a();
        if (a instanceof Iterator) {
            return (Iterator) a;
        }
        return null;
    }
}
