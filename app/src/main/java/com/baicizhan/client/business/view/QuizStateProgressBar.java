package com.baicizhan.client.business.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.R;
import com.baicizhan.client.business.view.AnimationController.OnAnimateListener;
//import com.jiongji.andriod.card.R;

public class QuizStateProgressBar extends View {
    public static final int STATE_NONE = -1;
    public static final int STATE_RIGHT = 1;
    public static final int STATE_WRONG = 0;
    private AnimationController mAnimationController;
    /* access modifiers changed from: private */
    public boolean mAniming = false;
    private int mCellHeight;
    /* access modifiers changed from: private */
    public Rect[] mCellRects;
    private int mCellWidth;
    private Drawable mCursor;
    /* access modifiers changed from: private */
    public int mCursorIndex = 0;
    /* access modifiers changed from: private */
    public Rect mCursorRect;
    private Rect mDrawRect;
    private Drawable mEndBackground;
    private Drawable mEndCursor;
    private Drawable mEndRight;
    private Drawable mEndWrong;
    private Drawable mNormalBackground;
    private Drawable mNormalCursor;
    private Drawable mNormalRight;
    private Drawable mNormalWrong;
    private QSPAnimationListener mOnAnimateListener = new QSPAnimationListener();
    /* access modifiers changed from: private */
    public int mQuantity;
    private Drawable mStartBackground;
    private Drawable mStartCursor;
    private Drawable mStartRight;
    private Drawable mStartWrong;
    /* access modifiers changed from: private */
    public int[] mStates;

    public class Initializer {
        private int mCursorIndex = 0;
        private int[] mStates;
        private QuizStateProgressBar mTarget;

        public Initializer wrap(QuizStateProgressBar quizStateProgressBar) {
            this.mTarget = quizStateProgressBar;
            return this;
        }

        public Initializer setStates(int[] iArr) {
            this.mStates = iArr;
            return this;
        }

        public Initializer setCursorIndex(int i) {
            this.mCursorIndex = i;
            return this;
        }

        public QuizStateProgressBar initialize() {
            if (this.mTarget == null || this.mStates == null) {
                return null;
            }
            if (this.mCursorIndex < 0 || this.mCursorIndex >= this.mStates.length) {
                throw new IndexOutOfBoundsException("QuizStateProgressBar initialize failed. transferred cursor index is: " + this.mCursorIndex + "; valid range is 0 to " + (this.mStates.length - 1));
            }
            for (int access$700 : this.mStates) {
                if (!QuizStateProgressBar.isValidState(access$700)) {
                    throw new IllegalArgumentException("QuizStateProgressBar initialize failed for illegal quiz state.");
                }
            }
            this.mTarget.mStates = this.mStates;
            this.mTarget.mQuantity = this.mStates.length;
            this.mTarget.mCursorIndex = this.mCursorIndex;
            this.mTarget.requestLayout();
            this.mTarget.adjustCursor(true);
            return this.mTarget;
        }
    }

    class QSPAnimationListener implements OnAnimateListener {
        QSPAnimationListener() {
        }

        public void onAnimationStart() {
            QuizStateProgressBar.this.mAniming = true;
        }

        public boolean continueAnimating() {
            return QuizStateProgressBar.this.mCursorRect.left != QuizStateProgressBar.this.mCellRects[Math.min(QuizStateProgressBar.this.mCursorIndex, QuizStateProgressBar.this.mQuantity + -1)].left;
        }

        public void onFrameUpdate(int i) {
            QuizStateProgressBar.this.moveCursor(i);
        }

        public void onAnimateComplete() {
            QuizStateProgressBar.this.mAniming = false;
            QuizStateProgressBar.this.adjustCursor(true);
        }
    }

    public QuizStateProgressBar(Context context) {
        super(context);
        init(null, R.style.DefaultQuizStateProgressBar);
    }

