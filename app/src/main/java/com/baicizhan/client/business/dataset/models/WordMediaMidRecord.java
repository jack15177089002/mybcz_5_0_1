//package com.baicizhan.client.business.dataset.models;
//
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_WORD_RADIO_HALF_TIME.Columns;
//import java.util.Map;
//
//public class WordMediaMidRecord {
//    public static final Map<String, String> COLUMN_MAP = new ArrayMap();
//    public static final Map<String, String> OLD_COLUMN_MAP = new ArrayMap();
//    private String path;
//    private int type;
//
//    static {
//        COLUMN_MAP.put("path", "path");
//        COLUMN_MAP.put("type", "type");
//        OLD_COLUMN_MAP.put("path", "ws_audio");
//        OLD_COLUMN_MAP.put("type", Columns.WS_WORD_TV);
//    }
//
//    public String getPath() {
//        return this.path;
//    }
//
//    public void setPath(String str) {
//        this.path = str;
//    }
//
//    public int getType() {
//        return this.type;
//    }
//
//    public void setType(int i) {
//        this.type = i;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("WordMediaMidRecord {");
//        sb.append("path:").append(this.path).append(", type:").append(this.type).append("}");
//        return sb.toString();
//    }
//}
