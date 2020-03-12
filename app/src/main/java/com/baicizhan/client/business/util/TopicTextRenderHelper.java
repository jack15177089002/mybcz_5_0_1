//package com.baicizhan.client.business.util;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.res.ColorStateList;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.text.SpannableString;
//import android.text.TextUtils;
//import android.text.style.ForegroundColorSpan;
//import android.text.style.TextAppearanceSpan;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.PopupWindow;
//import android.widget.TextView;
////import com.jiongji.andriod.card.R;//import com.baicizhan.client.business.C0574R;
//import com.baicizhan.client.business.color_sentence.ColorSentence;
//import com.baicizhan.client.business.color_sentence.ColorSentence.Segment;
//import com.baicizhan.client.business.dataset.helpers.MiscRecordHelper;
//import com.baicizhan.client.business.dataset.models.TopicBriefRecord;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.widget.LinkTouchMovementMethod;
//import com.baicizhan.client.business.widget.TouchableSpan;
//import com.jiongji.andriod.card.R;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Locale;
//
//public class TopicTextRenderHelper {
//
//    public interface OnWordClickListener {
//        void onClick(String str);
//    }
//
//    public interface SpanFactory {
//        Object create();
//    }
//
//    public class TextStyleSpanFactory implements SpanFactory {
//        private int textColor = 0;
//        private int textSize = 0;
//
//        public void setTextSize(int i) {
//            this.textSize = i;
//        }
//
//        public void setTextColor(int i) {
//            this.textColor = i;
//        }
//
//        public Object create() {
//            if (this.textSize == 0) {
//                return new ForegroundColorSpan(this.textColor);
//            }
//            return new TextAppearanceSpan(null, 0, this.textSize, ColorStateList.valueOf(this.textColor), null);
//        }
//    }
//
//    public class TopicTextRender {
//        private boolean mClickable = false;
//        private OnWordClickListener mHighlightClickListener = null;
//        private int mHighlightColor;
//        private String mHighlightKey;
//        List<Segment> mHighlightSegments = null;
//        private int mHighlightSize;
//        private boolean mSkipClickHighlighted = true;
//        private String mText;
//
//        public static TopicTextRender with(String str) {
//            return new TopicTextRender(str);
//        }
//
//        private TopicTextRender(String str) {
//            this.mText = str;
//        }
//
//        public TopicTextRender highlightColor(int i) {
//            this.mHighlightColor = i;
//            return this;
//        }
//
//        public TopicTextRender highlightSize(int i) {
//            this.mHighlightSize = i;
//            return this;
//        }
//
//        public TopicTextRender highlightKey(String str) {
//            this.mHighlightKey = str;
//            return this;
//        }
//
//        public TopicTextRender addHighlightSegment(Segment segment) {
//            if (this.mHighlightSegments == null) {
//                this.mHighlightSegments = new ArrayList(1);
//            }
//            this.mHighlightSegments.add(segment);
//            return this;
//        }
//
//        public TopicTextRender clickable() {
//            this.mClickable = true;
//            return this;
//        }
//
//        public TopicTextRender skipClickHighlighted() {
//            this.mSkipClickHighlighted = true;
//            return this;
//        }
//
//        public TopicTextRender setHighlightClickListener(OnWordClickListener onWordClickListener) {
//            this.mHighlightClickListener = onWordClickListener;
//            return this;
//        }
//
//        public void into(final TextView textView) {
//            boolean z;
//            SpannableString spannableString = new SpannableString(this.mText);
//            try {
//                if (!TextUtils.isEmpty(this.mHighlightKey)) {
//                    List<Segment> segments = ColorSentence.getSegments(this.mText, this.mHighlightKey, null);
//                    if (this.mHighlightSegments == null || segments == null) {
//                        this.mHighlightSegments = segments;
//                    } else {
//                        this.mHighlightSegments.addAll(segments);
//                    }
//                }
//                if (this.mHighlightSegments != null && this.mHighlightSegments.size() > 0) {
//                    TextStyleSpanFactory textStyleSpanFactory = new TextStyleSpanFactory();
//                    textStyleSpanFactory.setTextColor(this.mHighlightColor);
//                    textStyleSpanFactory.setTextSize(this.mHighlightSize);
//                    for (Segment segment : this.mHighlightSegments) {
//                        spannableString.setSpan(textStyleSpanFactory.create(), segment.start, segment.end, 33);
//                    }
//                }
//                if (this.mClickable) {
//                    final Context context = textView.getContext();
//                    C06371 r3 = new OnWordClickListener() {
//                        public void onClick(String str) {
//                            TopicBriefRecord topicBriefRecordByWord = MiscRecordHelper.getTopicBriefRecordByWord(context, str);
//                            if (topicBriefRecordByWord != null) {
//                                TopicTextRenderHelper.popupWordMeanWindow(context, textView, topicBriefRecordByWord);
//                            }
//                        }
//                    };
//                    for (HighLightMatcher.Segment segment2 : HighLightMatcher.splitEnglishWords(this.mText)) {
//                        int start = segment2.getStart();
//                        int end = segment2.getEnd();
//                        if (this.mSkipClickHighlighted && this.mHighlightSegments != null) {
//                            Iterator it = this.mHighlightSegments.iterator();
//                            while (true) {
//                                if (!it.hasNext()) {
//                                    break;
//                                }
//                                Segment segment3 = (Segment) it.next();
//                                if (segment3.start <= start && segment3.end >= end) {
//                                    z = true;
//                                    break;
//                                }
//                            }
//                        }
//                        z = false;
//                        if (!z) {
//                            spannableString.setSpan(new WordClickableSpan(r3, start, end), start, end, 33);
//                        } else if (this.mHighlightClickListener != null) {
//                            spannableString.setSpan(new WordClickableSpan(this.mHighlightClickListener, start, end), start, end, 33);
//                        }
//                    }
//                    textView.setMovementMethod(LinkTouchMovementMethod.getInstance());
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            textView.setText(spannableString);
//        }
//    }
//
//    class WordClickableSpan extends TouchableSpan {
//        int end;
//        OnWordClickListener listener;
//        int start;
//
//        public WordClickableSpan(OnWordClickListener onWordClickListener, int i, int i2) {
//            super(Color.parseColor("#6633b5e5"));
//            this.listener = onWordClickListener;
//            this.start = i;
//            this.end = i2;
//        }
//
//        public void onClick(View view) {
//            String charSequence = ((TextView) view).getText().subSequence(this.start, this.end).toString();
//            if (this.listener != null) {
//                this.listener.onClick(charSequence);
//            }
//        }
//    }
//
//    public static void showClickableHighlightSentence(TextView textView, String str, String str2) {
//        TopicTextRender.with(str2).highlightColor(ThemeUtil.getThemeColorWithAttr(textView.getContext(), R.attr.color_text_blue)).highlightKey(str).clickable().skipClickHighlighted().into(textView);
//    }
//
//    public static void showWordMeanEn(TextView textView, TopicRecord topicRecord) {
//        TopicTextRender.with(topicRecord.word + " = " + topicRecord.wordMeanEn).addHighlightSegment(new Segment(0, topicRecord.word.length())).highlightColor(ThemeUtil.getThemeColorWithAttr(textView.getContext(), R.attr.color_text_blue)).clickable().skipClickHighlighted().into(textView);
//    }
//
//    public static void showWordMeanCn(TextView textView, TopicRecord topicRecord) {
//        TopicTextRender.with(topicRecord.word + " = " + topicRecord.wordMean).addHighlightSegment(new Segment(0, topicRecord.word.length())).highlightColor(ThemeUtil.getThemeColorWithAttr(textView.getContext(), R.attr.color_text_blue)).into(textView);
//    }
//
//    @SuppressLint({"InflateParams"})
//    public static void popupWordMeanWindow(Context context, View view, TopicBriefRecord topicBriefRecord) {
//        View inflate = LayoutInflater.from(context).inflate(R.layout.word_translate_window, null, false);
//        ((TextView) inflate.findViewById(R.id.word)).setText(topicBriefRecord.word);
//        TextView textView = (TextView) inflate.findViewById(R.id.phonetic);
//        textView.setText(topicBriefRecord.phonetic);
//        CustomFont.setFont(textView, 3);
//        ((TextView) inflate.findViewById(R.id.mean)).setText(topicBriefRecord.meanCn);
//        final PopupWindow popupWindow = new PopupWindow(inflate, -1, -2);
//        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
//        popupWindow.setFocusable(true);
//        popupWindow.setTouchable(true);
//        popupWindow.setOutsideTouchable(true);
//        popupWindow.setAnimationStyle(R.style.Animations_fade_in_out);
//        popupWindow.showAtLocation(view, 48, 0, 0);
//        inflate.setOnClickListener(new OnClickListener() {
//            public final void onClick(View view) {
//                popupWindow.dismiss();
//            }
//        });
//    }
//
//    public static int[] getFirstMatchWordBorder(TopicRecord topicRecord) {
//        ArrayList<String> arrayList = new ArrayList<>(2);
//        if (!TextUtils.isEmpty(topicRecord.word)) {
//            arrayList.add(topicRecord.word.toLowerCase(Locale.US));
//        }
//        if (!TextUtils.isEmpty(topicRecord.wordVariants)) {
//            try {
//                for (String trim : TextUtils.split(topicRecord.wordVariants, ",")) {
//                    arrayList.add(trim.trim().toLowerCase(Locale.US));
//                }
//            } catch (Exception e) {
//                Log.e("temp", Log.getStackTraceString(e));
//            }
//        }
//        String lowerCase = topicRecord.sentence.toLowerCase(Locale.US);
//        for (String str : arrayList) {
//            if (lowerCase.length() > 0) {
//                int indexOf = lowerCase.indexOf(str, 0);
//                if (indexOf != -1) {
//                    return new int[]{indexOf, indexOf + str.length()};
//                }
//            }
//        }
//        if (!isSerialPhrase(topicRecord.word)) {
//            return null;
//        }
//        List segments = ColorSentence.getSegments(topicRecord.sentence, topicRecord.word, null);
//        if (segments == null || segments.isEmpty()) {
//            return null;
//        }
//        return new int[]{((Segment) segments.get(0)).start, ((Segment) segments.get(segments.size() - 1)).end};
//    }
//
//    private static boolean isSerialPhrase(String str) {
//        char[] charArray;
//        if (TextUtils.isEmpty(str)) {
//            return false;
//        }
//        for (char c : str.replaceAll(" ", "").toLowerCase(Locale.US).toCharArray()) {
//            if (c < 'a' || c > 'z') {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static int[][] getMatchWordBorders(TopicRecord topicRecord) {
//        int[][] iArr = null;
//        List<Segment> segments = ColorSentence.getSegments(topicRecord.sentence, topicRecord.word, null);
//        if (segments != null && !segments.isEmpty()) {
//            iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{segments.size(), 2});
//            int i = 0;
//            for (Segment segment : segments) {
//                iArr[i][0] = segment.start;
//                iArr[i][1] = segment.end;
//                i++;
//            }
//        }
//        return iArr;
//    }
//}
