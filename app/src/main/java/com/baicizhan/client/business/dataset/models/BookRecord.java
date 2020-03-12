//package com.baicizhan.client.business.dataset.models;
//
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZBOOKRESOURCE.Columns;
//import com.baicizhan.client.business.util.TimeUtil;
////import com.baicizhan.online.bs_users.BBLearnInfo;
////import com.baicizhan.online.bs_users.BBUserSelectedBookInfo;
//import java.io.Serializable;
//import java.util.Map;
//
//public class BookRecord implements Serializable {
//    public static Map<String, String> COLUMN_MAP = null;
//    public static final int ID_GaoKaoCiHui = 16;
//    public static final int ID_GaoKaoGaoFen = 31;
//    public static final int ID_INVALID = -1;
//    private static final long serialVersionUID = -8226546627562812675L;
//    public int bookId;
//    public String bookName;
//    public String description;
//    public long dueTime;
//    public transient int finishCount;
//    public long localBookResVer;
//    public long localRadioResVer;
//    public long localRoadmapVer;
//    public transient long remoteBookResVer;
//    public transient long remoteRadioResVer;
//    public transient long remoteRoadmapVer;
//    public long updateTime;
//    public int wordCount;
//
//    static {
//        ArrayMap aVar = new ArrayMap();
//        COLUMN_MAP = aVar;
//        aVar.put("bookId", "BOOK_ID");
//        COLUMN_MAP.put("bookName", Columns.BOOKNAME);
//        COLUMN_MAP.put(Columns.DESCRIPTION, Columns.DESCRIPTION);
//        COLUMN_MAP.put("updateTime", "UPDATETIME");
//        COLUMN_MAP.put("wordCount", Columns.WORD_COUNT);
//        COLUMN_MAP.put("dueTime", Columns.SETDATETIME);
//        COLUMN_MAP.put("localBookResVer", Columns.UPDATE_LOCAL_DATA);
//        COLUMN_MAP.put("localRoadmapVer", Columns.ROADMAP_VER);
//        COLUMN_MAP.put("localRadioResVer", Columns.ZWORD_RADIO_UPDATE_TIME);
//    }
//
//    public String toString() {
//        return "BookRecord [bookId=" + this.bookId + ", bookName=" + this.bookName + ", updateTime=" + this.updateTime + ", wordCount=" + this.wordCount + ", dueTime=" + this.dueTime + ", localBookResVer=" + this.localBookResVer + ", localRoadmapVer=" + this.localRoadmapVer + ", localRadioResVer=" + this.localRadioResVer + ", finishCount=" + this.finishCount + ", remoteBookResVer=" + this.remoteBookResVer + ", remoteRoadmapVer=" + this.remoteRoadmapVer + ", remoteRadioResVer=" + this.remoteRadioResVer + "]";
//    }
//
//    public int getRemainDays() {
//        int betweenDays = TimeUtil.getBetweenDays(System.currentTimeMillis(), this.dueTime * 1000);
//        if (betweenDays == 0) {
//            return 1;
//        }
//        return betweenDays;
//    }
//
//    public int getRemainCount() {
//        return this.wordCount - this.finishCount;
//    }
//
//    public boolean equals(Object obj) {
//        if (obj == null || !(obj instanceof BookRecord) || this.bookId != ((BookRecord) obj).bookId) {
//            return false;
//        }
//        return true;
//    }
//
////    public void updateSelectedInfo(BBUserSelectedBookInfo bBUserSelectedBookInfo) {
////        this.dueTime = bBUserSelectedBookInfo.getSelected_end_time();
////        this.finishCount = bBUserSelectedBookInfo.getLearned_words_count();
////        this.remoteRoadmapVer = bBUserSelectedBookInfo.getRoadmap_version();
////        this.remoteRadioResVer = bBUserSelectedBookInfo.getWord_fm_updated_at();
////    }
////
////    public void updateCurrentBookInfo(BBLearnInfo bBLearnInfo) {
////        this.remoteRoadmapVer = bBLearnInfo.getRoadmap_version();
////        this.remoteRadioResVer = bBLearnInfo.getWord_fm_updated_at();
////    }
//}
