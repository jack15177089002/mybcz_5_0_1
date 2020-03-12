package org.mozilla.javascript;

import java.math.BigInteger;
import p012ch.qos.logback.core.CoreConstants;

/* renamed from: org.mozilla.javascript.s */
final class DToA {

    /* renamed from: a */
    private static final double[] f6821a = {1.0d, 10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d, 1.0E22d};

    /* renamed from: b */
    private static final double[] f6822b = {1.0E16d, 1.0E32d, 1.0E64d, 1.0E128d, 1.0E256d};

    /* renamed from: c */
    private static final int[] f6823c = {0, 0, 3, 2, 2};

    /* renamed from: a */
    private static int m6796a(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        if ((i & 7) == 0) {
            if ((65535 & i) == 0) {
                i2 = 16;
                i3 = i >>> 16;
            } else {
                i2 = 0;
                i3 = i;
            }
            if ((i3 & 255) == 0) {
                i2 += 8;
                i3 >>>= 8;
            }
            if ((i3 & 15) == 0) {
                i2 += 4;
                i3 >>>= 4;
            }
            if ((i3 & 3) == 0) {
                int i6 = i3 >>> 2;
                i4 = i2 + 2;
                i5 = i6;
            } else {
                int i7 = i3;
                i4 = i2;
                i5 = i7;
            }
            if ((i5 & 1) != 0) {
                return i4;
            }
            int i8 = i4 + 1;
            if (((i5 >>> 1) & 1) == 0) {
                return 32;
            }
            return i8;
        } else if ((i & 1) != 0) {
            return 0;
        } else {
            if ((i & 2) != 0) {
                return 1;
            }
            return 2;
        }
    }

    /* renamed from: b */
    private static int m6803b(int i) {
        int i2;
        int i3 = 0;
        if ((-65536 & i) == 0) {
            i3 = 16;
            i2 = i << 16;
        } else {
            i2 = i;
        }
        if ((-16777216 & i2) == 0) {
            i3 += 8;
            i2 <<= 8;
        }
        if ((-268435456 & i2) == 0) {
            i3 += 4;
            i2 <<= 4;
        }
        if ((-1073741824 & i2) == 0) {
            i3 += 2;
            i2 <<= 2;
        }
        if ((Integer.MIN_VALUE & i2) != 0) {
            return i3;
        }
        int i4 = i3 + 1;
        if ((i2 & 1073741824) == 0) {
            return 32;
        }
        return i4;
    }

    /* renamed from: a */
    private static void m6801a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* renamed from: a */
    private static BigInteger m6798a(double d, int[] iArr, int[] iArr2) {
        byte[] bArr;
        int i;
        int i2;
        int i3 = 1;
        long doubleToLongBits = Double.doubleToLongBits(d);
        int i4 = (int) (doubleToLongBits >>> 32);
        int i5 = (int) doubleToLongBits;
        int i6 = 1048575 & i4;
        int i7 = (Integer.MAX_VALUE & i4) >>> 20;
        if (i7 != 0) {
            i6 |= 1048576;
        }
        if (i5 != 0) {
            bArr = new byte[8];
            int a = m6796a(i5);
            int i8 = i5 >>> a;
            if (a != 0) {
                m6801a(bArr, 4, i8 | (i6 << (32 - a)));
                i6 >>= a;
            } else {
                m6801a(bArr, 4, i8);
            }
            m6801a(bArr, 0, i6);
            if (i6 != 0) {
                i3 = 2;
            }
            int i9 = a;
            i = i3;
            i2 = i9;
        } else {
            bArr = new byte[4];
            int a2 = m6796a(i6);
            i6 >>>= a2;
            m6801a(bArr, 0, i6);
            int i10 = a2 + 32;
            i = 1;
            i2 = i10;
        }
        if (i7 != 0) {
            iArr[0] = ((i7 - 1023) - 52) + i2;
            iArr2[0] = 53 - i2;
        } else {
            iArr[0] = i2 + ((i7 - 1023) - 52) + 1;
            iArr2[0] = (i * 32) - m6803b(i6);
        }
        return new BigInteger(bArr);
    }

