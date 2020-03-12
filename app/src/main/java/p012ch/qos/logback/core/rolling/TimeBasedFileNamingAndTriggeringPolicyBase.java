package p012ch.qos.logback.core.rolling;

import java.io.File;
import java.util.Date;
import p012ch.qos.logback.core.rolling.helper.ArchiveRemover;
import p012ch.qos.logback.core.rolling.helper.DateTokenConverter;
import p012ch.qos.logback.core.rolling.helper.RollingCalendar;
import p012ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.rolling.TimeBasedFileNamingAndTriggeringPolicyBase */
public abstract class TimeBasedFileNamingAndTriggeringPolicyBase<E> extends ContextAwareBase implements TimeBasedFileNamingAndTriggeringPolicy<E> {
    protected ArchiveRemover archiveRemover = null;
    protected long artificialCurrentTime = -1;
    protected Date dateInCurrentPeriod = null;
    protected String elapsedPeriodsFileName;
    protected long nextCheck;

    /* renamed from: rc */
    protected RollingCalendar f1668rc;
    protected boolean started = false;
    protected TimeBasedRollingPolicy<E> tbrp;

    public boolean isStarted() {
        return this.started;
    }

    public void start() {
        DateTokenConverter primaryDateTokenConverter = this.tbrp.fileNamePattern.getPrimaryDateTokenConverter();
        if (primaryDateTokenConverter == null) {
            throw new IllegalStateException("FileNamePattern [" + this.tbrp.fileNamePattern.getPattern() + "] does not contain a valid DateToken");
        }
        this.f1668rc = new RollingCalendar();
        this.f1668rc.init(primaryDateTokenConverter.getDatePattern());
        addInfo("The date pattern is '" + primaryDateTokenConverter.getDatePattern() + "' from file name pattern '" + this.tbrp.fileNamePattern.getPattern() + "'.");
        this.f1668rc.printPeriodicity(this);
        setDateInCurrentPeriod(new Date(getCurrentTime()));
        if (this.tbrp.getParentsRawFileProperty() != null) {
            File file = new File(this.tbrp.getParentsRawFileProperty());
            if (file.exists() && file.canRead()) {
                setDateInCurrentPeriod(new Date(file.lastModified()));
            }
        }
        addInfo("Setting initial period to " + this.dateInCurrentPeriod);
        computeNextCheck();
    }

    public void stop() {
        this.started = false;
    }

    /* access modifiers changed from: protected */
    public void computeNextCheck() {
        this.nextCheck = this.f1668rc.getNextTriggeringMillis(this.dateInCurrentPeriod);
    }

    /* access modifiers changed from: protected */
    public void setDateInCurrentPeriod(long j) {
        this.dateInCurrentPeriod.setTime(j);
    }

    public void setDateInCurrentPeriod(Date date) {
        this.dateInCurrentPeriod = date;
    }

    public String getElapsedPeriodsFileName() {
        return this.elapsedPeriodsFileName;
    }

    public String getCurrentPeriodsFileNameWithoutCompressionSuffix() {
        return this.tbrp.fileNamePatternWCS.convert(this.dateInCurrentPeriod);
    }

    public void setCurrentTime(long j) {
        this.artificialCurrentTime = j;
    }

    public long getCurrentTime() {
        if (this.artificialCurrentTime >= 0) {
            return this.artificialCurrentTime;
        }
        return System.currentTimeMillis();
    }

    public void setTimeBasedRollingPolicy(TimeBasedRollingPolicy<E> timeBasedRollingPolicy) {
        this.tbrp = timeBasedRollingPolicy;
    }

    public ArchiveRemover getArchiveRemover() {
        return this.archiveRemover;
    }
}
