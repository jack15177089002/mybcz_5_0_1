package org.mozilla.javascript;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.cb */
public class NativeObject extends IdScriptableObject implements Map {

    /* renamed from: a */
    private static final Object f6362a = "Object";

    /* renamed from: a */
    static void m6098a(Scriptable drVar) {
        new NativeObject().exportAsJSClass(12, drVar, false);
    }

    public String getClassName() {
        return "Object";
    }

    public String toString() {
        return ScriptRuntime.m6404b((Scriptable) this);
    }

    /* access modifiers changed from: protected */
    public void fillConstructorProperties(IdFunctionObject ahVar) {
        addIdFunctionProperty(ahVar, f6362a, -1, "getPrototypeOf", 1);
        addIdFunctionProperty(ahVar, f6362a, -2, "keys", 1);
        addIdFunctionProperty(ahVar, f6362a, -3, "getOwnPropertyNames", 1);
        addIdFunctionProperty(ahVar, f6362a, -4, "getOwnPropertyDescriptor", 2);
        addIdFunctionProperty(ahVar, f6362a, -5, "defineProperty", 3);
        addIdFunctionProperty(ahVar, f6362a, -6, "isExtensible", 1);
        addIdFunctionProperty(ahVar, f6362a, -7, "preventExtensions", 1);
        addIdFunctionProperty(ahVar, f6362a, -8, "defineProperties", 2);
        addIdFunctionProperty(ahVar, f6362a, -9, "create", 2);
        addIdFunctionProperty(ahVar, f6362a, -10, "isSealed", 1);
        addIdFunctionProperty(ahVar, f6362a, -11, "isFrozen", 1);
        addIdFunctionProperty(ahVar, f6362a, -12, "seal", 1);
        addIdFunctionProperty(ahVar, f6362a, -13, "freeze", 1);
        super.fillConstructorProperties(ahVar);
    }

