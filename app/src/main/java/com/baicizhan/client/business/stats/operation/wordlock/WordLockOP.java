//package com.baicizhan.client.business.stats.operation.wordlock;
//
//import com.baicizhan.client.business.stats.operation.OpCommonRecord;
//import com.baicizhan.client.business.stats.operation.TypeOP;
//import com.google.gson.Gson;//import com.p020b.p021a.Gson;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.util.List;
//
//public class WordLockOP extends TypeOP {
//    public int lockSize;
//
//    public static String parse(List<OpCommonRecord> list) {
//        if (list == null) {
//            return null;
//        }
//        WordLockOP wordLockOP = new WordLockOP();
//        wordLockOP.data = merge(list);
//        wordLockOP.lockSize = list.size();
//        return new Gson().mo3213a((Object) wordLockOP, new TypeToken<WordLockOP>() {
//        }.getType());
//    }
//}
