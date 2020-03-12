//package com.baicizhan.client.business.dataset.models;
//
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_COMMON_TB.Columns;
//import com.tencent.android.tpush.common.MessageKey;
//import java.util.Map;
//
//public class NoticeListItemRecord {
//    public static final Map<String, String> COLUMN_MAP;
//    public String content;
//
//    /* renamed from: id */
//    public int f2230id;
//    public String person;
//    public int status;
//    public long time;
//
//    static {
//        ArrayMap aVar = new ArrayMap();
//        COLUMN_MAP = aVar;
//        aVar.put(Columns.f2234ID, "ntf_id");
//        COLUMN_MAP.put("time", "ntf_time");
//        COLUMN_MAP.put("person", "ntf_person");
//        COLUMN_MAP.put(MessageKey.MSG_CONTENT, "ntf_content");
//        COLUMN_MAP.put("status", "read_status");
//    }
//
//    public String toString() {
//        return "NoticeListItemRecord [id=" + this.f2230id + ", time=" + this.time + ", person=" + this.person + ", content=" + this.content + ", status=" + this.status + "]";
//    }
//}
