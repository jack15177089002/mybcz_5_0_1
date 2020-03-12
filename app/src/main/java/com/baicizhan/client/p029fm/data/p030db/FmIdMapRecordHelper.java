//package com.baicizhan.client.p029fm.data.p030db;
//
//import android.content.Context;
//import android.database.Cursor;
//import com.baicizhan.client.business.dataset.provider.Contracts.BOOK_TS_OFFLINE_ROAD_MAP_IDS;
//import com.baicizhan.client.business.dataset.provider.Contracts.BOOK_TS_OFFLINE_ROAD_MAP_IDS.Columns;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
///* renamed from: com.baicizhan.client.fm.data.db.FmIdMapRecordHelper */
//public class FmIdMapRecordHelper {
//    public static List<FmIdMapRecord> getFmIdMapRecords(Context context, int i, Set<String> set) {
//        ArrayList arrayList = null;
//        if (set != null && !set.isEmpty()) {
//            Cursor perform = QueryBuilder.query(BOOK_TS_OFFLINE_ROAD_MAP_IDS.getBookContentUri(i)).perform(context);
//            if (perform != null) {
//                try {
//                    arrayList = new ArrayList(set.size());
//                    while (perform.moveToNext()) {
//                        String string = perform.getString(perform.getColumnIndex("topic_id"));
//                        if (set.contains(string)) {
//                            FmIdMapRecord fmIdMapRecord = new FmIdMapRecord();
//                            fmIdMapRecord.wordid = string;
//                            fmIdMapRecord.fmid = perform.getString(perform.getColumnIndex(Columns.TAPESCRIPT_ID));
//                            arrayList.add(fmIdMapRecord);
//                        }
//                    }
//                } finally {
//                    perform.close();
//                }
//            }
//        }
//        return arrayList;
//    }
//}