    public QuizStateProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, R.style.DefaultQuizStateProgressBar);
    }

    public QuizStateProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, R.style.DefaultQuizStateProgressBar);
    }

    private void init(AttributeSet attributeSet, int i) {
//        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QuizStateProgressBar, 0, i);
//        applyAttrs(obtainStyledAttributes);
//        obtainStyledAttributes.recycle();
        this.mAnimationController = AnimationController.getDefault().init(this.mOnAnimateListener);
        this.mAnimationController.setVelocity(1);
    }

    private void applyAttrs(TypedArray typedArray) {
//        this.mStartBackground = typedArray.getDrawable(R.styleable.QuizStateProgressBar_startBackground);
//        this.mNormalBackground = typedArray.getDrawable(R.styleable.QuizStateProgressBar_normalBackground);
//        this.mEndBackground = typedArray.getDrawable(R.styleable.QuizStateProgressBar_endBackground);
//        this.mStartRight = typedArray.getDrawable(R.styleable.QuizStateProgressBar_startRight);
//        this.mNormalRight = typedArray.getDrawable(R.styleable.QuizStateProgressBar_normalRight);
//        this.mEndRight = typedArray.getDrawable(R.styleable.QuizStateProgressBar_endRight);
//        this.mStartWrong = typedArray.getDrawable(R.styleable.QuizStateProgressBar_startWrong);
//        this.mNormalWrong = typedArray.getDrawable(R.styleable.QuizStateProgressBar_normalWrong);
//        this.mEndWrong = typedArray.getDrawable(R.styleable.QuizStateProgressBar_endWrong);
//        this.mStartCursor = typedArray.getDrawable(R.styleable.QuizStateProgressBar_startCursor);
//        this.mNormalCursor = typedArray.getDrawable(R.styleable.QuizStateProgressBar_normalCursor);
//        this.mEndCursor = typedArray.getDrawable(R.styleable.QuizStateProgressBar_endCursor);
//        this.mCursor = this.mStartCursor;
//        this.mQuantity = typedArray.getInt(R.styleable.QuizStateProgressBar_quantity, 3);
        applyValues();
    }

    private void applyValues() {
        int min = Math.min(Math.min(Math.min(this.mStartRight.getIntrinsicWidth(), this.mStartWrong.getIntrinsicWidth()), this.mStartBackground.getIntrinsicWidth()), this.mStartCursor.getIntrinsicWidth());
        int min2 = Math.min(Math.min(Math.min(this.mNormalRight.getIntrinsicWidth(), this.mNormalWrong.getIntrinsicWidth()), this.mNormalBackground.getIntrinsicWidth()), this.mNormalCursor.getIntrinsicWidth());
        this.mCellWidth = Math.min(Math.min(min, min2), Math.min(Math.min(Math.min(this.mEndRight.getIntrinsicWidth(), this.mEndWrong.getIntrinsicWidth()), this.mEndBackground.getIntrinsicWidth()), this.mEndCursor.getIntrinsicWidth()));
        int min3 = Math.min(Math.min(Math.min(this.mStartRight.getIntrinsicHeight(), this.mStartWrong.getIntrinsicHeight()), this.mStartBackground.getIntrinsicHeight()), this.mStartCursor.getIntrinsicHeight());
        int min4 = Math.min(Math.min(Math.min(this.mNormalRight.getIntrinsicHeight(), this.mNormalWrong.getIntrinsicHeight()), this.mNormalBackground.getIntrinsicHeight()), this.mNormalCursor.getIntrinsicHeight());
        this.mCellHeight = Math.min(Math.min(min3, min4), Math.min(Math.min(Math.min(this.mEndRight.getIntrinsicHeight(), this.mEndWrong.getIntrinsicHeight()), this.mEndBackground.getIntrinsicHeight()), this.mEndCursor.getIntrinsicHeight()));
        this.mStates = new int[this.mQuantity];
        for (int i = 0; i < this.mQuantity; i++) {
            this.mStates[i] = -1;
        }
    }

    public void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (Integer.MIN_VALUE == MeasureSpec.getMode(i)) {
            size = (this.mCellWidth * this.mQuantity) + getPaddingLeft() + getPaddingRight();
        } else {
            this.mCellWidth = ((size - getPaddingLeft()) - getPaddingRight()) / this.mQuantity;
        }
        if (Integer.MIN_VALUE == MeasureSpec.getMode(i2)) {
            size2 = this.mCellHeight + getPaddingBottom() + getPaddingTop();
        } else {
            this.mCellHeight = (size2 - getPaddingBottom()) - getPaddingTop();
        }
        setMeasuredDimension(size, size2);
        if (!this.mAniming) {
            applyDrawRects(size, size2);
        }
    }

    private void applyDrawRects(int i, int i2) {
        this.mDrawRect = new Rect();
        this.mDrawRect.left = getPaddingLeft();
        this.mDrawRect.top = getPaddingTop();
        this.mDrawRect.right = i - getPaddingRight();
        this.mDrawRect.bottom = i2 - getPaddingBottom();
        this.mCellRects = new Rect[this.mQuantity];
        for (int i3 = 0; i3 < this.mQuantity; i3++) {
            Rect rect = new Rect();
            rect.left = this.mDrawRect.left + (this.mCellWidth * i3);
            rect.top = this.mDrawRect.top;
            rect.right = rect.left + this.mCellWidth;
            rect.bottom = this.mDrawRect.bottom;
            this.mCellRects[i3] = rect;
        }
        this.mCursorRect = new Rect(this.mCellRects[this.mCursorIndex]);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCells(canvas);
        drawCursor(canvas);
    }

    private void drawCells(Canvas canvas) {
        Drawable drawable;
        for (int i = 0; i < this.mQuantity; i++) {
            switch (this.mStates[i]) {
                case 0:
                    if (i != 0) {
                        if (this.mQuantity - 1 != i) {
                            drawable = this.mNormalWrong;
                            break;
                        } else {
                            drawable = this.mEndWrong;
                            break;
                        }
                    } else {
                        drawable = this.mStartWrong;
                        break;
                    }
                case 1:
                    if (i != 0) {
                        if (this.mQuantity - 1 != i) {
                            drawable = this.mNormalRight;
                            break;
                        } else {
                            drawable = this.mEndRight;
                            break;
                        }
                    } else {
                        drawable = this.mStartRight;
                        break;
                    }
                default:
                    if (i != 0) {
                        if (this.mQuantity - 1 != i) {
                            drawable = this.mNormalBackground;
                            Log.d("whiz", "draw cell, normal rect: " + this.mCellRects[i]);
                            break;
                        } else {
                            drawable = this.mEndBackground;
                            Log.d("whiz", "draw cell, end rect: " + this.mCellRects[i]);
                            break;
                        }
                    } else {
                        drawable = this.mStartBackground;
                        Log.d("whiz", "draw cell, start rect: " + this.mCellRects[i]);
                        break;
                    }
            }
            drawable.setBounds(this.mCellRects[i]);
            drawable.draw(canvas);
        }
    }

    private void drawCursor(Canvas canvas) {
        this.mCursor.setBounds(this.mCursorRect);
        this.mCursor.draw(canvas);
    }

    public void pushState(int i) {
        pushState(i, true);
    }

    public void pushState(int i, boolean z) {
        int i2;
        if (isValidState(i) && this.mCursorIndex < this.mQuantity) {
            if (this.mCursorIndex < this.mQuantity - 1 || this.mStates[this.mCursorIndex] == -1) {
                this.mStates[this.mCursorIndex] = i;
                if (z) {
                    int i3 = this.mCursorIndex + 1;
                    i2 = 1;
                    while (true) {
                        if (i3 < this.mQuantity) {
                            if (1 != this.mStates[i3]) {
                                this.mCursorIndex = i3;
                                break;
                            }
                            this.mCursorIndex = i3 + 1;
                            i2++;
                            i3++;
                        } else {
                            break;
                        }
                    }
                } else {
                    this.mCursorIndex++;
                    i2 = 1;
                }
                if (this.mCursorIndex >= this.mQuantity) {
                    postInvalidate();
                    return;
                }
                this.mAnimationController.setVelocity(i2);
                this.mAnimationController.stopAnimation();
                this.mAnimationController.startAnimation(this.mCursorRect.left, this.mCellRects[this.mCursorIndex].left);
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean isValidState(int i) {
        return i >= -1 && i <= 1;
    }

    public int getQuantity() {
        return this.mQuantity;
    }

    public int getState(int i) {
        if (i >= 0 && i < this.mQuantity) {
            return this.mStates[i];
        }
        throw new IndexOutOfBoundsException("Cursor index is: " + i + "; valid range is 0 to " + (this.mQuantity - 1));
    }

    public void setState(int i, int i2) {
        if (i < 0 || i >= this.mQuantity) {
            throw new IndexOutOfBoundsException("Index is: " + i + "; valid range is 0 to " + (this.mQuantity - 1));
        } else if (i2 != this.mStates[i] && isValidState(i2)) {
            this.mStates[i] = i2;
            postInvalidate();
        }
    }

    public void setCursor(int i) {
        if (i < 0 || i >= this.mQuantity) {
            throw new IndexOutOfBoundsException("Cursor index is: " + i + "; valid range is 0 to " + (this.mQuantity - 1));
        } else if (i != this.mCursorIndex) {
            this.mAnimationController.setVelocity(Math.abs(this.mCursorIndex - i));
            this.mCursorIndex = i;
            this.mAnimationController.stopAnimation();
            this.mAnimationController.startAnimation(this.mCursorRect.left, this.mCellRects[this.mCursorIndex].left);
        }
    }

    public int getCursor() {
        return this.mCursorIndex;
    }

    /* access modifiers changed from: private */
    public void moveCursor(int i) {
        this.mCursorRect.left += i;
        this.mCursorRect.right += i;
        postInvalidate();
    }

    /* access modifiers changed from: private */
    public void adjustCursor(boolean z) {
        if (this.mCursorIndex == 0) {
            this.mCursor = this.mStartCursor;
        } else if (this.mQuantity - 1 == this.mCursorIndex) {
            this.mCursor = this.mEndCursor;
        } else {
            this.mCursor = this.mNormalCursor;
        }
        if (z) {
            postInvalidate();
        }
    }
}
