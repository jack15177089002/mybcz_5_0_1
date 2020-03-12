package org.mozilla.javascript.regexp;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.RegExpProxy;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

public class RegExpImpl implements RegExpProxy {
    protected String input;
    protected SubString lastMatch;
    protected SubString lastParen;
    protected SubString leftContext;
    protected boolean multiline;
    protected SubString[] parens;
    protected SubString rightContext;

    public boolean isRegExp(Scriptable drVar) {
        return drVar instanceof NativeRegExp;
    }

    public Object compileRegExp(Context lVar, String str, String str2) {
        return NativeRegExp.compileRE(lVar, str, str2, false);
    }

    public Scriptable wrapRegExp(Context lVar, Scriptable drVar, Object obj) {
        return new NativeRegExp(drVar, (RECompiled) obj);
    }

    public Object action(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr, int i) {
        String d;
        Function abVar;
        int indexOf;
        GlobData globData = new GlobData();
        globData.mode = i;
        switch (i) {
            case 1:
                globData.optarg = 1;
                Object matchOrReplace = matchOrReplace(lVar, drVar, drVar2, objArr, this, globData, false);
                if (globData.arrayobj == null) {
                    return matchOrReplace;
                }
                return globData.arrayobj;
            case 2:
                Object obj = objArr.length < 2 ? Undefined.f6689a : objArr[1];
                if (obj instanceof Function) {
                    abVar = (Function) obj;
                    d = null;
                } else {
                    d = ScriptRuntime.m6436d(obj);
                    abVar = null;
                }
                globData.optarg = 2;
                globData.lambda = abVar;
                globData.repstr = d;
                if (d == null) {
                    indexOf = -1;
                } else {
                    indexOf = d.indexOf(36);
                }
                globData.dollar = indexOf;
                globData.charBuf = null;
                globData.leftIndex = 0;
                Object matchOrReplace2 = matchOrReplace(lVar, drVar, drVar2, objArr, this, globData, true);
                if (globData.charBuf == null) {
                    if (globData.global || matchOrReplace2 == null || !matchOrReplace2.equals(Boolean.TRUE)) {
                        return globData.str;
                    }
                    SubString subString = this.leftContext;
                    replace_glob(globData, lVar, drVar, this, subString.index, subString.length);
                }
                SubString subString2 = this.rightContext;
                globData.charBuf.append(subString2.str, subString2.index, subString2.length + subString2.index);
                return globData.charBuf.toString();
            case 3:
                globData.optarg = 1;
                return matchOrReplace(lVar, drVar, drVar2, objArr, this, globData, false);
            default:
                throw Kit.m5810a();
        }
    }

