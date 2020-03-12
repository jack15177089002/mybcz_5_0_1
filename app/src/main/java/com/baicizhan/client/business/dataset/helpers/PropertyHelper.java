package com.baicizhan.client.business.dataset.helpers;

import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import androidx.collection.ArrayMap;

import com.baicizhan.client.business.dataset.provider.Contracts.PROPERTY;
import com.baicizhan.client.business.dataset.provider.Contracts.PROPERTY.Columns;
import com.baicizhan.client.business.dataset.provider.QueryBuilder;
import com.baicizhan.client.business.util.LogWrapper;
import com.baicizhan.client.framework.BaseAppHandler;
import java.util.Collections;
import java.util.Map;

public class PropertyHelper {
    public static final String APP_ROOT = "app_root";
    public static final String CURRENT_BOOK_ID = "current_book_id";
    public static final String NIGHT_MODE = "night_mode";
    public static final String PORTRAIT_MODE = "portrait_mode";
    public static final String SHOW_IMAGE_MEAN = "show_image_mean";
    public static final String SHOW_SENTENCE_TRANSLATION = "show_sentence_translation";
    public static final String SOUND_EFFECT = "sound_effect";
    /* access modifiers changed from: private */
    public static final String TAG = PropertyHelper.class.getSimpleName();
    public static final String WORD_LOCK = "word_lock";
    private static PropertyObserver sObserver;

    public class PropertyObserver extends ContentObserver {
        private  final String EMPTY = new String();
        private Map<String, String> mCached = Collections.synchronizedMap(new ArrayMap());

        public PropertyObserver(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            String queryParameter = uri.getQueryParameter("key");
            if (!TextUtils.isEmpty(queryParameter)) {
                this.mCached.remove(queryParameter);
            } else {
                this.mCached.clear();
            }
        }

        public String getValue(String str, String str2) {
            String str3 = (String) this.mCached.get(str);
            if (str3 == null) {
                Cursor cursor = null;
                try {
                    cursor = QueryBuilder.query(PROPERTY.CONTENT_URI).where("KEY = ?", str).projection(Columns.VALUE).perform(BaseAppHandler.getApp());
                    if (cursor == null || cursor.getCount() == 0) {
                        this.mCached.put(str, EMPTY);
                        if (cursor == null) {
                            return str2;
                        }
                        cursor.close();
                        return str2;
                    }
                    cursor.moveToFirst();
                    String string = cursor.getString(0);
                    this.mCached.put(str, string);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return string;
                } catch (Exception e) {
                    LogWrapper.m2794e(PropertyHelper.TAG, e.toString());
                    if (cursor == null) {
                        return str2;
                    }
                    cursor.close();
                    return str2;
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } else if (str3 == EMPTY) {
                return str2;
            } else {
                return str3;
            }
        }

        public void setValue(String str, String str2) {
            this.mCached.put(str, str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put(Columns.KEY, str);
            contentValues.put(Columns.VALUE, str2);
            BaseAppHandler.getApp().getContentResolver().insert(PROPERTY.CONTENT_URI, contentValues);
        }
    }

    private PropertyHelper() {
    }

    public  void init() {
        sObserver = new PropertyObserver(new Handler(Looper.getMainLooper()));
        BaseAppHandler.getApp().getContentResolver().registerContentObserver(PROPERTY.CONTENT_URI, true, sObserver);
    }

    public static boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public static boolean getBoolean(String str, boolean z) {
        long j;
        if (z) {
            j = 1;
        } else {
            j = 0;
        }
        return getLong(str, j) != 0;
    }

    public static int getInt(String str) {
        return getInt(str, 0);
    }

    public static int getInt(String str, int i) {
        return (int) getLong(str, (long) i);
    }

    public static long getLong(String str) {
        return getLong(str, 0);
    }

    public static long getLong(String str, long j) {
        String string = getString(str, null);
        if (TextUtils.isEmpty(string)) {
            return j;
        }
        try {
            return Long.valueOf(string).longValue();
        } catch (Exception e) {
            return j;
        }
    }

    public static String getString(String str) {
        return getString(str, null);
    }

    public static String getString(String str, String str2) {
        return sObserver.getValue(str, str2);
    }

    public static void put(String str, boolean z) {
        put(str, z ? 1 : 0);
    }

    public static void put(String str, int i) {
        put(str, (long) i);
    }

    public static void put(String str, long j) {
        put(str, Long.toString(j));
    }

    public static void put(String str, String str2) {
        sObserver.setValue(str, str2);
    }
}
