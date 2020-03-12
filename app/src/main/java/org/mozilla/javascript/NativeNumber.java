package org.mozilla.javascript;

import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.ca */
final class NativeNumber extends IdScriptableObject {

    /* renamed from: a */
    private static final Object f6360a = "Number";

    /* renamed from: b */
    private double f6361b;

    /* renamed from: a */
    static void m6097a(Scriptable drVar) {
        new NativeNumber(0.0d).exportAsJSClass(8, drVar, false);
    }

    NativeNumber(double d) {
        this.f6361b = d;
    }

    public final String getClassName() {
        return "Number";
    }

    /* access modifiers changed from: protected */
    public final void fillConstructorProperties(IdFunctionObject ahVar) {
        ahVar.defineProperty("NaN", (Object) ScriptRuntime.f6515v, 7);
        ahVar.defineProperty("POSITIVE_INFINITY", (Object) ScriptRuntime.m6313a(Double.POSITIVE_INFINITY), 7);
        ahVar.defineProperty("NEGATIVE_INFINITY", (Object) ScriptRuntime.m6313a(Double.NEGATIVE_INFINITY), 7);
        ahVar.defineProperty("MAX_VALUE", (Object) ScriptRuntime.m6313a(Double.MAX_VALUE), 7);
        ahVar.defineProperty("MIN_VALUE", (Object) ScriptRuntime.m6313a(Double.MIN_VALUE), 7);
        super.fillConstructorProperties(ahVar);
    }

    /* access modifiers changed from: protected */
    public final void initPrototypeId(int i) {
        String str;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "constructor";
                break;
            case 2:
                str = "toString";
                break;
            case 3:
                str = "toLocaleString";
                break;
            case 4:
                str = "toSource";
                i2 = 0;
                break;
            case 5:
                str = CoreConstants.VALUE_OF;
                i2 = 0;
                break;
            case 6:
                str = "toFixed";
                break;
            case 7:
                str = "toExponential";
                break;
            case 8:
                str = "toPrecision";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(f6360a, i, str, i2);
    }

    public final Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        if (!ahVar.mo18643a(f6360a)) {
            return super.execIdCall(ahVar, lVar, drVar, drVar2, objArr);
        }
        int i = ahVar.f5994a;
        if (i == 1) {
            double d = objArr.length > 0 ? ScriptRuntime.m6395b(objArr[0]) : 0.0d;
            if (drVar2 == null) {
                return new NativeNumber(d);
            }
            return ScriptRuntime.m6313a(d);
        } else if (!(drVar2 instanceof NativeNumber)) {
            throw incompatibleCallError(ahVar);
        } else {
            double d2 = ((NativeNumber) drVar2).f6361b;
            switch (i) {
                case 2:
                case 3:
                    return ScriptRuntime.m6347a(d2, (objArr.length == 0 || objArr[0] == Undefined.f6689a) ? 10 : ScriptRuntime.m6446f(objArr[0]));
                case 4:
                    return "(new Number(" + ScriptRuntime.m6402b(d2) + "))";
                case 5:
                    return ScriptRuntime.m6313a(d2);
                case 6:
                    return m6096a(d2, objArr, 2, 2, -20, 0);
                case 7:
                    if (Double.isNaN(d2)) {
                        return "NaN";
                    }
                    if (!Double.isInfinite(d2)) {
                        return m6096a(d2, objArr, 1, 3, 0, 1);
                    }
                    if (d2 >= 0.0d) {
                        return "Infinity";
                    }
                    return "-Infinity";
                case 8:
                    if (objArr.length == 0 || objArr[0] == Undefined.f6689a) {
                        return ScriptRuntime.m6347a(d2, 10);
                    }
                    if (Double.isNaN(d2)) {
                        return "NaN";
                    }
                    if (!Double.isInfinite(d2)) {
                        return m6096a(d2, objArr, 0, 4, 1, 0);
                    }
                    if (d2 >= 0.0d) {
                        return "Infinity";
                    }
                    return "-Infinity";
                default:
                    throw new IllegalArgumentException(String.valueOf(i));
            }
        }
    }

    public final String toString() {
        return ScriptRuntime.m6347a(this.f6361b, 10);
    }

    /* renamed from: a */
    private static String m6096a(double d, Object[] objArr, int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (objArr.length != 0) {
            int f = ScriptRuntime.m6446f(objArr[0]);
            if (f < i3 || f > 100) {
                throw ScriptRuntime.m6375a("RangeError", ScriptRuntime.m6349a("msg.bad.precision", (Object) ScriptRuntime.m6436d(objArr[0])));
            }
            i5 = f;
            i = i2;
        }
        StringBuilder sb = new StringBuilder();
        DToA.m6800a(sb, i, i5 + i4, d);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int findPrototypeId(String r7) {
        /*
            r6 = this;
            r2 = 3
            r4 = 116(0x74, float:1.63E-43)
            r0 = 0
            r1 = 0
            int r3 = r7.length()
            switch(r3) {
                case 7: goto L_0x0019;
                case 8: goto L_0x0031;
                case 9: goto L_0x000c;
                case 10: goto L_0x000c;
                case 11: goto L_0x0049;
                case 12: goto L_0x000c;
                case 13: goto L_0x0062;
                case 14: goto L_0x0069;
                default: goto L_0x000c;
            }
        L_0x000c:
            r2 = r1
            r1 = r0
        L_0x000e:
            if (r2 == 0) goto L_0x006f
            if (r2 == r7) goto L_0x006f
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x006f
        L_0x0018:
            return r0
        L_0x0019:
            char r2 = r7.charAt(r0)
            if (r2 != r4) goto L_0x0026
            java.lang.String r1 = "toFixed"
            r2 = 6
            r5 = r1
            r1 = r2
            r2 = r5
            goto L_0x000e
        L_0x0026:
            r3 = 118(0x76, float:1.65E-43)
            if (r2 != r3) goto L_0x000c
            java.lang.String r1 = "valueOf"
            r2 = 5
            r5 = r1
            r1 = r2
            r2 = r5
            goto L_0x000e
        L_0x0031:
            char r2 = r7.charAt(r2)
            r3 = 111(0x6f, float:1.56E-43)
            if (r2 != r3) goto L_0x0040
            java.lang.String r1 = "toSource"
            r2 = 4
            r5 = r1
            r1 = r2
            r2 = r5
            goto L_0x000e
        L_0x0040:
            if (r2 != r4) goto L_0x000c
            java.lang.String r1 = "toString"
            r2 = 2
            r5 = r1
            r1 = r2
            r2 = r5
            goto L_0x000e
        L_0x0049:
            char r2 = r7.charAt(r0)
            r3 = 99
            if (r2 != r3) goto L_0x0058
            java.lang.String r1 = "constructor"
            r2 = 1
            r5 = r1
            r1 = r2
            r2 = r5
            goto L_0x000e
        L_0x0058:
            if (r2 != r4) goto L_0x000c
            java.lang.String r1 = "toPrecision"
            r2 = 8
            r5 = r1
            r1 = r2
            r2 = r5
            goto L_0x000e
        L_0x0062:
            java.lang.String r1 = "toExponential"
            r2 = 7
            r5 = r1
            r1 = r2
            r2 = r5
            goto L_0x000e
        L_0x0069:
            java.lang.String r1 = "toLocaleString"
            r5 = r1
            r1 = r2
            r2 = r5
            goto L_0x000e
        L_0x006f:
            r0 = r1
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeNumber.findPrototypeId(java.lang.String):int");
    }
}
