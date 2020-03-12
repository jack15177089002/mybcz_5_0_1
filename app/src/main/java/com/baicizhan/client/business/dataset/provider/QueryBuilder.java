package com.baicizhan.client.business.dataset.provider;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.MergeCursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class QueryBuilder {
    private static final int WHERE_IN = 1;
    private static final int WHERE_NOT_IN = 2;
    private static final int WHERE_NULL = 0;
    private int mLimit;
    private String mOrderBy = null;
    private String[] mProjection = null;
    private String mSelection;
    private String[] mSelectionArgs = null;
    private Uri mUri = null;
    private int mWhereBatch;
    private String mWhereColumn;
    private int mWhereMode = 0;
    private Collection<?> mWhereSet = null;

    public QueryBuilder() {
    }

    public static QueryBuilder query(Uri uri) {
        return new QueryBuilder(uri);
    }

    public static QueryBuilder rawQuery(String str, String str2, String... strArr) {
        QueryBuilder queryBuilder = new QueryBuilder(Contracts.getRawQueryContentUri(str, str2));
        queryBuilder.where("", strArr);
        return queryBuilder;
    }

    public QueryBuilder(Uri uri) {
        this.mUri = uri;
    }

    public QueryBuilder projection(String... strArr) {
        this.mProjection = strArr;
        return this;
    }

    public QueryBuilder where(String str, String... strArr) {
        if (!TextUtils.isEmpty(str)) {
            this.mSelection = str;
        }
        if (strArr != null) {
            this.mSelectionArgs = strArr;
        }
        return this;
    }

    public <E> QueryBuilder whereIn(String str, Collection<E> collection, int i) {
        this.mWhereColumn = str;
        this.mWhereMode = 1;
        this.mWhereSet = collection;
        this.mWhereBatch = i;
        return this;
    }

    public <E> QueryBuilder whereNotIn(String str, Collection<E> collection) {
        this.mWhereColumn = str;
        this.mWhereMode = 2;
        this.mWhereSet = collection;
        return this;
    }

    public static <E> String getWhereClause(String str, String str2, Collection<E> collection) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(" ").append(str2).append(" (");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof Number) {
                sb.append(next.toString());
            } else {
                sb.append(DatabaseUtils.sqlEscapeString(next.toString()));
            }
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public QueryBuilder orderBy(String str) {
        this.mOrderBy = str;
        return this;
    }

    public QueryBuilder limit(int i) {
        this.mLimit = i;
        return this;
    }

    public Cursor perform(Context context) {
        if (this.mLimit > 0) {
            if (this.mOrderBy != null) {
                this.mOrderBy += " limit " + this.mLimit;
            } else {
                this.mOrderBy = " limit " + this.mLimit;
            }
        }
        switch (this.mWhereMode) {
            case 0:
                return context.getContentResolver().query(this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mOrderBy);
            case 1:
                return performWhereIn(context);
            case 2:
                return performWhereNotIn(context);
            default:
                return null;
        }
    }

    private Cursor performWhereNotIn(Context context) {
        return context.getContentResolver().query(this.mUri, this.mProjection, getWhereClause(this.mWhereColumn, "NOT IN", this.mWhereSet), null, this.mOrderBy);
    }

    private Cursor performWhereIn(Context context) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(this.mWhereBatch);
        int size = this.mWhereSet.size();
        int i2 = 0;
        for (Object add : this.mWhereSet) {
            arrayList2.add(add);
            int i3 = i + 1;
            if (arrayList2.size() == this.mWhereBatch || i3 == size) {
                if (i2 > 0) {
                    reLimit(this.mLimit - i2);
                }
                Cursor query = context.getContentResolver().query(this.mUri, this.mProjection, getWhereClause(this.mWhereColumn, "IN", arrayList2), null, this.mOrderBy);
                arrayList.add(query);
                if (this.mLimit > 0 && query != null) {
                    i2 += query.getCount();
                    if (i2 >= this.mLimit) {
                        break;
                    }
                }
            }
            i2 = i2;
            i = i3;
        }
        Cursor[] cursorArr = new Cursor[arrayList.size()];
        arrayList.toArray(cursorArr);
        return new MergeCursor(cursorArr);
    }

    private void reLimit(int i) {
        if (this.mOrderBy == null) {
            this.mOrderBy = " limit " + i;
            return;
        }
        int indexOf = this.mOrderBy.toLowerCase().indexOf("limit");
        if (indexOf < 0) {
            this.mOrderBy += " limit " + i;
        } else {
            this.mOrderBy = this.mOrderBy.substring(0, indexOf) + "limit " + i;
        }
    }
}
