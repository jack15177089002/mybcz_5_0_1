package com.baicizhan.client.wordtesting.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.baicizhan.client.framework.log.C0789L;
import java.util.ArrayList;
import java.util.List;

public class CountDownView extends View implements AnimationListener {
    private final Animation animation = new Animation() {
    };
    private int animationDuration = 100;
    private int circleColor = -16776961;
    private Paint circlePaint = new Paint();
    private int circlePassedColor = -7829368;
    private Paint circlePassedPaint = null;
    private float currentDegree = 360.0f;
    private double currentSecond = ((double) this.totalSeconds);
    private boolean expired;
    private float fontSize = (((float) this.radiusOutter) * 0.6f);
    private final float fontSizeRate = 0.6f;
    private List<Handler> handlers = new ArrayList();
    private int radiusOutter = 100;
    private int radiusX = 0;
    private int radiusY = 0;
    private final RectF rect = new RectF();
    private int strike = ((int) (((double) this.radiusOutter) * 0.2d));
    private final double strikeRate = 0.2d;
    private String text = String.valueOf((this.totalSeconds));
    private int textColor = -1;
    private Paint textPaint = new Paint();
    private final float totalDegree = 360.0f;
    private int totalSeconds = 6;
    private final Rect txtRect = new Rect();

    public interface Handler {
        void onStart();

        void onTimeFinished();
    }

