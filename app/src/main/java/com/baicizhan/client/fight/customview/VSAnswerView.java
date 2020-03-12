//package com.baicizhan.client.fight.customview;
//
//import android.content.Context;
//import android.graphics.drawable.AnimationDrawable;
//import android.text.TextPaint;
//import android.util.AttributeSet;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.LinearLayout.LayoutParams;
//import android.widget.TextView;
////import com.baicizhan.client.fight.R;
//import com.baicizhan.client.fight.jsonbean.Problem;
//import com.baicizhan.client.fight.jsonbean.Problem.Option;
//import com.baicizhan.client.framework.audio.AudioPlayer.OnPlaySateListener;
//import com.baicizhan.client.framework.audio.AudioPlayer.State;
//import com.jiongji.andriod.card.R;
//import com.p055f.p056a.C1578av;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.Picasso;
//import com.p055f.p056a.RequestCreator;
//
//public class VSAnswerView extends FrameLayout implements OnPlaySateListener {
//    private static final int IMG_HEIGHT_RATIO = 5;
//    private static final int IMG_WIDTH_RATIO = 6;
//    public static final int INVALID_SELECTION = -1;
//    private static final int OPTION_NUM = 4;
//    private static final int SHOW_ANSWER_TIME = 600;
//    public static final String TAG = "VSAnswerView";
//    OnAnswerListener mAnswerListener;
//    int mCurrentProblemAnswer;
//    int mCurrentProblemType;
//    int mImageHeight;
//    int mImageWidth;
//    View[] mImgFrameOpts;
//    View[] mImgMaskOpts;
//    ImageView[] mImgOpts;
//    View mImgOptsView;
//    TextView mImgWord;
//    int mMeanInHeight;
//    int mMeanInWidth;
//    AutoResizeTextView[] mMeanOpts;
//    View mMeanOptsView;
//    TextPaint mMeanPaint;
//    float mMeanTextSize;
//    TextView mMeanWord;
//    ImageView mVoiceWord;
//
//    public interface OnAnswerListener {
//        void onAnswer(int i);
//
//        void onFinish();
//    }
//
//    public VSAnswerView(Context context) {
//        super(context);
//    }
//
//    public VSAnswerView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//    }
//
//    public void onFinishInflate() {
//        super.onFinishInflate();
//        this.mImgOptsView = findViewById(R.id.img_opts);
//        this.mImgOpts = new ImageView[]{(ImageView) this.mImgOptsView.findViewById(R.id.img_00), (ImageView) this.mImgOptsView.findViewById(R.id.img_01), (ImageView) this.mImgOptsView.findViewById(R.id.img_10), (ImageView) this.mImgOptsView.findViewById(R.id.img_11)};
//        this.mImgWord = (TextView) this.mImgOptsView.findViewById(R.id.img_word);
//        this.mImgFrameOpts = new View[]{this.mImgOptsView.findViewById(R.id.frame_00), this.mImgOptsView.findViewById(R.id.frame_01), this.mImgOptsView.findViewById(R.id.frame_10), this.mImgOptsView.findViewById(R.id.frame_11)};
//        this.mImgMaskOpts = new View[]{this.mImgOptsView.findViewById(R.id.img_frame_00), this.mImgOptsView.findViewById(R.id.img_frame_01), this.mImgOptsView.findViewById(R.id.img_frame_10), this.mImgOptsView.findViewById(R.id.img_frame_11)};
//        this.mMeanOptsView = findViewById(R.id.mean_opts);
//        AutoResizeTextView autoResizeTextView = (AutoResizeTextView) this.mMeanOptsView.findViewById(R.id.mean_00);
//        this.mMeanOpts = new AutoResizeTextView[]{autoResizeTextView, (AutoResizeTextView) this.mMeanOptsView.findViewById(R.id.mean_01), (AutoResizeTextView) this.mMeanOptsView.findViewById(R.id.mean_10), (AutoResizeTextView) this.mMeanOptsView.findViewById(R.id.mean_11)};
//        this.mMeanWord = (TextView) findViewById(R.id.mean_word);
//        int dimension = (int) getContext().getResources().getDimension(R.dimen.fight_answer_mean_min_textsize);
//        int dimension2 = (int) getContext().getResources().getDimension(R.dimen.fight_answer_mean_max_textsize);
//        for (int i = 0; i < this.mMeanOpts.length; i++) {
//            Integer valueOf = Integer.valueOf(i);
//            this.mImgOpts[i].setTag(valueOf);
//            this.mMeanOpts[i].setScanSpan(dimension, dimension2);
//            this.mMeanOpts[i].setTag(valueOf);
//        }
//        this.mMeanPaint = autoResizeTextView.getPaint();
//        this.mMeanTextSize = autoResizeTextView.getTextSize();
//    }
//
//    public void onMeasure(int i, int i2) {
//        super.onMeasure(i, i2);
//        int measuredWidth = this.mImgFrameOpts[0].getMeasuredWidth();
//        int min = Math.min((measuredWidth * 5) / 6, this.mImgOptsView.getMeasuredHeight() / 2);
//        reSizeImg(this.mImgFrameOpts[0], min);
//        reSizeImg(this.mImgFrameOpts[1], min);
//        reSizeImg(this.mImgFrameOpts[2], min);
//        reSizeImg(this.mImgFrameOpts[3], min);
//        this.mImageWidth = measuredWidth;
//        this.mImageHeight = min;
//        int measuredWidth2 = this.mMeanOpts[0].getMeasuredWidth();
//        int measuredHeight = this.mMeanOpts[0].getMeasuredHeight();
//        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.fight_mean_probs_in_margin);
//        this.mMeanInHeight = measuredHeight - (dimensionPixelSize * 2);
//        this.mMeanInWidth = measuredWidth2 - (dimensionPixelSize * 2);
//    }
//
//    private void reSizeImg(View view, int i) {
//        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
//        if (layoutParams.height != i && layoutParams.height != 0) {
//            layoutParams.height = i;
//            view.setLayoutParams(layoutParams);
//        }
//    }
//
//    public void onPlayStateChanged(State state) {
//        switch (state) {
//            case Preparing:
//            case Playing:
//                animVoice();
//                return;
//            case Paused:
//            case Stopped:
//                slienceVoice();
//                return;
//            default:
//                return;
//        }
//    }
//
//    private void animVoice() {
//        AnimationDrawable animationDrawable = (AnimationDrawable) this.mVoiceWord.getDrawable();
//        if (animationDrawable != null) {
//            animationDrawable.start();
//        }
//    }
//
//    private void slienceVoice() {
//        AnimationDrawable animationDrawable = (AnimationDrawable) this.mVoiceWord.getDrawable();
//        animationDrawable.selectDrawable(0);
//        animationDrawable.stop();
//    }
//
//    public void updateProblem(Problem problem, OnAnswerListener onAnswerListener) {
//        this.mAnswerListener = onAnswerListener;
//        this.mCurrentProblemType = problem.getType();
//        this.mCurrentProblemAnswer = problem.getAnswer();
////        C07431 r3 = new OnClickListener() {
////            public void onClick(View view) {
////                int intValue = ((Integer) view.getTag()).intValue();
////                if (intValue == VSAnswerView.this.mCurrentProblemAnswer) {
////                    VSAnswerView.this.mAnswerListener.onAnswer(0);
////                } else {
////                    VSAnswerView.this.mAnswerListener.onAnswer(-1);
////                }
////                VSAnswerView.this.showAnswer(intValue);
////            }
////        };
//        if (this.mCurrentProblemType == 1) {
//            this.mImgOptsView.setVisibility(0);
//            this.mMeanOptsView.setVisibility(8);
//            this.mImgWord.setText(problem.getTitle());
//            for (int i = 0; i < this.mImgOpts.length; i++) {
//                ImageView imageView = this.mImgOpts[i];
//                RequestCreator a = Picasso.with(getContext()).load("file://" + ((Option) problem.getOptions().get(i)).getImageUrl());
//                C1578av avVar = a.f3706b;
//                if (avVar.f3696g) {
//                    throw new IllegalStateException("Center crop can not be used after calling centerInside");
//                }
//                avVar.f3695f = true;
//                a.mo16331a(this.mImageWidth, this.mImageHeight).error(R.drawable.fight_error).into(imageView, (Callback) null);
////                imageView.setOnClickListener(r3);
//                imageView.setVisibility(0);
//                this.mImgMaskOpts[i].setBackgroundResource(R.drawable.fight_image_frame);
//            }
//            return;
//        }
//        this.mMeanOptsView.setVisibility(0);
//        this.mImgOptsView.setVisibility(8);
//        this.mMeanWord.setText(problem.getTitle());
//        for (int i2 = 0; i2 < this.mMeanOpts.length; i2++) {
//            String replaceAll = ((Option) problem.getOptions().get(i2)).getMeanCn().replaceAll("\n|\r\n", " ");
//            AutoResizeTextView autoResizeTextView = this.mMeanOpts[i2];
//            autoResizeTextView.setText(replaceAll);
////            autoResizeTextView.setOnClickListener(r3);
//            autoResizeTextView.setBackgroundResource(R.drawable.fight_mean_opt_normal);
//            autoResizeTextView.setVisibility(0);
//        }
//    }
//
//    public void showAnswer(int i) {
//        int i2 = 0;
//        if (this.mCurrentProblemType == 1) {
//            for (ImageView onClickListener : this.mImgOpts) {
//                onClickListener.setOnClickListener(null);
//            }
//            if (i == -1) {
//                while (i2 < 4) {
//                    if (i2 == this.mCurrentProblemAnswer) {
//                        this.mImgMaskOpts[i2].setBackgroundResource(R.drawable.fight_img_right_bg);
//                    } else {
//                        this.mImgOpts[i2].setVisibility(4);
//                    }
//                    i2++;
//                }
//            } else if (i == this.mCurrentProblemAnswer) {
//                this.mImgMaskOpts[i].setBackgroundResource(R.drawable.fight_img_right_bg);
//            } else {
//                this.mImgMaskOpts[i].setBackgroundResource(R.drawable.fight_img_error_bg);
//            }
//        } else {
//            for (AutoResizeTextView onClickListener2 : this.mMeanOpts) {
//                onClickListener2.setOnClickListener(null);
//            }
//            if (i == -1) {
//                while (i2 < 4) {
//                    if (i2 == this.mCurrentProblemAnswer) {
//                        this.mMeanOpts[i2].setBackgroundResource(R.drawable.fight_mean_right_bg);
//                    } else {
//                        this.mMeanOpts[i2].setVisibility(4);
//                    }
//                    i2++;
//                }
//            } else if (i == this.mCurrentProblemAnswer) {
//                this.mMeanOpts[i].setBackgroundResource(R.drawable.fight_mean_right_bg);
//            } else {
//                this.mMeanOpts[i].setBackgroundResource(R.drawable.fight_mean_error_bg);
//            }
//        }
//        postDelayed(new Runnable() {
//            public void run() {
//                VSAnswerView.this.mAnswerListener.onFinish();
//            }
//        }, 600);
//    }
//}
