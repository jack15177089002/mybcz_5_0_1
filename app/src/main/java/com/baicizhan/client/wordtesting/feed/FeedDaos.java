//package com.baicizhan.client.wordtesting.feed;
//
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_TOPIC_DATA_ALL;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.framework.p031db.BaseDao;
//import com.baicizhan.client.framework.p031db.ConnectionPool;
//import com.baicizhan.client.framework.p031db.ConnectionPool.ConnectionMode;
//import com.baicizhan.client.framework.p031db.ConnectionPool.OpenMode;
//import java.io.File;
//import java.util.List;
//import p012ch.qos.logback.classic.spi.CallerData;
//
//public class FeedDaos {
//
//    class WordDao extends BaseDao {
//        WordDao() {
//            super(new File(PathUtil.getBaicizhanAppRoot(), Databases.TOPIC_PROBLEM).getAbsolutePath());
//        }
//
//        /* access modifiers changed from: 0000 */
//        public void writebackWords2Review(int i, List<WordId> list) {
//            if (list != null && !list.isEmpty()) {
//                String valueOf = String.valueOf(i);
//                if (i < 10) {
//                    valueOf = "0" + i;
//                }
//                String str = "ts_learn_offline_dotopic_sync_ids_" + valueOf;
//                for (WordId wordId : list) {
//                    if (update("update " + str + " set topic_obn=?, err_num=err_num+1, last_do_time=? where topic_id=?", Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(wordId.f2397id))) {
//                        C0789L.log.info("this word should be reviewed again, its id is [{}]", (Object) Integer.valueOf(wordId.f2397id));
//                    }
//                }
//            }
//        }
//    }
//
//    public class WordId {
//        /* access modifiers changed from: private */
//
//        /* renamed from: id */
//        public int f2397id;
//    }
//
//    class WordIdDao extends BaseDao {
//        WordIdDao() {
//            super(new File(PathUtil.getBaicizhanAppRoot(), Databases.JIONGJI_DAILY).getAbsolutePath());
//        }
//
//        /* access modifiers changed from: 0000 */
//        public List<WordId> getIds(List<String> list) {
//            if (list == null || list.isEmpty()) {
//                return null;
//            }
//            String str = TS_TOPIC_DATA_ALL.TABLE_NAME;
//            StringBuilder sb = new StringBuilder("select distinct ");
//            sb.append("topic_id as id from ").append(str).append(" where topic_word in (").append(FeedDaos.makePlaceholders(list.size())).append(")");
//            return query(sb.toString(), WordId.class, list.toArray(new String[list.size()]));
//        }
//    }
//
//    public void writebackWords2Review(int i, List<String> list) {
//        try {
//            ConnectionPool.getInstance().init(ConnectionMode.ONE_PER_FETCH, OpenMode.READ_WRITE);
//            List ids = new WordIdDao().getIds(list);
//            C0789L.log.info("the wrong words' ids [{}]", (Object) ids);
//            new WordDao().writebackWords2Review(i, ids);
//            try {
//                ConnectionPool.getInstance().destroy();
//            } catch (Exception e) {
//            }
//        } catch (Exception e2) {
//            C0789L.log.warn("write back words to review from db error", (Throwable) e2);
//            try {
//                ConnectionPool.getInstance().destroy();
//            } catch (Exception e3) {
//            }
//        } finally {
//            try {
//                ConnectionPool.getInstance().free();
//            } catch (Exception e4) {
//            }
//            try {
//                ConnectionPool.getInstance().destroy();
//            } catch (Exception e5) {
//            }
//        }
//    }
//
//    /* access modifiers changed from: private */
//    public static String makePlaceholders(int i) {
//        if (i <= 0) {
//            throw new RuntimeException("No placeholders");
//        }
//        StringBuilder sb = new StringBuilder((i * 2) - 1);
//        sb.append(CallerData.f1661NA);
//        for (int i2 = 1; i2 < i; i2++) {
//            sb.append(",?");
//        }
//        return sb.toString();
//    }
//}
