package org.mozilla.javascript;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* renamed from: org.mozilla.javascript.ai */
public abstract class IdScriptableObject extends ScriptableObject implements IdFunctionCall {
    private transient C2134aj prototypeValues;

    public IdScriptableObject() {
    }

    public IdScriptableObject(Scriptable drVar, Scriptable drVar2) {
        super(drVar, drVar2);
    }

    /* access modifiers changed from: protected */
    public final Object defaultGet(String str) {
        return super.get(str, (Scriptable) this);
    }

    /* access modifiers changed from: protected */
    public final void defaultPut(String str, Object obj) {
        super.put(str, (Scriptable) this, obj);
    }

    public boolean has(String str, Scriptable drVar) {
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo == 0) {
            if (this.prototypeValues != null) {
                int a = this.prototypeValues.mo18668a(str);
                if (a != 0) {
                    Object[] objArr = this.prototypeValues.f6002c;
                    if (objArr == null) {
                        return true;
                    }
                    Object obj = objArr[(a - 1) * 2];
                    if (obj == null || obj != Scriptable.f6533j) {
                        return true;
                    }
                    return false;
                }
            }
            return super.has(str, drVar);
        } else if (((findInstanceIdInfo >>> 16) & 4) != 0) {
            return true;
        } else {
            if (f6533j == getInstanceIdValue(findInstanceIdInfo & 65535)) {
                return false;
            }
            return true;
        }
    }

    public Object get(String str, Scriptable drVar) {
        Object obj = super.get(str, drVar);
        if (obj != f6533j) {
            return obj;
        }
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0) {
            Object instanceIdValue = getInstanceIdValue(findInstanceIdInfo & 65535);
            if (instanceIdValue != f6533j) {
                return instanceIdValue;
            }
        }
        if (this.prototypeValues != null) {
            int a = this.prototypeValues.mo18668a(str);
            if (a != 0) {
                Object a2 = this.prototypeValues.mo18669a(a);
                if (a2 != f6533j) {
                    return a2;
                }
            }
        }
        return f6533j;
    }

    public void put(String str, Scriptable drVar, Object obj) {
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo == 0) {
            if (this.prototypeValues != null) {
                int a = this.prototypeValues.mo18668a(str);
                if (a != 0) {
                    if (drVar != this || !isSealed()) {
                        this.prototypeValues.mo18672a(a, drVar, obj);
                        return;
                    }
                    throw Context.m6755a("msg.modify.sealed", (Object) str);
                }
            }
            super.put(str, drVar, obj);
        } else if (drVar == this && isSealed()) {
            throw Context.m6755a("msg.modify.sealed", (Object) str);
        } else if (((findInstanceIdInfo >>> 16) & 1) != 0) {
        } else {
            if (drVar == this) {
                setInstanceIdValue(findInstanceIdInfo & 65535, obj);
            } else {
                drVar.put(str, drVar, obj);
            }
        }
    }

    public void delete(String str) {
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo == 0 || isSealed()) {
            if (this.prototypeValues != null) {
                int a = this.prototypeValues.mo18668a(str);
                if (a != 0) {
                    if (!isSealed()) {
                        this.prototypeValues.mo18673b(a);
                        return;
                    }
                    return;
                }
            }
            super.delete(str);
        } else if (((findInstanceIdInfo >>> 16) & 4) == 0) {
            setInstanceIdValue(findInstanceIdInfo & 65535, f6533j);
        }
    }

    public int getAttributes(String str) {
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0) {
            return findInstanceIdInfo >>> 16;
        }
        if (this.prototypeValues != null) {
            int a = this.prototypeValues.mo18668a(str);
            if (a != 0) {
                return this.prototypeValues.mo18674c(a);
            }
        }
        return super.getAttributes(str);
    }

    public void setAttributes(String str, int i) {
        ScriptableObject.checkValidAttributes(i);
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0) {
            int i2 = 65535 & findInstanceIdInfo;
            if (i != (findInstanceIdInfo >>> 16)) {
                setInstanceIdAttributes(i2, i);
                return;
            }
            return;
        }
        if (this.prototypeValues != null) {
            int a = this.prototypeValues.mo18668a(str);
            if (a != 0) {
                this.prototypeValues.mo18670a(a, i);
                return;
            }
        }
        super.setAttributes(str, i);
    }

    /* access modifiers changed from: 0000 */
    public Object[] getIds(boolean z) {
        Object[] objArr;
        Object[] objArr2;
        int i;
        int i2;
        Object[] ids = super.getIds(z);
        if (this.prototypeValues != null) {
            C2134aj ajVar = this.prototypeValues;
            int i3 = 1;
            int i4 = 0;
            objArr = null;
            while (i3 <= ajVar.f6001b) {
                Object d = ajVar.mo18675d(i3);
                if ((z || (ajVar.f6003d[i3 - 1] & 2) == 0) && d != Scriptable.f6533j) {
                    String str = (String) ajVar.f6002c[((i3 - 1) * 2) + 1];
                    if (objArr == null) {
                        objArr = new Object[ajVar.f6001b];
                    }
                    int i5 = i4 + 1;
                    objArr[i4] = str;
                    i2 = i5;
                } else {
                    i2 = i4;
                }
                i3++;
                i4 = i2;
            }
            if (i4 == 0) {
                objArr = ids;
            } else if (ids != null && ids.length != 0) {
                int length = ids.length;
                Object[] objArr3 = new Object[(length + i4)];
                System.arraycopy(ids, 0, objArr3, 0, length);
                System.arraycopy(objArr, 0, objArr3, length, i4);
                objArr = objArr3;
            } else if (i4 != objArr.length) {
                Object[] objArr4 = new Object[i4];
                System.arraycopy(objArr, 0, objArr4, 0, i4);
                objArr = objArr4;
            }
        } else {
            objArr = ids;
        }
        int maxInstanceId = getMaxInstanceId();
        if (maxInstanceId == 0) {
            return objArr;
        }
        int i6 = 0;
        int i7 = maxInstanceId;
        Object[] objArr5 = null;
        while (i7 != 0) {
            String instanceIdName = getInstanceIdName(i7);
            int findInstanceIdInfo = findInstanceIdInfo(instanceIdName);
            if (findInstanceIdInfo != 0) {
                int i8 = findInstanceIdInfo >>> 16;
                if (!((i8 & 4) == 0 && f6533j == getInstanceIdValue(i7)) && (z || (i8 & 2) == 0)) {
                    if (i6 == 0) {
                        objArr5 = new Object[i7];
                    }
                    int i9 = i6 + 1;
                    objArr5[i6] = instanceIdName;
                    objArr2 = objArr5;
                    i = i9;
                    i7--;
                    Object[] objArr6 = objArr2;
                    i6 = i;
                    objArr5 = objArr6;
                }
            }
            int i10 = i6;
            objArr2 = objArr5;
            i = i10;
            i7--;
            Object[] objArr62 = objArr2;
            i6 = i;
            objArr5 = objArr62;
        }
        if (i6 == 0) {
            return objArr;
        }
        if (objArr.length == 0 && objArr5.length == i6) {
            return objArr5;
        }
        Object[] objArr7 = new Object[(objArr.length + i6)];
        System.arraycopy(objArr, 0, objArr7, 0, objArr.length);
        System.arraycopy(objArr5, 0, objArr7, objArr.length, i6);
        return objArr7;
    }

    public int getMaxInstanceId() {
        return 0;
    }

    public static int instanceIdInfo(int i, int i2) {
        return (i << 16) | i2;
    }

    public int findInstanceIdInfo(String str) {
        return 0;
    }

    public String getInstanceIdName(int i) {
        throw new IllegalArgumentException(String.valueOf(i));
    }

    public Object getInstanceIdValue(int i) {
        throw new IllegalStateException(String.valueOf(i));
    }

    public void setInstanceIdValue(int i, Object obj) {
        throw new IllegalStateException(String.valueOf(i));
    }

    /* access modifiers changed from: protected */
    public void setInstanceIdAttributes(int i, int i2) {
        throw ScriptRuntime.m6375a("InternalError", "Changing attributes not supported for " + getClassName() + " " + getInstanceIdName(i) + " property");
    }

    public Object execIdCall(IdFunctionObject ahVar, Context lVar, Scriptable drVar, Scriptable drVar2, Object[] objArr) {
        throw ahVar.mo18644b();
    }

    public final IdFunctionObject exportAsJSClass(int i, Scriptable drVar, boolean z) {
        if (!(drVar == this || drVar == null)) {
            setParentScope(drVar);
            setPrototype(getObjectPrototype(drVar));
        }
        activatePrototypeMap(i);
        C2134aj ajVar = this.prototypeValues;
        if (ajVar.f6004e != 0) {
            throw new IllegalStateException();
        }
        ajVar.f6004e = ajVar.f6000a.findPrototypeId("constructor");
        if (ajVar.f6004e == 0) {
            throw new IllegalStateException("No id for constructor property");
        }
        ajVar.f6000a.initPrototypeId(ajVar.f6004e);
        if (ajVar.f6005f == null) {
            throw new IllegalStateException(ajVar.f6000a.getClass().getName() + ".initPrototypeId() did not initialize id=" + ajVar.f6004e);
        }
        IdFunctionObject ahVar = ajVar.f6005f;
        String className = ajVar.f6000a.getClassName();
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(ajVar.f6000a);
        if (className == null) {
            throw new IllegalArgumentException();
        } else if (topLevelScope == null) {
            throw new IllegalArgumentException();
        } else {
            ahVar.f5995b = className;
            ahVar.setParentScope(topLevelScope);
            ajVar.f6005f.mo18642a((Scriptable) ajVar.f6000a);
            IdFunctionObject ahVar2 = ajVar.f6005f;
            if (z) {
                sealObject();
            }
            fillConstructorProperties(ahVar2);
            if (z) {
                ahVar2.sealObject();
            }
            ahVar2.mo18641a();
            return ahVar2;
        }
    }

    public final boolean hasPrototypeMap() {
        return this.prototypeValues != null;
    }

    public final void activatePrototypeMap(int i) {
        C2134aj ajVar = new C2134aj(this, i);
        synchronized (this) {
            if (this.prototypeValues != null) {
                throw new IllegalStateException();
            }
            this.prototypeValues = ajVar;
        }
    }

    public final void initPrototypeMethod(Object obj, int i, String str, int i2) {
        this.prototypeValues.mo18671a(i, str, newIdFunction(obj, i, str, i2, ScriptableObject.getTopLevelScope(this)), 2);
    }

    public final void initPrototypeConstructor(IdFunctionObject ahVar) {
        int i = this.prototypeValues.f6004e;
        if (i == 0) {
            throw new IllegalStateException();
        } else if (ahVar.f5994a != i) {
            throw new IllegalArgumentException();
        } else {
            if (isSealed()) {
                ahVar.sealObject();
            }
            this.prototypeValues.mo18671a(i, "constructor", ahVar, 2);
        }
    }

    public final void initPrototypeValue(int i, String str, Object obj, int i2) {
        this.prototypeValues.mo18671a(i, str, obj, i2);
    }

    public void initPrototypeId(int i) {
        throw new IllegalStateException(String.valueOf(i));
    }

    public int findPrototypeId(String str) {
        throw new IllegalStateException(str);
    }

    /* access modifiers changed from: protected */
    public void fillConstructorProperties(IdFunctionObject ahVar) {
    }

    /* access modifiers changed from: protected */
    public void addIdFunctionProperty(Scriptable drVar, Object obj, int i, String str, int i2) {
        newIdFunction(obj, i, str, i2, ScriptableObject.getTopLevelScope(drVar)).mo18645b(drVar);
    }

    public static EcmaError incompatibleCallError(IdFunctionObject ahVar) {
        throw ScriptRuntime.m6414b("msg.incompat.call", ahVar.getFunctionName());
    }

    private IdFunctionObject newIdFunction(Object obj, int i, String str, int i2, Scriptable drVar) {
        IdFunctionObject ahVar = new IdFunctionObject(this, obj, i, str, i2, drVar);
        if (isSealed()) {
            ahVar.sealObject();
        }
        return ahVar;
    }

    public void defineOwnProperty(Context lVar, Object obj, ScriptableObject dsVar) {
        if (obj instanceof String) {
            String str = (String) obj;
            int findInstanceIdInfo = findInstanceIdInfo(str);
            if (findInstanceIdInfo != 0) {
                int i = 65535 & findInstanceIdInfo;
                if (isAccessorDescriptor(dsVar)) {
                    delete(i);
                } else {
                    checkPropertyDefinition(dsVar);
                    checkPropertyChange(str, getOwnPropertyDescriptor(lVar, obj), dsVar);
                    int i2 = findInstanceIdInfo >>> 16;
                    Object property = getProperty((Scriptable) dsVar, "value");
                    if (property != f6533j && (i2 & 1) == 0 && !sameValue(property, getInstanceIdValue(i))) {
                        setInstanceIdValue(i, property);
                    }
                    setAttributes(str, applyDescriptorToAttributeBitset(i2, dsVar));
                    return;
                }
            }
            if (this.prototypeValues != null) {
                int a = this.prototypeValues.mo18668a(str);
                if (a != 0) {
                    if (isAccessorDescriptor(dsVar)) {
                        this.prototypeValues.mo18673b(a);
                    } else {
                        checkPropertyDefinition(dsVar);
                        checkPropertyChange(str, getOwnPropertyDescriptor(lVar, obj), dsVar);
                        int c = this.prototypeValues.mo18674c(a);
                        Object property2 = getProperty((Scriptable) dsVar, "value");
                        if (property2 != f6533j && (c & 1) == 0 && !sameValue(property2, this.prototypeValues.mo18669a(a))) {
                            this.prototypeValues.mo18672a(a, this, property2);
                        }
                        this.prototypeValues.mo18670a(a, applyDescriptorToAttributeBitset(c, dsVar));
                        return;
                    }
                }
            }
        }
        super.defineOwnProperty(lVar, obj, dsVar);
    }

    /* access modifiers changed from: protected */
    public ScriptableObject getOwnPropertyDescriptor(Context lVar, Object obj) {
        ScriptableObject ownPropertyDescriptor = super.getOwnPropertyDescriptor(lVar, obj);
        if (ownPropertyDescriptor != null || !(obj instanceof String)) {
            return ownPropertyDescriptor;
        }
        return getBuiltInDescriptor((String) obj);
    }

    private ScriptableObject getBuiltInDescriptor(String str) {
        Scriptable parentScope = getParentScope();
//        if (parentScope == 0) {
//            parentScope = this;
//        }
        int findInstanceIdInfo = findInstanceIdInfo(str);
        if (findInstanceIdInfo != 0) {
            return buildDataDescriptor(parentScope, getInstanceIdValue(65535 & findInstanceIdInfo), findInstanceIdInfo >>> 16);
        }
        if (this.prototypeValues != null) {
            int a = this.prototypeValues.mo18668a(str);
            if (a != 0) {
                return buildDataDescriptor(parentScope, this.prototypeValues.mo18669a(a), this.prototypeValues.mo18674c(a));
            }
        }
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) {
//        objectInputStream.defaultReadObject();
//        int readInt = objectInputStream.readInt();
//        if (readInt != 0) {
//            activatePrototypeMap(readInt);
//        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
//        objectOutputStream.defaultWriteObject();
//        int i = 0;
//        if (this.prototypeValues != null) {
//            i = this.prototypeValues.f6001b;
//        }
//        objectOutputStream.writeInt(i);
    }
}
