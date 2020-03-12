package org.mozilla.javascript.p115g;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Ref;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/* renamed from: org.mozilla.javascript.g.a */
public abstract class XMLLib {

    /* renamed from: a */
    private static final Object f6719a = new Object();

    /* renamed from: a */
    public abstract boolean mo19112a();

    /* renamed from: b */
    public abstract Ref mo19113b();

    /* renamed from: c */
    public abstract Ref mo19114c();

    /* renamed from: d */
    public abstract String mo19115d();

    /* renamed from: e */
    public abstract String mo19116e();

    /* renamed from: f */
    public abstract Object mo19117f();

    /* renamed from: a */
    public static XMLLib m6685a(Scriptable drVar) {
        XMLLib aVar;
        ScriptableObject a = ScriptRuntime.m6371a(drVar);
        if (a == null) {
            aVar = null;
        } else {
            ScriptableObject.getProperty((Scriptable) a, "XML");
            aVar = (XMLLib) a.getAssociatedValue(f6719a);
        }
        if (aVar != null) {
            return aVar;
        }
        throw Context.m6765c(ScriptRuntime.m6448f("msg.XML.not.available"));
    }
}
