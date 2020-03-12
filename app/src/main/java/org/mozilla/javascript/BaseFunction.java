package org.mozilla.javascript;

import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.b */
public class BaseFunction extends IdScriptableObject implements Function {
    private static final Object FUNCTION_TAG = "Function";
    private static final int Id_apply = 4;
    private static final int Id_arguments = 5;
    private static final int Id_arity = 2;
    private static final int Id_bind = 6;
    private static final int Id_call = 5;
    private static final int Id_constructor = 1;
    private static final int Id_length = 1;
    private static final int Id_name = 3;
    private static final int Id_prototype = 4;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int MAX_INSTANCE_ID = 5;
    private static final int MAX_PROTOTYPE_ID = 6;
    static final long serialVersionUID = 5311394446546053859L;
    private Object prototypeProperty;
    private int prototypePropertyAttributes = 6;

    static void init(Scriptable drVar, boolean z) {
        BaseFunction bVar = new BaseFunction();
        bVar.prototypePropertyAttributes = 7;
        bVar.exportAsJSClass(6, drVar, z);
    }

    public BaseFunction() {
    }

    public BaseFunction(Scriptable drVar, Scriptable drVar2) {
        super(drVar, drVar2);
    }

    public String getClassName() {
        return "Function";
    }

    public String getTypeOf() {
        return avoidObjectDetection() ? "undefined" : "function";
    }

    public boolean hasInstance(Scriptable drVar) {
        Object property = ScriptableObject.getProperty((Scriptable) this, "prototype");
        if (property instanceof Scriptable) {
            return ScriptRuntime.m6393a(drVar, (Scriptable) property);
        }
        throw ScriptRuntime.m6414b("msg.instanceof.bad.prototype", getFunctionName());
    }

