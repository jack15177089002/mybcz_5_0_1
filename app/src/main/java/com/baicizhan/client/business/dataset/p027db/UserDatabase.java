package com.baicizhan.client.business.dataset.p027db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baicizhan.client.business.util.LogWrapper;

/* renamed from: com.baicizhan.client.business.dataset.db.UserDatabase */
public class UserDatabase extends SQLiteOpenHelper {
    public UserDatabase(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ZLOGINUSER (USER VARCHAR, ZSESSION VARCHAR, ZLOGINTYPE INTEGER, ZPASSWORD VARCHAR, ZPASSWORDMD5 VARCHAR, ZSAVESTATUS INTEGER default 1, ZPROFILEIMAGE VARCHAR default \"\", ZSEX INTEGER default 3, ZUSERNICKNAME VARCHAR default \"\")");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS login_user ON ZLOGINUSER(USER);");
        } catch (Exception e) {
            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZLOGINUSER ADD ZPASSWORDMD5 VARCHAR");
        } catch (Exception e2) {
        }
        onUpgrade(sQLiteDatabase, 0, 0);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZLOGINUSER ADD ZPASSWORDMD5 VARCHAR");
        } catch (Exception e) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZLOGINUSER  ADD ZSAVESTATUS INTEGER default 1;");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZLOGINUSER  ADD ZPROFILEIMAGE VARCHAR default \"\"");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZLOGINUSER  ADD ZSEX INTEGER default 3");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZLOGINUSER  ADD ZUSERNICKNAME VARCHAR default \"\"");
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            sQLiteDatabase.execSQL("CREATE UNIQUE INDEX login_user ON ZLOGINUSER(USER);");
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
