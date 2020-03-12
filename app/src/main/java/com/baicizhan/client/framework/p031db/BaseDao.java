package com.baicizhan.client.framework.p031db;

import android.database.sqlite.SQLiteOpenHelper;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;
import java.util.List;
import org.slf4j.Logger;

/* renamed from: com.baicizhan.client.framework.db.BaseDao */
public abstract class BaseDao {

    /* renamed from: cp */
    protected ConnectionProxy f2298cp = null;

    public BaseDao(String str) {
        try {
            this.f2298cp = ConnectionPool.getInstance().get(str);
        } catch (Exception e) {
            try {
                if (LSwitcher.isOpened()) {
                    C0789L.log.warn("get connection error", (Throwable) e);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (LSwitcher.isOpened()) {
                    C0789L.log.error("construct BaseDao error", (Throwable) e2);
                }
            }
        }
    }

    public BaseDao(SQLiteOpenHelper sQLiteOpenHelper) {
        try {
            this.f2298cp = ConnectionPool.getInstance().get(sQLiteOpenHelper);
        } catch (Exception e) {
            try {
                if (LSwitcher.isOpened()) {
                    C0789L.log.warn("get connection error", (Throwable) e);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (LSwitcher.isOpened()) {
                    C0789L.log.error("construct BaseDao error", (Throwable) e2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        try {
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        ConnectionPool.getInstance().free();
        if (LSwitcher.isOpened()) {
            C0789L.log.debug("BaseDao free connection");
        }
    }

    /* access modifiers changed from: protected */
    public boolean execute(String str, Object... objArr) {
        if (str == null) {
            return false;
        }
        try {
            this.f2298cp.prepare(str, objArr).executeUpdate();
            return true;
        } catch (Exception e) {
            Exception exc = e;
            if (LSwitcher.isOpened()) {
                Logger logger = C0789L.log;
                String str2 = "execute [%s] error connection [%s]";
                Object[] objArr2 = new Object[2];
                objArr2[0] = str;
                objArr2[1] = this.f2298cp != null ? this.f2298cp.getConnection() : "null";
                logger.warn(String.format(str2, objArr2), (Throwable) exc);
            }
            return false;
        }
    }

    public <T> T queryOne(String str, Class<T> cls, Object... objArr) {
        if (str == null || cls == null) {
            return null;
        }
        try {
            return this.f2298cp.prepare(str, objArr).executeQueryAsSingleResult(cls);
        } catch (Exception e) {
            Exception exc = e;
            if (LSwitcher.isOpened()) {
                Logger logger = C0789L.log;
                String str2 = "execute query [%s] error connection [%s]";
                Object[] objArr2 = new Object[2];
                objArr2[0] = str;
                objArr2[1] = this.f2298cp != null ? this.f2298cp.getConnection() : "null";
                logger.warn(String.format(str2, objArr2), (Throwable) exc);
            }
            return null;
        }
    }

    public <T> List<T> query(String str, Class<T> cls, Object... objArr) {
        if (str == null || cls == null) {
            return null;
        }
        try {
            return this.f2298cp.prepare(str, objArr).executeQuery(cls);
        } catch (Exception e) {
            Exception exc = e;
            if (LSwitcher.isOpened()) {
                Logger logger = C0789L.log;
                String str2 = "execute query [%s] error connection [%s]";
                Object[] objArr2 = new Object[2];
                objArr2[0] = str;
                objArr2[1] = this.f2298cp != null ? this.f2298cp.getConnection() : "null";
                logger.warn(String.format(str2, objArr2), (Throwable) exc);
            }
            return null;
        }
    }

    public boolean update(String str, Object... objArr) {
        if (str == null) {
            return false;
        }
        try {
            return this.f2298cp.prepare(str, objArr).executeUpdate() > 0;
        } catch (Exception e) {
            Exception exc = e;
            if (LSwitcher.isOpened()) {
                Logger logger = C0789L.log;
                String str2 = "execute update [%s] error connection [%s]";
                Object[] objArr2 = new Object[2];
                objArr2[0] = str;
                objArr2[1] = this.f2298cp != null ? this.f2298cp.getConnection() : "null";
                logger.warn(String.format(str2, objArr2), (Throwable) exc);
            }
            return false;
        }
    }

    public int insert(String str, Object... objArr) {
        int i = -1;
        if (str != null) {
            SQLExecutor sQLExecutor = null;
            try {
                sQLExecutor = this.f2298cp.prepare(str, objArr);
                i = sQLExecutor.executeInsertAndGetId();
                if (sQLExecutor != null) {
                    sQLExecutor.close();
                }
            } catch (Exception e) {
                if (LSwitcher.isOpened()) {
                    Logger logger = C0789L.log;
                    String str2 = "execute insert [%s] error connection [%s]";
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = str;
                    objArr2[1] = this.f2298cp != null ? this.f2298cp.getConnection() : "null";
                    logger.warn(String.format(str2, objArr2), (Throwable) e);
                }
                if (sQLExecutor != null) {
                    sQLExecutor.close();
                }
            } catch (Throwable th) {
                if (sQLExecutor != null) {
                    sQLExecutor.close();
                }
                throw th;
            }
        }
        return i;
    }
}