    public int getMaxInstanceId() {
        return 5;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findInstanceIdInfo(String r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            int r2 = r6.length()
            switch(r2) {
                case 4: goto L_0x001d;
                case 5: goto L_0x0024;
                case 6: goto L_0x002b;
                case 7: goto L_0x0009;
                case 8: goto L_0x0009;
                case 9: goto L_0x0032;
                default: goto L_0x0009;
            }
        L_0x0009:
            r2 = r1
            r1 = r0
        L_0x000b:
            if (r2 == 0) goto L_0x0016
            if (r2 == r6) goto L_0x0016
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0016
            r1 = r0
        L_0x0016:
            if (r1 != 0) goto L_0x004c
            int r0 = super.findInstanceIdInfo(r6)
        L_0x001c:
            return r0
        L_0x001d:
            java.lang.String r1 = "name"
            r2 = 3
            r4 = r1
            r1 = r2
            r2 = r4
            goto L_0x000b
        L_0x0024:
            java.lang.String r1 = "arity"
            r2 = 2
            r4 = r1
            r1 = r2
            r2 = r4
            goto L_0x000b
        L_0x002b:
            java.lang.String r1 = "length"
            r2 = 1
            r4 = r1
            r1 = r2
            r2 = r4
            goto L_0x000b
        L_0x0032:
            char r2 = r6.charAt(r0)
            r3 = 97
            if (r2 != r3) goto L_0x0041
            java.lang.String r1 = "arguments"
            r2 = 5
            r4 = r1
            r1 = r2
            r2 = r4
            goto L_0x000b
        L_0x0041:
            r3 = 112(0x70, float:1.57E-43)
            if (r2 != r3) goto L_0x0009
            java.lang.String r1 = "prototype"
            r2 = 4
            r4 = r1
            r1 = r2
            r2 = r4
            goto L_0x000b
        L_0x004c:
            switch(r1) {
                case 1: goto L_0x0055;
                case 2: goto L_0x0055;
                case 3: goto L_0x0055;
                case 4: goto L_0x005b;
                case 5: goto L_0x0064;
                default: goto L_0x004f;
            }
        L_0x004f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x0055:
            r0 = 7
        L_0x0056:
            int r0 = instanceIdInfo(r0, r1)
            goto L_0x001c
        L_0x005b:
            boolean r2 = r5.hasPrototypeProperty()
            if (r2 == 0) goto L_0x001c
            int r0 = r5.prototypePropertyAttributes
            goto L_0x0056
        L_0x0064:
            r0 = 6
            goto L_0x0056
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.BaseFunction.findInstanceIdInfo(java.lang.String):int");
    }

    public String getInstanceIdName(int i) {
        switch (i) {
            case 1:
                return "length";
            case 2:
                return "arity";
            case 3:
                return "name";
            case 4:
                return "prototype";
            case 5:
                return "arguments";
            default:
                return super.getInstanceIdName(i);
        }
    }

    public Object getInstanceIdValue(int i) {
        switch (i) {
            case 1:
                return ScriptRuntime.m6434d(getLength());
            case 2:
                return ScriptRuntime.m6434d(getArity());
            case 3:
                return getFunctionName();
            case 4:
                return getPrototypeProperty();
            case 5:
                return getArguments();
            default:
                return super.getInstanceIdValue(i);
        }
    }

    public void setInstanceIdValue(int i, Object obj) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                return;
            case 4:
                if ((this.prototypePropertyAttributes & 1) == 0) {
                    if (obj == null) {
                        obj = UniqueTag.f6691b;
                    }
                    this.prototypeProperty = obj;
                    return;
                }
                return;
            case 5:
                if (obj == f6533j) {
                    Kit.m5810a();
                }
                defaultPut("arguments", obj);
                return;
            default:
                super.setInstanceIdValue(i, obj);
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void fillConstructorProperties(IdFunctionObject ahVar) {
        ahVar.setPrototype(this);
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
                break;
            case 3:
                str = "toSource";
                break;
            case 4:
                i2 = 2;
                str = "apply";
                break;
            case 5:
                str = "call";
                break;
            case 6:
                str = "bind";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(FUNCTION_TAG, i, str, i2);
    }

    static boolean isApply(IdFunctionObject ahVar) {
        return ahVar.mo18643a(FUNCTION_TAG) && ahVar.f5994a == 4;
    }

    static boolean isApplyOrCall(IdFunctionObject ahVar) {
        if (ahVar.mo18643a(FUNCTION_TAG)) {
            switch (ahVar.f5994a) {
                case 4:
                case 5:
                    return true;
            }
        }
        return false;
    }

    public Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        Scriptable drVar3;
        Object[] objArr2;
        int i;
        boolean z = false;
        if (!ahVar.mo18643a(FUNCTION_TAG)) {
            return super.execIdCall(ahVar, lVar, drVar, drVar2, objArr);
        }
        int i2 = ahVar.f5994a;
        switch (i2) {
            case 1:
                return jsConstructor(lVar, drVar, objArr);
            case 2:
                return realFunction(drVar2, ahVar).decompile(ScriptRuntime.m6420c(objArr, 0), 0);
            case 3:
                BaseFunction realFunction = realFunction(drVar2, ahVar);
                if (objArr.length != 0) {
                    int f = ScriptRuntime.m6446f(objArr[0]);
                    if (f >= 0) {
                        i = f;
                    } else {
                        i = 0;
                        z = true;
                    }
                } else {
                    i = 0;
                    z = true;
                }
                return realFunction.decompile(i, z ? 1 : 0);
            case 4:
            case 5:
                if (i2 == 4) {
                    z = true;
                }
                return ScriptRuntime.m6345a(z, lVar, drVar, drVar2, objArr);
            case 6:
                if (!(drVar2 instanceof Callable)) {
                    throw ScriptRuntime.m6474o(drVar2);
                }
                Callable eVar = (Callable) drVar2;
                int length = objArr.length;
                if (length > 0) {
                    drVar3 = ScriptRuntime.m6366a(lVar, objArr[0], drVar);
                    objArr2 = new Object[(length - 1)];
                    System.arraycopy(objArr, 1, objArr2, 0, length - 1);
                } else {
                    drVar3 = null;
                    objArr2 = ScriptRuntime.f6517x;
                }
                return new BoundFunction(lVar, drVar, eVar, drVar3, objArr2);
            default:
                throw new IllegalArgumentException(String.valueOf(i2));
        }
    }

