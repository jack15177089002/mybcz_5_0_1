package org.mozilla.javascript.regexp;

//import com.tencent.android.tpush.common.Constants;
import org.mozilla.javascript.BaseFunction;
import org.mozilla.javascript.C2193eh;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

public class NativeRegExp extends IdScriptableObject implements Function {
    static final /* synthetic */ boolean $assertionsDisabled = (!NativeRegExp.class.desiredAssertionStatus());
    private static final int ANCHOR_BOL = -2;
    private static final int INDEX_LEN = 2;
    private static final int Id_compile = 1;
    private static final int Id_exec = 4;
    private static final int Id_global = 3;
    private static final int Id_ignoreCase = 4;
    private static final int Id_lastIndex = 1;
    private static final int Id_multiline = 5;
    private static final int Id_prefix = 6;
    private static final int Id_source = 2;
    private static final int Id_test = 5;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    public static final int JSREG_FOLD = 2;
    public static final int JSREG_GLOB = 1;
    public static final int JSREG_MULTILINE = 4;
    public static final int MATCH = 1;
    private static final int MAX_INSTANCE_ID = 5;
    private static final int MAX_PROTOTYPE_ID = 6;
    public static final int PREFIX = 2;
    private static final Object REGEXP_TAG = new Object();
    private static final byte REOP_ALNUM = 9;
    private static final byte REOP_ALT = 31;
    private static final byte REOP_ALTPREREQ = 53;
    private static final byte REOP_ALTPREREQ2 = 55;
    private static final byte REOP_ALTPREREQi = 54;
    private static final byte REOP_ASSERT = 41;
    private static final byte REOP_ASSERTNOTTEST = 44;
    private static final byte REOP_ASSERTTEST = 43;
    private static final byte REOP_ASSERT_NOT = 42;
    private static final byte REOP_BACKREF = 13;
    private static final byte REOP_BOL = 2;
    private static final byte REOP_CLASS = 22;
    private static final byte REOP_DIGIT = 7;
    private static final byte REOP_DOT = 6;
    private static final byte REOP_EMPTY = 1;
    private static final byte REOP_END = 57;
    private static final byte REOP_ENDCHILD = 49;
    private static final byte REOP_EOL = 3;
    private static final byte REOP_FLAT = 14;
    private static final byte REOP_FLAT1 = 15;
    private static final byte REOP_FLAT1i = 17;
    private static final byte REOP_FLATi = 16;
    private static final byte REOP_JUMP = 32;
    private static final byte REOP_LPAREN = 29;
    private static final byte REOP_MINIMALOPT = 47;
    private static final byte REOP_MINIMALPLUS = 46;
    private static final byte REOP_MINIMALQUANT = 48;
    private static final byte REOP_MINIMALREPEAT = 52;
    private static final byte REOP_MINIMALSTAR = 45;
    private static final byte REOP_NCLASS = 23;
    private static final byte REOP_NONALNUM = 10;
    private static final byte REOP_NONDIGIT = 8;
    private static final byte REOP_NONSPACE = 12;
    private static final byte REOP_OPT = 28;
    private static final byte REOP_PLUS = 27;
    private static final byte REOP_QUANT = 25;
    private static final byte REOP_REPEAT = 51;
    private static final byte REOP_RPAREN = 30;
    private static final byte REOP_SIMPLE_END = 23;
    private static final byte REOP_SIMPLE_START = 1;
    private static final byte REOP_SPACE = 11;
    private static final byte REOP_STAR = 26;
    private static final byte REOP_UCFLAT1 = 18;
    private static final byte REOP_UCFLAT1i = 19;
    private static final byte REOP_WBDRY = 4;
    private static final byte REOP_WNONBDRY = 5;
    public static final int TEST = 0;
    private static final boolean debug = false;
    static final long serialVersionUID = 4965263491464903264L;
    double lastIndex;

    /* renamed from: re */
    private RECompiled f6815re;

    public static void init(Context lVar, Scriptable drVar, boolean z) {
        NativeRegExp nativeRegExp = new NativeRegExp();
        nativeRegExp.f6815re = compileRE(lVar, "", null, false);
        nativeRegExp.activatePrototypeMap(6);
        nativeRegExp.setParentScope(drVar);
        nativeRegExp.setPrototype(getObjectPrototype(drVar));
        NativeRegExpCtor nativeRegExpCtor = new NativeRegExpCtor();
        nativeRegExp.defineProperty("constructor", (Object) nativeRegExpCtor, 2);
        ScriptRuntime.m6379a((BaseFunction) nativeRegExpCtor, drVar);
        nativeRegExpCtor.setImmunePrototypeProperty(nativeRegExp);
        if (z) {
            nativeRegExp.sealObject();
            nativeRegExpCtor.sealObject();
        }
        defineProperty(drVar, "RegExp", nativeRegExpCtor, 2);
    }

    NativeRegExp(Scriptable drVar, RECompiled rECompiled) {
        this.f6815re = rECompiled;
        this.lastIndex = 0.0d;
        ScriptRuntime.m6384a((ScriptableObject) this, drVar, C2193eh.RegExp);
    }

    public String getClassName() {
        return "RegExp";
    }

    public String getTypeOf() {
        return "object";
    }

    public Object call(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        return execSub(lVar, drVar, objArr, 1);
    }

    public Scriptable construct(Context lVar, Scriptable drVar, Object[] objArr) {
        return (Scriptable) execSub(lVar, drVar, objArr, 1);
    }

