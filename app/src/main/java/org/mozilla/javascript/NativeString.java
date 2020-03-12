package org.mozilla.javascript;

import com.baicizhan.client.framework.network.http.HttpStat.ExecuteStatus;
import com.baicizhan.client.framework.network.http.NetWorkError;
import java.text.Collator;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.pattern.parser.Parser;
import p012ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

/* renamed from: org.mozilla.javascript.ck */
final class NativeString extends IdScriptableObject {

    /* renamed from: b */
    private static final Object f6383b = "String";

    /* renamed from: a */
    CharSequence f6384a;

    /* renamed from: a */
    static void m6105a(Scriptable drVar) {
        new NativeString("").exportAsJSClass(37, drVar, false);
    }

    NativeString(CharSequence charSequence) {
        this.f6384a = charSequence;
    }

    public final String getClassName() {
        return "String";
    }

    /* access modifiers changed from: protected */
    public final int getMaxInstanceId() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public final int findInstanceIdInfo(String str) {
        if (str.equals("length")) {
            return instanceIdInfo(7, 1);
        }
        return super.findInstanceIdInfo(str);
    }

    /* access modifiers changed from: protected */
    public final String getInstanceIdName(int i) {
        if (i == 1) {
            return "length";
        }
        return super.getInstanceIdName(i);
    }

    /* access modifiers changed from: protected */
    public final Object getInstanceIdValue(int i) {
        if (i == 1) {
            return ScriptRuntime.m6434d(this.f6384a.length());
        }
        return super.getInstanceIdValue(i);
    }

    /* access modifiers changed from: protected */
    public final void fillConstructorProperties(IdFunctionObject ahVar) {
        addIdFunctionProperty(ahVar, f6383b, -1, "fromCharCode", 1);
        addIdFunctionProperty(ahVar, f6383b, -5, "charAt", 2);
        addIdFunctionProperty(ahVar, f6383b, -6, "charCodeAt", 2);
        addIdFunctionProperty(ahVar, f6383b, -7, "indexOf", 2);
        addIdFunctionProperty(ahVar, f6383b, -8, "lastIndexOf", 2);
        addIdFunctionProperty(ahVar, f6383b, -9, "split", 3);
        addIdFunctionProperty(ahVar, f6383b, -10, "substring", 3);
        addIdFunctionProperty(ahVar, f6383b, -11, "toLowerCase", 1);
        addIdFunctionProperty(ahVar, f6383b, -12, "toUpperCase", 1);
        addIdFunctionProperty(ahVar, f6383b, -13, "substr", 3);
        addIdFunctionProperty(ahVar, f6383b, -14, "concat", 2);
        addIdFunctionProperty(ahVar, f6383b, -15, "slice", 3);
        addIdFunctionProperty(ahVar, f6383b, -30, "equalsIgnoreCase", 2);
        addIdFunctionProperty(ahVar, f6383b, -31, "match", 2);
        addIdFunctionProperty(ahVar, f6383b, -32, "search", 2);
        addIdFunctionProperty(ahVar, f6383b, -33, Parser.REPLACE_CONVERTER_WORD, 2);
        addIdFunctionProperty(ahVar, f6383b, -34, "localeCompare", 2);
        addIdFunctionProperty(ahVar, f6383b, -35, "toLocaleLowerCase", 1);
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
                i2 = 0;
                break;
            case 3:
                str = "toSource";
                i2 = 0;
                break;
            case 4:
                str = CoreConstants.VALUE_OF;
                i2 = 0;
                break;
            case 5:
                str = "charAt";
                break;
            case 6:
                str = "charCodeAt";
                break;
            case 7:
                str = "indexOf";
                break;
            case 8:
                str = "lastIndexOf";
                break;
            case 9:
                str = "split";
                i2 = 2;
                break;
            case 10:
                str = "substring";
                i2 = 2;
                break;
            case 11:
                str = "toLowerCase";
                i2 = 0;
                break;
            case 12:
                str = "toUpperCase";
                i2 = 0;
                break;
            case 13:
                str = "substr";
                i2 = 2;
                break;
            case 14:
                str = "concat";
                break;
            case 15:
                str = "slice";
                i2 = 2;
                break;
            case 16:
                str = "bold";
                i2 = 0;
                break;
            case 17:
                str = "italics";
                i2 = 0;
                break;
            case 18:
                str = "fixed";
                i2 = 0;
                break;
            case 19:
                str = "strike";
                i2 = 0;
                break;
            case 20:
                str = "small";
                i2 = 0;
                break;
            case 21:
                str = "big";
                i2 = 0;
                break;
            case 22:
                str = "blink";
                i2 = 0;
                break;
            case 23:
                str = "sup";
                i2 = 0;
                break;
            case 24:
                str = "sub";
                i2 = 0;
                break;
            case 25:
                str = "fontsize";
                i2 = 0;
                break;
            case 26:
                str = "fontcolor";
                i2 = 0;
                break;
            case 27:
                str = "link";
                i2 = 0;
                break;
            case 28:
                str = "anchor";
                i2 = 0;
                break;
            case 29:
                str = "equals";
                break;
            case 30:
                str = "equalsIgnoreCase";
                break;
            case 31:
                str = "match";
                break;
            case 32:
                str = "search";
                break;
            case 33:
                str = Parser.REPLACE_CONVERTER_WORD;
                break;
            case 34:
                str = "localeCompare";
                break;
            case 35:
                str = "toLocaleLowerCase";
                i2 = 0;
                break;
            case 36:
                str = "toLocaleUpperCase";
                i2 = 0;
                break;
            case 37:
                str = "trim";
                i2 = 0;
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(f6383b, i, str, i2);
    }

