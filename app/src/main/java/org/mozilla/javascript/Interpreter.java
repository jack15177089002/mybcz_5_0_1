package org.mozilla.javascript;

//import com.tencent.android.tpush.common.Constants;
import java.util.ArrayList;
import org.mozilla.javascript.p110b.AstRoot;
import org.mozilla.javascript.p110b.ScriptNode;
import org.mozilla.javascript.p111c.DebugFrame;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.an */
public final class Interpreter extends Icode implements Evaluator {

    /* renamed from: a */
    InterpreterData f6017a;

    /* renamed from: a */
    public final Object mo18685a(CompilerEnvirons iVar, ScriptNode auVar, String str, boolean z) {
        CodeGenerator hVar = new CodeGenerator();
        hVar.f6721a = iVar;
        new NodeTransformer().mo18956a(auVar);
        if (z) {
            hVar.f6723c = auVar.mo18764k(0);
        } else {
            hVar.f6723c = auVar;
        }
        hVar.f6722b = new InterpreterData(iVar.f6739b, hVar.f6723c.f6148E, str, ((AstRoot) auVar).f6213g);
        hVar.f6722b.f6075x = true;
        if (z) {
            hVar.mo19126a();
        } else {
            hVar.mo19127a((Node) hVar.f6723c);
        }
        this.f6017a = hVar.f6722b;
        return this.f6017a;
    }

    /* renamed from: a */
    public final Script mo18689a(Object obj) {
        if (obj != this.f6017a) {
            Kit.m5810a();
        }
        return InterpretedFunction.m5713a(this.f6017a, (Object) null);
    }

    /* renamed from: a */
    public final void mo18691a(Script djVar) {
        ((InterpretedFunction) djVar).f6014a.f6051C = true;
    }

    /* renamed from: a */
    public final Function mo18688a(Context lVar, Scriptable drVar, Object obj) {
        if (obj != this.f6017a) {
            Kit.m5810a();
        }
        return InterpretedFunction.m5715a(drVar, this.f6017a, (Object) null);
    }

    /* renamed from: a */
//    private static int m5735a(byte[] bArr, int i) {
//        return (bArr[i] << 8) | (bArr[i + 1] & Constants.NETWORK_TYPE_UNCONNECTED);
//    }

    /* renamed from: b */
//    private static int m5755b(byte[] bArr, int i) {
//        return ((bArr[i] & Constants.NETWORK_TYPE_UNCONNECTED) << 8) | (bArr[i + 1] & Constants.NETWORK_TYPE_UNCONNECTED);
//    }

    /* renamed from: c */
//    private static int m5760c(byte[] bArr, int i) {
//        return (bArr[i] << 24) | ((bArr[i + 1] & Constants.NETWORK_TYPE_UNCONNECTED) << 16) | ((bArr[i + 2] & Constants.NETWORK_TYPE_UNCONNECTED) << 8) | (bArr[i + 3] & Constants.NETWORK_TYPE_UNCONNECTED);
//    }

