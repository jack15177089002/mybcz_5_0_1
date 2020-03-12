package com.baicizhan.client.wordlock.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baicizhan.client.wordlock.util.FastBlur;

public class LockBgLayout extends RelativeLayout {
    public LockBgLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void refreshBg() {
        Context context = getContext();
        if (context instanceof Activity) {
            FastBlur.applyBlur((Activity) context, this);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        refreshBg();
    }
}
