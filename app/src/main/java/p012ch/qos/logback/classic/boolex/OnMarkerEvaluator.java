package p012ch.qos.logback.classic.boolex;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Marker;
import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.core.boolex.EventEvaluatorBase;

/* renamed from: ch.qos.logback.classic.boolex.OnMarkerEvaluator */
public class OnMarkerEvaluator extends EventEvaluatorBase<ILoggingEvent> {
    List<String> markerList = new ArrayList();

    public void addMarker(String str) {
        this.markerList.add(str);
    }

    public boolean evaluate(ILoggingEvent iLoggingEvent) {
        Marker marker = iLoggingEvent.getMarker();
        if (marker == null) {
            return false;
        }
        for (String contains : this.markerList) {
            if (marker.contains(contains)) {
                return true;
            }
        }
        return false;
    }
}
