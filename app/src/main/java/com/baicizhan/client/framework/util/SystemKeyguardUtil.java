package com.baicizhan.client.framework.util;

import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;

public class SystemKeyguardUtil {
    public static boolean isSecureKeyguard(Context context) {
        if (VERSION.SDK_INT >= 16) {
            return isSecureKeyguard_API16(context);
        }
        try {
            Class cls = Class.forName("com.android.internal.widget.LockPatternUtils");
            return ((Boolean) cls.getMethod("isSecure", new Class[0]).invoke(cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context}), null)).booleanValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (IllegalArgumentException e5) {
            e5.printStackTrace();
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
        }
        return true;
    }

    @TargetApi(16)
    private static boolean isSecureKeyguard_API16(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure();
    }

    @TargetApi(16)
    public static boolean isKeyguardLocked_API16(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardLocked();
    }

    public static boolean isKeyguardLocked(Context context) {
        if (VERSION.SDK_INT >= 16) {
            return isKeyguardLocked_API16(context);
        }
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    public static int getKeyguardStoredPasswordQuality(Context context) {
        try {
            Class cls = Class.forName("com.android.internal.widget.LockPatternUtils");
            return ((Integer) cls.getMethod("getKeyguardStoredPasswordQuality", new Class[0]).invoke(cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context}), null)).intValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (IllegalArgumentException e5) {
            e5.printStackTrace();
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
        }
        return -1;
    }

    public static boolean usingBiometricWeak(Context context) {
        try {
            Class cls = Class.forName("com.android.internal.widget.LockPatternUtils");
            return ((Boolean) cls.getMethod("usingBiometricWeak", new Class[0]).invoke(cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context}), null)).booleanValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (IllegalArgumentException e5) {
            e5.printStackTrace();
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
        }
        return false;
    }
}
