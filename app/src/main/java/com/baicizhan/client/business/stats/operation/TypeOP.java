//package com.baicizhan.client.business.stats.operation;
//
//import com.google.gson.Gson;//import com.p020b.p021a.Gson;
//import com.networkbench.com.google.gson.reflect.TypeToken;//import1 com.p020b.p021a.p025c.TypeToken;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class TypeOP {
//    public List<Map<Integer, Integer>> data;
//
//    public static List<Map<Integer, Integer>> merge(List<OpCommonRecord> list) {
//        if (list == null || list.isEmpty()) {
//            return null;
//        }
//        ArrayList arrayList = new ArrayList(list.size());
//        Gson kVar = new Gson();
//        Type type = new TypeToken<Map<Integer, Integer>>() {
//        }.getType();
//        for (OpCommonRecord opValue : list) {
//            arrayList.add((Map) kVar.fromJson(opValue.getOpValue(), type));
//        }
//        return arrayList;
//    }
//}
