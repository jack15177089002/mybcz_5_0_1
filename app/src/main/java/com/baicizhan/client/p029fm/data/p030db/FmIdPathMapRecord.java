//package com.baicizhan.client.p029fm.data.p030db;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_WORD_STATION_DATA_ALL.Columns;
//import java.util.HashMap;
//import java.util.Map;
//
///* renamed from: com.baicizhan.client.fm.data.db.FmIdPathMapRecord */
//public class FmIdPathMapRecord {
//    public static final Map<String, String> COLUMN_MAP;
//    String fmid;
//    String hdpath;
//    String path;
//
//    static {
//        HashMap hashMap = new HashMap();
//        COLUMN_MAP = hashMap;
//        hashMap.put("fmid", "ws_id");
//        COLUMN_MAP.put("path", "ws_audio");
//        COLUMN_MAP.put("hdpath", Columns.WS_AUDIO_HIGH);
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
//    public String getPath() {
//        return this.path;
//    }
//
//    public void setPath(String str) {
//        this.path = str;
//    }
//
//    public String getHdpath() {
//        return this.hdpath;
//    }
//
//    public void setHdpath(String str) {
//        this.hdpath = str;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("FmIdPathMapRecord {");
//        sb.append("fmid:").append(this.fmid).append(", path:").append(this.path).append(", hdpath:").append(this.hdpath).append("}");
//        return sb.toString();
//    }
//}
