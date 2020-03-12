package p012ch.qos.logback.core;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import p012ch.qos.logback.core.spi.LifeCycle;
import p012ch.qos.logback.core.spi.PropertyContainer;
import p012ch.qos.logback.core.status.StatusManager;

/* renamed from: ch.qos.logback.core.Context */
public interface Context extends PropertyContainer {
    String getAbsoluteFilePath(String str);

    long getBirthTime();

    Object getConfigurationLock();

    Map<String, String> getCopyOfPropertyMap();

    ExecutorService getExecutorService();

    String getName();

    Object getObject(String str);

    String getProperty(String str);

    StatusManager getStatusManager();

    void putObject(String str, Object obj);

    void putProperty(String str, String str2);

    void register(LifeCycle lifeCycle);

    void setName(String str);
}
