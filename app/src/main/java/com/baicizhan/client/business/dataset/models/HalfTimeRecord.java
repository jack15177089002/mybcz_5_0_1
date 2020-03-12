//package com.baicizhan.client.business.dataset.models;
//
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_WORD_RADIO_HALF_TIME.Columns;
//import java.util.Map;
//
//public class HalfTimeRecord {
//    public static final Map<String, String> COLUMN_MAP;
//    public String audioPath;
//    public int bookId;
//    public int complete;
//    public long updateTime;
//    public String vedioPath;
//    public long wsId;
//
//    static {
//        ArrayMap aVar = new ArrayMap();
//        COLUMN_MAP = aVar;
//        aVar.put("wsId", "ws_id");
//        COLUMN_MAP.put("bookId", Columns.WS_BOOKID);
//        COLUMN_MAP.put("complete", "ws_complete");
//        COLUMN_MAP.put("audioPath", "ws_audio");
//        COLUMN_MAP.put("updateTime", "ws_update_time");
//        COLUMN_MAP.put("vedioPath", Columns.WS_WORD_TV);
//    }
//
//    public String toString() {
//        return "HalfTimeRecord [wsId=" + this.wsId + ", bookId=" + this.bookId + ", complete=" + this.complete + ", audioPath=" + this.audioPath + ", updateTime=" + this.updateTime + ", vedioPath=" + this.vedioPath + "]";
//    }
//}
