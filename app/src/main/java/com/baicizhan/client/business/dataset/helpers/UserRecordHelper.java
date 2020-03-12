//package com.baicizhan.client.business.dataset.helpers;
//
//import android.content.ContentProviderOperation;
//import android.content.ContentValues;
//import android.content.Context;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.models.UserRecord;
//import com.baicizhan.client.business.dataset.provider.Contracts;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZLOGINUSER;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZLOGINUSER.Columns;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.util.LogWrapper;
//import java.util.ArrayList;
//
//public class UserRecordHelper {
//    public static UserRecord getCurrentUserRecord(Context context) {
//        return (UserRecord) Cursors.mapToUnique(QueryBuilder.query(ZLOGINUSER.CONTENT_URI).where("ZSAVESTATUS = 1", new String[0]).perform(context), UserRecord.class, UserRecord.COLUMN_MAP);
//    }
//
//    public static void saveUserRecord(Context context, UserRecord userRecord) {
//        try {
//            ArrayList arrayList = new ArrayList(3);
//            arrayList.add(ContentProviderOperation.newDelete(ZLOGINUSER.CONTENT_URI).withSelection("USER = ?", new String[]{userRecord.getUser()}).build());
//            arrayList.add(ContentProviderOperation.newInsert(ZLOGINUSER.CONTENT_URI).withValues(Cursors.convertContentValues(userRecord, UserRecord.class, UserRecord.COLUMN_MAP, null)).build());
//            context.getContentResolver().applyBatch(Contracts.AUTHORITY, arrayList);
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
//        }
//    }
//
//    public static int updateUserRecord(Context context, UserRecord userRecord, String... strArr) {
//        if (strArr != null) {
//            try {
//                if (strArr.length == 0) {
//                    strArr = null;
//                }
//            } catch (Exception e) {
//                LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
//                return 0;
//            }
//        }
//        return context.getContentResolver().update(ZLOGINUSER.CONTENT_URI, Cursors.convertContentValues(userRecord, UserRecord.class, UserRecord.COLUMN_MAP, strArr), "USER = ?", new String[]{userRecord.getUser()});
//    }
//
//    public static void clearAllSaveStatus(Context context) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(Columns.ZSAVESTATUS, Integer.valueOf(0));
//        context.getContentResolver().update(ZLOGINUSER.CONTENT_URI, contentValues, "ZSAVESTATUS!=0", null);
//    }
//}
