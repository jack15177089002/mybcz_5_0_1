package p012ch.qos.logback.classic.selector;

import java.util.List;
import p012ch.qos.logback.classic.LoggerContext;

/* renamed from: ch.qos.logback.classic.selector.ContextSelector */
public interface ContextSelector {
    LoggerContext detachLoggerContext(String str);

    List<String> getContextNames();

    LoggerContext getDefaultLoggerContext();

    LoggerContext getLoggerContext();

    LoggerContext getLoggerContext(String str);
}
