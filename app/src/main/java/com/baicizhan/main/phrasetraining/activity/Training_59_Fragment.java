//package com.baicizhan.main.phrasetraining.activity;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.text.SpannableString;
//import android.text.style.ForegroundColorSpan;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.main.phrasetraining.data.bean.Phrase;
//import com.baicizhan.main.utils.VividPlayManager;
//import com.jiongji.andriod.card.R;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.Picasso;
//import com.p055f.p056a.RequestCreator;
//import java.io.File;
//import java.util.Locale;
//
//public class Training_59_Fragment extends TrainingFragment implements OnClickListener {
//    private ImageView mImg0;
//    private ImageView mImg1;
//    private VividPlayManager mPM;
//    private ImageView mTag0;
//    private ImageView mTag1;
//
//    static Training_59_Fragment createInstance() {
//        return new Training_59_Fragment();
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        if (recreated(bundle)) {
//            return null;
//        }
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.phrase_training_fragment_59, viewGroup, false);
//        PhraseTrainingActivity phraseTrainingActivity = (PhraseTrainingActivity) getActivity();
//        initExample(viewGroup2, phraseTrainingActivity);
//        initOptions(viewGroup2, phraseTrainingActivity);
//        initPlay(viewGroup2, phraseTrainingActivity);
//        return viewGroup2;
//    }
//
//    private void initExample(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        String sentence = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getSentence();
//        String sentenceWordHighlight = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getSentenceWordHighlight();
//        SpannableString spannableString = new SpannableString(sentence);
//        int indexOf = sentence.toLowerCase(Locale.US).indexOf(sentenceWordHighlight.toLowerCase(Locale.US));
//        if (indexOf >= 0) {
//            spannableString.setSpan(new ForegroundColorSpan(ThemeUtil.getThemeColorWithAttr(getActivity(), R.attr.color_progress)), indexOf, sentenceWordHighlight.length() + indexOf, 34);
//        }
//        ((TextView) viewGroup.findViewById(R.id.phrase_training_example)).setText(spannableString);
//    }
//
//    private void initOptions(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        String reformSuffix = PathUtil.reformSuffix(PathUtil.BCZ_HOME + phraseTrainingActivity.mCurTopic.getGroupedOptions(), ".jpg");
//        String reformSuffix2 = PathUtil.reformSuffix(PathUtil.BCZ_HOME + ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getWordImage(), ".jpg");
//        this.mImg0 = (ImageView) viewGroup.findViewById(R.id.phrase_training_img_0);
//        ThemeResUtil.setCardBg(getActivity(), this.mImg0);
//        this.mImg0.setOnClickListener(this);
//        this.mImg1 = (ImageView) viewGroup.findViewById(R.id.phrase_training_img_1);
//        ThemeResUtil.setCardBg(getActivity(), this.mImg1);
//        this.mImg1.setOnClickListener(this);
//        this.mTag0 = (ImageView) viewGroup.findViewById(R.id.phrase_training_tag_0);
//        this.mTag1 = (ImageView) viewGroup.findViewById(R.id.phrase_training_tag_1);
//        if (((int) Math.round(Math.random())) == 0) {
//            this.mImg0.setTag(Boolean.valueOf(true));
//            RequestCreator a = Picasso.with((Context) phraseTrainingActivity).load(new File(reformSuffix2));
//            a.f3707c = true;
//            a.into(this.mImg0, (Callback) null);
//            this.mTag0.setImageResource(R.drawable.right_big_normal_default);
//            this.mImg1.setTag(Boolean.valueOf(false));
//            RequestCreator a2 = Picasso.with((Context) phraseTrainingActivity).load(new File(reformSuffix));
//            a2.f3707c = true;
//            a2.into(this.mImg1, (Callback) null);
//            this.mTag1.setImageResource(R.drawable.wrong_big_normal_default);
//            return;
//        }
//        this.mImg0.setTag(Boolean.valueOf(false));
//        RequestCreator a3 = Picasso.with((Context) phraseTrainingActivity).load(new File(reformSuffix));
//        a3.f3707c = true;
//        a3.into(this.mImg0, (Callback) null);
//        this.mTag0.setImageResource(R.drawable.wrong_big_normal_default);
//        this.mImg1.setTag(Boolean.valueOf(true));
//        RequestCreator a4 = Picasso.with((Context) phraseTrainingActivity).load(new File(reformSuffix2));
//        a4.f3707c = true;
//        a4.into(this.mImg1, (Callback) null);
//        this.mTag1.setImageResource(R.drawable.right_big_normal_default);
//    }
//
//    private void initPlay(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        View findViewById = viewGroup.findViewById(R.id.phrase_training_sound_frame);
//        ImageView imageView = (ImageView) findViewById.findViewById(R.id.phrase_training_sound);
//        ThemeResUtil.setSoundBg(getActivity(), imageView);
//        this.mPM = new VividPlayManager(phraseTrainingActivity.mPlayer, ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getSentenceAudio(), findViewById, imageView);
//        this.mPM.play();
//    }
//
//    public void onClick(View view) {
//        ImageView imageView;
//        boolean booleanValue = ((Boolean) view.getTag()).booleanValue();
//        if (this.mListener != null) {
//            this.mListener.onResult(booleanValue);
//        }
//        if (view == this.mImg0) {
//            imageView = this.mTag0;
//        } else if (view == this.mImg1) {
//            imageView = this.mTag1;
//        } else {
//            imageView = null;
//        }
//        if (imageView != null) {
//            this.mImg0.setOnClickListener(null);
//            this.mImg1.setOnClickListener(null);
//            this.mPM.stop();
//            imageView.setVisibility(0);
//            goNext(booleanValue);
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
//            this.mTag0.setVisibility(8);
//            this.mTag1.setVisibility(8);
//        }
//    }
//}
