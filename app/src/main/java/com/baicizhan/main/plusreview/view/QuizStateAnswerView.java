//package com.baicizhan.main.plusreview.view;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.graphics.Paint.FontMetricsInt;
//import android.graphics.RectF;
//import android.text.SpannableString;
//import android.text.TextUtils;
//import android.text.style.ReplacementSpan;
//import android.util.AttributeSet;
//import android.widget.TextView;
//import com.baicizhan.client.business.view.AnimationController;
//import com.baicizhan.client.business.view.AnimationController.OnAnimateListener;
//import com.jiongji.andriod.card.C1651b;
//import com.jiongji.andriod.card.R;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//public class QuizStateAnswerView extends TextView {
//    public static final int STATE_INVISIBLE = 0;
//    public static final int STATE_VISIBLE = 1;
//    /* access modifiers changed from: private */
//    public int[] mAlphas;
//    private AnimationController mAnimationController;
//    /* access modifiers changed from: private */
//    public char[] mAnswerArry;
//    /* access modifiers changed from: private */
//    public int mAnswerBGColor;
//    /* access modifiers changed from: private */
//    public int mAnswerBGRadius;
//    /* access modifiers changed from: private */
//    public int mAnswerEnd;
//    /* access modifiers changed from: private */
//    public int mAnswerFGColor;
//    /* access modifiers changed from: private */
//    public int mAnswerStart;
//    /* access modifiers changed from: private */
//    public int mCursor;
//    private List<Integer> mDrawingCursors;
//    /* access modifiers changed from: private */
//    public int mLineExtra;
//    private QSTAnimationListener mOnAnimateListener = new QSTAnimationListener();
//    /* access modifiers changed from: private */
//    public String mQuiz;
//    /* access modifiers changed from: private */
//    public int[] mStates;
//
//    class AnswerSpan extends ReplacementSpan {
//        AnswerSpan() {
//        }
//
//        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
//            int access$100 = QuizStateAnswerView.this.mAnswerBGRadius;
//            return (access$100 * 2) + (access$100 * 2) + Math.round(paint.measureText(charSequence.subSequence(i, i2).toString()));
//        }
//
//        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
//            int access$100 = QuizStateAnswerView.this.mAnswerBGRadius;
//            float f2 = f;
//            RectF rectF = new RectF(f2, (float) (i3 - access$100), paint.measureText(charSequence.subSequence(i, i2).toString()) + f + ((float) (access$100 * 4)), (float) (QuizStateAnswerView.this.mLineExtra + i4 + access$100));
//            paint.setColor(QuizStateAnswerView.this.mAnswerBGColor);
//            canvas.drawRoundRect(rectF, (float) QuizStateAnswerView.this.mAnswerBGRadius, (float) QuizStateAnswerView.this.mAnswerBGRadius, paint);
//            paint.setColor(QuizStateAnswerView.this.mAnswerFGColor);
//            float f3 = 0.0f;
//            int i6 = 0;
//            while (i6 < i2 - i) {
//                if (QuizStateAnswerView.this.mStates[i6] == 0) {
//                    paint.setAlpha(0);
//                } else {
//                    paint.setAlpha(QuizStateAnswerView.this.mAlphas[i6]);
//                }
//                if (i6 == 0) {
//                    canvas.drawText(charSequence, i, i + 1, f + ((float) (access$100 * 2)), (float) i4, paint);
//                } else {
//                    f3 += paint.measureText(charSequence.subSequence((i + i6) - 1, i + i6).toString());
//                    canvas.drawText(charSequence, i + i6, i + i6 + 1, ((float) (access$100 * 2)) + f + f3, (float) i4, paint);
//                }
//                i6++;
//                f3 = f3;
//            }
//        }
//    }
//
//    public class Initializer {
//        private int mAnswerEnd;
//        private int mAnswerStart;
//        private int mCursor;
//        private String mQuiz;
//        private int[] mStates;
//        private QuizStateAnswerView mTarget;
//
//        public Initializer wrap(QuizStateAnswerView quizStateAnswerView) {
//            this.mTarget = quizStateAnswerView;
//            return this;
//        }
//
//        public Initializer setQuiz(String str) {
//            this.mQuiz = str;
//            return this;
//        }
//
//        public Initializer setAnswerBorder(int i, int i2) {
//            this.mAnswerStart = i;
//            this.mAnswerEnd = i2;
//            return this;
//        }
//
//        public Initializer setStates(int[] iArr) {
//            this.mStates = iArr;
//            return this;
//        }
//
//        public Initializer setCursor(int i) {
//            this.mCursor = i;
//            return this;
//        }
//
//        public QuizStateAnswerView initialize() {
//            int i;
//            if (this.mTarget == null || TextUtils.isEmpty(this.mQuiz)) {
//                return null;
//            }
//            int length = this.mQuiz.length();
//            if (this.mAnswerStart < 0 || this.mAnswerStart >= length || this.mAnswerEnd < 0 || this.mAnswerEnd > length || this.mAnswerEnd - this.mAnswerStart <= 0) {
//                throw new IllegalArgumentException("initialize failed, " + formatInfo());
//            }
//            if (this.mStates == null) {
//                this.mStates = new int[(this.mAnswerEnd - this.mAnswerStart)];
//                if (1 == this.mStates.length) {
//                    this.mStates[0] = 0;
//                    this.mCursor = 0;
//                } else if (this.mStates.length <= 3) {
//                    this.mStates[0] = 1;
//                    for (int i2 = 1; i2 < this.mStates.length; i2++) {
//                        this.mStates[i2] = 0;
//                    }
//                    this.mCursor = 1;
//                } else {
//                    for (int i3 = 0; i3 < this.mStates.length; i3++) {
//                        if (i3 == 0 || this.mStates.length - 1 == i3) {
//                            this.mStates[i3] = 1;
//                        } else {
//                            this.mStates[i3] = 0;
//                        }
//                    }
//                    this.mCursor = 1;
//                }
//            }
//            if (this.mStates.length > length) {
//                throw new IllegalArgumentException("initialize failed, " + formatInfo());
//            } else if (this.mCursor < 0 || this.mCursor >= this.mAnswerEnd - this.mAnswerStart) {
//                throw new IllegalArgumentException("initialize failed, " + formatInfo());
//            } else {
//                this.mTarget.mQuiz = this.mQuiz;
//                this.mTarget.mAnswerStart = this.mAnswerStart;
//                this.mTarget.mAnswerEnd = this.mAnswerEnd;
//                this.mTarget.mAlphas = new int[length];
//                this.mTarget.mAnswerArry = this.mQuiz.substring(this.mAnswerStart, this.mAnswerEnd).toCharArray();
//                this.mTarget.mStates = this.mStates;
//                this.mTarget.mCursor = this.mCursor;
//                int i4 = 1;
//                while (i4 < this.mStates.length && !QuizStateAnswerView.isLetter(this.mTarget.mAnswerArry[i4])) {
//                    this.mStates[i4] = 1;
//                    this.mTarget.mCursor = this.mTarget.mCursor + 1;
//                    i4++;
//                }
//                for (int i5 = 0; i5 < this.mStates.length; i5++) {
//                    int[] access$600 = this.mTarget.mAlphas;
//                    if (1 == this.mStates[i5]) {
//                        i = 255;
//                    } else {
//                        i = 0;
//                    }
//                    access$600[i5] = i;
//                }
//                this.mTarget.refresh();
//                return this.mTarget;
//            }
//        }
//
//        public String formatInfo() {
//            int i = 0;
//            StringBuilder sb = new StringBuilder("QuizStateAnswerView info {");
//            StringBuilder append = sb.append("[quiz: ").append(this.mQuiz).append("]; [quiz length: ").append(this.mQuiz != null ? this.mQuiz.length() : 0).append("]; [answer border: [").append(this.mAnswerStart).append(", ").append(this.mAnswerEnd).append(")]; [states length: ");
//            if (this.mStates != null) {
//                i = this.mStates.length;
//            }
//            append.append(i).append("]; [cursor: ").append(this.mCursor).append("]}");
//            return sb.toString();
//        }
//    }
//
//    class QSTAnimationListener implements OnAnimateListener {
//        private QSTAnimationListener() {
//        }
//
//        public void onAnimationStart() {
//        }
//
//        public boolean continueAnimating() {
//            int access$700 = QuizStateAnswerView.this.mAnswerEnd - QuizStateAnswerView.this.mAnswerStart;
//            if (QuizStateAnswerView.this.mCursor >= 0) {
//                if (QuizStateAnswerView.this.mAlphas[Math.min(QuizStateAnswerView.this.mCursor - 1, access$700 - 1)] < 255) {
//                    return true;
//                }
//                return false;
//            }
//            for (int i = 0; i < access$700; i++) {
//                if (QuizStateAnswerView.this.mAlphas[i] < 255) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        public void onFrameUpdate(int i) {
//            QuizStateAnswerView.this.fadeInChar(i);
//        }
//
//        public void onAnimateComplete() {
//        }
//    }
//
//    public QuizStateAnswerView(Context context) {
//        super(context);
//        init(null, R.style.DefaultQuizStateAnswerView);
//    }
//
//    public QuizStateAnswerView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        init(attributeSet, R.style.DefaultQuizStateAnswerView);
//    }
//
//    public QuizStateAnswerView(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        init(attributeSet, R.style.DefaultQuizStateAnswerView);
//    }
//
//    private void init(AttributeSet attributeSet, int i) {
//        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1651b.QuizStateAnswerView, 0, i);
//        applyAttrs(obtainStyledAttributes);
//        obtainStyledAttributes.recycle();
//        this.mAnimationController = AnimationController.getDefault().init(this.mOnAnimateListener);
//        this.mAnimationController.setVelocity(15);
//    }
//
//    private void applyAttrs(TypedArray typedArray) {
//        this.mAnswerBGColor = typedArray.getColor(0, -16777216);
//        this.mAnswerFGColor = typedArray.getColor(1, -1);
//        this.mAnswerBGRadius = typedArray.getDimensionPixelSize(2, 0);
//        this.mLineExtra = this.mAnswerBGRadius * 2;
//        setLineSpacing((float) this.mLineExtra, 1.0f);
//        setGravity(16);
//        setPadding(0, this.mLineExtra, 0, this.mLineExtra);
//    }
//
//    public boolean fillAnswer(String str) {
//        if (TextUtils.isEmpty(this.mQuiz) || str == null || str.length() != 1) {
//            return false;
//        }
//        char c = this.mAnswerArry[this.mCursor];
//        if (str.toLowerCase(Locale.US).charAt(0) != c && str.toUpperCase(Locale.US).charAt(0) != c) {
//            return false;
//        }
//        this.mDrawingCursors = new ArrayList();
//        this.mDrawingCursors.add(Integer.valueOf(this.mCursor));
//        this.mCursor++;
//        for (int i = 0; i < this.mCursor - 1; i++) {
//            this.mAlphas[i] = 255;
//        }
//        this.mStates[this.mCursor - 1] = 1;
//        int i2 = this.mCursor;
//        while (i2 < this.mAnswerArry.length && !isLetter(this.mAnswerArry[i2])) {
//            this.mCursor++;
//            this.mDrawingCursors.add(Integer.valueOf(i2));
//            this.mStates[i2] = 1;
//            i2++;
//        }
//        this.mAnimationController.stopAnimation();
//        this.mAnimationController.startAnimation(0, 255);
//        return true;
//    }
//
//    /* access modifiers changed from: private */
//    public static boolean isLetter(char c) {
//        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
//    }
//
//    public void fillAll() {
//        if (!TextUtils.isEmpty(this.mQuiz)) {
//            this.mCursor = -1;
//            int i = this.mAnswerEnd - this.mAnswerStart;
//            for (int i2 = 0; i2 < i; i2++) {
//                this.mStates[i2] = 1;
//            }
//            this.mAnimationController.stopAnimation();
//            this.mAnimationController.startAnimation(0, 255);
//        }
//    }
//
//    public String getAnswer() {
//        if (TextUtils.isEmpty(this.mQuiz)) {
//            return null;
//        }
//        return String.valueOf(this.mAnswerArry[this.mCursor]);
//    }
//
//    public String getAnswer(int i) {
//        if (TextUtils.isEmpty(this.mQuiz)) {
//            return null;
//        }
//        int i2 = this.mAnswerEnd - this.mAnswerStart;
//        if (i >= 0 && i < i2) {
//            return String.valueOf(this.mAnswerArry[i]);
//        }
//        throw new IndexOutOfBoundsException("Answer's cursor is out of range, " + i + " is not from 0 to " + (i2 - 1));
//    }
//
//    public String getAnswers() {
//        if (TextUtils.isEmpty(this.mQuiz)) {
//            return null;
//        }
//        return this.mQuiz.substring(this.mAnswerStart, this.mAnswerEnd);
//    }
//
//    public boolean allAnswered() {
//        if (TextUtils.isEmpty(this.mQuiz)) {
//            return false;
//        }
//        for (int i : this.mStates) {
//            if (i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void setStates(int[] iArr) {
//        int i;
//        if (iArr != null && !TextUtils.isEmpty(this.mQuiz)) {
//            if (this.mStates == null || iArr.length == this.mStates.length) {
//                for (int isValidState : iArr) {
//                    if (!isValidState(isValidState)) {
//                        throw new IllegalArgumentException("Set states failed for states' value is not valid.");
//                    }
//                }
//                this.mStates = iArr;
//                for (int i2 = 0; i2 < this.mStates.length; i2++) {
//                    int[] iArr2 = this.mAlphas;
//                    if (1 == this.mStates[i2]) {
//                        i = 255;
//                    } else {
//                        i = 0;
//                    }
//                    iArr2[i2] = i;
//                }
//                refresh();
//                return;
//            }
//            throw new IllegalArgumentException("Set states failed for states' length is not equal the required value: " + this.mStates.length);
//        }
//    }
//
//    public void setState(int i, int i2) {
//        if (!TextUtils.isEmpty(this.mQuiz)) {
//            int i3 = this.mAnswerEnd - this.mAnswerStart;
//            if (i < 0 || i >= i3) {
//                throw new IndexOutOfBoundsException("Answer's cursor is out of range, " + i + " is not from 0 to " + (i3 - 1));
//            } else if (!isValidState(i2)) {
//                throw new IllegalArgumentException("Set states failed for states' value is not valid.");
//            } else if (this.mStates[i] != i2) {
//                this.mStates[i] = i2;
//                if (1 == i2) {
//                    this.mAlphas[i] = 255;
//                }
//                refresh();
//            }
//        }
//    }
//
//    public int getUnAnsweredCount() {
//        int i = 0;
//        if (this.mStates != null) {
//            for (int i2 : this.mStates) {
//                if (i2 == 0) {
//                    i++;
//                }
//            }
//        }
//        return i;
//    }
//
//    /* access modifiers changed from: private */
//    public void refresh() {
//        if (!TextUtils.isEmpty(this.mQuiz)) {
//            SpannableString spannableString = new SpannableString(this.mQuiz);
//            spannableString.setSpan(new AnswerSpan(), this.mAnswerStart, this.mAnswerEnd, 33);
//            setText(spannableString);
//        }
//    }
//
//    private static boolean isValidState(int i) {
//        return i >= 0 && i <= 1;
//    }
//
//    /* access modifiers changed from: private */
//    public void fadeInChar(int i) {
//        if (this.mCursor < 0) {
//            int i2 = this.mAnswerEnd - this.mAnswerStart;
//            for (int i3 = 0; i3 < i2; i3++) {
//                if (this.mAlphas[i3] < 255) {
//                    int i4 = this.mAlphas[i3] + i;
//                    int[] iArr = this.mAlphas;
//                    if (i4 > 255) {
//                        i4 = 255;
//                    }
//                    iArr[i3] = i4;
//                }
//            }
//        } else if (this.mDrawingCursors != null) {
//            for (Integer intValue : this.mDrawingCursors) {
//                int intValue2 = intValue.intValue();
//                int i5 = this.mAlphas[intValue2] + i;
//                int[] iArr2 = this.mAlphas;
//                if (i5 > 255) {
//                    i5 = 255;
//                }
//                iArr2[intValue2] = i5;
//            }
//        }
//        refresh();
//    }
//
//    public String formatInfo() {
//        int i = 0;
//        StringBuilder sb = new StringBuilder("QuizStateAnswerView info {");
//        StringBuilder append = sb.append("[quiz: ").append(this.mQuiz).append("]; [quiz length: ").append(this.mQuiz != null ? this.mQuiz.length() : 0).append("]; [answer border: [").append(this.mAnswerStart).append(", ").append(this.mAnswerEnd).append(")]; [states length: ").append(this.mStates != null ? this.mStates.length : 0).append("]; [cursor: ").append(this.mCursor).append("]}[alphas length: ");
//        if (this.mAlphas != null) {
//            i = this.mAlphas.length;
//        }
//        append.append(i).append("]}");
//        return sb.toString();
//    }
//}
