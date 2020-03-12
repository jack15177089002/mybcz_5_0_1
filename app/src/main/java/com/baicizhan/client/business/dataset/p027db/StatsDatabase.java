package com.baicizhan.client.business.dataset.p027db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.baicizhan.client.business.dataset.db.StatsDatabase */
public class StatsDatabase extends SQLiteOpenHelper {
    public StatsDatabase(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append("tb_stats_word_done(topic_id INTEGER, is_today_new INTEGER, is_done_right INTEGER, option INTEGER, done_type INTEGER, duration INTEGER)");
        sQLiteDatabase.execSQL(sb.toString());
        StringBuilder sb2 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb2.append("tb_stats_operation(op_name TEXT, op_value INTEGER, op_time INTEGER)");
        sQLiteDatabase.execSQL(sb2.toString());
        StringBuilder sb3 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb3.append("tb_stats_operation_common(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, op_type INTEGER, op_time INTEGER, op_value TEXT)");
        sQLiteDatabase.execSQL(sb3.toString());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_stats_word_done");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_stats_operation");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_stats_operation_common");
        onCreate(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
