package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.bm */
public final class NativeGenerator extends IdScriptableObject {

    /* renamed from: a */
    private static final Object f6317a = "Generator";

    /* renamed from: b */
    private NativeFunction f6318b;

    /* renamed from: c */
    private Object f6319c;

    /* renamed from: d */
    private String f6320d;

    /* renamed from: e */
    private int f6321e;

    /* renamed from: f */
    private boolean f6322f = true;

    /* renamed from: g */
    private boolean f6323g;

    /* renamed from: a */
    static NativeGenerator m6051a(ScriptableObject dsVar) {
        NativeGenerator bmVar = new NativeGenerator();
        if (dsVar != null) {
            bmVar.setParentScope(dsVar);
            bmVar.setPrototype(getObjectPrototype(dsVar));
        }
        bmVar.activatePrototypeMap(5);
        if (dsVar != null) {
            dsVar.associateValue(f6317a, bmVar);
        }
        return bmVar;
    }

    private NativeGenerator() {
    }

    public NativeGenerator(Scriptable drVar, NativeFunction blVar, Object obj) {
        this.f6318b = blVar;
        this.f6319c = obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(drVar);
        setParentScope(topLevelScope);
        setPrototype((NativeGenerator) ScriptableObject.getTopScopeValue(topLevelScope, f6317a));
    }

    public final String getClassName() {
        return "Generator";
    }

    /* access modifiers changed from: protected */
    public final void initPrototypeId(int i) {
        String str;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "close";
                break;
            case 2:
                str = "next";
                break;
            case 3:
                str = "send";
                i2 = 0;
                break;
            case 4:
                str = "throw";
                i2 = 0;
                break;
            case 5:
                str = "__iterator__";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(f6317a, i, str, i2);
    }

    public final Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        if (!ahVar.mo18643a(f6317a)) {
            return super.execIdCall(ahVar, lVar, drVar, drVar2, objArr);
        }
        int i = ahVar.f5994a;
        if (!(drVar2 instanceof NativeGenerator)) {
            throw incompatibleCallError(ahVar);
        }
        NativeGenerator bmVar = (NativeGenerator) drVar2;
        switch (i) {
            case 1:
                return bmVar.m6050a(lVar, drVar, 2, new C2149bn());
            case 2:
                bmVar.f6322f = false;
                return bmVar.m6050a(lVar, drVar, 0, Undefined.f6689a);
            case 3:
                Object obj = objArr.length > 0 ? objArr[0] : Undefined.f6689a;
                if (!bmVar.f6322f || obj.equals(Undefined.f6689a)) {
                    return bmVar.m6050a(lVar, drVar, 0, obj);
                }
                throw ScriptRuntime.m6455g("msg.send.newborn");
            case 4:
                return bmVar.m6050a(lVar, drVar, 1, objArr.length > 0 ? objArr[0] : Undefined.f6689a);
            case 5:
                return drVar2;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    /* renamed from: a */
    private Object m6050a(Context lVar, Scriptable drVar, int i, Object obj) {
        if (this.f6319c != null) {
            try {
                synchronized (this) {
                    if (this.f6323g) {
                        throw ScriptRuntime.m6455g("msg.already.exec.gen");
                    }
                    this.f6323g = true;
                }
                Object a = this.f6318b.mo18677a(lVar, i, this.f6319c, obj);
                synchronized (this) {
                    this.f6323g = false;
                }
                if (i != 2) {
                    return a;
                }
                this.f6319c = null;
                return a;
            } catch (C2149bn e) {
                try {
                    Object obj2 = Undefined.f6689a;
                    synchronized (this) {
                        this.f6323g = false;
                        if (i != 2) {
                            return obj2;
                        }
                        this.f6319c = null;
                        return obj2;
                    }
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f6323g = false;
                        if (i == 2) {
                            this.f6319c = null;
                        }
                        throw th;
                    }
                }
            } catch (RhinoException e2) {
                this.f6321e = e2.f6489e;
                this.f6320d = e2.f6490f;
                this.f6319c = null;
                throw e2;
            }
        } else if (i == 2) {
            return Undefined.f6689a;
        } else {
            if (i != 1) {
                obj = NativeIterator.m6064a(drVar);
            }
            throw new JavaScriptException(obj, this.f6320d, this.f6321e);
        }
    }

    /* access modifiers changed from: protected */
    public final int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 4) {
            char charAt = str.charAt(0);
            if (charAt == 'n') {
                i = 2;
                str2 = "next";
            } else {
                if (charAt == 's') {
                    i = 3;
                    str2 = "send";
                }
                str2 = null;
                i = 0;
            }
        } else if (length == 5) {
            char charAt2 = str.charAt(0);
            if (charAt2 == 'c') {
                i = 1;
                str2 = "close";
            } else {
                if (charAt2 == 't') {
                    i = 4;
                    str2 = "throw";
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 12) {
                str2 = "__iterator__";
                i = 5;
            }
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
