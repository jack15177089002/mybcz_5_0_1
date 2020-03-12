package com.baicizhan.client.business.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;
import com.baicizhan.client.framework.util.DisplayUtils;

public class RedDotImageView extends ImageView {
    private static final int DEFAULT_RED_DOT_COLOR = -65536;
    private static final int DEFAULT_RED_DOT_RADIUS_DP = 2;
    private Paint mRedDotPaint;
    private int mRedDotRadius;
    private boolean mShowRedDot;

    public RedDotImageView(Context context) {
        this(context, null, 0);
    }

    public RedDotImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RedDotImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShowRedDot = false;
//        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RedDotImageView, i, 0);
//        int color = obtainStyledAttributes.getColor(R.styleable.RedDotImageView_redDotColor, DEFAULT_RED_DOT_COLOR);
//        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RedDotImageView_redDotRadius, 0);
//        if (dimensionPixelSize == 0) {
//            dimensionPixelSize = DisplayUtils.dpToPx(context, 2.0f);
//        }
//        obtainStyledAttributes.recycle();
//        this.mRedDotPaint = new Paint(1);
//        this.mRedDotPaint.setColor(color);
//        this.mRedDotRadius = dimensionPixelSize;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mShowRedDot) {
            canvas.drawCircle((float) (getWidth() - getPaddingRight()), (float) getPaddingTop(), (float) this.mRedDotRadius, this.mRedDotPaint);
        }
    }

    public void setShowRedDot(boolean z) {
        if (this.mShowRedDot != z) {
            this.mShowRedDot = z;
            invalidate();
        }
    }
}