    /* renamed from: a */
    static String m6797a(int i, double d) {
        boolean z;
        long j;
        long j2;
        String bigInteger;
        int i2;
        BigInteger bigInteger2;
        int i3;
        BigInteger bigInteger3;
        long j3;
        if (2 > i || i > 36) {
            throw new IllegalArgumentException("Bad base: " + i);
        } else if (Double.isNaN(d)) {
            return "NaN";
        } else {
            if (Double.isInfinite(d)) {
                return d > 0.0d ? "Infinity" : "-Infinity";
            }
            if (d == 0.0d) {
                return "0";
            }
            if (d >= 0.0d) {
                z = false;
            } else {
                z = true;
                d = -d;
            }
            double floor = Math.floor(d);
            long j4 = (long) floor;
            if (((double) j4) == floor) {
                if (z) {
                    j3 = -j4;
                } else {
                    j3 = j4;
                }
                bigInteger = Long.toString(j3, i);
            } else {
                long doubleToLongBits = Double.doubleToLongBits(floor);
                int i4 = ((int) (doubleToLongBits >> 52)) & 2047;
                if (i4 == 0) {
                    j = (doubleToLongBits & 4503599627370495L) << 1;
                } else {
                    j = (doubleToLongBits & 4503599627370495L) | 4503599627370496L;
                }
                if (z) {
                    j2 = -j;
                } else {
                    j2 = j;
                }
                int i5 = i4 - 1075;
                BigInteger valueOf = BigInteger.valueOf(j2);
                if (i5 > 0) {
                    valueOf = valueOf.shiftLeft(i5);
                } else if (i5 < 0) {
                    valueOf = valueOf.shiftRight(-i5);
                }
                bigInteger = valueOf.toString(i);
            }
            if (d == floor) {
                return bigInteger;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(bigInteger).append(CoreConstants.DOT);
            double d2 = d - floor;
            long doubleToLongBits2 = Double.doubleToLongBits(d);
            int i6 = (int) (doubleToLongBits2 >> 32);
            int i7 = (int) doubleToLongBits2;
            int[] iArr = new int[1];
            BigInteger a = m6798a(d2, iArr, new int[1]);
            int i8 = -((i6 >>> 20) & 2047);
            if (i8 == 0) {
                i8 = -1;
            }
            int i9 = i8 + 1076;
            BigInteger valueOf2 = BigInteger.valueOf(1);
            if (i7 == 0 && (1048575 & i6) == 0 && (2145386496 & i6) != 0) {
                i2 = i9 + 1;
                bigInteger2 = BigInteger.valueOf(2);
            } else {
                i2 = i9;
                bigInteger2 = valueOf2;
            }
            BigInteger shiftLeft = a.shiftLeft(iArr[0] + i2);
            BigInteger shiftLeft2 = BigInteger.valueOf(1).shiftLeft(i2);
            BigInteger valueOf3 = BigInteger.valueOf((long) i);
            boolean z2 = false;
            BigInteger bigInteger4 = bigInteger2;
            BigInteger bigInteger5 = shiftLeft;
            BigInteger bigInteger6 = valueOf2;
            while (true) {
                BigInteger[] divideAndRemainder = bigInteger5.multiply(valueOf3).divideAndRemainder(shiftLeft2);
                BigInteger bigInteger7 = divideAndRemainder[1];
                int intValue = (char) divideAndRemainder[0].intValue();
                if (bigInteger6 == bigInteger4) {
                    bigInteger4 = bigInteger6.multiply(valueOf3);
                    bigInteger6 = bigInteger4;
                } else {
                    bigInteger6 = bigInteger6.multiply(valueOf3);
                    bigInteger4 = bigInteger4.multiply(valueOf3);
                }
                int compareTo = bigInteger7.compareTo(bigInteger6);
                BigInteger subtract = shiftLeft2.subtract(bigInteger4);
                int compareTo2 = subtract.signum() <= 0 ? 1 : bigInteger7.compareTo(subtract);
                if (compareTo2 == 0 && (i7 & 1) == 0) {
                    if (compareTo > 0) {
                        intValue++;
                    }
                    z2 = true;
                } else if (compareTo < 0 || (compareTo == 0 && (i7 & 1) == 0)) {
                    if (compareTo2 > 0) {
                        bigInteger7 = bigInteger7.shiftLeft(1);
                        if (bigInteger7.compareTo(shiftLeft2) > 0) {
                            BigInteger bigInteger8 = bigInteger7;
                            i3 = intValue + 1;
                            bigInteger3 = bigInteger8;
                            z2 = true;
                            BigInteger bigInteger9 = bigInteger3;
                            intValue = i3;
                            bigInteger7 = bigInteger9;
                        }
                    }
                    BigInteger bigInteger10 = bigInteger7;
                    i3 = intValue;
                    bigInteger3 = bigInteger10;
                    z2 = true;
                    BigInteger bigInteger92 = bigInteger3;
                    intValue = i3;
                    bigInteger7 = bigInteger92;
                } else if (compareTo2 > 0) {
                    intValue++;
                    z2 = true;
                }
                sb.append((char) (intValue >= 10 ? intValue + 87 : intValue + 48));
                if (z2) {
                    return sb.toString();
                }
                bigInteger5 = bigInteger7;
            }
        }
    }

    /* renamed from: a */
    private static int m6795a(double d) {
        return (int) (Double.doubleToLongBits(d) >> 32);
    }

    /* renamed from: a */
    private static double m6794a(double d, int i) {
        return Double.longBitsToDouble((Double.doubleToLongBits(d) & 4294967295L) | (((long) i) << 32));
    }

    /* renamed from: a */
    private static BigInteger m6799a(BigInteger bigInteger, int i) {
        return bigInteger.multiply(BigInteger.valueOf(5).pow(i));
    }

    /* renamed from: a */
    private static boolean m6802a(StringBuilder sb) {
        int length = sb.length();
        while (length != 0) {
            length--;
            char charAt = sb.charAt(length);
            if (charAt != '9') {
                sb.setCharAt(length, (char) (charAt + 1));
                sb.setLength(length + 1);
                return false;
            }
        }
        sb.setLength(0);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01d9, code lost:
        r14 = r14 >> 1;
        r15 = r15 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0236, code lost:
        if (r39 > 0) goto L_0x0841;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0238, code lost:
        r7 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0239, code lost:
        r22 = r8;
        r12 = r7;
        r11 = r7;
        r23 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0242, code lost:
        r11 = (r39 + r6) + 1;
        r12 = r11 - 1;
        r22 = r7;
        r23 = r39;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x024e, code lost:
        r14 = r16 / r8;
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0251, code lost:
        if (r3 == false) goto L_0x0826;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0257, code lost:
        if (r14 >= 1.0d) goto L_0x0826;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0259, code lost:
        if (r11 <= 0) goto L_0x0826;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x025b, code lost:
        if (r12 > 0) goto L_0x02b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x025d, code lost:
        r7 = true;
        r9 = r11;
        r10 = r8;
        r8 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0261, code lost:
        r16 = (((double) r10) * r14) + 7.0d;
        r30 = m6794a(r16, m6795a(r16) - 54525952);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0278, code lost:
        if (r9 != 0) goto L_0x0822;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x027a, code lost:
        r16 = r14 - 5.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0280, code lost:
        if (r16 <= r30) goto L_0x02c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0282, code lost:
        r37.append('1');
        r7 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x028b, code lost:
        r2 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x028f, code lost:
        r8 = -r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0290, code lost:
        if (r8 == 0) goto L_0x0830;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0292, code lost:
        r34 = r8 >> 4;
        r8 = f6821a[r8 & 15] * r4;
        r14 = r34;
        r15 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02a4, code lost:
        if (r14 == 0) goto L_0x082c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02a8, code lost:
        if ((r14 & 1) == 0) goto L_0x02b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02aa, code lost:
        r7 = r7 + 1;
        r8 = r8 * f6822b[r15];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02b2, code lost:
        r14 = r14 >> 1;
        r15 = r15 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02b7, code lost:
        r14 = r14 * 10.0d;
        r9 = r12;
        r7 = false;
        r10 = r8 + 1;
        r8 = r6 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x02cc, code lost:
        if (r16 >= (-r30)) goto L_0x02de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02ce, code lost:
        r37.setLength(0);
        r37.append('0');
        r2 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02de, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02df, code lost:
        if (r7 != false) goto L_0x081e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02e2, code lost:
        if (r22 == false) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02e4, code lost:
        r14 = (0.5d / f6821a[r9 - 1]) - r30;
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02f1, code lost:
        r30 = (long) r16;
        r16 = r16 - ((double) r30);
        r37.append((char) ((int) (r30 + 48)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0314, code lost:
        if (r16 < r14) goto L_0x081b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x031c, code lost:
        if ((1.0d - r16) >= r14) goto L_0x034e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x031e, code lost:
        r2 = r37.charAt(r37.length() - 1);
        r37.setLength(r37.length() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0337, code lost:
        if (r2 != '9') goto L_0x0343;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x033d, code lost:
        if (r37.length() != 0) goto L_0x031e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x033f, code lost:
        r8 = r8 + 1;
        r2 = '0';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0343, code lost:
        r37.append((char) (r2 + 1));
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x034e, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0350, code lost:
        if (r7 >= r9) goto L_0x0816;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0352, code lost:
        r14 = r14 * 10.0d;
        r16 = r16 * 10.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x035b, code lost:
        r30 = r30 * f6821a[r9 - 1];
        r7 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0364, code lost:
        r32 = (long) r16;
        r14 = r16 - ((double) r32);
        r37.append((char) ((int) (48 + r32)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0383, code lost:
        if (r7 != r9) goto L_0x03e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x038b, code lost:
        if (r14 <= (0.5d + r30)) goto L_0x03bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x038d, code lost:
        r2 = r37.charAt(r37.length() - 1);
        r37.setLength(r37.length() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03a6, code lost:
        if (r2 != '9') goto L_0x03b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03ac, code lost:
        if (r37.length() != 0) goto L_0x038d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03ae, code lost:
        r8 = r8 + 1;
        r2 = '0';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03b2, code lost:
        r37.append((char) (r2 + 1));
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03c3, code lost:
        if (r14 >= (0.5d - r30)) goto L_0x03e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03c5, code lost:
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03c6, code lost:
        r2 = r37.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03ca, code lost:
        r3 = r2 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03cc, code lost:
        if (r2 <= 0) goto L_0x03d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03d6, code lost:
        if (r37.charAt(r3) == '0') goto L_0x07d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03d8, code lost:
        r37.setLength(r3 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03e1, code lost:
        r7 = r7 + 1;
        r16 = 10.0d * r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03e9, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03ea, code lost:
        if (r7 == false) goto L_0x0811;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03ec, code lost:
        r37.setLength(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03f5, code lost:
        if (r27[0] < 0) goto L_0x0494;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x03f9, code lost:
        if (r6 > 14) goto L_0x0494;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03fb, code lost:
        r8 = f6821a[r6];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03ff, code lost:
        if (r23 >= 0) goto L_0x0430;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0401, code lost:
        if (r11 > 0) goto L_0x0430;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0403, code lost:
        if (r11 < 0) goto L_0x0415;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x040a, code lost:
        if (r4 < (5.0d * r8)) goto L_0x0415;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x040c, code lost:
        if (r2 != false) goto L_0x0425;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0413, code lost:
        if (r4 != (5.0d * r8)) goto L_0x0425;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0415, code lost:
        r37.setLength(0);
        r37.append('0');
        r2 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0425, code lost:
        r37.append('1');
        r7 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0430, code lost:
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0431, code lost:
        r12 = (long) (r4 / r8);
        r4 = r4 - (((double) r12) * r8);
        r37.append((char) ((int) (48 + r12)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0441, code lost:
        if (r3 != r11) goto L_0x0488;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0443, code lost:
        r4 = r4 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0446, code lost:
        if (r4 > r8) goto L_0x0457;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x044a, code lost:
        if (r4 != r8) goto L_0x0484;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0453, code lost:
        if ((1 & r12) != 0) goto L_0x0457;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0455, code lost:
        if (r2 == false) goto L_0x0484;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0457, code lost:
        r2 = r37.charAt(r37.length() - 1);
        r37.setLength(r37.length() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0470, code lost:
        if (r2 != '9') goto L_0x047c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0476, code lost:
        if (r37.length() != 0) goto L_0x0457;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0478, code lost:
        r6 = r6 + 1;
        r2 = '0';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x047c, code lost:
        r37.append((char) (r2 + 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0484, code lost:
        r2 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0488, code lost:
        r4 = r4 * 10.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x048f, code lost:
        if (r4 == 0.0d) goto L_0x0484;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0491, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0494, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0495, code lost:
        if (r22 == false) goto L_0x0803;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x049a, code lost:
        if (r24 >= 2) goto L_0x054d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x049c, code lost:
        if (r25 == false) goto L_0x0546;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x049e, code lost:
        r7 = r27[0] + 1075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x04a3, code lost:
        r8 = r18;
        r9 = r7;
        r10 = r19;
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x04a9, code lost:
        r19 = r19 + r9;
        r9 = r9 + r21;
        r14 = r8;
        r15 = r18;
        r18 = r7;
        r8 = r10;
        r10 = java.math.BigInteger.valueOf(1);
        r13 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x04bc, code lost:
        if (r8 <= 0) goto L_0x07fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x04be, code lost:
        if (r9 <= 0) goto L_0x07fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x04c0, code lost:
        if (r8 >= r9) goto L_0x0565;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x04c2, code lost:
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x04c3, code lost:
        r13 = r13 - r7;
        r9 = r9 - r7;
        r16 = r8 - r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x04c8, code lost:
        if (r15 <= 0) goto L_0x07f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x04ca, code lost:
        if (r22 == false) goto L_0x0568;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x04cc, code lost:
        if (r14 <= 0) goto L_0x07f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x04ce, code lost:
        r8 = m6799a(r10, r14);
        r7 = r8.multiply(r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x04d8, code lost:
        r10 = r15 - r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x04da, code lost:
        if (r10 == 0) goto L_0x04e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x04dc, code lost:
        r7 = m6799a(r7, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x04e0, code lost:
        r15 = java.math.BigInteger.valueOf(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x04e6, code lost:
        if (r18 <= 0) goto L_0x04ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x04e8, code lost:
        r15 = m6799a(r15, r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x04ee, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x04f2, code lost:
        if (r24 >= 2) goto L_0x0517;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x04fb, code lost:
        if (((int) java.lang.Double.doubleToLongBits(r4)) != 0) goto L_0x0517;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0506, code lost:
        if ((m6795a(r4) & 1048575) != 0) goto L_0x0517;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0510, code lost:
        if ((m6795a(r4) & 2145386496) == 0) goto L_0x0517;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0512, code lost:
        r13 = r13 + 1;
        r9 = r9 + 1;
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0517, code lost:
        r19 = r15.toByteArray();
        r14 = 0;
        r17 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x052a, code lost:
        if (r17 >= 4) goto L_0x0571;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x052c, code lost:
        r14 = r14 << 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0537, code lost:
        if (r17 >= r19.length) goto L_0x0543;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0539, code lost:
        r14 = r14 | (r19[r17] & com.tencent.android.tpush.common.Constants.NETWORK_TYPE_UNCONNECTED);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0543, code lost:
        r17 = r17 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0546, code lost:
        r7 = 54 - r28[0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x054d, code lost:
        r7 = r11 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0551, code lost:
        if (r18 < r7) goto L_0x055d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0553, code lost:
        r8 = r18 - r7;
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0556, code lost:
        if (r11 >= 0) goto L_0x07fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0558, code lost:
        r10 = r19 - r11;
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x055d, code lost:
        r8 = r7 - r18;
        r7 = r13 + r8;
        r18 = r18 + r8;
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0565, code lost:
        r7 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0568, code lost:
        r7 = m6799a(r20, r15);
        r8 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0571, code lost:
        if (r18 == 0) goto L_0x05eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x0573, code lost:
        r14 = 32 - m6803b(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x0579, code lost:
        r14 = (r14 + r9) & 31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x057c, code lost:
        if (r14 == 0) goto L_0x0580;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x057e, code lost:
        r14 = 32 - r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x0584, code lost:
        if (r14 <= 4) goto L_0x05ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x0586, code lost:
        r17 = r14 - 4;
        r13 = r13 + r17;
        r14 = r16 + r17;
        r9 = r9 + r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x058e, code lost:
        if (r13 <= 0) goto L_0x0594;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0590, code lost:
        r7 = r7.shiftLeft(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x0594, code lost:
        if (r9 <= 0) goto L_0x07e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x0596, code lost:
        r13 = r15.shiftLeft(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x059b, code lost:
        if (r3 == false) goto L_0x07e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x05a1, code lost:
        if (r7.compareTo(r13) >= 0) goto L_0x07e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x05a3, code lost:
        r6 = r6 - 1;
        r3 = r7.multiply(java.math.BigInteger.valueOf(10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x05af, code lost:
        if (r22 == false) goto L_0x05bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x05b1, code lost:
        r8 = r8.multiply(java.math.BigInteger.valueOf(10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x05bb, code lost:
        r7 = r6;
        r6 = r8;
        r8 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x05be, code lost:
        if (r12 > 0) goto L_0x0607;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x05c3, code lost:
        if (r24 <= 2) goto L_0x0607;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x05c5, code lost:
        if (r12 < 0) goto L_0x05db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x05c7, code lost:
        r3 = r8.compareTo(r13.multiply(java.math.BigInteger.valueOf(5)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x05d5, code lost:
        if (r3 < 0) goto L_0x05db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x05d7, code lost:
        if (r3 != 0) goto L_0x05fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x05d9, code lost:
        if (r2 != false) goto L_0x05fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x05db, code lost:
        r37.setLength(0);
        r37.append('0');
        r2 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x05eb, code lost:
        r14 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x05f1, code lost:
        if (r14 >= 4) goto L_0x07ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x05f3, code lost:
        r17 = r14 + 28;
        r13 = r13 + r17;
        r14 = r16 + r17;
        r9 = r9 + r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x05fc, code lost:
        r37.append('1');
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x0607, code lost:
        if (r22 == false) goto L_0x072a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0609, code lost:
        if (r14 <= 0) goto L_0x060f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x060b, code lost:
        r6 = r6.shiftLeft(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x060f, code lost:
        if (r10 == false) goto L_0x07dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x0611, code lost:
        r3 = r6.shiftLeft(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0616, code lost:
        r9 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x061a, code lost:
        r10 = r9;
        r9 = r3;
        r3 = r8.divideAndRemainder(r13);
        r8 = r3[1];
        r3 = (char) (r3[0].intValue() + 48);
        r14 = r8.compareTo(r6);
        r11 = r13.subtract(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x0637, code lost:
        if (r11.signum() > 0) goto L_0x0667;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x0639, code lost:
        r11 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x063a, code lost:
        if (r11 != 0) goto L_0x0678;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x063c, code lost:
        if (r24 != 0) goto L_0x0678;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x0647, code lost:
        if ((((int) java.lang.Double.doubleToLongBits(r4)) & 1) != 0) goto L_0x0678;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x064b, code lost:
        if (r3 != '9') goto L_0x066c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x064d, code lost:
        r37.append('9');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x0658, code lost:
        if (m6802a(r37) == false) goto L_0x07da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:0x065a, code lost:
        r2 = r7 + 1;
        r37.append('1');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x0663, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x0667, code lost:
        r11 = r8.compareTo(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x066c, code lost:
        if (r14 <= 0) goto L_0x07d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x066e, code lost:
        r2 = (char) (r3 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x0671, code lost:
        r37.append(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x0678, code lost:
        if (r14 < 0) goto L_0x0687;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x067a, code lost:
        if (r14 != 0) goto L_0x06c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x067c, code lost:
        if (r24 != 0) goto L_0x06c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x0685, code lost:
        if ((((int) java.lang.Double.doubleToLongBits(r4)) & 1) != 0) goto L_0x06c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x0687, code lost:
        if (r11 <= 0) goto L_0x06bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x0689, code lost:
        r4 = r8.shiftLeft(1).compareTo(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x0692, code lost:
        if (r4 > 0) goto L_0x069d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x0694, code lost:
        if (r4 != 0) goto L_0x06bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:331:0x0699, code lost:
        if ((r3 & 1) == 1) goto L_0x069d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x069b, code lost:
        if (r2 == false) goto L_0x06bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:333:0x069d, code lost:
        r2 = (char) (r3 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x06a2, code lost:
        if (r3 != '9') goto L_0x06be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x06a4, code lost:
        r37.append('9');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x06af, code lost:
        if (m6802a(r37) == false) goto L_0x06ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x06b1, code lost:
        r7 = r7 + 1;
        r37.append('1');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x06ba, code lost:
        r2 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x06be, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x06bf, code lost:
        r37.append(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x06c6, code lost:
        if (r11 <= 0) goto L_0x06f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:343:0x06ca, code lost:
        if (r3 != '9') goto L_0x06e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x06cc, code lost:
        r37.append('9');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x06d7, code lost:
        if (m6802a(r37) == false) goto L_0x06e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x06d9, code lost:
        r7 = r7 + 1;
        r37.append('1');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x06e2, code lost:
        r2 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x06e6, code lost:
        r37.append((char) (r3 + 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x06f0, code lost:
        r37.append(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x06f5, code lost:
        if (r10 == r12) goto L_0x07d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x06f7, code lost:
        r8 = r8.multiply(java.math.BigInteger.valueOf(10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x0701, code lost:
        if (r6 != r9) goto L_0x0715;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x0703, code lost:
        r3 = r9.multiply(java.math.BigInteger.valueOf(10));
        r6 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x070e, code lost:
        r9 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x0715, code lost:
        r6 = r6.multiply(java.math.BigInteger.valueOf(10));
        r3 = r9.multiply(java.math.BigInteger.valueOf(10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x072a, code lost:
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x072b, code lost:
        r5 = r8.divideAndRemainder(r13);
        r4 = r5[1];
        r5 = (char) (r5[0].intValue() + 48);
        r37.append(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x0741, code lost:
        if (r3 >= r12) goto L_0x0750;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x0743, code lost:
        r8 = r4.multiply(java.math.BigInteger.valueOf(10));
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x0750, code lost:
        r3 = r4;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x0752, code lost:
        r3 = r3.shiftLeft(1).compareTo(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x075b, code lost:
        if (r3 > 0) goto L_0x0766;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x075d, code lost:
        if (r3 != 0) goto L_0x03c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x0762, code lost:
        if ((r4 & 1) == 1) goto L_0x0766;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x0764, code lost:
        if (r2 == false) goto L_0x03c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x076a, code lost:
        if (m6802a(r37) == false) goto L_0x028b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x076c, code lost:
        r7 = r7 + 1;
        r37.append('1');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:396:0x07d0, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x07d3, code lost:
        r4 = r3;
        r3 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x07d7, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:399:0x07da, code lost:
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:400:0x07dd, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:401:0x07e0, code lost:
        r12 = r11;
        r34 = r6;
        r6 = r8;
        r8 = r7;
        r7 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:402:0x07e9, code lost:
        r13 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x07ec, code lost:
        r14 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:404:0x07f0, code lost:
        r7 = r20;
        r8 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x07f5, code lost:
        r7 = r20;
        r8 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:406:0x07fa, code lost:
        r16 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:407:0x07fe, code lost:
        r9 = r11;
        r10 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:408:0x0803, code lost:
        r9 = r21;
        r14 = r18;
        r15 = r18;
        r8 = r19;
        r18 = r13;
        r13 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:409:0x0811, code lost:
        r6 = r8;
        r11 = r9;
        r4 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x0816, code lost:
        r7 = true;
        r14 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:411:0x081b, code lost:
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:412:0x081e, code lost:
        r14 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x0822, code lost:
        r16 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x0826, code lost:
        r7 = false;
        r9 = r11;
        r10 = r8;
        r8 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x082c, code lost:
        r14 = r8;
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x0830, code lost:
        r8 = 2;
        r14 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x0834, code lost:
        r16 = r4;
        r34 = r8;
        r8 = r14;
        r14 = r34;
        r15 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:418:0x0841, code lost:
        r7 = r39;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01a1, code lost:
        if (r11 < 0) goto L_0x03f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a5, code lost:
        if (r11 > 14) goto L_0x03f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a7, code lost:
        if (r9 == false) goto L_0x03f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01a9, code lost:
        r7 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01ab, code lost:
        if (r6 <= 0) goto L_0x028f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01ad, code lost:
        r14 = f6821a[r6 & 15];
        r8 = r6 >> 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01b7, code lost:
        if ((r8 & true) == false) goto L_0x0834;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01b9, code lost:
        r16 = r4 / f6822b[4];
        r34 = r14;
        r14 = r8 & 15;
        r15 = 0;
        r7 = 3;
        r8 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01cb, code lost:
        if (r14 == 0) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01cf, code lost:
        if ((r14 & 1) == 0) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01d1, code lost:
        r7 = r7 + 1;
        r8 = r8 * f6822b[r15];
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m6800a(StringBuilder r37, int r38, int r39, double r40) {
        /*
            r2 = 1
            boolean[] r0 = new boolean[r2]
            r26 = r0
            r2 = 2
            r0 = r38
            if (r0 != r2) goto L_0x001e
            r2 = 4921056587992461136(0x444b1ae4d6e2ef50, double:1.0E21)
            int r2 = (r40 > r2 ? 1 : (r40 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x001c
            r2 = -4302315448862314672(0xc44b1ae4d6e2ef50, double:-1.0E21)
            int r2 = (r40 > r2 ? 1 : (r40 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x001e
        L_0x001c:
            r38 = 0
        L_0x001e:
            int[] r2 = f6823c
            r8 = r2[r38]
            r2 = 2
            r0 = r38
            if (r0 < r2) goto L_0x00ed
            r2 = 1
        L_0x0028:
            r3 = 1
            int[] r0 = new int[r3]
            r27 = r0
            r3 = 1
            int[] r0 = new int[r3]
            r28 = r0
            int r3 = m6795a(r40)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x00f0
            r3 = 0
            r4 = 1
            r26[r3] = r4
            int r3 = m6795a(r40)
            r4 = 2147483647(0x7fffffff, float:NaN)
            r3 = r3 & r4
            r0 = r40
            double r4 = m6794a(r0, r3)
        L_0x004d:
            int r3 = m6795a(r4)
            r6 = 2146435072(0x7ff00000, float:NaN)
            r3 = r3 & r6
            r6 = 2146435072(0x7ff00000, float:NaN)
            if (r3 != r6) goto L_0x00fc
            long r2 = java.lang.Double.doubleToLongBits(r4)
            int r2 = (int) r2
            if (r2 != 0) goto L_0x00f8
            int r2 = m6795a(r4)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            if (r2 != 0) goto L_0x00f8
            java.lang.String r2 = "Infinity"
        L_0x006b:
            r0 = r37
            r0.append(r2)
            r2 = 9999(0x270f, float:1.4012E-41)
        L_0x0072:
            int r4 = r37.length()
            r3 = 9999(0x270f, float:1.4012E-41)
            if (r2 == r3) goto L_0x00b4
            r5 = 0
            r3 = 0
            switch(r38) {
                case 0: goto L_0x0777;
                case 1: goto L_0x078d;
                case 2: goto L_0x0784;
                case 3: goto L_0x078f;
                case 4: goto L_0x0795;
                default: goto L_0x007f;
            }
        L_0x007f:
            if (r4 >= r3) goto L_0x07c9
        L_0x0081:
            r4 = 48
            r0 = r37
            r0.append(r4)
            int r4 = r37.length()
            if (r4 != r3) goto L_0x0081
        L_0x008e:
            if (r5 == 0) goto L_0x07a2
            r4 = 1
            if (r3 == r4) goto L_0x009b
            r3 = 1
            r4 = 46
            r0 = r37
            r0.insert(r3, r4)
        L_0x009b:
            r3 = 101(0x65, float:1.42E-43)
            r0 = r37
            r0.append(r3)
            int r3 = r2 + -1
            if (r3 < 0) goto L_0x00ad
            r3 = 43
            r0 = r37
            r0.append(r3)
        L_0x00ad:
            int r2 = r2 + -1
            r0 = r37
            r0.append(r2)
        L_0x00b4:
            r2 = 0
            boolean r2 = r26[r2]
            if (r2 == 0) goto L_0x00ec
            int r2 = m6795a(r40)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 != r3) goto L_0x00c8
            long r2 = java.lang.Double.doubleToLongBits(r40)
            int r2 = (int) r2
            if (r2 == 0) goto L_0x00ec
        L_0x00c8:
            int r2 = m6795a(r40)
            r3 = 2146435072(0x7ff00000, float:NaN)
            r2 = r2 & r3
            r3 = 2146435072(0x7ff00000, float:NaN)
            if (r2 != r3) goto L_0x00e4
            long r2 = java.lang.Double.doubleToLongBits(r40)
            int r2 = (int) r2
            if (r2 != 0) goto L_0x00ec
            int r2 = m6795a(r40)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            if (r2 != 0) goto L_0x00ec
        L_0x00e4:
            r2 = 0
            r3 = 45
            r0 = r37
            r0.insert(r2, r3)
        L_0x00ec:
            return
        L_0x00ed:
            r2 = 0
            goto L_0x0028
        L_0x00f0:
            r3 = 0
            r4 = 0
            r26[r3] = r4
            r4 = r40
            goto L_0x004d
        L_0x00f8:
            java.lang.String r2 = "NaN"
            goto L_0x006b
        L_0x00fc:
            r6 = 0
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0112
            r2 = 0
            r0 = r37
            r0.setLength(r2)
            r2 = 48
            r0 = r37
            r0.append(r2)
            r2 = 1
            goto L_0x0072
        L_0x0112:
            r0 = r27
            r1 = r28
            java.math.BigInteger r20 = m6798a(r4, r0, r1)
            int r3 = m6795a(r4)
            int r3 = r3 >>> 20
            r3 = r3 & 2047(0x7ff, float:2.868E-42)
            if (r3 == 0) goto L_0x01de
            int r6 = m6795a(r4)
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r6 & r7
            r7 = 1072693248(0x3ff00000, float:1.875)
            r6 = r6 | r7
            double r6 = m6794a(r4, r6)
            int r9 = r3 + -1023
            r3 = 0
            r25 = r3
        L_0x0138:
            r10 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            double r6 = r6 - r10
            r10 = 4598887322496222049(0x3fd287a7636f4361, double:0.289529654602168)
            double r6 = r6 * r10
            r10 = 4595512376519870643(0x3fc68a288b60c8b3, double:0.1760912590558)
            double r6 = r6 + r10
            double r10 = (double) r9
            r12 = 4599094494223104507(0x3fd34413509f79fb, double:0.301029995663981)
            double r10 = r10 * r12
            double r6 = r6 + r10
            int r3 = (int) r6
            r10 = 0
            int r10 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x015d
            double r10 = (double) r3
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x015d
            int r3 = r3 + -1
        L_0x015d:
            r6 = 1
            if (r3 < 0) goto L_0x084d
            r7 = 22
            if (r3 > r7) goto L_0x084d
            double[] r6 = f6821a
            r6 = r6[r3]
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x016e
            int r3 = r3 + -1
        L_0x016e:
            r6 = 0
            r34 = r6
            r6 = r3
            r3 = r34
        L_0x0174:
            r7 = 0
            r7 = r28[r7]
            int r7 = r7 - r9
            int r21 = r7 + -1
            if (r21 < 0) goto L_0x021b
            r19 = 0
        L_0x017e:
            if (r6 < 0) goto L_0x0224
            r18 = 0
            int r21 = r21 + r6
            r13 = r6
        L_0x0185:
            if (r8 < 0) goto L_0x018b
            r7 = 9
            if (r8 <= r7) goto L_0x018c
        L_0x018b:
            r8 = 0
        L_0x018c:
            r7 = 1
            r9 = 5
            if (r8 <= r9) goto L_0x0848
            int r8 = r8 + -4
            r7 = 0
            r9 = r7
            r24 = r8
        L_0x0196:
            r7 = 1
            r12 = 0
            switch(r24) {
                case 0: goto L_0x022c;
                case 1: goto L_0x022c;
                case 2: goto L_0x0235;
                case 3: goto L_0x0241;
                case 4: goto L_0x0845;
                case 5: goto L_0x0242;
                default: goto L_0x019b;
            }
        L_0x019b:
            r22 = r7
            r11 = r12
            r23 = r39
        L_0x01a0:
            r10 = 0
            if (r11 < 0) goto L_0x03f2
            r7 = 14
            if (r11 > r7) goto L_0x03f2
            if (r9 == 0) goto L_0x03f2
            r9 = 0
            r7 = 2
            if (r6 <= 0) goto L_0x028f
            double[] r8 = f6821a
            r14 = r6 & 15
            r14 = r8[r14]
            int r8 = r6 >> 4
            r16 = r8 & 16
            if (r16 == 0) goto L_0x0834
            r7 = r8 & 15
            double[] r8 = f6822b
            r16 = 4
            r16 = r8[r16]
            double r16 = r4 / r16
            r8 = 3
            r34 = r14
            r14 = r7
            r15 = r9
            r7 = r8
            r8 = r34
        L_0x01cb:
            if (r14 == 0) goto L_0x024e
            r29 = r14 & 1
            if (r29 == 0) goto L_0x01d9
            int r7 = r7 + 1
            double[] r29 = f6822b
            r30 = r29[r15]
            double r8 = r8 * r30
        L_0x01d9:
            int r14 = r14 >> 1
            int r15 = r15 + 1
            goto L_0x01cb
        L_0x01de:
            r3 = 0
            r3 = r28[r3]
            r6 = 0
            r6 = r27[r6]
            int r3 = r3 + r6
            int r3 = r3 + 1074
            r6 = 32
            if (r3 <= r6) goto L_0x0211
            int r6 = m6795a(r4)
            long r6 = (long) r6
            int r9 = 64 - r3
            long r6 = r6 << r9
            long r10 = java.lang.Double.doubleToLongBits(r4)
            int r9 = (int) r10
            int r10 = r3 + -32
            int r9 = r9 >>> r10
            long r10 = (long) r9
            long r6 = r6 | r10
        L_0x01fd:
            double r10 = (double) r6
            double r6 = (double) r6
            int r6 = m6795a(r6)
            r7 = 32505856(0x1f00000, float:8.8162076E-38)
            int r6 = r6 - r7
            double r6 = m6794a(r10, r6)
            int r9 = r3 + -1075
            r3 = 1
            r25 = r3
            goto L_0x0138
        L_0x0211:
            long r6 = java.lang.Double.doubleToLongBits(r4)
            int r6 = (int) r6
            long r6 = (long) r6
            int r9 = 32 - r3
            long r6 = r6 << r9
            goto L_0x01fd
        L_0x021b:
            r0 = r21
            int r0 = -r0
            r19 = r0
            r21 = 0
            goto L_0x017e
        L_0x0224:
            int r19 = r19 - r6
            int r0 = -r6
            r18 = r0
            r13 = 0
            goto L_0x0185
        L_0x022c:
            r12 = -1
            r8 = 0
            r22 = r7
            r11 = r12
            r23 = r8
            goto L_0x01a0
        L_0x0235:
            r8 = 0
        L_0x0236:
            if (r39 > 0) goto L_0x0841
            r7 = 1
        L_0x0239:
            r22 = r8
            r12 = r7
            r11 = r7
            r23 = r7
            goto L_0x01a0
        L_0x0241:
            r7 = 0
        L_0x0242:
            int r8 = r39 + r6
            int r11 = r8 + 1
            int r12 = r11 + -1
            r22 = r7
            r23 = r39
            goto L_0x01a0
        L_0x024e:
            double r14 = r16 / r8
            r8 = r7
        L_0x0251:
            if (r3 == 0) goto L_0x0826
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r7 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r7 >= 0) goto L_0x0826
            if (r11 <= 0) goto L_0x0826
            if (r12 > 0) goto L_0x02b7
            r7 = 1
            r9 = r11
            r10 = r8
            r8 = r6
        L_0x0261:
            double r0 = (double) r10
            r16 = r0
            double r16 = r16 * r14
            r30 = 4619567317775286272(0x401c000000000000, double:7.0)
            double r16 = r16 + r30
            int r10 = m6795a(r16)
            r29 = 54525952(0x3400000, float:5.642373E-37)
            int r10 = r10 - r29
            r0 = r16
            double r30 = m6794a(r0, r10)
            if (r9 != 0) goto L_0x0822
            r16 = 4617315517961601024(0x4014000000000000, double:5.0)
            double r16 = r14 - r16
            int r7 = (r16 > r30 ? 1 : (r16 == r30 ? 0 : -1))
            if (r7 <= 0) goto L_0x02c7
            r2 = 49
            r0 = r37
            r0.append(r2)
            int r7 = r8 + 1
        L_0x028b:
            int r2 = r7 + 1
            goto L_0x0072
        L_0x028f:
            int r8 = -r6
            if (r8 == 0) goto L_0x0830
            double[] r14 = f6821a
            r15 = r8 & 15
            r14 = r14[r15]
            double r14 = r14 * r4
            int r8 = r8 >> 4
            r34 = r8
            r35 = r9
            r8 = r14
            r14 = r34
            r15 = r35
        L_0x02a4:
            if (r14 == 0) goto L_0x082c
            r16 = r14 & 1
            if (r16 == 0) goto L_0x02b2
            int r7 = r7 + 1
            double[] r16 = f6822b
            r16 = r16[r15]
            double r8 = r8 * r16
        L_0x02b2:
            int r14 = r14 >> 1
            int r15 = r15 + 1
            goto L_0x02a4
        L_0x02b7:
            int r7 = r6 + -1
            r16 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r14 = r14 * r16
            int r8 = r8 + 1
            r9 = r12
            r34 = r7
            r7 = r10
            r10 = r8
            r8 = r34
            goto L_0x0261
        L_0x02c7:
            r0 = r30
            double r14 = -r0
            int r7 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r7 >= 0) goto L_0x02de
            r2 = 0
            r0 = r37
            r0.setLength(r2)
            r2 = 48
            r0 = r37
            r0.append(r2)
            r2 = 1
            goto L_0x0072
        L_0x02de:
            r7 = 1
        L_0x02df:
            if (r7 != 0) goto L_0x081e
            r10 = 1
            if (r22 == 0) goto L_0x035b
            r14 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double[] r7 = f6821a
            int r29 = r9 + -1
            r32 = r7[r29]
            double r14 = r14 / r32
            double r14 = r14 - r30
            r7 = 0
        L_0x02f1:
            r0 = r16
            long r0 = (long) r0
            r30 = r0
            r0 = r30
            double r0 = (double) r0
            r32 = r0
            double r16 = r16 - r32
            r32 = 48
            long r30 = r30 + r32
            r0 = r30
            int r0 = (int) r0
            r29 = r0
            r0 = r29
            char r0 = (char) r0
            r29 = r0
            r0 = r37
            r1 = r29
            r0.append(r1)
            int r29 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r29 < 0) goto L_0x081b
            r30 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r30 = r30 - r16
            int r29 = (r30 > r14 ? 1 : (r30 == r14 ? 0 : -1))
            if (r29 >= 0) goto L_0x034e
        L_0x031e:
            int r2 = r37.length()
            int r2 = r2 + -1
            r0 = r37
            char r2 = r0.charAt(r2)
            int r3 = r37.length()
            int r3 = r3 + -1
            r0 = r37
            r0.setLength(r3)
            r3 = 57
            if (r2 != r3) goto L_0x0343
            int r2 = r37.length()
            if (r2 != 0) goto L_0x031e
            int r8 = r8 + 1
            r2 = 48
        L_0x0343:
            int r2 = r2 + 1
            char r2 = (char) r2
            r0 = r37
            r0.append(r2)
            r7 = r8
            goto L_0x028b
        L_0x034e:
            int r7 = r7 + 1
            if (r7 >= r9) goto L_0x0816
            r30 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r14 = r14 * r30
            r30 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r16 = r16 * r30
            goto L_0x02f1
        L_0x035b:
            double[] r7 = f6821a
            int r14 = r9 + -1
            r14 = r7[r14]
            double r30 = r30 * r14
            r7 = 1
        L_0x0364:
            r0 = r16
            long r0 = (long) r0
            r32 = r0
            r0 = r32
            double r14 = (double) r0
            double r14 = r16 - r14
            r16 = 48
            long r16 = r16 + r32
            r0 = r16
            int r0 = (int) r0
            r16 = r0
            r0 = r16
            char r0 = (char) r0
            r16 = r0
            r0 = r37
            r1 = r16
            r0.append(r1)
            if (r7 != r9) goto L_0x03e1
            r16 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r16 = r16 + r30
            int r7 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r7 <= 0) goto L_0x03bd
        L_0x038d:
            int r2 = r37.length()
            int r2 = r2 + -1
            r0 = r37
            char r2 = r0.charAt(r2)
            int r3 = r37.length()
            int r3 = r3 + -1
            r0 = r37
            r0.setLength(r3)
            r3 = 57
            if (r2 != r3) goto L_0x03b2
            int r2 = r37.length()
            if (r2 != 0) goto L_0x038d
            int r8 = r8 + 1
            r2 = 48
        L_0x03b2:
            int r2 = r2 + 1
            char r2 = (char) r2
            r0 = r37
            r0.append(r2)
            r7 = r8
            goto L_0x028b
        L_0x03bd:
            r16 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r16 = r16 - r30
            int r7 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r7 >= 0) goto L_0x03e9
            r7 = r8
        L_0x03c6:
            int r2 = r37.length()
        L_0x03ca:
            int r3 = r2 + -1
            if (r2 <= 0) goto L_0x03d8
            r0 = r37
            char r2 = r0.charAt(r3)
            r4 = 48
            if (r2 == r4) goto L_0x07d0
        L_0x03d8:
            int r2 = r3 + 1
            r0 = r37
            r0.setLength(r2)
            goto L_0x028b
        L_0x03e1:
            int r7 = r7 + 1
            r16 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r16 = r16 * r14
            goto L_0x0364
        L_0x03e9:
            r7 = r10
        L_0x03ea:
            if (r7 == 0) goto L_0x0811
            r7 = 0
            r0 = r37
            r0.setLength(r7)
        L_0x03f2:
            r7 = 0
            r7 = r27[r7]
            if (r7 < 0) goto L_0x0494
            r7 = 14
            if (r6 > r7) goto L_0x0494
            double[] r3 = f6821a
            r8 = r3[r6]
            if (r23 >= 0) goto L_0x0430
            if (r11 > 0) goto L_0x0430
            if (r11 < 0) goto L_0x0415
            r10 = 4617315517961601024(0x4014000000000000, double:5.0)
            double r10 = r10 * r8
            int r3 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r3 < 0) goto L_0x0415
            if (r2 != 0) goto L_0x0425
            r2 = 4617315517961601024(0x4014000000000000, double:5.0)
            double r2 = r2 * r8
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0425
        L_0x0415:
            r2 = 0
            r0 = r37
            r0.setLength(r2)
            r2 = 48
            r0 = r37
            r0.append(r2)
            r2 = 1
            goto L_0x0072
        L_0x0425:
            r2 = 49
            r0 = r37
            r0.append(r2)
            int r7 = r6 + 1
            goto L_0x028b
        L_0x0430:
            r3 = 1
        L_0x0431:
            double r12 = r4 / r8
            long r12 = (long) r12
            double r14 = (double) r12
            double r14 = r14 * r8
            double r4 = r4 - r14
            r14 = 48
            long r14 = r14 + r12
            int r7 = (int) r14
            char r7 = (char) r7
            r0 = r37
            r0.append(r7)
            if (r3 != r11) goto L_0x0488
            double r4 = r4 + r4
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 > 0) goto L_0x0457
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x0484
            r4 = 1
            long r4 = r4 & r12
            r8 = 0
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x0457
            if (r2 == 0) goto L_0x0484
        L_0x0457:
            int r2 = r37.length()
            int r2 = r2 + -1
            r0 = r37
            char r2 = r0.charAt(r2)
            int r3 = r37.length()
            int r3 = r3 + -1
            r0 = r37
            r0.setLength(r3)
            r3 = 57
            if (r2 != r3) goto L_0x047c
            int r2 = r37.length()
            if (r2 != 0) goto L_0x0457
            int r6 = r6 + 1
            r2 = 48
        L_0x047c:
            int r2 = r2 + 1
            char r2 = (char) r2
            r0 = r37
            r0.append(r2)
        L_0x0484:
            int r2 = r6 + 1
            goto L_0x0072
        L_0x0488:
            r12 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r4 = r4 * r12
            r12 = 0
            int r7 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r7 == 0) goto L_0x0484
            int r3 = r3 + 1
            goto L_0x0431
        L_0x0494:
            r10 = 0
            if (r22 == 0) goto L_0x0803
            r7 = 2
            r0 = r24
            if (r0 >= r7) goto L_0x054d
            if (r25 == 0) goto L_0x0546
            r7 = 0
            r7 = r27[r7]
            int r7 = r7 + 1075
        L_0x04a3:
            r8 = r18
            r9 = r7
            r10 = r19
            r7 = r13
        L_0x04a9:
            int r19 = r19 + r9
            int r9 = r9 + r21
            r14 = 1
            java.math.BigInteger r13 = java.math.BigInteger.valueOf(r14)
            r14 = r8
            r15 = r18
            r18 = r7
            r8 = r10
            r10 = r13
            r13 = r19
        L_0x04bc:
            if (r8 <= 0) goto L_0x07fa
            if (r9 <= 0) goto L_0x07fa
            if (r8 >= r9) goto L_0x0565
            r7 = r8
        L_0x04c3:
            int r13 = r13 - r7
            int r8 = r8 - r7
            int r9 = r9 - r7
            r16 = r8
        L_0x04c8:
            if (r15 <= 0) goto L_0x07f5
            if (r22 == 0) goto L_0x0568
            if (r14 <= 0) goto L_0x07f0
            java.math.BigInteger r8 = m6799a(r10, r14)
            r0 = r20
            java.math.BigInteger r7 = r8.multiply(r0)
        L_0x04d8:
            int r10 = r15 - r14
            if (r10 == 0) goto L_0x04e0
            java.math.BigInteger r7 = m6799a(r7, r10)
        L_0x04e0:
            r14 = 1
            java.math.BigInteger r15 = java.math.BigInteger.valueOf(r14)
            if (r18 <= 0) goto L_0x04ee
            r0 = r18
            java.math.BigInteger r15 = m6799a(r15, r0)
        L_0x04ee:
            r10 = 0
            r14 = 2
            r0 = r24
            if (r0 >= r14) goto L_0x0517
            long r20 = java.lang.Double.doubleToLongBits(r4)
            r0 = r20
            int r14 = (int) r0
            if (r14 != 0) goto L_0x0517
            int r14 = m6795a(r4)
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r14 = r14 & r17
            if (r14 != 0) goto L_0x0517
            int r14 = m6795a(r4)
            r17 = 2145386496(0x7fe00000, float:NaN)
            r14 = r14 & r17
            if (r14 == 0) goto L_0x0517
            int r13 = r13 + 1
            int r9 = r9 + 1
            r10 = 1
        L_0x0517:
            byte[] r19 = r15.toByteArray()
            r17 = 0
            r14 = 0
            r34 = r14
            r14 = r17
            r17 = r34
        L_0x0524:
            r20 = 4
            r0 = r17
            r1 = r20
            if (r0 >= r1) goto L_0x0571
            int r14 = r14 << 8
            r0 = r19
            int r0 = r0.length
            r20 = r0
            r0 = r17
            r1 = r20
            if (r0 >= r1) goto L_0x0543
            byte r20 = r19[r17]
            r0 = r20
            r0 = r0 & 255(0xff, float:3.57E-43)
            r20 = r0
            r14 = r14 | r20
        L_0x0543:
            int r17 = r17 + 1
            goto L_0x0524
        L_0x0546:
            r7 = 0
            r7 = r28[r7]
            int r7 = 54 - r7
            goto L_0x04a3
        L_0x054d:
            int r7 = r11 + -1
            r0 = r18
            if (r0 < r7) goto L_0x055d
            int r8 = r18 - r7
            r7 = r13
        L_0x0556:
            if (r11 >= 0) goto L_0x07fe
            int r10 = r19 - r11
            r9 = 0
            goto L_0x04a9
        L_0x055d:
            int r8 = r7 - r18
            int r7 = r13 + r8
            int r18 = r18 + r8
            r8 = 0
            goto L_0x0556
        L_0x0565:
            r7 = r9
            goto L_0x04c3
        L_0x0568:
            r0 = r20
            java.math.BigInteger r7 = m6799a(r0, r15)
            r8 = r10
            goto L_0x04e0
        L_0x0571:
            if (r18 == 0) goto L_0x05eb
            int r14 = m6803b(r14)
            int r14 = 32 - r14
        L_0x0579:
            int r14 = r14 + r9
            r14 = r14 & 31
            if (r14 == 0) goto L_0x0580
            int r14 = 32 - r14
        L_0x0580:
            r17 = 4
            r0 = r17
            if (r14 <= r0) goto L_0x05ed
            int r17 = r14 + -4
            int r13 = r13 + r17
            int r14 = r16 + r17
            int r9 = r9 + r17
        L_0x058e:
            if (r13 <= 0) goto L_0x0594
            java.math.BigInteger r7 = r7.shiftLeft(r13)
        L_0x0594:
            if (r9 <= 0) goto L_0x07e9
            java.math.BigInteger r9 = r15.shiftLeft(r9)
            r13 = r9
        L_0x059b:
            if (r3 == 0) goto L_0x07e0
            int r3 = r7.compareTo(r13)
            if (r3 >= 0) goto L_0x07e0
            int r6 = r6 + -1
            r16 = 10
            java.math.BigInteger r3 = java.math.BigInteger.valueOf(r16)
            java.math.BigInteger r3 = r7.multiply(r3)
            if (r22 == 0) goto L_0x05bb
            r16 = 10
            java.math.BigInteger r7 = java.math.BigInteger.valueOf(r16)
            java.math.BigInteger r8 = r8.multiply(r7)
        L_0x05bb:
            r7 = r6
            r6 = r8
            r8 = r3
        L_0x05be:
            if (r12 > 0) goto L_0x0607
            r3 = 2
            r0 = r24
            if (r0 <= r3) goto L_0x0607
            if (r12 < 0) goto L_0x05db
            r4 = 5
            java.math.BigInteger r3 = java.math.BigInteger.valueOf(r4)
            java.math.BigInteger r3 = r13.multiply(r3)
            int r3 = r8.compareTo(r3)
            if (r3 < 0) goto L_0x05db
            if (r3 != 0) goto L_0x05fc
            if (r2 != 0) goto L_0x05fc
        L_0x05db:
            r2 = 0
            r0 = r37
            r0.setLength(r2)
            r2 = 48
            r0 = r37
            r0.append(r2)
            r2 = 1
            goto L_0x0072
        L_0x05eb:
            r14 = 1
            goto L_0x0579
        L_0x05ed:
            r17 = 4
            r0 = r17
            if (r14 >= r0) goto L_0x07ec
            int r17 = r14 + 28
            int r13 = r13 + r17
            int r14 = r16 + r17
            int r9 = r9 + r17
            goto L_0x058e
        L_0x05fc:
            r2 = 49
            r0 = r37
            r0.append(r2)
            int r7 = r7 + 1
            goto L_0x028b
        L_0x0607:
            if (r22 == 0) goto L_0x072a
            if (r14 <= 0) goto L_0x060f
            java.math.BigInteger r6 = r6.shiftLeft(r14)
        L_0x060f:
            if (r10 == 0) goto L_0x07dd
            r3 = 1
            java.math.BigInteger r3 = r6.shiftLeft(r3)
        L_0x0616:
            r9 = 1
            r10 = r9
            r9 = r3
            r3 = r8
        L_0x061a:
            java.math.BigInteger[] r3 = r3.divideAndRemainder(r13)
            r8 = 1
            r8 = r3[r8]
            r11 = 0
            r3 = r3[r11]
            int r3 = r3.intValue()
            int r3 = r3 + 48
            char r3 = (char) r3
            int r14 = r8.compareTo(r6)
            java.math.BigInteger r11 = r13.subtract(r9)
            int r15 = r11.signum()
            if (r15 > 0) goto L_0x0667
            r11 = 1
        L_0x063a:
            if (r11 != 0) goto L_0x0678
            if (r24 != 0) goto L_0x0678
            long r16 = java.lang.Double.doubleToLongBits(r4)
            r0 = r16
            int r15 = (int) r0
            r15 = r15 & 1
            if (r15 != 0) goto L_0x0678
            r2 = 57
            if (r3 != r2) goto L_0x066c
            r2 = 57
            r0 = r37
            r0.append(r2)
            boolean r2 = m6802a(r37)
            if (r2 == 0) goto L_0x07da
            int r2 = r7 + 1
            r3 = 49
            r0 = r37
            r0.append(r3)
        L_0x0663:
            int r2 = r2 + 1
            goto L_0x0072
        L_0x0667:
            int r11 = r8.compareTo(r11)
            goto L_0x063a
        L_0x066c:
            if (r14 <= 0) goto L_0x07d7
            int r2 = r3 + 1
            char r2 = (char) r2
        L_0x0671:
            r0 = r37
            r0.append(r2)
            goto L_0x028b
        L_0x0678:
            if (r14 < 0) goto L_0x0687
            if (r14 != 0) goto L_0x06c6
            if (r24 != 0) goto L_0x06c6
            long r14 = java.lang.Double.doubleToLongBits(r4)
            int r14 = (int) r14
            r14 = r14 & 1
            if (r14 != 0) goto L_0x06c6
        L_0x0687:
            if (r11 <= 0) goto L_0x06bf
            r4 = 1
            java.math.BigInteger r4 = r8.shiftLeft(r4)
            int r4 = r4.compareTo(r13)
            if (r4 > 0) goto L_0x069d
            if (r4 != 0) goto L_0x06bf
            r4 = r3 & 1
            r5 = 1
            if (r4 == r5) goto L_0x069d
            if (r2 == 0) goto L_0x06bf
        L_0x069d:
            int r2 = r3 + 1
            char r2 = (char) r2
            r4 = 57
            if (r3 != r4) goto L_0x06be
            r2 = 57
            r0 = r37
            r0.append(r2)
            boolean r2 = m6802a(r37)
            if (r2 == 0) goto L_0x06ba
            int r7 = r7 + 1
            r2 = 49
            r0 = r37
            r0.append(r2)
        L_0x06ba:
            int r2 = r7 + 1
            goto L_0x0072
        L_0x06be:
            r3 = r2
        L_0x06bf:
            r0 = r37
            r0.append(r3)
            goto L_0x028b
        L_0x06c6:
            if (r11 <= 0) goto L_0x06f0
            r2 = 57
            if (r3 != r2) goto L_0x06e6
            r2 = 57
            r0 = r37
            r0.append(r2)
            boolean r2 = m6802a(r37)
            if (r2 == 0) goto L_0x06e2
            int r7 = r7 + 1
            r2 = 49
            r0 = r37
            r0.append(r2)
        L_0x06e2:
            int r2 = r7 + 1
            goto L_0x0072
        L_0x06e6:
            int r2 = r3 + 1
            char r2 = (char) r2
            r0 = r37
            r0.append(r2)
            goto L_0x028b
        L_0x06f0:
            r0 = r37
            r0.append(r3)
            if (r10 == r12) goto L_0x07d3
            r14 = 10
            java.math.BigInteger r3 = java.math.BigInteger.valueOf(r14)
            java.math.BigInteger r8 = r8.multiply(r3)
            if (r6 != r9) goto L_0x0715
            r14 = 10
            java.math.BigInteger r3 = java.math.BigInteger.valueOf(r14)
            java.math.BigInteger r3 = r9.multiply(r3)
            r6 = r3
        L_0x070e:
            int r9 = r10 + 1
            r10 = r9
            r9 = r3
            r3 = r8
            goto L_0x061a
        L_0x0715:
            r14 = 10
            java.math.BigInteger r3 = java.math.BigInteger.valueOf(r14)
            java.math.BigInteger r6 = r6.multiply(r3)
            r14 = 10
            java.math.BigInteger r3 = java.math.BigInteger.valueOf(r14)
            java.math.BigInteger r3 = r9.multiply(r3)
            goto L_0x070e
        L_0x072a:
            r3 = 1
        L_0x072b:
            java.math.BigInteger[] r5 = r8.divideAndRemainder(r13)
            r4 = 1
            r4 = r5[r4]
            r6 = 0
            r5 = r5[r6]
            int r5 = r5.intValue()
            int r5 = r5 + 48
            char r5 = (char) r5
            r0 = r37
            r0.append(r5)
            if (r3 >= r12) goto L_0x0750
            r8 = 10
            java.math.BigInteger r5 = java.math.BigInteger.valueOf(r8)
            java.math.BigInteger r8 = r4.multiply(r5)
            int r3 = r3 + 1
            goto L_0x072b
        L_0x0750:
            r3 = r4
            r4 = r5
        L_0x0752:
            r5 = 1
            java.math.BigInteger r3 = r3.shiftLeft(r5)
            int r3 = r3.compareTo(r13)
            if (r3 > 0) goto L_0x0766
            if (r3 != 0) goto L_0x03c6
            r3 = r4 & 1
            r4 = 1
            if (r3 == r4) goto L_0x0766
            if (r2 == 0) goto L_0x03c6
        L_0x0766:
            boolean r2 = m6802a(r37)
            if (r2 == 0) goto L_0x028b
            int r7 = r7 + 1
            r2 = 49
            r0 = r37
            r0.append(r2)
            goto L_0x028b
        L_0x0777:
            r6 = -5
            if (r2 < r6) goto L_0x077e
            r6 = 21
            if (r2 <= r6) goto L_0x0781
        L_0x077e:
            r5 = 1
            goto L_0x007f
        L_0x0781:
            r3 = r2
            goto L_0x007f
        L_0x0784:
            if (r39 < 0) goto L_0x078a
            int r3 = r2 + r39
            goto L_0x007f
        L_0x078a:
            r3 = r2
            goto L_0x007f
        L_0x078d:
            r39 = r3
        L_0x078f:
            r3 = 1
            r5 = r3
            r3 = r39
            goto L_0x007f
        L_0x0795:
            r3 = -5
            if (r2 < r3) goto L_0x079c
            r0 = r39
            if (r2 <= r0) goto L_0x07cc
        L_0x079c:
            r3 = 1
            r5 = r3
            r3 = r39
            goto L_0x007f
        L_0x07a2:
            if (r2 == r3) goto L_0x00b4
            if (r2 <= 0) goto L_0x07af
            r3 = 46
            r0 = r37
            r0.insert(r2, r3)
            goto L_0x00b4
        L_0x07af:
            r3 = 0
        L_0x07b0:
            int r4 = 1 - r2
            if (r3 >= r4) goto L_0x07bf
            r4 = 0
            r5 = 48
            r0 = r37
            r0.insert(r4, r5)
            int r3 = r3 + 1
            goto L_0x07b0
        L_0x07bf:
            r2 = 1
            r3 = 46
            r0 = r37
            r0.insert(r2, r3)
            goto L_0x00b4
        L_0x07c9:
            r3 = r4
            goto L_0x008e
        L_0x07cc:
            r3 = r39
            goto L_0x007f
        L_0x07d0:
            r2 = r3
            goto L_0x03ca
        L_0x07d3:
            r4 = r3
            r3 = r8
            goto L_0x0752
        L_0x07d7:
            r2 = r3
            goto L_0x0671
        L_0x07da:
            r2 = r7
            goto L_0x0663
        L_0x07dd:
            r3 = r6
            goto L_0x0616
        L_0x07e0:
            r12 = r11
            r34 = r6
            r6 = r8
            r8 = r7
            r7 = r34
            goto L_0x05be
        L_0x07e9:
            r13 = r15
            goto L_0x059b
        L_0x07ec:
            r14 = r16
            goto L_0x058e
        L_0x07f0:
            r7 = r20
            r8 = r10
            goto L_0x04d8
        L_0x07f5:
            r7 = r20
            r8 = r10
            goto L_0x04e0
        L_0x07fa:
            r16 = r8
            goto L_0x04c8
        L_0x07fe:
            r9 = r11
            r10 = r19
            goto L_0x04a9
        L_0x0803:
            r9 = r21
            r14 = r18
            r15 = r18
            r8 = r19
            r18 = r13
            r13 = r19
            goto L_0x04bc
        L_0x0811:
            r6 = r8
            r11 = r9
            r4 = r14
            goto L_0x03f2
        L_0x0816:
            r7 = r10
            r14 = r16
            goto L_0x03ea
        L_0x081b:
            r7 = r8
            goto L_0x028b
        L_0x081e:
            r14 = r16
            goto L_0x03ea
        L_0x0822:
            r16 = r14
            goto L_0x02df
        L_0x0826:
            r7 = r10
            r9 = r11
            r10 = r8
            r8 = r6
            goto L_0x0261
        L_0x082c:
            r14 = r8
            r8 = r7
            goto L_0x0251
        L_0x0830:
            r8 = r7
            r14 = r4
            goto L_0x0251
        L_0x0834:
            r16 = r4
            r34 = r8
            r35 = r9
            r8 = r14
            r14 = r34
            r15 = r35
            goto L_0x01cb
        L_0x0841:
            r7 = r39
            goto L_0x0239
        L_0x0845:
            r8 = r7
            goto L_0x0236
        L_0x0848:
            r9 = r7
            r24 = r8
            goto L_0x0196
        L_0x084d:
            r34 = r6
            r6 = r3
            r3 = r34
            goto L_0x0174
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.DToA.m6800a(java.lang.StringBuilder, int, int, double):void");
    }
}