    /* renamed from: a */
    private static int m5726a(C2136ao aoVar, boolean z) {
        int[] iArr = aoVar.f6022e.f6061j;
        if (iArr == null) {
            return -1;
        }
        int i = aoVar.f6035r - 1;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 != iArr.length; i5 += 6) {
            int i6 = iArr[i5 + 0];
            int i7 = iArr[i5 + 1];
            if (i6 <= i && i < i7 && (!z || iArr[i5 + 3] == 1)) {
                if (i3 >= 0) {
                    if (i4 >= i7) {
                        if (i2 > i6) {
                            Kit.m5810a();
                        }
                        if (i4 == i7) {
                            Kit.m5810a();
                        }
                    }
                }
                i4 = i7;
                i2 = i6;
                i3 = i5;
            }
        }
        return i3;
    }

    /* renamed from: a */
    public final void mo18690a(RhinoException dhVar) {
        C2136ao[] aoVarArr;
        Context a = Context.m6753a();
        if (a == null || a.f6795s == null) {
            dhVar.f6491g = null;
            dhVar.f6492h = null;
            return;
        }
        if (a.f6796t == null || a.f6796t.f6407a == 0) {
            aoVarArr = new C2136ao[1];
        } else {
            int i = a.f6796t.f6407a;
            if (a.f6796t.mo18959a() == a.f6795s) {
                i--;
            }
            C2136ao[] aoVarArr2 = new C2136ao[(i + 1)];
            a.f6796t.mo18962a((Object[]) aoVarArr2);
            aoVarArr = aoVarArr2;
        }
        aoVarArr[aoVarArr.length - 1] = (C2136ao) a.f6795s;
        int i2 = 0;
        for (int i3 = 0; i3 != aoVarArr.length; i3++) {
            i2 += aoVarArr[i3].f6019b + 1;
        }
        int[] iArr = new int[i2];
        int i4 = i2;
        int length = aoVarArr.length;
        while (length != 0) {
            int i5 = length - 1;
            for (C2136ao aoVar = aoVarArr[i5]; aoVar != null; aoVar = aoVar.f6018a) {
                i4--;
                iArr[i4] = aoVar.f6037t;
            }
            length = i5;
        }
        if (i4 != 0) {
            Kit.m5810a();
        }
        dhVar.f6491g = aoVarArr;
        dhVar.f6492h = iArr;
    }

    /* renamed from: a */
    public final String mo18687a(Context lVar, int[] iArr) {
        C2136ao aoVar = (C2136ao) lVar.f6795s;
        InterpreterData arVar = aoVar.f6022e;
//        if (aoVar.f6037t >= 0) {
//            iArr[0] = m5755b(arVar.f6060i, aoVar.f6037t);
//        } else {
//            iArr[0] = 0;
//        }
        return arVar.f6053b;
    }

    /* renamed from: a */
    public final String mo18686a(RhinoException dhVar, String str) {
        String str2 = "org.mozilla.javascript.Interpreter.interpretLoop";
        StringBuffer stringBuffer = new StringBuffer(str.length() + 1000);
        String a = SecurityUtilities.m6504a("line.separator");
        C2136ao[] aoVarArr = (C2136ao[]) dhVar.f6491g;
        int[] iArr = dhVar.f6492h;
        int length = aoVarArr.length;
        int length2 = iArr.length;
        int i = length;
        int i2 = 0;
        while (i != 0) {
            int i3 = i - 1;
            int indexOf = str.indexOf(str2, i2);
            if (indexOf < 0) {
                break;
            }
            int length3 = indexOf + str2.length();
            while (length3 != str.length()) {
                char charAt = str.charAt(length3);
                if (charAt == 10 || charAt == 13) {
                    break;
                }
                length3++;
            }
            stringBuffer.append(str.substring(i2, length3));
            for (C2136ao aoVar = aoVarArr[i3]; aoVar != null; aoVar = aoVar.f6018a) {
                if (length2 == 0) {
                    Kit.m5810a();
                }
                length2--;
                InterpreterData arVar = aoVar.f6022e;
                stringBuffer.append(a);
                stringBuffer.append("\tat script");
                if (!(arVar.f6052a == null || arVar.f6052a.length() == 0)) {
                    stringBuffer.append(CoreConstants.DOT);
                    stringBuffer.append(arVar.f6052a);
                }
                stringBuffer.append(CoreConstants.LEFT_PARENTHESIS_CHAR);
                stringBuffer.append(arVar.f6053b);
                int i4 = iArr[length2];
//                if (i4 >= 0) {
//                    stringBuffer.append(CoreConstants.COLON_CHAR);
//                    stringBuffer.append(m5755b(arVar.f6060i, i4));
//                }
                stringBuffer.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
            }
            i2 = length3;
            i = i3;
        }
        stringBuffer.append(str.substring(i2));
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static ScriptStackElement[][] m5758b(RhinoException dhVar) {
        String str;
        if (dhVar.f6491g == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        C2136ao[] aoVarArr = (C2136ao[]) dhVar.f6491g;
        int[] iArr = dhVar.f6492h;
        int length = aoVarArr.length;
        int length2 = iArr.length;
        while (length != 0) {
            int i = length - 1;
            C2136ao aoVar = aoVarArr[i];
            ArrayList arrayList2 = new ArrayList();
            C2136ao aoVar2 = aoVar;
            int i2 = length2;
            while (aoVar2 != null) {
                if (i2 == 0) {
                    Kit.m5810a();
                }
                int i3 = i2 - 1;
                InterpreterData arVar = aoVar2.f6022e;
                String str2 = arVar.f6053b;
                int i4 = -1;
                int i5 = iArr[i3];
//                if (i5 >= 0) {
//                    i4 = m5755b(arVar.f6060i, i5);
//                }
                if (arVar.f6052a == null || arVar.f6052a.length() == 0) {
                    str = null;
                } else {
                    str = arVar.f6052a;
                }
                aoVar2 = aoVar2.f6018a;
                arrayList2.add(new ScriptStackElement(str2, str, i4));
                i2 = i3;
            }
            arrayList.add(arrayList2.toArray(new ScriptStackElement[arrayList2.size()]));
            length2 = i2;
            length = i;
        }
        return (ScriptStackElement[][]) arrayList.toArray(new ScriptStackElement[arrayList.size()][]);
    }

    /* renamed from: a */
    static String m5741a(InterpreterData arVar) {
        if (arVar.f6070s == null) {
            return null;
        }
        return arVar.f6070s.substring(arVar.f6071t, arVar.f6072u);
    }

    /* renamed from: a */
    private static void m5746a(Scriptable drVar, InterpretedFunction amVar, int i) {
        InterpretedFunction a = InterpretedFunction.m5714a(drVar, amVar, i);
        ScriptRuntime.m6382a(drVar, (NativeFunction) a, a.f6014a.f6055d, amVar.f6014a.f6051C);
    }

    /* renamed from: a */
    static Object m5737a(InterpretedFunction amVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        if (!ScriptRuntime.m6431c(lVar)) {
            Kit.m5810a();
        }
        if (lVar.f6784h != amVar.f6016c) {
            Object obj = lVar.f6784h;
            lVar.f6784h = amVar.f6016c;
            try {
                return amVar.f6015b.mo18992a(amVar.f6016c, lVar, amVar, drVar2, objArr);
            } finally {
                lVar.f6784h = obj;
            }
        } else {
//            C2136ao aoVar = new C2136ao(0);
//            m5749a(lVar, drVar, drVar2, objArr, (double[]) null, 0, objArr.length, amVar, (C2136ao) null, aoVar);
//            aoVar.f6031n = lVar.f6780d;
//            lVar.f6780d = false;
//            return m5740a(lVar, aoVar, (Object) null);

            return null;
        }
    }

    /* renamed from: a */
    public static Object m5739a(Context lVar, int i, Object obj, Object obj2) {
        C2136ao aoVar = (C2136ao) obj;
        C2138aq aqVar = new C2138aq(i, obj2);
        if (i == 2) {
            try {
                return m5740a(lVar, aoVar, (Object) aqVar);
            } catch (RuntimeException e) {
                if (e == obj2) {
                    return Undefined.f6689a;
                }
                throw e;
            }
        } else {
            Object a = m5740a(lVar, aoVar, (Object) aqVar);
            if (aqVar.f6048c == null) {
                return a;
            }
            throw aqVar.f6048c;
        }
    }

    /* renamed from: a */
    public static Object m5738a(NativeContinuation biVar, Context lVar, Scriptable drVar, Object[] objArr) {
        Object obj;
        if (!ScriptRuntime.m6431c(lVar)) {
            return ScriptRuntime.m6339a((Callable) biVar, lVar, drVar, (Scriptable) null, objArr);
        }
        if (objArr.length == 0) {
            obj = Undefined.f6689a;
        } else {
            obj = objArr[0];
        }
        if (((C2136ao) biVar.f6305a) == null) {
            return obj;
        }
        C2137ap apVar = new C2137ap(biVar, null);
        apVar.f6044c = obj;
        return m5740a(lVar, (C2136ao) null, (Object) apVar);
    }

    /* JADX WARNING: type inference failed for: r38v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r7v10, types: [java.lang.Error] */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r7v12, types: [java.lang.RuntimeException] */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r2v33 */
    /* JADX WARNING: type inference failed for: r24v0 */
    /* JADX WARNING: type inference failed for: r24v1 */
    /* JADX WARNING: type inference failed for: r2v53, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r24v2 */
    /* JADX WARNING: type inference failed for: r2v55, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r4v12, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r2v62, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r18v0, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r2v64, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v67 */
    /* JADX WARNING: type inference failed for: r3v21 */
    /* JADX WARNING: type inference failed for: r2v68 */
    /* JADX WARNING: type inference failed for: r2v69, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v16, types: [org.mozilla.javascript.aw] */
    /* JADX WARNING: type inference failed for: r3v22 */
    /* JADX WARNING: type inference failed for: r2v70, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r0v28, types: [int] */
    /* JADX WARNING: type inference failed for: r15v0 */
    /* JADX WARNING: type inference failed for: r15v1 */
    /* JADX WARNING: type inference failed for: r2v76, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r2v86, types: [byte] */
    /* JADX WARNING: type inference failed for: r2v101, types: [byte] */
    /* JADX WARNING: type inference failed for: r2v108 */
    /* JADX WARNING: type inference failed for: r2v110 */
    /* JADX WARNING: type inference failed for: r2v112 */
    /* JADX WARNING: type inference failed for: r2v119 */
    /* JADX WARNING: type inference failed for: r2v120, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v122, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r2v123 */
    /* JADX WARNING: type inference failed for: r7v28 */
    /* JADX WARNING: type inference failed for: r0v33 */
    /* JADX WARNING: type inference failed for: r0v34 */
    /* JADX WARNING: type inference failed for: r8v24 */
    /* JADX WARNING: type inference failed for: r2v129 */
    /* JADX WARNING: type inference failed for: r2v131, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r2v133 */
    /* JADX WARNING: type inference failed for: r8v27 */
    /* JADX WARNING: type inference failed for: r2v137 */
    /* JADX WARNING: type inference failed for: r2v139, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r2v141 */
    /* JADX WARNING: type inference failed for: r2v145 */
    /* JADX WARNING: type inference failed for: r2v146 */
    /* JADX WARNING: type inference failed for: r8v30 */
    /* JADX WARNING: type inference failed for: r2v147 */
    /* JADX WARNING: type inference failed for: r2v149, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r2v151, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r2v164 */
    /* JADX WARNING: type inference failed for: r2v166 */
    /* JADX WARNING: type inference failed for: r2v168 */
    /* JADX WARNING: type inference failed for: r2v169 */
    /* JADX WARNING: type inference failed for: r2v170, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v172, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r2v173 */
    /* JADX WARNING: type inference failed for: r2v174, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v176, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r2v178, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v42 */
    /* JADX WARNING: type inference failed for: r2v182 */
    /* JADX WARNING: type inference failed for: r8v44 */
    /* JADX WARNING: type inference failed for: r8v45, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v45 */
    /* JADX WARNING: type inference failed for: r0v46 */
    /* JADX WARNING: type inference failed for: r2v191, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r8v47 */
    /* JADX WARNING: type inference failed for: r2v198 */
    /* JADX WARNING: type inference failed for: r7v54 */
    /* JADX WARNING: type inference failed for: r2v206 */
    /* JADX WARNING: type inference failed for: r2v207, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v209, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r17v6, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r14v22, types: [int] */
    /* JADX WARNING: type inference failed for: r9v5, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r14v23, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v3, types: [int] */
    /* JADX WARNING: type inference failed for: r9v6, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r14v25 */
    /* JADX WARNING: type inference failed for: r15v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v5, types: [int] */
    /* JADX WARNING: type inference failed for: r9v7, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r14v27 */
    /* JADX WARNING: type inference failed for: r15v6, types: [byte] */
    /* JADX WARNING: type inference failed for: r8v60, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r2v236 */
    /* JADX WARNING: type inference failed for: r2v237, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v239, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r2v240 */
    /* JADX WARNING: type inference failed for: r2v241, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v243, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r0v60 */
    /* JADX WARNING: type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r0v65, types: [int] */
    /* JADX WARNING: type inference failed for: r3v24 */
    /* JADX WARNING: type inference failed for: r2v252 */
    /* JADX WARNING: type inference failed for: r10v8 */
    /* JADX WARNING: type inference failed for: r0v68 */
    /* JADX WARNING: type inference failed for: r4v27, types: [org.mozilla.javascript.ap] */
    /* JADX WARNING: type inference failed for: r2v256, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v25 */
    /* JADX WARNING: type inference failed for: r0v71, types: [int] */
    /* JADX WARNING: type inference failed for: r15v8, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r3v26 */
    /* JADX WARNING: type inference failed for: r8v85, types: [int] */
    /* JADX WARNING: type inference failed for: r3v27 */
    /* JADX WARNING: type inference failed for: r0v85 */
    /* JADX WARNING: type inference failed for: r11v8, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r0v86 */
    /* JADX WARNING: type inference failed for: r3v28 */
    /* JADX WARNING: type inference failed for: r0v87, types: [int] */
    /* JADX WARNING: type inference failed for: r10v11, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r13v7, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r2v270 */
    /* JADX WARNING: type inference failed for: r2v271, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v274, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r2v276 */
    /* JADX WARNING: type inference failed for: r8v95 */
    /* JADX WARNING: type inference failed for: r8v96, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v277 */
    /* JADX WARNING: type inference failed for: r2v278, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v281, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r2v283, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r8v98 */
    /* JADX WARNING: type inference failed for: r2v284 */
    /* JADX WARNING: type inference failed for: r2v285, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v288, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r2v294 */
    /* JADX WARNING: type inference failed for: r2v295 */
    /* JADX WARNING: type inference failed for: r8v103, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r2v300 */
    /* JADX WARNING: type inference failed for: r2v303 */
    /* JADX WARNING: type inference failed for: r2v304 */
    /* JADX WARNING: type inference failed for: r8v104, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v305 */
    /* JADX WARNING: type inference failed for: r2v308, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r2v309 */
    /* JADX WARNING: type inference failed for: r2v313 */
    /* JADX WARNING: type inference failed for: r2v314, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r8v107, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r2v318, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r2v319 */
    /* JADX WARNING: type inference failed for: r8v109 */
    /* JADX WARNING: type inference failed for: r8v110, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v320 */
    /* JADX WARNING: type inference failed for: r2v321, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v323, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r2v324, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r8v112 */
    /* JADX WARNING: type inference failed for: r2v325 */
    /* JADX WARNING: type inference failed for: r2v326, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v328, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r2v329 */
    /* JADX WARNING: type inference failed for: r2v330, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v332, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r1v12, types: [int] */
    /* JADX WARNING: type inference failed for: r2v333 */
    /* JADX WARNING: type inference failed for: r2v334 */
    /* JADX WARNING: type inference failed for: r8v116, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v335 */
    /* JADX WARNING: type inference failed for: r2v338, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r2v339 */
    /* JADX WARNING: type inference failed for: r8v118 */
    /* JADX WARNING: type inference failed for: r8v119, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v340 */
    /* JADX WARNING: type inference failed for: r0v122 */
    /* JADX WARNING: type inference failed for: r2v345, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r8v121 */
    /* JADX WARNING: type inference failed for: r0v126, types: [int] */
    /* JADX WARNING: type inference failed for: r0v127 */
    /* JADX WARNING: type inference failed for: r0v128, types: [int] */
    /* JADX WARNING: type inference failed for: r2v359 */
    /* JADX WARNING: type inference failed for: r8v131 */
    /* JADX WARNING: type inference failed for: r8v135 */
    /* JADX WARNING: type inference failed for: r8v138 */
    /* JADX WARNING: type inference failed for: r8v140 */
    /* JADX WARNING: type inference failed for: r2v368, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v372 */
    /* JADX WARNING: type inference failed for: r3v29 */
    /* JADX WARNING: type inference failed for: r2v380 */
    /* JADX WARNING: type inference failed for: r0v132 */
    /* JADX WARNING: type inference failed for: r2v407, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r7v148, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v133 */
    /* JADX WARNING: type inference failed for: r2v423 */
    /* JADX WARNING: type inference failed for: r8v154 */
    /* JADX WARNING: type inference failed for: r8v155, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v424 */
    /* JADX WARNING: type inference failed for: r2v425, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v134 */
    /* JADX WARNING: type inference failed for: r2v430, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r2v431, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r8v157 */
    /* JADX WARNING: type inference failed for: r0v136, types: [int] */
    /* JADX WARNING: type inference failed for: r0v141 */
    /* JADX WARNING: type inference failed for: r2v459, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v39, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r3v33 */
    /* JADX WARNING: type inference failed for: r2v460 */
    /* JADX WARNING: type inference failed for: r6v26, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r3v34 */
    /* JADX WARNING: type inference failed for: r2v461 */
    /* JADX WARNING: type inference failed for: r3v35 */
    /* JADX WARNING: type inference failed for: r2v462 */
    /* JADX WARNING: type inference failed for: r3v36, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r34v5 */
    /* JADX WARNING: type inference failed for: r2v463 */
    /* JADX WARNING: type inference failed for: r3v37 */
    /* JADX WARNING: type inference failed for: r3v39 */
    /* JADX WARNING: type inference failed for: r2v469, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r24v3 */
    /* JADX WARNING: type inference failed for: r0v146 */
    /* JADX WARNING: type inference failed for: r2v472, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r24v4 */
    /* JADX WARNING: type inference failed for: r0v149, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r24v5 */
    /* JADX WARNING: type inference failed for: r2v474, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r2v482, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r0v150 */
    /* JADX WARNING: type inference failed for: r0v151 */
    /* JADX WARNING: type inference failed for: r2v485 */
    /* JADX WARNING: type inference failed for: r3v47 */
    /* JADX WARNING: type inference failed for: r3v48 */
    /* JADX WARNING: type inference failed for: r3v49 */
    /* JADX WARNING: type inference failed for: r3v50 */
    /* JADX WARNING: type inference failed for: r3v51 */
    /* JADX WARNING: type inference failed for: r3v52 */
    /* JADX WARNING: type inference failed for: r24v6 */
    /* JADX WARNING: type inference failed for: r24v7 */
    /* JADX WARNING: type inference failed for: r24v8 */
    /* JADX WARNING: type inference failed for: r24v9 */
    /* JADX WARNING: type inference failed for: r24v10 */
    /* JADX WARNING: type inference failed for: r24v11 */
    /* JADX WARNING: type inference failed for: r2v489 */
    /* JADX WARNING: type inference failed for: r2v490 */
    /* JADX WARNING: type inference failed for: r2v491 */
    /* JADX WARNING: type inference failed for: r2v492 */
    /* JADX WARNING: type inference failed for: r2v493 */
    /* JADX WARNING: type inference failed for: r2v494 */
    /* JADX WARNING: type inference failed for: r2v495 */
    /* JADX WARNING: type inference failed for: r2v496 */
    /* JADX WARNING: type inference failed for: r2v497 */
    /* JADX WARNING: type inference failed for: r14v32 */
    /* JADX WARNING: type inference failed for: r14v33 */
    /* JADX WARNING: type inference failed for: r15v10 */
    /* JADX WARNING: type inference failed for: r15v11 */
    /* JADX WARNING: type inference failed for: r2v498 */
    /* JADX WARNING: type inference failed for: r2v499 */
    /* JADX WARNING: type inference failed for: r2v500 */
    /* JADX WARNING: type inference failed for: r2v501 */
    /* JADX WARNING: type inference failed for: r2v502 */
    /* JADX WARNING: type inference failed for: r2v503 */
    /* JADX WARNING: type inference failed for: r2v504 */
    /* JADX WARNING: type inference failed for: r2v505 */
    /* JADX WARNING: type inference failed for: r2v506 */
    /* JADX WARNING: type inference failed for: r2v507 */
    /* JADX WARNING: type inference failed for: r2v508 */
    /* JADX WARNING: type inference failed for: r2v509 */
    /* JADX WARNING: type inference failed for: r2v510 */
    /* JADX WARNING: type inference failed for: r2v511 */
    /* JADX WARNING: type inference failed for: r24v12 */
    /* JADX WARNING: type inference failed for: r24v13 */
    /* JADX WARNING: type inference failed for: r2v512 */
    /* JADX WARNING: type inference failed for: r2v513 */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01de, code lost:
        if (r6.f6020c == false) goto L_0x01e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01e0, code lost:
        r6 = r6.mo18692a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01e4, code lost:
        m5745a(r6, (java.lang.Object) r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01e7, code lost:
        r25 = null;
        r26 = r4;
        r7 = r28;
        r3 = r24;
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01f4, code lost:
        if (r3.f6020c != false) goto L_0x022e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01fb, code lost:
        if (r38.f6046a != 2) goto L_0x0204;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0203, code lost:
        throw org.mozilla.javascript.ScriptRuntime.m6455g("msg.yield.closing");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0204, code lost:
        r3.f6020c = true;
        r3.f6033p = r3.f6023f[r7];
        r3.f6034q = r3.f6025h[r7];
        r3.f6039v = r7;
        r3.f6035r--;
        org.mozilla.javascript.ScriptRuntime.m6443e(r36);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0222, code lost:
        if (r3.f6033p == org.mozilla.javascript.UniqueTag.f6692c) goto L_0x0227;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x022e, code lost:
        r3.f6020c = false;
        r8 = m5755b(r3.f6022e.f6060i, r3.f6035r);
        r3.f6035r += 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0246, code lost:
        if (r38.f6046a != 1) goto L_0x02bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0248, code lost:
        r2 = new org.mozilla.javascript.JavaScriptException(r38.f6047b, r3.f6022e.f6053b, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0257, code lost:
        if (r2 == org.mozilla.javascript.Scriptable.f6533j) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0259, code lost:
        r4 = r26;
        r6 = r25;
        r17 = r3;
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02c1, code lost:
        if (r38.f6046a != 2) goto L_0x02c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02c3, code lost:
        r2 = r38.f6047b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02cc, code lost:
        if (r38.f6046a == 0) goto L_0x02d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02d2, code lost:
        throw org.mozilla.javascript.Kit.m5810a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x02d7, code lost:
        if (r18 != 72) goto L_0x02e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02d9, code lost:
        r3.f6023f[r7] = r38.f6047b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02e1, code lost:
        r2 = org.mozilla.javascript.Scriptable.f6533j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:401:0x09ba, code lost:
        r7 = m5728a(r3, (java.lang.Object[]) r5, r6, r7, r20, r31, r32, (int) r15);
        r14 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x09d3, code lost:
        r7 = m5753b(r3, r5, r6, r7, r20, r31, r32, r15);
        r14 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x09ec, code lost:
        r7 = m5727a(r3, (java.lang.Object[]) r5, r6, r7, r20, r31, (int) r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ed, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ee, code lost:
        r4 = r26;
        r6 = r28;
        r7 = r3;
        r3 = r25;
        r24 = r24;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f7, code lost:
        r2.printStackTrace(java.lang.System.err);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0101, code lost:
        throw new java.lang.IllegalStateException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:543:0x0d6b, code lost:
        r3 = r2;
        r2 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:554:0x0d91, code lost:
        r28 = r6;
        r17 = r7;
        r6 = r3;
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:601:0x0e41, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:602:0x0e42, code lost:
        r7 = r3;
        r3 = r2;
        r2 = r6;
        r6 = r28;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:603:0x0e49, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:604:0x0e4a, code lost:
        r7 = r6;
        r6 = r28;
        r34 = r2;
        r2 = r3;
        r3 = r34;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:613:0x0e7a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:614:0x0e7b, code lost:
        r6 = r28;
        r7 = r3;
        r3 = r2;
        r2 = r4;
        r4 = r26;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:622:0x0ea4, code lost:
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:725:0x00bd, code lost:
        r14 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:793:?, code lost:
        return r3.f6033p;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:794:?, code lost:
        return org.mozilla.javascript.ScriptRuntime.m6313a(r3.f6034q);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01cc, code lost:
        m5756b(r36, r3, (java.lang.Object) null);
        r2 = r3.f6033p;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        r4 = r3.f6034q;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01d8, code lost:
        if (r3.f6018a == null) goto L_0x0d6b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01da, code lost:
        r6 = r3.f6018a;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r14v23, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r15v4, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r15v6, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r18v0, types: [byte, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r2v101, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r2v86, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r8v103, types: [byte, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r8v107, types: [byte, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=null, for r8v60, types: [byte, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte[], code=null, for r4v12, types: [byte[]] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object, code=null, for r38v0, types: [java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v2
  assigns: []
  uses: []
  mth insns count: 1778
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
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0335 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x033d A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0371 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x03bf A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x03d7 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x03e8 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x03f9 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0412 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0420 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x042a A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0431 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0433 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0440 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x045e A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0485 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x048c A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x049b A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x04ab A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x04cb A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x04f5 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0502 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x050a A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0524 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0535 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x053c A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0544 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0555 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0565 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0593 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x05b0 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x05ba A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x05d2 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x05ec A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x0613 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0635 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x063d A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0645 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x064d A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x065b A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0678 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0686 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x069e A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06ad A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x06b5 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x06cd A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x06ef A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x071e A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x073c A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x0755 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0892 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0928 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x093c A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x094a A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x0950 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x0965 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x097a A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x0988 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:399:0x0998 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x09b2 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x09cb A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x09e4 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x09fa A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x0a0e A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x0a18 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x0a22 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:410:0x0a29 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x0a31 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x0a39 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x0a41 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:414:0x0a49 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:415:0x0a4f A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:419:0x0a69 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:420:0x0a73 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:429:0x0aaa A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:440:0x0ad7 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x0af3 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:449:0x0b0b A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:456:0x0b2c A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:457:0x0b32 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:461:0x0b45 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:462:0x0b4d A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:463:0x0b58 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:464:0x0b61 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:465:0x0b6f A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:466:0x0b78 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:467:0x0b8c A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:468:0x0b9e A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:472:0x0bbf A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:473:0x0be0 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:474:0x0c01 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:482:0x0c44 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:486:0x0c5a A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:490:0x0c7a A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:494:0x0c8d A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:497:0x0c9b A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:500:0x0ca9 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:503:0x0caf A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:504:0x0cbb A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:505:0x0cbe A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:506:0x0cc1 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:507:0x0cc4 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:508:0x0cc7 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:509:0x0cca A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:510:0x0ccd A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:511:0x0cdb A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:512:0x0ce9 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:513:0x0cf7 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:514:0x0cfc A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:515:0x0d01 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:516:0x0d06 A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:517:0x0d0b A[Catch:{ Throwable -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:521:0x0d1d A[SYNTHETIC, Splitter:B:521:0x0d1d] */
    /* JADX WARNING: Removed duplicated region for block: B:526:0x0d2f A[SYNTHETIC, Splitter:B:526:0x0d2f] */
    /* JADX WARNING: Removed duplicated region for block: B:531:0x0d41 A[SYNTHETIC, Splitter:B:531:0x0d41] */
    /* JADX WARNING: Removed duplicated region for block: B:550:0x0d8a  */
    /* JADX WARNING: Removed duplicated region for block: B:554:0x0d91  */
    /* JADX WARNING: Removed duplicated region for block: B:555:0x0d99  */
    /* JADX WARNING: Removed duplicated region for block: B:598:0x0e37  */
    /* JADX WARNING: Removed duplicated region for block: B:616:0x0e88  */
    /* JADX WARNING: Removed duplicated region for block: B:624:0x0eaa  */
    /* JADX WARNING: Removed duplicated region for block: B:625:0x0ead  */
    /* JADX WARNING: Removed duplicated region for block: B:629:0x0ec0  */
    /* JADX WARNING: Removed duplicated region for block: B:631:0x00c8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:633:0x00f7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:652:0x01cc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:653:0x02e5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:654:0x0303 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:655:0x0327 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:656:0x04e5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:657:0x04ef A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:787:0x0e03 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0196 A[ADDED_TO_REGION, Catch:{ Throwable -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01a4 A[SYNTHETIC, Splitter:B:87:0x01a4] */
    /* JADX WARNING: Unknown variable types count: 177 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Object m5740a(Context r36, C2136ao r37, Object r38) {
        /*
            org.mozilla.javascript.ek r29 = org.mozilla.javascript.UniqueTag.f6692c
            java.lang.Object r30 = org.mozilla.javascript.Undefined.f6689a
            r0 = r36
            int r2 = r0.f6798v
            if (r2 == 0) goto L_0x0102
            r2 = 1
            r23 = r2
        L_0x000d:
            r28 = 0
            r14 = -1
            r0 = r36
            java.lang.Object r2 = r0.f6795s
            if (r2 == 0) goto L_0x0030
            r0 = r36
            org.mozilla.javascript.cq r2 = r0.f6796t
            if (r2 != 0) goto L_0x0025
            org.mozilla.javascript.cq r2 = new org.mozilla.javascript.cq
            r2.<init>()
            r0 = r36
            r0.f6796t = r2
        L_0x0025:
            r0 = r36
            org.mozilla.javascript.cq r2 = r0.f6796t
            r0 = r36
            java.lang.Object r3 = r0.f6795s
            r2.mo18961a(r3)
        L_0x0030:
            r2 = 0
            if (r38 == 0) goto L_0x0110
            r0 = r38
            boolean r3 = r0 instanceof org.mozilla.javascript.C2138aq
            if (r3 == 0) goto L_0x0107
            org.mozilla.javascript.aq r38 = (org.mozilla.javascript.C2138aq) r38
            java.lang.Object[] r2 = org.mozilla.javascript.ScriptRuntime.f6517x
            r2 = 1
            r0 = r36
            r1 = r37
            m5748a(r0, r1, r2)
            r2 = 0
        L_0x0046:
            r25 = 0
            r26 = 0
            r7 = r28
            r3 = r2
            r4 = r37
        L_0x004f:
            if (r3 == 0) goto L_0x0196
            if (r14 < 0) goto L_0x0118
            boolean r2 = r4.f6020c     // Catch:{ Throwable -> 0x017c }
            if (r2 == 0) goto L_0x0eb3
            org.mozilla.javascript.ao r5 = r4.mo18692a()     // Catch:{ Throwable -> 0x017c }
        L_0x005b:
            org.mozilla.javascript.ar r2 = r5.f6022e     // Catch:{ Throwable -> 0x017c }
            int[] r2 = r2.f6061j     // Catch:{ Throwable -> 0x017c }
            int r6 = r14 + 2
            r6 = r2[r6]     // Catch:{ Throwable -> 0x017c }
            r5.f6035r = r6     // Catch:{ Throwable -> 0x017c }
            if (r23 == 0) goto L_0x006b
            int r6 = r5.f6035r     // Catch:{ Throwable -> 0x017c }
            r5.f6036s = r6     // Catch:{ Throwable -> 0x017c }
        L_0x006b:
            int r6 = r5.f6028k     // Catch:{ Throwable -> 0x017c }
            r5.f6039v = r6     // Catch:{ Throwable -> 0x017c }
            int r6 = r5.f6027j     // Catch:{ Throwable -> 0x017c }
            int r8 = r14 + 5
            r8 = r2[r8]     // Catch:{ Throwable -> 0x017c }
            int r6 = r6 + r8
            int r8 = r5.f6027j     // Catch:{ Throwable -> 0x017c }
            int r9 = r14 + 4
            r2 = r2[r9]     // Catch:{ Throwable -> 0x017c }
            int r8 = r8 + r2
            java.lang.Object[] r2 = r5.f6023f     // Catch:{ Throwable -> 0x017c }
            r2 = r2[r6]     // Catch:{ Throwable -> 0x017c }
            org.mozilla.javascript.dr r2 = (org.mozilla.javascript.Scriptable) r2     // Catch:{ Throwable -> 0x017c }
            r5.f6038u = r2     // Catch:{ Throwable -> 0x017c }
            java.lang.Object[] r2 = r5.f6023f     // Catch:{ Throwable -> 0x017c }
            r2[r8] = r3     // Catch:{ Throwable -> 0x017c }
        L_0x0089:
            r2 = 0
            r5.f6041x = r2     // Catch:{ Throwable -> 0x017c }
            java.lang.Object r0 = r5.f6041x     // Catch:{ Throwable -> 0x0e54 }
            r24 = r0
            r2 = 0
            r5.f6041x = r2     // Catch:{ Throwable -> 0x0e5f }
            r3 = r5
        L_0x0094:
            java.lang.Object[] r5 = r3.f6023f     // Catch:{ Throwable -> 0x0e68 }
            double[] r6 = r3.f6025h     // Catch:{ Throwable -> 0x0e68 }
            org.mozilla.javascript.ao r2 = r3.f6026i     // Catch:{ Throwable -> 0x0e68 }
            java.lang.Object[] r0 = r2.f6023f     // Catch:{ Throwable -> 0x0e68 }
            r20 = r0
            org.mozilla.javascript.ao r2 = r3.f6026i     // Catch:{ Throwable -> 0x0e68 }
            double[] r0 = r2.f6025h     // Catch:{ Throwable -> 0x0e68 }
            r31 = r0
            org.mozilla.javascript.ao r2 = r3.f6026i     // Catch:{ Throwable -> 0x0e68 }
            int[] r0 = r2.f6024g     // Catch:{ Throwable -> 0x0e68 }
            r32 = r0
            org.mozilla.javascript.ar r2 = r3.f6022e     // Catch:{ Throwable -> 0x0e68 }
            byte[] r4 = r2.f6060i     // Catch:{ Throwable -> 0x0e68 }
            org.mozilla.javascript.ar r2 = r3.f6022e     // Catch:{ Throwable -> 0x0e68 }
            java.lang.String[] r0 = r2.f6056e     // Catch:{ Throwable -> 0x0e68 }
            r33 = r0
            int r2 = r3.f6039v     // Catch:{ Throwable -> 0x0e68 }
            r0 = r36
            r0.f6795s = r3     // Catch:{ Throwable -> 0x0e68 }
            r28 = r7
            r7 = r2
        L_0x00bd:
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r8 = r2 + 1
            r3.f6035r = r8     // Catch:{ Throwable -> 0x00ed }
            byte r18 = r4[r2]     // Catch:{ Throwable -> 0x00ed }
            switch(r18) {
                case -64: goto L_0x0ca9;
                case -63: goto L_0x02e5;
                case -62: goto L_0x01a4;
                case -61: goto L_0x09b2;
                case -60: goto L_0x00c8;
                case -59: goto L_0x0593;
                case -58: goto L_0x0be0;
                case -57: goto L_0x0bbf;
                case -56: goto L_0x06ad;
                case -55: goto L_0x0755;
                case -54: goto L_0x0c5a;
                case -53: goto L_0x0c44;
                case -52: goto L_0x0a18;
                case -51: goto L_0x0a0e;
                case -50: goto L_0x0a49;
                case -49: goto L_0x09cb;
                case -48: goto L_0x09e4;
                case -47: goto L_0x0d2f;
                case -46: goto L_0x0d1d;
                case -45: goto L_0x0d0b;
                case -44: goto L_0x0d06;
                case -43: goto L_0x0d01;
                case -42: goto L_0x0cfc;
                case -41: goto L_0x0cf7;
                case -40: goto L_0x0ce9;
                case -39: goto L_0x0cdb;
                case -38: goto L_0x0ccd;
                case -37: goto L_0x0cca;
                case -36: goto L_0x0cc7;
                case -35: goto L_0x0cc4;
                case -34: goto L_0x0cc1;
                case -33: goto L_0x0cbe;
                case -32: goto L_0x0cbb;
                case -31: goto L_0x0c01;
                case -30: goto L_0x0b9e;
                case -29: goto L_0x0b8c;
                case -28: goto L_0x0965;
                case -27: goto L_0x0950;
                case -26: goto L_0x0caf;
                case -25: goto L_0x045e;
                case -24: goto L_0x0440;
                case -23: goto L_0x0433;
                case -22: goto L_0x04ef;
                case -21: goto L_0x073c;
                case -20: goto L_0x0b6f;
                case -19: goto L_0x0b61;
                case -18: goto L_0x071e;
                case -17: goto L_0x06ef;
                case -16: goto L_0x06cd;
                case -15: goto L_0x06b5;
                case -14: goto L_0x093c;
                case -13: goto L_0x0b58;
                case -12: goto L_0x0b4d;
                case -11: goto L_0x0686;
                case -10: goto L_0x0645;
                case -9: goto L_0x0613;
                case -8: goto L_0x0998;
                case -7: goto L_0x09fa;
                case -6: goto L_0x03f9;
                case -5: goto L_0x048c;
                case -4: goto L_0x0485;
                case -3: goto L_0x04cb;
                case -2: goto L_0x04ab;
                case -1: goto L_0x049b;
                case 0: goto L_0x05b0;
                case 1: goto L_0x00c8;
                case 2: goto L_0x0a4f;
                case 3: goto L_0x0a69;
                case 4: goto L_0x04e5;
                case 5: goto L_0x0431;
                case 6: goto L_0x03e8;
                case 7: goto L_0x03d7;
                case 8: goto L_0x0565;
                case 9: goto L_0x0502;
                case 10: goto L_0x0502;
                case 11: goto L_0x0502;
                case 12: goto L_0x0371;
                case 13: goto L_0x0371;
                case 14: goto L_0x0335;
                case 15: goto L_0x0335;
                case 16: goto L_0x0335;
                case 17: goto L_0x0335;
                case 18: goto L_0x0502;
                case 19: goto L_0x0502;
                case 20: goto L_0x050a;
                case 21: goto L_0x0535;
                case 22: goto L_0x053c;
                case 23: goto L_0x053c;
                case 24: goto L_0x053c;
                case 25: goto L_0x053c;
                case 26: goto L_0x0544;
                case 27: goto L_0x04f5;
                case 28: goto L_0x0524;
                case 29: goto L_0x0524;
                case 30: goto L_0x0892;
                case 31: goto L_0x05b0;
                case 32: goto L_0x0928;
                case 33: goto L_0x05d2;
                case 34: goto L_0x05ba;
                case 35: goto L_0x05ec;
                case 36: goto L_0x0635;
                case 37: goto L_0x063d;
                case 38: goto L_0x0755;
                case 39: goto L_0x0988;
                case 40: goto L_0x097a;
                case 41: goto L_0x094a;
                case 42: goto L_0x0a22;
                case 43: goto L_0x0a29;
                case 44: goto L_0x0a39;
                case 45: goto L_0x0a41;
                case 46: goto L_0x03bf;
                case 47: goto L_0x03bf;
                case 48: goto L_0x0b78;
                case 49: goto L_0x0555;
                case 50: goto L_0x0303;
                case 51: goto L_0x0327;
                case 52: goto L_0x033d;
                case 53: goto L_0x033d;
                case 54: goto L_0x069e;
                case 55: goto L_0x09ec;
                case 56: goto L_0x0eaa;
                case 57: goto L_0x0a73;
                case 58: goto L_0x0aaa;
                case 59: goto L_0x0aaa;
                case 60: goto L_0x0aaa;
                case 61: goto L_0x0ad7;
                case 62: goto L_0x0ad7;
                case 63: goto L_0x0a31;
                case 64: goto L_0x01cc;
                case 65: goto L_0x0c01;
                case 66: goto L_0x0c01;
                case 67: goto L_0x064d;
                case 68: goto L_0x065b;
                case 69: goto L_0x0678;
                case 70: goto L_0x0755;
                case 71: goto L_0x0af3;
                case 72: goto L_0x01f2;
                case 73: goto L_0x0565;
                case 74: goto L_0x0c7a;
                case 75: goto L_0x0c8d;
                case 76: goto L_0x0c9b;
                case 77: goto L_0x0b0b;
                case 78: goto L_0x0b2c;
                case 79: goto L_0x0b32;
                case 80: goto L_0x0b45;
                case 81: goto L_0x00c8;
                case 82: goto L_0x00c8;
                case 83: goto L_0x00c8;
                case 84: goto L_0x00c8;
                case 85: goto L_0x00c8;
                case 86: goto L_0x00c8;
                case 87: goto L_0x00c8;
                case 88: goto L_0x00c8;
                case 89: goto L_0x00c8;
                case 90: goto L_0x00c8;
                case 91: goto L_0x00c8;
                case 92: goto L_0x00c8;
                case 93: goto L_0x00c8;
                case 94: goto L_0x00c8;
                case 95: goto L_0x00c8;
                case 96: goto L_0x00c8;
                case 97: goto L_0x00c8;
                case 98: goto L_0x00c8;
                case 99: goto L_0x00c8;
                case 100: goto L_0x00c8;
                case 101: goto L_0x00c8;
                case 102: goto L_0x00c8;
                case 103: goto L_0x00c8;
                case 104: goto L_0x00c8;
                case 105: goto L_0x00c8;
                case 106: goto L_0x00c8;
                case 107: goto L_0x00c8;
                case 108: goto L_0x00c8;
                case 109: goto L_0x00c8;
                case 110: goto L_0x00c8;
                case 111: goto L_0x00c8;
                case 112: goto L_0x00c8;
                case 113: goto L_0x00c8;
                case 114: goto L_0x00c8;
                case 115: goto L_0x00c8;
                case 116: goto L_0x00c8;
                case 117: goto L_0x00c8;
                case 118: goto L_0x00c8;
                case 119: goto L_0x00c8;
                case 120: goto L_0x00c8;
                case 121: goto L_0x00c8;
                case 122: goto L_0x00c8;
                case 123: goto L_0x00c8;
                case 124: goto L_0x00c8;
                case 125: goto L_0x00c8;
                case 126: goto L_0x00c8;
                case 127: goto L_0x00c8;
                case 128: goto L_0x00c8;
                case 129: goto L_0x00c8;
                case 130: goto L_0x00c8;
                case 131: goto L_0x00c8;
                case 132: goto L_0x00c8;
                case 133: goto L_0x00c8;
                case 134: goto L_0x00c8;
                case 135: goto L_0x00c8;
                case 136: goto L_0x00c8;
                case 137: goto L_0x00c8;
                case 138: goto L_0x00c8;
                case 139: goto L_0x00c8;
                case 140: goto L_0x00c8;
                case 141: goto L_0x00c8;
                case 142: goto L_0x00c8;
                case 143: goto L_0x00c8;
                case 144: goto L_0x00c8;
                case 145: goto L_0x00c8;
                case 146: goto L_0x00c8;
                case 147: goto L_0x00c8;
                case 148: goto L_0x00c8;
                case 149: goto L_0x00c8;
                case 150: goto L_0x00c8;
                case 151: goto L_0x00c8;
                case 152: goto L_0x00c8;
                case 153: goto L_0x00c8;
                case 154: goto L_0x00c8;
                case 155: goto L_0x00c8;
                case 156: goto L_0x0ead;
                default: goto L_0x00c8;
            }     // Catch:{ Throwable -> 0x00ed }
        L_0x00c8:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ Throwable -> 0x00ed }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00ed }
            java.lang.String r5 = "Unknown icode : "
            r4.<init>(r5)     // Catch:{ Throwable -> 0x00ed }
            r0 = r18
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch:{ Throwable -> 0x00ed }
            java.lang.String r5 = " @ pc : "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Throwable -> 0x00ed }
            int r5 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r5 = r5 + -1
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Throwable -> 0x00ed }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x00ed }
            r2.<init>(r4)     // Catch:{ Throwable -> 0x00ed }
            throw r2     // Catch:{ Throwable -> 0x00ed }
        L_0x00ed:
            r2 = move-exception
            r4 = r26
            r6 = r28
            r7 = r3
            r3 = r25
        L_0x00f5:
            if (r24 == 0) goto L_0x0d91
            java.io.PrintStream r3 = java.lang.System.err
            r2.printStackTrace(r3)
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            r2.<init>()
            throw r2
        L_0x0102:
            r2 = 0
            r23 = r2
            goto L_0x000d
        L_0x0107:
            r0 = r38
            boolean r3 = r0 instanceof org.mozilla.javascript.C2137ap
            if (r3 != 0) goto L_0x0110
            org.mozilla.javascript.Kit.m5810a()
        L_0x0110:
            r34 = r2
            r2 = r38
            r38 = r34
            goto L_0x0046
        L_0x0118:
            r0 = r3
            org.mozilla.javascript.ap r0 = (org.mozilla.javascript.C2137ap) r0     // Catch:{ Throwable -> 0x017c }
            r2 = r0
            org.mozilla.javascript.ao r5 = r2.f6043b     // Catch:{ Throwable -> 0x017c }
            if (r5 == r4) goto L_0x0123
            org.mozilla.javascript.Kit.m5810a()     // Catch:{ Throwable -> 0x017c }
        L_0x0123:
            org.mozilla.javascript.ao r5 = r2.f6042a     // Catch:{ Throwable -> 0x017c }
            if (r5 != 0) goto L_0x012a
            org.mozilla.javascript.Kit.m5810a()     // Catch:{ Throwable -> 0x017c }
        L_0x012a:
            org.mozilla.javascript.ao r5 = r2.f6042a     // Catch:{ Throwable -> 0x017c }
            int r5 = r5.f6019b     // Catch:{ Throwable -> 0x017c }
            int r5 = r5 + 1
            org.mozilla.javascript.ao r6 = r2.f6043b     // Catch:{ Throwable -> 0x017c }
            if (r6 == 0) goto L_0x0eb0
            org.mozilla.javascript.ao r6 = r2.f6043b     // Catch:{ Throwable -> 0x017c }
            int r6 = r6.f6019b     // Catch:{ Throwable -> 0x017c }
            int r5 = r5 - r6
            r11 = r5
        L_0x013a:
            r5 = 0
            r9 = 0
            org.mozilla.javascript.ao r8 = r2.f6042a     // Catch:{ Throwable -> 0x017c }
            r6 = 0
            r10 = r8
            r34 = r6
            r6 = r9
            r9 = r34
        L_0x0145:
            if (r9 == r11) goto L_0x016d
            boolean r8 = r10.f6020c     // Catch:{ Throwable -> 0x017c }
            if (r8 != 0) goto L_0x014e
            org.mozilla.javascript.Kit.m5810a()     // Catch:{ Throwable -> 0x017c }
        L_0x014e:
            org.mozilla.javascript.c.a r8 = r10.f6029l     // Catch:{ Throwable -> 0x017c }
            if (r8 != 0) goto L_0x0158
            org.mozilla.javascript.ar r8 = r10.f6022e     // Catch:{ Throwable -> 0x017c }
            boolean r8 = r8.f6054c     // Catch:{ Throwable -> 0x017c }
            if (r8 == 0) goto L_0x016b
        L_0x0158:
            r8 = 1
        L_0x0159:
            if (r8 == 0) goto L_0x0165
            if (r6 != 0) goto L_0x0161
            int r6 = r11 - r9
            org.mozilla.javascript.ao[] r6 = new org.mozilla.javascript.C2136ao[r6]     // Catch:{ Throwable -> 0x017c }
        L_0x0161:
            r6[r5] = r10     // Catch:{ Throwable -> 0x017c }
            int r5 = r5 + 1
        L_0x0165:
            org.mozilla.javascript.ao r10 = r10.f6018a     // Catch:{ Throwable -> 0x017c }
            int r8 = r9 + 1
            r9 = r8
            goto L_0x0145
        L_0x016b:
            r8 = 0
            goto L_0x0159
        L_0x016d:
            if (r5 == 0) goto L_0x0187
            int r5 = r5 + -1
            r8 = r6[r5]     // Catch:{ Throwable -> 0x017c }
            java.lang.Object[] r9 = org.mozilla.javascript.ScriptRuntime.f6517x     // Catch:{ Throwable -> 0x017c }
            r9 = 1
            r0 = r36
            m5748a(r0, r8, r9)     // Catch:{ Throwable -> 0x017c }
            goto L_0x016d
        L_0x017c:
            r2 = move-exception
            r6 = r7
            r24 = r3
            r3 = r25
            r7 = r4
            r4 = r26
            goto L_0x00f5
        L_0x0187:
            org.mozilla.javascript.ao r5 = r2.f6042a     // Catch:{ Throwable -> 0x017c }
            org.mozilla.javascript.ao r5 = r5.mo18692a()     // Catch:{ Throwable -> 0x017c }
            java.lang.Object r6 = r2.f6044c     // Catch:{ Throwable -> 0x017c }
            double r8 = r2.f6045d     // Catch:{ Throwable -> 0x017c }
            m5745a(r5, r6, r8)     // Catch:{ Throwable -> 0x017c }
            goto L_0x0089
        L_0x0196:
            if (r38 != 0) goto L_0x019f
            boolean r2 = r4.f6020c     // Catch:{ Throwable -> 0x017c }
            if (r2 == 0) goto L_0x019f
            org.mozilla.javascript.Kit.m5810a()     // Catch:{ Throwable -> 0x017c }
        L_0x019f:
            r24 = r3
            r3 = r4
            goto L_0x0094
        L_0x01a4:
            boolean r2 = r3.f6020c     // Catch:{ Throwable -> 0x00ed }
            if (r2 != 0) goto L_0x01f2
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + -1
            r3.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            r2 = 1
            r3.f6020c = r2     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ao r2 = r3.mo18692a()     // Catch:{ Throwable -> 0x00ed }
            r4 = 0
            r3.f6020c = r4     // Catch:{ Throwable -> 0x00ed }
            r4 = 0
            r2.f6018a = r4     // Catch:{ Throwable -> 0x00ed }
            r4 = 0
            r2.f6019b = r4     // Catch:{ Throwable -> 0x00ed }
            r4 = 1
            r2.f6020c = r4     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.bm r4 = new org.mozilla.javascript.bm     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r5 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.am r6 = r2.f6021d     // Catch:{ Throwable -> 0x00ed }
            r4.<init>(r5, r6, r2)     // Catch:{ Throwable -> 0x00ed }
            r3.f6033p = r4     // Catch:{ Throwable -> 0x00ed }
        L_0x01cc:
            r2 = 0
            r0 = r36
            m5756b(r0, r3, r2)     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object r2 = r3.f6033p     // Catch:{ Throwable -> 0x00ed }
            double r4 = r3.f6034q     // Catch:{ Throwable -> 0x0e7a }
            org.mozilla.javascript.ao r6 = r3.f6018a     // Catch:{ Throwable -> 0x0e41 }
            if (r6 == 0) goto L_0x0d6b
            org.mozilla.javascript.ao r6 = r3.f6018a     // Catch:{ Throwable -> 0x0e41 }
            boolean r3 = r6.f6020c     // Catch:{ Throwable -> 0x0e49 }
            if (r3 == 0) goto L_0x01e4
            org.mozilla.javascript.ao r6 = r6.mo18692a()     // Catch:{ Throwable -> 0x0e49 }
        L_0x01e4:
            m5745a(r6, r2, r4)     // Catch:{ Throwable -> 0x0e49 }
            r25 = 0
            r26 = r4
            r7 = r28
            r3 = r24
            r4 = r6
            goto L_0x004f
        L_0x01f2:
            boolean r2 = r3.f6020c     // Catch:{ Throwable -> 0x00ed }
            if (r2 != 0) goto L_0x022e
            r0 = r38
            int r2 = r0.f6046a     // Catch:{ Throwable -> 0x00ed }
            r4 = 2
            if (r2 != r4) goto L_0x0204
            java.lang.String r2 = "msg.yield.closing"
            org.mozilla.javascript.w r2 = org.mozilla.javascript.ScriptRuntime.m6455g(r2)     // Catch:{ Throwable -> 0x00ed }
            throw r2     // Catch:{ Throwable -> 0x00ed }
        L_0x0204:
            r2 = 1
            r3.f6020c = r2     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object[] r2 = r3.f6023f     // Catch:{ Throwable -> 0x00ed }
            r2 = r2[r7]     // Catch:{ Throwable -> 0x00ed }
            r3.f6033p = r2     // Catch:{ Throwable -> 0x00ed }
            double[] r2 = r3.f6025h     // Catch:{ Throwable -> 0x00ed }
            r4 = r2[r7]     // Catch:{ Throwable -> 0x00ed }
            r3.f6034q = r4     // Catch:{ Throwable -> 0x00ed }
            r3.f6039v = r7     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + -1
            r3.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ScriptRuntime.m6443e(r36)     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object r2 = r3.f6033p     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ek r4 = org.mozilla.javascript.UniqueTag.f6692c     // Catch:{ Throwable -> 0x00ed }
            if (r2 == r4) goto L_0x0227
            java.lang.Object r3 = r3.f6033p     // Catch:{ Throwable -> 0x00ed }
        L_0x0226:
            return r3
        L_0x0227:
            double r4 = r3.f6034q     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r3 = org.mozilla.javascript.ScriptRuntime.m6313a(r4)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x0226
        L_0x022e:
            r2 = 0
            r3.f6020c = r2     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ar r2 = r3.f6022e     // Catch:{ Throwable -> 0x00ed }
            byte[] r2 = r2.f6060i     // Catch:{ Throwable -> 0x00ed }
            int r8 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r8 = m5755b(r2, r8)     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 2
            r3.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            r0 = r38
            int r2 = r0.f6046a     // Catch:{ Throwable -> 0x00ed }
            r9 = 1
            if (r2 != r9) goto L_0x02bc
            org.mozilla.javascript.aw r2 = new org.mozilla.javascript.aw     // Catch:{ Throwable -> 0x00ed }
            r0 = r38
            java.lang.Object r9 = r0.f6047b     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ar r10 = r3.f6022e     // Catch:{ Throwable -> 0x00ed }
            java.lang.String r10 = r10.f6053b     // Catch:{ Throwable -> 0x00ed }
            r2.<init>(r9, r10, r8)     // Catch:{ Throwable -> 0x00ed }
        L_0x0255:
            java.lang.Object r8 = org.mozilla.javascript.Scriptable.f6533j     // Catch:{ Throwable -> 0x00ed }
            if (r2 == r8) goto L_0x00bd
            r4 = r26
            r6 = r25
            r17 = r3
            r3 = r2
        L_0x0260:
            if (r3 != 0) goto L_0x0265
            org.mozilla.javascript.Kit.m5810a()
        L_0x0265:
            r7 = 0
            if (r38 == 0) goto L_0x0275
            r0 = r38
            int r2 = r0.f6046a
            r8 = 2
            if (r2 != r8) goto L_0x0275
            r0 = r38
            java.lang.Object r2 = r0.f6047b
            if (r3 == r2) goto L_0x0dee
        L_0x0275:
            boolean r2 = r3 instanceof org.mozilla.javascript.JavaScriptException
            if (r2 == 0) goto L_0x0d99
            r2 = 2
        L_0x027a:
            r34 = r7
            r7 = r2
            r2 = r34
        L_0x027f:
            if (r23 == 0) goto L_0x0ec0
            r8 = 100
            r0 = r36
            r1 = r17
            m5747a(r0, r1, r8)     // Catch:{ RuntimeException -> 0x0df1, Error -> 0x0df8 }
            r8 = r7
            r7 = r2
        L_0x028c:
            if (r8 == 0) goto L_0x029a
            r2 = 2
            if (r8 == r2) goto L_0x0e00
            r2 = 1
        L_0x0292:
            r0 = r17
            int r14 = m5726a(r0, r2)
            if (r14 >= 0) goto L_0x0eb6
        L_0x029a:
            r0 = r36
            r1 = r17
            m5756b(r0, r1, r3)
            r0 = r17
            org.mozilla.javascript.ao r0 = r0.f6018a
            r17 = r0
            if (r17 == 0) goto L_0x0e03
            if (r7 == 0) goto L_0x028c
            org.mozilla.javascript.ao r2 = r7.f6043b
            r0 = r17
            if (r2 != r0) goto L_0x028c
            r14 = -1
            r26 = r4
            r25 = r6
            r7 = r28
            r4 = r17
            goto L_0x004f
        L_0x02bc:
            r0 = r38
            int r2 = r0.f6046a     // Catch:{ Throwable -> 0x00ed }
            r8 = 2
            if (r2 != r8) goto L_0x02c8
            r0 = r38
            java.lang.Object r2 = r0.f6047b     // Catch:{ Throwable -> 0x00ed }
            goto L_0x0255
        L_0x02c8:
            r0 = r38
            int r2 = r0.f6046a     // Catch:{ Throwable -> 0x00ed }
            if (r2 == 0) goto L_0x02d3
            java.lang.RuntimeException r2 = org.mozilla.javascript.Kit.m5810a()     // Catch:{ Throwable -> 0x00ed }
            throw r2     // Catch:{ Throwable -> 0x00ed }
        L_0x02d3:
            r2 = 72
            r0 = r18
            if (r0 != r2) goto L_0x02e1
            java.lang.Object[] r2 = r3.f6023f     // Catch:{ Throwable -> 0x00ed }
            r0 = r38
            java.lang.Object r8 = r0.f6047b     // Catch:{ Throwable -> 0x00ed }
            r2[r7] = r8     // Catch:{ Throwable -> 0x00ed }
        L_0x02e1:
            java.lang.Object r2 = org.mozilla.javascript.Scriptable.f6533j     // Catch:{ Throwable -> 0x00ed }
            goto L_0x0255
        L_0x02e5:
            r2 = 1
            r3.f6020c = r2     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = m5755b(r4, r2)     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.aw r4 = new org.mozilla.javascript.aw     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r5 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object r5 = org.mozilla.javascript.NativeIterator.m6064a(r5)     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ar r6 = r3.f6022e     // Catch:{ Throwable -> 0x00ed }
            java.lang.String r6 = r6.f6053b     // Catch:{ Throwable -> 0x00ed }
            r4.<init>(r5, r6, r2)     // Catch:{ Throwable -> 0x00ed }
            r0 = r38
            r0.f6048c = r4     // Catch:{ Throwable -> 0x00ed }
            goto L_0x01cc
        L_0x0303:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x030f
            r6 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r6)     // Catch:{ Throwable -> 0x00ed }
        L_0x030f:
            int r5 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r5 = m5755b(r4, r5)     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.aw r4 = new org.mozilla.javascript.aw     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ar r6 = r3.f6022e     // Catch:{ Throwable -> 0x00ed }
            java.lang.String r6 = r6.f6053b     // Catch:{ Throwable -> 0x00ed }
            r4.<init>(r2, r6, r5)     // Catch:{ Throwable -> 0x00ed }
            r6 = r25
            r17 = r3
            r3 = r4
            r4 = r26
            goto L_0x0260
        L_0x0327:
            int r2 = r3.f6027j     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + r14
            r2 = r5[r2]     // Catch:{ Throwable -> 0x00ed }
            r4 = r26
            r6 = r25
            r17 = r3
            r3 = r2
            goto L_0x0260
        L_0x0335:
            r0 = r18
            int r7 = m5725a(r3, r0, r5, r6, r7)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x033d:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ek r8 = org.mozilla.javascript.UniqueTag.f6692c     // Catch:{ Throwable -> 0x00ed }
            if (r2 != r8) goto L_0x0ea7
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
            r8 = r2
        L_0x034a:
            int r7 = r7 + -1
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ek r9 = org.mozilla.javascript.UniqueTag.f6692c     // Catch:{ Throwable -> 0x00ed }
            if (r2 != r9) goto L_0x0358
            r10 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r10)     // Catch:{ Throwable -> 0x00ed }
        L_0x0358:
            r9 = 52
            r0 = r18
            if (r0 != r9) goto L_0x036c
            r0 = r36
            boolean r2 = org.mozilla.javascript.ScriptRuntime.m6418b(r2, r8, r0)     // Catch:{ Throwable -> 0x00ed }
        L_0x0364:
            java.lang.Boolean r2 = org.mozilla.javascript.ScriptRuntime.m6312a(r2)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x036c:
            boolean r2 = org.mozilla.javascript.ScriptRuntime.m6439d(r2, r8)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x0364
        L_0x0371:
            int r8 = r7 + -1
            int r2 = r8 + 1
            r2 = r5[r2]     // Catch:{ Throwable -> 0x00ed }
            r7 = r5[r8]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ek r9 = org.mozilla.javascript.UniqueTag.f6692c     // Catch:{ Throwable -> 0x00ed }
            if (r2 != r9) goto L_0x03ab
            org.mozilla.javascript.ek r2 = org.mozilla.javascript.UniqueTag.f6692c     // Catch:{ Throwable -> 0x00ed }
            if (r7 != r2) goto L_0x03a1
            r10 = r6[r8]     // Catch:{ Throwable -> 0x00ed }
            int r2 = r8 + 1
            r12 = r6[r2]     // Catch:{ Throwable -> 0x00ed }
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x039e
            r2 = 1
            r7 = r2
        L_0x038d:
            r2 = 13
            r0 = r18
            if (r0 != r2) goto L_0x03bd
            r2 = 1
        L_0x0394:
            r2 = r2 ^ r7
            java.lang.Boolean r2 = org.mozilla.javascript.ScriptRuntime.m6312a(r2)     // Catch:{ Throwable -> 0x00ed }
            r5[r8] = r2     // Catch:{ Throwable -> 0x00ed }
            r7 = r8
            goto L_0x00bd
        L_0x039e:
            r2 = 0
            r7 = r2
            goto L_0x038d
        L_0x03a1:
            int r2 = r8 + 1
            r10 = r6[r2]     // Catch:{ Throwable -> 0x00ed }
            boolean r2 = org.mozilla.javascript.ScriptRuntime.m6388a(r10, r7)     // Catch:{ Throwable -> 0x00ed }
            r7 = r2
            goto L_0x038d
        L_0x03ab:
            org.mozilla.javascript.ek r9 = org.mozilla.javascript.UniqueTag.f6692c     // Catch:{ Throwable -> 0x00ed }
            if (r7 != r9) goto L_0x03b7
            r10 = r6[r8]     // Catch:{ Throwable -> 0x00ed }
            boolean r2 = org.mozilla.javascript.ScriptRuntime.m6388a(r10, r2)     // Catch:{ Throwable -> 0x00ed }
            r7 = r2
            goto L_0x038d
        L_0x03b7:
            boolean r2 = org.mozilla.javascript.ScriptRuntime.m6417b(r7, r2)     // Catch:{ Throwable -> 0x00ed }
            r7 = r2
            goto L_0x038d
        L_0x03bd:
            r2 = 0
            goto L_0x0394
        L_0x03bf:
            int r7 = r7 + -1
            boolean r8 = m5757b(r5, r6, r7)     // Catch:{ Throwable -> 0x00ed }
            r2 = 47
            r0 = r18
            if (r0 != r2) goto L_0x03d5
            r2 = 1
        L_0x03cc:
            r2 = r2 ^ r8
            java.lang.Boolean r2 = org.mozilla.javascript.ScriptRuntime.m6312a(r2)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x03d5:
            r2 = 0
            goto L_0x03cc
        L_0x03d7:
            int r2 = r7 + -1
            boolean r7 = m5762c(r3, r7)     // Catch:{ Throwable -> 0x00ed }
            if (r7 == 0) goto L_0x0ea4
            int r7 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r7 = r7 + 2
            r3.f6035r = r7     // Catch:{ Throwable -> 0x00ed }
            r7 = r2
            goto L_0x00bd
        L_0x03e8:
            int r2 = r7 + -1
            boolean r7 = m5762c(r3, r7)     // Catch:{ Throwable -> 0x00ed }
            if (r7 != 0) goto L_0x0ea4
            int r7 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r7 = r7 + 2
            r3.f6035r = r7     // Catch:{ Throwable -> 0x00ed }
            r7 = r2
            goto L_0x00bd
        L_0x03f9:
            int r2 = r7 + -1
            boolean r7 = m5762c(r3, r7)     // Catch:{ Throwable -> 0x00ed }
            if (r7 != 0) goto L_0x040a
            int r7 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r7 = r7 + 2
            r3.f6035r = r7     // Catch:{ Throwable -> 0x00ed }
            r7 = r2
            goto L_0x00bd
        L_0x040a:
            int r7 = r2 + -1
            r8 = 0
            r5[r2] = r8     // Catch:{ Throwable -> 0x00ed }
            r8 = r7
        L_0x0410:
            if (r23 == 0) goto L_0x0418
            r2 = 2
            r0 = r36
            m5747a(r0, r3, r2)     // Catch:{ Throwable -> 0x00ed }
        L_0x0418:
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = m5735a(r4, r2)     // Catch:{ Throwable -> 0x00ed }
            if (r2 == 0) goto L_0x0d41
            int r7 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + -1
            int r2 = r2 + r7
            r7 = r3
        L_0x0426:
            r7.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            if (r23 == 0) goto L_0x0e88
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            r3.f6036s = r2     // Catch:{ Throwable -> 0x00ed }
            r7 = r8
            goto L_0x00bd
        L_0x0431:
            r8 = r7
            goto L_0x0410
        L_0x0433:
            int r7 = r7 + 1
            r5[r7] = r29     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 2
            double r8 = (double) r2     // Catch:{ Throwable -> 0x00ed }
            r6[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            r8 = r7
            goto L_0x0410
        L_0x0440:
            int r2 = r3.f6028k     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 1
            if (r7 != r2) goto L_0x0455
            int r2 = r3.f6027j     // Catch:{ Throwable -> 0x00ed }
            int r14 = r14 + r2
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r5[r14] = r2     // Catch:{ Throwable -> 0x00ed }
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            r6[r14] = r8     // Catch:{ Throwable -> 0x00ed }
            int r7 = r7 + -1
            goto L_0x00bd
        L_0x0455:
            int r2 = r3.f6028k     // Catch:{ Throwable -> 0x00ed }
            if (r7 == r2) goto L_0x00bd
            org.mozilla.javascript.Kit.m5810a()     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x045e:
            if (r23 == 0) goto L_0x0466
            r2 = 0
            r0 = r36
            m5747a(r0, r3, r2)     // Catch:{ Throwable -> 0x00ed }
        L_0x0466:
            int r2 = r3.f6027j     // Catch:{ Throwable -> 0x00ed }
            int r14 = r14 + r2
            r2 = r5[r14]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 == r0) goto L_0x0478
            r4 = r26
            r6 = r25
            r17 = r3
            r3 = r2
            goto L_0x0260
        L_0x0478:
            r8 = r6[r14]     // Catch:{ Throwable -> 0x00ed }
            int r2 = (int) r8     // Catch:{ Throwable -> 0x00ed }
            r3.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            if (r23 == 0) goto L_0x00bd
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            r3.f6036s = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0485:
            r2 = 0
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            int r7 = r7 + -1
            goto L_0x00bd
        L_0x048c:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r3.f6033p = r2     // Catch:{ Throwable -> 0x00ed }
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            r3.f6034q = r8     // Catch:{ Throwable -> 0x00ed }
            r2 = 0
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            int r7 = r7 + -1
            goto L_0x00bd
        L_0x049b:
            int r2 = r7 + 1
            r8 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r5[r2] = r8     // Catch:{ Throwable -> 0x00ed }
            int r2 = r7 + 1
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            r6[r2] = r8     // Catch:{ Throwable -> 0x00ed }
            int r7 = r7 + 1
            goto L_0x00bd
        L_0x04ab:
            int r2 = r7 + 1
            int r8 = r7 + -1
            r8 = r5[r8]     // Catch:{ Throwable -> 0x00ed }
            r5[r2] = r8     // Catch:{ Throwable -> 0x00ed }
            int r2 = r7 + 1
            int r8 = r7 + -1
            r8 = r6[r8]     // Catch:{ Throwable -> 0x00ed }
            r6[r2] = r8     // Catch:{ Throwable -> 0x00ed }
            int r2 = r7 + 2
            r8 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r5[r2] = r8     // Catch:{ Throwable -> 0x00ed }
            int r2 = r7 + 2
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            r6[r2] = r8     // Catch:{ Throwable -> 0x00ed }
            int r7 = r7 + 2
            goto L_0x00bd
        L_0x04cb:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            int r8 = r7 + -1
            r8 = r5[r8]     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            int r8 = r7 + -1
            r5[r8] = r2     // Catch:{ Throwable -> 0x00ed }
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            int r2 = r7 + -1
            r10 = r6[r2]     // Catch:{ Throwable -> 0x00ed }
            r6[r7] = r10     // Catch:{ Throwable -> 0x00ed }
            int r2 = r7 + -1
            r6[r2] = r8     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x04e5:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r3.f6033p = r2     // Catch:{ Throwable -> 0x00ed }
            r4 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            r3.f6034q = r4     // Catch:{ Throwable -> 0x00ed }
            goto L_0x01cc
        L_0x04ef:
            r0 = r30
            r3.f6033p = r0     // Catch:{ Throwable -> 0x00ed }
            goto L_0x01cc
        L_0x04f5:
            int r2 = m5724a(r3, r7)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r29     // Catch:{ Throwable -> 0x00ed }
            r2 = r2 ^ -1
            double r8 = (double) r2     // Catch:{ Throwable -> 0x00ed }
            r6[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0502:
            r0 = r18
            int r7 = m5752b(r3, r0, r5, r6, r7)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x050a:
            int r2 = r7 + -1
            double r8 = m5751b(r3, r2)     // Catch:{ Throwable -> 0x00ed }
            int r2 = m5724a(r3, r7)     // Catch:{ Throwable -> 0x00ed }
            r2 = r2 & 31
            int r7 = r7 + -1
            r5[r7] = r29     // Catch:{ Throwable -> 0x00ed }
            long r8 = org.mozilla.javascript.ScriptRuntime.m6441e(r8)     // Catch:{ Throwable -> 0x00ed }
            long r8 = r8 >>> r2
            double r8 = (double) r8     // Catch:{ Throwable -> 0x00ed }
            r6[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0524:
            double r8 = m5751b(r3, r7)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r29     // Catch:{ Throwable -> 0x00ed }
            r2 = 29
            r0 = r18
            if (r0 != r2) goto L_0x0531
            double r8 = -r8
        L_0x0531:
            r6[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0535:
            int r7 = r7 + -1
            m5761c(r5, r6, r7)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x053c:
            r0 = r18
            int r7 = m5759c(r3, r0, r5, r6, r7)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0544:
            boolean r2 = m5762c(r3, r7)     // Catch:{ Throwable -> 0x00ed }
            if (r2 != 0) goto L_0x0553
            r2 = 1
        L_0x054b:
            java.lang.Boolean r2 = org.mozilla.javascript.ScriptRuntime.m6312a(r2)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0553:
            r2 = 0
            goto L_0x054b
        L_0x0555:
            int r7 = r7 + 1
            org.mozilla.javascript.dr r2 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            r0 = r36
            r1 = r28
            org.mozilla.javascript.dr r2 = org.mozilla.javascript.ScriptRuntime.m6411b(r0, r2, r1)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0565:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x0ea1
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
            r8 = r2
        L_0x0572:
            int r7 = r7 + -1
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r2 = (org.mozilla.javascript.Scriptable) r2     // Catch:{ Throwable -> 0x00ed }
            r9 = 8
            r0 = r18
            if (r0 != r9) goto L_0x058c
            org.mozilla.javascript.dr r9 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            r0 = r36
            r1 = r28
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6334a(r2, r8, r0, r9, r1)     // Catch:{ Throwable -> 0x00ed }
        L_0x0588:
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x058c:
            r0 = r28
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6333a(r2, r8, r0)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x0588
        L_0x0593:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x0e9e
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
            r8 = r2
        L_0x05a0:
            int r7 = r7 + -1
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r2 = (org.mozilla.javascript.Scriptable) r2     // Catch:{ Throwable -> 0x00ed }
            r0 = r28
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6399b(r2, r8, r0)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x05b0:
            r0 = r36
            r1 = r18
            int r7 = m5729a(r0, r1, r5, r6, r7)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x05ba:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x05c6
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
        L_0x05c6:
            r0 = r28
            r1 = r36
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6323a(r2, r0, r1)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x05d2:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x05de
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
        L_0x05de:
            org.mozilla.javascript.dr r8 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            r0 = r28
            r1 = r36
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6325a(r2, r0, r1, r8)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x05ec:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x0e9b
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
            r8 = r2
        L_0x05f9:
            int r7 = r7 + -1
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x0607
            r10 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r10)     // Catch:{ Throwable -> 0x00ed }
        L_0x0607:
            r0 = r28
            r1 = r36
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6322a(r2, r0, r8, r1)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0613:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x061f
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
        L_0x061f:
            int r8 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            byte r8 = r4[r8]     // Catch:{ Throwable -> 0x00ed }
            r0 = r28
            r1 = r36
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6324a(r2, r0, r1, r8)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 1
            r3.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0635:
            r0 = r36
            int r7 = m5731a(r0, r3, r5, r6, r7)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x063d:
            r0 = r36
            int r7 = m5734a(r0, r5, r6, r7)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0645:
            r2 = r36
            int r7 = m5730a(r2, r3, r4, r5, r6, r7)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x064d:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dd r2 = (org.mozilla.javascript.Ref) r2     // Catch:{ Throwable -> 0x00ed }
            r0 = r36
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6329a(r2, r0)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x065b:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x0e98
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
            r8 = r2
        L_0x0668:
            int r7 = r7 + -1
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dd r2 = (org.mozilla.javascript.Ref) r2     // Catch:{ Throwable -> 0x00ed }
            r0 = r36
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6328a(r2, r8, r0)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0678:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dd r2 = (org.mozilla.javascript.Ref) r2     // Catch:{ Throwable -> 0x00ed }
            r0 = r36
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6398b(r2, r0)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0686:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dd r2 = (org.mozilla.javascript.Ref) r2     // Catch:{ Throwable -> 0x00ed }
            int r8 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            byte r8 = r4[r8]     // Catch:{ Throwable -> 0x00ed }
            r0 = r36
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6330a(r2, r0, r8)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 1
            r3.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x069e:
            int r7 = r7 + 1
            int r2 = r3.f6027j     // Catch:{ Throwable -> 0x00ed }
            int r14 = r14 + r2
            r2 = r5[r14]     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            r8 = r6[r14]     // Catch:{ Throwable -> 0x00ed }
            r6[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x06ad:
            int r2 = r3.f6027j     // Catch:{ Throwable -> 0x00ed }
            int r14 = r14 + r2
            r2 = 0
            r5[r14] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x06b5:
            int r2 = r7 + 1
            org.mozilla.javascript.dr r7 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            r0 = r28
            r1 = r36
            org.mozilla.javascript.e r7 = org.mozilla.javascript.ScriptRuntime.m6374a(r0, r1, r7)     // Catch:{ Throwable -> 0x00ed }
            r5[r2] = r7     // Catch:{ Throwable -> 0x00ed }
            int r7 = r2 + 1
            org.mozilla.javascript.dr r2 = org.mozilla.javascript.ScriptRuntime.m6470m(r36)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x06cd:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x06d9
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
        L_0x06d9:
            org.mozilla.javascript.dr r8 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            r0 = r28
            r1 = r36
            org.mozilla.javascript.e r2 = org.mozilla.javascript.ScriptRuntime.m6412b(r2, r0, r1, r8)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            int r7 = r7 + 1
            org.mozilla.javascript.dr r2 = org.mozilla.javascript.ScriptRuntime.m6470m(r36)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x06ef:
            int r2 = r7 + -1
            r2 = r5[r2]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x0e95
            int r2 = r7 + -1
            r8 = r6[r2]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
            r8 = r2
        L_0x0700:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x070c
            r10 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r10)     // Catch:{ Throwable -> 0x00ed }
        L_0x070c:
            int r9 = r7 + -1
            r0 = r36
            org.mozilla.javascript.e r2 = org.mozilla.javascript.ScriptRuntime.m6373a(r8, r2, r0)     // Catch:{ Throwable -> 0x00ed }
            r5[r9] = r2     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r2 = org.mozilla.javascript.ScriptRuntime.m6470m(r36)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x071e:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x072a
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
        L_0x072a:
            r0 = r36
            org.mozilla.javascript.e r2 = org.mozilla.javascript.ScriptRuntime.m6413b(r2, r0)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            int r7 = r7 + 1
            org.mozilla.javascript.dr r2 = org.mozilla.javascript.ScriptRuntime.m6470m(r36)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x073c:
            if (r23 == 0) goto L_0x0748
            r0 = r36
            int r2 = r0.f6797u     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 100
            r0 = r36
            r0.f6797u = r2     // Catch:{ Throwable -> 0x00ed }
        L_0x0748:
            r8 = r36
            r9 = r3
            r10 = r5
            r11 = r6
            r12 = r7
            r13 = r4
            int r7 = m5732a(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0755:
            if (r23 == 0) goto L_0x0761
            r0 = r36
            int r2 = r0.f6797u     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 100
            r0 = r36
            r0.f6797u = r2     // Catch:{ Throwable -> 0x00ed }
        L_0x0761:
            int r2 = r14 + 1
            int r7 = r7 - r2
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.e r2 = (org.mozilla.javascript.Callable) r2     // Catch:{ Throwable -> 0x00ed }
            int r8 = r7 + 1
            r10 = r5[r8]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r10 = (org.mozilla.javascript.Scriptable) r10     // Catch:{ Throwable -> 0x00ed }
            r8 = 70
            r0 = r18
            if (r0 != r8) goto L_0x0781
            int r8 = r7 + 2
            m5750a(r5, r6, r8, r14)     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dd r2 = org.mozilla.javascript.ScriptRuntime.m6360a(r2)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0781:
            org.mozilla.javascript.dr r9 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            boolean r8 = r3.f6030m     // Catch:{ Throwable -> 0x00ed }
            if (r8 == 0) goto L_0x078d
            org.mozilla.javascript.dr r8 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r9 = org.mozilla.javascript.ScriptableObject.getTopLevelScope(r8)     // Catch:{ Throwable -> 0x00ed }
        L_0x078d:
            boolean r8 = r2 instanceof org.mozilla.javascript.InterpretedFunction     // Catch:{ Throwable -> 0x00ed }
            if (r8 == 0) goto L_0x07d2
            r0 = r2
            org.mozilla.javascript.am r0 = (org.mozilla.javascript.InterpretedFunction) r0     // Catch:{ Throwable -> 0x00ed }
            r15 = r0
            org.mozilla.javascript.am r8 = r3.f6021d     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object r8 = r8.f6016c     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object r11 = r15.f6016c     // Catch:{ Throwable -> 0x00ed }
            if (r8 != r11) goto L_0x07d2
            org.mozilla.javascript.ao r17 = new org.mozilla.javascript.ao     // Catch:{ Throwable -> 0x00ed }
            r2 = 0
            r0 = r17
            r0.<init>(r2)     // Catch:{ Throwable -> 0x00ed }
            r2 = -55
            r0 = r18
            if (r0 != r2) goto L_0x0e91
            org.mozilla.javascript.ao r0 = r3.f6018a     // Catch:{ Throwable -> 0x00ed }
            r16 = r0
            r2 = 0
            r0 = r36
            m5756b(r0, r3, r2)     // Catch:{ Throwable -> 0x00ed }
        L_0x07b5:
            int r13 = r7 + 2
            r8 = r36
            r11 = r5
            r12 = r6
            m5749a(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Throwable -> 0x00ed }
            r2 = -55
            r0 = r18
            if (r0 == r2) goto L_0x07ca
            r3.f6039v = r7     // Catch:{ Throwable -> 0x00ed }
            r0 = r18
            r3.f6040w = r0     // Catch:{ Throwable -> 0x00ed }
        L_0x07ca:
            r7 = r28
            r3 = r24
            r4 = r17
            goto L_0x004f
        L_0x07d2:
            boolean r8 = r2 instanceof org.mozilla.javascript.NativeContinuation     // Catch:{ Throwable -> 0x00ed }
            if (r8 == 0) goto L_0x07f9
            org.mozilla.javascript.ap r4 = new org.mozilla.javascript.ap     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.bi r2 = (org.mozilla.javascript.NativeContinuation) r2     // Catch:{ Throwable -> 0x00ed }
            r4.<init>(r2, r3)     // Catch:{ Throwable -> 0x00ed }
            if (r14 != 0) goto L_0x07ec
            r0 = r30
            r4.f6044c = r0     // Catch:{ Throwable -> 0x00ed }
        L_0x07e3:
            r6 = r25
            r17 = r3
            r3 = r4
            r4 = r26
            goto L_0x0260
        L_0x07ec:
            int r2 = r7 + 2
            r2 = r5[r2]     // Catch:{ Throwable -> 0x00ed }
            r4.f6044c = r2     // Catch:{ Throwable -> 0x00ed }
            int r2 = r7 + 2
            r6 = r6[r2]     // Catch:{ Throwable -> 0x00ed }
            r4.f6045d = r6     // Catch:{ Throwable -> 0x00ed }
            goto L_0x07e3
        L_0x07f9:
            boolean r8 = r2 instanceof org.mozilla.javascript.IdFunctionObject     // Catch:{ Throwable -> 0x00ed }
            if (r8 == 0) goto L_0x083f
            r0 = r2
            org.mozilla.javascript.ah r0 = (org.mozilla.javascript.IdFunctionObject) r0     // Catch:{ Throwable -> 0x00ed }
            r12 = r0
            boolean r8 = org.mozilla.javascript.NativeContinuation.m6004a(r12)     // Catch:{ Throwable -> 0x00ed }
            if (r8 == 0) goto L_0x0815
            java.lang.Object[] r2 = r3.f6023f     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ao r8 = r3.f6018a     // Catch:{ Throwable -> 0x00ed }
            r0 = r36
            org.mozilla.javascript.bi r8 = m5744a(r0, r8)     // Catch:{ Throwable -> 0x00ed }
            r2[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0815:
            boolean r8 = org.mozilla.javascript.BaseFunction.isApplyOrCall(r12)     // Catch:{ Throwable -> 0x00ed }
            if (r8 == 0) goto L_0x083f
            org.mozilla.javascript.e r11 = org.mozilla.javascript.ScriptRuntime.m6428c(r10)     // Catch:{ Throwable -> 0x00ed }
            boolean r8 = r11 instanceof org.mozilla.javascript.InterpretedFunction     // Catch:{ Throwable -> 0x00ed }
            if (r8 == 0) goto L_0x083f
            org.mozilla.javascript.am r11 = (org.mozilla.javascript.InterpretedFunction) r11     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.am r8 = r3.f6021d     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object r8 = r8.f6016c     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object r13 = r11.f6016c     // Catch:{ Throwable -> 0x00ed }
            if (r8 != r13) goto L_0x083f
            r2 = r36
            r4 = r14
            r8 = r18
            r10 = r12
            org.mozilla.javascript.ao r17 = m5742a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Throwable -> 0x00ed }
            r7 = r28
            r3 = r24
            r4 = r17
            goto L_0x004f
        L_0x083f:
            boolean r8 = r2 instanceof org.mozilla.javascript.C2178dp     // Catch:{ Throwable -> 0x00ed }
            if (r8 == 0) goto L_0x0878
            r0 = r2
            org.mozilla.javascript.dp r0 = (org.mozilla.javascript.C2178dp) r0     // Catch:{ Throwable -> 0x00ed }
            r21 = r0
            r0 = r21
            org.mozilla.javascript.e r0 = r0.f6529b     // Catch:{ Throwable -> 0x00ed }
            r22 = r0
            r0 = r22
            boolean r8 = r0 instanceof org.mozilla.javascript.InterpretedFunction     // Catch:{ Throwable -> 0x00ed }
            if (r8 == 0) goto L_0x0878
            org.mozilla.javascript.am r22 = (org.mozilla.javascript.InterpretedFunction) r22     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.am r8 = r3.f6021d     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object r8 = r8.f6016c     // Catch:{ Throwable -> 0x00ed }
            r0 = r22
            java.lang.Object r11 = r0.f6016c     // Catch:{ Throwable -> 0x00ed }
            if (r8 != r11) goto L_0x0878
            r12 = r36
            r13 = r3
            r15 = r5
            r16 = r6
            r17 = r7
            r19 = r10
            r20 = r9
            org.mozilla.javascript.ao r17 = m5743a(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Throwable -> 0x00ed }
            r7 = r28
            r3 = r24
            r4 = r17
            goto L_0x004f
        L_0x0878:
            r0 = r36
            r0.f6795s = r3     // Catch:{ Throwable -> 0x00ed }
            r0 = r18
            r3.f6040w = r0     // Catch:{ Throwable -> 0x00ed }
            r3.f6039v = r7     // Catch:{ Throwable -> 0x00ed }
            int r8 = r7 + 2
            java.lang.Object[] r8 = m5750a(r5, r6, r8, r14)     // Catch:{ Throwable -> 0x00ed }
            r0 = r36
            java.lang.Object r2 = r2.call(r0, r9, r10, r8)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0892:
            if (r23 == 0) goto L_0x089e
            r0 = r36
            int r2 = r0.f6797u     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 100
            r0 = r36
            r0.f6797u = r2     // Catch:{ Throwable -> 0x00ed }
        L_0x089e:
            int r19 = r7 - r14
            r2 = r5[r19]     // Catch:{ Throwable -> 0x00ed }
            boolean r7 = r2 instanceof org.mozilla.javascript.InterpretedFunction     // Catch:{ Throwable -> 0x00ed }
            if (r7 == 0) goto L_0x08e1
            r0 = r2
            org.mozilla.javascript.am r0 = (org.mozilla.javascript.InterpretedFunction) r0     // Catch:{ Throwable -> 0x00ed }
            r15 = r0
            org.mozilla.javascript.am r7 = r3.f6021d     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object r7 = r7.f6016c     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object r8 = r15.f6016c     // Catch:{ Throwable -> 0x00ed }
            if (r7 != r8) goto L_0x08e1
            org.mozilla.javascript.dr r2 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            r0 = r36
            org.mozilla.javascript.dr r10 = r15.createObject(r0, r2)     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ao r17 = new org.mozilla.javascript.ao     // Catch:{ Throwable -> 0x00ed }
            r2 = 0
            r0 = r17
            r0.<init>(r2)     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r9 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            int r13 = r19 + 1
            r8 = r36
            r11 = r5
            r12 = r6
            r16 = r3
            m5749a(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Throwable -> 0x00ed }
            r5[r19] = r10     // Catch:{ Throwable -> 0x00ed }
            r0 = r19
            r3.f6039v = r0     // Catch:{ Throwable -> 0x00ed }
            r0 = r18
            r3.f6040w = r0     // Catch:{ Throwable -> 0x00ed }
            r7 = r28
            r3 = r24
            r4 = r17
            goto L_0x004f
        L_0x08e1:
            boolean r7 = r2 instanceof org.mozilla.javascript.Function     // Catch:{ Throwable -> 0x00ed }
            if (r7 != 0) goto L_0x08f4
            r0 = r29
            if (r2 != r0) goto L_0x08ef
            r4 = r6[r19]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r4)     // Catch:{ Throwable -> 0x00ed }
        L_0x08ef:
            java.lang.RuntimeException r2 = org.mozilla.javascript.ScriptRuntime.m6474o(r2)     // Catch:{ Throwable -> 0x00ed }
            throw r2     // Catch:{ Throwable -> 0x00ed }
        L_0x08f4:
            org.mozilla.javascript.ab r2 = (org.mozilla.javascript.Function) r2     // Catch:{ Throwable -> 0x00ed }
            boolean r7 = r2 instanceof org.mozilla.javascript.IdFunctionObject     // Catch:{ Throwable -> 0x00ed }
            if (r7 == 0) goto L_0x0914
            r0 = r2
            org.mozilla.javascript.ah r0 = (org.mozilla.javascript.IdFunctionObject) r0     // Catch:{ Throwable -> 0x00ed }
            r7 = r0
            boolean r7 = org.mozilla.javascript.NativeContinuation.m6004a(r7)     // Catch:{ Throwable -> 0x00ed }
            if (r7 == 0) goto L_0x0914
            java.lang.Object[] r2 = r3.f6023f     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ao r7 = r3.f6018a     // Catch:{ Throwable -> 0x00ed }
            r0 = r36
            org.mozilla.javascript.bi r7 = m5744a(r0, r7)     // Catch:{ Throwable -> 0x00ed }
            r2[r19] = r7     // Catch:{ Throwable -> 0x00ed }
            r7 = r19
            goto L_0x00bd
        L_0x0914:
            int r7 = r19 + 1
            java.lang.Object[] r7 = m5750a(r5, r6, r7, r14)     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r8 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            r0 = r36
            org.mozilla.javascript.dr r2 = r2.construct(r0, r8, r7)     // Catch:{ Throwable -> 0x00ed }
            r5[r19] = r2     // Catch:{ Throwable -> 0x00ed }
            r7 = r19
            goto L_0x00bd
        L_0x0928:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x0934
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
        L_0x0934:
            java.lang.String r2 = org.mozilla.javascript.ScriptRuntime.m6469l(r2)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x093c:
            int r7 = r7 + 1
            org.mozilla.javascript.dr r2 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            r0 = r28
            java.lang.String r2 = org.mozilla.javascript.ScriptRuntime.m6405b(r2, r0)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x094a:
            int r7 = r7 + 1
            r5[r7] = r28     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0950:
            int r7 = r7 + 1
            r5[r7] = r29     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = m5735a(r4, r2)     // Catch:{ Throwable -> 0x00ed }
            double r8 = (double) r2     // Catch:{ Throwable -> 0x00ed }
            r6[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 2
            r3.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0965:
            int r7 = r7 + 1
            r5[r7] = r29     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = m5760c(r4, r2)     // Catch:{ Throwable -> 0x00ed }
            double r8 = (double) r2     // Catch:{ Throwable -> 0x00ed }
            r6[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 4
            r3.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x097a:
            int r7 = r7 + 1
            r5[r7] = r29     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ar r2 = r3.f6022e     // Catch:{ Throwable -> 0x00ed }
            double[] r2 = r2.f6057f     // Catch:{ Throwable -> 0x00ed }
            r8 = r2[r14]     // Catch:{ Throwable -> 0x00ed }
            r6[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0988:
            int r7 = r7 + 1
            org.mozilla.javascript.dr r2 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            r0 = r36
            r1 = r28
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6342a(r0, r2, r1)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0998:
            int r7 = r7 + 1
            org.mozilla.javascript.dr r2 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            int r8 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            byte r8 = r4[r8]     // Catch:{ Throwable -> 0x00ed }
            r0 = r28
            r1 = r36
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6338a(r2, r0, r1, r8)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 1
            r3.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x09b2:
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r8 = r2 + 1
            r3.f6035r = r8     // Catch:{ Throwable -> 0x00ed }
            byte r15 = r4[r2]     // Catch:{ Throwable -> 0x00ed }
        L_0x09ba:
            r8 = r3
            r9 = r5
            r10 = r6
            r11 = r7
            r12 = r20
            r13 = r31
            r14 = r32
            int r7 = m5728a(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Throwable -> 0x00ed }
            r14 = r15
            goto L_0x00bd
        L_0x09cb:
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r8 = r2 + 1
            r3.f6035r = r8     // Catch:{ Throwable -> 0x00ed }
            byte r15 = r4[r2]     // Catch:{ Throwable -> 0x00ed }
        L_0x09d3:
            r8 = r3
            r9 = r5
            r10 = r6
            r11 = r7
            r12 = r20
            r13 = r31
            r14 = r32
            int r7 = m5753b(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Throwable -> 0x00ed }
            r14 = r15
            goto L_0x00bd
        L_0x09e4:
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r8 = r2 + 1
            r3.f6035r = r8     // Catch:{ Throwable -> 0x00ed }
            byte r14 = r4[r2]     // Catch:{ Throwable -> 0x00ed }
        L_0x09ec:
            r8 = r3
            r9 = r5
            r10 = r6
            r11 = r7
            r12 = r20
            r13 = r31
            int r7 = m5727a(r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x09fa:
            r15 = r36
            r16 = r3
            r17 = r5
            r18 = r6
            r19 = r7
            r21 = r31
            r22 = r14
            int r7 = m5733a(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0a0e:
            int r7 = r7 + 1
            r5[r7] = r29     // Catch:{ Throwable -> 0x00ed }
            r8 = 0
            r6[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0a18:
            int r7 = r7 + 1
            r5[r7] = r29     // Catch:{ Throwable -> 0x00ed }
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r6[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0a22:
            int r7 = r7 + 1
            r2 = 0
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0a29:
            int r7 = r7 + 1
            org.mozilla.javascript.dr r2 = r3.f6032o     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0a31:
            int r7 = r7 + 1
            org.mozilla.javascript.am r2 = r3.f6021d     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0a39:
            int r7 = r7 + 1
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0a41:
            int r7 = r7 + 1
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0a49:
            int r7 = r7 + 1
            r5[r7] = r30     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0a4f:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x0a5b
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
        L_0x0a5b:
            int r7 = r7 + -1
            org.mozilla.javascript.dr r8 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            r0 = r36
            org.mozilla.javascript.dr r2 = org.mozilla.javascript.ScriptRuntime.m6361a(r2, r0, r8)     // Catch:{ Throwable -> 0x00ed }
            r3.f6038u = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0a69:
            org.mozilla.javascript.dr r2 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r2 = org.mozilla.javascript.ScriptRuntime.m6437d(r2)     // Catch:{ Throwable -> 0x00ed }
            r3.f6038u = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0a73:
            int r8 = r7 + -1
            int r2 = r3.f6027j     // Catch:{ Throwable -> 0x00ed }
            int r14 = r14 + r2
            org.mozilla.javascript.ar r2 = r3.f6022e     // Catch:{ Throwable -> 0x00ed }
            byte[] r2 = r2.f6060i     // Catch:{ Throwable -> 0x00ed }
            int r7 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            byte r2 = r2[r7]     // Catch:{ Throwable -> 0x00ed }
            if (r2 == 0) goto L_0x0aa2
            r2 = 1
            r7 = r2
        L_0x0a84:
            int r2 = r8 + 1
            r2 = r5[r2]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ Throwable -> 0x00ed }
            if (r7 != 0) goto L_0x0aa5
            r7 = 0
        L_0x0a8d:
            org.mozilla.javascript.dr r9 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            r0 = r28
            r1 = r36
            org.mozilla.javascript.dr r2 = org.mozilla.javascript.ScriptRuntime.m6362a(r2, r7, r0, r1, r9)     // Catch:{ Throwable -> 0x00ed }
            r5[r14] = r2     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 1
            r3.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            r7 = r8
            goto L_0x00bd
        L_0x0aa2:
            r2 = 0
            r7 = r2
            goto L_0x0a84
        L_0x0aa5:
            r7 = r5[r14]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r7 = (org.mozilla.javascript.Scriptable) r7     // Catch:{ Throwable -> 0x00ed }
            goto L_0x0a8d
        L_0x0aaa:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x0e8e
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
            r8 = r2
        L_0x0ab7:
            int r7 = r7 + -1
            int r2 = r3.f6027j     // Catch:{ Throwable -> 0x00ed }
            int r14 = r14 + r2
            r2 = 58
            r0 = r18
            if (r0 != r2) goto L_0x0acd
            r2 = 0
        L_0x0ac3:
            r0 = r36
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6327a(r8, r0, r2)     // Catch:{ Throwable -> 0x00ed }
            r5[r14] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0acd:
            r2 = 59
            r0 = r18
            if (r0 != r2) goto L_0x0ad5
            r2 = 1
            goto L_0x0ac3
        L_0x0ad5:
            r2 = 2
            goto L_0x0ac3
        L_0x0ad7:
            int r2 = r3.f6027j     // Catch:{ Throwable -> 0x00ed }
            int r14 = r14 + r2
            r2 = r5[r14]     // Catch:{ Throwable -> 0x00ed }
            int r7 = r7 + 1
            r8 = 61
            r0 = r18
            if (r0 != r8) goto L_0x0aec
            java.lang.Boolean r2 = org.mozilla.javascript.ScriptRuntime.m6464j(r2)     // Catch:{ Throwable -> 0x00ed }
        L_0x0ae8:
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0aec:
            r0 = r36
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6326a(r2, r0)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x0ae8
        L_0x0af3:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x0aff
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
        L_0x0aff:
            r0 = r28
            r1 = r36
            org.mozilla.javascript.dd r2 = org.mozilla.javascript.ScriptRuntime.m6408b(r2, r0, r1)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0b0b:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ek r8 = org.mozilla.javascript.UniqueTag.f6692c     // Catch:{ Throwable -> 0x00ed }
            if (r2 != r8) goto L_0x0b16
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
        L_0x0b16:
            int r7 = r7 + -1
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ek r8 = org.mozilla.javascript.UniqueTag.f6692c     // Catch:{ Throwable -> 0x00ed }
            if (r2 != r8) goto L_0x0b24
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
        L_0x0b24:
            org.mozilla.javascript.dd r2 = org.mozilla.javascript.ScriptRuntime.m6475p(r2)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0b2c:
            int r7 = m5736a(r5, r6, r7)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0b32:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x0b3d
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
        L_0x0b3d:
            org.mozilla.javascript.dd r2 = org.mozilla.javascript.ScriptRuntime.m6465j(r36)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0b45:
            r0 = r36
            int r7 = m5754b(r0, r5, r6, r7)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0b4d:
            int r2 = r3.f6027j     // Catch:{ Throwable -> 0x00ed }
            int r14 = r14 + r2
            r2 = r5[r14]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r2 = (org.mozilla.javascript.Scriptable) r2     // Catch:{ Throwable -> 0x00ed }
            r3.f6038u = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0b58:
            int r2 = r3.f6027j     // Catch:{ Throwable -> 0x00ed }
            int r14 = r14 + r2
            org.mozilla.javascript.dr r2 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            r5[r14] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0b61:
            int r7 = r7 + 1
            org.mozilla.javascript.dr r2 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.am r8 = r3.f6021d     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.am r2 = org.mozilla.javascript.InterpretedFunction.m5714a(r2, r8, r14)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0b6f:
            org.mozilla.javascript.dr r2 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.am r8 = r3.f6021d     // Catch:{ Throwable -> 0x00ed }
            m5746a(r2, r8, r14)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0b78:
            org.mozilla.javascript.ar r2 = r3.f6022e     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object[] r2 = r2.f6059h     // Catch:{ Throwable -> 0x00ed }
            r2 = r2[r14]     // Catch:{ Throwable -> 0x00ed }
            int r7 = r7 + 1
            org.mozilla.javascript.dr r8 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            r0 = r36
            org.mozilla.javascript.dr r2 = org.mozilla.javascript.ScriptRuntime.m6425c(r0, r8, r2)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0b8c:
            int r2 = r7 + 1
            int[] r7 = new int[r14]     // Catch:{ Throwable -> 0x00ed }
            r5[r2] = r7     // Catch:{ Throwable -> 0x00ed }
            int r7 = r2 + 1
            java.lang.Object[] r2 = new java.lang.Object[r14]     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            r8 = 0
            r6[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0b9e:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x0e8b
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
            r8 = r2
        L_0x0bab:
            int r7 = r7 + -1
            r10 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            int r9 = (int) r10     // Catch:{ Throwable -> 0x00ed }
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Throwable -> 0x00ed }
            r2[r9] = r8     // Catch:{ Throwable -> 0x00ed }
            int r2 = r9 + 1
            double r8 = (double) r2     // Catch:{ Throwable -> 0x00ed }
            r6[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0bbf:
            r8 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            int r7 = r7 + -1
            r10 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            int r9 = (int) r10     // Catch:{ Throwable -> 0x00ed }
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Throwable -> 0x00ed }
            r2[r9] = r8     // Catch:{ Throwable -> 0x00ed }
            int r2 = r7 + -1
            r2 = r5[r2]     // Catch:{ Throwable -> 0x00ed }
            int[] r2 = (int[]) r2     // Catch:{ Throwable -> 0x00ed }
            int[] r2 = (int[]) r2     // Catch:{ Throwable -> 0x00ed }
            r8 = -1
            r2[r9] = r8     // Catch:{ Throwable -> 0x00ed }
            int r2 = r9 + 1
            double r8 = (double) r2     // Catch:{ Throwable -> 0x00ed }
            r6[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0be0:
            r8 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            int r7 = r7 + -1
            r10 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            int r9 = (int) r10     // Catch:{ Throwable -> 0x00ed }
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Throwable -> 0x00ed }
            r2[r9] = r8     // Catch:{ Throwable -> 0x00ed }
            int r2 = r7 + -1
            r2 = r5[r2]     // Catch:{ Throwable -> 0x00ed }
            int[] r2 = (int[]) r2     // Catch:{ Throwable -> 0x00ed }
            int[] r2 = (int[]) r2     // Catch:{ Throwable -> 0x00ed }
            r8 = 1
            r2[r9] = r8     // Catch:{ Throwable -> 0x00ed }
            int r2 = r9 + 1
            double r8 = (double) r2     // Catch:{ Throwable -> 0x00ed }
            r6[r7] = r8     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0c01:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Throwable -> 0x00ed }
            int r9 = r7 + -1
            r7 = r5[r9]     // Catch:{ Throwable -> 0x00ed }
            int[] r7 = (int[]) r7     // Catch:{ Throwable -> 0x00ed }
            int[] r7 = (int[]) r7     // Catch:{ Throwable -> 0x00ed }
            r8 = 66
            r0 = r18
            if (r0 != r8) goto L_0x0c2c
            org.mozilla.javascript.ar r8 = r3.f6022e     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object[] r8 = r8.f6076y     // Catch:{ Throwable -> 0x00ed }
            r8 = r8[r14]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object[] r8 = (java.lang.Object[]) r8     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object[] r8 = (java.lang.Object[]) r8     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r10 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            r0 = r36
            org.mozilla.javascript.dr r2 = org.mozilla.javascript.ScriptRuntime.m6370a(r8, r2, r7, r0, r10)     // Catch:{ Throwable -> 0x00ed }
        L_0x0c27:
            r5[r9] = r2     // Catch:{ Throwable -> 0x00ed }
            r7 = r9
            goto L_0x00bd
        L_0x0c2c:
            r7 = 0
            r8 = -31
            r0 = r18
            if (r0 != r8) goto L_0x0c3d
            org.mozilla.javascript.ar r7 = r3.f6022e     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object[] r7 = r7.f6076y     // Catch:{ Throwable -> 0x00ed }
            r7 = r7[r14]     // Catch:{ Throwable -> 0x00ed }
            int[] r7 = (int[]) r7     // Catch:{ Throwable -> 0x00ed }
            int[] r7 = (int[]) r7     // Catch:{ Throwable -> 0x00ed }
        L_0x0c3d:
            org.mozilla.javascript.dr r8 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r2 = org.mozilla.javascript.ScriptRuntime.m6369a(r2, r7, r8)     // Catch:{ Throwable -> 0x00ed }
            goto L_0x0c27
        L_0x0c44:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x0c50
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            java.lang.Number r2 = org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
        L_0x0c50:
            int r7 = r7 + -1
            org.mozilla.javascript.dr r2 = org.mozilla.javascript.ScriptRuntime.m6472n(r2)     // Catch:{ Throwable -> 0x00ed }
            r3.f6038u = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0c5a:
            m5762c(r3, r7)     // Catch:{ Throwable -> 0x00ed }
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6397b()     // Catch:{ Throwable -> 0x00ed }
            if (r2 == 0) goto L_0x0c75
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r2 = r3.f6038u     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.dr r2 = org.mozilla.javascript.ScriptRuntime.m6442e(r2)     // Catch:{ Throwable -> 0x00ed }
            r3.f6038u = r2     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 2
            r3.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0c75:
            int r7 = r7 + -1
            r8 = r7
            goto L_0x0410
        L_0x0c7a:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 != r0) goto L_0x0c85
            r8 = r6[r7]     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ScriptRuntime.m6313a(r8)     // Catch:{ Throwable -> 0x00ed }
        L_0x0c85:
            java.lang.Object r2 = org.mozilla.javascript.ScriptRuntime.m6400b(r36)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0c8d:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 == r0) goto L_0x00bd
            java.lang.String r2 = org.mozilla.javascript.ScriptRuntime.m6458h(r36)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0c9b:
            r2 = r5[r7]     // Catch:{ Throwable -> 0x00ed }
            r0 = r29
            if (r2 == r0) goto L_0x00bd
            java.lang.String r2 = org.mozilla.javascript.ScriptRuntime.m6462i(r36)     // Catch:{ Throwable -> 0x00ed }
            r5[r7] = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0ca9:
            org.mozilla.javascript.c.a r2 = r3.f6029l     // Catch:{ Throwable -> 0x00ed }
            if (r2 == 0) goto L_0x00bd
            goto L_0x00bd
        L_0x0caf:
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            r3.f6037t = r2     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 2
            r3.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0cbb:
            r14 = 0
            goto L_0x00bd
        L_0x0cbe:
            r14 = 1
            goto L_0x00bd
        L_0x0cc1:
            r14 = 2
            goto L_0x00bd
        L_0x0cc4:
            r14 = 3
            goto L_0x00bd
        L_0x0cc7:
            r14 = 4
            goto L_0x00bd
        L_0x0cca:
            r14 = 5
            goto L_0x00bd
        L_0x0ccd:
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            byte r2 = r4[r2]     // Catch:{ Throwable -> 0x00ed }
            r14 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 1
            r3.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0cdb:
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r14 = m5755b(r4, r2)     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 2
            r3.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0ce9:
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r14 = m5760c(r4, r2)     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + 4
            r3.f6035r = r2     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0cf7:
            r2 = 0
            r28 = r33[r2]     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0cfc:
            r2 = 1
            r28 = r33[r2]     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0d01:
            r2 = 2
            r28 = r33[r2]     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0d06:
            r2 = 3
            r28 = r33[r2]     // Catch:{ Throwable -> 0x00ed }
            goto L_0x00bd
        L_0x0d0b:
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            byte r2 = r4[r2]     // Catch:{ Throwable -> 0x00ed }
            r2 = r2 & 255(0xff, float:3.57E-43)
            r8 = r33[r2]     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x0e71 }
            int r2 = r2 + 1
            r3.f6035r = r2     // Catch:{ Throwable -> 0x0e71 }
            r28 = r8
            goto L_0x00bd
        L_0x0d1d:
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = m5755b(r4, r2)     // Catch:{ Throwable -> 0x00ed }
            r8 = r33[r2]     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x0e71 }
            int r2 = r2 + 2
            r3.f6035r = r2     // Catch:{ Throwable -> 0x0e71 }
            r28 = r8
            goto L_0x00bd
        L_0x0d2f:
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            int r2 = m5760c(r4, r2)     // Catch:{ Throwable -> 0x00ed }
            r8 = r33[r2]     // Catch:{ Throwable -> 0x00ed }
            int r2 = r3.f6035r     // Catch:{ Throwable -> 0x0e71 }
            int r2 = r2 + 4
            r3.f6035r = r2     // Catch:{ Throwable -> 0x0e71 }
            r28 = r8
            goto L_0x00bd
        L_0x0d41:
            org.mozilla.javascript.ar r2 = r3.f6022e     // Catch:{ Throwable -> 0x00ed }
            org.mozilla.javascript.ei r2 = r2.f6077z     // Catch:{ Throwable -> 0x00ed }
            int r7 = r3.f6035r     // Catch:{ Throwable -> 0x00ed }
            if (r7 >= 0) goto L_0x0d4c
            org.mozilla.javascript.Kit.m5810a()     // Catch:{ Throwable -> 0x00ed }
        L_0x0d4c:
            int r7 = r2.mo19090a(r7)     // Catch:{ Throwable -> 0x00ed }
            if (r7 < 0) goto L_0x0d64
            int r9 = r2.f6687e     // Catch:{ Throwable -> 0x00ed }
            if (r9 == 0) goto L_0x0d60
            int[] r9 = r2.f6683a     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2.f6687e     // Catch:{ Throwable -> 0x00ed }
            int r2 = r2 + r7
            r2 = r9[r2]     // Catch:{ Throwable -> 0x00ed }
            r7 = r3
            goto L_0x0426
        L_0x0d60:
            r2 = 0
            r7 = r3
            goto L_0x0426
        L_0x0d64:
            org.mozilla.javascript.Kit.m5810a()     // Catch:{ Throwable -> 0x00ed }
            r2 = 0
            r7 = r3
            goto L_0x0426
        L_0x0d6b:
            r3 = r2
            r2 = r24
        L_0x0d6e:
            r0 = r36
            org.mozilla.javascript.cq r6 = r0.f6796t
            if (r6 == 0) goto L_0x0e28
            r0 = r36
            org.mozilla.javascript.cq r6 = r0.f6796t
            int r6 = r6.f6407a
            if (r6 == 0) goto L_0x0e28
            r0 = r36
            org.mozilla.javascript.cq r6 = r0.f6796t
            java.lang.Object r6 = r6.mo18963b()
            r0 = r36
            r0.f6795s = r6
        L_0x0d88:
            if (r2 == 0) goto L_0x0e37
            boolean r3 = r2 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x0e34
            java.lang.RuntimeException r2 = (java.lang.RuntimeException) r2
            throw r2
        L_0x0d91:
            r28 = r6
            r17 = r7
            r6 = r3
            r3 = r2
            goto L_0x0260
        L_0x0d99:
            boolean r2 = r3 instanceof org.mozilla.javascript.EcmaError
            if (r2 == 0) goto L_0x0da0
            r2 = 2
            goto L_0x027a
        L_0x0da0:
            boolean r2 = r3 instanceof org.mozilla.javascript.EvaluatorException
            if (r2 == 0) goto L_0x0da7
            r2 = 2
            goto L_0x027a
        L_0x0da7:
            boolean r2 = r3 instanceof java.lang.RuntimeException
            if (r2 == 0) goto L_0x0dbf
            r2 = 13
            r0 = r36
            boolean r2 = r0.mo19138b(r2)
            if (r2 == 0) goto L_0x0dbd
            r2 = 2
        L_0x0db6:
            r34 = r7
            r7 = r2
            r2 = r34
            goto L_0x027f
        L_0x0dbd:
            r2 = 1
            goto L_0x0db6
        L_0x0dbf:
            boolean r2 = r3 instanceof java.lang.Error
            if (r2 == 0) goto L_0x0dd7
            r2 = 13
            r0 = r36
            boolean r2 = r0.mo19138b(r2)
            if (r2 == 0) goto L_0x0dd5
            r2 = 2
        L_0x0dce:
            r34 = r7
            r7 = r2
            r2 = r34
            goto L_0x027f
        L_0x0dd5:
            r2 = 0
            goto L_0x0dce
        L_0x0dd7:
            boolean r2 = r3 instanceof org.mozilla.javascript.C2137ap
            if (r2 == 0) goto L_0x0de1
            r7 = 1
            r2 = r3
            org.mozilla.javascript.ap r2 = (org.mozilla.javascript.C2137ap) r2
            goto L_0x027f
        L_0x0de1:
            r2 = 13
            r0 = r36
            boolean r2 = r0.mo19138b(r2)
            if (r2 == 0) goto L_0x0dee
            r2 = 2
            goto L_0x027a
        L_0x0dee:
            r2 = 1
            goto L_0x027a
        L_0x0df1:
            r7 = move-exception
            r3 = 1
            r8 = r3
            r3 = r7
            r7 = r2
            goto L_0x028c
        L_0x0df8:
            r7 = move-exception
            r2 = 0
            r3 = 0
            r8 = r3
            r3 = r7
            r7 = r2
            goto L_0x028c
        L_0x0e00:
            r2 = 0
            goto L_0x0292
        L_0x0e03:
            if (r7 == 0) goto L_0x0e84
            org.mozilla.javascript.ao r2 = r7.f6043b
            if (r2 == 0) goto L_0x0e0c
            org.mozilla.javascript.Kit.m5810a()
        L_0x0e0c:
            org.mozilla.javascript.ao r2 = r7.f6042a
            if (r2 == 0) goto L_0x0e1b
            r14 = -1
            r26 = r4
            r25 = r6
            r7 = r28
            r4 = r17
            goto L_0x004f
        L_0x0e1b:
            java.lang.Object r4 = r7.f6044c
            double r2 = r7.f6045d
            r5 = 0
            r34 = r2
            r3 = r4
            r2 = r5
            r4 = r34
            goto L_0x0d6e
        L_0x0e28:
            r6 = 0
            r0 = r36
            r0.f6795s = r6
            r6 = 0
            r0 = r36
            r0.f6796t = r6
            goto L_0x0d88
        L_0x0e34:
            java.lang.Error r2 = (java.lang.Error) r2
            throw r2
        L_0x0e37:
            r0 = r29
            if (r3 != r0) goto L_0x0226
            java.lang.Number r3 = org.mozilla.javascript.ScriptRuntime.m6313a(r4)
            goto L_0x0226
        L_0x0e41:
            r6 = move-exception
            r7 = r3
            r3 = r2
            r2 = r6
            r6 = r28
            goto L_0x00f5
        L_0x0e49:
            r3 = move-exception
            r7 = r6
            r6 = r28
            r34 = r2
            r2 = r3
            r3 = r34
            goto L_0x00f5
        L_0x0e54:
            r2 = move-exception
            r6 = r7
            r24 = r3
            r3 = r25
            r7 = r5
            r4 = r26
            goto L_0x00f5
        L_0x0e5f:
            r2 = move-exception
            r3 = r25
            r6 = r7
            r7 = r5
            r4 = r26
            goto L_0x00f5
        L_0x0e68:
            r2 = move-exception
            r4 = r26
            r6 = r7
            r7 = r3
            r3 = r25
            goto L_0x00f5
        L_0x0e71:
            r2 = move-exception
            r4 = r26
            r6 = r8
            r7 = r3
            r3 = r25
            goto L_0x00f5
        L_0x0e7a:
            r4 = move-exception
            r6 = r28
            r7 = r3
            r3 = r2
            r2 = r4
            r4 = r26
            goto L_0x00f5
        L_0x0e84:
            r2 = r3
            r3 = r6
            goto L_0x0d6e
        L_0x0e88:
            r7 = r8
            goto L_0x00bd
        L_0x0e8b:
            r8 = r2
            goto L_0x0bab
        L_0x0e8e:
            r8 = r2
            goto L_0x0ab7
        L_0x0e91:
            r16 = r3
            goto L_0x07b5
        L_0x0e95:
            r8 = r2
            goto L_0x0700
        L_0x0e98:
            r8 = r2
            goto L_0x0668
        L_0x0e9b:
            r8 = r2
            goto L_0x05f9
        L_0x0e9e:
            r8 = r2
            goto L_0x05a0
        L_0x0ea1:
            r8 = r2
            goto L_0x0572
        L_0x0ea4:
            r8 = r2
            goto L_0x0410
        L_0x0ea7:
            r8 = r2
            goto L_0x034a
        L_0x0eaa:
            r15 = r14
            goto L_0x09d3
        L_0x0ead:
            r15 = r14
            goto L_0x09ba
        L_0x0eb0:
            r11 = r5
            goto L_0x013a
        L_0x0eb3:
            r5 = r4
            goto L_0x005b
        L_0x0eb6:
            r26 = r4
            r25 = r6
            r7 = r28
            r4 = r17
            goto L_0x004f
        L_0x0ec0:
            r8 = r7
            r7 = r2
            goto L_0x028c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Interpreter.m5740a(org.mozilla.javascript.l, org.mozilla.javascript.ao, java.lang.Object):java.lang.Object");
    }

    /* renamed from: a */
    private static int m5725a(C2136ao aoVar, int i, Object[] objArr, double[] dArr, int i2) {
        double b;
        double d;
        boolean z = true;
        int i3 = i2 - 1;
        UniqueTag ekVar = (UniqueTag) objArr[i3 + 1];
        UniqueTag ekVar2 = (UniqueTag) objArr[i3];
        if (ekVar == UniqueTag.f6692c) {
            b = dArr[i3 + 1];
            d = m5751b(aoVar, i3);
        } else if (ekVar2 == UniqueTag.f6692c) {
            b = ScriptRuntime.m6395b((Object) ekVar);
            d = dArr[i3];
        } else {
            switch (i) {
                case 14:
                    z = ScriptRuntime.m6444e(ekVar2, ekVar);
                    break;
                case 15:
                    z = ScriptRuntime.m6450f(ekVar2, ekVar);
                    break;
                case 16:
                    z = ScriptRuntime.m6444e(ekVar, ekVar2);
                    break;
                case 17:
                    z = ScriptRuntime.m6450f(ekVar, ekVar2);
                    break;
                default:
                    throw Kit.m5810a();
            }
            objArr[i3] = ScriptRuntime.m6312a(z);
            return i3;
        }
        switch (i) {
            case 14:
                if (d >= b) {
                    z = false;
                    break;
                }
                break;
            case 15:
                if (d > b) {
                    z = false;
                    break;
                }
                break;
            case 16:
                if (d <= b) {
                    z = false;
                    break;
                }
                break;
            case 17:
                if (d < b) {
                    z = false;
                    break;
                }
                break;
            default:
                throw Kit.m5810a();
        }
        objArr[i3] = ScriptRuntime.m6312a(z);
        return i3;
    }

    /* renamed from: b */
    private static int m5752b(C2136ao aoVar, int i, Object[] objArr, double[] dArr, int i2) {
        int a = m5724a(aoVar, i2 - 1);
        int a2 = m5724a(aoVar, i2);
        int i3 = i2 - 1;
        objArr[i3] = UniqueTag.f6692c;
        switch (i) {
            case 9:
                a |= a2;
                break;
            case 10:
                a ^= a2;
                break;
            case 11:
                a &= a2;
                break;
            case 18:
                a <<= a2;
                break;
            case 19:
                a >>= a2;
                break;
        }
        dArr[i3] = (double) a;
        return i3;
    }

    /* renamed from: a */
    private static int m5729a(Context lVar, int i, Object[] objArr, double[] dArr, int i2) {
        Object obj;
        Number number = (Number) objArr[i2];
//        if (number == UniqueTag.f6692c) {
//            number = ScriptRuntime.m6313a(dArr[i2]);
//        }
//        int i3 = i2 - 1;
//        UniqueTag ekVar = objArr[i3];
//        if (ekVar == UniqueTag.f6692c) {
//            obj = ScriptRuntime.m6313a(dArr[i3]);
//        } else {
//            obj = ekVar;
//        }
//        objArr[i3] = ScriptRuntime.m6321a(obj, (Object) number, lVar, i == 0);
//        return i3;

        return -1;
    }

    /* renamed from: a */
    private static int m5731a(Context lVar, C2136ao aoVar, Object[] objArr, double[] dArr, int i) {
        Object a = null;
        int i2 = i - 1;
//        Number number = objArr[i2];
//        if (number == UniqueTag.f6692c) {
//            number = ScriptRuntime.m6313a(dArr[i2]);
//        }
//        UniqueTag ekVar = objArr[i2 + 1];
//        if (ekVar != UniqueTag.f6692c) {
//            a = ScriptRuntime.m6320a((Object) number, (Object) ekVar, lVar, aoVar.f6038u);
//        } else {
//            a = ScriptRuntime.m6315a((Object) number, dArr[i2 + 1], lVar);
//        }
        objArr[i2] = a;
        return i2;
    }

    /* renamed from: a */
    private static int m5734a(Context lVar, Object[] objArr, double[] dArr, int i) {
        Object a = null;
        int i2 = i - 2;
//        Number number = objArr[i2 + 2];
//        if (number == UniqueTag.f6692c) {
//            number = ScriptRuntime.m6313a(dArr[i2 + 2]);
//        }
//        Number number2 = objArr[i2];
//        if (number2 == UniqueTag.f6692c) {
//            number2 = ScriptRuntime.m6313a(dArr[i2]);
//        }
//        UniqueTag ekVar = objArr[i2 + 1];
//        if (ekVar != UniqueTag.f6692c) {
//            a = ScriptRuntime.m6318a((Object) number2, (Object) ekVar, (Object) number, lVar);
//        } else {
//            a = ScriptRuntime.m6314a((Object) number2, dArr[i2 + 1], (Object) number, lVar);
//        }
        objArr[i2] = a;
        return i2;
    }

    /* renamed from: a */
    private static int m5730a(Context lVar, C2136ao aoVar, byte[] bArr, Object[] objArr, double[] dArr, int i) {
//        Number number = objArr[i];
//        if (number == UniqueTag.f6692c) {
//            number = ScriptRuntime.m6313a(dArr[i]);
//        }
        int i2 = i - 1;
//        Number number2 = objArr[i2];
//        if (number2 == UniqueTag.f6692c) {
//            number2 = ScriptRuntime.m6313a(dArr[i2]);
//        }
//        objArr[i2] = ScriptRuntime.m6319a((Object) number2, (Object) number, lVar, (int) bArr[aoVar.f6035r]);
//        aoVar.f6035r++;
        return i2;
    }

    /* renamed from: a */
    private static int m5732a(Context lVar, C2136ao aoVar, Object[] objArr, double[] dArr, int i, byte[] bArr, int i2) {
        int i3 = 0;
//        byte b = bArr[aoVar.f6035r] & Constants.NETWORK_TYPE_UNCONNECTED;
//        boolean z = bArr[aoVar.f6035r + 1] != 0;
//        int b2 = m5755b(bArr, aoVar.f6035r + 2);
//        if (z) {
//            int i4 = i - i2;
//            Number number = objArr[i4];
//            if (number == UniqueTag.f6692c) {
//                number = ScriptRuntime.m6313a(dArr[i4]);
//            }
//            objArr[i4] = ScriptRuntime.m6340a(lVar, (Object) number, m5750a(objArr, dArr, i4 + 1, i2), aoVar.f6038u, (int) b);
//            i3 = i4;
//        } else {
//            int i5 = i - (i2 + 1);
//            objArr[i5] = ScriptRuntime.m6344a(lVar, objArr[i5], objArr[i5 + 1], m5750a(objArr, dArr, i5 + 2, i2), aoVar.f6038u, aoVar.f6032o, b, aoVar.f6022e.f6053b, b2);
//            i3 = i5;
//        }
        aoVar.f6035r += 4;
        return i3;
    }

    /* renamed from: a */
    private static int m5728a(C2136ao aoVar, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int[] iArr, int i2) {
        Object obj;
        if (aoVar.f6030m) {
            UniqueTag ekVar = (UniqueTag) objArr[i];
            if (ekVar == UniqueTag.f6692c) {
                obj = ScriptRuntime.m6313a(dArr[i]);
            } else {
                obj = ekVar;
            }
            String str = aoVar.f6022e.f6066o[i2];
            if (aoVar.f6038u instanceof ConstProperties) {
                ((ConstProperties) aoVar.f6038u).putConst(str, aoVar.f6038u, obj);
            } else {
                throw Kit.m5810a();
            }
        } else if ((iArr[i2] & 1) == 0) {
            throw Context.m6755a("msg.var.redecl", (Object) aoVar.f6022e.f6066o[i2]);
        } else if ((iArr[i2] & 8) != 0) {
            objArr2[i2] = objArr[i];
            iArr[i2] = iArr[i2] & -9;
            dArr2[i2] = dArr[i];
        }
        return i;
    }

    /* renamed from: b */
    private static int m5753b(C2136ao aoVar, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int[] iArr, int i2) {
//        if (aoVar.f6030m) {
//            Number number = objArr[i];
//            if (number == UniqueTag.f6692c) {
//                number = ScriptRuntime.m6313a(dArr[i]);
//            }
//            aoVar.f6038u.put(aoVar.f6022e.f6066o[i2], aoVar.f6038u, (Object) number);
//        } else if ((iArr[i2] & 1) == 0) {
//            objArr2[i2] = objArr[i];
//            dArr2[i2] = dArr[i];
//        }
//        return i;

        return -1;
    }

    /* renamed from: a */
    private static int m5727a(C2136ao aoVar, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int i2) {
        int i3 = i + 1;
        if (!aoVar.f6030m) {
            objArr[i3] = objArr2[i2];
            dArr[i3] = dArr2[i2];
        } else {
            objArr[i3] = aoVar.f6038u.get(aoVar.f6022e.f6066o[i2], aoVar.f6038u);
        }
        return i3;
    }

    /* renamed from: a */
    private static int m5733a(Context lVar, C2136ao aoVar, Object[] objArr, double[] dArr, int i, Object[] objArr2, double[] dArr2, int i2) {
        double b;
        int i3 = i + 1;
        byte b2 = aoVar.f6022e.f6060i[aoVar.f6035r];
        if (!aoVar.f6030m) {
            objArr[i3] = UniqueTag.f6692c;
//            UniqueTag ekVar = objArr2[i2];
//            if (ekVar == UniqueTag.f6692c) {
//                b = dArr2[i2];
//            } else {
//                b = ScriptRuntime.m6395b((Object) ekVar);
//                objArr2[i2] = UniqueTag.f6692c;
//            }
//            double d = (b2 & 1) == 0 ? b + 1.0d : b - 1.0d;
//            dArr2[i2] = d;
//            if ((b2 & 2) != 0) {
//                d = b;
//            }
//            dArr[i3] = d;
        } else {
            objArr[i3] = ScriptRuntime.m6338a(aoVar.f6038u, aoVar.f6022e.f6066o[i2], lVar, (int) b2);
        }
        aoVar.f6035r++;
        return i3;
    }

    /* renamed from: a */
    private static int m5736a(Object[] objArr, double[] dArr, int i) {
        if (objArr[i] == UniqueTag.f6692c) {
            ScriptRuntime.m6313a(dArr[i]);
        }
        int i2 = i - 1;
        if (objArr[i2] == UniqueTag.f6692c) {
            ScriptRuntime.m6313a(dArr[i2]);
        }
        int i3 = i2 - 1;
        Number number = (Number) objArr[i3];
//        if (number == UniqueTag.f6692c) {
//            number = ScriptRuntime.m6313a(dArr[i3]);
//        }
        objArr[i3] = ScriptRuntime.m6476q(number);
        return i3;
    }

    /* renamed from: b */
    private static int m5754b(Context lVar, Object[] objArr, double[] dArr, int i) {
        if (objArr[i] == UniqueTag.f6692c) {
            ScriptRuntime.m6313a(dArr[i]);
        }
        int i2 = i - 1;
        if (objArr[i2] == UniqueTag.f6692c) {
            ScriptRuntime.m6313a(dArr[i2]);
        }
        objArr[i2] = ScriptRuntime.m6466k(lVar);
        return i2;
    }

    /* renamed from: a */
    private static C2136ao m5743a(Context lVar, C2136ao aoVar, int i, Object[] objArr, double[] dArr, int i2, int i3, Scriptable drVar, Scriptable drVar2, C2178dp dpVar, InterpretedFunction amVar) {
        C2136ao aoVar2;
        Object[] objArr2 = new Object[i];
        int i4 = i2 + 2;
        for (int i5 = 0; i5 < i; i5++) {
//            Number number = (Number) objArr[i4];
//            if (number == UniqueTag.f6692c) {
//                number = ScriptRuntime.m6313a(dArr[i4]);
//            }
//            objArr2[i5] = number;
//            i4++;
        }
//        Object[] objArr3 = {dpVar.f6528a, Context.m6752a(drVar2, objArr2)};
//        C2136ao aoVar3 = new C2136ao(0);
//        if (i3 == -55) {
//            aoVar2 = aoVar.f6018a;
//            m5756b(lVar, aoVar, (Object) null);
//        } else {
//            aoVar2 = aoVar;
//        }
//        m5749a(lVar, drVar2, drVar, objArr3, (double[]) null, 0, 2, amVar, aoVar2, aoVar3);
//        if (i3 != -55) {
//            aoVar.f6039v = i2;
//            aoVar.f6040w = i3;
//        }
//        return aoVar3;


        return null;
    }

    /* renamed from: b */
    private static boolean m5757b(Object[] objArr, double[] dArr, int i) {
        double doubleValue;
        double d;
        UniqueTag ekVar = (UniqueTag) objArr[i + 1];
        Number number = (Number) objArr[i];
        UniqueTag ekVar2 = UniqueTag.f6692c;
//        if (ekVar == ekVar2) {
//            doubleValue = dArr[i + 1];
//            if (number == ekVar2) {
//                d = dArr[i];
//            } else if (!(number instanceof Number)) {
//                return false;
//            } else {
//                d = number.doubleValue();
//            }
//        } else if (number != ekVar2) {
//            return ScriptRuntime.m6430c((Object) number, (Object) ekVar);
//        } else {
//            double d2 = dArr[i];
//            if (!(ekVar instanceof Number)) {
//                return false;
//            }
//            double d3 = d2;
//            doubleValue = ((Number) ekVar).doubleValue();
//            d = d3;
//        }
//        if (d == doubleValue) {
//            return true;
//        }
        return false;
    }

    /* renamed from: a */
    private static C2136ao m5742a(Context lVar, C2136ao aoVar, int i, Object[] objArr, double[] dArr, int i2, int i3, Scriptable drVar, IdFunctionObject ahVar, InterpretedFunction amVar) {
        Scriptable drVar2;
        C2136ao aoVar2;
//        if (i != 0) {
//            Number number = objArr[i2 + 2];
//            if (number == UniqueTag.f6692c) {
//                number = ScriptRuntime.m6313a(dArr[i2 + 2]);
//            }
//            drVar2 = ScriptRuntime.m6365a(lVar, (Object) number);
//        } else {
//            drVar2 = null;
//        }
//        if (drVar2 == null) {
//            drVar2 = ScriptRuntime.m6438d(lVar);
//        }
//        if (i3 == -55) {
//            m5756b(lVar, aoVar, (Object) null);
//            aoVar2 = aoVar.f6018a;
//        } else {
//            aoVar.f6039v = i2;
//            aoVar.f6040w = i3;
//            aoVar2 = aoVar;
//        }
//        C2136ao aoVar3 = new C2136ao(0);
//        if (BaseFunction.isApply(ahVar)) {
//            Object[] k = i < 2 ? ScriptRuntime.f6517x : ScriptRuntime.m6467k(objArr[i2 + 3]);
//            m5749a(lVar, drVar, drVar2, k, (double[]) null, 0, k.length, amVar, aoVar2, aoVar3);
//        } else {
//            for (int i4 = 1; i4 < i; i4++) {
//                objArr[i2 + 1 + i4] = objArr[i2 + 2 + i4];
//                dArr[i2 + 1 + i4] = dArr[i2 + 2 + i4];
//            }
//            m5749a(lVar, drVar, drVar2, objArr, dArr, i2 + 2, i < 2 ? 0 : i - 1, amVar, aoVar2, aoVar3);
//        }
//        return aoVar3;

        return null;
    }

    /* renamed from: a */
    private static void m5749a(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr, double[] dArr, int i, int i2, InterpretedFunction amVar, C2136ao aoVar, C2136ao aoVar2) {
        DebugFrame aVar;
        boolean z;
        boolean z2;
        Object[] objArr2;
        int[] iArr;
        double[] dArr2;
        InterpreterData arVar = amVar.f6014a;
        boolean z3 = arVar.f6054c;
        if (lVar.f6793q != null) {
            DebugFrame a = lVar.f6793q.mo18889a();
            if (a != null) {
                aVar = a;
                z = true;
            } else {
                aVar = a;
                z = z3;
            }
        } else {
            aVar = null;
            z = z3;
        }
        if (z) {
            if (dArr != null) {
                objArr = m5750a(objArr, dArr, i, i2);
            }
            i = 0;
            dArr = null;
        }
        if (arVar.f6055d != 0) {
            drVar = amVar.getParentScope();
            if (z) {
                drVar = ScriptRuntime.m6363a((NativeFunction) amVar, drVar, objArr);
            }
        } else {
            ScriptRuntime.m6380a((NativeFunction) amVar, lVar, drVar, amVar.f6014a.f6051C);
        }
        if (arVar.f6058g != null) {
            if (arVar.f6055d != 0 && !arVar.f6054c) {
                Kit.m5810a();
            }
            for (int i3 = 0; i3 < arVar.f6058g.length; i3++) {
                if (arVar.f6058g[i3].f6055d == 1) {
                    m5746a(drVar, amVar, i3);
                }
            }
        }
        int i4 = (arVar.f6062k + arVar.f6063l) - 1;
        int i5 = arVar.f6065n;
        if (i5 != arVar.f6064m + i4 + 1) {
            Kit.m5810a();
        }
        if (aoVar2.f6023f == null || i5 > aoVar2.f6023f.length) {
            z2 = false;
            objArr2 = new Object[i5];
            iArr = new int[i5];
            dArr2 = new double[i5];
        } else {
            z2 = true;
            objArr2 = aoVar2.f6023f;
            iArr = aoVar2.f6024g;
            dArr2 = aoVar2.f6025h;
        }
        int length = arVar.f6066o.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (arVar.f6067p[i6]) {
                iArr[i6] = 13;
            }
        }
        int i7 = arVar.f6068q;
        if (i7 <= i2) {
            i2 = i7;
        }
        aoVar2.f6018a = aoVar;
        aoVar2.f6019b = aoVar == null ? 0 : aoVar.f6019b + 1;
        if (aoVar2.f6019b > lVar.f6792p) {
            throw Context.m6765c("Exceeded maximum stack depth");
        }
        aoVar2.f6020c = false;
        aoVar2.f6021d = amVar;
        aoVar2.f6022e = arVar;
        aoVar2.f6023f = objArr2;
        aoVar2.f6024g = iArr;
        aoVar2.f6025h = dArr2;
        aoVar2.f6026i = aoVar2;
        aoVar2.f6027j = arVar.f6062k;
        aoVar2.f6028k = i4;
        aoVar2.f6029l = aVar;
        aoVar2.f6030m = z;
        aoVar2.f6032o = drVar2;
        aoVar2.f6033p = Undefined.f6689a;
        aoVar2.f6035r = 0;
        aoVar2.f6036s = 0;
        aoVar2.f6037t = arVar.f6049A;
        aoVar2.f6038u = drVar;
        aoVar2.f6039v = i4;
        aoVar2.f6040w = 0;
        System.arraycopy(objArr, i, objArr2, 0, i2);
        if (dArr != null) {
            System.arraycopy(dArr, i, dArr2, 0, i2);
        }
        while (i2 != arVar.f6062k) {
            objArr2[i2] = Undefined.f6689a;
            i2++;
        }
        if (z2) {
            for (int i8 = i4 + 1; i8 != objArr2.length; i8++) {
                objArr2[i8] = null;
            }
        }
        m5748a(lVar, aoVar2, false);
    }

    /* renamed from: a */
    private static void m5748a(Context lVar, C2136ao aoVar, boolean z) {
        boolean z2 = aoVar.f6022e.f6054c;
        boolean z3 = aoVar.f6029l != null;
        if (z2 || z3) {
            Scriptable drVar = aoVar.f6038u;
            if (drVar == null) {
                Kit.m5810a();
            } else if (z) {
                while (true) {
                    if (!(drVar instanceof NativeWith)) {
                        break;
                    }
                    drVar = drVar.getParentScope();
                    if (drVar == null || (aoVar.f6018a != null && aoVar.f6018a.f6038u == drVar)) {
                        Kit.m5810a();
                    }
                }
                Kit.m5810a();
            }
            if (z2) {
                ScriptRuntime.m6387a(lVar, drVar);
            }
        }
    }

    /* renamed from: b */
    private static void m5756b(Context lVar, C2136ao aoVar, Object obj) {
        Object obj2;
        double d;
        if (aoVar.f6022e.f6054c) {
            ScriptRuntime.m6443e(lVar);
        }
        if (aoVar.f6029l != null) {
            try {
                if (!(obj instanceof Throwable)) {
                    C2137ap apVar = (C2137ap) obj;
                    if (apVar == null) {
                        obj2 = aoVar.f6033p;
                    } else {
                        obj2 = apVar.f6044c;
                    }
                    if (obj2 == UniqueTag.f6692c) {
                        if (apVar == null) {
                            d = aoVar.f6034q;
                        } else {
                            d = apVar.f6045d;
                        }
                        ScriptRuntime.m6313a(d);
                    }
                }
            } catch (Throwable th) {
                System.err.println("RHINO USAGE WARNING: onExit terminated with exception");
                th.printStackTrace(System.err);
            }
        }
    }

    /* renamed from: a */
    private static void m5745a(C2136ao aoVar, Object obj, double d) {
        if (aoVar.f6040w == 38) {
            aoVar.f6023f[aoVar.f6039v] = obj;
            aoVar.f6025h[aoVar.f6039v] = d;
        } else if (aoVar.f6040w != 30) {
            Kit.m5810a();
        } else if (obj instanceof Scriptable) {
            aoVar.f6023f[aoVar.f6039v] = obj;
        }
        aoVar.f6040w = 0;
    }

    /* renamed from: a */
    private static NativeContinuation m5744a(Context lVar, C2136ao aoVar) {
        NativeContinuation biVar = new NativeContinuation();
        ScriptRuntime.m6383a((ScriptableObject) biVar, ScriptRuntime.m6438d(lVar));
        C2136ao aoVar2 = aoVar;
        while (aoVar2 != null && !aoVar2.f6020c) {
            aoVar2.f6020c = true;
            int i = aoVar2.f6039v;
            while (true) {
                i++;
                if (i == aoVar2.f6023f.length) {
                    break;
                }
                aoVar2.f6023f[i] = null;
                aoVar2.f6024g[i] = 0;
            }
            if (aoVar2.f6040w == 38) {
                aoVar2.f6023f[aoVar2.f6039v] = null;
            } else if (aoVar2.f6040w != 30) {
                Kit.m5810a();
            }
            aoVar2 = aoVar2.f6018a;
        }
        biVar.f6305a = aoVar;
        return biVar;
    }

    /* renamed from: a */
    private static int m5724a(C2136ao aoVar, int i) {
        Object obj = aoVar.f6023f[i];
        if (obj == UniqueTag.f6692c) {
            return ScriptRuntime.m6433d(aoVar.f6025h[i]);
        }
        return ScriptRuntime.m6446f(obj);
    }

    /* renamed from: b */
    private static double m5751b(C2136ao aoVar, int i) {
        Object obj = aoVar.f6023f[i];
        if (obj != UniqueTag.f6692c) {
            return ScriptRuntime.m6395b(obj);
        }
        return aoVar.f6025h[i];
    }

    /* renamed from: c */
    private static boolean m5762c(C2136ao aoVar, int i) {
        Object obj = aoVar.f6023f[i];
        if (obj == Boolean.TRUE) {
            return true;
        }
        if (obj == Boolean.FALSE) {
            return false;
        }
        if (obj == UniqueTag.f6692c) {
            double d = aoVar.f6025h[i];
            return d == d && d != 0.0d;
        } else if (obj == null || obj == Undefined.f6689a) {
            return false;
        } else {
            if (obj instanceof Number) {
                double doubleValue = ((Number) obj).doubleValue();
                return doubleValue == doubleValue && doubleValue != 0.0d;
            } else if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            } else {
                return ScriptRuntime.m6391a(obj);
            }
        }
    }

    /* renamed from: c */
    private static void m5761c(Object[] objArr, double[] dArr, int i) {
        double d;
        boolean z;
        UniqueTag ekVar = (UniqueTag) objArr[i + 1];
        Number number = (Number) objArr[i];
//        if (ekVar == UniqueTag.f6692c) {
//            d = dArr[i + 1];
//            if (number == UniqueTag.f6692c) {
//                dArr[i] = dArr[i] + d;
//                return;
//            }
//            z = true;
//        } else if (number == UniqueTag.f6692c) {
//            d = dArr[i];
//            number = ekVar;
//            z = false;
//        } else if ((number instanceof Scriptable) || (ekVar instanceof Scriptable)) {
//            objArr[i] = ScriptRuntime.m6317a((Object) number, (Object) ekVar);
//            return;
//        } else if ((number instanceof CharSequence) || (ekVar instanceof CharSequence)) {
//            objArr[i] = new ConsString(ScriptRuntime.m6422c((Object) number), ScriptRuntime.m6422c((Object) ekVar));
//            return;
//        } else {
//            double b = number instanceof Number ? number.doubleValue() : ScriptRuntime.m6395b((Object) number);
//            double b2 = ekVar instanceof Number ? ((Number) ekVar).doubleValue() : ScriptRuntime.m6395b((Object) ekVar);
//            objArr[i] = UniqueTag.f6692c;
//            dArr[i] = b2 + b;
//            return;
//        }
//        if (number instanceof Scriptable) {
//            Object a = ScriptRuntime.m6313a(d);
//            if (!z) {
//                Object obj = a;
//                a = number;
//                number = obj;
//            }
//            objArr[i] = ScriptRuntime.m6317a(number, a);
//        } else if (number instanceof CharSequence) {
//            CharSequence charSequence = (CharSequence) number;
//            CharSequence c = ScriptRuntime.m6422c((Object) Double.valueOf(d));
//            if (z) {
//                objArr[i] = new ConsString(charSequence, c);
//            } else {
//                objArr[i] = new ConsString(c, charSequence);
//            }
//        } else {
//            double b3 = number instanceof Number ? ((Number) number).doubleValue() : ScriptRuntime.m6395b((Object) number);
//            objArr[i] = UniqueTag.f6692c;
//            dArr[i] = b3 + d;
//        }
    }

    /* renamed from: c */
    private static int m5759c(C2136ao aoVar, int i, Object[] objArr, double[] dArr, int i2) {
        double b = m5751b(aoVar, i2);
        int i3 = i2 - 1;
        double b2 = m5751b(aoVar, i3);
        objArr[i3] = UniqueTag.f6692c;
        switch (i) {
            case 22:
                b2 -= b;
                break;
            case 23:
                b2 *= b;
                break;
            case 24:
                b2 /= b;
                break;
            case 25:
                b2 %= b;
                break;
        }
        dArr[i3] = b2;
        return i3;
    }

    /* renamed from: a */
    private static Object[] m5750a(Object[] objArr, double[] dArr, int i, int i2) {
        if (i2 == 0) {
            return ScriptRuntime.f6517x;
        }
        Object[] objArr2 = new Object[i2];
//        for (int i3 = 0; i3 != i2; i3++) {
//            Number number = objArr[i];
//            if (number == UniqueTag.f6692c) {
//                number = ScriptRuntime.m6313a(dArr[i]);
//            }
//            objArr2[i3] = number;
//            i++;
//        }
        return objArr2;
    }

    /* renamed from: a */
    private static void m5747a(Context lVar, C2136ao aoVar, int i) {
        lVar.f6797u += (aoVar.f6035r - aoVar.f6036s) + i;
        if (lVar.f6797u > lVar.f6798v) {
            int i2 = lVar.f6797u;
            Context.m6768i();
            lVar.f6797u = 0;
        }
    }
}