    private BaseFunction realFunction(Scriptable drVar, IdFunctionObject ahVar) {
        Object defaultValue = drVar.getDefaultValue(ScriptRuntime.f6509p);
        if (defaultValue instanceof BaseFunction) {
            return (BaseFunction) defaultValue;
        }
        throw ScriptRuntime.m6414b("msg.incompat.call", ahVar.getFunctionName());
    }

    public void setImmunePrototypeProperty(Object obj) {
        if ((this.prototypePropertyAttributes & 1) != 0) {
            throw new IllegalStateException();
        }
        if (obj == null) {
            obj = UniqueTag.f6691b;
        }
        this.prototypeProperty = obj;
        this.prototypePropertyAttributes = 7;
    }

    /* access modifiers changed from: protected */
    public Scriptable getClassPrototype() {
        Object prototypeProperty2 = getPrototypeProperty();
        if (prototypeProperty2 instanceof Scriptable) {
            return (Scriptable) prototypeProperty2;
        }
        return ScriptableObject.getObjectPrototype(this);
    }

    public Object call(Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        return Undefined.f6689a;
    }

    public Scriptable construct(Context lVar, Scriptable drVar, Object[] objArr) {
        Scriptable createObject = createObject(lVar, drVar);
        if (createObject != null) {
            Object call = call(lVar, drVar, createObject, objArr);
            if (call instanceof Scriptable) {
                return (Scriptable) call;
            }
            return createObject;
        }
        Object call2 = call(lVar, drVar, null, objArr);
        if (!(call2 instanceof Scriptable)) {
            throw new IllegalStateException("Bad implementaion of call as constructor, name=" + getFunctionName() + " in " + getClass().getName());
        }
        Scriptable drVar2 = (Scriptable) call2;
        if (drVar2.getPrototype() == null) {
            Scriptable classPrototype = getClassPrototype();
            if (drVar2 != classPrototype) {
                drVar2.setPrototype(classPrototype);
            }
        }
        if (drVar2.getParentScope() != null) {
            return drVar2;
        }
        Scriptable parentScope = getParentScope();
        if (drVar2 == parentScope) {
            return drVar2;
        }
        drVar2.setParentScope(parentScope);
        return drVar2;
    }

    public Scriptable createObject(Context lVar, Scriptable drVar) {
        NativeObject cbVar = new NativeObject();
        cbVar.setPrototype(getClassPrototype());
        cbVar.setParentScope(getParentScope());
        return cbVar;
    }

    /* access modifiers changed from: 0000 */
    public String decompile(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = (i2 & 1) != 0;
        if (!z) {
            stringBuffer.append("function ");
            stringBuffer.append(getFunctionName());
            stringBuffer.append("() {\n\t");
        }
        stringBuffer.append("[native code, arity=");
        stringBuffer.append(getArity());
        stringBuffer.append("]\n");
        if (!z) {
            stringBuffer.append("}\n");
        }
        return stringBuffer.toString();
    }

    public int getArity() {
        return 0;
    }

    public int getLength() {
        return 0;
    }

    public String getFunctionName() {
        return "";
    }

    /* access modifiers changed from: protected */
    public boolean hasPrototypeProperty() {
        return this.prototypeProperty != null || (this instanceof NativeFunction);
    }

    /* access modifiers changed from: protected */
    public Object getPrototypeProperty() {
        Object obj = this.prototypeProperty;
        if (obj == null) {
            if (this instanceof NativeFunction) {
                return setupDefaultPrototype();
            }
            return Undefined.f6689a;
        } else if (obj == UniqueTag.f6691b) {
            return null;
        } else {
            return obj;
        }
    }

    private synchronized Object setupDefaultPrototype() {
        NativeObject cbVar;
        if (this.prototypeProperty != null) {
            cbVar = (NativeObject) this.prototypeProperty;
        } else {
            cbVar = new NativeObject();
            cbVar.defineProperty("constructor", (Object) this, 2);
            this.prototypeProperty = cbVar;
            Scriptable objectPrototype = getObjectPrototype(this);
            if (objectPrototype != cbVar) {
                cbVar.setPrototype(objectPrototype);
            }
        }
        return cbVar;
    }

