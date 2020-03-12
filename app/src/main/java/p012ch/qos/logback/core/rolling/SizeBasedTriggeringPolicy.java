package p012ch.qos.logback.core.rolling;

import java.io.File;
import p012ch.qos.logback.core.util.FileSize;
import p012ch.qos.logback.core.util.InvocationGate;

/* renamed from: ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy */
public class SizeBasedTriggeringPolicy<E> extends TriggeringPolicyBase<E> {
    public static final long DEFAULT_MAX_FILE_SIZE = 10485760;
    public static final String SEE_SIZE_FORMAT = "http://logback.qos.ch/codes.html#sbtp_size_format";
    private InvocationGate invocationGate = new InvocationGate();
    FileSize maxFileSize;
    String maxFileSizeAsString = Long.toString(10485760);

    public SizeBasedTriggeringPolicy() {
    }

    public SizeBasedTriggeringPolicy(String str) {
        setMaxFileSize(str);
    }

    public boolean isTriggeringEvent(File file, E e) {
        if (this.invocationGate.skipFurtherWork()) {
            return false;
        }
        this.invocationGate.updateMaskIfNecessary(System.currentTimeMillis());
        if (file.length() >= this.maxFileSize.getSize()) {
            return true;
        }
        return false;
    }

    public String getMaxFileSize() {
        return this.maxFileSizeAsString;
    }

    public void setMaxFileSize(String str) {
        this.maxFileSizeAsString = str;
        this.maxFileSize = FileSize.valueOf(str);
    }

    /* access modifiers changed from: 0000 */
    public long toFileSize(String str) {
        long j = 10485760;
        if (str == null) {
            return j;
        }
        String upperCase = str.trim().toUpperCase();
        long j2 = 1;
        int indexOf = upperCase.indexOf("KB");
        if (indexOf != -1) {
            j2 = 1024;
            upperCase = upperCase.substring(0, indexOf);
        } else {
            int indexOf2 = upperCase.indexOf("MB");
            if (indexOf2 != -1) {
                j2 = 1048576;
                upperCase = upperCase.substring(0, indexOf2);
            } else {
                int indexOf3 = upperCase.indexOf("GB");
                if (indexOf3 != -1) {
                    j2 = 1073741824;
                    upperCase = upperCase.substring(0, indexOf3);
                }
            }
        }
        if (upperCase == null) {
            return j;
        }
        try {
            return Long.valueOf(upperCase).longValue() * j2;
        } catch (NumberFormatException e) {
            addError("[" + upperCase + "] is not in proper int format. Please refer to http://logback.qos.ch/codes.html#sbtp_size_format");
            addError("[" + str + "] not in expected format.", e);
            return j;
        }
    }
}
