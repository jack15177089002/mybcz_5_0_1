package p012ch.qos.logback.classic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.spi.LocationAwareLogger;
import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.classic.spi.LoggingEvent;
import p012ch.qos.logback.classic.util.LoggerNameUtil;
import p012ch.qos.logback.core.Appender;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.spi.AppenderAttachable;
import p012ch.qos.logback.core.spi.AppenderAttachableImpl;
import p012ch.qos.logback.core.spi.FilterReply;

/* renamed from: ch.qos.logback.classic.Logger */
public final class Logger implements AppenderAttachable<ILoggingEvent>, Serializable, org.slf4j.Logger, LocationAwareLogger {
    private static final int DEFAULT_CHILD_ARRAY_SIZE = 5;
    public static final String FQCN = Logger.class.getName();
    private static final long serialVersionUID = 5454405123156820674L;
    private transient AppenderAttachableImpl<ILoggingEvent> aai;
    private transient boolean additive = true;
    private transient List<Logger> childrenList;
    private transient int effectiveLevelInt;
    private transient Level level;
    final transient LoggerContext loggerContext;
    private String name;
    private transient Logger parent;

    Logger(String str, Logger logger, LoggerContext loggerContext2) {
        this.name = str;
        this.parent = logger;
        this.loggerContext = loggerContext2;
    }

    public final Level getEffectiveLevel() {
        return Level.toLevel(this.effectiveLevelInt);
    }

    /* access modifiers changed from: 0000 */
    public final int getEffectiveLevelInt() {
        return this.effectiveLevelInt;
    }

    public final Level getLevel() {
        return this.level;
    }

    public final String getName() {
        return this.name;
    }

    private boolean isRootLogger() {
        return this.parent == null;
    }

    /* access modifiers changed from: 0000 */
    public final Logger getChildByName(String str) {
        if (this.childrenList == null) {
            return null;
        }
        int size = this.childrenList.size();
        for (int i = 0; i < size; i++) {
            Logger logger = (Logger) this.childrenList.get(i);
            if (str.equals(logger.getName())) {
                return logger;
            }
        }
        return null;
    }

    public final synchronized void setLevel(Level level2) {
        if (this.level != level2) {
            if (level2 == null) {
                if (isRootLogger()) {
                    throw new IllegalArgumentException("The level of the root logger cannot be set to null");
                }
            }
            this.level = level2;
            if (level2 == null) {
                this.effectiveLevelInt = this.parent.effectiveLevelInt;
                level2 = this.parent.getEffectiveLevel();
            } else {
                this.effectiveLevelInt = level2.levelInt;
            }
            if (this.childrenList != null) {
                int size = this.childrenList.size();
                for (int i = 0; i < size; i++) {
                    ((Logger) this.childrenList.get(i)).handleParentLevelChange(this.effectiveLevelInt);
                }
            }
            this.loggerContext.fireOnLevelChange(this, level2);
        }
    }

