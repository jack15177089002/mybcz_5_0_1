package p012ch.qos.logback.classic.pattern;

import java.util.Map;
import java.util.Map.Entry;
import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.classic.pattern.MDCConverter */
public class MDCConverter extends ClassicConverter {
    private String defaultValue = "";
    private String key;

    public void start() {
        String[] extractDefaultReplacement = OptionHelper.extractDefaultReplacement(getFirstOption());
        this.key = extractDefaultReplacement[0];
        if (extractDefaultReplacement[1] != null) {
            this.defaultValue = extractDefaultReplacement[1];
        }
        super.start();
    }

    public void stop() {
        this.key = null;
        super.stop();
    }

    public String convert(ILoggingEvent iLoggingEvent) {
        Map mDCPropertyMap = iLoggingEvent.getMDCPropertyMap();
        if (mDCPropertyMap == null) {
            return this.defaultValue;
        }
        if (this.key == null) {
            return outputMDCForAllKeys(mDCPropertyMap);
        }
        String str = (String) iLoggingEvent.getMDCPropertyMap().get(this.key);
        return str == null ? this.defaultValue : str;
    }

    private String outputMDCForAllKeys(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Entry entry : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append((String) entry.getKey()).append('=').append((String) entry.getValue());
        }
        return sb.toString();
    }
}