    /* access modifiers changed from: protected */
    public void initPrototypeId(int i) {
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
                str = "toLocaleString";
                i2 = 0;
                break;
            case 4:
                str = CoreConstants.VALUE_OF;
                i2 = 0;
                break;
            case 5:
                str = "hasOwnProperty";
                break;
            case 6:
                str = "propertyIsEnumerable";
                break;
            case 7:
                str = "isPrototypeOf";
                break;
            case 8:
                str = "toSource";
                i2 = 0;
                break;
            case 9:
                str = "__defineGetter__";
                i2 = 2;
                break;
            case 10:
                str = "__defineSetter__";
                i2 = 2;
                break;
            case 11:
                str = "__lookupGetter__";
                break;
            case 12:
                str = "__lookupSetter__";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(f6362a, i, str, i2);
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [int] */
    /* JADX WARNING: type inference failed for: r1v2, types: [int] */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4, types: [int] */
    /* JADX WARNING: type inference failed for: r1v15, types: [int] */
    /* JADX WARNING: type inference failed for: r1v16, types: [int] */
    /* JADX WARNING: type inference failed for: r1v17, types: [int] */
    /* JADX WARNING: type inference failed for: r1v18, types: [int] */
    /* JADX WARNING: type inference failed for: r2v18, types: [boolean] */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r2v21, types: [boolean] */
    /* JADX WARNING: type inference failed for: r1v22, types: [boolean] */
    /* JADX WARNING: type inference failed for: r1v23 */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* JADX WARNING: type inference failed for: r2v25 */
    /* JADX WARNING: type inference failed for: r1v24 */
    /* JADX WARNING: type inference failed for: r1v25, types: [boolean] */
    /* JADX WARNING: type inference failed for: r0v144 */
    /* JADX WARNING: type inference failed for: r1v26 */
    /* JADX WARNING: type inference failed for: r0v145, types: [boolean] */
    /* JADX WARNING: type inference failed for: r0v148, types: [boolean] */
    /* JADX WARNING: type inference failed for: r1v27 */
    /* JADX WARNING: type inference failed for: r1v33 */
    /* JADX WARNING: type inference failed for: r1v34 */
    /* JADX WARNING: type inference failed for: r1v35 */
    /* JADX WARNING: type inference failed for: r1v36 */
    /* JADX WARNING: type inference failed for: r1v37 */
    /* JADX WARNING: type inference failed for: r1v38 */
    /* JADX WARNING: type inference failed for: r1v39 */
    /* JADX WARNING: type inference failed for: r1v40 */
    /* JADX INFO: used method not loaded: org.mozilla.javascript.ds.getAttributes(java.lang.String):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00cc, code lost:
        if ((((org.mozilla.javascript.ScriptableObject) r13).getAttributes(r3) & 2) == 0) goto L_0x00ce;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v23
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], int]
  uses: [boolean, ?[int, byte, short, char], ?[int, short, byte, char], int]
  mth insns count: 408
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
    /* JADX WARNING: Unknown variable types count: 11 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Object execIdCall(org.mozilla.javascript.IdFunctionObject r10, Context r11, Scriptable r12, Scriptable r13, Object[] r14) {
        /*
            r9 = this;
            r3 = 2
            r2 = 1
            r1 = 0
            java.lang.Object r0 = f6362a
            boolean r0 = r10.mo18643a(r0)
            if (r0 != 0) goto L_0x0010
            java.lang.Object r0 = super.execIdCall(r10, r11, r12, r13, r14)
        L_0x000f:
            return r0
        L_0x0010:
            int r4 = r10.f5994a
            switch(r4) {
                case -13: goto L_0x0383;
                case -12: goto L_0x0349;
                case -11: goto L_0x02f5;
                case -10: goto L_0x02b9;
                case -9: goto L_0x027d;
                case -8: goto L_0x0257;
                case -7: goto L_0x0246;
                case -6: goto L_0x0230;
                case -5: goto L_0x0209;
                case -4: goto L_0x01e7;
                case -3: goto L_0x01c3;
                case -2: goto L_0x019f;
                case -1: goto L_0x018d;
                case 0: goto L_0x0015;
                case 1: goto L_0x001f;
                case 2: goto L_0x0040;
                case 3: goto L_0x0040;
                case 4: goto L_0x006f;
                case 5: goto L_0x0071;
                case 6: goto L_0x0090;
                case 7: goto L_0x00d2;
                case 8: goto L_0x00ef;
                case 9: goto L_0x00f5;
                case 10: goto L_0x00f5;
                case 11: goto L_0x014e;
                case 12: goto L_0x014e;
                default: goto L_0x0015;
            }
        L_0x0015:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = java.lang.String.valueOf(r4)
            r0.<init>(r1)
            throw r0
        L_0x001f:
            if (r13 == 0) goto L_0x0026
            org.mozilla.javascript.dr r0 = r10.construct(r11, r12, r14)
            goto L_0x000f
        L_0x0026:
            int r0 = r14.length
            if (r0 == 0) goto L_0x0033
            r0 = r14[r1]
            if (r0 == 0) goto L_0x0033
            r0 = r14[r1]
            java.lang.Object r2 = org.mozilla.javascript.Undefined.f6689a
            if (r0 != r2) goto L_0x0039
        L_0x0033:
            org.mozilla.javascript.cb r0 = new org.mozilla.javascript.cb
            r0.<init>()
            goto L_0x000f
        L_0x0039:
            r0 = r14[r1]
            org.mozilla.javascript.dr r0 = org.mozilla.javascript.ScriptRuntime.m6410b(r11, r12, r0)
            goto L_0x000f
        L_0x0040:
            r0 = 4
            boolean r0 = r11.mo19138b(r0)
            if (r0 == 0) goto L_0x006a
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.m6355a(r11, r12, r13)
            int r3 = r0.length()
            if (r3 == 0) goto L_0x000f
            char r1 = r0.charAt(r1)
            r4 = 40
            if (r1 != r4) goto L_0x000f
            int r1 = r3 + -1
            char r1 = r0.charAt(r1)
            r4 = 41
            if (r1 != r4) goto L_0x000f
            int r1 = r3 + -1
            java.lang.String r0 = r0.substring(r2, r1)
            goto L_0x000f
        L_0x006a:
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.m6404b(r13)
            goto L_0x000f
        L_0x006f:
            r0 = r13
            goto L_0x000f
        L_0x0071:
            int r0 = r14.length
            if (r0 != 0) goto L_0x007a
            r0 = r1
        L_0x0075:
            java.lang.Boolean r0 = org.mozilla.javascript.ScriptRuntime.m6312a(r0)
            goto L_0x000f
        L_0x007a:
            r0 = r14[r1]
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.m6406b(r11, r0)
            if (r0 != 0) goto L_0x008b
            int r0 = org.mozilla.javascript.ScriptRuntime.m6468l(r11)
            boolean r0 = r13.has(r0, r13)
            goto L_0x0075
        L_0x008b:
            boolean r0 = r13.has(r0, r13)
            goto L_0x0075
        L_0x0090:
            int r0 = r14.length
            if (r0 == 0) goto L_0x00d0
            r0 = r14[r1]
            java.lang.String r3 = org.mozilla.javascript.ScriptRuntime.m6406b(r11, r0)
            if (r3 != 0) goto L_0x00ba
            int r3 = org.mozilla.javascript.ScriptRuntime.m6468l(r11)
            boolean r0 = r13.has(r3, r13)
            if (r0 == 0) goto L_0x03d8
            boolean r4 = r13 instanceof org.mozilla.javascript.ScriptableObject
            if (r4 == 0) goto L_0x03d8
            org.mozilla.javascript.ds r13 = (org.mozilla.javascript.ScriptableObject) r13
            int r0 = r13.getAttributes(r3)
            r0 = r0 & 2
            if (r0 != 0) goto L_0x00b4
            r1 = r2
        L_0x00b4:
            java.lang.Boolean r0 = org.mozilla.javascript.ScriptRuntime.m6312a(r1)
            goto L_0x000f
        L_0x00ba:
            boolean r0 = r13.has(r3, r13)
            if (r0 == 0) goto L_0x03d8
            boolean r4 = r13 instanceof org.mozilla.javascript.ScriptableObject
            if (r4 == 0) goto L_0x03d8
            org.mozilla.javascript.ds r13 = (org.mozilla.javascript.ScriptableObject) r13
            int r0 = r13.getAttributes(r3)
            r0 = r0 & 2
            if (r0 != 0) goto L_0x00d0
        L_0x00ce:
            r1 = r2
            goto L_0x00b4
        L_0x00d0:
            r2 = r1
            goto L_0x00ce
        L_0x00d2:
            int r0 = r14.length
            if (r0 == 0) goto L_0x00e6
            r0 = r14[r1]
            boolean r0 = r0 instanceof org.mozilla.javascript.Scriptable
            if (r0 == 0) goto L_0x00e6
            r0 = r14[r1]
            org.mozilla.javascript.dr r0 = (org.mozilla.javascript.Scriptable) r0
        L_0x00df:
            org.mozilla.javascript.dr r0 = r0.getPrototype()
            if (r0 != r13) goto L_0x00ec
            r1 = r2
        L_0x00e6:
            java.lang.Boolean r0 = org.mozilla.javascript.ScriptRuntime.m6312a(r1)
            goto L_0x000f
        L_0x00ec:
            if (r0 != 0) goto L_0x00df
            goto L_0x00e6
        L_0x00ef:
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.m6355a(r11, r12, r13)
            goto L_0x000f
        L_0x00f5:
            int r0 = r14.length
            if (r0 < r3) goto L_0x00fe
            r0 = r14[r2]
            boolean r0 = r0 instanceof org.mozilla.javascript.Callable
            if (r0 != 0) goto L_0x010b
        L_0x00fe:
            int r0 = r14.length
            if (r0 < r3) goto L_0x0108
            r0 = r14[r2]
        L_0x0103:
            java.lang.RuntimeException r0 = org.mozilla.javascript.ScriptRuntime.m6474o(r0)
            throw r0
        L_0x0108:
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
            goto L_0x0103
        L_0x010b:
            boolean r0 = r13 instanceof org.mozilla.javascript.ScriptableObject
            if (r0 != 0) goto L_0x0124
            java.lang.String r0 = "msg.extend.scriptable"
            java.lang.Class r2 = r13.getClass()
            java.lang.String r2 = r2.getName()
            r1 = r14[r1]
            java.lang.String r1 = java.lang.String.valueOf(r1)
            org.mozilla.javascript.z r0 = org.mozilla.javascript.Context.m6756a(r0, r2, r1)
            throw r0
        L_0x0124:
            org.mozilla.javascript.ds r13 = (org.mozilla.javascript.ScriptableObject) r13
            r0 = r14[r1]
            java.lang.String r5 = org.mozilla.javascript.ScriptRuntime.m6406b(r11, r0)
            if (r5 == 0) goto L_0x0146
            r3 = r1
        L_0x012f:
            r0 = r14[r2]
            org.mozilla.javascript.e r0 = (org.mozilla.javascript.Callable) r0
            r6 = 10
            if (r4 != r6) goto L_0x014c
        L_0x0137:
            r13.setGetterOrSetter(r5, r3, r0, r2)
            boolean r0 = r13 instanceof org.mozilla.javascript.NativeArray
            if (r0 == 0) goto L_0x0142
            org.mozilla.javascript.bc r13 = (org.mozilla.javascript.NativeArray) r13
            r13.f6286b = r1
        L_0x0142:
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
            goto L_0x000f
        L_0x0146:
            int r0 = org.mozilla.javascript.ScriptRuntime.m6468l(r11)
            r3 = r0
            goto L_0x012f
        L_0x014c:
            r2 = r1
            goto L_0x0137
        L_0x014e:
            int r0 = r14.length
            if (r0 <= 0) goto L_0x0155
            boolean r0 = r13 instanceof org.mozilla.javascript.ScriptableObject
            if (r0 != 0) goto L_0x0159
        L_0x0155:
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
            goto L_0x000f
        L_0x0159:
            org.mozilla.javascript.ds r13 = (org.mozilla.javascript.ScriptableObject) r13
            r0 = r14[r1]
            java.lang.String r5 = org.mozilla.javascript.ScriptRuntime.m6406b(r11, r0)
            if (r5 == 0) goto L_0x017c
            r3 = r1
        L_0x0164:
            r0 = 12
            if (r4 != r0) goto L_0x0182
        L_0x0168:
            java.lang.Object r1 = r13.getGetterOrSetter(r5, r3, r2)
            if (r1 != 0) goto L_0x0184
            org.mozilla.javascript.dr r0 = r13.getPrototype()
            if (r0 == 0) goto L_0x0184
            boolean r4 = r0 instanceof org.mozilla.javascript.ScriptableObject
            if (r4 == 0) goto L_0x0184
            org.mozilla.javascript.ds r0 = (org.mozilla.javascript.ScriptableObject) r0
            r13 = r0
            goto L_0x0168
        L_0x017c:
            int r0 = org.mozilla.javascript.ScriptRuntime.m6468l(r11)
            r3 = r0
            goto L_0x0164
        L_0x0182:
            r2 = r1
            goto L_0x0168
        L_0x0184:
            if (r1 == 0) goto L_0x0189
            r0 = r1
            goto L_0x000f
        L_0x0189:
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
            goto L_0x000f
        L_0x018d:
            int r0 = r14.length
            if (r0 > 0) goto L_0x019c
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x0192:
            org.mozilla.javascript.dr r0 = ensureScriptable(r0)
            org.mozilla.javascript.dr r0 = r0.getPrototype()
            goto L_0x000f
        L_0x019c:
            r0 = r14[r1]
            goto L_0x0192
        L_0x019f:
            int r0 = r14.length
            if (r0 > 0) goto L_0x01ba
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x01a4:
            org.mozilla.javascript.dr r0 = ensureScriptable(r0)
            java.lang.Object[] r0 = r0.getIds()
        L_0x01ac:
            int r2 = r0.length
            if (r1 >= r2) goto L_0x01bd
            r2 = r0[r1]
            java.lang.String r2 = org.mozilla.javascript.ScriptRuntime.m6436d(r2)
            r0[r1] = r2
            int r1 = r1 + 1
            goto L_0x01ac
        L_0x01ba:
            r0 = r14[r1]
            goto L_0x01a4
        L_0x01bd:
            org.mozilla.javascript.dr r0 = org.mozilla.javascript.Context.m6752a(r12, r0)
            goto L_0x000f
        L_0x01c3:
            int r0 = r14.length
            if (r0 > 0) goto L_0x01de
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x01c8:
            org.mozilla.javascript.ds r0 = ensureScriptableObject(r0)
            java.lang.Object[] r0 = r0.getAllIds()
        L_0x01d0:
            int r2 = r0.length
            if (r1 >= r2) goto L_0x01e1
            r2 = r0[r1]
            java.lang.String r2 = org.mozilla.javascript.ScriptRuntime.m6436d(r2)
            r0[r1] = r2
            int r1 = r1 + 1
            goto L_0x01d0
        L_0x01de:
            r0 = r14[r1]
            goto L_0x01c8
        L_0x01e1:
            org.mozilla.javascript.dr r0 = org.mozilla.javascript.Context.m6752a(r12, r0)
            goto L_0x000f
        L_0x01e7:
            int r0 = r14.length
            if (r0 > 0) goto L_0x0203
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x01ec:
            org.mozilla.javascript.ds r1 = ensureScriptableObject(r0)
            int r0 = r14.length
            if (r0 >= r3) goto L_0x0206
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x01f5:
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.m6436d(r0)
            org.mozilla.javascript.ds r0 = r1.getOwnPropertyDescriptor(r11, r0)
            if (r0 != 0) goto L_0x000f
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
            goto L_0x000f
        L_0x0203:
            r0 = r14[r1]
            goto L_0x01ec
        L_0x0206:
            r0 = r14[r2]
            goto L_0x01f5
        L_0x0209:
            int r0 = r14.length
            if (r0 > 0) goto L_0x0227
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x020e:
            org.mozilla.javascript.ds r13 = ensureScriptableObject(r0)
            int r0 = r14.length
            if (r0 >= r3) goto L_0x022a
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x0217:
            int r1 = r14.length
            r2 = 3
            if (r1 >= r2) goto L_0x022d
            java.lang.Object r1 = org.mozilla.javascript.Undefined.f6689a
        L_0x021d:
            org.mozilla.javascript.ds r1 = ensureScriptableObject(r1)
            r13.defineOwnProperty(r11, r0, r1)
            r0 = r13
            goto L_0x000f
        L_0x0227:
            r0 = r14[r1]
            goto L_0x020e
        L_0x022a:
            r0 = r14[r2]
            goto L_0x0217
        L_0x022d:
            r1 = r14[r3]
            goto L_0x021d
        L_0x0230:
            int r0 = r14.length
            if (r0 > 0) goto L_0x0243
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x0235:
            org.mozilla.javascript.ds r0 = ensureScriptableObject(r0)
            boolean r0 = r0.isExtensible()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x000f
        L_0x0243:
            r0 = r14[r1]
            goto L_0x0235
        L_0x0246:
            int r0 = r14.length
            if (r0 > 0) goto L_0x0254
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x024b:
            org.mozilla.javascript.ds r0 = ensureScriptableObject(r0)
            r0.preventExtensions()
            goto L_0x000f
        L_0x0254:
            r0 = r14[r1]
            goto L_0x024b
        L_0x0257:
            int r0 = r14.length
            if (r0 > 0) goto L_0x0277
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x025c:
            org.mozilla.javascript.ds r13 = ensureScriptableObject(r0)
            int r0 = r14.length
            if (r0 >= r3) goto L_0x027a
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x0265:
            org.mozilla.javascript.dr r1 = r9.getParentScope()
            org.mozilla.javascript.dr r0 = org.mozilla.javascript.Context.m6749a(r0, r1)
            org.mozilla.javascript.ds r0 = ensureScriptableObject(r0)
            r13.defineOwnProperties(r11, r0)
            r0 = r13
            goto L_0x000f
        L_0x0277:
            r0 = r14[r1]
            goto L_0x025c
        L_0x027a:
            r0 = r14[r2]
            goto L_0x0265
        L_0x027d:
            int r0 = r14.length
            if (r0 > 0) goto L_0x02b1
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x0282:
            if (r0 != 0) goto L_0x02b4
            r0 = 0
        L_0x0285:
            org.mozilla.javascript.cb r13 = new org.mozilla.javascript.cb
            r13.<init>()
            org.mozilla.javascript.dr r1 = r9.getParentScope()
            r13.setParentScope(r1)
            r13.setPrototype(r0)
            int r0 = r14.length
            if (r0 <= r2) goto L_0x02ae
            r0 = r14[r2]
            java.lang.Object r1 = org.mozilla.javascript.Undefined.f6689a
            if (r0 == r1) goto L_0x02ae
            r0 = r14[r2]
            org.mozilla.javascript.dr r1 = r9.getParentScope()
            org.mozilla.javascript.dr r0 = org.mozilla.javascript.Context.m6749a(r0, r1)
            org.mozilla.javascript.ds r0 = ensureScriptableObject(r0)
            r13.defineOwnProperties(r11, r0)
        L_0x02ae:
            r0 = r13
            goto L_0x000f
        L_0x02b1:
            r0 = r14[r1]
            goto L_0x0282
        L_0x02b4:
            org.mozilla.javascript.dr r0 = ensureScriptable(r0)
            goto L_0x0285
        L_0x02b9:
            int r0 = r14.length
            if (r0 > 0) goto L_0x02cc
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x02be:
            org.mozilla.javascript.ds r0 = ensureScriptableObject(r0)
            boolean r2 = r0.isExtensible()
            if (r2 == 0) goto L_0x02cf
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x000f
        L_0x02cc:
            r0 = r14[r1]
            goto L_0x02be
        L_0x02cf:
            java.lang.Object[] r2 = r0.getAllIds()
            int r3 = r2.length
        L_0x02d4:
            if (r1 >= r3) goto L_0x02f1
            r4 = r2[r1]
            org.mozilla.javascript.ds r4 = r0.getOwnPropertyDescriptor(r11, r4)
            java.lang.String r5 = "configurable"
            java.lang.Object r4 = r4.get(r5)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x02ee
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x000f
        L_0x02ee:
            int r1 = r1 + 1
            goto L_0x02d4
        L_0x02f1:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            goto L_0x000f
        L_0x02f5:
            int r0 = r14.length
            if (r0 > 0) goto L_0x0308
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x02fa:
            org.mozilla.javascript.ds r0 = ensureScriptableObject(r0)
            boolean r2 = r0.isExtensible()
            if (r2 == 0) goto L_0x030b
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x000f
        L_0x0308:
            r0 = r14[r1]
            goto L_0x02fa
        L_0x030b:
            java.lang.Object[] r2 = r0.getAllIds()
            int r3 = r2.length
        L_0x0310:
            if (r1 >= r3) goto L_0x0345
            r4 = r2[r1]
            org.mozilla.javascript.ds r4 = r0.getOwnPropertyDescriptor(r11, r4)
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            java.lang.String r6 = "configurable"
            java.lang.Object r6 = r4.get(r6)
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x032a
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x000f
        L_0x032a:
            boolean r5 = r9.isDataDescriptor(r4)
            if (r5 == 0) goto L_0x0342
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            java.lang.String r6 = "writable"
            java.lang.Object r4 = r4.get(r6)
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0342
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x000f
        L_0x0342:
            int r1 = r1 + 1
            goto L_0x0310
        L_0x0345:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            goto L_0x000f
        L_0x0349:
            int r0 = r14.length
            if (r0 > 0) goto L_0x037b
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x034e:
            org.mozilla.javascript.ds r0 = ensureScriptableObject(r0)
            java.lang.Object[] r3 = r0.getAllIds()
            int r4 = r3.length
            r2 = r1
        L_0x0358:
            if (r2 >= r4) goto L_0x037e
            r5 = r3[r2]
            org.mozilla.javascript.ds r6 = r0.getOwnPropertyDescriptor(r11, r5)
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.String r8 = "configurable"
            java.lang.Object r8 = r6.get(r8)
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0378
            java.lang.String r7 = "configurable"
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            r6.put(r7, r6, r8)
            r0.defineOwnProperty(r11, r5, r6, r1)
        L_0x0378:
            int r2 = r2 + 1
            goto L_0x0358
        L_0x037b:
            r0 = r14[r1]
            goto L_0x034e
        L_0x037e:
            r0.preventExtensions()
            goto L_0x000f
        L_0x0383:
            int r0 = r14.length
            if (r0 > 0) goto L_0x03d0
            java.lang.Object r0 = org.mozilla.javascript.Undefined.f6689a
        L_0x0388:
            org.mozilla.javascript.ds r0 = ensureScriptableObject(r0)
            java.lang.Object[] r3 = r0.getAllIds()
            int r4 = r3.length
            r2 = r1
        L_0x0392:
            if (r2 >= r4) goto L_0x03d3
            r5 = r3[r2]
            org.mozilla.javascript.ds r6 = r0.getOwnPropertyDescriptor(r11, r5)
            boolean r7 = r9.isDataDescriptor(r6)
            if (r7 == 0) goto L_0x03b5
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.String r8 = "writable"
            java.lang.Object r8 = r6.get(r8)
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x03b5
            java.lang.String r7 = "writable"
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            r6.put(r7, r6, r8)
        L_0x03b5:
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.String r8 = "configurable"
            java.lang.Object r8 = r6.get(r8)
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x03ca
            java.lang.String r7 = "configurable"
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            r6.put(r7, r6, r8)
        L_0x03ca:
            r0.defineOwnProperty(r11, r5, r6, r1)
            int r2 = r2 + 1
            goto L_0x0392
        L_0x03d0:
            r0 = r14[r1]
            goto L_0x0388
        L_0x03d3:
            r0.preventExtensions()
            goto L_0x000f
        L_0x03d8:
            r1 = r0
            goto L_0x00b4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeObject.execIdCall(org.mozilla.javascript.ah, org.mozilla.javascript.l, org.mozilla.javascript.dr, org.mozilla.javascript.dr, java.lang.Object[]):java.lang.Object");
    }

    public boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return has((String) obj, this);
        }
        if (obj instanceof Number) {
            return has(((Number) obj).intValue(), (Scriptable) this);
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        for (Object next : values()) {
            if (obj == next || (obj != null && obj.equals(next))) {
                return true;
            }
        }
        return false;
    }

    public Object remove(Object obj) {
        Object obj2 = get(obj);
        if (obj instanceof String) {
            delete((String) obj);
        } else if (obj instanceof Number) {
            delete(((Number) obj).intValue());
        }
        return obj2;
    }

    public Set<Object> keySet() {
        return new C2157cf(this);
    }

    public Collection<Object> values() {
        return new C2159ch(this);
    }

    public Set<Entry<Object, Object>> entrySet() {
        return new C2154cc(this);
    }

    public Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findPrototypeId(String r9) {
        /*
            r8 = this;
            r6 = 71
            r4 = 3
            r3 = 2
            r2 = 8
            r0 = 0
            r1 = 0
            int r5 = r9.length()
            switch(r5) {
                case 7: goto L_0x001c;
                case 8: goto L_0x0023;
                case 9: goto L_0x000f;
                case 10: goto L_0x000f;
                case 11: goto L_0x003a;
                case 12: goto L_0x000f;
                case 13: goto L_0x0041;
                case 14: goto L_0x0048;
                case 15: goto L_0x000f;
                case 16: goto L_0x0060;
                case 17: goto L_0x000f;
                case 18: goto L_0x000f;
                case 19: goto L_0x000f;
                case 20: goto L_0x00a2;
                default: goto L_0x000f;
            }
        L_0x000f:
            r2 = r1
            r1 = r0
        L_0x0011:
            if (r2 == 0) goto L_0x00aa
            if (r2 == r9) goto L_0x00aa
            boolean r2 = r2.equals(r9)
            if (r2 != 0) goto L_0x00aa
        L_0x001b:
            return r0
        L_0x001c:
            java.lang.String r1 = "valueOf"
            r2 = 4
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0011
        L_0x0023:
            char r4 = r9.charAt(r4)
            r5 = 111(0x6f, float:1.56E-43)
            if (r4 != r5) goto L_0x0031
            java.lang.String r1 = "toSource"
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0011
        L_0x0031:
            r2 = 116(0x74, float:1.63E-43)
            if (r4 != r2) goto L_0x000f
            java.lang.String r1 = "toString"
            r2 = r1
            r1 = r3
            goto L_0x0011
        L_0x003a:
            java.lang.String r1 = "constructor"
            r2 = 1
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0011
        L_0x0041:
            java.lang.String r1 = "isPrototypeOf"
            r2 = 7
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0011
        L_0x0048:
            char r2 = r9.charAt(r0)
            r3 = 104(0x68, float:1.46E-43)
            if (r2 != r3) goto L_0x0057
            java.lang.String r1 = "hasOwnProperty"
            r2 = 5
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0011
        L_0x0057:
            r3 = 116(0x74, float:1.63E-43)
            if (r2 != r3) goto L_0x000f
            java.lang.String r1 = "toLocaleString"
            r2 = r1
            r1 = r4
            goto L_0x0011
        L_0x0060:
            char r3 = r9.charAt(r3)
            r4 = 100
            if (r3 != r4) goto L_0x0082
            char r2 = r9.charAt(r2)
            if (r2 != r6) goto L_0x0076
            java.lang.String r1 = "__defineGetter__"
            r2 = 9
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0011
        L_0x0076:
            r3 = 83
            if (r2 != r3) goto L_0x000f
            java.lang.String r1 = "__defineSetter__"
            r2 = 10
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0011
        L_0x0082:
            r4 = 108(0x6c, float:1.51E-43)
            if (r3 != r4) goto L_0x000f
            char r2 = r9.charAt(r2)
            if (r2 != r6) goto L_0x0095
            java.lang.String r1 = "__lookupGetter__"
            r2 = 11
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0011
        L_0x0095:
            r3 = 83
            if (r2 != r3) goto L_0x000f
            java.lang.String r1 = "__lookupSetter__"
            r2 = 12
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0011
        L_0x00a2:
            java.lang.String r1 = "propertyIsEnumerable"
            r2 = 6
            r7 = r1
            r1 = r2
            r2 = r7
            goto L_0x0011
        L_0x00aa:
            r0 = r1
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeObject.findPrototypeId(java.lang.String):int");
    }
}
