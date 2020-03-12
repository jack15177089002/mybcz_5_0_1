package com.baicizhan.client.business.dataset.provider;

import android.content.Context;
import android.database.DatabaseUtils;
import android.text.TextUtils;

public class ProviderUtils {
    public static int queryNumEntries(Context context, String str, String str2, String str3, String[] strArr) {
        return Cursors.toSimpleInt(QueryBuilder.rawQuery(str, "SELECT count(*) from " + str2 + (!TextUtils.isEmpty(str3) ? " WHERE " + str3 : ""), strArr).perform(context));
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

    public static int queryIntFieldMax(Context context, String str, String str2, String str3) {
        return Cursors.toSimpleInt(QueryBuilder.rawQuery(str, String.format("SELECT MAX(%s) FROM %s", new Object[]{str3, str2}), new String[0]).perform(context));
    }
}
