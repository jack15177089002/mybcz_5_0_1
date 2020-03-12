package org.mozilla.javascript;

//import com.tencent.android.tpush.service.report.ReportItem;
import java.util.Locale;
import org.mozilla.javascript.p114f.FastDtoa;
import org.mozilla.javascript.p115g.XMLLib;
import org.mozilla.javascript.p115g.XMLObject;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.dk */
public class ScriptRuntime {

    /* renamed from: A */
    private static final Object f6493A = "LIBRARY_SCOPE";

    /* renamed from: a */
    public static final Class<?> f6494a = Kit.m5805a("java.lang.Boolean");

    /* renamed from: b */
    public static final Class<?> f6495b = Kit.m5805a("java.lang.Byte");

    /* renamed from: c */
    public static final Class<?> f6496c = Kit.m5805a("java.lang.Character");

    /* renamed from: d */
    public static final Class<?> f6497d = Kit.m5805a("java.lang.Class");

    /* renamed from: e */
    public static final Class<?> f6498e = Kit.m5805a("java.lang.Double");

    /* renamed from: f */
    public static final Class<?> f6499f = Kit.m5805a("java.lang.Float");

    /* renamed from: g */
    public static final Class<?> f6500g = Kit.m5805a("java.lang.Integer");

    /* renamed from: h */
    public static final Class<?> f6501h = Kit.m5805a("java.lang.Long");

    /* renamed from: i */
    public static final Class<?> f6502i = Kit.m5805a("java.lang.Number");

    /* renamed from: j */
    public static final Class<?> f6503j = Kit.m5805a("java.lang.Object");

    /* renamed from: k */
    public static final Class<?> f6504k = Kit.m5805a("java.lang.Short");

    /* renamed from: l */
    public static final Class<?> f6505l = Kit.m5805a("java.lang.String");

    /* renamed from: m */
    public static final Class<?> f6506m = Kit.m5805a("java.util.Date");

    /* renamed from: n */
    public static final Class<?> f6507n = Kit.m5805a("org.mozilla.javascript.l");

    /* renamed from: o */
    public static final Class<?> f6508o = Kit.m5805a("org.mozilla.javascript.o");

    /* renamed from: p */
    public static final Class<?> f6509p = Kit.m5805a("org.mozilla.javascript.ab");

    /* renamed from: q */
    public static final Class<?> f6510q = Kit.m5805a("org.mozilla.javascript.ds");

    /* renamed from: r */
    public static final Class<Scriptable> f6511r = Scriptable.class;

    /* renamed from: s */
    public static Locale f6512s = new Locale("");

    /* renamed from: t */
    public static final double f6513t = Double.longBitsToDouble(9221120237041090560L);

    /* renamed from: u */
    public static final double f6514u = Double.longBitsToDouble(Long.MIN_VALUE);

    /* renamed from: v */
    public static final Double f6515v = new Double(f6513t);

    /* renamed from: w */
    public static C2177do f6516w = new C2175dm((byte) 0);

    /* renamed from: x */
    public static final Object[] f6517x = new Object[0];

    /* renamed from: y */
    public static final String[] f6518y = new String[0];

    /* renamed from: z */
    private static BaseFunction f6519z = null;

    /* renamed from: a */
    public static BaseFunction m6358a() {
        if (f6519z == null) {
            C2174dl dlVar = new C2174dl();
            dlVar.preventExtensions();
            f6519z = dlVar;
        }
        return f6519z;
    }

    /* renamed from: a */
    public static ScriptableObject m6372a(Context lVar) {
        NativeObject cbVar = new NativeObject();
        cbVar.associateValue(f6493A, cbVar);
        ClassCache fVar = new ClassCache();
        if (cbVar.getParentScope() != null) {
            throw new IllegalArgumentException();
        }
        if (fVar == cbVar.associateValue(ClassCache.f6697a, fVar)) {
            fVar.f6702f = cbVar;
        }
        BaseFunction.init(cbVar, false);
        NativeObject.m6098a(cbVar);
        Scriptable objectPrototype = ScriptableObject.getObjectPrototype(cbVar);
        ScriptableObject.getClassPrototype(cbVar, "Function").setPrototype(objectPrototype);
        if (cbVar.getPrototype() == null) {
            cbVar.setPrototype(objectPrototype);
        }
        NativeError.m6038a((Scriptable) cbVar);
        NativeGlobal.m6059a(lVar, (Scriptable) cbVar);
        NativeArray.m5989a((Scriptable) cbVar);
        if (lVar.f6791o > 0) {
            NativeArray.m5988a();
        }
        NativeString.m6105a(cbVar);
        NativeBoolean.m6002a(cbVar);
        NativeNumber.m6097a(cbVar);
        NativeDate.m6016a((Scriptable) cbVar);
        NativeMath.m6094a(cbVar);
        NativeJSON.m6072a((Scriptable) cbVar);
        NativeWith.m6108a((Scriptable) cbVar);
        NativeCall.m6003a(cbVar);
        NativeScript.m6101a(cbVar);
        NativeIterator.m6065a((ScriptableObject) cbVar);
        boolean z = lVar.mo19138b(6) && Context.m6767h() != null;
        new LazilyLoadedCtor(cbVar, "RegExp", "org.mozilla.javascript.regexp.NativeRegExp");
        new LazilyLoadedCtor(cbVar, "Packages", "org.mozilla.javascript.NativeJavaTopPackage");
        new LazilyLoadedCtor(cbVar, "getClass", "org.mozilla.javascript.NativeJavaTopPackage");
        new LazilyLoadedCtor(cbVar, "JavaAdapter", "org.mozilla.javascript.JavaAdapter");
        new LazilyLoadedCtor(cbVar, "JavaImporter", "org.mozilla.javascript.ImporterTopLevel");
        new LazilyLoadedCtor(cbVar, "Continuation", "org.mozilla.javascript.NativeContinuation");
//        for (String azVar : "Dalvik".equals(System.getProperty("java.vm.name")) ? new String[]{"java", "javax", "org", "com", "edu", ReportItem.NETWORK_TYPE, "android"} : new String[]{"java", "javax", "org", "com", "edu", ReportItem.NETWORK_TYPE}) {
//            new LazilyLoadedCtor(cbVar, azVar, "org.mozilla.javascript.NativeJavaTopPackage");
//        }
        if (z) {
            String a = Context.m6767h().mo19118a();
            new LazilyLoadedCtor(cbVar, "XML", a);
            new LazilyLoadedCtor(cbVar, "XMLList", a);
            new LazilyLoadedCtor(cbVar, "Namespace", a);
            new LazilyLoadedCtor(cbVar, "QName", a);
        }
//        if (cbVar instanceof TopLevel) {
//            ((TopLevel) cbVar).mo19089a();
//        }
        return cbVar;
    }

    /* renamed from: a */
    public static ScriptableObject m6371a(Scriptable drVar) {
        return (ScriptableObject) ScriptableObject.getTopScopeValue(drVar, f6493A);
    }

    /* renamed from: a */
    public static boolean m6389a(int i) {
        if ((57296 & i) != 0) {
            return false;
        }
        if (i == 10 || i == 13 || i == 8232 || i == 8233) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m6416b(int i) {
        return m6429c(i) || m6389a(i);
    }

    /* renamed from: c */
    static boolean m6429c(int i) {
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 32:
            case 160:
            case 8232:
            case 8233:
            case 65279:
                return true;
            default:
                return Character.getType(i) == 12;
        }
    }

    /* renamed from: a */
    public static Boolean m6312a(boolean z) {
        return z ? Boolean.TRUE : Boolean.FALSE;
    }

    /* renamed from: d */
    public static Integer m6434d(int i) {
        return Integer.valueOf(i);
    }

    /* renamed from: a */
    public static Number m6313a(double d) {
        if (d != d) {
            return f6515v;
        }
        return new Double(d);
    }

