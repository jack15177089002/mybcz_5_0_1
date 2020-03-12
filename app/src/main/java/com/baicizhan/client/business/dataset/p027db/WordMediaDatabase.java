package com.baicizhan.client.business.dataset.p027db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baicizhan.client.business.dataset.provider.Contracts.WORD_MEDIA_TB;
import java.util.Locale;
import java.util.regex.Pattern;

/* renamed from: com.baicizhan.client.business.dataset.db.WordMediaDatabase */
public class WordMediaDatabase extends SQLiteOpenHelper {
    public static final String COL_FM_MID_UPDATE = "fm_mid_update";
    public static final String COL_LOADED_BOOK_ID = "loaded_book_id";
    public static final String COL_MID_PATH = "path";
    public static final String COL_MID_TYPE = "type";
    public static final String COL_TV_MID_UPDATE = "tv_mid_update";
    public static final String TB_WORD_MEDIA_BOOK = "tb_word_media_book";
    public static final String TB_WORD_MEDIA_MID = "tb_word_media_mid";
    public static final String TB_WORD_MEDIA_MID_UPD = "tb_word_media_mid_update";

    public WordMediaDatabase(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append("tb_word_media_mid(path TEXT UNIQUE, type INTEGER)");
        sQLiteDatabase.execSQL(sb.toString());
        StringBuilder sb2 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb2.append("tb_word_media_mid_update(fm_mid_update INTEGER, tv_mid_update INTEGER)");
        sQLiteDatabase.execSQL(sb2.toString());
        StringBuilder sb3 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb3.append("tb_word_media_book(loaded_book_id INTEGER PRIMARY KEY)");
        sQLiteDatabase.execSQL(sb3.toString());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_word_media_mid");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_word_media_mid_update");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_word_media_book");
        onCreate(sQLiteDatabase);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        addWordMediaTVSnapshotColumn(sQLiteDatabase);
    }

    private void addWordMediaTVSnapshotColumn(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        Pattern compile = Pattern.compile(String.format(Locale.US, "%s_\\d+", new Object[]{WORD_MEDIA_TB.TABLE_NAME_BASE}));
        try {
            cursor = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type = \"table\" and name like \"tb_word_media%\"", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String string = cursor.getString(0);
                if (compile.matcher(string).matches()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ALTER TABLE ").append(string).append(" ADD tv_snapshot_path VARCHAR DEFAULT \"\"");
                    try {
                        sQLiteDatabase.execSQL(sb.toString());
                    } catch (Exception e) {
                    }
                }
                cursor.moveToNext();
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e2) {
            Log.e("baicizhandb", Log.getStackTraceString(e2));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
