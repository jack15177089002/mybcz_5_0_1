package com.baicizhan.client.business.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.List;

public class HollowDrawable extends Drawable {
    private List<CircleHollow> mCircleHollows = new ArrayList();
    private Paint mHollowPaint = new Paint(1);
    private int mMaskColor;
    private List<RectHollow> mRectHollows = new ArrayList();

    public class CircleHollow {
        /* access modifiers changed from: private */
        public RectF mRect;

        public CircleHollow() {
        }

        public CircleHollow(RectF rectF) {
            this.mRect = rectF;
        }

        public CircleHollow(float f, float f2, float f3, float f4) {
            this.mRect = new RectF(f, f2, f3, f4);
        }

        public RectF getRect() {
            return this.mRect;
        }

        public void setRect(RectF rectF) {
            this.mRect = rectF;
        }

        public void setRect(float f, float f2, float f3, float f4) {
            this.mRect = new RectF(f, f2, f3, f4);
        }
    }

    public class RectHollow {
        /* access modifiers changed from: private */
        public float mCornerRadius;
        /* access modifiers changed from: private */
        public RectF mRect;

        public RectHollow() {
        }

        public RectHollow(RectF rectF, float f) {
            this.mRect = rectF;
            this.mCornerRadius = f;
        }

        public RectHollow(float f, float f2, float f3, float f4, float f5) {
            this.mRect = new RectF(f, f2, f3, f4);
            this.mCornerRadius = f5;
        }

        public float getCornerRadius() {
            return this.mCornerRadius;
        }

        public void setCornerRadius(float f) {
            this.mCornerRadius = f;
        }

        public RectF getRect() {
            return this.mRect;
        }

        public void setRect(RectF rectF) {
            this.mRect = rectF;
        }

        public void setRect(float f, float f2, float f3, float f4) {
            this.mRect = new RectF(f, f2, f3, f4);
        }
    }

    private HollowDrawable() {
        this.mHollowPaint.setColor(-65536);
        this.mHollowPaint.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
    }

    public static HollowDrawable born() {
        return new HollowDrawable();
    }

    public HollowDrawable setMaskColor(int i) {
        this.mMaskColor = i;
        return this;
    }

    public HollowDrawable digRectHollow(RectHollow rectHollow) {
        if (rectHollow != null) {
            this.mRectHollows.add(rectHollow);
        }
        return this;
    }

    public HollowDrawable digCircleHollow(CircleHollow circleHollow) {
        if (circleHollow != null) {
            this.mCircleHollows.add(circleHollow);
        }
        return this;
    }

    public HollowDrawable digRectHollows(List<RectHollow> list) {
        if (list != null) {
            this.mRectHollows = list;
        }
        return this;
    }

    public HollowDrawable digCircleHollows(List<CircleHollow> list) {
        if (list != null) {
            this.mCircleHollows = list;
        }
        return this;
    }

    public boolean isInHollow(float f, float f2) {
        for (RectHollow access$000 : this.mRectHollows) {
            if (access$000.mRect.contains(f, f2)) {
                return true;
            }
        }
        for (CircleHollow access$100 : this.mCircleHollows) {
            if (access$100.mRect.contains(f, f2)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Bitmap createBitmap = Bitmap.createBitmap(bounds.width(), bounds.height(), Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        canvas2.drawColor(this.mMaskColor);
        for (RectHollow rectHollow : this.mRectHollows) {
            canvas2.drawRoundRect(rectHollow.mRect, rectHollow.mCornerRadius, rectHollow.mCornerRadius, this.mHollowPaint);
        }
        for (CircleHollow access$100 : this.mCircleHollows) {
            canvas2.drawArc(access$100.mRect, 0.0f, 360.0f, false, this.mHollowPaint);
        }
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, null);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -3;
    }
}
