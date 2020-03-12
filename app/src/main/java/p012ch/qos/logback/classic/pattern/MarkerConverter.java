package p012ch.qos.logback.classic.pattern;

import org.slf4j.Marker;
import p012ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.MarkerConverter */
public class MarkerConverter extends ClassicConverter {
    private static String EMPTY = "";

    public String convert(ILoggingEvent iLoggingEvent) {
        Marker marker = iLoggingEvent.getMarker();
        if (marker == null) {
            return EMPTY;
        }
        return marker.toString();
    }
}