    public CountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        for (int i = 0; i < attributeSet.getAttributeCount(); i++) {
            String attributeName = attributeSet.getAttributeName(i);
            String attributeValue = attributeSet.getAttributeValue(i);
            if ("textColor".equals(attributeName)) {
                try {
                    this.textColor = Color.parseColor(attributeValue);
                } catch (Exception e) {
                }
            } else if ("circleColor".equals(attributeName)) {
                try {
                    this.circleColor = Color.parseColor(attributeValue);
                } catch (Exception e2) {
                }
            } else if ("circlePassedColor".equals(attributeName)) {
                try {
                    this.circlePassedColor = Color.parseColor(attributeValue);
                } catch (Exception e3) {
                }
            } else if ("animateDurationMilliSecend".equals(attributeName)) {
                try {
                    this.animationDuration = Integer.parseInt(attributeValue);
                } catch (Exception e4) {
                }
            } else if ("totalSeconds".equals(attributeName)) {
                try {
                    this.totalSeconds = Integer.parseInt(attributeValue);
                } catch (Exception e5) {
                }
            }
        }
        this.circlePaint.setStyle(Style.STROKE);
        this.circlePaint.setStrokeWidth((float) this.strike);
        this.circlePaint.setColor(this.circleColor);
        this.circlePaint.setAntiAlias(true);
        this.circlePassedPaint = new Paint(this.circlePaint);
        this.circlePassedPaint.setColor(this.circlePassedColor);
        this.textPaint.setStyle(Style.FILL);
        this.textPaint.setTextSize(this.fontSize);
        this.textPaint.setColor(-1);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextAlign(Align.CENTER);
        this.textPaint.setStyle(Style.STROKE);
        this.textPaint.setFakeBoldText(true);
        this.textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        this.textPaint.setColor(this.textColor);
    }

    public void start() {
        this.expired = false;
        for (Handler handler : this.handlers) {
            if (handler != null) {
                handler.onStart();
            }
        }
        this.animation.reset();
        this.currentSecond = (double) this.totalSeconds;
        this.animation.setDuration((long) this.animationDuration);
        this.animation.setRepeatCount((this.totalSeconds * 1000) / this.animationDuration);
        C0789L.log.debug("animation {} {}", (Object) Long.valueOf(this.animation.getDuration()), (Object) Integer.valueOf(this.animation.getRepeatCount()));
        this.animation.setStartTime(-1);
        this.animation.setAnimationListener(this);
        startAnimation(this.animation);
    }

    public void addHandler(Handler handler) {
        if (handler != null && !this.handlers.contains(handler)) {
            this.handlers.add(handler);
        }
    }

    public void clearHandlers() {
        this.handlers.clear();
    }

    public void stop() {
        this.animation.cancel();
    }

    public void startAnimation(Animation animation2) {
        super.startAnimation(animation2);
        setAnimation(animation2);
        animation2.start();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - this.strike;
        int paddingLeft = getPaddingLeft() + (this.strike / 2);
        int i = paddingLeft + width;
        int i2 = paddingLeft + (width / 2);
        int height = ((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.strike;
        int paddingTop = getPaddingTop() + (this.strike / 2);
        int i3 = paddingTop + (height / 2);
        this.rect.set((float) paddingLeft, (float) paddingTop, (float) i, (float) (paddingTop + height));
        canvas.drawArc(this.rect, -90.0f, 360.0f, false, this.circlePassedPaint);
        canvas.drawArc(this.rect, -90.0f, this.currentDegree, false, this.circlePaint);
        int textWidth = getTextWidth();
        int textHight = getTextHight();
        int i4 = i2 - (textWidth / 2);
        int i5 = i3 - (textHight / 2);
        this.txtRect.set(i4, i5, textWidth + i4, textHight + i5);
        FontMetricsInt fontMetricsInt = this.textPaint.getFontMetricsInt();
        canvas.drawText(this.text, (float) this.txtRect.centerX(), (float) ((this.txtRect.top + ((((this.txtRect.bottom - this.txtRect.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2)) - fontMetricsInt.top), this.textPaint);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measureWidth = measureWidth(i);
        int measureHeight = measureHeight(i2);
        int max = Math.max(this.radiusX, this.radiusY);
        if (max > 0) {
            this.radiusOutter = max / 2;
            this.strike = (int) (((double) this.radiusOutter) * 0.2d);
            this.circlePaint.setStrokeWidth((float) this.strike);
            this.circlePassedPaint.setStrokeWidth((float) this.strike);
            this.fontSize = 0.6f * ((float) this.radiusOutter);
            this.textPaint.setTextSize(this.fontSize);
        }
        setMeasuredDimension(measureWidth, measureHeight);
    }

    private int getTextHight() {
        return (int) (this.textPaint.descent() - this.textPaint.ascent());
    }

    private int getTextWidth() {
        return (int) this.textPaint.measureText(this.text);
    }

    private int getViewHight() {
        return this.radiusOutter * 2;
    }

    private int getViewWidth() {
        return this.radiusOutter * 2;
    }

    private int measureWidth(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            this.radiusX = size;
            return size;
        } else if (this.radiusY > 0) {
            return this.radiusY;
        } else {
            int viewWidth = getViewWidth() + getPaddingLeft() + getPaddingRight();
            return mode == Integer.MIN_VALUE ? Math.min(viewWidth, size) : viewWidth;
        }
    }

    private int measureHeight(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            this.radiusY = size;
            return size;
        } else if (this.radiusX > 0) {
            return this.radiusX;
        } else {
            int viewHight = getViewHight() + getPaddingTop() + getPaddingBottom();
            return mode == Integer.MIN_VALUE ? Math.min(viewHight, size) : viewHight;
        }
    }

    public void onAnimationStart(Animation animation2) {
        this.currentDegree = 360.0f;
        invalidate();
    }

    public void onAnimationEnd(Animation animation2) {
        this.currentDegree = 0.0f;
        invalidate();
    }

    public void onAnimationRepeat(Animation animation2) {
        double d = (((double) this.totalSeconds) * 1000.0d) / ((double) this.animationDuration);
        double d2 = 360.0d / d;
        double d3 = ((double) this.totalSeconds) / d;
        this.currentDegree = (float) (((double) this.currentDegree) - d2);
        this.currentSecond -= d3;
        int i = (int) this.currentSecond;
        double d4 = this.currentSecond - ((double) i);
        StringBuilder sb = new StringBuilder();
        if (d4 > 1.0E-5d) {
            i++;
        }
        this.text = sb.append(i).toString();
        invalidate();
        if (this.currentSecond <= 1.0E-5d) {
            this.expired = true;
            for (Handler handler : this.handlers) {
                if (handler != null) {
                    handler.onTimeFinished();
                }
            }
        }
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    public void setTotalSeconds(int i) {
        this.totalSeconds = i;
    }

    public boolean isExpired() {
        return this.expired;
    }
}
