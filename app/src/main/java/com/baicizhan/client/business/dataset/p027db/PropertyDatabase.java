package com.baicizhan.client.business.dataset.p027db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baicizhan.client.business.util.LogWrapper;

/* renamed from: com.baicizhan.client.business.dataset.db.PropertyDatabase */
public class PropertyDatabase extends SQLiteOpenHelper {
    public PropertyDatabase(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ZPROPERTY (KEY VARCHAR PRIMARY KEY NOT NULL, VALUE VARCHAR)");
        } catch (SQLException e) {
            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
