package p012ch.qos.logback.classic.spi;

import p012ch.qos.logback.classic.LoggerContext;
import p012ch.qos.logback.core.spi.ContextAware;

/* renamed from: ch.qos.logback.classic.spi.LoggerContextAware */
public interface LoggerContextAware extends ContextAware {
    void setLoggerContext(LoggerContext loggerContext);
}
