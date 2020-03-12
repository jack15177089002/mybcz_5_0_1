package p012ch.qos.logback.classic.pattern;

import java.util.List;
import java.util.TimeZone;
import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.util.CachingDateFormatter;

/* renamed from: ch.qos.logback.classic.pattern.DateConverter */
public class DateConverter extends ClassicConverter {
    CachingDateFormatter cachingDateFormatter = null;
    long lastTimestamp = -1;
    String timestampStrCache = null;

    public void start() {
        String str;
        String firstOption = getFirstOption();
        if (firstOption == null) {
            firstOption = CoreConstants.ISO8601_PATTERN;
        }
        if (firstOption.equals(CoreConstants.ISO8601_STR)) {
            str = CoreConstants.ISO8601_PATTERN;
        } else {
            str = firstOption;
        }
        try {
            this.cachingDateFormatter = new CachingDateFormatter(str);
        } catch (IllegalArgumentException e) {
            addWarn("Could not instantiate SimpleDateFormat with pattern " + str, e);
            this.cachingDateFormatter = new CachingDateFormatter(CoreConstants.ISO8601_PATTERN);
        }
        List optionList = getOptionList();
        if (optionList != null && optionList.size() > 1) {
            this.cachingDateFormatter.setTimeZone(TimeZone.getTimeZone((String) optionList.get(1)));
        }
    }

    public String convert(ILoggingEvent iLoggingEvent) {
        return this.cachingDateFormatter.format(iLoggingEvent.getTimeStamp());
    }
}
