//package com.baicizhan.client.business.dataset.helpers;
//
//import android.content.ContentProviderOperation;
//import android.content.ContentValues;
//import android.content.Context;
//import android.content.OperationApplicationException;
//import android.os.RemoteException;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.models.BookRecord;
//import com.baicizhan.client.business.dataset.models.OfflineStateRecord;
//import com.baicizhan.client.business.dataset.models.ScheduleRecord;
//import com.baicizhan.client.business.dataset.provider.Contracts;
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.dataset.provider.Contracts.TOPICRESOURCE;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_OFFLINE_DOTOPIC_SYNC_IDS;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_OFFLINE_SYNC_STATE;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZBOOKFINISHINFO;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZBOOKFINISHINFO.Columns;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZBOOKRESOURCE;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.framework.util.FileHelper;
//import com.google.gson.GsonBuilder;
//import com.google.gson.ExclusionStrategy;
//import com.google.gson.FieldAttributes;
//import com.google.gson.internal.Excluder;
////import com.google.Gson;
//
////import com.google.p021a.ExclusionStrategy;
////import com.google.p021a.FieldAttributes;
////import com.google.p021a.Gson;
////import com.google.p021a.GsonBuilder;
////import com.google.p021a.p023b.Excluder;
//import com.google.gson.reflect.TypeToken;
////import1 com.google.p021a.p025c.TypeToken;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//
//public class BookRecordHelper {
//    public static List<BookRecord> getAllBookRecords(Context context) {
//        return Cursors.mapToList(QueryBuilder.query(ZBOOKRESOURCE.CONTENT_URI).perform(context), BookRecord.class, BookRecord.COLUMN_MAP);
//    }
//
//    public static BookRecord getBookRecordById(Context context, int i) {
//        return (BookRecord) Cursors.mapToUnique(QueryBuilder.query(ZBOOKRESOURCE.CONTENT_URI).where("BOOK_ID = " + i, new String[0]).perform(context), BookRecord.class, BookRecord.COLUMN_MAP);
//    }
//
//    public static void saveAllBookRecord(Context context, Collection<BookRecord> collection) {
//        try {
//            context.getContentResolver().bulkInsert(ZBOOKRESOURCE.CONTENT_URI, Cursors.bulkConvertContentValues(collection, BookRecord.class, BookRecord.COLUMN_MAP, (String[]) null));
//        } catch (Exception e) {
//            Log.e("baicizhandb", Log.getStackTraceString(e));
//        }
//    }
//
//    public static void saveBookRecord(Context context, BookRecord bookRecord) {
//        try {
//            context.getContentResolver().insert(ZBOOKRESOURCE.CONTENT_URI, Cursors.convertContentValues(bookRecord, BookRecord.class, BookRecord.COLUMN_MAP, null));
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
//        }
//    }
//
//    public static void updateBookRecord(Context context, BookRecord bookRecord, String... strArr) {
//        try {
//            context.getContentResolver().update(ZBOOKRESOURCE.CONTENT_URI, Cursors.convertContentValues(bookRecord, BookRecord.class, BookRecord.COLUMN_MAP, strArr), "BOOK_ID = " + bookRecord.bookId, null);
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
//        }
//    }
//
//    public static ScheduleRecord getCurrentSchedule(Context context) {
//        return (ScheduleRecord) Cursors.mapToUnique(QueryBuilder.query(ZBOOKFINISHINFO.CONTENT_URI).where("IS_CURRENT_SELECT_BOOK = 1", new String[0]).perform(context), ScheduleRecord.class, ScheduleRecord.COLUMN_MAP);
//    }
//
//    public static ScheduleRecord getScheduleById(Context context, int i) {
//        return (ScheduleRecord) Cursors.mapToUnique(QueryBuilder.query(ZBOOKFINISHINFO.CONTENT_URI).where("BOOK_ID=" + i, new String[0]).perform(context), ScheduleRecord.class, ScheduleRecord.COLUMN_MAP);
//    }
//
//    public static void saveScheduleAsCurrentSelected(Context context, ScheduleRecord scheduleRecord) {
//        try {
//            ArrayList arrayList = new ArrayList(3);
//            arrayList.add(ContentProviderOperation.newUpdate(ZBOOKFINISHINFO.CONTENT_URI).withValue(Columns.IS_CURRENT_SELECT_BOOK, Integer.valueOf(0)).build());
//            arrayList.add(ContentProviderOperation.newDelete(ZBOOKFINISHINFO.CONTENT_URI).withSelection("BOOK_ID = " + scheduleRecord.bookId, null).build());
//            scheduleRecord.isCurrentSelect = 1;
//            arrayList.add(ContentProviderOperation.newInsert(ZBOOKFINISHINFO.CONTENT_URI).withValues(Cursors.convertContentValues(scheduleRecord, ScheduleRecord.class, ScheduleRecord.COLUMN_MAP, null)).build());
//            context.getContentResolver().applyBatch(Contracts.AUTHORITY, arrayList);
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
//        }
//    }
//
//    public static void updateSchedule(Context context, ScheduleRecord scheduleRecord, String... strArr) {
//        try {
//            context.getContentResolver().update(ZBOOKFINISHINFO.CONTENT_URI, Cursors.convertContentValues(scheduleRecord, ScheduleRecord.class, ScheduleRecord.COLUMN_MAP, strArr), "BOOK_ID=" + scheduleRecord.bookId, null);
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
//        }
//    }
//
//    public static void clearPersonalData(Context context) {
////        KVHelper.deleteKey(context, KVHelper.KEY_USER_HAS_WORD_FRIENDS);
////        KVHelper.deleteKeyCascaded(context, KVHelper.KEY_USER_BOOK_UPDATE_MD5);
////        UserRecordHelper.clearAllSaveStatus(context);
////        context.getContentResolver().delete(ZBOOKFINISHINFO.CONTENT_URI, null, null);
////        PropertyHelper.put(PropertyHelper.CURRENT_BOOK_ID, 0);
////        ContentValues contentValues = new ContentValues();
////        contentValues.put(ZBOOKRESOURCE.Columns.ROADMAP_VER, Integer.valueOf(0));
////        contentValues.put(ZBOOKRESOURCE.Columns.UPDATE_LOCAL_DATA, Integer.valueOf(0));
////        contentValues.put(ZBOOKRESOURCE.Columns.SETDATETIME, Integer.valueOf(0));
////        context.getContentResolver().update(ZBOOKRESOURCE.CONTENT_URI, contentValues, null, null);
////        FileHelper.deleteDir(PathUtil.getBaicizhanFile("roadmap"), false);
////        List<String> mapToList = Cursors.mapToList(QueryBuilder.rawQuery(Databases.TOPIC_PROBLEM, "SELECT name FROM sqlite_master WHERE type=?", "table").perform(context), String.class);
////        ArrayList arrayList = new ArrayList(mapToList.size());
////        for (String str : mapToList) {
////            if (!str.equals("android_metadata")) {
////                arrayList.add(ContentProviderOperation.newDelete(Contracts.getTableContentUri(Databases.TOPIC_PROBLEM, str)).build());
////            }
////        }
////        try {
////            context.getContentResolver().applyBatch(Contracts.AUTHORITY, arrayList);
////        } catch (OperationApplicationException | RemoteException e) {
////            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
////        }
////        context.getContentResolver().delete(TS_OFFLINE_SYNC_STATE.CONTENT_URI, null, null);
////        MiscRecordHelper.clearAllNoticeFinishRecords(context);
////        MiscRecordHelper.clearAllUsedNoticeIds(context);
////        Settings.putInt(Settings.PREF_GUIDE_FLAGS, 0);
//    }
//
//    public static void deleteScheduleData(Context context, int i, boolean z) {
////        if (z) {
////            context.getContentResolver().delete(ZBOOKFINISHINFO.CONTENT_URI, "BOOK_ID = " + i, null);
////            PropertyHelper.put(PropertyHelper.CURRENT_BOOK_ID, 0);
////        }
////        context.getContentResolver().delete(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i), null, null);
////        context.getContentResolver().delete(TS_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i), null, null);
////        deleteOfflineState(context, i);
//    }
//
//    public static OfflineStateRecord getOfflieStateById(Context context, int i) {
//        return (OfflineStateRecord) Cursors.mapToUnique(QueryBuilder.query(TS_OFFLINE_SYNC_STATE.CONTENT_URI).where("book_id = " + i, new String[0]).perform(context), OfflineStateRecord.class, OfflineStateRecord.COLUMN_MAP);
//    }
//
//    public static void saveOfflineState(Context context, OfflineStateRecord offlineStateRecord) {
//        try {
//            context.getContentResolver().insert(TS_OFFLINE_SYNC_STATE.CONTENT_URI, Cursors.convertContentValues(offlineStateRecord, OfflineStateRecord.class, OfflineStateRecord.COLUMN_MAP, null));
//        } catch (Exception e) {
//            LogWrapper.m2794e("leijie", Log.getStackTraceString(e));
//        }
//    }
//
//    public static void deleteOfflineState(Context context, int i) {
//        context.getContentResolver().delete(TS_OFFLINE_SYNC_STATE.CONTENT_URI, "book_id = " + i, null);
//    }
//
//    public static Map<Integer, String> getTopicUpdateFlagsByBookId(Context context, int i) {
////        try {
////            Type type = new TypeToken<Map<Integer, String>>() {
////            }.getType();
////            return (Map) new Gson().fromJson(KVHelper.getString(context, KVHelper.getSubKey(KVHelper.KEY_USER_BOOK_UPDATE_MD5, Integer.toString(i)), false), type);
////        } catch (Exception e) {
////            LogWrapper.m2794e("leijie", Log.getStackTraceString(e));
////            return Collections.emptyMap();
////        }
//        return null;
//    }
//
//    public static void saveTopicUpdateFlagsByBookId(Context context, int i, Map<Integer, String> map) {
////        try {
////            GsonBuilder rVar = new GsonBuilder();
////            C05792 r1 = new ExclusionStrategy() {
////                public final boolean shouldSkipField(FieldAttributes cVar) {
////                    String name = cVar.f2127a.getName();
////                    if (name.equals("topic_id") || name.equals(TOPICRESOURCE.Columns.UPDATE_FLAG_MD5)) {
////                        return false;
////                    }
////                    return true;
////                }
////
////                public final boolean shouldSkipClass(Class<?> cls) {
////                    return false;
////                }
////            };
////            Excluder sVar = rVar.f2186a;
////            Excluder a = sVar.clone();
////            a.f2106f = new ArrayList(sVar.f2106f);
////            a.f2106f.add(r1);
////            rVar.f2186a = a;
////            KVHelper.setString(context, KVHelper.getSubKey(KVHelper.KEY_USER_BOOK_UPDATE_MD5, Integer.toString(i)), rVar.mo3215a().mo3213a((Object) map, new TypeToken<Map<Integer, String>>() {
////            }.getType()), false);
////        } catch (Exception e) {
////            LogWrapper.m2794e("leijie", Log.getStackTraceString(e));
////        }
//    }
//}
