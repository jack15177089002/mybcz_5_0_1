package com.baicizhan.client.framework.handler;

import android.app.Application;

public abstract class AbstractAppHandler {
    private static Application sApp;

    public abstract void onCreate();

    public void onDestroy() {
        sApp = null;
    }

    public static Application getApp() {
        return sApp;
    }

    public static void setApp(Application application) {
        sApp = application;
    }
}
