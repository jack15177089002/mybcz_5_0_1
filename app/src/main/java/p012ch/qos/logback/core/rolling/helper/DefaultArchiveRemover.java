package p012ch.qos.logback.core.rolling.helper;

import java.io.File;
import java.util.Date;
import p012ch.qos.logback.core.pattern.Converter;
import p012ch.qos.logback.core.pattern.LiteralConverter;
import p012ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.rolling.helper.DefaultArchiveRemover */
public abstract class DefaultArchiveRemover extends ContextAwareBase implements ArchiveRemover {
    protected static final long INACTIVITY_TOLERANCE_IN_MILLIS = 5529600000L;
    static final int MAX_VALUE_FOR_INACTIVITY_PERIODS = 336;
    protected static final long UNINITIALIZED = -1;
    final FileNamePattern fileNamePattern;
    long lastHeartBeat = UNINITIALIZED;
    final boolean parentClean;
    int periodOffsetForDeletionTarget;

    /* renamed from: rc */
    final RollingCalendar f1670rc;

    /* access modifiers changed from: 0000 */
    public abstract void cleanByPeriodOffset(Date date, int i);

    public DefaultArchiveRemover(FileNamePattern fileNamePattern2, RollingCalendar rollingCalendar) {
        this.fileNamePattern = fileNamePattern2;
        this.f1670rc = rollingCalendar;
        this.parentClean = computeParentCleaningFlag(fileNamePattern2);
    }

    /* access modifiers changed from: 0000 */
    public int computeElapsedPeriodsSinceLastClean(long j) {
        long j2 = 336;
        if (this.lastHeartBeat == UNINITIALIZED) {
            addInfo("first clean up after appender initialization");
            long periodsElapsed = this.f1670rc.periodsElapsed(j, INACTIVITY_TOLERANCE_IN_MILLIS + j);
            if (periodsElapsed <= 336) {
                j2 = periodsElapsed;
            }
        } else {
            j2 = this.f1670rc.periodsElapsed(this.lastHeartBeat, j);
            if (j2 < 1) {
                addWarn("Unexpected periodsElapsed value " + j2);
                j2 = 1;
            }
        }
        return (int) j2;
    }

    public void clean(Date date) {
        long time = date.getTime();
        int computeElapsedPeriodsSinceLastClean = computeElapsedPeriodsSinceLastClean(time);
        this.lastHeartBeat = time;
        if (computeElapsedPeriodsSinceLastClean > 1) {
            addInfo("periodsElapsed = " + computeElapsedPeriodsSinceLastClean);
        }
        for (int i = 0; i < computeElapsedPeriodsSinceLastClean; i++) {
            cleanByPeriodOffset(date, this.periodOffsetForDeletionTarget - i);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean computeParentCleaningFlag(FileNamePattern fileNamePattern2) {
        if (fileNamePattern2.getPrimaryDateTokenConverter().getDatePattern().indexOf(47) != -1) {
            return true;
        }
        Converter<Object> converter = fileNamePattern2.headTokenConverter;
        while (converter != null && !(converter instanceof DateTokenConverter)) {
            converter = converter.getNext();
        }
        while (converter != null) {
            if ((converter instanceof LiteralConverter) && converter.convert(null).indexOf(47) != -1) {
                return true;
            }
            converter = converter.getNext();
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void removeFolderIfEmpty(File file) {
        removeFolderIfEmpty(file, 0);
    }

    private void removeFolderIfEmpty(File file, int i) {
        while (i < 3 && file.isDirectory() && FileFilterUtil.isEmptyDirectory(file)) {
            addInfo("deleting folder [" + file + "]");
            file.delete();
            file = file.getParentFile();
            i++;
        }
    }

    public void setMaxHistory(int i) {
        this.periodOffsetForDeletionTarget = (-i) - 1;
    }
}
