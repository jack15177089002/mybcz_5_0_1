//package com.baicizhan.client.p029fm.data.p030db;
//
//import android.content.Context;
//import android.database.Cursor;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_WORD_STATION_DATA_ALL;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_WORD_STATION_DATA_ALL.Columns;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
///* renamed from: com.baicizhan.client.fm.data.db.FmIdPathMapRecordHelper */
//public class FmIdPathMapRecordHelper {
//    public static List<FmIdPathMapRecord> getFmIdPathMapRecords(Context context, Set<String> set) {
//        ArrayList arrayList = null;
//        if (set != null && !set.isEmpty()) {
//            Cursor perform = QueryBuilder.query(TS_WORD_STATION_DATA_ALL.CONTENT_URI).perform(context);
//            if (perform != null) {
//                try {
//                    arrayList = new ArrayList(set.size());
//                    while (perform.moveToNext()) {
//                        String string = perform.getString(perform.getColumnIndex("ws_id"));
//                        if (set.contains(string)) {
//                            FmIdPathMapRecord fmIdPathMapRecord = new FmIdPathMapRecord();
//                            fmIdPathMapRecord.fmid = string;
//                            fmIdPathMapRecord.path = perform.getString(perform.getColumnIndex("ws_audio"));
//                            fmIdPathMapRecord.hdpath = perform.getString(perform.getColumnIndex(Columns.WS_AUDIO_HIGH));
//                            arrayList.add(fmIdPathMapRecord);
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