    private static Object matchOrReplace(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr, RegExpImpl regExpImpl, GlobData globData, boolean z) {
        String str;
        NativeRegExp nativeRegExp;
        String d = ScriptRuntime.m6436d((Object) drVar2);
        globData.str = d;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(drVar);
        if (objArr.length == 0) {
            nativeRegExp = new NativeRegExp(topLevelScope, NativeRegExp.compileRE(lVar, "", "", false));
        } else if (objArr[0] instanceof NativeRegExp) {
            nativeRegExp = (NativeRegExp) objArr[0];
        } else {
            String d2 = ScriptRuntime.m6436d(objArr[0]);
            if (globData.optarg < objArr.length) {
                objArr[0] = d2;
                str = ScriptRuntime.m6436d(objArr[globData.optarg]);
            } else {
                str = null;
            }
            nativeRegExp = new NativeRegExp(topLevelScope, NativeRegExp.compileRE(lVar, d2, str, z));
        }
        globData.global = (nativeRegExp.getFlags() & 1) != 0;
        int[] iArr = {0};
        Object obj = null;
        if (globData.mode == 3) {
            Object executeRegExp = nativeRegExp.executeRegExp(lVar, drVar, regExpImpl, d, iArr, 0);
            if (executeRegExp == null || !executeRegExp.equals(Boolean.TRUE)) {
                return Integer.valueOf(-1);
            }
            return Integer.valueOf(regExpImpl.leftContext.length);
        } else if (globData.global) {
            nativeRegExp.lastIndex = 0.0d;
            int i = 0;
            while (true) {
                int i2 = i;
                Object obj2 = obj;
                if (iArr[0] > d.length()) {
                    return obj2;
                }
                obj = nativeRegExp.executeRegExp(lVar, drVar, regExpImpl, d, iArr, 0);
                if (obj == null || !obj.equals(Boolean.TRUE)) {
                    return obj;
                }
                if (globData.mode == 1) {
                    match_glob(globData, lVar, drVar, i2, regExpImpl);
                } else {
                    if (globData.mode != 2) {
                        Kit.m5810a();
                    }
                    SubString subString = regExpImpl.lastMatch;
                    int i3 = globData.leftIndex;
                    int i4 = subString.index - i3;
                    globData.leftIndex = subString.length + subString.index;
                    replace_glob(globData, lVar, drVar, regExpImpl, i3, i4);
                }
                if (regExpImpl.lastMatch.length == 0) {
                    if (iArr[0] == d.length()) {
                        return obj;
                    }
                    iArr[0] = iArr[0] + 1;
                }
                i = i2 + 1;
            }
        } else {
            return nativeRegExp.executeRegExp(lVar, drVar, regExpImpl, d, iArr, globData.mode == 2 ? 0 : 1);
        }
    }

