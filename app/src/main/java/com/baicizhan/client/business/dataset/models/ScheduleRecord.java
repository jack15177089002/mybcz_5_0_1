package com.baicizhan.client.business.dataset.models;

import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZBOOKFINISHINFO.Columns;
import java.util.Map;
import p012ch.qos.logback.core.CoreConstants;

public class ScheduleRecord {
    public static Map<String, String> COLUMN_MAP;
    public int bookId;
    public transient boolean completeReviewMode;
    public int dailyNewCount;
    public int dakaDays;
    public transient long dueTime;
    public int isCurrentSelect;
    public long lastDakaTime;
    public int lastVocabTestFinishedCount;
    public int lastVocabTestTime;
    public long localSyncVer;
    public int maxOfflineCount;
    public int maxOfflineDays;
    public transient long remoteSyncVer;
    public transient int todayMaxCombo;

    static {
        ArrayMap aVar = new ArrayMap();
        COLUMN_MAP = aVar;
        aVar.put("bookId", "BOOK_ID");
//        COLUMN_MAP.put("isCurrentSelect", Columns.IS_CURRENT_SELECT_BOOK);
//        COLUMN_MAP.put("dailyNewCount", Columns.DAILY_NEW_WORD);
//        COLUMN_MAP.put("localSyncVer", "sync_state");
//        COLUMN_MAP.put("dakaDays", Columns.DAKA_DAYS);
//        COLUMN_MAP.put("lastDakaTime", Columns.LAST_DAKA_TIMES);
//        COLUMN_MAP.put("maxOfflineDays", Columns.MAX_OFFLINE_DAYS);
//        COLUMN_MAP.put("maxOfflineCount", Columns.MAX_OFFLINE_PROBLEM_COUNT);
//        COLUMN_MAP.put("lastVocabTestTime", Columns.LAST_DANCILIANG_TIMES);
//        COLUMN_MAP.put("lastVocabTestFinishedCount", Columns.LAST_DANCILIANG_FINISH_WORD_COUNT);
    }

    public String toString() {
        return "ScheduleRecord{bookId=" + this.bookId + ", dailyNewCount=" + this.dailyNewCount + ", dakaDays=" + this.dakaDays + ", dueTime=" + this.dueTime + ", lastDakaTime=" + this.lastDakaTime + ", lastVocabTestFinishedCount=" + this.lastVocabTestFinishedCount + ", lastVocabTestTime=" + this.lastVocabTestTime + ", localSyncVer=" + this.localSyncVer + ", maxOfflineCount=" + this.maxOfflineCount + ", maxOfflineDays=" + this.maxOfflineDays + ", remoteSyncVer=" + this.remoteSyncVer + ", todayMaxCombo=" + this.todayMaxCombo + ", isCurrentSelect=" + this.isCurrentSelect + ", completeReviewMode=" + this.completeReviewMode + CoreConstants.CURLY_RIGHT;
    }
}
