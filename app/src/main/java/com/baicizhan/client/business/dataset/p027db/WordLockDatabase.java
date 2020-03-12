package com.baicizhan.client.business.dataset.p027db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.baicizhan.client.business.dataset.db.WordLockDatabase */
public class WordLockDatabase extends SQLiteOpenHelper {
    private static final String COL_REV_TODAY_TOPIC_ID = "topic_id";
    private static final String COL_REV_TOPIC_ID = "topic_id";
    private static final String TB_REVIEW = "tb_review";
    private static final String TB_REVIEW_TODAY = "tb_review_today";

    public WordLockDatabase(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append("tb_review(topic_id INTEGER UNIQUE)");
        sQLiteDatabase.execSQL(sb.toString());
        StringBuilder sb2 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb2.append("tb_review_today(topic_id INTEGER UNIQUE)");
        sQLiteDatabase.execSQL(sb2.toString());
        StringBuilder sb3 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb3.append("tb_search_history(time INTEGER, book_id INTEGER, topic_id INTEGER, word TEXT, accent TEXT, cnmean TEXT, audio TEXT, example TEXT, cnexample TEXT, image TEXT, vivid TEXT, enmean TEXT, root TEXT, zpk_path TEXT, flag INTEGER)");
        sQLiteDatabase.execSQL(sb3.toString());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_review");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_review_today");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_search_history");
        onCreate(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }
}