    private Object getArguments() {
        Object defaultGet = defaultGet("arguments");
        if (defaultGet != f6533j) {
            return defaultGet;
        }
        NativeCall a = ScriptRuntime.m6359a(Context.m6769k(), (Function) this);
        if (a == null) {
            return null;
        }
        return a.get("arguments", a);
    }

    private static Object jsConstructor(Context lVar, Scriptable drVar, Object[] objArr) {
        int length = objArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("function ");
        if (lVar.f6785i != 120) {
            stringBuffer.append("anonymous");
        }
        stringBuffer.append(CoreConstants.LEFT_PARENTHESIS_CHAR);
        for (int i = 0; i < length - 1; i++) {
            if (i > 0) {
                stringBuffer.append(CoreConstants.COMMA_CHAR);
            }
            stringBuffer.append(ScriptRuntime.m6436d(objArr[i]));
        }
        stringBuffer.append(") {");
        if (length != 0) {
            stringBuffer.append(ScriptRuntime.m6436d(objArr[length - 1]));
        }
        stringBuffer.append("\n}");
        String stringBuffer2 = stringBuffer.toString();
        int[] iArr = new int[1];
        String a = Context.m6748a(iArr);
        if (a == null) {
            a = "<eval'ed string>";
            iArr[0] = 1;
        }
        String a2 = ScriptRuntime.m6356a(false, a, iArr[0]);
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(drVar);
        ErrorReporter a3 = DefaultErrorReporter.m6816a(lVar.mo19139d());
        Evaluator l = Context.m6770l();
        if (l != null) {
            return lVar.mo19135a(topLevelScope, stringBuffer2, l, a3, a2);
        }
        throw new JavaScriptException("Interpreter not present", a, iArr[0]);
    }

    /* access modifiers changed from: protected */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findPrototypeId(String r7) {
        /*
            r6 = this;
            r2 = 3
            r0 = 0
            r1 = 0
            int r3 = r7.length()
            switch(r3) {
                case 4: goto L_0x0017;
                case 5: goto L_0x0031;
                case 6: goto L_0x000a;
                case 7: goto L_0x000a;
                case 8: goto L_0x0038;
                case 9: goto L_0x000a;
                case 10: goto L_0x000a;
                case 11: goto L_0x0051;
                default: goto L_0x000a;
            }
        L_0x000a:
            r2 = r1
            r1 = r0
        L_0x000c:
            if (r2 == 0) goto L_0x0058
            if (r2 == r7) goto L_0x0058
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x0058
        L_0x0016:
            return r0
        L_0x0017:
            char r2 = r7.charAt(r0)
            r3 = 98
            if (r2 != r3) goto L_0x0026
            java.lang.String r1 = "bind"
            r2 = 6
            r5 = r1
            r1 = r2
            r2 = r5
            goto L_0x000c
        L_0x0026:
            r3 = 99
            if (r2 != r3) goto L_0x000a
            java.lang.String r1 = "call"
            r2 = 5
            r5 = r1
            r1 = r2
            r2 = r5
            goto L_0x000c
        L_0x0031:
            java.lang.String r1 = "apply"
            r2 = 4
            r5 = r1
            r1 = r2
            r2 = r5
            goto L_0x000c
        L_0x0038:
            char r3 = r7.charAt(r2)
            r4 = 111(0x6f, float:1.56E-43)
            if (r3 != r4) goto L_0x0046
            java.lang.String r1 = "toSource"
            r5 = r1
            r1 = r2
            r2 = r5
            goto L_0x000c
        L_0x0046:
            r2 = 116(0x74, float:1.63E-43)
            if (r3 != r2) goto L_0x000a
            java.lang.String r1 = "toString"
            r2 = 2
            r5 = r1
            r1 = r2
            r2 = r5
            goto L_0x000c
        L_0x0051:
            java.lang.String r1 = "constructor"
            r2 = 1
            r5 = r1
            r1 = r2
            r2 = r5
            goto L_0x000c
        L_0x0058:
            r0 = r1
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.BaseFunction.findPrototypeId(java.lang.String):int");
    }
}
