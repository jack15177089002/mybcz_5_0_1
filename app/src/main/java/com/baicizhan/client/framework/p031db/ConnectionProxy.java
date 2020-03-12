package com.baicizhan.client.framework.p031db;

import android.database.sqlite.SQLiteDatabase;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;

/* renamed from: com.baicizhan.client.framework.db.ConnectionProxy */
public class ConnectionProxy {
    protected SQLiteDatabase connection = null;

    public ConnectionProxy(SQLiteDatabase sQLiteDatabase) {
        this.connection = sQLiteDatabase;
    }

    public SQLiteDatabase getConnection() {
        return this.connection;
    }

    public SQLExecutor prepare(String str, Object... objArr) {
        return prepare(true, str, objArr);
    }

    public SQLExecutor prepare(boolean z, String str, Object... objArr) {
        SQLExecutorProxy sQLExecutorProxy = new SQLExecutorProxy(new SQLExecutor(this.connection, str, objArr), z);
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (objArr != null && i < objArr.length) {
            if (i > 0) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(objArr[i]);
            i++;
        }
        if (LSwitcher.isOpened()) {
            C0789L.log.debug("execute sql [{}] args[{}]", (Object) str, (Object) stringBuffer.toString());
        }
        return sQLExecutorProxy.getInstance();
    }

    public void beginTransaction() {
        if (LSwitcher.isOpened()) {
            C0789L.log.debug("begin transaction");
        }
        this.connection.beginTransaction();
    }

    public void commit() {
        try {
            if (LSwitcher.isOpened()) {
                C0789L.log.debug("commit");
            }
            this.connection.setTransactionSuccessful();
        } finally {
            this.connection.endTransaction();
        }
    }

    public void rollback() {
        try {
            if (LSwitcher.isOpened()) {
                C0789L.log.debug("rollback");
            }
        } finally {
            this.connection.endTransaction();
        }
    }
}
