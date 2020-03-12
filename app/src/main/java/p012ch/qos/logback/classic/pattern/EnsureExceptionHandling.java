package p012ch.qos.logback.classic.pattern;

import p012ch.qos.logback.classic.spi.ILoggingEvent;
import p012ch.qos.logback.core.pattern.Converter;
import p012ch.qos.logback.core.pattern.ConverterUtil;
import p012ch.qos.logback.core.pattern.PostCompileProcessor;

/* renamed from: ch.qos.logback.classic.pattern.EnsureExceptionHandling */
public class EnsureExceptionHandling implements PostCompileProcessor<ILoggingEvent> {
    public void process(Converter<ILoggingEvent> converter) {
        if (converter == null) {
            throw new IllegalArgumentException("cannot process empty chain");
        } else if (!chainHandlesThrowable(converter)) {
            ConverterUtil.findTail(converter).setNext(new ExtendedThrowableProxyConverter());
        }
    }

    public boolean chainHandlesThrowable(Converter converter) {
        while (converter != null) {
            if (converter instanceof ThrowableHandlingConverter) {
                return true;
            }
            converter = converter.getNext();
        }
        return false;
    }
}
