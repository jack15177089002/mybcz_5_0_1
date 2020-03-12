//package com.baicizhan.main.phrasetraining.activity;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.main.phrasetraining.data.bean.Phrase;
//import com.baicizhan.main.utils.VividPlayManager;
//import com.jiongji.andriod.card.R;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.Picasso;
//import com.p055f.p056a.RequestCreator;
//import java.io.File;
//import java.util.ArrayList;
//
//public class Training_60_64_Fragment extends TrainingFragment implements OnClickListener {
//    private static final String ARG_TYPE = "type";
//    private int mCurType = 60;
//    private VividPlayManager mPM;
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
//    static Training_60_64_Fragment createInstance(int i) {
//        Training_60_64_Fragment training_60_64_Fragment = new Training_60_64_Fragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt("type", i);
//        training_60_64_Fragment.setArguments(bundle);
//        return training_60_64_Fragment;
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
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.phrase_training_fragment_60_64, viewGroup, false);
//        PhraseTrainingActivity phraseTrainingActivity = (PhraseTrainingActivity) getActivity();
//        initImage(viewGroup2, phraseTrainingActivity);
//        initOptions(viewGroup2, phraseTrainingActivity);
//        initPlay(viewGroup2, phraseTrainingActivity);
//        return viewGroup2;
//    }
//
//    private void initImage(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        String reformSuffix = PathUtil.reformSuffix(PathUtil.BCZ_HOME + ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getWordImage(), ".jpg");
//        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.phrase_training_image);
//        RequestCreator a = Picasso.with((Context) phraseTrainingActivity).load(new File(reformSuffix));
//        a.f3707c = true;
//        a.into(imageView, (Callback) null);
//    }
//
//    private void initOptions(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        String word;
//        String[] strArr = new String[3];
//        if (60 == this.mCurType) {
//            String meanCn = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getMeanCn();
//            word = meanCn;
//            strArr = phraseTrainingActivity.mCurTopic.getGroupedOptions().split("\\|");
//        } else if (64 == this.mCurType) {
//            word = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getWord();
//            String[] split = phraseTrainingActivity.mCurTopic.getGroupedTopicIds().split(",");
//            for (int i = 0; i < 3; i++) {
//                strArr[i] = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(split[i]))).getWord();
//            }
//        } else {
//            return;
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
//        View findViewById = viewGroup.findViewById(R.id.phrase_training_sound_frame);
//        ImageView imageView = (ImageView) findViewById.findViewById(R.id.phrase_training_sound);
//        ThemeResUtil.setSoundBg(getActivity(), imageView);
//        this.mPM = new VividPlayManager(phraseTrainingActivity.mPlayer, ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getWordAudio(), findViewById, imageView);
//        this.mPM.play();
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
//            this.mWord0.setOnClickListener(null);
//            this.mWord1.setOnClickListener(null);
//            this.mWord2.setOnClickListener(null);
//            this.mWord3.setOnClickListener(null);
//            this.mTag.setVisibility(0);
//            this.mPM.stop();
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
//            this.mTag.setVisibility(8);
//        }
//    }
//}
