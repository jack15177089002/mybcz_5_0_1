//package com.baicizhan.client.business.stats.operation;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//import android.os.Parcelable.Creator;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_COMMON_TB.Columns;
//import com.baicizhan.client.business.util.TimeUtil;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class OpCommonRecord implements Parcelable {
//    public static final Map<String, String> COLUMN_MAP;
//    public static final Creator<OperationRecord> CREATOR = new Creator<OperationRecord>() {
//        public final OperationRecord createFromParcel(Parcel parcel) {
//            return new OperationRecord(parcel);
//        }
//
//        public final OperationRecord[] newArray(int i) {
//            return new OperationRecord[i];
//        }
//    };
//
//    /* renamed from: id */
//    private int f2238id;
//    private long opTime;
//    private int opType;
//    private String opValue;
//
//    static {
//        HashMap hashMap = new HashMap();
//        COLUMN_MAP = hashMap;
//        hashMap.put(Columns.f2234ID, Columns.f2234ID);
//        COLUMN_MAP.put("opType", Columns.OP_TYPE);
//        COLUMN_MAP.put("opTime", "op_time");
//        COLUMN_MAP.put("opValue", "op_value");
//    }
//
//    public int getId() {
//        return this.f2238id;
//    }
//
//    public void setId(int i) {
//        this.f2238id = i;
//    }
//
//    public int getOpType() {
//        return this.opType;
//    }
//
//    public void setOpType(int i) {
//        this.opType = i;
//    }
//
//    public String getOpValue() {
//        return this.opValue;
//    }
//
//    public void setOpValue(String str) {
//        this.opValue = str;
//    }
//
//    public long getOpTime() {
//        return this.opTime;
//    }
//
//    public void setOpTime(long j) {
//        this.opTime = j;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder("OpCommonRecord {");
//        sb.append("opType:").append(this.opType).append(", opValue:").append(this.opValue).append(", opTime:").append(this.opTime).append("}");
//        return sb.toString();
//    }
//
//    public OpCommonRecord() {
//    }
//
//    public OpCommonRecord(Parcel parcel) {
//        this.f2238id = parcel.readInt();
//        this.opType = parcel.readInt();
//        this.opTime = parcel.readLong();
//        this.opValue = parcel.readString();
//    }
//
//    public int describeContents() {
//        return 0;
//    }
//
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeInt(this.f2238id);
//        parcel.writeInt(this.opType);
//        parcel.writeLong(this.opTime);
//        parcel.writeString(this.opValue);
//    }
//
//    public static Map<Long, List<OpCommonRecord>> classifyRecordsByDay(List<OpCommonRecord> list) {
//        if (list == null || list.isEmpty()) {
//            return null;
//        }
//        HashMap hashMap = new HashMap();
//        for (OpCommonRecord opCommonRecord : list) {
//            long startSecondOfDay = TimeUtil.getStartSecondOfDay(opCommonRecord.opTime);
//            List list2 = (List) hashMap.get(Long.valueOf(startSecondOfDay));
//            if (list2 == null) {
//                list2 = new ArrayList();
//                hashMap.put(Long.valueOf(startSecondOfDay), list2);
//            }
//            list2.add(opCommonRecord);
//        }
//        return hashMap;
//    }
//}