    public int find_split(Context lVar, Scriptable drVar, String str, String str2, Scriptable drVar2, int[] iArr, int[] iArr2, boolean[] zArr, String[][] strArr) {
        int i;
        int i2 = iArr[0];
        int length = str.length();
        int i3 = lVar.f6785i;
        NativeRegExp nativeRegExp = (NativeRegExp) drVar2;
        while (true) {
            int i4 = iArr[0];
            iArr[0] = i2;
            if (nativeRegExp.executeRegExp(lVar, drVar, this, str, iArr, 0) != Boolean.TRUE) {
                iArr[0] = i4;
                iArr2[0] = 1;
                zArr[0] = false;
                return length;
            }
            int i5 = iArr[0];
            iArr[0] = i4;
            zArr[0] = true;
            iArr2[0] = this.lastMatch.length;
            if (iArr2[0] != 0 || i5 != iArr[0]) {
                i = i5 - iArr2[0];
            } else if (i5 != length) {
                i2 = i5 + 1;
            } else if (i3 == 120) {
                iArr2[0] = 1;
                i = i5;
            } else {
                i = -1;
            }
        }
        int length2 = this.parens == null ? 0 : this.parens.length;
        strArr[0] = new String[length2];
        for (int i6 = 0; i6 < length2; i6++) {
            strArr[0][i6] = getParenSubString(i6).toString();
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    public SubString getParenSubString(int i) {
        if (this.parens != null && i < this.parens.length) {
            SubString subString = this.parens[i];
            if (subString != null) {
                return subString;
            }
        }
        return SubString.emptySubString;
    }

    private static void match_glob(GlobData globData, Context lVar, Scriptable drVar, int i, RegExpImpl regExpImpl) {
        if (globData.arrayobj == null) {
            globData.arrayobj = Context.m6751a(drVar, 0);
        }
        globData.arrayobj.put(i, globData.arrayobj, (Object) regExpImpl.lastMatch.toString());
    }

    /* JADX INFO: finally extract failed */
    private static void replace_glob(GlobData globData, Context lVar, Scriptable drVar, RegExpImpl regExpImpl, int i, int i2) {
        int length;
        String str;
        int i3;
        if (globData.lambda != null) {
            SubString[] subStringArr = regExpImpl.parens;
            int length2 = subStringArr == null ? 0 : subStringArr.length;
            Object[] objArr = new Object[(length2 + 3)];
            objArr[0] = regExpImpl.lastMatch.toString();
            for (int i4 = 0; i4 < length2; i4++) {
                SubString subString = subStringArr[i4];
                if (subString != null) {
                    objArr[i4 + 1] = subString.toString();
                } else {
                    objArr[i4 + 1] = Undefined.f6689a;
                }
            }
            objArr[length2 + 1] = Integer.valueOf(regExpImpl.leftContext.length);
            objArr[length2 + 2] = globData.str;
            if (regExpImpl != ScriptRuntime.m6449f(lVar)) {
                Kit.m5810a();
            }
            RegExpImpl regExpImpl2 = new RegExpImpl();
            regExpImpl2.multiline = regExpImpl.multiline;
            regExpImpl2.input = regExpImpl.input;
            ScriptRuntime.m6386a(lVar, (RegExpProxy) regExpImpl2);
            try {
                Scriptable topLevelScope = ScriptableObject.getTopLevelScope(drVar);
                str = ScriptRuntime.m6436d(globData.lambda.call(lVar, topLevelScope, topLevelScope, objArr));
                ScriptRuntime.m6386a(lVar, (RegExpProxy) regExpImpl);
                length = str.length();
            } catch (Throwable th) {
                ScriptRuntime.m6386a(lVar, (RegExpProxy) regExpImpl);
                throw th;
            }
        } else {
            length = globData.repstr.length();
            if (globData.dollar >= 0) {
                int[] iArr = new int[1];
                int i5 = globData.dollar;
                do {
                    SubString interpretDollar = interpretDollar(lVar, regExpImpl, globData.repstr, i5, iArr);
                    if (interpretDollar != null) {
                        length += interpretDollar.length - iArr[0];
                        i3 = i5 + iArr[0];
                    } else {
                        i3 = i5 + 1;
                    }
                    i5 = globData.repstr.indexOf(36, i3);
                } while (i5 >= 0);
            }
            str = null;
        }
        int i6 = regExpImpl.rightContext.length + i2 + length;
        StringBuilder sb = globData.charBuf;
        if (sb == null) {
            sb = new StringBuilder(i6);
            globData.charBuf = sb;
        } else {
            sb.ensureCapacity(i6 + globData.charBuf.length());
        }
        sb.append(regExpImpl.leftContext.str, i, i + i2);
        if (globData.lambda != null) {
            sb.append(str);
        } else {
            do_replace(globData, lVar, regExpImpl);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static SubString interpretDollar(org.mozilla.javascript.Context r7, RegExpImpl r8, String r9, int r10, int[] r11) {
        /*
            r4 = 140(0x8c, float:1.96E-43)
            r5 = 0
            r2 = 0
            char r0 = r9.charAt(r10)
            r1 = 36
            if (r0 == r1) goto L_0x000f
            org.mozilla.javascript.Kit.m5810a()
        L_0x000f:
            int r0 = r7.f6785i
            if (r0 == 0) goto L_0x0023
            if (r0 > r4) goto L_0x0023
            if (r10 <= 0) goto L_0x0023
            int r1 = r10 + -1
            char r1 = r9.charAt(r1)
            r3 = 92
            if (r1 != r3) goto L_0x0023
            r0 = r2
        L_0x0022:
            return r0
        L_0x0023:
            int r6 = r9.length()
            int r1 = r10 + 1
            if (r1 < r6) goto L_0x002d
            r0 = r2
            goto L_0x0022
        L_0x002d:
            int r1 = r10 + 1
            char r1 = r9.charAt(r1)
            boolean r3 = org.mozilla.javascript.regexp.NativeRegExp.isDigit(r1)
            if (r3 == 0) goto L_0x0091
            if (r0 == 0) goto L_0x005c
            if (r0 > r4) goto L_0x005c
            r0 = 48
            if (r1 != r0) goto L_0x0043
            r0 = r2
            goto L_0x0022
        L_0x0043:
            r0 = r10
            r1 = r5
        L_0x0045:
            int r0 = r0 + 1
            if (r0 >= r6) goto L_0x0087
            char r2 = r9.charAt(r0)
            boolean r3 = org.mozilla.javascript.regexp.NativeRegExp.isDigit(r2)
            if (r3 == 0) goto L_0x0087
            int r3 = r1 * 10
            int r2 = r2 + -48
            int r2 = r2 + r3
            if (r2 < r1) goto L_0x0087
            r1 = r2
            goto L_0x0045
        L_0x005c:
            org.mozilla.javascript.regexp.SubString[] r0 = r8.parens
            if (r0 != 0) goto L_0x0067
            r4 = r5
        L_0x0061:
            int r3 = r1 + -48
            if (r3 <= r4) goto L_0x006c
            r0 = r2
            goto L_0x0022
        L_0x0067:
            org.mozilla.javascript.regexp.SubString[] r0 = r8.parens
            int r0 = r0.length
            r4 = r0
            goto L_0x0061
        L_0x006c:
            int r0 = r10 + 2
            if (r0 >= r6) goto L_0x00c1
            char r1 = r9.charAt(r0)
            boolean r6 = org.mozilla.javascript.regexp.NativeRegExp.isDigit(r1)
            if (r6 == 0) goto L_0x00c1
            int r6 = r3 * 10
            int r1 = r1 + -48
            int r1 = r1 + r6
            if (r1 > r4) goto L_0x00c1
            int r0 = r0 + 1
        L_0x0083:
            if (r1 != 0) goto L_0x0087
            r0 = r2
            goto L_0x0022
        L_0x0087:
            int r1 = r1 + -1
            int r0 = r0 - r10
            r11[r5] = r0
            org.mozilla.javascript.regexp.SubString r0 = r8.getParenSubString(r1)
            goto L_0x0022
        L_0x0091:
            r3 = 2
            r11[r5] = r3
            switch(r1) {
                case 36: goto L_0x0099;
                case 38: goto L_0x00a1;
                case 39: goto L_0x00bd;
                case 43: goto L_0x00a5;
                case 96: goto L_0x00a9;
                default: goto L_0x0097;
            }
        L_0x0097:
            r0 = r2
            goto L_0x0022
        L_0x0099:
            org.mozilla.javascript.regexp.SubString r0 = new org.mozilla.javascript.regexp.SubString
            java.lang.String r1 = "$"
            r0.<init>(r1)
            goto L_0x0022
        L_0x00a1:
            org.mozilla.javascript.regexp.SubString r0 = r8.lastMatch
            goto L_0x0022
        L_0x00a5:
            org.mozilla.javascript.regexp.SubString r0 = r8.lastParen
            goto L_0x0022
        L_0x00a9:
            r1 = 120(0x78, float:1.68E-43)
            if (r0 != r1) goto L_0x00b9
            org.mozilla.javascript.regexp.SubString r0 = r8.leftContext
            r0.index = r5
            org.mozilla.javascript.regexp.SubString r0 = r8.leftContext
            org.mozilla.javascript.regexp.SubString r1 = r8.lastMatch
            int r1 = r1.index
            r0.length = r1
        L_0x00b9:
            org.mozilla.javascript.regexp.SubString r0 = r8.leftContext
            goto L_0x0022
        L_0x00bd:
            org.mozilla.javascript.regexp.SubString r0 = r8.rightContext
            goto L_0x0022
        L_0x00c1:
            r1 = r3
            goto L_0x0083
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.RegExpImpl.interpretDollar(org.mozilla.javascript.l, org.mozilla.javascript.regexp.RegExpImpl, java.lang.String, int, int[]):org.mozilla.javascript.regexp.SubString");
    }

    private static void do_replace(GlobData globData, Context lVar, RegExpImpl regExpImpl) {
        int i;
        int i2;
        StringBuilder sb = globData.charBuf;
        String str = globData.repstr;
        int i3 = globData.dollar;
        if (i3 != -1) {
            int[] iArr = new int[1];
            int i4 = i3;
            i = 0;
            do {
                sb.append(str.substring(i, i4));
                SubString interpretDollar = interpretDollar(lVar, regExpImpl, str, i4, iArr);
                if (interpretDollar != null) {
                    int i5 = interpretDollar.length;
                    if (i5 > 0) {
                        sb.append(interpretDollar.str, interpretDollar.index, interpretDollar.index + i5);
                    }
                    i = iArr[0] + i4;
                    i2 = i4 + iArr[0];
                } else {
                    int i6 = i4;
                    i2 = i4 + 1;
                    i = i6;
                }
                i4 = str.indexOf(36, i2);
            } while (i4 >= 0);
        } else {
            i = 0;
        }
        int length = str.length();
        if (length > i) {
            sb.append(str.substring(i, length));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Object js_split(org.mozilla.javascript.Context r25, org.mozilla.javascript.Scriptable r26, String r27, Object[] r28) {
        /*
            r24 = this;
            r4 = 0
            r0 = r26
            org.mozilla.javascript.dr r18 = org.mozilla.javascript.Context.m6751a(r0, r4)
            r0 = r28
            int r4 = r0.length
            if (r4 > 0) goto L_0x0019
            r4 = 0
            r0 = r18
            r1 = r18
            r2 = r27
            r0.put(r4, r1, r2)
            r4 = r18
        L_0x0018:
            return r4
        L_0x0019:
            r0 = r28
            int r4 = r0.length
            r5 = 1
            if (r4 <= r5) goto L_0x00e7
            r4 = 1
            r4 = r28[r4]
            java.lang.Object r5 = org.mozilla.javascript.Undefined.f6689a
            if (r4 == r5) goto L_0x00e7
            r4 = 1
            r19 = r4
        L_0x0029:
            r4 = 0
            if (r19 == 0) goto L_0x011c
            r4 = 1
            r4 = r28[r4]
            long r4 = org.mozilla.javascript.ScriptRuntime.m6452g(r4)
            int r6 = r27.length()
            long r6 = (long) r6
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x011c
            int r4 = r27.length()
            int r4 = r4 + 1
            long r4 = (long) r4
            r16 = r4
        L_0x0046:
            r7 = 0
            r4 = 1
            int[] r12 = new int[r4]
            r10 = 0
            r9 = 0
            r4 = 0
            r4 = r28[r4]
            boolean r4 = r4 instanceof org.mozilla.javascript.Scriptable
            if (r4 == 0) goto L_0x0065
            org.mozilla.javascript.df r9 = org.mozilla.javascript.ScriptRuntime.m6449f(r25)
            if (r9 == 0) goto L_0x0065
            r4 = 0
            r4 = r28[r4]
            org.mozilla.javascript.dr r4 = (org.mozilla.javascript.Scriptable) r4
            boolean r5 = r9.isRegExp(r4)
            if (r5 == 0) goto L_0x0065
            r10 = r4
        L_0x0065:
            if (r10 != 0) goto L_0x0075
            r4 = 0
            r4 = r28[r4]
            java.lang.String r7 = org.mozilla.javascript.ScriptRuntime.m6436d(r4)
            r4 = 0
            int r5 = r7.length()
            r12[r4] = r5
        L_0x0075:
            r4 = 1
            int[] r11 = new int[r4]
            r4 = 0
            r5 = 0
            r11[r4] = r5
            r4 = 0
            r5 = 1
            boolean[] r13 = new boolean[r5]
            r5 = 0
            r6 = 0
            r13[r5] = r6
            r5 = 1
            java.lang.String[][] r14 = new java.lang.String[r5][]
            r5 = 0
            r6 = 0
            r14[r5] = r6
            r0 = r25
            int r8 = r0.f6785i
            r15 = r4
        L_0x0090:
            r4 = r25
            r5 = r26
            r6 = r27
            int r20 = find_split(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            if (r20 < 0) goto L_0x0118
            if (r19 == 0) goto L_0x00a3
            long r4 = (long) r15
            int r4 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r4 >= 0) goto L_0x0118
        L_0x00a3:
            int r4 = r27.length()
            r0 = r20
            if (r0 > r4) goto L_0x0118
            int r4 = r27.length()
            if (r4 != 0) goto L_0x00ec
            r4 = r27
        L_0x00b3:
            r0 = r18
            r1 = r18
            r0.put(r15, r1, r4)
            int r4 = r15 + 1
            if (r10 == 0) goto L_0x00fc
            r5 = 0
            boolean r5 = r13[r5]
            r6 = 1
            if (r5 != r6) goto L_0x00fc
            r5 = 0
            r5 = r14[r5]
            int r15 = r5.length
            r5 = 0
        L_0x00c9:
            if (r5 >= r15) goto L_0x00f8
            if (r19 == 0) goto L_0x00d4
            long r0 = (long) r4
            r22 = r0
            int r6 = (r22 > r16 ? 1 : (r22 == r16 ? 0 : -1))
            if (r6 >= 0) goto L_0x00f8
        L_0x00d4:
            r6 = 0
            r6 = r14[r6]
            r6 = r6[r5]
            r0 = r18
            r1 = r18
            r0.put(r4, r1, r6)
            int r6 = r4 + 1
            int r4 = r5 + 1
            r5 = r4
            r4 = r6
            goto L_0x00c9
        L_0x00e7:
            r4 = 0
            r19 = r4
            goto L_0x0029
        L_0x00ec:
            r4 = 0
            r4 = r11[r4]
            r0 = r27
            r1 = r20
            java.lang.String r4 = r0.substring(r4, r1)
            goto L_0x00b3
        L_0x00f8:
            r5 = 0
            r6 = 0
            r13[r5] = r6
        L_0x00fc:
            r5 = 0
            r6 = 0
            r6 = r12[r6]
            int r6 = r6 + r20
            r11[r5] = r6
            r5 = 130(0x82, float:1.82E-43)
            if (r8 >= r5) goto L_0x0115
            if (r8 == 0) goto L_0x0115
            if (r19 != 0) goto L_0x0115
            r5 = 0
            r5 = r11[r5]
            int r6 = r27.length()
            if (r5 == r6) goto L_0x0118
        L_0x0115:
            r15 = r4
            goto L_0x0090
        L_0x0118:
            r4 = r18
            goto L_0x0018
        L_0x011c:
            r16 = r4
            goto L_0x0046
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.RegExpImpl.js_split(org.mozilla.javascript.l, org.mozilla.javascript.dr, java.lang.String, java.lang.Object[]):java.lang.Object");
    }

    private static int find_split(Context lVar, Scriptable drVar, String str, String str2, int i, RegExpProxy dfVar, Scriptable drVar2, int[] iArr, int[] iArr2, boolean[] zArr, String[][] strArr) {
        int i2 = iArr[0];
        int length = str.length();
        if (i == 120 && drVar2 == null && str2.length() == 1 && str2.charAt(0) == ' ') {
            if (i2 == 0) {
                while (i2 < length && Character.isWhitespace(str.charAt(i2))) {
                    i2++;
                }
                iArr[0] = i2;
            }
            if (i2 == length) {
                return -1;
            }
            while (i2 < length && !Character.isWhitespace(str.charAt(i2))) {
                i2++;
            }
            int i3 = i2;
            while (i3 < length && Character.isWhitespace(str.charAt(i3))) {
                i3++;
            }
            iArr2[0] = i3 - i2;
            return i2;
        } else if (i2 > length) {
            return -1;
        } else {
            if (drVar2 != null) {
                return dfVar.find_split(lVar, drVar, str, str2, drVar2, iArr, iArr2, zArr, strArr);
            }
            if (i != 0 && i < 130 && length == 0) {
                return -1;
            }
            if (str2.length() == 0) {
                if (i == 120) {
                    if (i2 != length) {
                        return i2 + 1;
                    }
                    iArr2[0] = 1;
                    return i2;
                } else if (i2 == length) {
                    return -1;
                } else {
                    return i2 + 1;
                }
            } else if (iArr[0] >= length) {
                return length;
            } else {
                int indexOf = str.indexOf(str2, iArr[0]);
                return indexOf == -1 ? length : indexOf;
            }
        }
    }
}
