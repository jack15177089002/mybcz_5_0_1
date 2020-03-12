//package com.baicizhan.client.p029fm.data.p030db;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_TOPIC_DATA_ALL.Columns;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_LOCK_SEARCH_HISTORY_TB;
//import java.util.HashMap;
//import java.util.Map;
//
///* renamed from: com.baicizhan.client.fm.data.db.WordInfoRecord */
//public class WordInfoRecord {
//    public static final Map<String, String> COLUMN_MAP;
//    String accent;
//    String cnmean;
//    String example;
//    String word;
//    String wordid;
//
//    static {
//        HashMap hashMap = new HashMap();
//        COLUMN_MAP = hashMap;
//        hashMap.put("wordid", "topic_id");
//        COLUMN_MAP.put("word", "topic_word");
//        COLUMN_MAP.put("accent", Columns.TOPIC_ACCENT);
//        COLUMN_MAP.put(WORD_LOCK_SEARCH_HISTORY_TB.Columns.CNMEAN, Columns.TOPIC_WORD_INTERPRET);
//        COLUMN_MAP.put(WORD_LOCK_SEARCH_HISTORY_TB.Columns.EXAMPLE, Columns.TOPIC_EXAMPLE);
//    }
//
//    public String getWordid() {
//        return this.wordid;
//    }
//
//    public void setWordid(String str) {
//        this.wordid = str;
//    }
//
//    public String getWord() {
//        return this.word;
//    }
//
//    public void setWord(String str) {
//        this.word = str;
//    }
//
//    public String getAccent() {
//        return this.accent;
//    }
//
//    public void setAccent(String str) {
//        this.accent = str;
//    }
//
//    public String getCnmean() {
//        return this.cnmean;
//    }
//
//    public void setCnmean(String str) {
//        this.cnmean = str;
//    }
//
//    public String getExample() {
//        return this.example;
//    }
//
//    public void setExample(String str) {
//        this.example = str;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("WordInfoRecord {");
//        sb.append("wordid:").append(this.wordid).append(", word:").append(this.word).append(", accent:").append(this.accent).append(", cnmean:").append(this.cnmean).append(", example:").append(this.example).append("}");
//        return sb.toString();
//    }
//}
