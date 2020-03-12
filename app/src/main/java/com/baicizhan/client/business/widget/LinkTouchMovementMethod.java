package com.baicizhan.client.business.widget;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

public class LinkTouchMovementMethod extends LinkMovementMethod {
    private static LinkTouchMovementMethod sInstance;
    private TouchableSpan mPressedSpan;

    public static LinkTouchMovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new LinkTouchMovementMethod();
        }
        return sInstance;
    }

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mPressedSpan = getPressedSpan(textView, spannable, motionEvent);
            if (this.mPressedSpan != null) {
                this.mPressedSpan.setPressed(true);
                Selection.setSelection(spannable, spannable.getSpanStart(this.mPressedSpan), spannable.getSpanEnd(this.mPressedSpan));
            }
        } else if (motionEvent.getAction() == 2) {
            TouchableSpan pressedSpan = getPressedSpan(textView, spannable, motionEvent);
            if (!(this.mPressedSpan == null || pressedSpan == this.mPressedSpan)) {
                this.mPressedSpan.setPressed(false);
                this.mPressedSpan = null;
                Selection.removeSelection(spannable);
            }
        } else {
            if (this.mPressedSpan != null) {
                this.mPressedSpan.setPressed(false);
                super.onTouchEvent(textView, spannable, motionEvent);
            }
            this.mPressedSpan = null;
            Selection.removeSelection(spannable);
        }
        return true;
    }

    private TouchableSpan getPressedSpan(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
        int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
        TouchableSpan[] touchableSpanArr = (TouchableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, TouchableSpan.class);
        if (touchableSpanArr.length > 0) {
            return touchableSpanArr[0];
        }
        return null;
    }
}
