//package com.baicizhan.client.p029fm.data.p030db;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.BOOK_TS_OFFLINE_ROAD_MAP_IDS.Columns;
//import java.util.HashMap;
//import java.util.Map;
//
///* renamed from: com.baicizhan.client.fm.data.db.FmIdMapRecord */
//public class FmIdMapRecord {
//    public static final Map<String, String> COLUMN_MAP;
//    String fmid;
//    String wordid;
//
//    static {
//        HashMap hashMap = new HashMap();
//        COLUMN_MAP = hashMap;
//        hashMap.put("wordid", "topic_id");
//        COLUMN_MAP.put("fmid", Columns.TAPESCRIPT_ID);
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
//    public String getFmid() {
//        return this.fmid;
//    }
//
//    public void setFmid(String str) {
//        this.fmid = str;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("FmIdMapRecord {");
//        sb.append("wordid:").append(this.wordid).append(", fmid:").append(this.fmid).append("}");
//        return sb.toString();
//    }
//}
