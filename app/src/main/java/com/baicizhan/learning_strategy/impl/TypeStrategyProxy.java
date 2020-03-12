//package com.baicizhan.learning_strategy.impl;
//
//import com.baicizhan.learning_strategy.bean.ProblemProxy;
//import com.baicizhan.learning_strategy.bean.TypeProxy;
//import com.baicizhan.learning_strategy.iface.TypeStrategy;
//import com.baicizhan.learning_strategy.util.NativeObjectProxy;
//import org.mozilla.javascript.NativeObject;
//
//public class TypeStrategyProxy extends NativeObjectProxy implements TypeStrategy {
//    public TypeStrategyProxy(NativeObject cbVar) {
//        super(cbVar);
//    }
//
//    public TypeProxy getType(ProblemProxy problemProxy) {
//        NativeObject invokeNativeObject = invokeNativeObject("getType", null, problemProxy.nativeObject());
//        if (invokeNativeObject == null) {
//            return null;
//        }
//        return new TypeProxy(invokeNativeObject);
//    }
//}
