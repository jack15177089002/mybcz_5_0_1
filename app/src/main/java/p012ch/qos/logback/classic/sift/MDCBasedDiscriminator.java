package p012ch.qos.logback.classic.sift;

import java.util.Map;
import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.core.sift.AbstractDiscriminator;
import p012ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.classic.sift.MDCBasedDiscriminator */
public class MDCBasedDiscriminator extends AbstractDiscriminator<ILoggingEvent> {
    private String defaultValue;
    private String key;

    public String getDiscriminatingValue(ILoggingEvent iLoggingEvent) {
        Map mDCPropertyMap = iLoggingEvent.getMDCPropertyMap();
        if (mDCPropertyMap == null) {
            return this.defaultValue;
        }
        String str = (String) mDCPropertyMap.get(this.key);
        if (str == null) {
            return this.defaultValue;
        }
        return str;
    }

    public void start() {
        int i = 0;
        if (OptionHelper.isEmpty(this.key)) {
            addError("The \"Key\" property must be set");
            i = 1;
        }
        if (OptionHelper.isEmpty(this.defaultValue)) {
            i++;
            addError("The \"DefaultValue\" property must be set");
        }
        if (i == 0) {
            this.started = true;
        }
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String str) {
        this.defaultValue = str;
    }
}
