//package com.baicizhan.main.resource;
//
//import android.content.ContentResolver;
//import android.content.Context;
//import android.net.Uri;
//import com.baicizhan.client.business.dataset.helpers.KVHelper;
//import com.baicizhan.client.business.dataset.helpers.TopicRecordHelper;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.dataset.provider.BaicizhanContentProvider;
//import com.baicizhan.client.business.dataset.provider.Contracts.TOPICRESOURCE;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.Profiler;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.lang.reflect.Type;
//import java.util.List;
//
//public class TopicResourceTableDivider {
//    private static final String TAG = TopicResourceTableDivider.class.getSimpleName();
//    private int bookId;
//    private Context context;
//
//    public TopicResourceTableDivider(Context context2, int i) {
//        this.context = context2;
//        this.bookId = i;
//    }
//
//    public void transfer() {
//        String subKey = KVHelper.getSubKey(KVHelper.KEY_GLOBAL_BOOK_TRANSFER_STATE, Integer.toString(this.bookId));
//        long j = KVHelper.getLong(this.context, subKey);
//        LogWrapper.m2793d(TAG, "transfer state " + j);
//        if (j == 1) {
//            TopicRecordHelper.setSkipLegacyCompat(this.bookId, true);
//            return;
//        }
//        TopicRecordHelper.setSkipLegacyCompat(this.bookId, false);
//        Type type = new TypeToken<List<Integer>>() {
//        }.getType();
//        String subKey2 = KVHelper.getSubKey(KVHelper.KEY_GLOBAL_BOOK_TRANSFER, Integer.toString(this.bookId));
//        List list = (List) KVHelper.getJsonBean(this.context, subKey2, type, false);
//        if (list != null && list.size() != 0) {
//            LogWrapper.m2793d(TAG, "transfer size " + list.size());
//            Uri withAppendedPath = Uri.withAppendedPath(TOPICRESOURCE.getBookContentUri(this.bookId), BaicizhanContentProvider.EXTEND_CONFLICT_IGNORE);
//            ContentResolver contentResolver = this.context.getContentResolver();
//            Profiler profiler = new Profiler();
//            profiler.openFunc(TAG, "transfer");
//            for (int i = 0; i < list.size(); i += 500) {
//                try {
//                    profiler.openFunc(TAG, "transferBatch");
//                    int min = Math.min(i + 500, list.size());
//                    contentResolver.bulkInsert(withAppendedPath, Cursors.bulkConvertContentValues(TopicRecordHelper.getDeprecateTopicRecords(this.context, list.subList(i, min)).values(), TopicRecord.class, TopicRecord.COLUMN_MAP, (String[]) null));
//                    profiler.closeAndPrintFunc(TAG, "transferBatch");
//                    KVHelper.setJsonBean(this.context, subKey2, list.subList(min, list.size()), type, false);
//                    Thread.sleep(500);
//                } catch (Exception e) {
//                    LogWrapper.m2794e(TAG, e.toString());
//                }
//            }
//            KVHelper.deleteKey(this.context, subKey2);
//            KVHelper.setLong(this.context, subKey, 1);
//            profiler.closeAndPrintFunc(TAG, "transfer");
//        }
//    }
//}
