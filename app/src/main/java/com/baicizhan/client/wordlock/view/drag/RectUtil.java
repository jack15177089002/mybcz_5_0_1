package com.baicizhan.client.wordlock.view.drag;

import android.graphics.Rect;
import android.view.View;

public final class RectUtil {
    private RectUtil() {
    }

    public static final Rect getRectOnScreen(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new Rect(iArr[0], iArr[1], view.getWidth() + iArr[0], iArr[1] + view.getHeight());
    }
}
