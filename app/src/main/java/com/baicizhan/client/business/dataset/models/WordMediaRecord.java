//package com.baicizhan.client.business.dataset.models;
//
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_WORD_STATION_DATA_ALL;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_LOCK_SEARCH_HISTORY_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_MEDIA_TB.Columns;
////import com.baicizhan.online.bs_words.BBWordMediaV2;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class WordMediaRecord {
//    public static final Map<String, String> COLUMN_MAP = new ArrayMap();
//    public static final Map<String, String> OLD_COLUMN_MAP = new ArrayMap();
//    private String cnmean;
//    private String example;
//    private String fmpath;
//    private long fmupdate;
//    private String highfmpath;
//    private int tapId;
//    private String tvSnapshotPath;
//    private String tvpath;
//    private long tvupdate;
//    private String word;
//    private String wordid;
//    private String wordtype;
//
//    static {
//        COLUMN_MAP.put("wordid", "topic_id");
//        COLUMN_MAP.put("word", "topic_word");
//        COLUMN_MAP.put("wordtype", Columns.TOPIC_WORD_TYPE);
//        COLUMN_MAP.put(WORD_LOCK_SEARCH_HISTORY_TB.Columns.CNMEAN, Columns.TOPIC_WORD_CNMEAN);
//        COLUMN_MAP.put(WORD_LOCK_SEARCH_HISTORY_TB.Columns.EXAMPLE, Columns.TOPIC_SENTENCE);
//        COLUMN_MAP.put("fmpath", Columns.AMR_AUDIO_PATH);
//        COLUMN_MAP.put("highfmpath", Columns.M4A_AUDIO_PATH);
//        COLUMN_MAP.put("tvpath", Columns.TV_PATH);
//        COLUMN_MAP.put("tvSnapshotPath", Columns.TV_SNAPSHOT_PATH);
//        COLUMN_MAP.put("fmupdate", "fm_updated_at");
//        COLUMN_MAP.put("tvupdate", "tv_updated_at");
//        OLD_COLUMN_MAP.put("tapId", "ws_id");
//        OLD_COLUMN_MAP.put("word", TS_WORD_STATION_DATA_ALL.Columns.WS_WORD);
//        OLD_COLUMN_MAP.put("wordtype", TS_WORD_STATION_DATA_ALL.Columns.WS_WORD_TYPE);
//        OLD_COLUMN_MAP.put(WORD_LOCK_SEARCH_HISTORY_TB.Columns.CNMEAN, TS_WORD_STATION_DATA_ALL.Columns.WS_WORD_CN);
//        OLD_COLUMN_MAP.put(WORD_LOCK_SEARCH_HISTORY_TB.Columns.EXAMPLE, TS_WORD_STATION_DATA_ALL.Columns.WS_SENTENCE);
//        OLD_COLUMN_MAP.put("fmpath", "ws_audio");
//        OLD_COLUMN_MAP.put("highfmpath", TS_WORD_STATION_DATA_ALL.Columns.WS_AUDIO_HIGH);
//        OLD_COLUMN_MAP.put("tvpath", TS_WORD_STATION_DATA_ALL.Columns.TV_VEDIO_PATH);
//        OLD_COLUMN_MAP.put("fmupdate", "ws_update_time");
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
//    public String getFmpath() {
//        return this.fmpath;
//    }
//
//    public void setFmpath(String str) {
//        this.fmpath = str;
//    }
//
//    public String getHighfmpath() {
//        return this.highfmpath;
//    }
//
//    public void setHighfmpath(String str) {
//        this.highfmpath = str;
//    }
//
//    public String getTvpath() {
//        return this.tvpath;
//    }
//
//    public void setTvpath(String str) {
//        this.tvpath = str;
//    }
//
//    public String getTvSnapshotPath() {
//        return this.tvSnapshotPath;
//    }
//
//    public void setTvSnapshotPath(String str) {
//        this.tvSnapshotPath = str;
//    }
//
//    public long getFmupdate() {
//        return this.fmupdate;
//    }
//
//    public void setFmupdate(long j) {
//        this.fmupdate = j;
//    }
//
//    public long getTvupdate() {
//        return this.tvupdate;
//    }
//
//    public void setTvupdate(long j) {
//        this.tvupdate = j;
//    }
//
//    public String getWord() {
//        return this.word;
//    }
//
//    public void setWord(String str) {
//        this.word = str;
//    }
//
//    public String getCnmean() {
//        return this.cnmean;
//    }
//
//    public void setCnmean(String str) {
//        this.cnmean = str;
//    }
//
//    public String getExample() {
//        return this.example;
//    }
//
//    public void setExample(String str) {
//        this.example = str;
//    }
//
//    public String getWordtype() {
//        return this.wordtype;
//    }
//
//    public void setWordtype(String str) {
//        this.wordtype = str;
//    }
//
//    public int getTapId() {
//        return this.tapId;
//    }
//
//    public void setTapId(int i) {
//        this.tapId = i;
//    }
//
////    public static WordMediaRecord fromBBWordMedia(BBWordMediaV2 bBWordMediaV2) {
////        WordMediaRecord wordMediaRecord = new WordMediaRecord();
////        wordMediaRecord.setCnmean(bBWordMediaV2.getWord_mean_cn());
////        wordMediaRecord.setWordid(Integer.toString(bBWordMediaV2.getTopic_id()));
////        wordMediaRecord.setWord(bBWordMediaV2.getWord());
////        wordMediaRecord.setWordtype(bBWordMediaV2.getWord_type());
////        wordMediaRecord.setExample(bBWordMediaV2.getWord_sentence());
////        wordMediaRecord.setFmpath(bBWordMediaV2.getAmr_audio_path());
////        wordMediaRecord.setHighfmpath(bBWordMediaV2.getM4a_audio_path());
////        wordMediaRecord.setTvpath(bBWordMediaV2.getTv_path());
////        wordMediaRecord.setTvSnapshotPath(bBWordMediaV2.getTv_snapshot_path());
////        wordMediaRecord.setFmupdate(bBWordMediaV2.getFm_updated_at());
////        wordMediaRecord.setTvupdate(bBWordMediaV2.getTv_updated_at());
////        return wordMediaRecord;
////    }
////
////    public static List<WordMediaRecord> fromList(List<BBWordMediaV2> list) {
////        if (list == null) {
////            return null;
////        }
////        ArrayList arrayList = new ArrayList(list.size());
////        for (BBWordMediaV2 bBWordMediaV2 : list) {
////            WordMediaRecord wordMediaRecord = new WordMediaRecord();
////            wordMediaRecord.setWordid(bBWordMediaV2.topic_id);
////            wordMediaRecord.setWord(bBWordMediaV2.word);
////            wordMediaRecord.setWordtype(bBWordMediaV2.word_type);
////            wordMediaRecord.setCnmean(bBWordMediaV2.word_mean_cn);
////            wordMediaRecord.setExample(bBWordMediaV2.word_sentence);
////            wordMediaRecord.setFmpath(bBWordMediaV2.amr_audio_path);
////            wordMediaRecord.setHighfmpath(bBWordMediaV2.m4a_audio_path);
////            wordMediaRecord.setTvpath(bBWordMediaV2.tv_path);
////            wordMediaRecord.setTvSnapshotPath(bBWordMediaV2.tv_snapshot_path);
////            wordMediaRecord.setFmupdate(bBWordMediaV2.fm_updated_at);
////            wordMediaRecord.setTvupdate(bBWordMediaV2.tv_updated_at);
////            arrayList.add(wordMediaRecord);
////        }
////        return arrayList;
////    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("WordMediaRecord {");
//        sb.append("cnmean:").append(this.cnmean).append(", wordid:").append(this.wordid).append(", word:").append(this.word).append(", wordtype:").append(this.wordtype).append(", example:").append(this.example).append(", fmpath:").append(this.fmpath).append(", highfmpath:").append(this.highfmpath).append(", tvpath:").append(this.tvpath).append(", tvSnapshotPath:").append(this.tvSnapshotPath).append(", fmupdate:").append(this.fmupdate).append(", tvupdate:").append(this.tvupdate).append(", tapId:").append(this.tapId).append("}");
//        return sb.toString();
//    }
//}
