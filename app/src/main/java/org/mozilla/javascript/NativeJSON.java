package org.mozilla.javascript;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import org.mozilla.javascript.p112d.C2169b;
import org.mozilla.javascript.p112d.JsonParser;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.bs */
public final class NativeJSON extends IdScriptableObject {

    /* renamed from: a */
    private static final Object f6329a = "JSON";

    /* renamed from: a */
    static void m6072a(Scriptable drVar) {
        NativeJSON bsVar = new NativeJSON();
        bsVar.activatePrototypeMap(3);
        bsVar.setPrototype(getObjectPrototype(drVar));
        bsVar.setParentScope(drVar);
        ScriptableObject.defineProperty(drVar, "JSON", bsVar, 2);
    }

    private NativeJSON() {
    }

    public final String getClassName() {
        return "JSON";
    }

    /* access modifiers changed from: protected */
    public final void initPrototypeId(int i) {
        String str;
        int i2 = 3;
        if (i <= 3) {
            switch (i) {
                case 1:
                    i2 = 0;
                    str = "toSource";
                    break;
                case 2:
                    i2 = 2;
                    str = "parse";
                    break;
                case 3:
                    str = "stringify";
                    break;
                default:
                    throw new IllegalStateException(String.valueOf(i));
            }
            initPrototypeMethod(f6329a, i, str, i2);
            return;
        }
        throw new IllegalStateException(String.valueOf(i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        r3 = r20[1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        r10 = r20[0];
        r14 = r3;
        r3 = r2;
        r2 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r5 = "";
        r6 = "";
        r8 = null;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007a, code lost:
        if ((r2 instanceof org.mozilla.javascript.Callable) == false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007c, code lost:
        r7 = (org.mozilla.javascript.Callable) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0081, code lost:
        if ((r3 instanceof org.mozilla.javascript.NativeNumber) == false) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0083, code lost:
        r3 = java.lang.Double.valueOf(org.mozilla.javascript.ScriptRuntime.m6395b(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008d, code lost:
        if ((r3 instanceof java.lang.Number) == false) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008f, code lost:
        r3 = java.lang.Math.min(10, (int) org.mozilla.javascript.ScriptRuntime.m6440e(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009a, code lost:
        if (r3 <= 0) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009c, code lost:
        r4 = new char[r3];
        java.util.Arrays.fill(r4, ' ');
        r2 = new java.lang.String(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a8, code lost:
        r6 = r2;
        r9 = java.lang.Integer.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ae, code lost:
        r2 = new org.mozilla.javascript.C2152bt(r17, r18, r5, r6, r7, r8, r9);
        r3 = new org.mozilla.javascript.NativeObject();
        r3.setParentScope(r18);
        r3.setPrototype(org.mozilla.javascript.ScriptableObject.getObjectPrototype(r18));
        r3.defineProperty("", r10, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d8, code lost:
        if ((r2 instanceof org.mozilla.javascript.NativeArray) == false) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00da, code lost:
        r8 = new java.util.LinkedList();
        r2 = (org.mozilla.javascript.NativeArray) r2;
        r9 = r2.mo18842b();
        r11 = r9.length;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e7, code lost:
        if (r4 >= r11) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e9, code lost:
        r12 = r2.get(r9[r4].intValue(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f5, code lost:
        if ((r12 instanceof java.lang.String) != false) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f9, code lost:
        if ((r12 instanceof java.lang.Number) == false) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00fb, code lost:
        r8.add(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00fe, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0103, code lost:
        if ((r12 instanceof org.mozilla.javascript.NativeString) != false) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0107, code lost:
        if ((r12 instanceof org.mozilla.javascript.NativeNumber) == false) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0109, code lost:
        r8.add(org.mozilla.javascript.ScriptRuntime.m6436d(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0113, code lost:
        if ((r3 instanceof org.mozilla.javascript.NativeString) == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0115, code lost:
        r3 = org.mozilla.javascript.ScriptRuntime.m6436d(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011b, code lost:
        r2 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if ((r3 instanceof java.lang.String) == false) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0122, code lost:
        r2 = (java.lang.String) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012b, code lost:
        if (r2.length() <= 10) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x012d, code lost:
        r6 = r2.substring(0, 10);
        r9 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0138, code lost:
        r6 = r2;
        r9 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013c, code lost:
        r9 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        return m6066a((java.lang.Object) "", (org.mozilla.javascript.Scriptable) r3, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Object execIdCall(org.mozilla.javascript.IdFunctionObject r16, Context r17, org.mozilla.javascript.Scriptable r18, org.mozilla.javascript.Scriptable r19, Object[] r20) {
        /*
            r15 = this;
            java.lang.Object r2 = f6329a
            r0 = r16
            boolean r2 = r0.mo18643a(r2)
            if (r2 != 0) goto L_0x000f
            java.lang.Object r2 = super.execIdCall(r16, r17, r18, r19, r20)
        L_0x000e:
            return r2
        L_0x000f:
            r0 = r16
            int r2 = r0.f5994a
            switch(r2) {
                case 1: goto L_0x0020;
                case 2: goto L_0x0023;
                case 3: goto L_0x005c;
                default: goto L_0x0016;
            }
        L_0x0016:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r3.<init>(r2)
            throw r3
        L_0x0020:
            java.lang.String r2 = "JSON"
            goto L_0x000e
        L_0x0023:
            java.lang.String r3 = org.mozilla.javascript.ScriptRuntime.m6407b(r20)
            r2 = 0
            r0 = r20
            int r4 = r0.length
            r5 = 1
            if (r4 <= r5) goto L_0x0031
            r2 = 1
            r2 = r20[r2]
        L_0x0031:
            boolean r4 = r2 instanceof org.mozilla.javascript.Callable
            if (r4 == 0) goto L_0x0053
            org.mozilla.javascript.e r2 = (org.mozilla.javascript.Callable) r2
            r0 = r17
            r1 = r18
            java.lang.Object r3 = m6067a(r0, r1, r3)
            org.mozilla.javascript.dr r4 = org.mozilla.javascript.Context.m6750a(r18)
            java.lang.String r5 = ""
            r4.put(r5, r4, r3)
            java.lang.String r3 = ""
            r0 = r17
            r1 = r18
            java.lang.Object r2 = m6068a(r0, r1, r2, r4, r3)
            goto L_0x000e
        L_0x0053:
            r0 = r17
            r1 = r18
            java.lang.Object r2 = m6067a(r0, r1, r3)
            goto L_0x000e
        L_0x005c:
            r4 = 0
            r3 = 0
            r2 = 0
            r0 = r20
            int r5 = r0.length
            switch(r5) {
                case 0: goto L_0x013f;
                case 1: goto L_0x006b;
                case 2: goto L_0x0068;
                default: goto L_0x0065;
            }
        L_0x0065:
            r2 = 2
            r2 = r20[r2]
        L_0x0068:
            r3 = 1
            r3 = r20[r3]
        L_0x006b:
            r4 = 0
            r4 = r20[r4]
            r10 = r4
            r14 = r3
            r3 = r2
            r2 = r14
        L_0x0072:
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            r8 = 0
            r7 = 0
            boolean r4 = r2 instanceof org.mozilla.javascript.Callable
            if (r4 == 0) goto L_0x00d6
            org.mozilla.javascript.e r2 = (org.mozilla.javascript.Callable) r2
            r7 = r2
        L_0x007f:
            boolean r2 = r3 instanceof org.mozilla.javascript.NativeNumber
            if (r2 == 0) goto L_0x0111
            double r2 = org.mozilla.javascript.ScriptRuntime.m6395b(r3)
            java.lang.Double r3 = java.lang.Double.valueOf(r2)
        L_0x008b:
            boolean r2 = r3 instanceof java.lang.Number
            if (r2 == 0) goto L_0x011e
            double r2 = org.mozilla.javascript.ScriptRuntime.m6440e(r3)
            int r2 = (int) r2
            r3 = 10
            int r3 = java.lang.Math.min(r3, r2)
            if (r3 <= 0) goto L_0x011b
            char[] r4 = new char[r3]
            r2 = 32
            java.util.Arrays.fill(r4, r2)
            java.lang.String r2 = new java.lang.String
            r2.<init>(r4)
        L_0x00a8:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r6 = r2
            r9 = r3
        L_0x00ae:
            org.mozilla.javascript.bt r2 = new org.mozilla.javascript.bt
            r3 = r17
            r4 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            org.mozilla.javascript.cb r3 = new org.mozilla.javascript.cb
            r3.<init>()
            r0 = r18
            r3.setParentScope(r0)
            org.mozilla.javascript.dr r4 = org.mozilla.javascript.ScriptableObject.getObjectPrototype(r18)
            r3.setPrototype(r4)
            java.lang.String r4 = ""
            r5 = 0
            r3.defineProperty(r4, r10, r5)
            java.lang.String r4 = ""
            java.lang.Object r2 = m6066a(r4, r3, r2)
            goto L_0x000e
        L_0x00d6:
            boolean r4 = r2 instanceof org.mozilla.javascript.NativeArray
            if (r4 == 0) goto L_0x007f
            java.util.LinkedList r8 = new java.util.LinkedList
            r8.<init>()
            org.mozilla.javascript.bc r2 = (org.mozilla.javascript.NativeArray) r2
            java.lang.Integer[] r9 = r2.mo18842b()
            int r11 = r9.length
            r4 = 0
        L_0x00e7:
            if (r4 >= r11) goto L_0x007f
            r12 = r9[r4]
            int r12 = r12.intValue()
            java.lang.Object r12 = r2.get(r12, r2)
            boolean r13 = r12 instanceof java.lang.String
            if (r13 != 0) goto L_0x00fb
            boolean r13 = r12 instanceof java.lang.Number
            if (r13 == 0) goto L_0x0101
        L_0x00fb:
            r8.add(r12)
        L_0x00fe:
            int r4 = r4 + 1
            goto L_0x00e7
        L_0x0101:
            boolean r13 = r12 instanceof org.mozilla.javascript.NativeString
            if (r13 != 0) goto L_0x0109
            boolean r13 = r12 instanceof org.mozilla.javascript.NativeNumber
            if (r13 == 0) goto L_0x00fe
        L_0x0109:
            java.lang.String r12 = org.mozilla.javascript.ScriptRuntime.m6436d(r12)
            r8.add(r12)
            goto L_0x00fe
        L_0x0111:
            boolean r2 = r3 instanceof org.mozilla.javascript.NativeString
            if (r2 == 0) goto L_0x008b
            java.lang.String r3 = org.mozilla.javascript.ScriptRuntime.m6436d(r3)
            goto L_0x008b
        L_0x011b:
            java.lang.String r2 = ""
            goto L_0x00a8
        L_0x011e:
            boolean r2 = r3 instanceof java.lang.String
            if (r2 == 0) goto L_0x013c
            r2 = r3
            java.lang.String r2 = (java.lang.String) r2
            int r4 = r2.length()
            r6 = 10
            if (r4 <= r6) goto L_0x0138
            r4 = 0
            r6 = 10
            java.lang.String r2 = r2.substring(r4, r6)
            r6 = r2
            r9 = r3
            goto L_0x00ae
        L_0x0138:
            r6 = r2
            r9 = r3
            goto L_0x00ae
        L_0x013c:
            r9 = r3
            goto L_0x00ae
        L_0x013f:
            r10 = r4
            r14 = r3
            r3 = r2
            r2 = r14
            goto L_0x0072
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeJSON.execIdCall(org.mozilla.javascript.ah, org.mozilla.javascript.l, org.mozilla.javascript.dr, org.mozilla.javascript.dr, java.lang.Object[]):java.lang.Object");
    }

    /* renamed from: a */
    private static Object m6067a(Context lVar, Scriptable drVar, String str) {
        try {
            return new JsonParser(lVar, drVar).mo18996a(str);
        } catch (C2169b e) {
            throw ScriptRuntime.m6375a("SyntaxError", e.getMessage());
        }
    }

    /* renamed from: a */
    private static Object m6068a(Context lVar, Scriptable drVar, Callable eVar, Scriptable drVar2, Object obj) {
        Object obj2;
        Object[] ids;
        if (obj instanceof Number) {
            obj2 = drVar2.get(((Number) obj).intValue(), drVar2);
        } else {
            obj2 = drVar2.get((String) obj, drVar2);
        }
        if (obj2 instanceof Scriptable) {
            Scriptable drVar3 = (Scriptable) obj2;
            if (drVar3 instanceof NativeArray) {
                int i = (int) ((NativeArray) drVar3).f6285a;
                for (int i2 = 0; i2 < i; i2++) {
                    Object a = m6068a(lVar, drVar, eVar, drVar3, Integer.valueOf(i2));
                    if (a == Undefined.f6689a) {
                        drVar3.delete(i2);
                    } else {
                        drVar3.put(i2, drVar3, a);
                    }
                }
            } else {
                for (Object obj3 : drVar3.getIds()) {
                    Object a2 = m6068a(lVar, drVar, eVar, drVar3, obj3);
                    if (a2 == Undefined.f6689a) {
                        if (obj3 instanceof Number) {
                            drVar3.delete(((Number) obj3).intValue());
                        } else {
                            drVar3.delete((String) obj3);
                        }
                    } else if (obj3 instanceof Number) {
                        drVar3.put(((Number) obj3).intValue(), drVar3, a2);
                    } else {
                        drVar3.put((String) obj3, drVar3, a2);
                    }
                }
            }
        }
        return eVar.call(lVar, drVar, drVar2, new Object[]{obj, obj2});
    }

    /* renamed from: a */
    private static Object m6066a(Object obj, Scriptable drVar, C2152bt btVar) {
        Object property;
        Object obj2;
        Object obj3;
        String str;
        if (obj instanceof String) {
            property = getProperty(drVar, (String) obj);
        } else {
            property = getProperty(drVar, ((Number) obj).intValue());
        }
        if ((property instanceof Scriptable) && (getProperty((Scriptable) property, "toJSON") instanceof Callable)) {
            property = callMethod(btVar.f6336g, (Scriptable) property, "toJSON", new Object[]{obj});
        }
        if (btVar.f6333d != null) {
            obj2 = btVar.f6333d.call(btVar.f6336g, btVar.f6337h, drVar, new Object[]{obj, property});
        } else {
            obj2 = property;
        }
        if (obj2 instanceof NativeNumber) {
            obj3 = Double.valueOf(ScriptRuntime.m6395b(obj2));
        } else if (obj2 instanceof NativeString) {
            obj3 = ScriptRuntime.m6436d(obj2);
        } else if (obj2 instanceof NativeBoolean) {
            obj3 = ((NativeBoolean) obj2).getDefaultValue(ScriptRuntime.f6494a);
        } else {
            obj3 = obj2;
        }
        if (obj3 == null) {
            return "null";
        }
        if (obj3.equals(Boolean.TRUE)) {
            return "true";
        }
        if (obj3.equals(Boolean.FALSE)) {
            return "false";
        }
        if (obj3 instanceof CharSequence) {
            return m6069a(obj3.toString());
        }
        if (obj3 instanceof Number) {
            double doubleValue = ((Number) obj3).doubleValue();
            if (doubleValue != doubleValue || doubleValue == Double.POSITIVE_INFINITY || doubleValue == Double.NEGATIVE_INFINITY) {
                return "null";
            }
            return ScriptRuntime.m6436d(obj3);
        } else if (!(obj3 instanceof Scriptable) || (obj3 instanceof Callable)) {
            return Undefined.f6689a;
        } else {
            if (!(obj3 instanceof NativeArray)) {
                return m6071a((Scriptable) obj3, btVar);
            }
            NativeArray bcVar = (NativeArray) obj3;
            if (btVar.f6330a.search(bcVar) != -1) {
                throw ScriptRuntime.m6455g("msg.cyclic.value");
            }
            btVar.f6330a.push(bcVar);
            String str2 = btVar.f6331b;
            btVar.f6331b += btVar.f6332c;
            LinkedList linkedList = new LinkedList();
            int i = (int) bcVar.f6285a;
            for (int i2 = 0; i2 < i; i2++) {
                Object a = m6066a((Object) Integer.valueOf(i2), (Scriptable) bcVar, btVar);
                if (a == Undefined.f6689a) {
                    linkedList.add("null");
                } else {
                    linkedList.add(a);
                }
            }
            if (linkedList.isEmpty()) {
                str = "[]";
            } else if (btVar.f6332c.length() == 0) {
                str = "[" + m6070a((Collection<Object>) linkedList, ",") + ']';
            } else {
                str = "[\n" + btVar.f6331b + m6070a((Collection<Object>) linkedList, ",\n" + btVar.f6331b) + 10 + str2 + ']';
            }
            btVar.f6330a.pop();
            btVar.f6331b = str2;
            return str;
        }
    }

    /* renamed from: a */
    private static String m6070a(Collection<Object> collection, String str) {
        if (collection.isEmpty()) {
            return "";
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(it.next().toString());
        while (it.hasNext()) {
            sb.append(str).append(it.next().toString());
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m6071a(Scriptable drVar, C2152bt btVar) {
        Object[] ids;
        String str;
        if (btVar.f6330a.search(drVar) != -1) {
            throw ScriptRuntime.m6455g("msg.cyclic.value");
        }
        btVar.f6330a.push(drVar);
        String str2 = btVar.f6331b;
        btVar.f6331b += btVar.f6332c;
        if (btVar.f6334e != null) {
            ids = btVar.f6334e.toArray();
        } else {
            ids = drVar.getIds();
        }
        LinkedList linkedList = new LinkedList();
        for (Object obj : ids) {
            Object a = m6066a(obj, drVar, btVar);
            if (a != Undefined.f6689a) {
                String str3 = m6069a(obj.toString()) + ":";
                if (btVar.f6332c.length() > 0) {
                    str3 = str3 + " ";
                }
                linkedList.add(str3 + a);
            }
        }
        if (linkedList.isEmpty()) {
            str = "{}";
        } else if (btVar.f6332c.length() == 0) {
            str = "{" + m6070a((Collection<Object>) linkedList, ",") + CoreConstants.CURLY_RIGHT;
        } else {
            str = "{\n" + btVar.f6331b + m6070a((Collection<Object>) linkedList, ",\n" + btVar.f6331b) + 10 + str2 + CoreConstants.CURLY_RIGHT;
        }
        btVar.f6330a.pop();
        btVar.f6331b = str2;
        return str;
    }

    /* renamed from: a */
    private static String m6069a(String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length() + 2);
        stringBuffer.append(CoreConstants.DOUBLE_QUOTE_CHAR);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case 8:
                    stringBuffer.append("\\b");
                    break;
                case 9:
                    stringBuffer.append("\\t");
                    break;
                case 10:
                    stringBuffer.append("\\n");
                    break;
                case 12:
                    stringBuffer.append("\\f");
                    break;
                case 13:
                    stringBuffer.append("\\r");
                    break;
                case '\"':
                    stringBuffer.append("\\\"");
                    break;
                case '\\':
                    stringBuffer.append("\\\\");
                    break;
                default:
                    if (charAt >= ' ') {
                        stringBuffer.append(charAt);
                        break;
                    } else {
                        stringBuffer.append("\\u");
                        stringBuffer.append(String.format("%04x", new Object[]{Integer.valueOf(charAt)}));
                        break;
                    }
            }
        }
        stringBuffer.append(CoreConstants.DOUBLE_QUOTE_CHAR);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public final int findPrototypeId(String str) {
        int i;
        String str2;
        switch (str.length()) {
            case 5:
                i = 2;
                str2 = "parse";
                break;
            case 8:
                i = 1;
                str2 = "toSource";
                break;
            case 9:
                i = 3;
                str2 = "stringify";
                break;
            default:
                str2 = null;
                i = 0;
                break;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
