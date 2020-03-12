package p012ch.qos.logback.classic.turbo;

import org.slf4j.Marker;
import p012ch.qos.logback.classic.Level;
import p012ch.qos.logback.classic.Logger;
import p012ch.qos.logback.core.spi.FilterReply;

/* renamed from: ch.qos.logback.classic.turbo.DuplicateMessageFilter */
public class DuplicateMessageFilter extends TurboFilter {
    public static final int DEFAULT_ALLOWED_REPETITIONS = 5;
    public static final int DEFAULT_CACHE_SIZE = 100;
    public int allowedRepetitions = 5;
    public int cacheSize = 100;
    private LRUMessageCache msgCache;

    public void start() {
        this.msgCache = new LRUMessageCache(this.cacheSize);
        super.start();
    }

    public void stop() {
        this.msgCache.clear();
        this.msgCache = null;
        super.stop();
    }

    public FilterReply decide(Marker marker, Logger logger, Level level, String str, Object[] objArr, Throwable th) {
        if (this.msgCache.getMessageCountAndThenIncrement(str) <= this.allowedRepetitions) {
            return FilterReply.NEUTRAL;
        }
        return FilterReply.DENY;
    }

    public int getAllowedRepetitions() {
        return this.allowedRepetitions;
    }

    public void setAllowedRepetitions(int i) {
        this.allowedRepetitions = i;
    }

    public int getCacheSize() {
        return this.cacheSize;
    }

    public void setCacheSize(int i) {
        this.cacheSize = i;
    }
}
