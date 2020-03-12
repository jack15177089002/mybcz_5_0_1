//package com.baicizhan.main.plusreview.fragment;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.support.p004v4.app.Fragment;
//import android.text.SpannableString;
//import android.text.style.ForegroundColorSpan;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.View.OnLongClickListener;
//import android.view.View.OnTouchListener;
//import android.view.ViewGroup;
//import android.view.animation.AlphaAnimation;
//import android.view.animation.AnimationSet;
//import android.view.animation.TranslateAnimation;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.ZPackUtils;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.client.framework.util.Common;
//import com.baicizhan.main.plusreview.data.MatchTestCache;
//import com.baicizhan.main.plusreview.data.MatchTestlib.BingSentence;
//import com.baicizhan.main.plusreview.data.MatchTestlib.Other;
//import com.baicizhan.main.plusreview.data.MatchTestlib.RightOption;
//import com.baicizhan.main.plusreview.data.MatchTestlib.Word;
//import com.jiongji.andriod.card.R;
//import com.p047d.p048a.ObjectAnimator;
//import com.p047d.p050c.ViewHelper;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.RequestCreator;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class MatchFragment extends Fragment implements OnClickListener, OnLongClickListener, OnTouchListener {
//    private static final String ARG_INDEX = "index";
//    private static final int MAX_OPT_COUNT = 5;
//    private static final int MAX_RIGHT_COUNT = 2;
//    private TextView[] mCnExms = new TextView[2];
//    private TextView mCnmean;
//    private TextView[] mExms = new TextView[2];
//    private ImageView mImage;
//    private int mIndex;
//    private LeftClickListener mLeftClickListener;
//    private View mLeftContainer;
//    private OnMatchFragmentInteractionListener mListener;
//    private TextView[] mOptAnswers;
//    private ImageView[] mOptTags;
//    private List<Option> mOptions = new ArrayList(5);
//    private ViewGroup[] mOpts;
//    /* access modifiers changed from: private */
//    public AudioPlayer mPlayer;
//    private Word mReviewWord;
//    private boolean mRight = true;
//    private int mRightIndex = 0;
//    private List<Integer> mRights = new ArrayList(2);
//    /* access modifiers changed from: private */
//    public TopicRecord mTopicRecord;
//    /* access modifiers changed from: private */
//    public TextView mWord;
//
//    class LeftClickListener implements OnClickListener {
//        private LeftClickListener() {
//        }
//
//        public void onClick(View view) {
//            ViewHelper.m3390b(MatchFragment.this.mWord, (float) (MatchFragment.this.mWord.getWidth() / 2));
//            ViewHelper.m3391c(MatchFragment.this.mWord, (float) (MatchFragment.this.mWord.getHeight() / 2));
//            ObjectAnimator.m3360a(MatchFragment.this.mWord, "scaleX", 1.0f, 1.2f, 1.0f).mo16215a(300).mo16161a();
//            ObjectAnimator.m3360a(MatchFragment.this.mWord, "scaleY", 1.0f, 1.2f, 1.0f).mo16215a(300).mo16161a();
//            ZPackUtils.loadAudioCompat(MatchFragment.this.mPlayer, MatchFragment.this.mTopicRecord, MatchFragment.this.mTopicRecord.wordAudio);
//        }
//    }
//
//    public interface OnMatchFragmentInteractionListener {
//        void onAnswer(boolean z, int i);
//
//        void onMatchDetach();
//    }
//
//    class Option {
//        String cnexample;
//        String cnmean;
//        SpannableString example;
//
//        /* renamed from: id */
//        int f2402id;
//        String word;
//
//        private Option() {
//        }
//    }
//
//    public static MatchFragment newInstance(int i) {
//        MatchFragment matchFragment = new MatchFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt(ARG_INDEX, i);
//        matchFragment.setArguments(bundle);
//        return matchFragment;
//    }
//
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        this.mPlayer = new AudioPlayer(activity);
//        try {
//            this.mListener = (OnMatchFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        this.mIndex = getArguments() != null ? getArguments().getInt(ARG_INDEX) : 0;
//        if (MatchTestCache.getCache().getTestlib() != null) {
//            this.mReviewWord = (Word) MatchTestCache.getCache().getTestlib().getReview_words().get(this.mIndex);
//            this.mTopicRecord = MatchTestCache.getCache().getTopicRecord();
//        }
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        if (this.mReviewWord == null) {
//            return null;
//        }
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.plusreview_fragment_match, viewGroup, false);
//        initValues();
//        initViews(viewGroup2);
//        return viewGroup2;
//    }
//
//    private void initValues() {
//        int indexOf;
//        List arr_right_options = this.mReviewWord.getArr_right_options();
//        Collections.shuffle(arr_right_options);
//        int min = Math.min(2, arr_right_options.size());
//        for (int i = 0; i < min; i++) {
//            RightOption rightOption = (RightOption) arr_right_options.get(i);
//            this.mRights.add(Integer.valueOf(rightOption.getEn_word_id()));
//            Option option = new Option();
//            option.f2402id = rightOption.getEn_word_id();
//            option.word = rightOption.getWord();
//            option.cnmean = rightOption.getMean_cn();
//            option.cnexample = ((BingSentence) rightOption.getArr_bing_sentences().get(0)).getSentence_trans();
//            String sentence = ((BingSentence) rightOption.getArr_bing_sentences().get(0)).getSentence();
//            ArrayList<String> arrayList = new ArrayList<>();
//            ArrayList arrayList2 = new ArrayList();
//            do {
//                int indexOf2 = sentence.indexOf("<i>");
//                indexOf = sentence.indexOf("</i>");
//                Log.d("whiz", "raw exmp: " + sentence + "; start: " + indexOf2 + "; end: " + indexOf);
//                if (indexOf2 < 0 || indexOf < 0) {
//                    break;
//                }
//                String substring = sentence.substring(indexOf2 + 3, indexOf);
//                arrayList.add(substring);
//                sentence = sentence.replaceFirst("<i>" + substring + "</i>", substring);
//                arrayList2.add(Integer.valueOf(indexOf2));
//                if (indexOf2 < 0) {
//                    break;
//                }
//            } while (indexOf >= 0);
//            option.example = new SpannableString(sentence);
//            int i2 = 0;
//            for (String str : arrayList) {
//                int intValue = ((Integer) arrayList2.get(i2)).intValue();
//                if (intValue >= 0) {
//                    option.example.setSpan(new ForegroundColorSpan(ThemeUtil.getThemeColorWithAttr(getActivity(), R.attr.color_progress)), intValue, str.length() + intValue, 34);
//                }
//                i2++;
//            }
//            this.mOptions.add(option);
//        }
//        List arr_other_options = this.mReviewWord.getArr_other_options();
//        Collections.shuffle(arr_other_options);
//        int min2 = Math.min(3, arr_other_options.size());
//        for (int i3 = 0; i3 < min2; i3++) {
//            Other other = (Other) arr_other_options.get(i3);
//            Option option2 = new Option();
//            option2.f2402id = other.getEn_word_id();
//            option2.word = other.getWord();
//            option2.cnmean = other.getMean_cn();
//            this.mOptions.add(option2);
//        }
//        Collections.shuffle(this.mOptions);
//    }
//
//    private void initViews(ViewGroup viewGroup) {
//        this.mLeftClickListener = new LeftClickListener();
//        this.mLeftContainer = viewGroup.findViewById(R.id.plusreview_match_left);
//        this.mLeftContainer.setOnClickListener(this.mLeftClickListener);
//        this.mWord = (TextView) viewGroup.findViewById(R.id.plusreview_match_word);
//        this.mWord.setText(this.mTopicRecord.word);
//        this.mWord.setOnClickListener(this.mLeftClickListener);
//        this.mCnmean = (TextView) viewGroup.findViewById(R.id.plusreview_match_cnmean);
//        this.mCnmean.setText(this.mTopicRecord.wordMean);
//        this.mCnmean.setVisibility(8);
//        this.mCnmean.setOnClickListener(this.mLeftClickListener);
//        this.mImage = (ImageView) viewGroup.findViewById(R.id.plusreview_match_image);
//        ThemeResUtil.setCardBg(getActivity(), this.mImage);
//        RequestCreator b = ZPackUtils.loadImageCompat(this.mTopicRecord, this.mTopicRecord.imagePath).error(R.drawable.image_broke_normal_default);
//        b.f3707c = true;
//        b.into(this.mImage, (Callback) null);
//        this.mImage.setVisibility(8);
//        this.mImage.setOnClickListener(this.mLeftClickListener);
//        this.mExms[0] = (TextView) viewGroup.findViewById(R.id.plusreview_match_exam_0);
//        this.mCnExms[0] = (TextView) viewGroup.findViewById(R.id.plusreview_match_cnexam_0);
//        this.mExms[1] = (TextView) viewGroup.findViewById(R.id.plusreview_match_exam_1);
//        this.mCnExms[1] = (TextView) viewGroup.findViewById(R.id.plusreview_match_cnexam_1);
//        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.plusreview_match_right);
//        int min = Math.min(viewGroup2.getChildCount(), this.mOptions.size());
//        this.mOpts = new ViewGroup[min];
//        this.mOptAnswers = new TextView[min];
//        this.mOptTags = new ImageView[min];
//        for (int i = 0; i < min; i++) {
//            this.mOpts[i] = (ViewGroup) viewGroup2.getChildAt(i);
//            this.mOpts[i].setVisibility(0);
//            this.mOpts[i].setOnClickListener(this);
//            this.mOpts[i].setOnLongClickListener(this);
//            this.mOpts[i].setOnTouchListener(this);
//            this.mOpts[i].setTag(Integer.valueOf(i));
//            this.mOptAnswers[i] = (TextView) this.mOpts[i].getChildAt(0);
//            this.mOptAnswers[i].setText(((Option) this.mOptions.get(i)).word);
//            this.mOptTags[i] = (ImageView) this.mOpts[i].getChildAt(1);
//            if (isRight(i)) {
//                this.mOptTags[i].setImageResource(R.drawable.right_mid_normal_default);
//            }
//        }
//    }
//
//    private boolean isRight(int i) {
//        int i2 = ((Option) this.mOptions.get(i)).f2402id;
//        for (Integer intValue : this.mRights) {
//            if (i2 == intValue.intValue()) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void onDestroy() {
//        super.onDestroy();
//    }
//
//    public void onDetach() {
//        super.onDetach();
//        if (this.mListener != null) {
//            this.mListener.onMatchDetach();
//        }
//        this.mListener = null;
//        this.mPlayer.destroy();
//    }
//
//    public void onClick(View view) {
//        int intValue = ((Integer) view.getTag()).intValue();
//        boolean isRight = isRight(intValue);
//        this.mOptTags[intValue].setVisibility(0);
//        if (!isRight) {
//            moveOut(this.mOpts[intValue]);
//            this.mRight = false;
//        } else if (this.mRightIndex < 2) {
//            this.mExms[this.mRightIndex].setText(((Option) this.mOptions.get(intValue)).example);
//            this.mCnExms[this.mRightIndex].setText(((Option) this.mOptions.get(intValue)).cnexample);
//            switchRightExamples();
//            this.mRightIndex++;
//        }
//        this.mOpts[intValue].setOnClickListener(null);
//        if (this.mRightIndex >= 2 && this.mListener != null) {
//            this.mListener.onAnswer(this.mRight, this.mIndex);
//            displayWordInfo();
//            disableOptions();
//        }
//    }
//
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        switch (motionEvent.getAction()) {
//            case 1:
//            case 3:
//                onEndLongClick(view);
//                break;
//        }
//        return false;
//    }
//
//    public boolean onLongClick(View view) {
//        onStartLongClick(view);
//        return true;
//    }
//
//    private void onStartLongClick(View view) {
//        int intValue = ((Integer) view.getTag()).intValue();
//        this.mOptAnswers[intValue].setText(((Option) this.mOptions.get(intValue)).word + "\n" + ((Option) this.mOptions.get(intValue)).cnmean);
//        this.mOptAnswers[intValue].getLayoutParams().width = Common.dip2px(getActivity(), 230.0f);
//    }
//
//    private void onEndLongClick(View view) {
//        int intValue = ((Integer) view.getTag()).intValue();
//        this.mOptAnswers[intValue].setText(((Option) this.mOptions.get(intValue)).word);
//        this.mOptAnswers[intValue].getLayoutParams().width = Common.dip2px(getActivity(), 172.0f);
//    }
//
//    private void moveOut(View view) {
//        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
//        alphaAnimation.setDuration(160);
//        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
//        translateAnimation.setDuration(160);
//        AnimationSet animationSet = new AnimationSet(false);
//        animationSet.addAnimation(alphaAnimation);
//        animationSet.addAnimation(translateAnimation);
//        view.startAnimation(animationSet);
//        view.setVisibility(4);
//    }
//
//    private void displayWordInfo() {
//        this.mCnmean.setVisibility(0);
//        this.mImage.setVisibility(0);
//        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
//        alphaAnimation.setDuration(300);
//        this.mCnmean.startAnimation(alphaAnimation);
//        this.mImage.startAnimation(alphaAnimation);
//    }
//
//    private void disableOptions() {
//        ViewGroup[] viewGroupArr;
//        int i = 0;
//        for (ViewGroup viewGroup : this.mOpts) {
//            viewGroup.setOnClickListener(null);
//            if (viewGroup.getVisibility() == 0 && !isRight(i)) {
//                moveOut(viewGroup);
//            }
//            i++;
//        }
//    }
//
//    private void switchRightExamples() {
//        if (1 == this.mRightIndex) {
//            ObjectAnimator.m3360a(this.mExms[0], "alpha", 1.0f, 0.5f).mo16215a(300).mo16161a();
//            ObjectAnimator.m3360a(this.mCnExms[0], "alpha", 1.0f, 0.5f).mo16215a(300).mo16161a();
//        }
//        ObjectAnimator.m3360a(this.mExms[this.mRightIndex], "alpha", 0.5f, 1.0f).mo16215a(300).mo16161a();
//        ObjectAnimator.m3360a(this.mCnExms[this.mRightIndex], "alpha", 0.5f, 1.0f).mo16215a(300).mo16161a();
//    }
//}
