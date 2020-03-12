package com.baicizhan.client.business.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.Button;
import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;

@SuppressLint("AppCompatCustomView")
public class RoundedButton extends Button {
    private static final int CORNER_ALL = 15;
    private static final int CORNER_BOTTOM_LEFT = 8;
    private static final int CORNER_BOTTOM_RIGHT = 4;
    private static final int CORNER_TOP_LEFT = 1;
    private static final int CORNER_TOP_RIGHT = 2;
    private GradientDrawable mBackground;
    private int mCornerMode;
    private int mCornerRadius;
    private int mCurFillColor;
    private int mCurStrokeColor;
    private ColorStateList mFillColor;
    private ColorStateList mStrokeColor;
    private int mStrokeWidth;

    public RoundedButton(Context context) {
        this(context, null, 0);
    }

    public RoundedButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
//        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedButton, i, 0);
//        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
//            int index = obtainStyledAttributes.getIndex(i2);
//            if (index == R.styleable.RoundedButton_cornerRadius) {
//                this.mCornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, 0);
//            } else if (index == R.styleable.RoundedButton_cornerMode) {
//                this.mCornerMode = obtainStyledAttributes.getInt(index, 15);
//            } else if (index == R.styleable.RoundedButton_strokeWidth) {
//                this.mStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(index, 0);
//            } else if (index == R.styleable.RoundedButton_strokeColor) {
//                this.mStrokeColor = obtainStyledAttributes.getColorStateList(index);
//            } else if (index == R.styleable.RoundedButton_fillColor) {
//                this.mFillColor = obtainStyledAttributes.getColorStateList(index);
//            }
//        }
//        obtainStyledAttributes.recycle();
        if (this.mCornerMode == 0 && this.mCornerRadius > 0) {
            this.mCornerMode = 15;
        }
        this.mBackground = new GradientDrawable();
        this.mBackground.setShape(0);
        if (this.mCornerMode == 15) {
            this.mBackground.setCornerRadius((float) this.mCornerRadius);
        } else {
            float[] fArr = new float[8];
            if ((this.mCornerMode & 1) > 0) {
                float f = (float) this.mCornerRadius;
                fArr[1] = f;
                fArr[0] = f;
            }
            if ((this.mCornerMode & 2) > 0) {
                float f2 = (float) this.mCornerRadius;
                fArr[3] = f2;
                fArr[2] = f2;
            }
            if ((this.mCornerMode & 4) > 0) {
                float f3 = (float) this.mCornerRadius;
                fArr[5] = f3;
                fArr[4] = f3;
            }
            if ((this.mCornerMode & 8) > 0) {
                float f4 = (float) this.mCornerRadius;
                fArr[7] = f4;
                fArr[6] = f4;
            }
            this.mBackground.setCornerRadii(fArr);
        }
        setBackgroundCompat(this.mBackground);
        updateColors();
    }

    @SuppressLint({"NewApi"})
    private void setBackgroundCompat(Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateColors() {
        /*
            r6 = this;
            r1 = 1
            r2 = 0
            int[] r3 = r6.getDrawableState()
            android.content.res.ColorStateList r0 = r6.mStrokeColor
            if (r0 == 0) goto L_0x003c
            android.content.res.ColorStateList r0 = r6.mStrokeColor
            int r0 = r0.getColorForState(r3, r2)
            int r4 = r6.mCurStrokeColor
            if (r0 == r4) goto L_0x003c
            r6.mCurStrokeColor = r0
            android.graphics.drawable.GradientDrawable r0 = r6.mBackground
            int r4 = r6.mStrokeWidth
            int r5 = r6.mCurStrokeColor
            r0.setStroke(r4, r5)
            r0 = r1
        L_0x0020:
            android.content.res.ColorStateList r4 = r6.mFillColor
            if (r4 == 0) goto L_0x0036
            android.content.res.ColorStateList r4 = r6.mFillColor
            int r2 = r4.getColorForState(r3, r2)
            int r3 = r6.mCurFillColor
            if (r2 == r3) goto L_0x0036
            r6.mCurFillColor = r2
            android.graphics.drawable.GradientDrawable r0 = r6.mBackground
            r0.setColor(r2)
            r0 = r1
        L_0x0036:
            if (r0 == 0) goto L_0x003b
            r6.invalidate()
        L_0x003b:
            return
        L_0x003c:
            r0 = r2
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.widget.RoundedButton.updateColors():void");
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if ((this.mStrokeColor != null && this.mStrokeColor.isStateful()) || (this.mFillColor != null && this.mFillColor.isStateful())) {
            updateColors();
        }
    }

    public void setFillColor(ColorStateList colorStateList) {
        this.mFillColor = colorStateList;
        updateColors();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.mStrokeColor = colorStateList;
        updateColors();
    }
}
