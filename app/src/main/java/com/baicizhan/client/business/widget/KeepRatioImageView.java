package com.baicizhan.client.business.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class KeepRatioImageView extends ImageView {
    public KeepRatioImageView(Context context) {
        super(context);
    }

    public KeepRatioImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KeepRatioImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onMeasure(i, i2);
            return;
        }
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        float measuredWidth = (float) getMeasuredWidth();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec((int) measuredWidth, 1073741824);
        float intrinsicWidth = (float) drawable.getIntrinsicWidth();
        if (intrinsicWidth == 0.0f) {
            intrinsicWidth = 1.0f;
        }
        super.onMeasure(makeMeasureSpec, MeasureSpec.makeMeasureSpec((int) ((((float) drawable.getIntrinsicHeight()) * measuredWidth) / intrinsicWidth), 1073741824));
    }
}
