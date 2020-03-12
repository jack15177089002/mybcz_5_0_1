//package com.baicizhan.client.wordlock.data.p033db;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.content.Intent;
//import android.database.Cursor;
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_LOCK_REVIEW_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_LOCK_TODAY_REVIEW_TB;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.search.Word;
//import com.baicizhan.client.business.settings.Settings;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.main.receiver.LearnOperationReceiver;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
///* renamed from: com.baicizhan.client.wordlock.data.db.WordLockHelper */
//public class WordLockHelper {
//    public static final int TOP_N = 30;
//
//    public static List<Word> getUnrevdTopNWords(Context context, Collection<String> collection) {
//        return getUnrevdTopNWords(context, collection, true);
//    }
//
//    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
//        return r3;
//     */
//    /* Code decompiled incorrectly, please refer to instructions dump. */
//    public static List<Word> getUnrevdTopNWords(Context r11, Collection<String> r12, boolean r13) {
//        /*
//            r2 = 0
//            r10 = 1
//            r1 = 0
//        L_0x0003:
//            java.util.Collection r0 = refreshRevdIds(r11, r12)
//            int r4 = getBookId()
//            if (r4 >= 0) goto L_0x000f
//            r0 = r2
//        L_0x000e:
//            return r0
//        L_0x000f:
//            java.util.Collection r5 = getUnrevdTopNWordIds(r11, r4, r0)
//            if (r5 == 0) goto L_0x001b
//            boolean r0 = r5.isEmpty()
//            if (r0 == 0) goto L_0x001d
//        L_0x001b:
//            r0 = r2
//            goto L_0x000e
//        L_0x001d:
//            java.util.ArrayList r3 = new java.util.ArrayList
//            r3.<init>()
//            java.util.Iterator r6 = r5.iterator()
//        L_0x0026:
//            boolean r0 = r6.hasNext()
//            if (r0 == 0) goto L_0x0106
//            java.lang.Object r0 = r6.next()
//            java.lang.String r0 = (java.lang.String) r0
//            java.lang.StringBuilder r7 = new java.lang.StringBuilder
//            java.lang.String r8 = "select distinct "
//            r7.<init>(r8)
//            java.lang.String r8 = "word, phonetic, mean_cn, word_audio, sentence, sentence_trans, image, deformation_image, mean_en, etyma, zpk_path, word_variants from "
//            java.lang.StringBuilder r8 = r7.append(r8)
//            java.lang.String r9 = com.baicizhan.client.business.dataset.provider.Contracts.TOPICRESOURCE.getBookTableName(r4)
//            java.lang.StringBuilder r8 = r8.append(r9)
//            java.lang.String r9 = " where topic=?"
//            r8.append(r9)
//            java.lang.String r8 = "baicizhantopic.db"
//            java.lang.String r7 = r7.toString()
//            java.lang.String[] r9 = new java.lang.String[r10]
//            r9[r1] = r0
//            com.baicizhan.client.business.dataset.provider.QueryBuilder r7 = com.baicizhan.client.business.dataset.provider.QueryBuilder.rawQuery(r8, r7, r9)
//            android.database.Cursor r7 = r7.perform(r11)
//            if (r7 != 0) goto L_0x0072
//            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
//            int r0 = r0.intValue()
//            com.baicizhan.client.business.search.Word r0 = getWordFromTotalTable(r11, r4, r0)
//            if (r0 == 0) goto L_0x0026
//            r3.add(r0)
//            goto L_0x0026
//        L_0x0072:
//            boolean r8 = r7.moveToFirst()     // Catch:{ all -> 0x0101 }
//            if (r8 == 0) goto L_0x00ef
//            com.baicizhan.client.business.search.Word r8 = new com.baicizhan.client.business.search.Word     // Catch:{ all -> 0x0101 }
//            r8.<init>()     // Catch:{ all -> 0x0101 }
//            r8.setBookId(r4)     // Catch:{ all -> 0x0101 }
//            r8.setId(r0)     // Catch:{ all -> 0x0101 }
//            r0 = 0
//            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x0101 }
//            r8.setWord(r0)     // Catch:{ all -> 0x0101 }
//            r0 = 1
//            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x0101 }
//            r8.setAccent(r0)     // Catch:{ all -> 0x0101 }
//            r0 = 2
//            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x0101 }
//            r8.setCnmean(r0)     // Catch:{ all -> 0x0101 }
//            r0 = 3
//            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x0101 }
//            r8.setAudio(r0)     // Catch:{ all -> 0x0101 }
//            r0 = 4
//            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x0101 }
//            r8.setExample(r0)     // Catch:{ all -> 0x0101 }
//            r0 = 5
//            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x0101 }
//            r8.setCnexample(r0)     // Catch:{ all -> 0x0101 }
//            r0 = 6
//            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x0101 }
//            r8.setImage(r0)     // Catch:{ all -> 0x0101 }
//            r0 = 7
//            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x0101 }
//            r8.setVivid(r0)     // Catch:{ all -> 0x0101 }
//            r0 = 8
//            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x0101 }
//            r8.setEnmean(r0)     // Catch:{ all -> 0x0101 }
//            r0 = 9
//            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x0101 }
//            r8.setRoot(r0)     // Catch:{ all -> 0x0101 }
//            r0 = 10
//            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x0101 }
//            r8.setZpkPath(r0)     // Catch:{ all -> 0x0101 }
//            r0 = 11
//            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x0101 }
//            r8.setVariants(r0)     // Catch:{ all -> 0x0101 }
//            r3.add(r8)     // Catch:{ all -> 0x0101 }
//        L_0x00ea:
//            r7.close()
//            goto L_0x0026
//        L_0x00ef:
//            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0101 }
//            int r0 = r0.intValue()     // Catch:{ all -> 0x0101 }
//            com.baicizhan.client.business.search.Word r0 = getWordFromTotalTable(r11, r4, r0)     // Catch:{ all -> 0x0101 }
//            if (r0 == 0) goto L_0x00ea
//            r3.add(r0)     // Catch:{ all -> 0x0101 }
//            goto L_0x00ea
//        L_0x0101:
//            r0 = move-exception
//            r7.close()
//            throw r0
//        L_0x0106:
//            boolean r0 = r3.isEmpty()
//            if (r0 == 0) goto L_0x011a
//            boolean r0 = r5.isEmpty()
//            if (r0 != 0) goto L_0x011a
//            if (r13 == 0) goto L_0x011a
//            clearRevd(r11)
//            r13 = r1
//            goto L_0x0003
//        L_0x011a:
//            r0 = r3
//            goto L_0x000e
//        */
//        throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.wordlock.data.p033db.WordLockHelper.getUnrevdTopNWords(android.content.Context, java.util.Collection, boolean):java.util.List");
//    }
//
//    private static Word getWordFromTotalTable(Context context, int i, int i2) {
//        Word word = null;
//        if (Settings.isTotalResDBEnabled()) {
//            StringBuilder sb = new StringBuilder("select distinct ");
//            sb.append("word, phonetic, mean_cn, word_audio, sentence, sentence_trans, image, deformation_image, mean_en, etyma, word_variants, book_id from tb_total_topic_resources where topic_id=? and (book_id=? or ").append("book_id=?)");
//            Cursor perform = QueryBuilder.rawQuery(Databases.TOTAL_RESOURCES, sb.toString(), String.valueOf(i2), String.valueOf(i), "0").perform(context);
//            if (perform != null) {
//                while (true) {
//                    try {
//                        if (!perform.moveToNext()) {
//                            perform.close();
//                            break;
//                        }
//                        word = new Word();
//                        word.setBookId(i);
//                        word.setId(String.valueOf(i2));
//                        word.setWord(perform.getString(0));
//                        word.setAccent(perform.getString(1));
//                        word.setCnmean(perform.getString(2));
//                        word.setAudio(perform.getString(3));
//                        word.setExample(perform.getString(4));
//                        word.setCnexample(perform.getString(5));
//                        word.setImage(perform.getString(6));
//                        word.setVivid(perform.getString(7));
//                        word.setEnmean(perform.getString(8));
//                        word.setRoot(perform.getString(9));
//                        word.setVariants(perform.getString(10));
//                        if (perform.getInt(10) != 0) {
//                            break;
//                        }
//                    } finally {
//                        perform.close();
//                    }
//                }
//            }
//        }
//        return word;
//    }
//
//    private static Collection<String> getUnrevdTopNWordIds(Context context, int i, Collection<String> collection) {
//        Set set;
//        StringBuilder sb = new StringBuilder("select distinct ");
//        sb.append("topic_id from ").append(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookTableName(i)).append(" where topic_obn>=? order by is_today_new DESC, topic_obn ASC, err_num DESC, last_do_time DESC");
//        Cursor perform = QueryBuilder.rawQuery(Databases.TOPIC_PROBLEM, sb.toString(), "1").perform(context);
//        if (perform == null) {
//            return null;
//        }
//        Set hashSet = new HashSet(collection.size());
//        if (!(collection instanceof Set) || collection == null) {
//            hashSet.addAll(collection);
//            set = hashSet;
//        } else {
//            set = (Set) collection;
//        }
//        try {
//            ArrayList arrayList = new ArrayList();
//            ArrayList arrayList2 = new ArrayList();
//            while (perform.moveToNext()) {
//                String string = perform.getString(0);
//                if (arrayList2.size() <= 30) {
//                    arrayList2.add(string);
//                }
//                if (!set.contains(string)) {
//                    arrayList.add(string);
//                    if (arrayList.size() >= 30) {
//                        break;
//                    }
//                }
//            }
//            if (!arrayList.isEmpty() || arrayList2.isEmpty()) {
//                arrayList2 = arrayList;
//            } else {
//                clearRevd(context);
//            }
//            return arrayList2;
//        } finally {
//            perform.close();
//        }
//    }
//
//    private static synchronized Collection<String> refreshRevdIds(Context context, Collection<String> collection) {
//        Collection<String> collection2;
//        synchronized (WordLockHelper.class) {
//            if (collection == null) {
//                collection2 = new ArrayList<>(0);
//            } else {
//                collection2 = collection;
//            }
//            ArrayList arrayList = new ArrayList();
//            Cursor perform = QueryBuilder.query(WORD_LOCK_REVIEW_TB.CONTENT_URI).whereNotIn("topic_id", collection2).perform(context);
//            if (perform == null) {
//                insertRevdIds(context, collection2);
//            } else {
//                while (perform.moveToNext()) {
//                    try {
//                        arrayList.add(perform.getString(perform.getColumnIndex("topic_id")));
//                    } catch (Throwable th) {
//                        perform.close();
//                        throw th;
//                    }
//                }
//                perform.close();
//                insertRevdIds(context, collection2);
//                arrayList.addAll(collection2);
//                collection2 = arrayList;
//            }
//        }
//        return collection2;
//    }
//
//    private static synchronized void insertRevdIds(Context context, Collection<String> collection) {
//        synchronized (WordLockHelper.class) {
//            if (collection != null) {
//                if (!collection.isEmpty()) {
//                    ContentValues[] contentValuesArr = new ContentValues[collection.size()];
//                    int i = 0;
//                    for (String str : collection) {
//                        ContentValues contentValues = new ContentValues();
//                        contentValues.put("topic_id", str);
//                        contentValuesArr[i] = contentValues;
//                        i++;
//                    }
//                    context.getContentResolver().bulkInsert(WORD_LOCK_REVIEW_TB.CONTENT_URI, contentValuesArr);
//                }
//            }
//        }
//    }
//
//    private static synchronized void clearRevd(Context context) {
//        synchronized (WordLockHelper.class) {
//            int delete = context.getContentResolver().delete(WORD_LOCK_REVIEW_TB.CONTENT_URI, null, null);
//            if (delete <= 0) {
//                C0789L.log.error("clear word lock revd table failed, cleared item count [{}]", (Object) Integer.valueOf(delete));
//            }
//        }
//    }
//
//    public static int getTodayRevdCount(Context context, Collection<String> collection) {
//        if (collection != null && !collection.isEmpty()) {
//            ContentValues[] contentValuesArr = new ContentValues[collection.size()];
//            int i = 0;
//            for (String str : collection) {
//                ContentValues contentValues = new ContentValues();
//                contentValues.put("topic_id", str);
//                int i2 = i + 1;
//                contentValuesArr[i] = contentValues;
//                i = i2;
//            }
//            if (context.getContentResolver().bulkInsert(WORD_LOCK_TODAY_REVIEW_TB.CONTENT_URI, contentValuesArr) <= 0) {
//                C0789L.log.error("bulk insert word lock today review tb failed, values [{}]", (Object) contentValuesArr.toString());
//            }
//        }
//        Cursor perform = QueryBuilder.query(WORD_LOCK_TODAY_REVIEW_TB.CONTENT_URI).perform(context);
//        if (perform == null) {
//            return 0;
//        }
//        int count = perform.getCount() + 0;
//        perform.close();
//        return count;
//    }
//
//    public static synchronized void clearTodayRvd(Context context) {
//        synchronized (WordLockHelper.class) {
//            int delete = context.getContentResolver().delete(WORD_LOCK_TODAY_REVIEW_TB.CONTENT_URI, null, null);
//            if (delete <= 0) {
//                C0789L.log.error("clear word lock today revd failed, ret [{}]", (Object) Integer.valueOf(delete));
//            }
//        }
//    }
//
//    public static void killWord(Context context, String str) {
//        int bookId = getBookId();
//        if (bookId >= 0) {
//            Intent intent = new Intent(LearnOperationReceiver.ACTION_KILL);
//            intent.putExtra("book_id", bookId);
//            intent.putExtra("topic_id", Integer.valueOf(str));
//            context.sendBroadcast(intent);
//        }
//    }
//
//    public static int getKilledWordCount(Context context) {
//        int bookId = getBookId();
//        if (bookId < 0) {
//            return 0;
//        }
//        Cursor perform = QueryBuilder.query(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(bookId)).where("topic_obn=?", "-1").perform(context);
//        if (perform == null) {
//            return 0;
//        }
//        int count = perform.getCount();
//        perform.close();
//        return count;
//    }
//
//    private static int getBookId() {
//        int book = com.baicizhan.client.wordlock.setting.Settings.getBook();
//        if (book > 0) {
//            return book;
//        }
//        C0789L.log.error("get book id failed for book record helper exception");
//        return -1;
//    }
//}
