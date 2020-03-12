package p012ch.qos.logback.core.rolling.helper;

import java.util.Date;
import p012ch.qos.logback.core.spi.ContextAware;

/* renamed from: ch.qos.logback.core.rolling.helper.ArchiveRemover */
public interface ArchiveRemover extends ContextAware {
    void clean(Date date);

    void setMaxHistory(int i);
}
