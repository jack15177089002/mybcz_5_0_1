//package com.baicizhan.client.video.data.p032db;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.helpers.WordMediaRecordHelper;
//import com.baicizhan.client.business.dataset.models.TopicLearnRecord;
//import com.baicizhan.client.business.dataset.models.WordMediaMidRecord;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.business.dataset.provider.Contracts.Databases;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS;
//import com.baicizhan.client.business.dataset.provider.Contracts.TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.Columns;
//import com.baicizhan.client.business.dataset.provider.Contracts.WORD_MEDIA_TB;
//import com.baicizhan.client.business.dataset.provider.Cursors;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.video.data.VideoInfo;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//
///* renamed from: com.baicizhan.client.video.data.db.VideoInfoHelper */
//public class VideoInfoHelper {
//
//    /* renamed from: com.baicizhan.client.video.data.db.VideoInfoHelper$ViewState */
//    class ViewState {
//        int skipValue;
//        int topicId;
//        int tvViewCount;
//
//        private ViewState() {
//        }
//    }
//
//    private VideoInfoHelper() {
//    }
//
//    public static List<WordMediaRecord> getPreparedWordMediaRecords(Context context, int i, List<Integer> list) {
//        if (list == null || list.isEmpty()) {
//            return null;
//        }
//        return Cursors.mapToList(QueryBuilder.query(WORD_MEDIA_TB.getContentUri(i)).whereIn("topic_id", list, 100).perform(context), WordMediaRecord.class, WordMediaRecord.COLUMN_MAP);
//    }
//
//    public static List<VideoInfo> mergeViewState(Context context, int i, List<WordMediaRecord> list, List<Integer> list2) {
//        boolean z;
//        int i2;
//        if (list == null || list.isEmpty()) {
//            return null;
//        }
//        StringBuilder sb = new StringBuilder("select distinct ");
//        sb.append("topic_id, radio_skip_state, radio_tv_state from ").append(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookTableName(i)).append(" where ").append(QueryBuilder.getWhereClause("topic_id", "in", list2));
//        Log.d("whiz", "tv state select sql: " + sb.toString());
//        Cursor perform = QueryBuilder.rawQuery(Databases.TOPIC_PROBLEM, sb.toString(), null).perform(context);
//        HashMap hashMap = new HashMap();
//        if (perform != null) {
//            while (perform.moveToNext()) {
//                try {
//                    ViewState viewState = new ViewState();
//                    viewState.topicId = perform.getInt(0);
//                    viewState.skipValue = perform.getInt(1);
//                    viewState.tvViewCount = perform.getInt(2);
//                    hashMap.put(Integer.valueOf(viewState.topicId), viewState);
//                } finally {
//                    perform.close();
//                }
//            }
//        }
//        HashMap hashMap2 = new HashMap();
//        for (WordMediaRecord wordMediaRecord : list) {
//            int intValue = Integer.valueOf(wordMediaRecord.getWordid()).intValue();
//            ViewState viewState2 = (ViewState) hashMap.get(Integer.valueOf(intValue));
//            VideoInfo videoInfo = new VideoInfo();
//            videoInfo.setWordId(intValue);
//            videoInfo.setWord(wordMediaRecord.getWord());
//            videoInfo.setMidfield(false);
//            videoInfo.setPath(wordMediaRecord.getTvpath());
//            if (viewState2 != null) {
//                z = TopicLearnRecord.isTVSkipped(viewState2.skipValue);
//            } else {
//                z = false;
//            }
//            videoInfo.setSkipped(z);
//            if (viewState2 != null) {
//                i2 = viewState2.tvViewCount;
//            } else {
//                i2 = 0;
//            }
//            videoInfo.setViewedCount(i2);
//            videoInfo.setInitedOne(videoInfo);
//            hashMap2.put(Integer.valueOf(intValue), videoInfo);
//        }
//        ArrayList arrayList = new ArrayList();
//        for (Integer intValue2 : list2) {
//            VideoInfo videoInfo2 = (VideoInfo) hashMap2.get(Integer.valueOf(intValue2.intValue()));
//            if (videoInfo2 != null) {
//                arrayList.add(videoInfo2);
//            }
//        }
//        return arrayList;
//    }
//
//    /* JADX INFO: finally extract failed */
//    public static List<Integer> reorderVideos(Context context, int i, List<String> list) {
//        if (list == null || list.isEmpty()) {
//            return null;
//        }
//        HashSet<String> hashSet = new HashSet<>(list);
//        StringBuilder sb = new StringBuilder("select distinct ");
//        sb.append("topic_id from ").append(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookTableName(i)).append(" order by radio_tv_state, topic_obn desc");
//        Log.d("whiz", "tv state select sql: " + sb.toString());
//        Cursor perform = QueryBuilder.rawQuery(Databases.TOPIC_PROBLEM, sb.toString(), null).perform(context);
//        if (perform == null) {
//            return null;
//        }
//        Log.d("whiz", "tv state select orig count: " + hashSet.size());
//        ArrayList arrayList = new ArrayList();
//        while (perform.moveToNext()) {
//            try {
//                String string = perform.getString(perform.getColumnIndex("topic_id"));
//                if (hashSet.contains(string)) {
//                    arrayList.add(Integer.valueOf(string));
//                    hashSet.remove(string);
//                }
//            } catch (Throwable th) {
//                perform.close();
//                throw th;
//            }
//        }
//        perform.close();
//        Log.d("whiz", "tv state select after count: " + hashSet.size());
//        for (String valueOf : hashSet) {
//            arrayList.add(Integer.valueOf(valueOf));
//        }
//        return arrayList;
//    }
//
//    public static List<VideoInfo> getVideoMidList(Context context) {
//        List<WordMediaMidRecord> wordMediaMidRecords = WordMediaRecordHelper.getWordMediaMidRecords(context, 1);
//        if (wordMediaMidRecords == null) {
//            return null;
//        }
//        ArrayList arrayList = new ArrayList(wordMediaMidRecords.size());
//        for (WordMediaMidRecord wordMediaMidRecord : wordMediaMidRecords) {
//            VideoInfo videoInfo = new VideoInfo();
//            videoInfo.setMidfield(true);
//            videoInfo.setPath(wordMediaMidRecord.getPath());
//            arrayList.add(videoInfo);
//        }
//        return arrayList;
//    }
//
//    public static void updateVideoLearnRecords(Context context, int i, List<VideoInfo> list) {
//        int i2;
//        if (list != null && !list.isEmpty()) {
//            int size = list.size();
//            for (int i3 = 0; i3 < size; i3++) {
//                VideoInfo videoInfo = (VideoInfo) list.get(i3);
//                VideoInfo initedOne = videoInfo.getInitedOne();
//                Log.d("whiz", "update tv learn record, org: " + initedOne);
//                if (initedOne == null) {
//                    C0789L.log.error("update tv learn records error, inited one is null, data is [{}]", (Object) videoInfo);
//                } else {
//                    if (videoInfo.isSkipped() == initedOne.isSkipped() && videoInfo.getViewedCount() == initedOne.getViewedCount()) {
//                        i2 = 0;
//                    } else {
//                        i2 = 1;
//                    }
//                    Log.d("whiz", "update tv learn record, needPost: " + i2 + "; skipped: " + videoInfo.isSkipped() + "; viewed: " + videoInfo.getViewedCount() + "; word: " + videoInfo.getWord());
//                    if (i2 > 0) {
//                        ContentValues contentValues = new ContentValues();
//                        contentValues.put(Columns.RADIO_SKIP_STATE, Integer.valueOf(videoInfo.getSkipValue()));
//                        contentValues.put(Columns.RADIO_TV_STATE, Integer.valueOf(videoInfo.getViewedCount()));
//                        contentValues.put(Columns.RADIO_POST_STATE, Integer.valueOf(i2));
//                        int update = context.getContentResolver().update(TS_LEARN_OFFLINE_DOTOPIC_SYNC_IDS.getBookContentUri(i), contentValues, "topic_id=?", new String[]{videoInfo.getWordId()});
//                        if (update <= 0) {
//                            C0789L.log.error("update tv learn records failed for unknown reason.");
//                        }
//                        Log.d("whiz", "update tv learn record, update count: " + update);
//                    }
//                }
//            }
//        }
//    }
//}
