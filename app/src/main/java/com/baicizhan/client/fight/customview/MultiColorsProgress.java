package com.baicizhan.client.fight.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.p047d.p048a.Animator;
import com.p047d.p048a.AnimatorListenerAdapter;
import com.p047d.p048a.AnimatorSet;
import com.p047d.p048a.C1548at;
import com.p047d.p048a.C1549b;
import com.p047d.p048a.ValueAnimator;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiColorsProgress extends View {
    private static final String TAG = "MultiColorsProgress";
    /* access modifiers changed from: private */
    public int mAlphaing;
    /* access modifiers changed from: private */
    public AnimatorSet mAnimSet;
    private ArrayList<ProgressFragment> mHistoryProgresses;
    /* access modifiers changed from: private */
    public int mLastProgress;
    private Paint mPaint;
    /* access modifiers changed from: private */
    public int mProgress;
    /* access modifiers changed from: private */
    public ProgressFragment mProgressing;

    class ProgressFragment {
        int color;
        int from;

        /* renamed from: to */
        int f2264to;

        ProgressFragment() {
        }
    }

    public MultiColorsProgress(Context context) {
        super(context);
        this.mHistoryProgresses = new ArrayList<>();
        this.mAlphaing = 255;
    }

    public MultiColorsProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHistoryProgresses = new ArrayList<>();
        this.mAlphaing = 255;
        this.mPaint = new Paint(1);
        this.mPaint.setStyle(Style.STROKE);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setStrokeWidth((float) getWidth());
        Iterator it = this.mHistoryProgresses.iterator();
        while (it.hasNext()) {
            ProgressFragment progressFragment = (ProgressFragment) it.next();
            if (progressFragment != null) {
                drawProgress(canvas, progressFragment, false);
            }
        }
        if (this.mProgressing != null) {
            drawProgress(canvas, this.mProgressing, true);
        }
    }

    private void drawProgress(Canvas canvas, ProgressFragment progressFragment, boolean z) {
        this.mPaint.setColor(progressFragment.color);
        if (z) {
            this.mPaint.setAlpha(this.mAlphaing);
        }
        float width = (float) (getWidth() / 2);
        canvas.drawLine(width, (float) (getHeight() - ((getHeight() * progressFragment.from) / 100)), width, (float) (getHeight() - ((getHeight() * progressFragment.f2264to) / 100)), this.mPaint);
    }

    private void animProgress() {
        if (this.mAnimSet != null) {
            this.mAnimSet.mo16164b();
        }
        this.mAnimSet = new AnimatorSet();
        ValueAnimator b = ValueAnimator.m3296b(this.mLastProgress, this.mProgress);
        b.mo16188b((long) Math.max(800, Math.abs(this.mProgress - this.mLastProgress) * 30));
        b.f3483k = new LinearInterpolator();
        b.mo16184a((C1548at) new C1548at() {
            public void onAnimationUpdate(ValueAnimator amVar) {
                float f = amVar.f3476d;
                MultiColorsProgress.this.mProgressing.f2264to = (int) ((f * ((float) (MultiColorsProgress.this.mProgress - MultiColorsProgress.this.mLastProgress))) + ((float) MultiColorsProgress.this.mLastProgress));
                MultiColorsProgress.this.invalidate();
            }
        });
        ValueAnimator b2 = ValueAnimator.m3296b(255, 50, 255);
        b2.mo16188b(800);
        b2.f3483k = new LinearInterpolator();
        b2.mo16184a((C1548at) new C1548at() {
            public void onAnimationUpdate(ValueAnimator amVar) {
                MultiColorsProgress.this.mAlphaing = ((Integer) amVar.mo16192g()).intValue();
                MultiColorsProgress.this.invalidate();
            }
        });
        this.mAnimSet.mo16162a((C1549b) new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator aVar) {
                MultiColorsProgress.this.mAlphaing = 255;
                MultiColorsProgress.this.mProgressing.f2264to = MultiColorsProgress.this.mProgress;
                MultiColorsProgress.this.invalidate();
                MultiColorsProgress.this.mAnimSet = null;
            }

            public void onAnimationCancel(Animator aVar) {
                MultiColorsProgress.this.mAlphaing = 255;
                MultiColorsProgress.this.mProgressing.f2264to = MultiColorsProgress.this.mProgress;
                MultiColorsProgress.this.invalidate();
                MultiColorsProgress.this.mAnimSet = null;
            }
        });
        this.mAnimSet.mo16201a(b, b2);
        this.mAnimSet.mo16161a();
    }

    public void setProgress(int i, int i2) {
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        if (i != this.mProgress) {
            if (i < this.mProgress) {
                this.mLastProgress = 0;
                this.mProgress = i;
                this.mHistoryProgresses.clear();
                this.mProgressing = new ProgressFragment();
                this.mProgressing.from = 0;
                this.mProgressing.f2264to = i;
                this.mProgressing.color = i2;
                animProgress();
                return;
            }
            this.mLastProgress = this.mProgress;
            this.mProgress = i;
            if (this.mProgressing != null) {
                this.mProgressing.f2264to = this.mLastProgress;
            }
            this.mHistoryProgresses.add(this.mProgressing);
            this.mProgressing = new ProgressFragment();
            this.mProgressing.from = this.mLastProgress;
            this.mProgressing.f2264to = i;
            this.mProgressing.color = i2;
            animProgress();
        }
    }

    public int getProgress() {
        return this.mProgress;
    }
}
