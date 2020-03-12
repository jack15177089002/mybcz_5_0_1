package com.baicizhan.client.fight.customview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
//import com.baicizhan.client.fight.R;
import com.jiongji.andriod.card.R;
import com.p047d.p048a.Animator;
import com.p047d.p048a.C1548at;
import com.p047d.p048a.C1549b;
import com.p047d.p048a.ValueAnimator;

public class RoundProgress extends View {
    private static final String TAG = "RoundProgress";
    /* access modifiers changed from: private */
    public ValueAnimator mCountDNAnim;
    /* access modifiers changed from: private */
    public long mCur;
    /* access modifiers changed from: private */
    public long mFrom;
    private int mProgBackColor;
    private Paint mProgBackPaint;
    private int mProgColor;
    private Paint mProgPaint;
    private CharSequence mProgText;
    private int mProgTextColor;
    private TextPaint mProgTextPaint;
    private int mProgTextSize;
    private int mProgress;
    private int mRadius;
    private int mRim;
    private RectF mRoundBounds = new RectF();
    /* access modifiers changed from: private */
    public int mSweepAngle;
    /* access modifiers changed from: private */
    public long mTo;

    public RoundProgress(Context context) {
        super(context);
    }

    public RoundProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initPaints();
        setDefaultAttrs(context);
//        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundProgress);
//        int indexCount = obtainStyledAttributes.getIndexCount();
//        for (int i = 0; i < indexCount; i++) {
//            int index = obtainStyledAttributes.getIndex(i);
//            if (index == R.styleable.RoundProgress_rp_radius) {
//                this.mRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.mRadius);
//            } else if (index == R.styleable.RoundProgress_rp_rim) {
//                this.mRim = obtainStyledAttributes.getDimensionPixelSize(index, this.mRim);
//            } else if (index == R.styleable.RoundProgress_rp_prog_text_size) {
//                this.mProgTextSize = obtainStyledAttributes.getDimensionPixelSize(index, this.mProgTextSize);
//            } else if (index == R.styleable.RoundProgress_rp_prog_text_color) {
//                this.mProgTextColor = obtainStyledAttributes.getColor(index, this.mProgTextColor);
//            } else if (index == R.styleable.RoundProgress_rp_prog_back_color) {
//                this.mProgBackColor = obtainStyledAttributes.getColor(index, this.mProgBackColor);
//            } else if (index == R.styleable.RoundProgress_rp_prog_color) {
//                this.mProgColor = obtainStyledAttributes.getColor(index, this.mProgColor);
//            }
//        }
//        obtainStyledAttributes.recycle();
        applyAttrs();
    }

    private void initPaints() {
        this.mProgBackPaint = new Paint(1);
        this.mProgBackPaint.setStyle(Style.STROKE);
        this.mProgPaint = new Paint(1);
        this.mProgPaint.setStyle(Style.STROKE);
        this.mProgTextPaint = new TextPaint(1);
        this.mProgTextPaint.setStyle(Style.FILL);
        this.mProgTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.mProgTextPaint.setTextAlign(Align.CENTER);
    }

    private void setDefaultAttrs(Context context) {
        Resources resources = context.getResources();
        this.mRadius = resources.getDimensionPixelSize(R.dimen.fight_def_rp_radius);
        this.mRim = resources.getDimensionPixelSize(R.dimen.fight_def_rp_rim);
        this.mProgTextSize = resources.getDimensionPixelSize(R.dimen.fight_def_rp_prog_text_size);
        this.mProgText = "10";
        this.mProgBackColor = resources.getColor(R.color.fight_def_gray_color);
        this.mProgColor = resources.getColor(R.color.fight_def_blue_color);
        this.mProgTextColor = resources.getColor(R.color.fight_def_blue_color);
    }

    private void applyAttrs() {
        this.mProgBackPaint.setStrokeWidth((float) this.mRim);
        this.mProgBackPaint.setColor(this.mProgBackColor);
        this.mProgPaint.setStrokeWidth((float) this.mRim);
        this.mProgPaint.setColor(this.mProgColor);
        this.mProgTextPaint.setTextSize((float) this.mProgTextSize);
        this.mProgTextPaint.setColor(this.mProgTextColor);
    }

    public void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(((this.mRadius + this.mRim) * 2) + getPaddingLeft() + getPaddingRight(), i), resolveSize(((this.mRadius + this.mRim) * 2) + getPaddingTop() + getPaddingBottom(), i2));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int i = height - this.mRadius;
        int i2 = height + this.mRadius;
        this.mRoundBounds.set((float) (width - this.mRadius), (float) i, (float) (this.mRadius + width), (float) i2);
        canvas.drawArc(this.mRoundBounds, 360.0f, 360.0f, false, this.mProgBackPaint);
        canvas.drawArc(this.mRoundBounds, -90.0f, (float) this.mSweepAngle, false, this.mProgPaint);
        if (!TextUtils.isEmpty(this.mProgText)) {
            FontMetrics fontMetrics = this.mProgTextPaint.getFontMetrics();
            canvas.drawText(this.mProgText.toString(), (float) width, (float) ((int) ((((((float) (i2 - i)) - fontMetrics.bottom) - fontMetrics.top) / 2.0f) + ((float) i))), this.mProgTextPaint);
        }
    }

    public void startCountDown(long j) {
        this.mFrom = 0;
        this.mCur = 0;
        this.mTo = j;
        countDown(this.mFrom, this.mTo);
    }

    public void pauseCountDown() {
        if (this.mCountDNAnim != null) {
            this.mCountDNAnim.mo16164b();
        }
    }

    public void continueCountDown() {
        countDown(this.mCur, this.mTo);
    }

    public void stopCountDown() {
        if (this.mCountDNAnim != null) {
            this.mCountDNAnim.mo16166c();
        }
        this.mFrom = 0;
        this.mCur = 0;
        this.mTo = 0;
    }

    private void countDown(long j, long j2) {
        if (j < j2) {
            if (this.mCountDNAnim != null) {
                this.mCountDNAnim.mo16164b();
                this.mCountDNAnim = null;
            }
            if (this.mCountDNAnim == null) {
                this.mCountDNAnim = ValueAnimator.m3295b((float) j, (float) j2);
                this.mCountDNAnim.f3483k = new LinearInterpolator();
                this.mCountDNAnim.mo16188b(j2 - j);
                final long j3 = j;
                final long j4 = j2;
                this.mCountDNAnim.mo16184a((C1548at) new C1548at() {
                    public void onAnimationUpdate(ValueAnimator amVar) {
                        float f = amVar.f3476d;
                        RoundProgress.this.mCur = (long) Math.round((f * ((float) (j4 - j3))) + ((float) j3));
                        if (RoundProgress.this.mCur == RoundProgress.this.mFrom) {
                            RoundProgress.this.mSweepAngle = 0;
                        } else {
                            RoundProgress.this.mSweepAngle = 360 - Math.round((float) ((360 * (RoundProgress.this.mCur - RoundProgress.this.mFrom)) / (RoundProgress.this.mTo - RoundProgress.this.mFrom)));
                        }
                        RoundProgress.this.invalidate();
                    }
                });
                this.mCountDNAnim.mo16162a((C1549b) new C1549b() {
                    public void onAnimationStart(Animator aVar) {
                    }

                    public void onAnimationRepeat(Animator aVar) {
                    }

                    public void onAnimationEnd(Animator aVar) {
                        RoundProgress.this.mCountDNAnim = null;
                    }

                    public void onAnimationCancel(Animator aVar) {
                        RoundProgress.this.mCountDNAnim = null;
                    }
                });
            }
            this.mCountDNAnim.mo16161a();
        }
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        this.mProgress = i;
        this.mSweepAngle = (i * 360) / 100;
        invalidate();
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void setRadius(int i) {
        this.mRadius = i;
        requestLayout();
        invalidate();
    }

    public int getRadius() {
        return this.mRadius;
    }

    public void setRim(int i) {
        this.mRim = i;
        this.mProgBackPaint.setStrokeWidth((float) this.mRim);
        this.mProgPaint.setStrokeWidth((float) this.mRim);
        requestLayout();
        invalidate();
    }

    public int getRim() {
        return this.mRim;
    }

    public void setProgTextSize(int i) {
        this.mProgTextSize = i;
        this.mProgTextPaint.setTextSize((float) this.mProgTextSize);
        invalidate();
    }

    public int getProgTextSize() {
        return this.mProgTextSize;
    }

    public void setProgTextColor(int i) {
        this.mProgTextColor = i;
        this.mProgTextPaint.setColor(i);
        invalidate();
    }

    public int getProgTextColor() {
        return this.mProgTextColor;
    }

    public void setProgText(CharSequence charSequence) {
        this.mProgText = charSequence;
        invalidate();
    }

    public void setProgText(int i) {
        setProgText((CharSequence) getContext().getString(i));
    }

    public CharSequence getProgText() {
        return this.mProgText;
    }

    public void setProgBackColor(int i) {
        this.mProgBackColor = i;
        this.mProgBackPaint.setColor(i);
        invalidate();
    }

    public int getProgBackColor() {
        return this.mProgBackColor;
    }

    public void setProgColor(int i) {
        this.mProgColor = i;
        this.mProgPaint.setColor(i);
        invalidate();
    }

    public int getProgColor() {
        return this.mProgColor;
    }
}
