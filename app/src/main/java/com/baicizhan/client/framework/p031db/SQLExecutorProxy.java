package com.baicizhan.client.framework.p031db;

/* renamed from: com.baicizhan.client.framework.db.SQLExecutorProxy */
public class SQLExecutorProxy {
    private SQLExecutor obj;
    private SQLExecutor proxy = this.obj;

    public SQLExecutorProxy(SQLExecutor sQLExecutor, boolean z) {
        this.obj = sQLExecutor;
    }

    public SQLExecutor getInstance() {
        return this.proxy;
    }
}
