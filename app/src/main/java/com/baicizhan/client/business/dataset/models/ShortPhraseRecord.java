//package com.baicizhan.client.business.dataset.models;
//
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_COMMON_TB.Columns;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZSHORTPHRASETOPICRESOURCE;
//import java.util.Map;
//
//public class ShortPhraseRecord {
//    public static final Map<String, String> COLUMN_MAP;
//    public String examInfo;
//    public String explain;
//    public String explainAudio;
//
//    /* renamed from: id */
//    public long f2232id;
//    public String imagePath;
//    public String sentence;
//    public String sentence2;
//    public String sentenceAudio;
//    public String sentenceAudio2;
//    public String sentenceTrans;
//    public String sentenceTrans2;
//    public String sentenceWordHighLight;
//    public String sentenceWordHighLight2;
//    public String similarHighLight;
//    public String word;
//    public String wordAudio;
//    public String wordMean;
//    public String wordVariants;
//
//    static {
//        ArrayMap aVar = new ArrayMap();
//        COLUMN_MAP = aVar;
//        aVar.put(Columns.f2234ID, "TOPIC");
//        COLUMN_MAP.put("word", "ZWORD");
//        COLUMN_MAP.put("sentence", "ZSENTENCE");
//        COLUMN_MAP.put("sentence2", ZSHORTPHRASETOPICRESOURCE.Columns.ZSENTENCE2);
//        COLUMN_MAP.put("wordAudio", "ZWORDVIDEO");
//        COLUMN_MAP.put("sentenceAudio", "ZSENTENCEVIDEO");
//        COLUMN_MAP.put("sentenceAudio2", ZSHORTPHRASETOPICRESOURCE.Columns.ZSENTENCEVIDEO2);
//        COLUMN_MAP.put("imagePath", "ZIMAGEPATH");
//        COLUMN_MAP.put("wordMean", "ZWORDMEAN");
//        COLUMN_MAP.put("sentenceTrans", "ZSENTENCE_TRANS");
//        COLUMN_MAP.put("sentenceTrans2", ZSHORTPHRASETOPICRESOURCE.Columns.ZSENTENCE_TRANS2);
//        COLUMN_MAP.put("wordVariants", "ZWORDVARIANTS");
//        COLUMN_MAP.put("similarHighLight", ZSHORTPHRASETOPICRESOURCE.Columns.ZSIMILAR_HIGHLIGHT);
//        COLUMN_MAP.put("explainAudio", ZSHORTPHRASETOPICRESOURCE.Columns.ZEXPLAINCIDEO);
//        COLUMN_MAP.put("explain", ZSHORTPHRASETOPICRESOURCE.Columns.ZEXPLAIN);
//        COLUMN_MAP.put("sentenceWordHighLight", ZSHORTPHRASETOPICRESOURCE.Columns.ZSENTENCEWORDHIGHLIGHT);
//        COLUMN_MAP.put("sentenceWordHighLight2", ZSHORTPHRASETOPICRESOURCE.Columns.ZSENTENCEWORDHIGHLIGHT2);
//        COLUMN_MAP.put("examInfo", ZSHORTPHRASETOPICRESOURCE.Columns.ZEXAMINFO);
//    }
//
//    public String toString() {
//        return "ShortPhraseRecord [id=" + this.f2232id + ", word=" + this.word + ", sentence=" + this.sentence + ", sentence2=" + this.sentence2 + ", wordAudio=" + this.wordAudio + ", sentenceAudio=" + this.sentenceAudio + ", sentenceAudio2=" + this.sentenceAudio2 + ", imagePath=" + this.imagePath + ", wordMean=" + this.wordMean + ", sentenceTrans=" + this.sentenceTrans + ", sentenceTrans2=" + this.sentenceTrans2 + ", wordVariants=" + this.wordVariants + ", similarHighLight=" + this.similarHighLight + ", explainAudio=" + this.explainAudio + ", explain=" + this.explain + ", sentenceWordHighLight=" + this.sentenceWordHighLight + ", sentenceWordHighLight2=" + this.sentenceWordHighLight2 + ", examInfo=" + this.examInfo + "]";
//    }
//}
