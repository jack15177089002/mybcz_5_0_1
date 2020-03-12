//package com.baicizhan.client.p029fm.data;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.os.Parcelable.Creator;
//import java.util.ArrayList;
//
///* renamed from: com.baicizhan.client.fm.data.SolidFmList */
//public class SolidFmList extends ArrayList<FmData> implements Parcelable {
//    public static final Creator<SolidFmList> CREATOR = new Creator<SolidFmList>() {
//        public final SolidFmList createFromParcel(Parcel parcel) {
//            return new SolidFmList(parcel);
//        }
//
//        public final SolidFmList[] newArray(int i) {
//            return new SolidFmList[i];
//        }
//    };
//
//    public SolidFmList() {
//    }
//
//    public SolidFmList(Parcel parcel) {
//        this();
//        clear();
//        int readInt = parcel.readInt();
//        for (int i = 0; i < readInt; i++) {
//            add(new FmData(parcel));
//        }
//    }
//
//    public int describeContents() {
//        return 0;
//    }
//
//    public void writeToParcel(Parcel parcel, int i) {
//        int size = size();
//        parcel.writeInt(size);
//        for (int i2 = 0; i2 < size; i2++) {
//            ((FmData) get(i2)).writeToParcel(parcel, i);
//        }
//    }
//}
