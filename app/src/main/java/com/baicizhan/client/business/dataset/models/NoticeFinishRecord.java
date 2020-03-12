//package com.baicizhan.client.business.dataset.models;
//
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_COMMON_TB.Columns;
//import com.tencent.android.tpush.common.MessageKey;
//import java.util.Map;
//
//public class NoticeFinishRecord {
//    public static final Map<String, String> COLUMN_MAP;
//    public static final int PERSON_BAO = 1;
//    public static final int PERSON_GUO = 2;
//    public static final int STATUS_READED = 1;
//    public static final int STATUS_UNREAD = 0;
//    public String content;
//
//    /* renamed from: id */
//    public int f2228id;
//    public int person;
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
//        return "NoticeFinishRecord [id=" + this.f2228id + ", time=" + this.time + ", person=" + this.person + ", content=" + this.content + ", status=" + this.status + "]";
//    }
//}
