//package com.baicizhan.client.business.stats.operation;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.text.TextUtils;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_COMMON_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_OPERATION_COMMON_TB.Columns;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.util.TimeUtil;
//import com.baicizhan.client.framework.log.C0789L;
//import java.util.Iterator;
//import java.util.List;
//
//public class OpCommonHelper {
//    public static final int TYPE_WORDLOCK = 0;
//
//    private OpCommonHelper() {
//    }
//
//    public static List<OpCommonRecord> getSegmentRecords(Context context, int i, int i2) {
//        if (i2 <= 0) {
//            return null;
//        }
//        long j = TimeUtil.todayStart() - 259200000;
//        int i3 = 0;
//        int i4 = 0;
//        while (true) {
//            int i5 = i3 + i2;
//            List<OpCommonRecord> mapToList = Cursors.mapToList(QueryBuilder.query(STATS_OPERATION_COMMON_TB.CONTENT_URI).where("op_time>=? AND op_type=?", String.valueOf(j), String.valueOf(i)).limit(i5).perform(context), OpCommonRecord.class, OpCommonRecord.COLUMN_MAP);
//            if (mapToList != null && !mapToList.isEmpty()) {
//                int size = mapToList.size();
//                for (OpCommonRecord opValue : mapToList) {
//                    if (!TextUtils.isEmpty(opValue.getOpValue())) {
//                        i4++;
//                    }
//                }
//                if (i4 < i2 / 2 && size >= i5) {
//                    return mapToList;
//                }
//                i3 = i5;
//            }
//        }
//        return null;
//    }
//
//    public static void clearRecords(Context context, int i, int i2) {
//        QueryBuilder.rawQuery(Databases.STATS, "delete from tb_stats_operation_common", new String[0]).where("op_time>=? AND op_type=? AND id<=?", String.valueOf(TimeUtil.todayStart() - 259200000), String.valueOf(i), String.valueOf(i2)).perform(context);
//    }
//
//    public static synchronized void saveRecords(Context context, List<OpCommonRecord> list) {
//        synchronized (OpCommonHelper.class) {
//            if (list != null) {
//                if (!list.isEmpty()) {
//                    ContentValues[] contentValuesArr = new ContentValues[list.size()];
//                    int i = 0;
//                    Iterator it = list.iterator();
//                    while (true) {
//                        int i2 = i;
//                        if (it.hasNext()) {
//                            OpCommonRecord opCommonRecord = (OpCommonRecord) it.next();
//                            ContentValues contentValues = new ContentValues();
//                            contentValues.put(Columns.OP_TYPE, Integer.valueOf(opCommonRecord.getOpType()));
//                            contentValues.put("op_time", Long.valueOf(opCommonRecord.getOpTime()));
//                            contentValues.put("op_value", opCommonRecord.getOpValue());
//                            contentValuesArr[i2] = contentValues;
//                            i = i2 + 1;
//                        } else {
//                            try {
//                                break;
//                            } catch (Exception e) {
//                                C0789L.log.error("bulk insert operation common stats records error. ", (Throwable) e);
//                                Log.d("whiz", "insert operation common stats records error: " + e);
//                            }
//                        }
//                    }
//                    Log.d("whiz", "insert operation common stats records: " + context.getContentResolver().bulkInsert(STATS_OPERATION_COMMON_TB.CONTENT_URI, contentValuesArr) + "; records size: " + list.size());
//                }
//            }
//        }
//        return;
//    }
//
//    public static synchronized void saveRecord(Context context, OpCommonRecord opCommonRecord) {
//        synchronized (OpCommonHelper.class) {
//            if (opCommonRecord != null) {
//                try {
//                    ContentValues contentValues = new ContentValues();
//                    contentValues.put(Columns.OP_TYPE, Integer.valueOf(opCommonRecord.getOpType()));
//                    contentValues.put("op_time", Long.valueOf(opCommonRecord.getOpTime()));
//                    contentValues.put("op_value", opCommonRecord.getOpValue());
//                    context.getContentResolver().insert(STATS_OPERATION_COMMON_TB.CONTENT_URI, contentValues);
//                } catch (Exception e) {
//                    C0789L.log.error("bulk insert operation common stats records error. ", (Throwable) e);
//                    Log.d("whiz", "insert operation common stats records error: " + e);
//                }
//            }
//        }
//        return;
//    }
//
//    public static synchronized void clearExpiredRecords(Context context) {
//        synchronized (OpCommonHelper.class) {
//            QueryBuilder.rawQuery(Databases.STATS, "delete from tb_stats_operation_common", new String[0]).where("op_time<?", String.valueOf(TimeUtil.todayStart() - 259200000)).perform(context);
//        }
//    }
//}
