//package com.baicizhan.main.stats.study;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_WORD_DONE_TB.Columns;
//import com.baicizhan.online.bs_users.BBDoneWordStatLog;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class WordDoneRecord {
//    public static final Map<String, String> COLUMN_MAP;
//    private int doneType;
//    private int duration;
//    private int isDoneRight;
//    private int isTodyNew;
//    private int option;
//    private int topicId;
//
//    static {
//        HashMap hashMap = new HashMap();
//        COLUMN_MAP = hashMap;
//        hashMap.put("topicId", "topic_id");
//        COLUMN_MAP.put("isTodyNew", "is_today_new");
//        COLUMN_MAP.put("isDoneRight", Columns.IS_DONE_RIGHT);
//        COLUMN_MAP.put(Columns.OPTION, Columns.OPTION);
//        COLUMN_MAP.put("doneType", Columns.DONE_TYPE);
//        COLUMN_MAP.put(Columns.DURATION, Columns.DURATION);
//    }
//
//    public static List<WordDoneRecord> fromThrift(List<BBDoneWordStatLog> list) {
//        if (list == null) {
//            return null;
//        }
//        ArrayList arrayList = new ArrayList(list.size());
//        for (BBDoneWordStatLog bBDoneWordStatLog : list) {
//            WordDoneRecord wordDoneRecord = new WordDoneRecord();
//            wordDoneRecord.topicId = bBDoneWordStatLog.topic_id;
//            wordDoneRecord.isTodyNew = bBDoneWordStatLog.is_today_new;
//            wordDoneRecord.isDoneRight = bBDoneWordStatLog.is_done_right;
//            wordDoneRecord.option = bBDoneWordStatLog.option;
//            wordDoneRecord.doneType = bBDoneWordStatLog.done_type;
//            wordDoneRecord.duration = bBDoneWordStatLog.duration;
//            arrayList.add(wordDoneRecord);
//        }
//        return arrayList;
//    }
//
//    public static List<BBDoneWordStatLog> toThrift(List<WordDoneRecord> list) {
//        if (list == null) {
//            return null;
//        }
//        ArrayList arrayList = new ArrayList();
//        for (WordDoneRecord wordDoneRecord : list) {
//            BBDoneWordStatLog bBDoneWordStatLog = new BBDoneWordStatLog();
//            bBDoneWordStatLog.topic_id = wordDoneRecord.topicId;
//            bBDoneWordStatLog.is_today_new = wordDoneRecord.isTodyNew;
//            bBDoneWordStatLog.is_done_right = wordDoneRecord.isDoneRight;
//            bBDoneWordStatLog.option = wordDoneRecord.option;
//            bBDoneWordStatLog.done_type = wordDoneRecord.doneType;
//            bBDoneWordStatLog.duration = wordDoneRecord.duration;
//            arrayList.add(bBDoneWordStatLog);
//        }
//        return arrayList;
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
//    public int getIsTodyNew() {
//        return this.isTodyNew;
//    }
//
//    public void setIsTodyNew(int i) {
//        this.isTodyNew = i;
//    }
//
//    public int getIsDoneRight() {
//        return this.isDoneRight;
//    }
//
//    public void setIsDoneRight(int i) {
//        this.isDoneRight = i;
//    }
//
//    public int getOption() {
//        return this.option;
//    }
//
//    public void setOption(int i) {
//        this.option = i;
//    }
//
//    public int getDoneType() {
//        return this.doneType;
//    }
//
//    public void setDoneType(int i) {
//        this.doneType = i;
//    }
//
//    public int getDuration() {
//        return this.duration;
//    }
//
//    public void setDuration(int i) {
//        this.duration = i;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("WordDoneRecord {");
//        sb.append("topicId:").append(this.topicId).append(", isTodyNew:").append(this.isTodyNew).append(", isDoneRight:").append(this.isDoneRight).append(", option:").append(this.option).append(", doneType:").append(this.doneType).append(", duration:").append(this.duration).append("}");
//        return sb.toString();
//    }
//}
