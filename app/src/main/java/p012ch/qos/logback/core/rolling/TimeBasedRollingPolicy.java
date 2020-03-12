package p012ch.qos.logback.core.rolling;

import java.io.File;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.rolling.helper.ArchiveRemover;
import p012ch.qos.logback.core.rolling.helper.AsynchronousCompressor;
import p012ch.qos.logback.core.rolling.helper.CompressionMode;
import p012ch.qos.logback.core.rolling.helper.Compressor;
import p012ch.qos.logback.core.rolling.helper.FileFilterUtil;
import p012ch.qos.logback.core.rolling.helper.FileNamePattern;
import p012ch.qos.logback.core.rolling.helper.RenameUtil;

/* renamed from: ch.qos.logback.core.rolling.TimeBasedRollingPolicy */
public class TimeBasedRollingPolicy<E> extends RollingPolicyBase implements TriggeringPolicy<E> {
    static final String FNP_NOT_SET = "The FileNamePattern option must be set before using TimeBasedRollingPolicy. ";
    static final int INFINITE_HISTORY = 0;
    private ArchiveRemover archiveRemover;
    boolean cleanHistoryOnStart = false;
    private Compressor compressor;
    FileNamePattern fileNamePatternWCS;
    Future<?> future;
    private int maxHistory = 0;
    private RenameUtil renameUtil = new RenameUtil();
    TimeBasedFileNamingAndTriggeringPolicy<E> timeBasedFileNamingAndTriggeringPolicy;

    public void start() {
        this.renameUtil.setContext(this.context);
        if (this.fileNamePatternStr != null) {
            this.fileNamePattern = new FileNamePattern(this.fileNamePatternStr, this.context);
            determineCompressionMode();
            this.compressor = new Compressor(this.compressionMode);
            this.compressor.setContext(this.context);
            this.fileNamePatternWCS = new FileNamePattern(Compressor.computeFileNameStr_WCS(this.fileNamePatternStr, this.compressionMode), this.context);
            addInfo("Will use the pattern " + this.fileNamePatternWCS + " for the active file");
            if (this.compressionMode == CompressionMode.ZIP) {
                this.zipEntryFileNamePattern = new FileNamePattern(transformFileNamePattern2ZipEntry(this.fileNamePatternStr), this.context);
            }
            if (this.timeBasedFileNamingAndTriggeringPolicy == null) {
                this.timeBasedFileNamingAndTriggeringPolicy = new DefaultTimeBasedFileNamingAndTriggeringPolicy();
            }
            this.timeBasedFileNamingAndTriggeringPolicy.setContext(this.context);
            this.timeBasedFileNamingAndTriggeringPolicy.setTimeBasedRollingPolicy(this);
            this.timeBasedFileNamingAndTriggeringPolicy.start();
            if (this.maxHistory != 0) {
                this.archiveRemover = this.timeBasedFileNamingAndTriggeringPolicy.getArchiveRemover();
                this.archiveRemover.setMaxHistory(this.maxHistory);
                if (this.cleanHistoryOnStart) {
                    addInfo("Cleaning on start up");
                    this.archiveRemover.clean(new Date(this.timeBasedFileNamingAndTriggeringPolicy.getCurrentTime()));
                }
            }
            super.start();
            return;
        }
        addWarn(FNP_NOT_SET);
        addWarn(CoreConstants.SEE_FNP_NOT_SET);
        throw new IllegalStateException("The FileNamePattern option must be set before using TimeBasedRollingPolicy. See also http://logback.qos.ch/codes.html#tbr_fnp_not_set");
    }

    public void stop() {
        if (isStarted()) {
            waitForAsynchronousJobToStop();
            super.stop();
        }
    }

    private void waitForAsynchronousJobToStop() {
        if (this.future != null) {
            try {
                this.future.get(30, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                addError("Timeout while waiting for compression job to finish", e);
            } catch (Exception e2) {
                addError("Unexpected exception while waiting for compression job to finish", e2);
            }
        }
    }

    private String transformFileNamePattern2ZipEntry(String str) {
        return FileFilterUtil.afterLastSlash(FileFilterUtil.slashify(str));
    }

    public void setTimeBasedFileNamingAndTriggeringPolicy(TimeBasedFileNamingAndTriggeringPolicy<E> timeBasedFileNamingAndTriggeringPolicy2) {
        this.timeBasedFileNamingAndTriggeringPolicy = timeBasedFileNamingAndTriggeringPolicy2;
    }

    public TimeBasedFileNamingAndTriggeringPolicy<E> getTimeBasedFileNamingAndTriggeringPolicy() {
        return this.timeBasedFileNamingAndTriggeringPolicy;
    }

    public void rollover() {
        String elapsedPeriodsFileName = this.timeBasedFileNamingAndTriggeringPolicy.getElapsedPeriodsFileName();
        String afterLastSlash = FileFilterUtil.afterLastSlash(elapsedPeriodsFileName);
        if (this.compressionMode == CompressionMode.NONE) {
            if (getParentsRawFileProperty() != null) {
                this.renameUtil.rename(getParentsRawFileProperty(), elapsedPeriodsFileName);
            }
        } else if (getParentsRawFileProperty() == null) {
            this.future = asyncCompress(elapsedPeriodsFileName, elapsedPeriodsFileName, afterLastSlash);
        } else {
            this.future = renamedRawAndAsyncCompress(elapsedPeriodsFileName, afterLastSlash);
        }
        if (this.archiveRemover != null) {
            this.archiveRemover.clean(new Date(this.timeBasedFileNamingAndTriggeringPolicy.getCurrentTime()));
        }
    }

    /* access modifiers changed from: 0000 */
    public Future asyncCompress(String str, String str2, String str3) {
        return new AsynchronousCompressor(this.compressor).compressAsynchronously(str, str2, str3);
    }

    /* access modifiers changed from: 0000 */
    public Future renamedRawAndAsyncCompress(String str, String str2) {
        String parentsRawFileProperty = getParentsRawFileProperty();
        String sb = new StringBuilder(String.valueOf(parentsRawFileProperty)).append(System.nanoTime()).append(".tmp").toString();
        this.renameUtil.rename(parentsRawFileProperty, sb);
        return asyncCompress(sb, str, str2);
    }

    public String getActiveFileName() {
        String parentsRawFileProperty = getParentsRawFileProperty();
        if (parentsRawFileProperty != null) {
            return parentsRawFileProperty;
        }
        return this.timeBasedFileNamingAndTriggeringPolicy.getCurrentPeriodsFileNameWithoutCompressionSuffix();
    }

    public boolean isTriggeringEvent(File file, E e) {
        return this.timeBasedFileNamingAndTriggeringPolicy.isTriggeringEvent(file, e);
    }

    public int getMaxHistory() {
        return this.maxHistory;
    }

    public void setMaxHistory(int i) {
        this.maxHistory = i;
    }

    public boolean isCleanHistoryOnStart() {
        return this.cleanHistoryOnStart;
    }

    public void setCleanHistoryOnStart(boolean z) {
        this.cleanHistoryOnStart = z;
    }

    public String toString() {
        return "c.q.l.core.rolling.TimeBasedRollingPolicy";
    }
}
