package p012ch.qos.logback.classic.sift;

import org.slf4j.Marker;
import p012ch.qos.logback.classic.ClassicConstants;
import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.core.joran.spi.DefaultClass;
import p012ch.qos.logback.core.sift.Discriminator;
import p012ch.qos.logback.core.sift.SiftingAppenderBase;

/* renamed from: ch.qos.logback.classic.sift.SiftingAppender */
public class SiftingAppender extends SiftingAppenderBase<ILoggingEvent> {
    /* access modifiers changed from: protected */
    public long getTimestamp(ILoggingEvent iLoggingEvent) {
        return iLoggingEvent.getTimeStamp();
    }

    @DefaultClass(MDCBasedDiscriminator.class)
    public void setDiscriminator(Discriminator<ILoggingEvent> discriminator) {
        super.setDiscriminator(discriminator);
    }

    /* access modifiers changed from: protected */
    public boolean eventMarksEndOfLife(ILoggingEvent iLoggingEvent) {
        Marker marker = iLoggingEvent.getMarker();
        if (marker == null) {
            return false;
        }
        return marker.contains(ClassicConstants.FINALIZE_SESSION_MARKER);
    }
}
