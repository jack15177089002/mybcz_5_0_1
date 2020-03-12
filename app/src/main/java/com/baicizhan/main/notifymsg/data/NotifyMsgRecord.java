//package com.baicizhan.main.notifymsg.data;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.os.Parcelable.Creator;
//import com.baicizhan.client.business.dataset.provider.Contracts.NOTIFY_MESSAGE_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_COMMON_TB.Columns;
//import java.util.HashMap;
//import java.util.Map;
//
//public class NotifyMsgRecord implements Parcelable {
//    public static final Map<String, String> COLUMN_MAP;
//    public static final Creator<NotifyMsgRecord> CREATOR = new Creator<NotifyMsgRecord>() {
//        public final NotifyMsgRecord createFromParcel(Parcel parcel) {
//            return new NotifyMsgRecord(parcel);
//        }
//
//        public final NotifyMsgRecord[] newArray(int i) {
//            return new NotifyMsgRecord[i];
//        }
//    };
//    private String contentUrl;
//
//    /* renamed from: id */
//    private int f2401id;
//    private String imgUrl;
//    private int isHidden;
//    private int read;
//    private int time;
//    private String title;
//    private String titleDesc;
//    private int type;
//
//    static {
//        HashMap hashMap = new HashMap();
//        COLUMN_MAP = hashMap;
//        hashMap.put(Columns.f2234ID, NOTIFY_MESSAGE_TB.Columns.MSG_ID);
//        COLUMN_MAP.put("type", NOTIFY_MESSAGE_TB.Columns.MSG_TYPE);
//        COLUMN_MAP.put("title", "title");
//        COLUMN_MAP.put("titleDesc", NOTIFY_MESSAGE_TB.Columns.TITLE_DESC);
//        COLUMN_MAP.put("imgUrl", NOTIFY_MESSAGE_TB.Columns.IMG_URL);
//        COLUMN_MAP.put("contentUrl", NOTIFY_MESSAGE_TB.Columns.CONTENT_URL);
//        COLUMN_MAP.put("isHidden", NOTIFY_MESSAGE_TB.Columns.IS_HIDDEN);
//        COLUMN_MAP.put("time", "time");
//    }
//
//    public int getId() {
//        return this.f2401id;
//    }
//
//    public void setId(int i) {
//        this.f2401id = i;
//    }
//
//    public int getType() {
//        return this.type;
//    }
//
//    public void setType(int i) {
//        this.type = i;
//    }
//
//    public String getTitle() {
//        return this.title;
//    }
//
//    public void setTitle(String str) {
//        this.title = str;
//    }
//
//    public String getTitleDesc() {
//        return this.titleDesc;
//    }
//
//    public void setTitleDesc(String str) {
//        this.titleDesc = str;
//    }
//
//    public String getImgUrl() {
//        return this.imgUrl;
//    }
//
//    public void setImgUrl(String str) {
//        this.imgUrl = str;
//    }
//
//    public String getContentUrl() {
//        return this.contentUrl;
//    }
//
//    public void setContentUrl(String str) {
//        this.contentUrl = str;
//    }
//
//    public int getIsHidden() {
//        return this.isHidden;
//    }
//
//    public void setIsHidden(int i) {
//        this.isHidden = i;
//    }
//
//    public int getTime() {
//        return this.time;
//    }
//
//    public void setTime(int i) {
//        this.time = i;
//    }
//
//    public int getRead() {
//        return this.read;
//    }
//
//    public void setRead(int i) {
//        this.read = i;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("NotifyMsgRecord {");
//        sb.append("id:").append(this.f2401id).append(", type:").append(this.type).append(", title:").append(this.title).append(", titleDesc:").append(this.titleDesc).append(", imgUrl:").append(this.imgUrl).append(", contentUrl:").append(this.contentUrl).append(", isHidden:").append(this.isHidden).append(", time:").append(this.time).append(", read:").append(this.read).append("}");
//        return sb.toString();
//    }
//
//    public NotifyMsgRecord() {
//    }
//
//    public NotifyMsgRecord(Parcel parcel) {
//        this.f2401id = parcel.readInt();
//        this.type = parcel.readInt();
//        this.title = parcel.readString();
//        this.titleDesc = parcel.readString();
//        this.imgUrl = parcel.readString();
//        this.contentUrl = parcel.readString();
//        this.isHidden = parcel.readInt();
//        this.time = parcel.readInt();
//        this.read = parcel.readInt();
//    }
//
//    public int describeContents() {
//        return 0;
//    }
//
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeInt(this.f2401id);
//        parcel.writeInt(this.type);
//        parcel.writeString(this.title);
//        parcel.writeString(this.titleDesc);
//        parcel.writeString(this.imgUrl);
//        parcel.writeString(this.contentUrl);
//        parcel.writeInt(this.isHidden);
//        parcel.writeInt(this.time);
//        parcel.writeInt(this.read);
//    }
//}
