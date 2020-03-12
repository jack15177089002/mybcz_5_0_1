package com.baicizhan.client.framework;

import android.app.Application;
import android.util.Log;
import com.baicizhan.client.framework.handler.AbstractAppHandler;
import com.baicizhan.client.framework.stat.AbstractCrashManager;
import com.baicizhan.client.framework.util.Common;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseApp extends Application {
    private final List<AbstractAppHandler> mLibs = new ArrayList();

    public abstract AbstractAppHandler[] getRawHandlers();

    public void onCreate() {
        super.onCreate();
        String processName = Common.getProcessName(this);
        Log.d("whiz", "process name: " + processName);
        if (processName != null && !processName.equals("")) {
            AbstractCrashManager.monitor();
            initLibs();
        }
    }

    private void initLibs() {
        AbstractAppHandler.setApp(this);
        BaseAppHandler baseAppHandler = new BaseAppHandler();
        baseAppHandler.onCreate();
        this.mLibs.add(baseAppHandler);
        AbstractAppHandler[] rawHandlers = getRawHandlers();
        if (rawHandlers != null) {
            for (AbstractAppHandler abstractAppHandler : rawHandlers) {
                abstractAppHandler.onCreate();
                this.mLibs.add(abstractAppHandler);
            }
        }
    }

    public void onTerminate() {
        super.onTerminate();
        for (AbstractAppHandler onDestroy : this.mLibs) {
            onDestroy.onDestroy();
        }
        this.mLibs.clear();
    }
}
