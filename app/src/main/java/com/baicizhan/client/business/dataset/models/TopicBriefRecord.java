//package com.baicizhan.client.business.dataset.models;
//
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import com.baicizhan.client.business.dataset.provider.Contracts.TOPICRESOURCE.Columns;
//import java.util.Map;
//
//public class TopicBriefRecord {
//    public static final Map<String, String> COLUMN_MAP_DICTIONARY;
//    public static final Map<String, String> COLUMN_MAP_RESOURCE;
//    public String meanCn;
//    public String phonetic;
//    public int topicId;
//    public String word;
//
//    static {
//        ArrayMap aVar = new ArrayMap();
//        COLUMN_MAP_DICTIONARY = aVar;
//        aVar.put("topicId", "topic_id");
//        COLUMN_MAP_DICTIONARY.put("word", "topic_word");
//        COLUMN_MAP_DICTIONARY.put("meanCn", "mean_cn");
//        COLUMN_MAP_DICTIONARY.put("phonetic", "accent");
//        ArrayMap aVar2 = new ArrayMap();
//        COLUMN_MAP_RESOURCE = aVar2;
//        aVar2.put("topicId", Columns.TOPIC);
//        COLUMN_MAP_RESOURCE.put("word", "word");
//        COLUMN_MAP_RESOURCE.put("meanCn", "mean_cn");
//        COLUMN_MAP_RESOURCE.put("phonetic", "phonetic");
//    }
//
//    public String toString() {
//        return "TopicBriefRecord [topicId=" + this.topicId + ", word=" + this.word + ", meanCn=" + this.meanCn + ", phonetic=" + this.phonetic + "]";
//    }
//}
