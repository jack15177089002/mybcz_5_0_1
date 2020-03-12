package com.baicizhan.client.business.widget;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

public abstract class TouchableSpan extends ClickableSpan {
    private boolean mIsPressed;
    private int mPressedBackgroundColor;

    public TouchableSpan(int i) {
        this.mPressedBackgroundColor = i;
    }

    public void setPressed(boolean z) {
        this.mIsPressed = z;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.bgColor = this.mIsPressed ? this.mPressedBackgroundColor : 0;
    }
}
