//package com.baicizhan.learning_strategy.impl;
//
//import com.baicizhan.learning_strategy.bean.ProblemProxy;
//import com.baicizhan.learning_strategy.core.JsRuntime;
//import com.baicizhan.learning_strategy.iface.ObjectCreator;
//import com.baicizhan.learning_strategy.util.C0975L;
//import com.baicizhan.learning_strategy.util.JsExecutor;
//import com.baicizhan.learning_strategy.util.NativeObjectProxy;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map.Entry;
//import org.mozilla.javascript.Context;
//import org.mozilla.javascript.NativeObject;
//
//public class ObjectCreatorProxy extends NativeObjectProxy implements ObjectCreator {
//    private static NativeObject get() {
//        try {
//            Object execute = JsExecutor.execute(JsRuntime.getInstance().getContext(), JsRuntime.getInstance().getGlobalScriptable(), "new ObjectCreator()");
//            if (execute instanceof NativeObject) {
//                NativeObject cbVar = (NativeObject) execute;
//                Context.m6766c();
//                return cbVar;
//            }
//            Context.m6766c();
//            return null;
//        } catch (Exception e) {
//            C0975L.log.error("create ObjectCreatorProxy error", (Throwable) e);
//            throw e;
//        } catch (Throwable th) {
//            Context.m6766c();
//            throw th;
//        }
//    }
//
//    public ObjectCreatorProxy() {
//        super(get());
//    }
//
//    public ProblemProxy createProblem() {
//        return new ProblemProxy(invokeNativeObject("createProblem", null, new Object[0]));
//    }
//
//    public List<ProblemProxy> createProblems(int i) {
//        NativeObject invokeNativeObject = invokeNativeObject("createProblem", null, new Object[0]);
//        HashSet<Entry> hashSet = new HashSet<>(invokeNativeObject.entrySet());
//        ArrayList arrayList = new ArrayList(i);
//        for (int i2 = 0; i2 < i; i2++) {
//            NativeObject cbVar = new NativeObject();
//            cbVar.setPrototype(invokeNativeObject.getPrototype());
//            for (Entry entry : hashSet) {
//                cbVar.put(entry.getKey().toString(), cbVar, entry.getValue());
//            }
//            arrayList.add(new ProblemProxy(cbVar));
//        }
//        return arrayList;
//    }
//}
