package p012ch.qos.logback.core.rolling;

import p012ch.qos.logback.core.FileAppender;
import p012ch.qos.logback.core.rolling.helper.CompressionMode;
import p012ch.qos.logback.core.rolling.helper.FileNamePattern;
import p012ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.rolling.RollingPolicyBase */
public abstract class RollingPolicyBase extends ContextAwareBase implements RollingPolicy {
    protected CompressionMode compressionMode = CompressionMode.NONE;
    FileNamePattern fileNamePattern;
    protected String fileNamePatternStr;
    private FileAppender parent;
    private boolean started;
    FileNamePattern zipEntryFileNamePattern;

    /* access modifiers changed from: protected */
    public void determineCompressionMode() {
        if (this.fileNamePatternStr.endsWith(".gz")) {
            addInfo("Will use gz compression");
            this.compressionMode = CompressionMode.GZ;
        } else if (this.fileNamePatternStr.endsWith(".zip")) {
            addInfo("Will use zip compression");
            this.compressionMode = CompressionMode.ZIP;
        } else {
            addInfo("No compression will be used");
            this.compressionMode = CompressionMode.NONE;
        }
    }

    public void setFileNamePattern(String str) {
        this.fileNamePatternStr = str;
    }

    public String getFileNamePattern() {
        return this.fileNamePatternStr;
    }

    public CompressionMode getCompressionMode() {
        return this.compressionMode;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void start() {
        this.started = true;
    }

    public void stop() {
        this.started = false;
    }

    public void setParent(FileAppender fileAppender) {
        this.parent = fileAppender;
    }

    public boolean isParentPrudent() {
        return this.parent.isPrudent();
    }

    public String getParentsRawFileProperty() {
        return this.parent.rawFileProperty();
    }
}
