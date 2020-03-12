package p012ch.qos.logback.core.pattern;

import p012ch.qos.logback.classic.Level;

/* renamed from: ch.qos.logback.core.pattern.FormatInfo */
public class FormatInfo {
    private boolean leftPad = true;
    private boolean leftTruncate = true;
    private int max = Integer.MAX_VALUE;
    private int min = Level.ALL_INT;

    public FormatInfo() {
    }

    public FormatInfo(int i, int i2) {
        this.min = i;
        this.max = i2;
    }

    public FormatInfo(int i, int i2, boolean z, boolean z2) {
        this.min = i;
        this.max = i2;
        this.leftPad = z;
        this.leftTruncate = z2;
    }

    public static FormatInfo valueOf(String str) {
        if (str == null) {
            throw new NullPointerException("Argument cannot be null");
        }
        FormatInfo formatInfo = new FormatInfo();
        int indexOf = str.indexOf(46);
        String str2 = null;
        if (indexOf != -1) {
            String substring = str.substring(0, indexOf);
            if (indexOf + 1 == str.length()) {
                throw new IllegalArgumentException("Formatting string [" + str + "] should not end with '.'");
            }
            str2 = str.substring(indexOf + 1);
            str = substring;
        }
        if (str != null && str.length() > 0) {
            int parseInt = Integer.parseInt(str);
            if (parseInt >= 0) {
                formatInfo.min = parseInt;
            } else {
                formatInfo.min = -parseInt;
                formatInfo.leftPad = false;
            }
        }
        if (str2 != null && str2.length() > 0) {
            int parseInt2 = Integer.parseInt(str2);
            if (parseInt2 >= 0) {
                formatInfo.max = parseInt2;
            } else {
                formatInfo.max = -parseInt2;
                formatInfo.leftTruncate = false;
            }
        }
        return formatInfo;
    }

    public boolean isLeftPad() {
        return this.leftPad;
    }

    public void setLeftPad(boolean z) {
        this.leftPad = z;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int i) {
        this.max = i;
    }

    public int getMin() {
        return this.min;
    }

    public void setMin(int i) {
        this.min = i;
    }

    public boolean isLeftTruncate() {
        return this.leftTruncate;
    }

    public void setLeftTruncate(boolean z) {
        this.leftTruncate = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormatInfo)) {
            return false;
        }
        FormatInfo formatInfo = (FormatInfo) obj;
        if (this.min == formatInfo.min && this.max == formatInfo.max && this.leftPad == formatInfo.leftPad && this.leftTruncate == formatInfo.leftTruncate) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2 = 1;
        int i3 = ((this.min * 31) + this.max) * 31;
        if (this.leftPad) {
            i = 1;
        } else {
            i = 0;
        }
        int i4 = (i + i3) * 31;
        if (!this.leftTruncate) {
            i2 = 0;
        }
        return i4 + i2;
    }

    public String toString() {
        return "FormatInfo(" + this.min + ", " + this.max + ", " + this.leftPad + ", " + this.leftTruncate + ")";
    }
}
