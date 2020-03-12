package com.baicizhan.client.wordtesting.application;

import com.baicizhan.client.framework.BaseApp;
import com.baicizhan.client.framework.handler.AbstractAppHandler;

public class WordTestingApplication extends BaseApp {
    public AbstractAppHandler[] getRawHandlers() {
        return new AbstractAppHandler[]{new WordTestingApplicationHandler()};
    }
}
