package com.baicizhan.client.business.util;

import android.graphics.Typeface;
import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
import android.util.SparseArray;
import android.widget.TextView;
import com.baicizhan.client.business.BusinessAppHandler;
import java.util.Map;

public abstract class CustomFont {
    public static final String DEFAULT_FONT_ACCENT = "fonts/HelveticaNeue.otf";
    public static final String DEFAULT_FONT_LIGHT = "fonts/DIN-Light.otf";
    public static final String DEFAULT_FONT_LIGHT_NUM = "fonts/DIN-Light-Num.otf";
    public static final String DEFAULT_FONT_REGULAR = "fonts/DIN-Regular.otf";
    public static final int TYPEFACE_ACCENT = 3;
    public static final int TYPEFACE_LIGHT = 1;
    public static final int TYPEFACE_LIGHT_NUM = 2;
    public static final int TYPEFACE_REGULAR = 0;
    private static Map<String, Typeface> typefaceCache = new ArrayMap();
    private static SparseArray<String> whichFontToUseForEachTypefaceStyle;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        whichFontToUseForEachTypefaceStyle = sparseArray;
        sparseArray.put(0, "fonts/DIN-Regular.otf");
        whichFontToUseForEachTypefaceStyle.put(1, "fonts/DIN-Light.otf");
        whichFontToUseForEachTypefaceStyle.put(2, "fonts/DIN-Light-Num.otf");
        whichFontToUseForEachTypefaceStyle.put(3, "fonts/HelveticaNeue.otf");
    }

    private CustomFont() {
    }

    public static Typeface getFont(int i) {
        Typeface typeface = (Typeface) typefaceCache.get(whichFontToUseForEachTypefaceStyle.get(i));
        if (typeface != null) {
            return typeface;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                Typeface createFromAsset = Typeface.createFromAsset(BusinessAppHandler.getApp().getAssets(), (String) whichFontToUseForEachTypefaceStyle.get(i));
                typefaceCache.put(whichFontToUseForEachTypefaceStyle.get(i), createFromAsset);
                return createFromAsset;
            default:
                return typeface;
        }
    }

    public static void setFont(TextView textView, int i) {
        Typeface font = getFont(i);
        if (font != null) {
            textView.setTypeface(font);
        }
    }
}
