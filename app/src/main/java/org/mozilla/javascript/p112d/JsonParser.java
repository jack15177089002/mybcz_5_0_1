package org.mozilla.javascript.p112d;

import java.util.ArrayList;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.d.a */
public final class JsonParser {

    /* renamed from: a */
    private Context f6475a;

    /* renamed from: b */
    private Scriptable f6476b;

    /* renamed from: c */
    private int f6477c;

    /* renamed from: d */
    private int f6478d;

    /* renamed from: e */
    private String f6479e;

    public JsonParser(Context lVar, Scriptable drVar) {
        this.f6475a = lVar;
        this.f6476b = drVar;
    }

    /* renamed from: a */
    public final synchronized Object mo18996a(String str) {
        Object a;
        if (str == null) {
            throw new C2169b("Input string may not be null");
        }
        this.f6477c = 0;
        this.f6478d = str.length();
        this.f6479e = str;
        a = m6289a();
        m6292d();
        if (this.f6477c < this.f6478d) {
            throw new C2169b("Expected end of stream at char " + this.f6477c);
        }
        return a;
    }

    /* renamed from: a */
    private Object m6289a() {
        m6292d();
        if (this.f6477c < this.f6478d) {
            String str = this.f6479e;
            int i = this.f6477c;
            this.f6477c = i + 1;
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\"':
                    return m6291c();
                case '-':
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
                    return m6288a(charAt);
                case '[':
                    return m6290b();
                case 'f':
                    if (this.f6478d - this.f6477c >= 4 && this.f6479e.charAt(this.f6477c) == 'a' && this.f6479e.charAt(this.f6477c + 1) == 'l' && this.f6479e.charAt(this.f6477c + 2) == 's' && this.f6479e.charAt(this.f6477c + 3) == 'e') {
                        this.f6477c += 4;
                        return Boolean.FALSE;
                    }
                    throw new C2169b("Unexpected token: f");
                case 'n':
                    if (this.f6478d - this.f6477c >= 3 && this.f6479e.charAt(this.f6477c) == 'u' && this.f6479e.charAt(this.f6477c + 1) == 'l' && this.f6479e.charAt(this.f6477c + 2) == 'l') {
                        this.f6477c += 3;
                        return null;
                    }
                    throw new C2169b("Unexpected token: n");
                case 't':
                    if (this.f6478d - this.f6477c >= 3 && this.f6479e.charAt(this.f6477c) == 'r' && this.f6479e.charAt(this.f6477c + 1) == 'u' && this.f6479e.charAt(this.f6477c + 2) == 'e') {
                        this.f6477c += 3;
                        return Boolean.TRUE;
                    }
                    throw new C2169b("Unexpected token: t");
                case '{':
                    Scriptable a = Context.m6750a(this.f6476b);
                    m6292d();
                    boolean z = false;
                    while (this.f6477c < this.f6478d) {
                        String str2 = this.f6479e;
                        int i2 = this.f6477c;
                        this.f6477c = i2 + 1;
                        switch (str2.charAt(i2)) {
                            case '\"':
                                if (!z) {
                                    String c = m6291c();
                                    m6292d();
                                    if (this.f6477c < this.f6478d) {
                                        String str3 = this.f6479e;
                                        int i3 = this.f6477c;
                                        this.f6477c = i3 + 1;
                                        char charAt2 = str3.charAt(i3);
                                        if (charAt2 == ':') {
                                            Object a2 = m6289a();
                                            long c2 = ScriptRuntime.m6421c(c);
                                            if (c2 < 0) {
                                                a.put(c, a, a2);
                                            } else {
                                                a.put((int) c2, a, a2);
                                            }
                                            z = true;
                                            break;
                                        } else {
                                            throw new C2169b("Expected : found " + charAt2);
                                        }
                                    } else {
                                        throw new C2169b("Expected : but reached end of stream");
                                    }
                                } else {
                                    throw new C2169b("Missing comma in object literal");
                                }
                            case ',':
                                if (z) {
                                    z = false;
                                    break;
                                } else {
                                    throw new C2169b("Unexpected comma in object literal");
                                }
                            case '}':
                                return a;
                            default:
                                throw new C2169b("Unexpected token in object literal");
                        }
                        m6292d();
                    }
                    throw new C2169b("Unterminated object literal");
                default:
                    throw new C2169b("Unexpected token: " + charAt);
            }
        } else {
            throw new C2169b("Empty JSON string");
        }
    }

    /* renamed from: b */
    private Object m6290b() {
        ArrayList arrayList = new ArrayList();
        m6292d();
        boolean z = false;
        while (this.f6477c < this.f6478d) {
            switch (this.f6479e.charAt(this.f6477c)) {
                case ',':
                    if (z) {
                        this.f6477c++;
                        z = false;
                        break;
                    } else {
                        throw new C2169b("Unexpected comma in array literal");
                    }
                case ']':
                    this.f6477c++;
                    return Context.m6752a(this.f6476b, arrayList.toArray());
                default:
                    if (!z) {
                        arrayList.add(m6289a());
                        z = true;
                        break;
                    } else {
                        throw new C2169b("Missing comma in array literal");
                    }
            }
            m6292d();
        }
        throw new C2169b("Unterminated array literal");
    }

    /* renamed from: c */
    private String m6291c() {
        StringBuilder sb = new StringBuilder();
        while (this.f6477c < this.f6478d) {
            String str = this.f6479e;
            int i = this.f6477c;
            this.f6477c = i + 1;
            char charAt = str.charAt(i);
            if (charAt > 31) {
                switch (charAt) {
                    case '\"':
                        return sb.toString();
                    case '\\':
                        if (this.f6477c >= this.f6478d) {
                            throw new C2169b("Unterminated string");
                        }
                        String str2 = this.f6479e;
                        int i2 = this.f6477c;
                        this.f6477c = i2 + 1;
                        char charAt2 = str2.charAt(i2);
                        switch (charAt2) {
                            case '\"':
                                sb.append(CoreConstants.DOUBLE_QUOTE_CHAR);
                                break;
                            case '/':
                                sb.append('/');
                                break;
                            case '\\':
                                sb.append(CoreConstants.ESCAPE_CHAR);
                                break;
                            case 'b':
                                sb.append(8);
                                break;
                            case 'f':
                                sb.append(12);
                                break;
                            case 'n':
                                sb.append(10);
                                break;
                            case 'r':
                                sb.append(13);
                                break;
                            case 't':
                                sb.append(9);
                                break;
                            case 'u':
                                if (this.f6478d - this.f6477c < 5) {
                                    throw new C2169b("Invalid character code: \\u" + this.f6479e.substring(this.f6477c));
                                }
                                try {
                                    sb.append((char) Integer.parseInt(this.f6479e.substring(this.f6477c, this.f6477c + 4), 16));
                                    this.f6477c += 4;
                                    break;
                                } catch (NumberFormatException e) {
                                    throw new C2169b("Invalid character code: " + this.f6479e.substring(this.f6477c, this.f6477c + 4));
                                }
                            default:
                                throw new C2169b("Unexcpected character in string: '\\" + charAt2 + "'");
                        }
                    default:
                        sb.append(charAt);
                        break;
                }
            } else {
                throw new C2169b("String contains control character");
            }
        }
        throw new C2169b("Unterminated string literal");
    }

    /* renamed from: a */
    private Number m6288a(char c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        while (this.f6477c < this.f6478d) {
            char charAt = this.f6479e.charAt(this.f6477c);
            if (!Character.isDigit(charAt) && charAt != '-' && charAt != '+' && charAt != '.' && charAt != 'e' && charAt != 'E') {
                break;
            }
            this.f6477c++;
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        int length = sb2.length();
        int i = 0;
        while (true) {
            if (i < length) {
                try {
                    char charAt2 = sb2.charAt(i);
                    if (!Character.isDigit(charAt2)) {
                        i++;
                    } else if (charAt2 == '0' && length > i + 1 && Character.isDigit(sb2.charAt(i + 1))) {
                        throw new C2169b("Unsupported number format: " + sb2);
                    }
                } catch (NumberFormatException e) {
                    throw new C2169b("Unsupported number format: " + sb2);
                }
            }
        }
        double parseDouble = Double.parseDouble(sb2);
        int i2 = (int) parseDouble;
        if (((double) i2) == parseDouble) {
            return Integer.valueOf(i2);
        }
        return Double.valueOf(parseDouble);
    }

    /* renamed from: d */
    private void m6292d() {
        while (this.f6477c < this.f6478d) {
            switch (this.f6479e.charAt(this.f6477c)) {
                case 9:
                case 10:
                case 13:
                case ' ':
                    this.f6477c++;
                default:
                    return;
            }
        }
    }
}
