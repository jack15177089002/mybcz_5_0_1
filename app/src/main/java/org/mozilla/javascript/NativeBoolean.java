package org.mozilla.javascript;

import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.bg */
final class NativeBoolean extends IdScriptableObject {

    /* renamed from: a */
    private static final Object f6298a = "Boolean";

    /* renamed from: b */
    private boolean f6299b;

    /* renamed from: a */
    static void m6002a(Scriptable drVar) {
        new NativeBoolean(false).exportAsJSClass(4, drVar, false);
    }

    NativeBoolean(boolean z) {
        this.f6299b = z;
    }

    public final String getClassName() {
        return "Boolean";
    }

    public final Object getDefaultValue(Class<?> cls) {
        if (cls == ScriptRuntime.f6494a) {
            return ScriptRuntime.m6312a(this.f6299b);
        }
        return super.getDefaultValue(cls);
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
            case 4:
                str = CoreConstants.VALUE_OF;
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(f6298a, i, str, i2);
    }

    public final Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        boolean z = false;
        if (!ahVar.mo18643a(f6298a)) {
            return super.execIdCall(ahVar, lVar, drVar, drVar2, objArr);
        }
        int i = ahVar.f5994a;
        if (i == 1) {
            if (objArr.length != 0) {
                z = (!(objArr[0] instanceof ScriptableObject) || !objArr[0].avoidObjectDetection()) ? ScriptRuntime.m6391a(objArr[0]) : true;
            }
            if (drVar2 == null) {
                return new NativeBoolean(z);
            }
            return ScriptRuntime.m6312a(z);
        } else if (!(drVar2 instanceof NativeBoolean)) {
            throw incompatibleCallError(ahVar);
        } else {
            boolean z2 = ((NativeBoolean) drVar2).f6299b;
            switch (i) {
                case 2:
                    return z2 ? "true" : "false";
                case 3:
                    return z2 ? "(new Boolean(true))" : "(new Boolean(false))";
                case 4:
                    return ScriptRuntime.m6312a(z2);
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
        if (length == 7) {
            i = 4;
            str2 = CoreConstants.VALUE_OF;
        } else {
            if (length == 8) {
                char charAt = str.charAt(3);
                if (charAt == 'o') {
                    i = 3;
                    str2 = "toSource";
                } else if (charAt == 't') {
                    i = 2;
                    str2 = "toString";
                }
            } else if (length == 11) {
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
