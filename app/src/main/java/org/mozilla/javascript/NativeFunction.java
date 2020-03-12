package org.mozilla.javascript;

/* renamed from: org.mozilla.javascript.bl */
public abstract class NativeFunction extends BaseFunction {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo18680a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo18681b();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract int mo18683c();

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract int mo18684d();

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x05bd, code lost:
        r3 = r4;
        r5 = r8;
        r4 = r7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x05c2  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x021b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String decompile(int r22, int r23) {
        /*
            r21 = this;
            java.lang.String r12 = r21.mo18679a()
            if (r12 != 0) goto L_0x000b
            java.lang.String r2 = super.decompile(r22, r23)
        L_0x000a:
            return r2
        L_0x000b:
            org.mozilla.javascript.ei r2 = new org.mozilla.javascript.ei
            r3 = 1
            r2.<init>(r3)
            r3 = 1
            r0 = r22
            r2.mo19093b(r3, r0)
            int r13 = r12.length()
            if (r13 != 0) goto L_0x0020
            java.lang.String r2 = ""
            goto L_0x000a
        L_0x0020:
            r3 = 1
            r4 = 0
            int r6 = r2.mo19091a(r3, r4)
            if (r6 >= 0) goto L_0x002e
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            r2.<init>()
            throw r2
        L_0x002e:
            r3 = 2
            r4 = 4
            int r9 = r2.mo19091a(r3, r4)
            if (r9 >= 0) goto L_0x003c
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            r2.<init>()
            throw r2
        L_0x003c:
            r3 = 3
            r4 = 2
            int r14 = r2.mo19091a(r3, r4)
            if (r14 >= 0) goto L_0x004a
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            r2.<init>()
            throw r2
        L_0x004a:
            java.lang.StringBuffer r15 = new java.lang.StringBuffer
            r15.<init>()
            r2 = r23 & 1
            if (r2 == 0) goto L_0x007b
            r2 = 1
            r11 = r2
        L_0x0055:
            r2 = r23 & 2
            if (r2 == 0) goto L_0x007e
            r2 = 1
        L_0x005a:
            r8 = 0
            r7 = 0
            r4 = 0
            r3 = 0
            char r3 = r12.charAt(r3)
            r5 = 136(0x88, float:1.9E-43)
            if (r3 != r5) goto L_0x0080
            r4 = 1
            r3 = -1
            r10 = r3
        L_0x0069:
            if (r2 != 0) goto L_0x0087
            r3 = 10
            r15.append(r3)
            r3 = 0
        L_0x0071:
            if (r3 >= r6) goto L_0x008f
            r5 = 32
            r15.append(r5)
            int r3 = r3 + 1
            goto L_0x0071
        L_0x007b:
            r2 = 0
            r11 = r2
            goto L_0x0055
        L_0x007e:
            r2 = 0
            goto L_0x005a
        L_0x0080:
            r3 = 1
            char r3 = r12.charAt(r3)
            r10 = r3
            goto L_0x0069
        L_0x0087:
            r3 = 2
            if (r10 != r3) goto L_0x008f
            r3 = 40
            r15.append(r3)
        L_0x008f:
            if (r4 >= r13) goto L_0x05a5
            char r3 = r12.charAt(r4)
            switch(r3) {
                case 1: goto L_0x0209;
                case 2: goto L_0x0098;
                case 3: goto L_0x0098;
                case 4: goto L_0x034b;
                case 5: goto L_0x0098;
                case 6: goto L_0x0098;
                case 7: goto L_0x0098;
                case 8: goto L_0x0098;
                case 9: goto L_0x0447;
                case 10: goto L_0x0451;
                case 11: goto L_0x045b;
                case 12: goto L_0x0479;
                case 13: goto L_0x0483;
                case 14: goto L_0x0497;
                case 15: goto L_0x048d;
                case 16: goto L_0x04ab;
                case 17: goto L_0x04a1;
                case 18: goto L_0x04bf;
                case 19: goto L_0x04c9;
                case 20: goto L_0x04d3;
                case 21: goto L_0x0541;
                case 22: goto L_0x054b;
                case 23: goto L_0x0555;
                case 24: goto L_0x055f;
                case 25: goto L_0x0569;
                case 26: goto L_0x0505;
                case 27: goto L_0x050f;
                case 28: goto L_0x0519;
                case 29: goto L_0x0523;
                case 30: goto L_0x027d;
                case 31: goto L_0x0287;
                case 32: goto L_0x04dd;
                case 33: goto L_0x0098;
                case 34: goto L_0x0098;
                case 35: goto L_0x0098;
                case 36: goto L_0x0098;
                case 37: goto L_0x0098;
                case 38: goto L_0x0098;
                case 39: goto L_0x00d8;
                case 40: goto L_0x00e8;
                case 41: goto L_0x00e0;
                case 42: goto L_0x016d;
                case 43: goto L_0x0177;
                case 44: goto L_0x0163;
                case 45: goto L_0x0159;
                case 46: goto L_0x0465;
                case 47: goto L_0x046f;
                case 48: goto L_0x00d8;
                case 49: goto L_0x0098;
                case 50: goto L_0x02f5;
                case 51: goto L_0x0098;
                case 52: goto L_0x02af;
                case 53: goto L_0x04b5;
                case 54: goto L_0x0098;
                case 55: goto L_0x0098;
                case 56: goto L_0x0098;
                case 57: goto L_0x0098;
                case 58: goto L_0x0098;
                case 59: goto L_0x0098;
                case 60: goto L_0x0098;
                case 61: goto L_0x0098;
                case 62: goto L_0x0098;
                case 63: goto L_0x0098;
                case 64: goto L_0x0098;
                case 65: goto L_0x0098;
                case 66: goto L_0x040e;
                case 67: goto L_0x0098;
                case 68: goto L_0x0098;
                case 69: goto L_0x0098;
                case 70: goto L_0x0098;
                case 71: goto L_0x0098;
                case 72: goto L_0x04fb;
                case 73: goto L_0x0098;
                case 74: goto L_0x0098;
                case 75: goto L_0x0098;
                case 76: goto L_0x0098;
                case 77: goto L_0x0098;
                case 78: goto L_0x0098;
                case 79: goto L_0x0098;
                case 80: goto L_0x0098;
                case 81: goto L_0x02d7;
                case 82: goto L_0x0376;
                case 83: goto L_0x01f5;
                case 84: goto L_0x01ff;
                case 85: goto L_0x019b;
                case 86: goto L_0x01b0;
                case 87: goto L_0x01d4;
                case 88: goto L_0x01de;
                case 89: goto L_0x0191;
                case 90: goto L_0x038c;
                case 91: goto L_0x03c8;
                case 92: goto L_0x03d2;
                case 93: goto L_0x03dc;
                case 94: goto L_0x03e6;
                case 95: goto L_0x03f0;
                case 96: goto L_0x03fa;
                case 97: goto L_0x0396;
                case 98: goto L_0x03a0;
                case 99: goto L_0x03aa;
                case 100: goto L_0x03b4;
                case 101: goto L_0x03be;
                case 102: goto L_0x0404;
                case 103: goto L_0x0418;
                case 104: goto L_0x0433;
                case 105: goto L_0x043d;
                case 106: goto L_0x052d;
                case 107: goto L_0x0537;
                case 108: goto L_0x0273;
                case 109: goto L_0x0181;
                case 110: goto L_0x0098;
                case 111: goto L_0x0098;
                case 112: goto L_0x0291;
                case 113: goto L_0x029b;
                case 114: goto L_0x02ff;
                case 115: goto L_0x0337;
                case 116: goto L_0x0341;
                case 117: goto L_0x02c3;
                case 118: goto L_0x02cd;
                case 119: goto L_0x02a5;
                case 120: goto L_0x0309;
                case 121: goto L_0x0320;
                case 122: goto L_0x0362;
                case 123: goto L_0x02b9;
                case 124: goto L_0x02e1;
                case 125: goto L_0x02eb;
                case 126: goto L_0x04e7;
                case 127: goto L_0x0098;
                case 128: goto L_0x0098;
                case 129: goto L_0x0098;
                case 130: goto L_0x0098;
                case 131: goto L_0x0098;
                case 132: goto L_0x0098;
                case 133: goto L_0x0098;
                case 134: goto L_0x0098;
                case 135: goto L_0x0098;
                case 136: goto L_0x0098;
                case 137: goto L_0x0098;
                case 138: goto L_0x0098;
                case 139: goto L_0x0098;
                case 140: goto L_0x0098;
                case 141: goto L_0x0098;
                case 142: goto L_0x0098;
                case 143: goto L_0x057d;
                case 144: goto L_0x0573;
                case 145: goto L_0x0098;
                case 146: goto L_0x0587;
                case 147: goto L_0x0591;
                case 148: goto L_0x0098;
                case 149: goto L_0x0098;
                case 150: goto L_0x0098;
                case 151: goto L_0x00b5;
                case 152: goto L_0x00b5;
                case 153: goto L_0x036c;
                case 154: goto L_0x04f1;
                case 155: goto L_0x0098;
                case 156: goto L_0x0098;
                case 157: goto L_0x0098;
                case 158: goto L_0x0098;
                case 159: goto L_0x0098;
                case 160: goto L_0x059b;
                case 161: goto L_0x0098;
                case 162: goto L_0x0098;
                case 163: goto L_0x0098;
                case 164: goto L_0x018c;
                default: goto L_0x0098;
            }
        L_0x0098:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Token: "
            r3.<init>(r5)
            char r4 = r12.charAt(r4)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x00b5:
            char r3 = r12.charAt(r4)
            r5 = 151(0x97, float:2.12E-43)
            if (r3 != r5) goto L_0x00d5
            java.lang.String r3 = "get "
        L_0x00bf:
            r15.append(r3)
            int r3 = r4 + 1
            int r3 = r3 + 1
            r4 = 0
            int r3 = org.mozilla.javascript.Decompiler.m6805a(r12, r3, r4, r15)
            int r3 = r3 + 1
            r4 = r7
            r5 = r8
        L_0x00cf:
            int r3 = r3 + 1
            r7 = r4
            r8 = r5
            r4 = r3
            goto L_0x008f
        L_0x00d5:
            java.lang.String r3 = "set "
            goto L_0x00bf
        L_0x00d8:
            int r3 = r4 + 1
            r4 = 0
            int r4 = org.mozilla.javascript.Decompiler.m6805a(r12, r3, r4, r15)
            goto L_0x008f
        L_0x00e0:
            int r3 = r4 + 1
            r4 = 1
            int r4 = org.mozilla.javascript.Decompiler.m6805a(r12, r3, r4, r15)
            goto L_0x008f
        L_0x00e8:
            int r3 = r4 + 1
            char r4 = r12.charAt(r3)
            int r3 = r3 + 1
            r5 = 83
            if (r4 != r5) goto L_0x0108
            char r4 = r12.charAt(r3)
            double r4 = (double) r4
            int r3 = r3 + 1
        L_0x00fb:
            r16 = 10
            r0 = r16
            java.lang.String r4 = org.mozilla.javascript.ScriptRuntime.m6347a(r4, r0)
            r15.append(r4)
            r4 = r3
            goto L_0x008f
        L_0x0108:
            r5 = 74
            if (r4 == r5) goto L_0x0110
            r5 = 68
            if (r4 != r5) goto L_0x0153
        L_0x0110:
            char r5 = r12.charAt(r3)
            long r0 = (long) r5
            r16 = r0
            r5 = 48
            long r16 = r16 << r5
            int r5 = r3 + 1
            char r5 = r12.charAt(r5)
            long r0 = (long) r5
            r18 = r0
            r5 = 32
            long r18 = r18 << r5
            long r16 = r16 | r18
            int r5 = r3 + 2
            char r5 = r12.charAt(r5)
            long r0 = (long) r5
            r18 = r0
            r5 = 16
            long r18 = r18 << r5
            long r16 = r16 | r18
            int r5 = r3 + 3
            char r5 = r12.charAt(r5)
            long r0 = (long) r5
            r18 = r0
            long r16 = r16 | r18
            r5 = 74
            if (r4 != r5) goto L_0x014e
            r0 = r16
            double r4 = (double) r0
        L_0x014b:
            int r3 = r3 + 4
            goto L_0x00fb
        L_0x014e:
            double r4 = java.lang.Double.longBitsToDouble(r16)
            goto L_0x014b
        L_0x0153:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>()
            throw r2
        L_0x0159:
            java.lang.String r3 = "true"
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0163:
            java.lang.String r3 = "false"
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x016d:
            java.lang.String r3 = "null"
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0177:
            java.lang.String r3 = "this"
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0181:
            int r3 = r4 + 1
            java.lang.String r4 = "function "
            r15.append(r4)
            r4 = r7
            r5 = r8
            goto L_0x00cf
        L_0x018c:
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0191:
            java.lang.String r3 = ", "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x019b:
            int r5 = r8 + 1
            r3 = 1
            int r8 = org.mozilla.javascript.Decompiler.m6804a(r12, r13, r4)
            if (r3 != r8) goto L_0x05d3
            int r3 = r6 + r9
        L_0x01a6:
            r6 = 123(0x7b, float:1.72E-43)
            r15.append(r6)
            r6 = r3
            r3 = r4
            r4 = r7
            goto L_0x00cf
        L_0x01b0:
            int r3 = r8 + -1
            if (r11 == 0) goto L_0x01b6
            if (r3 == 0) goto L_0x05ce
        L_0x01b6:
            r5 = 125(0x7d, float:1.75E-43)
            r15.append(r5)
            int r5 = org.mozilla.javascript.Decompiler.m6804a(r12, r13, r4)
            switch(r5) {
                case 1: goto L_0x01c7;
                case 113: goto L_0x01cd;
                case 117: goto L_0x01cd;
                case 164: goto L_0x01c7;
                default: goto L_0x01c2;
            }
        L_0x01c2:
            r5 = r3
            r3 = r4
            r4 = r7
            goto L_0x00cf
        L_0x01c7:
            int r6 = r6 - r9
            r5 = r3
            r3 = r4
            r4 = r7
            goto L_0x00cf
        L_0x01cd:
            int r6 = r6 - r9
            r5 = 32
            r15.append(r5)
            goto L_0x01c2
        L_0x01d4:
            r3 = 40
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x01de:
            r3 = 41
            r15.append(r3)
            r3 = 85
            int r5 = org.mozilla.javascript.Decompiler.m6804a(r12, r13, r4)
            if (r3 != r5) goto L_0x05bd
            r3 = 32
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x01f5:
            r3 = 91
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x01ff:
            r3 = 93
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0209:
            if (r2 != 0) goto L_0x05bd
            r3 = 1
            if (r7 != 0) goto L_0x05ca
            r7 = 1
            if (r11 == 0) goto L_0x05ca
            r3 = 0
            r15.setLength(r3)
            int r6 = r6 - r9
            r3 = 0
            r5 = r3
            r3 = r7
        L_0x0219:
            if (r5 == 0) goto L_0x0220
            r5 = 10
            r15.append(r5)
        L_0x0220:
            int r5 = r4 + 1
            if (r5 >= r13) goto L_0x05c2
            r5 = 0
            int r7 = r4 + 1
            char r7 = r12.charAt(r7)
            r16 = 115(0x73, float:1.61E-43)
            r0 = r16
            if (r7 == r0) goto L_0x0237
            r16 = 116(0x74, float:1.63E-43)
            r0 = r16
            if (r7 != r0) goto L_0x0243
        L_0x0237:
            int r5 = r9 - r14
        L_0x0239:
            if (r5 >= r6) goto L_0x026b
            r7 = 32
            r15.append(r7)
            int r5 = r5 + 1
            goto L_0x0239
        L_0x0243:
            r16 = 86
            r0 = r16
            if (r7 != r0) goto L_0x024b
            r5 = r9
            goto L_0x0239
        L_0x024b:
            r16 = 39
            r0 = r16
            if (r7 != r0) goto L_0x0239
            int r7 = r4 + 2
            r16 = 0
            r17 = 0
            r0 = r16
            r1 = r17
            int r7 = org.mozilla.javascript.Decompiler.m6805a(r12, r7, r0, r1)
            char r7 = r12.charAt(r7)
            r16 = 103(0x67, float:1.44E-43)
            r0 = r16
            if (r7 != r0) goto L_0x0239
            r5 = r9
            goto L_0x0239
        L_0x026b:
            r5 = r8
            r20 = r3
            r3 = r4
            r4 = r20
            goto L_0x00cf
        L_0x0273:
            r3 = 46
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x027d:
            java.lang.String r3 = "new "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0287:
            java.lang.String r3 = "delete "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0291:
            java.lang.String r3 = "if "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x029b:
            java.lang.String r3 = "else "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x02a5:
            java.lang.String r3 = "for "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x02af:
            java.lang.String r3 = " in "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x02b9:
            java.lang.String r3 = "with "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x02c3:
            java.lang.String r3 = "while "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x02cd:
            java.lang.String r3 = "do "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x02d7:
            java.lang.String r3 = "try "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x02e1:
            java.lang.String r3 = "catch "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x02eb:
            java.lang.String r3 = "finally "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x02f5:
            java.lang.String r3 = "throw "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x02ff:
            java.lang.String r3 = "switch "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0309:
            java.lang.String r3 = "break"
            r15.append(r3)
            r3 = 39
            int r5 = org.mozilla.javascript.Decompiler.m6804a(r12, r13, r4)
            if (r3 != r5) goto L_0x05bd
            r3 = 32
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0320:
            java.lang.String r3 = "continue"
            r15.append(r3)
            r3 = 39
            int r5 = org.mozilla.javascript.Decompiler.m6804a(r12, r13, r4)
            if (r3 != r5) goto L_0x05bd
            r3 = 32
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0337:
            java.lang.String r3 = "case "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0341:
            java.lang.String r3 = "default"
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x034b:
            java.lang.String r3 = "return"
            r15.append(r3)
            r3 = 82
            int r5 = org.mozilla.javascript.Decompiler.m6804a(r12, r13, r4)
            if (r3 == r5) goto L_0x05bd
            r3 = 32
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0362:
            java.lang.String r3 = "var "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x036c:
            java.lang.String r3 = "let "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0376:
            r3 = 59
            r15.append(r3)
            r3 = 1
            int r5 = org.mozilla.javascript.Decompiler.m6804a(r12, r13, r4)
            if (r3 == r5) goto L_0x05bd
            r3 = 32
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x038c:
            java.lang.String r3 = " = "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0396:
            java.lang.String r3 = " += "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x03a0:
            java.lang.String r3 = " -= "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x03aa:
            java.lang.String r3 = " *= "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x03b4:
            java.lang.String r3 = " /= "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x03be:
            java.lang.String r3 = " %= "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x03c8:
            java.lang.String r3 = " |= "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x03d2:
            java.lang.String r3 = " ^= "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x03dc:
            java.lang.String r3 = " &= "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x03e6:
            java.lang.String r3 = " <<= "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x03f0:
            java.lang.String r3 = " >>= "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x03fa:
            java.lang.String r3 = " >>>= "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0404:
            java.lang.String r3 = " ? "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x040e:
            r3 = 58
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0418:
            r3 = 1
            int r5 = org.mozilla.javascript.Decompiler.m6804a(r12, r13, r4)
            if (r3 != r5) goto L_0x0429
            r3 = 58
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0429:
            java.lang.String r3 = " : "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0433:
            java.lang.String r3 = " || "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x043d:
            java.lang.String r3 = " && "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0447:
            java.lang.String r3 = " | "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0451:
            java.lang.String r3 = " ^ "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x045b:
            java.lang.String r3 = " & "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0465:
            java.lang.String r3 = " === "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x046f:
            java.lang.String r3 = " !== "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0479:
            java.lang.String r3 = " == "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0483:
            java.lang.String r3 = " != "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x048d:
            java.lang.String r3 = " <= "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0497:
            java.lang.String r3 = " < "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x04a1:
            java.lang.String r3 = " >= "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x04ab:
            java.lang.String r3 = " > "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x04b5:
            java.lang.String r3 = " instanceof "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x04bf:
            java.lang.String r3 = " << "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x04c9:
            java.lang.String r3 = " >> "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x04d3:
            java.lang.String r3 = " >>> "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x04dd:
            java.lang.String r3 = "typeof "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x04e7:
            java.lang.String r3 = "void "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x04f1:
            java.lang.String r3 = "const "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x04fb:
            java.lang.String r3 = "yield "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0505:
            r3 = 33
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x050f:
            r3 = 126(0x7e, float:1.77E-43)
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0519:
            r3 = 43
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0523:
            r3 = 45
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x052d:
            java.lang.String r3 = "++"
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0537:
            java.lang.String r3 = "--"
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0541:
            java.lang.String r3 = " + "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x054b:
            java.lang.String r3 = " - "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0555:
            java.lang.String r3 = " * "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x055f:
            java.lang.String r3 = " / "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0569:
            java.lang.String r3 = " % "
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0573:
            java.lang.String r3 = "::"
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x057d:
            java.lang.String r3 = ".."
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0587:
            java.lang.String r3 = ".("
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x0591:
            r3 = 64
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x059b:
            java.lang.String r3 = "debugger;\n"
            r15.append(r3)
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x05a5:
            if (r2 != 0) goto L_0x05b4
            if (r11 != 0) goto L_0x05ae
            r2 = 10
            r15.append(r2)
        L_0x05ae:
            java.lang.String r2 = r15.toString()
            goto L_0x000a
        L_0x05b4:
            r2 = 2
            if (r10 != r2) goto L_0x05ae
            r2 = 41
            r15.append(r2)
            goto L_0x05ae
        L_0x05bd:
            r3 = r4
            r5 = r8
            r4 = r7
            goto L_0x00cf
        L_0x05c2:
            r5 = r8
            r20 = r3
            r3 = r4
            r4 = r20
            goto L_0x00cf
        L_0x05ca:
            r5 = r3
            r3 = r7
            goto L_0x0219
        L_0x05ce:
            r5 = r3
            r3 = r4
            r4 = r7
            goto L_0x00cf
        L_0x05d3:
            r3 = r6
            goto L_0x01a6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeFunction.decompile(int, int):java.lang.String");
    }

    public int getLength() {
        int c = mo18683c();
        if (mo18681b() != 120) {
            return c;
        }
        NativeCall a = ScriptRuntime.m6359a(Context.m6769k(), (Function) this);
        return a != null ? a.f6302b.length : c;
    }

    public int getArity() {
        return mo18683c();
    }

    /* renamed from: a */
    public String mo18679a() {
        return null;
    }

    /* renamed from: a */
    public Object mo18677a(Context lVar, int i, Object obj, Object obj2) {
        throw new EvaluatorException("resumeGenerator() not implemented");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo18682b(int i) {
        return false;
    }
}
