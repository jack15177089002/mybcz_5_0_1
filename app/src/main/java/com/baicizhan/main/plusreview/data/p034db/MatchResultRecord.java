//package com.baicizhan.main.plusreview.data.p034db;
//
//import java.util.HashMap;
//import java.util.Map;
//
///* renamed from: com.baicizhan.main.plusreview.data.db.MatchResultRecord */
//public class MatchResultRecord {
//    public static final Map<String, String> COLUMN_MAP;
//    public static final int RESULT_NONE = 0;
//    public static final int RESULT_RIGHT = 1;
//    public static final int RESULT_WRONG = -1;
//    private int result;
//    private int topicId;
//
//    static {
//        HashMap hashMap = new HashMap();
//        COLUMN_MAP = hashMap;
//        hashMap.put("topicId", "word_topic_id");
//        COLUMN_MAP.put("fmpath", "result");
//    }
//
//    public int getTopicId() {
//        return this.topicId;
//    }
//
//    public void setTopicId(int i) {
//        this.topicId = i;
//    }
//
//    public int getResult() {
//        return this.result;
//    }
//
//    public void setResult(int i) {
//        this.result = i;
//    }
//
//    public String toString() {
//        return "MatchResultRecord {[topicId: " + this.topicId + "]; [result: " + this.result + "]}";
//    }
//}
