//package com.baicizhan.main.fragment;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.content.res.ColorStateList;
//import android.graphics.Color;
//import android.graphics.drawable.GradientDrawable;
//import android.text.SpannableString;
//import android.text.TextUtils;
//import android.text.style.ForegroundColorSpan;
//import android.util.Pair;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup.LayoutParams;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.baicizhan.client.business.color_sentence.StringLCS;
//import com.baicizhan.client.business.dataset.models.SimilarWordRecord;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.managers.LearnRecordManager;
//import com.baicizhan.client.business.stats.operation.OperationStats;
//import com.baicizhan.client.business.util.ColorStateListUtils;
//import com.baicizhan.client.business.util.CustomFont;
//import com.baicizhan.client.business.util.ThemeResUtil;
//import com.baicizhan.client.business.util.ThemeUtil;
//import com.baicizhan.client.business.util.TopicTextRenderHelper;
//import com.baicizhan.main.stats.study.StudyStats;
//import com.baicizhan.main.utils.GuideFlags;
//import com.baicizhan.online.bs_words.BBSimilarWordVote;
//import com.handmark.pulltorefresh.library.p057a.C1604j;
//import com.jiongji.andriod.card.R;
//
//public class SimilarWordDialog extends Dialog implements OnClickListener {
//    private static final String TAG = SimilarWordDialog.class.getSimpleName();
//    private View mConfuseComment;
//    private TextView mConfuseNo;
//    private TextView mConfuseYes;
//    private int mHighlightColor;
//    private boolean mIsPortrait;
//    private TopicRecord mMainTopic;
//    private SimilarWordRecord mSimilarRecord;
//    private TopicRecord mSimilarTopic;
//
//    public SimilarWordDialog(Context context, boolean z, SimilarWordRecord similarWordRecord, TopicRecord topicRecord, TopicRecord topicRecord2) {
//        super(context, 16973834);
//        getWindow().setLayout(-1, -1);
//        getWindow().setFlags(1024, 1024);
//        getWindow().setBackgroundDrawableResource(17301673);
//        this.mIsPortrait = z;
//        this.mMainTopic = topicRecord;
//        this.mSimilarRecord = similarWordRecord;
//        this.mSimilarTopic = topicRecord2;
//        createView();
//    }
//
//    public void createView() {
//        View inflate;
//        LayoutInflater from = LayoutInflater.from(getContext());
//        if (this.mIsPortrait) {
//            inflate = from.inflate(R.layout.fragment_wiki_diff_portrait, null, false);
//        } else {
//            inflate = from.inflate(R.layout.fragment_wiki_diff, null, false);
//        }
//        setContentView(inflate, new LayoutParams(-1, -1));
//        ThemeResUtil.setBackgroundShape(getContext(), inflate.findViewById(R.id.panel), R.attr.color_friend_bg, 10.0f);
//        this.mHighlightColor = ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_text_blue);
//        Pair highLight = highLight(this.mMainTopic.word, this.mSimilarTopic.word);
//        initTopic(inflate.findViewById(R.id.topic1), this.mMainTopic, (SpannableString) highLight.first);
//        initTopic(inflate.findViewById(R.id.topic2), this.mSimilarTopic, (SpannableString) highLight.second);
//        TextView textView = (TextView) inflate.findViewById(R.id.tips);
//        ImageView imageView = (ImageView) inflate.findViewById(R.id.tips_label);
//        if (TextUtils.isEmpty(this.mSimilarRecord.tips)) {
//            imageView.setVisibility(4);
//            textView.setVisibility(4);
//        } else {
//            imageView.setVisibility(0);
//            textView.setVisibility(0);
//            GradientDrawable gradientDrawable = new GradientDrawable();
//            int themeColorWithAttr = ThemeUtil.getThemeColorWithAttr(getContext(), R.attr.color_welcome_text);
//            int argb = Color.argb(128, Color.red(themeColorWithAttr), Color.green(themeColorWithAttr), Color.blue(themeColorWithAttr));
//            gradientDrawable.setShape(0);
//            gradientDrawable.setStroke(1, argb, 8.0f, 8.0f);
//            C1604j.m3631a(textView, gradientDrawable);
//        }
//        findViewById(R.id.close).setOnClickListener(this);
//        ColorStateList simpleThemeColorStateListWithAttr = ColorStateListUtils.getSimpleThemeColorStateListWithAttr(getContext(), R.attr.color_checkin_text, R.attr.color_common_white);
//        this.mConfuseYes = (TextView) findViewById(R.id.confused_yes);
//        this.mConfuseYes.setOnClickListener(this);
//        this.mConfuseYes.setTextColor(simpleThemeColorStateListWithAttr);
//        this.mConfuseNo = (TextView) findViewById(R.id.confused_no);
//        this.mConfuseNo.setOnClickListener(this);
//        this.mConfuseNo.setTextColor(simpleThemeColorStateListWithAttr);
//        this.mConfuseComment = findViewById(R.id.confuse_comment);
//    }
//
//    private Pair<SpannableString, SpannableString> highLight(String str, String str2) {
//        StringLCS stringLCS = new StringLCS();
//        Pair<SpannableString, SpannableString> pair = new Pair<>(new SpannableString(str), new SpannableString(str2));
//        int lcs = stringLCS.lcs(str, str2);
//        if (((float) lcs) >= ((float) str.length()) * 0.5f || ((float) lcs) >= ((float) str2.length()) * 0.5f) {
//            int[] posA = stringLCS.getPosA();
//            int[] posB = stringLCS.getPosB();
//            int i = 1;
//            for (int i2 = 1; i2 < posA.length; i2++) {
//                if (posA[i2] == posA[i2 - 1] + 1 && posB[i2] == posB[i2 - 1] + 1) {
//                    i++;
//                } else if (i > 1) {
//                    setHighlightSpan((SpannableString) pair.first, posA[i2 - i], posA[i2 - 1] + 1, this.mHighlightColor);
//                    setHighlightSpan((SpannableString) pair.second, posB[i2 - i], posB[i2 - 1] + 1, this.mHighlightColor);
//                    i = 1;
//                }
//            }
//            if (i > 1) {
//                int length = posA.length;
//                setHighlightSpan((SpannableString) pair.first, posA[length - i], posA[length - 1] + 1, this.mHighlightColor);
//                setHighlightSpan((SpannableString) pair.second, posB[length - i], posB[length - 1] + 1, this.mHighlightColor);
//            }
//        }
//        return pair;
//    }
//
//    private void setHighlightSpan(SpannableString spannableString, int i, int i2, int i3) {
//        spannableString.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
//    }
//
//    private void initTopic(View view, TopicRecord topicRecord, SpannableString spannableString) {
//        ((TextView) view.findViewById(R.id.topic_word)).setText(spannableString);
//        TextView textView = (TextView) view.findViewById(R.id.topic_phonetic);
//        textView.setText(topicRecord.phonetic);
//        CustomFont.setFont(textView, 3);
//        ((TextView) view.findViewById(R.id.topic_mean_cn)).setText(topicRecord.wordMean);
//        TopicTextRenderHelper.showClickableHighlightSentence((TextView) view.findViewById(R.id.topic_sentence), topicRecord.word, topicRecord.sentence);
//    }
//
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.close /*2131296297*/:
//                dismiss();
//                return;
//            case R.id.confused_yes /*2131296667*/:
//                OperationStats.statSimilaYes();
//                LearnRecordManager.getInstance().markLocalReviewable(this.mMainTopic.topicId);
//                if (GuideFlags.guideEnabled(1024)) {
//                    this.mConfuseComment.setVisibility(0);
//                    this.mConfuseYes.setVisibility(8);
//                    this.mConfuseNo.setVisibility(8);
//                    GuideFlags.disableGuide(1024);
//                    return;
//                }
//                stat(true);
//                dismiss();
//                return;
//            case R.id.confused_no /*2131296668*/:
//                OperationStats.statSimilaNo();
//                stat(false);
//                dismiss();
//                return;
//            default:
//                return;
//        }
//    }
//
//    private void stat(boolean z) {
//        BBSimilarWordVote bBSimilarWordVote = new BBSimilarWordVote();
//        bBSimilarWordVote.setTopic_id(this.mMainTopic.topicId);
//        bBSimilarWordVote.setBook_id(this.mSimilarRecord.similar_word_book_id);
//        bBSimilarWordVote.setSimilar_word_id(this.mSimilarTopic.topicId);
//        bBSimilarWordVote.setIs_similar(z);
//        StudyStats.getsInstance().fillSimilarWordVote(bBSimilarWordVote);
//    }
//}
