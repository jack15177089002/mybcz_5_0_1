package com.baicizhan.client.business.dataset.models;

import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
import java.util.Map;

public class WordMediaUpdRecord {
    public static final Map<String, String> COLUMN_MAP;
    private long fmupdate;
    private long tvupdate;
    private String wordid;

    static {
        ArrayMap aVar = new ArrayMap();
        COLUMN_MAP = aVar;
        aVar.put("wordid", "word_topic_id");
        COLUMN_MAP.put("fmupdate", "fm_updated_at");
        COLUMN_MAP.put("tvupdate", "tv_updated_at");
    }

    public String getWordid() {
        return this.wordid;
    }

    public void setWordid(String str) {
        this.wordid = str;
    }

    public long getFmupdate() {
        return this.fmupdate;
    }

    public void setFmupdate(long j) {
        this.fmupdate = j;
    }

    public long getTvupdate() {
        return this.tvupdate;
    }

    public void setTvupdate(long j) {
        this.tvupdate = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WordMediaUpdRecord {");
        sb.append("wordid:").append(this.wordid).append(", fmupdate:").append(this.fmupdate).append(", tvupdate:").append(this.tvupdate).append("}");
        return sb.toString();
    }
}
