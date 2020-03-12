package com.baicizhan.client.business.dataset.p027db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baicizhan.client.business.util.LogWrapper;

/* renamed from: com.baicizhan.client.business.dataset.db.WordRadioTopicDatabase */
public class WordRadioTopicDatabase extends SQLiteOpenHelper {
    private static final String SQL_CREATE_WORD_RADIO_HALF_TIME_TABLE = "CREATE TABLE IF NOT EXISTS ts_word_radio_half_time(ws_id integer primary key,ws_bookid integer default 0,ws_complete integer default 0,ws_audio    text,ws_update_time  integer default 0, ws_word_tv integer default 0)";
    private static final String SQL_CREATE_WORD_STATION_DATA_TABLE = "CREATE TABLE IF NOT EXISTS ts_word_station_data_all(ws_id integer primary key,ws_complete integer default 0,ws_word text,ws_word_type  text,ws_word_cn  text,ws_sentence text,ws_desc     text,ws_audio    text,ws_audio_high text, ws_read integer default 0, ws_update_time long default 0, tv_vedio_path  VARCHAR default \"\",ws_tv_update_time long default 0)";

    public WordRadioTopicDatabase(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(SQL_CREATE_WORD_RADIO_HALF_TIME_TABLE);
            sQLiteDatabase.execSQL(SQL_CREATE_WORD_STATION_DATA_TABLE);
        } catch (SQLException e) {
            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
        }
        onUpgrade(sQLiteDatabase, 0, 0);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ts_word_station_data_all  ADD ws_read long default 0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ts_word_station_data_all  ADD ws_update_time long default 0");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ts_word_station_data_all  ADD tv_vedio_path  VARCHAR default \"\"");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ts_word_station_data_all  ADD ws_tv_update_time long default 0");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            sQLiteDatabase.execSQL("ALTER TABLE ts_word_radio_half_time  ADD ws_word_tv integer default 0");
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
