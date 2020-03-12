package org.mozilla.javascript;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.bj */
final class NativeDate extends IdScriptableObject {

    /* renamed from: b */
    private static final Object f6306b = "Date";

    /* renamed from: c */
    private static final DateFormat f6307c;

    /* renamed from: d */
    private static TimeZone f6308d;

    /* renamed from: e */
    private static double f6309e;

    /* renamed from: f */
    private static DateFormat f6310f;

    /* renamed from: g */
    private static DateFormat f6311g;

    /* renamed from: h */
    private static DateFormat f6312h;

    /* renamed from: i */
    private static DateFormat f6313i;

    /* renamed from: a */
    double f6314a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f6307c = simpleDateFormat;
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "UTC"));
        f6307c.setLenient(false);
    }

    /* renamed from: a */
    static void m6016a(Scriptable drVar) {
        NativeDate bjVar = new NativeDate();
        bjVar.f6314a = ScriptRuntime.f6513t;
        bjVar.exportAsJSClass(47, drVar, false);
    }

    private NativeDate() {
        if (f6308d == null) {
            TimeZone timeZone = TimeZone.getDefault();
            f6308d = timeZone;
            f6309e = (double) timeZone.getRawOffset();
        }
    }

    public final String getClassName() {
        return "Date";
    }

    public final Object getDefaultValue(Class<?> cls) {
        if (cls == null) {
            cls = ScriptRuntime.f6505l;
        }
        return super.getDefaultValue(cls);
    }

    /* access modifiers changed from: protected */
    public final void fillConstructorProperties(IdFunctionObject ahVar) {
        addIdFunctionProperty(ahVar, f6306b, -3, "now", 0);
        addIdFunctionProperty(ahVar, f6306b, -2, "parse", 1);
        addIdFunctionProperty(ahVar, f6306b, -1, "UTC", 1);
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
                str = "toTimeString";
                i2 = 0;
                break;
            case 4:
                str = "toDateString";
                i2 = 0;
                break;
            case 5:
                str = "toLocaleString";
                i2 = 0;
                break;
            case 6:
                str = "toLocaleTimeString";
                i2 = 0;
                break;
            case 7:
                str = "toLocaleDateString";
                i2 = 0;
                break;
            case 8:
                str = "toUTCString";
                i2 = 0;
                break;
            case 9:
                str = "toSource";
                i2 = 0;
                break;
            case 10:
                str = CoreConstants.VALUE_OF;
                i2 = 0;
                break;
            case 11:
                str = "getTime";
                i2 = 0;
                break;
            case 12:
                str = "getYear";
                i2 = 0;
                break;
            case 13:
                str = "getFullYear";
                i2 = 0;
                break;
            case 14:
                str = "getUTCFullYear";
                i2 = 0;
                break;
            case 15:
                str = "getMonth";
                i2 = 0;
                break;
            case 16:
                str = "getUTCMonth";
                i2 = 0;
                break;
            case 17:
                str = "getDate";
                i2 = 0;
                break;
            case 18:
                str = "getUTCDate";
                i2 = 0;
                break;
            case 19:
                str = "getDay";
                i2 = 0;
                break;
            case 20:
                str = "getUTCDay";
                i2 = 0;
                break;
            case 21:
                str = "getHours";
                i2 = 0;
                break;
            case 22:
                str = "getUTCHours";
                i2 = 0;
                break;
            case 23:
                str = "getMinutes";
                i2 = 0;
                break;
            case 24:
                str = "getUTCMinutes";
                i2 = 0;
                break;
            case 25:
                str = "getSeconds";
                i2 = 0;
                break;
            case 26:
                str = "getUTCSeconds";
                i2 = 0;
                break;
            case 27:
                str = "getMilliseconds";
                i2 = 0;
                break;
            case 28:
                str = "getUTCMilliseconds";
                i2 = 0;
                break;
            case 29:
                str = "getTimezoneOffset";
                i2 = 0;
                break;
            case 30:
                str = "setTime";
                break;
            case 31:
                str = "setMilliseconds";
                break;
            case 32:
                str = "setUTCMilliseconds";
                break;
            case 33:
                str = "setSeconds";
                i2 = 2;
                break;
            case 34:
                str = "setUTCSeconds";
                i2 = 2;
                break;
            case 35:
                str = "setMinutes";
                i2 = 3;
                break;
            case 36:
                str = "setUTCMinutes";
                i2 = 3;
                break;
            case 37:
                str = "setHours";
                i2 = 4;
                break;
            case 38:
                str = "setUTCHours";
                i2 = 4;
                break;
            case 39:
                str = "setDate";
                break;
            case 40:
                str = "setUTCDate";
                break;
            case 41:
                str = "setMonth";
                i2 = 2;
                break;
            case 42:
                str = "setUTCMonth";
                i2 = 2;
                break;
            case 43:
                str = "setFullYear";
                i2 = 3;
                break;
            case 44:
                str = "setUTCFullYear";
                i2 = 3;
                break;
            case 45:
                str = "setYear";
                break;
            case 46:
                str = "toISOString";
                i2 = 0;
                break;
            case 47:
                str = "toJSON";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(f6306b, i, str, i2);
    }

    public final Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        double d;
        double j;
        double d2;
        if (!ahVar.mo18643a(f6306b)) {
            return super.execIdCall(ahVar, lVar, drVar, drVar2, objArr);
        }
        int i = ahVar.f5994a;
        switch (i) {
            case -3:
                return ScriptRuntime.m6313a((double) System.currentTimeMillis());
            case -2:
                return ScriptRuntime.m6313a(m6010a(ScriptRuntime.m6407b(objArr)));
            case -1:
                return ScriptRuntime.m6313a(m6036p(m6011a(objArr)));
            case 1:
                if (drVar2 != null) {
                    return m6013a((double) System.currentTimeMillis(), 2);
                }
                NativeDate bjVar = new NativeDate();
                if (objArr.length == 0) {
                    bjVar.f6314a = (double) System.currentTimeMillis();
                    return bjVar;
                } else if (objArr.length == 1) {
                    Object obj = objArr[0];
                    if (obj instanceof Scriptable) {
                        obj = ((Scriptable) obj).getDefaultValue(null);
                    }
                    bjVar.f6314a = m6036p(obj instanceof CharSequence ? m6010a(obj.toString()) : ScriptRuntime.m6395b(obj));
                    return bjVar;
                } else {
                    double a = m6011a(objArr);
                    if (!Double.isNaN(a) && !Double.isInfinite(a)) {
                        a = m6036p(m6031k(a));
                    }
                    bjVar.f6314a = a;
                    return bjVar;
                }
            case 47:
                if (drVar2 instanceof NativeDate) {
                    return ((NativeDate) drVar2).m6012a();
                }
                Scriptable b = ScriptRuntime.m6410b(lVar, drVar, (Object) drVar2);
                Object a2 = ScriptRuntime.m6316a((Object) b, ScriptRuntime.f6502i);
                if (a2 instanceof Number) {
                    double doubleValue = ((Number) a2).doubleValue();
                    if (doubleValue != doubleValue || Double.isInfinite(doubleValue)) {
                        return null;
                    }
                }
                Object obj2 = b.get("toISOString", b);
                if (obj2 == f6533j) {
                    throw ScriptRuntime.m6376a("msg.function.not.found.in", "toISOString", ScriptRuntime.m6436d((Object) b));
                } else if (!(obj2 instanceof Callable)) {
                    throw ScriptRuntime.m6378a("msg.isnt.function.in", "toISOString", ScriptRuntime.m6436d((Object) b), ScriptRuntime.m6436d(obj2));
                } else {
                    Object call = ((Callable) obj2).call(lVar, drVar, b, ScriptRuntime.f6517x);
                    if (ScriptRuntime.m6471m(call)) {
                        return call;
                    }
                    throw ScriptRuntime.m6414b("msg.toisostring.must.return.primitive", ScriptRuntime.m6436d(call));
                }
            default:
                if (!(drVar2 instanceof NativeDate)) {
                    throw incompatibleCallError(ahVar);
                }
                NativeDate bjVar2 = (NativeDate) drVar2;
                double d3 = bjVar2.f6314a;
                switch (i) {
                    case 2:
                    case 3:
                    case 4:
                        if (d3 == d3) {
                            return m6013a(d3, i);
                        }
                        return "Invalid Date";
                    case 5:
                    case 6:
                    case 7:
                        if (d3 == d3) {
                            return m6021b(d3, i);
                        }
                        return "Invalid Date";
                    case 8:
                        if (d3 != d3) {
                            return "Invalid Date";
                        }
                        StringBuffer stringBuffer = new StringBuffer(60);
                        m6022b(stringBuffer, m6028h(d3));
                        stringBuffer.append(", ");
                        m6015a(stringBuffer, m6027g(d3), 2);
                        stringBuffer.append(' ');
                        m6014a(stringBuffer, m6026f(d3));
                        stringBuffer.append(' ');
                        int e = m6025e(d3);
                        if (e < 0) {
                            stringBuffer.append(CoreConstants.DASH_CHAR);
                            e = -e;
                        }
                        m6015a(stringBuffer, e, 4);
                        stringBuffer.append(' ');
                        m6015a(stringBuffer, m6032l(d3), 2);
                        stringBuffer.append(CoreConstants.COLON_CHAR);
                        m6015a(stringBuffer, m6033m(d3), 2);
                        stringBuffer.append(CoreConstants.COLON_CHAR);
                        m6015a(stringBuffer, m6034n(d3), 2);
                        stringBuffer.append(" GMT");
                        return stringBuffer.toString();
                    case 9:
                        return "(new Date(" + ScriptRuntime.m6402b(d3) + "))";
                    case 10:
                    case 11:
                        return ScriptRuntime.m6313a(d3);
                    case 12:
                    case 13:
                    case 14:
                        if (d3 == d3) {
                            if (i != 14) {
                                d2 = m6030j(d3);
                            } else {
                                d2 = d3;
                            }
                            d3 = (double) m6025e(d2);
                            if (i == 12 && (!lVar.mo19138b(1) || (1900.0d <= d3 && d3 < 2000.0d))) {
                                d3 -= 1900.0d;
                            }
                        }
                        return ScriptRuntime.m6313a(d3);
                    case 15:
                    case 16:
                        if (d3 == d3) {
                            if (i == 15) {
                                d3 = m6030j(d3);
                            }
                            d3 = (double) m6026f(d3);
                        }
                        return ScriptRuntime.m6313a(d3);
                    case 17:
                    case 18:
                        if (d3 == d3) {
                            if (i == 17) {
                                d3 = m6030j(d3);
                            }
                            d3 = (double) m6027g(d3);
                        }
                        return ScriptRuntime.m6313a(d3);
                    case 19:
                    case 20:
                        if (d3 == d3) {
                            if (i == 19) {
                                d3 = m6030j(d3);
                            }
                            d3 = (double) m6028h(d3);
                        }
                        return ScriptRuntime.m6313a(d3);
                    case 21:
                    case 22:
                        if (d3 == d3) {
                            if (i == 21) {
                                d3 = m6030j(d3);
                            }
                            d3 = (double) m6032l(d3);
                        }
                        return ScriptRuntime.m6313a(d3);
                    case 23:
                    case 24:
                        if (d3 == d3) {
                            if (i == 23) {
                                d3 = m6030j(d3);
                            }
                            d3 = (double) m6033m(d3);
                        }
                        return ScriptRuntime.m6313a(d3);
                    case 25:
                    case 26:
                        if (d3 == d3) {
                            if (i == 25) {
                                d3 = m6030j(d3);
                            }
                            d3 = (double) m6034n(d3);
                        }
                        return ScriptRuntime.m6313a(d3);
                    case 27:
                    case 28:
                        if (d3 == d3) {
                            if (i == 27) {
                                d3 = m6030j(d3);
                            }
                            d3 = (double) m6035o(d3);
                        }
                        return ScriptRuntime.m6313a(d3);
                    case 29:
                        if (d3 == d3) {
                            d3 = (d3 - m6030j(d3)) / 60000.0d;
                        }
                        return ScriptRuntime.m6313a(d3);
                    case 30:
                        double p = m6036p(ScriptRuntime.m6311a(objArr, 0));
                        bjVar2.f6314a = p;
                        return ScriptRuntime.m6313a(p);
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                        double a3 = m6009a(d3, objArr, i);
                        bjVar2.f6314a = a3;
                        return ScriptRuntime.m6313a(a3);
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                        double b2 = m6019b(d3, objArr, i);
                        bjVar2.f6314a = b2;
                        return ScriptRuntime.m6313a(b2);
                    case 45:
                        double a4 = ScriptRuntime.m6311a(objArr, 0);
                        if (a4 != a4 || Double.isInfinite(a4)) {
                            d = ScriptRuntime.f6513t;
                        } else {
                            if (d3 != d3) {
                                j = 0.0d;
                            } else {
                                j = m6030j(d3);
                            }
                            if (a4 >= 0.0d && a4 <= 99.0d) {
                                a4 += 1900.0d;
                            }
                            d = m6036p(m6031k((m6006a(a4, (double) m6026f(j), (double) m6027g(j)) * 8.64E7d) + m6018b(j)));
                        }
                        bjVar2.f6314a = d;
                        return ScriptRuntime.m6313a(d);
                    case 46:
                        return bjVar2.m6012a();
                    default:
                        throw new IllegalArgumentException(String.valueOf(i));
                }
        }
    }

    /* renamed from: a */
    private String m6012a() {
        String format;
        if (this.f6314a == this.f6314a) {
            synchronized (f6307c) {
                format = f6307c.format(new Date((long) this.f6314a));
            }
            return format;
        }
        throw ScriptRuntime.m6375a("RangeError", ScriptRuntime.m6448f("msg.invalid.date"));
    }

    /* renamed from: a */
    private static double m6005a(double d) {
        return Math.floor(d / 8.64E7d);
    }

    /* renamed from: b */
    private static double m6018b(double d) {
        double d2 = d % 8.64E7d;
        if (d2 < 0.0d) {
            return d2 + 8.64E7d;
        }
        return d2;
    }

    /* renamed from: a */
    private static boolean m6017a(int i) {
        return i % 4 == 0 && (i % 100 != 0 || i % 400 == 0);
    }

    /* renamed from: c */
    private static double m6023c(double d) {
        return (((365.0d * (d - 1970.0d)) + Math.floor((d - 1969.0d) / 4.0d)) - Math.floor((d - 1901.0d) / 100.0d)) + Math.floor((d - 1601.0d) / 400.0d);
    }

    /* renamed from: d */
    private static double m6024d(double d) {
        return m6023c(d) * 8.64E7d;
    }

    /* renamed from: e */
    private static int m6025e(double d) {
        int i;
        int floor = ((int) Math.floor((d / 8.64E7d) / 366.0d)) + 1970;
        int floor2 = ((int) Math.floor((d / 8.64E7d) / 365.0d)) + 1970;
        if (floor2 < floor) {
            i = floor;
        } else {
            i = floor2;
            floor2 = floor;
        }
        while (i > floor2) {
            int i2 = (i + floor2) / 2;
            if (m6024d((double) i2) > d) {
                i = i2 - 1;
            } else {
                floor2 = i2 + 1;
                if (m6024d((double) floor2) > d) {
                    return i2;
                }
            }
        }
        return floor2;
    }

    /* renamed from: f */
    private static int m6026f(double d) {
        int i;
        int e = m6025e(d);
        int a = ((int) (m6005a(d) - m6023c((double) e))) - 59;
        if (a >= 0) {
            if (m6017a(e)) {
                if (a == 0) {
                    return 1;
                }
                a--;
            }
            int i2 = a / 30;
            switch (i2) {
                case 0:
                    return 2;
                case 1:
                    i = 31;
                    break;
                case 2:
                    i = 61;
                    break;
                case 3:
                    i = 92;
                    break;
                case 4:
                    i = 122;
                    break;
                case 5:
                    i = 153;
                    break;
                case 6:
                    i = 184;
                    break;
                case 7:
                    i = 214;
                    break;
                case 8:
                    i = 245;
                    break;
                case 9:
                    i = 275;
                    break;
                case 10:
                    return 11;
                default:
                    throw Kit.m5810a();
            }
            if (a >= i) {
                return i2 + 2;
            }
            return i2 + 1;
        } else if (a < -28) {
            return 0;
        } else {
            return 1;
        }
    }

    /* renamed from: g */
    private static int m6027g(double d) {
        int i = 30;
        int i2 = 31;
        int e = m6025e(d);
        int a = ((int) (m6005a(d) - m6023c((double) e))) - 59;
        if (a >= 0) {
            if (m6017a(e)) {
                if (a == 0) {
                    return 29;
                }
                a--;
            }
            switch (a / 30) {
                case 0:
                    return a + 1;
                case 1:
                    i = 31;
                    break;
                case 2:
                    i2 = 61;
                    break;
                case 3:
                    i = 31;
                    i2 = 92;
                    break;
                case 4:
                    i2 = 122;
                    break;
                case 5:
                    i = 31;
                    i2 = 153;
                    break;
                case 6:
                    i = 31;
                    i2 = 184;
                    break;
                case 7:
                    i2 = 214;
                    break;
                case 8:
                    i = 31;
                    i2 = 245;
                    break;
                case 9:
                    i2 = 275;
                    break;
                case 10:
                    return (a - 275) + 1;
                default:
                    throw Kit.m5810a();
            }
            int i3 = a - i2;
            if (i3 < 0) {
                i3 += i;
            }
            return i3 + 1;
        } else if (a < -28) {
            return a + 31 + 28 + 1;
        } else {
            return a + 28 + 1;
        }
    }

    /* renamed from: h */
    private static int m6028h(double d) {
        double a = (m6005a(d) + 4.0d) % 7.0d;
        if (a < 0.0d) {
            a += 7.0d;
        }
        return (int) a;
    }

    /* renamed from: i */
    private static double m6029i(double d) {
        if (d < 0.0d) {
            d = (m6006a((double) m6020b(m6025e(d)), (double) m6026f(d), (double) m6027g(d)) * 8.64E7d) + m6018b(d);
        }
        if (f6308d.inDaylightTime(new Date((long) d))) {
            return 3600000.0d;
        }
        return 0.0d;
    }

    /* renamed from: b */
    private static int m6020b(int i) {
        int c = (((int) m6023c((double) i)) + 4) % 7;
        if (c < 0) {
            c += 7;
        }
        if (m6017a(i)) {
            switch (c) {
                case 0:
                    return 1984;
                case 1:
                    return 1996;
                case 2:
                    return 1980;
                case 3:
                    return 1992;
                case 4:
                    return 1976;
                case 5:
                    return 1988;
                case 6:
                    return 1972;
            }
        } else {
            switch (c) {
                case 0:
                    return 1978;
                case 1:
                    return 1973;
                case 2:
                    return 1985;
                case 3:
                    return 1986;
                case 4:
                    return 1981;
                case 5:
                    return 1971;
                case 6:
                    return 1977;
            }
        }
        throw Kit.m5810a();
    }

    /* renamed from: j */
    private static double m6030j(double d) {
        return f6309e + d + m6029i(d);
    }

    /* renamed from: k */
    private static double m6031k(double d) {
        return (d - f6309e) - m6029i(d - f6309e);
    }

    /* renamed from: l */
    private static int m6032l(double d) {
        double floor = Math.floor(d / 3600000.0d) % 24.0d;
        if (floor < 0.0d) {
            floor += 24.0d;
        }
        return (int) floor;
    }

    /* renamed from: m */
    private static int m6033m(double d) {
        double floor = Math.floor(d / 60000.0d) % 60.0d;
        if (floor < 0.0d) {
            floor += 60.0d;
        }
        return (int) floor;
    }

    /* renamed from: n */
    private static int m6034n(double d) {
        double floor = Math.floor(d / 1000.0d) % 60.0d;
        if (floor < 0.0d) {
            floor += 60.0d;
        }
        return (int) floor;
    }

    /* renamed from: o */
    private static int m6035o(double d) {
        double d2 = d % 1000.0d;
        if (d2 < 0.0d) {
            d2 += 1000.0d;
        }
        return (int) d2;
    }

    /* renamed from: a */
    private static double m6007a(double d, double d2, double d3, double d4) {
        return (((((d * 60.0d) + d2) * 60.0d) + d3) * 1000.0d) + d4;
    }

    /* renamed from: a */
    private static double m6006a(double d, double d2, double d3) {
        double floor = d + Math.floor(d2 / 12.0d);
        double d4 = d2 % 12.0d;
        if (d4 < 0.0d) {
            d4 += 12.0d;
        }
        double floor2 = Math.floor(m6024d(floor) / 8.64E7d);
        int i = (int) d4;
        int i2 = (int) floor;
        int i3 = i * 30;
        int i4 = i >= 7 ? i3 + ((i / 2) - 1) : i >= 2 ? i3 + (((i - 1) / 2) - 1) : i3 + i;
        if (i >= 2 && m6017a(i2)) {
            i4++;
        }
        return ((((double) i4) + floor2) + d3) - 1.0d;
    }

    /* renamed from: p */
    private static double m6036p(double d) {
        if (d != d || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY || Math.abs(d) > 8.64E15d) {
            return ScriptRuntime.f6513t;
        }
        if (d > 0.0d) {
            return Math.floor(d + 0.0d);
        }
        return Math.ceil(d + 0.0d);
    }

    /* renamed from: a */
    private static double m6008a(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        return (m6006a(d, d2, d3) * 8.64E7d) + m6007a(d4, d5, d6, d7);
    }

    /* renamed from: a */
    private static double m6011a(Object[] objArr) {
        double[] dArr = new double[7];
        for (int i = 0; i < 7; i++) {
            if (i < objArr.length) {
                double b = ScriptRuntime.m6395b(objArr[i]);
                if (b != b || Double.isInfinite(b)) {
                    return ScriptRuntime.f6513t;
                }
                dArr[i] = ScriptRuntime.m6440e(objArr[i]);
            } else if (i == 2) {
                dArr[i] = 1.0d;
            } else {
                dArr[i] = 0.0d;
            }
        }
        if (dArr[0] >= 0.0d && dArr[0] <= 99.0d) {
            dArr[0] = dArr[0] + 1900.0d;
        }
        return m6008a(dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], dArr[6]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e2  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double m6010a(String r23) {
        /*
            int r2 = r23.length()     // Catch:{ ParseException -> 0x001d }
            r3 = 24
            if (r2 != r3) goto L_0x001e
            java.text.DateFormat r3 = f6307c     // Catch:{ ParseException -> 0x001d }
            monitor-enter(r3)     // Catch:{ ParseException -> 0x001d }
            java.text.DateFormat r2 = f6307c     // Catch:{ all -> 0x001a }
            r0 = r23
            java.util.Date r2 = r2.parse(r0)     // Catch:{ all -> 0x001a }
            monitor-exit(r3)     // Catch:{ all -> 0x001a }
            long r2 = r2.getTime()     // Catch:{ ParseException -> 0x001d }
            double r2 = (double) r2
        L_0x0019:
            return r2
        L_0x001a:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x001a }
            throw r2     // Catch:{ ParseException -> 0x001d }
        L_0x001d:
            r2 = move-exception
        L_0x001e:
            r14 = -1
            r13 = -1
            r12 = -1
            r11 = -1
            r10 = -1
            r9 = -1
            r18 = 0
            r16 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r4 = 0
            r8 = 0
            int r20 = r23.length()
            r19 = r4
        L_0x0030:
            r0 = r18
            r1 = r20
            if (r0 >= r1) goto L_0x02ce
            r0 = r23
            r1 = r18
            char r4 = r0.charAt(r1)
            int r2 = r18 + 1
            r3 = 32
            if (r4 <= r3) goto L_0x004c
            r3 = 44
            if (r4 == r3) goto L_0x004c
            r3 = 45
            if (r4 != r3) goto L_0x0067
        L_0x004c:
            r0 = r20
            if (r2 >= r0) goto L_0x030a
            r0 = r23
            char r3 = r0.charAt(r2)
            r5 = 45
            if (r4 != r5) goto L_0x030a
            r5 = 48
            if (r5 > r3) goto L_0x030a
            r5 = 57
            if (r3 > r5) goto L_0x030a
            r19 = r4
            r18 = r2
            goto L_0x0030
        L_0x0067:
            r3 = 40
            if (r4 != r3) goto L_0x008f
            r3 = 1
            r22 = r3
            r3 = r2
            r2 = r22
        L_0x0071:
            r0 = r20
            if (r3 >= r0) goto L_0x0306
            r0 = r23
            char r4 = r0.charAt(r3)
            int r3 = r3 + 1
            r5 = 40
            if (r4 != r5) goto L_0x0084
            int r2 = r2 + 1
            goto L_0x0071
        L_0x0084:
            r5 = 41
            if (r4 != r5) goto L_0x0071
            int r2 = r2 + -1
            if (r2 > 0) goto L_0x0071
            r18 = r3
            goto L_0x0030
        L_0x008f:
            r3 = 48
            if (r3 > r4) goto L_0x01ee
            r3 = 57
            if (r4 > r3) goto L_0x01ee
            int r3 = r4 + -48
            r15 = r2
            r2 = r3
            r3 = r4
        L_0x009c:
            r0 = r20
            if (r15 >= r0) goto L_0x00b8
            r4 = 48
            r0 = r23
            char r3 = r0.charAt(r15)
            if (r4 > r3) goto L_0x00b8
            r4 = 57
            if (r3 > r4) goto L_0x00b8
            int r2 = r2 * 10
            int r2 = r2 + r3
            int r4 = r2 + -48
            int r2 = r15 + 1
            r15 = r2
            r2 = r4
            goto L_0x009c
        L_0x00b8:
            r4 = 43
            r0 = r19
            if (r0 == r4) goto L_0x00c4
            r4 = 45
            r0 = r19
            if (r0 != r4) goto L_0x0102
        L_0x00c4:
            r3 = 1
            r4 = 24
            if (r2 >= r4) goto L_0x00e2
            int r2 = r2 * 60
        L_0x00cb:
            r4 = 43
            r0 = r19
            if (r0 != r4) goto L_0x00d2
            int r2 = -r2
        L_0x00d2:
            r4 = 0
            int r4 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x00ea
            r4 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r4 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x00ea
            double r2 = org.mozilla.javascript.ScriptRuntime.f6513t
            goto L_0x0019
        L_0x00e2:
            int r4 = r2 % 100
            int r2 = r2 / 100
            int r2 = r2 * 60
            int r2 = r2 + r4
            goto L_0x00cb
        L_0x00ea:
            double r4 = (double) r2
            r2 = r3
            r6 = r10
            r7 = r11
            r8 = r12
            r3 = r9
            r10 = r14
            r9 = r13
        L_0x00f2:
            r11 = 0
            r16 = r4
            r19 = r11
            r18 = r15
            r12 = r8
            r13 = r9
            r14 = r10
            r11 = r7
            r8 = r2
            r9 = r3
            r10 = r6
            goto L_0x0030
        L_0x0102:
            r4 = 70
            if (r2 >= r4) goto L_0x0112
            r4 = 47
            r0 = r19
            if (r0 != r4) goto L_0x013c
            if (r13 < 0) goto L_0x013c
            if (r12 < 0) goto L_0x013c
            if (r14 >= 0) goto L_0x013c
        L_0x0112:
            if (r14 < 0) goto L_0x0118
            double r2 = org.mozilla.javascript.ScriptRuntime.f6513t
            goto L_0x0019
        L_0x0118:
            r4 = 32
            if (r3 <= r4) goto L_0x0128
            r4 = 44
            if (r3 == r4) goto L_0x0128
            r4 = 47
            if (r3 == r4) goto L_0x0128
            r0 = r20
            if (r15 < r0) goto L_0x0138
        L_0x0128:
            r3 = 100
            if (r2 >= r3) goto L_0x012e
            int r2 = r2 + 1900
        L_0x012e:
            r4 = r16
            r3 = r9
            r6 = r10
            r7 = r11
            r9 = r13
            r10 = r2
            r2 = r8
            r8 = r12
            goto L_0x00f2
        L_0x0138:
            double r2 = org.mozilla.javascript.ScriptRuntime.f6513t
            goto L_0x0019
        L_0x013c:
            r4 = 58
            if (r3 != r4) goto L_0x015c
            if (r11 >= 0) goto L_0x014c
            r4 = r16
            r3 = r9
            r6 = r10
            r7 = r2
            r2 = r8
            r9 = r13
            r10 = r14
            r8 = r12
            goto L_0x00f2
        L_0x014c:
            if (r10 >= 0) goto L_0x0158
            r4 = r16
            r3 = r9
            r6 = r2
            r7 = r11
            r10 = r14
            r9 = r13
            r2 = r8
            r8 = r12
            goto L_0x00f2
        L_0x0158:
            double r2 = org.mozilla.javascript.ScriptRuntime.f6513t
            goto L_0x0019
        L_0x015c:
            r4 = 47
            if (r3 != r4) goto L_0x0182
            if (r13 >= 0) goto L_0x016e
            int r2 = r2 + -1
            r4 = r16
            r3 = r9
            r6 = r10
            r7 = r11
            r9 = r2
            r10 = r14
            r2 = r8
            r8 = r12
            goto L_0x00f2
        L_0x016e:
            if (r12 >= 0) goto L_0x017e
            r4 = r16
            r3 = r9
            r6 = r10
            r7 = r11
            r9 = r13
            r10 = r14
            r22 = r8
            r8 = r2
            r2 = r22
            goto L_0x00f2
        L_0x017e:
            double r2 = org.mozilla.javascript.ScriptRuntime.f6513t
            goto L_0x0019
        L_0x0182:
            r0 = r20
            if (r15 >= r0) goto L_0x0196
            r4 = 44
            if (r3 == r4) goto L_0x0196
            r4 = 32
            if (r3 <= r4) goto L_0x0196
            r4 = 45
            if (r3 == r4) goto L_0x0196
            double r2 = org.mozilla.javascript.ScriptRuntime.f6513t
            goto L_0x0019
        L_0x0196:
            if (r8 == 0) goto L_0x01bc
            r3 = 60
            if (r2 >= r3) goto L_0x01bc
            r4 = 0
            int r3 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x01af
            double r2 = (double) r2
            double r2 = r16 - r2
            r4 = r2
            r6 = r10
            r7 = r11
            r2 = r8
            r3 = r9
            r10 = r14
            r9 = r13
            r8 = r12
            goto L_0x00f2
        L_0x01af:
            double r2 = (double) r2
            double r2 = r2 + r16
            r4 = r2
            r6 = r10
            r7 = r11
            r2 = r8
            r3 = r9
            r10 = r14
            r9 = r13
            r8 = r12
            goto L_0x00f2
        L_0x01bc:
            if (r11 < 0) goto L_0x01cb
            if (r10 >= 0) goto L_0x01cb
            r4 = r16
            r3 = r9
            r6 = r2
            r7 = r11
            r10 = r14
            r9 = r13
            r2 = r8
            r8 = r12
            goto L_0x00f2
        L_0x01cb:
            if (r10 < 0) goto L_0x01da
            if (r9 >= 0) goto L_0x01da
            r4 = r16
            r3 = r2
            r6 = r10
            r7 = r11
            r9 = r13
            r2 = r8
            r10 = r14
            r8 = r12
            goto L_0x00f2
        L_0x01da:
            if (r12 >= 0) goto L_0x01ea
            r4 = r16
            r3 = r9
            r6 = r10
            r7 = r11
            r9 = r13
            r10 = r14
            r22 = r8
            r8 = r2
            r2 = r22
            goto L_0x00f2
        L_0x01ea:
            double r2 = org.mozilla.javascript.ScriptRuntime.f6513t
            goto L_0x0019
        L_0x01ee:
            r3 = 47
            if (r4 == r3) goto L_0x01fe
            r3 = 58
            if (r4 == r3) goto L_0x01fe
            r3 = 43
            if (r4 == r3) goto L_0x01fe
            r3 = 45
            if (r4 != r3) goto L_0x0204
        L_0x01fe:
            r19 = r4
            r18 = r2
            goto L_0x0030
        L_0x0204:
            int r6 = r2 + -1
            r18 = r2
        L_0x0208:
            r0 = r18
            r1 = r20
            if (r0 >= r1) goto L_0x022b
            r0 = r23
            r1 = r18
            char r2 = r0.charAt(r1)
            r3 = 65
            if (r3 > r2) goto L_0x021e
            r3 = 90
            if (r2 <= r3) goto L_0x0226
        L_0x021e:
            r3 = 97
            if (r3 > r2) goto L_0x022b
            r3 = 122(0x7a, float:1.71E-43)
            if (r2 > r3) goto L_0x022b
        L_0x0226:
            int r2 = r18 + 1
            r18 = r2
            goto L_0x0208
        L_0x022b:
            int r7 = r18 - r6
            r2 = 2
            if (r7 >= r2) goto L_0x0234
            double r2 = org.mozilla.javascript.ScriptRuntime.f6513t
            goto L_0x0019
        L_0x0234:
            java.lang.String r2 = "am;pm;monday;tuesday;wednesday;thursday;friday;saturday;sunday;january;february;march;april;may;june;july;august;september;october;november;december;gmt;ut;utc;est;edt;cst;cdt;mst;mdt;pst;pdt;"
            r3 = 0
            r4 = 0
            r15 = r3
        L_0x0239:
            r3 = 59
            int r21 = r2.indexOf(r3, r4)
            if (r21 >= 0) goto L_0x0245
            double r2 = org.mozilla.javascript.ScriptRuntime.f6513t
            goto L_0x0019
        L_0x0245:
            r3 = 1
            r5 = r23
            boolean r3 = r2.regionMatches(r3, r4, r5, r6, r7)
            if (r3 != 0) goto L_0x0254
            int r4 = r21 + 1
            int r3 = r15 + 1
            r15 = r3
            goto L_0x0239
        L_0x0254:
            r2 = 2
            if (r15 >= r2) goto L_0x0272
            r2 = 12
            if (r11 > r2) goto L_0x025d
            if (r11 >= 0) goto L_0x0261
        L_0x025d:
            double r2 = org.mozilla.javascript.ScriptRuntime.f6513t
            goto L_0x0019
        L_0x0261:
            if (r15 != 0) goto L_0x026a
            r2 = 12
            if (r11 != r2) goto L_0x0030
            r11 = 0
            goto L_0x0030
        L_0x026a:
            r2 = 12
            if (r11 == r2) goto L_0x0030
            int r11 = r11 + 12
            goto L_0x0030
        L_0x0272:
            int r2 = r15 + -2
            r3 = 7
            if (r2 < r3) goto L_0x0030
            int r2 = r2 + -7
            r3 = 12
            if (r2 >= r3) goto L_0x0286
            if (r13 >= 0) goto L_0x0282
            r13 = r2
            goto L_0x0030
        L_0x0282:
            double r2 = org.mozilla.javascript.ScriptRuntime.f6513t
            goto L_0x0019
        L_0x0286:
            int r2 = r2 + -12
            switch(r2) {
                case 0: goto L_0x0290;
                case 1: goto L_0x0294;
                case 2: goto L_0x0298;
                case 3: goto L_0x029c;
                case 4: goto L_0x02a3;
                case 5: goto L_0x02a7;
                case 6: goto L_0x02ae;
                case 7: goto L_0x02b5;
                case 8: goto L_0x02bc;
                case 9: goto L_0x02c3;
                case 10: goto L_0x02c7;
                default: goto L_0x028b;
            }
        L_0x028b:
            org.mozilla.javascript.Kit.m5810a()
            goto L_0x0030
        L_0x0290:
            r16 = 0
            goto L_0x0030
        L_0x0294:
            r16 = 0
            goto L_0x0030
        L_0x0298:
            r16 = 0
            goto L_0x0030
        L_0x029c:
            r16 = 4643985272004935680(0x4072c00000000000, double:300.0)
            goto L_0x0030
        L_0x02a3:
            r16 = 4642648265865560064(0x406e000000000000, double:240.0)
            goto L_0x0030
        L_0x02a7:
            r16 = 4645040803167600640(0x4076800000000000, double:360.0)
            goto L_0x0030
        L_0x02ae:
            r16 = 4643985272004935680(0x4072c00000000000, double:300.0)
            goto L_0x0030
        L_0x02b5:
            r16 = 4646096334330265600(0x407a400000000000, double:420.0)
            goto L_0x0030
        L_0x02bc:
            r16 = 4645040803167600640(0x4076800000000000, double:360.0)
            goto L_0x0030
        L_0x02c3:
            r16 = 4647151865492930560(0x407e000000000000, double:480.0)
            goto L_0x0030
        L_0x02c7:
            r16 = 4646096334330265600(0x407a400000000000, double:420.0)
            goto L_0x0030
        L_0x02ce:
            if (r14 < 0) goto L_0x02d4
            if (r13 < 0) goto L_0x02d4
            if (r12 >= 0) goto L_0x02d8
        L_0x02d4:
            double r2 = org.mozilla.javascript.ScriptRuntime.f6513t
            goto L_0x0019
        L_0x02d8:
            if (r9 >= 0) goto L_0x0304
            r9 = 0
            r15 = r9
        L_0x02dc:
            if (r10 >= 0) goto L_0x02df
            r10 = 0
        L_0x02df:
            if (r11 >= 0) goto L_0x02e2
            r11 = 0
        L_0x02e2:
            double r2 = (double) r14
            double r4 = (double) r13
            double r6 = (double) r12
            double r8 = (double) r11
            double r10 = (double) r10
            double r12 = (double) r15
            r14 = 0
            double r2 = m6008a(r2, r4, r6, r8, r10, r12, r14)
            r4 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r4 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x02fa
            double r2 = m6031k(r2)
            goto L_0x0019
        L_0x02fa:
            r4 = 4678479150791524352(0x40ed4c0000000000, double:60000.0)
            double r4 = r4 * r16
            double r2 = r2 + r4
            goto L_0x0019
        L_0x0304:
            r15 = r9
            goto L_0x02dc
        L_0x0306:
            r18 = r3
            goto L_0x0030
        L_0x030a:
            r18 = r2
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.m6010a(java.lang.String):double");
    }

    /* renamed from: a */
    private static String m6013a(double d, int i) {
        StringBuffer stringBuffer = new StringBuffer(60);
        double j = m6030j(d);
        if (i != 3) {
            m6022b(stringBuffer, m6028h(j));
            stringBuffer.append(' ');
            m6014a(stringBuffer, m6026f(j));
            stringBuffer.append(' ');
            m6015a(stringBuffer, m6027g(j), 2);
            stringBuffer.append(' ');
            int e = m6025e(j);
            if (e < 0) {
                stringBuffer.append(CoreConstants.DASH_CHAR);
                e = -e;
            }
            m6015a(stringBuffer, e, 4);
            if (i != 4) {
                stringBuffer.append(' ');
            }
        }
        if (i != 4) {
            m6015a(stringBuffer, m6032l(j), 2);
            stringBuffer.append(CoreConstants.COLON_CHAR);
            m6015a(stringBuffer, m6033m(j), 2);
            stringBuffer.append(CoreConstants.COLON_CHAR);
            m6015a(stringBuffer, m6034n(j), 2);
            int floor = (int) Math.floor((f6309e + m6029i(d)) / 60000.0d);
            int i2 = (floor % 60) + ((floor / 60) * 100);
            if (i2 > 0) {
                stringBuffer.append(" GMT+");
            } else {
                stringBuffer.append(" GMT-");
                i2 = -i2;
            }
            m6015a(stringBuffer, i2, 4);
            if (f6310f == null) {
                f6310f = new SimpleDateFormat("zzz");
            }
            if (d < 0.0d) {
                d = (m6006a((double) m6020b(m6025e(j)), (double) m6026f(d), (double) m6027g(d)) * 8.64E7d) + m6018b(d);
            }
            stringBuffer.append(" (");
            Date date = new Date((long) d);
            synchronized (f6310f) {
                stringBuffer.append(f6310f.format(date));
            }
            stringBuffer.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private static String m6021b(double d, int i) {
        DateFormat dateFormat;
        String format;
        switch (i) {
            case 5:
                if (f6311g == null) {
                    f6311g = DateFormat.getDateTimeInstance(1, 1);
                }
                dateFormat = f6311g;
                break;
            case 6:
                if (f6313i == null) {
                    f6313i = DateFormat.getTimeInstance(1);
                }
                dateFormat = f6313i;
                break;
            case 7:
                if (f6312h == null) {
                    f6312h = DateFormat.getDateInstance(1);
                }
                dateFormat = f6312h;
                break;
            default:
                throw new AssertionError();
        }
        synchronized (dateFormat) {
            format = dateFormat.format(new Date((long) d));
        }
        return format;
    }

    /* renamed from: a */
    private static void m6015a(StringBuffer stringBuffer, int i, int i2) {
        int i3 = 1000000000;
        if (i < 0) {
            Kit.m5810a();
        }
        int i4 = i2 - 1;
        if (i < 10) {
            i3 = 1;
        } else if (i < 1000000000) {
            i3 = 1;
            while (true) {
                int i5 = i3 * 10;
                if (i < i5) {
                    break;
                }
                i4--;
                i3 = i5;
            }
        } else {
            i4 -= 9;
        }
        while (i4 > 0) {
            stringBuffer.append('0');
            i4--;
        }
        while (i3 != 1) {
            stringBuffer.append((char) ((i / i3) + 48));
            i %= i3;
            i3 /= 10;
        }
        stringBuffer.append((char) (i + 48));
    }

    /* renamed from: a */
    private static void m6014a(StringBuffer stringBuffer, int i) {
        String str = "JanFebMarAprMayJunJulAugSepOctNovDec";
        int i2 = i * 3;
        for (int i3 = 0; i3 != 3; i3++) {
            stringBuffer.append(str.charAt(i2 + i3));
        }
    }

    /* renamed from: b */
    private static void m6022b(StringBuffer stringBuffer, int i) {
        String str = "SunMonTueWedThuFriSat";
        int i2 = i * 3;
        for (int i3 = 0; i3 != 3; i3++) {
            stringBuffer.append(str.charAt(i2 + i3));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        r8 = r0;
        r6 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        r8 = r0;
        r6 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        if (r14.length != 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        r14 = org.mozilla.javascript.ScriptRuntime.m6394a(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        if (r0 >= r14.length) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        if (r0 >= r6) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        r10[r0] = org.mozilla.javascript.ScriptRuntime.m6395b(r14[r0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        if (r10[r0] != r10[r0]) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        if (java.lang.Double.isInfinite(r10[r0]) == false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
        r10[r0] = org.mozilla.javascript.ScriptRuntime.m6419c(r10[r0]);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0059, code lost:
        if (r8 == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005b, code lost:
        r12 = m6030j(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        r4 = 0;
        r11 = r14.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0062, code lost:
        if (r6 < 4) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0064, code lost:
        if (r11 <= 0) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0066, code lost:
        r4 = 1;
        r0 = r10[0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006b, code lost:
        if (r6 < 3) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006d, code lost:
        if (r4 >= r11) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006f, code lost:
        r9 = r4 + 1;
        r2 = r10[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0074, code lost:
        if (r6 < 2) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0076, code lost:
        if (r9 >= r11) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0078, code lost:
        r7 = r9 + 1;
        r4 = r10[r9];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r10 = new double[4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007c, code lost:
        if (r6 <= 0) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007e, code lost:
        if (r7 >= r11) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0080, code lost:
        r6 = r10[r7];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0082, code lost:
        r0 = m6007a(r0, r2, r4, r6) + (m6005a(r12) * 8.64E7d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0091, code lost:
        if (r8 == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0093, code lost:
        r0 = m6031k(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009d, code lost:
        r0 = (double) m6032l(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a3, code lost:
        r2 = (double) m6033m(r12);
        r9 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00aa, code lost:
        r4 = (double) m6034n(r12);
        r7 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        if (r12 == r12) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b1, code lost:
        r6 = (double) m6035o(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return org.mozilla.javascript.ScriptRuntime.f6513t;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return m6036p(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        r8 = r0;
        r6 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        r8 = r0;
        r6 = 2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double m6009a(double r12, Object[] r14, int r15) {
        /*
            r0 = 1
            switch(r15) {
                case 31: goto L_0x0013;
                case 32: goto L_0x0012;
                case 33: goto L_0x0018;
                case 34: goto L_0x0017;
                case 35: goto L_0x001d;
                case 36: goto L_0x001c;
                case 37: goto L_0x0022;
                case 38: goto L_0x0021;
                default: goto L_0x0004;
            }
        L_0x0004:
            org.mozilla.javascript.Kit.m5810a()
            r1 = 0
            r8 = r0
            r6 = r1
        L_0x000a:
            r0 = 4
            double[] r10 = new double[r0]
            int r0 = (r12 > r12 ? 1 : (r12 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x0026
        L_0x0011:
            return r12
        L_0x0012:
            r0 = 0
        L_0x0013:
            r1 = 1
            r8 = r0
            r6 = r1
            goto L_0x000a
        L_0x0017:
            r0 = 0
        L_0x0018:
            r1 = 2
            r8 = r0
            r6 = r1
            goto L_0x000a
        L_0x001c:
            r0 = 0
        L_0x001d:
            r1 = 3
            r8 = r0
            r6 = r1
            goto L_0x000a
        L_0x0021:
            r0 = 0
        L_0x0022:
            r1 = 4
            r8 = r0
            r6 = r1
            goto L_0x000a
        L_0x0026:
            int r0 = r14.length
            if (r0 != 0) goto L_0x002d
            java.lang.Object[] r14 = org.mozilla.javascript.ScriptRuntime.m6394a(r14)
        L_0x002d:
            r0 = 0
        L_0x002e:
            int r1 = r14.length
            if (r0 >= r1) goto L_0x0059
            if (r0 >= r6) goto L_0x0059
            r1 = r14[r0]
            double r2 = org.mozilla.javascript.ScriptRuntime.m6395b(r1)
            r10[r0] = r2
            r2 = r10[r0]
            r4 = r10[r0]
            int r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x004b
            r2 = r10[r0]
            boolean r1 = java.lang.Double.isInfinite(r2)
            if (r1 == 0) goto L_0x004e
        L_0x004b:
            double r12 = org.mozilla.javascript.ScriptRuntime.f6513t
            goto L_0x0011
        L_0x004e:
            r2 = r10[r0]
            double r2 = org.mozilla.javascript.ScriptRuntime.m6419c(r2)
            r10[r0] = r2
            int r0 = r0 + 1
            goto L_0x002e
        L_0x0059:
            if (r8 == 0) goto L_0x005f
            double r12 = m6030j(r12)
        L_0x005f:
            r4 = 0
            int r11 = r14.length
            r0 = 4
            if (r6 < r0) goto L_0x009d
            if (r11 <= 0) goto L_0x009d
            r0 = 0
            r4 = 1
            r0 = r10[r0]
        L_0x006a:
            r2 = 3
            if (r6 < r2) goto L_0x00a3
            if (r4 >= r11) goto L_0x00a3
            int r9 = r4 + 1
            r2 = r10[r4]
        L_0x0073:
            r4 = 2
            if (r6 < r4) goto L_0x00aa
            if (r9 >= r11) goto L_0x00aa
            int r7 = r9 + 1
            r4 = r10[r9]
        L_0x007c:
            if (r6 <= 0) goto L_0x00b1
            if (r7 >= r11) goto L_0x00b1
            r6 = r10[r7]
        L_0x0082:
            double r0 = m6007a(r0, r2, r4, r6)
            double r2 = m6005a(r12)
            r4 = 4725570615333879808(0x4194997000000000, double:8.64E7)
            double r2 = r2 * r4
            double r0 = r0 + r2
            if (r8 == 0) goto L_0x0097
            double r0 = m6031k(r0)
        L_0x0097:
            double r12 = m6036p(r0)
            goto L_0x0011
        L_0x009d:
            int r0 = m6032l(r12)
            double r0 = (double) r0
            goto L_0x006a
        L_0x00a3:
            int r2 = m6033m(r12)
            double r2 = (double) r2
            r9 = r4
            goto L_0x0073
        L_0x00aa:
            int r4 = m6034n(r12)
            double r4 = (double) r4
            r7 = r9
            goto L_0x007c
        L_0x00b1:
            int r6 = m6035o(r12)
            double r6 = (double) r6
            goto L_0x0082
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.m6009a(double, java.lang.Object[], int):double");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r8[r0] = org.mozilla.javascript.ScriptRuntime.m6395b(r14[r0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r8[r0] != r8[r0]) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        if (java.lang.Double.isInfinite(r8[r0]) == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        r6 = r0;
        r4 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        r6 = r0;
        r4 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        r6 = r0;
        r4 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        r8[r0] = org.mozilla.javascript.ScriptRuntime.m6419c(r8[r0]);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        if (r12 == r12) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
        if (r14.length >= 3) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005a, code lost:
        r12 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005c, code lost:
        r7 = 0;
        r9 = r14.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
        if (r4 < 3) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0061, code lost:
        if (r9 <= 0) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0063, code lost:
        r7 = 1;
        r0 = r8[0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0068, code lost:
        if (r4 < 2) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006a, code lost:
        if (r7 >= r9) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006c, code lost:
        r5 = r7 + 1;
        r2 = r8[r7];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0070, code lost:
        if (r4 <= 0) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0072, code lost:
        if (r5 >= r9) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0074, code lost:
        r4 = r8[r5];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0076, code lost:
        r0 = (m6006a(r0, r2, r4) * 8.64E7d) + m6018b(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r8 = new double[3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0085, code lost:
        if (r6 == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0087, code lost:
        r0 = m6031k(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0090, code lost:
        if (r6 == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0092, code lost:
        r12 = m6030j(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0097, code lost:
        r0 = (double) m6025e(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009d, code lost:
        r2 = (double) m6026f(r12);
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a4, code lost:
        r4 = (double) m6027g(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        if (r14.length != 0) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return org.mozilla.javascript.ScriptRuntime.f6513t;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return org.mozilla.javascript.ScriptRuntime.f6513t;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return m6036p(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r14 = org.mozilla.javascript.ScriptRuntime.m6394a(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r0 >= r14.length) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r0 >= r4) goto L_0x004f;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double m6019b(double r12, Object[] r14, int r15) {
        /*
            r0 = 1
            switch(r15) {
                case 39: goto L_0x0036;
                case 40: goto L_0x0035;
                case 41: goto L_0x003b;
                case 42: goto L_0x003a;
                case 43: goto L_0x0040;
                case 44: goto L_0x003f;
                default: goto L_0x0004;
            }
        L_0x0004:
            org.mozilla.javascript.Kit.m5810a()
            r1 = 0
            r6 = r0
            r4 = r1
        L_0x000a:
            r0 = 3
            double[] r8 = new double[r0]
            int r0 = r14.length
            if (r0 != 0) goto L_0x0014
            java.lang.Object[] r14 = org.mozilla.javascript.ScriptRuntime.m6394a(r14)
        L_0x0014:
            r0 = 0
        L_0x0015:
            int r1 = r14.length
            if (r0 >= r1) goto L_0x004f
            if (r0 >= r4) goto L_0x004f
            r1 = r14[r0]
            double r2 = org.mozilla.javascript.ScriptRuntime.m6395b(r1)
            r8[r0] = r2
            r2 = r8[r0]
            r10 = r8[r0]
            int r1 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r1 != 0) goto L_0x0032
            r2 = r8[r0]
            boolean r1 = java.lang.Double.isInfinite(r2)
            if (r1 == 0) goto L_0x0044
        L_0x0032:
            double r0 = org.mozilla.javascript.ScriptRuntime.f6513t
        L_0x0034:
            return r0
        L_0x0035:
            r0 = 0
        L_0x0036:
            r1 = 1
            r6 = r0
            r4 = r1
            goto L_0x000a
        L_0x003a:
            r0 = 0
        L_0x003b:
            r1 = 2
            r6 = r0
            r4 = r1
            goto L_0x000a
        L_0x003f:
            r0 = 0
        L_0x0040:
            r1 = 3
            r6 = r0
            r4 = r1
            goto L_0x000a
        L_0x0044:
            r2 = r8[r0]
            double r2 = org.mozilla.javascript.ScriptRuntime.m6419c(r2)
            r8[r0] = r2
            int r0 = r0 + 1
            goto L_0x0015
        L_0x004f:
            int r0 = (r12 > r12 ? 1 : (r12 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x0090
            int r0 = r14.length
            r1 = 3
            if (r0 >= r1) goto L_0x005a
            double r0 = org.mozilla.javascript.ScriptRuntime.f6513t
            goto L_0x0034
        L_0x005a:
            r12 = 0
        L_0x005c:
            r7 = 0
            int r9 = r14.length
            r0 = 3
            if (r4 < r0) goto L_0x0097
            if (r9 <= 0) goto L_0x0097
            r0 = 0
            r7 = 1
            r0 = r8[r0]
        L_0x0067:
            r2 = 2
            if (r4 < r2) goto L_0x009d
            if (r7 >= r9) goto L_0x009d
            int r5 = r7 + 1
            r2 = r8[r7]
        L_0x0070:
            if (r4 <= 0) goto L_0x00a4
            if (r5 >= r9) goto L_0x00a4
            r4 = r8[r5]
        L_0x0076:
            double r0 = m6006a(r0, r2, r4)
            double r2 = m6018b(r12)
            r4 = 4725570615333879808(0x4194997000000000, double:8.64E7)
            double r0 = r0 * r4
            double r0 = r0 + r2
            if (r6 == 0) goto L_0x008b
            double r0 = m6031k(r0)
        L_0x008b:
            double r0 = m6036p(r0)
            goto L_0x0034
        L_0x0090:
            if (r6 == 0) goto L_0x005c
            double r12 = m6030j(r12)
            goto L_0x005c
        L_0x0097:
            int r0 = m6025e(r12)
            double r0 = (double) r0
            goto L_0x0067
        L_0x009d:
            int r2 = m6026f(r12)
            double r2 = (double) r2
            r5 = r7
            goto L_0x0070
        L_0x00a4:
            int r4 = m6027g(r12)
            double r4 = (double) r4
            goto L_0x0076
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.m6019b(double, java.lang.Object[], int):double");
    }

    /* access modifiers changed from: protected */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int findPrototypeId(String r9) {
        /*
            r8 = this;
            r6 = 116(0x74, float:1.63E-43)
            r2 = 3
            r5 = 115(0x73, float:1.61E-43)
            r4 = 103(0x67, float:1.44E-43)
            r0 = 0
            r1 = 0
            int r3 = r9.length()
            switch(r3) {
                case 6: goto L_0x001d;
                case 7: goto L_0x0035;
                case 8: goto L_0x008f;
                case 9: goto L_0x00df;
                case 10: goto L_0x00e8;
                case 11: goto L_0x0146;
                case 12: goto L_0x01d2;
                case 13: goto L_0x01ee;
                case 14: goto L_0x0234;
                case 15: goto L_0x0258;
                case 16: goto L_0x0010;
                case 17: goto L_0x0272;
                case 18: goto L_0x027b;
                default: goto L_0x0010;
            }
        L_0x0010:
            r2 = r1
            r1 = r0
        L_0x0012:
            if (r2 == 0) goto L_0x02b5
            if (r2 == r9) goto L_0x02b5
            boolean r2 = r2.equals(r9)
            if (r2 != 0) goto L_0x02b5
        L_0x001c:
            return r0
        L_0x001d:
            char r2 = r9.charAt(r0)
            if (r2 != r4) goto L_0x002b
            java.lang.String r1 = "getDay"
            r2 = 19
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x002b:
            if (r2 != r6) goto L_0x0010
            java.lang.String r1 = "toJSON"
            r2 = 47
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0035:
            char r2 = r9.charAt(r2)
            switch(r2) {
                case 68: goto L_0x003f;
                case 84: goto L_0x0057;
                case 89: goto L_0x006f;
                case 117: goto L_0x0087;
                default: goto L_0x003c;
            }
        L_0x003c:
            r2 = r1
            r1 = r0
            goto L_0x0012
        L_0x003f:
            char r2 = r9.charAt(r0)
            if (r2 != r4) goto L_0x004d
            java.lang.String r1 = "getDate"
            r2 = 17
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x004d:
            if (r2 != r5) goto L_0x0010
            java.lang.String r1 = "setDate"
            r2 = 39
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0057:
            char r2 = r9.charAt(r0)
            if (r2 != r4) goto L_0x0065
            java.lang.String r1 = "getTime"
            r2 = 11
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0065:
            if (r2 != r5) goto L_0x0010
            java.lang.String r1 = "setTime"
            r2 = 30
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x006f:
            char r2 = r9.charAt(r0)
            if (r2 != r4) goto L_0x007d
            java.lang.String r1 = "getYear"
            r2 = 12
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x007d:
            if (r2 != r5) goto L_0x0010
            java.lang.String r1 = "setYear"
            r2 = 45
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0087:
            java.lang.String r1 = "valueOf"
            r2 = 10
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x008f:
            char r2 = r9.charAt(r2)
            switch(r2) {
                case 72: goto L_0x009a;
                case 77: goto L_0x00b4;
                case 111: goto L_0x00ce;
                case 116: goto L_0x00d7;
                default: goto L_0x0096;
            }
        L_0x0096:
            r2 = r1
            r1 = r0
            goto L_0x0012
        L_0x009a:
            char r2 = r9.charAt(r0)
            if (r2 != r4) goto L_0x00a9
            java.lang.String r1 = "getHours"
            r2 = 21
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x00a9:
            if (r2 != r5) goto L_0x0010
            java.lang.String r1 = "setHours"
            r2 = 37
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x00b4:
            char r2 = r9.charAt(r0)
            if (r2 != r4) goto L_0x00c3
            java.lang.String r1 = "getMonth"
            r2 = 15
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x00c3:
            if (r2 != r5) goto L_0x0010
            java.lang.String r1 = "setMonth"
            r2 = 41
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x00ce:
            java.lang.String r1 = "toSource"
            r2 = 9
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x00d7:
            java.lang.String r1 = "toString"
            r2 = 2
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x00df:
            java.lang.String r1 = "getUTCDay"
            r2 = 20
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x00e8:
            char r2 = r9.charAt(r2)
            r3 = 77
            if (r2 != r3) goto L_0x010a
            char r2 = r9.charAt(r0)
            if (r2 != r4) goto L_0x00ff
            java.lang.String r1 = "getMinutes"
            r2 = 23
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x00ff:
            if (r2 != r5) goto L_0x0010
            java.lang.String r1 = "setMinutes"
            r2 = 35
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x010a:
            r3 = 83
            if (r2 != r3) goto L_0x0128
            char r2 = r9.charAt(r0)
            if (r2 != r4) goto L_0x011d
            java.lang.String r1 = "getSeconds"
            r2 = 25
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x011d:
            if (r2 != r5) goto L_0x0010
            java.lang.String r1 = "setSeconds"
            r2 = 33
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0128:
            r3 = 85
            if (r2 != r3) goto L_0x0010
            char r2 = r9.charAt(r0)
            if (r2 != r4) goto L_0x013b
            java.lang.String r1 = "getUTCDate"
            r2 = 18
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x013b:
            if (r2 != r5) goto L_0x0010
            java.lang.String r1 = "setUTCDate"
            r2 = 40
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0146:
            char r2 = r9.charAt(r2)
            switch(r2) {
                case 70: goto L_0x0151;
                case 77: goto L_0x016b;
                case 83: goto L_0x0174;
                case 84: goto L_0x017d;
                case 85: goto L_0x0186;
                case 115: goto L_0x01ca;
                default: goto L_0x014d;
            }
        L_0x014d:
            r2 = r1
            r1 = r0
            goto L_0x0012
        L_0x0151:
            char r2 = r9.charAt(r0)
            if (r2 != r4) goto L_0x0160
            java.lang.String r1 = "getFullYear"
            r2 = 13
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0160:
            if (r2 != r5) goto L_0x0010
            java.lang.String r1 = "setFullYear"
            r2 = 43
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x016b:
            java.lang.String r1 = "toGMTString"
            r2 = 8
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0174:
            java.lang.String r1 = "toISOString"
            r2 = 46
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x017d:
            java.lang.String r1 = "toUTCString"
            r2 = 8
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0186:
            char r2 = r9.charAt(r0)
            if (r2 != r4) goto L_0x01aa
            r2 = 9
            char r2 = r9.charAt(r2)
            r3 = 114(0x72, float:1.6E-43)
            if (r2 != r3) goto L_0x019f
            java.lang.String r1 = "getUTCHours"
            r2 = 22
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x019f:
            if (r2 != r6) goto L_0x0010
            java.lang.String r1 = "getUTCMonth"
            r2 = 16
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x01aa:
            if (r2 != r5) goto L_0x0010
            r2 = 9
            char r2 = r9.charAt(r2)
            r3 = 114(0x72, float:1.6E-43)
            if (r2 != r3) goto L_0x01bf
            java.lang.String r1 = "setUTCHours"
            r2 = 38
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x01bf:
            if (r2 != r6) goto L_0x0010
            java.lang.String r1 = "setUTCMonth"
            r2 = 42
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x01ca:
            java.lang.String r1 = "constructor"
            r2 = 1
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x01d2:
            r3 = 2
            char r3 = r9.charAt(r3)
            r4 = 68
            if (r3 != r4) goto L_0x01e3
            java.lang.String r1 = "toDateString"
            r2 = 4
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x01e3:
            r4 = 84
            if (r3 != r4) goto L_0x0010
            java.lang.String r1 = "toTimeString"
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x01ee:
            char r2 = r9.charAt(r0)
            if (r2 != r4) goto L_0x0213
            r2 = 6
            char r2 = r9.charAt(r2)
            r3 = 77
            if (r2 != r3) goto L_0x0206
            java.lang.String r1 = "getUTCMinutes"
            r2 = 24
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0206:
            r3 = 83
            if (r2 != r3) goto L_0x0010
            java.lang.String r1 = "getUTCSeconds"
            r2 = 26
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0213:
            if (r2 != r5) goto L_0x0010
            r2 = 6
            char r2 = r9.charAt(r2)
            r3 = 77
            if (r2 != r3) goto L_0x0227
            java.lang.String r1 = "setUTCMinutes"
            r2 = 36
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0227:
            r3 = 83
            if (r2 != r3) goto L_0x0010
            java.lang.String r1 = "setUTCSeconds"
            r2 = 34
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0234:
            char r2 = r9.charAt(r0)
            if (r2 != r4) goto L_0x0243
            java.lang.String r1 = "getUTCFullYear"
            r2 = 14
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0243:
            if (r2 != r5) goto L_0x024e
            java.lang.String r1 = "setUTCFullYear"
            r2 = 44
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x024e:
            if (r2 != r6) goto L_0x0010
            java.lang.String r1 = "toLocaleString"
            r2 = 5
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0258:
            char r2 = r9.charAt(r0)
            if (r2 != r4) goto L_0x0267
            java.lang.String r1 = "getMilliseconds"
            r2 = 27
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0267:
            if (r2 != r5) goto L_0x0010
            java.lang.String r1 = "setMilliseconds"
            r2 = 31
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0272:
            java.lang.String r1 = "getTimezoneOffset"
            r2 = 29
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x027b:
            char r2 = r9.charAt(r0)
            if (r2 != r4) goto L_0x028a
            java.lang.String r1 = "getUTCMilliseconds"
            r2 = 28
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x028a:
            if (r2 != r5) goto L_0x0295
            java.lang.String r1 = "setUTCMilliseconds"
            r2 = 32
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x0295:
            if (r2 != r6) goto L_0x0010
            r2 = 8
            char r2 = r9.charAt(r2)
            r3 = 68
            if (r2 != r3) goto L_0x02a9
            java.lang.String r1 = "toLocaleDateString"
            r2 = 7
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x02a9:
            r3 = 84
            if (r2 != r3) goto L_0x0010
            java.lang.String r1 = "toLocaleTimeString"
            r2 = 6
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0012
        L_0x02b5:
            r0 = r1
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.findPrototypeId(java.lang.String):int");
    }
}
