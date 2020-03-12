//package com.baicizhan.client.business.search.p028db;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.text.TextUtils;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_LOCK_SEARCH_HISTORY_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_LOCK_SEARCH_HISTORY_TB.Columns;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.search.Settings;
//import com.baicizhan.client.business.search.Word;
//import com.baicizhan.client.framework.log.C0789L;
//import java.util.ArrayList;
//import java.util.List;
//
///* renamed from: com.baicizhan.client.business.search.db.SearchHelper */
//public class SearchHelper {
//    private SearchHelper() {
//    }
//
//    public static synchronized void addSearchHistory(Context context, Word word) {
//        List<Word> list;
//        int i;
//        int i2 = 1;
//        synchronized (SearchHelper.class) {
//            if (word != null) {
//                List mapToList = Cursors.mapToList(QueryBuilder.query(WORD_LOCK_SEARCH_HISTORY_TB.CONTENT_URI).orderBy("time DESC").limit(9).perform(context), Word.class, Word.COLUMN_MAP);
//                if (mapToList != null) {
//                    context.getContentResolver().delete(WORD_LOCK_SEARCH_HISTORY_TB.CONTENT_URI, null, null);
//                }
//                if (mapToList == null || mapToList.isEmpty()) {
//                    ArrayList arrayList = new ArrayList();
//                    arrayList.add(word);
//                    list = arrayList;
//                } else {
//                    mapToList.add(0, word);
//                    list = mapToList;
//                }
//                while (true) {
//                    if (i2 >= list.size()) {
//                        i = -1;
//                        break;
//                    } else if (TextUtils.equals(word.getWord(), ((Word) list.get(i2)).getWord())) {
//                        i = i2;
//                        break;
//                    } else {
//                        i2++;
//                    }
//                }
//                if (i > 0) {
//                    list.remove(i);
//                }
//                ContentValues[] contentValuesArr = new ContentValues[list.size()];
//                long currentTimeMillis = System.currentTimeMillis();
//                int i3 = 0;
//                for (Word word2 : list) {
//                    ContentValues contentValues = new ContentValues();
//                    contentValues.put("time", Long.valueOf(currentTimeMillis - ((long) i3)));
//                    contentValues.put("book_id", Integer.valueOf(word2.getBookId()));
//                    contentValues.put("topic_id", word2.getId());
//                    contentValues.put("word", word2.getWord());
//                    contentValues.put("accent", word2.getAccent());
//                    contentValues.put(Columns.CNMEAN, word2.getCnmean());
//                    contentValues.put(Columns.AUDIO, word2.getAudio());
//                    contentValues.put(Columns.EXAMPLE, word2.getExample());
//                    contentValues.put(Columns.CNEXAMPLE, word2.getCnexample());
//                    contentValues.put("image", word2.getImage());
//                    contentValues.put(Columns.VIVID, word2.getVivid());
//                    contentValues.put(Columns.ENMEAN, word2.getEnmean());
//                    contentValues.put(Columns.ROOT, word2.getRoot());
//                    contentValues.put("zpk_path", word2.getZpkPath());
//                    contentValues.put(Columns.FLAG, Integer.valueOf(word2.getFlag()));
//                    int i4 = i3 + 1;
//                    contentValuesArr[i3] = contentValues;
//                    i3 = i4;
//                }
//                if (context.getContentResolver().bulkInsert(WORD_LOCK_SEARCH_HISTORY_TB.CONTENT_URI, contentValuesArr) <= 0) {
//                    C0789L.log.error("bulk insert word lock search history tb failed, values [{}]", (Object) contentValuesArr.toString());
//                } else {
//                    Settings.setHasHistory(true);
//                }
//            }
//        }
//    }
//
//    public static List<Word> getSearchHistories(Context context) {
//        return Cursors.mapToList(QueryBuilder.query(WORD_LOCK_SEARCH_HISTORY_TB.CONTENT_URI).orderBy("time DESC").limit(10).perform(context), Word.class, Word.COLUMN_MAP);
//    }
//}
