//package com.baicizhan.main.phrasetraining.activity;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.Button;
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
//import org.slf4j.Marker;
//
//public class Training_66_Fragment extends TrainingFragment {
//    private static final String ARG_IS_WIKI = "is_wiki";
//    private Button mNext;
//    /* access modifiers changed from: private */
//    public VividPlayManager mPM;
//    private boolean mWIKI = false;
//
//    static Training_66_Fragment createInstance(boolean z) {
//        Training_66_Fragment training_66_Fragment = new Training_66_Fragment();
//        Bundle bundle = new Bundle();
//        bundle.putBoolean(ARG_IS_WIKI, z);
//        training_66_Fragment.setArguments(bundle);
//        return training_66_Fragment;
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        this.mWIKI = getArguments() != null ? getArguments().getBoolean(ARG_IS_WIKI) : false;
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        if (recreated(bundle)) {
//            return null;
//        }
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.phrase_training_fragment_66, viewGroup, false);
//        PhraseTrainingActivity phraseTrainingActivity = (PhraseTrainingActivity) getActivity();
//        initWikis(viewGroup2, phraseTrainingActivity);
//        initNextButton(viewGroup2, phraseTrainingActivity);
//        initPlay(viewGroup2, phraseTrainingActivity);
//        return viewGroup2;
//    }
//
//    private void initWikis(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        String reformSuffix = PathUtil.reformSuffix(PathUtil.BCZ_HOME + ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getWordImage(), ".jpg");
//        String word = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getWord();
//        String meanCn = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getMeanCn();
//        String sentence = ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getSentence();
//        String sb = new StringBuilder(Marker.ANY_MARKER).append(((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getExamInfo()).toString();
//        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.phrase_training_image);
//        RequestCreator a = Picasso.with((Context) phraseTrainingActivity).load(new File(reformSuffix));
//        a.f3707c = true;
//        a.into(imageView, (Callback) null);
//        ((TextView) viewGroup.findViewById(R.id.phrase_training_word)).setText(word);
//        ((TextView) viewGroup.findViewById(R.id.phrase_training_mean)).setText(meanCn);
//        ((TextView) viewGroup.findViewById(R.id.phrase_training_example)).setText(sentence);
//        ((TextView) viewGroup.findViewById(R.id.phrase_training_test_from)).setText(sb);
//    }
//
//    private void initNextButton(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        this.mNext = (Button) viewGroup.findViewById(R.id.phrase_training_next_q);
//        this.mNext.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                Training_66_Fragment.this.mPM.stop();
//                Training_66_Fragment.this.goNext(true, 0);
//            }
//        });
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
//    /* access modifiers changed from: protected */
//    public void next(boolean z) {
//        if (this.mListener != null) {
//            if (this.mWIKI) {
//                this.mListener.onNext(2, this);
//            } else {
//                this.mListener.onNext(0, null);
//            }
//        }
//    }
//}
