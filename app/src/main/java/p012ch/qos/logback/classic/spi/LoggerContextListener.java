package p012ch.qos.logback.classic.spi;

import p012ch.qos.logback.classic.Level;
import p012ch.qos.logback.classic.Logger;
import p012ch.qos.logback.classic.LoggerContext;

/* renamed from: ch.qos.logback.classic.spi.LoggerContextListener */
public interface LoggerContextListener {
    boolean isResetResistant();

    void onLevelChange(Logger logger, Level level);

    void onReset(LoggerContext loggerContext);

    void onStart(LoggerContext loggerContext);

    void onStop(LoggerContext loggerContext);
}
