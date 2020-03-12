//package com.baicizhan.main.phrasetraining.activity;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup;
//import android.view.animation.AlphaAnimation;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.main.phrasetraining.data.bean.Phrase;
//import com.jiongji.andriod.card.R;
//import com.p047d.p048a.ObjectAnimator;
//import com.p047d.p050c.ViewHelper;
//import com.p055f.p056a.Callback;
//import com.p055f.p056a.Picasso;
//import com.p055f.p056a.RequestCreator;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//public class Training_65_Fragment extends TrainingFragment implements OnClickListener {
//    private int mCurIndex;
//    private ArrayList<ImageView> mImgs = new ArrayList<>(3);
//    private Button mNext;
//    private int mOptsSize;
//    private ArrayList<Button> mSelects = new ArrayList<>(3);
//    private ArrayList<TextView> mWordViews = new ArrayList<>(3);
//
//    static Training_65_Fragment createInstance() {
//        return new Training_65_Fragment();
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        if (recreated(bundle)) {
//            return null;
//        }
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.phrase_training_fragment_65, viewGroup, false);
//        PhraseTrainingActivity phraseTrainingActivity = (PhraseTrainingActivity) getActivity();
//        initNextButton(viewGroup2, phraseTrainingActivity);
//        initOptions(viewGroup2, phraseTrainingActivity);
//        return viewGroup2;
//    }
//
//    private void initNextButton(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        this.mNext = (Button) viewGroup.findViewById(R.id.phrase_training_next_q);
//        this.mNext.setOnClickListener(new OnClickListener() {
//            public void onClick(View view) {
//                Training_65_Fragment.this.goNext(true, 0);
//            }
//        });
//    }
//
//    private void initOptions(ViewGroup viewGroup, PhraseTrainingActivity phraseTrainingActivity) {
//        int i = 0;
//        String[] split = phraseTrainingActivity.mCurTopic.getGroupedTopicIds().split(",");
//        this.mOptsSize = split.length;
//        ArrayList arrayList = new ArrayList(this.mOptsSize);
//        ArrayList arrayList2 = new ArrayList(this.mOptsSize);
//        for (String str : split) {
//            arrayList.add(PathUtil.reformSuffix(PathUtil.BCZ_HOME + ((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(str))).getWordImage(), ".jpg"));
//            arrayList2.add(((Phrase) phraseTrainingActivity.mPhrases.get(Integer.valueOf(str))).getWord());
//        }
//        this.mImgs.add((ImageView) viewGroup.findViewById(R.id.phrase_training_image_0));
//        this.mImgs.add((ImageView) viewGroup.findViewById(R.id.phrase_training_image_1));
//        this.mImgs.add((ImageView) viewGroup.findViewById(R.id.phrase_training_image_2));
//        this.mWordViews.add((TextView) viewGroup.findViewById(R.id.phrase_training_word_0));
//        this.mWordViews.add((TextView) viewGroup.findViewById(R.id.phrase_training_word_1));
//        this.mWordViews.add((TextView) viewGroup.findViewById(R.id.phrase_training_word_2));
//        this.mSelects.add((Button) viewGroup.findViewById(R.id.phrase_training_select_0));
//        this.mSelects.add((Button) viewGroup.findViewById(R.id.phrase_training_select_1));
//        this.mSelects.add((Button) viewGroup.findViewById(R.id.phrase_training_select_2));
//        if (2 == this.mOptsSize) {
//            ((TextView) this.mWordViews.get(2)).setVisibility(8);
//            ((Button) this.mSelects.get(2)).setVisibility(8);
//            ((ImageView) this.mImgs.get(2)).setVisibility(8);
//        }
//        for (int i2 = 0; i2 < this.mOptsSize; i2++) {
//            ((Button) this.mSelects.get(i2)).setText((CharSequence) arrayList2.get(i2));
//            ((Button) this.mSelects.get(i2)).setTag(Integer.valueOf(i2));
//            ((Button) this.mSelects.get(i2)).setOnClickListener(this);
//            if (i2 != 0) {
//                View view = (View) this.mImgs.get(i2);
//                ViewHelper.m3392d(view, 0.85f);
//                ViewHelper.m3393e(view, 0.85f);
//                ViewHelper.m3389a(view, 0.1f);
//            }
//        }
//        while (true) {
//            int i3 = i;
//            if (i3 < this.mOptsSize) {
//                ImageView imageView = (ImageView) this.mImgs.get(i3);
//                ThemeResUtil.setCardBg(getActivity(), imageView);
//                TextView textView = (TextView) this.mWordViews.get(i3);
//                int size = (int) (((double) arrayList2.size()) * Math.random());
//                String str2 = (String) arrayList.remove(size);
//                String str3 = (String) arrayList2.remove(size);
//                RequestCreator a = Picasso.with((Context) phraseTrainingActivity).load(new File(str2));
//                a.f3707c = true;
//                a.into(imageView, (Callback) null);
//                imageView.setTag(str3);
//                textView.setText(str3);
//                i = i3 + 1;
//            } else {
//                return;
//            }
//        }
//    }
//
//    public void onClick(View view) {
//        Button button = (Button) view;
//        if (button.getText().toString().equals((String) ((ImageView) this.mImgs.get(this.mCurIndex)).getTag())) {
//            if (this.mListener != null) {
//                this.mListener.onResult(true);
//            }
//            Iterator it = this.mSelects.iterator();
//            while (it.hasNext()) {
//                ((Button) it.next()).setTextColor(ThemeUtil.getThemeColorWithAttr(getActivity(), R.attr.color_list_text1));
//            }
//            button.setVisibility(4);
//            button.setOnClickListener(null);
//            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
//            alphaAnimation.setDuration(100);
//            button.startAnimation(alphaAnimation);
//            ((TextView) this.mWordViews.get(this.mCurIndex)).setVisibility(0);
//            AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
//            alphaAnimation2.setDuration(100);
//            ((TextView) this.mWordViews.get(this.mCurIndex)).startAnimation(alphaAnimation2);
//            this.mCurIndex++;
//            if (this.mCurIndex >= this.mOptsSize) {
//                this.mNext.setVisibility(0);
//                return;
//            }
//            ObjectAnimator.m3360a(this.mImgs.get(this.mCurIndex), "scaleX", 0.85f, 1.0f).mo16215a(200).mo16161a();
//            ObjectAnimator.m3360a(this.mImgs.get(this.mCurIndex), "scaleY", 0.85f, 1.0f).mo16215a(200).mo16161a();
//            ObjectAnimator.m3360a(this.mImgs.get(this.mCurIndex), "alpha", 0.1f, 1.0f).mo16215a(200).mo16161a();
//            return;
//        }
//        if (this.mListener != null) {
//            this.mListener.onResult(false);
//        }
//        button.setTextColor(-65536);
//    }
//
//    /* access modifiers changed from: protected */
//    public void next(boolean z) {
//        if (this.mListener != null) {
//            this.mListener.onNext(0, null);
//        }
//    }
//}
