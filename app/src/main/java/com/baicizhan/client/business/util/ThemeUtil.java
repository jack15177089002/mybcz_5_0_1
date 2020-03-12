package com.baicizhan.client.business.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
//import com.baicizhan.client.business.R;//import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;
//import com.baicizhan.client.business.dataset.helpers.PropertyHelper;
import com.jiongji.andriod.card.R;

public class ThemeUtil {
    public static void updateTheme(Activity activity) {
        activity.finish();
        activity.overridePendingTransition(17432576, 17432577);
        activity.startActivity(new Intent(activity, activity.getClass()));
        activity.overridePendingTransition(17432576, 17432577);
    }

    public static void setThemeOnActivityCreate(Activity activity) {
        activity.setTheme(getCurrentSettingThemeId());
    }

    public static int getCurrentSettingThemeId() {
        //test

//        if (PropertyHelper.getInt(PropertyHelper.NIGHT_MODE) == 1) {
//            return R.style.StandardNight;
//        }
        return R.style.StandardDefault;
    }

    public static int getThemeColorWithAttr(Context context, int i) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    public static ColorStateList getThemeColorStateListWithAttr(Context context, int i) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
        obtainStyledAttributes.recycle();
        return colorStateList;
    }

    public static int getThemeResourceIdWithAttr(Context context, int i) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Drawable getThemeDrawableWithAttr(Context context, int i) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public static Context ensureThemeContext(Context context) {
        Theme theme = context.getTheme();
        if (theme == null || !theme.resolveAttribute(R.attr.color_common_bg, new TypedValue(), true)) {
            return new ContextThemeWrapper(context, getCurrentSettingThemeId());
        }
        return context;
    }
}
