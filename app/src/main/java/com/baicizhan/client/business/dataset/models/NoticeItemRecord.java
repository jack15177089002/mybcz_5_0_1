//package com.baicizhan.client.business.dataset.models;
//
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_COMMON_TB.Columns;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_EVERY_NOTICE_INFO;
//import com.tencent.android.tpush.common.MessageKey;
//import java.util.Map;
//import p012ch.qos.logback.core.CoreConstants;
//
//public class NoticeItemRecord {
//    public static final Map<String, String> COLUMN_MAP;
//    public static final int PERSON_BAO = 1;
//    public static final int PERSON_GUO = 2;
//    public String content;
//    public int day;
//
//    /* renamed from: id */
//    public int f2229id;
//    public int person;
//    public long time;
//
//    static {
//        ArrayMap aVar = new ArrayMap();
//        COLUMN_MAP = aVar;
//        aVar.put(Columns.f2234ID, "ntf_id");
//        COLUMN_MAP.put("day", TS_EVERY_NOTICE_INFO.Columns.NTF_DAY);
//        COLUMN_MAP.put("time", "ntf_time");
//        COLUMN_MAP.put("person", "ntf_person");
//        COLUMN_MAP.put(MessageKey.MSG_CONTENT, "ntf_content");
//    }
//
//    public String toString() {
//        return "NoticeItemRecord{content='" + this.content + CoreConstants.SINGLE_QUOTE_CHAR + ", id=" + this.f2229id + ", day=" + this.day + ", time=" + this.time + ", person=" + this.person + CoreConstants.CURLY_RIGHT;
//    }
//}
