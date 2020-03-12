//package com.baicizhan.client.business.dataset.helpers;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.text.TextUtils;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.models.TopicLearnRecord;
//import com.baicizhan.client.business.dataset.models.WordMediaMidRecord;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.business.dataset.models.WordMediaUpdRecord;
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_MEDIA_BOOK_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_MEDIA_MID_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_MEDIA_MID_UPD_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_MEDIA_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_MEDIA_TB.Columns;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_MEDIA_UPD_TB;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.ProviderUtils;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.dataset.provider.RawExecBuilder;
//import com.baicizhan.client.framework.log.C0789L;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//
//public class WordMediaRecordHelper {
//    public static final String DEF_FM_END = "/pianwei.baicizhan";
//    public static final String DEF_FM_START = "/kaichang.baicizhan";
//    private static final int INSERT_SEGMENT = 100;
//    public static final int MEDIA_FM = 0;
//    public static final int MEDIA_TV = 1;
//    public static final int TYPE_FM_END = 3;
//    public static final int TYPE_FM_MID = 0;
//    public static final int TYPE_FM_START = 2;
//    public static final int TYPE_TV_MID = 1;
//
//    public static synchronized void createTablesIfNotExists(Context context, int i) {
//        synchronized (WordMediaRecordHelper.class) {
//            if (!ProviderUtils.queryTableExists(context, Databases.WORD_MEDIA, WORD_MEDIA_TB.getTableName(i))) {
//                StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
//                sb.append(WORD_MEDIA_TB.getTableName(i)).append("(topic_id INTEGER PRIMARY KEY, topic_word TEXT, topic_word_type TEXT, topic_word_cnmean TEXT, topic_sentence TEXT, m4a_audio_path TEXT, amr_audio_path TEXT, tv_path TEXT, tv_snapshot_path TEXT DEFAULT \"\",fm_updated_at INTEGER, tv_updated_at INTEGER)");
//                RawExecBuilder.m2792on(Databases.WORD_MEDIA).exec(sb.toString(), new String[0]).perform(context);
//            }
//            if (!ProviderUtils.queryTableExists(context, Databases.WORD_MEDIA, WORD_MEDIA_UPD_TB.getTableName(i))) {
//                StringBuilder sb2 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
//                sb2.append(WORD_MEDIA_UPD_TB.getTableName(i)).append("(word_topic_id INTEGER PRIMARY KEY, fm_updated_at INTEGER, tv_updated_at INTEGER)");
//                RawExecBuilder.m2792on(Databases.WORD_MEDIA).exec(sb2.toString(), new String[0]).perform(context);
//            }
//        }
//    }
//
//    public static WordMediaRecord getWordMediaRecord(Context context, int i, String str, int i2) {
//        if (TextUtils.isEmpty(str)) {
//            return null;
//        }
//        return (WordMediaRecord) Cursors.mapToUnique(QueryBuilder.query(WORD_MEDIA_TB.getContentUri(i)).where((i2 == 0 ? "fm_updated_at<>?" : "tv_updated_at<>?") + " and topic_id=?", "0", str).perform(context), WordMediaRecord.class, WordMediaRecord.COLUMN_MAP);
//    }
//
//    public static synchronized void insertWordMediaRecords(Context context, int i, List<WordMediaRecord> list) {
//        synchronized (WordMediaRecordHelper.class) {
//            if (list != null) {
//                if (!list.isEmpty()) {
//                    int size = (list.size() + 100) / 100;
//                    for (int i2 = 0; i2 < size; i2++) {
//                        int i3 = i2 * 100;
//                        int min = Math.min(list.size(), (i2 + 1) * 100);
//                        ContentValues[] contentValuesArr = new ContentValues[(min - i3)];
//                        int i4 = i3;
//                        int i5 = 0;
//                        while (i4 < min) {
//                            WordMediaRecord wordMediaRecord = (WordMediaRecord) list.get(i4);
//                            ContentValues contentValues = new ContentValues();
//                            contentValues.put("topic_id", wordMediaRecord.getWordid());
//                            contentValues.put("topic_word", wordMediaRecord.getWord());
//                            contentValues.put(Columns.TOPIC_WORD_TYPE, wordMediaRecord.getWordtype());
//                            contentValues.put(Columns.TOPIC_WORD_CNMEAN, wordMediaRecord.getCnmean());
//                            contentValues.put(Columns.TOPIC_SENTENCE, wordMediaRecord.getExample());
//                            contentValues.put(Columns.AMR_AUDIO_PATH, wordMediaRecord.getFmpath());
//                            contentValues.put(Columns.M4A_AUDIO_PATH, wordMediaRecord.getHighfmpath());
//                            contentValues.put(Columns.TV_PATH, wordMediaRecord.getTvpath());
//                            contentValues.put(Columns.TV_SNAPSHOT_PATH, wordMediaRecord.getTvSnapshotPath());
//                            contentValues.put("fm_updated_at", Long.valueOf(wordMediaRecord.getFmupdate()));
//                            contentValues.put("tv_updated_at", Long.valueOf(wordMediaRecord.getTvupdate()));
//                            contentValuesArr[i5] = contentValues;
//                            i4++;
//                            i5++;
//                        }
//                        try {
//                            Log.d("whiz", "insert word media records: " + context.getContentResolver().bulkInsert(WORD_MEDIA_TB.getContentUri(i), contentValuesArr) + "; records size: " + list.size());
//                        } catch (Exception e) {
//                            C0789L.log.error("bulk insert word media records error. ", (Throwable) e);
//                            Log.d("whiz", "insert word media records error: " + e);
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    public static synchronized void updateWordMediaRecords(Context context, int i, List<WordMediaRecord> list, boolean z) {
//        synchronized (WordMediaRecordHelper.class) {
//            if (list != null) {
//                if (!list.isEmpty()) {
//                    if (z) {
//                        try {
//                            context.getContentResolver().delete(WORD_MEDIA_TB.getContentUri(i), null, null);
//                        } catch (Exception e) {
//                            C0789L.log.error("delete word media records error. ", (Throwable) e);
//                        }
//                        insertWordMediaRecords(context, i, list);
//                    } else {
//                        try {
//                            for (WordMediaRecord wordMediaRecord : list) {
//                                ContentValues contentValues = new ContentValues();
//                                contentValues.put("topic_id", wordMediaRecord.getWordid());
//                                contentValues.put("topic_word", wordMediaRecord.getWord());
//                                contentValues.put(Columns.TOPIC_WORD_TYPE, wordMediaRecord.getWordtype());
//                                contentValues.put(Columns.TOPIC_WORD_CNMEAN, wordMediaRecord.getCnmean());
//                                contentValues.put(Columns.TOPIC_SENTENCE, wordMediaRecord.getExample());
//                                contentValues.put(Columns.AMR_AUDIO_PATH, wordMediaRecord.getFmpath());
//                                contentValues.put(Columns.M4A_AUDIO_PATH, wordMediaRecord.getHighfmpath());
//                                contentValues.put(Columns.TV_PATH, wordMediaRecord.getTvpath());
//                                contentValues.put(Columns.TV_SNAPSHOT_PATH, wordMediaRecord.getTvSnapshotPath());
//                                contentValues.put("fm_updated_at", Long.valueOf(wordMediaRecord.getFmupdate()));
//                                contentValues.put("tv_updated_at", Long.valueOf(wordMediaRecord.getTvupdate()));
//                                context.getContentResolver().update(WORD_MEDIA_TB.getContentUri(i), contentValues, "topic_id=?", new String[]{wordMediaRecord.getWordid()});
//                            }
//                        } catch (Exception e2) {
//                            C0789L.log.error("update word media records error. ", (Throwable) e2);
//                        }
//                    }
//                }
//            }
//        }
//        return;
//    }
//
//    public static Set<String> filterNullWordMediaIds(Context context, int i, Set<String> set, int i2) {
//        if (set == null || set.isEmpty()) {
//            return null;
//        }
//        Cursor perform = QueryBuilder.query(WORD_MEDIA_UPD_TB.getContentUri(i)).where(i2 == 0 ? "fm_updated_at=?" : "tv_updated_at=?", "0").perform(context);
//        if (perform == null) {
//            return set;
//        }
//        while (perform.moveToNext()) {
//            try {
//                set.remove(perform.getString(perform.getColumnIndex("word_topic_id")));
//            } finally {
//                perform.close();
//            }
//        }
//        return set;
//    }
//
//    public static List<WordMediaRecord> getWordMediaRecords(Context context, int i, Set<String> set, int i2) {
//        if (set == null || set.isEmpty()) {
//            return null;
//        }
//        Cursor perform = QueryBuilder.query(WORD_MEDIA_TB.getContentUri(i)).where(i2 == 0 ? "fm_updated_at<>?" : "tv_updated_at<>?", "0").perform(context);
//        if (perform == null) {
//            return null;
//        }
//        try {
//            ArrayList arrayList = new ArrayList(set.size());
//            while (perform.moveToNext()) {
//                String string = perform.getString(perform.getColumnIndex("topic_id"));
//                if (set.contains(string)) {
//                    WordMediaRecord wordMediaRecord = new WordMediaRecord();
//                    wordMediaRecord.setWordid(string);
//                    wordMediaRecord.setWord(perform.getString(perform.getColumnIndex("topic_word")));
//                    wordMediaRecord.setCnmean(perform.getString(perform.getColumnIndex(Columns.TOPIC_WORD_CNMEAN)));
//                    wordMediaRecord.setWordtype(perform.getString(perform.getColumnIndex(Columns.TOPIC_WORD_TYPE)));
//                    wordMediaRecord.setExample(perform.getString(perform.getColumnIndex(Columns.TOPIC_SENTENCE)));
//                    wordMediaRecord.setFmpath(perform.getString(perform.getColumnIndex(Columns.AMR_AUDIO_PATH)));
//                    wordMediaRecord.setHighfmpath(perform.getString(perform.getColumnIndex(Columns.M4A_AUDIO_PATH)));
//                    wordMediaRecord.setTvpath(perform.getString(perform.getColumnIndex(Columns.TV_PATH)));
//                    wordMediaRecord.setTvSnapshotPath(perform.getString(perform.getColumnIndex(Columns.TV_SNAPSHOT_PATH)));
//                    wordMediaRecord.setFmupdate(perform.getLong(perform.getColumnIndex("fm_updated_at")));
//                    wordMediaRecord.setTvupdate(perform.getLong(perform.getColumnIndex("tv_updated_at")));
//                    arrayList.add(wordMediaRecord);
//                }
//            }
//            return arrayList;
//        } finally {
//            perform.close();
//        }
//    }
//
//    public static Set<Integer> getMediaIds(Context context, int i, int i2) {
//        Cursor perform = QueryBuilder.query(WORD_MEDIA_UPD_TB.getContentUri(i)).where(i2 == 0 ? "fm_updated_at<>?" : "tv_updated_at<>?", "0").perform(context);
//        if (perform == null) {
//            return null;
//        }
//        try {
//            HashSet hashSet = new HashSet();
//            while (perform.moveToNext()) {
//                hashSet.add(Integer.valueOf(perform.getInt(perform.getColumnIndex("word_topic_id"))));
//            }
//            return hashSet;
//        } finally {
//            perform.close();
//        }
//    }
//
//    public static synchronized void refreshWordMediaUpdRecords(Context context, int i, List<WordMediaUpdRecord> list) {
//        synchronized (WordMediaRecordHelper.class) {
//            if (list != null) {
//                if (!list.isEmpty()) {
//                    ContentValues[] contentValuesArr = new ContentValues[list.size()];
//                    int i2 = 0;
//                    Iterator it = list.iterator();
//                    while (true) {
//                        int i3 = i2;
//                        if (it.hasNext()) {
//                            WordMediaUpdRecord wordMediaUpdRecord = (WordMediaUpdRecord) it.next();
//                            ContentValues contentValues = new ContentValues();
//                            contentValues.put("word_topic_id", wordMediaUpdRecord.getWordid());
//                            contentValues.put("fm_updated_at", Long.valueOf(wordMediaUpdRecord.getFmupdate()));
//                            contentValues.put("tv_updated_at", Long.valueOf(wordMediaUpdRecord.getTvupdate()));
//                            contentValuesArr[i3] = contentValues;
//                            i2 = i3 + 1;
//                        } else {
//                            try {
//                                break;
//                            } catch (Exception e) {
//                                C0789L.log.error("refresh word media update records error. ", (Throwable) e);
//                            }
//                        }
//                    }
//                    context.getContentResolver().delete(WORD_MEDIA_UPD_TB.getContentUri(i), null, null);
//                    context.getContentResolver().bulkInsert(WORD_MEDIA_UPD_TB.getContentUri(i), contentValuesArr);
//                }
//            }
//        }
//        return;
//    }
//
//    public static boolean isWordMediaUpdRecordsEmpty(Context context, int i) {
//        StringBuilder sb = new StringBuilder("select distinct ");
//        sb.append("word_topic_id from ").append(WORD_MEDIA_UPD_TB.getTableName(i));
//        Cursor perform = QueryBuilder.rawQuery(Databases.WORD_MEDIA, sb.toString(), null).perform(context);
//        boolean z = perform == null || perform.getCount() <= 0;
//        if (perform != null) {
//            perform.close();
//        }
//        return z;
//    }
//
//    public static List<String> getAllWordMediaRecordsFromUpdate(Context context, int i) {
//        StringBuilder sb = new StringBuilder("select distinct ");
//        sb.append("word_topic_id from ").append(WORD_MEDIA_UPD_TB.getTableName(i));
//        Cursor perform = QueryBuilder.rawQuery(Databases.WORD_MEDIA, sb.toString(), new String[0]).perform(context);
//        if (perform == null) {
//            return null;
//        }
//        try {
//            ArrayList arrayList = new ArrayList();
//            while (perform.moveToNext()) {
//                arrayList.add(perform.getString(perform.getColumnIndex("word_topic_id")));
//            }
//            return arrayList;
//        } finally {
//            perform.close();
//        }
//    }
//
//    public static List<String> getAllExistWordMediaRecordsFromUpdate(Context context, int i, int i2) {
//        StringBuilder sb = new StringBuilder("select distinct ");
//        sb.append("word_topic_id from ").append(WORD_MEDIA_UPD_TB.getTableName(i)).append(" where ").append(i2 == 0 ? "fm_updated_at" : "tv_updated_at").append("<>?");
//        Cursor perform = QueryBuilder.rawQuery(Databases.WORD_MEDIA, sb.toString(), "0").perform(context);
//        if (perform == null) {
//            return null;
//        }
//        try {
//            ArrayList arrayList = new ArrayList();
//            while (perform.moveToNext()) {
//                arrayList.add(perform.getString(perform.getColumnIndex("word_topic_id")));
//            }
//            return arrayList;
//        } finally {
//            perform.close();
//        }
//    }
//
//    public static List<String> getWordMediaRecordsToUpdate(Context context, int i) {
//        String tableName = WORD_MEDIA_TB.getTableName(i);
//        String tableName2 = WORD_MEDIA_UPD_TB.getTableName(i);
//        StringBuilder sb = new StringBuilder("select distinct ");
//        sb.append(tableName2).append(".word_topic_id from ").append(tableName2).append(" join ").append(tableName).append(" on ").append(tableName2).append(".word_topic_id=").append(tableName).append(".topic_id where ").append(tableName2).append(".fm_updated_at<>").append(tableName).append(".fm_updated_at or ").append(tableName2).append(".tv_updated_at<>").append(tableName).append(".tv_updated_at");
//        Cursor perform = QueryBuilder.rawQuery(Databases.WORD_MEDIA, sb.toString(), new String[0]).perform(context);
//        if (perform == null) {
//            return null;
//        }
//        try {
//            ArrayList arrayList = new ArrayList();
//            while (perform.moveToNext()) {
//                arrayList.add(perform.getString(perform.getColumnIndex("word_topic_id")));
//            }
//            return arrayList;
//        } finally {
//            perform.close();
//        }
//    }
//
//    /* JADX INFO: finally extract failed */
//    public static synchronized boolean refreshWordMediaMidUpdTime(Context context, long j, long j2) {
//        boolean z = true;
//        boolean z2 = false;
//        synchronized (WordMediaRecordHelper.class) {
//            ContentValues contentValues = new ContentValues();
//            contentValues.put("fm_mid_update", Long.valueOf(j));
//            contentValues.put("tv_mid_update", Long.valueOf(j2));
//            Cursor perform = QueryBuilder.query(WORD_MEDIA_MID_UPD_TB.CONTENT_URI).perform(context);
//            if (perform == null || perform.getCount() == 0) {
//                if (context.getContentResolver().insert(WORD_MEDIA_MID_UPD_TB.CONTENT_URI, contentValues) != null) {
//                    z2 = true;
//                }
//            } else if (j > 0 || j2 > 0) {
//                try {
//                    if (perform.moveToFirst()) {
//                        long j3 = perform.getLong(perform.getColumnIndex("fm_mid_update"));
//                        long j4 = perform.getLong(perform.getColumnIndex("tv_mid_update"));
//                        if (!(j3 == j && j4 == j2)) {
//                            ContentValues contentValues2 = new ContentValues();
//                            String str = "fm_mid_update";
//                            if (j == j3) {
//                                j = j3;
//                            }
//                            contentValues2.put(str, Long.valueOf(j));
//                            String str2 = "tv_mid_update";
//                            if (j2 == j4) {
//                                j2 = j4;
//                            }
//                            contentValues2.put(str2, Long.valueOf(j2));
//                            if (context.getContentResolver().update(WORD_MEDIA_MID_UPD_TB.CONTENT_URI, contentValues2, null, null) <= 0) {
//                                z = false;
//                            }
//                            perform.close();
//                            z2 = z;
//                        }
//                    }
//                    perform.close();
//                } catch (Throwable th) {
//                    perform.close();
//                    throw th;
//                }
//            }
//        }
//        return z2;
//    }
//
//    public static synchronized void refreshWordMediaMidRecords(Context context, List<WordMediaMidRecord> list) {
//        synchronized (WordMediaRecordHelper.class) {
//            if (list != null) {
//                if (!list.isEmpty()) {
//                    ContentValues[] contentValuesArr = new ContentValues[list.size()];
//                    int i = 0;
//                    Iterator it = list.iterator();
//                    while (true) {
//                        int i2 = i;
//                        if (it.hasNext()) {
//                            WordMediaMidRecord wordMediaMidRecord = (WordMediaMidRecord) it.next();
//                            ContentValues contentValues = new ContentValues();
//                            contentValues.put("path", wordMediaMidRecord.getPath());
//                            contentValues.put("type", Integer.valueOf(wordMediaMidRecord.getType()));
//                            contentValuesArr[i2] = contentValues;
//                            i = i2 + 1;
//                        } else {
//                            try {
//                                break;
//                            } catch (Exception e) {
//                                C0789L.log.error("refresh word media mid records error. ", (Throwable) e);
//                            }
//                        }
//                    }
//                    context.getContentResolver().delete(WORD_MEDIA_MID_TB.CONTENT_URI, null, null);
//                    Log.d("whiz", "refresh word media mid records, inserted: " + context.getContentResolver().bulkInsert(WORD_MEDIA_MID_TB.CONTENT_URI, contentValuesArr));
//                }
//            }
//        }
//        return;
//    }
//
//    public static List<WordMediaMidRecord> getWordMediaMidRecords(Context context, int i) {
//        if (i == 0 || i == 1) {
//            return Cursors.mapToList(QueryBuilder.query(WORD_MEDIA_MID_TB.CONTENT_URI).where("type=?", String.valueOf(i)).perform(context), WordMediaMidRecord.class, WordMediaMidRecord.COLUMN_MAP);
//        }
//        C0789L.log.error("cannot get word media mid records for incorrect type [{}]", (Object) Integer.valueOf(i));
//        return null;
//    }
//
//    public static String getBorderMediaPath(Context context, int i) {
//        if (i == 2 || i == 3) {
//            Cursor perform = QueryBuilder.query(WORD_MEDIA_MID_TB.CONTENT_URI).where("type=?", String.valueOf(i)).perform(context);
//            if (perform == null) {
//                return getDefPath(i);
//            }
//            try {
//                if (perform.moveToFirst()) {
//                    String string = perform.getString(perform.getColumnIndex("path"));
//                    if (TextUtils.isEmpty(string)) {
//                        string = getDefPath(i);
//                    }
//                    return string;
//                }
//                perform.close();
//                return getDefPath(i);
//            } finally {
//                perform.close();
//            }
//        } else {
//            C0789L.log.error("cannot get border media path for incorrect type [{}]", (Object) Integer.valueOf(i));
//            return null;
//        }
//    }
//
//    private static String getDefPath(int i) {
//        if (2 == i) {
//            return DEF_FM_START;
//        }
//        if (3 == i) {
//            return DEF_FM_END;
//        }
//        return null;
//    }
//
//    public static synchronized void refreshWordMediaReviewRecords(Context context, int i, List<TopicLearnRecord> list) {
//        synchronized (WordMediaRecordHelper.class) {
//            if (list != null) {
//                if (!list.isEmpty()) {
//                    for (TopicLearnRecord topicLearnRecord : list) {
//                        ContentValues contentValues = new ContentValues();
//                        contentValues.put(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.Columns.RADIO_STATE, Integer.valueOf(topicLearnRecord.radioState));
//                        contentValues.put(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.Columns.RADIO_TV_STATE, Integer.valueOf(topicLearnRecord.radioTVState));
//                        contentValues.put(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.Columns.RADIO_SKIP_STATE, Integer.valueOf(topicLearnRecord.radioSkipState));
//                        contentValues.put(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.Columns.RADIO_POST_STATE, Integer.valueOf(0));
//                        context.getContentResolver().update(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i), contentValues, "topic_id=?", new String[]{String.valueOf(topicLearnRecord.topicId)});
//                    }
//                }
//            }
//        }
//    }
//
//    public static List<TopicLearnRecord> getWordMediaReviewRecordsNeedSync(Context context, int i) {
//        return Cursors.mapToList(QueryBuilder.query(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i)).where("radio_post_state=?", "1").perform(context), TopicLearnRecord.class, TopicLearnRecord.MEDIA_SYNC_COLUMN_MAP);
//    }
//
//    /* JADX INFO: finally extract failed */
//    public static boolean isBookLoaded(Context context, int i) {
//        boolean z = true;
//        Cursor perform = QueryBuilder.query(WORD_MEDIA_BOOK_TB.CONTENT_URI).where("loaded_book_id=?", String.valueOf(i)).perform(context);
//        if (perform == null) {
//            return false;
//        }
//        try {
//            if (perform.getCount() <= 0) {
//                z = false;
//            }
//            perform.close();
//            return z;
//        } catch (Throwable th) {
//            perform.close();
//            throw th;
//        }
//    }
//
//    public static synchronized void setBookLoaded(Context context, int i) {
//        synchronized (WordMediaRecordHelper.class) {
//            try {
//                ContentValues contentValues = new ContentValues();
//                contentValues.put("loaded_book_id", Integer.valueOf(i));
//                context.getContentResolver().insert(WORD_MEDIA_BOOK_TB.CONTENT_URI, contentValues);
//            } catch (Exception e) {
//                C0789L.log.error("set current book id error. ", (Throwable) e);
//            }
//        }
//        return;
//    }
//}