    private synchronized void handleParentLevelChange(int i) {
        if (this.level == null) {
            this.effectiveLevelInt = i;
            if (this.childrenList != null) {
                int size = this.childrenList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((Logger) this.childrenList.get(i2)).handleParentLevelChange(i);
                }
            }
        }
    }

    public final void detachAndStopAllAppenders() {
        if (this.aai != null) {
            this.aai.detachAndStopAllAppenders();
        }
    }

    public final boolean detachAppender(String str) {
        if (this.aai == null) {
            return false;
        }
        return this.aai.detachAppender(str);
    }

    public final synchronized void addAppender(Appender<ILoggingEvent> appender) {
        if (this.aai == null) {
            this.aai = new AppenderAttachableImpl<>();
        }
        this.aai.addAppender(appender);
    }

    public final boolean isAttached(Appender<ILoggingEvent> appender) {
        if (this.aai == null) {
            return false;
        }
        return this.aai.isAttached(appender);
    }

    public final Iterator<Appender<ILoggingEvent>> iteratorForAppenders() {
        if (this.aai == null) {
            return Collections.EMPTY_LIST.iterator();
        }
        return this.aai.iteratorForAppenders();
    }

    public final Appender<ILoggingEvent> getAppender(String str) {
        if (this.aai == null) {
            return null;
        }
        return this.aai.getAppender(str);
    }

    public final void callAppenders(ILoggingEvent iLoggingEvent) {
        int i = 0;
        for (Logger logger = this; logger != null; logger = logger.parent) {
            i += logger.appendLoopOnAppenders(iLoggingEvent);
            if (!logger.additive) {
                break;
            }
        }
        if (i == 0) {
            this.loggerContext.noAppenderDefinedWarning(this);
        }
    }

    private int appendLoopOnAppenders(ILoggingEvent iLoggingEvent) {
        if (this.aai != null) {
            return this.aai.appendLoopOnAppenders(iLoggingEvent);
        }
        return 0;
    }

    public final boolean detachAppender(Appender<ILoggingEvent> appender) {
        if (this.aai == null) {
            return false;
        }
        return this.aai.detachAppender(appender);
    }

    /* access modifiers changed from: 0000 */
    public final Logger createChildByLastNamePart(String str) {
        Logger logger;
        if (LoggerNameUtil.getFirstSeparatorIndexOf(str) != -1) {
            throw new IllegalArgumentException("Child name [" + str + " passed as parameter, may not include [.]");
        }
        if (this.childrenList == null) {
            this.childrenList = new ArrayList();
        }
        if (isRootLogger()) {
            logger = new Logger(str, this, this.loggerContext);
        } else {
            logger = new Logger(this.name + CoreConstants.DOT + str, this, this.loggerContext);
        }
        this.childrenList.add(logger);
        logger.effectiveLevelInt = this.effectiveLevelInt;
        return logger;
    }

    private void localLevelReset() {
        this.effectiveLevelInt = 10000;
        if (isRootLogger()) {
            this.level = Level.DEBUG;
        } else {
            this.level = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void recursiveReset() {
        detachAndStopAllAppenders();
        localLevelReset();
        this.additive = true;
        if (this.childrenList != null) {
            for (Logger recursiveReset : this.childrenList) {
                recursiveReset.recursiveReset();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final Logger createChildByName(String str) {
        if (LoggerNameUtil.getSeparatorIndexOf(str, this.name.length() + 1) != -1) {
            throw new IllegalArgumentException("For logger [" + this.name + "] child name [" + str + " passed as parameter, may not include '.' after index" + (this.name.length() + 1));
        }
        if (this.childrenList == null) {
            this.childrenList = new ArrayList(5);
        }
        Logger logger = new Logger(str, this, this.loggerContext);
        this.childrenList.add(logger);
        logger.effectiveLevelInt = this.effectiveLevelInt;
        return logger;
    }

    private void filterAndLog_0_Or3Plus(String str, Marker marker, Level level2, String str2, Object[] objArr, Throwable th) {
        FilterReply turboFilterChainDecision_0_3OrMore = this.loggerContext.getTurboFilterChainDecision_0_3OrMore(marker, this, level2, str2, objArr, th);
        if (turboFilterChainDecision_0_3OrMore == FilterReply.NEUTRAL) {
            if (this.effectiveLevelInt > level2.levelInt) {
                return;
            }
        } else if (turboFilterChainDecision_0_3OrMore == FilterReply.DENY) {
            return;
        }
        buildLoggingEventAndAppend(str, marker, level2, str2, objArr, th);
    }

    private void filterAndLog_1(String str, Marker marker, Level level2, String str2, Object obj, Throwable th) {
        FilterReply turboFilterChainDecision_1 = this.loggerContext.getTurboFilterChainDecision_1(marker, this, level2, str2, obj, th);
        if (turboFilterChainDecision_1 == FilterReply.NEUTRAL) {
            if (this.effectiveLevelInt > level2.levelInt) {
                return;
            }
        } else if (turboFilterChainDecision_1 == FilterReply.DENY) {
            return;
        }
        buildLoggingEventAndAppend(str, marker, level2, str2, new Object[]{obj}, th);
    }

    private void filterAndLog_2(String str, Marker marker, Level level2, String str2, Object obj, Object obj2, Throwable th) {
        FilterReply turboFilterChainDecision_2 = this.loggerContext.getTurboFilterChainDecision_2(marker, this, level2, str2, obj, obj2, th);
        if (turboFilterChainDecision_2 == FilterReply.NEUTRAL) {
            if (this.effectiveLevelInt > level2.levelInt) {
                return;
            }
        } else if (turboFilterChainDecision_2 == FilterReply.DENY) {
            return;
        }
        buildLoggingEventAndAppend(str, marker, level2, str2, new Object[]{obj, obj2}, th);
    }

    private void buildLoggingEventAndAppend(String str, Marker marker, Level level2, String str2, Object[] objArr, Throwable th) {
        LoggingEvent loggingEvent = new LoggingEvent(str, this, level2, str2, th, objArr);
        loggingEvent.setMarker(marker);
        callAppenders(loggingEvent);
    }

    public final void trace(String str) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.TRACE, str, null, null);
    }

    public final void trace(String str, Object obj) {
        filterAndLog_1(FQCN, null, Level.TRACE, str, obj, null);
    }

    public final void trace(String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, null, Level.TRACE, str, obj, obj2, null);
    }

    public final void trace(String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.TRACE, str, objArr, null);
    }

    public final void trace(String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.TRACE, str, null, th);
    }

    public final void trace(Marker marker, String str) {
        filterAndLog_0_Or3Plus(FQCN, marker, Level.TRACE, str, null, null);
    }

    public final void trace(Marker marker, String str, Object obj) {
        filterAndLog_1(FQCN, marker, Level.TRACE, str, obj, null);
    }

    public final void trace(Marker marker, String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, marker, Level.TRACE, str, obj, obj2, null);
    }

    public final void trace(Marker marker, String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, marker, Level.TRACE, str, objArr, null);
    }

    public final void trace(Marker marker, String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, marker, Level.TRACE, str, null, th);
    }

    public final boolean isDebugEnabled() {
        return isDebugEnabled(null);
    }

    public final boolean isDebugEnabled(Marker marker) {
        FilterReply callTurboFilters = callTurboFilters(marker, Level.DEBUG);
        if (callTurboFilters == FilterReply.NEUTRAL) {
            if (this.effectiveLevelInt <= 10000) {
                return true;
            }
            return false;
        } else if (callTurboFilters == FilterReply.DENY) {
            return false;
        } else {
            if (callTurboFilters == FilterReply.ACCEPT) {
                return true;
            }
            throw new IllegalStateException("Unknown FilterReply value: " + callTurboFilters);
        }
    }

    public final void debug(String str) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.DEBUG, str, null, null);
    }

    public final void debug(String str, Object obj) {
        filterAndLog_1(FQCN, null, Level.DEBUG, str, obj, null);
    }

    public final void debug(String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, null, Level.DEBUG, str, obj, obj2, null);
    }

    public final void debug(String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.DEBUG, str, objArr, null);
    }

    public final void debug(String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.DEBUG, str, null, th);
    }

    public final void debug(Marker marker, String str) {
        filterAndLog_0_Or3Plus(FQCN, marker, Level.DEBUG, str, null, null);
    }

    public final void debug(Marker marker, String str, Object obj) {
        filterAndLog_1(FQCN, marker, Level.DEBUG, str, obj, null);
    }

    public final void debug(Marker marker, String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, marker, Level.DEBUG, str, obj, obj2, null);
    }

    public final void debug(Marker marker, String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, marker, Level.DEBUG, str, objArr, null);
    }

    public final void debug(Marker marker, String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, marker, Level.DEBUG, str, null, th);
    }

    public final void error(String str) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.ERROR, str, null, null);
    }

    public final void error(String str, Object obj) {
        filterAndLog_1(FQCN, null, Level.ERROR, str, obj, null);
    }

    public final void error(String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, null, Level.ERROR, str, obj, obj2, null);
    }

    public final void error(String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.ERROR, str, objArr, null);
    }

    public final void error(String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.ERROR, str, null, th);
    }

    public final void error(Marker marker, String str) {
        filterAndLog_0_Or3Plus(FQCN, marker, Level.ERROR, str, null, null);
    }

    public final void error(Marker marker, String str, Object obj) {
        filterAndLog_1(FQCN, marker, Level.ERROR, str, obj, null);
    }

    public final void error(Marker marker, String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, marker, Level.ERROR, str, obj, obj2, null);
    }

    public final void error(Marker marker, String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, marker, Level.ERROR, str, objArr, null);
    }

    public final void error(Marker marker, String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, marker, Level.ERROR, str, null, th);
    }

    public final boolean isInfoEnabled() {
        return isInfoEnabled(null);
    }

    public final boolean isInfoEnabled(Marker marker) {
        FilterReply callTurboFilters = callTurboFilters(marker, Level.INFO);
        if (callTurboFilters == FilterReply.NEUTRAL) {
            if (this.effectiveLevelInt <= 20000) {
                return true;
            }
            return false;
        } else if (callTurboFilters == FilterReply.DENY) {
            return false;
        } else {
            if (callTurboFilters == FilterReply.ACCEPT) {
                return true;
            }
            throw new IllegalStateException("Unknown FilterReply value: " + callTurboFilters);
        }
    }

    public final void info(String str) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.INFO, str, null, null);
    }

    public final void info(String str, Object obj) {
        filterAndLog_1(FQCN, null, Level.INFO, str, obj, null);
    }

    public final void info(String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, null, Level.INFO, str, obj, obj2, null);
    }

    public final void info(String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.INFO, str, objArr, null);
    }

    public final void info(String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.INFO, str, null, th);
    }

    public final void info(Marker marker, String str) {
        filterAndLog_0_Or3Plus(FQCN, marker, Level.INFO, str, null, null);
    }

    public final void info(Marker marker, String str, Object obj) {
        filterAndLog_1(FQCN, marker, Level.INFO, str, obj, null);
    }

    public final void info(Marker marker, String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, marker, Level.INFO, str, obj, obj2, null);
    }

    public final void info(Marker marker, String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, marker, Level.INFO, str, objArr, null);
    }

    public final void info(Marker marker, String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, marker, Level.INFO, str, null, th);
    }

    public final boolean isTraceEnabled() {
        return isTraceEnabled(null);
    }

    public final boolean isTraceEnabled(Marker marker) {
        FilterReply callTurboFilters = callTurboFilters(marker, Level.TRACE);
        if (callTurboFilters == FilterReply.NEUTRAL) {
            if (this.effectiveLevelInt <= 5000) {
                return true;
            }
            return false;
        } else if (callTurboFilters == FilterReply.DENY) {
            return false;
        } else {
            if (callTurboFilters == FilterReply.ACCEPT) {
                return true;
            }
            throw new IllegalStateException("Unknown FilterReply value: " + callTurboFilters);
        }
    }

    public final boolean isErrorEnabled() {
        return isErrorEnabled(null);
    }

    public final boolean isErrorEnabled(Marker marker) {
        FilterReply callTurboFilters = callTurboFilters(marker, Level.ERROR);
        if (callTurboFilters == FilterReply.NEUTRAL) {
            if (this.effectiveLevelInt <= 40000) {
                return true;
            }
            return false;
        } else if (callTurboFilters == FilterReply.DENY) {
            return false;
        } else {
            if (callTurboFilters == FilterReply.ACCEPT) {
                return true;
            }
            throw new IllegalStateException("Unknown FilterReply value: " + callTurboFilters);
        }
    }

    public final boolean isWarnEnabled() {
        return isWarnEnabled(null);
    }

    public final boolean isWarnEnabled(Marker marker) {
        FilterReply callTurboFilters = callTurboFilters(marker, Level.WARN);
        if (callTurboFilters == FilterReply.NEUTRAL) {
            if (this.effectiveLevelInt <= 30000) {
                return true;
            }
            return false;
        } else if (callTurboFilters == FilterReply.DENY) {
            return false;
        } else {
            if (callTurboFilters == FilterReply.ACCEPT) {
                return true;
            }
            throw new IllegalStateException("Unknown FilterReply value: " + callTurboFilters);
        }
    }

    public final boolean isEnabledFor(Marker marker, Level level2) {
        FilterReply callTurboFilters = callTurboFilters(marker, level2);
        if (callTurboFilters == FilterReply.NEUTRAL) {
            if (this.effectiveLevelInt <= level2.levelInt) {
                return true;
            }
            return false;
        } else if (callTurboFilters == FilterReply.DENY) {
            return false;
        } else {
            if (callTurboFilters == FilterReply.ACCEPT) {
                return true;
            }
            throw new IllegalStateException("Unknown FilterReply value: " + callTurboFilters);
        }
    }

    public final boolean isEnabledFor(Level level2) {
        return isEnabledFor(null, level2);
    }

    public final void warn(String str) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.WARN, str, null, null);
    }

    public final void warn(String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.WARN, str, null, th);
    }

    public final void warn(String str, Object obj) {
        filterAndLog_1(FQCN, null, Level.WARN, str, obj, null);
    }

    public final void warn(String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, null, Level.WARN, str, obj, obj2, null);
    }

    public final void warn(String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, null, Level.WARN, str, objArr, null);
    }

    public final void warn(Marker marker, String str) {
        filterAndLog_0_Or3Plus(FQCN, marker, Level.WARN, str, null, null);
    }

    public final void warn(Marker marker, String str, Object obj) {
        filterAndLog_1(FQCN, marker, Level.WARN, str, obj, null);
    }

    public final void warn(Marker marker, String str, Object[] objArr) {
        filterAndLog_0_Or3Plus(FQCN, marker, Level.WARN, str, objArr, null);
    }

    public final void warn(Marker marker, String str, Object obj, Object obj2) {
        filterAndLog_2(FQCN, marker, Level.WARN, str, obj, obj2, null);
    }

    public final void warn(Marker marker, String str, Throwable th) {
        filterAndLog_0_Or3Plus(FQCN, marker, Level.WARN, str, null, th);
    }

    public final boolean isAdditive() {
        return this.additive;
    }

    public final void setAdditive(boolean z) {
        this.additive = z;
    }

    public final String toString() {
        return "Logger[" + this.name + "]";
    }

    private FilterReply callTurboFilters(Marker marker, Level level2) {
        return this.loggerContext.getTurboFilterChainDecision_0_3OrMore(marker, this, level2, null, null, null);
    }

    public final LoggerContext getLoggerContext() {
        return this.loggerContext;
    }

    public final void log(Marker marker, String str, int i, String str2, Object[] objArr, Throwable th) {
        filterAndLog_0_Or3Plus(str, marker, Level.fromLocationAwareLoggerInteger(i), str2, objArr, th);
    }

    /* access modifiers changed from: protected */
    public final Object readResolve() {
        return LoggerFactory.getLogger(getName());
    }
}
