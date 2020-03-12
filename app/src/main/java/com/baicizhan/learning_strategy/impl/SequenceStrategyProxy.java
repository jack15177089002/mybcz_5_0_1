//package com.baicizhan.learning_strategy.impl;
//
//import com.baicizhan.learning_strategy.bean.ProblemList;
//import com.baicizhan.learning_strategy.bean.ProblemProxy;
//import com.baicizhan.learning_strategy.iface.SequenceStrategy;
//import com.baicizhan.learning_strategy.util.NativeObjectProxy;
//import com.baicizhan.learning_strategy.util.Pair;
//import com.baicizhan.main.receiver.LearnOperationReceiver;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import org.mozilla.javascript.Context;
//import org.mozilla.javascript.NativeArray;
//import org.mozilla.javascript.NativeObject;
//
//public class SequenceStrategyProxy extends NativeObjectProxy implements SequenceStrategy {
//    public SequenceStrategyProxy(NativeObject cbVar) {
//        super(cbVar);
//    }
//
//    public ProblemList getTodayRoadMap() {
//        NativeObject invokeNativeObject = invokeNativeObject("getTodayRoadMap", null, new Object[0]);
//        if (invokeNativeObject == null) {
//            return null;
//        }
//        try {
//            int doubleValue = (int) ((Double) invokeNativeObject.get("markedPosition", invokeNativeObject)).doubleValue();
//            try {
//                NativeArray bcVar = (NativeArray) invokeNativeObject.get("list", invokeNativeObject);
//                if (bcVar == null) {
//                    return null;
//                }
//                int size = bcVar.size();
//                ArrayList arrayList = new ArrayList(size);
//                for (int i = 0; i < size; i++) {
//                    arrayList.add(new ProblemProxy((NativeObject) bcVar.get(i)));
//                }
//                ProblemList problemList = new ProblemList();
//                problemList.setMarkedPosition(doubleValue);
//                problemList.setList(arrayList);
//                return problemList;
//            } catch (Exception e) {
//                return null;
//            }
//        } catch (Exception e2) {
//            return null;
//        }
//    }
//
//    public int getReviewCount() {
//        return invokeInt("getReviewCount", 0, new Object[0]);
//    }
//
//    public int getNewLearningCount() {
//        return invokeInt("getNewLearningCount", 0, new Object[0]);
//    }
//
//    public Pair<Integer, Integer> getNewLearningAndReviewCount() {
//        try {
//            NativeObject cbVar = (NativeObject) invokeObject("getNewLearningAndReviewCount", null, new Object[0]);
//            return new Pair<>(Integer.valueOf((int) ((Double) cbVar.get("newLearningCount", cbVar)).doubleValue()), Integer.valueOf((int) ((Double) cbVar.get("reviewCount", cbVar)).doubleValue()));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Pair<>(Integer.valueOf(0), Integer.valueOf(0));
//        }
//    }
//
//    public List<ProblemProxy> getNext(int i, int i2) {
//        NativeArray invokeNativeArray = invokeNativeArray("getNext", null, Integer.valueOf(i), Integer.valueOf(i2));
//        if (invokeNativeArray == null) {
//            return null;
//        }
//        int size = invokeNativeArray.size();
//        ArrayList arrayList = new ArrayList(size);
//        for (int i3 = 0; i3 < size; i3++) {
//            arrayList.add(new ProblemProxy((NativeObject) invokeNativeArray.get(i3)));
//        }
//        return arrayList;
//    }
//
//    public ProblemProxy getNextOne() {
//        NativeObject invokeNativeObject = invokeNativeObject("getNextOne", null, new Object[0]);
//        if (invokeNativeObject == null) {
//            return null;
//        }
//        return new ProblemProxy(invokeNativeObject);
//    }
//
//    public boolean hasNext() {
//        return invokeBoolean("hasNext", false, new Object[0]);
//    }
//
//    public ProblemProxy doneCorrect(ProblemProxy problemProxy, long j, Map<String, Object> map) {
//        try {
//            Context.m6762b();
//            NativeObject cbVar = map == null ? null : new NativeObject();
//            if (!(cbVar == null || map == null)) {
//                for (Entry entry : map.entrySet()) {
//                    cbVar.put((String) entry.getKey(), cbVar, entry.getValue());
//                }
//            }
//            NativeObject invokeNativeObject = invokeNativeObject("doneCorrect", null, problemProxy.nativeObject(), Long.valueOf(j), cbVar);
//            return invokeNativeObject == null ? null : new ProblemProxy(invokeNativeObject);
//        } finally {
//            Context.m6766c();
//        }
//    }
//
//    public ProblemProxy doneWrong(ProblemProxy problemProxy, long j, Map<String, Object> map) {
//        try {
//            Context.m6762b();
//            NativeObject cbVar = map == null ? null : new NativeObject();
//            if (!(cbVar == null || map == null)) {
//                for (Entry entry : map.entrySet()) {
//                    cbVar.put((String) entry.getKey(), cbVar, entry.getValue());
//                }
//            }
//            NativeObject invokeNativeObject = invokeNativeObject("doneWrong", null, problemProxy.nativeObject(), Long.valueOf(j), cbVar);
//            return invokeNativeObject == null ? null : new ProblemProxy(invokeNativeObject);
//        } finally {
//            Context.m6766c();
//        }
//    }
//
//    public void kill(ProblemProxy problemProxy) {
//        invokeObject(LearnOperationReceiver.ACTION_KILL, null, problemProxy.nativeObject());
//    }
//
//    public void cancelKill(ProblemProxy problemProxy) {
//        invokeObject("cancelKill", null, problemProxy.nativeObject());
//    }
//
//    public void skip(ProblemProxy problemProxy) {
//        invokeObject("skip", null, problemProxy.nativeObject());
//    }
//
//    public void cancelSkip(ProblemProxy problemProxy) {
//        invokeObject("cancelSkip", null, problemProxy.nativeObject());
//    }
//
//    public void userActionHint(ProblemProxy problemProxy) {
//        invokeObject("userActionHint", null, problemProxy.nativeObject());
//    }
//}
