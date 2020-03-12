package p012ch.qos.logback.classic.pattern;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.classic.util.LevelToSyslogSeverity;
import p012ch.qos.logback.core.net.SyslogAppenderBase;

/* renamed from: ch.qos.logback.classic.pattern.SyslogStartConverter */
public class SyslogStartConverter extends ClassicConverter {
    int facility;
    long lastTimestamp = -1;
    final String localHostName = "localhost";
    SimpleDateFormat simpleFormat;
    String timesmapStr = null;

    public void start() {
        boolean z = false;
        String firstOption = getFirstOption();
        if (firstOption == null) {
            addError("was expecting a facility string as an option");
            return;
        }
        this.facility = SyslogAppenderBase.facilityStringToint(firstOption);
        try {
            this.simpleFormat = new SimpleDateFormat("MMM dd HH:mm:ss", new DateFormatSymbols(Locale.US));
        } catch (IllegalArgumentException e) {
            addError("Could not instantiate SimpleDateFormat", e);
            z = true;
        }
        if (!z) {
            super.start();
        }
    }

    public String convert(ILoggingEvent iLoggingEvent) {
        StringBuilder sb = new StringBuilder();
        int convert = this.facility + LevelToSyslogSeverity.convert(iLoggingEvent);
        sb.append("<");
        sb.append(convert);
        sb.append(">");
        sb.append(computeTimeStampString(iLoggingEvent.getTimeStamp()));
        sb.append(' ');
        sb.append("localhost");
        sb.append(' ');
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public String computeTimeStampString(long j) {
        String str;
        synchronized (this) {
            if (j != this.lastTimestamp) {
                this.lastTimestamp = j;
                this.timesmapStr = this.simpleFormat.format(new Date(j));
            }
            str = this.timesmapStr;
        }
        return str;
    }
}
