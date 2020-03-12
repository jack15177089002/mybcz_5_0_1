package com.baicizhan.client.business.util.Aa;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* renamed from: com.f.a.bf */
public interface Target {
    void onBitmapFailed(Drawable drawable);

    void onBitmapLoaded(Bitmap bitmap, C1573an anVar);

    void onPrepareLoad(Drawable drawable);
}
