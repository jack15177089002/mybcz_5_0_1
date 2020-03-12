package com.baicizhan.client.business.dataset.models;

//import com.baicizhan.online.bs_words.BBSimilarWordInfo;
//import p012ch.qos.logback.core.CoreConstants;

public class SimilarWordRecord {
    public int similar_word_book_id;
    public int similar_word_id;
    public String tips;
    public int topic_id;
    public String word;

//    public static SimilarWordRecord fromBBSimilarWordInfo(BBSimilarWordInfo bBSimilarWordInfo) {
//        SimilarWordRecord similarWordRecord = new SimilarWordRecord();
//        similarWordRecord.topic_id = bBSimilarWordInfo.getTopic_id();
//        similarWordRecord.similar_word_book_id = bBSimilarWordInfo.getSimilar_word_book_id();
//        similarWordRecord.similar_word_id = bBSimilarWordInfo.getSimilar_word_id();
//        similarWordRecord.tips = bBSimilarWordInfo.getTips();
//        similarWordRecord.word = bBSimilarWordInfo.getWord();
//        return similarWordRecord;
//    }

    public String toString() {
//        return "TopicSimilarInfoRecord{similar_word_book_id=" + this.similar_word_book_id + ", topic_id=" + this.topic_id + ", similar_word_id=" + this.similar_word_id + ", tips='" + this.tips + CoreConstants.SINGLE_QUOTE_CHAR + ", word='" + this.word + CoreConstants.SINGLE_QUOTE_CHAR + CoreConstants.CURLY_RIGHT;
        return null;
    }
}
