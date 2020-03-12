package org.mozilla.javascript.regexp;

import org.mozilla.javascript.BaseFunction;
import org.mozilla.javascript.C2193eh;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;
import p012ch.qos.logback.core.CoreConstants;

class NativeRegExpCtor extends BaseFunction {
    private static final int DOLLAR_ID_BASE = 12;
    private static final int Id_AMPERSAND = 6;
    private static final int Id_BACK_QUOTE = 10;
    private static final int Id_DOLLAR_1 = 13;
    private static final int Id_DOLLAR_2 = 14;
    private static final int Id_DOLLAR_3 = 15;
    private static final int Id_DOLLAR_4 = 16;
    private static final int Id_DOLLAR_5 = 17;
    private static final int Id_DOLLAR_6 = 18;
    private static final int Id_DOLLAR_7 = 19;
    private static final int Id_DOLLAR_8 = 20;
    private static final int Id_DOLLAR_9 = 21;
    private static final int Id_PLUS = 8;
    private static final int Id_QUOTE = 12;
    private static final int Id_STAR = 2;
    private static final int Id_UNDERSCORE = 4;
    private static final int Id_input = 3;
    private static final int Id_lastMatch = 5;
    private static final int Id_lastParen = 7;
    private static final int Id_leftContext = 9;
    private static final int Id_multiline = 1;
    private static final int Id_rightContext = 11;
    private static final int MAX_INSTANCE_ID = 21;
    static final long serialVersionUID = -5733330028285400526L;

    NativeRegExpCtor() {
    }

    public String getFunctionName() {
        return "RegExp";
    }

    public Object call(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        if (objArr.length <= 0 || !(objArr[0] instanceof NativeRegExp) || (objArr.length != 1 && objArr[1] != Undefined.f6689a)) {
            return construct(lVar, drVar, objArr);
        }
        return objArr[0];
    }

    public Scriptable construct(Context lVar, Scriptable drVar, Object[] objArr) {
        NativeRegExp nativeRegExp = new NativeRegExp();
        nativeRegExp.compile(lVar, drVar, objArr);
        ScriptRuntime.m6384a((ScriptableObject) nativeRegExp, drVar, C2193eh.RegExp);
        return nativeRegExp;
    }

    private static RegExpImpl getImpl() {
        return (RegExpImpl) ScriptRuntime.m6449f(Context.m6753a());
    }

