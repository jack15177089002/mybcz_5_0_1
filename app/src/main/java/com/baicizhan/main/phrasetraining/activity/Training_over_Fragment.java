//package com.baicizhan.main.phrasetraining.activity;
//
//import android.os.Bundle;
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
//import java.util.List;
//
//public class Training_over_Fragment extends TrainingFragment {
//    static Training_over_Fragment createInstance() {
//        return new Training_over_Fragment();
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        if (recreated(bundle)) {
//            return null;
//        }
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.phrase_training_fragment_over, viewGroup, false);
//        initElements(viewGroup2, (PhraseTrainingActivity) getActivity());
//        initCtrls(viewGroup2);
//        return viewGroup2;
//    }
//
//    private void initElements(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        ((TextView) viewGroup.findViewById(R.id.phrase_training_course_finished)).setText(getString(R.string.phrase_training_course_finished, String.format("%02d", new Object[]{Integer.valueOf(phraseTrainingActivity.mCurGroupIndex + 1)})));
//        List phrases = ((PhraseGroup) phraseTrainingActivity.mGroupPhrases.get(phraseTrainingActivity.mCurGroupIndex)).getPhrases();
//        ArrayList arrayList = new ArrayList(8);
//        arrayList.add((TextView) viewGroup.findViewById(R.id.phrase_training_word_0));
//        arrayList.add((TextView) viewGroup.findViewById(R.id.phrase_training_word_1));
//        arrayList.add((TextView) viewGroup.findViewById(R.id.phrase_training_word_2));
//        arrayList.add((TextView) viewGroup.findViewById(R.id.phrase_training_word_3));
//        arrayList.add((TextView) viewGroup.findViewById(R.id.phrase_training_word_4));
//        arrayList.add((TextView) viewGroup.findViewById(R.id.phrase_training_word_5));
//        arrayList.add((TextView) viewGroup.findViewById(R.id.phrase_training_word_6));
//        arrayList.add((TextView) viewGroup.findViewById(R.id.phrase_training_word_7));
//        ArrayList arrayList2 = new ArrayList(8);
//        arrayList2.add((TextView) viewGroup.findViewById(R.id.phrase_training_mean_0));
//        arrayList2.add((TextView) viewGroup.findViewById(R.id.phrase_training_mean_1));
//        arrayList2.add((TextView) viewGroup.findViewById(R.id.phrase_training_mean_2));
//        arrayList2.add((TextView) viewGroup.findViewById(R.id.phrase_training_mean_3));
//        arrayList2.add((TextView) viewGroup.findViewById(R.id.phrase_training_mean_4));
//        arrayList2.add((TextView) viewGroup.findViewById(R.id.phrase_training_mean_5));
//        arrayList2.add((TextView) viewGroup.findViewById(R.id.phrase_training_mean_6));
//        arrayList2.add((TextView) viewGroup.findViewById(R.id.phrase_training_mean_7));
//        int min = Math.min(phrases.size(), arrayList.size());
//        for (int i = 0; i < min; i++) {
//            ((TextView) arrayList.get(i)).setText(((Phrase) phrases.get(i)).getWord());
//            ((TextView) arrayList.get(i)).setVisibility(0);
//            ((TextView) arrayList2.get(i)).setText(((com.baicizhan.main.phrasetraining.data.bean.Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(((Phrase) phrases.get(i)).getTopicId()))).getMeanCn().replaceAll("\n", ""));
//            ((TextView) arrayList2.get(i)).setVisibility(0);
//        }
//    }
//
//    private void initCtrls(ViewGroup viewGroup) {
//        ((Button) viewGroup.findViewById(R.id.phrase_training_back_list)).setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                if (Training_over_Fragment.this.mListener != null) {
//                    Training_over_Fragment.this.mListener.onEnd();
//                }
//            }
//        });
//        ((Button) viewGroup.findViewById(R.id.phrase_training_continue_next_course)).setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                if (Training_over_Fragment.this.mListener != null) {
//                    Training_over_Fragment.this.mListener.onNextGroup(Training_over_Fragment.this);
//                }
//            }
//        });
//    }
//
//    /* access modifiers changed from: protected */
//    public void next(boolean z) {
//    }
//}
