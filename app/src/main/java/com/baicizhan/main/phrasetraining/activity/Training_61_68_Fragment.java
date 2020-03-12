//package com.baicizhan.main.phrasetraining.activity;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.main.phrasetraining.data.bean.Phrase;
//import com.baicizhan.main.utils.VividPlayManager;
//import com.jiongji.andriod.card.R;
//import java.util.ArrayList;
//
//public class Training_61_68_Fragment extends TrainingFragment implements OnClickListener {
//    private static final String ARG_TYPE = "type";
//    private int mCurType = 61;
//    private TextView mExample;
//    private TextView mExampleMean;
//    private Button mNext;
//    /* access modifiers changed from: private */
//    public VividPlayManager mPM;
//    private View mPlayFrame;
//    private ImageView mTag;
//    private ImageView mTag0;
//    private ImageView mTag1;
//    private ImageView mTag2;
//    private ImageView mTag3;
//    private TextView mWord0;
//    private TextView mWord1;
//    private TextView mWord2;
//    private TextView mWord3;
//
//    static Training_61_68_Fragment createInstance(int i) {
//        Training_61_68_Fragment training_61_68_Fragment = new Training_61_68_Fragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt("type", i);
//        training_61_68_Fragment.setArguments(bundle);
//        return training_61_68_Fragment;
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        this.mCurType = getArguments() != null ? getArguments().getInt("type") : this.mCurType;
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        if (recreated(bundle)) {
//            return null;
//        }
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.phrase_training_fragment_61_68, viewGroup, false);
//        PhraseTrainingActivity phraseTrainingActivity = (PhraseTrainingActivity) getActivity();
//        initNextButton(viewGroup2, phraseTrainingActivity);
//        initExample(viewGroup2, phraseTrainingActivity);
//        initOptions(viewGroup2, phraseTrainingActivity);
//        initPlay(viewGroup2, phraseTrainingActivity);
//        return viewGroup2;
//    }
//
//    private void initNextButton(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        this.mNext = (Button) viewGroup.findViewById(R.id.phrase_training_next_q);
//        this.mNext.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                Training_61_68_Fragment.this.mPM.stop();
//                Training_61_68_Fragment.this.goNext(true, 0);
//            }
//        });
//    }
//
//    private void initExample(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        String sentencen2Trans;
//        String sentence2;
//        if (61 == this.mCurType) {
//            sentencen2Trans = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getSentenceTrans();
//            sentence2 = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getSentence();
//        } else {
//            sentencen2Trans = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getSentencen2Trans();
//            sentence2 = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getSentence2();
//        }
//        this.mExampleMean = (TextView) viewGroup.findViewById(R.id.phrase_training_mean);
//        this.mExampleMean.setText(sentencen2Trans);
//        this.mExample = (TextView) viewGroup.findViewById(R.id.phrase_training_example);
//        this.mExample.setText(sentence2);
//    }
//
//    private void initOptions(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        String[] strArr = new String[3];
//        String word = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getWord();
//        String[] split = phraseTrainingActivity.mCurTopic.getGroupedTopicIds().split(",");
//        for (int i = 0; i < 3; i++) {
//            strArr[i] = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(split[i]))).getWord();
//        }
//        this.mTag0 = (ImageView) viewGroup.findViewById(R.id.phrase_training_tag_0);
//        this.mTag1 = (ImageView) viewGroup.findViewById(R.id.phrase_training_tag_1);
//        this.mTag2 = (ImageView) viewGroup.findViewById(R.id.phrase_training_tag_2);
//        this.mTag3 = (ImageView) viewGroup.findViewById(R.id.phrase_training_tag_3);
//        ArrayList arrayList = new ArrayList(4);
//        arrayList.add(this.mTag0);
//        arrayList.add(this.mTag1);
//        arrayList.add(this.mTag2);
//        arrayList.add(this.mTag3);
//        this.mWord0 = (TextView) viewGroup.findViewById(R.id.phrase_training_word_0);
//        this.mWord1 = (TextView) viewGroup.findViewById(R.id.phrase_training_word_1);
//        this.mWord2 = (TextView) viewGroup.findViewById(R.id.phrase_training_word_2);
//        this.mWord3 = (TextView) viewGroup.findViewById(R.id.phrase_training_word_3);
//        ArrayList arrayList2 = new ArrayList(4);
//        arrayList2.add(this.mWord0);
//        arrayList2.add(this.mWord1);
//        arrayList2.add(this.mWord2);
//        arrayList2.add(this.mWord3);
//        int round = (int) Math.round(Math.random() * 3.0d);
//        TextView textView = (TextView) arrayList2.remove(round);
//        textView.setTag(Boolean.valueOf(true));
//        textView.setText(word);
//        textView.setOnClickListener(this);
//        ((ImageView) arrayList.remove(round)).setImageResource(R.drawable.right_mid_normal_default);
//        for (int i2 = 0; i2 < 3; i2++) {
//            ((TextView) arrayList2.get(i2)).setTag(Boolean.valueOf(false));
//            ((TextView) arrayList2.get(i2)).setText(strArr[i2]);
//            ((TextView) arrayList2.get(i2)).setOnClickListener(this);
//        }
//    }
//
//    private void initPlay(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        String sentence2Audio;
//        if (61 == this.mCurType) {
//            sentence2Audio = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getSentenceAudio();
//        } else {
//            sentence2Audio = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getSentence2Audio();
//        }
//        this.mPlayFrame = viewGroup.findViewById(R.id.phrase_training_sound_frame);
//        ImageView imageView = (ImageView) this.mPlayFrame.findViewById(R.id.phrase_training_sound);
//        ThemeResUtil.setSoundBg(getActivity(), imageView);
//        this.mPM = new VividPlayManager(phraseTrainingActivity.mPlayer, sentence2Audio, this.mPlayFrame, imageView);
//        this.mPlayFrame.setVisibility(8);
//    }
//
//    public void onClick(View view) {
//        boolean booleanValue = ((Boolean) view.getTag()).booleanValue();
//        if (this.mListener != null) {
//            this.mListener.onResult(booleanValue);
//        }
//        this.mTag = null;
//        if (view == this.mWord0) {
//            this.mTag = this.mTag0;
//        } else if (view == this.mWord1) {
//            this.mTag = this.mTag1;
//        } else if (view == this.mWord2) {
//            this.mTag = this.mTag2;
//        } else {
//            this.mTag = this.mTag3;
//        }
//        if (this.mTag != null) {
//            this.mTag.setVisibility(0);
//            this.mWord0.setOnClickListener(null);
//            this.mWord1.setOnClickListener(null);
//            this.mWord2.setOnClickListener(null);
//            this.mWord3.setOnClickListener(null);
//            if (booleanValue) {
//                this.mExample.setVisibility(0);
//                this.mNext.setVisibility(0);
//                this.mPlayFrame.setVisibility(0);
//                this.mHandler.postDelayed(new Runnable() {
//                    public void run() {
//                        Training_61_68_Fragment.this.mPM.play();
//                    }
//                }, 450);
//                return;
//            }
//            goNext(false);
//        }
//    }
//
//    /* access modifiers changed from: protected */
//    public void next(boolean z) {
//        if (this.mListener != null) {
//            if (z) {
//                this.mListener.onNext(0, null);
//            } else {
//                this.mListener.onNext(1, null);
//            }
//            this.mTag.setVisibility(8);
//        }
//    }
//}
