package com.baicizhan.client.business.util;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class SystemUtil {
    private SystemUtil() {
    }

    public static void showIME(View view) {
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 2);
        }
    }

    public static void hideIME(View view) {
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
