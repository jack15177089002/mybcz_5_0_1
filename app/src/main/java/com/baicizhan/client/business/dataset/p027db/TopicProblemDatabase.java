package com.baicizhan.client.business.dataset.p027db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baicizhan.client.business.util.LogWrapper;

/* renamed from: com.baicizhan.client.business.dataset.db.TopicProblemDatabase */
public class TopicProblemDatabase extends SQLiteOpenHelper {
    public TopicProblemDatabase(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ts_offline_sync_state (book_id integer primary key,sync_state integer,run_time integer,roadmap_ver integer default 0,want_more_count integer default 0,combo_count integer default 0,max_combo_count integer default 0)");
        } catch (SQLException e) {
            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
        }
        onUpgrade(sQLiteDatabase, -1, 0);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ts_offline_sync_state ADD COLUMN want_more_count integer default 0");
        } catch (SQLException e) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ts_offline_sync_state ADD COLUMN combo_count integer default 0");
        } catch (SQLException e2) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ts_offline_sync_state ADD COLUMN max_combo_count integer default 0");
        } catch (SQLException e3) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ts_offline_sync_state ADD COLUMN want_more_count integer default 0");
        } catch (SQLException e4) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ts_offline_sync_state ADD COLUMN combo_count integer default 0");
        } catch (SQLException e5) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ts_offline_sync_state ADD COLUMN roadmap_ver integer default 0");
        } catch (SQLException e6) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ts_offline_sync_state ADD COLUMN roadmap_save integer default 0");
        } catch (SQLException e7) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ts_offline_sync_state  ADD roadmap_save integer default 0");
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
