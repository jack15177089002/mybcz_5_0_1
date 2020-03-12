package com.baicizhan.client.business.dataset.p027db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baicizhan.client.business.util.LogWrapper;

/* renamed from: com.baicizhan.client.business.dataset.db.DoExampleInfoDatabase */
public class DoExampleInfoDatabase extends SQLiteOpenHelper {
    public DoExampleInfoDatabase(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ZBOOKFINISHINFO(book_id INTEGER PRIMARY KEY, word_finish_count integer, is_current_select_book integer, daily_new_word integer default 0, sync_state long default 0, daka_days integer default 0, last_daka_times long default 0, max_offline_days integer default 0, max_offline_problem_count integer default 0, last_danciliang_times long default 0, last_danciliang_finish_word_count long default 0)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ZBOOKRESOURCE(book_id integer PRIMARY KEY, updatetime long, setdatetime long, word_count integer, bookname varchar, update_data long default 0, update_local_data long default 0, description varchar default \"\", zword_radio_update_time long default -1, roadmap_ver varchar default \"\")");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ZBOOKWORDINFO(BOOK_ID INTEGER, UPDATETIME LONG, TYPE INTEGER, ALL_WORD BLOB)");
            sQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS book_word_info_unique_index ON ZBOOKWORDINFO(BOOK_ID, TYPE)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS KVDICT(key VARCHAR NOT NULL PRIMARY KEY, value VARCHAR default \"\")");
        } catch (SQLException e) {
            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
        }
        onUpgrade(sQLiteDatabase, 0, 0);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS book_word_info_unique_index ON ZBOOKWORDINFO(BOOK_ID, TYPE)");
        } catch (Exception e) {
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS KVDICT(key VARCHAR NOT NULL PRIMARY KEY, value VARCHAR default \"\")");
        } catch (Exception e2) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZBOOKFINISHINFO ADD LAST_DANCILIANG_TIMES long default 0;");
        } catch (Exception e3) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZBOOKFINISHINFO ADD LAST_DANCILIANG_FINISH_WORD_COUNT long default 0;");
        } catch (Exception e4) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZBOOKRESOURCE  ADD update_data long default 0");
        } catch (Exception e5) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZBOOKRESOURCE  ADD roadmap_ver VARCHAR default \\\"\\\"");
        } catch (Exception e6) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZBOOKRESOURCE  ADD description VARCHAR default \\\"\\\"");
        } catch (Exception e7) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZBOOKFINISHINFO  ADD DAILY_NEW_WORD INTEGER default  0;");
        } catch (Exception e8) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZBOOKFINISHINFO  ADD DAKA_DAYS INTEGER default  0;");
        } catch (Exception e9) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZBOOKFINISHINFO  ADD LAST_DAKA_TIMES long default  0;");
        } catch (Exception e10) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZBOOKFINISHINFO  ADD MAX_OFFLINE_DAYS INTEGER default  0;");
        } catch (Exception e11) {
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZBOOKFINISHINFO  ADD MAX_OFFLINE_PROBLEM_COUNT long default  0;");
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZBOOKFINISHINFO  ADD sync_state long default  0;");
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZBOOKFINISHINFO  ADD LAST_DANCILIANG_TIMES long default  0;");
        } catch (Exception e14) {
            e14.printStackTrace();
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZBOOKFINISHINFO  ADD LAST_DANCILIANG_FINISH_WORD_COUNT long default  0;");
        } catch (Exception e15) {
            e15.printStackTrace();
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ZBOOKRESOURCE  ADD ZWORD_RADIO_UPDATE_TIME long default -1");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
