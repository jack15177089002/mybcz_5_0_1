package com.baicizhan.client.business.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;

public class CircleProgressView extends View {
    private int mBackgroundColor;
    private Paint mBackgroundPaint;
    private int mMaxProgress;
    private int mProgress;
    private int mProgressColor;
    private Paint mProgressPaint;
    private int mRadius;
    private RectF mRectF;
    private Paint mSquarePaint;
    private int mSquareWidth;
    private int mStrokeWidth;
    private int mXCenter;
    private int mYCenter;

    public CircleProgressView(Context context) {
        this(context, null);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgress = 0;
        this.mMaxProgress = 100;
        this.mRectF = new RectF();
//        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CircleProgressView, i, 0);
//        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressView_circleRadius, 0);
//        this.mStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressView_strokeWidth, 0);
//        this.mSquareWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleProgressView_centerSquareWidth, 0);
//        this.mBackgroundColor = obtainStyledAttributes.getColor(R.styleable.CircleProgressView_circleBackgroundColor, 0);
//        this.mProgressColor = obtainStyledAttributes.getColor(R.styleable.CircleProgressView_circleProgressColor, 0);
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(this.mBackgroundColor);
        this.mBackgroundPaint.setStyle(Style.STROKE);
        this.mBackgroundPaint.setStrokeWidth((float) this.mStrokeWidth);
        this.mProgressPaint = new Paint(this.mBackgroundPaint);
        this.mProgressPaint.setColor(this.mProgressColor);
        this.mSquarePaint = new Paint();
        this.mSquarePaint.setColor(this.mProgressColor);
        this.mSquarePaint.setStyle(Style.FILL);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(((this.mRadius + this.mStrokeWidth) * 2) + getPaddingLeft() + getPaddingRight(), i), resolveSize(((this.mRadius + this.mStrokeWidth) * 2) + getPaddingTop() + getPaddingBottom(), i2));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int width = getWidth();
        int height = getHeight();
        this.mXCenter = width / 2;
        this.mYCenter = height / 2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        canvas2.drawRect(((float) this.mXCenter) - (((float) this.mSquareWidth) / 2.0f), ((float) this.mYCenter) - (((float) this.mSquareWidth) / 2.0f), (((float) this.mSquareWidth) / 2.0f) + ((float) this.mXCenter), (((float) this.mSquareWidth) / 2.0f) + ((float) this.mYCenter), this.mSquarePaint);
        float f = ((float) this.mRadius) + (((float) this.mStrokeWidth) / 2.0f);
        canvas.drawCircle((float) this.mXCenter, (float) this.mYCenter, f, this.mBackgroundPaint);
        if (this.mProgress > 0) {
            this.mRectF.left = ((float) this.mXCenter) - f;
            this.mRectF.top = ((float) this.mYCenter) - f;
            this.mRectF.right = ((float) this.mXCenter) + f;
            this.mRectF.bottom = f + ((float) this.mYCenter);
            canvas.drawArc(this.mRectF, -90.0f, 360.0f * (((float) this.mProgress) / ((float) this.mMaxProgress)), false, this.mProgressPaint);
        }
    }

    public void setProgress(int i) {
        this.mProgress = i;
        postInvalidate();
    }

    public void setMaxProgress(int i) {
        this.mMaxProgress = i;
        postInvalidate();
    }
}
