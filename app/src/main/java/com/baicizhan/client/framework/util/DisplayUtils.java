package com.baicizhan.client.framework.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Window;

public class DisplayUtils {
    private DisplayUtils() {
        throw new AssertionError();
    }

    public static boolean isLandscape(Context context) {
        if (context != null && context.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public static boolean isLandscapeTablet(Context context) {
        return isLandscape(context) && isTablet(context);
    }

    public static int getDisplayPixelWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getDisplayPixelHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static Point getDisplayPixelSize(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static Point getDisplayDpSize(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new Point((int) (((double) (((float) displayMetrics.widthPixels) / displayMetrics.density)) + 0.5d), (int) (((double) (((float) displayMetrics.heightPixels) / displayMetrics.density)) + 0.5d));
    }

    public static int dpToPx(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int pxToDp(Context context, int i) {
        return (int) (((double) (((float) i) / context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public static boolean isTablet(Context context) {
        if (context != null && (context.getResources().getConfiguration().screenLayout & 15) >= 3) {
            return true;
        }
        return false;
    }

    public static boolean isXLarge(Context context) {
        if ((context.getResources().getConfiguration().screenLayout & 15) == 4) {
            return true;
        }
        return false;
    }

    public static int getActionBarHeight(Context context) {
        if (context == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme() == null || !context.getTheme().resolveAttribute(16843499, typedValue, true)) {
            return dpToPx(context, 48.0f);
        }
        return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
    }

    @TargetApi(11)
    public static boolean hasActionBarOverlay(Window window) {
        return window.hasFeature(9);
    }
}
