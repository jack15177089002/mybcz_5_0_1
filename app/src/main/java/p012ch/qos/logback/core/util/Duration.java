package p012ch.qos.logback.core.util;

//import com.tencent.android.tpush.common.MessageKey;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ch.qos.logback.core.util.Duration */
public class Duration {
    static final long DAYS_COEFFICIENT = 86400000;
    private static final int DOUBLE_GROUP = 1;
    private static final String DOUBLE_PART = "([0-9]*(.[0-9]+)?)";
    private static final Pattern DURATION_PATTERN = Pattern.compile("([0-9]*(.[0-9]+)?)\\s*(|milli(second)?|second(e)?|minute|hour|day)s?", 2);
    static final long HOURS_COEFFICIENT = 3600000;
    static final long MINUTES_COEFFICIENT = 60000;
    static final long SECONDS_COEFFICIENT = 1000;
    private static final int UNIT_GROUP = 3;
    private static final String UNIT_PART = "(|milli(second)?|second(e)?|minute|hour|day)s?";
    final long millis;

    public Duration(long j) {
        this.millis = j;
    }

    public static Duration buildByMilliseconds(double d) {
        return new Duration((long) d);
    }

    public static Duration buildBySeconds(double d) {
        return new Duration((long) (1000.0d * d));
    }

    public static Duration buildByMinutes(double d) {
        return new Duration((long) (60000.0d * d));
    }

    public static Duration buildByHours(double d) {
        return new Duration((long) (3600000.0d * d));
    }

    public static Duration buildByDays(double d) {
        return new Duration((long) (8.64E7d * d));
    }

    public static Duration buildUnbounded() {
        return new Duration(Long.MAX_VALUE);
    }

    public long getMilliseconds() {
        return this.millis;
    }

    public static Duration valueOf(String str) {
        Matcher matcher = DURATION_PATTERN.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            String group2 = matcher.group(3);
            double doubleValue = Double.valueOf(group).doubleValue();
            if (group2.equalsIgnoreCase("milli") || group2.equalsIgnoreCase("millisecond") || group2.length() == 0) {
                return buildByMilliseconds(doubleValue);
            }
            if (group2.equalsIgnoreCase("second") || group2.equalsIgnoreCase("seconde")) {
                return buildBySeconds(doubleValue);
            }
            if (group2.equalsIgnoreCase("minute")) {
                return buildByMinutes(doubleValue);
            }
//            if (group2.equalsIgnoreCase(MessageKey.MSG_ACCEPT_TIME_HOUR)) {
//                return buildByHours(doubleValue);
//            }
            if (group2.equalsIgnoreCase("day")) {
                return buildByDays(doubleValue);
            }
            throw new IllegalStateException("Unexpected " + group2);
        }
        throw new IllegalArgumentException("String value [" + str + "] is not in the expected format.");
    }

    public String toString() {
        if (this.millis < 1000) {
            return this.millis + " milliseconds";
        }
        if (this.millis < 60000) {
            return new StringBuilder(String.valueOf(this.millis / 1000)).append(" seconds").toString();
        }
        if (this.millis < 3600000) {
            return new StringBuilder(String.valueOf(this.millis / 60000)).append(" minutes").toString();
        }
        return new StringBuilder(String.valueOf(this.millis / 3600000)).append(" hours").toString();
    }
}
