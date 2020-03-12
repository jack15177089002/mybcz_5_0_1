package com.handmark.pulltorefresh.library.p057a;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;

/* renamed from: com.handmark.pulltorefresh.library.a.j */
/* compiled from: ViewCompat */
public final class C1604j {
    /* renamed from: a */
    public static void m3631a(View view, Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