    public final Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        int i;
        double e;
        double d;
        double d2;
        int indexOf;
        Scriptable a;
        if (!ahVar.mo18643a(f6383b)) {
            return super.execIdCall(ahVar, lVar, drVar, drVar2, objArr);
        }
        int i2 = ahVar.f5994a;
        Object[] objArr2 = objArr;
        Scriptable drVar3 = drVar2;
        while (true) {
            switch (i2) {
                case -35:
                case -34:
                case -33:
                case -32:
                case -31:
                case -30:
                case NetWorkError.NETWORK_OUTOFMEMORY /*-15*/:
                case NetWorkError.NETWORK_CANCEL /*-14*/:
                case NetWorkError.NETWORK_SOCKET_TIMEOUT /*-13*/:
                case NetWorkError.NETWORK_SOCKET_EXCEPTION /*-12*/:
                case NetWorkError.NETWORK_DATA_TOO_BIG /*-11*/:
                case NetWorkError.NETWORK_UNKNOWN /*-10*/:
                case ExecuteStatus.GETDATA_SUCC /*-9*/:
                case ExecuteStatus.GETDATA_BEFORE /*-8*/:
                case -7:
                case -6:
                case -5:
                    if (objArr2.length > 0) {
                        Scriptable a2 = ScriptRuntime.m6364a(drVar, (Object) ScriptRuntime.m6422c(objArr2[0]));
                        Object[] objArr3 = new Object[(objArr2.length - 1)];
                        for (int i3 = 0; i3 < objArr3.length; i3++) {
                            objArr3[i3] = objArr2[i3 + 1];
                        }
                        objArr2 = objArr3;
                        a = a2;
                    } else {
                        a = ScriptRuntime.m6364a(drVar, (Object) ScriptRuntime.m6422c((Object) drVar3));
                    }
                    i2 = -i2;
                    drVar3 = a;
                case -1:
                    int length = objArr2.length;
                    if (length <= 0) {
                        return "";
                    }
                    StringBuffer stringBuffer = new StringBuffer(length);
                    for (int i4 = 0; i4 != length; i4++) {
                        stringBuffer.append(ScriptRuntime.m6456h(objArr2[i4]));
                    }
                    return stringBuffer.toString();
                case 1:
                    CharSequence charSequence = objArr2.length > 0 ? ScriptRuntime.m6422c(objArr2[0]) : "";
                    if (drVar3 == null) {
                        return new NativeString(charSequence);
                    }
                    return charSequence instanceof String ? charSequence : charSequence.toString();
                case 2:
                case 4:
                    CharSequence charSequence2 = m6104a(drVar3, ahVar).f6384a;
                    if (!(charSequence2 instanceof String)) {
                        return charSequence2.toString();
                    }
                    return charSequence2;
                case 3:
                    return "(new String(\"" + ScriptRuntime.m6403b(m6104a(drVar3, ahVar).f6384a.toString()) + "\"))";
                case 5:
                case 6:
                    CharSequence c = ScriptRuntime.m6422c((Object) drVar3);
                    double b = ScriptRuntime.m6396b(objArr2, 0);
                    if (b >= 0.0d && b < ((double) c.length())) {
                        char charAt = c.charAt((int) b);
                        if (i2 == 5) {
                            return String.valueOf(charAt);
                        }
                        return ScriptRuntime.m6434d((int) charAt);
                    } else if (i2 == 5) {
                        return "";
                    } else {
                        return ScriptRuntime.f6515v;
                    }
                case 7:
                    String d3 = ScriptRuntime.m6436d((Object) drVar3);
                    String b2 = ScriptRuntime.m6407b(objArr2);
                    double b3 = ScriptRuntime.m6396b(objArr2, 1);
                    if (b3 > ((double) d3.length())) {
                        indexOf = -1;
                    } else {
                        if (b3 < 0.0d) {
                            b3 = 0.0d;
                        }
                        indexOf = d3.indexOf(b2, (int) b3);
                    }
                    return ScriptRuntime.m6434d(indexOf);
                case 8:
                    String d4 = ScriptRuntime.m6436d((Object) drVar3);
                    String b4 = ScriptRuntime.m6407b(objArr2);
                    double a3 = ScriptRuntime.m6311a(objArr2, 1);
                    if (a3 != a3 || a3 > ((double) d4.length())) {
                        a3 = (double) d4.length();
                    } else if (a3 < 0.0d) {
                        a3 = 0.0d;
                    }
                    return ScriptRuntime.m6434d(d4.lastIndexOf(b4, (int) a3));
                case 9:
                    return ScriptRuntime.m6454g(lVar).js_split(lVar, drVar, ScriptRuntime.m6436d((Object) drVar3), objArr2);
                case 10:
                    CharSequence c2 = ScriptRuntime.m6422c((Object) drVar3);
                    int length2 = c2.length();
                    double b5 = ScriptRuntime.m6396b(objArr2, 0);
                    if (b5 < 0.0d) {
                        b5 = 0.0d;
                    } else if (b5 > ((double) length2)) {
                        b5 = (double) length2;
                    }
                    if (objArr2.length <= 1 || objArr2[1] == Undefined.f6689a) {
                        d2 = b5;
                        b5 = (double) length2;
                    } else {
                        d2 = ScriptRuntime.m6440e(objArr2[1]);
                        if (d2 < 0.0d) {
                            d2 = 0.0d;
                        } else if (d2 > ((double) length2)) {
                            d2 = (double) length2;
                        }
                        if (d2 >= b5) {
                            double d5 = d2;
                            d2 = b5;
                            b5 = d5;
                        } else if (lVar.f6785i == 120) {
                            d2 = b5;
                        }
                    }
                    return c2.subSequence((int) d2, (int) b5);
                case 11:
                    return ScriptRuntime.m6436d((Object) drVar3).toLowerCase(ScriptRuntime.f6512s);
                case 12:
                    return ScriptRuntime.m6436d((Object) drVar3).toUpperCase(ScriptRuntime.f6512s);
                case 13:
                    CharSequence c3 = ScriptRuntime.m6422c((Object) drVar3);
                    if (objArr2.length <= 0) {
                        return c3;
                    }
                    double e2 = ScriptRuntime.m6440e(objArr2[0]);
                    int length3 = c3.length();
                    if (e2 < 0.0d) {
                        e2 += (double) length3;
                        if (e2 < 0.0d) {
                            e2 = 0.0d;
                        }
                    } else if (e2 > ((double) length3)) {
                        e2 = (double) length3;
                    }
                    if (objArr2.length == 1) {
                        d = (double) length3;
                    } else {
                        double e3 = ScriptRuntime.m6440e(objArr2[1]);
                        if (e3 < 0.0d) {
                            e3 = 0.0d;
                        }
                        d = e3 + e2;
                        if (d > ((double) length3)) {
                            d = (double) length3;
                        }
                    }
                    return c3.subSequence((int) e2, (int) d);
                case 14:
                    return m6103a(ScriptRuntime.m6436d((Object) drVar3), objArr2);
                case 15:
                    CharSequence c4 = ScriptRuntime.m6422c((Object) drVar3);
                    if (objArr2.length == 0) {
                        return c4;
                    }
                    double e4 = ScriptRuntime.m6440e(objArr2[0]);
                    int length4 = c4.length();
                    if (e4 < 0.0d) {
                        e4 += (double) length4;
                        if (e4 < 0.0d) {
                            e4 = 0.0d;
                        }
                    } else if (e4 > ((double) length4)) {
                        e4 = (double) length4;
                    }
                    if (objArr2.length == 1) {
                        e = (double) length4;
                    } else {
                        e = ScriptRuntime.m6440e(objArr2[1]);
                        if (e < 0.0d) {
                            e += (double) length4;
                            if (e < 0.0d) {
                                e = 0.0d;
                            }
                        } else if (e > ((double) length4)) {
                            e = (double) length4;
                        }
                        if (e < e4) {
                            e = e4;
                        }
                    }
                    return c4.subSequence((int) e4, (int) e);
                case 16:
                    return m6102a(drVar3, "b", null, null);
                case 17:
                    return m6102a(drVar3, IntegerTokenConverter.CONVERTER_KEY, null, null);
                case 18:
                    return m6102a(drVar3, "tt", null, null);
                case 19:
                    return m6102a(drVar3, "strike", null, null);
                case 20:
                    return m6102a(drVar3, "small", null, null);
                case 21:
                    return m6102a(drVar3, "big", null, null);
                case 22:
                    return m6102a(drVar3, "blink", null, null);
                case 23:
                    return m6102a(drVar3, "sup", null, null);
                case 24:
                    return m6102a(drVar3, "sub", null, null);
                case 25:
                    return m6102a(drVar3, "font", "size", objArr2);
                case 26:
                    return m6102a(drVar3, "font", "color", objArr2);
                case 27:
                    return m6102a(drVar3, "a", "href", objArr2);
                case 28:
                    return m6102a(drVar3, "a", "name", objArr2);
                case 29:
                case 30:
                    String d6 = ScriptRuntime.m6436d((Object) drVar3);
                    String b6 = ScriptRuntime.m6407b(objArr2);
                    return ScriptRuntime.m6312a(i2 == 29 ? d6.equals(b6) : d6.equalsIgnoreCase(b6));
                case 31:
                case 32:
                case 33:
                    if (i2 == 31) {
                        i = 1;
                    } else if (i2 == 32) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    return ScriptRuntime.m6454g(lVar).action(lVar, drVar, drVar3, objArr2, i);
                case 34:
                    Collator instance = Collator.getInstance(lVar.mo19140e());
                    instance.setStrength(3);
                    instance.setDecomposition(1);
                    return ScriptRuntime.m6313a((double) instance.compare(ScriptRuntime.m6436d((Object) drVar3), ScriptRuntime.m6407b(objArr2)));
                case 35:
                    return ScriptRuntime.m6436d((Object) drVar3).toLowerCase(lVar.mo19140e());
                case 36:
                    return ScriptRuntime.m6436d((Object) drVar3).toUpperCase(lVar.mo19140e());
                case 37:
                    String d7 = ScriptRuntime.m6436d((Object) drVar3);
                    char[] charArray = d7.toCharArray();
                    int i5 = 0;
                    while (i5 < charArray.length && ScriptRuntime.m6416b((int) charArray[i5])) {
                        i5++;
                    }
                    int length5 = charArray.length;
                    while (length5 > i5 && ScriptRuntime.m6416b((int) charArray[length5 - 1])) {
                        length5--;
                    }
                    return d7.substring(i5, length5);
                default:
                    throw new IllegalArgumentException(String.valueOf(i2));
            }
        }
    }

    /* renamed from: a */
    private static NativeString m6104a(Scriptable drVar, IdFunctionObject ahVar) {
        if (drVar instanceof NativeString) {
            return (NativeString) drVar;
        }
        throw incompatibleCallError(ahVar);
    }

    /* renamed from: a */
    private static String m6102a(Object obj, String str, String str2, Object[] objArr) {
        String d = ScriptRuntime.m6436d(obj);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('<');
        stringBuffer.append(str);
        if (str2 != null) {
            stringBuffer.append(' ');
            stringBuffer.append(str2);
            stringBuffer.append("=\"");
            stringBuffer.append(ScriptRuntime.m6407b(objArr));
            stringBuffer.append(CoreConstants.DOUBLE_QUOTE_CHAR);
        }
        stringBuffer.append('>');
        stringBuffer.append(d);
        stringBuffer.append("</");
        stringBuffer.append(str);
        stringBuffer.append('>');
        return stringBuffer.toString();
    }

    public final String toString() {
        return this.f6384a instanceof String ? (String) this.f6384a : this.f6384a.toString();
    }

    public final Object get(int i, Scriptable drVar) {
        if (i < 0 || i >= this.f6384a.length()) {
            return super.get(i, drVar);
        }
        return String.valueOf(this.f6384a.charAt(i));
    }

    public final void put(int i, Scriptable drVar, Object obj) {
        if (i < 0 || i >= this.f6384a.length()) {
            super.put(i, drVar, obj);
        }
    }

    /* renamed from: a */
    private static String m6103a(String str, Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return str;
        }
        if (length == 1) {
            return str.concat(ScriptRuntime.m6436d(objArr[0]));
        }
        String[] strArr = new String[length];
        int length2 = str.length();
        for (int i = 0; i != length; i++) {
            String d = ScriptRuntime.m6436d(objArr[i]);
            strArr[i] = d;
            length2 += d.length();
        }
        StringBuffer stringBuffer = new StringBuffer(length2);
        stringBuffer.append(str);
        for (int i2 = 0; i2 != length; i2++) {
            stringBuffer.append(strArr[i2]);
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int findPrototypeId(String r9) {
        /*
            r8 = this;
            r2 = 4
            r3 = 2
            r6 = 115(0x73, float:1.61E-43)
            r4 = 1
            r0 = 0
            r1 = 0
            int r5 = r9.length()
            switch(r5) {
                case 3: goto L_0x001b;
                case 4: goto L_0x0060;
                case 5: goto L_0x0088;
                case 6: goto L_0x00c9;
                case 7: goto L_0x0112;
                case 8: goto L_0x013e;
                case 9: goto L_0x0163;
                case 10: goto L_0x017f;
                case 11: goto L_0x0187;
                case 12: goto L_0x000e;
                case 13: goto L_0x01b3;
                case 14: goto L_0x000e;
                case 15: goto L_0x000e;
                case 16: goto L_0x01bc;
                case 17: goto L_0x01c5;
                default: goto L_0x000e;
            }
        L_0x000e:
            r2 = r1
            r1 = r0
        L_0x0010:
            if (r2 == 0) goto L_0x01e5
            if (r2 == r9) goto L_0x01e5
            boolean r2 = r2.equals(r9)
            if (r2 != 0) goto L_0x01e5
        L_0x001a:
            return r0
        L_0x001b:
            char r2 = r9.charAt(r3)
            r3 = 98
            if (r2 != r3) goto L_0x0034
            char r2 = r9.charAt(r0)
            if (r2 != r6) goto L_0x000e
            char r2 = r9.charAt(r4)
            r3 = 117(0x75, float:1.64E-43)
            if (r2 != r3) goto L_0x000e
            r0 = 24
            goto L_0x001a
        L_0x0034:
            r3 = 103(0x67, float:1.44E-43)
            if (r2 != r3) goto L_0x004b
            char r2 = r9.charAt(r0)
            r3 = 98
            if (r2 != r3) goto L_0x000e
            char r2 = r9.charAt(r4)
            r3 = 105(0x69, float:1.47E-43)
            if (r2 != r3) goto L_0x000e
            r0 = 21
            goto L_0x001a
        L_0x004b:
            r3 = 112(0x70, float:1.57E-43)
            if (r2 != r3) goto L_0x000e
            char r2 = r9.charAt(r0)
            if (r2 != r6) goto L_0x000e
            char r2 = r9.charAt(r4)
            r3 = 117(0x75, float:1.64E-43)
            if (r2 != r3) goto L_0x000e
            r0 = 23
            goto L_0x001a
        L_0x0060:
            char r2 = r9.charAt(r0)
            r3 = 98
            if (r2 != r3) goto L_0x0070
            java.lang.String r1 = "bold"
            r2 = 16
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0070:
            r3 = 108(0x6c, float:1.51E-43)
            if (r2 != r3) goto L_0x007c
            java.lang.String r1 = "link"
            r2 = 27
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x007c:
            r3 = 116(0x74, float:1.63E-43)
            if (r2 != r3) goto L_0x000e
            java.lang.String r1 = "trim"
            r2 = 37
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0088:
            char r2 = r9.charAt(r2)
            switch(r2) {
                case 100: goto L_0x0093;
                case 101: goto L_0x009c;
                case 104: goto L_0x00a5;
                case 107: goto L_0x00ae;
                case 108: goto L_0x00b7;
                case 116: goto L_0x00c0;
                default: goto L_0x008f;
            }
        L_0x008f:
            r2 = r1
            r1 = r0
            goto L_0x0010
        L_0x0093:
            java.lang.String r1 = "fixed"
            r2 = 18
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x009c:
            java.lang.String r1 = "slice"
            r2 = 15
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00a5:
            java.lang.String r1 = "match"
            r2 = 31
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00ae:
            java.lang.String r1 = "blink"
            r2 = 22
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00b7:
            java.lang.String r1 = "small"
            r2 = 20
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00c0:
            java.lang.String r1 = "split"
            r2 = 9
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00c9:
            char r2 = r9.charAt(r4)
            switch(r2) {
                case 101: goto L_0x00d4;
                case 104: goto L_0x00dd;
                case 110: goto L_0x00e5;
                case 111: goto L_0x00ee;
                case 113: goto L_0x00f7;
                case 116: goto L_0x0100;
                case 117: goto L_0x0109;
                default: goto L_0x00d0;
            }
        L_0x00d0:
            r2 = r1
            r1 = r0
            goto L_0x0010
        L_0x00d4:
            java.lang.String r1 = "search"
            r2 = 32
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00dd:
            java.lang.String r1 = "charAt"
            r2 = 5
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00e5:
            java.lang.String r1 = "anchor"
            r2 = 28
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00ee:
            java.lang.String r1 = "concat"
            r2 = 14
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x00f7:
            java.lang.String r1 = "equals"
            r2 = 29
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0100:
            java.lang.String r1 = "strike"
            r2 = 19
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0109:
            java.lang.String r1 = "substr"
            r2 = 13
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0112:
            char r3 = r9.charAt(r4)
            switch(r3) {
                case 97: goto L_0x011d;
                case 101: goto L_0x0124;
                case 110: goto L_0x012d;
                case 116: goto L_0x0135;
                default: goto L_0x0119;
            }
        L_0x0119:
            r2 = r1
            r1 = r0
            goto L_0x0010
        L_0x011d:
            java.lang.String r1 = "valueOf"
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0124:
            java.lang.String r1 = "replace"
            r2 = 33
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x012d:
            java.lang.String r1 = "indexOf"
            r2 = 7
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0135:
            java.lang.String r1 = "italics"
            r2 = 17
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x013e:
            char r2 = r9.charAt(r2)
            r4 = 114(0x72, float:1.6E-43)
            if (r2 != r4) goto L_0x014c
            java.lang.String r1 = "toString"
            r2 = r1
            r1 = r3
            goto L_0x0010
        L_0x014c:
            if (r2 != r6) goto L_0x0157
            java.lang.String r1 = "fontsize"
            r2 = 25
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0157:
            r3 = 117(0x75, float:1.64E-43)
            if (r2 != r3) goto L_0x000e
            java.lang.String r1 = "toSource"
            r2 = 3
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0163:
            char r2 = r9.charAt(r0)
            r3 = 102(0x66, float:1.43E-43)
            if (r2 != r3) goto L_0x0174
            java.lang.String r1 = "fontcolor"
            r2 = 26
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0174:
            if (r2 != r6) goto L_0x000e
            java.lang.String r1 = "substring"
            r2 = 10
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x017f:
            java.lang.String r1 = "charCodeAt"
            r2 = 6
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x0187:
            char r2 = r9.charAt(r3)
            switch(r2) {
                case 76: goto L_0x0192;
                case 85: goto L_0x019b;
                case 110: goto L_0x01a4;
                case 115: goto L_0x01aa;
                default: goto L_0x018e;
            }
        L_0x018e:
            r2 = r1
            r1 = r0
            goto L_0x0010
        L_0x0192:
            java.lang.String r1 = "toLowerCase"
            r2 = 11
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x019b:
            java.lang.String r1 = "toUpperCase"
            r2 = 12
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x01a4:
            java.lang.String r1 = "constructor"
            r2 = r1
            r1 = r4
            goto L_0x0010
        L_0x01aa:
            java.lang.String r1 = "lastIndexOf"
            r2 = 8
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x01b3:
            java.lang.String r1 = "localeCompare"
            r2 = 34
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x01bc:
            java.lang.String r1 = "equalsIgnoreCase"
            r2 = 30
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x01c5:
            r2 = 8
            char r2 = r9.charAt(r2)
            r3 = 76
            if (r2 != r3) goto L_0x01d8
            java.lang.String r1 = "toLocaleLowerCase"
            r2 = 35
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x01d8:
            r3 = 85
            if (r2 != r3) goto L_0x000e
            java.lang.String r1 = "toLocaleUpperCase"
            r2 = 36
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0010
        L_0x01e5:
            r0 = r1
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeString.findPrototypeId(java.lang.String):int");
    }
}
