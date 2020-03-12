//package com.baicizhan.learning_strategy.core;
//
//import com.baicizhan.learning_strategy.iface.LearningManager;
//import com.baicizhan.learning_strategy.impl.LearningManagerProxy;
//import com.baicizhan.learning_strategy.util.JsExecutor;
//import org.mozilla.javascript.Context;
//import org.mozilla.javascript.NativeObject;
//import org.mozilla.javascript.Scriptable;
//
//public class StringLoader implements Loader {
//    private String script = null;
//
//    public StringLoader(String str) {
//        this.script = str;
//    }
//
//    public synchronized LearningManager load() {
//        LearningManager learningManager;
//        Scriptable globalScriptable = JsRuntime.getInstance().getGlobalScriptable();
//        Context context = JsRuntime.getInstance().getContext();
//        try {
//            JsExecutor.execute(context, globalScriptable, this.script);
//            Object execute = JsExecutor.execute(context, globalScriptable, "new LearningManager()");
//            if (execute instanceof NativeObject) {
//                LearningManagerProxy learningManagerProxy = new LearningManagerProxy((NativeObject) execute);
//                Context.m6766c();
//                learningManager = learningManagerProxy;
//            } else {
//                Context.m6766c();
//                learningManager = null;
//            }
//        } catch (Throwable th) {
//            Context.m6766c();
//            throw th;
//        }
//        return learningManager;
//    }
//}
