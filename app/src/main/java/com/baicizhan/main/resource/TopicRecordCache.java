//package com.baicizhan.main.resource;
//
//import android.content.Context;
//import android.support.p004v4.p006b.LruCache;
//import com.baicizhan.client.business.dataset.helpers.TopicRecordHelper;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import java.util.Collection;
//
//public class TopicRecordCache extends LruCache<Integer, TopicRecord> {
//    private int bookId;
//    private Context context;
//
//    public TopicRecordCache(int i) {
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
//    public TopicRecord create(Integer num) {
//        TopicRecord bookTopicRecord = TopicRecordHelper.getBookTopicRecord(this.context, this.bookId, num.intValue());
//        if (bookTopicRecord != null) {
//            TopicRecordHelper.fixUpdateFlagMD5(this.context, this.bookId, bookTopicRecord);
//        }
//        return bookTopicRecord;
//    }
//
//    public boolean putAndSave(TopicRecord topicRecord) {
//        put(Integer.valueOf(topicRecord.topicId), topicRecord);
//        try {
//            TopicRecordHelper.saveBookTopicRecord(this.context, this.bookId, topicRecord);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean bulkInsert(Collection<TopicRecord> collection) {
//        for (TopicRecord topicRecord : collection) {
//            put(Integer.valueOf(topicRecord.topicId), topicRecord);
//        }
//        try {
//            TopicRecordHelper.saveBookTopicRecords(this.context, this.bookId, collection);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}
