//package com.baicizhan.client.business.stats.operation;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_TB.Columns;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.util.TimeUtil;
//import com.baicizhan.client.framework.log.C0789L;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//
//public class OperationHelper {
//    private OperationHelper() {
//    }
//
//    public static List<OperationRecord> getAllRecords(Context context) {
//        return Cursors.mapToList(QueryBuilder.query(STATS_OPERATION_TB.CONTENT_URI).where("op_time>=?", String.valueOf(TimeUtil.todayStart() - 259200000)).perform(context), OperationRecord.class, OperationRecord.COLUMN_MAP);
//    }
//
//    public static synchronized void saveRecords(Context context, List<OperationRecord> list) {
//        synchronized (OperationHelper.class) {
//            if (list != null) {
//                if (!list.isEmpty()) {
//                    ArrayList<OperationRecord> arrayList = new ArrayList<>();
//                    arrayList.addAll(list);
//                    arrayList.addAll(getAllRecords(context));
//                    HashMap hashMap = new HashMap(arrayList.size());
//                    for (OperationRecord operationRecord : arrayList) {
//                        String str = operationRecord.getOpName() + operationRecord.getOpTime();
//                        if (hashMap.containsKey(str)) {
//                            ((OperationRecord) hashMap.get(str)).setOpValue(operationRecord.getOpValue() + ((OperationRecord) hashMap.get(str)).getOpValue());
//                        } else {
//                            hashMap.put(str, operationRecord);
//                        }
//                    }
//                    ArrayList arrayList2 = new ArrayList(hashMap.values());
//                    ContentValues[] contentValuesArr = new ContentValues[arrayList2.size()];
//                    int i = 0;
//                    Iterator it = arrayList2.iterator();
//                    while (true) {
//                        int i2 = i;
//                        if (it.hasNext()) {
//                            OperationRecord operationRecord2 = (OperationRecord) it.next();
//                            ContentValues contentValues = new ContentValues();
//                            contentValues.put(Columns.OP_NAME, operationRecord2.getOpName());
//                            contentValues.put("op_value", Integer.valueOf(operationRecord2.getOpValue()));
//                            contentValues.put("op_time", Long.valueOf(operationRecord2.getOpTime()));
//                            contentValuesArr[i2] = contentValues;
//                            i = i2 + 1;
//                        } else {
//                            try {
//                                break;
//                            } catch (Exception e) {
//                                C0789L.log.error("bulk insert operation stats records error. ", (Throwable) e);
//                                Log.d("whiz", "insert operation stats records error: " + e);
//                            }
//                        }
//                    }
//                    clear(context);
//                    Log.d("whiz", "insert operation stats records: " + context.getContentResolver().bulkInsert(STATS_OPERATION_TB.CONTENT_URI, contentValuesArr) + "; records size: " + arrayList2.size());
//                }
//            }
//        }
//        return;
//    }
//
//    public static synchronized void clear(Context context) {
//        synchronized (OperationHelper.class) {
//            QueryBuilder.rawQuery(Databases.STATS, "delete from tb_stats_operation", new String[0]).perform(context);
//        }
//    }
//}
