package com.baicizhan.client.wordlock.view.drag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.baicizhan.client.framework.util.Common;
import com.baicizhan.client.p029fm.service.proxy.FmPlayState;

public class DragView extends View {
    private static final float DRAG_SCALE = 1.2f;
    private float mAnimationScale = 1.0f;
    private Bitmap mBitmap;
    private int mBottomMargine;
    private int mBottomThreshold;
    private boolean mCanMove = false;
    private LayoutParams mLayoutParams;
    private Paint mPaint;
    private int mRegistrationX;
    private int mRegistrationY;
    private float mScale;
    private WindowManager mWindowManager;

    public DragView(Context context, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6) {
        super(context);
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        Matrix matrix = new Matrix();
        this.mScale = DRAG_SCALE;
        matrix.setScale(DRAG_SCALE, DRAG_SCALE);
        this.mBitmap = Bitmap.createBitmap(bitmap, i3, i4, i5, i6, matrix, true);
        this.mRegistrationX = ((this.mBitmap.getWidth() - bitmap.getWidth()) / 2) + i;
        this.mRegistrationY = ((this.mBitmap.getHeight() - bitmap.getHeight()) / 2) + i2;
        this.mBottomMargine = Common.dip2px(context, 48.0f);
        this.mBottomThreshold = Common.getScreenHeight(context) - this.mBottomMargine;
        this.mPaint = new Paint(1);
        this.mPaint.setColorFilter(new PorterDuffColorFilter(-6440194, Mode.SRC_ATOP));
        this.mPaint.setStyle(Style.FILL);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(this.mBitmap.getWidth(), this.mBitmap.getHeight());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f = this.mAnimationScale;
        if (f < 0.999f) {
            float width = (float) this.mBitmap.getWidth();
            float f2 = (width - (width * f)) / 2.0f;
            canvas.translate(f2, f2);
            canvas.scale(f, f);
        }
        canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mBitmap.recycle();
    }

    public void setPaint(Paint paint) {
        this.mPaint = paint;
        invalidate();
    }

    public void setScale(float f) {
        if (f > 1.0f) {
            this.mAnimationScale = 1.0f;
        } else {
            this.mAnimationScale = f;
        }
        invalidate();
    }

    public void show(IBinder iBinder, int i, int i2) {
        LayoutParams layoutParams = new LayoutParams(-2, -2, i - this.mRegistrationX, i2 - this.mRegistrationY, FmPlayState.TYPE_MID_FM, 768, -3);
        layoutParams.gravity = 51;
        layoutParams.token = iBinder;
        layoutParams.setTitle("DragView");
        this.mLayoutParams = layoutParams;
        this.mWindowManager.addView(this, layoutParams);
    }

    /* access modifiers changed from: 0000 */
    public void move(int i, int i2) {
        if (this.mCanMove) {
            int i3 = i2 - this.mRegistrationY;
            if ((i2 - this.mRegistrationY) + this.mBitmap.getHeight() >= this.mBottomThreshold) {
                i3 = this.mBottomThreshold - this.mBitmap.getHeight();
            }
            LayoutParams layoutParams = this.mLayoutParams;
            layoutParams.x = i - this.mRegistrationX;
            layoutParams.y = i3;
            this.mWindowManager.updateViewLayout(this, layoutParams);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setMovable(boolean z) {
        this.mCanMove = z;
    }

    /* access modifiers changed from: 0000 */
    public void remove() {
        this.mWindowManager.removeView(this);
    }

    /* access modifiers changed from: 0000 */
    public Rect getRectOnScreen() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        return new Rect(iArr[0], iArr[1], getWidth() + iArr[0], iArr[1] + getHeight());
    }

    public float getPopScale() {
        return this.mScale;
    }
}
