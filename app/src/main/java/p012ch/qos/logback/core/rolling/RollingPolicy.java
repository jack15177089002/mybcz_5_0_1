package p012ch.qos.logback.core.rolling;

import p012ch.qos.logback.core.FileAppender;
import p012ch.qos.logback.core.rolling.helper.CompressionMode;
import p012ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.rolling.RollingPolicy */
public interface RollingPolicy extends LifeCycle {
    String getActiveFileName();

    CompressionMode getCompressionMode();

    void rollover();

    void setParent(FileAppender fileAppender);
}
