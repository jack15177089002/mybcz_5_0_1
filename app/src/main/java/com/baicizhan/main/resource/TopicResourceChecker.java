//package com.baicizhan.main.resource;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.text.TextUtils;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.helpers.TopicRecordHelper;
//import com.baicizhan.client.business.dataset.models.TopicRecord;
//import com.baicizhan.client.business.dataset.provider.Contracts.TOPICRESOURCE;
//import com.baicizhan.client.business.dataset.provider.Contracts.TOPICRESOURCE.Columns;
//import com.baicizhan.client.business.dataset.provider.QueryBuilder;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.business.util.ZPackUtils;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class TopicResourceChecker {
//    private static final String TAG = TopicResourceChecker.class.getSimpleName();
//
//    public static boolean checkIntegrity(TopicRecord topicRecord) {
//        boolean z = true;
//        if (topicRecord == null) {
//            return false;
//        }
//        if (ZPackUtils.isZpkExists(topicRecord)) {
//            return true;
//        }
//        LogWrapper.m2793d(TAG, "zpk not exists " + topicRecord);
//        if (!checkResourceExists(topicRecord.imagePath)) {
//            z = false;
//        }
//        if (!checkResourceExists(topicRecord.wordAudio)) {
//            z = false;
//        }
//        if (checkResourceExists(topicRecord.sentenceAudio)) {
//            return z;
//        }
//        return false;
//    }
//
//    public static boolean checkUpdateFlagMD5(TopicRecord topicRecord) {
//        if (topicRecord == null) {
//            return false;
//        }
//        String topicUpdateFlagMD5 = StudyManager.getInstance().getTopicUpdateFlagMD5(topicRecord.topicId);
//        if (TextUtils.isEmpty(topicUpdateFlagMD5) || TextUtils.isEmpty(topicRecord.updateFlagMD5) || TextUtils.equals(topicRecord.updateFlagMD5, topicUpdateFlagMD5)) {
//            return true;
//        }
//        return false;
//    }
//
//    public static boolean checkResourceExists(String str) {
//        return TextUtils.isEmpty(str) || PathUtil.isBaicizhanResourceFileExist(str);
//    }
//
//    public static List<Integer> queryTextAbsentTopics(Context context, int i) {
//        List newBookTopicRecordIds = TopicRecordHelper.getNewBookTopicRecordIds(context, i, StudyManager.getInstance().getCurrentRoadmap());
//        ArrayList arrayList = new ArrayList();
//        for (Integer intValue : StudyManager.getInstance().getRoadmapOrder()) {
//            int intValue2 = intValue.intValue();
//            if (!newBookTopicRecordIds.contains(Integer.valueOf(intValue2))) {
//                arrayList.add(Integer.valueOf(intValue2));
//            }
//        }
//        return arrayList;
//    }
//
//    private static Set<String> listResDir(String str) {
//        try {
//            HashSet hashSet = new HashSet();
//            Collections.addAll(hashSet, PathUtil.getBaicizhanFile(str).list());
//            return hashSet;
//        } catch (Exception e) {
//            return Collections.emptySet();
//        }
//    }
//
//    private static boolean isFileExists(String str, Set<String> set) {
//        if (TextUtils.isEmpty(str)) {
//            return false;
//        }
//        File baicizhanResourceFile = PathUtil.getBaicizhanResourceFile(str);
//        if (set.contains(baicizhanResourceFile.getName()) || baicizhanResourceFile.exists()) {
//            return true;
//        }
//        return false;
//    }
//
//    public static List<Integer> queryMediaAbsentTopics(Context context, int i) {
//        ArrayList arrayList = new ArrayList();
//        Set listResDir = listResDir(ZPackUtils.LEGACY_IMAGE_DIR);
//        Set listResDir2 = listResDir(ZPackUtils.LEGACY_WORD_AUDIO_DIR);
//        Set listResDir3 = listResDir(ZPackUtils.LEGACY_SENTENCE_AUDIO_DIR);
//        Cursor cursor = null;
//        try {
//            Cursor perform = QueryBuilder.query(TOPICRESOURCE.getBookContentUri(i)).projection(Columns.TOPIC, "image", "word_audio", "sentence_audio", "zpk_path").perform(context);
//            perform.moveToFirst();
//            while (!perform.isAfterLast()) {
//                int i2 = perform.getInt(0);
//                if (!(ZPackUtils.isZpkExists(i, perform.getString(4)) || (isFileExists(perform.getString(1), listResDir) && isFileExists(perform.getString(2), listResDir2) && isFileExists(perform.getString(3), listResDir3)))) {
//                    arrayList.add(Integer.valueOf(i2));
//                }
//                perform.moveToNext();
//            }
//            if (perform != null) {
//                perform.close();
//            }
//        } catch (Exception e) {
//            LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//            if (cursor != null) {
//                cursor.close();
//            }
//        } catch (Throwable th) {
//            if (cursor != null) {
//                cursor.close();
//            }
//            throw th;
//        }
//        return arrayList;
//    }
//}
