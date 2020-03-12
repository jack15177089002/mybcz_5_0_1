package com.baicizhan.client.business.dataset.p027db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baicizhan.client.business.util.LogWrapper;

/* renamed from: com.baicizhan.client.business.dataset.db.TopicWordMeanDatabase */
public class TopicWordMeanDatabase extends SQLiteOpenHelper {
    private static final String SQL_CREATE_TOPIC_RESOUCE_EXTRA_TABLE = "CREATE TABLE IF NOT EXISTS ZTOPICRESOURCEWORDEXTRA(TOPIC INTEGER PRIMARY KEY NOT NULL,UPDATELABEL VARCHAR, ZWORDMEAN_EN VARCHAR, ZWORD_EXAMPLE_KEYWORD VARCHAR, ZWORD_ETYMA VARCHAR, ZWORD_DEFORMATION_IMG VARCHAR, ZDEFORMATION_DESC VARCHAR default \"\", ZKEYWORD_VARIANTS VARCHAR default \"\", ZSENTENCE_TRANS VARCHAR default \"\")";

    public TopicWordMeanDatabase(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(SQL_CREATE_TOPIC_RESOUCE_EXTRA_TABLE);
        } catch (SQLException e) {
            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
        }
        onUpgrade(sQLiteDatabase, 0, 0);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
