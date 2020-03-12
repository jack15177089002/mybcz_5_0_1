package p012ch.qos.logback.classic.turbo;

import org.slf4j.Marker;
import p012ch.qos.logback.classic.Level;
import p012ch.qos.logback.classic.Logger;
import p012ch.qos.logback.core.spi.ContextAwareBase;
import p012ch.qos.logback.core.spi.FilterReply;
import p012ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.classic.turbo.TurboFilter */
public abstract class TurboFilter extends ContextAwareBase implements LifeCycle {
    private String name;
    boolean start = false;

    public abstract FilterReply decide(Marker marker, Logger logger, Level level, String str, Object[] objArr, Throwable th);

    public void start() {
        this.start = true;
    }

    public boolean isStarted() {
        return this.start;
    }

    public void stop() {
        this.start = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
