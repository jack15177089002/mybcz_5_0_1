package org.mozilla.javascript;

import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.bk */
final class NativeError extends IdScriptableObject {

    /* renamed from: a */
    private static final Object f6315a = "Error";

    /* renamed from: b */
    private RhinoException f6316b;

    NativeError() {
    }

    /* renamed from: a */
    static void m6038a(Scriptable drVar) {
        NativeError bkVar = new NativeError();
        ScriptableObject.putProperty((Scriptable) bkVar, "name", (Object) "Error");
        ScriptableObject.putProperty((Scriptable) bkVar, "message", (Object) "");
        ScriptableObject.putProperty((Scriptable) bkVar, "fileName", (Object) "");
        ScriptableObject.putProperty((Scriptable) bkVar, "lineNumber", (Object) Integer.valueOf(0));
        bkVar.exportAsJSClass(3, drVar, false);
    }

    /* renamed from: a */
    static NativeError m6037a(Scriptable drVar, IdFunctionObject ahVar, Object[] objArr) {
        Scriptable drVar2 = (Scriptable) ahVar.get("prototype", ahVar);
        NativeError bkVar = new NativeError();
        bkVar.setPrototype(drVar2);
        bkVar.setParentScope(drVar);
        int length = objArr.length;
        if (length > 0) {
            ScriptableObject.putProperty((Scriptable) bkVar, "message", (Object) ScriptRuntime.m6436d(objArr[0]));
            if (length >= 2) {
                ScriptableObject.putProperty((Scriptable) bkVar, "fileName", objArr[1]);
                if (length >= 3) {
                    ScriptableObject.putProperty((Scriptable) bkVar, "lineNumber", (Object) Integer.valueOf(ScriptRuntime.m6446f(objArr[2])));
                }
            }
        }
        return bkVar;
    }

    public final String getClassName() {
        return "Error";
    }

    public final String toString() {
        Object b = m6039b(this);
        return b instanceof String ? (String) b : super.toString();
    }

    /* access modifiers changed from: protected */
    public final void initPrototypeId(int i) {
        String str;
        int i2 = 0;
        switch (i) {
            case 1:
                i2 = 1;
                str = "constructor";
                break;
            case 2:
                str = "toString";
                break;
            case 3:
                str = "toSource";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(f6315a, i, str, i2);
    }

    public final Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        if (!ahVar.mo18643a(f6315a)) {
            return super.execIdCall(ahVar, lVar, drVar, drVar2, objArr);
        }
        int i = ahVar.f5994a;
        switch (i) {
            case 1:
                return m6037a(drVar, ahVar, objArr);
            case 2:
                return m6039b(drVar2);
            case 3:
                Object property = ScriptableObject.getProperty(drVar2, "name");
                Object property2 = ScriptableObject.getProperty(drVar2, "message");
                Object property3 = ScriptableObject.getProperty(drVar2, "fileName");
                Object property4 = ScriptableObject.getProperty(drVar2, "lineNumber");
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("(new ");
                if (property == f6533j) {
                    property = Undefined.f6689a;
                }
                stringBuffer.append(ScriptRuntime.m6436d(property));
                stringBuffer.append("(");
                if (!(property2 == f6533j && property3 == f6533j && property4 == f6533j)) {
                    stringBuffer.append(ScriptRuntime.m6354a(lVar, drVar, property2 == f6533j ? "" : property2));
                    if (!(property3 == f6533j && property4 == f6533j)) {
                        stringBuffer.append(", ");
                        stringBuffer.append(ScriptRuntime.m6354a(lVar, drVar, property3 == f6533j ? "" : property3));
                        if (property4 != f6533j) {
                            int f = ScriptRuntime.m6446f(property4);
                            if (f != 0) {
                                stringBuffer.append(", ");
                                stringBuffer.append(ScriptRuntime.m6402b((double) f));
                            }
                        }
                    }
                }
                stringBuffer.append("))");
                return stringBuffer.toString();
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    /* renamed from: a */
    public final void mo18877a(RhinoException dhVar) {
        if (this.f6316b == null) {
            this.f6316b = dhVar;
            String str = "stack";
            try {
                defineProperty(str, null, NativeError.class.getMethod("a", new Class[0]), NativeError.class.getMethod("a", new Class[]{Object.class}), 0);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: a */
    public final Object mo18875a() {
        ScriptStackElement[] b;
        Object sb;
        if (this.f6316b == null) {
            sb = f6533j;
        } else {
            RhinoException dhVar = this.f6316b;
            StringBuilder sb2 = new StringBuilder();
            String a = SecurityUtilities.m6504a("line.separator");
            for (ScriptStackElement dqVar : dhVar.mo19014b()) {
                if (RhinoException.f6486c) {
                    dqVar.mo19020a(sb2);
                } else {
                    sb2.append("\tat ").append(dqVar.f6530a);
                    if (dqVar.f6532c >= 0) {
                        sb2.append(CoreConstants.COLON_CHAR).append(dqVar.f6532c);
                    }
                    if (dqVar.f6531b != null) {
                        sb2.append(" (").append(dqVar.f6531b).append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
                    }
                }
                sb2.append(a);
            }
            sb = sb2.toString();
        }
        mo18876a(sb);
        return sb;
    }

    /* renamed from: a */
    public final void mo18876a(Object obj) {
        if (this.f6316b != null) {
            this.f6316b = null;
            delete("stack");
        }
        put("stack", this, obj);
    }

    /* renamed from: b */
    private static Object m6039b(Scriptable drVar) {
        String str;
        Object property = ScriptableObject.getProperty(drVar, "name");
        if (property == f6533j || property == Undefined.f6689a) {
            str = "Error";
        } else {
            str = ScriptRuntime.m6436d(property);
        }
        Object property2 = ScriptableObject.getProperty(drVar, "message");
        if (property2 == f6533j || property2 == Undefined.f6689a) {
            return Undefined.f6689a;
        }
        return str + ": " + ScriptRuntime.m6436d(property2);
    }

    /* access modifiers changed from: protected */
    public final int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 8) {
            char charAt = str.charAt(3);
            if (charAt == 'o') {
                i = 3;
                str2 = "toSource";
            } else {
                if (charAt == 't') {
                    i = 2;
                    str2 = "toString";
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 11) {
                i = 1;
                str2 = "constructor";
            }
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
