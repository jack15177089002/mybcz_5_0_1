package com.baicizhan.client.business.dataset.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
import android.text.TextUtils;
//import com.baicizhan.client.business.dataset.provider.Contracts.TOPICRESOURCE.Columns;
//import com.baicizhan.online.bs_words.BBTopicAssetV2;
import com.google.gson.annotations.SerializedName;//import com.p020b.p021a.p022a.SerializedName;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//import p012ch.qos.logback.core.CoreConstants;

public class TopicRecord implements Parcelable {
    public static final Map<String, String> COLUMN_MAP;
    public static final Creator<TopicRecord> CREATOR = new Creator<TopicRecord>() {
        public final TopicRecord createFromParcel(Parcel parcel) {
            return new TopicRecord(parcel);
        }

        public final TopicRecord[] newArray(int i) {
            return new TopicRecord[i];
        }
    };
    public int bookId;//value
    @SerializedName(value = "deformation_desc")
    public String deformationDesc;
    @SerializedName(value = "deformation_img")
    public String deformationImagePath;
    @SerializedName(value = "image_file")
    public String imagePath;
    @SerializedName(value = "accent")
    public String phonetic;
    @SerializedName(value = "sentence")
    public String sentence;
    @SerializedName(value = "sentence_audio")
    public String sentenceAudio;
    @SerializedName(value = "sentence_trans")
    public String sentenceTrans;
    @SerializedName(value = "short_phrase")
    public String shortPhrase;
    @SerializedName(value = "topic_id")
    public int topicId;
    public String updateFlagMD5;
    @SerializedName(value = "word")
    public String word;
    @SerializedName(value = "word_audio")
    public String wordAudio;
    @SerializedName(value = "word_etyma")
    public String wordEtyma;
    @SerializedName(value = "mean_cn")
    public String wordMean;
    @SerializedName(value = "mean_en")
    public String wordMeanEn;
    public transient Set<String> wordVariantSet = null;
    @SerializedName(value = "word_variants")
    public String wordVariants;
    public String zpkPath;

    static {
        ArrayMap aVar = new ArrayMap();
        COLUMN_MAP = aVar;
//        aVar.put("topicId", Columns.TOPIC);
        COLUMN_MAP.put("word", "word");
        COLUMN_MAP.put("wordVariants", "word_variants");
        COLUMN_MAP.put("wordAudio", "word_audio");
        COLUMN_MAP.put("shortPhrase", "short_phrase");
        COLUMN_MAP.put("sentence", "sentence");
        COLUMN_MAP.put("sentenceAudio", "sentence_audio");
        COLUMN_MAP.put("sentenceTrans", "sentence_trans");
        COLUMN_MAP.put("imagePath", "image");
        COLUMN_MAP.put("phonetic", "phonetic");
        COLUMN_MAP.put("wordMean", "mean_cn");
        COLUMN_MAP.put("wordMeanEn", "mean_en");
        COLUMN_MAP.put("wordEtyma", "etyma");
        COLUMN_MAP.put("deformationImagePath", "deformation_image");
        COLUMN_MAP.put("zpkPath", "zpk_path");
//        COLUMN_MAP.put("updateFlagMD5", Columns.UPDATE_FLAG_MD5);
    }

    public String toString() {
//        return "TopicRecord{deformationDesc='" + this.deformationDesc + CoreConstants.SINGLE_QUOTE_CHAR + ", topicId=" + this.topicId + ", word='" + this.word + CoreConstants.SINGLE_QUOTE_CHAR + ", wordMean='" + this.wordMean + CoreConstants.SINGLE_QUOTE_CHAR + ", wordVariants='" + this.wordVariants + CoreConstants.SINGLE_QUOTE_CHAR + ", phonetic='" + this.phonetic + CoreConstants.SINGLE_QUOTE_CHAR + ", sentence='" + this.sentence + CoreConstants.SINGLE_QUOTE_CHAR + ", wordAudio='" + this.wordAudio + CoreConstants.SINGLE_QUOTE_CHAR + ", sentenceAudio='" + this.sentenceAudio + CoreConstants.SINGLE_QUOTE_CHAR + ", imagePath='" + this.imagePath + CoreConstants.SINGLE_QUOTE_CHAR + ", wordMeanEn='" + this.wordMeanEn + CoreConstants.SINGLE_QUOTE_CHAR + ", shortPhrase='" + this.shortPhrase + CoreConstants.SINGLE_QUOTE_CHAR + ", wordEtyma='" + this.wordEtyma + CoreConstants.SINGLE_QUOTE_CHAR + ", deformationImagePath='" + this.deformationImagePath + CoreConstants.SINGLE_QUOTE_CHAR + ", sentenceTrans='" + this.sentenceTrans + CoreConstants.SINGLE_QUOTE_CHAR + ", updateFlagMD5='" + this.updateFlagMD5 + CoreConstants.SINGLE_QUOTE_CHAR + ", zpkPath='" + this.zpkPath + CoreConstants.SINGLE_QUOTE_CHAR + ", wordVariantSet=" + this.wordVariantSet + CoreConstants.CURLY_RIGHT;
        return null;
    }

