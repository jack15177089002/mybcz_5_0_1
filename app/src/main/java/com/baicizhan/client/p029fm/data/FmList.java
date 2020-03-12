//package com.baicizhan.client.p029fm.data;
//
//import android.text.TextUtils;
//import android.util.Log;
//import com.baicizhan.client.business.dataset.models.TopicLearnRecord;
//import com.baicizhan.client.business.dataset.models.WordMediaRecord;
//import com.baicizhan.client.business.util.PathUtil;
//import com.baicizhan.client.framework.log.C0789L;
//import com.baicizhan.client.p029fm.data.p030db.WordInfoRecord;
//import com.baicizhan.client.p029fm.util.FmUtil;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//
///* renamed from: com.baicizhan.client.fm.data.FmList */
//public class FmList implements ITargetList<FmData> {
//    private LinkedHashMap<String, FmData> mDatas;
//    private String mHome = PathUtil.getBaicizhanAppRoot();
//    private Map<String, TopicLearnRecord> mLearnRecordMap;
//    private List<String> mSequenceIds;
//    private Map<String, FmData> mUnbornDatas;
//    private Map<String, WordInfoRecord> mWordInfoRecordMap;
//    private Map<String, WordMediaRecord> mWordMediaRecordMap;
//
//    public void injectSequenceIds(List<String> list) {
//        if (list != null && !list.isEmpty()) {
//            this.mSequenceIds = new ArrayList(list);
//        }
//    }
//
//    public void injectWordInfoRecords(List<WordInfoRecord> list) {
//        if (list == null || list.isEmpty()) {
//            this.mWordInfoRecordMap = new HashMap(0);
//            return;
//        }
//        this.mWordInfoRecordMap = new HashMap(list.size());
//        for (WordInfoRecord wordInfoRecord : list) {
//            this.mWordInfoRecordMap.put(wordInfoRecord.getWordid(), wordInfoRecord);
//        }
//    }
//
//    public void injectWordMediaRecords(List<WordMediaRecord> list) {
//        if (list == null || list.isEmpty()) {
//            this.mWordMediaRecordMap = new HashMap(0);
//            return;
//        }
//        this.mWordMediaRecordMap = new HashMap(list.size());
//        for (WordMediaRecord wordMediaRecord : list) {
//            this.mWordMediaRecordMap.put(wordMediaRecord.getWordid(), wordMediaRecord);
//        }
//    }
//
//    public void injectLearnRecords(List<TopicLearnRecord> list) {
//        if (list == null || list.isEmpty()) {
//            this.mLearnRecordMap = new HashMap(0);
//            return;
//        }
//        this.mLearnRecordMap = new HashMap(list.size());
//        for (TopicLearnRecord topicLearnRecord : list) {
//            this.mLearnRecordMap.put(String.valueOf(topicLearnRecord.topicId), topicLearnRecord);
//        }
//    }
//
//    public boolean adapt() {
//        if (this.mSequenceIds == null || this.mSequenceIds.isEmpty() || this.mWordMediaRecordMap == null) {
//            return false;
//        }
//        this.mDatas = new LinkedHashMap<>(this.mSequenceIds.size());
//        this.mUnbornDatas = new HashMap();
//        for (String str : this.mSequenceIds) {
//            FmData fmData = new FmData();
//            fmData.wordid = str;
//            if (this.mLearnRecordMap != null) {
//                TopicLearnRecord topicLearnRecord = (TopicLearnRecord) this.mLearnRecordMap.get(str);
//                if (topicLearnRecord != null) {
//                    fmData.viewed = topicLearnRecord.radioState;
//                    fmData.skipped = topicLearnRecord.radioSkipState;
//                }
//            }
//            WordMediaRecord wordMediaRecord = (WordMediaRecord) this.mWordMediaRecordMap.get(str);
//            if (wordMediaRecord == null) {
//                this.mUnbornDatas.put(str, fmData);
//            } else if (wordMediaRecord.getFmupdate() > 0) {
//                fmData.word = wordMediaRecord.getWord();
//                fmData.wordtype = wordMediaRecord.getWordtype();
//                fmData.cnmean = wordMediaRecord.getCnmean();
//                fmData.example = wordMediaRecord.getExample();
//                fmData.path = wordMediaRecord.getFmpath();
//                fmData.hdpath = wordMediaRecord.getHighfmpath();
//            }
//            fmData.setInitedOne(fmData);
//            this.mDatas.put(str, fmData);
//        }
//        return true;
//    }
//
//    public boolean needBorn() {
//        Log.d("whiz", "un born datas: " + this.mUnbornDatas);
//        return this.mUnbornDatas != null && !this.mUnbornDatas.isEmpty();
//    }
//
//    public List<String> born() {
//        if (!needBorn()) {
//            return null;
//        }
//        return new ArrayList(this.mUnbornDatas.keySet());
//    }
//
//    public void completeBorn(List<WordMediaRecord> list) {
//        int i;
//        Log.d("whiz", "complete born before, datas: " + this.mDatas.size());
//        if (needBorn()) {
//            if (list != null) {
//                i = 0;
//                for (WordMediaRecord wordMediaRecord : list) {
//                    FmData fmData = (FmData) this.mUnbornDatas.get(wordMediaRecord.getWordid());
//                    if (fmData == null) {
//                        C0789L.log.error("an invalid record is put to born [{}]", (Object) wordMediaRecord);
//                    } else {
//                        fmData.path = wordMediaRecord.getFmpath();
//                        fmData.hdpath = wordMediaRecord.getHighfmpath();
//                        this.mDatas.put(wordMediaRecord.getWordid(), fmData);
//                        i++;
//                    }
//                }
//            } else {
//                i = 0;
//            }
//            if (i < this.mUnbornDatas.size()) {
//                C0789L.log.error("fm data borned failed, some was lost.");
//                for (Entry entry : this.mUnbornDatas.entrySet()) {
//                    FmData fmData2 = (FmData) entry.getValue();
//                    if (TextUtils.isEmpty(fmData2.getPath()) && TextUtils.isEmpty(fmData2.getHdpath())) {
//                        C0789L.log.error("unborned fm word id: " + entry.getKey());
//                        this.mDatas.remove(entry.getKey());
//                    }
//                }
//            }
//            this.mUnbornDatas.clear();
//            Log.d("whiz", "complete born after, datas: " + this.mDatas.size());
//        }
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
//    public FmData get(int i) {
//        if (this.mDatas == null) {
//            Log.d("whiz", "fm list is null");
//            return null;
//        }
//        int i2 = 0;
//        Iterator it = this.mDatas.entrySet().iterator();
//        while (true) {
//            int i3 = i2;
//            if (it.hasNext()) {
//                Entry entry = (Entry) it.next();
//                if (i3 == i) {
//                    FmData fmData = (FmData) entry.getValue();
//                    if (fmData != null) {
//                        return fmData;
//                    }
//                    Log.d("whiz", "fm list get null data, just null shit, i: " + i3 + "; index: " + i + "; size: " + this.mDatas.size());
//                    return fmData;
//                }
//                i2 = i3 + 1;
//            } else {
//                Log.d("whiz", "fm list get null data, i: " + i3 + "; index: " + i + "; size: " + this.mDatas.size());
//                return null;
//            }
//        }
//    }
//
//    public String getLocalPath(int i) {
//        return getLocalPathFromData(get(i));
//    }
//
//    private String getLocalPathFromData(FmData fmData) {
//        if (fmData == null) {
//            return null;
//        }
//        String reformFmPath = FmUtil.reformFmPath(this.mHome + fmData.hdpath);
//        if (reformFmPath == null) {
//            return null;
//        }
//        File file = new File(reformFmPath);
//        if (file.exists()) {
//            return file.getAbsolutePath();
//        }
//        String reformFmPath2 = FmUtil.reformFmPath(this.mHome + fmData.path);
//        if (reformFmPath2 == null) {
//            return null;
//        }
//        File file2 = new File(reformFmPath2);
//        if (file2.exists()) {
//            return file2.getAbsolutePath();
//        }
//        return null;
//    }
//
//    public String getSavedPath(int i, boolean z) {
//        return FmUtil.reformFmPath(this.mHome + getPath(i, z));
//    }
//
//    public String getPath(int i, boolean z) {
//        FmData fmData = get(i);
//        if (fmData == null) {
//            return null;
//        }
//        if (z) {
//            return fmData.hdpath;
//        }
//        return fmData.path;
//    }
//
//    public void extractOfflines() {
//        if (this.mDatas != null) {
//            LinkedHashMap<String, FmData> linkedHashMap = new LinkedHashMap<>();
//            for (Entry value : this.mDatas.entrySet()) {
//                FmData fmData = (FmData) value.getValue();
//                if (!TextUtils.isEmpty(getLocalPathFromData(fmData))) {
//                    linkedHashMap.put(fmData.wordid, fmData);
//                }
//            }
//            this.mDatas = linkedHashMap;
//        }
//    }
//
//    public void clear() {
//        if (this.mDatas != null) {
//            this.mDatas.clear();
//            this.mDatas = null;
//            if (this.mUnbornDatas != null) {
//                this.mUnbornDatas.clear();
//                this.mUnbornDatas = null;
//            }
//            if (this.mSequenceIds != null) {
//                this.mSequenceIds.clear();
//                this.mSequenceIds = null;
//            }
//            if (this.mWordInfoRecordMap != null) {
//                this.mWordInfoRecordMap.clear();
//                this.mWordInfoRecordMap = null;
//            }
//            if (this.mWordMediaRecordMap != null) {
//                this.mWordMediaRecordMap.clear();
//                this.mWordMediaRecordMap = null;
//            }
//        }
//    }
//
//    public String toString() {
//        if (this.mDatas != null) {
//            return this.mDatas.toString();
//        }
//        return super.toString();
//    }
//}
