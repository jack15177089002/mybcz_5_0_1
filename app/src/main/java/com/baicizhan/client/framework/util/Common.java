package com.baicizhan.client.framework.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
//import com.tencent.android.tpush.common.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Common {
    public static final String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
//            for (byte b : digest) {
//                String hexString = Integer.toHexString(b & Constants.NETWORK_TYPE_UNCONNECTED);
//                while (hexString.length() < 2) {
//                    hexString = "0" + hexString;
//                }
//                sb.append(hexString);
//            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int dip2px(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static DisplayMetrics getScreenMetrics(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int getScreenHeight(Context context) {
        return getScreenHeight(context, 0);
    }

    public static int getScreenHeight(Context context, int i) {
        DisplayMetrics screenMetrics = getScreenMetrics(context);
        if (1 == i) {
            return px2dip(context, (float) screenMetrics.heightPixels);
        }
        return screenMetrics.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return getScreenWidth(context, 0);
    }

    public static int getScreenWidth(Context context, int i) {
        DisplayMetrics screenMetrics = getScreenMetrics(context);
        if (1 == i) {
            return px2dip(context, (float) screenMetrics.widthPixels);
        }
        return screenMetrics.widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        int dip2px = dip2px(context, 25.0f);
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return dip2px;
    }

    public static ComponentName hasMoreRunningActivity(Context context, String str, String str2) {
        Log.d("caohzh", "filter: " + str2);
//        List<RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningTasks(Integer.MAX_VALUE);
//        if (runningTasks != null) {
//            for (RunningTaskInfo runningTaskInfo : runningTasks) {
//                ComponentName componentName = runningTaskInfo.topActivity;
//                Log.d("caohzh", "filter hou: " + componentName.getClassName());
//                if (componentName.getPackageName().equals(str) && !componentName.getClassName().equals(str2)) {
//                    return componentName;
//                }
//            }
//        }
        return null;
    }

    public static boolean isActivityRunningTop(Context context, String str, String str2) {
//        List runningTasks = ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningTasks(1);
//        if (runningTasks != null) {
//            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
//            if (componentName.getPackageName().equals(str) && componentName.getClassName().equals(str2)) {
//                return true;
//            }
//        }
        return false;
    }

    public static String getProcessName(Context context) {
//        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME)).getRunningAppProcesses()) {
//            try {
//                if (runningAppProcessInfo.pid == Process.myPid()) {
//                    return runningAppProcessInfo.processName;
//                }
//            } catch (Exception e) {
//            }
//        }
        return null;
    }

    public static void setAlpha(int i, View view) {
        if (VERSION.SDK_INT >= 11) {
            doSetAlpha_API11(i, view);
        } else {
            doSetAlpha((i * 255) / 100, view);
        }
    }

    @TargetApi(11)
    private static void doSetAlpha_API11(int i, View view) {
        view.setAlpha(((float) i) / 100.0f);
    }

    private static void doSetAlpha(int i, View view) {
        if (view instanceof ViewGroup) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < ((ViewGroup) view).getChildCount()) {
                    doSetAlpha(i, ((ViewGroup) view).getChildAt(i3));
                    if (((ViewGroup) view).getBackground() != null) {
                        ((ViewGroup) view).getBackground().setAlpha(i);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        } else if (view instanceof ImageView) {
            if (((ImageView) view).getDrawable() != null) {
                ((ImageView) view).getDrawable().setAlpha(i);
            }
            if (((ImageView) view).getBackground() != null) {
                ((ImageView) view).getBackground().setAlpha(i);
            }
        } else if (view instanceof TextView) {
            ((TextView) view).setTextColor(((TextView) view).getTextColors().withAlpha(i));
            if (((TextView) view).getBackground() != null) {
                ((TextView) view).getBackground().setAlpha(i);
            }
        } else if (view instanceof EditText) {
            ((EditText) view).setTextColor(((EditText) view).getTextColors().withAlpha(i));
            if (((EditText) view).getBackground() != null) {
                ((EditText) view).getBackground().setAlpha(i);
            }
        }
    }

    public static boolean isScreenOn(Context context) {
        return ((PowerManager) context.getSystemService("power")).isScreenOn();
    }
}
