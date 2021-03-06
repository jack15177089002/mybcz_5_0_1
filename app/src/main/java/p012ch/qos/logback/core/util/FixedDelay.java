package p012ch.qos.logback.core.util;

/* renamed from: ch.qos.logback.core.util.FixedDelay */
public class FixedDelay implements DelayStrategy {
    private long nextDelay;
    private final long subsequentDelay;

    public FixedDelay(long j, long j2) {
        new String();
        this.nextDelay = j;
        this.subsequentDelay = j2;
    }

    public FixedDelay(int i) {
        this((long) i, (long) i);
    }

    public long nextDelay() {
        long j = this.nextDelay;
        this.nextDelay = this.subsequentDelay;
        return j;
    }
}
