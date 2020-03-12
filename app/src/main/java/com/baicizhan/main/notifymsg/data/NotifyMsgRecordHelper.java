//package com.baicizhan.main.notifymsg.data;
//
//import android.content.AsyncQueryHandler;
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.dataset.provider.Contracts.NOTIFY_MESSAGE_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.NOTIFY_MESSAGE_TB.Columns;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.framework.log.C0789L;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.List;
//
//public class NotifyMsgRecordHelper {
//    private NotifyMsgRecordHelper() {
//    }
//
//    public static List<NotifyMsgRecord> getNotifyMsgs(Context context, int i) {
//        return Cursors.mapToList(QueryBuilder.query(NOTIFY_MESSAGE_TB.CONTENT_URI).whereIn(Columns.MSG_TYPE, new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)})), 100).orderBy("time DESC").limit(i).perform(context), NotifyMsgRecord.class, NotifyMsgRecord.COLUMN_MAP);
//    }
//
//    public static int getMaxTime(Context context) {
//        int i = 0;
//        StringBuilder sb = new StringBuilder("select max(");
//        sb.append("time) from tb_notify_message");
//        Cursor perform = QueryBuilder.rawQuery(Databases.EVERY_NOTICE, sb.toString(), new String[0]).perform(context);
//        if (perform != null) {
//            try {
//                if (perform.moveToFirst()) {
//                    i = perform.getInt(0);
//                }
//            } finally {
//                perform.close();
//            }
//        }
//        return i;
//    }
//
//    public static synchronized void saveNotifyMsgs(Context context, List<NotifyMsgRecord> list) {
//        synchronized (NotifyMsgRecordHelper.class) {
//            if (list != null) {
//                if (!list.isEmpty()) {
//                    ContentValues[] contentValuesArr = new ContentValues[list.size()];
//                    int i = 0;
//                    Iterator it = list.iterator();
//                    while (true) {
//                        int i2 = i;
//                        if (it.hasNext()) {
//                            NotifyMsgRecord notifyMsgRecord = (NotifyMsgRecord) it.next();
//                            ContentValues contentValues = new ContentValues();
//                            contentValues.put(Columns.MSG_ID, Integer.valueOf(notifyMsgRecord.getId()));
//                            contentValues.put(Columns.MSG_TYPE, Integer.valueOf(notifyMsgRecord.getType()));
//                            contentValues.put("title", notifyMsgRecord.getTitle());
//                            contentValues.put(Columns.TITLE_DESC, notifyMsgRecord.getTitleDesc());
//                            contentValues.put(Columns.IMG_URL, notifyMsgRecord.getImgUrl());
//                            contentValues.put(Columns.CONTENT_URL, notifyMsgRecord.getContentUrl());
//                            contentValues.put(Columns.IS_HIDDEN, Integer.valueOf(notifyMsgRecord.getIsHidden()));
//                            contentValues.put("time", Integer.valueOf(notifyMsgRecord.getTime()));
//                            contentValues.put(Columns.READ, Integer.valueOf(notifyMsgRecord.getRead()));
//                            contentValuesArr[i2] = contentValues;
//                            i = i2 + 1;
//                        } else {
//                            try {
//                                break;
//                            } catch (Exception e) {
//                                C0789L.log.error("bulk insert notify message records error. ", (Throwable) e);
//                                Log.d("whiz", "insert notify message records error: " + e);
//                            }
//                        }
//                    }
//                    Log.d("whiz", "insert notify message records: " + context.getContentResolver().bulkInsert(NOTIFY_MESSAGE_TB.CONTENT_URI, contentValuesArr) + "; records size: " + list.size());
//                }
//            }
//        }
//        return;
//    }
//
//    public static synchronized void updateNotifyMsgsContent(Context context, List<NotifyMsgRecord> list) {
//        synchronized (NotifyMsgRecordHelper.class) {
//            if (list != null) {
//                if (!list.isEmpty()) {
//                    for (NotifyMsgRecord notifyMsgRecord : list) {
//                        ContentValues contentValues = new ContentValues();
//                        contentValues.put(Columns.MSG_TYPE, Integer.valueOf(notifyMsgRecord.getType()));
//                        contentValues.put("title", notifyMsgRecord.getTitle());
//                        contentValues.put(Columns.TITLE_DESC, notifyMsgRecord.getTitleDesc());
//                        contentValues.put(Columns.IMG_URL, notifyMsgRecord.getImgUrl());
//                        contentValues.put(Columns.CONTENT_URL, notifyMsgRecord.getContentUrl());
//                        contentValues.put(Columns.IS_HIDDEN, Integer.valueOf(notifyMsgRecord.getIsHidden()));
//                        contentValues.put("time", Integer.valueOf(notifyMsgRecord.getTime()));
//                        context.getContentResolver().update(NOTIFY_MESSAGE_TB.CONTENT_URI, contentValues, "msg_id=?", new String[]{String.valueOf(notifyMsgRecord.getId())});
//                    }
//                }
//            }
//        }
//    }
//
//    public static void asyncUpdate(AsyncQueryHandler asyncQueryHandler, NotifyMsgRecord notifyMsgRecord) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(Columns.MSG_ID, Integer.valueOf(notifyMsgRecord.getId()));
//        contentValues.put(Columns.MSG_TYPE, Integer.valueOf(notifyMsgRecord.getType()));
//        contentValues.put("title", notifyMsgRecord.getTitle());
//        contentValues.put(Columns.TITLE_DESC, notifyMsgRecord.getTitleDesc());
//        contentValues.put(Columns.IMG_URL, notifyMsgRecord.getImgUrl());
//        contentValues.put(Columns.CONTENT_URL, notifyMsgRecord.getContentUrl());
//        contentValues.put(Columns.IS_HIDDEN, Integer.valueOf(notifyMsgRecord.getIsHidden()));
//        contentValues.put("time", Integer.valueOf(notifyMsgRecord.getTime()));
//        contentValues.put(Columns.READ, Integer.valueOf(notifyMsgRecord.getRead()));
//        AsyncQueryHandler asyncQueryHandler2 = asyncQueryHandler;
//        asyncQueryHandler2.startUpdate(0, null, NOTIFY_MESSAGE_TB.CONTENT_URI, contentValues, "msg_id=?", new String[]{String.valueOf(notifyMsgRecord.getId())});
//    }
//}
