package org.mozilla.javascript;

//import com.tencent.android.tpush.common.Constants;
import java.io.Serializable;
import org.mozilla.javascript.p115g.XMLLib;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.bo */
public final class NativeGlobal implements Serializable, IdFunctionCall {

    /* renamed from: a */
    private static final Object f6324a = "Global";

    /* renamed from: a */
    public static void m6059a(Context lVar, Scriptable drVar) {
        String str;
        int i;
        NativeGlobal boVar = new NativeGlobal();
        for (int i2 = 1; i2 <= 13; i2++) {
            switch (i2) {
                case 1:
                    str = "decodeURI";
                    i = 1;
                    break;
                case 2:
                    str = "decodeURIComponent";
                    i = 1;
                    break;
                case 3:
                    str = "encodeURI";
                    i = 1;
                    break;
                case 4:
                    str = "encodeURIComponent";
                    i = 1;
                    break;
                case 5:
                    str = "escape";
                    i = 1;
                    break;
                case 6:
                    str = "eval";
                    i = 1;
                    break;
                case 7:
                    str = "isFinite";
                    i = 1;
                    break;
                case 8:
                    str = "isNaN";
                    i = 1;
                    break;
                case 9:
                    str = "isXMLName";
                    i = 1;
                    break;
                case 10:
                    str = "parseFloat";
                    i = 1;
                    break;
                case 11:
                    str = "parseInt";
                    i = 2;
                    break;
                case 12:
                    str = "unescape";
                    i = 1;
                    break;
                case 13:
                    str = "uneval";
                    i = 1;
                    break;
                default:
                    throw Kit.m5810a();
            }
            new IdFunctionObject(boVar, f6324a, i2, str, i, drVar).mo18641a();
        }
        ScriptableObject.defineProperty(drVar, "NaN", ScriptRuntime.f6515v, 7);
        ScriptableObject.defineProperty(drVar, "Infinity", ScriptRuntime.m6313a(Double.POSITIVE_INFINITY), 7);
        ScriptableObject.defineProperty(drVar, "undefined", Undefined.f6689a, 7);
        String[] strArr = {"ConversionError", "EvalError", "RangeError", "ReferenceError", "SyntaxError", "TypeError", "URIError", "InternalError", "JavaException"};
        for (int i3 = 0; i3 < 9; i3++) {
            String str2 = strArr[i3];
            ScriptableObject dsVar = (ScriptableObject) ScriptRuntime.m6367a(lVar, drVar, "Error", ScriptRuntime.f6517x);
            dsVar.put("name", (Scriptable) dsVar, (Object) str2);
            dsVar.put("message", (Scriptable) dsVar, (Object) "");
            IdFunctionObject ahVar = new IdFunctionObject(boVar, f6324a, 14, str2, 1, drVar);
            ahVar.mo18642a((Scriptable) dsVar);
            dsVar.put("constructor", (Scriptable) dsVar, (Object) ahVar);
            dsVar.setAttributes("constructor", 2);
            ahVar.mo18641a();
        }
    }

