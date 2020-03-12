//package com.baicizhan.client.business.dataset.models;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.os.Parcelable.Creator;
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.Columns;
//import java.util.Map;
//import p012ch.qos.logback.core.CoreConstants;
//
//public class TopicLearnRecord implements Parcelable {
//    public static final Creator<TopicLearnRecord> CREATOR = new Creator<TopicLearnRecord>() {
//        public final TopicLearnRecord[] newArray(int i) {
//            return new TopicLearnRecord[i];
//        }
//
//        public final TopicLearnRecord createFromParcel(Parcel parcel) {
//            TopicLearnRecord topicLearnRecord = new TopicLearnRecord();
//            topicLearnRecord.readFromParcel(parcel);
//            return topicLearnRecord;
//        }
//    };
//    public static Map<String, String> MEDIA_SYNC_COLUMN_MAP = new ArrayMap();
//    public static final int SCORE_DEFUALT_KILLED = -1;
//    public static final int SCORE_UNTOUCH = -1024;
//    public static final int SKIPPED_FM = 1;
//    public static final int SKIPPED_TV = 2;
//    public static final int SYNCED = 1;
//    public static Map<String, String> SYNCING_TABLE_COLUMN_MAP = new ArrayMap();
//    public static Map<String, String> TOTAL_TABLE_COLUMN_MAP = new ArrayMap();
//    public static final int UNSYNC = 0;
//    public int doNum;
//    public int errNum;
//    public int isTodayNew;
//    public long lastDoTime;
//    public int radioPostState;
//    public int radioSkipState;
//    public int radioState;
//    public int radioTVState;
//    public long syncState;
//    public int topicDay;
//    public int topicId;
//    public int topicScore;
//    public long totalTime;
//    public int zijianState;
//
//    public static boolean isFmSkipped(int i) {
//        return (i | 1) == 1;
//    }
//
//    public static boolean isTVSkipped(int i) {
//        return (i | 2) == 2;
//    }
//
//    public static int mergeFmSkipValue(boolean z, int i) {
//        return (z ? 1 : 0) | i;
//    }
//
//    public static int mergeTVSkipVlaue(boolean z, int i) {
//        return (z ? 2 : 0) | i;
//    }
//
//    static {
//        TOTAL_TABLE_COLUMN_MAP.put("topicId", "topic_id");
//        TOTAL_TABLE_COLUMN_MAP.put("topicScore", "topic_obn");
//        TOTAL_TABLE_COLUMN_MAP.put("topicDay", "topic_day");
//        TOTAL_TABLE_COLUMN_MAP.put("totalTime", "total_time");
//        TOTAL_TABLE_COLUMN_MAP.put("doNum", "do_num");
//        TOTAL_TABLE_COLUMN_MAP.put("errNum", "err_num");
//        TOTAL_TABLE_COLUMN_MAP.put("syncState", "sync_state");
//        TOTAL_TABLE_COLUMN_MAP.put("lastDoTime", "last_do_time");
//        TOTAL_TABLE_COLUMN_MAP.put("isTodayNew", "is_today_new");
//        SYNCING_TABLE_COLUMN_MAP.put("topicId", "topic_id");
//        SYNCING_TABLE_COLUMN_MAP.put("topicScore", "topic_obn");
//        SYNCING_TABLE_COLUMN_MAP.put("topicDay", "topic_day");
//        SYNCING_TABLE_COLUMN_MAP.put("totalTime", "total_time");
//        SYNCING_TABLE_COLUMN_MAP.put("doNum", "do_num");
//        SYNCING_TABLE_COLUMN_MAP.put("errNum", "err_num");
//        SYNCING_TABLE_COLUMN_MAP.put("syncState", "sync_state");
//        SYNCING_TABLE_COLUMN_MAP.put("lastDoTime", "last_do_time");
//        SYNCING_TABLE_COLUMN_MAP.put("isTodayNew", "is_today_new");
//        MEDIA_SYNC_COLUMN_MAP.put("topicId", "topic_id");
//        MEDIA_SYNC_COLUMN_MAP.put("radioState", Columns.RADIO_STATE);
//        MEDIA_SYNC_COLUMN_MAP.put("radioPostState", Columns.RADIO_POST_STATE);
//        MEDIA_SYNC_COLUMN_MAP.put("radioTVState", Columns.RADIO_TV_STATE);
//        MEDIA_SYNC_COLUMN_MAP.put("radioSkipState", Columns.RADIO_SKIP_STATE);
//    }
//
//    public String toString() {
//        return "TopicLearnRecord{topicId=" + this.topicId + ", topicScore=" + this.topicScore + ", topicDay=" + this.topicDay + ", totalTime=" + this.totalTime + ", doNum=" + this.doNum + ", errNum=" + this.errNum + ", syncState=" + this.syncState + ", lastDoTime=" + this.lastDoTime + ", isTodayNew=" + this.isTodayNew + ", zijianState=" + this.zijianState + ", radioState=" + this.radioState + ", radioPostState=" + this.radioPostState + ", radioTVState=" + this.radioTVState + ", radioSkipState=" + this.radioSkipState + CoreConstants.CURLY_RIGHT;
//    }
//
//    public int describeContents() {
//        return 0;
//    }
//
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeInt(this.topicId);
//        parcel.writeInt(this.topicScore);
//        parcel.writeInt(this.topicDay);
//        parcel.writeLong(this.totalTime);
//        parcel.writeInt(this.doNum);
//        parcel.writeInt(this.errNum);
//        parcel.writeLong(this.syncState);
//        parcel.writeLong(this.lastDoTime);
//        parcel.writeInt(this.isTodayNew);
//        parcel.writeInt(this.zijianState);
//        parcel.writeInt(this.radioState);
//        parcel.writeInt(this.radioPostState);
//        parcel.writeInt(this.radioTVState);
//        parcel.writeInt(this.radioSkipState);
//    }
//
//    public void readFromParcel(Parcel parcel) {
//        this.topicId = parcel.readInt();
//        this.topicScore = parcel.readInt();
//        this.topicDay = parcel.readInt();
//        this.totalTime = parcel.readLong();
//        this.doNum = parcel.readInt();
//        this.errNum = parcel.readInt();
//        this.syncState = parcel.readLong();
//        this.lastDoTime = parcel.readLong();
//        this.isTodayNew = parcel.readInt();
//        this.zijianState = parcel.readInt();
//        this.radioState = parcel.readInt();
//        this.radioPostState = parcel.readInt();
//        this.radioTVState = parcel.readInt();
//        this.radioSkipState = parcel.readInt();
//    }
//
//    public boolean isKilled() {
//        return isKilled(this.topicScore);
//    }
//
//    public static boolean isKilled(int i) {
//        return i < 0 && i != -1024;
//    }
//}
