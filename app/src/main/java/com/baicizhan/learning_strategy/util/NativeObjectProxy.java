package com.baicizhan.learning_strategy.util;

import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.ScriptableObject;

public abstract class NativeObjectProxy {
    protected NativeObject nativeObject = null;

    public NativeObjectProxy(NativeObject cbVar) {
        if (cbVar == null) {
            throw new IllegalArgumentException("NativeObject is null!");
        }
        this.nativeObject = cbVar;
    }

    public NativeObject nativeObject() {
        return this.nativeObject;
    }

    public void putAttribute(String str, Object obj) {
        this.nativeObject.put(str, this.nativeObject, obj);
    }

    /* access modifiers changed from: protected */
    public Object getAttribute(String str, Object obj) {
        Object obj2 = this.nativeObject.get(str, this.nativeObject);
        return obj2 == null ? obj : obj2;
    }

    public String getStringAttribute(String str, String str2) {
        Object attribute = getAttribute(str, null);
        if (attribute == null) {
            return str2;
        }
        try {
            return (String) attribute;
        } catch (Exception e) {
            return str2;
        }
    }

    public int getIntAttribute(String str, int i) {
        Object attribute = getAttribute(str, null);
        if (attribute == null) {
            return i;
        }
        try {
            return ((Integer) attribute).intValue();
        } catch (Exception e) {
            try {
                return (int) ((Double) attribute).doubleValue();
            } catch (Exception e2) {
                return i;
            }
        }
    }

    public long getLongAttribute(String str, long j) {
        Object attribute = getAttribute(str, null);
        if (attribute == null) {
            return j;
        }
        try {
            return ((Long) attribute).longValue();
        } catch (Exception e) {
            try {
                return (long) ((Double) attribute).doubleValue();
            } catch (Exception e2) {
                return j;
            }
        }
    }

    public boolean getBooleanAttribute(String str, boolean z) {
        Object attribute = getAttribute(str, null);
        if (attribute == null) {
            return z;
        }
        try {
            return ((Boolean) attribute).booleanValue();
        } catch (Exception e) {
            return z;
        }
    }

    public Object invokeObject(String str, Object obj, Object... objArr) {
        Object callMethod = ScriptableObject.callMethod(this.nativeObject, str, objArr);
        return callMethod == null ? obj : callMethod;
    }

    public NativeObject invokeNativeObject(String str, NativeObject cbVar, Object... objArr) {
        try {
            return (NativeObject) invokeObject(str, cbVar, objArr);
        } catch (Exception e) {
            return cbVar;
        }
    }

    public NativeArray invokeNativeArray(String str, NativeArray bcVar, Object... objArr) {
        try {
            return (NativeArray) invokeObject(str, bcVar, objArr);
        } catch (Exception e) {
            return bcVar;
        }
    }

    public boolean invokeBoolean(String str, boolean z, Object... objArr) {
        try {
            return ((Boolean) invokeObject(str, Boolean.valueOf(z), objArr)).booleanValue();
        } catch (Exception e) {
            return z;
        }
    }

    /* access modifiers changed from: protected */
    public double invokeDouble(String str, double d, Object... objArr) {
        try {
            return ((Double) invokeObject(str, Double.valueOf(d), objArr)).doubleValue();
        } catch (Exception e) {
            return d;
        }
    }

    public int invokeInt(String str, int i, Object... objArr) {
        try {
            return (int) invokeDouble(str, (double) i, objArr);
        } catch (Exception e) {
            return i;
        }
    }

    /* access modifiers changed from: protected */
    public long invokeLong(String str, long j, Object... objArr) {
        try {
            return (long) invokeDouble(str, (double) j, objArr);
        } catch (Exception e) {
            return j;
        }
    }

    /* access modifiers changed from: protected */
    public String invokeString(String str, String str2, Object... objArr) {
        try {
            return (String) invokeObject(str, str2, objArr);
        } catch (Exception e) {
            return str2;
        }
    }

    public void invokeVoid(String str, Object... objArr) {
        invokeObject(str, null, objArr);
    }
}
