package p012ch.qos.logback.core.spi;

import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.status.ErrorStatus;
import p012ch.qos.logback.core.status.InfoStatus;
import p012ch.qos.logback.core.status.Status;
import p012ch.qos.logback.core.status.StatusManager;
import p012ch.qos.logback.core.status.WarnStatus;

/* renamed from: ch.qos.logback.core.spi.ContextAwareBase */
public class ContextAwareBase implements ContextAware {
    public Context context;
    final Object declaredOrigin;
    private int noContextWarning;

    public ContextAwareBase() {
        this.noContextWarning = 0;
        this.declaredOrigin = this;
    }

    public ContextAwareBase(ContextAware contextAware) {
        this.noContextWarning = 0;
        this.declaredOrigin = contextAware;
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

    /* access modifiers changed from: protected */
    public Object getDeclaredOrigin() {
        return this.declaredOrigin;
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
        addStatus(new InfoStatus(str, getDeclaredOrigin()));
    }

    public void addInfo(String str, Throwable th) {
        addStatus(new InfoStatus(str, getDeclaredOrigin(), th));
    }

    public void addWarn(String str) {
        addStatus(new WarnStatus(str, getDeclaredOrigin()));
    }

    public void addWarn(String str, Throwable th) {
        addStatus(new WarnStatus(str, getDeclaredOrigin(), th));
    }

    public void addError(String str) {
        addStatus(new ErrorStatus(str, getDeclaredOrigin()));
    }

    public void addError(String str, Throwable th) {
        addStatus(new ErrorStatus(str, getDeclaredOrigin(), th));
    }
}
