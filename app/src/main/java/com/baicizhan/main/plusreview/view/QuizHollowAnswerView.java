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
//public class QuizHollowAnswerView extends TextView {
//    public static final int STATE_INVISIBLE = 0;
//    public static final int STATE_VISIBLE = 1;
//    /* access modifiers changed from: private */
//    public List<int[]> mAlphas;
//    private AnimationController mAnimationController;
//    /* access modifiers changed from: private */
//    public List<char[]> mAnswerArry;
//    /* access modifiers changed from: private */
//    public int mAnswerBGColor;
//    /* access modifiers changed from: private */
//    public int mAnswerBGRadius;
//    /* access modifiers changed from: private */
//    public int[] mAnswerEnds;
//    /* access modifiers changed from: private */
//    public int mAnswerFGColor;
//    /* access modifiers changed from: private */
//    public int[] mAnswerStarts;
//    /* access modifiers changed from: private */
//    public int[] mCursors;
//    /* access modifiers changed from: private */
//    public List<List<Integer>> mDrawingCursors;
//    /* access modifiers changed from: private */
//    public int mLineExtra;
//    private QSTAnimationListener mOnAnimateListener = new QSTAnimationListener();
//    /* access modifiers changed from: private */
//    public int mOutCursor;
//    /* access modifiers changed from: private */
//    public String mQuiz;
//    /* access modifiers changed from: private */
//    public List<int[]> mStates;
//
//    class AnswerSpan extends ReplacementSpan {
//        private final int outCursor;
//
//        AnswerSpan(int i) {
//            this.outCursor = i;
//        }
//
//        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
//            int access$100 = QuizHollowAnswerView.this.mAnswerBGRadius;
//            return (access$100 * 2) + (access$100 * 2) + Math.round(paint.measureText(charSequence.subSequence(i, i2).toString()));
//        }
//
//        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
//            int access$100 = QuizHollowAnswerView.this.mAnswerBGRadius;
//            float f2 = f;
//            RectF rectF = new RectF(f2, (float) (i3 - access$100), paint.measureText(charSequence.subSequence(i, i2).toString()) + f + ((float) (access$100 * 4)), (float) (QuizHollowAnswerView.this.mLineExtra + i4 + access$100));
//            paint.setColor(QuizHollowAnswerView.this.mAnswerBGColor);
//            canvas.drawRoundRect(rectF, (float) QuizHollowAnswerView.this.mAnswerBGRadius, (float) QuizHollowAnswerView.this.mAnswerBGRadius, paint);
//            paint.setColor(QuizHollowAnswerView.this.mAnswerFGColor);
//            float f3 = 0.0f;
//            int i6 = 0;
//            while (i6 < i2 - i) {
//                if (((int[]) QuizHollowAnswerView.this.mStates.get(this.outCursor))[i6] == 0) {
//                    paint.setAlpha(0);
//                } else {
//                    paint.setAlpha(((int[]) QuizHollowAnswerView.this.mAlphas.get(this.outCursor))[i6]);
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
//        private List<int[]> mAlphas;
//        private List<char[]> mAnswerArry;
//        private int[] mAnswerEnds;
//        private int[] mAnswerStarts;
//        private int[] mCursors;
//        private List<List<Integer>> mDrawingCursors;
//        private String mQuiz;
//        private List<int[]> mStates;
//        private QuizHollowAnswerView mTarget;
//
//        public Initializer wrap(QuizHollowAnswerView quizHollowAnswerView) {
//            this.mTarget = quizHollowAnswerView;
//            return this;
//        }
//
//        public Initializer setQuiz(String str) {
//            this.mQuiz = str;
//            return this;
//        }
//
//        public Initializer setAnswerBorders(int[] iArr, int[] iArr2) {
//            this.mAnswerStarts = iArr;
//            this.mAnswerEnds = iArr2;
//            return this;
//        }
//
//        public QuizHollowAnswerView initialize() {
//            int i;
//            int i2;
//            int i3;
//            int i4;
//            int i5;
//            int[] iArr;
//            int[] iArr2;
//            int i6;
//            int i7;
//            int i8;
//            int i9;
//            int i10;
//            int i11;
//            int i12;
//            if (this.mTarget == null || TextUtils.isEmpty(this.mQuiz) || this.mAnswerStarts == null || this.mAnswerEnds == null) {
//                return null;
//            }
//            int length = this.mQuiz.length();
//            if (this.mAnswerStarts.length != this.mAnswerEnds.length || this.mAnswerStarts.length <= 0 || this.mAnswerStarts.length > length || this.mAnswerEnds.length > length) {
//                throw new IllegalArgumentException("initialize failed, " + formatInfo());
//            }
//            this.mAnswerArry = new ArrayList(this.mAnswerStarts.length);
//            this.mStates = new ArrayList(this.mAnswerStarts.length);
//            this.mAlphas = new ArrayList(this.mAnswerStarts.length);
//            this.mCursors = new int[this.mAnswerStarts.length];
//            this.mDrawingCursors = new ArrayList(this.mAnswerStarts.length);
//            for (int i13 = 0; i13 < this.mAnswerStarts.length; i13++) {
//                int i14 = this.mAnswerStarts[i13];
//                int i15 = this.mAnswerEnds[i13];
//                if (i14 < 0 || i14 >= length || i15 < 0 || i15 > length || i15 - i14 <= 0) {
//                    throw new IllegalArgumentException("initialize failed, " + formatInfo());
//                }
//                char[] charArray = this.mQuiz.substring(i14, i15).toCharArray();
//                this.mAnswerArry.add(charArray);
//                int[] iArr3 = new int[(i15 - i14)];
//                int[] iArr4 = new int[(i15 - i14)];
//                if (1 != this.mAnswerStarts.length) {
//                    if (i13 == 0) {
//                        i = 1;
//                    } else {
//                        i = 0;
//                    }
//                    i2 = i;
//                    for (int i16 = 0; i16 < iArr3.length; i16++) {
//                        if (i13 == 0 && i16 == 0) {
//                            iArr3[0] = 1;
//                            i4 = 255;
//                            i5 = 0;
//                            iArr = iArr4;
//                        } else if (this.mAnswerStarts.length - 1 == i13 && iArr3.length - 1 == i16) {
//                            iArr3[iArr3.length - 1] = 1;
//                            i5 = iArr3.length - 1;
//                            iArr = iArr4;
//                            i4 = 255;
//                        } else {
//                            if (QuizHollowAnswerView.isLetter(charArray[i16])) {
//                                i3 = 0;
//                            } else {
//                                i3 = 1;
//                            }
//                            iArr3[i16] = i3;
//                            if (1 == iArr3[i16]) {
//                                i4 = 255;
//                                i5 = i16;
//                                iArr = iArr4;
//                            } else {
//                                i4 = 0;
//                                i5 = i16;
//                                iArr = iArr4;
//                            }
//                        }
//                        iArr[i5] = i4;
//                        if (i16 == i2 && 1 == iArr3[i16]) {
//                            i2++;
//                        }
//                    }
//                } else if (1 == iArr3.length) {
//                    iArr3[0] = QuizHollowAnswerView.isLetter(charArray[0]) ? 0 : 1;
//                    if (1 == iArr3[0]) {
//                        i11 = 255;
//                    } else {
//                        i11 = 0;
//                    }
//                    iArr4[0] = i11;
//                    if (1 == iArr3[0]) {
//                        i12 = 1;
//                    } else {
//                        i12 = 0;
//                    }
//                    i2 = i12;
//                } else if (iArr3.length <= 3) {
//                    iArr3[0] = 1;
//                    iArr4[0] = 255;
//                    i2 = 1;
//                    for (int i17 = 1; i17 < iArr3.length; i17++) {
//                        if (QuizHollowAnswerView.isLetter(charArray[i17])) {
//                            i9 = 0;
//                        } else {
//                            i9 = 1;
//                        }
//                        iArr3[i17] = i9;
//                        if (1 == iArr3[i17]) {
//                            i10 = 255;
//                        } else {
//                            i10 = 0;
//                        }
//                        iArr4[i17] = i10;
//                        if (i17 == i2 && 1 == iArr3[i17]) {
//                            i2++;
//                        }
//                    }
//                } else {
//                    i2 = 0;
//                    for (int i18 = 0; i18 < iArr3.length; i18++) {
//                        if (i18 == 0 || iArr3.length - 1 == i18) {
//                            iArr3[i18] = 1;
//                            i7 = 255;
//                            i6 = i18;
//                            iArr2 = iArr4;
//                        } else {
//                            if (QuizHollowAnswerView.isLetter(charArray[i18])) {
//                                i8 = 0;
//                            } else {
//                                i8 = 1;
//                            }
//                            iArr3[i18] = i8;
//                            if (1 == iArr3[i18]) {
//                                i7 = 255;
//                                i6 = i18;
//                                iArr2 = iArr4;
//                            } else {
//                                i7 = 0;
//                                i6 = i18;
//                                iArr2 = iArr4;
//                            }
//                        }
//                        iArr2[i6] = i7;
//                        if (i18 == 1 && 1 == iArr3[i18]) {
//                            i2 = 2;
//                        } else {
//                            i2 = 1;
//                        }
//                    }
//                }
//                this.mStates.add(iArr3);
//                this.mAlphas.add(iArr4);
//                this.mCursors[i13] = i2;
//                this.mDrawingCursors.add(null);
//            }
//            this.mTarget.mQuiz = this.mQuiz;
//            this.mTarget.mAnswerStarts = this.mAnswerStarts;
//            this.mTarget.mAnswerEnds = this.mAnswerEnds;
//            this.mTarget.mAlphas = this.mAlphas;
//            this.mTarget.mAnswerArry = this.mAnswerArry;
//            this.mTarget.mStates = this.mStates;
//            this.mTarget.mCursors = this.mCursors;
//            this.mTarget.initOutCursor();
//            this.mTarget.mDrawingCursors = this.mDrawingCursors;
//            this.mTarget.refresh();
//            return this.mTarget;
//        }
//
//        public String formatInfo() {
//            int i = 0;
//            StringBuilder sb = new StringBuilder("QuizHollowAnswerView info {");
//            StringBuilder append = sb.append("[quiz: ").append(this.mQuiz).append("]; [quiz length: ").append(this.mQuiz != null ? this.mQuiz.length() : 0).append("]; [answer borders: [").append(this.mAnswerStarts).append(", ").append(this.mAnswerEnds).append(")]; [states length: ");
//            if (this.mStates != null) {
//                i = this.mStates.size();
//            }
//            append.append(i).append("]; [cursors: ").append(this.mCursors).append("]}");
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
//            if (QuizHollowAnswerView.this.mOutCursor < 0) {
//                for (int i = 0; i < QuizHollowAnswerView.this.mAnswerStarts.length; i++) {
//                    int i2 = QuizHollowAnswerView.this.mAnswerEnds[i] - QuizHollowAnswerView.this.mAnswerStarts[i];
//                    for (int i3 = 0; i3 < i2; i3++) {
//                        if (((int[]) QuizHollowAnswerView.this.mAlphas.get(i))[i3] < 255) {
//                            return true;
//                        }
//                    }
//                }
//                return false;
//            }
//            int i4 = QuizHollowAnswerView.this.mAnswerEnds[QuizHollowAnswerView.this.mOutCursor] - QuizHollowAnswerView.this.mAnswerStarts[QuizHollowAnswerView.this.mOutCursor];
//            if (QuizHollowAnswerView.this.mCursors[QuizHollowAnswerView.this.mOutCursor] >= 0) {
//                if (((int[]) QuizHollowAnswerView.this.mAlphas.get(QuizHollowAnswerView.this.mOutCursor))[Math.min(QuizHollowAnswerView.this.mCursors[QuizHollowAnswerView.this.mOutCursor] - 1, i4 - 1)] < 255) {
//                    return true;
//                }
//                return false;
//            }
//            for (int i5 = 0; i5 < i4; i5++) {
//                if (((int[]) QuizHollowAnswerView.this.mAlphas.get(QuizHollowAnswerView.this.mOutCursor))[i5] < 255) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        public void onFrameUpdate(int i) {
//            QuizHollowAnswerView.this.fadeInChar(i);
//        }
//
//        public void onAnimateComplete() {
//        }
//    }
//
//    public QuizHollowAnswerView(Context context) {
//        super(context);
//        init(null, R.style.DefaultQuizStateAnswerView);
//    }
//
//    public QuizHollowAnswerView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        init(attributeSet, R.style.DefaultQuizStateAnswerView);
//    }
//
//    public QuizHollowAnswerView(Context context, AttributeSet attributeSet, int i) {
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
//        updateOutCursor();
//        if (this.mOutCursor >= this.mAnswerStarts.length) {
//            return false;
//        }
//        char c = ((char[]) this.mAnswerArry.get(this.mOutCursor))[this.mCursors[this.mOutCursor]];
//        if (str.toLowerCase(Locale.US).charAt(0) != c && str.toUpperCase(Locale.US).charAt(0) != c) {
//            return false;
//        }
//        ArrayList arrayList = new ArrayList();
//        arrayList.add(Integer.valueOf(this.mCursors[this.mOutCursor]));
//        int[] iArr = this.mCursors;
//        int i = this.mOutCursor;
//        iArr[i] = iArr[i] + 1;
//        for (int i2 = 0; i2 < this.mCursors[this.mOutCursor] - 1; i2++) {
//            ((int[]) this.mAlphas.get(this.mOutCursor))[i2] = 255;
//        }
//        ((int[]) this.mStates.get(this.mOutCursor))[this.mCursors[this.mOutCursor] - 1] = 1;
//        int i3 = this.mCursors[this.mOutCursor];
//        while (true) {
//            int i4 = i3;
//            if (i4 >= ((char[]) this.mAnswerArry.get(this.mOutCursor)).length || isLetter(((char[]) this.mAnswerArry.get(this.mOutCursor))[i4])) {
//                this.mDrawingCursors.set(this.mOutCursor, arrayList);
//                this.mAnimationController.stopAnimation();
//                this.mAnimationController.startAnimation(0, 255);
//            } else {
//                int[] iArr2 = this.mCursors;
//                int i5 = this.mOutCursor;
//                iArr2[i5] = iArr2[i5] + 1;
//                arrayList.add(Integer.valueOf(i4));
//                ((int[]) this.mStates.get(this.mOutCursor))[i4] = 1;
//                i3 = i4 + 1;
//            }
//        }
//        this.mDrawingCursors.set(this.mOutCursor, arrayList);
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
//            this.mOutCursor = -1;
//            for (int i = 0; i < this.mAnswerStarts.length; i++) {
//                this.mCursors[i] = -1;
//                int i2 = this.mAnswerEnds[i] - this.mAnswerStarts[i];
//                for (int i3 = 0; i3 < i2; i3++) {
//                    ((int[]) this.mStates.get(i))[i3] = 1;
//                }
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
//        return String.valueOf(((char[]) this.mAnswerArry.get(this.mOutCursor))[this.mCursors[this.mOutCursor]]);
//    }
//
//    public String getAnswer(int i, int i2) {
//        if (TextUtils.isEmpty(this.mQuiz)) {
//            return null;
//        }
//        if (i < 0 || i >= this.mAnswerStarts.length) {
//            throw new IndexOutOfBoundsException("Answer's out cursor is out of range, " + i + " is not from 0 to " + (this.mAnswerStarts.length - 1));
//        }
//        int i3 = this.mAnswerEnds[i] - this.mAnswerStarts[i];
//        if (i2 >= 0 && i2 < i3) {
//            return String.valueOf(((char[]) this.mAnswerArry.get(i))[i2]);
//        }
//        throw new IndexOutOfBoundsException("Answer's cursor is out of range, " + i2 + " is not from 0 to " + (i3 - 1));
//    }
//
//    public String getAnswers() {
//        if (TextUtils.isEmpty(this.mQuiz)) {
//            return null;
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < this.mAnswerStarts.length; i++) {
//            sb.append(this.mQuiz.substring(this.mAnswerStarts[i], this.mAnswerEnds[i]));
//            if (this.mAnswerStarts.length > 0 && i != this.mAnswerStarts.length - 1) {
//                sb.append(" ");
//            }
//        }
//        return sb.toString();
//    }
//
//    public boolean allAnswered() {
//        if (TextUtils.isEmpty(this.mQuiz)) {
//            return false;
//        }
//        for (int[] iArr : this.mStates) {
//            int length = iArr.length;
//            int i = 0;
//            while (true) {
//                if (i < length) {
//                    if (iArr[i] == 0) {
//                        return false;
//                    }
//                    i++;
//                }
//            }
//        }
//        return true;
//    }
//
//    public void setState(int i, int i2, int i3) {
//        if (!TextUtils.isEmpty(this.mQuiz)) {
//            if (i < 0 || i >= this.mAnswerStarts.length) {
//                throw new IndexOutOfBoundsException("Answer's out cursor is out of range, " + i + " is not from 0 to " + (this.mAnswerStarts.length - 1));
//            }
//            int i4 = this.mAnswerEnds[i] - this.mAnswerStarts[i];
//            if (i2 < 0 || i2 >= i4) {
//                throw new IndexOutOfBoundsException("Answer's cursor is out of range, " + i2 + " is not from 0 to " + (i4 - 1));
//            } else if (!isValidState(i3)) {
//                throw new IllegalArgumentException("Set states failed for states' value is not valid.");
//            } else if (((int[]) this.mStates.get(i))[i2] != i3) {
//                ((int[]) this.mStates.get(i))[i2] = i3;
//                if (1 == i3) {
//                    ((int[]) this.mAlphas.get(i))[i2] = 255;
//                }
//                refresh();
//            }
//        }
//    }
//
//    public int getUnAnsweredCount() {
//        if (this.mStates == null) {
//            return 0;
//        }
//        int i = 0;
//        for (int[] iArr : this.mStates) {
//            for (int i2 : (int[]) r4.next()) {
//                if (i2 == 0) {
//                    i++;
//                }
//            }
//        }
//        return i;
//    }
//
//    /* access modifiers changed from: private */
//    public void initOutCursor() {
//        boolean z;
//        this.mOutCursor = 0;
//        for (int[] iArr : this.mStates) {
//            int length = iArr.length;
//            int i = 0;
//            while (true) {
//                if (i >= length) {
//                    z = true;
//                    break;
//                } else if (iArr[i] != 1) {
//                    z = false;
//                    break;
//                } else {
//                    i++;
//                }
//            }
//            if (z) {
//                this.mOutCursor++;
//            } else {
//                return;
//            }
//        }
//    }
//
//    private void updateOutCursor() {
//        if (this.mOutCursor < this.mStates.size()) {
//            int[] iArr = (int[]) this.mStates.get(this.mOutCursor);
//            int length = iArr.length;
//            int i = 0;
//            while (i < length) {
//                if (iArr[i] == 1) {
//                    i++;
//                } else {
//                    return;
//                }
//            }
//            this.mOutCursor++;
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public void refresh() {
//        if (!TextUtils.isEmpty(this.mQuiz)) {
//            SpannableString spannableString = new SpannableString(this.mQuiz);
//            for (int i = 0; i < this.mAnswerStarts.length; i++) {
//                spannableString.setSpan(new AnswerSpan(i), this.mAnswerStarts[i], this.mAnswerEnds[i], 33);
//            }
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
//        if (this.mOutCursor < 0) {
//            for (int i2 = 0; i2 < this.mAnswerStarts.length; i2++) {
//                int i3 = this.mAnswerEnds[i2] - this.mAnswerStarts[i2];
//                for (int i4 = 0; i4 < i3; i4++) {
//                    if (((int[]) this.mAlphas.get(i2))[i4] < 255) {
//                        int i5 = ((int[]) this.mAlphas.get(i2))[i4] + i;
//                        int[] iArr = (int[]) this.mAlphas.get(i2);
//                        if (i5 > 255) {
//                            i5 = 255;
//                        }
//                        iArr[i4] = i5;
//                    }
//                }
//            }
//        } else if (this.mCursors[this.mOutCursor] < 0) {
//            int i6 = this.mAnswerEnds[this.mOutCursor] - this.mAnswerStarts[this.mOutCursor];
//            for (int i7 = 0; i7 < i6; i7++) {
//                if (((int[]) this.mAlphas.get(this.mOutCursor))[i7] < 255) {
//                    int i8 = ((int[]) this.mAlphas.get(this.mOutCursor))[i7] + i;
//                    int[] iArr2 = (int[]) this.mAlphas.get(this.mOutCursor);
//                    if (i8 > 255) {
//                        i8 = 255;
//                    }
//                    iArr2[i7] = i8;
//                }
//            }
//        } else if (this.mDrawingCursors.get(this.mOutCursor) != null) {
//            for (Integer intValue : (List) this.mDrawingCursors.get(this.mOutCursor)) {
//                int intValue2 = intValue.intValue();
//                int i9 = ((int[]) this.mAlphas.get(this.mOutCursor))[intValue2] + i;
//                int[] iArr3 = (int[]) this.mAlphas.get(this.mOutCursor);
//                if (i9 > 255) {
//                    i9 = 255;
//                }
//                iArr3[intValue2] = i9;
//            }
//        }
//        refresh();
//    }
//}