    /* access modifiers changed from: protected */
    public int getMaxInstanceId() {
        return super.getMaxInstanceId() + 21;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r4 = null;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (r4 == null) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        if (r4 == r9) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00f1, code lost:
        switch(r2) {
            case 1: goto L_0x00f5;
            case 2: goto L_0x00f5;
            case 3: goto L_0x00f5;
            case 4: goto L_0x00f5;
            default: goto L_0x00f4;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        if (r4.equals(r9) != false) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00f4, code lost:
        r0 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0100, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return super.findInstanceIdInfo(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        return instanceIdInfo(r0, super.getMaxInstanceId() + r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        if (r2 != 0) goto L_0x00f1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findInstanceIdInfo(String r9) {
        /*
            r8 = this;
            r1 = 5
            r4 = 1
            r0 = 4
            r6 = 36
            r2 = 0
            r3 = 0
            int r5 = r9.length()
            switch(r5) {
                case 2: goto L_0x0021;
                case 3: goto L_0x000e;
                case 4: goto L_0x000e;
                case 5: goto L_0x00b2;
                case 6: goto L_0x000e;
                case 7: goto L_0x000e;
                case 8: goto L_0x000e;
                case 9: goto L_0x00ba;
                case 10: goto L_0x000e;
                case 11: goto L_0x00df;
                case 12: goto L_0x00e8;
                default: goto L_0x000e;
            }
        L_0x000e:
            r4 = r3
            r3 = r2
        L_0x0010:
            if (r4 == 0) goto L_0x0100
            if (r4 == r9) goto L_0x0100
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L_0x0100
        L_0x001a:
            if (r2 != 0) goto L_0x00f1
            int r0 = super.findInstanceIdInfo(r9)
        L_0x0020:
            return r0
        L_0x0021:
            char r4 = r9.charAt(r4)
            switch(r4) {
                case 38: goto L_0x002b;
                case 39: goto L_0x0033;
                case 42: goto L_0x003c;
                case 43: goto L_0x0044;
                case 49: goto L_0x004d;
                case 50: goto L_0x0056;
                case 51: goto L_0x005f;
                case 52: goto L_0x0068;
                case 53: goto L_0x0071;
                case 54: goto L_0x007a;
                case 55: goto L_0x0083;
                case 56: goto L_0x008c;
                case 57: goto L_0x0095;
                case 95: goto L_0x009f;
                case 96: goto L_0x00a8;
                default: goto L_0x0028;
            }
        L_0x0028:
            r4 = r3
            r3 = r2
            goto L_0x0010
        L_0x002b:
            char r4 = r9.charAt(r2)
            if (r4 != r6) goto L_0x000e
            r2 = 6
            goto L_0x001a
        L_0x0033:
            char r4 = r9.charAt(r2)
            if (r4 != r6) goto L_0x000e
            r2 = 12
            goto L_0x001a
        L_0x003c:
            char r4 = r9.charAt(r2)
            if (r4 != r6) goto L_0x000e
            r2 = 2
            goto L_0x001a
        L_0x0044:
            char r4 = r9.charAt(r2)
            if (r4 != r6) goto L_0x000e
            r2 = 8
            goto L_0x001a
        L_0x004d:
            char r4 = r9.charAt(r2)
            if (r4 != r6) goto L_0x000e
            r2 = 13
            goto L_0x001a
        L_0x0056:
            char r4 = r9.charAt(r2)
            if (r4 != r6) goto L_0x000e
            r2 = 14
            goto L_0x001a
        L_0x005f:
            char r4 = r9.charAt(r2)
            if (r4 != r6) goto L_0x000e
            r2 = 15
            goto L_0x001a
        L_0x0068:
            char r4 = r9.charAt(r2)
            if (r4 != r6) goto L_0x000e
            r2 = 16
            goto L_0x001a
        L_0x0071:
            char r4 = r9.charAt(r2)
            if (r4 != r6) goto L_0x000e
            r2 = 17
            goto L_0x001a
        L_0x007a:
            char r4 = r9.charAt(r2)
            if (r4 != r6) goto L_0x000e
            r2 = 18
            goto L_0x001a
        L_0x0083:
            char r4 = r9.charAt(r2)
            if (r4 != r6) goto L_0x000e
            r2 = 19
            goto L_0x001a
        L_0x008c:
            char r4 = r9.charAt(r2)
            if (r4 != r6) goto L_0x000e
            r2 = 20
            goto L_0x001a
        L_0x0095:
            char r4 = r9.charAt(r2)
            if (r4 != r6) goto L_0x000e
            r2 = 21
            goto L_0x001a
        L_0x009f:
            char r4 = r9.charAt(r2)
            if (r4 != r6) goto L_0x000e
            r2 = r0
            goto L_0x001a
        L_0x00a8:
            char r4 = r9.charAt(r2)
            if (r4 != r6) goto L_0x000e
            r2 = 10
            goto L_0x001a
        L_0x00b2:
            java.lang.String r3 = "input"
            r4 = 3
            r7 = r3
            r3 = r4
            r4 = r7
            goto L_0x0010
        L_0x00ba:
            char r5 = r9.charAt(r0)
            r6 = 77
            if (r5 != r6) goto L_0x00c8
            java.lang.String r3 = "lastMatch"
            r4 = r3
            r3 = r1
            goto L_0x0010
        L_0x00c8:
            r6 = 80
            if (r5 != r6) goto L_0x00d4
            java.lang.String r3 = "lastParen"
            r4 = 7
            r7 = r3
            r3 = r4
            r4 = r7
            goto L_0x0010
        L_0x00d4:
            r6 = 105(0x69, float:1.47E-43)
            if (r5 != r6) goto L_0x000e
            java.lang.String r3 = "multiline"
            r7 = r3
            r3 = r4
            r4 = r7
            goto L_0x0010
        L_0x00df:
            java.lang.String r3 = "leftContext"
            r4 = 9
            r7 = r3
            r3 = r4
            r4 = r7
            goto L_0x0010
        L_0x00e8:
            java.lang.String r3 = "rightContext"
            r4 = 11
            r7 = r3
            r3 = r4
            r4 = r7
            goto L_0x0010
        L_0x00f1:
            switch(r2) {
                case 1: goto L_0x00f5;
                case 2: goto L_0x00f5;
                case 3: goto L_0x00f5;
                case 4: goto L_0x00f5;
                default: goto L_0x00f4;
            }
        L_0x00f4:
            r0 = r1
        L_0x00f5:
            int r1 = super.getMaxInstanceId()
            int r1 = r1 + r2
            int r0 = instanceIdInfo(r0, r1)
            goto L_0x0020
        L_0x0100:
            r2 = r3
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.NativeRegExpCtor.findInstanceIdInfo(java.lang.String):int");
    }

    /* access modifiers changed from: protected */
    public String getInstanceIdName(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        if (maxInstanceId <= 0 || maxInstanceId > 21) {
            return super.getInstanceIdName(i);
        }
        switch (maxInstanceId) {
            case 1:
                return "multiline";
            case 2:
                return "$*";
            case 3:
                return "input";
            case 4:
                return "$_";
            case 5:
                return "lastMatch";
            case 6:
                return "$&";
            case 7:
                return "lastParen";
            case 8:
                return "$+";
            case 9:
                return "leftContext";
            case 10:
                return "$`";
            case 11:
                return "rightContext";
            case 12:
                return "$'";
            default:
                return new String(new char[]{CoreConstants.DOLLAR, (char) (((maxInstanceId - 12) - 1) + 49)});
        }
    }

    /* access modifiers changed from: protected */
    public Object getInstanceIdValue(int i) {
        Object obj;
        int maxInstanceId = i - super.getMaxInstanceId();
        if (maxInstanceId <= 0 || maxInstanceId > 21) {
            return super.getInstanceIdValue(i);
        }
        RegExpImpl impl = getImpl();
        switch (maxInstanceId) {
            case 1:
            case 2:
                return ScriptRuntime.m6312a(impl.multiline);
            case 3:
            case 4:
                obj = impl.input;
                break;
            case 5:
            case 6:
                obj = impl.lastMatch;
                break;
            case 7:
            case 8:
                obj = impl.lastParen;
                break;
            case 9:
            case 10:
                obj = impl.leftContext;
                break;
            case 11:
            case 12:
                obj = impl.rightContext;
                break;
            default:
                obj = impl.getParenSubString((maxInstanceId - 12) - 1);
                break;
        }
        return obj == null ? "" : obj.toString();
    }

    /* access modifiers changed from: protected */
    public void setInstanceIdValue(int i, Object obj) {
        int maxInstanceId = i - super.getMaxInstanceId();
        switch (maxInstanceId) {
            case 1:
            case 2:
                getImpl().multiline = ScriptRuntime.m6391a(obj);
                return;
            case 3:
            case 4:
                getImpl().input = ScriptRuntime.m6436d(obj);
                return;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return;
            default:
                int i2 = (maxInstanceId - 12) - 1;
                if (i2 < 0 || i2 > 8) {
                    super.setInstanceIdValue(i, obj);
                    return;
                }
                return;
        }
    }
}
