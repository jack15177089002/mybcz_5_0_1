//package com.baicizhan.main.plusreview.data.p034db;
//
//import android.content.Context;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_OPEN_EARS_MATCH_INFO;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//
///* renamed from: com.baicizhan.main.plusreview.data.db.RecognitionHelper */
//public class RecognitionHelper {
//    public static RecognitionRecord getRecRecord(Context context, int i, int i2) {
//        StringBuilder sb = new StringBuilder("book_id");
//        sb.append("=? and max_id>=? and min_id<=?");
//        return (RecognitionRecord) Cursors.mapToUnique(QueryBuilder.query(TS_OPEN_EARS_MATCH_INFO.CONTENT_URI).where(sb.toString(), String.valueOf(i), String.valueOf(i2), String.valueOf(i2)).perform(context), RecognitionRecord.class, RecognitionRecord.COLUMN_MAP);
//    }
//}
