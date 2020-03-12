package com.baicizhan.client.business.logoload;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LoadLogoPageDBHelper extends SQLiteOpenHelper {
    private static final String COL_DURATION = "duration";
    private static final String COL_END = "end";
    private static final String COL_LOADED = "loaded";
    private static final String COL_START = "start";
    private static final String COL_URL = "url";
    private static final String COL_VERSION = "version";
    private static final int DATABASE_VERSION = 2;
    private static final String LOADING_DB = "loadingdb.db";
    private static final String TB_INFO = "tb_info";
    private static final String TB_LOADING = "tb_loading";

    public LoadLogoPageDBHelper(Context context) {
        super(context, LOADING_DB, null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createLoadingTable(sQLiteDatabase);
        createInfoTable(sQLiteDatabase);
    }

    private void createLoadingTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append("tb_loading(url TEXT, start INTEGER, end INTEGER, duration INTEGER, loaded INTEGER)");
        sQLiteDatabase.execSQL(sb.toString());
    }

    private void createInfoTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append("tb_info(version INTEGER)");
        sQLiteDatabase.execSQL(sb.toString());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_loading");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_info");
        onCreate(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }
}
