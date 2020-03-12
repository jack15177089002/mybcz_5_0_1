package com.baicizhan.client.business.logoload;

import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baicizhan.client.framework.BaseAppHandler;
import com.baicizhan.client.framework.p031db.BaseDao;
import com.baicizhan.client.framework.p031db.ConnectionPool;
import com.baicizhan.client.framework.p031db.ConnectionPool.ConnectionMode;
import com.baicizhan.client.framework.p031db.ConnectionPool.OpenMode;
import java.util.List;

public class LPDaos {
    private static final String TAG = "LPDaos";

    public class Info {
        /* access modifiers changed from: private */
        public int version;
    }

    public class Loading {
        /* access modifiers changed from: private */
        public long duration;
        /* access modifiers changed from: private */
        public long end;
        /* access modifiers changed from: private */
        public long start;
        /* access modifiers changed from: private */
        public String url;

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public long getStart() {
            return this.start;
        }

        public void setStart(long j) {
            this.start = j;
        }

        public long getEnd() {
            return this.end;
        }

        public void setEnd(long j) {
            this.end = j;
        }

        public long getDuration() {
            return this.duration;
        }

        public void setDuration(long j) {
            this.duration = j;
        }
    }

    class LoadingDao extends BaseDao {
        LoadingDao() {
            super((SQLiteOpenHelper) new LoadLogoPageDBHelper(BaseAppHandler.getApp()));
        }

        /* access modifiers changed from: 0000 */
        public Loading getOneLoadedLoading() {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder("select distinct ");
            sb.append("url, start, end, duration from tb_loading where start<=? and end>=? and loaded=?");
            List query = query(sb.toString(), Loading.class, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis), Integer.valueOf(1));
            if (query == null || query.isEmpty()) {
                return null;
            }
            return (Loading) query.get((int) Math.round(((double) (query.size() - 1)) * Math.random()));
        }

        /* access modifiers changed from: 0000 */
        public Loading getOneLoadingPreferUnloaded() {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder("select distinct ");
            sb.append("url, start, end, duration from tb_loading where end>=? and loaded=?");
            List query = query(sb.toString(), Loading.class, Long.valueOf(currentTimeMillis), Integer.valueOf(0));
            if (query == null || query.isEmpty()) {
                return null;
            }
            return (Loading) query.get((int) Math.round(((double) (query.size() - 1)) * Math.random()));
        }

