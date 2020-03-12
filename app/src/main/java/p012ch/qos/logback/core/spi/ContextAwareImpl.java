package p012ch.qos.logback.core.spi;

import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.status.ErrorStatus;
import p012ch.qos.logback.core.status.InfoStatus;
import p012ch.qos.logback.core.status.Status;
import p012ch.qos.logback.core.status.StatusManager;
import p012ch.qos.logback.core.status.WarnStatus;

/* renamed from: ch.qos.logback.core.spi.ContextAwareImpl */
public class ContextAwareImpl implements ContextAware {
    protected Context context;
    private int noContextWarning = 0;
    final Object origin;

    public ContextAwareImpl(Context context2, Object obj) {
        this.context = context2;
        this.origin = obj;
    }

    public Object getOrigin() {
        return this.origin;
    }

    public void setContext(Context context2) {
        if (this.context == null) {
            this.context = context2;
        } else if (this.context != context2) {
            throw new IllegalStateException("Context has been already set");
        }
    }

    public Context getContext() {
        return this.context;
    }

    public StatusManager getStatusManager() {
        if (this.context == null) {
            return null;
        }
        return this.context.getStatusManager();
    }

    public void addStatus(Status status) {
        if (this.context == null) {
            int i = this.noContextWarning;
            this.noContextWarning = i + 1;
            if (i == 0) {
                System.out.println("LOGBACK: No context given for " + this);
                return;
            }
            return;
        }
        StatusManager statusManager = this.context.getStatusManager();
        if (statusManager != null) {
            statusManager.add(status);
        }
    }

    public void addInfo(String str) {
        addStatus(new InfoStatus(str, getOrigin()));
    }

    public void addInfo(String str, Throwable th) {
        addStatus(new InfoStatus(str, getOrigin(), th));
    }

    public void addWarn(String str) {
        addStatus(new WarnStatus(str, getOrigin()));
    }

    public void addWarn(String str, Throwable th) {
        addStatus(new WarnStatus(str, getOrigin(), th));
    }

    public void addError(String str) {
        addStatus(new ErrorStatus(str, getOrigin()));
    }

    public void addError(String str, Throwable th) {
        addStatus(new ErrorStatus(str, getOrigin(), th));
    }
}
