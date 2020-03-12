package p012ch.qos.logback.classic.sift;

import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.core.sift.AbstractDiscriminator;

/* renamed from: ch.qos.logback.classic.sift.ContextBasedDiscriminator */
public class ContextBasedDiscriminator extends AbstractDiscriminator<ILoggingEvent> {
    private static final String KEY = "contextName";
    private String defaultValue;

    public String getDiscriminatingValue(ILoggingEvent iLoggingEvent) {
        String name = iLoggingEvent.getLoggerContextVO().getName();
        if (name == null) {
            return this.defaultValue;
        }
        return name;
    }

    public String getKey() {
        return KEY;
    }

    public void setKey(String str) {
        throw new UnsupportedOperationException("Key cannot be set. Using fixed key contextName");
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String str) {
        this.defaultValue = str;
    }
}
