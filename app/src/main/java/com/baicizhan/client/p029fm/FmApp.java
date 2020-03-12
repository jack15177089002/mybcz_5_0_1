package com.baicizhan.client.p029fm;

import com.baicizhan.client.framework.BaseApp;
import com.baicizhan.client.framework.handler.AbstractAppHandler;

/* renamed from: com.baicizhan.client.fm.FmApp */
public class FmApp extends BaseApp {
    public AbstractAppHandler[] getRawHandlers() {
        return new AbstractAppHandler[]{new FmAppHandler()};
    }
}
