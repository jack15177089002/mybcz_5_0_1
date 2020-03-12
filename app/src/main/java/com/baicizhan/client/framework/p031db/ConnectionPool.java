package com.baicizhan.client.framework.p031db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baicizhan.client.framework.log.C0789L;
import com.baicizhan.client.framework.log.LSwitcher;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.baicizhan.client.framework.db.ConnectionPool */
public class ConnectionPool {
    private static final ConnectionPool instance = new ConnectionPool();
    private ConnectionMode mode = ConnectionMode.ONE_PER_FETCH;
    private OpenMode openMode = OpenMode.OPEN_OR_CREATE;

    /* renamed from: tl */
    private ThreadLocal<ConnectionProxy> f2299tl = new ThreadLocal<>();
    private Set<SQLiteDatabase> unfreeConnections = new HashSet();

    /* renamed from: com.baicizhan.client.framework.db.ConnectionPool$ConnectionMode */
    public enum ConnectionMode {
        ONE_PER_FETCH,
        ONE_PER_SESSION
    }

    /* renamed from: com.baicizhan.client.framework.db.ConnectionPool$OpenMode */
    public enum OpenMode {
        OPEN_OR_CREATE,
        READ_ONLY,
        READ_WRITE
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    private ConnectionPool() {
    }

    public void init() {
        init(ConnectionMode.ONE_PER_FETCH, OpenMode.OPEN_OR_CREATE);
    }

    public void init(ConnectionMode connectionMode, OpenMode openMode2) {
        this.mode = connectionMode;
        this.openMode = openMode2;
        if (LSwitcher.isOpened()) {
            C0789L.log.info("ConnectionPool [mod = {}] inited!", (Object) this.mode);
        }
    }

    public ConnectionMode getMode() {
        return this.mode;
    }

    public void destroy() {
        for (SQLiteDatabase sQLiteDatabase : this.unfreeConnections) {
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                try {
                    sQLiteDatabase.close();
                } catch (Exception e) {
                    if (LSwitcher.isOpened()) {
                        C0789L.log.warn(String.format("close [%s] error", new Object[]{sQLiteDatabase}), (Throwable) e);
                    }
                }
            }
        }
        if (LSwitcher.isOpened()) {
            C0789L.log.info("ConnectionPool destroyed!");
        }
    }

    public ConnectionProxy get(String str) {
        return get(new File(str));
    }

    public ConnectionProxy get(File file) {
        SQLiteDatabase openDatabase;
        ConnectionProxy connectionProxy;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            ConnectionProxy connectionProxy2 = (ConnectionProxy) this.f2299tl.get();
            if ((ConnectionMode.ONE_PER_FETCH.equals(this.mode) && connectionProxy2 != null) || !(connectionProxy2 == null || connectionProxy2.connection == null || connectionProxy2.connection.isOpen())) {
                free();
            }
            if (this.f2299tl.get() != null) {
                connectionProxy = (ConnectionProxy) this.f2299tl.get();
            } else {
                if (OpenMode.OPEN_OR_CREATE.equals(this.openMode)) {
                    openDatabase = SQLiteDatabase.openOrCreateDatabase(file, null);
                } else {
                    openDatabase = SQLiteDatabase.openDatabase(file.getAbsolutePath(), null, OpenMode.READ_ONLY.equals(this.openMode) ? 1 : 0);
                }
                synchronized (this.unfreeConnections) {
                    this.unfreeConnections.add(openDatabase);
                }
                connectionProxy = new ConnectionProxy(openDatabase);
                this.f2299tl.set(connectionProxy);
                SQLiteDatabase sQLiteDatabase2 = connectionProxy.connection;
                if (LSwitcher.isOpened()) {
                    C0789L.log.debug("get connection [{}] from pool [mode={} openMode={}]", sQLiteDatabase2, this.mode, this.openMode);
                }
            }
            return connectionProxy;
        } finally {
            if (LSwitcher.isOpened()) {
                C0789L.log.debug("get connection [{}] from pool [mode={} openMode={}]", sQLiteDatabase, this.mode, this.openMode);
            }
        }
    }

    public ConnectionProxy get(SQLiteOpenHelper sQLiteOpenHelper) {
        ConnectionProxy connectionProxy;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            ConnectionProxy connectionProxy2 = (ConnectionProxy) this.f2299tl.get();
            if ((ConnectionMode.ONE_PER_FETCH.equals(this.mode) && connectionProxy2 != null) || !(connectionProxy2 == null || connectionProxy2.connection == null || connectionProxy2.connection.isOpen())) {
                free();
            }
            if (this.f2299tl.get() != null) {
                connectionProxy = (ConnectionProxy) this.f2299tl.get();
            } else {
                SQLiteDatabase writableDatabase = OpenMode.READ_ONLY.equals(this.openMode) ? sQLiteOpenHelper.getReadableDatabase() : sQLiteOpenHelper.getWritableDatabase();
                synchronized (this.unfreeConnections) {
                    this.unfreeConnections.add(writableDatabase);
                }
                connectionProxy = new ConnectionProxy(writableDatabase);
                this.f2299tl.set(connectionProxy);
                SQLiteDatabase sQLiteDatabase2 = connectionProxy.connection;
                if (LSwitcher.isOpened()) {
                    C0789L.log.debug("get connection [{}] from pool [mode={} openMode={}]", sQLiteDatabase2, this.mode, this.openMode);
                }
            }
            return connectionProxy;
        } finally {
            if (LSwitcher.isOpened()) {
                C0789L.log.debug("get connection [{}] from pool [mode={} openMode={}]", sQLiteDatabase, this.mode, this.openMode);
            }
        }
    }

    public void free() {
        ConnectionProxy connectionProxy = (ConnectionProxy) this.f2299tl.get();
        if (LSwitcher.isOpened()) {
            C0789L.log.debug("free connection [{}] to pool [mode={}]", connectionProxy != null ? connectionProxy.connection : "null", (Object) this.mode);
        }
        if (connectionProxy != null) {
            SQLiteDatabase sQLiteDatabase = connectionProxy.connection;
            try {
                if (sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                this.f2299tl.remove();
                synchronized (this.unfreeConnections) {
                    this.unfreeConnections.remove(sQLiteDatabase);
                }
            } catch (Exception e) {
                if (LSwitcher.isOpened()) {
                    C0789L.log.warn("close connection error", (Throwable) e);
                }
            }
        }
    }

    protected static void printStackTrace() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace != null) {
            for (int i = 0; i < stackTrace.length; i++) {
                System.out.println(stackTrace[i]);
            }
        }
    }
}
