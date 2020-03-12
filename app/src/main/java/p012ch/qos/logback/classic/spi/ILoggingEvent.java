package p012ch.qos.logback.classic.spi;

import java.util.Map;
import org.slf4j.Marker;
import p012ch.qos.logback.classic.Level;
import p012ch.qos.logback.core.spi.DeferredProcessingAware;

/* renamed from: ch.qos.logback.classic.spi.ILoggingEvent */
public interface ILoggingEvent extends DeferredProcessingAware {
    Object[] getArgumentArray();

    StackTraceElement[] getCallerData();

    String getFormattedMessage();

    Level getLevel();

    LoggerContextVO getLoggerContextVO();

    String getLoggerName();

    Map<String, String> getMDCPropertyMap();

    Marker getMarker();

    Map<String, String> getMdc();

    String getMessage();

    String getThreadName();

    IThrowableProxy getThrowableProxy();

    long getTimeStamp();

    boolean hasCallerData();

    void prepareForDeferredProcessing();
}
