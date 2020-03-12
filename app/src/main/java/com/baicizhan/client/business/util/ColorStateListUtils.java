package com.baicizhan.client.business.util;

import android.content.Context;
import android.content.res.ColorStateList;

public class ColorStateListUtils {
    public static ColorStateList getSimpleColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{new int[]{16842913}, new int[]{16842919}, new int[0]}, new int[]{i2, i2, i});
    }

    public static ColorStateList getSimpleThemeColorStateListWithAttr(Context context, int i, int i2) {
        return getSimpleColorStateList(ThemeUtil.getThemeColorWithAttr(context, i), ThemeUtil.getThemeColorWithAttr(context, i2));
    }
}
