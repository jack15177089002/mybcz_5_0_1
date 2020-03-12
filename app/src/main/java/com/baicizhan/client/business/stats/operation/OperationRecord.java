package com.baicizhan.client.business.stats.operation;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_TB.Columns;
//import com.baicizhan.online.bs_users.BBOperationStatLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationRecord implements Parcelable {
    public static final Map<String, String> COLUMN_MAP;
    public static final Creator<OperationRecord> CREATOR = new Creator<OperationRecord>() {
        public final OperationRecord createFromParcel(Parcel parcel) {
            return new OperationRecord(parcel);
        }

        public final OperationRecord[] newArray(int i) {
            return new OperationRecord[i];
        }
    };
    private String opName;
    private long opTime;
    private int opValue;

    static {
        HashMap hashMap = new HashMap();
        COLUMN_MAP = hashMap;
//        hashMap.put("opName", Columns.OP_NAME);
        COLUMN_MAP.put("opValue", "op_value");
        COLUMN_MAP.put("opTime", "op_time");
    }

//    public static List<OperationRecord> fromThrift(List<BBOperationStatLog> list) {
//        if (list == null) {
//            return null;
//        }
//        ArrayList arrayList = new ArrayList();
//        for (BBOperationStatLog bBOperationStatLog : list) {
//            OperationRecord operationRecord = new OperationRecord();
//            operationRecord.opName = bBOperationStatLog.op_name;
//            operationRecord.opValue = bBOperationStatLog.op_value;
//            operationRecord.opTime = bBOperationStatLog.op_time;
//            arrayList.add(operationRecord);
//        }
//        return arrayList;
//    }

//    public static List<BBOperationStatLog> toThrift(List<OperationRecord> list) {
//        if (list == null) {
//            return null;
//        }
//        ArrayList arrayList = new ArrayList();
//        for (OperationRecord operationRecord : list) {
//            BBOperationStatLog bBOperationStatLog = new BBOperationStatLog();
//            bBOperationStatLog.op_name = operationRecord.opName;
//            bBOperationStatLog.op_value = operationRecord.opValue;
//            bBOperationStatLog.op_time = operationRecord.opTime;
//            arrayList.add(bBOperationStatLog);
//        }
//        return arrayList;
//    }

    public String getOpName() {
        return this.opName;
    }

    public void setOpName(String str) {
        this.opName = str;
    }

    public int getOpValue() {
        return this.opValue;
    }

    public void setOpValue(int i) {
        this.opValue = i;
    }

    public long getOpTime() {
        return this.opTime;
    }

    public void setOpTime(long j) {
        this.opTime = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WordDoneRecord {");
        sb.append("opName:").append(this.opName).append(", opValue:").append(this.opValue).append(", opTime:").append(this.opTime).append("}");
        return sb.toString();
    }

    public OperationRecord() {
    }

    public OperationRecord(Parcel parcel) {
        this.opName = parcel.readString();
        this.opValue = parcel.readInt();
        this.opTime = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.opName);
        parcel.writeInt(this.opValue);
        parcel.writeLong(this.opTime);
    }
}
