//package com.baicizhan.client.p029fm.data.p030db;
//
//import android.content.Context;
//import android.database.Cursor;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_MEDIA_TB;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_MEDIA_TB.Columns;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.managers.StudyManager;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
///* renamed from: com.baicizhan.client.fm.data.db.WordIdRecordHelper */
//public class WordIdRecordHelper {
//    public static List<WordMediaRecord> getFmRecords(Context context, int i) {
//        Map currentRoadmap = StudyManager.getInstance().getCurrentRoadmap();
//        if (currentRoadmap == null) {
//            return null;
//        }
//        Set<Integer> keySet = currentRoadmap.keySet();
//        if (keySet == null) {
//            return null;
//        }
//        HashSet hashSet = new HashSet(keySet.size());
//        for (Integer intValue : keySet) {
//            hashSet.add(Integer.toString(intValue.intValue()));
//        }
//        StringBuilder sb = new StringBuilder("fm_updated_at");
//        sb.append("<>0 AND amr_audio_path <> '' AND amr_audio_path IS NOT NULL AND m4a_audio_path <> '' AND m4a_audio_path IS NOT NULL");
//        Cursor perform = QueryBuilder.query(WORD_MEDIA_TB.getContentUri(i)).where(sb.toString(), new String[0]).perform(context);
//        if (perform == null) {
//            return null;
//        }
//        try {
//            ArrayList arrayList = new ArrayList();
//            while (perform.moveToNext()) {
//                String string = perform.getString(perform.getColumnIndex("topic_id"));
//                if (hashSet.contains(string)) {
//                    String string2 = perform.getString(perform.getColumnIndex(Columns.M4A_AUDIO_PATH));
//                    String string3 = perform.getString(perform.getColumnIndex(Columns.AMR_AUDIO_PATH));
//                    String string4 = perform.getString(perform.getColumnIndex(Columns.TV_PATH));
//                    long j = perform.getLong(perform.getColumnIndex("fm_updated_at"));
//                    long j2 = perform.getLong(perform.getColumnIndex("tv_updated_at"));
//                    WordMediaRecord wordMediaRecord = new WordMediaRecord();
//                    wordMediaRecord.setWordid(string);
//                    wordMediaRecord.setHighfmpath(string2);
//                    wordMediaRecord.setFmpath(string3);
//                    wordMediaRecord.setTvpath(string4);
//                    wordMediaRecord.setFmupdate(j);
//                    wordMediaRecord.setTvupdate(j2);
//                    arrayList.add(wordMediaRecord);
//                }
//            }
//            return arrayList;
//        } finally {
//            perform.close();
//        }
//    }
//}
