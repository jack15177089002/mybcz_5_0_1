package com.baicizhan.client.wordtesting.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.baicizhan.client.framework.log.C0789L;

public class TextView extends View {
    private Paint paint = new Paint();
    private String text = "1";

    public TextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paint.setStyle(Style.FILL);
        this.paint.setTextSize(35.0f);
        setPadding(0, 5, 0, 0);
    }

    /* access modifiers changed from: protected */
    public void onDraw2(Canvas canvas) {
        this.paint.setColor(-1);
        C0789L.log.debug("[{} {} {} {}]", Integer.valueOf(getPaddingLeft()), Integer.valueOf(getPaddingTop()), Integer.valueOf(getPaddingRight()), Integer.valueOf(getPaddingBottom()));
        canvas.drawText(this.text, (float) getPaddingLeft(), (float) (getPaddingTop() + getTextHight()), this.paint);
        canvas.drawLine(0.0f, 0.0f, 10.0f, 20.0f, this.paint);
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Rect rect = new Rect(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + getTextWidth(), getPaddingTop() + getTextHight());
        String str = this.text;
        this.paint.setColor(-16711681);
        FontMetricsInt fontMetricsInt = this.paint.getFontMetricsInt();
        int i = (rect.top + ((((rect.bottom - rect.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2)) - fontMetricsInt.top;
        this.paint.setTextAlign(Align.CENTER);
        C0789L.log.debug("pos [{} {} {} {} {} {} {}]", Integer.valueOf(rect.top), Integer.valueOf(rect.bottom), Integer.valueOf(rect.centerX()), Integer.valueOf(fontMetricsInt.top), Integer.valueOf(fontMetricsInt.bottom), Float.valueOf(this.paint.ascent()), Float.valueOf(this.paint.descent()));
        canvas.drawText(str, (float) rect.centerX(), (float) i, this.paint);
        this.paint.setColor(-1);
        canvas.drawLine((float) getPaddingLeft(), (float) fontMetricsInt.bottom, (float) getPaddingRight(), (float) fontMetricsInt.bottom, this.paint);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        C0789L.log.debug("measure [{}] [{}]", (Object) Integer.valueOf(i), (Object) Integer.valueOf(i2));
        C0789L.log.debug("padding [{}] [{}]", (Object) Integer.valueOf(getPaddingLeft()), (Object) Integer.valueOf(getPaddingTop()));
        super.onMeasure(i, i2);
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    private int measureWidth(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int textWidth = getTextWidth() + getPaddingLeft() + getPaddingRight();
            size = mode == Integer.MIN_VALUE ? Math.min(textWidth, size) : textWidth;
        }
        C0789L.log.debug("width [{}]", (Object) Integer.valueOf(size));
        return size;
    }

    private int getTextHight() {
        return (int) (this.paint.descent() - this.paint.ascent());
    }

    private int getTextWidth() {
        return (int) this.paint.measureText(this.text);
    }

    private int measureHeight(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            int textHight = getTextHight() + getPaddingTop() + getPaddingBottom();
            size = mode == Integer.MIN_VALUE ? Math.min(textHight, size) : textHight;
        }
        C0789L.log.debug("height [{}]", (Object) Integer.valueOf(size));
        return size;
    }
}
