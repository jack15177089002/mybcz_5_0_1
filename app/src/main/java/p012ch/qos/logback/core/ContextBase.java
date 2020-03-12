package p012ch.qos.logback.core;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import p012ch.qos.logback.core.spi.LifeCycle;
import p012ch.qos.logback.core.spi.LogbackLock;
import p012ch.qos.logback.core.status.StatusManager;
import p012ch.qos.logback.core.util.EnvUtil;
import p012ch.qos.logback.core.util.ExecutorServiceUtil;
import p012ch.qos.logback.core.util.FileUtil;

/* renamed from: ch.qos.logback.core.ContextBase */
public class ContextBase implements Context, LifeCycle {
    private long birthTime = System.currentTimeMillis();
    LogbackLock configurationLock = new LogbackLock();
    private volatile ExecutorService executorService;
    private LifeCycleManager lifeCycleManager;
    private String name;
    Map<String, Object> objectMap = new HashMap();
    Map<String, String> propertyMap = new HashMap();

    /* renamed from: sm */
    private StatusManager f1662sm = new BasicStatusManager();
    private boolean started;

    public StatusManager getStatusManager() {
        return this.f1662sm;
    }

    public void setStatusManager(StatusManager statusManager) {
        if (statusManager == null) {
            throw new IllegalArgumentException("null StatusManager not allowed");
        }
        this.f1662sm = statusManager;
    }

    public Map<String, String> getCopyOfPropertyMap() {
        return new HashMap(this.propertyMap);
    }

    public void putProperty(String str, String str2) {
        this.propertyMap.put(str, str2);
    }

    public String getProperty(String str) {
        if (CoreConstants.CONTEXT_NAME_KEY.equals(str)) {
            return getName();
        }
        return (String) this.propertyMap.get(str);
    }

    public Object getObject(String str) {
        return this.objectMap.get(str);
    }

    public void putObject(String str, Object obj) {
        this.objectMap.put(str, obj);
    }

    public String getName() {
        return this.name;
    }

    public void start() {
        this.started = true;
    }

    public void stop() {
        stopExecutorService();
        this.started = false;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void reset() {
        getLifeCycleManager().reset();
        this.propertyMap.clear();
        this.objectMap.clear();
    }

    public void setName(String str) {
        if (str != null && str.equals(this.name)) {
            return;
        }
        if (this.name == null || "default".equals(this.name)) {
            this.name = str;
            return;
        }
        throw new IllegalStateException("Context has been already given a name");
    }

    public long getBirthTime() {
        return this.birthTime;
    }

    public Object getConfigurationLock() {
        return this.configurationLock;
    }

    public ExecutorService getExecutorService() {
        if (this.executorService == null) {
            synchronized (this) {
                if (this.executorService == null) {
                    this.executorService = ExecutorServiceUtil.newExecutorService();
                }
            }
        }
        return this.executorService;
    }

    private synchronized void stopExecutorService() {
        if (this.executorService != null) {
            ExecutorServiceUtil.shutdown(this.executorService);
            this.executorService = null;
        }
    }

    public void register(LifeCycle lifeCycle) {
        getLifeCycleManager().register(lifeCycle);
    }

    /* access modifiers changed from: 0000 */
    public synchronized LifeCycleManager getLifeCycleManager() {
        if (this.lifeCycleManager == null) {
            this.lifeCycleManager = new LifeCycleManager();
        }
        return this.lifeCycleManager;
    }

    public String toString() {
        return this.name;
    }

    public String getAbsoluteFilePath(String str) {
        if (!EnvUtil.isAndroidOS() || new File(str).isAbsolute()) {
            return str;
        }
        return FileUtil.prefixRelativePath(getProperty(CoreConstants.DATA_DIR_KEY), str);
    }
}
