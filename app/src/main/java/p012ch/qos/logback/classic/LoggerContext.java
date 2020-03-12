package p012ch.qos.logback.classic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.Marker;
import p012ch.qos.logback.classic.android.AndroidManifestPropertiesUtil;
import p012ch.qos.logback.classic.spi.LoggerComparator;
import p012ch.qos.logback.classic.spi.LoggerContextListener;
import p012ch.qos.logback.classic.spi.LoggerContextVO;
import p012ch.qos.logback.classic.spi.TurboFilterList;
import p012ch.qos.logback.classic.turbo.TurboFilter;
import p012ch.qos.logback.classic.util.LoggerNameUtil;
import p012ch.qos.logback.core.ContextBase;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.joran.spi.JoranException;
import p012ch.qos.logback.core.spi.FilterReply;
import p012ch.qos.logback.core.spi.LifeCycle;
import p012ch.qos.logback.core.status.Status;
import p012ch.qos.logback.core.status.StatusListener;
import p012ch.qos.logback.core.status.StatusManager;
import p012ch.qos.logback.core.status.WarnStatus;

/* renamed from: ch.qos.logback.classic.LoggerContext */
public class LoggerContext extends ContextBase implements LifeCycle, ILoggerFactory {
    private boolean androidPropsInitialized = false;
    private List<String> frameworkPackages;
    private Map<String, Logger> loggerCache = new ConcurrentHashMap();
    private final List<LoggerContextListener> loggerContextListenerList = new ArrayList();
    private LoggerContextVO loggerContextRemoteView = new LoggerContextVO(this);
    private int maxCallerDataDepth = 8;
    private int noAppenderWarning = 0;
    private boolean packagingDataEnabled = true;
    int resetCount = 0;
//    final Logger root = new Logger(Logger.ROOT_LOGGER_NAME, null, this);
    private int size;
    private final TurboFilterList turboFilterList = new TurboFilterList();

    public LoggerContext() {
//        this.root.setLevel(Level.DEBUG);
//        this.loggerCache.put(Logger.ROOT_LOGGER_NAME, this.root);
//        initEvaluatorMap();
//        this.size = 1;
//        this.frameworkPackages = new ArrayList();
    }

    /* access modifiers changed from: 0000 */
    public void initEvaluatorMap() {
        putObject(CoreConstants.EVALUATOR_MAP, new HashMap());
    }

    private void updateLoggerContextVO() {
        this.loggerContextRemoteView = new LoggerContextVO(this);
    }

    private boolean isSpecialKey(String str) {
        return str.equals(CoreConstants.PACKAGE_NAME_KEY) || str.equals(CoreConstants.VERSION_NAME_KEY) || str.equals(CoreConstants.VERSION_CODE_KEY) || str.equals(CoreConstants.EXT_DIR_KEY) || str.equals(CoreConstants.DATA_DIR_KEY);
    }

    public String getProperty(String str) {
        if (isSpecialKey(str)) {
            try {
                if (!this.androidPropsInitialized) {
                    this.androidPropsInitialized = true;
                    AndroidManifestPropertiesUtil.setAndroidProperties(this);
                }
            } catch (Exception e) {
                getStatusManager().add((Status) new WarnStatus("Can't set manifest properties", e));
                this.androidPropsInitialized = false;
            }
        }
        return super.getProperty(str);
    }

    public void putProperty(String str, String str2) {
        super.putProperty(str, str2);
        updateLoggerContextVO();
    }

    public void setName(String str) {
        super.setName(str);
        updateLoggerContextVO();
    }

    public final Logger getLogger(Class cls) {
        return getLogger(cls.getName());
    }

    public final Logger getLogger(String str) {
        String substring;
        Logger logger;
//        if (str == null) {
//            throw new IllegalArgumentException("name argument cannot be null");
//        } else if (Logger.ROOT_LOGGER_NAME.equalsIgnoreCase(str)) {
//            return this.root;
//        } else {
//            Logger logger2 = this.root;
//            Logger logger3 = (Logger) this.loggerCache.get(str);
//            if (logger3 != null) {
//                return logger3;
//            }
//            Logger logger4 = logger2;
//            int i = 0;
//            while (true) {
//                int separatorIndexOf = LoggerNameUtil.getSeparatorIndexOf(str, i);
//                if (separatorIndexOf == -1) {
//                    substring = str;
//                } else {
//                    substring = str.substring(0, separatorIndexOf);
//                }
//                int i2 = separatorIndexOf + 1;
//                synchronized (logger4) {
//                    Logger childByName = logger4.getChildByName(substring);
//                    if (childByName == null) {
//                        childByName = logger4.createChildByName(substring);
//                        this.loggerCache.put(substring, childByName);
//                        incSize();
//                    }
//                    logger = childByName;
//                }
//                if (separatorIndexOf == -1) {
//                    return logger;
//                }
//                logger4 = logger;
//                i = i2;
//            }
//            while (true) {
//            }
//        }
        return null;
    }

    private void incSize() {
        this.size++;
    }

    /* access modifiers changed from: 0000 */
    public int size() {
        return this.size;
    }

