package com.baicizhan.client.business.dataset.p027db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baicizhan.client.business.dataset.helpers.DBHelper;
import com.baicizhan.client.business.util.LogWrapper;
import java.util.Locale;
import java.util.regex.Pattern;

/* renamed from: com.baicizhan.client.business.dataset.db.TopicDatabase */
public class TopicDatabase extends SQLiteOpenHelper {
    public TopicDatabase(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ZSHORTPHRASETOPICRESOURCE(TOPIC INTEGER PRIMARY KEY, ZWORD VARCHAR, ZSENTENCE VARCHAR, ZWORDVIDEO VARCHAR, ZSENTENCEVIDEO VARCHAR, ZIMAGEPATH VARCHAR, ZWORDMEAN VARCHAR, ZWORDVARIANTS VARCHAR, ZSIMILAR_HIGHLIGHT VARCHAR, ZSENTENCE2 VARCHAR, ZSENTENCE_TRANS VARCHAR, ZSENTENCE_TRANS2 VARCHAR, ZSENTENCEVIDEO2 VARCHAR, ZEXPLAINCIDEO VARCHAR, ZEXPLAIN VARCHAR, ZSENTENCEWORDHIGHLIGHT VARCHAR, ZSENTENCEWORDHIGHLIGHT2 VARCHAR, ZEXAMINFO VARCHAR)");
        } catch (SQLException e) {
            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
        }
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        for (String str : DBHelper.queryAllTableNamesMatches(sQLiteDatabase, Pattern.compile("topic_resource_\\d+"))) {
            try {
                sQLiteDatabase.execSQL(String.format(Locale.US, "ALTER TABLE %s ADD COLUMN zpk_path VARCHAR DEFAULT \"\"", new Object[]{str}));
                sQLiteDatabase.execSQL(String.format(Locale.US, "ALTER TABLE %s ADD COLUMN update_flag_md5 VARCHAR DEFAULT \"\"", new Object[]{str}));
            } catch (Exception e) {
            }
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
