//package com.baicizhan.client.business.dataset.helpers;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.text.TextUtils;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.models.TopicLearnRecord;
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_OFFLINE_DOTOPIC_SYNC_IDS;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.Cursors.KeyGetter;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.dataset.provider.RawExecBuilder;
//import com.baicizhan.client.business.util.LogWrapper;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//
//public class TopicLearnRecordHelper {
//    public static void createTotalTopicLearnRecordTable(Context context, int i) {
//        RawExecBuilder.m2792on(Databases.TOPIC_PROBLEM).exec("CREATE TABLE IF NOT EXISTS " + TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookTableName(i) + "(topic_id  integer primary key,topic_obn integer, topic_day integer, total_time integer, do_num integer, err_num integer, sync_state integer, is_today_new integer, last_do_time integer, zijian_state integer default 0, radio_state integer default 0, radio_post_state integer default 0, radio_skip_state integer default 0, review_more_count integer default 0, radio_tv_state integer default 0)", new String[0]).perform(context);
//    }
//
//    public static void createSyncingTopicLearnRecordTable(Context context, int i) {
//        RawExecBuilder.m2792on(Databases.TOPIC_PROBLEM).exec("CREATE TABLE IF NOT EXISTS " + TS_OFFLINE_DOTOPIC_SYNC_IDS.getBookTableName(i) + "(topic_id  integer primary key,topic_obn integer, topic_day integer, total_time integer, do_num integer, err_num integer, sync_state integer, is_today_new integer, last_do_time integer)", new String[0]).perform(context);
//    }
//
//    public static TopicLearnRecord getTotalTopicLearnRecordById(Context context, int i, int i2) {
//        return (TopicLearnRecord) Cursors.mapToUnique(QueryBuilder.query(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i)).where("topic_id = " + i2, new String[0]).perform(context), TopicLearnRecord.class, TopicLearnRecord.TOTAL_TABLE_COLUMN_MAP);
//    }
//
//    public static Map<Integer, TopicLearnRecord> getTotalTopicLearnRecords(Context context, int i) {
//        return Cursors.reduceToDict(QueryBuilder.query(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i)).perform(context), TopicLearnRecord.class, TopicLearnRecord.TOTAL_TABLE_COLUMN_MAP, new KeyGetter<Integer, TopicLearnRecord>() {
//            public final Integer get(TopicLearnRecord topicLearnRecord) {
//                return Integer.valueOf(topicLearnRecord.topicId);
//            }
//        });
//    }
//
//    public static TopicLearnRecord getSyncingTopicLearnRecordById(Context context, int i, int i2) {
//        return (TopicLearnRecord) Cursors.mapToUnique(QueryBuilder.query(TS_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i)).where("topic_id = " + i2, new String[0]).perform(context), TopicLearnRecord.class, TopicLearnRecord.TOTAL_TABLE_COLUMN_MAP);
//    }
//
//    public static Map<Integer, TopicLearnRecord> getSyncingTopicLearnRecords(Context context, int i) {
//        return Cursors.reduceToDict(QueryBuilder.query(TS_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i)).perform(context), TopicLearnRecord.class, TopicLearnRecord.SYNCING_TABLE_COLUMN_MAP, new KeyGetter<Integer, TopicLearnRecord>() {
//            public final Integer get(TopicLearnRecord topicLearnRecord) {
//                return Integer.valueOf(topicLearnRecord.topicId);
//            }
//        });
//    }
//
//    public static void deleteTotalTopicLearnRecords(Context context, int i, List<Integer> list) {
//        String str = "topic_id in (" + TextUtils.join(",", list) + ")";
//        context.getContentResolver().delete(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i), str, null);
//    }
//
//    public static void deleteSyncingTopicLearnRecords(Context context, int i, List<Integer> list) {
//        String str = "topic_id in (" + TextUtils.join(",", list) + ")";
//        context.getContentResolver().delete(TS_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i), str, null);
//    }
//
//    public static void saveTotalTopicLearnRecord(Context context, int i, TopicLearnRecord topicLearnRecord) {
//        try {
//            context.getContentResolver().insert(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i), Cursors.convertContentValues(topicLearnRecord, TopicLearnRecord.class, TopicLearnRecord.TOTAL_TABLE_COLUMN_MAP, null));
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
//        }
//    }
//
//    public static int saveTotalTopicLearnRecords(Context context, int i, Collection<TopicLearnRecord> collection) {
//        try {
//            return Cursors.safeBulkInsert(context, TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i), Cursors.bulkConvertContentValues(collection, TopicLearnRecord.class, TopicLearnRecord.TOTAL_TABLE_COLUMN_MAP, (String[]) null), 500);
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
//            return 0;
//        }
//    }
//
//    public static void saveSyncingTopicLearnRecord(Context context, int i, TopicLearnRecord topicLearnRecord) {
//        try {
//            context.getContentResolver().insert(TS_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i), Cursors.convertContentValues(topicLearnRecord, TopicLearnRecord.class, TopicLearnRecord.SYNCING_TABLE_COLUMN_MAP, null));
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
//        }
//    }
//
//    public static int saveSyncingTopicLearnRecords(Context context, int i, Collection<TopicLearnRecord> collection) {
//        try {
//            return Cursors.safeBulkInsert(context, TS_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i), Cursors.bulkConvertContentValues(collection, TopicLearnRecord.class, TopicLearnRecord.SYNCING_TABLE_COLUMN_MAP, (String[]) null), 500);
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
//            return 0;
//        }
//    }
//
//    public static void updateTopicLearnRecordScore(Context context, int i, int i2, int i3) {
//        try {
//            ContentValues contentValues = new ContentValues();
//            contentValues.put("topic_obn", Integer.valueOf(i3));
//            context.getContentResolver().update(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i), contentValues, "topic_id = " + i2, null);
//            context.getContentResolver().update(TS_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i), contentValues, "topic_id = " + i2, null);
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
//        }
//    }
//
//    public static void incBookTopicDay(Context context, int i, int i2) {
//        RawExecBuilder.m2792on(Databases.TOPIC_PROBLEM).exec("UPDATE " + TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookTableName(i) + " SET topic_day = topic_day + 1, is_today_new = 0", new String[0]);
//        context.getContentResolver().delete(TS_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i), "sync_state=1", null);
//        RawExecBuilder.m2792on(Databases.TOPIC_PROBLEM).exec("UPDATE " + TS_OFFLINE_DOTOPIC_SYNC_IDS.getBookTableName(i) + " SET topic_day = topic_day + " + i2 + ", is_today_new = 0", new String[0]).perform(context);
//        RawExecBuilder.m2792on(Databases.TOPIC_PROBLEM).exec("UPDATE " + TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookTableName(i) + " SET topic_day = topic_day + " + i2 + ", is_today_new = 0", new String[0]).perform(context);
//    }
//}
