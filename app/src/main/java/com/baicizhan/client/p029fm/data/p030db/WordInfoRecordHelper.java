//package com.baicizhan.client.p029fm.data.p030db;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.models.TopicLearnRecord;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_TOPIC_DATA_ALL;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_TOPIC_DATA_ALL.Columns;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.p029fm.data.FmData;
//import com.baicizhan.client.p029fm.data.FmList;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
///* renamed from: com.baicizhan.client.fm.data.db.WordInfoRecordHelper */
//public class WordInfoRecordHelper {
//    public static List<WordInfoRecord> getWordInfoRecords(Context context, Set<String> set) {
//        ArrayList arrayList = null;
//        if (set != null && !set.isEmpty()) {
//            Cursor perform = QueryBuilder.query(TS_TOPIC_DATA_ALL.CONTENT_URI).whereIn("topic_id", set, 900).perform(context);
//            if (perform != null) {
//                try {
//                    arrayList = new ArrayList(set.size());
//                    while (perform.moveToNext()) {
//                        String string = perform.getString(perform.getColumnIndex("topic_id"));
//                        WordInfoRecord wordInfoRecord = new WordInfoRecord();
//                        wordInfoRecord.wordid = string;
//                        wordInfoRecord.word = perform.getString(perform.getColumnIndex("topic_word"));
//                        wordInfoRecord.accent = perform.getString(perform.getColumnIndex(Columns.TOPIC_ACCENT));
//                        wordInfoRecord.cnmean = perform.getString(perform.getColumnIndex(Columns.TOPIC_WORD_INTERPRET));
//                        wordInfoRecord.example = perform.getString(perform.getColumnIndex(Columns.TOPIC_EXAMPLE));
//                        arrayList.add(wordInfoRecord);
//                    }
//                } finally {
//                    perform.close();
//                }
//            }
//        }
//        return arrayList;
//    }
//
//    public static List<TopicLearnRecord> getTopicLearnRecords(Context context, int i, Set<String> set) {
//        if (set == null || set.isEmpty()) {
//            return null;
//        }
//        return Cursors.mapToList(QueryBuilder.query(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i)).whereIn("topic_id", set, 900).perform(context), TopicLearnRecord.class, TopicLearnRecord.MEDIA_SYNC_COLUMN_MAP);
//    }
//
//    public static List<TopicLearnRecord> getTopicLearntRecords(Context context, int i) {
//        return Cursors.mapToList(QueryBuilder.query(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i)).where("radio_state>? or radio_skip_state=? or radio_skip_state=?", "0", "1", "3").perform(context), TopicLearnRecord.class, TopicLearnRecord.MEDIA_SYNC_COLUMN_MAP);
//    }
//
//    public static void updateFmLearnRecords(Context context, int i, FmList fmList) {
//        int i2;
//        if (fmList != null && !fmList.isEmpty()) {
//            int size = fmList.size();
//            for (int i3 = 0; i3 < size; i3++) {
//                FmData fmData = fmList.get(i3);
//                FmData initedOne = fmData.getInitedOne();
//                Log.d("whiz", "update fm learn record, org: " + initedOne);
//                if (initedOne == null) {
//                    C0789L.log.error("update fm learn records error, inited one is null, data is [{}]", (Object) fmData);
//                } else {
//                    if (fmData.isSkipped() == initedOne.isSkipped() && fmData.getViewedCount() == initedOne.getViewedCount()) {
//                        i2 = 0;
//                    } else {
//                        i2 = 1;
//                    }
//                    Log.d("whiz", "update fm learn record, needPost: " + i2 + "; skipped: " + fmData.isSkipped() + "; viewed: " + fmData.getViewedCount() + "; word: " + fmData.getWord());
//                    if (i2 > 0) {
//                        ContentValues contentValues = new ContentValues();
//                        contentValues.put(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.Columns.RADIO_SKIP_STATE, Integer.valueOf(fmData.getSkipValue()));
//                        contentValues.put(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.Columns.RADIO_STATE, Integer.valueOf(fmData.getViewedCount()));
//                        contentValues.put(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.Columns.RADIO_POST_STATE, Integer.valueOf(i2));
//                        int update = context.getContentResolver().update(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i), contentValues, "topic_id=?", new String[]{fmData.getWordid()});
//                        if (update <= 0) {
//                            C0789L.log.error("update fm learn records failed for unknown reason.");
//                        }
//                        Log.d("whiz", "update fm learn record, update count: " + update);
//                    }
//                }
//            }
//        }
//    }
//}
