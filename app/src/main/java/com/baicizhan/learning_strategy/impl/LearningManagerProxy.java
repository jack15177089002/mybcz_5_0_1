//package com.baicizhan.learning_strategy.impl;
//
//import com.baicizhan.client.business.dataset.models.TopicLearnRecord;
//import com.baicizhan.learning_strategy.bean.ProblemProxy;
//import com.baicizhan.learning_strategy.iface.LearningManager;
//import com.baicizhan.learning_strategy.iface.SequenceStrategy;
//import com.baicizhan.learning_strategy.iface.TypeStrategy;
//import com.baicizhan.learning_strategy.util.DateTimeUtil;
//import com.baicizhan.learning_strategy.util.JsCreator;
//import com.baicizhan.learning_strategy.util.NativeObjectProxy;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;
//import org.mozilla.javascript.NativeArray;
//import org.mozilla.javascript.NativeObject;
//import org.mozilla.javascript.Scriptable;
//
//public class LearningManagerProxy extends NativeObjectProxy implements LearningManager {
//    public LearningManagerProxy(NativeObject cbVar) {
//        super(cbVar);
//    }
//
//    public void init(List<ProblemProxy> list, Map<Integer, ProblemProxy> map) {
//        init2(list, map);
//    }
//
//    /* access modifiers changed from: protected */
//    public void init1(List<ProblemProxy> list, Map<Integer, ProblemProxy> map) {
//        boolean z;
//        NativeArray createArray = JsCreator.createArray(list.size());
//        int i = 0;
//        for (ProblemProxy nativeObject : list) {
//            int i2 = i + 1;
//            createArray.put(i, (Scriptable) createArray, (Object) nativeObject.nativeObject());
//            i = i2;
//        }
//        long startOfTodayInMillis = DateTimeUtil.getStartOfTodayInMillis();
//        NativeObject cbVar = new NativeObject();
//        NativeObject cbVar2 = new NativeObject();
//        if (map != null) {
//            for (Entry entry : map.entrySet()) {
//                cbVar.put(((Integer) entry.getKey()).intValue(), (Scriptable) cbVar, (Object) ((ProblemProxy) entry.getValue()).nativeObject());
//                ProblemProxy problemProxy = (ProblemProxy) entry.getValue();
//                if (problemProxy.getLastLearnedTime() >= startOfTodayInMillis || problemProxy.isTodayNewLearned()) {
//                    z = true;
//                } else {
//                    z = false;
//                }
//                if (z) {
//                    cbVar2.put(((Integer) entry.getKey()).intValue(), (Scriptable) cbVar2, (Object) ((ProblemProxy) entry.getValue()).nativeObject());
//                }
//            }
//        }
//        invokeVoid("init", createArray, cbVar, cbVar2);
//    }
//
//    /* access modifiers changed from: protected */
//    public void init2(List<ProblemProxy> list, Map<Integer, ProblemProxy> map) {
//        int i;
//        NativeArray createArray = JsCreator.createArray(list.size());
//        int i2 = 0;
//        for (ProblemProxy nativeObject : list) {
//            int i3 = i2 + 1;
//            createArray.put(i2, (Scriptable) createArray, (Object) nativeObject.nativeObject());
//            i2 = i3;
//        }
//        long startOfTodayInMillis = DateTimeUtil.getStartOfTodayInMillis();
//        NativeObject cbVar = new NativeObject();
//        NativeObject cbVar2 = new NativeObject();
//        if (map != null) {
//            for (Entry entry : map.entrySet()) {
//                cbVar.put(((Integer) entry.getKey()).intValue(), (Scriptable) cbVar, (Object) ((ProblemProxy) entry.getValue()).nativeObject());
//                ProblemProxy problemProxy = (ProblemProxy) entry.getValue();
//                if (problemProxy.getLastLearnedTime() >= startOfTodayInMillis || problemProxy.isTodayNewLearned()) {
//                    cbVar2.put(((Integer) entry.getKey()).intValue(), (Scriptable) cbVar2, (Object) ((ProblemProxy) entry.getValue()).nativeObject());
//                }
//            }
//        }
//        HashMap hashMap = new HashMap();
//        hashMap.put(Integer.valueOf(TopicLearnRecord.SCORE_UNTOUCH), new ArrayList());
//        for (int i4 = 0; i4 <= 9; i4++) {
//            hashMap.put(Integer.valueOf(i4), new ArrayList());
//        }
//        for (ProblemProxy problemProxy2 : list) {
//            ProblemProxy problemProxy3 = (ProblemProxy) map.get(Integer.valueOf(problemProxy2.getId()));
//            if (problemProxy3 == null) {
//                problemProxy2.setScore(TopicLearnRecord.SCORE_UNTOUCH);
//                problemProxy2.setLastScore(TopicLearnRecord.SCORE_UNTOUCH);
//            } else if (!problemProxy3.isKilled()) {
//                problemProxy2 = problemProxy3;
//            }
//            int score = problemProxy2.getScore();
//            if (score != -1024 && score < 0) {
//                i = 0;
//            } else if (score > 9) {
//                i = 9;
//            } else {
//                i = score;
//            }
//            List list2 = (List) hashMap.get(Integer.valueOf(i));
//            if (list2 == null) {
//                list2 = new ArrayList();
//                hashMap.put(Integer.valueOf(i), list2);
//            }
//            list2.add(problemProxy2);
//        }
//        Collections.sort((List) hashMap.get(Integer.valueOf(9)), new Comparator<ProblemProxy>() {
//            public int compare(ProblemProxy problemProxy, ProblemProxy problemProxy2) {
//                int score = problemProxy.getScore() - problemProxy2.getScore();
//                return score != 0 ? score : problemProxy.getId() - problemProxy2.getId();
//            }
//        });
//        NativeObject cbVar3 = new NativeObject();
//        for (Entry entry2 : hashMap.entrySet()) {
//            int intValue = ((Integer) entry2.getKey()).intValue();
//            List<ProblemProxy> list3 = (List) entry2.getValue();
//            NativeArray createArray2 = JsCreator.createArray(list3.size());
//            int i5 = 0;
//            for (ProblemProxy nativeObject2 : list3) {
//                int i6 = i5 + 1;
//                createArray2.put(i5, (Scriptable) createArray2, (Object) nativeObject2.nativeObject());
//                i5 = i6;
//            }
//            cbVar3.put(intValue, (Scriptable) cbVar3, (Object) createArray2);
//        }
//        invokeVoid("initWithBuckets", createArray, cbVar, cbVar3, cbVar2);
//    }
//
//    private static NativeObject convertMapToNativeObject(Map<String, Object> map) {
//        if (map == null) {
//            return null;
//        }
//        NativeObject cbVar = new NativeObject();
//        for (Entry entry : map.entrySet()) {
//            cbVar.put((String) entry.getKey(), cbVar, objectToNative(entry.getValue()));
//        }
//        return cbVar;
//    }
//
//    private static Object objectToNative(Object obj) {
//        if (obj == null) {
//            return null;
//        }
//        if (obj instanceof List) {
//            List<Object> list = (List) obj;
//            NativeArray createArray = JsCreator.createArray(list.size());
//            int i = 0;
//            for (Object objectToNative : list) {
//                int i2 = i + 1;
//                createArray.put(i, (Scriptable) createArray, objectToNative(objectToNative));
//                i = i2;
//            }
//            return createArray;
//        } else if (obj instanceof Map) {
//            Map map = (Map) obj;
//            NativeObject cbVar = new NativeObject();
//            for (Entry entry : map.entrySet()) {
//                Object objectToNative2 = objectToNative(entry.getKey());
//                Object objectToNative3 = objectToNative(entry.getValue());
//                if (objectToNative2 instanceof Integer) {
//                    cbVar.put(((Integer) objectToNative2).intValue(), (Scriptable) cbVar, (Object) objectToNative3.toString());
//                } else {
//                    cbVar.put(objectToNative2.toString(), cbVar, objectToNative3.toString());
//                }
//            }
//            return cbVar;
//        } else if (!(obj instanceof Set)) {
//            return obj;
//        } else {
//            Set<Object> set = (Set) obj;
//            NativeObject cbVar2 = new NativeObject();
//            for (Object objectToNative4 : set) {
//                Object objectToNative5 = objectToNative(objectToNative4);
//                if (objectToNative5 instanceof Integer) {
//                    cbVar2.put(((Integer) objectToNative5).intValue(), (Scriptable) cbVar2, (Object) objectToNative5.toString());
//                } else {
//                    cbVar2.put(objectToNative5.toString(), cbVar2, objectToNative5.toString());
//                }
//            }
//            return cbVar2;
//        }
//    }
//
//    public void setSequenceModeNewAndReview(int i, Map<String, Object> map) {
//        invokeVoid("setSequenceModeNewAndReview", Integer.valueOf(i), convertMapToNativeObject(map));
//    }
//
//    public void setSequenceModeReviewMore(int i, Map<String, Object> map) {
//        invokeVoid("setSequenceModeReviewMore", Integer.valueOf(i), convertMapToNativeObject(map));
//    }
//
//    public void setSequenceModeMultiMedia(int i, Map<String, Object> map) {
//        invokeVoid("setSequenceModeMultiMedia", Integer.valueOf(i), convertMapToNativeObject(map));
//    }
//
//    public void setTypeModeLearning(Map<String, Object> map) {
//        invokeVoid("setTypeModeLearning", convertMapToNativeObject(map));
//    }
//
//    public void setTypeModeMultiMedia(Map<String, Object> map) {
//        invokeVoid("setTypeModeMultiMedia", convertMapToNativeObject(map));
//    }
//
//    public SequenceStrategy getSequenceStrategy() {
//        NativeObject invokeNativeObject = invokeNativeObject("getSequenceStrategy", null, new Object[0]);
//        if (invokeNativeObject == null) {
//            return null;
//        }
//        return new SequenceStrategyProxy(invokeNativeObject);
//    }
//
//    public TypeStrategy getTypeStrategy() {
//        NativeObject invokeNativeObject = invokeNativeObject("getTypeStrategy", null, new Object[0]);
//        if (invokeNativeObject == null) {
//            return null;
//        }
//        return new TypeStrategyProxy(invokeNativeObject);
//    }
//
//    public boolean isInited() {
//        return invokeBoolean("isInited", false, new Object[0]);
//    }
//}
