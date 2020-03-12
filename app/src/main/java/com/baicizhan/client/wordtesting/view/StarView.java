package com.baicizhan.client.wordtesting.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.p047d.p048a.Animator;
import com.p047d.p048a.C1548at;
import com.p047d.p048a.C1549b;
import com.p047d.p048a.ValueAnimator;

public class StarView extends View {
    private RectF mLBOval = new RectF();
    private RectF mLTOval = new RectF();
    private RectF mRBOval = new RectF();
    private RectF mRTOval = new RectF();
    private ValueAnimator mShine;
    /* access modifiers changed from: private */
    public float mShineProg;
    private int mSpaceColor = -13158601;
    private Paint mSpacePaint;
    private int mStarColor = -330048;
    private Paint mStarPaint;
    private RectF mStarR = new RectF();

    public StarView(Context context) {
        super(context);
        init();
    }

    public StarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.mStarPaint = new Paint(1);
        this.mStarPaint.setStyle(Style.FILL);
        this.mStarPaint.setColor(this.mStarColor);
        this.mSpacePaint = new Paint(1);
        this.mSpacePaint.setStyle(Style.FILL);
        this.mSpacePaint.setColor(this.mSpaceColor);
    }

    public void onDraw(Canvas canvas) {
        float width = (float) getWidth();
        float height = (float) getHeight();
        float f = width / 2.0f;
        float f2 = (height / 2.0f) - ((this.mShineProg * height) / 6.0f);
        this.mLTOval.left = f - (this.mShineProg * width);
        this.mLTOval.top = f2 - (((this.mShineProg * 2.0f) * height) / 3.0f);
        this.mLTOval.right = f;
        this.mLTOval.bottom = f2;
        this.mLBOval.left = f - (this.mShineProg * width);
        this.mLBOval.top = f2;
        this.mLBOval.right = f;
        this.mLBOval.bottom = ((((this.mShineProg * 2.0f) * 2.0f) * height) / 3.0f) + f2;
        this.mRBOval.left = f;
        this.mRBOval.top = f2;
        this.mRBOval.right = (((this.mShineProg * 2.0f) * width) / 2.0f) + f;
        this.mRBOval.bottom = ((((this.mShineProg * 2.0f) * 2.0f) * height) / 3.0f) + f2;
        this.mRTOval.left = f;
        this.mRTOval.top = f2 - (((this.mShineProg * 2.0f) * height) / 3.0f);
        this.mRTOval.right = (((this.mShineProg * 2.0f) * width) / 2.0f) + f;
        this.mRTOval.bottom = f2;
        this.mStarR.left = f - ((this.mShineProg * width) / 2.0f);
        this.mStarR.top = (height / 2.0f) - ((this.mShineProg * height) / 2.0f);
        this.mStarR.right = ((width * this.mShineProg) / 2.0f) + f;
        this.mStarR.bottom = ((height * this.mShineProg) / 2.0f) + (height / 2.0f);
        canvas.drawRect(this.mStarR, this.mStarPaint);
        canvas.drawOval(this.mLTOval, this.mSpacePaint);
        canvas.drawOval(this.mLBOval, this.mSpacePaint);
        canvas.drawOval(this.mRBOval, this.mSpacePaint);
        canvas.drawOval(this.mRTOval, this.mSpacePaint);
    }

    public void setStarColor(int i) {
        this.mStarColor = i;
        this.mStarPaint.setColor(this.mStarColor);
        invalidate();
    }

    public void setSpaceColor(int i) {
        this.mSpaceColor = i;
        this.mSpacePaint.setColor(this.mSpaceColor);
        invalidate();
    }

    public void startShine(final long j) {
        this.mShineProg = 1.0f;
        postDelayed(new Runnable() {
            public void run() {
                StarView.this.dostartShine(j);
            }
        }, j);
    }

    /* access modifiers changed from: private */
    public void dostartShine(long j) {
        if (this.mShine == null) {
            this.mShine = ValueAnimator.m3295b(0.0f, 100.0f);
            this.mShine.mo16188b(4000);
            this.mShine.f3480h = j;
            this.mShine.f3481i = -1;
            this.mShine.mo16184a((C1548at) new C1548at() {
                public void onAnimationUpdate(ValueAnimator amVar) {
                    float f = amVar.f3476d;
                    if (f < 0.25f && f >= 0.0f) {
                        StarView.this.mShineProg = f * 4.0f;
                    } else if (f <= 0.5f) {
                        StarView.this.mShineProg = 1.0f - ((f - 0.25f) * 4.0f);
                    }
                    StarView.this.invalidate();
                }
            });
            this.mShine.mo16162a((C1549b) new C1549b() {
                public void onAnimationCancel(Animator aVar) {
                }

                public void onAnimationEnd(Animator aVar) {
                }

                public void onAnimationRepeat(Animator aVar) {
                }

                public void onAnimationStart(Animator aVar) {
                    StarView.this.setVisibility(0);
                }
            });
        } else {
            this.mShine.mo16164b();
        }
        this.mShine.mo16161a();
    }
}
