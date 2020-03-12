//package com.baicizhan.client.business.dataset.thrifadapt;
//
//import com.baicizhan.client.business.dataset.models.WordMediaMidRecord;
////import com.baicizhan.online.bs_words.BBWordMediaHalftimeList;
//import java.util.ArrayList;
//import java.util.List;
//
//public class WordMediaMidRecordAdapter {
//    private WordMediaMidRecordAdapter() {
//    }
//
////    public static List<WordMediaMidRecord> fromList(BBWordMediaHalftimeList bBWordMediaHalftimeList) {
////        if (bBWordMediaHalftimeList == null) {
////            return null;
////        }
////        List<String> word_fm_halftime_list = bBWordMediaHalftimeList.getWord_fm_halftime_list();
////        List<String> word_tv_halftime_list = bBWordMediaHalftimeList.getWord_tv_halftime_list();
////        List<String> word_fm_head_list = bBWordMediaHalftimeList.getWord_fm_head_list();
////        List<String> word_fm_tail_list = bBWordMediaHalftimeList.getWord_fm_tail_list();
////        if (word_fm_halftime_list == null && word_tv_halftime_list == null) {
////            return null;
////        }
////        ArrayList arrayList = new ArrayList();
////        if (word_fm_halftime_list != null) {
////            for (String str : word_fm_halftime_list) {
////                WordMediaMidRecord wordMediaMidRecord = new WordMediaMidRecord();
////                wordMediaMidRecord.setPath(str);
////                wordMediaMidRecord.setType(0);
////                arrayList.add(wordMediaMidRecord);
////            }
////        }
////        if (word_tv_halftime_list != null) {
////            for (String str2 : word_tv_halftime_list) {
////                WordMediaMidRecord wordMediaMidRecord2 = new WordMediaMidRecord();
////                wordMediaMidRecord2.setPath(str2);
////                wordMediaMidRecord2.setType(1);
////                arrayList.add(wordMediaMidRecord2);
////            }
////        }
////        if (word_fm_head_list != null) {
////            for (String str3 : word_fm_head_list) {
////                WordMediaMidRecord wordMediaMidRecord3 = new WordMediaMidRecord();
////                wordMediaMidRecord3.setPath(str3);
////                wordMediaMidRecord3.setType(2);
////                arrayList.add(wordMediaMidRecord3);
////            }
////        }
////        if (word_fm_tail_list != null) {
////            for (String str4 : word_fm_tail_list) {
////                WordMediaMidRecord wordMediaMidRecord4 = new WordMediaMidRecord();
////                wordMediaMidRecord4.setPath(str4);
////                wordMediaMidRecord4.setType(3);
////                arrayList.add(wordMediaMidRecord4);
////            }
////        }
////        return arrayList;
////    }
//}
