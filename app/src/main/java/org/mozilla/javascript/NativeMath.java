package org.mozilla.javascript;

//import com.tencent.android.tpush.common.MessageKey;

/* renamed from: org.mozilla.javascript.bz */
final class NativeMath extends IdScriptableObject {

    /* renamed from: a */
    private static final Object f6356a = "Math";

    /* renamed from: a */
    static void m6094a(Scriptable drVar) {
        NativeMath bzVar = new NativeMath();
        bzVar.activatePrototypeMap(27);
        bzVar.setPrototype(getObjectPrototype(drVar));
        bzVar.setParentScope(drVar);
        ScriptableObject.defineProperty(drVar, "Math", bzVar, 2);
    }

    private NativeMath() {
    }

    public final String getClassName() {
        return "Math";
    }

    /* access modifiers changed from: protected */
    public final void initPrototypeId(int i) {
        double d;
        String str;
        String str2;
        int i2 = 0;
        if (i <= 19) {
            switch (i) {
                case 1:
                    str2 = "toSource";
                    break;
                case 2:
                    str2 = "abs";
                    i2 = 1;
                    break;
                case 3:
                    str2 = "acos";
                    i2 = 1;
                    break;
                case 4:
                    str2 = "asin";
                    i2 = 1;
                    break;
                case 5:
                    str2 = "atan";
                    i2 = 1;
                    break;
                case 6:
                    str2 = "atan2";
                    i2 = 2;
                    break;
                case 7:
                    str2 = "ceil";
                    i2 = 1;
                    break;
                case 8:
                    str2 = "cos";
                    i2 = 1;
                    break;
                case 9:
                    str2 = "exp";
                    i2 = 1;
                    break;
                case 10:
                    str2 = "floor";
                    i2 = 1;
                    break;
                case 11:
                    str2 = "log";
                    i2 = 1;
                    break;
                case 12:
                    str2 = "max";
                    i2 = 2;
                    break;
                case 13:
//                    str2 = MessageKey.MSG_ACCEPT_TIME_MIN;
//                    i2 = 2;
                    break;
                case 14:
                    str2 = "pow";
                    i2 = 2;
                    break;
                case 15:
                    str2 = "random";
                    break;
                case 16:
                    str2 = "round";
                    i2 = 1;
                    break;
                case 17:
                    str2 = "sin";
                    i2 = 1;
                    break;
                case 18:
                    str2 = "sqrt";
                    i2 = 1;
                    break;
                case 19:
                    str2 = "tan";
                    i2 = 1;
                    break;
                default:
                    throw new IllegalStateException(String.valueOf(i));
            }
            initPrototypeMethod(f6356a, i, str2, i2);
            return;
        }
        switch (i) {
            case 20:
                d = 2.718281828459045d;
                str = "E";
                break;
            case 21:
                d = 3.141592653589793d;
                str = "PI";
                break;
            case 22:
                d = 2.302585092994046d;
                str = "LN10";
                break;
            case 23:
                d = 0.6931471805599453d;
                str = "LN2";
                break;
            case 24:
                d = 1.4426950408889634d;
                str = "LOG2E";
                break;
            case 25:
                d = 0.4342944819032518d;
                str = "LOG10E";
                break;
            case 26:
                d = 0.7071067811865476d;
                str = "SQRT1_2";
                break;
            case 27:
                d = 1.4142135623730951d;
                str = "SQRT2";
                break;
            default:
                throw new IllegalStateException(String.valueOf(i));
        }
        initPrototypeValue(i, str, ScriptRuntime.m6313a(d), 7);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:99:0x018d, code lost:
        if (r4 < 1.0d) goto L_0x018f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Object execIdCall(org.mozilla.javascript.IdFunctionObject r10, Context r11, org.mozilla.javascript.Scriptable r12, org.mozilla.javascript.Scriptable r13, Object[] r14) {
        /*
            r9 = this;
            java.lang.Object r0 = f6356a
            boolean r0 = r10.mo18643a(r0)
            if (r0 != 0) goto L_0x000d
            java.lang.Object r0 = super.execIdCall(r10, r11, r12, r13, r14)
        L_0x000c:
            return r0
        L_0x000d:
            int r6 = r10.f5994a
            switch(r6) {
                case 1: goto L_0x001c;
                case 2: goto L_0x001f;
                case 3: goto L_0x0039;
                case 4: goto L_0x0039;
                case 5: goto L_0x005e;
                case 6: goto L_0x0068;
                case 7: goto L_0x0077;
                case 8: goto L_0x0081;
                case 9: goto L_0x009a;
                case 10: goto L_0x00b5;
                case 11: goto L_0x00c0;
                case 12: goto L_0x00d5;
                case 13: goto L_0x00d5;
                case 14: goto L_0x0105;
                case 15: goto L_0x01fa;
                case 16: goto L_0x0200;
                case 17: goto L_0x0236;
                case 18: goto L_0x0251;
                case 19: goto L_0x025c;
                default: goto L_0x0012;
            }
        L_0x0012:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = java.lang.String.valueOf(r6)
            r0.<init>(r1)
            throw r0
        L_0x001c:
            java.lang.String r0 = "Math"
            goto L_0x000c
        L_0x001f:
            r0 = 0
            double r0 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r0)
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0031
            r0 = 0
        L_0x002c:
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.m6313a(r0)
            goto L_0x000c
        L_0x0031:
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x002c
            double r0 = -r0
            goto L_0x002c
        L_0x0039:
            r0 = 0
            double r0 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r0)
            int r2 = (r0 > r0 ? 1 : (r0 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x005b
            r2 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x005b
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x005b
            r2 = 3
            if (r6 != r2) goto L_0x0056
            double r0 = java.lang.Math.acos(r0)
            goto L_0x002c
        L_0x0056:
            double r0 = java.lang.Math.asin(r0)
            goto L_0x002c
        L_0x005b:
            r0 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x002c
        L_0x005e:
            r0 = 0
            double r0 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r0)
            double r0 = java.lang.Math.atan(r0)
            goto L_0x002c
        L_0x0068:
            r0 = 0
            double r0 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r0)
            r2 = 1
            double r2 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r2)
            double r0 = java.lang.Math.atan2(r0, r2)
            goto L_0x002c
        L_0x0077:
            r0 = 0
            double r0 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r0)
            double r0 = java.lang.Math.ceil(r0)
            goto L_0x002c
        L_0x0081:
            r0 = 0
            double r0 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r0)
            r2 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0092
            r2 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0095
        L_0x0092:
            r0 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x002c
        L_0x0095:
            double r0 = java.lang.Math.cos(r0)
            goto L_0x002c
        L_0x009a:
            r0 = 0
            double r0 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r0)
            r2 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x002c
            r2 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x00af
            r0 = 0
            goto L_0x002c
        L_0x00af:
            double r0 = java.lang.Math.exp(r0)
            goto L_0x002c
        L_0x00b5:
            r0 = 0
            double r0 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r0)
            double r0 = java.lang.Math.floor(r0)
            goto L_0x002c
        L_0x00c0:
            r0 = 0
            double r0 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r0)
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x00cf
            r0 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x002c
        L_0x00cf:
            double r0 = java.lang.Math.log(r0)
            goto L_0x002c
        L_0x00d5:
            r0 = 12
            if (r6 != r0) goto L_0x00ef
            r0 = -4503599627370496(0xfff0000000000000, double:-Infinity)
        L_0x00db:
            r2 = 0
            r8 = r2
            r2 = r0
            r0 = r8
        L_0x00df:
            int r1 = r14.length
            if (r0 == r1) goto L_0x0102
            r1 = r14[r0]
            double r4 = org.mozilla.javascript.ScriptRuntime.m6395b(r1)
            int r1 = (r4 > r4 ? 1 : (r4 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x00f2
            r0 = r4
            goto L_0x002c
        L_0x00ef:
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x00db
        L_0x00f2:
            r1 = 12
            if (r6 != r1) goto L_0x00fd
            double r2 = java.lang.Math.max(r2, r4)
        L_0x00fa:
            int r0 = r0 + 1
            goto L_0x00df
        L_0x00fd:
            double r2 = java.lang.Math.min(r2, r4)
            goto L_0x00fa
        L_0x0102:
            r0 = r2
            goto L_0x002c
        L_0x0105:
            r0 = 0
            double r4 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r0)
            r0 = 1
            double r0 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r0)
            int r2 = (r0 > r0 ? 1 : (r0 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x002c
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x011d
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x002c
        L_0x011d:
            r2 = 0
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0165
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r2 = r2 / r4
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x013a
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0136
            r0 = 0
            goto L_0x002c
        L_0x0136:
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x002c
        L_0x013a:
            long r2 = (long) r0
            double r4 = (double) r2
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 != 0) goto L_0x0157
            r4 = 1
            long r2 = r2 & r4
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0157
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0153
            r0 = -9223372036854775808
            goto L_0x002c
        L_0x0153:
            r0 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            goto L_0x002c
        L_0x0157:
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0161
            r0 = 0
            goto L_0x002c
        L_0x0161:
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x002c
        L_0x0165:
            double r2 = java.lang.Math.pow(r4, r0)
            int r6 = (r2 > r2 ? 1 : (r2 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0267
            r6 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x0193
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x017f
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0183
        L_0x017f:
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x002c
        L_0x0183:
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0267
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0267
        L_0x018f:
            r0 = 0
            goto L_0x002c
        L_0x0193:
            r6 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x01b9
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x01a5
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x01a9
        L_0x01a5:
            r0 = 0
            goto L_0x002c
        L_0x01a9:
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0267
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0267
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x002c
        L_0x01b9:
            r6 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x01cd
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x01c9
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x002c
        L_0x01c9:
            r0 = 0
            goto L_0x002c
        L_0x01cd:
            r6 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x0267
            long r2 = (long) r0
            double r4 = (double) r2
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 != 0) goto L_0x01f0
            r4 = 1
            long r2 = r2 & r4
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x01f0
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x01ec
            r0 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            goto L_0x002c
        L_0x01ec:
            r0 = -9223372036854775808
            goto L_0x002c
        L_0x01f0:
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x018f
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x002c
        L_0x01fa:
            double r0 = java.lang.Math.random()
            goto L_0x002c
        L_0x0200:
            r0 = 0
            double r0 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r0)
            int r2 = (r0 > r0 ? 1 : (r0 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x002c
            r2 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x002c
            r2 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x002c
            long r2 = java.lang.Math.round(r0)
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0222
            double r0 = (double) r2
            goto L_0x002c
        L_0x0222:
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x022c
            double r0 = org.mozilla.javascript.ScriptRuntime.f6514u
            goto L_0x002c
        L_0x022c:
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x002c
            r0 = 0
            goto L_0x002c
        L_0x0236:
            r0 = 0
            double r0 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r0)
            r2 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0247
            r2 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x024b
        L_0x0247:
            r0 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x002c
        L_0x024b:
            double r0 = java.lang.Math.sin(r0)
            goto L_0x002c
        L_0x0251:
            r0 = 0
            double r0 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r0)
            double r0 = java.lang.Math.sqrt(r0)
            goto L_0x002c
        L_0x025c:
            r0 = 0
            double r0 = org.mozilla.javascript.ScriptRuntime.m6311a(r14, r0)
            double r0 = java.lang.Math.tan(r0)
            goto L_0x002c
        L_0x0267:
            r0 = r2
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeMath.execIdCall(org.mozilla.javascript.ah, org.mozilla.javascript.l, org.mozilla.javascript.dr, org.mozilla.javascript.dr, java.lang.Object[]):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int findPrototypeId(String r9) {
        /*
            r8 = this;
            r6 = 111(0x6f, float:1.56E-43)
            r5 = 110(0x6e, float:1.54E-43)
            r1 = 0
            r0 = 2
            r3 = 1
            r2 = 0
            int r4 = r9.length()
            switch(r4) {
                case 1: goto L_0x001c;
                case 2: goto L_0x0027;
                case 3: goto L_0x003a;
                case 4: goto L_0x00f4;
                case 5: goto L_0x0130;
                case 6: goto L_0x0166;
                case 7: goto L_0x0184;
                case 8: goto L_0x018d;
                default: goto L_0x000f;
            }
        L_0x000f:
            r0 = r1
        L_0x0010:
            if (r2 == 0) goto L_0x001b
            if (r2 == r9) goto L_0x001b
            boolean r2 = r2.equals(r9)
            if (r2 != 0) goto L_0x001b
            r0 = r1
        L_0x001b:
            return r0
        L_0x001c:
            char r0 = r9.charAt(r1)
            r3 = 69
            if (r0 != r3) goto L_0x000f
            r0 = 20
            goto L_0x001b
        L_0x0027:
            char r0 = r9.charAt(r1)
            r4 = 80
            if (r0 != r4) goto L_0x000f
            char r0 = r9.charAt(r3)
            r3 = 73
            if (r0 != r3) goto L_0x000f
            r0 = 21
            goto L_0x001b
        L_0x003a:
            char r4 = r9.charAt(r1)
            switch(r4) {
                case 76: goto L_0x0043;
                case 97: goto L_0x0056;
                case 99: goto L_0x0067;
                case 101: goto L_0x0078;
                case 108: goto L_0x008b;
                case 109: goto L_0x009c;
                case 112: goto L_0x00be;
                case 115: goto L_0x00d0;
                case 116: goto L_0x00e2;
                default: goto L_0x0041;
            }
        L_0x0041:
            r0 = r1
            goto L_0x0010
        L_0x0043:
            char r0 = r9.charAt(r0)
            r4 = 50
            if (r0 != r4) goto L_0x000f
            char r0 = r9.charAt(r3)
            r3 = 78
            if (r0 != r3) goto L_0x000f
            r0 = 23
            goto L_0x001b
        L_0x0056:
            char r4 = r9.charAt(r0)
            r5 = 115(0x73, float:1.61E-43)
            if (r4 != r5) goto L_0x000f
            char r3 = r9.charAt(r3)
            r4 = 98
            if (r3 != r4) goto L_0x000f
            goto L_0x001b
        L_0x0067:
            char r0 = r9.charAt(r0)
            r4 = 115(0x73, float:1.61E-43)
            if (r0 != r4) goto L_0x000f
            char r0 = r9.charAt(r3)
            if (r0 != r6) goto L_0x000f
            r0 = 8
            goto L_0x001b
        L_0x0078:
            char r0 = r9.charAt(r0)
            r4 = 112(0x70, float:1.57E-43)
            if (r0 != r4) goto L_0x000f
            char r0 = r9.charAt(r3)
            r3 = 120(0x78, float:1.68E-43)
            if (r0 != r3) goto L_0x000f
            r0 = 9
            goto L_0x001b
        L_0x008b:
            char r0 = r9.charAt(r0)
            r4 = 103(0x67, float:1.44E-43)
            if (r0 != r4) goto L_0x000f
            char r0 = r9.charAt(r3)
            if (r0 != r6) goto L_0x000f
            r0 = 11
            goto L_0x001b
        L_0x009c:
            char r0 = r9.charAt(r0)
            if (r0 != r5) goto L_0x00ae
            char r0 = r9.charAt(r3)
            r3 = 105(0x69, float:1.47E-43)
            if (r0 != r3) goto L_0x000f
            r0 = 13
            goto L_0x001b
        L_0x00ae:
            r4 = 120(0x78, float:1.68E-43)
            if (r0 != r4) goto L_0x000f
            char r0 = r9.charAt(r3)
            r3 = 97
            if (r0 != r3) goto L_0x000f
            r0 = 12
            goto L_0x001b
        L_0x00be:
            char r0 = r9.charAt(r0)
            r4 = 119(0x77, float:1.67E-43)
            if (r0 != r4) goto L_0x000f
            char r0 = r9.charAt(r3)
            if (r0 != r6) goto L_0x000f
            r0 = 14
            goto L_0x001b
        L_0x00d0:
            char r0 = r9.charAt(r0)
            if (r0 != r5) goto L_0x000f
            char r0 = r9.charAt(r3)
            r3 = 105(0x69, float:1.47E-43)
            if (r0 != r3) goto L_0x000f
            r0 = 17
            goto L_0x001b
        L_0x00e2:
            char r0 = r9.charAt(r0)
            if (r0 != r5) goto L_0x000f
            char r0 = r9.charAt(r3)
            r3 = 97
            if (r0 != r3) goto L_0x000f
            r0 = 19
            goto L_0x001b
        L_0x00f4:
            char r0 = r9.charAt(r3)
            switch(r0) {
                case 78: goto L_0x00fe;
                case 99: goto L_0x0107;
                case 101: goto L_0x010f;
                case 113: goto L_0x0117;
                case 115: goto L_0x0120;
                case 116: goto L_0x0128;
                default: goto L_0x00fb;
            }
        L_0x00fb:
            r0 = r1
            goto L_0x0010
        L_0x00fe:
            java.lang.String r0 = "LN10"
            r2 = 22
            r7 = r0
            r0 = r2
            r2 = r7
            goto L_0x0010
        L_0x0107:
            java.lang.String r0 = "acos"
            r2 = 3
            r7 = r0
            r0 = r2
            r2 = r7
            goto L_0x0010
        L_0x010f:
            java.lang.String r0 = "ceil"
            r2 = 7
            r7 = r0
            r0 = r2
            r2 = r7
            goto L_0x0010
        L_0x0117:
            java.lang.String r0 = "sqrt"
            r2 = 18
            r7 = r0
            r0 = r2
            r2 = r7
            goto L_0x0010
        L_0x0120:
            java.lang.String r0 = "asin"
            r2 = 4
            r7 = r0
            r0 = r2
            r2 = r7
            goto L_0x0010
        L_0x0128:
            java.lang.String r0 = "atan"
            r2 = 5
            r7 = r0
            r0 = r2
            r2 = r7
            goto L_0x0010
        L_0x0130:
            char r0 = r9.charAt(r1)
            switch(r0) {
                case 76: goto L_0x013a;
                case 83: goto L_0x0143;
                case 97: goto L_0x014c;
                case 102: goto L_0x0154;
                case 114: goto L_0x015d;
                default: goto L_0x0137;
            }
        L_0x0137:
            r0 = r1
            goto L_0x0010
        L_0x013a:
            java.lang.String r0 = "LOG2E"
            r2 = 24
            r7 = r0
            r0 = r2
            r2 = r7
            goto L_0x0010
        L_0x0143:
            java.lang.String r0 = "SQRT2"
            r2 = 27
            r7 = r0
            r0 = r2
            r2 = r7
            goto L_0x0010
        L_0x014c:
            java.lang.String r0 = "atan2"
            r2 = 6
            r7 = r0
            r0 = r2
            r2 = r7
            goto L_0x0010
        L_0x0154:
            java.lang.String r0 = "floor"
            r2 = 10
            r7 = r0
            r0 = r2
            r2 = r7
            goto L_0x0010
        L_0x015d:
            java.lang.String r0 = "round"
            r2 = 16
            r7 = r0
            r0 = r2
            r2 = r7
            goto L_0x0010
        L_0x0166:
            char r0 = r9.charAt(r1)
            r3 = 76
            if (r0 != r3) goto L_0x0177
            java.lang.String r0 = "LOG10E"
            r2 = 25
            r7 = r0
            r0 = r2
            r2 = r7
            goto L_0x0010
        L_0x0177:
            r3 = 114(0x72, float:1.6E-43)
            if (r0 != r3) goto L_0x000f
            java.lang.String r0 = "random"
            r2 = 15
            r7 = r0
            r0 = r2
            r2 = r7
            goto L_0x0010
        L_0x0184:
            java.lang.String r0 = "SQRT1_2"
            r2 = 26
            r7 = r0
            r0 = r2
            r2 = r7
            goto L_0x0010
        L_0x018d:
            java.lang.String r0 = "toSource"
            r2 = r0
            r0 = r3
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeMath.findPrototypeId(java.lang.String):int");
    }
}
