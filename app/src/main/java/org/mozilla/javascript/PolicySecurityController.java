package org.mozilla.javascript;

import java.lang.ref.SoftReference;
import java.lang.reflect.UndeclaredThrowableException;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.PrivilegedActionException;
import java.util.Map;
import java.util.WeakHashMap;
//import org.mozilla.p108a.C2126c;

/* renamed from: org.mozilla.javascript.cx */
public final class PolicySecurityController extends SecurityController {
    /* access modifiers changed from: private */

    /* renamed from: b */
//    public static final byte[] f6464b;

    /* renamed from: c */
    private static final Map<CodeSource, Map<ClassLoader, SoftReference<C2172dc>>> f6465c = new WeakHashMap();

    static {
//        String name = C2172dc.class.getName();
//        C2126c cVar = new C2126c(name + "Impl", name, "<generated>");
//        cVar.mo18581b("<init>", "()V", 1);
//        cVar.mo18593i(0);
//        cVar.mo18580b(183, name, "<init>", "()V");
//        cVar.mo18564a(177);
//        cVar.mo18574a(1);
//        String str = "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;";
//        cVar.mo18581b("call", "(Lorg/mozilla/javascript/Callable;" + str, 17);
//        for (int i = 1; i < 6; i++) {
//            cVar.mo18593i(i);
//        }
//        cVar.mo18580b(185, "org/mozilla/javascript/Callable", "call", "(" + str);
//        cVar.mo18564a(176);
//        cVar.mo18574a(6);
//        f6464b = cVar.mo18585c();
    }

    /* renamed from: a */
    public final Class<?> mo18990a() {
        return CodeSource.class;
    }

    /* renamed from: a */
    public final GeneratedClassLoader mo18993a(ClassLoader classLoader, Object obj) {
        return (C2171db) AccessController.doPrivileged(new C2167cy(this, classLoader, obj));
    }

    /* renamed from: a */
    public final Object mo18991a(Object obj) {
        return obj;
    }

    /* renamed from: a */
    public final Object mo18992a(Object obj, Context lVar, Callable eVar, Scriptable drVar, Object[] objArr) {
        Map map;
        C2172dc dcVar;
        ClassLoader classLoader = (ClassLoader) AccessController.doPrivileged(new C2168cz(this, lVar));
        CodeSource codeSource = (CodeSource) obj;
        synchronized (f6465c) {
            Map map2 = (Map) f6465c.get(codeSource);
            if (map2 == null) {
                WeakHashMap weakHashMap = new WeakHashMap();
                f6465c.put(codeSource, weakHashMap);
                map = weakHashMap;
            } else {
                map = map2;
            }
        }
        synchronized (map) {
            SoftReference softReference = (SoftReference) map.get(classLoader);
            if (softReference != null) {
                dcVar = (C2172dc) softReference.get();
            } else {
                dcVar = null;
            }
            if (dcVar == null) {
                try {
                    dcVar = (C2172dc) AccessController.doPrivileged(new C2170da(this, classLoader, codeSource));
                    map.put(classLoader, new SoftReference(dcVar));
                } catch (PrivilegedActionException e) {
                    throw new UndeclaredThrowableException(e.getCause());
                }
            }
        }
        return dcVar.mo18998a();
    }
}
