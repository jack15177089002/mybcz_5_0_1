package com.baicizhan.learning_strategy.core;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;

public class JsRuntime {
    private static final JsRuntime instance = new JsRuntime();
    private int optimizationLevel = -1;
    private Scriptable scriptable = null;

    public static final JsRuntime getInstance() {
        return instance;
    }

    private JsRuntime() {
    }

    public void init(int i) {
        this.optimizationLevel = i;
        try {
            Context b = Context.m6762b();
            b.mo19137a(i);
            this.scriptable = ScriptRuntime.m6372a(b);
        } finally {
            Context.m6766c();
        }
    }

    public Scriptable getGlobalScriptable() {
        return this.scriptable;
    }

    public Context getContext() {
        Context b = Context.m6762b();
        b.mo19137a(this.optimizationLevel);
        return b;
    }

    public void destory() {
    }
}