    public void collateVariants() {
        if (this.wordVariantSet == null) {
            if (!TextUtils.isEmpty(this.wordVariants)) {
                this.wordVariantSet = new HashSet();
                for (String trim : TextUtils.split(this.wordVariants, ",")) {
                    String trim2 = trim.trim();
                    if (trim2.length() > 0) {
                        this.wordVariantSet.add(trim2);
                    }
                }
                return;
            }
            this.wordVariantSet = Collections.emptySet();
        }
    }

    public TopicRecord() {
    }

    public TopicRecord(Parcel parcel) {
        this.topicId = parcel.readInt();
        this.word = parcel.readString();
        this.wordMean = parcel.readString();
        this.wordVariants = parcel.readString();
        this.phonetic = parcel.readString();
        this.sentence = parcel.readString();
        this.wordAudio = parcel.readString();
        this.sentenceAudio = parcel.readString();
        this.imagePath = parcel.readString();
        this.wordMeanEn = parcel.readString();
        this.shortPhrase = parcel.readString();
        this.wordEtyma = parcel.readString();
        this.deformationImagePath = parcel.readString();
        this.deformationDesc = parcel.readString();
        this.sentenceTrans = parcel.readString();
        this.zpkPath = parcel.readString();
        this.updateFlagMD5 = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.topicId);
        parcel.writeString(this.word);
        parcel.writeString(this.wordMean);
        parcel.writeString(this.wordVariants);
        parcel.writeString(this.phonetic);
        parcel.writeString(this.sentence);
        parcel.writeString(this.wordAudio);
        parcel.writeString(this.sentenceAudio);
        parcel.writeString(this.imagePath);
        parcel.writeString(this.wordMeanEn);
        parcel.writeString(this.shortPhrase);
        parcel.writeString(this.wordEtyma);
        parcel.writeString(this.deformationImagePath);
        parcel.writeString(this.deformationDesc);
        parcel.writeString(this.sentenceTrans);
        parcel.writeString(this.zpkPath);
        parcel.writeString(this.updateFlagMD5);
    }

//    public static TopicRecord fromAssetInfo(BBTopicAssetV2 bBTopicAssetV2) {
//        TopicRecord topicRecord = new TopicRecord();
//        topicRecord.topicId = bBTopicAssetV2.getTopic_id();
//        topicRecord.word = bBTopicAssetV2.getWord();
//        topicRecord.wordMean = bBTopicAssetV2.getMean_cn();
//        topicRecord.wordVariants = bBTopicAssetV2.getWord_variants();
//        topicRecord.phonetic = bBTopicAssetV2.getAccent();
//        topicRecord.sentence = bBTopicAssetV2.getSentence();
//        topicRecord.wordAudio = bBTopicAssetV2.getWord_audio();
//        topicRecord.sentenceAudio = bBTopicAssetV2.getSentence_audio();
//        topicRecord.imagePath = bBTopicAssetV2.getImage_file();
//        topicRecord.wordMeanEn = bBTopicAssetV2.getMean_en();
//        topicRecord.shortPhrase = bBTopicAssetV2.getShort_phrase();
//        topicRecord.wordEtyma = bBTopicAssetV2.getWord_etyma();
//        topicRecord.deformationImagePath = bBTopicAssetV2.getDeformation_img();
//        topicRecord.deformationDesc = bBTopicAssetV2.getDeformation_desc();
//        topicRecord.sentenceTrans = bBTopicAssetV2.getSentence_trans();
//        topicRecord.zpkPath = bBTopicAssetV2.getAsset_pack_path();
//        topicRecord.updateFlagMD5 = bBTopicAssetV2.getUpdate_flag_md5();
//        return topicRecord;
//    }
}
