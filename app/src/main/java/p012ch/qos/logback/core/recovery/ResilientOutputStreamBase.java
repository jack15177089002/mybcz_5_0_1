package p012ch.qos.logback.core.recovery;

import java.io.IOException;
import java.io.OutputStream;
import p012ch.qos.logback.core.Context;
import p012ch.qos.logback.core.status.ErrorStatus;
import p012ch.qos.logback.core.status.InfoStatus;
import p012ch.qos.logback.core.status.Status;
import p012ch.qos.logback.core.status.StatusManager;

/* renamed from: ch.qos.logback.core.recovery.ResilientOutputStreamBase */
public abstract class ResilientOutputStreamBase extends OutputStream {
    static final int STATUS_COUNT_LIMIT = 8;
    private Context context;
    private int noContextWarning = 0;

    /* renamed from: os */
    protected OutputStream f1667os;
    protected boolean presumedClean = true;
    private RecoveryCoordinator recoveryCoordinator;
    private int statusCount = 0;

    /* access modifiers changed from: 0000 */
    public abstract String getDescription();

    /* access modifiers changed from: 0000 */
    public abstract OutputStream openNewOutputStream();

    private boolean isPresumedInError() {
        return this.recoveryCoordinator != null && !this.presumedClean;
    }

    public void write(byte[] bArr, int i, int i2) {
        if (!isPresumedInError()) {
            try {
                this.f1667os.write(bArr, i, i2);
                postSuccessfulWrite();
            } catch (IOException e) {
                postIOFailure(e);
            }
        } else if (!this.recoveryCoordinator.isTooSoon()) {
            attemptRecovery();
        }
    }

    public void write(int i) {
        if (!isPresumedInError()) {
            try {
                this.f1667os.write(i);
                postSuccessfulWrite();
            } catch (IOException e) {
                postIOFailure(e);
            }
        } else if (!this.recoveryCoordinator.isTooSoon()) {
            attemptRecovery();
        }
    }

    public void flush() {
        if (this.f1667os != null) {
            try {
                this.f1667os.flush();
                postSuccessfulWrite();
            } catch (IOException e) {
                postIOFailure(e);
            }
        }
    }

    private void postSuccessfulWrite() {
        if (this.recoveryCoordinator != null) {
            this.recoveryCoordinator = null;
            this.statusCount = 0;
            addStatus(new InfoStatus("Recovered from IO failure on " + getDescription(), this));
        }
    }

    /* access modifiers changed from: 0000 */
    public void postIOFailure(IOException iOException) {
        addStatusIfCountNotOverLimit(new ErrorStatus("IO failure while writing to " + getDescription(), this, iOException));
        this.presumedClean = false;
        if (this.recoveryCoordinator == null) {
            this.recoveryCoordinator = new RecoveryCoordinator();
        }
    }

    public void close() {
        if (this.f1667os != null) {
            this.f1667os.close();
        }
    }

    /* access modifiers changed from: 0000 */
    public void attemptRecovery() {
        try {
            close();
        } catch (IOException e) {
        }
        addStatusIfCountNotOverLimit(new InfoStatus("Attempting to recover from IO failure on " + getDescription(), this));
        try {
            this.f1667os = openNewOutputStream();
            this.presumedClean = true;
        } catch (IOException e2) {
            addStatusIfCountNotOverLimit(new ErrorStatus("Failed to open " + getDescription(), this, e2));
        }
    }

    /* access modifiers changed from: 0000 */
    public void addStatusIfCountNotOverLimit(Status status) {
        this.statusCount++;
        if (this.statusCount < 8) {
            addStatus(status);
        }
        if (this.statusCount == 8) {
            addStatus(status);
            addStatus(new InfoStatus("Will supress future messages regarding " + getDescription(), this));
        }
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

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context2) {
        this.context = context2;
    }
}
