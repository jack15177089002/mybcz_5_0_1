package com.baicizhan.client.business.dataset.p027db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baicizhan.client.business.util.LogWrapper;

/* renamed from: com.baicizhan.client.business.dataset.db.EveryNoticeDatabase */
public class EveryNoticeDatabase extends SQLiteOpenHelper {
    public EveryNoticeDatabase(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ts_all_notice_list(ntf_time  integer  primary key, ntf_id integer, ntf_person integer, ntf_content varchar, read_status integer)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ts_every_notice_info(ntf_id integer primary key, ntf_person integer, ntf_day integer, ntf_time integer, ntf_content varchar)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ts_notice_id_use(ntf_id  integer primary key ,read_status integer)");
            StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
            sb.append("tb_notify_message(msg_id INTEGER PRIMARY KEY, msg_type INTEGER, title TEXT, title_desc TEXT, img_url TEXT, content_url TEXT, is_hidden INTEGER, time INTEGER, read INTEGER)");
            sQLiteDatabase.execSQL(sb.toString());
        } catch (SQLException e) {
            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onCreate(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
