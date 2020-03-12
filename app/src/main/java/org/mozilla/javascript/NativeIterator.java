package org.mozilla.javascript;

import java.util.Iterator;

/* renamed from: org.mozilla.javascript.bp */
public final class NativeIterator extends IdScriptableObject {

    /* renamed from: a */
    private static final Object f6325a = "Iterator";

    /* renamed from: b */
    private Object f6326b;

    /* renamed from: a */
    static void m6065a(ScriptableObject dsVar) {
        new NativeIterator().exportAsJSClass(3, dsVar, false);
        NativeGenerator.m6051a(dsVar);
        C2150bq bqVar = new C2150bq();
        bqVar.setPrototype(getObjectPrototype(dsVar));
        bqVar.setParentScope(dsVar);
        ScriptableObject.defineProperty(dsVar, "StopIteration", bqVar, 2);
        dsVar.associateValue(f6325a, bqVar);
    }

    private NativeIterator() {
    }

    private NativeIterator(Object obj) {
        this.f6326b = obj;
    }

    /* renamed from: a */
    public static Object m6064a(Scriptable drVar) {
        return ScriptableObject.getTopScopeValue(ScriptableObject.getTopLevelScope(drVar), f6325a);
    }

    public final String getClassName() {
        return "Iterator";
    }

    /* access modifiers changed from: protected */
    public final void initPrototypeId(int i) {
        int i2;
        String str;
        switch (i) {
            case 1:
                i2 = 2;
                str = "constructor";
                break;
            case 2:
                i2 = 0;
                str = "next";
                break;
            case 3:
                i2 = 1;
                str = "__iterator__";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(f6325a, i, str, i2);
    }

    public final Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        boolean z = true;
        if (!ahVar.mo18643a(f6325a)) {
            return super.execIdCall(ahVar, lVar, drVar, drVar2, objArr);
        }
        int i = ahVar.f5994a;
        if (i == 1) {
            if (objArr.length == 0 || objArr[0] == null || objArr[0] == Undefined.f6689a) {
                throw ScriptRuntime.m6414b("msg.no.properties", ScriptRuntime.m6436d(objArr.length == 0 ? Undefined.f6689a : objArr[0]));
            }
            Scriptable a = ScriptRuntime.m6364a(drVar, objArr[0]);
            if (objArr.length <= 1 || !ScriptRuntime.m6391a(objArr[1])) {
                z = false;
            }
            if (drVar2 != null) {
                VMBridge elVar = VMBridge.f6694a;
                Iterator c = VMBridge.m6655c(a);
                if (c != null) {
                    Scriptable topLevelScope = ScriptableObject.getTopLevelScope(drVar);
                    return lVar.mo19142g().mo19103a(topLevelScope, new C2151br(c, topLevelScope), C2151br.class);
                }
                Scriptable a2 = ScriptRuntime.m6368a(lVar, drVar, a, z);
                if (a2 != null) {
                    return a2;
                }
            }
            Object a3 = ScriptRuntime.m6327a((Object) a, lVar, z ? 3 : 5);
            ScriptRuntime.m6463i(a3);
            NativeIterator bpVar = new NativeIterator(a3);
            bpVar.setPrototype(ScriptableObject.getClassPrototype(drVar, bpVar.getClassName()));
            bpVar.setParentScope(drVar);
            return bpVar;
        } else if (!(drVar2 instanceof NativeIterator)) {
            throw incompatibleCallError(ahVar);
        } else {
            NativeIterator bpVar2 = (NativeIterator) drVar2;
            switch (i) {
                case 2:
                    if (ScriptRuntime.m6464j(bpVar2.f6326b).booleanValue()) {
                        return ScriptRuntime.m6326a(bpVar2.f6326b, lVar);
                    }
                    throw new JavaScriptException(m6064a(drVar), null, 0);
                case 3:
                    return drVar2;
                default:
                    throw new IllegalArgumentException(String.valueOf(i));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 4) {
            i = 2;
            str2 = "next";
        } else if (length == 11) {
            i = 1;
            str2 = "constructor";
        } else if (length == 12) {
            i = 3;
            str2 = "__iterator__";
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
