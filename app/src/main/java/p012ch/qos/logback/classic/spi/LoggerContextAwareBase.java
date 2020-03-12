package p012ch.qos.logback.classic.spi;

import p012ch.qos.logback.classic.LoggerContext;
import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.classic.spi.LoggerContextAwareBase */
public class LoggerContextAwareBase extends ContextAwareBase implements LoggerContextAware {
    public void setLoggerContext(LoggerContext loggerContext) {
        super.setContext(loggerContext);
    }

    public void setContext(Context context) {
        if ((context instanceof LoggerContext) || context == null) {
            super.setContext(context);
            return;
        }
        throw new IllegalArgumentException("LoggerContextAwareBase only accepts contexts of type c.l.classic.LoggerContext");
    }

    public LoggerContext getLoggerContext() {
        return (LoggerContext) this.context;
    }
}
