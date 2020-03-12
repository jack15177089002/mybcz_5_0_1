package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.em */
public final class WrapFactory {

    /* renamed from: a */
    private boolean f6695a = true;

    /* renamed from: a */
    public final Object mo19103a(Scriptable drVar, Object obj, Class<?> cls) {
        if (obj == null || obj == Undefined.f6689a || (obj instanceof Scriptable)) {
            return obj;
        }
        if (cls == null || !cls.isPrimitive()) {
            if (!this.f6695a) {
                if ((obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean)) {
                    return obj;
                }
                if (obj instanceof Character) {
                    return String.valueOf(((Character) obj).charValue());
                }
            }
            if (obj.getClass().isArray()) {
                return NativeJavaArray.m6073a(drVar, obj);
            }
            return m6664b(drVar, obj, cls);
        } else if (cls == Void.TYPE) {
            return Undefined.f6689a;
        } else {
            if (cls == Character.TYPE) {
                return Integer.valueOf(((Character) obj).charValue());
            }
            return obj;
        }
    }

    /* renamed from: b */
    public static Scriptable m6664b(Scriptable drVar, Object obj, Class<?> cls) {
        return new NativeJavaObject(drVar, obj, cls);
    }
}
