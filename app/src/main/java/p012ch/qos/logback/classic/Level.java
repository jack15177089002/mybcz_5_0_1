package p012ch.qos.logback.classic;

import java.io.Serializable;

/* renamed from: ch.qos.logback.classic.Level */
public final class Level implements Serializable {
    public static final int ALL_INT = Integer.MIN_VALUE;
    public static final Level ALL = new Level(ALL_INT, "ALL");
    public static final Integer ALL_INTEGER = Integer.valueOf(ALL_INT);
    public static final Level DEBUG = new Level(10000, "DEBUG");
    public static final int DEBUG_INT = 10000;
    public static final Integer DEBUG_INTEGER = Integer.valueOf(10000);
    public static final int ERROR_INT = 40000;
    public static final Level ERROR = new Level(ERROR_INT, "ERROR");
    public static final Integer ERROR_INTEGER = Integer.valueOf(ERROR_INT);
    public static final Level INFO = new Level(20000, "INFO");
    public static final int INFO_INT = 20000;
    public static final Integer INFO_INTEGER = Integer.valueOf(20000);
    public static final Level OFF = new Level(Integer.MAX_VALUE, "OFF");
    public static final int OFF_INT = Integer.MAX_VALUE;
    public static final Integer OFF_INTEGER = Integer.valueOf(Integer.MAX_VALUE);
    public static final Level TRACE = new Level(5000, "TRACE");
    public static final int TRACE_INT = 5000;
    public static final Integer TRACE_INTEGER = Integer.valueOf(5000);
    public static final Level WARN = new Level(30000, "WARN");
    public static final int WARN_INT = 30000;
    public static final Integer WARN_INTEGER = Integer.valueOf(30000);
    private static final long serialVersionUID = -814092767334282137L;
    public final int levelInt;
    public final String levelStr;

    private Level(int i, String str) {
        this.levelInt = i;
        this.levelStr = str;
    }

    public final String toString() {
        return this.levelStr;
    }

    public final int toInt() {
        return this.levelInt;
    }

    public final Integer toInteger() {
        switch (this.levelInt) {
            case ALL_INT /*-2147483648*/:
                return ALL_INTEGER;
            case 5000:
                return TRACE_INTEGER;
            case 10000:
                return DEBUG_INTEGER;
            case 20000:
                return INFO_INTEGER;
            case 30000:
                return WARN_INTEGER;
            case ERROR_INT /*40000*/:
                return ERROR_INTEGER;
            case Integer.MAX_VALUE:
                return OFF_INTEGER;
            default:
                throw new IllegalStateException("Level " + this.levelStr + ", " + this.levelInt + " is unknown.");
        }
    }

    public final boolean isGreaterOrEqual(Level level) {
        return this.levelInt >= level.levelInt;
    }

    public static Level toLevel(String str) {
        return toLevel(str, DEBUG);
    }

    public static Level valueOf(String str) {
        return toLevel(str, DEBUG);
    }

    public static Level toLevel(int i) {
        return toLevel(i, DEBUG);
    }

    public static Level toLevel(int i, Level level) {
        switch (i) {
            case ALL_INT /*-2147483648*/:
                return ALL;
            case 5000:
                return TRACE;
            case 10000:
                return DEBUG;
            case 20000:
                return INFO;
            case 30000:
                return WARN;
            case ERROR_INT /*40000*/:
                return ERROR;
            case Integer.MAX_VALUE:
                return OFF;
            default:
                return level;
        }
    }

    public static Level toLevel(String str, Level level) {
        if (str == null) {
            return level;
        }
        if (str.equalsIgnoreCase("ALL")) {
            return ALL;
        }
        if (str.equalsIgnoreCase("TRACE")) {
            return TRACE;
        }
        if (str.equalsIgnoreCase("DEBUG")) {
            return DEBUG;
        }
        if (str.equalsIgnoreCase("INFO")) {
            return INFO;
        }
        if (str.equalsIgnoreCase("WARN")) {
            return WARN;
        }
        if (str.equalsIgnoreCase("ERROR")) {
            return ERROR;
        }
        if (str.equalsIgnoreCase("OFF")) {
            return OFF;
        }
        return level;
    }

    private Object readResolve() {
        return toLevel(this.levelInt);
    }

    public static Level fromLocationAwareLoggerInteger(int i) {
        switch (i) {
            case 0:
                return TRACE;
            case 10:
                return DEBUG;
            case 20:
                return INFO;
            case 30:
                return WARN;
            case 40:
                return ERROR;
            default:
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(i)).append(" not a valid level value").toString());
        }
    }

    public static int toLocationAwareLoggerInteger(Level level) {
        if (level == null) {
            throw new IllegalArgumentException("null level parameter is not admitted");
        }
        switch (level.toInt()) {
            case 5000:
                return 0;
            case 10000:
                return 10;
            case 20000:
                return 20;
            case 30000:
                return 30;
            case ERROR_INT /*40000*/:
                return 40;
            default:
                throw new IllegalArgumentException(level + " not a valid level value");
        }
    }
}
