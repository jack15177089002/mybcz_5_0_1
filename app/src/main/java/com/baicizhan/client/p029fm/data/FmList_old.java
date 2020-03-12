//package com.baicizhan.client.p029fm.data;
//
//import android.text.TextUtils;
//import com.baicizhan.client.p029fm.data.p030db.FmIdMapRecord;
//import com.baicizhan.client.p029fm.data.p030db.FmIdPathMapRecord;
//import com.baicizhan.client.p029fm.data.p030db.WordInfoRecord;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///* renamed from: com.baicizhan.client.fm.data.FmList_old */
//public class FmList_old {
//    private List<FmData_old> mDatas;
//    private Map<String, FmIdMapRecord> mFmIdMapRecordMap;
//    private Map<String, FmIdPathMapRecord> mFmIdPathMapRecordMap;
//    private List<String> mSequenceIds;
//    private Map<String, WordInfoRecord> mWordInfoRecordMap;
//
//    /* access modifiers changed from: 0000 */
//    public void injectSequenceIds(List<String> list) {
//        if (list != null && !list.isEmpty()) {
//            this.mSequenceIds = new ArrayList(list);
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void injectFmIdMapRecords(List<FmIdMapRecord> list) {
//        if (list != null && !list.isEmpty()) {
//            this.mFmIdMapRecordMap = new HashMap(list.size());
//            for (FmIdMapRecord fmIdMapRecord : list) {
//                this.mFmIdMapRecordMap.put(fmIdMapRecord.getWordid(), fmIdMapRecord);
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void injectWordInfoRecords(List<WordInfoRecord> list) {
//        if (list != null && !list.isEmpty()) {
//            this.mWordInfoRecordMap = new HashMap(list.size());
//            for (WordInfoRecord wordInfoRecord : list) {
//                this.mWordInfoRecordMap.put(wordInfoRecord.getWordid(), wordInfoRecord);
//            }
//        }
//    }
//
//    /* access modifiers changed from: 0000 */
//    public void injectFmIdPathMapRecords(List<FmIdPathMapRecord> list) {
//        if (list != null && !list.isEmpty()) {
//            this.mFmIdPathMapRecordMap = new HashMap();
//            for (FmIdPathMapRecord fmIdPathMapRecord : list) {
//                this.mFmIdPathMapRecordMap.put(fmIdPathMapRecord.getFmid(), fmIdPathMapRecord);
//            }
//        }
//    }
//
//    public boolean adapt() {
//        if (this.mSequenceIds == null || this.mSequenceIds.isEmpty() || this.mFmIdMapRecordMap == null || this.mFmIdMapRecordMap.isEmpty() || this.mWordInfoRecordMap == null || this.mWordInfoRecordMap.isEmpty() || this.mFmIdPathMapRecordMap == null || this.mFmIdPathMapRecordMap.isEmpty()) {
//            return false;
//        }
//        this.mDatas = new ArrayList(this.mSequenceIds.size());
//        for (String str : this.mSequenceIds) {
//            String fmid = ((FmIdMapRecord) this.mFmIdMapRecordMap.get(str)).getFmid();
//            if (fmid != null) {
//                FmIdPathMapRecord fmIdPathMapRecord = (FmIdPathMapRecord) this.mFmIdPathMapRecordMap.get(fmid);
//                if (fmIdPathMapRecord != null && !TextUtils.isEmpty(fmIdPathMapRecord.getPath()) && !TextUtils.isEmpty(fmIdPathMapRecord.getHdpath())) {
//                    WordInfoRecord wordInfoRecord = (WordInfoRecord) this.mWordInfoRecordMap.get(str);
//                    if (wordInfoRecord != null) {
//                        FmData_old fmData_old = new FmData_old();
//                        fmData_old.wordid = str;
//                        fmData_old.fmid = fmid;
//                        fmData_old.word = wordInfoRecord.getWord();
//                        fmData_old.accent = wordInfoRecord.getAccent();
//                        fmData_old.cnmean = wordInfoRecord.getCnmean();
//                        fmData_old.example = wordInfoRecord.getExample();
//                        fmData_old.path = fmIdPathMapRecord.getPath();
//                        fmData_old.hdpath = fmIdPathMapRecord.getHdpath();
//                        this.mDatas.add(fmData_old);
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
//    public int size() {
//        if (this.mDatas == null) {
//            return 0;
//        }
//        return this.mDatas.size();
//    }
//
//    public boolean isEmpty() {
//        if (this.mDatas == null) {
//            return true;
//        }
//        return this.mDatas.isEmpty();
//    }
//
//    public FmData_old get(int i) {
//        if (this.mDatas == null) {
//            return null;
//        }
//        return (FmData_old) this.mDatas.get(i);
//    }
//
//    public void clear() {
//        if (this.mDatas != null) {
//            this.mDatas.clear();
//            this.mDatas = null;
//            if (this.mSequenceIds != null) {
//                this.mSequenceIds.clear();
//                this.mSequenceIds = null;
//            }
//            if (this.mFmIdMapRecordMap != null) {
//                this.mFmIdMapRecordMap.clear();
//                this.mFmIdMapRecordMap = null;
//            }
//            if (this.mWordInfoRecordMap != null) {
//                this.mWordInfoRecordMap.clear();
//                this.mWordInfoRecordMap = null;
//            }
//            if (this.mFmIdPathMapRecordMap != null) {
//                this.mFmIdPathMapRecordMap.clear();
//                this.mFmIdPathMapRecordMap = null;
//            }
//        }
//    }
//}
