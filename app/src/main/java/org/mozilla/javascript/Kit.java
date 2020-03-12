package org.mozilla.javascript;

import com.baicizhan.main.utils.GuideFlags;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: org.mozilla.javascript.ax */
public final class Kit {

    /* renamed from: a */
    private static Method f6091a;

    static {
        f6091a = null;
        try {
            Class a = m5805a("java.lang.Throwable");
            f6091a = a.getMethod("initCause", new Class[]{a});
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static Class<?> m5805a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException | IllegalArgumentException | LinkageError | SecurityException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static Class<?> m5804a(ClassLoader classLoader, String str) {
        try {
            return classLoader.loadClass(str);
        } catch (ClassNotFoundException | IllegalArgumentException | LinkageError | SecurityException e) {
            return null;
        }
    }

    /* renamed from: a */
    static Object m5806a(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException | InstantiationException | LinkageError | SecurityException e) {
            return null;
        }
    }

    /* renamed from: a */
    static boolean m5813a(ClassLoader classLoader) {
        Class<?> cls = ScriptRuntime.f6508o;
        if (m5804a(classLoader, cls.getName()) != cls) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static RuntimeException m5811a(RuntimeException runtimeException, Throwable th) {
        if (f6091a != null) {
            try {
                f6091a.invoke(runtimeException, new Object[]{th});
            } catch (Exception e) {
            }
        }
        return runtimeException;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        if (r0 >= 0) goto L_0x0008;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m5803a(int r2, int r3) {
        /*
            r0 = 57
            if (r2 > r0) goto L_0x000c
            int r0 = r2 + -48
            if (r0 < 0) goto L_0x0022
        L_0x0008:
            int r1 = r3 << 4
            r0 = r0 | r1
        L_0x000b:
            return r0
        L_0x000c:
            r0 = 70
            if (r2 > r0) goto L_0x0017
            r0 = 65
            if (r0 > r2) goto L_0x0022
            int r0 = r2 + -55
            goto L_0x0008
        L_0x0017:
            r0 = 102(0x66, float:1.43E-43)
            if (r2 > r0) goto L_0x0022
            r0 = 97
            if (r0 > r2) goto L_0x0022
            int r0 = r2 + -87
            goto L_0x0008
        L_0x0022:
            r0 = -1
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Kit.m5803a(int, int):int");
    }

    /* renamed from: a */
    public static Object m5807a(Object obj, int i) {
        if (i == 0) {
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof Object[])) {
                return obj;
            }
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                return objArr[0];
            }
            throw new IllegalArgumentException();
        } else if (i != 1) {
            Object[] objArr2 = (Object[]) obj;
            int length = objArr2.length;
            if (length < 2) {
                throw new IllegalArgumentException();
            } else if (i == length) {
                return null;
            } else {
                return objArr2[i];
            }
        } else if (obj instanceof Object[]) {
            return ((Object[]) obj)[1];
        } else {
            if (obj != null) {
                return null;
            }
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    static Object m5809a(Map<Object, Object> map, Object obj, Object obj2) {
        synchronized (map) {
            Object obj3 = map.get(obj);
            if (obj3 == null) {
                map.put(obj, obj2);
            } else {
                obj2 = obj3;
            }
        }
        return obj2;
    }

    /* renamed from: a */
    public static Object m5808a(Object obj, Object obj2) {
        if (obj == null) {
            throw new IllegalArgumentException();
        } else if (obj2 != null) {
            return new C2142ay(obj, obj2);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public static String m5812a(Reader reader) {
        char[] cArr = new char[GuideFlags.FLAG_PATTERN_3];
        int i = 0;
        while (true) {
            int read = reader.read(cArr, i, cArr.length - i);
            if (read < 0) {
                return new String(cArr, 0, i);
            }
            i += read;
            if (i == cArr.length) {
                char[] cArr2 = new char[(cArr.length * 2)];
                System.arraycopy(cArr, 0, cArr2, 0, i);
                cArr = cArr2;
            }
        }
    }

    /* renamed from: a */
    public static RuntimeException m5810a() {
        IllegalStateException illegalStateException = new IllegalStateException("FAILED ASSERTION");
        illegalStateException.printStackTrace(System.err);
        throw illegalStateException;
    }

    /* renamed from: b */
    public static RuntimeException m5814b(String str) {
        IllegalStateException illegalStateException = new IllegalStateException("FAILED ASSERTION: " + str);
        illegalStateException.printStackTrace(System.err);
        throw illegalStateException;
    }
}
