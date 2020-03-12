package p012ch.qos.logback.core;

import java.util.HashSet;
import java.util.Set;
import p012ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.LifeCycleManager */
public class LifeCycleManager {
    private final Set<LifeCycle> components = new HashSet();

    public void register(LifeCycle lifeCycle) {
        this.components.add(lifeCycle);
    }

    public void reset() {
        for (LifeCycle lifeCycle : this.components) {
            if (lifeCycle.isStarted()) {
                lifeCycle.stop();
            }
        }
        this.components.clear();
    }
}
