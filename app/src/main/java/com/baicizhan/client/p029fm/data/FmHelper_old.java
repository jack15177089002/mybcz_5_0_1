//package com.baicizhan.client.p029fm.data;
//
//import android.content.Context;
//import com.baicizhan.client.p029fm.data.p030db.FmIdMapRecord;
//import com.baicizhan.client.p029fm.data.p030db.FmIdMapRecordHelper;
//import com.baicizhan.client.p029fm.data.p030db.FmIdPathMapRecordHelper;
//import com.baicizhan.client.p029fm.data.p030db.WordInfoRecordHelper;
//import java.util.HashSet;
//import java.util.List;
//
///* renamed from: com.baicizhan.client.fm.data.FmHelper_old */
//public class FmHelper_old {
//    public static FmList_old getFmList(Context context, int i, List<String> list) {
//        if (list == null || list.isEmpty()) {
//            return null;
//        }
//        FmList_old fmList_old = new FmList_old();
//        fmList_old.injectSequenceIds(list);
//        HashSet hashSet = new HashSet(list.size());
//        for (String add : list) {
//            hashSet.add(add);
//        }
//        List<FmIdMapRecord> fmIdMapRecords = FmIdMapRecordHelper.getFmIdMapRecords(context, i, hashSet);
//        fmList_old.injectFmIdMapRecords(fmIdMapRecords);
//        HashSet hashSet2 = new HashSet(fmIdMapRecords.size());
//        for (FmIdMapRecord fmid : fmIdMapRecords) {
//            hashSet2.add(fmid.getFmid());
//        }
//        fmList_old.injectFmIdPathMapRecords(FmIdPathMapRecordHelper.getFmIdPathMapRecords(context, hashSet2));
//        fmList_old.injectWordInfoRecords(WordInfoRecordHelper.getWordInfoRecords(context, hashSet));
//        fmList_old.adapt();
//        return fmList_old;
//    }
//}