    /* renamed from: a */
    public static boolean m6391a(Object obj) {
        boolean z;
        Object obj2 = obj;
        while (!(obj2 instanceof Boolean)) {
            if (obj2 == null || obj2 == Undefined.f6689a) {
                return false;
            }
            if (obj2 instanceof CharSequence) {
                return ((CharSequence) obj2).length() != 0;
            }
            if (obj2 instanceof Number) {
                double doubleValue = ((Number) obj2).doubleValue();
                return doubleValue == doubleValue && doubleValue != 0.0d;
            } else if (!(obj2 instanceof Scriptable)) {
                m6478s(obj2);
                return true;
            } else if ((obj2 instanceof ScriptableObject) && ((ScriptableObject) obj2).avoidObjectDetection()) {
                return false;
            } else {
                Context k = Context.m6769k();
                if (k.f6785i == 0 || k.f6785i >= 130) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return true;
                }
                obj2 = ((Scriptable) obj2).getDefaultValue(f6494a);
                if (obj2 instanceof Scriptable) {
                    throw m6401b("msg.primitive.expected", obj2);
                }
            }
        }
        return ((Boolean) obj2).booleanValue();
    }

    /* renamed from: b */
    public static double m6395b(Object obj) {
        Object obj2 = obj;
        while (!(obj2 instanceof Number)) {
            if (obj2 == null) {
                return 0.0d;
            }
            if (obj2 == Undefined.f6689a) {
                return f6513t;
            }
            if (obj2 instanceof String) {
                return m6309a((String) obj2);
            }
            if (obj2 instanceof CharSequence) {
                return m6309a(obj2.toString());
            }
            if (obj2 instanceof Boolean) {
                return ((Boolean) obj2).booleanValue() ? 1.0d : 0.0d;
            }
            if (obj2 instanceof Scriptable) {
                obj2 = ((Scriptable) obj2).getDefaultValue(f6502i);
                if (obj2 instanceof Scriptable) {
                    throw m6401b("msg.primitive.expected", obj2);
                }
            } else {
                m6478s(obj2);
                return f6513t;
            }
        }
        return ((Number) obj2).doubleValue();
    }

    /* renamed from: a */
    public static double m6311a(Object[] objArr, int i) {
        return i < objArr.length ? m6395b(objArr[i]) : f6513t;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00cf, code lost:
        r18 = r4;
        r4 = r6;
        r6 = r8;
        r7 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d6, code lost:
        r9 = r12;
        r8 = r6;
        r2 = r10;
        r3 = r7;
        r6 = r4;
        r10 = r11;
        r4 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x011d, code lost:
        r18 = r4 * 2.0d;
        r4 = r6;
        r6 = r8;
        r7 = r2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static double m6310a(String r20, int r21, int r22) {
        /*
            r4 = 57
            r3 = 97
            r2 = 65
            int r8 = r20.length()
            r5 = 10
            r0 = r22
            if (r0 >= r5) goto L_0x0153
            int r4 = r22 + 48
            int r4 = r4 + -1
            char r4 = (char) r4
            r5 = r4
        L_0x0016:
            r4 = 10
            r0 = r22
            if (r0 <= r4) goto L_0x0026
            int r2 = r22 + 97
            int r2 = r2 + -10
            char r3 = (char) r2
            int r2 = r22 + 65
            int r2 = r2 + -10
            char r2 = (char) r2
        L_0x0026:
            r6 = 0
            r15 = r21
        L_0x002a:
            if (r15 >= r8) goto L_0x005a
            r0 = r20
            char r4 = r0.charAt(r15)
            r9 = 48
            if (r9 > r4) goto L_0x0044
            if (r4 > r5) goto L_0x0044
            int r4 = r4 + -48
        L_0x003a:
            r0 = r22
            double r10 = (double) r0
            double r6 = r6 * r10
            double r10 = (double) r4
            double r6 = r6 + r10
            int r4 = r15 + 1
            r15 = r4
            goto L_0x002a
        L_0x0044:
            r9 = 97
            if (r9 > r4) goto L_0x004f
            if (r4 >= r3) goto L_0x004f
            int r4 = r4 + -97
            int r4 = r4 + 10
            goto L_0x003a
        L_0x004f:
            r9 = 65
            if (r9 > r4) goto L_0x005a
            if (r4 >= r2) goto L_0x005a
            int r4 = r4 + -65
            int r4 = r4 + 10
            goto L_0x003a
        L_0x005a:
            r0 = r21
            if (r0 != r15) goto L_0x0061
            double r6 = f6513t
        L_0x0060:
            return r6
        L_0x0061:
            r2 = 4845873199050653696(0x4340000000000000, double:9.007199254740992E15)
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0060
            r2 = 10
            r0 = r22
            if (r0 != r2) goto L_0x007e
            r0 = r20
            r1 = r21
            java.lang.String r2 = r0.substring(r1, r15)     // Catch:{ NumberFormatException -> 0x007a }
            double r6 = java.lang.Double.parseDouble(r2)     // Catch:{ NumberFormatException -> 0x007a }
            goto L_0x0060
        L_0x007a:
            r2 = move-exception
            double r6 = f6513t
            goto L_0x0060
        L_0x007e:
            r2 = 2
            r0 = r22
            if (r0 == r2) goto L_0x009a
            r2 = 4
            r0 = r22
            if (r0 == r2) goto L_0x009a
            r2 = 8
            r0 = r22
            if (r0 == r2) goto L_0x009a
            r2 = 16
            r0 = r22
            if (r0 == r2) goto L_0x009a
            r2 = 32
            r0 = r22
            if (r0 != r2) goto L_0x0060
        L_0x009a:
            r9 = 1
            r10 = 0
            r11 = 0
            r8 = 53
            r4 = 0
            r3 = 0
            r2 = 0
            r13 = r2
            r14 = r3
            r2 = r10
            r3 = r11
            r10 = r21
        L_0x00a9:
            r11 = 1
            if (r9 != r11) goto L_0x014e
            if (r10 == r15) goto L_0x0129
            int r9 = r10 + 1
            r0 = r20
            char r2 = r0.charAt(r10)
            r10 = 48
            if (r10 > r2) goto L_0x00e1
            r10 = 57
            if (r2 > r10) goto L_0x00e1
            int r2 = r2 + -48
        L_0x00c0:
            r10 = r2
            r11 = r9
            r2 = r22
        L_0x00c4:
            int r12 = r2 >> 1
            r2 = r10 & r12
            if (r2 == 0) goto L_0x00ef
            r2 = 1
            r9 = r2
        L_0x00cc:
            switch(r3) {
                case 0: goto L_0x00f2;
                case 1: goto L_0x00fd;
                case 2: goto L_0x0112;
                case 3: goto L_0x011a;
                case 4: goto L_0x0144;
                default: goto L_0x00cf;
            }
        L_0x00cf:
            r18 = r4
            r4 = r6
            r6 = r8
            r7 = r3
            r2 = r18
        L_0x00d6:
            r9 = r12
            r8 = r6
            r18 = r2
            r2 = r10
            r3 = r7
            r6 = r4
            r10 = r11
            r4 = r18
            goto L_0x00a9
        L_0x00e1:
            r10 = 97
            if (r10 > r2) goto L_0x00ec
            r10 = 122(0x7a, float:1.71E-43)
            if (r2 > r10) goto L_0x00ec
            int r2 = r2 + -87
            goto L_0x00c0
        L_0x00ec:
            int r2 = r2 + -55
            goto L_0x00c0
        L_0x00ef:
            r2 = 0
            r9 = r2
            goto L_0x00cc
        L_0x00f2:
            if (r9 == 0) goto L_0x00cf
            int r8 = r8 + -1
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r3 = 1
            r2 = r10
            r9 = r12
            r10 = r11
            goto L_0x00a9
        L_0x00fd:
            r16 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r6 = r6 * r16
            if (r9 == 0) goto L_0x0107
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r6 = r6 + r16
        L_0x0107:
            int r2 = r8 + -1
            if (r2 != 0) goto L_0x0146
            r3 = 2
            r14 = r9
            r8 = r2
            r2 = r10
            r9 = r12
            r10 = r11
            goto L_0x00a9
        L_0x0112:
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            r3 = 3
            r2 = r10
            r13 = r9
            r9 = r12
            r10 = r11
            goto L_0x00a9
        L_0x011a:
            if (r9 == 0) goto L_0x0144
            r2 = 4
        L_0x011d:
            r16 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r4 = r4 * r16
            r18 = r4
            r4 = r6
            r6 = r8
            r7 = r2
            r2 = r18
            goto L_0x00d6
        L_0x0129:
            switch(r3) {
                case 0: goto L_0x012e;
                case 1: goto L_0x0060;
                case 2: goto L_0x0060;
                case 3: goto L_0x0132;
                case 4: goto L_0x013c;
                default: goto L_0x012c;
            }
        L_0x012c:
            goto L_0x0060
        L_0x012e:
            r6 = 0
            goto L_0x0060
        L_0x0132:
            r2 = r13 & r14
            if (r2 == 0) goto L_0x0139
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r6 = r6 + r2
        L_0x0139:
            double r6 = r6 * r4
            goto L_0x0060
        L_0x013c:
            if (r13 == 0) goto L_0x0141
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r6 = r6 + r2
        L_0x0141:
            double r6 = r6 * r4
            goto L_0x0060
        L_0x0144:
            r2 = r3
            goto L_0x011d
        L_0x0146:
            r18 = r4
            r4 = r6
            r6 = r2
            r7 = r3
            r2 = r18
            goto L_0x00d6
        L_0x014e:
            r11 = r10
            r10 = r2
            r2 = r9
            goto L_0x00c4
        L_0x0153:
            r5 = r4
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.m6310a(java.lang.String, int, int):double");
    }

    /* renamed from: a */
    public static double m6309a(String str) {
        char charAt;
        int length = str.length();
        int i = 0;
        while (i != length) {
            char charAt2 = str.charAt(i);
            if (m6429c((int) charAt2)) {
                i++;
            } else {
                if (charAt2 == '0') {
                    if (i + 2 < length) {
                        char charAt3 = str.charAt(i + 1);
                        if (charAt3 == 'x' || charAt3 == 'X') {
                            return m6310a(str, i + 2, 16);
                        }
                    }
                } else if ((charAt2 == '+' || charAt2 == '-') && i + 3 < length && str.charAt(i + 1) == '0') {
                    char charAt4 = str.charAt(i + 2);
                    if (charAt4 == 'x' || charAt4 == 'X') {
                        double a = m6310a(str, i + 3, 16);
                        if (charAt2 == '-') {
                            return -a;
                        }
                        return a;
                    }
                }
                while (true) {
                    length--;
                    charAt = str.charAt(length);
                    if (!m6429c((int) charAt)) {
                        break;
                    }
                }
                if (charAt == 'y') {
                    if (charAt2 == '+' || charAt2 == '-') {
                        i++;
                    }
                    if (i + 7 != length || !str.regionMatches(i, "Infinity", 0, 8)) {
                        return f6513t;
                    }
                    return charAt2 == '-' ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                }
                String substring = str.substring(i, length + 1);
                for (int length2 = substring.length() - 1; length2 >= 0; length2--) {
                    char charAt5 = substring.charAt(length2);
                    if (('0' > charAt5 || charAt5 > '9') && charAt5 != '.' && charAt5 != 'e' && charAt5 != 'E' && charAt5 != '+' && charAt5 != '-') {
                        return f6513t;
                    }
                }
                try {
                    return Double.parseDouble(substring);
                } catch (NumberFormatException e) {
                    return f6513t;
                }
            }
        }
        return 0.0d;
    }

    /* renamed from: a */
    public static Object[] m6394a(Object[] objArr) {
        if (1 < objArr.length) {
            return objArr;
        }
        Object[] objArr2 = new Object[1];
        int i = 0;
        while (i < objArr.length) {
            objArr2[i] = objArr[i];
            i++;
        }
        while (i <= 0) {
            objArr2[i] = Undefined.f6689a;
            i++;
        }
        return objArr2;
    }

    /* renamed from: b */
    public static String m6403b(String str) {
        return m6348a(str, (char) CoreConstants.DOUBLE_QUOTE_CHAR);
    }

    /* renamed from: a */
    private static String m6348a(String str, char c) {
        StringBuffer stringBuffer;
        int i;
        if (!(c == '\"' || c == '\'')) {
            Kit.m5810a();
        }
        int length = str.length();
        StringBuffer stringBuffer2 = null;
        for (int i2 = 0; i2 != length; i2++) {
            char charAt = str.charAt(i2);
            if (' ' > charAt || charAt > '~' || charAt == c || charAt == '\\') {
                if (stringBuffer2 == null) {
                    stringBuffer = new StringBuffer(length + 3);
                    stringBuffer.append(str);
                    stringBuffer.setLength(i2);
                } else {
                    stringBuffer = stringBuffer2;
                }
                int i3 = -1;
                switch (charAt) {
                    case 8:
                        i3 = 98;
                        break;
                    case 9:
                        i3 = 116;
                        break;
                    case 10:
                        i3 = 110;
                        break;
                    case 11:
                        i3 = 118;
                        break;
                    case 12:
                        i3 = 102;
                        break;
                    case 13:
                        i3 = 114;
                        break;
                    case ' ':
                        i3 = 32;
                        break;
                    case '\\':
                        i3 = 92;
                        break;
                }
                if (i3 >= 0) {
                    stringBuffer.append(CoreConstants.ESCAPE_CHAR);
                    stringBuffer.append((char) i3);
                    stringBuffer2 = stringBuffer;
                } else if (charAt == c) {
                    stringBuffer.append(CoreConstants.ESCAPE_CHAR);
                    stringBuffer.append(c);
                    stringBuffer2 = stringBuffer;
                } else {
                    if (charAt < 256) {
                        stringBuffer.append("\\x");
                        i = 2;
                    } else {
                        stringBuffer.append("\\u");
                        i = 4;
                    }
                    for (int i4 = (i - 1) * 4; i4 >= 0; i4 -= 4) {
                        int i5 = (charAt >> i4) & 15;
                        stringBuffer.append((char) (i5 < 10 ? i5 + 48 : i5 + 87));
                    }
                    stringBuffer2 = stringBuffer;
                }
            } else if (stringBuffer2 != null) {
                stringBuffer2.append((char) charAt);
            }
        }
        return stringBuffer2 == null ? str : stringBuffer2.toString();
    }

    /* renamed from: h */
    private static boolean m6459h(String str) {
        int length = str.length();
        if (length == 0 || !Character.isJavaIdentifierStart(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i != length; i++) {
            if (!Character.isJavaIdentifierPart(str.charAt(i))) {
                return false;
            }
        }
        if (!TokenStream.m6627a(str)) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public static CharSequence m6422c(Object obj) {
        if (obj instanceof NativeString) {
            return ((NativeString) obj).f6384a;
        }
        return obj instanceof CharSequence ? (CharSequence) obj : m6436d(obj);
    }

    /* renamed from: d */
    public static String m6436d(Object obj) {
        Object obj2 = obj;
        while (obj2 != null) {
            if (obj2 == Undefined.f6689a) {
                return "undefined";
            }
            if (obj2 instanceof String) {
                return (String) obj2;
            }
            if (obj2 instanceof CharSequence) {
                return obj2.toString();
            }
            if (obj2 instanceof Number) {
                return m6347a(((Number) obj2).doubleValue(), 10);
            }
            if (!(obj2 instanceof Scriptable)) {
                return obj2.toString();
            }
            obj2 = ((Scriptable) obj2).getDefaultValue(f6505l);
            if (obj2 instanceof Scriptable) {
                throw m6401b("msg.primitive.expected", obj2);
            }
        }
        return "null";
    }

    /* renamed from: b */
    static String m6404b(Scriptable drVar) {
        return "[object " + drVar.getClassName() + ']';
    }

    /* renamed from: b */
    public static String m6407b(Object[] objArr) {
        return objArr.length > 0 ? m6436d(objArr[0]) : "undefined";
    }

    /* renamed from: b */
    public static String m6402b(double d) {
        return m6347a(d, 10);
    }

    /* renamed from: a */
    public static String m6347a(double d, int i) {
        if (d != d) {
            return "NaN";
        }
        if (d == Double.POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (d == Double.NEGATIVE_INFINITY) {
            return "-Infinity";
        }
        if (d == 0.0d) {
            return "0";
        }
        if (i < 2 || i > 36) {
            throw Context.m6755a("msg.bad.radix", (Object) Integer.toString(i));
        } else if (i != 10) {
            return DToA.m6797a(i, d);
        } else {
            String a = FastDtoa.m6679a(d);
            if (a != null) {
                return a;
            }
            StringBuilder sb = new StringBuilder();
            DToA.m6800a(sb, 0, 0, d);
            return sb.toString();
        }
    }

    /* renamed from: a */
    static String m6354a(Context lVar, Scriptable drVar, Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj == Undefined.f6689a) {
            return "undefined";
        }
        if (obj instanceof CharSequence) {
            String a = m6348a(obj.toString(), (char) CoreConstants.DOUBLE_QUOTE_CHAR);
            StringBuffer stringBuffer = new StringBuffer(a.length() + 2);
            stringBuffer.append(CoreConstants.DOUBLE_QUOTE_CHAR);
            stringBuffer.append(a);
            stringBuffer.append(CoreConstants.DOUBLE_QUOTE_CHAR);
            return stringBuffer.toString();
        } else if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            if (doubleValue != 0.0d || 1.0d / doubleValue >= 0.0d) {
                return m6347a(doubleValue, 10);
            }
            return "-0";
        } else if (obj instanceof Boolean) {
            return m6436d(obj);
        } else {
            if (obj instanceof Scriptable) {
                Scriptable drVar2 = (Scriptable) obj;
                if (ScriptableObject.hasProperty(drVar2, "toSource")) {
                    Object property = ScriptableObject.getProperty(drVar2, "toSource");
                    if (property instanceof Function) {
                        return m6436d(((Function) property).call(lVar, drVar, drVar2, f6517x));
                    }
                }
                return m6436d(obj);
            }
            m6478s(obj);
            return obj.toString();
        }
    }

    /* renamed from: a */
    static String m6355a(Context lVar, Scriptable drVar, Scriptable drVar2) {
        boolean a;
        boolean z;
        Object obj;
        int i = 0;
        if (lVar.f6783g == null) {
            lVar.f6783g = new ObjToIntMap(31);
            z = true;
            a = false;
        } else {
            a = lVar.f6783g.mo18966a(drVar2);
            z = false;
        }
        StringBuffer stringBuffer = new StringBuffer(128);
        if (z) {
            stringBuffer.append("(");
        }
        stringBuffer.append(CoreConstants.CURLY_LEFT);
        if (!a) {
            try {
                lVar.f6783g.mo18967b(drVar2);
                Object[] ids = drVar2.getIds();
                while (true) {
                    int i2 = i;
                    if (i2 >= ids.length) {
                        break;
                    }
                    Object obj2 = ids[i2];
                    if (obj2 instanceof Integer) {
                        int intValue = ((Integer) obj2).intValue();
                        obj = drVar2.get(intValue, drVar2);
                        if (obj == Scriptable.f6533j) {
                            i = i2 + 1;
                        } else {
                            if (i2 > 0) {
                                stringBuffer.append(", ");
                            }
                            stringBuffer.append(intValue);
                        }
                    } else {
                        String str = (String) obj2;
                        Object obj3 = drVar2.get(str, drVar2);
                        if (obj3 == Scriptable.f6533j) {
                            i = i2 + 1;
                        } else {
                            if (i2 > 0) {
                                stringBuffer.append(", ");
                            }
                            if (m6459h(str)) {
                                stringBuffer.append(str);
                                obj = obj3;
                            } else {
                                stringBuffer.append(CoreConstants.SINGLE_QUOTE_CHAR);
                                stringBuffer.append(m6348a(str, (char) CoreConstants.SINGLE_QUOTE_CHAR));
                                stringBuffer.append(CoreConstants.SINGLE_QUOTE_CHAR);
                                obj = obj3;
                            }
                        }
                    }
                    stringBuffer.append(CoreConstants.COLON_CHAR);
//                    stringBuffer.append(m6354a(lVar, drVar, obj));
                    i = i2 + 1;
                }
            } catch (Throwable th) {
                if (z) {
                    lVar.f6783g = null;
                }
                throw th;
            }
        }
        if (z) {
            lVar.f6783g = null;
        }
        stringBuffer.append(CoreConstants.CURLY_RIGHT);
        if (z) {
            stringBuffer.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static Scriptable m6364a(Scriptable drVar, Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        return m6410b(Context.m6769k(), drVar, obj);
    }

    /* renamed from: a */
    public static Scriptable m6365a(Context lVar, Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        if (obj == null || obj == Undefined.f6689a) {
            return null;
        }
        return m6410b(lVar, m6438d(lVar), obj);
    }

    /* renamed from: a */
    public static Scriptable m6366a(Context lVar, Object obj, Scriptable drVar) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        if (obj == null || obj == Undefined.f6689a) {
            return null;
        }
        return m6410b(lVar, drVar, obj);
    }

    /* renamed from: b */
    public static Scriptable m6410b(Context lVar, Scriptable drVar, Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        if (obj instanceof CharSequence) {
            NativeString ckVar = new NativeString((CharSequence) obj);
            m6384a((ScriptableObject) ckVar, drVar, C2193eh.String);
            return ckVar;
        } else if (obj instanceof Number) {
            NativeNumber caVar = new NativeNumber(((Number) obj).doubleValue());
            m6384a((ScriptableObject) caVar, drVar, C2193eh.Number);
            return caVar;
        } else if (obj instanceof Boolean) {
            NativeBoolean bgVar = new NativeBoolean(((Boolean) obj).booleanValue());
            m6384a((ScriptableObject) bgVar, drVar, C2193eh.Boolean);
            return bgVar;
        } else if (obj == null) {
            throw m6455g("msg.null.to.object");
        } else if (obj == Undefined.f6689a) {
            throw m6455g("msg.undef.to.object");
        } else {
            Object a = lVar.mo19142g().mo19103a(drVar, obj, null);
            if (a instanceof Scriptable) {
                return (Scriptable) a;
            }
            throw m6401b("msg.invalid.type", obj);
        }
    }

    /* renamed from: a */
    public static Scriptable m6367a(Context lVar, Scriptable drVar, String str, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(drVar);
        Function a = m6357a(topLevelScope, str);
        if (objArr == null) {
            objArr = f6517x;
        }
        return a.construct(lVar, topLevelScope, objArr);
    }

    /* renamed from: e */
    public static double m6440e(Object obj) {
        return m6419c(m6395b(obj));
    }

    /* renamed from: c */
    public static double m6419c(double d) {
        if (d != d) {
            return 0.0d;
        }
        if (d == 0.0d || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY) {
            return d;
        }
        if (d > 0.0d) {
            return Math.floor(d);
        }
        return Math.ceil(d);
    }

    /* renamed from: b */
    public static double m6396b(Object[] objArr, int i) {
        if (i < objArr.length) {
            return m6419c(m6395b(objArr[i]));
        }
        return 0.0d;
    }

    /* renamed from: f */
    public static int m6446f(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return m6433d(m6395b(obj));
    }

    /* renamed from: c */
    public static int m6420c(Object[] objArr, int i) {
        if (i < objArr.length) {
            return m6446f(objArr[i]);
        }
        return 0;
    }

    /* renamed from: d */
    public static int m6433d(double d) {
        int i = (int) d;
        if (((double) i) == d) {
            return i;
        }
        if (d != d || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY) {
            return 0;
        }
        return (int) ((long) Math.IEEEremainder(d >= 0.0d ? Math.floor(d) : Math.ceil(d), 4.294967296E9d));
    }

    /* renamed from: e */
    public static long m6441e(double d) {
        long j = (long) d;
        if (((double) j) == d) {
            return j & 4294967295L;
        }
        if (d != d || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY) {
            return 0;
        }
        return ((long) Math.IEEEremainder(d >= 0.0d ? Math.floor(d) : Math.ceil(d), 4.294967296E9d)) & 4294967295L;
    }

    /* renamed from: g */
    public static long m6452g(Object obj) {
        return m6441e(m6395b(obj));
    }

    /* renamed from: h */
    public static char m6456h(Object obj) {
        double b = m6395b(obj);
        int i = (int) b;
        if (((double) i) == b) {
            return (char) i;
        }
        if (b != b || b == Double.POSITIVE_INFINITY || b == Double.NEGATIVE_INFINITY) {
            return 0;
        }
        return (char) ((int) Math.IEEEremainder(b >= 0.0d ? Math.floor(b) : Math.ceil(b), 65536.0d));
    }

    /* renamed from: b */
    public static Object m6400b(Context lVar) {
        Scriptable drVar = lVar.f6781e;
        if (drVar == null) {
            drVar = m6438d(lVar);
        }
        Object f = m6473n(lVar).mo19117f();
        if (!drVar.has("__default_namespace__", drVar)) {
            ScriptableObject.defineProperty(drVar, "__default_namespace__", f, 6);
        } else {
            drVar.put("__default_namespace__", drVar, f);
        }
        return Undefined.f6689a;
    }

    /* renamed from: a */
    static Function m6357a(Scriptable drVar, String str) {
        Object property = ScriptableObject.getProperty(drVar, str);
        if (property instanceof Function) {
            return (Function) property;
        }
        if (property == Scriptable.f6533j) {
            throw Context.m6755a("msg.ctor.not.found", (Object) str);
        }
        throw Context.m6755a("msg.not.ctor", (Object) str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005b, code lost:
        if (r4 <= (r6 ? 8 : 7)) goto L_0x005d;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long m6421c(String r11) {
        /*
            r2 = -1
            r9 = 9
            r8 = -214748364(0xfffffffff3333334, float:-1.4197688E31)
            r4 = 1
            r0 = 0
            int r7 = r11.length()
            if (r7 <= 0) goto L_0x006b
            char r1 = r11.charAt(r0)
            r5 = 45
            if (r1 != r5) goto L_0x006d
            if (r7 <= r4) goto L_0x006d
            char r1 = r11.charAt(r4)
            r5 = 48
            if (r1 != r5) goto L_0x0023
            r0 = r2
        L_0x0022:
            return r0
        L_0x0023:
            r6 = r4
            r5 = r4
        L_0x0025:
            int r4 = r1 + -48
            if (r4 < 0) goto L_0x006b
            if (r4 > r9) goto L_0x006b
            if (r6 == 0) goto L_0x004b
            r1 = 11
        L_0x002f:
            if (r7 > r1) goto L_0x006b
            int r1 = -r4
            int r5 = r5 + 1
            if (r1 == 0) goto L_0x004e
        L_0x0036:
            if (r5 == r7) goto L_0x004e
            char r4 = r11.charAt(r5)
            int r4 = r4 + -48
            if (r4 < 0) goto L_0x004e
            if (r4 > r9) goto L_0x004e
            int r0 = r1 * 10
            int r0 = r0 - r4
            int r5 = r5 + 1
            r10 = r1
            r1 = r0
            r0 = r10
            goto L_0x0036
        L_0x004b:
            r1 = 10
            goto L_0x002f
        L_0x004e:
            r10 = r0
            r0 = r1
            r1 = r10
            if (r5 != r7) goto L_0x006b
            if (r1 > r8) goto L_0x005d
            if (r1 != r8) goto L_0x006b
            if (r6 == 0) goto L_0x0067
            r1 = 8
        L_0x005b:
            if (r4 > r1) goto L_0x006b
        L_0x005d:
            r2 = 4294967295(0xffffffff, double:2.1219957905E-314)
            if (r6 == 0) goto L_0x0069
        L_0x0064:
            long r0 = (long) r0
            long r0 = r0 & r2
            goto L_0x0022
        L_0x0067:
            r1 = 7
            goto L_0x005b
        L_0x0069:
            int r0 = -r0
            goto L_0x0064
        L_0x006b:
            r0 = r2
            goto L_0x0022
        L_0x006d:
            r6 = r0
            r5 = r0
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.m6421c(java.lang.String):long");
    }

    /* renamed from: d */
    static Object m6435d(String str) {
        long c = m6421c(str);
        if (c >= 0) {
            return Integer.valueOf((int) c);
        }
        return str;
    }

    /* renamed from: f */
    static Object m6447f(double d) {
        int i = (int) d;
        if (((double) i) == d) {
            return Integer.valueOf(i);
        }
        return m6347a(d, 10);
    }

    /* renamed from: b */
    static String m6406b(Context lVar, Object obj) {
        String d;
        if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            int i = (int) doubleValue;
            if (((double) i) != doubleValue) {
                return m6436d(obj);
            }
            lVar.f6799w = i;
            return null;
        }
        if (obj instanceof String) {
            d = (String) obj;
        } else {
            d = m6436d(obj);
        }
        long c = m6421c(d);
        if (c < 0) {
            return d;
        }
        lVar.f6799w = (int) c;
        return null;
    }

    /* renamed from: a */
    public static Object m6320a(Object obj, Object obj2, Context lVar, Scriptable drVar) {
        Object property;
        Scriptable a = m6366a(lVar, obj, drVar);
        if (a == null) {
            throw m6453g(obj, obj2);
        }
        if (a instanceof XMLObject) {
            property = ((XMLObject) a).mo19120b();
        } else {
            String b = m6406b(lVar, obj2);
            property = b == null ? ScriptableObject.getProperty(a, lVar.f6799w) : ScriptableObject.getProperty(a, b);
        }
        return property == Scriptable.f6533j ? Undefined.f6689a : property;
    }

    /* renamed from: a */
    public static Object m6325a(Object obj, String str, Context lVar, Scriptable drVar) {
        Scriptable a = m6366a(lVar, obj, drVar);
        if (a != null) {
            return m6337a(a, str, lVar);
        }
        throw m6453g(obj, str);
    }

    /* renamed from: a */
    public static Object m6337a(Scriptable drVar, String str, Context lVar) {
        Object property = ScriptableObject.getProperty(drVar, str);
        if (property != Scriptable.f6533j) {
            return property;
        }
        if (lVar.mo19138b(11)) {
            Context.m6760a(m6349a("msg.ref.undefined.prop", (Object) str));
        }
        return Undefined.f6689a;
    }

    /* renamed from: a */
    public static Object m6323a(Object obj, String str, Context lVar) {
        Scriptable a = m6365a(lVar, obj);
        if (a == null) {
            throw m6453g(obj, str);
        }
        Object property = ScriptableObject.getProperty(a, str);
        if (property == Scriptable.f6533j) {
            return Undefined.f6689a;
        }
        return property;
    }

    /* renamed from: a */
    public static Object m6315a(Object obj, double d, Context lVar) {
        Scriptable a = m6365a(lVar, obj);
        if (a == null) {
            throw m6453g(obj, m6347a(d, 10));
        }
        int i = (int) d;
        if (((double) i) == d) {
            return m6331a(a, i);
        }
        return m6337a(a, m6347a(d, 10), lVar);
    }

    /* renamed from: a */
    public static Object m6331a(Scriptable drVar, int i) {
        Object property = ScriptableObject.getProperty(drVar, i);
        if (property == Scriptable.f6533j) {
            return Undefined.f6689a;
        }
        return property;
    }

    /* renamed from: a */
    public static Object m6318a(Object obj, Object obj2, Object obj3, Context lVar) {
        Scriptable a = m6365a(lVar, obj);
        if (a == null) {
            throw m6346a(obj, obj2, obj3);
        }
        if (a instanceof XMLObject) {
            ((XMLObject) a).mo19121c();
        } else {
            String b = m6406b(lVar, obj2);
            if (b == null) {
                ScriptableObject.putProperty(a, lVar.f6799w, obj3);
            } else {
                ScriptableObject.putProperty(a, b, obj3);
            }
        }
        return obj3;
    }

    /* renamed from: a */
    public static Object m6322a(Object obj, String str, Object obj2, Context lVar) {
        Scriptable a = m6365a(lVar, obj);
        if (a == null) {
            throw m6346a(obj, (Object) str, obj2);
        }
        ScriptableObject.putProperty(a, str, obj2);
        return obj2;
    }

    /* renamed from: a */
    public static Object m6335a(Scriptable drVar, String str, Object obj) {
        ScriptableObject.putProperty(drVar, str, obj);
        return obj;
    }

    /* renamed from: a */
    public static Object m6314a(Object obj, double d, Object obj2, Context lVar) {
        Scriptable a = m6365a(lVar, obj);
        if (a == null) {
            throw m6346a(obj, (Object) String.valueOf(d), obj2);
        }
        int i = (int) d;
        if (((double) i) == d) {
            ScriptableObject.putProperty(a, i, obj2);
        } else {
            ScriptableObject.putProperty(a, m6347a(d, 10), obj2);
        }
        return obj2;
    }

    /* renamed from: a */
    public static Object m6332a(Scriptable drVar, int i, Object obj) {
        ScriptableObject.putProperty(drVar, i, obj);
        return obj;
    }

    /* renamed from: a */
    public static boolean m6392a(Scriptable drVar, Object obj, Context lVar) {
        String b = m6406b(lVar, obj);
        if (b == null) {
            int i = lVar.f6799w;
            drVar.delete(i);
            if (!drVar.has(i, drVar)) {
                return true;
            }
            return false;
        }
        drVar.delete(b);
        if (drVar.has(b, drVar)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static Object m6329a(Ref ddVar, Context lVar) {
        return ddVar.mo18999a(lVar);
    }

    /* renamed from: a */
    public static Object m6328a(Ref ddVar, Object obj, Context lVar) {
        return ddVar.mo19000a(lVar, obj);
    }

    /* renamed from: b */
    public static Object m6398b(Ref ddVar, Context lVar) {
        return m6312a(ddVar.mo19001b(lVar));
    }

    /* renamed from: e */
    static boolean m6445e(String str) {
        return str.equals("__proto__") || str.equals("__parent__");
    }

    /* renamed from: b */
    public static Ref m6408b(Object obj, String str, Context lVar) {
        return SpecialRef.m6621a(lVar, obj, str);
    }

    /* renamed from: a */
    public static Object m6321a(Object obj, Object obj2, Context lVar, boolean z) {
        Scriptable a = m6365a(lVar, obj);
        if (a != null) {
            return m6312a(m6392a(a, obj2, lVar));
        }
        if (z) {
            return Boolean.TRUE;
        }
        throw m6376a("msg.undef.prop.delete", m6436d(obj), obj2 == null ? "null" : obj2.toString());
    }

    /* renamed from: a */
    public static Object m6342a(Context lVar, Scriptable drVar, String str) {
        Scriptable parentScope = drVar.getParentScope();
        if (parentScope != null) {
            return m6343a(lVar, drVar, parentScope, str, false);
        }
        Object c = m6424c(lVar, drVar, str);
        if (c != Scriptable.f6533j) {
            return c;
        }
        throw m6461i(str);
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [org.mozilla.javascript.dr] */
    /* JADX WARNING: type inference failed for: r7v0, types: [org.mozilla.javascript.dr] */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [org.mozilla.javascript.dr] */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r0v1, types: [org.mozilla.javascript.dr] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [org.mozilla.javascript.dr] */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r1v5, types: [org.mozilla.javascript.g.d, org.mozilla.javascript.dr] */
    /* JADX WARNING: type inference failed for: r0v9, types: [org.mozilla.javascript.dr] */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r0v14, types: [org.mozilla.javascript.dr] */
    /* JADX WARNING: type inference failed for: r0v16, types: [org.mozilla.javascript.dr] */
    /* JADX WARNING: type inference failed for: r0v17, types: [org.mozilla.javascript.g.d, org.mozilla.javascript.dr] */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        r7 = r0;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0049, code lost:
        r1 = r0;
        r0 = r7;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=org.mozilla.javascript.dr, code=null, for r6v0, types: [org.mozilla.javascript.dr] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=org.mozilla.javascript.dr, code=null, for r7v0, types: [org.mozilla.javascript.dr] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v18
  assigns: [?[OBJECT, ARRAY], org.mozilla.javascript.g.d, org.mozilla.javascript.dr]
  uses: [?[OBJECT, ARRAY], org.mozilla.javascript.g.d, org.mozilla.javascript.dr]
  mth insns count: 61
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0077 A[LOOP:0: B:1:0x0002->B:40:0x0077, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x002e A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 13 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Object m6343a(Context r5, Scriptable r6, Scriptable r7, String r8, boolean r9) {
        /*
            r1 = 0
            r0 = r6
        L_0x0002:
            boolean r2 = r0 instanceof org.mozilla.javascript.NativeWith
            if (r2 == 0) goto L_0x004c
            org.mozilla.javascript.dr r0 = r0.getPrototype()
            boolean r2 = r0 instanceof org.mozilla.javascript.p115g.XMLObject
            if (r2 == 0) goto L_0x003f
            org.mozilla.javascript.g.d r0 = (org.mozilla.javascript.p115g.XMLObject) r0
            boolean r2 = r0.has(r8, r0)
            if (r2 == 0) goto L_0x0025
            java.lang.Object r1 = r0.get(r8, r0)
        L_0x001a:
            if (r9 == 0) goto L_0x0071
            boolean r2 = r1 instanceof org.mozilla.javascript.Callable
            if (r2 != 0) goto L_0x006e
            java.lang.RuntimeException r0 = m6457h(r1, r8)
            throw r0
        L_0x0025:
            if (r1 != 0) goto L_0x0075
        L_0x0027:
            r1 = r0
        L_0x0028:
            org.mozilla.javascript.dr r0 = r7.getParentScope()
            if (r0 != 0) goto L_0x0077
            java.lang.Object r0 = m6424c(r5, r7, r8)
            java.lang.Object r2 = org.mozilla.javascript.Scriptable.f6533j
            if (r0 != r2) goto L_0x0049
            if (r1 == 0) goto L_0x003a
            if (r9 == 0) goto L_0x0069
        L_0x003a:
            java.lang.RuntimeException r0 = m6461i(r8)
            throw r0
        L_0x003f:
            java.lang.Object r2 = org.mozilla.javascript.ScriptableObject.getProperty(r0, r8)
            java.lang.Object r3 = org.mozilla.javascript.Scriptable.f6533j
            if (r2 == r3) goto L_0x0028
        L_0x0047:
            r7 = r0
            r0 = r2
        L_0x0049:
            r1 = r0
            r0 = r7
            goto L_0x001a
        L_0x004c:
            boolean r2 = r0 instanceof org.mozilla.javascript.NativeCall
            if (r2 == 0) goto L_0x0060
            java.lang.Object r2 = r0.get(r8, r0)
            java.lang.Object r0 = org.mozilla.javascript.Scriptable.f6533j
            if (r2 == r0) goto L_0x0028
            if (r9 == 0) goto L_0x0072
            org.mozilla.javascript.dr r0 = org.mozilla.javascript.ScriptableObject.getTopLevelScope(r7)
            r1 = r2
            goto L_0x001a
        L_0x0060:
            java.lang.Object r2 = org.mozilla.javascript.ScriptableObject.getProperty(r0, r8)
            java.lang.Object r3 = org.mozilla.javascript.Scriptable.f6533j
            if (r2 != r3) goto L_0x0047
            goto L_0x0028
        L_0x0069:
            java.lang.Object r0 = r1.get(r8, r1)
            goto L_0x0049
        L_0x006e:
            m6415b(r5, r0)
        L_0x0071:
            return r1
        L_0x0072:
            r0 = r6
            r1 = r2
            goto L_0x001a
        L_0x0075:
            r0 = r1
            goto L_0x0027
        L_0x0077:
            r4 = r0
            r0 = r7
            r7 = r4
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.m6343a(org.mozilla.javascript.l, org.mozilla.javascript.dr, org.mozilla.javascript.dr, java.lang.String, boolean):java.lang.Object");
    }

    /* renamed from: c */
    private static Object m6424c(Context lVar, Scriptable drVar, String str) {
        if (lVar.f6790n) {
            drVar = m6409b(lVar.f6779c, drVar);
        }
        return ScriptableObject.getProperty(drVar, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r1 == null) goto L_0x001f;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Scriptable m6411b(Context r4, Scriptable r5, String r6) {
        /*
            r1 = 0
            org.mozilla.javascript.dr r0 = r5.getParentScope()
            if (r0 == 0) goto L_0x0057
            r2 = r0
        L_0x0008:
            boolean r0 = r5 instanceof org.mozilla.javascript.NativeWith
            if (r0 == 0) goto L_0x0033
            org.mozilla.javascript.dr r0 = r5.getPrototype()
            boolean r3 = r0 instanceof org.mozilla.javascript.p115g.XMLObject
            if (r3 == 0) goto L_0x0029
            org.mozilla.javascript.g.d r0 = (org.mozilla.javascript.p115g.XMLObject) r0
            boolean r3 = r0.mo19119a()
            if (r3 == 0) goto L_0x001d
        L_0x001c:
            return r0
        L_0x001d:
            if (r1 != 0) goto L_0x002f
        L_0x001f:
            org.mozilla.javascript.dr r1 = r2.getParentScope()
            if (r1 == 0) goto L_0x0055
            r5 = r2
            r2 = r1
            r1 = r0
            goto L_0x0008
        L_0x0029:
            boolean r3 = org.mozilla.javascript.ScriptableObject.hasProperty(r0, r6)
            if (r3 != 0) goto L_0x001c
        L_0x002f:
            r0 = r1
            goto L_0x001f
        L_0x0031:
            r5 = r2
            r2 = r0
        L_0x0033:
            boolean r0 = org.mozilla.javascript.ScriptableObject.hasProperty(r5, r6)
            if (r0 == 0) goto L_0x003b
            r0 = r5
            goto L_0x001c
        L_0x003b:
            org.mozilla.javascript.dr r0 = r2.getParentScope()
            if (r0 != 0) goto L_0x0031
        L_0x0041:
            boolean r0 = r4.f6790n
            if (r0 == 0) goto L_0x004b
            org.mozilla.javascript.dr r0 = r4.f6779c
            org.mozilla.javascript.dr r2 = m6409b(r0, r2)
        L_0x004b:
            boolean r0 = org.mozilla.javascript.ScriptableObject.hasProperty(r2, r6)
            if (r0 == 0) goto L_0x0053
            r0 = r2
            goto L_0x001c
        L_0x0053:
            r0 = r1
            goto L_0x001c
        L_0x0055:
            r1 = r0
            goto L_0x0041
        L_0x0057:
            r2 = r5
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.m6411b(org.mozilla.javascript.l, org.mozilla.javascript.dr, java.lang.String):org.mozilla.javascript.dr");
    }

    /* renamed from: a */
    public static Object m6334a(Scriptable drVar, Object obj, Context lVar, Scriptable drVar2, String str) {
        if (drVar != null) {
            ScriptableObject.putProperty(drVar, str, obj);
        } else {
            if (lVar.mo19138b(11) || lVar.mo19138b(8)) {
                Context.m6760a(m6349a("msg.assn.create.strict", (Object) str));
            }
            Scriptable topLevelScope = ScriptableObject.getTopLevelScope(drVar2);
            if (lVar.f6790n) {
                topLevelScope = m6409b(lVar.f6779c, topLevelScope);
            }
            topLevelScope.put(str, topLevelScope, obj);
        }
        return obj;
    }

    /* renamed from: a */
    public static Object m6333a(Scriptable drVar, Object obj, String str) {
        if (drVar != null) {
            ScriptableObject.putProperty(drVar, str, obj);
            return obj;
        }
        throw m6375a("ReferenceError", "Assignment to undefined \"" + str + "\" in strict mode");
    }

    /* renamed from: b */
    public static Object m6399b(Scriptable drVar, Object obj, String str) {
        if (drVar instanceof XMLObject) {
            drVar.put(str, drVar, obj);
        } else {
            ScriptableObject.putConstProperty(drVar, str, obj);
        }
        return obj;
    }

    /* renamed from: a */
    public static Scriptable m6368a(Context lVar, Scriptable drVar, Scriptable drVar2, boolean z) {
        if (!ScriptableObject.hasProperty(drVar2, "__iterator__")) {
            return null;
        }
        Object property = ScriptableObject.getProperty(drVar2, "__iterator__");
        if (!(property instanceof Callable)) {
            throw m6455g("msg.invalid.iterator");
        }
        Callable eVar = (Callable) property;
        Object[] objArr = new Object[1];
        objArr[0] = z ? Boolean.TRUE : Boolean.FALSE;
        Object call = eVar.call(lVar, drVar, drVar2, objArr);
        if (call instanceof Scriptable) {
            return (Scriptable) call;
        }
        throw m6455g("msg.iterator.primitive");
    }

    /* renamed from: a */
    public static Object m6327a(Object obj, Context lVar, int i) {
        boolean z = false;
        C2176dn dnVar = new C2176dn((byte) 0);
        dnVar.f6520a = m6365a(lVar, obj);
        if (dnVar.f6520a == null) {
            return dnVar;
        }
        dnVar.f6525f = i;
        dnVar.f6527h = null;
        if (!(i == 3 || i == 4 || i == 5)) {
            Scriptable parentScope = dnVar.f6520a.getParentScope();
            Scriptable drVar = dnVar.f6520a;
            if (i == 0) {
                z = true;
            }
            dnVar.f6527h = m6368a(lVar, parentScope, drVar, z);
        }
        if (dnVar.f6527h == null) {
            m6381a(dnVar);
        }
        return dnVar;
    }

    /* renamed from: i */
    public static void m6463i(Object obj) {
        ((C2176dn) obj).f6526g = true;
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [java.lang.Integer] */
    /* JADX INFO: used method not loaded: org.mozilla.javascript.dr.has(java.lang.String, org.mozilla.javascript.dr):null, types can be incorrect */
    /* JADX INFO: used method not loaded: org.mozilla.javascript.dr.has(int, org.mozilla.javascript.dr):null, types can be incorrect */
    /* JADX WARNING: CFG modification limit reached, blocks count: 138 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        r0 = r5.f6521b;
        r1 = r5.f6522c;
        r5.f6522c = r1 + 1;
        r0 = r0[r1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        if (r5.f6523d == null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        if (r5.f6523d.mo18966a(r0) != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        if ((r0 instanceof java.lang.String) == false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006c, code lost:
        r0 = (java.lang.String) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        if (r5.f6520a.has(r0, r5.f6520a) == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        r5.f6524e = r0;
        r0 = java.lang.Boolean.TRUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007d, code lost:
        r0 = ((java.lang.Number) r0).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008b, code lost:
        if (r5.f6520a.has(r0, r5.f6520a) == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008f, code lost:
        if (r5.f6526g == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0091, code lost:
        r0 = java.lang.Integer.valueOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0096, code lost:
        r0 = java.lang.String.valueOf(r0);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Boolean m6464j(Object r5) {
        /*
            org.mozilla.javascript.dn r5 = (org.mozilla.javascript.C2176dn) r5
            org.mozilla.javascript.dr r0 = r5.f6527h
            if (r0 == 0) goto L_0x004b
            org.mozilla.javascript.dr r0 = r5.f6527h
            java.lang.String r1 = "next"
            java.lang.Object r0 = org.mozilla.javascript.ScriptableObject.getProperty(r0, r1)
            boolean r1 = r0 instanceof org.mozilla.javascript.Callable
            if (r1 != 0) goto L_0x0015
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
        L_0x0014:
            return r0
        L_0x0015:
            org.mozilla.javascript.e r0 = (org.mozilla.javascript.Callable) r0
            org.mozilla.javascript.l r1 = org.mozilla.javascript.Context.m6769k()
            org.mozilla.javascript.dr r2 = r5.f6527h     // Catch:{ aw -> 0x002e }
            org.mozilla.javascript.dr r2 = r2.getParentScope()     // Catch:{ aw -> 0x002e }
            org.mozilla.javascript.dr r3 = r5.f6527h     // Catch:{ aw -> 0x002e }
            java.lang.Object[] r4 = f6517x     // Catch:{ aw -> 0x002e }
            java.lang.Object r0 = r0.call(r1, r2, r3, r4)     // Catch:{ aw -> 0x002e }
            r5.f6524e = r0     // Catch:{ aw -> 0x002e }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ aw -> 0x002e }
            goto L_0x0014
        L_0x002e:
            r0 = move-exception
            java.lang.Object r1 = r0.f6090a
            boolean r1 = r1 instanceof org.mozilla.javascript.C2150bq
            if (r1 == 0) goto L_0x0038
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x0014
        L_0x0038:
            throw r0
        L_0x0039:
            int r0 = r5.f6522c
            java.lang.Object[] r1 = r5.f6521b
            int r1 = r1.length
            if (r0 != r1) goto L_0x0052
            org.mozilla.javascript.dr r0 = r5.f6520a
            org.mozilla.javascript.dr r0 = r0.getPrototype()
            r5.f6520a = r0
            m6381a(r5)
        L_0x004b:
            org.mozilla.javascript.dr r0 = r5.f6520a
            if (r0 != 0) goto L_0x0039
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x0014
        L_0x0052:
            java.lang.Object[] r0 = r5.f6521b
            int r1 = r5.f6522c
            int r2 = r1 + 1
            r5.f6522c = r2
            r0 = r0[r1]
            org.mozilla.javascript.cr r1 = r5.f6523d
            if (r1 == 0) goto L_0x0068
            org.mozilla.javascript.cr r1 = r5.f6523d
            boolean r1 = r1.mo18966a(r0)
            if (r1 != 0) goto L_0x004b
        L_0x0068:
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x007d
            java.lang.String r0 = (java.lang.String) r0
            org.mozilla.javascript.dr r1 = r5.f6520a
            org.mozilla.javascript.dr r2 = r5.f6520a
            boolean r1 = r1.has(r0, r2)
            if (r1 == 0) goto L_0x004b
        L_0x0078:
            r5.f6524e = r0
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            goto L_0x0014
        L_0x007d:
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            org.mozilla.javascript.dr r1 = r5.f6520a
            org.mozilla.javascript.dr r2 = r5.f6520a
            boolean r1 = r1.has(r0, r2)
            if (r1 == 0) goto L_0x004b
            boolean r1 = r5.f6526g
            if (r1 == 0) goto L_0x0096
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0078
        L_0x0096:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L_0x0078
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.m6464j(java.lang.Object):java.lang.Boolean");
    }

    /* renamed from: a */
    public static Object m6326a(Object obj, Context lVar) {
        C2176dn dnVar = (C2176dn) obj;
        if (dnVar.f6527h != null) {
            return dnVar.f6524e;
        }
        switch (dnVar.f6525f) {
            case 0:
            case 3:
                return dnVar.f6524e;
            case 1:
            case 4:
                return m6423c(obj, lVar);
            case 2:
            case 5:
                return Context.m6752a(ScriptableObject.getTopLevelScope(dnVar.f6520a), new Object[]{dnVar.f6524e, m6423c(obj, lVar)});
            default:
                throw Kit.m5810a();
        }
    }

    /* renamed from: c */
    private static Object m6423c(Object obj, Context lVar) {
        C2176dn dnVar = (C2176dn) obj;
        String b = m6406b(lVar, dnVar.f6524e);
        if (b != null) {
            return dnVar.f6520a.get(b, dnVar.f6520a);
        }
        return dnVar.f6520a.get(lVar.f6799w, dnVar.f6520a);
    }

    /* renamed from: a */
    private static void m6381a(C2176dn dnVar) {
        Object[] objArr = null;
        while (dnVar.f6520a != null) {
            objArr = dnVar.f6520a.getIds();
            if (objArr.length != 0) {
                break;
            }
            dnVar.f6520a = dnVar.f6520a.getPrototype();
        }
        if (!(dnVar.f6520a == null || dnVar.f6521b == null)) {
            Object[] objArr2 = dnVar.f6521b;
            int length = objArr2.length;
            if (dnVar.f6523d == null) {
                dnVar.f6523d = new ObjToIntMap(length);
            }
            for (int i = 0; i != length; i++) {
                dnVar.f6523d.mo18967b(objArr2[i]);
            }
        }
        dnVar.f6521b = objArr;
        dnVar.f6522c = 0;
    }

    /* renamed from: a */
    public static Callable m6374a(String str, Context lVar, Scriptable drVar) {
        Scriptable parentScope = drVar.getParentScope();
        if (parentScope != null) {
            return (Callable) m6343a(lVar, drVar, parentScope, str, true);
        }
        Object c = m6424c(lVar, drVar, str);
        if (c instanceof Callable) {
            m6415b(lVar, drVar);
            return (Callable) c;
        } else if (c == Scriptable.f6533j) {
            throw m6461i(str);
        } else {
            throw m6457h(c, str);
        }
    }

    /* renamed from: a */
    public static Callable m6373a(Object obj, Object obj2, Context lVar) {
        String b = m6406b(lVar, obj2);
        if (b != null) {
            return m6426c(obj, b, lVar);
        }
        int i = lVar.f6799w;
        Scriptable a = m6365a(lVar, obj);
        if (a == null) {
            throw m6460i(obj, String.valueOf(i));
        }
        Object property = ScriptableObject.getProperty(a, i);
        if (!(property instanceof Callable)) {
            throw m6457h(property, obj2);
        }
        m6415b(lVar, a);
        return (Callable) property;
    }

    /* renamed from: c */
    public static Callable m6426c(Object obj, String str, Context lVar) {
        return m6427c(obj, str, lVar, m6365a(lVar, obj));
    }

    /* renamed from: b */
    public static Callable m6412b(Object obj, String str, Context lVar, Scriptable drVar) {
        return m6427c(obj, str, lVar, m6366a(lVar, obj, drVar));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Callable m6427c(Object r5, String r6, Context r7, Scriptable r8) {
        /*
            if (r8 != 0) goto L_0x0007
            java.lang.RuntimeException r0 = m6460i(r5, r6)
            throw r0
        L_0x0007:
            java.lang.Object r1 = org.mozilla.javascript.ScriptableObject.getProperty(r8, r6)
            boolean r0 = r1 instanceof org.mozilla.javascript.Callable
            if (r0 != 0) goto L_0x006b
            java.lang.String r0 = "__noSuchMethod__"
            java.lang.Object r0 = org.mozilla.javascript.ScriptableObject.getProperty(r8, r0)
            boolean r2 = r0 instanceof org.mozilla.javascript.Callable
            if (r2 == 0) goto L_0x006b
            org.mozilla.javascript.dp r1 = new org.mozilla.javascript.dp
            org.mozilla.javascript.e r0 = (org.mozilla.javascript.Callable) r0
            r1.<init>(r0, r6)
            r0 = r1
        L_0x0021:
            boolean r1 = r0 instanceof org.mozilla.javascript.Callable
            if (r1 != 0) goto L_0x0065
            java.lang.String r1 = m6436d(r8)
            boolean r2 = r8 instanceof org.mozilla.javascript.NativeFunction
            if (r2 == 0) goto L_0x004f
            r2 = 123(0x7b, float:1.72E-43)
            int r2 = r1.indexOf(r2)
            if (r2 < 0) goto L_0x004f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 0
            int r2 = r2 + 1
            java.lang.String r1 = r1.substring(r4, r2)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r2 = "...}"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
        L_0x004f:
            java.lang.Object r2 = org.mozilla.javascript.Scriptable.f6533j
            if (r0 != r2) goto L_0x005a
            java.lang.String r0 = "msg.function.not.found.in"
            org.mozilla.javascript.w r0 = m6376a(r0, r6, r1)
        L_0x0059:
            throw r0
        L_0x005a:
            java.lang.String r2 = "msg.isnt.function.in"
            java.lang.String r0 = m6469l(r0)
            org.mozilla.javascript.w r0 = m6378a(r2, r6, r1, r0)
            goto L_0x0059
        L_0x0065:
            m6415b(r7, r8)
            org.mozilla.javascript.e r0 = (org.mozilla.javascript.Callable) r0
            return r0
        L_0x006b:
            r0 = r1
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.m6427c(java.lang.Object, java.lang.String, org.mozilla.javascript.l, org.mozilla.javascript.dr):org.mozilla.javascript.e");
    }

    /* renamed from: b */
    public static Callable m6413b(Object obj, Context lVar) {
        if (!(obj instanceof Callable)) {
            throw m6457h(obj, obj);
        }
        Callable eVar = (Callable) obj;
        Scriptable drVar = null;
        if (eVar instanceof Scriptable) {
            drVar = ((Scriptable) eVar).getParentScope();
        }
        if (drVar == null) {
            if (lVar.f6779c == null) {
                throw new IllegalStateException();
            }
            drVar = lVar.f6779c;
        }
        if (drVar.getParentScope() != null && !(drVar instanceof NativeWith) && (drVar instanceof NativeCall)) {
            drVar = ScriptableObject.getTopLevelScope(drVar);
        }
        m6415b(lVar, drVar);
        return eVar;
    }

    /* renamed from: a */
    public static Ref m6360a(Callable eVar) {
        if (eVar instanceof RefCallable) {
            RefCallable deVar = (RefCallable) eVar;
            Ref a = deVar.mo19002a();
            if (a != null) {
                return a;
            }
            throw new IllegalStateException(deVar.getClass().getName() + ".refCall() returned null");
        }
        throw m6375a("ReferenceError", m6349a("msg.no.ref.from.function", (Object) m6436d((Object) eVar)));
    }

    /* renamed from: a */
    public static Object m6344a(Context lVar, Callable eVar, Scriptable drVar, Object[] objArr, Scriptable drVar2, Scriptable drVar3, int i, String str, int i2) {
        if (i == 1) {
            if (drVar.getParentScope() == null && NativeGlobal.m6060a((Object) eVar)) {
                return m6341a(lVar, drVar2, (Object) drVar3, objArr, str, i2);
            }
        } else if (i != 2) {
            throw Kit.m5810a();
        } else if (NativeWith.m6109a((Object) eVar)) {
            throw Context.m6755a("msg.only.from.new", (Object) "With");
        }
        return eVar.call(lVar, drVar2, drVar, objArr);
    }

    /* renamed from: a */
    public static Object m6340a(Context lVar, Object obj, Object[] objArr, Scriptable drVar, int i) {
        if (i == 1) {
            if (NativeGlobal.m6060a(obj)) {
                throw m6414b("msg.not.ctor", "eval");
            }
        } else if (i != 2) {
            throw Kit.m5810a();
        } else if (NativeWith.m6109a(obj)) {
            return NativeWith.m6107a(lVar, drVar, objArr);
        }
        if (obj instanceof Function) {
            return ((Function) obj).construct(lVar, drVar, objArr);
        }
        throw m6457h(obj, obj);
    }

    /* renamed from: a */
    public static Object m6345a(boolean z, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        Scriptable drVar3;
        Object[] objArr2;
        int length = objArr.length;
        Callable c = m6428c(drVar2);
        Scriptable drVar4 = null;
        if (length != 0) {
            drVar4 = m6365a(lVar, objArr[0]);
        }
        if (drVar4 == null) {
            drVar3 = m6438d(lVar);
        } else {
            drVar3 = drVar4;
        }
        if (z) {
            if (length <= 1) {
                objArr2 = f6517x;
            } else {
                objArr2 = m6467k(objArr[1]);
            }
        } else if (length <= 1) {
            objArr2 = f6517x;
        } else {
            objArr2 = new Object[(length - 1)];
            System.arraycopy(objArr, 1, objArr2, 0, length - 1);
        }
        return c.call(lVar, drVar, drVar3, objArr2);
    }

    /* renamed from: k */
    static Object[] m6467k(Object obj) {
        if (obj == null || obj == Undefined.f6689a) {
            return f6517x;
        }
        if ((obj instanceof NativeArray) || (obj instanceof Arguments)) {
            return Context.m6764b((Scriptable) obj);
        }
        throw m6455g("msg.arg.isnt.array");
    }

    /* renamed from: c */
    static Callable m6428c(Scriptable drVar) {
        if (drVar instanceof Callable) {
            return (Callable) drVar;
        }
        Object defaultValue = drVar.getDefaultValue(f6509p);
        if (defaultValue instanceof Callable) {
            return (Callable) defaultValue;
        }
        throw m6457h(defaultValue, drVar);
    }

    /* renamed from: a */
    public static Object m6341a(Context lVar, Scriptable drVar, Object obj, Object[] objArr, String str, int i) {
        if (objArr.length <= 0) {
            return Undefined.f6689a;
        }
        Object obj2 = objArr[0];
        if (obj2 instanceof CharSequence) {
            if (str == null) {
                int[] iArr = new int[1];
                str = Context.m6748a(iArr);
                if (str != null) {
                    i = iArr[0];
                } else {
                    str = "";
                }
            }
            String a = m6356a(true, str, i);
            ErrorReporter a2 = DefaultErrorReporter.m6816a(lVar.mo19139d());
            Evaluator l = Context.m6770l();
            if (l == null) {
                throw new JavaScriptException("Interpreter not present", str, i);
            }
            Script a3 = lVar.mo19136a(obj2.toString(), l, a2, a, 1);
            l.mo18691a(a3);
            return ((Callable) a3).call(lVar, drVar, (Scriptable) obj, f6517x);
        } else if (lVar.mo19138b(11) || lVar.mo19138b(9)) {
            throw Context.m6763b("msg.eval.nonstring.strict");
        } else {
            Context.m6760a(m6353a("msg.eval.nonstring", (Object[]) null));
            return obj2;
        }
    }

    /* renamed from: l */
    public static String m6469l(Object obj) {
        if (obj == null) {
            return "object";
        }
        if (obj == Undefined.f6689a) {
            return "undefined";
        }
        if (obj instanceof ScriptableObject) {
            return ((ScriptableObject) obj).getTypeOf();
        }
        if (obj instanceof Scriptable) {
            return obj instanceof Callable ? "function" : "object";
        }
        if (obj instanceof CharSequence) {
            return "string";
        }
        if (obj instanceof Number) {
            return "number";
        }
        if (obj instanceof Boolean) {
            return "boolean";
        }
        throw m6401b("msg.invalid.type", obj);
    }

    /* renamed from: b */
    public static String m6405b(Scriptable drVar, String str) {
        Context k = Context.m6769k();
        Scriptable b = m6411b(k, drVar, str);
        if (b == null) {
            return "undefined";
        }
        return m6469l(m6337a(b, str, k));
    }

    /* renamed from: a */
    public static Object m6317a(Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            return m6313a(((Number) obj).doubleValue() + ((Number) obj2).doubleValue());
        }
        if (obj instanceof XMLObject) {
            Object h = XMLObject.m6695h();
            if (h != Scriptable.f6533j) {
                return h;
            }
        }
        if (obj2 instanceof XMLObject) {
            Object h2 = XMLObject.m6695h();
            if (h2 != Scriptable.f6533j) {
                return h2;
            }
        }
        if (obj instanceof Scriptable) {
            obj3 = ((Scriptable) obj).getDefaultValue(null);
        } else {
            obj3 = obj;
        }
        if (obj2 instanceof Scriptable) {
            obj4 = ((Scriptable) obj2).getDefaultValue(null);
        } else {
            obj4 = obj2;
        }
        if ((obj3 instanceof CharSequence) || (obj4 instanceof CharSequence)) {
            return new ConsString(m6422c(obj3), m6422c(obj4));
        }
        if (!(obj3 instanceof Number) || !(obj4 instanceof Number)) {
            return m6313a(m6395b(obj4) + m6395b(obj3));
        }
        return m6313a(((Number) obj4).doubleValue() + ((Number) obj3).doubleValue());
    }

    /* renamed from: a */
    public static Object m6338a(Scriptable drVar, String str, Context lVar, int i) {
        do {
            if (lVar.f6790n && drVar.getParentScope() == null) {
                drVar = m6409b(lVar.f6779c, drVar);
            }
            Scriptable drVar2 = drVar;
            do {
                if ((drVar2 instanceof NativeWith) && (drVar2.getPrototype() instanceof XMLObject)) {
                    break;
                }
                Object obj = drVar2.get(str, drVar);
                if (obj != Scriptable.f6533j) {
                    return m6336a(drVar2, str, drVar, obj, i);
                }
                drVar2 = drVar2.getPrototype();
            } while (drVar2 != null);
            drVar = drVar.getParentScope();
        } while (drVar != null);
        throw m6461i(str);
    }

    /* renamed from: a */
    public static Object m6324a(Object obj, String str, Context lVar, int i) {
        Scriptable a = m6365a(lVar, obj);
        if (a == null) {
            throw m6453g(obj, str);
        }
        Scriptable drVar = a;
        do {
            Object obj2 = drVar.get(str, a);
            if (obj2 != Scriptable.f6533j) {
                return m6336a(drVar, str, a, obj2, i);
            }
            drVar = drVar.getPrototype();
        } while (drVar != null);
        a.put(str, a, (Object) f6515v);
        return f6515v;
    }

    /* renamed from: a */
    private static Object m6336a(Scriptable drVar, String str, Scriptable drVar2, Object obj, int i) {
        double b;
        Object obj2;
        double d;
        boolean z = (i & 2) != 0;
        if (obj instanceof Number) {
            b = ((Number) obj).doubleValue();
            obj2 = obj;
        } else {
            b = m6395b(obj);
            if (z) {
                obj2 = m6313a(b);
            } else {
                obj2 = obj;
            }
        }
        if ((i & 1) == 0) {
            d = b + 1.0d;
        } else {
            d = b - 1.0d;
        }
        Number a = m6313a(d);
        drVar.put(str, drVar2, (Object) a);
        if (z) {
            return obj2;
        }
        return a;
    }

    /* renamed from: a */
    public static Object m6319a(Object obj, Object obj2, Context lVar, int i) {
        Object obj3;
        double d;
        double d2;
        Object a = m6320a(obj, obj2, lVar, m6438d(lVar));
        boolean z = (i & 2) != 0;
        if (a instanceof Number) {
            obj3 = a;
            d = ((Number) a).doubleValue();
        } else {
            double b = m6395b(a);
            if (z) {
                obj3 = m6313a(b);
                d = b;
            } else {
                obj3 = a;
                d = b;
            }
        }
        if ((i & 1) == 0) {
            d2 = d + 1.0d;
        } else {
            d2 = d - 1.0d;
        }
        Number a2 = m6313a(d2);
        m6318a(obj, obj2, (Object) a2, lVar);
        if (z) {
            return obj3;
        }
        return a2;
    }

    /* renamed from: a */
    public static Object m6330a(Ref ddVar, Context lVar, int i) {
        Object obj;
        double d;
        double d2;
        Object a = ddVar.mo18999a(lVar);
        boolean z = (i & 2) != 0;
        if (a instanceof Number) {
            obj = a;
            d = ((Number) a).doubleValue();
        } else {
            double b = m6395b(a);
            if (z) {
                obj = m6313a(b);
                d = b;
            } else {
                obj = a;
                d = b;
            }
        }
        if ((i & 1) == 0) {
            d2 = d + 1.0d;
        } else {
            d2 = d - 1.0d;
        }
        Number a2 = m6313a(d2);
        ddVar.mo19000a(lVar, a2);
        if (z) {
            return obj;
        }
        return a2;
    }

    /* renamed from: a */
    public static Object m6316a(Object obj, Class<?> cls) {
        if (obj instanceof Scriptable) {
            obj = ((Scriptable) obj).getDefaultValue(cls);
            if (obj instanceof Scriptable) {
                throw m6455g("msg.bad.default.value");
            }
        }
        return obj;
    }

    /* renamed from: b */
    public static boolean m6417b(Object obj, Object obj2) {
        double d = 1.0d;
        if (obj == null || obj == Undefined.f6689a) {
            if (obj2 == null || obj2 == Undefined.f6689a) {
                return true;
            }
            if (obj2 instanceof ScriptableObject) {
                Object equivalentValues = ((ScriptableObject) obj2).equivalentValues(obj);
                if (equivalentValues != Scriptable.f6533j) {
                    return ((Boolean) equivalentValues).booleanValue();
                }
            }
            return false;
        } else if (obj instanceof Number) {
            return m6388a(((Number) obj).doubleValue(), obj2);
        } else {
            if (obj == obj2) {
                return true;
            }
            if (obj instanceof CharSequence) {
                return m6390a((CharSequence) obj, obj2);
            }
            if (obj instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                if (obj2 instanceof Boolean) {
                    return booleanValue == ((Boolean) obj2).booleanValue();
                }
                if (obj2 instanceof ScriptableObject) {
                    Object equivalentValues2 = ((ScriptableObject) obj2).equivalentValues(obj);
                    if (equivalentValues2 != Scriptable.f6533j) {
                        return ((Boolean) equivalentValues2).booleanValue();
                    }
                }
                return m6388a(booleanValue ? 1.0d : 0.0d, obj2);
            } else if (!(obj instanceof Scriptable)) {
                m6478s(obj);
                return obj == obj2;
            } else if (obj2 instanceof Scriptable) {
                if (obj instanceof ScriptableObject) {
                    Object equivalentValues3 = ((ScriptableObject) obj).equivalentValues(obj2);
                    if (equivalentValues3 != Scriptable.f6533j) {
                        return ((Boolean) equivalentValues3).booleanValue();
                    }
                }
                if (obj2 instanceof ScriptableObject) {
                    Object equivalentValues4 = ((ScriptableObject) obj2).equivalentValues(obj);
                    if (equivalentValues4 != Scriptable.f6533j) {
                        return ((Boolean) equivalentValues4).booleanValue();
                    }
                }
                if (!(obj instanceof Wrapper) || !(obj2 instanceof Wrapper)) {
                    return false;
                }
                Object a = ((Wrapper) obj).mo18879a();
                Object a2 = ((Wrapper) obj2).mo18879a();
                return a == a2 || (m6471m(a) && m6471m(a2) && m6417b(a, a2));
            } else if (obj2 instanceof Boolean) {
                if (obj instanceof ScriptableObject) {
                    Object equivalentValues5 = ((ScriptableObject) obj).equivalentValues(obj2);
                    if (equivalentValues5 != Scriptable.f6533j) {
                        return ((Boolean) equivalentValues5).booleanValue();
                    }
                }
                if (!((Boolean) obj2).booleanValue()) {
                    d = 0.0d;
                }
                return m6388a(d, obj);
            } else if (obj2 instanceof Number) {
                return m6388a(((Number) obj2).doubleValue(), obj);
            } else {
                if (obj2 instanceof CharSequence) {
                    return m6390a((CharSequence) obj2, obj);
                }
                return false;
            }
        }
    }

    /* renamed from: m */
    public static boolean m6471m(Object obj) {
        return obj == null || obj == Undefined.f6689a || (obj instanceof Number) || (obj instanceof String) || (obj instanceof Boolean);
    }

    /* renamed from: a */
    static boolean m6388a(double d, Object obj) {
        Object obj2 = obj;
        while (obj2 != null && obj2 != Undefined.f6689a) {
            if (obj2 instanceof Number) {
                return d == ((Number) obj2).doubleValue();
            }
            if (obj2 instanceof CharSequence) {
                return d == m6395b(obj2);
            }
            if (obj2 instanceof Boolean) {
                return d == (((Boolean) obj2).booleanValue() ? 1.0d : 0.0d);
            } else if (obj2 instanceof Scriptable) {
                if (obj2 instanceof ScriptableObject) {
                    Object equivalentValues = ((ScriptableObject) obj2).equivalentValues(m6313a(d));
                    if (equivalentValues != Scriptable.f6533j) {
                        return ((Boolean) equivalentValues).booleanValue();
                    }
                }
                obj2 = m6316a(obj2, null);
            } else {
                m6478s(obj2);
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m6390a(CharSequence charSequence, Object obj) {
        Object obj2 = obj;
        while (obj2 != null && obj2 != Undefined.f6689a) {
            if (obj2 instanceof CharSequence) {
                CharSequence charSequence2 = (CharSequence) obj2;
                return charSequence.length() == charSequence2.length() && charSequence.toString().equals(charSequence2.toString());
            } else if (obj2 instanceof Number) {
                return m6309a(charSequence.toString()) == ((Number) obj2).doubleValue();
            } else {
                if (obj2 instanceof Boolean) {
                    return m6309a(charSequence.toString()) == (((Boolean) obj2).booleanValue() ? 1.0d : 0.0d);
                } else if (obj2 instanceof Scriptable) {
                    if (obj2 instanceof ScriptableObject) {
                        Object equivalentValues = ((ScriptableObject) obj2).equivalentValues(charSequence.toString());
                        if (equivalentValues != Scriptable.f6533j) {
                            return ((Boolean) equivalentValues).booleanValue();
                        }
                    }
                    obj2 = m6316a(obj2, null);
                } else {
                    m6478s(obj2);
                    return false;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m6430c(Object obj, Object obj2) {
        if (obj == obj2) {
            if (!(obj instanceof Number)) {
                return true;
            }
            double doubleValue = ((Number) obj).doubleValue();
            if (doubleValue != doubleValue) {
                return false;
            }
            return true;
        } else if (obj == null || obj == Undefined.f6689a) {
            return false;
        } else {
            if (obj instanceof Number) {
                if (obj2 instanceof Number) {
                    if (((Number) obj).doubleValue() != ((Number) obj2).doubleValue()) {
                        return false;
                    }
                    return true;
                }
            } else if (obj instanceof CharSequence) {
                if (obj2 instanceof CharSequence) {
                    return obj.toString().equals(obj2.toString());
                }
            } else if (obj instanceof Boolean) {
                if (obj2 instanceof Boolean) {
                    return obj.equals(obj2);
                }
            } else if (!(obj instanceof Scriptable)) {
                m6478s(obj);
                if (obj != obj2) {
                    return false;
                }
                return true;
            } else if ((obj instanceof Wrapper) && (obj2 instanceof Wrapper)) {
                if (((Wrapper) obj).mo18879a() != ((Wrapper) obj2).mo18879a()) {
                    return false;
                }
                return true;
            }
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m6439d(Object obj, Object obj2) {
        if (!(obj2 instanceof Scriptable)) {
            throw m6455g("msg.instanceof.not.object");
        } else if (!(obj instanceof Scriptable)) {
            return false;
        } else {
            return ((Scriptable) obj2).hasInstance((Scriptable) obj);
        }
    }

    /* renamed from: a */
    public static boolean m6393a(Scriptable drVar, Scriptable drVar2) {
        for (Scriptable prototype = drVar.getPrototype(); prototype != null; prototype = prototype.getPrototype()) {
            if (prototype.equals(drVar2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m6418b(Object obj, Object obj2, Context lVar) {
        if (!(obj2 instanceof Scriptable)) {
            throw m6455g("msg.in.not.object");
        }
        Scriptable drVar = (Scriptable) obj2;
        String b = m6406b(lVar, obj);
        return b == null ? ScriptableObject.hasProperty(drVar, lVar.f6799w) : ScriptableObject.hasProperty(drVar, b);
    }

    /* renamed from: e */
    public static boolean m6444e(Object obj, Object obj2) {
        double b;
        double b2;
        if (!(obj instanceof Number) || !(obj2 instanceof Number)) {
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(f6502i);
            }
            if (obj2 instanceof Scriptable) {
                obj2 = ((Scriptable) obj2).getDefaultValue(f6502i);
            }
            if (!(obj instanceof CharSequence) || !(obj2 instanceof CharSequence)) {
                b = m6395b(obj);
                b2 = m6395b(obj2);
            } else if (obj.toString().compareTo(obj2.toString()) >= 0) {
                return false;
            } else {
                return true;
            }
        } else {
            b = ((Number) obj).doubleValue();
            b2 = ((Number) obj2).doubleValue();
        }
        if (b < b2) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public static boolean m6450f(Object obj, Object obj2) {
        double b;
        double b2;
        if (!(obj instanceof Number) || !(obj2 instanceof Number)) {
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(f6502i);
            }
            if (obj2 instanceof Scriptable) {
                obj2 = ((Scriptable) obj2).getDefaultValue(f6502i);
            }
            if (!(obj instanceof CharSequence) || !(obj2 instanceof CharSequence)) {
                b = m6395b(obj);
                b2 = m6395b(obj2);
            } else if (obj.toString().compareTo(obj2.toString()) > 0) {
                return false;
            } else {
                return true;
            }
        } else {
            b = ((Number) obj).doubleValue();
            b2 = ((Number) obj2).doubleValue();
        }
        if (b <= b2) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m6431c(Context lVar) {
        return lVar.f6779c != null;
    }

    /* renamed from: d */
    public static Scriptable m6438d(Context lVar) {
        Scriptable drVar = lVar.f6779c;
        if (drVar != null) {
            return drVar;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public static Object m6339a(Callable eVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        NativeCall bhVar = null;
        if (drVar == null) {
            throw new IllegalArgumentException();
        } else if (lVar.f6779c != null) {
            throw new IllegalStateException();
        } else {
            lVar.f6779c = ScriptableObject.getTopLevelScope(drVar);
            lVar.f6790n = lVar.mo19138b(7);
            ContextFactory oVar = lVar.f6778b;
            try {
                if (bhVar == null) {
                    return ContextFactory.m6786a(eVar, lVar, drVar, drVar2, objArr);
                }
                throw new IllegalStateException();
            } finally {
                lVar.f6779c = null;
                lVar.f6782f = null;
                if (lVar.f6781e != null) {
                    throw new IllegalStateException();
                }
            }
        }
    }

    /* renamed from: b */
    private static Scriptable m6409b(Scriptable drVar, Scriptable drVar2) {
        if (drVar == drVar2) {
            return drVar;
        }
        Scriptable drVar3 = drVar;
        do {
            drVar3 = drVar3.getPrototype();
            if (drVar3 == drVar2) {
                return drVar;
            }
        } while (drVar3 != null);
        return drVar2;
    }

    /* renamed from: a */
    public static void m6380a(NativeFunction blVar, Context lVar, Scriptable drVar, boolean z) {
        if (lVar.f6779c == null) {
            throw new IllegalStateException();
        }
        int d = blVar.mo18684d();
        if (d != 0) {
            Scriptable drVar2 = drVar;
            while (drVar2 instanceof NativeWith) {
                drVar2 = drVar2.getParentScope();
            }
            while (true) {
                int i = d - 1;
                if (d != 0) {
                    String a = blVar.mo18680a(i);
                    boolean b = blVar.mo18682b(i);
                    if (ScriptableObject.hasProperty(drVar, a)) {
                        ScriptableObject.redefineProperty(drVar, a, b);
                        d = i;
                    } else if (z) {
                        drVar2.put(a, drVar2, Undefined.f6689a);
                        d = i;
                    } else if (b) {
                        ScriptableObject.defineConstProperty(drVar2, a);
                        d = i;
                    } else {
                        ScriptableObject.defineProperty(drVar2, a, Undefined.f6689a, 4);
                        d = i;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public static Scriptable m6363a(NativeFunction blVar, Scriptable drVar, Object[] objArr) {
        return new NativeCall(blVar, drVar, objArr);
    }

    /* renamed from: a */
    public static void m6387a(Context lVar, Scriptable drVar) {
        if (lVar.f6779c == null) {
            throw new IllegalStateException();
        }
        NativeCall bhVar = (NativeCall) drVar;
        bhVar.f6303c = lVar.f6781e;
        lVar.f6781e = bhVar;
    }

    /* renamed from: e */
    public static void m6443e(Context lVar) {
        NativeCall bhVar = lVar.f6781e;
        lVar.f6781e = bhVar.f6303c;
        bhVar.f6303c = null;
    }

    /* renamed from: a */
    static NativeCall m6359a(Context lVar, Function abVar) {
        for (NativeCall bhVar = lVar.f6781e; bhVar != null; bhVar = bhVar.f6303c) {
            if (bhVar.f6301a == abVar) {
                return bhVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Scriptable m6362a(Throwable th, Scriptable drVar, String str, Context lVar, Scriptable drVar2) {
        String th2;
        String str2;
        RhinoException dhVar;
        Throwable th3;
        Object[] objArr;
        boolean z;
        Object obj;
        if (th instanceof JavaScriptException) {
            obj = ((JavaScriptException) th).f6090a;
            z = false;
        } else if (drVar != null) {
            Object associatedValue = ((NativeObject) drVar).getAssociatedValue(th);
            if (associatedValue == 0) {
                Kit.m5810a();
                z = true;
                obj = associatedValue;
            } else {
                z = true;
                obj = associatedValue;
            }
        } else {
            if (th instanceof EcmaError) {
                EcmaError wVar = (EcmaError) th;
                str2 = wVar.f6830a;
                dhVar = wVar;
                th2 = wVar.f6831b;
                th3 = null;
            } else if (th instanceof WrappedException) {
                WrappedException enVar = (WrappedException) th;
                Throwable th4 = enVar.f6696a;
                str2 = "JavaException";
                dhVar = enVar;
                th2 = th4.getClass().getName() + ": " + th4.getMessage();
                th3 = th4;
            } else if (th instanceof EvaluatorException) {
                EvaluatorException zVar = (EvaluatorException) th;
                str2 = "InternalError";
                dhVar = zVar;
                th2 = zVar.getMessage();
                th3 = null;
            } else if (lVar.mo19138b(13)) {
                RhinoException enVar2 = new WrappedException(th);
                th2 = th.toString();
                str2 = "JavaException";
                dhVar = enVar2;
                th3 = null;
            } else {
                throw Kit.m5810a();
            }
            String str3 = dhVar.f6488d;
            if (str3 == null) {
                str3 = "";
            }
            int i = dhVar.f6489e;
            if (i > 0) {
                objArr = new Object[]{th2, str3, Integer.valueOf(i)};
            } else {
                objArr = new Object[]{th2, str3};
            }
            Scriptable topLevelScope = ScriptableObject.getTopLevelScope(drVar2);
            Scriptable construct = m6357a(topLevelScope, str2).construct(lVar, topLevelScope, objArr);
            ScriptableObject.putProperty(construct, "name", (Object) str2);
            if (construct instanceof NativeError) {
                ((NativeError) construct).mo18877a(dhVar);
            }
            if (th3 != null && m6432c(lVar, (Object) th3)) {
                ScriptableObject.defineProperty(construct, "javaException", lVar.mo19142g().mo19103a(drVar2, th3, null), 5);
            }
            if (m6432c(lVar, (Object) dhVar)) {
                ScriptableObject.defineProperty(construct, "rhinoException", lVar.mo19142g().mo19103a(drVar2, dhVar, null), 5);
            }
            z = true;
            obj = construct;
        }
        NativeObject cbVar = new NativeObject();
        cbVar.defineProperty(str, obj, 4);
        if (m6432c(lVar, (Object) th)) {
            cbVar.defineProperty("__exception__", Context.m6761b(th, drVar2), 6);
        }
        if (z) {
            cbVar.associateValue(th, obj);
        }
        return cbVar;
    }

    /* renamed from: c */
    private static boolean m6432c(Context lVar, Object obj) {
        ClassShutter f = lVar.mo19141f();
        if (f != null) {
            obj.getClass().getName();
            if (!f.mo19111a()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static Scriptable m6361a(Object obj, Context lVar, Scriptable drVar) {
        Scriptable a = m6365a(lVar, obj);
        if (a == null) {
            throw m6414b("msg.undef.with", m6436d(obj));
        } else if (a instanceof XMLObject) {
            return ((XMLObject) a).mo19124f();
        } else {
            return new NativeWith(drVar, a);
        }
    }

    /* renamed from: d */
    public static Scriptable m6437d(Scriptable drVar) {
        return ((NativeWith) drVar).getParentScope();
    }

    /* renamed from: n */
    public static Scriptable m6472n(Object obj) {
        if (obj instanceof XMLObject) {
            return ((XMLObject) obj).mo19125g();
        }
        throw m6477r(obj);
    }

    /* renamed from: b */
    public static Object m6397b() {
        return NativeWith.m6106a();
    }

    /* renamed from: e */
    public static Scriptable m6442e(Scriptable drVar) {
        return ((NativeWith) drVar).getParentScope();
    }

    /* renamed from: a */
    public static void m6379a(BaseFunction bVar, Scriptable drVar) {
        bVar.setParentScope(drVar);
        bVar.setPrototype(ScriptableObject.getFunctionPrototype(drVar));
    }

    /* renamed from: a */
    public static void m6383a(ScriptableObject dsVar, Scriptable drVar) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(drVar);
        dsVar.setParentScope(topLevelScope);
        dsVar.setPrototype(ScriptableObject.getClassPrototype(topLevelScope, dsVar.getClassName()));
    }

    /* renamed from: a */
    public static void m6384a(ScriptableObject dsVar, Scriptable drVar, C2193eh ehVar) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(drVar);
        dsVar.setParentScope(topLevelScope);
        dsVar.setPrototype(TopLevel.m6647a(topLevelScope, ehVar));
    }

    /* renamed from: a */
    public static void m6382a(Scriptable drVar, NativeFunction blVar, int i, boolean z) {
        if (i == 1) {
            String functionName = blVar.getFunctionName();
            if (functionName != null && functionName.length() != 0) {
                if (!z) {
                    ScriptableObject.defineProperty(drVar, functionName, blVar, 4);
                } else {
                    drVar.put(functionName, drVar, (Object) blVar);
                }
            }
        } else if (i == 3) {
            String functionName2 = blVar.getFunctionName();
            if (functionName2 != null && functionName2.length() != 0) {
                while (drVar instanceof NativeWith) {
                    drVar = drVar.getParentScope();
                }
                drVar.put(functionName2, drVar, (Object) blVar);
            }
        } else {
            throw Kit.m5810a();
        }
    }

    /* renamed from: a */
    public static Scriptable m6369a(Object[] objArr, int[] iArr, Scriptable drVar) {
        int i;
        int i2 = 0;
        int length = objArr.length;
        if (iArr != null) {
            i = iArr.length;
        } else {
            i = 0;
        }
        int i3 = length + i;
        if (i3 <= 1 || i * 2 >= i3) {
            Scriptable a = Context.m6751a(drVar, i3);
            int i4 = 0;
            for (int i5 = 0; i5 != i3; i5++) {
                if (i4 == i || iArr[i4] != i5) {
                    ScriptableObject.putProperty(a, i5, objArr[i2]);
                    i2++;
                } else {
                    i4++;
                }
            }
            return a;
        }
        if (i != 0) {
            Object[] objArr2 = new Object[i3];
            int i6 = 0;
            for (int i7 = 0; i7 != i3; i7++) {
                if (i6 == i || iArr[i6] != i7) {
                    objArr2[i7] = objArr[i2];
                    i2++;
                } else {
                    objArr2[i7] = Scriptable.f6533j;
                    i6++;
                }
            }
            objArr = objArr2;
        }
        return Context.m6752a(drVar, objArr);
    }

    /* renamed from: a */
    public static Scriptable m6370a(Object[] objArr, Object[] objArr2, int[] iArr, Context lVar, Scriptable drVar) {
        boolean z;
        Scriptable a = Context.m6750a(drVar);
        int length = objArr.length;
        int i = 0;
//        while (i != length) {
//            String str = objArr[i];
//            int i2 = iArr == null ? 0 : iArr[i];
//            Callable eVar = objArr2[i];
//            if (!(str instanceof String)) {
//                a.put(((Integer) str).intValue(), a, (Object) eVar);
//            } else if (i2 != 0) {
//                ScriptableObject dsVar = (ScriptableObject) a;
//                Callable eVar2 = eVar;
//                if (i2 == 1) {
//                    z = true;
//                } else {
//                    z = false;
//                }
//                dsVar.setGetterOrSetter(str, 0, eVar2, z);
//            } else if (m6445e(str)) {
//                SpecialRef.m6621a(lVar, a, str).mo19000a(lVar, eVar);
//            } else {
//                a.put(str, a, (Object) eVar);
//            }
//            i++;
//        }
        return a;
    }

    /* renamed from: f */
    public static Object[] m6451f(Scriptable drVar) {
        long a = NativeArray.m5979a(Context.m6769k(), drVar);
        if (a > 2147483647L) {
            throw new IllegalArgumentException();
        }
        int i = (int) a;
        if (i == 0) {
            return f6517x;
        }
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            Object property = ScriptableObject.getProperty(drVar, i2);
            if (property == Scriptable.f6533j) {
                property = Undefined.f6689a;
            }
            objArr[i2] = property;
        }
        return objArr;
    }

    /* renamed from: a */
    static void m6385a(Context lVar, String str) {
        int i = lVar.f6785i;
        if (i >= 140 || i == 0) {
            String a = m6349a("msg.deprec.ctor", (Object) str);
            if (i == 0) {
                Context.m6760a(a);
                return;
            }
            throw Context.m6765c(a);
        }
    }

    /* renamed from: f */
    public static String m6448f(String str) {
        return m6353a(str, (Object[]) null);
    }

    /* renamed from: a */
    public static String m6349a(String str, Object obj) {
        return m6353a(str, new Object[]{obj});
    }

    /* renamed from: a */
    public static String m6350a(String str, Object obj, Object obj2) {
        return m6353a(str, new Object[]{obj, obj2});
    }

    /* renamed from: a */
    public static String m6351a(String str, Object obj, Object obj2, Object obj3) {
        return m6353a(str, new Object[]{obj, obj2, obj3});
    }

    /* renamed from: a */
    public static String m6352a(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return m6353a(str, new Object[]{obj, obj2, obj3, obj4});
    }

    /* renamed from: a */
    private static String m6353a(String str, Object[] objArr) {
        return f6516w.mo19019a(str, objArr);
    }

    /* renamed from: a */
    public static EcmaError m6375a(String str, String str2) {
        int[] iArr = new int[1];
        return m6377a(str, str2, Context.m6748a(iArr), iArr[0], (String) null, 0);
    }

    /* renamed from: a */
    public static EcmaError m6377a(String str, String str2, String str3, int i, String str4, int i2) {
        return new EcmaError(str, str2, str3, i, str4, i2);
    }

    /* renamed from: g */
    public static EcmaError m6455g(String str) {
        return m6375a("TypeError", m6353a(str, (Object[]) null));
    }

    /* renamed from: b */
    public static EcmaError m6414b(String str, String str2) {
        return m6375a("TypeError", m6349a(str, (Object) str2));
    }

    /* renamed from: a */
    public static EcmaError m6376a(String str, String str2, String str3) {
        return m6375a("TypeError", m6350a(str, (Object) str2, (Object) str3));
    }

    /* renamed from: a */
    public static EcmaError m6378a(String str, String str2, String str3, String str4) {
        return m6375a("TypeError", m6351a(str, (Object) str2, (Object) str3, (Object) str4));
    }

    /* renamed from: g */
    public static RuntimeException m6453g(Object obj, Object obj2) {
        return m6376a("msg.undef.prop.read", m6436d(obj), obj2 == null ? "null" : obj2.toString());
    }

    /* renamed from: i */
    private static RuntimeException m6460i(Object obj, Object obj2) {
        return m6376a("msg.undef.method.call", m6436d(obj), obj2 == null ? "null" : obj2.toString());
    }

    /* renamed from: a */
    private static RuntimeException m6346a(Object obj, Object obj2, Object obj3) {
        return m6378a("msg.undef.prop.write", m6436d(obj), obj2 == null ? "null" : obj2.toString(), obj3 instanceof Scriptable ? obj3.toString() : m6436d(obj3));
    }

    /* renamed from: i */
    private static RuntimeException m6461i(String str) {
        throw m6375a("ReferenceError", m6349a("msg.is.not.defined", (Object) str));
    }

    /* renamed from: o */
    public static RuntimeException m6474o(Object obj) {
        return m6457h(obj, obj);
    }

    /* renamed from: h */
    public static RuntimeException m6457h(Object obj, Object obj2) {
        String obj3 = obj2 == null ? "null" : obj2.toString();
        if (obj == Scriptable.f6533j) {
            return m6414b("msg.function.not.found", obj3);
        }
        return m6376a("msg.isnt.function", obj3, m6469l(obj));
    }

    /* renamed from: r */
    private static RuntimeException m6477r(Object obj) {
        throw m6414b("msg.isnt.xml.object", m6436d(obj));
    }

    /* renamed from: s */
    private static void m6478s(Object obj) {
        String str = "RHINO USAGE WARNING: Missed Context.javaToJS() conversion:\nRhino runtime detected object " + obj + " of class " + obj.getClass().getName() + " where it expected String, Number, Boolean or Scriptable instance. Please check your code for missing Context.javaToJS() call.";
        Context.m6760a(str);
        System.err.println(str);
    }

    /* renamed from: f */
    public static RegExpProxy m6449f(Context lVar) {
        return lVar.mo19144m();
    }

    /* renamed from: a */
    public static void m6386a(Context lVar, RegExpProxy dfVar) {
        if (dfVar == null) {
            throw new IllegalArgumentException();
        }
        lVar.f6786j = dfVar;
    }

    /* renamed from: g */
    public static RegExpProxy m6454g(Context lVar) {
        RegExpProxy m = lVar.mo19144m();
        if (m != null) {
            return m;
        }
        throw Context.m6763b("msg.no.regexp");
    }

    /* renamed from: c */
    public static Scriptable m6425c(Context lVar, Scriptable drVar, Object obj) {
        return lVar.mo19144m().wrapRegExp(lVar, drVar, obj);
    }

    /* renamed from: n */
    private static XMLLib m6473n(Context lVar) {
        if (lVar.f6779c == null) {
            throw new IllegalStateException();
        }
        XMLLib aVar = lVar.f6782f;
        if (aVar == null) {
            aVar = XMLLib.m6685a(lVar.f6779c);
            if (aVar == null) {
                throw new IllegalStateException();
            }
            lVar.f6782f = aVar;
        }
        return aVar;
    }

    /* renamed from: h */
    public static String m6458h(Context lVar) {
        return m6473n(lVar).mo19115d();
    }

    /* renamed from: i */
    public static String m6462i(Context lVar) {
        return m6473n(lVar).mo19116e();
    }

    /* renamed from: p */
    public static Ref m6475p(Object obj) {
        if (obj instanceof XMLObject) {
            return ((XMLObject) obj).mo19122d();
        }
        throw m6477r(obj);
    }

    /* renamed from: q */
    public static Ref m6476q(Object obj) {
        if (obj instanceof XMLObject) {
            return ((XMLObject) obj).mo19123e();
        }
        throw m6477r(obj);
    }

    /* renamed from: j */
    public static Ref m6465j(Context lVar) {
        return m6473n(lVar).mo19113b();
    }

    /* renamed from: k */
    public static Ref m6466k(Context lVar) {
        return m6473n(lVar).mo19114c();
    }

    /* renamed from: l */
    static int m6468l(Context lVar) {
        return lVar.f6799w;
    }

    /* renamed from: b */
    private static void m6415b(Context lVar, Scriptable drVar) {
        if (lVar.f6800x != null) {
            throw new IllegalStateException();
        }
        lVar.f6800x = drVar;
    }

    /* renamed from: m */
    public static Scriptable m6470m(Context lVar) {
        Scriptable drVar = lVar.f6800x;
        lVar.f6800x = null;
        return drVar;
    }

    /* renamed from: a */
    static String m6356a(boolean z, String str, int i) {
        if (z) {
            return str + '#' + i + "(eval)";
        }
        return str + '#' + i + "(Function)";
    }

    /* renamed from: b */
    private static RuntimeException m6401b(String str, Object obj) {
        return Context.m6755a(str, (Object) obj.getClass().getName());
    }
}
