//package com.baicizhan.client.business.dataset.models;
//
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_COMMON_TB.Columns;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_WORD_STATION_DATA_ALL;
//import java.util.Map;
//
//public class WordStationRecord {
//    public static final Map<String, String> COLUMN_MAP;
//    public String audioHDPath;
//    public String audioPath;
//    public int complete;
//    public String desc;
//
//    /* renamed from: id */
//    public long f2233id;
//    public String sentence;
//    public long updateTime;
//    public String vedioPath;
//    public String word;
//    public String wordCN;
//    public String wordType;
//
//    static {
//        ArrayMap aVar = new ArrayMap();
//        COLUMN_MAP = aVar;
//        aVar.put(Columns.f2234ID, "ws_id");
//        COLUMN_MAP.put("complete", "ws_complete");
//        COLUMN_MAP.put("word", TS_WORD_STATION_DATA_ALL.Columns.WS_WORD);
//        COLUMN_MAP.put("wordType", TS_WORD_STATION_DATA_ALL.Columns.WS_WORD_TYPE);
//        COLUMN_MAP.put("wordCN", TS_WORD_STATION_DATA_ALL.Columns.WS_WORD_CN);
//        COLUMN_MAP.put("sentence", TS_WORD_STATION_DATA_ALL.Columns.WS_SENTENCE);
//        COLUMN_MAP.put("desc", TS_WORD_STATION_DATA_ALL.Columns.WS_DESC);
//        COLUMN_MAP.put("audioPath", "ws_audio");
//        COLUMN_MAP.put("audioHDPath", TS_WORD_STATION_DATA_ALL.Columns.WS_AUDIO_HIGH);
//        COLUMN_MAP.put("updateTime", "ws_update_time");
//        COLUMN_MAP.put("vedioPath", TS_WORD_STATION_DATA_ALL.Columns.TV_VEDIO_PATH);
//    }
//
//    public String toString() {
//        return "WordStationRecord [id=" + this.f2233id + ", complete=" + this.complete + ", word=" + this.word + ", wordType=" + this.wordType + ", wordCN=" + this.wordCN + ", sentence=" + this.sentence + ", desc=" + this.desc + ", audioPath=" + this.audioPath + ", audioHDPath=" + this.audioHDPath + ", updateTime=" + this.updateTime + ", vedioPath=" + this.vedioPath + "]";
//    }
//}
