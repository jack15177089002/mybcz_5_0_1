package com.baicizhan.learning_strategy.util;

import com.baicizhan.learning_strategy.core.JsRuntime;
import org.mozilla.javascript.C2193eh;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.ScriptableObject;

public class JsCreator {
    public static NativeArray createArray(int i) {
        NativeArray bcVar = new NativeArray((long) i);
        ScriptRuntime.m6384a((ScriptableObject) bcVar, JsRuntime.getInstance().getGlobalScriptable(), C2193eh.Array);
        return bcVar;
    }
}