    /* access modifiers changed from: 0000 */
    public Scriptable compile(Context lVar, Scriptable drVar, Object[] objArr) {
        if (objArr.length <= 0 || !(objArr[0] instanceof NativeRegExp)) {
            this.f6815re = compileRE(lVar, objArr.length == 0 ? "" : escapeRegExp(objArr[0]), (objArr.length <= 1 || objArr[1] == Undefined.f6689a) ? null : ScriptRuntime.m6436d(objArr[1]), false);
            this.lastIndex = 0.0d;
        } else if (objArr.length <= 1 || objArr[1] == Undefined.f6689a) {
//            NativeRegExp nativeRegExp = objArr[0];
//            this.f6815re = nativeRegExp.f6815re;
//            this.lastIndex = nativeRegExp.lastIndex;
        } else {
            throw ScriptRuntime.m6455g("msg.bad.regexp.compile");
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        if (this.f6815re.source.length != 0) {
            sb.append(this.f6815re.source);
        } else {
            sb.append("(?:)");
        }
        sb.append('/');
        if ((this.f6815re.flags & 1) != 0) {
            sb.append('g');
        }
        if ((this.f6815re.flags & 2) != 0) {
            sb.append('i');
        }
        if ((this.f6815re.flags & 4) != 0) {
            sb.append('m');
        }
        return sb.toString();
    }

    NativeRegExp() {
    }

    private static RegExpImpl getImpl(Context lVar) {
        return (RegExpImpl) ScriptRuntime.m6449f(lVar);
    }

    private static String escapeRegExp(Object obj) {
        String d = ScriptRuntime.m6436d(obj);
        int i = 0;
        StringBuilder sb = null;
        int indexOf = d.indexOf(47);
        while (indexOf >= 0) {
            if (indexOf == i || d.charAt(indexOf - 1) != '\\') {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(d, i, indexOf);
                sb.append("\\/");
                i = indexOf + 1;
            }
            int i2 = i;
            StringBuilder sb2 = sb;
            int i3 = i2;
            indexOf = d.indexOf(47, indexOf + 1);
            int i4 = i3;
            sb = sb2;
            i = i4;
        }
        if (sb == null) {
            return d;
        }
        sb.append(d, i, d.length());
        return sb.toString();
    }

    private Object execSub(Context lVar, Scriptable drVar, Object[] objArr, int i) {
        String d;
        double d2;
        RegExpImpl impl = getImpl(lVar);
        if (objArr.length == 0) {
            d = impl.input;
            if (d == null) {
                reportError("msg.no.re.input.for", toString());
            }
        } else {
            d = ScriptRuntime.m6436d(objArr[0]);
        }
        if ((this.f6815re.flags & 1) != 0) {
            d2 = this.lastIndex;
        } else {
            d2 = 0.0d;
        }
        if (d2 < 0.0d || ((double) d.length()) < d2) {
            this.lastIndex = 0.0d;
            return null;
        }
        int[] iArr = {(int) d2};
        Object executeRegExp = executeRegExp(lVar, drVar, impl, d, iArr, i);
        if ((this.f6815re.flags & 1) != 0) {
            this.lastIndex = (executeRegExp == null || executeRegExp == Undefined.f6689a) ? 0.0d : (double) iArr[0];
        }
        return executeRegExp;
    }

    static RECompiled compileRE(Context lVar, String str, String str2, boolean z) {
        int i;
        RECompiled rECompiled = new RECompiled(str);
        int length = str.length();
        if (str2 != null) {
            i = 0;
            for (int i2 = 0; i2 < str2.length(); i2++) {
                char charAt = str2.charAt(i2);
                if (charAt == 'g') {
                    i |= 1;
                } else if (charAt == 'i') {
                    i |= 2;
                } else if (charAt == 'm') {
                    i |= 4;
                } else {
                    reportError("msg.invalid.re.flag", String.valueOf(charAt));
                }
            }
        } else {
            i = 0;
        }
        rECompiled.flags = i;
        CompilerState compilerState = new CompilerState(lVar, rECompiled.source, length, i);
        if (z && length > 0) {
            compilerState.result = new RENode(REOP_FLAT);
            compilerState.result.chr = compilerState.cpbegin[0];
            compilerState.result.length = length;
            compilerState.result.flatIndex = 0;
            compilerState.progLength += 5;
        } else if (!parseDisjunction(compilerState)) {
            return null;
        }
        rECompiled.program = new byte[(compilerState.progLength + 1)];
        if (compilerState.classCount != 0) {
            rECompiled.classList = new RECharSet[compilerState.classCount];
            rECompiled.classCount = compilerState.classCount;
        }
        rECompiled.program[emitREBytecode(compilerState, rECompiled, 0, compilerState.result)] = REOP_END;
        rECompiled.parenCount = compilerState.parenCount;
        switch (rECompiled.program[0]) {
            case 2:
                rECompiled.anchorCh = -2;
                break;
            case 14:
            case 16:
                rECompiled.anchorCh = rECompiled.source[getIndex(rECompiled.program, 1)];
                break;
            case 15:
            case 17:
//                rECompiled.anchorCh = (char) (rECompiled.program[1] & Constants.NETWORK_TYPE_UNCONNECTED);
                break;
            case 18:
            case 19:
                rECompiled.anchorCh = (char) getIndex(rECompiled.program, 1);
                break;
            case 31:
                RENode rENode = compilerState.result;
                if (rENode.kid.f6820op == 2 && rENode.kid2.f6820op == 2) {
                    rECompiled.anchorCh = -2;
                    break;
                }
        }
        return rECompiled;
    }

    static boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    private static boolean isWord(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || isDigit(c) || c == '_';
    }

    private static boolean isControlLetter(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    private static boolean isLineTerm(char c) {
        return ScriptRuntime.m6389a((int) c);
    }

    private static boolean isREWhiteSpace(int i) {
        return ScriptRuntime.m6416b(i);
    }

    private static char upcase(char c) {
        if (c >= 128) {
            char upperCase = Character.toUpperCase(c);
            return upperCase >= 128 ? upperCase : c;
        } else if ('a' > c || c > 'z') {
            return c;
        } else {
            return (char) (c - ' ');
        }
    }

    private static char downcase(char c) {
        if (c >= 128) {
            char lowerCase = Character.toLowerCase(c);
            return lowerCase >= 128 ? lowerCase : c;
        } else if ('A' > c || c > 'Z') {
            return c;
        } else {
            return (char) (c + ' ');
        }
    }

    private static int toASCIIHexDigit(int i) {
        if (i < 48) {
            return -1;
        }
        if (i <= 57) {
            return i - 48;
        }
        int i2 = i | 32;
        if (97 > i2 || i2 > 102) {
            return -1;
        }
        return (i2 - 97) + 10;
    }

    private static boolean parseDisjunction(CompilerState compilerState) {
        if (!parseAlternative(compilerState)) {
            return false;
        }
        char[] cArr = compilerState.cpbegin;
        int i = compilerState.f6813cp;
        if (i != cArr.length && cArr[i] == '|') {
            compilerState.f6813cp++;
            RENode rENode = new RENode(REOP_ALT);
            rENode.kid = compilerState.result;
            if (!parseDisjunction(compilerState)) {
                return false;
            }
            rENode.kid2 = compilerState.result;
            compilerState.result = rENode;
            if (rENode.kid.f6820op == 14 && rENode.kid2.f6820op == 14) {
                rENode.f6820op = (compilerState.flags & 2) == 0 ? REOP_ALTPREREQ : REOP_ALTPREREQi;
                rENode.chr = rENode.kid.chr;
                rENode.index = rENode.kid2.chr;
                compilerState.progLength += 13;
            } else if (rENode.kid.f6820op == 22 && rENode.kid.index < 256 && rENode.kid2.f6820op == 14 && (compilerState.flags & 2) == 0) {
                rENode.f6820op = REOP_ALTPREREQ2;
                rENode.chr = rENode.kid2.chr;
                rENode.index = rENode.kid.index;
                compilerState.progLength += 13;
            } else if (rENode.kid.f6820op == 14 && rENode.kid2.f6820op == 22 && rENode.kid2.index < 256 && (compilerState.flags & 2) == 0) {
                rENode.f6820op = REOP_ALTPREREQ2;
                rENode.chr = rENode.kid.chr;
                rENode.index = rENode.kid2.index;
                compilerState.progLength += 13;
            } else {
                compilerState.progLength += 9;
            }
        }
        return true;
    }

    private static boolean parseAlternative(CompilerState compilerState) {
        RENode rENode = null;
        char[] cArr = compilerState.cpbegin;
        RENode rENode2 = null;
        while (compilerState.f6813cp != compilerState.cpend && cArr[compilerState.f6813cp] != '|' && (compilerState.parenNesting == 0 || cArr[compilerState.f6813cp] != ')')) {
            if (!parseTerm(compilerState)) {
                return false;
            }
            if (rENode2 == null) {
                rENode = compilerState.result;
                rENode2 = rENode;
            } else {
                rENode.next = compilerState.result;
            }
            while (rENode.next != null) {
                rENode = rENode.next;
            }
        }
        if (rENode2 == null) {
            compilerState.result = new RENode((byte) 1);
        } else {
            compilerState.result = rENode2;
        }
        return true;
    }

    private static boolean calculateBitmapSize(CompilerState compilerState, RENode rENode, char[] cArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z = false;
        int i10;
        int i11 = 0;
        boolean z2 = false;
        rENode.bmsize = 0;
        rENode.sense = true;
        if (i == i2) {
            return true;
        }
        if (cArr[i] == 94) {
            i4 = i + 1;
            rENode.sense = false;
            i3 = 0;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 != i2) {
            int i12 = 2;
            switch (cArr[i4]) {
                case '\\':
                    int i13 = i4 + 1;
                    int i14 = i13 + 1;
                    char c = cArr[i13];
                    switch (c) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                            int i15 = c - 48;
                            char c2 = cArr[i14];
                            if (48 <= c2 && c2 <= 55) {
                                int i16 = i14 + 1;
                                int i17 = (c2 - 48) + (i15 * 8);
                                char c3 = cArr[i16];
                                if (48 > c3 || c3 > 55) {
                                    i15 = i17;
                                    i14 = i16;
                                } else {
                                    int i18 = i16 + 1;
                                    i15 = (c3 - 48) + (i17 * 8);
                                    if (i15 <= 255) {
                                        i14 = i18;
                                    } else {
                                        int i19 = i17;
                                        i14 = i18 - 1;
                                        i15 = i19;
                                    }
                                }
                            }
                            i5 = i15;
                            i6 = i14;
                            break;
                        case 'D':
                        case 'S':
                        case 'W':
                        case 's':
                        case 'w':
                            if (z2) {
                                reportError("msg.bad.range", "");
                                return false;
                            }
                            rENode.bmsize = 65536;
                            return true;
                        case 'b':
                            i5 = 8;
                            i6 = i14;
                            break;
                        case 'c':
                            if (i14 >= i2 || !isControlLetter(cArr[i14])) {
                                i9 = i14 - 1;
                            } else {
                                i9 = i14 + 1;
                            }
                            i5 = 92;
                            i6 = i9;
                            break;
                        case 'd':
                            if (!z2) {
                                i5 = 57;
                                i6 = i14;
                                break;
                            } else {
                                reportError("msg.bad.range", "");
                                return false;
                            }
                        case 'f':
                            i5 = 12;
                            i6 = i14;
                            break;
                        case 'n':
                            i5 = 10;
                            i6 = i14;
                            break;
                        case 'r':
                            i5 = 13;
                            i6 = i14;
                            break;
                        case 't':
                            i5 = 9;
                            i6 = i14;
                            break;
                        case 'u':
                            i12 = 4;
                            break;
                        case 'v':
                            i5 = 11;
                            i6 = i14;
                            break;
                        case 'x':
                            break;
                        default:
                            i6 = i14;
                            i5 = c;
                            break;
                    }
                    int i20 = 0;
                    int i21 = i14;
                    int i22 = 0;
                    while (true) {
                        if (i20 >= i12 || i21 >= i2) {
                            i7 = i22;
                            i8 = i21;
                        } else {
                            int i23 = i21 + 1;
                            i22 = Kit.m5803a((int) cArr[i21], i22);
                            if (i22 < 0) {
                                i8 = i23 - (i20 + 1);
                                i7 = 92;
                            } else {
                                i20++;
                                i21 = i23;
                            }
                        }
                    }
//                    i7 = i22;
//                    i8 = i21;
//                    i5 = i7;
//                    i6 = i8;
//                    break;
                default:
                    int i24 = i4 + 1;
                    i5 = cArr[i4];
                    i6 = i24;
                    break;
            }
            if (z2) {
                if (i3 > i5) {
                    reportError("msg.bad.range", "");
                    return false;
                }
                z = false;
            } else if (i6 >= i2 - 1 || cArr[i6] != 45) {
                z = z2;
            } else {
                i6++;
                z2 = true;
                i3 = (char) i5;
            }
            if ((compilerState.flags & 2) != 0) {
                i10 = upcase((char) i5);
                int downcase = downcase((char) i5);
                if (i10 < downcase) {
                    i10 = downcase;
                }
            } else {
                i10 = i5;
            }
            if (i10 <= i11) {
                i10 = i11;
            }
            z2 = z;
            i11 = i10;
        }
        rENode.bmsize = i11 + 1;
        return true;
    }

    private static void doFlat(CompilerState compilerState, char c) {
        compilerState.result = new RENode(REOP_FLAT);
        compilerState.result.chr = c;
        compilerState.result.length = 1;
        compilerState.result.flatIndex = -1;
        compilerState.progLength += 3;
    }

    private static int getDecimalValue(char c, CompilerState compilerState, int i, String str) {
        boolean z = false;
        int i2 = compilerState.f6813cp;
        char[] cArr = compilerState.cpbegin;
        int i3 = c - '0';
        while (compilerState.f6813cp != compilerState.cpend) {
            char c2 = cArr[compilerState.f6813cp];
            if (!isDigit(c2)) {
                break;
            }
            if (!z) {
                int i4 = c2 - '0';
                if (i3 < (i - i4) / 10) {
                    i3 = (i3 * 10) + i4;
                } else {
                    z = true;
                    i3 = i;
                }
            }
            compilerState.f6813cp++;
        }
        if (z) {
            reportError(str, String.valueOf(cArr, i2, compilerState.f6813cp - i2));
        }
        return i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x0425  */
    /* JADX WARNING: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0276  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean parseTerm(org.mozilla.javascript.regexp.CompilerState r13) {
        /*
            r11 = 9
            r4 = -1
            r10 = 25
            r3 = 1
            r1 = 0
            char[] r7 = r13.cpbegin
            int r0 = r13.f6813cp
            int r2 = r0 + 1
            r13.f6813cp = r2
            char r2 = r7[r0]
            r0 = 2
            int r8 = r13.parenCount
            switch(r2) {
                case 36: goto L_0x0050;
                case 40: goto L_0x0230;
                case 41: goto L_0x02cb;
                case 42: goto L_0x0346;
                case 43: goto L_0x0346;
                case 46: goto L_0x0336;
                case 63: goto L_0x0346;
                case 91: goto L_0x02d4;
                case 92: goto L_0x0060;
                case 94: goto L_0x0040;
                default: goto L_0x0017;
            }
        L_0x0017:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r5 = 14
            r0.<init>(r5)
            r13.result = r0
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            r0.chr = r2
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            r0.length = r3
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            int r2 = r13.f6813cp
            int r2 = r2 + -1
            r0.flatIndex = r2
            int r0 = r13.progLength
            int r0 = r0 + 3
            r13.progLength = r0
        L_0x0036:
            org.mozilla.javascript.regexp.RENode r5 = r13.result
            int r0 = r13.f6813cp
            int r2 = r13.cpend
            if (r0 != r2) goto L_0x0357
            r1 = r3
        L_0x003f:
            return r1
        L_0x0040:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r1 = 2
            r0.<init>(r1)
            r13.result = r0
            int r0 = r13.progLength
            int r0 = r0 + 1
            r13.progLength = r0
            r1 = r3
            goto L_0x003f
        L_0x0050:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r1 = 3
            r0.<init>(r1)
            r13.result = r0
            int r0 = r13.progLength
            int r0 = r0 + 1
            r13.progLength = r0
            r1 = r3
            goto L_0x003f
        L_0x0060:
            int r2 = r13.f6813cp
            int r5 = r13.cpend
            if (r2 >= r5) goto L_0x0227
            int r2 = r13.f6813cp
            int r5 = r2 + 1
            r13.f6813cp = r5
            char r2 = r7[r2]
            switch(r2) {
                case 48: goto L_0x00b1;
                case 49: goto L_0x00e4;
                case 50: goto L_0x00e4;
                case 51: goto L_0x00e4;
                case 52: goto L_0x00e4;
                case 53: goto L_0x00e4;
                case 54: goto L_0x00e4;
                case 55: goto L_0x00e4;
                case 56: goto L_0x00e4;
                case 57: goto L_0x00e4;
                case 66: goto L_0x00a1;
                case 68: goto L_0x01d4;
                case 83: goto L_0x01f6;
                case 87: goto L_0x0216;
                case 98: goto L_0x0091;
                case 99: goto L_0x0168;
                case 100: goto L_0x01c4;
                case 102: goto L_0x0147;
                case 110: goto L_0x014e;
                case 114: goto L_0x0155;
                case 115: goto L_0x01e5;
                case 116: goto L_0x015c;
                case 117: goto L_0x0191;
                case 118: goto L_0x0161;
                case 119: goto L_0x0207;
                case 120: goto L_0x0192;
                default: goto L_0x0071;
            }
        L_0x0071:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r5 = 14
            r0.<init>(r5)
            r13.result = r0
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            r0.chr = r2
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            r0.length = r3
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            int r2 = r13.f6813cp
            int r2 = r2 + -1
            r0.flatIndex = r2
            int r0 = r13.progLength
            int r0 = r0 + 3
            r13.progLength = r0
            goto L_0x0036
        L_0x0091:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r1 = 4
            r0.<init>(r1)
            r13.result = r0
            int r0 = r13.progLength
            int r0 = r0 + 1
            r13.progLength = r0
            r1 = r3
            goto L_0x003f
        L_0x00a1:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r1 = 5
            r0.<init>(r1)
            r13.result = r0
            int r0 = r13.progLength
            int r0 = r0 + 1
            r13.progLength = r0
            r1 = r3
            goto L_0x003f
        L_0x00b1:
            org.mozilla.javascript.l r0 = r13.f6814cx
            java.lang.String r2 = "msg.bad.backref"
            java.lang.String r5 = ""
            reportWarning(r0, r2, r5)
            r0 = r1
        L_0x00bb:
            int r2 = r13.f6813cp
            int r5 = r13.cpend
            if (r2 >= r5) goto L_0x00de
            int r2 = r13.f6813cp
            char r2 = r7[r2]
            r5 = 48
            if (r2 < r5) goto L_0x00de
            r5 = 55
            if (r2 > r5) goto L_0x00de
            int r5 = r13.f6813cp
            int r5 = r5 + 1
            r13.f6813cp = r5
            int r5 = r0 * 8
            int r2 = r2 + -48
            int r2 = r2 + r5
            r5 = 255(0xff, float:3.57E-43)
            if (r2 > r5) goto L_0x00de
            r0 = r2
            goto L_0x00bb
        L_0x00de:
            char r0 = (char) r0
            doFlat(r13, r0)
            goto L_0x0036
        L_0x00e4:
            int r0 = r13.f6813cp
            int r0 = r0 + -1
            r5 = 65535(0xffff, float:9.1834E-41)
            java.lang.String r6 = "msg.overlarge.backref"
            int r2 = getDecimalValue(r2, r13, r5, r6)
            int r5 = r13.parenCount
            if (r2 <= r5) goto L_0x00fe
            org.mozilla.javascript.l r5 = r13.f6814cx
            java.lang.String r6 = "msg.bad.backref"
            java.lang.String r9 = ""
            reportWarning(r5, r6, r9)
        L_0x00fe:
            if (r2 <= r11) goto L_0x0130
            int r5 = r13.parenCount
            if (r2 <= r5) goto L_0x0130
            r13.f6813cp = r0
            r0 = r1
        L_0x0107:
            int r2 = r13.f6813cp
            int r5 = r13.cpend
            if (r2 >= r5) goto L_0x012a
            int r2 = r13.f6813cp
            char r2 = r7[r2]
            r5 = 48
            if (r2 < r5) goto L_0x012a
            r5 = 55
            if (r2 > r5) goto L_0x012a
            int r5 = r13.f6813cp
            int r5 = r5 + 1
            r13.f6813cp = r5
            int r5 = r0 * 8
            int r2 = r2 + -48
            int r2 = r2 + r5
            r5 = 255(0xff, float:3.57E-43)
            if (r2 > r5) goto L_0x012a
            r0 = r2
            goto L_0x0107
        L_0x012a:
            char r0 = (char) r0
            doFlat(r13, r0)
            goto L_0x0036
        L_0x0130:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r5 = 13
            r0.<init>(r5)
            r13.result = r0
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            int r2 = r2 + -1
            r0.parenIndex = r2
            int r0 = r13.progLength
            int r0 = r0 + 3
            r13.progLength = r0
            goto L_0x0036
        L_0x0147:
            r0 = 12
            doFlat(r13, r0)
            goto L_0x0036
        L_0x014e:
            r0 = 10
            doFlat(r13, r0)
            goto L_0x0036
        L_0x0155:
            r0 = 13
            doFlat(r13, r0)
            goto L_0x0036
        L_0x015c:
            doFlat(r13, r11)
            goto L_0x0036
        L_0x0161:
            r0 = 11
            doFlat(r13, r0)
            goto L_0x0036
        L_0x0168:
            int r0 = r13.f6813cp
            int r2 = r13.cpend
            if (r0 >= r2) goto L_0x0188
            int r0 = r13.f6813cp
            char r0 = r7[r0]
            boolean r0 = isControlLetter(r0)
            if (r0 == 0) goto L_0x0188
            int r0 = r13.f6813cp
            int r2 = r0 + 1
            r13.f6813cp = r2
            char r0 = r7[r0]
            r0 = r0 & 31
            char r0 = (char) r0
        L_0x0183:
            doFlat(r13, r0)
            goto L_0x0036
        L_0x0188:
            int r0 = r13.f6813cp
            int r0 = r0 + -1
            r13.f6813cp = r0
            r0 = 92
            goto L_0x0183
        L_0x0191:
            r0 = 4
        L_0x0192:
            r5 = r1
            r2 = r1
        L_0x0194:
            if (r5 >= r0) goto L_0x0464
            int r6 = r13.f6813cp
            int r9 = r13.cpend
            if (r6 >= r9) goto L_0x0464
            int r6 = r13.f6813cp
            int r9 = r6 + 1
            r13.f6813cp = r9
            char r6 = r7[r6]
            int r6 = org.mozilla.javascript.Kit.m5803a(r6, r2)
            if (r6 >= 0) goto L_0x01bf
            int r0 = r13.f6813cp
            int r2 = r5 + 2
            int r0 = r0 - r2
            r13.f6813cp = r0
            int r0 = r13.f6813cp
            int r2 = r0 + 1
            r13.f6813cp = r2
            char r0 = r7[r0]
        L_0x01b9:
            char r0 = (char) r0
            doFlat(r13, r0)
            goto L_0x0036
        L_0x01bf:
            int r2 = r5 + 1
            r5 = r2
            r2 = r6
            goto L_0x0194
        L_0x01c4:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r2 = 7
            r0.<init>(r2)
            r13.result = r0
            int r0 = r13.progLength
            int r0 = r0 + 1
            r13.progLength = r0
            goto L_0x0036
        L_0x01d4:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r2 = 8
            r0.<init>(r2)
            r13.result = r0
            int r0 = r13.progLength
            int r0 = r0 + 1
            r13.progLength = r0
            goto L_0x0036
        L_0x01e5:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r2 = 11
            r0.<init>(r2)
            r13.result = r0
            int r0 = r13.progLength
            int r0 = r0 + 1
            r13.progLength = r0
            goto L_0x0036
        L_0x01f6:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r2 = 12
            r0.<init>(r2)
            r13.result = r0
            int r0 = r13.progLength
            int r0 = r0 + 1
            r13.progLength = r0
            goto L_0x0036
        L_0x0207:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r0.<init>(r11)
            r13.result = r0
            int r0 = r13.progLength
            int r0 = r0 + 1
            r13.progLength = r0
            goto L_0x0036
        L_0x0216:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r2 = 10
            r0.<init>(r2)
            r13.result = r0
            int r0 = r13.progLength
            int r0 = r0 + 1
            r13.progLength = r0
            goto L_0x0036
        L_0x0227:
            java.lang.String r0 = "msg.trail.backslash"
            java.lang.String r2 = ""
            reportError(r0, r2)
            goto L_0x003f
        L_0x0230:
            r0 = 0
            int r2 = r13.f6813cp
            int r2 = r2 + 1
            int r5 = r13.cpend
            if (r2 >= r5) goto L_0x029f
            int r2 = r13.f6813cp
            char r2 = r7[r2]
            r5 = 63
            if (r2 != r5) goto L_0x029f
            int r2 = r13.f6813cp
            int r2 = r2 + 1
            char r2 = r7[r2]
            r5 = 61
            if (r2 == r5) goto L_0x0253
            r5 = 33
            if (r2 == r5) goto L_0x0253
            r5 = 58
            if (r2 != r5) goto L_0x029f
        L_0x0253:
            int r5 = r13.f6813cp
            int r5 = r5 + 2
            r13.f6813cp = r5
            r5 = 61
            if (r2 != r5) goto L_0x028d
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r2 = 41
            r0.<init>(r2)
            int r2 = r13.progLength
            int r2 = r2 + 4
            r13.progLength = r2
        L_0x026a:
            int r2 = r13.parenNesting
            int r2 = r2 + 1
            r13.parenNesting = r2
            boolean r2 = parseDisjunction(r13)
            if (r2 == 0) goto L_0x003f
            int r2 = r13.f6813cp
            int r5 = r13.cpend
            if (r2 == r5) goto L_0x0284
            int r2 = r13.f6813cp
            char r2 = r7[r2]
            r5 = 41
            if (r2 == r5) goto L_0x02b5
        L_0x0284:
            java.lang.String r0 = "msg.unterm.paren"
            java.lang.String r2 = ""
            reportError(r0, r2)
            goto L_0x003f
        L_0x028d:
            r5 = 33
            if (r2 != r5) goto L_0x026a
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r2 = 42
            r0.<init>(r2)
            int r2 = r13.progLength
            int r2 = r2 + 4
            r13.progLength = r2
            goto L_0x026a
        L_0x029f:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r2 = 29
            r0.<init>(r2)
            int r2 = r13.progLength
            int r2 = r2 + 6
            r13.progLength = r2
            int r2 = r13.parenCount
            int r5 = r2 + 1
            r13.parenCount = r5
            r0.parenIndex = r2
            goto L_0x026a
        L_0x02b5:
            int r2 = r13.f6813cp
            int r2 = r2 + 1
            r13.f6813cp = r2
            int r2 = r13.parenNesting
            int r2 = r2 + -1
            r13.parenNesting = r2
            if (r0 == 0) goto L_0x0036
            org.mozilla.javascript.regexp.RENode r2 = r13.result
            r0.kid = r2
            r13.result = r0
            goto L_0x0036
        L_0x02cb:
            java.lang.String r0 = "msg.re.unmatched.right.paren"
            java.lang.String r2 = ""
            reportError(r0, r2)
            goto L_0x003f
        L_0x02d4:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r2 = 22
            r0.<init>(r2)
            r13.result = r0
            int r0 = r13.f6813cp
            org.mozilla.javascript.regexp.RENode r2 = r13.result
            r2.startIndex = r0
        L_0x02e3:
            int r2 = r13.f6813cp
            int r5 = r13.cpend
            if (r2 != r5) goto L_0x02f2
            java.lang.String r0 = "msg.unterm.class"
            java.lang.String r2 = ""
            reportError(r0, r2)
            goto L_0x003f
        L_0x02f2:
            int r2 = r13.f6813cp
            char r2 = r7[r2]
            r5 = 92
            if (r2 != r5) goto L_0x0307
            int r2 = r13.f6813cp
            int r2 = r2 + 1
            r13.f6813cp = r2
        L_0x0300:
            int r2 = r13.f6813cp
            int r2 = r2 + 1
            r13.f6813cp = r2
            goto L_0x02e3
        L_0x0307:
            int r2 = r13.f6813cp
            char r2 = r7[r2]
            r5 = 93
            if (r2 != r5) goto L_0x0300
            org.mozilla.javascript.regexp.RENode r2 = r13.result
            int r5 = r13.f6813cp
            int r5 = r5 - r0
            r2.kidlen = r5
            org.mozilla.javascript.regexp.RENode r2 = r13.result
            int r5 = r13.classCount
            int r6 = r5 + 1
            r13.classCount = r6
            r2.index = r5
            org.mozilla.javascript.regexp.RENode r2 = r13.result
            int r5 = r13.f6813cp
            int r6 = r5 + 1
            r13.f6813cp = r6
            boolean r0 = calculateBitmapSize(r13, r2, r7, r0, r5)
            if (r0 == 0) goto L_0x003f
            int r0 = r13.progLength
            int r0 = r0 + 3
            r13.progLength = r0
            goto L_0x0036
        L_0x0336:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r2 = 6
            r0.<init>(r2)
            r13.result = r0
            int r0 = r13.progLength
            int r0 = r0 + 1
            r13.progLength = r0
            goto L_0x0036
        L_0x0346:
            java.lang.String r0 = "msg.bad.quant"
            int r2 = r13.f6813cp
            int r2 = r2 + -1
            char r2 = r7[r2]
            java.lang.String r2 = java.lang.String.valueOf(r2)
            reportError(r0, r2)
            goto L_0x003f
        L_0x0357:
            int r0 = r13.f6813cp
            char r0 = r7[r0]
            switch(r0) {
                case 42: goto L_0x037b;
                case 43: goto L_0x0364;
                case 63: goto L_0x0392;
                case 123: goto L_0x03a9;
                default: goto L_0x035e;
            }
        L_0x035e:
            r0 = r1
        L_0x035f:
            if (r0 != 0) goto L_0x0429
            r1 = r3
            goto L_0x003f
        L_0x0364:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r0.<init>(r10)
            r13.result = r0
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            r0.min = r3
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            r0.max = r4
            int r0 = r13.progLength
            int r0 = r0 + 8
            r13.progLength = r0
            r0 = r3
            goto L_0x035f
        L_0x037b:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r0.<init>(r10)
            r13.result = r0
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            r0.min = r1
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            r0.max = r4
            int r0 = r13.progLength
            int r0 = r0 + 8
            r13.progLength = r0
            r0 = r3
            goto L_0x035f
        L_0x0392:
            org.mozilla.javascript.regexp.RENode r0 = new org.mozilla.javascript.regexp.RENode
            r0.<init>(r10)
            r13.result = r0
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            r0.min = r1
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            r0.max = r3
            int r0 = r13.progLength
            int r0 = r0 + 8
            r13.progLength = r0
            r0 = r3
            goto L_0x035f
        L_0x03a9:
            int r6 = r13.f6813cp
            int r0 = r13.f6813cp
            int r0 = r0 + 1
            r13.f6813cp = r0
            int r2 = r7.length
            if (r0 >= r2) goto L_0x045e
            int r0 = r13.f6813cp
            char r0 = r7[r0]
            boolean r2 = isDigit(r0)
            if (r2 == 0) goto L_0x045e
            int r2 = r13.f6813cp
            int r2 = r2 + 1
            r13.f6813cp = r2
            r2 = 65535(0xffff, float:9.1834E-41)
            java.lang.String r9 = "msg.overlarge.min"
            int r2 = getDecimalValue(r0, r13, r2, r9)
            int r0 = r13.f6813cp
            char r0 = r7[r0]
            r9 = 44
            if (r0 != r9) goto L_0x0407
            int r0 = r13.f6813cp
            int r0 = r0 + 1
            r13.f6813cp = r0
            char r0 = r7[r0]
            boolean r9 = isDigit(r0)
            if (r9 == 0) goto L_0x0460
            int r4 = r13.f6813cp
            int r4 = r4 + 1
            r13.f6813cp = r4
            r4 = 65535(0xffff, float:9.1834E-41)
            java.lang.String r9 = "msg.overlarge.max"
            int r0 = getDecimalValue(r0, r13, r4, r9)
            int r4 = r13.f6813cp
            char r4 = r7[r4]
            if (r2 <= r0) goto L_0x0409
            java.lang.String r0 = "msg.max.lt.min"
            int r2 = r13.f6813cp
            char r2 = r7[r2]
            java.lang.String r2 = java.lang.String.valueOf(r2)
            reportError(r0, r2)
            goto L_0x003f
        L_0x0407:
            r4 = r0
            r0 = r2
        L_0x0409:
            r9 = 125(0x7d, float:1.75E-43)
            if (r4 != r9) goto L_0x045e
            org.mozilla.javascript.regexp.RENode r4 = new org.mozilla.javascript.regexp.RENode
            r4.<init>(r10)
            r13.result = r4
            org.mozilla.javascript.regexp.RENode r4 = r13.result
            r4.min = r2
            org.mozilla.javascript.regexp.RENode r2 = r13.result
            r2.max = r0
            int r0 = r13.progLength
            int r0 = r0 + 12
            r13.progLength = r0
            r0 = r3
        L_0x0423:
            if (r0 != 0) goto L_0x035f
            r13.f6813cp = r6
            goto L_0x035f
        L_0x0429:
            int r0 = r13.f6813cp
            int r0 = r0 + 1
            r13.f6813cp = r0
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            r0.kid = r5
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            r0.parenIndex = r8
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            int r2 = r13.parenCount
            int r2 = r2 - r8
            r0.parenCount = r2
            int r0 = r13.f6813cp
            int r2 = r13.cpend
            if (r0 >= r2) goto L_0x0459
            int r0 = r13.f6813cp
            char r0 = r7[r0]
            r2 = 63
            if (r0 != r2) goto L_0x0459
            int r0 = r13.f6813cp
            int r0 = r0 + 1
            r13.f6813cp = r0
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            r0.greedy = r1
        L_0x0456:
            r1 = r3
            goto L_0x003f
        L_0x0459:
            org.mozilla.javascript.regexp.RENode r0 = r13.result
            r0.greedy = r3
            goto L_0x0456
        L_0x045e:
            r0 = r1
            goto L_0x0423
        L_0x0460:
            r12 = r4
            r4 = r0
            r0 = r12
            goto L_0x0409
        L_0x0464:
            r0 = r2
            goto L_0x01b9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.parseTerm(org.mozilla.javascript.regexp.CompilerState):boolean");
    }

    private static void resolveForwardJump(byte[] bArr, int i, int i2) {
        if (i > i2) {
            throw Kit.m5810a();
        }
        addIndex(bArr, i, i2 - i);
    }

    private static int getOffset(byte[] bArr, int i) {
        return getIndex(bArr, i);
    }

    private static int addIndex(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            throw Kit.m5810a();
        } else if (i2 > 65535) {
            throw Context.m6765c("Too complex regexp");
        } else {
            bArr[i] = (byte) (i2 >> 8);
            bArr[i + 1] = (byte) i2;
            return i + 2;
        }
    }

    private static int getIndex(byte[] bArr, int i) {
//        return ((bArr[i] & Constants.NETWORK_TYPE_UNCONNECTED) << 8) | (bArr[i + 1] & Constants.NETWORK_TYPE_UNCONNECTED);

        return -1;
    }

    private static int emitREBytecode(CompilerState compilerState, RECompiled rECompiled, int i, RENode rENode) {
        int i2;
        byte b;
        byte[] bArr = rECompiled.program;
        while (rENode != null) {
            int i3 = i + 1;
            bArr[i] = rENode.f6820op;
            switch (rENode.f6820op) {
                case 1:
                    i3--;
                    continue;
                case 13:
                    i3 = addIndex(bArr, i3, rENode.parenIndex);
                    continue;
                case 14:
                    if (rENode.flatIndex != -1) {
                        while (rENode.next != null && rENode.next.f6820op == 14 && rENode.flatIndex + rENode.length == rENode.next.flatIndex) {
                            rENode.length += rENode.next.length;
                            rENode.next = rENode.next.next;
                        }
                    }
                    if (rENode.flatIndex == -1 || rENode.length <= 1) {
                        if (rENode.chr >= 256) {
                            if ((compilerState.flags & 2) != 0) {
                                bArr[i3 - 1] = REOP_UCFLAT1i;
                            } else {
                                bArr[i3 - 1] = REOP_UCFLAT1;
                            }
                            i3 = addIndex(bArr, i3, rENode.chr);
                            break;
                        } else {
                            if ((compilerState.flags & 2) != 0) {
                                bArr[i3 - 1] = REOP_FLAT1i;
                            } else {
                                bArr[i3 - 1] = REOP_FLAT1;
                            }
                            int i4 = i3 + 1;
                            bArr[i3] = (byte) rENode.chr;
                            i3 = i4;
                            break;
                        }
                    } else {
                        if ((compilerState.flags & 2) != 0) {
                            bArr[i3 - 1] = REOP_FLATi;
                        } else {
                            bArr[i3 - 1] = REOP_FLAT;
                        }
                        i3 = addIndex(bArr, addIndex(bArr, i3, rENode.flatIndex), rENode.length);
                        continue;
                    }
                case 22:
                    if (!rENode.sense) {
                        bArr[i3 - 1] = 23;
                    }
                    i3 = addIndex(bArr, i3, rENode.index);
                    rECompiled.classList[rENode.index] = new RECharSet(rENode.bmsize, rENode.startIndex, rENode.kidlen, rENode.sense);
                    continue;
                case 25:
                    if (rENode.min == 0 && rENode.max == -1) {
                        int i5 = i3 - 1;
                        if (rENode.greedy) {
                            b = REOP_STAR;
                        } else {
                            b = REOP_MINIMALSTAR;
                        }
                        bArr[i5] = b;
                    } else if (rENode.min == 0 && rENode.max == 1) {
                        bArr[i3 - 1] = rENode.greedy ? REOP_OPT : REOP_MINIMALOPT;
                    } else if (rENode.min == 1 && rENode.max == -1) {
                        bArr[i3 - 1] = rENode.greedy ? REOP_PLUS : REOP_MINIMALPLUS;
                    } else {
                        if (!rENode.greedy) {
                            bArr[i3 - 1] = REOP_MINIMALQUANT;
                        }
                        i3 = addIndex(bArr, addIndex(bArr, i3, rENode.min), rENode.max + 1);
                    }
                    int addIndex = addIndex(bArr, addIndex(bArr, i3, rENode.parenCount), rENode.parenIndex);
                    int emitREBytecode = emitREBytecode(compilerState, rECompiled, addIndex + 2, rENode.kid);
                    i3 = emitREBytecode + 1;
                    bArr[emitREBytecode] = REOP_ENDCHILD;
                    resolveForwardJump(bArr, addIndex, i3);
                    continue;
                case 29:
                    int emitREBytecode2 = emitREBytecode(compilerState, rECompiled, addIndex(bArr, i3, rENode.parenIndex), rENode.kid);
                    int i6 = emitREBytecode2 + 1;
                    bArr[emitREBytecode2] = REOP_RPAREN;
                    i3 = addIndex(bArr, i6, rENode.parenIndex);
                    continue;
                case 31:
                    i2 = i3;
                    break;
                case 41:
                    int emitREBytecode3 = emitREBytecode(compilerState, rECompiled, i3 + 2, rENode.kid);
                    int i7 = emitREBytecode3 + 1;
                    bArr[emitREBytecode3] = REOP_ASSERTTEST;
                    resolveForwardJump(bArr, i3, i7);
                    i3 = i7;
                    continue;
                case 42:
                    int emitREBytecode4 = emitREBytecode(compilerState, rECompiled, i3 + 2, rENode.kid);
                    int i8 = emitREBytecode4 + 1;
                    bArr[emitREBytecode4] = REOP_ASSERTNOTTEST;
                    resolveForwardJump(bArr, i3, i8);
                    i3 = i8;
                    continue;
                case 53:
                case 54:
                case 55:
                    boolean z = rENode.f6820op == 54;
                    addIndex(bArr, i3, z ? upcase(rENode.chr) : rENode.chr);
                    int i9 = i3 + 2;
                    addIndex(bArr, i9, z ? upcase((char) rENode.index) : rENode.index);
                    i2 = i9 + 2;
                    break;
            }
            RENode rENode2 = rENode.kid2;
//            int emitREBytecode5 = emitREBytecode(compilerState, rECompiled, i2 + 2, rENode.kid);
//            int i10 = emitREBytecode5 + 1;
//            bArr[emitREBytecode5] = REOP_JUMP;
//            int i11 = i10 + 2;
//            resolveForwardJump(bArr, i2, i11);
//            int emitREBytecode6 = emitREBytecode(compilerState, rECompiled, i11, rENode2);
//            int i12 = emitREBytecode6 + 1;
//            bArr[emitREBytecode6] = REOP_JUMP;
//            i3 = i12 + 2;
//            resolveForwardJump(bArr, i10, i3);
//            resolveForwardJump(bArr, i12, i3);
//            rENode = rENode.next;
//            i = i3;
        }
        return i;
    }

    private static void pushProgState(REGlobalData rEGlobalData, int i, int i2, int i3, REBackTrackData rEBackTrackData, int i4, int i5) {
        rEGlobalData.stateStackTop = new REProgState(rEGlobalData.stateStackTop, i, i2, i3, rEBackTrackData, i4, i5);
    }

    private static REProgState popProgState(REGlobalData rEGlobalData) {
        REProgState rEProgState = rEGlobalData.stateStackTop;
        rEGlobalData.stateStackTop = rEProgState.previous;
        return rEProgState;
    }

    private static void pushBackTrackState(REGlobalData rEGlobalData, byte b, int i) {
        REProgState rEProgState = rEGlobalData.stateStackTop;
        rEGlobalData.backTrackStackTop = new REBackTrackData(rEGlobalData, b, i, rEGlobalData.f6819cp, rEProgState.continuationOp, rEProgState.continuationPc);
    }

    private static void pushBackTrackState(REGlobalData rEGlobalData, byte b, int i, int i2, int i3, int i4) {
        rEGlobalData.backTrackStackTop = new REBackTrackData(rEGlobalData, b, i, i2, i3, i4);
    }

    private static boolean flatNMatcher(REGlobalData rEGlobalData, int i, int i2, String str, int i3) {
        if (rEGlobalData.f6819cp + i2 > i3) {
            return false;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (rEGlobalData.regexp.source[i + i4] != str.charAt(rEGlobalData.f6819cp + i4)) {
                return false;
            }
        }
        rEGlobalData.f6819cp += i2;
        return true;
    }

    private static boolean flatNIMatcher(REGlobalData rEGlobalData, int i, int i2, String str, int i3) {
        if (rEGlobalData.f6819cp + i2 > i3) {
            return false;
        }
        char[] cArr = rEGlobalData.regexp.source;
        for (int i4 = 0; i4 < i2; i4++) {
            char c = cArr[i + i4];
            char charAt = str.charAt(rEGlobalData.f6819cp + i4);
            if (c != charAt && upcase(c) != upcase(charAt)) {
                return false;
            }
        }
        rEGlobalData.f6819cp += i2;
        return true;
    }

    private static boolean backrefMatcher(REGlobalData rEGlobalData, int i, String str, int i2) {
        if (rEGlobalData.parens == null || i >= rEGlobalData.parens.length) {
            return false;
        }
        int parensIndex = rEGlobalData.parensIndex(i);
        if (parensIndex == -1) {
            return true;
        }
        int parensLength = rEGlobalData.parensLength(i);
        if (rEGlobalData.f6819cp + parensLength > i2) {
            return false;
        }
        if ((rEGlobalData.regexp.flags & 2) != 0) {
            for (int i3 = 0; i3 < parensLength; i3++) {
                char charAt = str.charAt(parensIndex + i3);
                char charAt2 = str.charAt(rEGlobalData.f6819cp + i3);
                if (charAt != charAt2 && upcase(charAt) != upcase(charAt2)) {
                    return false;
                }
            }
        } else if (!str.regionMatches(parensIndex, str, rEGlobalData.f6819cp, parensLength)) {
            return false;
        }
        rEGlobalData.f6819cp += parensLength;
        return true;
    }

    private static void addCharacterToCharSet(RECharSet rECharSet, char c) {
        int i = c / 8;
        if (c >= rECharSet.length) {
            throw ScriptRuntime.m6375a("SyntaxError", "invalid range in character class");
        }
        byte[] bArr = rECharSet.bits;
        bArr[i] = (byte) (bArr[i] | (1 << (c & 7)));
    }

    private static void addCharacterRangeToCharSet(RECharSet rECharSet, char c, char c2) {
        int i = c / 8;
        int i2 = c2 / 8;
        if (c2 >= rECharSet.length || c > c2) {
            throw ScriptRuntime.m6375a("SyntaxError", "invalid range in character class");
        }
        char c3 = (char) (c & 7);
        char c4 = (char) (c2 & 7);
        if (i == i2) {
            byte[] bArr = rECharSet.bits;
            bArr[i] = (byte) (((255 >> (7 - (c4 - c3))) << c3) | bArr[i]);
            return;
        }
        byte[] bArr2 = rECharSet.bits;
        bArr2[i] = (byte) ((255 << c3) | bArr2[i]);
        for (int i3 = i + 1; i3 < i2; i3++) {
            rECharSet.bits[i3] = -1;
        }
        byte[] bArr3 = rECharSet.bits;
        bArr3[i2] = (byte) (bArr3[i2] | (255 >> (7 - c4)));
    }

    private static void processCharSet(REGlobalData rEGlobalData, RECharSet rECharSet) {
        synchronized (rECharSet) {
            if (!rECharSet.converted) {
                processCharSetImpl(rEGlobalData, rECharSet);
                rECharSet.converted = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01d7, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01de, code lost:
        r0 = r2;
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c1, code lost:
        r5 = 0;
        r3 = r2;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c4, code lost:
        if (r5 >= r0) goto L_0x01de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c6, code lost:
        if (r3 >= r9) goto L_0x01de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c8, code lost:
        r7 = r3 + 1;
        r3 = toASCIIHexDigit(r14.regexp.source[r3]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d4, code lost:
        if (r3 >= 0) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d6, code lost:
        r2 = r7 - (r5 + 1);
        r0 = 92;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00dc, code lost:
        r3 = r2;
        r2 = (char) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e1, code lost:
        r5 = r5 + 1;
        r2 = r3 | (r2 << 4);
        r3 = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void processCharSetImpl(org.mozilla.javascript.regexp.REGlobalData r14, RECharSet r15) {
        /*
            r1 = 92
            r12 = 55
            r11 = 48
            r6 = 0
            int r2 = r15.startIndex
            int r0 = r15.strlength
            int r9 = r2 + r0
            int r0 = r15.length
            int r0 = r0 + 7
            int r0 = r0 / 8
            byte[] r0 = new byte[r0]
            r15.bits = r0
            if (r2 != r9) goto L_0x001a
        L_0x0019:
            return
        L_0x001a:
            org.mozilla.javascript.regexp.RECompiled r0 = r14.regexp
            char[] r0 = r0.source
            char r0 = r0[r2]
            r3 = 94
            if (r0 != r3) goto L_0x0063
            boolean r0 = $assertionsDisabled
            if (r0 != 0) goto L_0x0032
            boolean r0 = r15.sense
            if (r0 == 0) goto L_0x0032
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0032:
            int r2 = r2 + 1
            r8 = r6
            r4 = r6
            r3 = r2
        L_0x0037:
            if (r3 == r9) goto L_0x0019
            r0 = 2
            org.mozilla.javascript.regexp.RECompiled r2 = r14.regexp
            char[] r2 = r2.source
            char r2 = r2[r3]
            switch(r2) {
                case 92: goto L_0x0071;
                default: goto L_0x0043;
            }
        L_0x0043:
            org.mozilla.javascript.regexp.RECompiled r0 = r14.regexp
            char[] r0 = r0.source
            int r2 = r3 + 1
            char r0 = r0[r3]
            r3 = r2
            r2 = r0
        L_0x004d:
            if (r8 == 0) goto L_0x01a8
            org.mozilla.javascript.regexp.RECompiled r0 = r14.regexp
            int r0 = r0.flags
            r0 = r0 & 2
            if (r0 == 0) goto L_0x01a2
            boolean r0 = $assertionsDisabled
            if (r0 != 0) goto L_0x0186
            if (r4 <= r2) goto L_0x0186
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0063:
            boolean r0 = $assertionsDisabled
            if (r0 != 0) goto L_0x01e2
            boolean r0 = r15.sense
            if (r0 != 0) goto L_0x01e2
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0071:
            int r3 = r3 + 1
            org.mozilla.javascript.regexp.RECompiled r2 = r14.regexp
            char[] r5 = r2.source
            int r2 = r3 + 1
            char r3 = r5[r3]
            switch(r3) {
                case 48: goto L_0x00ea;
                case 49: goto L_0x00ea;
                case 50: goto L_0x00ea;
                case 51: goto L_0x00ea;
                case 52: goto L_0x00ea;
                case 53: goto L_0x00ea;
                case 54: goto L_0x00ea;
                case 55: goto L_0x00ea;
                case 68: goto L_0x0126;
                case 83: goto L_0x014b;
                case 87: goto L_0x0172;
                case 98: goto L_0x0082;
                case 99: goto L_0x00a0;
                case 100: goto L_0x011e;
                case 102: goto L_0x0087;
                case 110: goto L_0x008c;
                case 114: goto L_0x0091;
                case 115: goto L_0x0138;
                case 116: goto L_0x0096;
                case 117: goto L_0x00c0;
                case 118: goto L_0x009b;
                case 119: goto L_0x015e;
                case 120: goto L_0x00c1;
                default: goto L_0x007e;
            }
        L_0x007e:
            r13 = r3
            r3 = r2
            r2 = r13
            goto L_0x004d
        L_0x0082:
            r0 = 8
            r3 = r2
            r2 = r0
            goto L_0x004d
        L_0x0087:
            r0 = 12
            r3 = r2
            r2 = r0
            goto L_0x004d
        L_0x008c:
            r0 = 10
            r3 = r2
            r2 = r0
            goto L_0x004d
        L_0x0091:
            r0 = 13
            r3 = r2
            r2 = r0
            goto L_0x004d
        L_0x0096:
            r0 = 9
            r3 = r2
            r2 = r0
            goto L_0x004d
        L_0x009b:
            r0 = 11
            r3 = r2
            r2 = r0
            goto L_0x004d
        L_0x00a0:
            if (r2 >= r9) goto L_0x00bb
            org.mozilla.javascript.regexp.RECompiled r0 = r14.regexp
            char[] r0 = r0.source
            char r0 = r0[r2]
            boolean r0 = isControlLetter(r0)
            if (r0 == 0) goto L_0x00bb
            org.mozilla.javascript.regexp.RECompiled r0 = r14.regexp
            char[] r0 = r0.source
            int r3 = r2 + 1
            char r0 = r0[r2]
            r0 = r0 & 31
            char r0 = (char) r0
            r2 = r0
            goto L_0x004d
        L_0x00bb:
            int r2 = r2 + -1
            r3 = r2
            r2 = r1
            goto L_0x004d
        L_0x00c0:
            r0 = 4
        L_0x00c1:
            r5 = r6
            r3 = r2
            r2 = r6
        L_0x00c4:
            if (r5 >= r0) goto L_0x01de
            if (r3 >= r9) goto L_0x01de
            org.mozilla.javascript.regexp.RECompiled r7 = r14.regexp
            char[] r10 = r7.source
            int r7 = r3 + 1
            char r3 = r10[r3]
            int r3 = toASCIIHexDigit(r3)
            if (r3 >= 0) goto L_0x00e1
            int r0 = r5 + 1
            int r0 = r7 - r0
            r2 = r0
            r0 = r1
        L_0x00dc:
            char r0 = (char) r0
            r3 = r2
            r2 = r0
            goto L_0x004d
        L_0x00e1:
            int r2 = r2 << 4
            r3 = r3 | r2
            int r2 = r5 + 1
            r5 = r2
            r2 = r3
            r3 = r7
            goto L_0x00c4
        L_0x00ea:
            int r0 = r3 + -48
            org.mozilla.javascript.regexp.RECompiled r3 = r14.regexp
            char[] r3 = r3.source
            char r5 = r3[r2]
            if (r11 > r5) goto L_0x0113
            if (r5 > r12) goto L_0x0113
            int r3 = r2 + 1
            int r0 = r0 * 8
            int r2 = r5 + -48
            int r2 = r2 + r0
            org.mozilla.javascript.regexp.RECompiled r0 = r14.regexp
            char[] r0 = r0.source
            char r0 = r0[r3]
            if (r11 > r0) goto L_0x01da
            if (r0 > r12) goto L_0x01da
            int r3 = r3 + 1
            int r5 = r2 * 8
            int r0 = r0 + -48
            int r0 = r0 + r5
            r5 = 255(0xff, float:3.57E-43)
            if (r0 > r5) goto L_0x0118
            r2 = r3
        L_0x0113:
            char r0 = (char) r0
            r3 = r2
            r2 = r0
            goto L_0x004d
        L_0x0118:
            int r0 = r3 + -1
            r13 = r2
            r2 = r0
            r0 = r13
            goto L_0x0113
        L_0x011e:
            r0 = 57
            addCharacterRangeToCharSet(r15, r11, r0)
            r3 = r2
            goto L_0x0037
        L_0x0126:
            r0 = 47
            addCharacterRangeToCharSet(r15, r6, r0)
            r0 = 58
            int r3 = r15.length
            int r3 = r3 + -1
            char r3 = (char) r3
            addCharacterRangeToCharSet(r15, r0, r3)
            r3 = r2
            goto L_0x0037
        L_0x0138:
            int r0 = r15.length
            int r0 = r0 + -1
        L_0x013c:
            if (r0 < 0) goto L_0x01d7
            boolean r3 = isREWhiteSpace(r0)
            if (r3 == 0) goto L_0x0148
            char r3 = (char) r0
            addCharacterToCharSet(r15, r3)
        L_0x0148:
            int r0 = r0 + -1
            goto L_0x013c
        L_0x014b:
            int r0 = r15.length
            int r0 = r0 + -1
        L_0x014f:
            if (r0 < 0) goto L_0x01d7
            boolean r3 = isREWhiteSpace(r0)
            if (r3 != 0) goto L_0x015b
            char r3 = (char) r0
            addCharacterToCharSet(r15, r3)
        L_0x015b:
            int r0 = r0 + -1
            goto L_0x014f
        L_0x015e:
            int r0 = r15.length
            int r0 = r0 + -1
        L_0x0162:
            if (r0 < 0) goto L_0x01d7
            char r3 = (char) r0
            boolean r3 = isWord(r3)
            if (r3 == 0) goto L_0x016f
            char r3 = (char) r0
            addCharacterToCharSet(r15, r3)
        L_0x016f:
            int r0 = r0 + -1
            goto L_0x0162
        L_0x0172:
            int r0 = r15.length
            int r0 = r0 + -1
        L_0x0176:
            if (r0 < 0) goto L_0x01d7
            char r3 = (char) r0
            boolean r3 = isWord(r3)
            if (r3 != 0) goto L_0x0183
            char r3 = (char) r0
            addCharacterToCharSet(r15, r3)
        L_0x0183:
            int r0 = r0 + -1
            goto L_0x0176
        L_0x0186:
            r0 = r4
        L_0x0187:
            if (r0 > r2) goto L_0x01a5
            addCharacterToCharSet(r15, r0)
            char r5 = upcase(r0)
            char r7 = downcase(r0)
            if (r0 == r5) goto L_0x0199
            addCharacterToCharSet(r15, r5)
        L_0x0199:
            if (r0 == r7) goto L_0x019e
            addCharacterToCharSet(r15, r7)
        L_0x019e:
            int r0 = r0 + 1
            char r0 = (char) r0
            goto L_0x0187
        L_0x01a2:
            addCharacterRangeToCharSet(r15, r4, r2)
        L_0x01a5:
            r8 = r6
            goto L_0x0037
        L_0x01a8:
            org.mozilla.javascript.regexp.RECompiled r0 = r14.regexp
            int r0 = r0.flags
            r0 = r0 & 2
            if (r0 == 0) goto L_0x01d3
            char r0 = upcase(r2)
            addCharacterToCharSet(r15, r0)
            char r0 = downcase(r2)
            addCharacterToCharSet(r15, r0)
        L_0x01be:
            int r0 = r9 + -1
            if (r3 >= r0) goto L_0x0037
            org.mozilla.javascript.regexp.RECompiled r0 = r14.regexp
            char[] r0 = r0.source
            char r0 = r0[r3]
            r5 = 45
            if (r0 != r5) goto L_0x0037
            int r3 = r3 + 1
            r0 = 1
            r8 = r0
            r4 = r2
            goto L_0x0037
        L_0x01d3:
            addCharacterToCharSet(r15, r2)
            goto L_0x01be
        L_0x01d7:
            r3 = r2
            goto L_0x0037
        L_0x01da:
            r0 = r2
            r2 = r3
            goto L_0x0113
        L_0x01de:
            r0 = r2
            r2 = r3
            goto L_0x00dc
        L_0x01e2:
            r8 = r6
            r4 = r6
            r3 = r2
            goto L_0x0037
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.processCharSetImpl(org.mozilla.javascript.regexp.REGlobalData, org.mozilla.javascript.regexp.RECharSet):void");
    }

    private static boolean classMatcher(REGlobalData rEGlobalData, RECharSet rECharSet, char c) {
        boolean z = true;
        if (!rECharSet.converted) {
            processCharSet(rEGlobalData, rECharSet);
        }
        int i = c >> 3;
        if (!(rECharSet.length == 0 || c >= rECharSet.length || (rECharSet.bits[i] & (1 << (c & 7))) == 0)) {
            z = false;
        }
        return z ^ rECharSet.sense;
    }

    private static boolean reopIsSimple(int i) {
        return i > 0 && i <= 23;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0234, code lost:
        r0 = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int simpleMatch(org.mozilla.javascript.regexp.REGlobalData r6, String r7, int r8, byte[] r9, int r10, int r11, boolean r12) {
        /*
            r1 = 0
            r2 = 1
            int r3 = r6.f6819cp
            switch(r8) {
                case 1: goto L_0x000c;
                case 2: goto L_0x0015;
                case 3: goto L_0x002e;
                case 4: goto L_0x0045;
                case 5: goto L_0x006e;
                case 6: goto L_0x009a;
                case 7: goto L_0x00b4;
                case 8: goto L_0x00ce;
                case 9: goto L_0x00e8;
                case 10: goto L_0x0102;
                case 11: goto L_0x011c;
                case 12: goto L_0x0136;
                case 13: goto L_0x0150;
                case 14: goto L_0x015d;
                case 15: goto L_0x0170;
                case 16: goto L_0x018c;
                case 17: goto L_0x019f;
                case 18: goto L_0x01c5;
                case 19: goto L_0x01e2;
                case 20: goto L_0x0007;
                case 21: goto L_0x0007;
                case 22: goto L_0x0209;
                case 23: goto L_0x0209;
                default: goto L_0x0007;
            }
        L_0x0007:
            java.lang.RuntimeException r0 = org.mozilla.javascript.Kit.m5810a()
            throw r0
        L_0x000c:
            r1 = r2
            r0 = r10
        L_0x000e:
            if (r1 == 0) goto L_0x022f
            if (r12 != 0) goto L_0x0014
            r6.f6819cp = r3
        L_0x0014:
            return r0
        L_0x0015:
            int r0 = r6.f6819cp
            if (r0 == 0) goto L_0x002b
            boolean r0 = r6.multiline
            if (r0 == 0) goto L_0x0234
            int r0 = r6.f6819cp
            int r0 = r0 + -1
            char r0 = r7.charAt(r0)
            boolean r0 = isLineTerm(r0)
            if (r0 == 0) goto L_0x0234
        L_0x002b:
            r1 = r2
            r0 = r10
            goto L_0x000e
        L_0x002e:
            int r0 = r6.f6819cp
            if (r0 == r11) goto L_0x0042
            boolean r0 = r6.multiline
            if (r0 == 0) goto L_0x0234
            int r0 = r6.f6819cp
            char r0 = r7.charAt(r0)
            boolean r0 = isLineTerm(r0)
            if (r0 == 0) goto L_0x0234
        L_0x0042:
            r1 = r2
            r0 = r10
            goto L_0x000e
        L_0x0045:
            int r0 = r6.f6819cp
            if (r0 == 0) goto L_0x0057
            int r0 = r6.f6819cp
            int r0 = r0 + -1
            char r0 = r7.charAt(r0)
            boolean r0 = isWord(r0)
            if (r0 != 0) goto L_0x006c
        L_0x0057:
            r0 = r2
        L_0x0058:
            int r4 = r6.f6819cp
            if (r4 >= r11) goto L_0x0068
            int r4 = r6.f6819cp
            char r4 = r7.charAt(r4)
            boolean r4 = isWord(r4)
            if (r4 != 0) goto L_0x0069
        L_0x0068:
            r1 = r2
        L_0x0069:
            r1 = r1 ^ r0
            r0 = r10
            goto L_0x000e
        L_0x006c:
            r0 = r1
            goto L_0x0058
        L_0x006e:
            int r0 = r6.f6819cp
            if (r0 == 0) goto L_0x0080
            int r0 = r6.f6819cp
            int r0 = r0 + -1
            char r0 = r7.charAt(r0)
            boolean r0 = isWord(r0)
            if (r0 != 0) goto L_0x0096
        L_0x0080:
            r0 = r2
        L_0x0081:
            int r4 = r6.f6819cp
            if (r4 >= r11) goto L_0x0098
            int r4 = r6.f6819cp
            char r4 = r7.charAt(r4)
            boolean r4 = isWord(r4)
            if (r4 == 0) goto L_0x0098
        L_0x0091:
            r1 = r0 ^ r2
            r0 = r10
            goto L_0x000e
        L_0x0096:
            r0 = r1
            goto L_0x0081
        L_0x0098:
            r2 = r1
            goto L_0x0091
        L_0x009a:
            int r0 = r6.f6819cp
            if (r0 == r11) goto L_0x0234
            int r0 = r6.f6819cp
            char r0 = r7.charAt(r0)
            boolean r0 = isLineTerm(r0)
            if (r0 != 0) goto L_0x0234
            int r0 = r6.f6819cp
            int r0 = r0 + 1
            r6.f6819cp = r0
            r1 = r2
            r0 = r10
            goto L_0x000e
        L_0x00b4:
            int r0 = r6.f6819cp
            if (r0 == r11) goto L_0x0234
            int r0 = r6.f6819cp
            char r0 = r7.charAt(r0)
            boolean r0 = isDigit(r0)
            if (r0 == 0) goto L_0x0234
            int r0 = r6.f6819cp
            int r0 = r0 + 1
            r6.f6819cp = r0
            r1 = r2
            r0 = r10
            goto L_0x000e
        L_0x00ce:
            int r0 = r6.f6819cp
            if (r0 == r11) goto L_0x0234
            int r0 = r6.f6819cp
            char r0 = r7.charAt(r0)
            boolean r0 = isDigit(r0)
            if (r0 != 0) goto L_0x0234
            int r0 = r6.f6819cp
            int r0 = r0 + 1
            r6.f6819cp = r0
            r1 = r2
            r0 = r10
            goto L_0x000e
        L_0x00e8:
            int r0 = r6.f6819cp
            if (r0 == r11) goto L_0x0234
            int r0 = r6.f6819cp
            char r0 = r7.charAt(r0)
            boolean r0 = isWord(r0)
            if (r0 == 0) goto L_0x0234
            int r0 = r6.f6819cp
            int r0 = r0 + 1
            r6.f6819cp = r0
            r1 = r2
            r0 = r10
            goto L_0x000e
        L_0x0102:
            int r0 = r6.f6819cp
            if (r0 == r11) goto L_0x0234
            int r0 = r6.f6819cp
            char r0 = r7.charAt(r0)
            boolean r0 = isWord(r0)
            if (r0 != 0) goto L_0x0234
            int r0 = r6.f6819cp
            int r0 = r0 + 1
            r6.f6819cp = r0
            r1 = r2
            r0 = r10
            goto L_0x000e
        L_0x011c:
            int r0 = r6.f6819cp
            if (r0 == r11) goto L_0x0234
            int r0 = r6.f6819cp
            char r0 = r7.charAt(r0)
            boolean r0 = isREWhiteSpace(r0)
            if (r0 == 0) goto L_0x0234
            int r0 = r6.f6819cp
            int r0 = r0 + 1
            r6.f6819cp = r0
            r1 = r2
            r0 = r10
            goto L_0x000e
        L_0x0136:
            int r0 = r6.f6819cp
            if (r0 == r11) goto L_0x0234
            int r0 = r6.f6819cp
            char r0 = r7.charAt(r0)
            boolean r0 = isREWhiteSpace(r0)
            if (r0 != 0) goto L_0x0234
            int r0 = r6.f6819cp
            int r0 = r0 + 1
            r6.f6819cp = r0
            r1 = r2
            r0 = r10
            goto L_0x000e
        L_0x0150:
            int r0 = getIndex(r9, r10)
            int r10 = r10 + 2
            boolean r1 = backrefMatcher(r6, r0, r7, r11)
            r0 = r10
            goto L_0x000e
        L_0x015d:
            int r0 = getIndex(r9, r10)
            int r1 = r10 + 2
            int r2 = getIndex(r9, r1)
            int r10 = r1 + 2
            boolean r1 = flatNMatcher(r6, r0, r2, r7, r11)
            r0 = r10
            goto L_0x000e
        L_0x0170:
            int r0 = r10 + 1
            byte r4 = r9[r10]
            r4 = r4 & 255(0xff, float:3.57E-43)
            char r4 = (char) r4
            int r5 = r6.f6819cp
            if (r5 == r11) goto L_0x000e
            int r5 = r6.f6819cp
            char r5 = r7.charAt(r5)
            if (r5 != r4) goto L_0x000e
            int r1 = r6.f6819cp
            int r1 = r1 + 1
            r6.f6819cp = r1
            r1 = r2
            goto L_0x000e
        L_0x018c:
            int r0 = getIndex(r9, r10)
            int r1 = r10 + 2
            int r2 = getIndex(r9, r1)
            int r10 = r1 + 2
            boolean r1 = flatNIMatcher(r6, r0, r2, r7, r11)
            r0 = r10
            goto L_0x000e
        L_0x019f:
            int r0 = r10 + 1
            byte r4 = r9[r10]
            r4 = r4 & 255(0xff, float:3.57E-43)
            char r4 = (char) r4
            int r5 = r6.f6819cp
            if (r5 == r11) goto L_0x000e
            int r5 = r6.f6819cp
            char r5 = r7.charAt(r5)
            if (r4 == r5) goto L_0x01bc
            char r4 = upcase(r4)
            char r5 = upcase(r5)
            if (r4 != r5) goto L_0x000e
        L_0x01bc:
            int r1 = r6.f6819cp
            int r1 = r1 + 1
            r6.f6819cp = r1
            r1 = r2
            goto L_0x000e
        L_0x01c5:
            int r0 = getIndex(r9, r10)
            char r0 = (char) r0
            int r10 = r10 + 2
            int r4 = r6.f6819cp
            if (r4 == r11) goto L_0x0234
            int r4 = r6.f6819cp
            char r4 = r7.charAt(r4)
            if (r4 != r0) goto L_0x0234
            int r0 = r6.f6819cp
            int r0 = r0 + 1
            r6.f6819cp = r0
            r1 = r2
            r0 = r10
            goto L_0x000e
        L_0x01e2:
            int r0 = getIndex(r9, r10)
            char r0 = (char) r0
            int r10 = r10 + 2
            int r4 = r6.f6819cp
            if (r4 == r11) goto L_0x0234
            int r4 = r6.f6819cp
            char r4 = r7.charAt(r4)
            if (r0 == r4) goto L_0x01ff
            char r0 = upcase(r0)
            char r4 = upcase(r4)
            if (r0 != r4) goto L_0x0206
        L_0x01ff:
            int r0 = r6.f6819cp
            int r0 = r0 + 1
            r6.f6819cp = r0
            r1 = r2
        L_0x0206:
            r0 = r10
            goto L_0x000e
        L_0x0209:
            int r0 = getIndex(r9, r10)
            int r10 = r10 + 2
            int r4 = r6.f6819cp
            if (r4 == r11) goto L_0x0234
            org.mozilla.javascript.regexp.RECompiled r4 = r6.regexp
            org.mozilla.javascript.regexp.RECharSet[] r4 = r4.classList
            r0 = r4[r0]
            int r4 = r6.f6819cp
            char r4 = r7.charAt(r4)
            boolean r0 = classMatcher(r6, r0, r4)
            if (r0 == 0) goto L_0x0234
            int r0 = r6.f6819cp
            int r0 = r0 + 1
            r6.f6819cp = r0
            r1 = r2
            r0 = r10
            goto L_0x000e
        L_0x022f:
            r6.f6819cp = r3
            r0 = -1
            goto L_0x0014
        L_0x0234:
            r0 = r10
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.simpleMatch(org.mozilla.javascript.regexp.REGlobalData, java.lang.String, int, byte[], int, int, boolean):int");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r3v0, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r9v1, types: [int] */
    /* JADX WARNING: type inference failed for: r3v2, types: [int] */
    /* JADX WARNING: type inference failed for: r9v3, types: [int] */
    /* JADX WARNING: type inference failed for: r3v3, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r3v5, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v5, types: [int] */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r3v9, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v8, types: [int] */
    /* JADX WARNING: type inference failed for: r8v7, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r6v6, types: [byte] */
    /* JADX WARNING: type inference failed for: r3v12, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r9v13, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r9v14, types: [int] */
    /* JADX WARNING: type inference failed for: r9v15, types: [int] */
    /* JADX WARNING: type inference failed for: r9v16, types: [int] */
    /* JADX WARNING: type inference failed for: r9v17, types: [int] */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r16v1, types: [int] */
    /* JADX WARNING: type inference failed for: r3v19, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r3v20, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* JADX WARNING: type inference failed for: r3v21, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v20, types: [int] */
    /* JADX WARNING: type inference failed for: r3v22, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r16v2, types: [int] */
    /* JADX WARNING: type inference failed for: r1v74, types: [byte] */
    /* JADX WARNING: type inference failed for: r3v23, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r16v3, types: [int] */
    /* JADX WARNING: type inference failed for: r3v25, types: [byte] */
    /* JADX WARNING: type inference failed for: r3v27, types: [byte] */
    /* JADX WARNING: type inference failed for: r3v28, types: [byte] */
    /* JADX WARNING: type inference failed for: r3v29, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r3v31, types: [byte] */
    /* JADX WARNING: type inference failed for: r3v32, types: [byte] */
    /* JADX WARNING: type inference failed for: r3v33 */
    /* JADX WARNING: type inference failed for: r6v16, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v21 */
    /* JADX WARNING: type inference failed for: r3v34, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v22, types: [int] */
    /* JADX WARNING: type inference failed for: r3v39, types: [int] */
    /* JADX WARNING: type inference failed for: r3v40 */
    /* JADX WARNING: type inference failed for: r3v41, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v23 */
    /* JADX WARNING: type inference failed for: r3v42 */
    /* JADX WARNING: type inference failed for: r3v43 */
    /* JADX WARNING: type inference failed for: r3v44 */
    /* JADX WARNING: type inference failed for: r9v24 */
    /* JADX WARNING: type inference failed for: r9v25 */
    /* JADX WARNING: type inference failed for: r9v26 */
    /* JADX WARNING: type inference failed for: r9v27 */
    /* JADX WARNING: type inference failed for: r9v28 */
    /* JADX WARNING: type inference failed for: r9v29 */
    /* JADX WARNING: type inference failed for: r9v30 */
    /* JADX WARNING: type inference failed for: r9v31 */
    /* JADX WARNING: type inference failed for: r9v32 */
    /* JADX WARNING: type inference failed for: r9v33 */
    /* JADX WARNING: type inference failed for: r9v34 */
    /* JADX WARNING: type inference failed for: r9v35 */
    /* JADX WARNING: type inference failed for: r9v36 */
    /* JADX WARNING: type inference failed for: r9v37 */
    /* JADX WARNING: type inference failed for: r9v38 */
    /* JADX WARNING: type inference failed for: r9v39 */
    /* JADX WARNING: type inference failed for: r3v45 */
    /* JADX WARNING: type inference failed for: r9v40 */
    /* JADX WARNING: type inference failed for: r3v46 */
    /* JADX WARNING: type inference failed for: r9v41 */
    /* JADX WARNING: type inference failed for: r9v42 */
    /* JADX WARNING: type inference failed for: r3v47 */
    /* JADX WARNING: type inference failed for: r9v43 */
    /* JADX WARNING: type inference failed for: r3v48 */
    /* JADX WARNING: type inference failed for: r9v44 */
    /* JADX WARNING: type inference failed for: r9v45 */
    /* JADX WARNING: type inference failed for: r9v46 */
    /* JADX WARNING: type inference failed for: r9v47 */
    /* JADX WARNING: type inference failed for: r3v49 */
    /* JADX WARNING: type inference failed for: r9v48 */
    /* JADX WARNING: type inference failed for: r3v50 */
    /* JADX WARNING: type inference failed for: r9v49 */
    /* JADX WARNING: type inference failed for: r3v51 */
    /* JADX WARNING: type inference failed for: r9v50 */
    /* JADX WARNING: type inference failed for: r3v52 */
    /* JADX WARNING: type inference failed for: r3v53 */
    /* JADX WARNING: type inference failed for: r3v54 */
    /* JADX WARNING: type inference failed for: r3v55 */
    /* JADX WARNING: type inference failed for: r3v56 */
    /* JADX WARNING: type inference failed for: r3v57 */
    /* JADX WARNING: type inference failed for: r3v58 */
    /* JADX WARNING: type inference failed for: r3v59 */
    /* JADX WARNING: type inference failed for: r3v60 */
    /* JADX WARNING: type inference failed for: r9v51 */
    /* JADX WARNING: type inference failed for: r3v61 */
    /* JADX WARNING: type inference failed for: r9v52 */
    /* JADX WARNING: type inference failed for: r3v62 */
    /* JADX WARNING: type inference failed for: r3v63 */
    /* JADX WARNING: type inference failed for: r3v64 */
    /* JADX WARNING: CFG modification limit reached, blocks count: 291 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0051, code lost:
        r1 = true;
        r2 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0449, code lost:
        r1 = r18;
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0056, code lost:
        r3 = r4[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0056, code lost:
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0101, code lost:
        r11 = r5 + getOffset(r4, r5);
        r1 = r5 + 2;
        r5 = r1 + 1;
        r3 = r4[r1];
        r8 = r20.f6819cp;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0115, code lost:
        if (reopIsSimple(r3) == false) goto L_0x0449;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0117, code lost:
        r3 = simpleMatch(r20, r21, r3, r4, r5, r22, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0122, code lost:
        if (r3 >= 0) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0124, code lost:
        r5 = r11 + 1;
        r9 = r9;
        r3 = r4[r11];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0215, code lost:
        r12 = 0;
        r13 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0217, code lost:
        pushProgState(r20, r12, r13, r20.f6819cp, null, r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0225, code lost:
        if (r1 == false) goto L_0x0255;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0227, code lost:
        pushBackTrackState(r20, REOP_REPEAT, r5);
        r1 = r5 + 6;
        r19 = r5;
        r5 = r1 + 1;
        r10 = r19;
        r9 = 51;
        r3 = r4[r1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x023e, code lost:
        r12 = 1;
        r13 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0242, code lost:
        r12 = 0;
        r13 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0246, code lost:
        r12 = getOffset(r4, r5);
        r2 = r5 + 2;
        r13 = getOffset(r4, r2) - 1;
        r5 = r2 + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0255, code lost:
        if (r12 == 0) goto L_0x0266;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0257, code lost:
        r1 = r5 + 6;
        r19 = r5;
        r5 = r1 + 1;
        r10 = r19;
        r9 = 52;
        r3 = r4[r1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0266, code lost:
        pushBackTrackState(r20, REOP_MINIMALREPEAT, r5);
        popProgState(r20);
        r1 = r5 + 4;
        r1 = r1 + getOffset(r4, r1);
        r5 = r1 + 1;
        r9 = r9;
        r3 = r4[r1];
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r1v74, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v0, types: [byte, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v12, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v19, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v20, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v21, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v22, types: [byte, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v23, types: [byte, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v25, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v27, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v28, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v29, types: [byte, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v3, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v31, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v32, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v34, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v41, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v5, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r3v9, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r6v16, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r6v6, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r8v7, types: [byte, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte[], code=null, for r4v0, types: [byte[]] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v1
  assigns: []
  uses: []
  mth insns count: 526
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
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0432 A[LOOP:17: B:16:0x0062->B:162:0x0432, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0068 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ab  */
    /* JADX WARNING: Unknown variable types count: 44 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean executeREBytecode(org.mozilla.javascript.regexp.REGlobalData r20, String r21, int r22) {
        /*
            r0 = r20
            org.mozilla.javascript.regexp.RECompiled r1 = r0.regexp
            byte[] r4 = r1.program
            r9 = 57
            r10 = 0
            r8 = 0
            r1 = 0
            r11 = 1
            byte r3 = r4[r1]
            r0 = r20
            org.mozilla.javascript.regexp.RECompiled r1 = r0.regexp
            int r1 = r1.anchorCh
            if (r1 >= 0) goto L_0x0456
            boolean r1 = reopIsSimple(r3)
            if (r1 == 0) goto L_0x0456
            r12 = 0
        L_0x001d:
            r0 = r20
            int r1 = r0.f6819cp
            r0 = r22
            if (r1 > r0) goto L_0x0452
            r5 = 1
            r7 = 1
            r1 = r20
            r2 = r21
            r6 = r22
            int r2 = simpleMatch(r1, r2, r3, r4, r5, r6, r7)
            if (r2 < 0) goto L_0x003c
            r1 = 1
            int r5 = r2 + 1
            byte r3 = r4[r2]
        L_0x0038:
            if (r1 != 0) goto L_0x044e
            r1 = 0
        L_0x003b:
            return r1
        L_0x003c:
            r0 = r20
            int r1 = r0.skipped
            int r1 = r1 + 1
            r0 = r20
            r0.skipped = r1
            r0 = r20
            int r1 = r0.f6819cp
            int r1 = r1 + 1
            r0 = r20
            r0.f6819cp = r1
            goto L_0x001d
        L_0x0051:
            r1 = 1
            int r2 = r3 + 1
            byte r3 = r4[r3]
        L_0x0056:
            int r7 = r11 + 1
            byte r6 = r4[r11]
            r5 = r20
            pushBackTrackState(r5, r6, r7, r8, r9, r10)
            r18 = r1
            r5 = r2
        L_0x0062:
            boolean r1 = reopIsSimple(r3)
            if (r1 == 0) goto L_0x00ab
            r7 = 1
            r1 = r20
            r2 = r21
            r6 = r22
            int r1 = simpleMatch(r1, r2, r3, r4, r5, r6, r7)
            if (r1 < 0) goto L_0x00a8
            r18 = 1
        L_0x0077:
            if (r18 == 0) goto L_0x007a
            r5 = r1
        L_0x007a:
            r1 = r18
            r2 = r5
        L_0x007d:
            if (r1 != 0) goto L_0x0432
            r0 = r20
            org.mozilla.javascript.regexp.REBackTrackData r2 = r0.backTrackStackTop
            if (r2 == 0) goto L_0x042f
            org.mozilla.javascript.regexp.REBackTrackData r3 = r2.previous
            r0 = r20
            r0.backTrackStackTop = r3
            long[] r3 = r2.parens
            r0 = r20
            r0.parens = r3
            int r3 = r2.f6816cp
            r0 = r20
            r0.f6819cp = r3
            org.mozilla.javascript.regexp.REProgState r3 = r2.stateStackTop
            r0 = r20
            r0.stateStackTop = r3
            int r9 = r2.continuationOp
            int r10 = r2.continuationPc
            int r5 = r2.f6818pc
            int r3 = r2.f6817op
            r18 = r1
            goto L_0x0062
        L_0x00a8:
            r18 = 0
            goto L_0x0077
        L_0x00ab:
            switch(r3) {
                case 25: goto L_0x020b;
                case 26: goto L_0x020b;
                case 27: goto L_0x020b;
                case 28: goto L_0x020b;
                case 29: goto L_0x0135;
                case 30: goto L_0x014b;
                case 31: goto L_0x0101;
                case 32: goto L_0x012a;
                case 33: goto L_0x00ae;
                case 34: goto L_0x00ae;
                case 35: goto L_0x00ae;
                case 36: goto L_0x00ae;
                case 37: goto L_0x00ae;
                case 38: goto L_0x00ae;
                case 39: goto L_0x00ae;
                case 40: goto L_0x00ae;
                case 41: goto L_0x0167;
                case 42: goto L_0x01a6;
                case 43: goto L_0x01eb;
                case 44: goto L_0x01eb;
                case 45: goto L_0x020b;
                case 46: goto L_0x020b;
                case 47: goto L_0x020b;
                case 48: goto L_0x020b;
                case 49: goto L_0x027d;
                case 50: goto L_0x00ae;
                case 51: goto L_0x0286;
                case 52: goto L_0x0366;
                case 53: goto L_0x00b5;
                case 54: goto L_0x00b5;
                case 55: goto L_0x00b5;
                case 56: goto L_0x00ae;
                case 57: goto L_0x042c;
                default: goto L_0x00ae;
            }
        L_0x00ae:
            java.lang.String r1 = "invalid bytecode"
            java.lang.RuntimeException r1 = org.mozilla.javascript.Kit.m5814b(r1)
            throw r1
        L_0x00b5:
            int r1 = getIndex(r4, r5)
            char r2 = (char) r1
            int r1 = r5 + 2
            int r5 = getIndex(r4, r1)
            char r6 = (char) r5
            int r5 = r1 + 2
            r0 = r20
            int r1 = r0.f6819cp
            r0 = r22
            if (r1 != r0) goto L_0x00ce
            r1 = 0
            r2 = r5
            goto L_0x007d
        L_0x00ce:
            r0 = r20
            int r1 = r0.f6819cp
            r0 = r21
            char r1 = r0.charAt(r1)
            r7 = 55
            if (r3 != r7) goto L_0x00f1
            if (r1 == r2) goto L_0x0101
            r0 = r20
            org.mozilla.javascript.regexp.RECompiled r2 = r0.regexp
            org.mozilla.javascript.regexp.RECharSet[] r2 = r2.classList
            r2 = r2[r6]
            r0 = r20
            boolean r1 = classMatcher(r0, r2, r1)
            if (r1 != 0) goto L_0x0101
            r1 = 0
            r2 = r5
            goto L_0x007d
        L_0x00f1:
            r7 = 54
            if (r3 != r7) goto L_0x00f9
            char r1 = upcase(r1)
        L_0x00f9:
            if (r1 == r2) goto L_0x0101
            if (r1 == r6) goto L_0x0101
            r1 = 0
            r2 = r5
            goto L_0x007d
        L_0x0101:
            int r1 = getOffset(r4, r5)
            int r11 = r5 + r1
            int r1 = r5 + 2
            int r5 = r1 + 1
            byte r3 = r4[r1]
            r0 = r20
            int r8 = r0.f6819cp
            boolean r1 = reopIsSimple(r3)
            if (r1 == 0) goto L_0x0449
            r7 = 1
            r1 = r20
            r2 = r21
            r6 = r22
            int r3 = simpleMatch(r1, r2, r3, r4, r5, r6, r7)
            if (r3 >= 0) goto L_0x0051
            int r5 = r11 + 1
            byte r3 = r4[r11]
            goto L_0x0062
        L_0x012a:
            int r1 = getOffset(r4, r5)
            int r1 = r1 + r5
            int r5 = r1 + 1
            byte r3 = r4[r1]
            goto L_0x0062
        L_0x0135:
            int r1 = getIndex(r4, r5)
            int r2 = r5 + 2
            r0 = r20
            int r3 = r0.f6819cp
            r5 = 0
            r0 = r20
            r0.setParens(r1, r3, r5)
            int r5 = r2 + 1
            byte r3 = r4[r2]
            goto L_0x0062
        L_0x014b:
            int r1 = getIndex(r4, r5)
            int r2 = r5 + 2
            r0 = r20
            int r3 = r0.parensIndex(r1)
            r0 = r20
            int r5 = r0.f6819cp
            int r5 = r5 - r3
            r0 = r20
            r0.setParens(r1, r3, r5)
            int r5 = r2 + 1
            byte r3 = r4[r2]
            goto L_0x0062
        L_0x0167:
            int r1 = getIndex(r4, r5)
            int r8 = r5 + r1
            int r1 = r5 + 2
            int r5 = r1 + 1
            byte r3 = r4[r1]
            boolean r1 = reopIsSimple(r3)
            if (r1 == 0) goto L_0x018a
            r7 = 0
            r1 = r20
            r2 = r21
            r6 = r22
            int r1 = simpleMatch(r1, r2, r3, r4, r5, r6, r7)
            if (r1 >= 0) goto L_0x018a
            r1 = 0
            r2 = r5
            goto L_0x007d
        L_0x018a:
            r12 = 0
            r13 = 0
            r0 = r20
            int r14 = r0.f6819cp
            r0 = r20
            org.mozilla.javascript.regexp.REBackTrackData r15 = r0.backTrackStackTop
            r11 = r20
            r16 = r9
            r17 = r10
            pushProgState(r11, r12, r13, r14, r15, r16, r17)
            r1 = 43
            r0 = r20
            pushBackTrackState(r0, r1, r8)
            goto L_0x0062
        L_0x01a6:
            int r1 = getIndex(r4, r5)
            int r8 = r5 + r1
            int r1 = r5 + 2
            int r5 = r1 + 1
            byte r3 = r4[r1]
            boolean r1 = reopIsSimple(r3)
            if (r1 == 0) goto L_0x01cf
            r7 = 0
            r1 = r20
            r2 = r21
            r6 = r22
            int r1 = simpleMatch(r1, r2, r3, r4, r5, r6, r7)
            if (r1 < 0) goto L_0x01cf
            byte r1 = r4[r1]
            r2 = 44
            if (r1 != r2) goto L_0x01cf
            r1 = 0
            r2 = r5
            goto L_0x007d
        L_0x01cf:
            r12 = 0
            r13 = 0
            r0 = r20
            int r14 = r0.f6819cp
            r0 = r20
            org.mozilla.javascript.regexp.REBackTrackData r15 = r0.backTrackStackTop
            r11 = r20
            r16 = r9
            r17 = r10
            pushProgState(r11, r12, r13, r14, r15, r16, r17)
            r1 = 44
            r0 = r20
            pushBackTrackState(r0, r1, r8)
            goto L_0x0062
        L_0x01eb:
            org.mozilla.javascript.regexp.REProgState r1 = popProgState(r20)
            int r2 = r1.index
            r0 = r20
            r0.f6819cp = r2
            org.mozilla.javascript.regexp.REBackTrackData r2 = r1.backTrack
            r0 = r20
            r0.backTrackStackTop = r2
            int r10 = r1.continuationPc
            int r9 = r1.continuationOp
            r1 = 44
            if (r3 != r1) goto L_0x0445
            if (r18 != 0) goto L_0x0209
            r1 = 1
        L_0x0206:
            r2 = r5
            goto L_0x007d
        L_0x0209:
            r1 = 0
            goto L_0x0206
        L_0x020b:
            r1 = 0
            switch(r3) {
                case 25: goto L_0x0245;
                case 26: goto L_0x0214;
                case 27: goto L_0x023d;
                case 28: goto L_0x0241;
                case 45: goto L_0x0215;
                case 46: goto L_0x023e;
                case 47: goto L_0x0242;
                case 48: goto L_0x0246;
                default: goto L_0x020f;
            }
        L_0x020f:
            java.lang.RuntimeException r1 = org.mozilla.javascript.Kit.m5810a()
            throw r1
        L_0x0214:
            r1 = 1
        L_0x0215:
            r12 = 0
            r13 = -1
        L_0x0217:
            r0 = r20
            int r14 = r0.f6819cp
            r15 = 0
            r11 = r20
            r16 = r9
            r17 = r10
            pushProgState(r11, r12, r13, r14, r15, r16, r17)
            if (r1 == 0) goto L_0x0255
            r1 = 51
            r0 = r20
            pushBackTrackState(r0, r1, r5)
            r9 = 51
            int r1 = r5 + 6
            int r10 = r1 + 1
            byte r3 = r4[r1]
            r19 = r5
            r5 = r10
            r10 = r19
            goto L_0x0062
        L_0x023d:
            r1 = 1
        L_0x023e:
            r12 = 1
            r13 = -1
            goto L_0x0217
        L_0x0241:
            r1 = 1
        L_0x0242:
            r12 = 0
            r13 = 1
            goto L_0x0217
        L_0x0245:
            r1 = 1
        L_0x0246:
            int r12 = getOffset(r4, r5)
            int r2 = r5 + 2
            int r3 = getOffset(r4, r2)
            int r13 = r3 + -1
            int r5 = r2 + 2
            goto L_0x0217
        L_0x0255:
            if (r12 == 0) goto L_0x0266
            r9 = 52
            int r1 = r5 + 6
            int r10 = r1 + 1
            byte r3 = r4[r1]
            r19 = r5
            r5 = r10
            r10 = r19
            goto L_0x0062
        L_0x0266:
            r1 = 52
            r0 = r20
            pushBackTrackState(r0, r1, r5)
            popProgState(r20)
            int r1 = r5 + 4
            int r2 = getOffset(r4, r1)
            int r1 = r1 + r2
            int r5 = r1 + 1
            byte r3 = r4[r1]
            goto L_0x0062
        L_0x027d:
            r1 = 1
            r3 = r9
            r18 = r1
            r5 = r10
            goto L_0x0062
        L_0x0284:
            r18 = r1
        L_0x0286:
            org.mozilla.javascript.regexp.REProgState r15 = popProgState(r20)
            if (r18 != 0) goto L_0x02a3
            int r1 = r15.min
            if (r1 != 0) goto L_0x0292
            r18 = 1
        L_0x0292:
            int r10 = r15.continuationPc
            int r9 = r15.continuationOp
            int r1 = r5 + 4
            int r2 = getOffset(r4, r1)
            int r5 = r1 + r2
            r1 = r18
            r2 = r5
            goto L_0x007d
        L_0x02a3:
            int r1 = r15.min
            if (r1 != 0) goto L_0x02bf
            r0 = r20
            int r1 = r0.f6819cp
            int r2 = r15.index
            if (r1 != r2) goto L_0x02bf
            r1 = 0
            int r10 = r15.continuationPc
            int r9 = r15.continuationOp
            int r2 = r5 + 4
            int r3 = getOffset(r4, r2)
            int r5 = r2 + r3
            r2 = r5
            goto L_0x007d
        L_0x02bf:
            int r2 = r15.min
            int r1 = r15.max
            if (r2 == 0) goto L_0x0442
            int r2 = r2 + -1
            r14 = r2
        L_0x02c8:
            r2 = -1
            if (r1 == r2) goto L_0x043f
            int r1 = r1 + -1
            r13 = r1
        L_0x02ce:
            if (r13 != 0) goto L_0x02e0
            r1 = 1
            int r10 = r15.continuationPc
            int r9 = r15.continuationOp
            int r2 = r5 + 4
            int r3 = getOffset(r4, r2)
            int r5 = r2 + r3
            r2 = r5
            goto L_0x007d
        L_0x02e0:
            int r1 = r5 + 6
            byte r8 = r4[r1]
            r0 = r20
            int r0 = r0.f6819cp
            r16 = r0
            boolean r2 = reopIsSimple(r8)
            if (r2 == 0) goto L_0x043a
            int r10 = r1 + 1
            r12 = 1
            r6 = r20
            r7 = r21
            r9 = r4
            r11 = r22
            int r1 = simpleMatch(r6, r7, r8, r9, r10, r11, r12)
            if (r1 >= 0) goto L_0x0314
            if (r14 != 0) goto L_0x0312
            r1 = 1
        L_0x0303:
            int r10 = r15.continuationPc
            int r9 = r15.continuationOp
            int r2 = r5 + 4
            int r3 = getOffset(r4, r2)
            int r5 = r2 + r3
            r2 = r5
            goto L_0x007d
        L_0x0312:
            r1 = 0
            goto L_0x0303
        L_0x0314:
            r18 = 1
            r3 = r1
            r1 = r18
        L_0x0319:
            r2 = 51
            r10 = 0
            int r11 = r15.continuationOp
            int r12 = r15.continuationPc
            r6 = r20
            r7 = r14
            r8 = r13
            r9 = r16
            pushProgState(r6, r7, r8, r9, r10, r11, r12)
            if (r14 != 0) goto L_0x0352
            r7 = 51
            int r10 = r15.continuationOp
            int r11 = r15.continuationPc
            r6 = r20
            r8 = r5
            r9 = r16
            pushBackTrackState(r6, r7, r8, r9, r10, r11)
            int r7 = getIndex(r4, r5)
            int r6 = r5 + 2
            int r8 = getIndex(r4, r6)
            r6 = 0
        L_0x0344:
            if (r6 >= r7) goto L_0x0352
            int r9 = r8 + r6
            r10 = -1
            r11 = 0
            r0 = r20
            r0.setParens(r9, r10, r11)
            int r6 = r6 + 1
            goto L_0x0344
        L_0x0352:
            byte r6 = r4[r3]
            r7 = 49
            if (r6 == r7) goto L_0x0284
            int r10 = r3 + 1
            byte r3 = r4[r3]
            r18 = r1
            r9 = r2
            r19 = r5
            r5 = r10
            r10 = r19
            goto L_0x0062
        L_0x0366:
            org.mozilla.javascript.regexp.REProgState r2 = popProgState(r20)
            if (r18 != 0) goto L_0x03b8
            int r1 = r2.max
            r3 = -1
            if (r1 == r3) goto L_0x0375
            int r1 = r2.max
            if (r1 <= 0) goto L_0x03af
        L_0x0375:
            int r7 = r2.min
            int r8 = r2.max
            r0 = r20
            int r9 = r0.f6819cp
            r10 = 0
            int r11 = r2.continuationOp
            int r12 = r2.continuationPc
            r6 = r20
            pushProgState(r6, r7, r8, r9, r10, r11, r12)
            r9 = 52
            int r2 = getIndex(r4, r5)
            int r1 = r5 + 2
            int r3 = getIndex(r4, r1)
            int r6 = r1 + 4
            r1 = 0
        L_0x0396:
            if (r1 >= r2) goto L_0x03a4
            int r7 = r3 + r1
            r8 = -1
            r10 = 0
            r0 = r20
            r0.setParens(r7, r8, r10)
            int r1 = r1 + 1
            goto L_0x0396
        L_0x03a4:
            int r10 = r6 + 1
            byte r3 = r4[r6]
            r19 = r5
            r5 = r10
            r10 = r19
            goto L_0x0062
        L_0x03af:
            int r10 = r2.continuationPc
            int r9 = r2.continuationOp
            r1 = r18
            r2 = r5
            goto L_0x007d
        L_0x03b8:
            int r1 = r2.min
            if (r1 != 0) goto L_0x03cc
            r0 = r20
            int r1 = r0.f6819cp
            int r3 = r2.index
            if (r1 != r3) goto L_0x03cc
            r1 = 0
            int r10 = r2.continuationPc
            int r9 = r2.continuationOp
            r2 = r5
            goto L_0x007d
        L_0x03cc:
            int r7 = r2.min
            int r8 = r2.max
            if (r7 == 0) goto L_0x03d4
            int r7 = r7 + -1
        L_0x03d4:
            r1 = -1
            if (r8 == r1) goto L_0x03d9
            int r8 = r8 + -1
        L_0x03d9:
            r0 = r20
            int r9 = r0.f6819cp
            r10 = 0
            int r11 = r2.continuationOp
            int r12 = r2.continuationPc
            r6 = r20
            pushProgState(r6, r7, r8, r9, r10, r11, r12)
            if (r7 == 0) goto L_0x0411
            r9 = 52
            int r2 = getIndex(r4, r5)
            int r1 = r5 + 2
            int r3 = getIndex(r4, r1)
            int r6 = r1 + 4
            r1 = 0
        L_0x03f8:
            if (r1 >= r2) goto L_0x0406
            int r7 = r3 + r1
            r8 = -1
            r10 = 0
            r0 = r20
            r0.setParens(r7, r8, r10)
            int r1 = r1 + 1
            goto L_0x03f8
        L_0x0406:
            int r10 = r6 + 1
            byte r3 = r4[r6]
            r19 = r5
            r5 = r10
            r10 = r19
            goto L_0x0062
        L_0x0411:
            int r10 = r2.continuationPc
            int r9 = r2.continuationOp
            r1 = 52
            r0 = r20
            pushBackTrackState(r0, r1, r5)
            popProgState(r20)
            int r1 = r5 + 4
            int r2 = getOffset(r4, r1)
            int r1 = r1 + r2
            int r5 = r1 + 1
            byte r3 = r4[r1]
            goto L_0x0062
        L_0x042c:
            r1 = 1
            goto L_0x003b
        L_0x042f:
            r1 = 0
            goto L_0x003b
        L_0x0432:
            int r5 = r2 + 1
            byte r3 = r4[r2]
            r18 = r1
            goto L_0x0062
        L_0x043a:
            r3 = r1
            r1 = r18
            goto L_0x0319
        L_0x043f:
            r13 = r1
            goto L_0x02ce
        L_0x0442:
            r14 = r2
            goto L_0x02c8
        L_0x0445:
            r1 = r18
            goto L_0x0206
        L_0x0449:
            r1 = r18
            r2 = r5
            goto L_0x0056
        L_0x044e:
            r18 = r8
            goto L_0x0062
        L_0x0452:
            r1 = r12
            r5 = r11
            goto L_0x0038
        L_0x0456:
            r18 = r8
            r5 = r11
            goto L_0x0062
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.executeREBytecode(org.mozilla.javascript.regexp.REGlobalData, java.lang.String, int):boolean");
    }

    private static boolean matchRegExp(REGlobalData rEGlobalData, RECompiled rECompiled, String str, int i, int i2, boolean z) {
        boolean z2;
        if (rECompiled.parenCount != 0) {
            rEGlobalData.parens = new long[rECompiled.parenCount];
        } else {
            rEGlobalData.parens = null;
        }
        rEGlobalData.backTrackStackTop = null;
        rEGlobalData.stateStackTop = null;
        if (z || (rECompiled.flags & 4) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        rEGlobalData.multiline = z2;
        rEGlobalData.regexp = rECompiled;
        int i3 = rEGlobalData.regexp.anchorCh;
        int i4 = i;
        while (i4 <= i2) {
            if (i3 >= 0) {
                while (i4 != i2) {
                    char charAt = str.charAt(i4);
                    if (charAt != i3 && ((rEGlobalData.regexp.flags & 2) == 0 || upcase(charAt) != upcase((char) i3))) {
                        i4++;
                    }
                }
                return false;
            }
            rEGlobalData.f6819cp = i4;
            rEGlobalData.skipped = i4 - i;
            for (int i5 = 0; i5 < rECompiled.parenCount; i5++) {
                rEGlobalData.parens[i5] = -1;
            }
            boolean executeREBytecode = executeREBytecode(rEGlobalData, str, i2);
            rEGlobalData.backTrackStackTop = null;
            rEGlobalData.stateStackTop = null;
            if (executeREBytecode) {
                return true;
            }
            if (i3 != -2 || rEGlobalData.multiline) {
                i4 = rEGlobalData.skipped + i + 1;
            } else {
                rEGlobalData.skipped = i2;
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public Object executeRegExp(Context lVar, Scriptable drVar, RegExpImpl regExpImpl, String str, int[] iArr, int i) {
        Object a;
        Scriptable drVar2;
        REGlobalData rEGlobalData = new REGlobalData();
        int i2 = iArr[0];
        int length = str.length();
        if (i2 > length) {
            i2 = length;
        }
        if (matchRegExp(rEGlobalData, this.f6815re, str, i2, length, regExpImpl.multiline)) {
            int i3 = rEGlobalData.f6819cp;
            iArr[0] = i3;
            int i4 = i3 - (rEGlobalData.skipped + i2);
            int i5 = i3 - i4;
            if (i == 0) {
                a = Boolean.TRUE;
                drVar2 = null;
            } else {
                a = Context.m6751a(drVar, 0);
                drVar2 = (Scriptable) a;
                drVar2.put(0, drVar2, (Object) str.substring(i5, i5 + i4));
            }
            if (this.f6815re.parenCount == 0) {
                regExpImpl.parens = null;
                regExpImpl.lastParen = SubString.emptySubString;
            } else {
                regExpImpl.parens = new SubString[this.f6815re.parenCount];
                SubString subString = null;
                for (int i6 = 0; i6 < this.f6815re.parenCount; i6++) {
                    int parensIndex = rEGlobalData.parensIndex(i6);
                    if (parensIndex != -1) {
                        subString = new SubString(str, parensIndex, rEGlobalData.parensLength(i6));
                        regExpImpl.parens[i6] = subString;
                        if (i != 0) {
                            drVar2.put(i6 + 1, drVar2, (Object) subString.toString());
                        }
                    } else if (i != 0) {
                        drVar2.put(i6 + 1, drVar2, Undefined.f6689a);
                    }
                }
                regExpImpl.lastParen = subString;
            }
            if (i != 0) {
                drVar2.put("index", drVar2, (Object) Integer.valueOf(rEGlobalData.skipped + i2));
                drVar2.put("input", drVar2, (Object) str);
            }
            if (regExpImpl.lastMatch == null) {
                regExpImpl.lastMatch = new SubString();
                regExpImpl.leftContext = new SubString();
                regExpImpl.rightContext = new SubString();
            }
            regExpImpl.lastMatch.str = str;
            regExpImpl.lastMatch.index = i5;
            regExpImpl.lastMatch.length = i4;
            regExpImpl.leftContext.str = str;
            if (lVar.f6785i == 120) {
                regExpImpl.leftContext.index = i2;
                regExpImpl.leftContext.length = rEGlobalData.skipped;
            } else {
                regExpImpl.leftContext.index = 0;
                regExpImpl.leftContext.length = rEGlobalData.skipped + i2;
            }
            regExpImpl.rightContext.str = str;
            regExpImpl.rightContext.index = i3;
            regExpImpl.rightContext.length = length - i3;
            return a;
        } else if (i != 2) {
            return null;
        } else {
            return Undefined.f6689a;
        }
    }

    /* access modifiers changed from: 0000 */
    public int getFlags() {
        return this.f6815re.flags;
    }

    private static void reportWarning(Context lVar, String str, String str2) {
        if (lVar.mo19138b(11)) {
            Context.m6760a(ScriptRuntime.m6349a(str, (Object) str2));
        }
    }

    private static void reportError(String str, String str2) {
        throw ScriptRuntime.m6375a("SyntaxError", ScriptRuntime.m6349a(str, (Object) str2));
    }

    /* access modifiers changed from: protected */
    public int getMaxInstanceId() {
        return 5;
    }

    /* access modifiers changed from: protected */
    public int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int i2 = 6;
        int i3 = 0;
        int length = str.length();
        if (length == 6) {
            char charAt = str.charAt(0);
            if (charAt == 'g') {
                i = 3;
                str2 = "global";
            } else {
                if (charAt == 's') {
                    i = 2;
                    str2 = "source";
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 9) {
            char charAt2 = str.charAt(0);
            if (charAt2 == 'l') {
                i = 1;
                str2 = "lastIndex";
            } else {
                if (charAt2 == 'm') {
                    i = 5;
                    str2 = "multiline";
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 10) {
                i = 4;
                str2 = "ignoreCase";
            }
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            i3 = i;
        }
        if (i3 == 0) {
            return super.findInstanceIdInfo(str);
        }
        switch (i3) {
            case 1:
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                i2 = 7;
                break;
            default:
                throw new IllegalStateException();
        }
        return instanceIdInfo(i2, i3);
    }

    /* access modifiers changed from: protected */
    public String getInstanceIdName(int i) {
        switch (i) {
            case 1:
                return "lastIndex";
            case 2:
                return "source";
            case 3:
                return "global";
            case 4:
                return "ignoreCase";
            case 5:
                return "multiline";
            default:
                return super.getInstanceIdName(i);
        }
    }

    /* access modifiers changed from: protected */
    public Object getInstanceIdValue(int i) {
        boolean z = true;
        switch (i) {
            case 1:
                return ScriptRuntime.m6313a(this.lastIndex);
            case 2:
                return new String(this.f6815re.source);
            case 3:
                if ((this.f6815re.flags & 1) == 0) {
                    z = false;
                }
                return ScriptRuntime.m6312a(z);
            case 4:
                if ((this.f6815re.flags & 2) == 0) {
                    z = false;
                }
                return ScriptRuntime.m6312a(z);
            case 5:
                if ((this.f6815re.flags & 4) == 0) {
                    z = false;
                }
                return ScriptRuntime.m6312a(z);
            default:
                return super.getInstanceIdValue(i);
        }
    }

    /* access modifiers changed from: protected */
    public void setInstanceIdValue(int i, Object obj) {
        switch (i) {
            case 1:
                this.lastIndex = ScriptRuntime.m6395b(obj);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
                return;
            default:
                super.setInstanceIdValue(i, obj);
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void initPrototypeId(int i) {
        String str;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "compile";
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
                str = "exec";
                break;
            case 5:
                str = "test";
                break;
            case 6:
                str = "prefix";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(REGEXP_TAG, i, str, i2);
    }

    public Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        if (!ahVar.mo18643a(REGEXP_TAG)) {
            return super.execIdCall(ahVar, lVar, drVar, drVar2, objArr);
        }
        int i = ahVar.f5994a;
        switch (i) {
            case 1:
                return realThis(drVar2, ahVar).compile(lVar, drVar, objArr);
            case 2:
            case 3:
                return realThis(drVar2, ahVar).toString();
            case 4:
                return realThis(drVar2, ahVar).execSub(lVar, drVar, objArr, 1);
            case 5:
                return Boolean.TRUE.equals(realThis(drVar2, ahVar).execSub(lVar, drVar, objArr, 0)) ? Boolean.TRUE : Boolean.FALSE;
            case 6:
                return realThis(drVar2, ahVar).execSub(lVar, drVar, objArr, 2);
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    private static NativeRegExp realThis(Scriptable drVar, IdFunctionObject ahVar) {
        if (drVar instanceof NativeRegExp) {
            return (NativeRegExp) drVar;
        }
        throw incompatibleCallError(ahVar);
    }

    /* access modifiers changed from: protected */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findPrototypeId(String r8) {
        /*
            r7 = this;
            r5 = 116(0x74, float:1.63E-43)
            r2 = 3
            r0 = 0
            r1 = 0
            int r3 = r8.length()
            switch(r3) {
                case 4: goto L_0x0019;
                case 5: goto L_0x000c;
                case 6: goto L_0x0031;
                case 7: goto L_0x0038;
                case 8: goto L_0x003f;
                default: goto L_0x000c;
            }
        L_0x000c:
            r2 = r1
            r1 = r0
        L_0x000e:
            if (r2 == 0) goto L_0x0056
            if (r2 == r8) goto L_0x0056
            boolean r2 = r2.equals(r8)
            if (r2 != 0) goto L_0x0056
        L_0x0018:
            return r0
        L_0x0019:
            char r2 = r8.charAt(r0)
            r3 = 101(0x65, float:1.42E-43)
            if (r2 != r3) goto L_0x0028
            java.lang.String r1 = "exec"
            r2 = 4
            r6 = r1
            r1 = r2
            r2 = r6
            goto L_0x000e
        L_0x0028:
            if (r2 != r5) goto L_0x000c
            java.lang.String r1 = "test"
            r2 = 5
            r6 = r1
            r1 = r2
            r2 = r6
            goto L_0x000e
        L_0x0031:
            java.lang.String r1 = "prefix"
            r2 = 6
            r6 = r1
            r1 = r2
            r2 = r6
            goto L_0x000e
        L_0x0038:
            java.lang.String r1 = "compile"
            r2 = 1
            r6 = r1
            r1 = r2
            r2 = r6
            goto L_0x000e
        L_0x003f:
            char r3 = r8.charAt(r2)
            r4 = 111(0x6f, float:1.56E-43)
            if (r3 != r4) goto L_0x004d
            java.lang.String r1 = "toSource"
            r6 = r1
            r1 = r2
            r2 = r6
            goto L_0x000e
        L_0x004d:
            if (r3 != r5) goto L_0x000c
            java.lang.String r1 = "toString"
            r2 = 2
            r6 = r1
            r1 = r2
            r2 = r6
            goto L_0x000e
        L_0x0056:
            r0 = r1
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExp.findPrototypeId(java.lang.String):int");
    }
}
