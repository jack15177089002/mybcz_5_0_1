//package com.baicizhan.client.wordtesting.view;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.Paint.Style;
//import android.graphics.Path;
//import android.text.TextPaint;
//import android.util.AttributeSet;
//import android.view.View;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.client.wordtesting.C0933R;
//import com.baicizhan.client.wordtesting.util.Constants;
//import com.p047d.p048a.Animator;
//import com.p047d.p048a.AnimatorSet;
//import com.p047d.p048a.C1548at;
//import com.p047d.p048a.ValueAnimator;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import org.slf4j.Logger;
//
//public class VocabStatsCurveView extends View {
//    private static final int BOUND_PADDING = 2;
//    private static final int CURVE_FRAGMENT_WALK_DUR = 500;
//    private static final int IN_DOT_RADIUS = 2;
//    private static final int LAST_MARK_WIDTH = 60;
//    public static final int MAX_DIV = 9;
//    private static final int OUT_DOT_RADIUS = 4;
//    private int mBottomPadding;
//    private Paint mCurvePaint;
//    private Path[] mCurvePaths = new Path[this.mMaxDiv];
//    /* access modifiers changed from: private */
//    public float[] mDotFadeProgs = new float[(this.mMaxDiv + 1)];
//    /* access modifiers changed from: private */
//    public float mDotsFadeProg = -1.0f;
//    private Paint mFillPaint;
//    private Path[] mFillPaths = new Path[this.mMaxDiv];
//    private int[] mHXS = new int[(this.mMaxDiv + 1)];
//    private Paint mInDotPaint;
//    private int mInDotRadius;
//    private boolean mIsMI2S = Constants.isMI2S();
//    private String mLastMark;
//    private Paint mLastMarkPaint;
//    /* access modifiers changed from: private */
//    public float mLastMarkProg;
//    private int mLeftPadding;
//    private int mMaxDiv = 9;
//    private Paint mOutDotPaint;
//    private int mOutDotRadius;
//    /* access modifiers changed from: private */
//    public float[] mProgresses = new float[this.mMaxDiv];
//    private int mRightPadding;
//    private int mTopPadding;
//    private int[] mVXS = new int[(this.mMaxDiv + 1)];
//    private AnimatorSet mWalkAnims;
//
//    public VocabStatsCurveView(Context context) {
//        super(context);
//        init();
//    }
//
//    public VocabStatsCurveView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        init();
//    }
//
//    private void init() {
//        this.mLastMarkPaint = new TextPaint(1);
//        this.mLastMarkPaint.setColor(-14693891);
//        this.mLastMarkPaint.setStyle(Style.FILL);
//        this.mLastMarkPaint.setTextSize((float) getContext().getResources().getDimensionPixelSize(C0933R.dimen.wordtesting_stats_vx_count_size));
//        this.mInDotPaint = new Paint(1);
//        this.mInDotPaint.setColor(-14693891);
//        this.mInDotPaint.setStyle(Style.FILL);
//        this.mOutDotPaint = new Paint(1);
//        this.mOutDotPaint.setColor(-2011182595);
//        this.mOutDotPaint.setStyle(Style.FILL);
//        this.mFillPaint = new Paint(1);
//        this.mFillPaint.setColor(537374947);
//        if (this.mIsMI2S) {
//            this.mFillPaint.setStyle(Style.FILL_AND_STROKE);
//            this.mFillPaint.setStrokeWidth(2.0f);
//        } else {
//            this.mFillPaint.setStyle(Style.FILL);
//        }
//        this.mCurvePaint = new Paint(1);
//        this.mCurvePaint.setColor(-14693891);
//        this.mCurvePaint.setStyle(Style.STROKE);
//        this.mCurvePaint.setStrokeWidth(2.0f);
//        for (int i = 0; i < this.mMaxDiv; i++) {
//            this.mFillPaths[i] = new Path();
//            this.mCurvePaths[i] = new Path();
//        }
//        this.mInDotRadius = Common.dip2px(getContext(), 2.0f);
//        this.mOutDotRadius = Common.dip2px(getContext(), 4.0f);
//        this.mLeftPadding = (this.mOutDotRadius * 2) + 2;
//        this.mRightPadding = (this.mOutDotRadius * 2) + Common.dip2px(getContext(), 60.0f);
//        this.mTopPadding = this.mOutDotRadius * 4;
//        this.mBottomPadding = (this.mOutDotRadius * 2) + 2;
//        if (this.mIsMI2S) {
//            this.mLeftPadding += 2;
//        }
//    }
//
//    public void start(final List<Float> list, String str) {
//        int i = 0;
//        if (list == null || list.size() > 10 || list.size() == 0) {
//            Logger logger = C0789L.log;
//            String str2 = "vocabulary stats curve action cannot start for illegal input argument. vertical percents [{}], its size [{}]";
//            if (list != null) {
//                i = list.size();
//            }
//            logger.error(str2, (Object) list, (Object) Integer.valueOf(i));
//            return;
//        }
//        this.mMaxDiv = list.size() - 1;
//        this.mLastMark = str;
//        for (int i2 = 0; i2 < this.mMaxDiv; i2++) {
//            this.mProgresses[i2] = 0.0f;
//        }
//        while (i < this.mMaxDiv + 1) {
//            this.mDotFadeProgs[i] = 0.0f;
//            i++;
//        }
//        this.mDotsFadeProg = -1.0f;
//        this.mLastMarkProg = 0.0f;
//        post(new Runnable() {
//            public void run() {
//                VocabStatsCurveView.this.dostart(list);
//            }
//        });
//    }
//
//    /* access modifiers changed from: private */
//    public void dostart(List<Float> list) {
//        int width = getWidth();
//        int height = getHeight();
//        for (int i = 0; i < this.mMaxDiv + 1; i++) {
//            if (((Float) list.get(i)).floatValue() < 0.0f || ((Float) list.get(i)).floatValue() > 1.0f) {
//                C0789L.log.error("vocabulary stats curve action cannot start for illegal input argument, [{}] is out of range.", list.get(i));
//                return;
//            }
//            this.mVXS[i] = (int) ((1.0f - ((Float) list.get(i)).floatValue()) * ((float) ((height - this.mTopPadding) - this.mBottomPadding)));
//            this.mHXS[i] = (((width - this.mLeftPadding) - this.mRightPadding) * i) / 9;
//        }
//        if (this.mWalkAnims == null) {
//            this.mWalkAnims = new AnimatorSet();
//            ArrayList arrayList = new ArrayList(this.mMaxDiv);
//            for (final int i2 = 0; i2 < this.mMaxDiv; i2++) {
//                ValueAnimator b = ValueAnimator.m3295b(0.0f, 100.0f);
//                b.mo16188b(500);
//                b.f3480h = (long) (i2 * CURVE_FRAGMENT_WALK_DUR);
//                b.mo16184a((C1548at) new C1548at() {
//                    public void onAnimationUpdate(ValueAnimator amVar) {
//                        VocabStatsCurveView.this.mProgresses[i2] = amVar.f3476d;
//                        VocabStatsCurveView.this.invalidate();
//                    }
//                });
//                arrayList.add(b);
//            }
//            for (final int i3 = 0; i3 < this.mMaxDiv + 1; i3++) {
//                ValueAnimator b2 = ValueAnimator.m3295b(0.0f, 100.0f);
//                b2.mo16188b(500);
//                b2.f3480h = (long) (i3 * CURVE_FRAGMENT_WALK_DUR);
//                b2.mo16184a((C1548at) new C1548at() {
//                    public void onAnimationUpdate(ValueAnimator amVar) {
//                        VocabStatsCurveView.this.mDotFadeProgs[i3] = amVar.f3476d;
//                        VocabStatsCurveView.this.invalidate();
//                    }
//                });
//                arrayList.add(b2);
//            }
//            ValueAnimator b3 = ValueAnimator.m3295b(0.0f, 100.0f);
//            b3.mo16188b(4000);
//            b3.f3480h = (long) (this.mMaxDiv * 600);
//            b3.f3481i = -1;
//            b3.mo16184a((C1548at) new C1548at() {
//                public void onAnimationUpdate(ValueAnimator amVar) {
//                    float f = amVar.f3476d;
//                    if (f < 0.25f && f >= 0.0f) {
//                        VocabStatsCurveView.this.mDotsFadeProg = f * 4.0f;
//                    } else if (f <= 0.5f) {
//                        VocabStatsCurveView.this.mDotsFadeProg = 1.0f - ((f - 0.25f) * 4.0f);
//                    }
//                    VocabStatsCurveView.this.invalidate();
//                }
//            });
//            arrayList.add(b3);
//            ValueAnimator b4 = ValueAnimator.m3295b(0.0f, 100.0f);
//            b4.mo16188b(1000);
//            b4.f3480h = (long) ((this.mMaxDiv * 600) + 300);
//            b4.mo16184a((C1548at) new C1548at() {
//                public void onAnimationUpdate(ValueAnimator amVar) {
//                    VocabStatsCurveView.this.mLastMarkProg = amVar.f3476d;
//                    VocabStatsCurveView.this.invalidate();
//                }
//            });
//            arrayList.add(b4);
//            this.mWalkAnims.mo16200a((Collection<Animator>) arrayList);
//        } else {
//            this.mWalkAnims.mo16164b();
//        }
//        this.mWalkAnims.mo16161a();
//    }
//
//    public void onDraw(Canvas canvas) {
//        int height = getHeight();
//        for (int i = 0; i < this.mMaxDiv; i++) {
//            if (this.mProgresses[i] > 0.0f) {
//                this.mFillPaths[i].reset();
//                this.mCurvePaths[i].reset();
//                this.mFillPaths[i].moveTo((float) (this.mLeftPadding + this.mHXS[i]), (float) (height - this.mBottomPadding));
//                this.mFillPaths[i].lineTo((float) (this.mLeftPadding + this.mHXS[i]), (float) (this.mVXS[i] + this.mTopPadding));
//                this.mFillPaths[i].lineTo(((float) (this.mLeftPadding + this.mHXS[i])) + (((float) (this.mHXS[i + 1] - this.mHXS[i])) * this.mProgresses[i]), ((float) this.mVXS[i]) + (((float) (this.mVXS[i + 1] - this.mVXS[i])) * this.mProgresses[i]) + ((float) this.mTopPadding));
//                this.mFillPaths[i].lineTo(((float) (this.mLeftPadding + this.mHXS[i])) + (((float) (this.mHXS[i + 1] - this.mHXS[i])) * this.mProgresses[i]), (float) (height - this.mBottomPadding));
//                this.mFillPaths[i].lineTo((float) (this.mLeftPadding + this.mHXS[i]), (float) (height - this.mBottomPadding));
//                this.mCurvePaths[i].moveTo((float) (this.mLeftPadding + this.mHXS[i]), (float) (this.mVXS[i] + this.mTopPadding));
//                this.mCurvePaths[i].lineTo(((float) (this.mLeftPadding + this.mHXS[i])) + (((float) (this.mHXS[i + 1] - this.mHXS[i])) * this.mProgresses[i]), ((float) this.mVXS[i]) + (((float) (this.mVXS[i + 1] - this.mVXS[i])) * this.mProgresses[i]) + ((float) this.mTopPadding));
//                canvas.drawPath(this.mFillPaths[i], this.mFillPaint);
//                canvas.drawPath(this.mCurvePaths[i], this.mCurvePaint);
//            }
//        }
//        for (int i2 = 0; i2 < this.mMaxDiv + 1; i2++) {
//            if (this.mDotsFadeProg < 0.0f || i2 != this.mMaxDiv) {
//                this.mOutDotPaint.setAlpha((int) (128.0f * this.mDotFadeProgs[i2]));
//                this.mInDotPaint.setAlpha((int) (this.mDotFadeProgs[i2] * 255.0f));
//                canvas.drawCircle((float) (this.mLeftPadding + this.mHXS[i2]), (float) (this.mVXS[i2] + this.mTopPadding), ((float) this.mOutDotRadius) * this.mDotFadeProgs[i2], this.mOutDotPaint);
//                canvas.drawCircle((float) (this.mLeftPadding + this.mHXS[i2]), (float) (this.mVXS[i2] + this.mTopPadding), ((float) this.mInDotRadius) * this.mDotFadeProgs[i2], this.mInDotPaint);
//            } else {
//                this.mOutDotPaint.setAlpha(128);
//                this.mInDotPaint.setAlpha(255);
//                canvas.drawCircle((float) (this.mLeftPadding + this.mHXS[i2]), (float) (this.mVXS[i2] + this.mTopPadding), ((float) this.mOutDotRadius) + (((float) this.mOutDotRadius) * this.mDotsFadeProg), this.mOutDotPaint);
//                canvas.drawCircle((float) (this.mLeftPadding + this.mHXS[i2]), (float) (this.mVXS[i2] + this.mTopPadding), ((float) this.mInDotRadius) + (((float) this.mInDotRadius) * this.mDotsFadeProg), this.mInDotPaint);
//            }
//            if (i2 == this.mMaxDiv && this.mLastMarkProg > 0.0f) {
//                this.mLastMarkPaint.setAlpha((int) (this.mLastMarkProg * 255.0f));
//                canvas.drawText(this.mLastMark, (float) (this.mLeftPadding + this.mHXS[i2] + this.mOutDotRadius), (float) (this.mVXS[i2] + (this.mTopPadding / 2)), this.mLastMarkPaint);
//            }
//        }
//    }
//}
