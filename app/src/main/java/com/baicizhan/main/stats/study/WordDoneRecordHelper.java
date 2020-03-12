//package com.baicizhan.main.stats.study;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_WORD_DONE_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.STATS_WORD_DONE_TB.Columns;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.framework.log.C0789L;
//import java.util.Iterator;
//import java.util.List;
//
//public class WordDoneRecordHelper {
//    private WordDoneRecordHelper() {
//    }
//
//    public static List<WordDoneRecord> getAllRecords(Context context) {
//        return Cursors.mapToList(QueryBuilder.query(STATS_WORD_DONE_TB.CONTENT_URI).perform(context), WordDoneRecord.class, WordDoneRecord.COLUMN_MAP);
//    }
//
//    public static synchronized void saveRecords(Context context, List<WordDoneRecord> list) {
//        synchronized (WordDoneRecordHelper.class) {
//            if (list != null) {
//                if (!list.isEmpty()) {
//                    ContentValues[] contentValuesArr = new ContentValues[list.size()];
//                    int i = 0;
//                    Iterator it = list.iterator();
//                    while (true) {
//                        int i2 = i;
//                        if (it.hasNext()) {
//                            WordDoneRecord wordDoneRecord = (WordDoneRecord) it.next();
//                            ContentValues contentValues = new ContentValues();
//                            contentValues.put("topic_id", Integer.valueOf(wordDoneRecord.getTopicId()));
//                            contentValues.put("is_today_new", Integer.valueOf(wordDoneRecord.getIsTodyNew()));
//                            contentValues.put(Columns.IS_DONE_RIGHT, Integer.valueOf(wordDoneRecord.getIsDoneRight()));
//                            contentValues.put(Columns.OPTION, Integer.valueOf(wordDoneRecord.getOption()));
//                            contentValues.put(Columns.DONE_TYPE, Integer.valueOf(wordDoneRecord.getDoneType()));
//                            contentValues.put(Columns.DURATION, Integer.valueOf(wordDoneRecord.getDuration()));
//                            contentValuesArr[i2] = contentValues;
//                            i = i2 + 1;
//                        } else {
//                            try {
//                                break;
//                            } catch (Exception e) {
//                                C0789L.log.error("bulk insert word done records error. ", (Throwable) e);
//                                Log.d("whiz", "insert word done records error: " + e);
//                            }
//                        }
//                    }
//                    Log.d("whiz", "insert word done records: " + context.getContentResolver().bulkInsert(STATS_WORD_DONE_TB.CONTENT_URI, contentValuesArr) + "; records size: " + list.size());
//                }
//            }
//        }
//        return;
//    }
//
//    public static synchronized void clear(Context context) {
//        synchronized (WordDoneRecordHelper.class) {
//            QueryBuilder.rawQuery(Databases.STATS, "delete from tb_stats_word_done", new String[0]).perform(context);
//        }
//    }
//}
