package com.baicizhan.client.wordtesting.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.baicizhan.client.framework.util.Common;

public class MoonView extends View {
    private int mEarthColor = -13158601;
    private Paint mEarthPaint;
    private int mMoonColor = -330048;
    private Paint mMoonPaint;

    public MoonView(Context context) {
        super(context);
        init();
    }

    public MoonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.mMoonPaint = new Paint(1);
        this.mMoonPaint.setStyle(Style.FILL);
        this.mMoonPaint.setColor(this.mMoonColor);
        this.mEarthPaint = new Paint(1);
        this.mEarthPaint.setStyle(Style.FILL);
        this.mEarthPaint.setColor(this.mEarthColor);
    }

    public void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int min = (Math.min(width, height) / 2) - Common.dip2px(getContext(), 2.0f);
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) min, this.mMoonPaint);
        canvas.drawCircle((float) ((width * 7) / 12), (float) ((height * 5) / 12), (float) min, this.mEarthPaint);
    }

    public void setMoonColor(int i) {
        this.mMoonColor = i;
        this.mMoonPaint.setColor(this.mMoonColor);
        invalidate();
    }

    public void setEarthColor(int i) {
        this.mEarthColor = i;
        this.mEarthPaint.setColor(this.mEarthColor);
        invalidate();
    }
}
