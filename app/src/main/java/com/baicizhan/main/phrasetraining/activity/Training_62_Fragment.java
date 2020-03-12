//package com.baicizhan.main.phrasetraining.activity;
//
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//import com.baicizhan.main.phrasetraining.data.bean.PhraseGroup;
//import com.baicizhan.main.phrasetraining.data.bean.PhraseGroup.Phrase;
//import com.jiongji.andriod.card.R;
//import java.util.ArrayList;
//
//public class Training_62_Fragment extends TrainingFragment {
//    private String mAEndTip;
//    private String mAMidMean;
//    private String mAMidTip;
//    private ArrayList<String> mAWords = new ArrayList<>(3);
//    private Button mNext;
//    private String mQEndTip;
//    private String mQStartTip;
//    private ArrayList<String> mQWords = new ArrayList<>(3);
//    private boolean mQuestion = true;
//
//    static Training_62_Fragment createInstance() {
//        return new Training_62_Fragment();
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        if (recreated(bundle)) {
//            return null;
//        }
//        PhraseTrainingActivity phraseTrainingActivity = (PhraseTrainingActivity) getActivity();
//        if (!initDatas(phraseTrainingActivity)) {
//            return null;
//        }
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(this.mQuestion ? R.layout.phrase_training_fragment_62_question : R.layout.phrase_training_fragment_62_answer, viewGroup, false);
//        initTips(viewGroup2, phraseTrainingActivity);
//        initNextButton(viewGroup2, phraseTrainingActivity);
//        return viewGroup2;
//    }
//
//    private boolean initDatas(PhraseTrainingActivity phraseTrainingActivity) {
//        int i = 0;
//        String tips = phraseTrainingActivity.mCurTopic.getTips();
//        if (TextUtils.isEmpty(tips)) {
//            return false;
//        }
//        String[] split = tips.replaceAll("\n", "").split("#");
//        Log.d("whiz", "QA tips: " + tips.replaceAll("\n", ""));
//        int length = split.length;
//        for (int i2 = 0; i2 < length; i2++) {
//            Log.d("whiz", "QA tip: " + split[i2]);
//        }
//        if (tips.startsWith("#")) {
//            this.mQuestion = false;
//            int length2 = split.length;
//            while (i < length2) {
//                String str = split[i];
//                String replaceAll = str.replaceAll(" ", "");
//                if (isPhrase(str, phraseTrainingActivity)) {
//                    this.mAWords.add(str);
//                } else if (!replaceAll.equals(", ") && !replaceAll.equals(",") && !replaceAll.equals("，") && !replaceAll.equals("， ") && !replaceAll.equals("")) {
//                    if (this.mAMidTip == null) {
//                        this.mAMidTip = str;
//                    } else if (this.mAMidMean == null) {
//                        this.mAMidMean = str;
//                    } else if (this.mAEndTip == null) {
//                        this.mAEndTip = str;
//                    }
//                }
//                i++;
//            }
//        } else {
//            this.mQuestion = true;
//            int length3 = split.length;
//            while (i < length3) {
//                String str2 = split[i];
//                String replaceAll2 = str2.replaceAll(" ", "");
//                if (isPhrase(str2, phraseTrainingActivity)) {
//                    this.mQWords.add(str2);
//                } else if (!replaceAll2.equals(", ") && !replaceAll2.equals(",") && !replaceAll2.equals("，") && !replaceAll2.equals("， ") && !replaceAll2.equals("")) {
//                    if (this.mQStartTip == null) {
//                        this.mQStartTip = str2;
//                    } else if (this.mQEndTip == null) {
//                        this.mQEndTip = str2;
//                    }
//                }
//                i++;
//            }
//        }
//        return true;
//    }
//
//    private boolean isPhrase(String str, PhraseTrainingActivity phraseTrainingActivity) {
//        for (Phrase word : ((PhraseGroup) phraseTrainingActivity.mGroupPhrases.get(phraseTrainingActivity.mCurGroupIndex)).getPhrases()) {
//            if (word.getWord().equals(str)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private void initTips(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        if (this.mQuestion) {
//            ((TextView) viewGroup.findViewById(R.id.phrase_training_62_q_start_tip)).setText(this.mQStartTip);
//            ((TextView) viewGroup.findViewById(R.id.phrase_training_62_q_end_tip)).setText(this.mQEndTip);
//            ArrayList arrayList = new ArrayList();
//            arrayList.add((TextView) viewGroup.findViewById(R.id.phrase_training_62_q_word_0));
//            arrayList.add((TextView) viewGroup.findViewById(R.id.phrase_training_62_q_word_1));
//            arrayList.add((TextView) viewGroup.findViewById(R.id.phrase_training_62_q_word_2));
//            arrayList.add((TextView) viewGroup.findViewById(R.id.phrase_training_62_q_word_3));
//            int min = Math.min(this.mQWords.size(), arrayList.size());
//            for (int i = 0; i < min; i++) {
//                ((TextView) arrayList.get(i)).setText((CharSequence) this.mQWords.get(i));
//                ((TextView) arrayList.get(i)).setVisibility(0);
//            }
//            return;
//        }
//        ((TextView) viewGroup.findViewById(R.id.phrase_training_62_a_middle_tip)).setText(this.mAMidTip);
//        ((TextView) viewGroup.findViewById(R.id.phrase_training_62_a_middle_mean)).setText(this.mAMidMean);
//        ((TextView) viewGroup.findViewById(R.id.phrase_training_62_a_end_tip)).setText(this.mAEndTip);
//        ArrayList arrayList2 = new ArrayList();
//        arrayList2.add((TextView) viewGroup.findViewById(R.id.phrase_training_62_a_word_0));
//        arrayList2.add((TextView) viewGroup.findViewById(R.id.phrase_training_62_a_word_1));
//        arrayList2.add((TextView) viewGroup.findViewById(R.id.phrase_training_62_a_word_2));
//        arrayList2.add((TextView) viewGroup.findViewById(R.id.phrase_training_62_a_word_3));
//        int min2 = Math.min(this.mAWords.size(), arrayList2.size());
//        for (int i2 = 0; i2 < min2; i2++) {
//            ((TextView) arrayList2.get(i2)).setText((CharSequence) this.mAWords.get(i2));
//            ((TextView) arrayList2.get(i2)).setVisibility(0);
//        }
//    }
//
//    private void initNextButton(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        this.mNext = (Button) viewGroup.findViewById(R.id.phrase_training_next_q);
//        this.mNext.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                Training_62_Fragment.this.goNext(true, 0);
//            }
//        });
//    }
//
//    /* access modifiers changed from: protected */
//    public void next(boolean z) {
//        if (this.mListener != null) {
//            this.mListener.onNext(0, null);
//        }
//    }
//}
