package com.baicizhan.learning_strategy.bean;

import com.baicizhan.learning_strategy.util.NativeObjectProxy;
import org.mozilla.javascript.NativeObject;

public class TypeProxy extends NativeObjectProxy {
    public TypeProxy(NativeObject cbVar) {
        super(cbVar);
    }

    public void setValue(int i) {
        putAttribute("value", Integer.valueOf(i));
    }

    public int getValue() {
        return getIntAttribute("value", 0);
    }
}
