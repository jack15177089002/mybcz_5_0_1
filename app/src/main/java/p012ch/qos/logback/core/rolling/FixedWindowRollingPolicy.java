package p012ch.qos.logback.core.rolling;

import java.io.File;
import java.util.Date;
import p012ch.qos.logback.core.CoreConstants;
import p012ch.qos.logback.core.rolling.helper.CompressionMode;
import p012ch.qos.logback.core.rolling.helper.Compressor;
import p012ch.qos.logback.core.rolling.helper.FileFilterUtil;
import p012ch.qos.logback.core.rolling.helper.FileNamePattern;
import p012ch.qos.logback.core.rolling.helper.RenameUtil;

/* renamed from: ch.qos.logback.core.rolling.FixedWindowRollingPolicy */
public class FixedWindowRollingPolicy extends RollingPolicyBase {
    private static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$rolling$helper$CompressionMode = null;
    static final String FNP_NOT_SET = "The \"FileNamePattern\" property must be set before using FixedWindowRollingPolicy. ";
    private static int MAX_WINDOW_SIZE = 20;
    static final String PRUDENT_MODE_UNSUPPORTED = "See also http://logback.qos.ch/codes.html#tbr_fnp_prudent_unsupported";
    static final String SEE_PARENT_FN_NOT_SET = "Please refer to http://logback.qos.ch/codes.html#fwrp_parentFileName_not_set";
    public static final String ZIP_ENTRY_DATE_PATTERN = "yyyy-MM-dd_HHmm";
    Compressor compressor;
    int maxIndex = 7;
    int minIndex = 1;
    RenameUtil util = new RenameUtil();

    static /* synthetic */ int[] $SWITCH_TABLE$ch$qos$logback$core$rolling$helper$CompressionMode() {
        int[] iArr = $SWITCH_TABLE$ch$qos$logback$core$rolling$helper$CompressionMode;
        if (iArr == null) {
            iArr = new int[CompressionMode.values().length];
            try {
                iArr[CompressionMode.GZ.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CompressionMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CompressionMode.ZIP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$ch$qos$logback$core$rolling$helper$CompressionMode = iArr;
        }
        return iArr;
    }

    public void start() {
        this.util.setContext(this.context);
        if (this.fileNamePatternStr != null) {
            this.fileNamePattern = new FileNamePattern(this.fileNamePatternStr, this.context);
            determineCompressionMode();
            if (isParentPrudent()) {
                addError("Prudent mode is not supported with FixedWindowRollingPolicy.");
                addError(PRUDENT_MODE_UNSUPPORTED);
                throw new IllegalStateException("Prudent mode is not supported.");
            } else if (getParentsRawFileProperty() == null) {
                addError("The File name property must be set before using this rolling policy.");
                addError(SEE_PARENT_FN_NOT_SET);
                throw new IllegalStateException("The \"File\" option must be set.");
            } else {
                if (this.maxIndex < this.minIndex) {
                    addWarn("MaxIndex (" + this.maxIndex + ") cannot be smaller than MinIndex (" + this.minIndex + ").");
                    addWarn("Setting maxIndex to equal minIndex.");
                    this.maxIndex = this.minIndex;
                }
                int maxWindowSize = getMaxWindowSize();
                if (this.maxIndex - this.minIndex > maxWindowSize) {
                    addWarn("Large window sizes are not allowed.");
                    this.maxIndex = maxWindowSize + this.minIndex;
                    addWarn("MaxIndex reduced to " + this.maxIndex);
                }
                if (this.fileNamePattern.getIntegerTokenConverter() == null) {
                    throw new IllegalStateException("FileNamePattern [" + this.fileNamePattern.getPattern() + "] does not contain a valid IntegerToken");
                }
                if (this.compressionMode == CompressionMode.ZIP) {
                    this.zipEntryFileNamePattern = new FileNamePattern(transformFileNamePatternFromInt2Date(this.fileNamePatternStr), this.context);
                }
                this.compressor = new Compressor(this.compressionMode);
                this.compressor.setContext(this.context);
                super.start();
            }
        } else {
            addError(FNP_NOT_SET);
            addError(CoreConstants.SEE_FNP_NOT_SET);
            throw new IllegalStateException("The \"FileNamePattern\" property must be set before using FixedWindowRollingPolicy. See also http://logback.qos.ch/codes.html#tbr_fnp_not_set");
        }
    }

    /* access modifiers changed from: protected */
    public int getMaxWindowSize() {
        return MAX_WINDOW_SIZE;
    }

    private String transformFileNamePatternFromInt2Date(String str) {
        return FileFilterUtil.afterLastSlash(FileFilterUtil.slashify(str)).replace("%i", "%d{yyyy-MM-dd_HHmm}");
    }

    public void rollover() {
        if (this.maxIndex >= 0) {
            File file = new File(this.fileNamePattern.convertInt(this.maxIndex));
            if (file.exists()) {
                file.delete();
            }
            int i = this.maxIndex;
            while (true) {
                i--;
                if (i < this.minIndex) {
                    break;
                }
                String convertInt = this.fileNamePattern.convertInt(i);
                if (new File(convertInt).exists()) {
                    this.util.rename(convertInt, this.fileNamePattern.convertInt(i + 1));
                } else {
                    addInfo("Skipping roll-over for inexistent file " + convertInt);
                }
            }
            switch ($SWITCH_TABLE$ch$qos$logback$core$rolling$helper$CompressionMode()[this.compressionMode.ordinal()]) {
                case 1:
                    this.util.rename(getActiveFileName(), this.fileNamePattern.convertInt(this.minIndex));
                    return;
                case 2:
                    this.compressor.compress(getActiveFileName(), this.fileNamePattern.convertInt(this.minIndex), null);
                    return;
                case 3:
                    this.compressor.compress(getActiveFileName(), this.fileNamePattern.convertInt(this.minIndex), this.zipEntryFileNamePattern.convert(new Date()));
                    return;
                default:
                    return;
            }
        }
    }

    public String getActiveFileName() {
        return getParentsRawFileProperty();
    }

    public int getMaxIndex() {
        return this.maxIndex;
    }

    public int getMinIndex() {
        return this.minIndex;
    }

    public void setMaxIndex(int i) {
        this.maxIndex = i;
    }

    public void setMinIndex(int i) {
        this.minIndex = i;
    }
}
