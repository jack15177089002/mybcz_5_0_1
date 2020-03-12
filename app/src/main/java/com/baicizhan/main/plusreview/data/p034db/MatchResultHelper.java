//package com.baicizhan.main.plusreview.data.p034db;
//
//import android.content.ContentValues;
//import android.content.Context;
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.dataset.provider.Contracts.PHRASE_MATCH_RESULT_TB;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.ProviderUtils;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.dataset.provider.RawExecBuilder;
//import com.baicizhan.client.framework.log.C0789L;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
///* renamed from: com.baicizhan.main.plusreview.data.db.MatchResultHelper */
//public class MatchResultHelper {
//    public static void refreshResults(Context context, int i, List<MatchResultRecord> list) {
//        if (list != null && !list.isEmpty()) {
//            createTableIfNotExists(context, i);
//            clearResults(context, i);
//            ContentValues[] contentValuesArr = new ContentValues[list.size()];
//            int i2 = 0;
//            Iterator it = list.iterator();
//            while (true) {
//                int i3 = i2;
//                if (it.hasNext()) {
//                    MatchResultRecord matchResultRecord = (MatchResultRecord) it.next();
//                    ContentValues contentValues = new ContentValues();
//                    contentValues.put("word_topic_id", Integer.valueOf(matchResultRecord.getTopicId()));
//                    contentValues.put("result", Integer.valueOf(matchResultRecord.getResult()));
//                    i2 = i3 + 1;
//                    contentValuesArr[i3] = contentValues;
//                } else {
//                    try {
//                        context.getContentResolver().bulkInsert(PHRASE_MATCH_RESULT_TB.getContentUri(i), contentValuesArr);
//                        return;
//                    } catch (Exception e) {
//                        C0789L.log.error("refresh match test results error. ", (Throwable) e);
//                        return;
//                    }
//                }
//            }
//        }
//    }
//
//    public static void clearResults(Context context, int i) {
//        try {
//            createTableIfNotExists(context, i);
//            context.getContentResolver().delete(PHRASE_MATCH_RESULT_TB.getContentUri(i), null, null);
//        } catch (Exception e) {
//            C0789L.log.error("clear match test results failed.", (Throwable) e);
//        }
//    }
//
//    public static Map<Integer, MatchResultRecord> getResults(Context context, int i) {
//        createTableIfNotExists(context, i);
//        List<MatchResultRecord> mapToList = Cursors.mapToList(QueryBuilder.query(PHRASE_MATCH_RESULT_TB.getContentUri(i)).perform(context), MatchResultRecord.class, MatchResultRecord.COLUMN_MAP);
//        if (mapToList == null || mapToList.isEmpty()) {
//            return null;
//        }
//        HashMap hashMap = new HashMap();
//        for (MatchResultRecord matchResultRecord : mapToList) {
//            hashMap.put(Integer.valueOf(matchResultRecord.getTopicId()), matchResultRecord);
//        }
//        return hashMap;
//    }
//
//    private static void createTableIfNotExists(Context context, int i) {
//        if (!ProviderUtils.queryTableExists(context, Databases.TOPIC_PROBLEM, PHRASE_MATCH_RESULT_TB.getTableName(i))) {
//            StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
//            sb.append(PHRASE_MATCH_RESULT_TB.getTableName(i)).append("(word_topic_id INTEGER, result INTEGER)");
//            RawExecBuilder.m2792on(Databases.TOPIC_PROBLEM).exec(sb.toString(), new String[0]).perform(context);
//        }
//    }
//}
