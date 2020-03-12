//package com.baicizhan.client.wordlock.data;
//
//import android.os.Looper;
//import android.text.TextUtils;
//import com.baicizhan.client.business.search.Word;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class WordToReviewCache {
//    private static List<Word> CACHE = new ArrayList(30);
//    private static final int FRAGMENT_SIZE = 5;
//
//    private WordToReviewCache() {
//    }
//
//    public static final boolean isEmpty() {
//        return CACHE.isEmpty();
//    }
//
//    public static final void refresh(List<Word> list) {
//        disableWorkerThread();
//        if (list != null && !list.isEmpty()) {
//            CACHE.clear();
//            CACHE = list;
//        }
//    }
//
//    public static final void removeReviewed(String str) {
//        int i;
//        disableWorkerThread();
//        if (str != null) {
//            int size = CACHE.size();
//            int i2 = 0;
//            while (true) {
//                if (i2 >= size) {
//                    i = -1;
//                    break;
//                } else if (((Word) CACHE.get(i2)).getId().equals(str)) {
//                    i = i2;
//                    break;
//                } else {
//                    i2++;
//                }
//            }
//            if (i >= 0 && i < size) {
//                CACHE.remove(i);
//            }
//        }
//    }
//
//    public static final void refreshElement(Word word) {
//        int i;
//        disableWorkerThread();
//        if (word != null) {
//            int i2 = 0;
//            Iterator it = CACHE.iterator();
//            while (true) {
//                i = i2;
//                if (!it.hasNext()) {
//                    i = -1;
//                    break;
//                }
//                Word word2 = (Word) it.next();
//                if (TextUtils.equals(word2.getId(), word.getId()) && word2.getBookId() == word.getBookId()) {
//                    break;
//                }
//                i2 = i + 1;
//            }
//            if (i >= 0) {
//                CACHE.set(i, word);
//            }
//        }
//    }
//
//    public static final List<WordReviewing> copyFragment() {
//        disableWorkerThread();
//        if (CACHE.isEmpty()) {
//            return null;
//        }
//        int min = Math.min(CACHE.size(), 5);
//        ArrayList arrayList = new ArrayList(min);
//        for (int i = 0; i < min; i++) {
//            WordReviewing wordReviewing = new WordReviewing();
//            wordReviewing.setWord((Word) CACHE.get(i));
//            arrayList.add(wordReviewing);
//        }
//        return arrayList;
//    }
//
//    private static final void disableWorkerThread() {
//        if (Looper.getMainLooper() != Looper.myLooper()) {
//            throw new RuntimeException("fatal error: word to review cache can only be used in main thread.");
//        }
//    }
//}
