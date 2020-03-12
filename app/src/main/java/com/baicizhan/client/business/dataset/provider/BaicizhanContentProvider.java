package com.baicizhan.client.business.dataset.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteOutOfMemoryException;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baicizhan.client.business.dataset.p027db.DoExampleInfoDatabase;
import com.baicizhan.client.business.dataset.p027db.EveryNoticeDatabase;
import com.baicizhan.client.business.dataset.p027db.PropertyDatabase;
import com.baicizhan.client.business.dataset.p027db.StatsDatabase;
import com.baicizhan.client.business.dataset.p027db.TopicDatabase;
import com.baicizhan.client.business.dataset.p027db.TopicProblemDatabase;
import com.baicizhan.client.business.dataset.p027db.TopicWordMeanDatabase;
import com.baicizhan.client.business.dataset.p027db.UserDatabase;
import com.baicizhan.client.business.dataset.p027db.WordLockDatabase;
import com.baicizhan.client.business.dataset.p027db.WordMediaDatabase;
import com.baicizhan.client.business.dataset.p027db.WordRadioTopicDatabase;
import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
import com.baicizhan.client.business.dataset.provider.Contracts.PROPERTY;
import com.baicizhan.client.business.dataset.provider.Contracts.PROPERTY.Columns;
import com.baicizhan.client.business.util.LogWrapper;
import com.baicizhan.client.business.util.StoragePathDetector;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaicizhanContentProvider extends ContentProvider {
    public static final String EXTEND_CONFLICT_IGNORE = "CONFLICT_IGNORE";
    public static final String METHOD_SET_ROOT = "setRoot";
    public static final String TAG = "baicizhandb";
    private Map<String, SQLiteDatabase> mDatabaseMap = new ConcurrentHashMap();
    private String mRoot;

    public boolean onCreate() {
        LogWrapper.m2793d("baicizhandb", "provider onCreate");
        return true;
    }

    private void closeDatabases() {
        LogWrapper.m2793d("baicizhandb", "closeDatabases");
        synchronized (this.mDatabaseMap) {
            for (SQLiteDatabase sQLiteDatabase : this.mDatabaseMap.values()) {
                try {
                    LogWrapper.m2793d("baicizhandb", "close db " + sQLiteDatabase.getPath());
                    sQLiteDatabase.close();
                } catch (SQLiteException e) {
                    Log.d("baicizhandb", Log.getStackTraceString(e));
                }
            }
            this.mDatabaseMap.clear();
        }
    }

    public void shutdown() {
        super.shutdown();
        closeDatabases();
    }

    public synchronized String getType(Uri uri) {
        List pathSegments = uri.getPathSegments();
        if (pathSegments.size() > 0) {
            String str = (String) pathSegments.get(0);
            String query = uri.getQuery();
            if (str.equals(METHOD_SET_ROOT) && !TextUtils.isEmpty(query)) {
                this.mRoot = query;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int delete(Uri r8, String r9, String[] r10) {
        /*
            r7 = this;
            r2 = 0
            java.util.List r1 = r8.getPathSegments()     // Catch:{ Exception -> 0x0071 }
            r0 = 0
            java.lang.Object r0 = r1.get(r0)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0071 }
            r3 = 1
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0071 }
            java.lang.String r3 = r8.getQuery()     // Catch:{ Exception -> 0x0071 }
            android.database.sqlite.SQLiteDatabase r4 = r7.getDatabase(r0)     // Catch:{ Exception -> 0x0071 }
            monitor-enter(r4)     // Catch:{ Exception -> 0x0071 }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x0046
            java.lang.String r0 = "baicizhandb"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            java.lang.String r3 = "delete "
            r2.<init>(r3)     // Catch:{ all -> 0x006e }
            java.lang.StringBuilder r2 = r2.append(r1)     // Catch:{ all -> 0x006e }
            java.lang.String r3 = " where "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x006e }
            java.lang.StringBuilder r2 = r2.append(r9)     // Catch:{ all -> 0x006e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x006e }
            android.util.Log.v(r0, r2)     // Catch:{ all -> 0x006e }
            int r0 = r4.delete(r1, r9, r10)     // Catch:{ all -> 0x006e }
            monitor-exit(r4)     // Catch:{ all -> 0x006e }
        L_0x0045:
            return r0
        L_0x0046:
            java.lang.String r0 = "baicizhandb"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            java.lang.String r6 = "delete "
            r5.<init>(r6)     // Catch:{ all -> 0x006e }
            java.lang.StringBuilder r5 = r5.append(r3)     // Catch:{ all -> 0x006e }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x006e }
            android.util.Log.v(r0, r5)     // Catch:{ all -> 0x006e }
            java.lang.String r0 = "raw_exec"
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x0067
            if (r10 == 0) goto L_0x006a
            r4.execSQL(r3, r10)     // Catch:{ all -> 0x006e }
        L_0x0067:
            monitor-exit(r4)     // Catch:{ all -> 0x006e }
            r0 = r2
            goto L_0x0045
        L_0x006a:
            r4.execSQL(r3)     // Catch:{ all -> 0x006e }
            goto L_0x0067
        L_0x006e:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x006e }
            throw r0     // Catch:{ Exception -> 0x0071 }
        L_0x0071:
            r0 = move-exception
            r7.handleSQLException(r0)
            r0 = -1
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.dataset.provider.BaicizhanContentProvider.delete(android.net.Uri, java.lang.String, java.lang.String[]):int");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uri2;
        try {
            List pathSegments = uri.getPathSegments();
            String str = (String) pathSegments.get(0);
            String str2 = (String) pathSegments.get(1);
            String str3 = pathSegments.size() > 2 ? (String) pathSegments.get(2) : null;
            SQLiteDatabase database = getDatabase(str);
            synchronized (database) {
                if (TextUtils.equals(str3, EXTEND_CONFLICT_IGNORE)) {
                    database.insertWithOnConflict(str2, null, contentValues, 4);
                } else {
                    database.insertWithOnConflict(str2, null, contentValues, 5);
                }
                if (str.equals(Databases.PROPERTY) && str2.equals(PROPERTY.TABLE_NAME)) {
                    try {
                        uri2 = PROPERTY.CONTENT_URI.buildUpon().appendQueryParameter("key", contentValues.getAsString(Columns.KEY)).build();
                    } catch (Exception e) {
                        uri2 = PROPERTY.CONTENT_URI;
                    }
                    getContext().getContentResolver().notifyChange(uri2, null);
                }
            }
            return uri;
        } catch (Exception e2) {
            handleSQLException(e2);
            return null;
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            List pathSegments = uri.getPathSegments();
            String str3 = (String) pathSegments.get(0);
            String str4 = (String) pathSegments.get(1);
            SQLiteDatabase database = getDatabase(str3);
            synchronized (database) {
                String query = uri.getQuery();
                if (TextUtils.isEmpty(query)) {
                    LogWrapper.m2796v("baicizhandb", "query " + str4 + ", " + str + "args " + (strArr2 != null ? TextUtils.join(",", strArr2) : "null"));
                    Cursor query2 = database.query(str4, strArr, str, strArr2, null, null, str2);
                    return query2;
                } else if (!str4.equals(Contracts.RAW_QUERY)) {
                    return null;
                } else {
                    Cursor rawQuery = database.rawQuery(query, strArr2);
                    return rawQuery;
                }
            }
        } catch (Exception e) {
            handleSQLException(e);
            return null;
        }
    }

    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) {
        try {
            return super.applyBatch(arrayList);
        } catch (Exception e) {
            handleSQLException(e);
            return null;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int update;
        try {
            List pathSegments = uri.getPathSegments();
            String str2 = (String) pathSegments.get(0);
            String str3 = (String) pathSegments.get(1);
            SQLiteDatabase database = getDatabase(str2);
            synchronized (database) {
                update = database.update(str3, contentValues, str, strArr);
            }
            return update;
        } catch (Exception e) {
            handleSQLException(e);
            return 0;
        }
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        int length;
        try {
            List pathSegments = uri.getPathSegments();
            String str = (String) pathSegments.get(0);
            String str2 = (String) pathSegments.get(1);
            SQLiteDatabase database = getDatabase(str);
            synchronized (database) {
                try {
                    database.beginTransaction();
                    for (ContentValues insertWithOnConflict : contentValuesArr) {
                        database.insertWithOnConflict(str2, null, insertWithOnConflict, 5);
                    }
                    database.setTransactionSuccessful();
                    database.endTransaction();
                    length = contentValuesArr.length;
                } catch (Throwable th) {
                    database.endTransaction();
                    throw th;
                }
            }
            return length;
        } catch (Exception e) {
            handleSQLException(e);
            return 0;
        }
    }

    private String getRoot() {
        if (TextUtils.isEmpty(this.mRoot)) {
            this.mRoot = new File(StoragePathDetector.detect(getContext())).getAbsolutePath();
        }
        return this.mRoot;
    }

    private SQLiteDatabase getDatabase(String str) {
        SQLiteOpenHelper r0;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.mDatabaseMap.get(str);
        if (sQLiteDatabase == null) {
            synchronized (this.mDatabaseMap) {
                sQLiteDatabase = (SQLiteDatabase) this.mDatabaseMap.get(str);
                if (sQLiteDatabase == null) {
                    String absolutePath = new File(getRoot(), str).getAbsolutePath();
                    LogWrapper.m2793d("baicizhandb", "try open database " + absolutePath);
                    if (str.equals(Databases.PROPERTY)) {
                        r0 = new PropertyDatabase(getContext(), absolutePath, null, 23);
                    } else if (str.equals(Databases.USER)) {
                        r0 = new UserDatabase(getContext(), absolutePath, null, 23);
                    } else if (str.equals(Databases.TOPIC)) {
                        r0 = new TopicDatabase(getContext(), absolutePath, null, 23);
                    } else if (str.equals(Databases.TOPIC_PROBLEM)) {
                        r0 = new TopicProblemDatabase(getContext(), absolutePath, null, 23);
                    } else if (str.equals(Databases.TOPIC_WORD_MEAN)) {
                        r0 = new TopicWordMeanDatabase(getContext(), absolutePath, null, 23);
                    } else if (str.equals(Databases.WORD_RADIO_TOPIC)) {
                        r0 = new WordRadioTopicDatabase(getContext(), absolutePath, null, 23);
                    } else if (str.equals(Databases.DO_EXAMPLE_INFO)) {
                        r0 = new DoExampleInfoDatabase(getContext(), absolutePath, null, 23);
                    } else if (str.equals(Databases.WORD_MEDIA)) {
                        r0 = new WordMediaDatabase(getContext(), absolutePath, null, 23);
                    } else if (str.equals(Databases.EVERY_NOTICE)) {
                        r0 = new EveryNoticeDatabase(getContext(), absolutePath, null, 23);
                    } else if (str.equals(Databases.WORD_LOCK)) {
                        r0 = new WordLockDatabase(getContext(), absolutePath, null, 23);
                    } else if (str.equals(Databases.STATS)) {
                        r0 = new StatsDatabase(getContext(), absolutePath, null, 23);
                    } else {
                        r0 = new SQLiteOpenHelper(getContext(), absolutePath, null, 23) {
                            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                            }

                            public void onCreate(SQLiteDatabase sQLiteDatabase) {
                            }
                        };
                    }
                    sQLiteDatabase = r0.getWritableDatabase();
                    this.mDatabaseMap.put(str, sQLiteDatabase);
                    LogWrapper.m2793d("baicizhandb", "open database " + absolutePath + ", " + sQLiteDatabase);
                }
            }
        }
        return sQLiteDatabase;
    }

    private void handleSQLException(Exception exc) {
        if ((exc instanceof SQLiteFullException) || (exc instanceof SQLiteDiskIOException) || (exc instanceof SQLiteOutOfMemoryException) || (exc instanceof IllegalStateException) || (exc instanceof SQLiteDatabaseCorruptException)) {
            LogWrapper.m2794e("baicizhandb", "handleSQLException " + exc);
            closeDatabases();
        }
    }
}
