package com.baicizhan.learning_strategy.util;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class JsExecutor {
    public static Object execute(Context lVar, Scriptable drVar, String str) {
        Timer timer = new Timer();
        timer.start();
        Object a = lVar.mo19134a(drVar, str);
        timer.stop();
        return a;
    }

    public static Object execute(int i, Scriptable drVar, String str) {
        Context b = Context.m6762b();
        b.mo19137a(i);
        try {
            return execute(b, drVar, str);
        } finally {
            Context.m6766c();
        }
    }

    public static Object execute(Scriptable drVar, String str) {
        return execute(-1, drVar, str);
    }
}