    public final Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        int i4;
        char c;
        int i5;
        int i6;
        if (ahVar.mo18643a(f6324a)) {
            int i7 = ahVar.f5994a;
            switch (i7) {
                case 1:
                case 2:
                    String b = ScriptRuntime.m6407b(objArr);
                    boolean z3 = i7 == 1;
                    int i8 = 0;
                    int length = b.length();
                    char[] cArr = null;
                    int i9 = 0;
                    while (i9 != length) {
                        char charAt = b.charAt(i9);
                        if (charAt != '%') {
                            if (cArr != null) {
                                i6 = i8 + 1;
                                cArr[i8] = charAt;
                            } else {
                                i6 = i8;
                            }
                            i9++;
                            i8 = i6;
                        } else {
                            if (cArr == null) {
                                cArr = new char[length];
                                b.getChars(0, i9, cArr, 0);
                                i = i9;
                            } else {
                                i = i8;
                            }
                            if (i9 + 3 > length) {
                                throw m6058a();
                            }
                            int a = m6054a(b.charAt(i9 + 1), b.charAt(i9 + 2));
                            if (a < 0) {
                                throw m6058a();
                            }
                            int i10 = i9 + 3;
                            if ((a & 128) == 0) {
                                c = (char) a;
                                i5 = i10;
                            } else if ((a & 192) == 128) {
                                throw m6058a();
                            } else {
                                if ((a & 32) == 0) {
                                    i2 = a & 31;
                                    i3 = 128;
                                    i4 = 1;
                                } else if ((a & 16) == 0) {
                                    i2 = a & 15;
                                    i3 = 2048;
                                    i4 = 2;
                                } else if ((a & 8) == 0) {
                                    i2 = a & 7;
                                    i3 = 65536;
                                    i4 = 3;
                                } else if ((a & 4) == 0) {
                                    i2 = a & 3;
                                    i3 = 2097152;
                                    i4 = 4;
                                } else if ((a & 2) == 0) {
                                    i2 = a & 1;
                                    i3 = 67108864;
                                    i4 = 5;
                                } else {
                                    throw m6058a();
                                }
                                if ((i4 * 3) + i10 > length) {
                                    throw m6058a();
                                }
                                int i11 = i2;
                                int i12 = 0;
                                while (i12 != i4) {
                                    if (b.charAt(i10) != '%') {
                                        throw m6058a();
                                    }
                                    int a2 = m6054a(b.charAt(i10 + 1), b.charAt(i10 + 2));
                                    if (a2 < 0 || (a2 & 192) != 128) {
                                        throw m6058a();
                                    }
                                    i10 += 3;
                                    i12++;
                                    i11 = (a2 & 63) | (i11 << 6);
                                }
                                if (i11 < i3 || (i11 >= 55296 && i11 <= 57343)) {
                                    i11 = Integer.MAX_VALUE;
                                } else if (i11 == 65534 || i11 == 65535) {
                                    i11 = 65533;
                                }
                                if (i11 >= 65536) {
                                    int i13 = i11 - 65536;
                                    if (i13 > 1048575) {
                                        throw m6058a();
                                    }
                                    char c2 = (char) ((i13 >>> 10) + 55296);
                                    char c3 = (char) ((i13 & 1023) + 56320);
                                    int i14 = i + 1;
                                    cArr[i] = c2;
                                    i = i14;
                                    c = c3;
                                    i5 = i10;
                                } else {
                                    c = (char) i11;
                                    i5 = i10;
                                }
                            }
                            if (!z3 || ";/?:@&=+$,#".indexOf(c) < 0) {
                                i8 = i + 1;
                                cArr[i] = c;
                                i9 = i5;
                            } else {
                                i8 = i;
                                while (i9 != i5) {
                                    int i15 = i8 + 1;
                                    cArr[i8] = b.charAt(i9);
                                    i9++;
                                    i8 = i15;
                                }
                                i9 = i5;
                            }
                        }
                    }
                    if (cArr == null) {
                        return b;
                    }
                    return new String(cArr, 0, i8);
                case 3:
                case 4:
                    return m6057a(ScriptRuntime.m6407b(objArr), i7 == 3);
                case 5:
                    return m6062c(objArr);
                case 6:
                    Scriptable topLevelScope = ScriptableObject.getTopLevelScope(drVar);
                    return ScriptRuntime.m6341a(lVar, topLevelScope, (Object) topLevelScope, objArr, "eval code", 1);
                case 7:
                    if (objArr.length > 0) {
                        double b2 = ScriptRuntime.m6395b(objArr[0]);
                        if (!(b2 != b2 || b2 == Double.POSITIVE_INFINITY || b2 == Double.NEGATIVE_INFINITY)) {
                            z2 = true;
                            return ScriptRuntime.m6312a(z2);
                        }
                    }
                    z2 = false;
                    return ScriptRuntime.m6312a(z2);
                case 8:
                    if (objArr.length <= 0) {
                        z = true;
                    } else {
                        double b3 = ScriptRuntime.m6395b(objArr[0]);
                        z = b3 != b3;
                    }
                    return ScriptRuntime.m6312a(z);
                case 9:
                    if (objArr.length == 0) {
                        Object obj = Undefined.f6689a;
                    }
                    return ScriptRuntime.m6312a(XMLLib.m6685a(drVar).mo19112a());
                case 10:
                    return m6061b(objArr);
                case 11:
                    return m6056a(objArr);
                case 12:
                    return m6063d(objArr);
                case 13:
                    return ScriptRuntime.m6354a(lVar, drVar, objArr.length != 0 ? objArr[0] : Undefined.f6689a);
                case 14:
                    return NativeError.m6037a(drVar, ahVar, objArr);
            }
        }
        throw ahVar.mo18644b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0063  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Object m6056a(Object[] r11) {
        /*
            r2 = 16
            r3 = -1
            r10 = 48
            r1 = 0
            r6 = 1
            java.lang.String r7 = org.mozilla.javascript.ScriptRuntime.m6407b(r11)
            int r4 = org.mozilla.javascript.ScriptRuntime.m6420c(r11, r6)
            int r8 = r7.length()
            if (r8 != 0) goto L_0x0018
            java.lang.Double r0 = org.mozilla.javascript.ScriptRuntime.f6515v
        L_0x0017:
            return r0
        L_0x0018:
            r0 = r1
        L_0x0019:
            char r5 = r7.charAt(r0)
            boolean r9 = org.mozilla.javascript.ScriptRuntime.m6429c(r5)
            if (r9 == 0) goto L_0x0027
            int r0 = r0 + 1
            if (r0 < r8) goto L_0x0019
        L_0x0027:
            r9 = 43
            if (r5 == r9) goto L_0x0032
            r9 = 45
            if (r5 != r9) goto L_0x0030
            r1 = r6
        L_0x0030:
            if (r1 == 0) goto L_0x0098
        L_0x0032:
            int r0 = r0 + 1
            r5 = r1
        L_0x0035:
            if (r4 != 0) goto L_0x0063
            r1 = r3
        L_0x0038:
            if (r1 != r3) goto L_0x0057
            r1 = 10
            int r3 = r8 - r0
            if (r3 <= r6) goto L_0x0057
            char r3 = r7.charAt(r0)
            if (r3 != r10) goto L_0x0057
            int r3 = r0 + 1
            char r3 = r7.charAt(r3)
            r4 = 120(0x78, float:1.68E-43)
            if (r3 == r4) goto L_0x0054
            r4 = 88
            if (r3 != r4) goto L_0x008b
        L_0x0054:
            int r0 = r0 + 2
            r1 = r2
        L_0x0057:
            double r0 = org.mozilla.javascript.ScriptRuntime.m6310a(r7, r0, r1)
            if (r5 == 0) goto L_0x005e
            double r0 = -r0
        L_0x005e:
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.m6313a(r0)
            goto L_0x0017
        L_0x0063:
            r1 = 2
            if (r4 < r1) goto L_0x006a
            r1 = 36
            if (r4 <= r1) goto L_0x006d
        L_0x006a:
            java.lang.Double r0 = org.mozilla.javascript.ScriptRuntime.f6515v
            goto L_0x0017
        L_0x006d:
            if (r4 != r2) goto L_0x0096
            int r1 = r8 - r0
            if (r1 <= r6) goto L_0x0096
            char r1 = r7.charAt(r0)
            if (r1 != r10) goto L_0x0096
            int r1 = r0 + 1
            char r1 = r7.charAt(r1)
            r9 = 120(0x78, float:1.68E-43)
            if (r1 == r9) goto L_0x0087
            r9 = 88
            if (r1 != r9) goto L_0x0096
        L_0x0087:
            int r0 = r0 + 2
            r1 = r4
            goto L_0x0038
        L_0x008b:
            if (r10 > r3) goto L_0x0057
            r2 = 57
            if (r3 > r2) goto L_0x0057
            r1 = 8
            int r0 = r0 + 1
            goto L_0x0057
        L_0x0096:
            r1 = r4
            goto L_0x0038
        L_0x0098:
            r5 = r1
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGlobal.m6056a(java.lang.Object[]):java.lang.Object");
    }

    /* renamed from: b */
    private static Object m6061b(Object[] objArr) {
        int i;
        double d;
        boolean z = false;
        if (objArr.length <= 0) {
            return ScriptRuntime.f6515v;
        }
        String d2 = ScriptRuntime.m6436d(objArr[0]);
        int length = d2.length();
        int i2 = 0;
        while (i2 != length) {
            char charAt = d2.charAt(i2);
            if (ScriptRuntime.m6429c((int) charAt)) {
                i2++;
            } else {
                if (charAt == '+' || charAt == '-') {
                    i = i2 + 1;
                    if (i == length) {
                        return ScriptRuntime.f6515v;
                    }
                    charAt = d2.charAt(i);
                } else {
                    i = i2;
                }
                if (charAt != 'I') {
                    int i3 = -1;
                    int i4 = -1;
                    while (true) {
                        if (i < length) {
                            switch (d2.charAt(i)) {
                                case '+':
                                case '-':
                                    if (i3 != i - 1) {
                                        break;
                                    } else if (i == length - 1) {
                                        i--;
                                        break;
                                    } else {
                                        continue;
                                    }
                                case '.':
                                    if (i4 != -1) {
                                        break;
                                    } else {
                                        i4 = i;
                                        continue;
                                    }
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                case '4':
                                case '5':
                                case '6':
                                case '7':
                                case '8':
                                case '9':
                                    if (i3 != -1) {
                                        z = true;
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 'E':
                                case 'e':
                                    if (i3 == -1 && i != length - 1) {
                                        i3 = i;
                                        continue;
                                    }
                            }
                        }
                        i++;

                        break;
                    }
                    if (i3 == -1 || z) {
                        i3 = i;
                    }
                    try {
                        return Double.valueOf(d2.substring(i2, i3));
                    } catch (NumberFormatException e) {
                        return ScriptRuntime.f6515v;
                    }
                } else if (i + 8 > length || !d2.regionMatches(i, "Infinity", 0, 8)) {
                    return ScriptRuntime.f6515v;
                } else {
                    if (d2.charAt(i2) == '-') {
                        d = Double.NEGATIVE_INFINITY;
                    } else {
                        d = Double.POSITIVE_INFINITY;
                    }
                    return ScriptRuntime.m6313a(d);
                }
            }
        }
        return ScriptRuntime.f6515v;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if ((r0 & -8) == 0) goto L_0x0029;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Object m6062c(Object[] r12) {
        /*
            r11 = 43
            r10 = 37
            r2 = 2
            r3 = 1
            java.lang.String r4 = org.mozilla.javascript.ScriptRuntime.m6407b(r12)
            r0 = 7
            int r1 = r12.length
            if (r1 <= r3) goto L_0x0029
            r0 = r12[r3]
            double r6 = org.mozilla.javascript.ScriptRuntime.m6395b(r0)
            int r0 = (r6 > r6 ? 1 : (r6 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0022
            int r0 = (int) r6
            double r8 = (double) r0
            int r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x0022
            r1 = r0 & -8
            if (r1 == 0) goto L_0x0029
        L_0x0022:
            java.lang.String r0 = "msg.bad.esc.mask"
            org.mozilla.javascript.z r0 = org.mozilla.javascript.Context.m6763b(r0)
            throw r0
        L_0x0029:
            r3 = 0
            r1 = 0
            int r7 = r4.length()
            r5 = r1
            r1 = r3
        L_0x0031:
            if (r5 == r7) goto L_0x00c1
            char r8 = r4.charAt(r5)
            if (r0 == 0) goto L_0x0079
            r3 = 48
            if (r8 < r3) goto L_0x0041
            r3 = 57
            if (r8 <= r3) goto L_0x006f
        L_0x0041:
            r3 = 65
            if (r8 < r3) goto L_0x0049
            r3 = 90
            if (r8 <= r3) goto L_0x006f
        L_0x0049:
            r3 = 97
            if (r8 < r3) goto L_0x0051
            r3 = 122(0x7a, float:1.71E-43)
            if (r8 <= r3) goto L_0x006f
        L_0x0051:
            r3 = 64
            if (r8 == r3) goto L_0x006f
            r3 = 42
            if (r8 == r3) goto L_0x006f
            r3 = 95
            if (r8 == r3) goto L_0x006f
            r3 = 45
            if (r8 == r3) goto L_0x006f
            r3 = 46
            if (r8 == r3) goto L_0x006f
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0079
            r3 = 47
            if (r8 == r3) goto L_0x006f
            if (r8 != r11) goto L_0x0079
        L_0x006f:
            if (r1 == 0) goto L_0x0075
            char r3 = (char) r8
            r1.append(r3)
        L_0x0075:
            int r3 = r5 + 1
            r5 = r3
            goto L_0x0031
        L_0x0079:
            if (r1 != 0) goto L_0x00ca
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            int r1 = r7 + 3
            r3.<init>(r1)
            r3.append(r4)
            r3.setLength(r5)
        L_0x0088:
            r1 = 256(0x100, float:3.59E-43)
            if (r8 >= r1) goto L_0x00b4
            r1 = 32
            if (r8 != r1) goto L_0x0097
            if (r0 != r2) goto L_0x0097
            r3.append(r11)
            r1 = r3
            goto L_0x0075
        L_0x0097:
            r3.append(r10)
            r1 = r2
        L_0x009b:
            int r1 = r1 + -1
            int r1 = r1 * 4
            r6 = r1
        L_0x00a0:
            if (r6 < 0) goto L_0x00cc
            int r1 = r8 >> r6
            r1 = r1 & 15
            r9 = 10
            if (r1 >= r9) goto L_0x00be
            int r1 = r1 + 48
        L_0x00ac:
            char r1 = (char) r1
            r3.append(r1)
            int r1 = r6 + -4
            r6 = r1
            goto L_0x00a0
        L_0x00b4:
            r3.append(r10)
            r1 = 117(0x75, float:1.64E-43)
            r3.append(r1)
            r1 = 4
            goto L_0x009b
        L_0x00be:
            int r1 = r1 + 55
            goto L_0x00ac
        L_0x00c1:
            if (r1 != 0) goto L_0x00c5
            r0 = r4
        L_0x00c4:
            return r0
        L_0x00c5:
            java.lang.String r0 = r1.toString()
            goto L_0x00c4
        L_0x00ca:
            r3 = r1
            goto L_0x0088
        L_0x00cc:
            r1 = r3
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeGlobal.m6062c(java.lang.Object[]):java.lang.Object");
    }

    /* renamed from: d */
    private static Object m6063d(Object[] objArr) {
        int i;
        String b = ScriptRuntime.m6407b(objArr);
        int indexOf = b.indexOf(37);
        if (indexOf < 0) {
            return b;
        }
        int length = b.length();
        char[] charArray = b.toCharArray();
        int i2 = indexOf;
        while (indexOf != length) {
            char c = charArray[indexOf];
            int i3 = indexOf + 1;
            if (c == '%' && i3 != length) {
                if (charArray[i3] == 'u') {
                    i = i3 + 1;
                    indexOf = i3 + 5;
                } else {
                    indexOf = i3 + 2;
                    i = i3;
                }
                if (indexOf <= length) {
                    int i4 = 0;
                    for (int i5 = i; i5 != indexOf; i5++) {
                        i4 = Kit.m5803a((int) charArray[i5], i4);
                    }
                    if (i4 >= 0) {
                        c = (char) i4;
                        charArray[i2] = c;
                        i2++;
                    }
                }
            }
            indexOf = i3;
            charArray[i2] = c;
            i2++;
        }
        return new String(charArray, 0, i2);
    }

    /* renamed from: a */
    static boolean m6060a(Object obj) {
        if (obj instanceof IdFunctionObject) {
            IdFunctionObject ahVar = (IdFunctionObject) obj;
            if (ahVar.mo18643a(f6324a) && ahVar.f5994a == 6) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static String m6057a(String str, boolean z) {
        byte[] bArr = null;
        StringBuffer stringBuffer = null;
        int length = str.length();
        int i = 0;
        while (i != length) {
            char charAt = str.charAt(i);
            boolean z2 = ((65 > charAt || charAt > 90) && (97 > charAt || charAt > 122) && (48 > charAt || charAt > 57)) ? "-_.!~*'()".indexOf(charAt) >= 0 ? true : z ? ";/?:@&=+$,#".indexOf(charAt) >= 0 : false : true;
            if (!z2) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(length + 3);
                    stringBuffer.append(str);
                    stringBuffer.setLength(i);
                    bArr = new byte[6];
                }
                if (56320 > charAt || charAt > 57343) {
                    if (charAt >= 55296 && 56319 >= charAt) {
                        i++;
                        if (i == length) {
                            throw m6058a();
                        }
                        char charAt2 = str.charAt(i);
                        if (56320 > charAt2 || charAt2 > 57343) {
                            throw m6058a();
                        }
//                        charAt = ((charAt - 55296) << 10) + (charAt2 - 56320) + 65536;
                    }
                    int a = m6055a(bArr, charAt);
                    for (int i2 = 0; i2 < a; i2++) {
//                        byte b = bArr[i2] & Constants.NETWORK_TYPE_UNCONNECTED;
//                        stringBuffer.append(CoreConstants.PERCENT_CHAR);
//                        stringBuffer.append(m6052a(b >>> 4));
//                        stringBuffer.append(m6052a((int) b & 15));
                    }
                } else {
                    throw m6058a();
                }
            } else if (stringBuffer != null) {
                stringBuffer.append(charAt);
            }
            i++;
            bArr = bArr;
            stringBuffer = stringBuffer;
        }
        return stringBuffer == null ? str : stringBuffer.toString();
    }

    /* renamed from: a */
    private static char m6052a(int i) {
        if ((i >> 4) != 0) {
            Kit.m5810a();
        }
        return (char) (i < 10 ? i + 48 : (i - 10) + 65);
    }

    /* renamed from: a */
    private static int m6053a(char c) {
        if ('A' <= c && c <= 'F') {
            return (c - 'A') + 10;
        }
        if ('a' <= c && c <= 'f') {
            return (c - 'a') + 10;
        }
        if ('0' > c || c > '9') {
            return -1;
        }
        return c - '0';
    }

    /* renamed from: a */
    private static int m6054a(char c, char c2) {
        int a = m6053a(c);
        int a2 = m6053a(c2);
        if (a < 0 || a2 < 0) {
            return -1;
        }
        return (a << 4) | a2;
    }

    /* renamed from: a */
    private static EcmaError m6058a() {
        return ScriptRuntime.m6375a("URIError", ScriptRuntime.m6448f("msg.bad.uri"));
    }

    /* renamed from: a */
    private static int m6055a(byte[] bArr, int i) {
        if ((i & -128) == 0) {
            bArr[0] = (byte) i;
            return 1;
        }
        int i2 = 2;
        int i3 = i >>> 11;
        while (i3 != 0) {
            i3 >>>= 5;
            i2++;
        }
        int i4 = i2;
        while (true) {
            i4--;
            if (i4 > 0) {
                bArr[i4] = (byte) ((i & 63) | 128);
                i >>>= 6;
            } else {
                bArr[0] = (byte) ((256 - (1 << (8 - i2))) + i);
                return i2;
            }
        }
    }
}
