package com.baicizhan.client.fight.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

public class AutoResizeTextView extends TextView {
    private int mScanHighBound;
    private int mScanLowBound;
    private float mSpacingAdd;
    private float mSpacingMult;
    private TextPaint mTextPaint;
    private boolean needAdapt;

    public AutoResizeTextView(Context context) {
        this(context, null, 0);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScanLowBound = 10;
        this.mScanHighBound = 1000;
        this.mSpacingMult = 1.0f;
        this.mSpacingAdd = 0.0f;
        this.needAdapt = false;
        init();
    }

    private void init() {
        this.mTextPaint = new TextPaint();
    }

    public void setScanSpan(int i, int i2) {
        this.mScanLowBound = i;
        this.mScanHighBound = i2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.needAdapt) {
            adaptTextSize();
        } else {
            super.onDraw(canvas);
        }
    }

    private void adaptTextSize() {
        int i;
        CharSequence text = getText();
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        if (measuredWidth != 0 && measuredHeight != 0 && !TextUtils.isEmpty(text)) {
            if (isFit(text, this.mScanHighBound, measuredWidth, measuredHeight)) {
                i = this.mScanHighBound;
            } else {
                int i2 = this.mScanLowBound;
                i = i2;
                int i3 = this.mScanHighBound;
                while (i < i3 && i != i3 - 1) {
                    int i4 = (i + i3) / 2;
                    if (isFit(text, i4, measuredWidth, measuredHeight)) {
                        i = i4;
                    } else {
                        i3 = i4 - 1;
                    }
                }
            }
            setTextSize(0, (float) i);
            this.needAdapt = false;
            invalidate();
        }
    }

    private boolean isFit(CharSequence charSequence, int i, int i2, int i3) {
        this.mTextPaint.setTextSize((float) i);
        if (new StaticLayout(charSequence, this.mTextPaint, i2, Alignment.ALIGN_NORMAL, this.mSpacingMult, this.mSpacingAdd, true).getHeight() <= i3) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.needAdapt = true;
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.needAdapt = true;
    }

    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.mSpacingMult = f2;
        this.mSpacingAdd = f;
        this.needAdapt = true;
    }
}
