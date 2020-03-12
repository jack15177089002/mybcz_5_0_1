package p012ch.qos.logback.classic.turbo;

import org.slf4j.MDC;
import org.slf4j.Marker;
import p012ch.qos.logback.classic.Level;
import p012ch.qos.logback.classic.Logger;
import p012ch.qos.logback.core.spi.FilterReply;

/* renamed from: ch.qos.logback.classic.turbo.MDCFilter */
public class MDCFilter extends MatchingFilter {
    String MDCKey;
    String value;

    public FilterReply decide(Marker marker, Logger logger, Level level, String str, Object[] objArr, Throwable th) {
        if (this.MDCKey == null) {
            return FilterReply.NEUTRAL;
        }
        if (this.value.equals(MDC.get(this.MDCKey))) {
            return this.onMatch;
        }
        return this.onMismatch;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public void setMDCKey(String str) {
        this.MDCKey = str;
    }
}
