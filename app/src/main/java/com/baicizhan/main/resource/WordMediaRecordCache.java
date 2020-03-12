//package com.baicizhan.main.resource;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.util.ArrayMap;//import android.support.p004v4.p006b.ArrayMap;
//import android.support.p004v4.p006b.LruCache;
//import com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_MEDIA_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_MEDIA_TB.Columns;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//
//public class WordMediaRecordCache extends LruCache<String, WordMediaRecord> {
//    private int bookId;
//    private Context context;
//
//    public WordMediaRecordCache(int i) {
//        super(i);
//    }
//
//    public int getBookId() {
//        return this.bookId;
//    }
//
//    public void reinit(Context context2, int i) {
//        this.context = context2.getApplicationContext();
//        this.bookId = i;
//        evictAll();
//    }
//
//    /* access modifiers changed from: protected */
//    public WordMediaRecord create(String str) {
//        return (WordMediaRecord) Cursors.mapToUnique(QueryBuilder.query(WORD_MEDIA_TB.getContentUri(this.bookId)).projection("topic_id", Columns.TV_PATH, Columns.TV_SNAPSHOT_PATH).where("topic_id = " + str, new String[0]).perform(this.context), WordMediaRecord.class, WordMediaRecord.COLUMN_MAP);
//    }
//
//    public boolean putAndSave(WordMediaRecord wordMediaRecord) {
//        put(wordMediaRecord.getWordid(), wordMediaRecord);
//        try {
//            WordMediaRecordHelper.insertWordMediaRecords(this.context, this.bookId, Collections.singletonList(wordMediaRecord));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean bulkInsert(List<WordMediaRecord> list) {
//        for (WordMediaRecord wordMediaRecord : list) {
//            put(wordMediaRecord.getWordid(), wordMediaRecord);
//        }
//        try {
//            WordMediaRecordHelper.insertWordMediaRecords(this.context, this.bookId, list);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public Map<String, WordMediaRecord> bulkQuery(Collection<String> collection) {
//        Map<String, WordMediaRecord> emptyMap = Collections.emptyMap();
//        Cursor perform = QueryBuilder.query(WORD_MEDIA_TB.getContentUri(this.bookId)).projection("topic_id", Columns.TV_PATH, Columns.TV_SNAPSHOT_PATH).whereIn("topic_id", collection, 500).perform(this.context);
//        if (perform != null) {
//            try {
//                emptyMap = new ArrayMap<>(perform.getCount());
//                perform.moveToFirst();
//                while (!perform.isAfterLast()) {
//                    WordMediaRecord wordMediaRecord = new WordMediaRecord();
//                    wordMediaRecord.setWordid(perform.getString(0));
//                    wordMediaRecord.setTvpath(perform.getString(1));
//                    wordMediaRecord.setTvSnapshotPath(perform.getString(2));
//                    emptyMap.put(wordMediaRecord.getWordid(), wordMediaRecord);
//                    put(wordMediaRecord.getWordid(), wordMediaRecord);
//                    perform.moveToNext();
//                }
//            } finally {
//                perform.close();
//            }
//        }
//        return emptyMap;
//    }
//}
