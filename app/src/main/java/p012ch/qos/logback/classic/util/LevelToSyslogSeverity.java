package p012ch.qos.logback.classic.util;

import p012ch.qos.logback.classic.Level;
import p012ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.util.LevelToSyslogSeverity */
public class LevelToSyslogSeverity {
    public static int convert(ILoggingEvent iLoggingEvent) {
        Level level = iLoggingEvent.getLevel();
        switch (level.levelInt) {
            case 5000:
            case 10000:
                return 7;
            case 20000:
                return 6;
            case 30000:
                return 4;
            case Level.ERROR_INT /*40000*/:
                return 3;
            default:
                throw new IllegalArgumentException("Level " + level + " is not a valid level for a printing method");
        }
    }
}
