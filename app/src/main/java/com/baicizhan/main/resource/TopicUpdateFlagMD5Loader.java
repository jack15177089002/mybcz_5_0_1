//package com.baicizhan.main.resource;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.text.TextUtils;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.helpers.BookRecordHelper;
//import com.baicizhan.client.business.dataset.helpers.KVHelper;
//import com.baicizhan.client.business.dataset.models.BookRecord;
//import com.baicizhan.client.business.dataset.provider.Contracts.TOPICRESOURCE;
//import com.baicizhan.client.business.dataset.provider.Contracts.TOPICRESOURCE.Columns;
//import com.baicizhan.client.business.managers.StudyManager;
//import com.baicizhan.client.business.thrift.BaicizhanThrifts;
//import com.baicizhan.client.business.util.CollectionUtils;
//import com.baicizhan.client.business.util.LogWrapper;
//import com.baicizhan.online.bs_users.BBWordUpdateMD5;
//import com.baicizhan.online.bs_users.BSUsers.Client;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import org.p100a.p101a.p107f.C2120g;
//
//public class TopicUpdateFlagMD5Loader {
//    private static final int COMPATE_STATE_FINISH = -1;
//    private static final String TAG = TopicUpdateFlagMD5Loader.class.getSimpleName();
//
//    public static void load(Context context) {
//        BookRecord currentBook = StudyManager.getInstance().getCurrentBook();
//        LogWrapper.m2795i(TAG, "check book res version: " + currentBook.localBookResVer + " - " + currentBook.remoteBookResVer);
//        if (!StudyManager.getInstance().hasValidTopicUpdateInfos()) {
//            if ((currentBook.localBookResVer != 0 && (currentBook.remoteBookResVer <= 0 || currentBook.localBookResVer == currentBook.remoteBookResVer)) || !loadTopicUpdateFlagsFromServer(context)) {
//                LogWrapper.m2793d(TAG, "<client> getTopicUpdateFlagsByBookId");
//                Map topicUpdateFlagsByBookId = BookRecordHelper.getTopicUpdateFlagsByBookId(context, currentBook.bookId);
//                if (!CollectionUtils.isEmpty(topicUpdateFlagsByBookId)) {
//                    StudyManager.getInstance().setBookUpdateFlagMD5(topicUpdateFlagsByBookId);
//                } else if (!loadTopicUpdateFlagsFromServer(context)) {
//                    LogWrapper.m2797w(TAG, "can not get updateInfos");
//                }
//            }
//        }
//    }
//
//    private static boolean loadTopicUpdateFlagsFromServer(Context context) {
//        try {
//            Client client = (Client) BaicizhanThrifts.getProxy().createClient(BaicizhanThrifts.USERS);
//            if (StudyManager.getInstance().isOfflined()) {
//                return false;
//            }
//            BookRecord currentBook = StudyManager.getInstance().getCurrentBook();
//            LogWrapper.m2793d(TAG, "<server> get_word_update_md5_by_book");
//            List<BBWordUpdateMD5> list = client.get_word_update_md5_by_book(currentBook.bookId);
//            LogWrapper.m2793d(TAG, "thrift get_word_update_md5_by_book " + list.size());
//            if (!CollectionUtils.isEmpty((Collection<?>) list)) {
//                currentBook.localBookResVer = currentBook.remoteBookResVer;
//                BookRecordHelper.updateBookRecord(context, currentBook, "localBookResVer");
//                HashMap hashMap = new HashMap(list.size());
//                for (BBWordUpdateMD5 bBWordUpdateMD5 : list) {
//                    hashMap.put(Integer.valueOf(bBWordUpdateMD5.getTopic_id()), bBWordUpdateMD5.getUpdate_flag_md5());
//                }
//                BookRecordHelper.saveTopicUpdateFlagsByBookId(context, currentBook.bookId, hashMap);
//                StudyManager.getInstance().setBookUpdateFlagMD5(hashMap);
//                return true;
//            }
//            return false;
//        } catch (Exception e) {
//            if (!(e instanceof C2120g)) {
//                LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//            }
//        }
//    }
//
//    public static void compat(Context context) {
//        int i;
//        try {
//            if (StudyManager.getInstance().hasValidTopicUpdateInfos()) {
//                int currentBookId = StudyManager.getInstance().getCurrentBookId();
//                if (currentBookId > 0) {
//                    String subKey = KVHelper.getSubKey(KVHelper.KEY_USER_BOOK_UPDATE_MD5_COMPAT_STATE, Integer.toString(currentBookId));
//                    int i2 = KVHelper.getInt(context, subKey);
//                    if (i2 != -1) {
//                        ArrayList arrayList = new ArrayList(StudyManager.getInstance().getRoadmapOrder());
//                        Collections.sort(arrayList);
//                        LogWrapper.m2793d(TAG, "start ");
//                        int i3 = 0;
//                        int i4 = i2;
//                        while (i4 < arrayList.size()) {
//                            int intValue = ((Integer) arrayList.get(i4)).intValue();
//                            String topicUpdateFlagMD5 = StudyManager.getInstance().getTopicUpdateFlagMD5(intValue);
//                            if (!TextUtils.isEmpty(topicUpdateFlagMD5)) {
//                                ContentValues contentValues = new ContentValues();
//                                contentValues.put(Columns.UPDATE_FLAG_MD5, topicUpdateFlagMD5);
//                                context.getContentResolver().update(TOPICRESOURCE.getBookContentUri(currentBookId), contentValues, String.format("%s = %d AND %s is null", new Object[]{Columns.TOPIC, Integer.valueOf(intValue), Columns.UPDATE_FLAG_MD5}), null);
//                                i = i3 + 1;
//                                if (i >= 100) {
//                                    KVHelper.setInt(context, subKey, i4 + 1);
//                                    i = 0;
//                                }
//                            } else {
//                                i = i3;
//                            }
//                            i4++;
//                            i3 = i;
//                        }
//                        LogWrapper.m2793d(TAG, "end ");
//                        KVHelper.setInt(context, subKey, -1);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            LogWrapper.m2794e(TAG, Log.getStackTraceString(e));
//        }
//    }
//}
