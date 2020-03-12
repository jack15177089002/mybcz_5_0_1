package com.baicizhan.client.business;

import com.baicizhan.client.framework.BaseApp;
import com.baicizhan.client.framework.handler.AbstractAppHandler;

public class BusinessApp extends BaseApp {
    public AbstractAppHandler[] getRawHandlers() {
        return new AbstractAppHandler[]{new BusinessAppHandler()};
    }
}
