//package com.baicizhan.main.plusreview.fragment;
//
//import android.app.Activity;
//import android.content.Context;
//import android.os.Handler;
//import android.text.TextUtils;
//import android.util.AttributeSet;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.ViewSwitcher;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.main.fragment.PatternBaseFragment;
//import com.baicizhan.main.utils.ResidentBitmapCache;
//import com.baicizhan.main.utils.VividPlayManager;
//import com.jiongji.andriod.card.R;
//import java.lang.ref.WeakReference;
//
//public class ListenFragment extends PatternBaseFragment implements OnClickListener {
//    private boolean mAnswered;
//    private VividPlayManager mExmplePM;
//    private Handler mHandler;
//    private int mHintLevel;
//    private ViewSwitcher mHintSwitcher;
//    private ImageView mListenExmple;
//    private ImageView mListenWord;
//    private ImageView[] mOptTags;
//    private ViewGroup[] mOpts;
//    private AudioPlayer mPlayer;
//    private StartPlayRun mStartPlayRun;
//    /* access modifiers changed from: private */
//    public VividPlayManager mWordPM;
//
//    class StartPlayRun implements Runnable {
//        final WeakReference<ListenFragment> mFragment;
//
//        StartPlayRun(ListenFragment listenFragment) {
//            this.mFragment = new WeakReference<>(listenFragment);
//        }
//
//        public void run() {
//            ListenFragment listenFragment = (ListenFragment) this.mFragment.get();
//            if (listenFragment != null) {
//                listenFragment.mWordPM.play();
//            }
//        }
//    }
//
//    public ListenFragment(Context context) {
//        this(context, null, 0);
//    }
//
//    public ListenFragment(Context context, AttributeSet attributeSet, int i) {
//        super(context, attributeSet, i);
//        this.mOpts = new ViewGroup[4];
//        this.mOptTags = new ImageView[4];
//        this.mHintLevel = 0;
//        this.mHandler = new Handler();
//        this.mAnswered = false;
//        onCreateView(LayoutInflater.from(context), this);
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.plusreview_fragment_listen, viewGroup, true);
//        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.id.plusreview_listen_opts);
//        int i = 0;
//        while (true) {
//            int i2 = i;
//            if (i2 < 4) {
//                this.mOpts[i2] = (ViewGroup) viewGroup3.getChildAt(i2);
//                this.mOpts[i2].setTag(Integer.valueOf(i2));
//                this.mOptTags[i2] = (ImageView) this.mOpts[i2].getChildAt(1);
//                i = i2 + 1;
//            } else {
//                this.mHintSwitcher = (ViewSwitcher) viewGroup2.findViewById(R.id.hint_switcher);
//                this.mListenWord = (ImageView) viewGroup2.findViewById(R.id.plusreview_listen_word);
//                ThemeResUtil.setSpeakWordBg(getContext(), this.mListenWord);
//                this.mListenExmple = (ImageView) viewGroup2.findViewById(R.id.plusreview_listen_example);
//                ThemeResUtil.setSpeakSeBg(getContext(), this.mListenExmple);
//                return viewGroup2;
//            }
//        }
//    }
//
//    public void onUpdateViews() {
//        super.onUpdateViews();
//        this.mAnswered = false;
//        for (int i = 0; i < 4; i++) {
//            this.mOpts[i].setOnClickListener(this);
//            TopicRecord topicRecord = (TopicRecord) this.mTopicOptions.get(i);
//            int i2 = topicRecord.topicId;
//            ((TextView) this.mOpts[i].getChildAt(0)).setText(TextUtils.isEmpty(topicRecord.wordMean) ? "" : topicRecord.wordMean.trim());
//            if (isRight(i2)) {
//                ResidentBitmapCache.setImageResource(this.mOptTags[i], R.drawable.right_mid_normal_default);
//            } else {
//                ResidentBitmapCache.setImageResource(this.mOptTags[i], R.drawable.wrong_mid_normal_default);
//            }
//            this.mOptTags[i].setVisibility(8);
//        }
//        this.mWordPM = new VividPlayManager(this.mPlayer, this.mRightOption, this.mRightOption.wordAudio, this.mListenWord);
//        this.mExmplePM = new VividPlayManager(this.mPlayer, this.mRightOption, this.mRightOption.sentenceAudio, this.mListenExmple);
//        this.mStartPlayRun = new StartPlayRun(this);
//        this.mHandler.postDelayed(this.mStartPlayRun, 800);
//    }
//
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        this.mPlayer = new AudioPlayer(activity);
//    }
//
//    public void onDetach() {
//        super.onDetach();
//        this.mHandler.removeCallbacks(this.mStartPlayRun);
//        hintFirst();
//        this.mHintLevel = 0;
//        if (this.mPlayer != null) {
//            this.mPlayer.destroy();
//        }
//        if (this.mAnswered) {
//            OperationStats.statMoreReviewTingyin();
//        }
//    }
//
//    public boolean hint() {
//        this.mHintLevel++;
//        if (this.mHintLevel < this.mHintSwitcher.getChildCount()) {
//            hint(this.mHintLevel);
//            return true;
//        }
//        this.mHintLevel = 0;
//        hint(-1);
//        return false;
//    }
//
//    private void hint(int i) {
//        if (i == 0) {
//            this.mWordPM.play();
//        } else if (i > 0) {
//            this.mExmplePM.play();
//        }
//        if (i < 0) {
//            this.mHintSwitcher.setDisplayedChild(0);
//        } else {
//            this.mHintSwitcher.setDisplayedChild(i);
//        }
//    }
//
//    private void hintFirst() {
//        if (this.mHintSwitcher.getDisplayedChild() != 0) {
//            this.mHintSwitcher.setDisplayedChild(0);
//        }
//    }
//
//    public void sound() {
//    }
//
//    public void clearOptionMask(boolean z) {
//        if (!z) {
//            this.mHandler.postDelayed(this.mStartPlayRun, 800);
//        }
//        for (int i = 0; i < this.mOptTags.length; i++) {
//            if (this.mOptTags[i].getVisibility() != 0 || !z) {
//                this.mOptTags[i].setVisibility(8);
//                this.mOpts[i].setOnClickListener(this);
//            }
//        }
//    }
//
//    public void onClick(View view) {
//        int intValue = ((Integer) view.getTag()).intValue();
//        this.mOptTags[intValue].setVisibility(0);
//        for (ViewGroup onClickListener : this.mOpts) {
//            onClickListener.setOnClickListener(null);
//        }
//        answer(((TopicRecord) this.mTopicOptions.get(intValue)).topicId);
//        this.mAnswered = true;
//    }
//}