    public Logger exists(String str) {
        return (Logger) this.loggerCache.get(str);
    }

    /* access modifiers changed from: 0000 */
    public final void noAppenderDefinedWarning(Logger logger) {
        int i = this.noAppenderWarning;
        this.noAppenderWarning = i + 1;
        if (i == 0) {
            getStatusManager().add((Status) new WarnStatus("No appenders present in context [" + getName() + "] for logger [" + logger.getName() + "].", logger));
        }
    }

    public List<Logger> getLoggerList() {
        ArrayList arrayList = new ArrayList(this.loggerCache.values());
        Collections.sort(arrayList, new LoggerComparator());
        return arrayList;
    }

    public LoggerContextVO getLoggerContextRemoteView() {
        return this.loggerContextRemoteView;
    }

    public void setPackagingDataEnabled(boolean z) {
        this.packagingDataEnabled = z;
    }

    public boolean isPackagingDataEnabled() {
        return this.packagingDataEnabled;
    }

    public void reset() {
        this.resetCount++;
        super.reset();
        initEvaluatorMap();
//        this.root.recursiveReset();
        resetTurboFilterList();
        fireOnReset();
        resetListenersExceptResetResistant();
        resetStatusListeners();
    }

    private void resetStatusListeners() {
        StatusManager statusManager = getStatusManager();
        for (StatusListener remove : statusManager.getCopyOfStatusListenerList()) {
            statusManager.remove(remove);
        }
    }

    public TurboFilterList getTurboFilterList() {
        return this.turboFilterList;
    }

    public void addTurboFilter(TurboFilter turboFilter) {
        this.turboFilterList.add(turboFilter);
    }

    public void resetTurboFilterList() {
        Iterator it = this.turboFilterList.iterator();
        while (it.hasNext()) {
            ((TurboFilter) it.next()).stop();
        }
        this.turboFilterList.clear();
    }

    /* access modifiers changed from: 0000 */
    public final FilterReply getTurboFilterChainDecision_0_3OrMore(Marker marker, Logger logger, Level level, String str, Object[] objArr, Throwable th) {
        if (this.turboFilterList.size() == 0) {
            return FilterReply.NEUTRAL;
        }
//        return this.turboFilterList.getTurboFilterChainDecision(marker, logger, level, str, objArr, th);

        return null;
    }

    /* access modifiers changed from: 0000 */
    public final FilterReply getTurboFilterChainDecision_1(Marker marker, Logger logger, Level level, String str, Object obj, Throwable th) {
        if (this.turboFilterList.size() == 0) {
            return FilterReply.NEUTRAL;
        }
//        return this.turboFilterList.getTurboFilterChainDecision(marker, logger, level, str, new Object[]{obj}, th);
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final FilterReply getTurboFilterChainDecision_2(Marker marker, Logger logger, Level level, String str, Object obj, Object obj2, Throwable th) {
        if (this.turboFilterList.size() == 0) {
            return FilterReply.NEUTRAL;
        }
//        return this.turboFilterList.getTurboFilterChainDecision(marker, logger, level, str, new Object[]{obj, obj2}, th);

        return null;
    }

    public void addListener(LoggerContextListener loggerContextListener) {
        this.loggerContextListenerList.add(loggerContextListener);
    }

    public void removeListener(LoggerContextListener loggerContextListener) {
        this.loggerContextListenerList.remove(loggerContextListener);
    }

    private void resetListenersExceptResetResistant() {
        ArrayList arrayList = new ArrayList();
        for (LoggerContextListener loggerContextListener : this.loggerContextListenerList) {
            if (loggerContextListener.isResetResistant()) {
                arrayList.add(loggerContextListener);
            }
        }
        this.loggerContextListenerList.retainAll(arrayList);
    }

    private void resetAllListeners() {
        this.loggerContextListenerList.clear();
    }

    public List<LoggerContextListener> getCopyOfListenerList() {
        return new ArrayList(this.loggerContextListenerList);
    }

    /* access modifiers changed from: 0000 */
    public void fireOnLevelChange(Logger logger, Level level) {
        for (LoggerContextListener onLevelChange : this.loggerContextListenerList) {
//            onLevelChange.onLevelChange(logger, level);
        }
    }

    private void fireOnReset() {
        for (LoggerContextListener onReset : this.loggerContextListenerList) {
            onReset.onReset(this);
        }
    }

    private void fireOnStart() {
        for (LoggerContextListener onStart : this.loggerContextListenerList) {
            onStart.onStart(this);
        }
    }

    private void fireOnStop() {
        for (LoggerContextListener onStop : this.loggerContextListenerList) {
            onStop.onStop(this);
        }
    }

    public void start() {
        super.start();
        fireOnStart();
    }

    public void stop() {
        reset();
        fireOnStop();
        resetAllListeners();
        super.stop();
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getClass().getName())).append("[").append(getName()).append("]").toString();
    }

    public int getMaxCallerDataDepth() {
        return this.maxCallerDataDepth;
    }

    public void setMaxCallerDataDepth(int i) {
        this.maxCallerDataDepth = i;
    }

    public List<String> getFrameworkPackages() {
        return this.frameworkPackages;
    }
}
