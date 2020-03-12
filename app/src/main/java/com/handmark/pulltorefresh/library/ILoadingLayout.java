package com.handmark.pulltorefresh.library;

import android.graphics.drawable.Drawable;

/* renamed from: com.handmark.pulltorefresh.library.a */
public interface ILoadingLayout {
    void setLastUpdatedLabel(CharSequence charSequence);

    void setLoadingDrawable(Drawable drawable);

    void setPullLabel(CharSequence charSequence);

    void setRefreshingLabel(CharSequence charSequence);

    void setReleaseLabel(CharSequence charSequence);
}
