package p012ch.qos.logback.classic.pattern;

import p012ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.PropertyConverter */
public final class PropertyConverter extends ClassicConverter {
    String key;

    public final void start() {
        String firstOption = getFirstOption();
        if (firstOption != null) {
            this.key = firstOption;
            super.start();
        }
    }

    public final String convert(ILoggingEvent iLoggingEvent) {
        if (this.key == null) {
            return "Property_HAS_NO_KEY";
        }
        String str = (String) iLoggingEvent.getLoggerContextVO().getPropertyMap().get(this.key);
        return str == null ? System.getProperty(this.key) : str;
    }
}