        /* access modifiers changed from: 0000 */
        public boolean markLoaded(String str, boolean z) {
            if (str == null) {
                return false;
            }
            String str2 = "update tb_loading set loaded=? where url=?";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? 1 : 0);
            objArr[1] = str;
            return update(str2, objArr);
        }

        /* access modifiers changed from: 0000 */
        public void init(List<Loading> list) {
            clear();
            if (list != null && !list.isEmpty()) {
                for (Loading loading : list) {
                    Log.d(LPDaos.TAG, "insert url [ " + loading.url + "] into db, col [ " + insert("insert into tb_loading (url, start, end, duration, loaded) values (?,?,?,?,?)", loading.url, Long.valueOf(loading.start), Long.valueOf(loading.end), Long.valueOf(loading.duration), Integer.valueOf(0)) + "]");
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void clear() {
            Log.d(LPDaos.TAG, "clear loadings, ret: " + update("delete from tb_loading", new Object[0]));
        }

        /* access modifiers changed from: 0000 */
        public int getVersion() {
            Info info = (Info) queryOne("select distinct version from tb_info", Info.class, new Object[0]);
            if (info != null) {
                Log.d(LPDaos.TAG, "current version of logo pages is: " + info.version);
                return info.version;
            }
            Log.d(LPDaos.TAG, "current version of logo pages is -1");
            return -1;
        }

        /* access modifiers changed from: 0000 */
        public void setVersion(int i) {
            Log.d(LPDaos.TAG, "set version [" + i + "] ret [" + update("update tb_info set version=?", Integer.valueOf(i)) + "]");
        }

        /* access modifiers changed from: 0000 */
        public void initVersion(int i) {
            clearVersion();
            Log.d(LPDaos.TAG, "insert version valid: " + insert("insert into tb_info (version) values (?)", Integer.valueOf(i)));
        }

        /* access modifiers changed from: 0000 */
        public void clearVersion() {
            Log.d(LPDaos.TAG, "clear info, ret: " + update("delete from tb_info", new Object[0]));
        }
    }

    public void init(List<Loading> list, int i) {
        try {
            ConnectionPool.getInstance().init(ConnectionMode.ONE_PER_FETCH, OpenMode.READ_WRITE);
            LoadingDao loadingDao = new LoadingDao();
            loadingDao.init(list);
            loadingDao.initVersion(i);
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            Log.e(TAG, "init loading daos error.", e2);
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e3) {
            }
        } finally {
            try {
                ConnectionPool.getInstance().free();
            } catch (Exception e4) {
            }
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e5) {
            }
        }
    }

    public Loading getOneLoadedLoading() {
        try {
            ConnectionPool.getInstance().init(ConnectionMode.ONE_PER_FETCH, OpenMode.READ_ONLY);
            Loading oneLoadedLoading = new LoadingDao().getOneLoadedLoading();
            try {
                ConnectionPool.getInstance().destroy();
                return oneLoadedLoading;
            } catch (Exception e) {
                return oneLoadedLoading;
            }
        } catch (Exception e2) {
            Log.e(TAG, "get one loaded loading error.", e2);
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e3) {
            }
            return null;
        } finally {
            try {
                ConnectionPool.getInstance().free();
            } catch (Exception e4) {
            }
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e5) {
            }
        }
    }

    public Loading getOneLoadingPreferUnloaded() {
        try {
            ConnectionPool.getInstance().init(ConnectionMode.ONE_PER_FETCH, OpenMode.READ_ONLY);
            Loading oneLoadingPreferUnloaded = new LoadingDao().getOneLoadingPreferUnloaded();
            try {
                ConnectionPool.getInstance().destroy();
                return oneLoadingPreferUnloaded;
            } catch (Exception e) {
                return oneLoadingPreferUnloaded;
            }
        } catch (Exception e2) {
            Log.e(TAG, "get one loaded loading error.", e2);
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e3) {
            }
            return null;
        } finally {
            try {
                ConnectionPool.getInstance().free();
            } catch (Exception e4) {
            }
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e5) {
            }
        }
    }

    public boolean markLoaded(String str, boolean z) {
        try {
            ConnectionPool.getInstance().init(ConnectionMode.ONE_PER_FETCH, OpenMode.READ_WRITE);
            boolean markLoaded = new LoadingDao().markLoaded(str, z);
            try {
                ConnectionPool.getInstance().destroy();
                return markLoaded;
            } catch (Exception e) {
                return markLoaded;
            }
        } catch (Exception e2) {
            Log.e(TAG, "mark url loaded error.", e2);
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e3) {
            }
            return false;
        } finally {
            try {
                ConnectionPool.getInstance().free();
            } catch (Exception e4) {
            }
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e5) {
            }
        }
    }

    public int getVersion() {
        try {
            ConnectionPool.getInstance().init(ConnectionMode.ONE_PER_FETCH, OpenMode.READ_ONLY);
            int version = new LoadingDao().getVersion();
            try {
                ConnectionPool.getInstance().destroy();
                return version;
            } catch (Exception e) {
                return version;
            }
        } catch (Exception e2) {
            Log.e(TAG, "get loading version error.", e2);
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e3) {
            }
            return -1;
        } finally {
            try {
                ConnectionPool.getInstance().free();
            } catch (Exception e4) {
            }
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e5) {
            }
        }
    }

    public void setVersion(int i) {
        try {
            ConnectionPool.getInstance().init(ConnectionMode.ONE_PER_FETCH, OpenMode.READ_WRITE);
            new LoadingDao().setVersion(i);
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            Log.e(TAG, "set loading version error.", e2);
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e3) {
            }
        } finally {
            try {
                ConnectionPool.getInstance().free();
            } catch (Exception e4) {
            }
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e5) {
            }
        }
    }

    public void upgrade(List<Loading> list, int i) {
        try {
            ConnectionPool.getInstance().init(ConnectionMode.ONE_PER_FETCH, OpenMode.READ_WRITE);
            LoadingDao loadingDao = new LoadingDao();
            Loading oneLoadedLoading = loadingDao.getOneLoadedLoading();
            int version = loadingDao.getVersion();
            Log.d(TAG, "check loaded: " + oneLoadedLoading + "; cur: " + version + "; v: " + i);
            if (version != i || oneLoadedLoading == null) {
                loadingDao.clearVersion();
                loadingDao.initVersion(i);
                loadingDao.clear();
                loadingDao.init(list);
                try {
                    ConnectionPool.getInstance().free();
                } catch (Exception e) {
                }
                try {
                    ConnectionPool.getInstance().destroy();
                } catch (Exception e2) {
                }
            } else {
                try {
                    ConnectionPool.getInstance().destroy();
                } catch (Exception e3) {
                }
            }
        } catch (Exception e4) {
            Log.e(TAG, "upgrade loading error.", e4);
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e5) {
            }
        } finally {
            try {
                ConnectionPool.getInstance().free();
            } catch (Exception e6) {
            }
            try {
                ConnectionPool.getInstance().destroy();
            } catch (Exception e7) {
            }
        }
    }
}
