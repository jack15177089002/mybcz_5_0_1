//package com.baicizhan.client.business.dataset.models;
//
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_OFFLINE_SYNC_STATE.Columns;
//import java.util.Map;
//
//public class OfflineStateRecord {
//    public static final Map<String, String> COLUMN_MAP;
//    public int bookId;
//    public int comboCount;
//    public int maxComboCount;
//    public long runTime;
//    public int wantMoreCount;
//
//    static {
//        ArrayMap aVar = new ArrayMap();
//        COLUMN_MAP = aVar;
//        aVar.put("bookId", "book_id");
//        COLUMN_MAP.put("runTime", Columns.RUN_TIME);
//        COLUMN_MAP.put("wantMoreCount", Columns.WANT_MORE_COUNT);
//        COLUMN_MAP.put("comboCount", Columns.COMBO_COUNT);
//        COLUMN_MAP.put("maxComboCount", Columns.MAX_COMBO_COUNT);
//    }
//
//    public String toString() {
//        return "OfflineStateRecord [bookId=" + this.bookId + ", runTime=" + this.runTime + ", wantMoreCount=" + this.wantMoreCount + ", comboCount=" + this.comboCount + ", maxComboCount=" + this.maxComboCount + "]";
//    }
//}
