//package com.baicizhan.client.business.dataset.helpers;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.text.TextUtils;
//import android.util.Base64;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.provider.Contracts.KVDICT;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.framework.util.GzipUtils;
//import com.google.gson.Gson;//import com.p020b.p021a.Gson;
//import java.lang.reflect.Type;
//import java.util.Locale;
//
//public class KVHelper {
//    public static final String KEY_DATABASE_VERSION = "global.database_version";
//    public static final String KEY_GLOBAL_BOOK_CATEGORY = "global.book_categories";
//    public static final String KEY_GLOBAL_BOOK_LIST_VERSION = "global.book_list_version";
//    public static final String KEY_GLOBAL_BOOK_TRANSFER = "global.book_transfer";
//    public static final String KEY_GLOBAL_BOOK_TRANSFER_STATE = "global.book_transfer_state";
//    public static final String KEY_USER_BOOK_UPDATE_MD5 = "user.book_update_md5";
//    public static final String KEY_USER_BOOK_UPDATE_MD5_COMPAT_STATE = "user.book_update_md5_compat_state";
//    public static final String KEY_USER_HAS_WORD_FRIENDS = "user.has_word_friends";
//    public static final String KEY_USER_SELFTEST = "user.selftest";
//    public static final String KEY_USER_THIRD_PARTY_INFO = "global.third_party_info";
//    private static final String TAG = KVHelper.class.getSimpleName();
//
//    public static String getString(Context context, String str, boolean z) {
//        String[] strArr = {str};
//        String simpleString = Cursors.toSimpleString(QueryBuilder.query(KVDICT.CONTENT_URI).projection("value").where("key = ?", strArr).perform(context));
//        if (TextUtils.isEmpty(simpleString) || !z) {
//            return simpleString;
//        }
//        try {
//            return new String(GzipUtils.decompress(Base64.decode(simpleString.getBytes(), 0)));
//        } catch (Exception e) {
//            LogWrapper.m2794e(TAG, e.toString());
//            return null;
//        }
//    }
//
//    public static void setString(Context context, String str, String str2, boolean z) {
//        ContentValues contentValues = new ContentValues();
//        if (z) {
//            try {
//                str2 = new String(Base64.encode(GzipUtils.compress(str2.getBytes()), 0));
//            } catch (Exception e) {
//                LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//                str2 = "";
//            }
//        }
//        contentValues.put("key", str);
//        contentValues.put("value", str2);
//        context.getContentResolver().insert(KVDICT.CONTENT_URI, contentValues);
//    }
//
//    public static long getLong(Context context, String str) {
//        String string = getString(context, str, false);
//        try {
//            if (TextUtils.isEmpty(string)) {
//                return 0;
//            }
//            return Long.valueOf(string).longValue();
//        } catch (Exception e) {
//            LogWrapper.m2794e(TAG, "Conversion of " + string + " error: " + e.toString());
//            return 0;
//        }
//    }
//
//    public static void setLong(Context context, String str, long j) {
//        setString(context, str, Long.toString(j), false);
//    }
//
//    public static int getInt(Context context, String str) {
//        return (int) getLong(context, str);
//    }
//
//    public static void setInt(Context context, String str, int i) {
//        setString(context, str, Integer.toString(i), false);
//    }
//
//    public static void setBoolean(Context context, String str, boolean z) {
//        setLong(context, str, z ? 1 : 0);
//    }
//
//    public static boolean getBoolean(Context context, String str) {
//        return getLong(context, str) > 0;
//    }
//
//    public static <T> T getJsonBean(Context context, String str, Type type, boolean z) {
//        try {
//            return new Gson().fromJson(getString(context, str, z), type);
//        } catch (Exception e) {
//            LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//            return null;
//        }
//    }
//
//    public static <T> void setJsonBean(Context context, String str, T t, Type type, boolean z) {
//        setString(context, str, new Gson().mo3213a((Object) t, type), z);
//    }
//
//    public static void deleteKey(Context context, String str) {
//        context.getContentResolver().delete(KVDICT.CONTENT_URI, "key = ?", new String[]{str});
//    }
//
//    public static void deleteKeyCascaded(Context context, String str) {
//        context.getContentResolver().delete(KVDICT.CONTENT_URI, "key like ?", new String[]{str + "%"});
//    }
//
//    public static boolean hasKey(Context context, String str) {
//        Cursor perform = QueryBuilder.query(KVDICT.CONTENT_URI).where("key = ?", str).perform(context);
//        if (perform == null || perform.getCount() <= 0) {
//            return false;
//        }
//        return true;
//    }
//
//    public static String getSubKey(String str, String str2) {
//        return String.format(Locale.CHINA, "%s.%s", new Object[]{str, str2});
//    }
//}
