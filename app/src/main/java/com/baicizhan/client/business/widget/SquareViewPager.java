package com.baicizhan.client.business.widget;

import android.annotation.SuppressLint;
import android.content.Context;

import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import androidx.viewpager.widget.ViewPager;//import android.support.p004v4.view.ViewPager;

public class SquareViewPager extends ViewPager {
    public SquareViewPager(Context context) {
        super(context);
    }

    public SquareViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        @SuppressLint("WrongConstant") int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }
}
