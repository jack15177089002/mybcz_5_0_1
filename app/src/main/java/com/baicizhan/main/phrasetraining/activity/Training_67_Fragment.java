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
//import java.util.Iterator;
//
//public class Training_67_Fragment extends TrainingFragment implements OnClickListener {
//    private ImageView mImg0;
//    private ImageView mImg1;
//    private ImageView mImg2;
//    private ImageView mImg3;
//    private VividPlayManager mPM;
//    private ImageView mTag;
//    private ImageView mTag0;
//    private ImageView mTag1;
//    private ImageView mTag2;
//    private ImageView mTag3;
//
//    static Training_67_Fragment createInstance() {
//        return new Training_67_Fragment();
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        if (recreated(bundle)) {
//            return null;
//        }
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.phrase_training_fragment_67, viewGroup, false);
//        PhraseTrainingActivity phraseTrainingActivity = (PhraseTrainingActivity) getActivity();
//        initElements(viewGroup2, phraseTrainingActivity);
//        initPlay(viewGroup2, phraseTrainingActivity);
//        return viewGroup2;
//    }
//
//    private void initElements(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        int topicId = phraseTrainingActivity.mCurTopic.getTopicId();
//        String[] split = phraseTrainingActivity.mCurTopic.getGroupedTopicIds().split(",");
//        ((TextView) viewGroup.findViewById(R.id.phrase_training_word)).setText(((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(topicId))).getWord());
//        int round = (int) Math.round(Math.random() * 3.0d);
//        this.mImg0 = (ImageView) viewGroup.findViewById(R.id.phrase_training_img_0);
//        ThemeResUtil.setCardBg(getActivity(), this.mImg0);
//        this.mImg0.setOnClickListener(this);
//        this.mImg1 = (ImageView) viewGroup.findViewById(R.id.phrase_training_img_1);
//        ThemeResUtil.setCardBg(getActivity(), this.mImg1);
//        this.mImg1.setOnClickListener(this);
//        this.mImg2 = (ImageView) viewGroup.findViewById(R.id.phrase_training_img_2);
//        ThemeResUtil.setCardBg(getActivity(), this.mImg2);
//        this.mImg2.setOnClickListener(this);
//        this.mImg3 = (ImageView) viewGroup.findViewById(R.id.phrase_training_img_3);
//        ThemeResUtil.setCardBg(getActivity(), this.mImg3);
//        this.mImg3.setOnClickListener(this);
//        ArrayList arrayList = new ArrayList(4);
//        arrayList.add(this.mImg0);
//        arrayList.add(this.mImg1);
//        arrayList.add(this.mImg2);
//        arrayList.add(this.mImg3);
//        ImageView imageView = (ImageView) arrayList.remove(round);
//        imageView.setTag(Boolean.valueOf(true));
//        RequestCreator a = Picasso.with((Context) phraseTrainingActivity).load(new File(PathUtil.reformSuffix(PathUtil.BCZ_HOME + ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(phraseTrainingActivity.mCurTopic.getTopicId()))).getWordImage(), ".jpg")));
//        a.f3707c = true;
//        a.into(imageView, (Callback) null);
//        int i = 0;
//        Iterator it = arrayList.iterator();
//        while (true) {
//            int i2 = i;
//            if (it.hasNext()) {
//                ImageView imageView2 = (ImageView) it.next();
//                imageView2.setTag(Boolean.valueOf(false));
//                RequestCreator a2 = Picasso.with((Context) phraseTrainingActivity).load(new File(PathUtil.reformSuffix(PathUtil.BCZ_HOME + ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(split[i2]))).getWordImage(), ".jpg")));
//                a2.f3707c = true;
//                a2.into(imageView2, (Callback) null);
//                i = i2 + 1;
//            } else {
//                this.mTag0 = (ImageView) viewGroup.findViewById(R.id.phrase_training_tag_0);
//                this.mTag1 = (ImageView) viewGroup.findViewById(R.id.phrase_training_tag_1);
//                this.mTag2 = (ImageView) viewGroup.findViewById(R.id.phrase_training_tag_2);
//                this.mTag3 = (ImageView) viewGroup.findViewById(R.id.phrase_training_tag_3);
//                ArrayList arrayList2 = new ArrayList(4);
//                arrayList2.add(this.mTag0);
//                arrayList2.add(this.mTag1);
//                arrayList2.add(this.mTag2);
//                arrayList2.add(this.mTag3);
//                ((ImageView) arrayList2.remove(round)).setImageResource(R.drawable.right_big_normal_default);
//                return;
//            }
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
//        if (view == this.mImg0) {
//            this.mTag = this.mTag0;
//        } else if (view == this.mImg1) {
//            this.mTag = this.mTag1;
//        } else if (view == this.mImg2) {
//            this.mTag = this.mTag2;
//        } else if (view == this.mImg3) {
//            this.mTag = this.mTag3;
//        }
//        if (this.mTag != null) {
//            this.mImg0.setOnClickListener(null);
//            this.mImg1.setOnClickListener(null);
//            this.mImg2.setOnClickListener(null);
//            this.mImg3.setOnClickListener(null);
//            this.mPM.stop();
//            this.mTag.setVisibility(0);
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
