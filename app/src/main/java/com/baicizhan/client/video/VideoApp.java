package com.baicizhan.client.video;

import com.baicizhan.client.framework.BaseApp;
import com.baicizhan.client.framework.handler.AbstractAppHandler;

public class VideoApp extends BaseApp {
    public AbstractAppHandler[] getRawHandlers() {
        return new AbstractAppHandler[]{new VideoAppHandler()};
    }
}
