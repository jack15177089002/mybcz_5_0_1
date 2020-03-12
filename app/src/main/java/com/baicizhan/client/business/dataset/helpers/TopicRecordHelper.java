//package com.baicizhan.client.business.dataset.helpers;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.text.TextUtils;
//import android.util.ArrayMap;
//import android.util.Log;
//import android.util.SparseBooleanArray;
//import com.baicizhan.client.business.dataset.models.RoadmapRecord;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.dataset.provider.Contracts.TOPICRESOURCE;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZTOPICRESOURCE;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZTOPICRESOURCE.Columns;
//import com.baicizhan.client.business.dataset.provider.Contracts.ZTOPICRESOURCEWORDEXTRA;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.Cursors.KeyGetter;
//import com.baicizhan.client.business.dataset.provider.ProviderUtils;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.dataset.provider.RawExecBuilder;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.networkbench.com.google.gson.reflect.TypeToken;
////import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//
//public class TopicRecordHelper {
//    public static final Map<String, String> DEPRECATE_BASE_COLUMN_MAP = new ArrayMap();
//    public static final Map<String, String> DEPRECATE_EXTRA_COLUMN_MAP = new ArrayMap();
//    private static SparseBooleanArray SKIP_LEGACY_COMPAT = new SparseBooleanArray();
//
//    static {
//        DEPRECATE_BASE_COLUMN_MAP.put("topicId", "TOPIC");
//        DEPRECATE_BASE_COLUMN_MAP.put("updatetime", "UPDATEDATE");
//        DEPRECATE_BASE_COLUMN_MAP.put("word", "ZWORD");
//        DEPRECATE_BASE_COLUMN_MAP.put("wordMean", "ZWORDMEAN");
//        DEPRECATE_BASE_COLUMN_MAP.put("wordVariants", "ZWORDVARIANTS");
//        DEPRECATE_BASE_COLUMN_MAP.put("phonetic", Columns.ZPHONETIC);
//        DEPRECATE_BASE_COLUMN_MAP.put("sentence", "ZSENTENCE");
//        DEPRECATE_BASE_COLUMN_MAP.put("wordAudio", "ZWORDVIDEO");
//        DEPRECATE_BASE_COLUMN_MAP.put("sentenceAudio", "ZSENTENCEVIDEO");
//        DEPRECATE_BASE_COLUMN_MAP.put("imagePath", "ZIMAGEPATH");
//        DEPRECATE_BASE_COLUMN_MAP.put("thumbImagePath", Columns.ZTHUMBIMAGEPATH);
//        DEPRECATE_EXTRA_COLUMN_MAP.put("topicId", "TOPIC");
//        DEPRECATE_EXTRA_COLUMN_MAP.put("wordMeanEn", ZTOPICRESOURCEWORDEXTRA.Columns.ZWORDMEAN_EN);
//        DEPRECATE_EXTRA_COLUMN_MAP.put("shortPhrase", ZTOPICRESOURCEWORDEXTRA.Columns.ZWORD_EXAMPLE_KEYWORD);
//        DEPRECATE_EXTRA_COLUMN_MAP.put("wordEtyma", ZTOPICRESOURCEWORDEXTRA.Columns.ZWORD_ETYMA);
//        DEPRECATE_EXTRA_COLUMN_MAP.put("deformationImagePath", ZTOPICRESOURCEWORDEXTRA.Columns.ZWORD_DEFORMATION_IMG);
//        DEPRECATE_EXTRA_COLUMN_MAP.put("deformationDesc", ZTOPICRESOURCEWORDEXTRA.Columns.ZDEFORMATION_DESC);
//        DEPRECATE_EXTRA_COLUMN_MAP.put("keyWordVariants", ZTOPICRESOURCEWORDEXTRA.Columns.ZKEYWORD_VARIANTS);
//        DEPRECATE_EXTRA_COLUMN_MAP.put("sentenceTrans", "ZSENTENCE_TRANS");
//    }
//
//    public static void setSkipLegacyCompat(int i, boolean z) {
//        SKIP_LEGACY_COMPAT.put(i, z);
//    }
//
//    public static synchronized void createBookTopicResourceTable(Context context, int i, Map<Integer, RoadmapRecord> map) {
//        synchronized (TopicRecordHelper.class) {
//            boolean queryTableExists = ProviderUtils.queryTableExists(context, Databases.TOPIC, TOPICRESOURCE.getBookTableName(i));
//            String subKey = KVHelper.getSubKey(KVHelper.KEY_GLOBAL_BOOK_TRANSFER_STATE, Integer.toString(i));
//            String subKey2 = KVHelper.getSubKey(KVHelper.KEY_GLOBAL_BOOK_TRANSFER, Integer.toString(i));
//            if (map != null && map.size() > 0 && (!queryTableExists || !KVHelper.hasKey(context, subKey))) {
//                List deprecateBookTopicRecordIds = getDeprecateBookTopicRecordIds(context, map);
//                if (deprecateBookTopicRecordIds.size() > 0) {
//                    KVHelper.setJsonBean(context, subKey2, deprecateBookTopicRecordIds, new TypeToken<List<Integer>>() {
//                    }.getType(), false);
//                    KVHelper.setLong(context, subKey, 0);
//                    setSkipLegacyCompat(i, false);
//                } else {
//                    KVHelper.setLong(context, subKey, 1);
//                    setSkipLegacyCompat(i, true);
//                }
//                LogWrapper.m2795i("baicizhandb", "need transfer " + deprecateBookTopicRecordIds.size());
//            }
//            if (!queryTableExists) {
//                RawExecBuilder.m2792on(Databases.TOPIC).exec("CREATE TABLE IF NOT EXISTS " + TOPICRESOURCE.getBookTableName(i) + "(topic INTEGER PRIMARY KEY NOT NULL, word VARCHAR, sentence VARCHAR, word_audio VARCHAR, sentence_audio VARCHAR, image VARCHAR, phonetic VARCHAR, mean_cn VARCHAR, word_variants VARCHAR, mean_en VARCHAR, short_phrase VARCHAR, etyma VARCHAR, deformation_image VARCHAR, keyword_variants VARCHAR default \"\", sentence_trans VARCHAR default \"\", zpk_path VARCHAR default \"\", update_flag_md5 VARCHAR default \"\")", new String[0]).perform(context);
//            }
//        }
//    }
//
//    public static TopicRecord getBookTopicRecord(Context context, int i, int i2) {
//        TopicRecord topicRecord = (TopicRecord) Cursors.mapToUnique(QueryBuilder.query(TOPICRESOURCE.getBookContentUri(i)).where("topic = " + i2, new String[0]).perform(context), TopicRecord.class, TopicRecord.COLUMN_MAP);
//        if (topicRecord == null && !SKIP_LEGACY_COMPAT.get(i, false)) {
//            topicRecord = getDeprecateTopicRecord(context, i2);
//        }
//        if (topicRecord != null) {
//            topicRecord.bookId = i;
//        }
//        return topicRecord;
//    }
//
//    public static Map<Integer, TopicRecord> getBookTopicRecords(Context context, int i, Collection<Integer> collection) {
//        Map<Integer, TopicRecord> reduceToDict = Cursors.reduceToDict(QueryBuilder.query(TOPICRESOURCE.getBookContentUri(i)).whereIn(TOPICRESOURCE.Columns.TOPIC, collection, 0).perform(context), TopicRecord.class, TopicRecord.COLUMN_MAP, new KeyGetter<Integer, TopicRecord>() {
//            public final Integer get(TopicRecord topicRecord) {
//                return Integer.valueOf(topicRecord.topicId);
//            }
//        });
//        if (reduceToDict.size() < collection.size() && !SKIP_LEGACY_COMPAT.get(i, false)) {
//            ArrayList arrayList = new ArrayList(collection.size() - reduceToDict.size());
//            for (Integer intValue : collection) {
//                int intValue2 = intValue.intValue();
//                if (!reduceToDict.containsKey(Integer.valueOf(intValue2))) {
//                    arrayList.add(Integer.valueOf(intValue2));
//                }
//            }
//            reduceToDict.putAll(getDeprecateTopicRecords(context, arrayList));
//        }
//        for (TopicRecord topicRecord : reduceToDict.values()) {
//            fixUpdateFlagMD5(context, i, topicRecord);
//            topicRecord.bookId = i;
//        }
//        return reduceToDict;
//    }
//
//    public static void saveBookTopicRecord(Context context, int i, TopicRecord topicRecord) {
//        context.getContentResolver().insert(TOPICRESOURCE.getBookContentUri(i), Cursors.convertContentValues(topicRecord, TopicRecord.class, TopicRecord.COLUMN_MAP, null));
//    }
//
//    public static void saveBookTopicRecords(Context context, int i, Collection<TopicRecord> collection) {
//        if (collection != null && collection.size() != 0) {
//            Cursors.safeBulkInsert(context, TOPICRESOURCE.getBookContentUri(i), Cursors.bulkConvertContentValues(collection, TopicRecord.class, TopicRecord.COLUMN_MAP, (String[]) null), 100);
//        }
//    }
//
//    public static List<Integer> getNewBookTopicRecordIds(Context context, int i, Map<Integer, ?> map) {
//        return filterBookIdsByRoadmap(QueryBuilder.query(TOPICRESOURCE.getBookContentUri(i)).projection("TOPIC").perform(context), map);
//    }
//
//    public static List<Integer> getDeprecateBookTopicRecordIds(Context context, Map<Integer, ?> map) {
//        return filterBookIdsByRoadmap(QueryBuilder.query(ZTOPICRESOURCE.CONTENT_URI).projection("TOPIC").perform(context), map);
//    }
//
//    private static List<Integer> filterBookIdsByRoadmap(Cursor cursor, Map<Integer, ?> map) {
//        if (cursor == null) {
//            return Collections.emptyList();
//        }
//        ArrayList arrayList = new ArrayList(cursor.getCount());
//        try {
//            cursor.moveToFirst();
//            while (!cursor.isAfterLast()) {
//                int i = cursor.getInt(0);
//                if (map.containsKey(Integer.valueOf(i))) {
//                    arrayList.add(Integer.valueOf(i));
//                }
//                cursor.moveToNext();
//            }
//            return arrayList;
//        } catch (Exception e) {
//            LogWrapper.m2794e("baicizhandb", Log.getStackTraceString(e));
//            return arrayList;
//        } finally {
//            cursor.close();
//        }
//    }
//
//    /* JADX WARNING: Removed duplicated region for block: B:30:0x0097  */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public static Map<Integer, TopicRecord> getDeprecateTopicRecords(Context r8, Collection<Integer> r9) {
//        /*
//            r0 = 0
//            android.support.v4.b.a r3 = new android.support.v4.b.a
//            int r1 = r9.size()
//            r3.<init>(r1)
//            android.net.Uri r1 = com.baicizhan.client.business.dataset.provider.Contracts.ZTOPICRESOURCE.CONTENT_URI     // Catch:{ Exception -> 0x00a5, all -> 0x0090 }
//            com.baicizhan.client.business.dataset.provider.QueryBuilder r1 = com.baicizhan.client.business.dataset.provider.QueryBuilder.query(r1)     // Catch:{ Exception -> 0x00a5, all -> 0x0090 }
//            java.lang.String r2 = "TOPIC"
//            r4 = 0
//            com.baicizhan.client.business.dataset.provider.QueryBuilder r1 = r1.whereIn(r2, r9, r4)     // Catch:{ Exception -> 0x00a5, all -> 0x0090 }
//            android.database.Cursor r2 = r1.perform(r8)     // Catch:{ Exception -> 0x00a5, all -> 0x0090 }
//            r2.moveToFirst()     // Catch:{ Exception -> 0x003d, all -> 0x009e }
//        L_0x001e:
//            boolean r1 = r2.isAfterLast()     // Catch:{ Exception -> 0x003d, all -> 0x009e }
//            if (r1 != 0) goto L_0x0048
//            com.baicizhan.client.business.dataset.models.TopicRecord r1 = new com.baicizhan.client.business.dataset.models.TopicRecord     // Catch:{ Exception -> 0x003d, all -> 0x009e }
//            r1.<init>()     // Catch:{ Exception -> 0x003d, all -> 0x009e }
//            java.lang.Class<com.baicizhan.client.business.dataset.models.TopicRecord> r4 = com.baicizhan.client.business.dataset.models.TopicRecord.class
//            java.util.Map<java.lang.String, java.lang.String> r5 = DEPRECATE_BASE_COLUMN_MAP     // Catch:{ Exception -> 0x003d, all -> 0x009e }
//            com.baicizhan.client.business.dataset.provider.Cursors.inflateFromCursor(r1, r2, r4, r5)     // Catch:{ Exception -> 0x003d, all -> 0x009e }
//            int r4 = r1.topicId     // Catch:{ Exception -> 0x003d, all -> 0x009e }
//            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x003d, all -> 0x009e }
//            r3.put(r4, r1)     // Catch:{ Exception -> 0x003d, all -> 0x009e }
//            r2.moveToNext()     // Catch:{ Exception -> 0x003d, all -> 0x009e }
//            goto L_0x001e
//        L_0x003d:
//            r1 = move-exception
//            r1 = r2
//        L_0x003f:
//            if (r1 == 0) goto L_0x0047
//            r1.close()
//            r0.close()
//        L_0x0047:
//            return r3
//        L_0x0048:
//            android.net.Uri r1 = com.baicizhan.client.business.dataset.provider.Contracts.ZTOPICRESOURCEWORDEXTRA.CONTENT_URI     // Catch:{ Exception -> 0x003d, all -> 0x009e }
//            com.baicizhan.client.business.dataset.provider.QueryBuilder r1 = com.baicizhan.client.business.dataset.provider.QueryBuilder.query(r1)     // Catch:{ Exception -> 0x003d, all -> 0x009e }
//            java.lang.String r4 = "TOPIC"
//            r5 = 0
//            com.baicizhan.client.business.dataset.provider.QueryBuilder r1 = r1.whereIn(r4, r9, r5)     // Catch:{ Exception -> 0x003d, all -> 0x009e }
//            android.database.Cursor r1 = r1.perform(r8)     // Catch:{ Exception -> 0x003d, all -> 0x009e }
//            r1.moveToFirst()     // Catch:{ Exception -> 0x0083, all -> 0x00a3 }
//            java.lang.String r0 = "TOPIC"
//            int r4 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x0083, all -> 0x00a3 }
//        L_0x0062:
//            boolean r0 = r1.isAfterLast()     // Catch:{ Exception -> 0x0083, all -> 0x00a3 }
//            if (r0 != 0) goto L_0x0087
//            int r0 = r1.getInt(r4)     // Catch:{ Exception -> 0x0083, all -> 0x00a3 }
//            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0083, all -> 0x00a3 }
//            java.lang.Object r0 = r3.get(r0)     // Catch:{ Exception -> 0x0083, all -> 0x00a3 }
//            com.baicizhan.client.business.dataset.models.TopicRecord r0 = (com.baicizhan.client.business.dataset.models.TopicRecord) r0     // Catch:{ Exception -> 0x0083, all -> 0x00a3 }
//            if (r0 == 0) goto L_0x007f
//            java.lang.Class<com.baicizhan.client.business.dataset.models.TopicRecord> r5 = com.baicizhan.client.business.dataset.models.TopicRecord.class
//            java.util.Map<java.lang.String, java.lang.String> r6 = DEPRECATE_EXTRA_COLUMN_MAP     // Catch:{ Exception -> 0x0083, all -> 0x00a3 }
//            com.baicizhan.client.business.dataset.provider.Cursors.inflateFromCursor(r0, r1, r5, r6)     // Catch:{ Exception -> 0x0083, all -> 0x00a3 }
//        L_0x007f:
//            r1.moveToNext()     // Catch:{ Exception -> 0x0083, all -> 0x00a3 }
//            goto L_0x0062
//        L_0x0083:
//            r0 = move-exception
//            r0 = r1
//            r1 = r2
//            goto L_0x003f
//        L_0x0087:
//            if (r2 == 0) goto L_0x0047
//            r2.close()
//            r1.close()
//            goto L_0x0047
//        L_0x0090:
//            r1 = move-exception
//            r2 = r0
//            r7 = r0
//            r0 = r1
//            r1 = r7
//        L_0x0095:
//            if (r2 == 0) goto L_0x009d
//            r2.close()
//            r1.close()
//        L_0x009d:
//            throw r0
//        L_0x009e:
//            r1 = move-exception
//            r7 = r1
//            r1 = r0
//            r0 = r7
//            goto L_0x0095
//        L_0x00a3:
//            r0 = move-exception
//            goto L_0x0095
//        L_0x00a5:
//            r1 = move-exception
//            r1 = r0
//            goto L_0x003f
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.dataset.helpers.TopicRecordHelper.getDeprecateTopicRecords(android.content.Context, java.util.Collection):java.util.Map");
//    }
//
//    /* JADX WARNING: Removed duplicated region for block: B:31:0x0090  */
//    /* JADX WARNING: Removed duplicated region for block: B:33:0x0095  */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public static TopicRecord getDeprecateTopicRecord(Context r6, int r7) {
//        /*
//            r1 = 0
//            android.net.Uri r0 = com.baicizhan.client.business.dataset.provider.Contracts.ZTOPICRESOURCE.CONTENT_URI     // Catch:{ Exception -> 0x007d, all -> 0x008c }
//            com.baicizhan.client.business.dataset.provider.QueryBuilder r0 = com.baicizhan.client.business.dataset.provider.QueryBuilder.query(r0)     // Catch:{ Exception -> 0x007d, all -> 0x008c }
//            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d, all -> 0x008c }
//            java.lang.String r3 = "TOPIC = "
//            r2.<init>(r3)     // Catch:{ Exception -> 0x007d, all -> 0x008c }
//            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Exception -> 0x007d, all -> 0x008c }
//            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x007d, all -> 0x008c }
//            r3 = 0
//            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x007d, all -> 0x008c }
//            com.baicizhan.client.business.dataset.provider.QueryBuilder r0 = r0.where(r2, r3)     // Catch:{ Exception -> 0x007d, all -> 0x008c }
//            android.database.Cursor r3 = r0.perform(r6)     // Catch:{ Exception -> 0x007d, all -> 0x008c }
//            android.net.Uri r0 = com.baicizhan.client.business.dataset.provider.Contracts.ZTOPICRESOURCEWORDEXTRA.CONTENT_URI     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
//            com.baicizhan.client.business.dataset.provider.QueryBuilder r0 = com.baicizhan.client.business.dataset.provider.QueryBuilder.query(r0)     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
//            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
//            java.lang.String r4 = "TOPIC = "
//            r2.<init>(r4)     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
//            java.lang.StringBuilder r2 = r2.append(r7)     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
//            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
//            r4 = 0
//            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
//            com.baicizhan.client.business.dataset.provider.QueryBuilder r0 = r0.where(r2, r4)     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
//            android.database.Cursor r2 = r0.perform(r6)     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
//            boolean r0 = com.baicizhan.client.business.dataset.provider.Cursors.isCursorEmpty(r3)     // Catch:{ Exception -> 0x00a2, all -> 0x009b }
//            if (r0 != 0) goto L_0x004d
//            boolean r0 = com.baicizhan.client.business.dataset.provider.Cursors.isCursorEmpty(r2)     // Catch:{ Exception -> 0x00a2, all -> 0x009b }
//            if (r0 == 0) goto L_0x0059
//        L_0x004d:
//            if (r3 == 0) goto L_0x0052
//            r3.close()
//        L_0x0052:
//            if (r2 == 0) goto L_0x0057
//            r2.close()
//        L_0x0057:
//            r0 = r1
//        L_0x0058:
//            return r0
//        L_0x0059:
//            com.baicizhan.client.business.dataset.models.TopicRecord r0 = new com.baicizhan.client.business.dataset.models.TopicRecord     // Catch:{ Exception -> 0x00a2, all -> 0x009b }
//            r0.<init>()     // Catch:{ Exception -> 0x00a2, all -> 0x009b }
//            r3.moveToFirst()     // Catch:{ Exception -> 0x00a2, all -> 0x009b }
//            r2.moveToFirst()     // Catch:{ Exception -> 0x00a2, all -> 0x009b }
//            java.lang.Class<com.baicizhan.client.business.dataset.models.TopicRecord> r4 = com.baicizhan.client.business.dataset.models.TopicRecord.class
//            java.util.Map<java.lang.String, java.lang.String> r5 = DEPRECATE_BASE_COLUMN_MAP     // Catch:{ Exception -> 0x00a2, all -> 0x009b }
//            com.baicizhan.client.business.dataset.provider.Cursors.inflateFromCursor(r0, r3, r4, r5)     // Catch:{ Exception -> 0x00a2, all -> 0x009b }
//            java.lang.Class<com.baicizhan.client.business.dataset.models.TopicRecord> r4 = com.baicizhan.client.business.dataset.models.TopicRecord.class
//            java.util.Map<java.lang.String, java.lang.String> r5 = DEPRECATE_EXTRA_COLUMN_MAP     // Catch:{ Exception -> 0x00a2, all -> 0x009b }
//            com.baicizhan.client.business.dataset.provider.Cursors.inflateFromCursor(r0, r2, r4, r5)     // Catch:{ Exception -> 0x00a2, all -> 0x009b }
//            if (r3 == 0) goto L_0x0077
//            r3.close()
//        L_0x0077:
//            if (r2 == 0) goto L_0x0058
//            r2.close()
//            goto L_0x0058
//        L_0x007d:
//            r0 = move-exception
//            r0 = r1
//            r2 = r1
//        L_0x0080:
//            if (r2 == 0) goto L_0x0085
//            r2.close()
//        L_0x0085:
//            if (r0 == 0) goto L_0x008a
//            r0.close()
//        L_0x008a:
//            r0 = r1
//            goto L_0x0058
//        L_0x008c:
//            r0 = move-exception
//            r3 = r1
//        L_0x008e:
//            if (r3 == 0) goto L_0x0093
//            r3.close()
//        L_0x0093:
//            if (r1 == 0) goto L_0x0098
//            r1.close()
//        L_0x0098:
//            throw r0
//        L_0x0099:
//            r0 = move-exception
//            goto L_0x008e
//        L_0x009b:
//            r0 = move-exception
//            r1 = r2
//            goto L_0x008e
//        L_0x009e:
//            r0 = move-exception
//            r0 = r1
//            r2 = r3
//            goto L_0x0080
//        L_0x00a2:
//            r0 = move-exception
//            r0 = r2
//            r2 = r3
//            goto L_0x0080
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.business.dataset.helpers.TopicRecordHelper.getDeprecateTopicRecord(android.content.Context, int):com.baicizhan.client.business.dataset.models.TopicRecord");
//    }
//
//    public static void fixUpdateFlagMD5(Context context, int i, TopicRecord topicRecord) {
//        if (topicRecord != null && TextUtils.isEmpty(topicRecord.updateFlagMD5)) {
//            String topicUpdateFlagMD5 = StudyManager.getInstance().getTopicUpdateFlagMD5(topicRecord.topicId);
//            if (topicUpdateFlagMD5 != null) {
//                topicRecord.updateFlagMD5 = topicUpdateFlagMD5;
//                try {
//                    ContentValues contentValues = new ContentValues();
//                    contentValues.put(TOPICRESOURCE.Columns.UPDATE_FLAG_MD5, topicUpdateFlagMD5);
//                    context.getContentResolver().update(TOPICRESOURCE.getBookContentUri(i), contentValues, "topic=" + topicRecord.topicId, null);
//                } catch (Exception e) {
//                }
//            }
//        }
//    }
//}
