package com.baicizhan.client.business.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
//import com.p055f.p056a.C1573an;
//import com.p055f.p056a.Target;
import com.baicizhan.client.business.util.Aa.C1573an;
import com.baicizhan.client.business.util.Aa.Target;

import java.util.HashSet;

public abstract class StrongRefTarget implements Target {
    private static HashSet<Target> mTargetSet = new HashSet<>();

    public abstract void onBitmapFailedImpl(Drawable drawable);

    public abstract void onBitmapLoadedImpl(Bitmap bitmap, C1573an anVar);

    public abstract void onPrepareLoadImpl(Drawable drawable);

    public final void onBitmapLoaded(Bitmap bitmap, C1573an anVar) {
        onBitmapLoadedImpl(bitmap, anVar);
        mTargetSet.remove(this);
    }

    public final void onBitmapFailed(Drawable drawable) {
        onBitmapFailedImpl(drawable);
        mTargetSet.remove(this);
    }

    public final void onPrepareLoad(Drawable drawable) {
        mTargetSet.add(this);
        onPrepareLoadImpl(drawable);
    }
}
