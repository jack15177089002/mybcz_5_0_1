//package com.baicizhan.main.plusreview.fragment;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.support.p004v4.app.Fragment;
//import android.support.p008v7.widget.C0244al;
//import android.support.p008v7.widget.C0266bg;
//import android.support.p008v7.widget.LinearLayoutManager;
//import android.support.p008v7.widget.RecyclerView;
//import android.text.SpannableString;
//import android.text.style.ForegroundColorSpan;
//import android.view.KeyEvent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.View.OnKeyListener;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.ZPackUtils;
//import com.baicizhan.client.business.widget.WordErrFeedbackFragment;
//import com.baicizhan.client.framework.audio.AudioPlayer;
//import com.baicizhan.main.plusreview.data.MatchTestCache;
//import com.baicizhan.main.plusreview.data.MatchTestlib.BingSentence;
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
//public class MatchWikiFragment extends Fragment implements OnClickListener {
//    private static final String ARG_INDEX = "index";
//    private TextView mCnmean;
//    private Button mContinue;
//    private ExampleAdapter mExampleAdapter;
//    private RecyclerView mExampleRecycler;
//    /* access modifiers changed from: private */
//    public List<Example> mExamples = new ArrayList();
//    private ImageView mImage;
//    private int mIndex;
//    private View mInfosContainer;
//    /* access modifiers changed from: private */
//    public OnWikiFragmentInteractionListener mListener;
//    private Button mNotifyErr;
//    private AudioPlayer mPlayer;
//    private Word mReviewWord;
//    private TopicRecord mTopicRecord;
//    private TextView mWord;
//
//    class Example {
//        String cnexample;
//        SpannableString example;
//
//        private Example() {
//        }
//    }
//
//    class ExampleAdapter extends C0244al<ExampleHolder> {
//        private ExampleAdapter() {
//        }
//
//        public int getItemCount() {
//            return MatchWikiFragment.this.mExamples.size();
//        }
//
//        public void onBindViewHolder(ExampleHolder exampleHolder, int i) {
//            Example example = (Example) MatchWikiFragment.this.mExamples.get(i);
//            exampleHolder.mExample.setText(example.example);
//            exampleHolder.mCnexample.setText(example.cnexample);
//        }
//
//        public ExampleHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//            return new ExampleHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.plusreview_match_example_item, viewGroup, false));
//        }
//    }
//
//    class ExampleHolder extends C0266bg {
//        /* access modifiers changed from: private */
//        public TextView mCnexample;
//        /* access modifiers changed from: private */
//        public TextView mExample;
//
//        public ExampleHolder(View view) {
//            super(view);
//            this.mExample = (TextView) view.findViewById(R.id.plusreview_match_exam);
//            this.mCnexample = (TextView) view.findViewById(R.id.plusreview_match_cnexam);
//        }
//    }
//
//    public interface OnWikiFragmentInteractionListener {
//        void onContinue(Fragment fragment);
//
//        void onWikiAttach();
//
//        void onWikiDetach();
//    }
//
//    public static MatchWikiFragment newInstance(int i) {
//        MatchWikiFragment matchWikiFragment = new MatchWikiFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt(ARG_INDEX, i);
//        matchWikiFragment.setArguments(bundle);
//        return matchWikiFragment;
//    }
//
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        this.mPlayer = new AudioPlayer(activity);
//        try {
//            this.mListener = (OnWikiFragmentInteractionListener) activity;
//            this.mListener.onWikiAttach();
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    public void onCreate(Bundle bundle) {
//        super.onCreate(bundle);
//        this.mIndex = getArguments() != null ? getArguments().getInt(ARG_INDEX) : 0;
//        this.mReviewWord = (Word) MatchTestCache.getCache().getTestlib().getReview_words().get(this.mIndex);
//        this.mTopicRecord = MatchTestCache.getCache().getTopicRecord();
//    }
//
//    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
//        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.plusreview_fragment_match_wiki, viewGroup, false);
//        initValues();
//        initViews(viewGroup2);
//        return viewGroup2;
//    }
//
//    private void initViews(ViewGroup viewGroup) {
//        this.mInfosContainer = viewGroup.findViewById(R.id.plusreview_match_wiki_word_infos);
//        this.mInfosContainer.setOnClickListener(this);
//        this.mWord = (TextView) viewGroup.findViewById(R.id.plusreview_match_wiki_word);
//        this.mWord.setText(this.mTopicRecord.word);
//        this.mWord.setOnClickListener(this);
//        this.mCnmean = (TextView) viewGroup.findViewById(R.id.plusreview_match_wiki_cnmean);
//        this.mCnmean.setText(this.mTopicRecord.wordMean);
//        this.mCnmean.setOnClickListener(this);
//        this.mImage = (ImageView) viewGroup.findViewById(R.id.plusreview_match_wiki_image);
//        this.mImage.setOnClickListener(this);
//        RequestCreator b = ZPackUtils.loadImageCompat(this.mTopicRecord, this.mTopicRecord.imagePath).error(R.drawable.image_broke_normal_default);
//        b.f3707c = true;
//        b.into(this.mImage, (Callback) null);
//        this.mNotifyErr = (Button) viewGroup.findViewById(R.id.plusreview_match_wiki_notify_err);
//        this.mNotifyErr.setOnClickListener(this);
//        this.mContinue = (Button) viewGroup.findViewById(R.id.plusreview_match_wiki_continue);
//        this.mContinue.setOnClickListener(this);
//        this.mExampleAdapter = new ExampleAdapter();
//        this.mExampleRecycler = (RecyclerView) viewGroup.findViewById(R.id.plusreview_match_wiki_exams);
//        RecyclerView recyclerView = this.mExampleRecycler;
//        getActivity();
//        recyclerView.setLayoutManager(new LinearLayoutManager());
//        this.mExampleRecycler.setAdapter(this.mExampleAdapter);
//    }
//
//    private void initValues() {
//        int indexOf;
//        List arr_right_options = this.mReviewWord.getArr_right_options();
//        Collections.shuffle(arr_right_options);
//        int size = arr_right_options.size();
//        for (int i = 0; i < size; i++) {
//            for (BingSentence bingSentence : ((RightOption) arr_right_options.get(i)).getArr_bing_sentences()) {
//                Example example = new Example();
//                example.cnexample = bingSentence.getSentence_trans();
//                String sentence = bingSentence.getSentence();
//                ArrayList<String> arrayList = new ArrayList<>();
//                ArrayList arrayList2 = new ArrayList();
//                do {
//                    int indexOf2 = sentence.indexOf("<i>");
//                    indexOf = sentence.indexOf("</i>");
//                    if (indexOf2 < 0 || indexOf < 0) {
//                        break;
//                    }
//                    String substring = sentence.substring(indexOf2 + 3, indexOf);
//                    arrayList.add(substring);
//                    sentence = sentence.replaceFirst("<i>" + substring + "</i>", substring);
//                    arrayList2.add(Integer.valueOf(indexOf2));
//                    if (indexOf2 < 0) {
//                        break;
//                    }
//                } while (indexOf >= 0);
//                example.example = new SpannableString(sentence);
//                int i2 = 0;
//                for (String str : arrayList) {
//                    int intValue = ((Integer) arrayList2.get(i2)).intValue();
//                    if (intValue >= 0) {
//                        example.example.setSpan(new ForegroundColorSpan(ThemeUtil.getThemeColorWithAttr(getActivity(), R.attr.color_progress)), intValue, str.length() + intValue, 34);
//                    }
//                    i2++;
//                }
//                this.mExamples.add(example);
//            }
//        }
//    }
//
//    public void onActivityCreated(Bundle bundle) {
//        super.onActivityCreated(bundle);
//        getView().setFocusableInTouchMode(true);
//        getView().requestFocus();
//        getView().setOnKeyListener(new OnKeyListener() {
//            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//                if (keyEvent.getAction() != 0 || 4 != i || MatchWikiFragment.this.mListener == null) {
//                    return false;
//                }
//                MatchWikiFragment.this.mListener.onContinue(MatchWikiFragment.this);
//                return true;
//            }
//        });
//    }
//
//    public void onDetach() {
//        super.onDetach();
//        if (this.mListener != null) {
//            this.mListener.onWikiDetach();
//        }
//        this.mListener = null;
//        this.mPlayer.destroy();
//    }
//
//    public void onClick(View view) {
//        if (view == this.mContinue) {
//            if (this.mListener != null) {
//                this.mListener.onContinue(this);
//            }
//        } else if (view == this.mNotifyErr) {
//            WordErrFeedbackFragment.Word word = new WordErrFeedbackFragment.Word();
//            word.setId(this.mTopicRecord.topicId);
//            word.setWord(this.mTopicRecord.word);
//            WordErrFeedbackFragment.newInstance(word).show(getActivity().getSupportFragmentManager(), "feedback");
//        } else {
//            ViewHelper.m3390b(this.mWord, (float) (this.mWord.getWidth() / 2));
//            ViewHelper.m3391c(this.mWord, (float) (this.mWord.getHeight() / 2));
//            ObjectAnimator.m3360a(this.mWord, "scaleX", 1.0f, 1.2f, 1.0f).mo16215a(300).mo16161a();
//            ObjectAnimator.m3360a(this.mWord, "scaleY", 1.0f, 1.2f, 1.0f).mo16215a(300).mo16161a();
//            ZPackUtils.loadAudioCompat(this.mPlayer, this.mTopicRecord, this.mTopicRecord.wordAudio);
//        }
//    }
//}
