//package com.baicizhan.main.plusreview.fragment;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Handler;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.animation.AlphaAnimation;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.CustomFont;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.TopicTextRenderHelper;
//import com.baicizhan.client.business.util.ZPackUtils;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.main.customview.SpellingKeyboard;
//import com.baicizhan.main.customview.SpellingKeyboard.SpellingKeyListener;
//import com.baicizhan.main.fragment.PatternBaseFragment;
//import com.baicizhan.main.plusreview.view.QuizHollowAnswerView;
//import com.baicizhan.main.plusreview.view.QuizHollowAnswerView.Initializer;
//import com.baicizhan.main.utils.VividPlayManager;
//import com.baicizhan.main.utils.VividPlayManager.OnPlayListener;
//import com.jiongji.andriod.card.R;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.RequestCreator;
//
//public class WriteFragment extends PatternBaseFragment implements OnClickListener, SpellingKeyListener, OnPlayListener {
//    private TextView mAccent;
//    private int[] mAnswerEnds;
//    private int[] mAnswerStarts;
//    private boolean mAnswered;
//    private int[] mAnswersBorder;
//    private Handler mHandler;
//    private ImageView mImage;
//    private SpellingKeyboard mKeyboard;
//    private int mLeftCount;
//    private TextView mLeftCountView;
//    private OnControlListener mListener;
//    private VividPlayManager mPM;
//    private boolean mPassed;
//    private View mPlayFrame;
//    private AudioPlayer mPlayer;
//    private QuizHollowAnswerView mQuizHollowView;
//    private boolean mStopped;
//    private Button mTip;
//
//    public interface OnControlListener {
//        void onKillWord();
//    }
//
//    public void setOnControlListener(OnControlListener onControlListener) {
//        this.mListener = onControlListener;
//    }
//
//    public WriteFragment(Context context) {
//        this(context, null, 0);
//    }
//
//    public WriteFragment(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        this.mPassed = false;
//        this.mStopped = false;
//        this.mHandler = new Handler();
//        this.mAnswered = false;
//        onCreateView(LayoutInflater.from(context), this);
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.plusreview_fragment_write, viewGroup, true);
//        this.mQuizHollowView = (QuizHollowAnswerView) viewGroup2.findViewById(R.id.plusreview_write_quiz);
//        this.mImage = (ImageView) viewGroup2.findViewById(R.id.plusreview_write_image);
//        ThemeResUtil.setCardBg(getContext(), this.mImage);
//        this.mAccent = (TextView) viewGroup2.findViewById(R.id.plusreview_write_accent);
//        CustomFont.setFont(this.mAccent, 3);
//        this.mTip = (Button) viewGroup2.findViewById(R.id.plusreview_write_tip);
//        this.mTip.setOnClickListener(this);
//        this.mPlayFrame = viewGroup2.findViewById(R.id.plusreview_write_sound_frame);
//        this.mLeftCountView = (TextView) viewGroup2.findViewById(R.id.plusreview_write_left_count);
//        this.mKeyboard = (SpellingKeyboard) viewGroup2.findViewById(R.id.plusreview_write_keyboard);
//        this.mKeyboard.setListener(this);
//        return viewGroup2;
//    }
//
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        this.mPlayer = new AudioPlayer(activity);
//    }
//
//    public void onDetach() {
//        super.onDetach();
//        if (this.mPlayer != null) {
//            this.mPlayer.stop();
//            this.mPlayer.destroy();
//        }
//        if (this.mAnswered) {
//            OperationStats.statMoreReviewPinxie();
//        }
//    }
//
//    public void onUpdateViews() {
//        this.mAnswered = false;
//        this.mPassed = false;
//        this.mStopped = false;
//        int[][] matchWordBorders = TopicTextRenderHelper.getMatchWordBorders(this.mRightOption);
//        if (matchWordBorders == null) {
//            throw new RuntimeException("Topic record content is not completed, record: " + this.mRightOption);
//        }
//        this.mAnswerStarts = new int[matchWordBorders.length];
//        this.mAnswerEnds = new int[matchWordBorders.length];
//        for (int i = 0; i < matchWordBorders.length; i++) {
//            this.mAnswerStarts[i] = matchWordBorders[i][0];
//            this.mAnswerEnds[i] = matchWordBorders[i][1];
//        }
//        resetAnswers();
//        this.mKeyboard.resetKeyboard();
//        RequestCreator b = ZPackUtils.loadImageCompat(this.mRightOption, this.mRightOption.imagePath).error(R.drawable.image_broke_normal_default);
//        b.f3707c = true;
//        b.into(this.mImage, (Callback) null);
//        this.mAccent.setText(this.mRightOption.phonetic);
//        this.mAccent.setVisibility(4);
//        this.mTip.setVisibility(0);
//        this.mPlayFrame.setVisibility(8);
//        initPlay(this);
//        this.mLeftCount = this.mQuizHollowView.getUnAnsweredCount();
//        this.mLeftCountView.setText(getContext().getResources().getString(R.string.plusreview_write_left_count_init, new Object[]{Integer.valueOf(this.mLeftCount)}));
//    }
//
//    private void resetAnswers() {
//        new Initializer().wrap(this.mQuizHollowView).setQuiz(this.mRightOption.sentence).setAnswerBorders(this.mAnswerStarts, this.mAnswerEnds).initialize();
//    }
//
//    private void initPlay(ViewGroup viewGroup) {
//        ImageView imageView = (ImageView) this.mPlayFrame.findViewById(R.id.plusreview_write_sound);
//        ThemeResUtil.setSoundBg(getContext(), imageView);
//        this.mPM = new VividPlayManager(this.mPlayer, this.mRightOption, this.mRightOption.wordAudio, this.mPlayFrame, imageView);
//        this.mPM.setPlayListener(this);
//    }
//
//    public boolean hint() {
//        return true;
//    }
//
//    public void sound() {
//    }
//
//    public void clearOptionMask(boolean z) {
//        if (this.mPassed || this.mStopped) {
//            resetAnswers();
//            this.mKeyboard.resetKeyboard();
//            this.mTip.setVisibility(0);
//            this.mPlayFrame.setVisibility(8);
//            this.mAccent.setVisibility(4);
//            this.mLeftCount = this.mQuizHollowView.getUnAnsweredCount();
//            this.mLeftCountView.setText(getContext().getResources().getString(R.string.plusreview_write_left_count_init, new Object[]{Integer.valueOf(this.mLeftCount)}));
//            this.mPassed = false;
//            this.mStopped = false;
//        }
//    }
//
//    public void onClick(View view) {
//        if (!this.mPassed && !this.mStopped && this.mTip == view) {
//            this.mTip.setVisibility(8);
//            this.mPlayFrame.setVisibility(0);
//            this.mPM.play();
//            this.mAccent.setVisibility(0);
//            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
//            alphaAnimation.setDuration(300);
//            this.mAccent.startAnimation(alphaAnimation);
//        }
//    }
//
//    public boolean onLetterClick(View view, String str) {
//        if (this.mPassed || this.mStopped) {
//            return true;
//        }
//        boolean fillAnswer = this.mQuizHollowView.fillAnswer(str);
//        if (fillAnswer) {
//            this.mKeyboard.resetKeyboard();
//        } else {
//            this.mLeftCount--;
//            this.mLeftCountView.setText(getContext().getResources().getString(R.string.plusreview_write_left_count, new Object[]{Integer.valueOf(this.mLeftCount)}));
//            if (this.mLeftCount <= 0) {
//                this.mStopped = true;
//                this.mQuizHollowView.fillAll();
//                this.mHandler.postDelayed(new Runnable() {
//                    public void run() {
//                        WriteFragment.this.answer(-1);
//                    }
//                }, 1000);
//                return false;
//            }
//        }
//        if (this.mQuizHollowView.allAnswered()) {
//            this.mPassed = true;
//            this.mPM.play();
//        }
//        return fillAnswer;
//    }
//
//    public void onPassClick(View view) {
//        if (!this.mPassed) {
//            this.mPassed = true;
//            this.mPM.play();
//        }
//    }
//
//    public void onSlashClick(View view) {
//        if (this.mListener != null) {
//            this.mListener.onKillWord();
//        }
//    }
//
//    public void onPlayStart() {
//    }
//
//    public void onPlayCompleted() {
//        if (this.mPassed) {
//            answer(this.mRightOption.topicId);
//            this.mAnswered = true;
//        }
//    }
//}
