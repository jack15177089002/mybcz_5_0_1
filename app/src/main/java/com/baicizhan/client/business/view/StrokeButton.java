package com.baicizhan.client.business.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.R;

@SuppressLint({"ClickableViewAccessibility"})
public class StrokeButton extends Button {
    public static final int STYLE_BLUE = 1;
    public static final int STYLE_WHITE = 0;
    /* access modifiers changed from: private */
    public boolean mHasStroke = false;
    /* access modifiers changed from: private */
    public int mNormalBGResource;
    /* access modifiers changed from: private */
    public int mNormalTextColor;
    /* access modifiers changed from: private */
    public int mPressedBGResource;
    /* access modifiers changed from: private */
    public int mPressedTextColor;
    /* access modifiers changed from: private */
    public OnTouchListener mReal;
    private int mSelectedBGResource;
    private int mSelectedTextColor;
    /* access modifiers changed from: private */
    public ButtonTouchListener mTouchListener = new ButtonTouchListener();

    class ButtonTouchListener implements OnTouchListener {
        private ButtonTouchListener() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    StrokeButton.this.setTextColor(StrokeButton.this.mPressedTextColor);
                    if (StrokeButton.this.mHasStroke) {
                        StrokeButton.this.setBackgroundResource(StrokeButton.this.mPressedBGResource);
                        break;
                    } else {
                        StrokeButton.this.setBackgroundColor(0);
                        break;
                    }
                case 1:
                case 3:
                    if (!StrokeButton.this.isSelected()) {
                        StrokeButton.this.setTextColor(StrokeButton.this.mNormalTextColor);
                        if (StrokeButton.this.mHasStroke) {
                            StrokeButton.this.setBackgroundResource(StrokeButton.this.mNormalBGResource);
                            break;
                        } else {
                            StrokeButton.this.setBackgroundColor(0);
                            break;
                        }
                    }
                    break;
            }
            return false;
        }
    }

    public void setStyle(int i) {
        switch (i) {
            case 1:
                this.mNormalTextColor = getResources().getColor(R.color.business_def_blue_color);
                this.mPressedTextColor = getResources().getColor(R.color.business_def_deep_blue_color);
                this.mSelectedTextColor = getResources().getColor(R.color.business_def_deep_blue_color);
                this.mNormalBGResource = R.drawable.business_blue_stroke_rounded_btn_rect;
                this.mPressedBGResource = R.drawable.business_blue_stroke_rounded_btn_rect_pressed;
                this.mSelectedBGResource = R.drawable.business_blue_stroke_rounded_btn_rect_pressed;
                return;
            default:
                this.mNormalTextColor = -1;
                this.mPressedTextColor = -1996488705;
                this.mSelectedTextColor = -1996488705;
                this.mNormalBGResource = R.drawable.business_white_stroke_rounded_btn_rect;
                this.mPressedBGResource = R.drawable.business_white_stroke_rounded_btn_rect_pressed;
                this.mSelectedBGResource = R.drawable.business_white_stroke_rounded_btn_rect_pressed;
                return;
        }
    }

    public StrokeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setDefaultAttrs(context);
//        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StrokeButton);
//        int indexCount = obtainStyledAttributes.getIndexCount();
//        for (int i = 0; i < indexCount; i++) {
//            int index = obtainStyledAttributes.getIndex(i);
//            if (index == R.styleable.StrokeButton_business_style) {
//                setStyle(obtainStyledAttributes.getInt(index, 0));
//            } else if (index == R.styleable.StrokeButton_business_hasStroke) {
//                this.mHasStroke = obtainStyledAttributes.getBoolean(index, true);
//            } else if (index == R.styleable.StrokeButton_business_normal_text_color) {
//                this.mNormalTextColor = obtainStyledAttributes.getColor(index, this.mNormalTextColor);
//            } else if (index == R.styleable.StrokeButton_business_pressed_text_color) {
//                this.mPressedTextColor = obtainStyledAttributes.getColor(index, this.mPressedTextColor);
//            } else if (index == R.styleable.StrokeButton_business_selected_text_color) {
//                this.mSelectedTextColor = obtainStyledAttributes.getColor(index, this.mSelectedTextColor);
//            }
//        }
//        obtainStyledAttributes.recycle();
        applyAttrs();
    }

    private void setDefaultAttrs(Context context) {
        this.mNormalTextColor = -1;
        this.mPressedTextColor = -1996488705;
        this.mSelectedTextColor = -1996488705;
        this.mNormalBGResource = R.drawable.business_white_stroke_rounded_btn_rect;
        this.mPressedBGResource = R.drawable.business_white_stroke_rounded_btn_rect_pressed;
        this.mSelectedBGResource = R.drawable.business_white_stroke_rounded_btn_rect_pressed;
        this.mHasStroke = true;
    }

    private void applyAttrs() {
        setOnTouchListener(this.mTouchListener);
        setTextColor(this.mNormalTextColor);
        if (!this.mHasStroke) {
            setBackgroundColor(0);
        } else {
            setBackgroundResource(this.mNormalBGResource);
        }
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        if (onTouchListener != this.mTouchListener) {
            this.mReal = onTouchListener;
            super.setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    StrokeButton.this.mTouchListener.onTouch(view, motionEvent);
                    if (StrokeButton.this.mReal != null) {
                        return StrokeButton.this.mReal.onTouch(view, motionEvent);
                    }
                    return false;
                }
            });
            return;
        }
        super.setOnTouchListener(this.mTouchListener);
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        if (isSelected()) {
            setTextColor(this.mSelectedTextColor);
            if (!this.mHasStroke) {
                setBackgroundColor(0);
            } else {
                setBackgroundResource(this.mSelectedBGResource);
            }
        } else {
            setTextColor(this.mNormalTextColor);
            if (!this.mHasStroke) {
                setBackgroundColor(0);
            } else {
                setBackgroundResource(this.mNormalBGResource);
            }
        }
    }
}
