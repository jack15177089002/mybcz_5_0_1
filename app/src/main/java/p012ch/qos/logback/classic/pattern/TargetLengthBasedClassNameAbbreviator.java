package p012ch.qos.logback.classic.pattern;

/* renamed from: ch.qos.logback.classic.pattern.TargetLengthBasedClassNameAbbreviator */
public class TargetLengthBasedClassNameAbbreviator implements Abbreviator {
    final int targetLength;

    public TargetLengthBasedClassNameAbbreviator(int i) {
        this.targetLength = i;
    }

    public String abbreviate(String str) {
        StringBuilder sb = new StringBuilder(this.targetLength);
        if (str == null) {
            throw new IllegalArgumentException("Class name may not be null");
        } else if (str.length() < this.targetLength) {
            return str;
        } else {
            int[] iArr = new int[16];
            int[] iArr2 = new int[17];
            int computeDotIndexes = computeDotIndexes(str, iArr);
            if (computeDotIndexes == 0) {
                return str;
            }
            computeLengthArray(str, iArr, iArr2, computeDotIndexes);
            for (int i = 0; i <= computeDotIndexes; i++) {
                if (i == 0) {
                    sb.append(str.substring(0, iArr2[i] - 1));
                } else {
                    sb.append(str.substring(iArr[i - 1], iArr[i - 1] + iArr2[i]));
                }
            }
            return sb.toString();
        }
    }

    static int computeDotIndexes(String str, int[] iArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(46, i);
            if (indexOf == -1 || i2 >= 16) {
                return i2;
            }
            iArr[i2] = indexOf;
            i2++;
            i = indexOf + 1;
        }
        return i2;
    }

    /* access modifiers changed from: 0000 */
    public void computeLengthArray(String str, int[] iArr, int[] iArr2, int i) {
        int i2 = 0;
        int length = str.length() - this.targetLength;
        while (i2 < i) {
            int i3 = -1;
            if (i2 > 0) {
                i3 = iArr[i2 - 1];
            }
            int i4 = (iArr[i2] - i3) - 1;
            int i5 = length > 0 ? i4 <= 0 ? i4 : 1 : i4;
            int i6 = length - (i4 - i5);
            iArr2[i2] = i5 + 1;
            i2++;
            length = i6;
        }
        iArr2[i] = str.length() - iArr[i - 1];
    }

    static void printArray(String str, int[] iArr) {
        System.out.print(str);
        for (int i = 0; i < iArr.length; i++) {
            if (i == 0) {
                System.out.print(iArr[i]);
            } else {
                System.out.print(", " + iArr[i]);
            }
        }
        System.out.println();
    }
}
