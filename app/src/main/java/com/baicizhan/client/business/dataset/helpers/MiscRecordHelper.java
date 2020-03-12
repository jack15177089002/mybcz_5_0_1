//package com.baicizhan.client.business.dataset.helpers;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.DatabaseUtils;
////import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import android.util.ArrayMap;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.models.NoticeFinishRecord;
//import com.baicizhan.client.business.dataset.models.NoticeItemRecord;
//import com.baicizhan.client.business.dataset.models.ShortPhraseRecord;
//import com.baicizhan.client.business.dataset.models.TopicBriefRecord;
//import com.baicizhan.client.business.dataset.models.TopicSearchSuggestion;
//import com.baicizhan.client.business.dataset.provider.Contracts.DICTIONARY;
//import com.baicizhan.client.business.dataset.provider.Contracts.TATAL_TOPIC_RESOURCES_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.TOPICRESOURCE;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_ALL_NOTICE_LIST;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_EVERY_NOTICE_INFO;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_NOTICE_ID_USE;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZSHORTPHRASETOPICRESOURCE;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.util.LogWrapper;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.Set;
//
//public class MiscRecordHelper {
//    public static ShortPhraseRecord getShortPhraseRecordById(Context context, int i) {
//        return (ShortPhraseRecord) Cursors.mapToUnique(QueryBuilder.query(ZSHORTPHRASETOPICRESOURCE.CONTENT_URI).where("TOPIC = " + i, new String[0]).perform(context), ShortPhraseRecord.class, ShortPhraseRecord.COLUMN_MAP);
//    }
//
//    public static List<NoticeItemRecord> getAllNoticeItemRecord(Context context) {
//        return Cursors.mapToList(QueryBuilder.query(TS_EVERY_NOTICE_INFO.CONTENT_URI).perform(context), NoticeItemRecord.class, NoticeItemRecord.COLUMN_MAP);
//    }
//
//    public static Set<Integer> getUsedNoticeItemIds(Context context) {
//        return Cursors.reduceToSet(QueryBuilder.query(TS_NOTICE_ID_USE.CONTENT_URI).projection("ntf_id").perform(context), Integer.class, null);
//    }
//
//    public static void clearAllUsedNoticeIds(Context context) {
//        context.getContentResolver().delete(TS_NOTICE_ID_USE.CONTENT_URI, null, null);
//    }
//
//    public static void clearAllNoticeFinishRecords(Context context) {
//        context.getContentResolver().delete(TS_ALL_NOTICE_LIST.CONTENT_URI, null, null);
//    }
//
//    public static void insertNoticeFinishRecord(Context context, NoticeFinishRecord noticeFinishRecord) {
//        try {
//            ContentValues contentValues = new ContentValues();
//            contentValues.put("ntf_id", Integer.valueOf(noticeFinishRecord.f2228id));
//            contentValues.put("read_status", Integer.valueOf(0));
//            context.getContentResolver().insert(TS_NOTICE_ID_USE.CONTENT_URI, contentValues);
//            context.getContentResolver().insert(TS_ALL_NOTICE_LIST.CONTENT_URI, Cursors.convertContentValues(noticeFinishRecord, NoticeFinishRecord.class, NoticeFinishRecord.COLUMN_MAP, null));
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
//        }
//    }
//
//    public static void insertNoticeFinishRecords(Context context, List<NoticeFinishRecord> list) {
//        try {
//            ContentValues[] contentValuesArr = new ContentValues[list.size()];
//            for (int i = 0; i < list.size(); i++) {
//                ContentValues contentValues = new ContentValues();
//                contentValues.put("ntf_id", Integer.valueOf(((NoticeFinishRecord) list.get(i)).f2228id));
//                contentValues.put("read_status", Integer.valueOf(0));
//                contentValuesArr[i] = contentValues;
//            }
//            Cursors.safeBulkInsert(context, TS_NOTICE_ID_USE.CONTENT_URI, contentValuesArr, -1);
////            Cursors.safeBulkInsert(context, TS_ALL_NOTICE_LIST.CONTENT_URI, Cursors.bulkConvertContentValues((Collection<T>) list, NoticeFinishRecord.class, NoticeFinishRecord.COLUMN_MAP, (String[]) null), -1);
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
//        }
//    }
//
//    public static void insertNoticeItemRecords(Context context, List<NoticeItemRecord> list) {
//        context.getContentResolver().delete(TS_EVERY_NOTICE_INFO.CONTENT_URI, null, null);
//        try {
////            Cursors.safeBulkInsert(context, TS_EVERY_NOTICE_INFO.CONTENT_URI, Cursors.bulkConvertContentValues((Collection<T>) list, NoticeItemRecord.class, NoticeItemRecord.COLUMN_MAP, (String[]) null), -1);
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
//        }
//    }
//
//    public static List<NoticeFinishRecord> getAllNoticeFinishRecords(Context context) {
//        return Cursors.mapToList(QueryBuilder.query(TS_ALL_NOTICE_LIST.CONTENT_URI).orderBy("ntf_time").perform(context), NoticeFinishRecord.class, NoticeFinishRecord.COLUMN_MAP);
//    }
//
//    public static void setAllNoticeReaded(Context context) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("read_status", Integer.valueOf(1));
//        context.getContentResolver().update(TS_ALL_NOTICE_LIST.CONTENT_URI, contentValues, null, null);
//    }
//
//    public static TopicBriefRecord getSyntheticTopicBriefRecord(Context context, int i, int i2) {
//        TopicBriefRecord topicBriefRecord = (TopicBriefRecord) Cursors.mapToUnique(QueryBuilder.query(TOPICRESOURCE.getBookContentUri(i)).where("topic=" + i2, new String[0]).perform(context), TopicBriefRecord.class, TopicBriefRecord.COLUMN_MAP_RESOURCE);
//        return topicBriefRecord != null ? topicBriefRecord : getTopicBriefRecordById(context, i2);
//    }
//
//    public static TopicBriefRecord getTopicBriefRecordById(Context context, int i) {
//        return (TopicBriefRecord) Cursors.mapToUnique(QueryBuilder.query(DICTIONARY.CONTENT_URI).where("topic_id=" + i, new String[0]).perform(context), TopicBriefRecord.class, TopicBriefRecord.COLUMN_MAP_DICTIONARY);
//    }
//
//    public static TopicBriefRecord getTopicBriefRecordByWord(Context context, String str) {
//        if (str != null) {
//            str = str.toLowerCase();
//        }
//        return (TopicBriefRecord) Cursors.mapToUnique(QueryBuilder.query(DICTIONARY.CONTENT_URI).where("topic_word= ?", str).perform(context), TopicBriefRecord.class, TopicBriefRecord.COLUMN_MAP_DICTIONARY);
//    }
//
//    private static List<TopicSearchSuggestion> queryTopicSearchSuggestion(Context context, String str) {
//        List<TopicSearchSuggestion> emptyList;
//        Cursor cursor = null;
//        try {
//            cursor = QueryBuilder.query(TATAL_TOPIC_RESOURCES_TB.CONTENT_URI).projection("book_id", "topic_id", "word", "phonetic", "mean_cn").where(str, new String[0]).perform(context);
//            if (cursor == null || cursor.getCount() == 0) {
//                emptyList = Collections.emptyList();
//                if (cursor != null) {
//                    cursor.close();
//                }
//                return emptyList;
//            }
//            emptyList = new ArrayList<>(cursor.getCount());
//            cursor.moveToFirst();
//            while (!cursor.isAfterLast()) {
//                TopicSearchSuggestion topicSearchSuggestion = new TopicSearchSuggestion();
//                topicSearchSuggestion.bookId = cursor.getInt(0);
//                topicSearchSuggestion.topicId = cursor.getInt(1);
//                topicSearchSuggestion.word = cursor.getString(2);
//                topicSearchSuggestion.phonetic = cursor.getString(3);
//                topicSearchSuggestion.wordMean = cursor.getString(4);
//                emptyList.add(topicSearchSuggestion);
//                cursor.moveToNext();
//            }
//            if (cursor != null) {
//                cursor.close();
//            }
//            return emptyList;
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", e.toString());
//            emptyList = Collections.emptyList();
//            if (cursor != null) {
//                cursor.close();
//            }
//        } catch (Throwable th) {
//            if (cursor != null) {
//                cursor.close();
//            }
//            throw th;
//        }
//        return null;
//    }
//
//    public static List<TopicSearchSuggestion> getTopicSearchSuggestion(Context context, int i, String str, int i2) {
//        ArrayMap aVar = new ArrayMap();
//        ArrayList<TopicSearchSuggestion> arrayList = new ArrayList<>();
//        arrayList.addAll(queryTopicSearchSuggestion(context, String.format("%s = %s", new Object[]{"word", DatabaseUtils.sqlEscapeString(str)})));
//        arrayList.addAll(queryTopicSearchSuggestion(context, String.format("%s like '%s%%' limit %d", new Object[]{"word", str, Integer.valueOf(arrayList.size() > 0 ? i2 * 2 : i2 * 3)})));
//        for (TopicSearchSuggestion topicSearchSuggestion : arrayList) {
//            if (aVar.get(topicSearchSuggestion.word) == null) {
//                aVar.put(topicSearchSuggestion.word, topicSearchSuggestion);
//            } else if (i > 0 && topicSearchSuggestion.bookId == i) {
//                aVar.put(topicSearchSuggestion.word, topicSearchSuggestion);
//            }
//        }
//        return new ArrayList(aVar.values());
//    }
//
//    public static List<TopicSearchSuggestion> getDictionarySearchSuggestion(Context context, String str, int i) {
//        List<TopicSearchSuggestion> emptyList;
//        Cursor cursor = null;
//        try {
//            cursor = QueryBuilder.query(DICTIONARY.CONTENT_URI).projection("topic_id", "topic_word", "accent", "mean_cn").where(String.format("%s like '%s%%' limit %d", new Object[]{"topic_word", str, Integer.valueOf(i)}), new String[0]).perform(context);
//            if (cursor.getCount() == 0) {
//                emptyList = Collections.emptyList();
//                if (cursor != null) {
//                    cursor.close();
//                }
//            } else {
//                emptyList = new ArrayList<>();
//                cursor.moveToFirst();
//                while (!cursor.isAfterLast()) {
//                    TopicSearchSuggestion topicSearchSuggestion = new TopicSearchSuggestion();
//                    topicSearchSuggestion.bookId = -1;
//                    topicSearchSuggestion.topicId = cursor.getInt(0);
//                    topicSearchSuggestion.word = cursor.getString(1);
//                    topicSearchSuggestion.phonetic = cursor.getString(2);
//                    topicSearchSuggestion.wordMean = cursor.getString(3);
//                    emptyList.add(topicSearchSuggestion);
//                    cursor.moveToNext();
//                }
//                if (cursor != null) {
//                    cursor.close();
//                }
//            }
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", e.toString());
//            emptyList = Collections.emptyList();
//            if (cursor != null) {
//                cursor.close();
//            }
//        } catch (Throwable th) {
//            if (cursor != null) {
//                cursor.close();
//            }
//            throw th;
//        }
//        return emptyList;
//    }
//}
