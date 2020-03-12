//package com.baicizhan.client.p029fm.data;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.os.Parcelable.Creator;
//import com.baicizhan.client.business.dataset.models.TopicLearnRecord;
//
///* renamed from: com.baicizhan.client.fm.data.FmData */
//public class FmData implements Parcelable {
//    public static final Creator<FmData> CREATOR = new Creator<FmData>() {
//        public final FmData createFromParcel(Parcel parcel) {
//            return new FmData(parcel);
//        }
//
//        public final FmData[] newArray(int i) {
//            return new FmData[i];
//        }
//    };
//    String accent;
//    String cnmean;
//    String example;
//    String hdpath;
//    private FmData initedOne;
//    String path;
//    int skipped;
//    int viewed;
//    String word;
//    String wordid;
//    String wordtype;
//
//    public String getWordid() {
//        return this.wordid;
//    }
//
//    public String getWord() {
//        return this.word;
//    }
//
//    public String getWordType() {
//        return this.wordtype;
//    }
//
//    public String getAccent() {
//        return this.accent;
//    }
//
//    public String getCnmean() {
//        return this.cnmean;
//    }
//
//    public String getExample() {
//        return this.example;
//    }
//
//    public String getPath() {
//        return this.path;
//    }
//
//    public String getHdpath() {
//        return this.hdpath;
//    }
//
//    public int getViewedCount() {
//        return this.viewed;
//    }
//
//    public void accumViewed() {
//        this.viewed++;
//    }
//
//    public boolean isSkipped() {
//        return TopicLearnRecord.isFmSkipped(this.skipped);
//    }
//
//    public int getSkipValue() {
//        return this.skipped;
//    }
//
//    public void setSkipped(boolean z) {
//        this.skipped = TopicLearnRecord.mergeFmSkipValue(z, this.skipped);
//    }
//
//    public FmData getInitedOne() {
//        return this.initedOne;
//    }
//
//    public void setInitedOne(FmData fmData) {
//        if (fmData == null) {
//            this.initedOne = null;
//            return;
//        }
//        this.initedOne = new FmData();
//        this.initedOne.wordid = fmData.wordid;
//        this.initedOne.word = fmData.word;
//        this.initedOne.wordtype = fmData.wordtype;
//        this.initedOne.accent = fmData.accent;
//        this.initedOne.cnmean = fmData.cnmean;
//        this.initedOne.example = fmData.example;
//        this.initedOne.path = fmData.path;
//        this.initedOne.hdpath = fmData.hdpath;
//        this.initedOne.viewed = fmData.viewed;
//        this.initedOne.skipped = fmData.skipped;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("FmData {");
//        sb.append("wordid:").append(this.wordid).append(", word:").append(this.word).append(", accent:").append(this.accent).append(", cnmean:").append(this.cnmean).append(", example:").append(this.example).append(", path:").append(this.path).append(", hdpath:").append(this.hdpath).append("}");
//        return sb.toString();
//    }
//
//    public FmData() {
//    }
//
//    public FmData(Parcel parcel) {
//        this.wordid = parcel.readString();
//        this.word = parcel.readString();
//        this.wordtype = parcel.readString();
//        this.accent = parcel.readString();
//        this.cnmean = parcel.readString();
//        this.example = parcel.readString();
//        this.path = parcel.readString();
//        this.hdpath = parcel.readString();
//        this.viewed = parcel.readInt();
//        this.skipped = parcel.readInt();
//        this.initedOne = (FmData) parcel.readParcelable(FmData.class.getClassLoader());
//    }
//
//    public int describeContents() {
//        return 0;
//    }
//
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeString(this.wordid);
//        parcel.writeString(this.word);
//        parcel.writeString(this.wordtype);
//        parcel.writeString(this.accent);
//        parcel.writeString(this.cnmean);
//        parcel.writeString(this.example);
//        parcel.writeString(this.path);
//        parcel.writeString(this.hdpath);
//        parcel.writeInt(this.viewed);
//        parcel.writeInt(this.skipped);
//        parcel.writeParcelable(this.initedOne, i);
//    }
//}
