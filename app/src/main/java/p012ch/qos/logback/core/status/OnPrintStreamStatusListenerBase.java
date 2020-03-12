package p012ch.qos.logback.core.status;

import java.io.PrintStream;
import p012ch.qos.logback.core.spi.ContextAwareBase;
import p012ch.qos.logback.core.spi.LifeCycle;
import p012ch.qos.logback.core.util.StatusPrinter;

/* renamed from: ch.qos.logback.core.status.OnPrintStreamStatusListenerBase */
abstract class OnPrintStreamStatusListenerBase extends ContextAwareBase implements LifeCycle, StatusListener {
    static final long DEFAULT_RETROSPECTIVE = 300;
    boolean isStarted = false;
    long retrospective = DEFAULT_RETROSPECTIVE;

    /* access modifiers changed from: protected */
    public abstract PrintStream getPrintStream();

    OnPrintStreamStatusListenerBase() {
    }

    private void print(Status status) {
        StringBuilder sb = new StringBuilder();
        StatusPrinter.buildStr(sb, "", status);
        getPrintStream().print(sb);
    }

    public void addStatusEvent(Status status) {
        if (this.isStarted) {
            print(status);
        }
    }

    private void retrospectivePrint() {
        if (this.context != null) {
            long currentTimeMillis = System.currentTimeMillis();
            for (Status status : this.context.getStatusManager().getCopyOfStatusList()) {
                if (currentTimeMillis - status.getDate().longValue() < this.retrospective) {
                    print(status);
                }
            }
        }
    }

    public void start() {
        this.isStarted = true;
        if (this.retrospective > 0) {
            retrospectivePrint();
        }
    }

    public void setRetrospective(long j) {
        this.retrospective = j;
    }

    public long getRetrospective() {
        return this.retrospective;
    }

    public void stop() {
        this.isStarted = false;
    }

    public boolean isStarted() {
        return this.isStarted;
    }
}
