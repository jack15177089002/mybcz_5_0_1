package p012ch.qos.logback.core.util;

import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import p012ch.qos.logback.core.Context;

/* renamed from: ch.qos.logback.core.util.Loader */
public class Loader {
    private static boolean HAS_GET_CLASS_LOADER_PERMISSION = false;
    public static final String IGNORE_TCL_PROPERTY_NAME = "logback.ignoreTCL";
    static final String TSTR = "Caught Exception while in Loader.getResource. This may be innocuous.";
    private static boolean ignoreTCL;

    static {
        ignoreTCL = false;
        HAS_GET_CLASS_LOADER_PERMISSION = false;
        String systemProperty = OptionHelper.getSystemProperty(IGNORE_TCL_PROPERTY_NAME, null);
        if (systemProperty != null) {
            ignoreTCL = Boolean.valueOf(systemProperty).booleanValue();
        }
        HAS_GET_CLASS_LOADER_PERMISSION = ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() {
            public Boolean run() {
                try {
                    AccessController.checkPermission(new RuntimePermission("getClassLoader"));
                    return Boolean.valueOf(true);
                } catch (SecurityException e) {
                    return Boolean.valueOf(false);
                }
            }
        })).booleanValue();
    }

    public static Set<URL> getResourceOccurrenceCount(String str, ClassLoader classLoader) {
        HashSet hashSet = new HashSet();
        Enumeration resources = classLoader.getResources(str);
        while (resources.hasMoreElements()) {
            hashSet.add((URL) resources.nextElement());
        }
        return hashSet;
    }

    public static URL getResource(String str, ClassLoader classLoader) {
        try {
            return classLoader.getResource(str);
        } catch (Throwable th) {
            return null;
        }
    }

    public static URL getResourceBySelfClassLoader(String str) {
        return getResource(str, getClassLoaderOfClass(Loader.class));
    }

    public static ClassLoader getTCL() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?> loadClass(String str, Context context) {
        return getClassLoaderOfObject(context).loadClass(str);
    }

    public static ClassLoader getClassLoaderOfObject(Object obj) {
        if (obj != null) {
            return getClassLoaderOfClass(obj.getClass());
        }
        throw new NullPointerException("Argument cannot be null");
    }

    public static ClassLoader getClassLoaderAsPrivileged(final Class<?> cls) {
        if (!HAS_GET_CLASS_LOADER_PERMISSION) {
            return null;
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() {
            public ClassLoader run() {
                return cls.getClassLoader();
            }
        });
    }

    public static ClassLoader getClassLoaderOfClass(Class<?> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return classLoader;
    }

    public static Class<?> loadClass(String str) {
        if (ignoreTCL) {
            return Class.forName(str);
        }
        try {
            return getTCL().loadClass(str);
        } catch (Throwable th) {
            return Class.forName(str);
        }
    }
}
