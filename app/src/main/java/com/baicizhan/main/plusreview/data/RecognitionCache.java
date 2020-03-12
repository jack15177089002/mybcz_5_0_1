//package com.baicizhan.main.plusreview.data;
//
//import java.io.File;
//import java.util.Map;
//
//public class RecognitionCache {
//    private static final RecognitionCache sInstance = new RecognitionCache();
//    private Map<Integer, RecognitionData> mDatas;
//
//    private RecognitionCache() {
//    }
//
//    public static RecognitionCache getCache() {
//        return sInstance;
//    }
//
//    public Map<Integer, RecognitionData> getDatas() {
//        return this.mDatas;
//    }
//
//    public void setDatas(Map<Integer, RecognitionData> map) {
//        this.mDatas = map;
//    }
//
//    public boolean needLoad(int i) {
//        if (this.mDatas == null) {
//            return false;
//        }
//        RecognitionData recognitionData = (RecognitionData) this.mDatas.get(Integer.valueOf(i));
//        if (recognitionData == null) {
//            return false;
//        }
//        return !new File(recognitionData.getDicPath()).exists() || !new File(recognitionData.getDmpPath()).exists();
//    }
//}
