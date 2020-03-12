package com.baicizhan.client.business.dataset.helpers;

import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baicizhan.client.business.dataset.provider.Cursors;
import com.baicizhan.client.business.dataset.provider.QueryBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class DBHelper {
    public static long queryNumEntries(Context context, String str, String str2, String str3, String[] strArr) {
        return Cursors.toSimpleLong(QueryBuilder.rawQuery(str, "SELECT count(*) from " + str2 + (!TextUtils.isEmpty(str3) ? " WHERE " + str3 : ""), strArr).perform(context));
    }

    public static boolean queryIsEmpty(Context context, String str, String str2) {
        if (Cursors.toSimpleLong(QueryBuilder.rawQuery(str, "SELECT exists(SELECT 1 FROM " + str2 + ")", new String[0]).perform(context)) == 0) {
            return true;
        }
        return false;
    }

    public static boolean queryTableExists(Context context, String str, String str2) {
        if (Cursors.toSimpleLong(QueryBuilder.rawQuery(str, String.format("SELECT count(*) FROM sqlite_master WHERE name = %s", new Object[]{DatabaseUtils.sqlEscapeString(str2)}), new String[0]).perform(context)) == 1) {
            return true;
        }
        return false;
    }

    public static List<String> queryAllTableNames(Context context, String str) {
        return Cursors.mapToList(QueryBuilder.rawQuery(str, "SELECT name FROM sqlite_master WHERE type=?", "table").perform(context), String.class);
    }

    public static List<String> queryAllTableNames(SQLiteDatabase sQLiteDatabase) {
        return Cursors.mapToList(sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type=\"table\"", null), String.class);
    }

    public static List<String> queryAllTableNamesStartsWith(Context context, String str, String str2) {
        List<String> queryAllTableNames = queryAllTableNames(context, str);
        if (queryAllTableNames == null || queryAllTableNames.size() == 0) {
            return queryAllTableNames;
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : queryAllTableNames) {
            if (str3.startsWith(str2)) {
                arrayList.add(str3);
            }
        }
        return arrayList;
    }

    public static List<String> queryAllTableNamesMatches(Context context, String str, Pattern pattern) {
        List<String> queryAllTableNames = queryAllTableNames(context, str);
        if (queryAllTableNames == null || queryAllTableNames.size() == 0) {
            return queryAllTableNames;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : queryAllTableNames) {
            if (pattern.matcher(str2).matches()) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static List<String> queryAllTableNamesMatches(SQLiteDatabase sQLiteDatabase, Pattern pattern) {
        List<String> queryAllTableNames = queryAllTableNames(sQLiteDatabase);
        if (queryAllTableNames == null || queryAllTableNames.size() == 0) {
            return queryAllTableNames;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : queryAllTableNames) {
            if (pattern.matcher(str).matches()) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static int queryIntFieldMax(Context context, String str, String str2, String str3) {
        return Cursors.toSimpleInt(QueryBuilder.rawQuery(str, String.format("SELECT MAX(%s) FROM %s", new Object[]{str3, str2}), new String[0]).perform(context));
    }
}
