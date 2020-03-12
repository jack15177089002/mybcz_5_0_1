package com.baicizhan.client.wordtesting.doc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DocDBHelper extends SQLiteOpenHelper {
    public static final String COL_GRADE = "grade";
    public static final String COL_TEXT = "text";
    private static final int DATABASE_VERSION = 1;
    private static final String DOC_DB = "docdb.db";
    public static final String TB_DOCINFO = "tb_doc_info";

    public DocDBHelper(Context context) {
        super(context, DOC_DB, null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append("tb_doc_info(text TEXT, grade INTEGER)");
        sQLiteDatabase.execSQL(sb.toString());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_doc_info");
        onCreate(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }
}
