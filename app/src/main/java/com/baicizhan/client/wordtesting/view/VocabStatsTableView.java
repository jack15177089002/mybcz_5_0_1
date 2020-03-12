package com.baicizhan.client.wordtesting.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class VocabStatsTableView extends View {
    private Paint mDeepPaint;
    private Paint mLightPaint;

    public VocabStatsTableView(Context context) {
        super(context);
        init();
    }

    public VocabStatsTableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.mLightPaint = new Paint();
        this.mLightPaint.setColor(-6710887);
        this.mLightPaint.setStyle(Style.STROKE);
        this.mLightPaint.setStrokeWidth(1.0f);
        this.mDeepPaint = new Paint();
        this.mDeepPaint.setColor(-14145496);
        this.mDeepPaint.setStyle(Style.STROKE);
        this.mDeepPaint.setStrokeWidth(1.0f);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i = width / 9;
        int i2 = height / 5;
        canvas.drawLines(new float[]{1.0f, 1.0f, (float) (width - 1), 1.0f, 1.0f, (float) i2, (float) (width - 1), (float) i2, 1.0f, (float) (i2 * 2), (float) (width - 1), (float) (i2 * 2), 1.0f, (float) (i2 * 3), (float) (width - 1), (float) (i2 * 3), 1.0f, (float) (i2 * 4), (float) (width - 1), (float) (i2 * 4)}, this.mDeepPaint);
        canvas.drawLines(new float[]{(float) i, 1.0f, (float) i, (float) (height - 1), (float) (i * 2), 1.0f, (float) (i * 2), (float) (height - 1), (float) (i * 3), 1.0f, (float) (i * 3), (float) (height - 1), (float) (i * 4), 1.0f, (float) (i * 4), (float) (height - 1), (float) (i * 5), 1.0f, (float) (i * 5), (float) (height - 1), (float) (i * 6), 1.0f, (float) (i * 6), (float) (height - 1), (float) (i * 7), 1.0f, (float) (i * 7), (float) (height - 1), (float) (i * 8), 1.0f, (float) (i * 8), (float) (height - 1), (float) ((i * 9) - 1), 1.0f, (float) ((i * 9) - 1), (float) (height - 1)}, this.mDeepPaint);
        canvas.drawLine(1.0f, (float) ((i2 * 5) - 1), (float) (width - 1), (float) ((i2 * 5) - 1), this.mLightPaint);
        canvas.drawLine(1.0f, 1.0f, 1.0f, (float) (height - 1), this.mLightPaint);
    }
}
