package com.baicizhan.client.business.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;

public class DotIndicator extends View {
    private int mCurrentIndex;
    private int mDotColorNormal;
    private int mDotColorSelected;
    private int mDotCount;
    private int mDotInterval;
    private Paint mDotPaint;
    private int mDotRadius;

    public DotIndicator(Context context) {
        this(context, null, 0);
    }

    public DotIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DotIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
//        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DotIndicator);
//        this.mDotColorNormal = obtainStyledAttributes.getColor(R.styleable.DotIndicator_dot_color_normal, 0);
//        this.mDotColorSelected = obtainStyledAttributes.getColor(R.styleable.DotIndicator_dot_color_selected, 0);
//        this.mDotRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DotIndicator_dot_radius, 0);
//        this.mDotInterval = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DotIndicator_dot_interval, 0);
//        this.mDotCount = obtainStyledAttributes.getInt(R.styleable.DotIndicator_dot_count, 0);
        this.mDotPaint = new Paint(1);
//        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(getPaddingLeft() + getPaddingRight() + (this.mDotRadius << 1) + (this.mDotInterval * (this.mDotCount - 1)), i), resolveSize(getPaddingTop() + getPaddingBottom() + (this.mDotRadius << 1), i2));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int measuredHeight = getMeasuredHeight() / 2;
        int paddingLeft = this.mDotRadius + getPaddingLeft();
        int i = 0;
        while (i < this.mDotCount) {
            this.mDotPaint.setColor(i == this.mCurrentIndex ? this.mDotColorSelected : this.mDotColorNormal);
            canvas.drawCircle((float) paddingLeft, (float) measuredHeight, (float) this.mDotRadius, this.mDotPaint);
            paddingLeft += this.mDotInterval;
            i++;
        }
    }

    public void setSelectedItem(int i) {
        if (this.mCurrentIndex != i) {
            this.mCurrentIndex = i;
            invalidate();
        }
    }
}
