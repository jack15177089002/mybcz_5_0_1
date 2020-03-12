package org.mozilla.javascript;

import com.baicizhan.main.utils.GuideFlags;
import java.io.IOException;
import java.io.Reader;

/* renamed from: org.mozilla.javascript.ef */
final class TokenStream {

    /* renamed from: A */
    private boolean f6642A = false;

    /* renamed from: B */
    private Reader f6643B;

    /* renamed from: C */
    private int f6644C;

    /* renamed from: D */
    private Parser f6645D;

    /* renamed from: a */
    String f6646a;

    /* renamed from: b */
    String f6647b = "";

    /* renamed from: c */
    double f6648c;

    /* renamed from: d */
    boolean f6649d;

    /* renamed from: e */
    int f6650e;

    /* renamed from: f */
    final int[] f6651f = new int[3];

    /* renamed from: g */
    int f6652g;

    /* renamed from: h */
    int f6653h = 0;

    /* renamed from: i */
    int f6654i = -1;

    /* renamed from: j */
    int f6655j;

    /* renamed from: k */
    String f6656k;

    /* renamed from: l */
    char[] f6657l;

    /* renamed from: m */
    int f6658m;

    /* renamed from: n */
    int f6659n;

    /* renamed from: o */
    int f6660o;

    /* renamed from: p */
    int f6661p;

    /* renamed from: q */
    int f6662q;

    /* renamed from: r */
    boolean f6663r;

    /* renamed from: s */
    boolean f6664s;

    /* renamed from: t */
    int f6665t;

    /* renamed from: u */
    String f6666u = "";

    /* renamed from: v */
    int f6667v = -1;

    /* renamed from: w */
    private boolean f6668w;

    /* renamed from: x */
    private char[] f6669x = new char[128];

    /* renamed from: y */
    private int f6670y;

    /* renamed from: z */
    private ObjToIntMap f6671z = new ObjToIntMap(50);

    TokenStream(Parser ctVar, Reader reader, String str, int i) {
        this.f6645D = ctVar;
        this.f6655j = i;
        if (reader != null) {
            if (str != null) {
                Kit.m5810a();
            }
            this.f6643B = reader;
            this.f6657l = new char[GuideFlags.FLAG_PATTERN_3];
            this.f6644C = 0;
        } else {
            if (str == null) {
                Kit.m5810a();
            }
            this.f6656k = str;
            this.f6644C = str.length();
        }
        this.f6659n = 0;
        this.f6658m = 0;
    }

    /* renamed from: a */
    static boolean m6627a(String str) {
        return m6628b(str) != 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:182:?, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:?, code lost:
        return r1 & 255;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0077, code lost:
        if (r9.charAt(1) == 'n') goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (r2 == null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        if (r2 == r9) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        if (r2.equals(r9) != false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0100, code lost:
        if (r9.charAt(1) == 'h') goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0133, code lost:
        if (r9.charAt(1) == 'n') goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        if (r1 != 0) goto L_0x02f0;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m6628b(String r9) {
        /*
            r3 = 114(0x72, float:1.6E-43)
            r7 = 2
            r0 = 0
            r6 = 1
            r1 = 127(0x7f, float:1.78E-43)
            r2 = 0
            int r4 = r9.length()
            switch(r4) {
                case 2: goto L_0x001e;
                case 3: goto L_0x004f;
                case 4: goto L_0x00c5;
                case 5: goto L_0x018d;
                case 6: goto L_0x020e;
                case 7: goto L_0x025e;
                case 8: goto L_0x028a;
                case 9: goto L_0x02b7;
                case 10: goto L_0x02d3;
                case 11: goto L_0x000f;
                case 12: goto L_0x02ec;
                default: goto L_0x000f;
            }
        L_0x000f:
            r1 = r0
        L_0x0010:
            if (r2 == 0) goto L_0x001b
            if (r2 == r9) goto L_0x001b
            boolean r2 = r2.equals(r9)
            if (r2 != 0) goto L_0x001b
            r1 = r0
        L_0x001b:
            if (r1 != 0) goto L_0x02f0
        L_0x001d:
            return r0
        L_0x001e:
            char r1 = r9.charAt(r6)
            r3 = 102(0x66, float:1.43E-43)
            if (r1 != r3) goto L_0x0031
            char r1 = r9.charAt(r0)
            r3 = 105(0x69, float:1.47E-43)
            if (r1 != r3) goto L_0x000f
            r1 = 112(0x70, float:1.57E-43)
            goto L_0x001b
        L_0x0031:
            r3 = 110(0x6e, float:1.54E-43)
            if (r1 != r3) goto L_0x0040
            char r1 = r9.charAt(r0)
            r3 = 105(0x69, float:1.47E-43)
            if (r1 != r3) goto L_0x000f
            r1 = 52
            goto L_0x001b
        L_0x0040:
            r3 = 111(0x6f, float:1.56E-43)
            if (r1 != r3) goto L_0x000f
            char r1 = r9.charAt(r0)
            r3 = 100
            if (r1 != r3) goto L_0x000f
            r1 = 118(0x76, float:1.65E-43)
            goto L_0x001b
        L_0x004f:
            char r4 = r9.charAt(r0)
            switch(r4) {
                case 102: goto L_0x0058;
                case 105: goto L_0x0069;
                case 108: goto L_0x007a;
                case 110: goto L_0x008d;
                case 116: goto L_0x00a1;
                case 118: goto L_0x00b3;
                default: goto L_0x0056;
            }
        L_0x0056:
            r1 = r0
            goto L_0x0010
        L_0x0058:
            char r1 = r9.charAt(r7)
            if (r1 != r3) goto L_0x000f
            char r1 = r9.charAt(r6)
            r3 = 111(0x6f, float:1.56E-43)
            if (r1 != r3) goto L_0x000f
            r1 = 119(0x77, float:1.67E-43)
            goto L_0x001b
        L_0x0069:
            char r3 = r9.charAt(r7)
            r4 = 116(0x74, float:1.63E-43)
            if (r3 != r4) goto L_0x000f
            char r3 = r9.charAt(r6)
            r4 = 110(0x6e, float:1.54E-43)
            if (r3 != r4) goto L_0x000f
            goto L_0x001b
        L_0x007a:
            char r1 = r9.charAt(r7)
            r3 = 116(0x74, float:1.63E-43)
            if (r1 != r3) goto L_0x000f
            char r1 = r9.charAt(r6)
            r3 = 101(0x65, float:1.42E-43)
            if (r1 != r3) goto L_0x000f
            r1 = 153(0x99, float:2.14E-43)
            goto L_0x001b
        L_0x008d:
            char r1 = r9.charAt(r7)
            r3 = 119(0x77, float:1.67E-43)
            if (r1 != r3) goto L_0x000f
            char r1 = r9.charAt(r6)
            r3 = 101(0x65, float:1.42E-43)
            if (r1 != r3) goto L_0x000f
            r1 = 30
            goto L_0x001b
        L_0x00a1:
            char r1 = r9.charAt(r7)
            r4 = 121(0x79, float:1.7E-43)
            if (r1 != r4) goto L_0x000f
            char r1 = r9.charAt(r6)
            if (r1 != r3) goto L_0x000f
            r1 = 81
            goto L_0x001b
        L_0x00b3:
            char r1 = r9.charAt(r7)
            if (r1 != r3) goto L_0x000f
            char r1 = r9.charAt(r6)
            r3 = 97
            if (r1 != r3) goto L_0x000f
            r1 = 122(0x7a, float:1.71E-43)
            goto L_0x001b
        L_0x00c5:
            char r4 = r9.charAt(r0)
            switch(r4) {
                case 98: goto L_0x00cf;
                case 99: goto L_0x00d3;
                case 101: goto L_0x0104;
                case 103: goto L_0x0137;
                case 108: goto L_0x013b;
                case 110: goto L_0x013f;
                case 116: goto L_0x0148;
                case 118: goto L_0x017b;
                case 119: goto L_0x0184;
                default: goto L_0x00cc;
            }
        L_0x00cc:
            r1 = r0
            goto L_0x0010
        L_0x00cf:
            java.lang.String r2 = "byte"
            goto L_0x0010
        L_0x00d3:
            r4 = 3
            char r4 = r9.charAt(r4)
            r5 = 101(0x65, float:1.42E-43)
            if (r4 != r5) goto L_0x00f0
            char r1 = r9.charAt(r7)
            r3 = 115(0x73, float:1.61E-43)
            if (r1 != r3) goto L_0x000f
            char r1 = r9.charAt(r6)
            r3 = 97
            if (r1 != r3) goto L_0x000f
            r1 = 115(0x73, float:1.61E-43)
            goto L_0x001b
        L_0x00f0:
            if (r4 != r3) goto L_0x000f
            char r3 = r9.charAt(r7)
            r4 = 97
            if (r3 != r4) goto L_0x000f
            char r3 = r9.charAt(r6)
            r4 = 104(0x68, float:1.46E-43)
            if (r3 != r4) goto L_0x000f
            goto L_0x001b
        L_0x0104:
            r3 = 3
            char r3 = r9.charAt(r3)
            r4 = 101(0x65, float:1.42E-43)
            if (r3 != r4) goto L_0x0121
            char r1 = r9.charAt(r7)
            r3 = 115(0x73, float:1.61E-43)
            if (r1 != r3) goto L_0x000f
            char r1 = r9.charAt(r6)
            r3 = 108(0x6c, float:1.51E-43)
            if (r1 != r3) goto L_0x000f
            r1 = 113(0x71, float:1.58E-43)
            goto L_0x001b
        L_0x0121:
            r4 = 109(0x6d, float:1.53E-43)
            if (r3 != r4) goto L_0x000f
            char r3 = r9.charAt(r7)
            r4 = 117(0x75, float:1.64E-43)
            if (r3 != r4) goto L_0x000f
            char r3 = r9.charAt(r6)
            r4 = 110(0x6e, float:1.54E-43)
            if (r3 != r4) goto L_0x000f
            goto L_0x001b
        L_0x0137:
            java.lang.String r2 = "goto"
            goto L_0x0010
        L_0x013b:
            java.lang.String r2 = "long"
            goto L_0x0010
        L_0x013f:
            java.lang.String r1 = "null"
            r2 = 42
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x0148:
            r1 = 3
            char r1 = r9.charAt(r1)
            r4 = 101(0x65, float:1.42E-43)
            if (r1 != r4) goto L_0x0163
            char r1 = r9.charAt(r7)
            r4 = 117(0x75, float:1.64E-43)
            if (r1 != r4) goto L_0x000f
            char r1 = r9.charAt(r6)
            if (r1 != r3) goto L_0x000f
            r1 = 45
            goto L_0x001b
        L_0x0163:
            r3 = 115(0x73, float:1.61E-43)
            if (r1 != r3) goto L_0x000f
            char r1 = r9.charAt(r7)
            r3 = 105(0x69, float:1.47E-43)
            if (r1 != r3) goto L_0x000f
            char r1 = r9.charAt(r6)
            r3 = 104(0x68, float:1.46E-43)
            if (r1 != r3) goto L_0x000f
            r1 = 43
            goto L_0x001b
        L_0x017b:
            java.lang.String r1 = "void"
            r2 = 126(0x7e, float:1.77E-43)
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x0184:
            java.lang.String r1 = "with"
            r2 = 123(0x7b, float:1.72E-43)
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x018d:
            char r3 = r9.charAt(r7)
            switch(r3) {
                case 97: goto L_0x0197;
                case 98: goto L_0x0194;
                case 99: goto L_0x0194;
                case 100: goto L_0x0194;
                case 101: goto L_0x019b;
                case 102: goto L_0x0194;
                case 103: goto L_0x0194;
                case 104: goto L_0x0194;
                case 105: goto L_0x01b9;
                case 106: goto L_0x0194;
                case 107: goto L_0x0194;
                case 108: goto L_0x01c2;
                case 109: goto L_0x0194;
                case 110: goto L_0x01cb;
                case 111: goto L_0x01e4;
                case 112: goto L_0x01f8;
                case 113: goto L_0x0194;
                case 114: goto L_0x01fc;
                case 115: goto L_0x0194;
                case 116: goto L_0x0205;
                default: goto L_0x0194;
            }
        L_0x0194:
            r1 = r0
            goto L_0x0010
        L_0x0197:
            java.lang.String r2 = "class"
            goto L_0x0010
        L_0x019b:
            char r1 = r9.charAt(r0)
            r3 = 98
            if (r1 != r3) goto L_0x01ac
            java.lang.String r1 = "break"
            r2 = 120(0x78, float:1.68E-43)
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x01ac:
            r3 = 121(0x79, float:1.7E-43)
            if (r1 != r3) goto L_0x000f
            java.lang.String r1 = "yield"
            r2 = 72
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x01b9:
            java.lang.String r1 = "while"
            r2 = 117(0x75, float:1.64E-43)
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x01c2:
            java.lang.String r1 = "false"
            r2 = 44
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x01cb:
            char r3 = r9.charAt(r0)
            r4 = 99
            if (r3 != r4) goto L_0x01dc
            java.lang.String r1 = "const"
            r2 = 154(0x9a, float:2.16E-43)
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x01dc:
            r4 = 102(0x66, float:1.43E-43)
            if (r3 != r4) goto L_0x000f
            java.lang.String r2 = "final"
            goto L_0x0010
        L_0x01e4:
            char r3 = r9.charAt(r0)
            r4 = 102(0x66, float:1.43E-43)
            if (r3 != r4) goto L_0x01f0
            java.lang.String r2 = "float"
            goto L_0x0010
        L_0x01f0:
            r4 = 115(0x73, float:1.61E-43)
            if (r3 != r4) goto L_0x000f
            java.lang.String r2 = "short"
            goto L_0x0010
        L_0x01f8:
            java.lang.String r2 = "super"
            goto L_0x0010
        L_0x01fc:
            java.lang.String r1 = "throw"
            r2 = 50
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x0205:
            java.lang.String r1 = "catch"
            r2 = 124(0x7c, float:1.74E-43)
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x020e:
            char r4 = r9.charAt(r6)
            switch(r4) {
                case 97: goto L_0x0218;
                case 101: goto L_0x021c;
                case 104: goto L_0x0237;
                case 109: goto L_0x023b;
                case 111: goto L_0x023f;
                case 116: goto L_0x0243;
                case 117: goto L_0x0247;
                case 119: goto L_0x024b;
                case 120: goto L_0x0251;
                case 121: goto L_0x0255;
                default: goto L_0x0215;
            }
        L_0x0215:
            r1 = r0
            goto L_0x0010
        L_0x0218:
            java.lang.String r2 = "native"
            goto L_0x0010
        L_0x021c:
            char r1 = r9.charAt(r0)
            r4 = 100
            if (r1 != r4) goto L_0x022d
            java.lang.String r1 = "delete"
            r2 = 31
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x022d:
            if (r1 != r3) goto L_0x000f
            java.lang.String r1 = "return"
            r2 = 4
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x0237:
            java.lang.String r2 = "throws"
            goto L_0x0010
        L_0x023b:
            java.lang.String r2 = "import"
            goto L_0x0010
        L_0x023f:
            java.lang.String r2 = "double"
            goto L_0x0010
        L_0x0243:
            java.lang.String r2 = "static"
            goto L_0x0010
        L_0x0247:
            java.lang.String r2 = "public"
            goto L_0x0010
        L_0x024b:
            java.lang.String r1 = "switch"
            r2 = r1
            r1 = r3
            goto L_0x0010
        L_0x0251:
            java.lang.String r2 = "export"
            goto L_0x0010
        L_0x0255:
            java.lang.String r1 = "typeof"
            r2 = 32
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x025e:
            char r3 = r9.charAt(r6)
            switch(r3) {
                case 97: goto L_0x0268;
                case 101: goto L_0x026c;
                case 105: goto L_0x0275;
                case 111: goto L_0x027e;
                case 114: goto L_0x0282;
                case 120: goto L_0x0286;
                default: goto L_0x0265;
            }
        L_0x0265:
            r1 = r0
            goto L_0x0010
        L_0x0268:
            java.lang.String r2 = "package"
            goto L_0x0010
        L_0x026c:
            java.lang.String r1 = "default"
            r2 = 116(0x74, float:1.63E-43)
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x0275:
            java.lang.String r1 = "finally"
            r2 = 125(0x7d, float:1.75E-43)
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x027e:
            java.lang.String r2 = "boolean"
            goto L_0x0010
        L_0x0282:
            java.lang.String r2 = "private"
            goto L_0x0010
        L_0x0286:
            java.lang.String r2 = "extends"
            goto L_0x0010
        L_0x028a:
            char r3 = r9.charAt(r0)
            switch(r3) {
                case 97: goto L_0x0294;
                case 99: goto L_0x0298;
                case 100: goto L_0x02a1;
                case 102: goto L_0x02aa;
                case 118: goto L_0x02b3;
                default: goto L_0x0291;
            }
        L_0x0291:
            r1 = r0
            goto L_0x0010
        L_0x0294:
            java.lang.String r2 = "abstract"
            goto L_0x0010
        L_0x0298:
            java.lang.String r1 = "continue"
            r2 = 121(0x79, float:1.7E-43)
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x02a1:
            java.lang.String r1 = "debugger"
            r2 = 160(0xa0, float:2.24E-43)
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x02aa:
            java.lang.String r1 = "function"
            r2 = 109(0x6d, float:1.53E-43)
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x02b3:
            java.lang.String r2 = "volatile"
            goto L_0x0010
        L_0x02b7:
            char r3 = r9.charAt(r0)
            r4 = 105(0x69, float:1.47E-43)
            if (r3 != r4) goto L_0x02c3
            java.lang.String r2 = "interface"
            goto L_0x0010
        L_0x02c3:
            r4 = 112(0x70, float:1.57E-43)
            if (r3 != r4) goto L_0x02cb
            java.lang.String r2 = "protected"
            goto L_0x0010
        L_0x02cb:
            r4 = 116(0x74, float:1.63E-43)
            if (r3 != r4) goto L_0x000f
            java.lang.String r2 = "transient"
            goto L_0x0010
        L_0x02d3:
            char r3 = r9.charAt(r6)
            r4 = 109(0x6d, float:1.53E-43)
            if (r3 != r4) goto L_0x02df
            java.lang.String r2 = "implements"
            goto L_0x0010
        L_0x02df:
            r1 = 110(0x6e, float:1.54E-43)
            if (r3 != r1) goto L_0x000f
            java.lang.String r1 = "instanceof"
            r2 = 53
            r8 = r1
            r1 = r2
            r2 = r8
            goto L_0x0010
        L_0x02ec:
            java.lang.String r2 = "synchronized"
            goto L_0x0010
        L_0x02f0:
            r0 = r1 & 255(0xff, float:3.57E-43)
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.m6628b(java.lang.String):int");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01b5 A[LOOP:4: B:112:0x01b5->B:114:0x01bb, LOOP_START, PHI: r1 
  PHI: (r1v47 int) = (r1v22 int), (r1v48 int) binds: [B:111:0x01b3, B:114:0x01bb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0269 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x05c0  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo19082a() {
        /*
            r9 = this;
            r2 = 10
            r5 = -1
            r7 = 61
            r3 = 1
            r0 = 0
        L_0x0007:
            int r4 = r9.m6626a(r3)
            if (r4 != r5) goto L_0x0018
            int r1 = r9.f6659n
            int r1 = r1 + -1
            r9.f6660o = r1
            int r1 = r9.f6659n
            r9.f6661p = r1
        L_0x0017:
            return r0
        L_0x0018:
            if (r4 != r2) goto L_0x0028
            r9.f6668w = r0
            int r0 = r9.f6659n
            int r0 = r0 + -1
            r9.f6660o = r0
            int r0 = r9.f6659n
            r9.f6661p = r0
            r0 = r3
            goto L_0x0017
        L_0x0028:
            r1 = 127(0x7f, float:1.78E-43)
            if (r4 > r1) goto L_0x0058
            r1 = 32
            if (r4 == r1) goto L_0x003c
            r1 = 9
            if (r4 == r1) goto L_0x003c
            r1 = 12
            if (r4 == r1) goto L_0x003c
            r1 = 11
            if (r4 != r1) goto L_0x0056
        L_0x003c:
            r1 = r3
        L_0x003d:
            if (r1 != 0) goto L_0x0007
            r1 = 45
            if (r4 == r1) goto L_0x0045
            r9.f6668w = r3
        L_0x0045:
            int r1 = r9.f6659n
            int r1 = r1 + -1
            r9.f6660o = r1
            int r1 = r9.f6659n
            r9.f6661p = r1
            r1 = 64
            if (r4 != r1) goto L_0x006e
            r0 = 147(0x93, float:2.06E-43)
            goto L_0x0017
        L_0x0056:
            r1 = r0
            goto L_0x003d
        L_0x0058:
            r1 = 160(0xa0, float:2.24E-43)
            if (r4 == r1) goto L_0x006a
            r1 = 65279(0xfeff, float:9.1475E-41)
            if (r4 == r1) goto L_0x006a
            char r1 = (char) r4
            int r1 = java.lang.Character.getType(r1)
            r6 = 12
            if (r1 != r6) goto L_0x006c
        L_0x006a:
            r1 = r3
            goto L_0x003d
        L_0x006c:
            r1 = r0
            goto L_0x003d
        L_0x006e:
            r1 = 92
            if (r4 != r1) goto L_0x009d
            int r1 = r9.m6626a(r3)
            r4 = 117(0x75, float:1.64E-43)
            if (r1 != r4) goto L_0x0095
            r9.f6670y = r0
            r4 = r3
            r6 = r3
        L_0x007e:
            if (r6 == 0) goto L_0x0183
            r1 = r4
        L_0x0081:
            if (r1 == 0) goto L_0x00bf
            r2 = r0
            r1 = r0
        L_0x0085:
            r6 = 4
            if (r2 == r6) goto L_0x00ad
            int r6 = r9.m6626a(r3)
            int r1 = org.mozilla.javascript.Kit.m5803a(r6, r1)
            if (r1 < 0) goto L_0x00ad
            int r2 = r2 + 1
            goto L_0x0085
        L_0x0095:
            r9.mo19085b(r1)
            r1 = 92
            r4 = r0
            r6 = r0
            goto L_0x007e
        L_0x009d:
            char r1 = (char) r4
            boolean r1 = java.lang.Character.isJavaIdentifierStart(r1)
            if (r1 == 0) goto L_0x00a9
            r9.f6670y = r0
            r9.m6632e(r4)
        L_0x00a9:
            r6 = r1
            r1 = r4
            r4 = r0
            goto L_0x007e
        L_0x00ad:
            if (r1 >= 0) goto L_0x00ba
            org.mozilla.javascript.ct r0 = r9.f6645D
            java.lang.String r1 = "msg.invalid.escape"
            r2 = 0
            r0.mo18988b(r1, r2)
            r0 = r5
            goto L_0x0017
        L_0x00ba:
            r9.m6632e(r1)
            r1 = r0
            goto L_0x0081
        L_0x00bf:
            int r2 = r9.m6626a(r3)
            r6 = 92
            if (r2 != r6) goto L_0x00dd
            int r1 = r9.m6626a(r3)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L_0x00d2
            r1 = r3
            r4 = r3
            goto L_0x0081
        L_0x00d2:
            org.mozilla.javascript.ct r0 = r9.f6645D
            java.lang.String r1 = "msg.illegal.character"
            r2 = 0
            r0.mo18988b(r1, r2)
            r0 = r5
            goto L_0x0017
        L_0x00dd:
            if (r2 == r5) goto L_0x00ef
            r6 = 65279(0xfeff, float:9.1475E-41)
            if (r2 == r6) goto L_0x00ef
            char r6 = (char) r2
            boolean r6 = java.lang.Character.isJavaIdentifierPart(r6)
            if (r6 == 0) goto L_0x00ef
            r9.m6632e(r2)
            goto L_0x0081
        L_0x00ef:
            r9.mo19085b(r2)
            java.lang.String r2 = r9.m6633f()
            if (r4 != 0) goto L_0x0149
            int r0 = m6628b(r2)
            if (r0 == 0) goto L_0x013a
            r1 = 153(0x99, float:2.14E-43)
            if (r0 == r1) goto L_0x0106
            r1 = 72
            if (r0 != r1) goto L_0x05c8
        L_0x0106:
            org.mozilla.javascript.ct r1 = r9.f6645D
            org.mozilla.javascript.i r1 = r1.f6427a
            int r1 = r1.f6739b
            r3 = 170(0xaa, float:2.38E-43)
            if (r1 >= r3) goto L_0x05c8
            r1 = 153(0x99, float:2.14E-43)
            if (r0 != r1) goto L_0x012c
            java.lang.String r0 = "let"
        L_0x0116:
            r9.f6647b = r0
            r0 = 39
            r1 = r0
        L_0x011b:
            org.mozilla.javascript.cr r0 = r9.f6671z
            java.lang.Object r0 = r0.mo18967b(r2)
            java.lang.String r0 = (java.lang.String) r0
            r9.f6647b = r0
            r0 = 127(0x7f, float:1.78E-43)
            if (r1 == r0) goto L_0x012f
            r0 = r1
            goto L_0x0017
        L_0x012c:
            java.lang.String r0 = "yield"
            goto L_0x0116
        L_0x012f:
            org.mozilla.javascript.ct r0 = r9.f6645D
            org.mozilla.javascript.i r0 = r0.f6427a
            boolean r0 = r0.f6741d
            if (r0 != 0) goto L_0x013a
            r0 = r1
            goto L_0x0017
        L_0x013a:
            r0 = r2
        L_0x013b:
            org.mozilla.javascript.cr r1 = r9.f6671z
            java.lang.Object r0 = r1.mo18967b(r0)
            java.lang.String r0 = (java.lang.String) r0
            r9.f6647b = r0
            r0 = 39
            goto L_0x0017
        L_0x0149:
            boolean r1 = m6627a(r2)
            if (r1 == 0) goto L_0x05c5
            int r1 = r2.length()
            int r1 = r1 + -1
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            java.lang.String r4 = r2.substring(r0, r1)
            r3.<init>(r4)
            java.lang.String r4 = "\\u"
            r3.append(r4)
            char r1 = r2.charAt(r1)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x016b:
            int r2 = r1.length()
            int r2 = 4 - r2
            if (r0 >= r2) goto L_0x017b
            r2 = 48
            r3.append(r2)
            int r0 = r0 + 1
            goto L_0x016b
        L_0x017b:
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            goto L_0x013b
        L_0x0183:
            boolean r4 = m6630c(r1)
            if (r4 != 0) goto L_0x0197
            r4 = 46
            if (r1 != r4) goto L_0x0286
            int r4 = r9.m6635g()
            boolean r4 = m6630c(r4)
            if (r4 == 0) goto L_0x0286
        L_0x0197:
            r9.f6649d = r0
            r9.f6670y = r0
            r4 = 48
            if (r1 != r4) goto L_0x01d3
            int r1 = r9.m6637h()
            r4 = 120(0x78, float:1.68E-43)
            if (r1 == r4) goto L_0x01ab
            r4 = 88
            if (r1 != r4) goto L_0x01c3
        L_0x01ab:
            r4 = 16
            int r1 = r9.m6637h()
        L_0x01b1:
            r6 = 16
            if (r4 != r6) goto L_0x05c0
        L_0x01b5:
            int r6 = org.mozilla.javascript.Kit.m5803a(r1, r0)
            if (r6 < 0) goto L_0x0201
            r9.m6632e(r1)
            int r1 = r9.m6637h()
            goto L_0x01b5
        L_0x01c3:
            boolean r4 = m6630c(r1)
            if (r4 == 0) goto L_0x01ce
            r4 = 8
            r9.f6649d = r3
            goto L_0x01b1
        L_0x01ce:
            r4 = 48
            r9.m6632e(r4)
        L_0x01d3:
            r4 = r2
            goto L_0x01b1
        L_0x01d5:
            r6 = 48
            if (r6 > r4) goto L_0x01fe
            r6 = 57
            if (r4 > r6) goto L_0x01fe
            r6 = 8
            if (r1 != r6) goto L_0x01f3
            r6 = 56
            if (r4 < r6) goto L_0x01f3
            org.mozilla.javascript.ct r6 = r9.f6645D
            java.lang.String r7 = "msg.bad.octal.literal"
            r1 = 56
            if (r4 != r1) goto L_0x01fb
            java.lang.String r1 = "8"
        L_0x01ef:
            r6.mo18983a(r7, r1)
            r1 = r2
        L_0x01f3:
            r9.m6632e(r4)
            int r4 = r9.m6637h()
            goto L_0x01d5
        L_0x01fb:
            java.lang.String r1 = "9"
            goto L_0x01ef
        L_0x01fe:
            r8 = r1
            r1 = r4
            r4 = r8
        L_0x0201:
            if (r4 != r2) goto L_0x05bb
            r6 = 46
            if (r1 == r6) goto L_0x020f
            r6 = 101(0x65, float:1.42E-43)
            if (r1 == r6) goto L_0x020f
            r6 = 69
            if (r1 != r6) goto L_0x05bb
        L_0x020f:
            r3 = 46
            if (r1 != r3) goto L_0x0220
        L_0x0213:
            r9.m6632e(r1)
            int r1 = r9.m6637h()
            boolean r3 = m6630c(r1)
            if (r3 != 0) goto L_0x0213
        L_0x0220:
            r3 = 101(0x65, float:1.42E-43)
            if (r1 == r3) goto L_0x0228
            r3 = 69
            if (r1 != r3) goto L_0x025c
        L_0x0228:
            r9.m6632e(r1)
            int r1 = r9.m6637h()
            r3 = 43
            if (r1 == r3) goto L_0x0237
            r3 = 45
            if (r1 != r3) goto L_0x023e
        L_0x0237:
            r9.m6632e(r1)
            int r1 = r9.m6637h()
        L_0x023e:
            boolean r3 = m6630c(r1)
            if (r3 != 0) goto L_0x024f
            org.mozilla.javascript.ct r0 = r9.f6645D
            java.lang.String r1 = "msg.missing.exponent"
            r2 = 0
            r0.mo18988b(r1, r2)
            r0 = r5
            goto L_0x0017
        L_0x024f:
            r9.m6632e(r1)
            int r1 = r9.m6637h()
            boolean r3 = m6630c(r1)
            if (r3 != 0) goto L_0x024f
        L_0x025c:
            r3 = r1
            r1 = r0
        L_0x025e:
            r9.mo19085b(r3)
            java.lang.String r3 = r9.m6633f()
            r9.f6647b = r3
            if (r4 != r2) goto L_0x0281
            if (r1 != 0) goto L_0x0281
            double r0 = java.lang.Double.parseDouble(r3)     // Catch:{ NumberFormatException -> 0x0275 }
        L_0x026f:
            r9.f6648c = r0
            r0 = 40
            goto L_0x0017
        L_0x0275:
            r0 = move-exception
            org.mozilla.javascript.ct r0 = r9.f6645D
            java.lang.String r1 = "msg.caught.nfe"
            r2 = 0
            r0.mo18988b(r1, r2)
            r0 = r5
            goto L_0x0017
        L_0x0281:
            double r0 = org.mozilla.javascript.ScriptRuntime.m6310a(r3, r0, r4)
            goto L_0x026f
        L_0x0286:
            r4 = 34
            if (r1 == r4) goto L_0x028e
            r4 = 39
            if (r1 != r4) goto L_0x036c
        L_0x028e:
            r9.f6650e = r1
            r9.f6670y = r0
            int r1 = r9.m6626a(r0)
        L_0x0296:
            int r3 = r9.f6650e
            if (r1 == r3) goto L_0x035a
            if (r1 == r2) goto L_0x029e
            if (r1 != r5) goto L_0x02b0
        L_0x029e:
            r9.mo19085b(r1)
            int r0 = r9.f6659n
            r9.f6661p = r0
            org.mozilla.javascript.ct r0 = r9.f6645D
            java.lang.String r1 = "msg.unterminated.string.lit"
            r2 = 0
            r0.mo18988b(r1, r2)
            r0 = r5
            goto L_0x0017
        L_0x02b0:
            r3 = 92
            if (r1 != r3) goto L_0x02f2
            int r1 = r9.m6637h()
            switch(r1) {
                case 10: goto L_0x0354;
                case 98: goto L_0x02fa;
                case 102: goto L_0x02fd;
                case 110: goto L_0x0300;
                case 114: goto L_0x0302;
                case 116: goto L_0x0305;
                case 117: goto L_0x030b;
                case 118: goto L_0x0308;
                case 120: goto L_0x032c;
                default: goto L_0x02bb;
            }
        L_0x02bb:
            r3 = 48
            if (r3 > r1) goto L_0x02f2
            r3 = 56
            if (r1 >= r3) goto L_0x02f2
            int r1 = r1 + -48
            int r3 = r9.m6637h()
            r4 = 48
            if (r4 > r3) goto L_0x02ef
            r4 = 56
            if (r3 >= r4) goto L_0x02ef
            int r1 = r1 * 8
            int r1 = r1 + r3
            int r1 = r1 + -48
            int r3 = r9.m6637h()
            r4 = 48
            if (r4 > r3) goto L_0x02ef
            r4 = 56
            if (r3 >= r4) goto L_0x02ef
            r4 = 31
            if (r1 > r4) goto L_0x02ef
            int r1 = r1 * 8
            int r1 = r1 + r3
            int r1 = r1 + -48
            int r3 = r9.m6637h()
        L_0x02ef:
            r9.mo19085b(r3)
        L_0x02f2:
            r9.m6632e(r1)
            int r1 = r9.m6626a(r0)
            goto L_0x0296
        L_0x02fa:
            r1 = 8
            goto L_0x02f2
        L_0x02fd:
            r1 = 12
            goto L_0x02f2
        L_0x0300:
            r1 = r2
            goto L_0x02f2
        L_0x0302:
            r1 = 13
            goto L_0x02f2
        L_0x0305:
            r1 = 9
            goto L_0x02f2
        L_0x0308:
            r1 = 11
            goto L_0x02f2
        L_0x030b:
            int r6 = r9.f6670y
            r1 = 117(0x75, float:1.64E-43)
            r9.m6632e(r1)
            r4 = r0
            r3 = r0
        L_0x0314:
            r1 = 4
            if (r4 == r1) goto L_0x0328
            int r1 = r9.m6637h()
            int r3 = org.mozilla.javascript.Kit.m5803a(r1, r3)
            if (r3 < 0) goto L_0x0296
            r9.m6632e(r1)
            int r1 = r4 + 1
            r4 = r1
            goto L_0x0314
        L_0x0328:
            r9.f6670y = r6
            r1 = r3
            goto L_0x02f2
        L_0x032c:
            int r1 = r9.m6637h()
            int r4 = org.mozilla.javascript.Kit.m5803a(r1, r0)
            if (r4 >= 0) goto L_0x033d
            r3 = 120(0x78, float:1.68E-43)
            r9.m6632e(r3)
            goto L_0x0296
        L_0x033d:
            int r3 = r9.m6637h()
            int r4 = org.mozilla.javascript.Kit.m5803a(r3, r4)
            if (r4 >= 0) goto L_0x0352
            r4 = 120(0x78, float:1.68E-43)
            r9.m6632e(r4)
            r9.m6632e(r1)
            r1 = r3
            goto L_0x0296
        L_0x0352:
            r1 = r4
            goto L_0x02f2
        L_0x0354:
            int r1 = r9.m6637h()
            goto L_0x0296
        L_0x035a:
            java.lang.String r0 = r9.m6633f()
            org.mozilla.javascript.cr r1 = r9.f6671z
            java.lang.Object r0 = r1.mo18967b(r0)
            java.lang.String r0 = (java.lang.String) r0
            r9.f6647b = r0
            r0 = 41
            goto L_0x0017
        L_0x036c:
            switch(r1) {
                case 33: goto L_0x0423;
                case 37: goto L_0x0559;
                case 38: goto L_0x03f1;
                case 40: goto L_0x038e;
                case 41: goto L_0x0392;
                case 42: goto L_0x04cc;
                case 43: goto L_0x056b;
                case 44: goto L_0x0396;
                case 45: goto L_0x0585;
                case 46: goto L_0x03ae;
                case 47: goto L_0x04da;
                case 58: goto L_0x039e;
                case 59: goto L_0x037a;
                case 60: goto L_0x043b;
                case 61: goto L_0x040b;
                case 62: goto L_0x0492;
                case 63: goto L_0x039a;
                case 91: goto L_0x037e;
                case 93: goto L_0x0382;
                case 94: goto L_0x03e4;
                case 123: goto L_0x0386;
                case 124: goto L_0x03ca;
                case 125: goto L_0x038a;
                case 126: goto L_0x0567;
                default: goto L_0x036f;
            }
        L_0x036f:
            org.mozilla.javascript.ct r0 = r9.f6645D
            java.lang.String r1 = "msg.illegal.character"
            r2 = 0
            r0.mo18988b(r1, r2)
            r0 = r5
            goto L_0x0017
        L_0x037a:
            r0 = 82
            goto L_0x0017
        L_0x037e:
            r0 = 83
            goto L_0x0017
        L_0x0382:
            r0 = 84
            goto L_0x0017
        L_0x0386:
            r0 = 85
            goto L_0x0017
        L_0x038a:
            r0 = 86
            goto L_0x0017
        L_0x038e:
            r0 = 87
            goto L_0x0017
        L_0x0392:
            r0 = 88
            goto L_0x0017
        L_0x0396:
            r0 = 89
            goto L_0x0017
        L_0x039a:
            r0 = 102(0x66, float:1.43E-43)
            goto L_0x0017
        L_0x039e:
            r0 = 58
            boolean r0 = r9.m6634f(r0)
            if (r0 == 0) goto L_0x03aa
            r0 = 144(0x90, float:2.02E-43)
            goto L_0x0017
        L_0x03aa:
            r0 = 103(0x67, float:1.44E-43)
            goto L_0x0017
        L_0x03ae:
            r0 = 46
            boolean r0 = r9.m6634f(r0)
            if (r0 == 0) goto L_0x03ba
            r0 = 143(0x8f, float:2.0E-43)
            goto L_0x0017
        L_0x03ba:
            r0 = 40
            boolean r0 = r9.m6634f(r0)
            if (r0 == 0) goto L_0x03c6
            r0 = 146(0x92, float:2.05E-43)
            goto L_0x0017
        L_0x03c6:
            r0 = 108(0x6c, float:1.51E-43)
            goto L_0x0017
        L_0x03ca:
            r0 = 124(0x7c, float:1.74E-43)
            boolean r0 = r9.m6634f(r0)
            if (r0 == 0) goto L_0x03d6
            r0 = 104(0x68, float:1.46E-43)
            goto L_0x0017
        L_0x03d6:
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x03e0
            r0 = 91
            goto L_0x0017
        L_0x03e0:
            r0 = 9
            goto L_0x0017
        L_0x03e4:
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x03ee
            r0 = 92
            goto L_0x0017
        L_0x03ee:
            r0 = r2
            goto L_0x0017
        L_0x03f1:
            r0 = 38
            boolean r0 = r9.m6634f(r0)
            if (r0 == 0) goto L_0x03fd
            r0 = 105(0x69, float:1.47E-43)
            goto L_0x0017
        L_0x03fd:
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x0407
            r0 = 93
            goto L_0x0017
        L_0x0407:
            r0 = 11
            goto L_0x0017
        L_0x040b:
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x041f
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x041b
            r0 = 46
            goto L_0x0017
        L_0x041b:
            r0 = 12
            goto L_0x0017
        L_0x041f:
            r0 = 90
            goto L_0x0017
        L_0x0423:
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x0437
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x0433
            r0 = 47
            goto L_0x0017
        L_0x0433:
            r0 = 13
            goto L_0x0017
        L_0x0437:
            r0 = 26
            goto L_0x0017
        L_0x043b:
            r0 = 33
            boolean r0 = r9.m6634f(r0)
            if (r0 == 0) goto L_0x046e
            r0 = 45
            boolean r0 = r9.m6634f(r0)
            if (r0 == 0) goto L_0x0469
            r0 = 45
            boolean r0 = r9.m6634f(r0)
            if (r0 == 0) goto L_0x0464
            int r0 = r9.f6659n
            int r0 = r0 + -4
            r9.f6660o = r0
            r9.m6638i()
            int r0 = org.mozilla.javascript.C2192ee.f6640d
            r9.f6662q = r0
            r0 = 161(0xa1, float:2.26E-43)
            goto L_0x0017
        L_0x0464:
            r0 = 45
            r9.m6636g(r0)
        L_0x0469:
            r0 = 33
            r9.m6636g(r0)
        L_0x046e:
            r0 = 60
            boolean r0 = r9.m6634f(r0)
            if (r0 == 0) goto L_0x0484
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x0480
            r0 = 94
            goto L_0x0017
        L_0x0480:
            r0 = 18
            goto L_0x0017
        L_0x0484:
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x048e
            r0 = 15
            goto L_0x0017
        L_0x048e:
            r0 = 14
            goto L_0x0017
        L_0x0492:
            r0 = 62
            boolean r0 = r9.m6634f(r0)
            if (r0 == 0) goto L_0x04be
            r0 = 62
            boolean r0 = r9.m6634f(r0)
            if (r0 == 0) goto L_0x04b0
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x04ac
            r0 = 96
            goto L_0x0017
        L_0x04ac:
            r0 = 20
            goto L_0x0017
        L_0x04b0:
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x04ba
            r0 = 95
            goto L_0x0017
        L_0x04ba:
            r0 = 19
            goto L_0x0017
        L_0x04be:
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x04c8
            r0 = 17
            goto L_0x0017
        L_0x04c8:
            r0 = 16
            goto L_0x0017
        L_0x04cc:
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x04d6
            r0 = 99
            goto L_0x0017
        L_0x04d6:
            r0 = 23
            goto L_0x0017
        L_0x04da:
            java.lang.String r1 = ""
            r9.m6629c(r1)
            r1 = 47
            boolean r1 = r9.m6634f(r1)
            if (r1 == 0) goto L_0x04f8
            int r0 = r9.f6659n
            int r0 = r0 + -2
            r9.f6660o = r0
            r9.m6638i()
            int r0 = org.mozilla.javascript.C2192ee.f6637a
            r9.f6662q = r0
            r0 = 161(0xa1, float:2.26E-43)
            goto L_0x0017
        L_0x04f8:
            r1 = 42
            boolean r1 = r9.m6634f(r1)
            if (r1 == 0) goto L_0x054b
            int r1 = r9.f6659n
            int r1 = r1 + -2
            r9.f6660o = r1
            r1 = 42
            boolean r1 = r9.m6634f(r1)
            if (r1 == 0) goto L_0x052b
            int r1 = org.mozilla.javascript.C2192ee.f6639c
            r9.f6662q = r1
            r1 = r3
        L_0x0513:
            int r2 = r9.m6637h()
            if (r2 != r5) goto L_0x0531
            int r0 = r9.f6659n
            int r0 = r0 + -1
            r9.f6661p = r0
            org.mozilla.javascript.ct r0 = r9.f6645D
            java.lang.String r1 = "msg.unterminated.comment"
            r2 = 0
            r0.mo18988b(r1, r2)
            r0 = 161(0xa1, float:2.26E-43)
            goto L_0x0017
        L_0x052b:
            int r1 = org.mozilla.javascript.C2192ee.f6638b
            r9.f6662q = r1
            r1 = r0
            goto L_0x0513
        L_0x0531:
            r4 = 42
            if (r2 != r4) goto L_0x0537
            r1 = r3
            goto L_0x0513
        L_0x0537:
            r4 = 47
            if (r2 != r4) goto L_0x0545
            if (r1 == 0) goto L_0x0513
            int r0 = r9.f6659n
            r9.f6661p = r0
            r0 = 161(0xa1, float:2.26E-43)
            goto L_0x0017
        L_0x0545:
            int r1 = r9.f6659n
            r9.f6661p = r1
            r1 = r0
            goto L_0x0513
        L_0x054b:
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x0555
            r0 = 100
            goto L_0x0017
        L_0x0555:
            r0 = 24
            goto L_0x0017
        L_0x0559:
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x0563
            r0 = 101(0x65, float:1.42E-43)
            goto L_0x0017
        L_0x0563:
            r0 = 25
            goto L_0x0017
        L_0x0567:
            r0 = 27
            goto L_0x0017
        L_0x056b:
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x0575
            r0 = 97
            goto L_0x0017
        L_0x0575:
            r0 = 43
            boolean r0 = r9.m6634f(r0)
            if (r0 == 0) goto L_0x0581
            r0 = 106(0x6a, float:1.49E-43)
            goto L_0x0017
        L_0x0581:
            r0 = 21
            goto L_0x0017
        L_0x0585:
            boolean r0 = r9.m6634f(r7)
            if (r0 == 0) goto L_0x0591
            r0 = 98
        L_0x058d:
            r9.f6668w = r3
            goto L_0x0017
        L_0x0591:
            r0 = 45
            boolean r0 = r9.m6634f(r0)
            if (r0 == 0) goto L_0x05b8
            boolean r0 = r9.f6668w
            if (r0 != 0) goto L_0x05b5
            r0 = 62
            boolean r0 = r9.m6634f(r0)
            if (r0 == 0) goto L_0x05b5
            java.lang.String r0 = "--"
            r9.m6629c(r0)
            r9.m6638i()
            int r0 = org.mozilla.javascript.C2192ee.f6640d
            r9.f6662q = r0
            r0 = 161(0xa1, float:2.26E-43)
            goto L_0x0017
        L_0x05b5:
            r0 = 107(0x6b, float:1.5E-43)
            goto L_0x058d
        L_0x05b8:
            r0 = 22
            goto L_0x058d
        L_0x05bb:
            r8 = r3
            r3 = r1
            r1 = r8
            goto L_0x025e
        L_0x05c0:
            r8 = r4
            r4 = r1
            r1 = r8
            goto L_0x01d5
        L_0x05c5:
            r0 = r2
            goto L_0x013b
        L_0x05c8:
            r1 = r0
            goto L_0x011b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.mo19082a():int");
    }

    /* renamed from: c */
    private static boolean m6630c(int i) {
        return 48 <= i && i <= 57;
    }

    /* renamed from: d */
    private static boolean m6631d(int i) {
        return i > 127 && Character.getType((char) i) == 16;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo19083a(int i) {
        int a;
        boolean z = true;
        int i2 = this.f6660o;
        this.f6670y = 0;
        if (i == 100) {
            m6632e(61);
        } else if (i != 24) {
            Kit.m5810a();
        }
        boolean z2 = false;
        while (true) {
            a = m6626a(true);
            if (a == 47 && !z2) {
                int i3 = this.f6670y;
                while (true) {
                    if (!m6634f(103)) {
                        if (!m6634f(105)) {
                            if (!m6634f(109)) {
                                if (!m6634f(121)) {
                                    break;
                                }
                                m6632e(121);
                            } else {
                                m6632e(109);
                            }
                        } else {
                            m6632e(105);
                        }
                    } else {
                        m6632e(103);
                    }
                }
                this.f6661p = this.f6670y + i2 + 2;
                int g = m6635g();
                if (g <= 90) {
                    if (65 > g) {
                        z = false;
                    }
                } else if (97 > g || g > 122) {
                    z = false;
                }
                if (z) {
                    this.f6645D.mo18981a("msg.invalid.re.flag");
                }
                this.f6647b = new String(this.f6669x, 0, i3);
                this.f6646a = new String(this.f6669x, i3, this.f6670y - i3);
                return;
            } else if (a == 10 || a == -1) {
                mo19085b(a);
                this.f6661p = this.f6659n - 1;
                this.f6647b = new String(this.f6669x, 0, this.f6670y);
                this.f6645D.mo18981a("msg.unterminated.re.lit");
            } else {
                if (a == 92) {
                    m6632e(a);
                    a = m6637h();
                } else if (a == 91) {
                    z2 = true;
                } else if (a == 93) {
                    z2 = false;
                }
                m6632e(a);
            }
        }
        mo19085b(a);
        this.f6661p = this.f6659n - 1;
        this.f6647b = new String(this.f6669x, 0, this.f6670y);
        this.f6645D.mo18981a("msg.unterminated.re.lit");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final int mo19084b() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        this.f6660o = this.f6659n;
        this.f6670y = 0;
        int a = m6626a(true);
        while (a != -1) {
            if (!this.f6664s) {
                switch (a) {
                    case 60:
                        m6632e(a);
                        switch (m6635g()) {
                            case 33:
                                m6632e(m6626a(true));
                                switch (m6635g()) {
                                    case 45:
                                        m6632e(m6626a(true));
                                        int a2 = m6626a(true);
                                        if (a2 == 45) {
                                            m6632e(a2);
                                            int a3 = m6626a(true);
                                            while (true) {
                                                if (a3 != -1) {
                                                    m6632e(a3);
                                                    if (a3 == 45 && m6635g() == 45) {
                                                        a3 = m6626a(true);
                                                        m6632e(a3);
                                                        if (m6635g() == 62) {
                                                            m6632e(m6626a(true));
                                                            z3 = true;
                                                        }
                                                    } else {
                                                        a3 = m6626a(true);
                                                    }
                                                } else {
                                                    this.f6670y = 0;
                                                    this.f6647b = null;
                                                    this.f6645D.mo18988b("msg.XML.bad.form", (String) null);
                                                    z3 = false;
                                                }
                                            }
                                            if (z3) {
                                                break;
                                            } else {
                                                return -1;
                                            }
                                        } else {
                                            this.f6670y = 0;
                                            this.f6647b = null;
                                            this.f6645D.mo18988b("msg.XML.bad.form", (String) null);
                                            return -1;
                                        }
                                    case 91:
                                        m6632e(m6626a(true));
                                        if (m6626a(true) == 67 && m6626a(true) == 68 && m6626a(true) == 65 && m6626a(true) == 84 && m6626a(true) == 65 && m6626a(true) == 91) {
                                            m6632e(67);
                                            m6632e(68);
                                            m6632e(65);
                                            m6632e(84);
                                            m6632e(65);
                                            m6632e(91);
                                            int a4 = m6626a(true);
                                            while (true) {
                                                if (a4 != -1) {
                                                    m6632e(a4);
                                                    if (a4 == 93 && m6635g() == 93) {
                                                        a4 = m6626a(true);
                                                        m6632e(a4);
                                                        if (m6635g() == 62) {
                                                            m6632e(m6626a(true));
                                                            z2 = true;
                                                        }
                                                    } else {
                                                        a4 = m6626a(true);
                                                    }
                                                } else {
                                                    this.f6670y = 0;
                                                    this.f6647b = null;
                                                    this.f6645D.mo18988b("msg.XML.bad.form", (String) null);
                                                    z2 = false;
                                                }
                                            }
                                            if (z2) {
                                                break;
                                            } else {
                                                return -1;
                                            }
                                        } else {
                                            this.f6670y = 0;
                                            this.f6647b = null;
                                            this.f6645D.mo18988b("msg.XML.bad.form", (String) null);
                                            return -1;
                                        }
                                        break;
                                    default:
                                        int a5 = m6626a(true);
                                        int i = 1;
                                        while (true) {
                                            if (a5 != -1) {
                                                m6632e(a5);
                                                switch (a5) {
                                                    case 60:
                                                        i++;
                                                        break;
                                                    case 62:
                                                        i--;
                                                        if (i != 0) {
                                                            break;
                                                        } else {
                                                            z4 = true;
                                                            break;
                                                        }
                                                }
                                            } else {
                                                this.f6670y = 0;
                                                this.f6647b = null;
                                                this.f6645D.mo18988b("msg.XML.bad.form", (String) null);
                                                z4 = false;
                                            }
                                            a5 = m6626a(true);
                                        }
                                        if (z4) {
                                            break;
                                        } else {
                                            return -1;
                                        }
                                        break;
                                }
                            case 47:
                                m6632e(m6626a(true));
                                if (this.f6665t != 0) {
                                    this.f6664s = true;
                                    this.f6665t--;
                                    break;
                                } else {
                                    this.f6670y = 0;
                                    this.f6647b = null;
                                    this.f6645D.mo18988b("msg.XML.bad.form", (String) null);
                                    return -1;
                                }
                            case 63:
                                m6632e(m6626a(true));
                                int a6 = m6626a(true);
                                while (true) {
                                    if (a6 != -1) {
                                        m6632e(a6);
                                        if (a6 == 63 && m6635g() == 62) {
                                            m6632e(m6626a(true));
                                            z = true;
                                        } else {
                                            a6 = m6626a(true);
                                        }
                                    } else {
                                        this.f6670y = 0;
                                        this.f6647b = null;
                                        this.f6645D.mo18988b("msg.XML.bad.form", (String) null);
                                        z = false;
                                    }
                                }
                                if (z) {
                                    break;
                                } else {
                                    return -1;
                                }
                            default:
                                this.f6664s = true;
                                this.f6665t++;
                                break;
                        }
                    case 123:
                        mo19085b(a);
                        this.f6647b = m6633f();
                        return 145;
                    default:
                        m6632e(a);
                        break;
                }
            } else {
                switch (a) {
                    case 9:
                    case 10:
                    case 13:
                    case 32:
                        m6632e(a);
                        break;
                    case 34:
                    case 39:
                        m6632e(a);
                        int a7 = m6626a(true);
                        while (true) {
                            if (a7 != -1) {
                                m6632e(a7);
                                if (a7 == a) {
                                    z5 = true;
                                } else {
                                    a7 = m6626a(true);
                                }
                            } else {
                                this.f6670y = 0;
                                this.f6647b = null;
                                this.f6645D.mo18988b("msg.XML.bad.form", (String) null);
                                z5 = false;
                            }
                        }
                        if (!z5) {
                            return -1;
                        }
                        break;
                    case 47:
                        m6632e(a);
                        if (m6635g() == 62) {
                            m6632e(m6626a(true));
                            this.f6664s = false;
                            this.f6665t--;
                            break;
                        }
                        break;
                    case 61:
                        m6632e(a);
                        this.f6663r = true;
                        break;
                    case 62:
                        m6632e(a);
                        this.f6664s = false;
                        this.f6663r = false;
                        break;
                    case 123:
                        mo19085b(a);
                        this.f6647b = m6633f();
                        return 145;
                    default:
                        m6632e(a);
                        this.f6663r = false;
                        break;
                }
                if (!this.f6664s && this.f6665t == 0) {
                    this.f6647b = m6633f();
                    return 148;
                }
            }
            a = m6626a(true);
        }
        this.f6661p = this.f6659n;
        this.f6670y = 0;
        this.f6647b = null;
        this.f6645D.mo18988b("msg.XML.bad.form", (String) null);
        return -1;
    }

    /* renamed from: f */
    private String m6633f() {
        this.f6661p = this.f6659n;
        return new String(this.f6669x, 0, this.f6670y);
    }

    /* renamed from: e */
    private void m6632e(int i) {
        int i2 = this.f6670y;
        if (i2 == this.f6669x.length) {
            char[] cArr = new char[(this.f6669x.length * 2)];
            System.arraycopy(this.f6669x, 0, cArr, 0, i2);
            this.f6669x = cArr;
        }
        this.f6669x[i2] = (char) i;
        this.f6670y = i2 + 1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo19085b(int i) {
        if (this.f6652g != 0 && this.f6651f[this.f6652g - 1] == 10) {
            Kit.m5810a();
        }
        int[] iArr = this.f6651f;
        int i2 = this.f6652g;
        this.f6652g = i2 + 1;
        iArr[i2] = i;
        this.f6659n--;
    }

    /* renamed from: f */
    private boolean m6634f(int i) {
        int i2;
        if (this.f6652g == 0) {
            while (true) {
                if (this.f6656k == null) {
                    if (this.f6658m == this.f6644C && !m6639j()) {
                        this.f6642A = true;
                        i2 = -1;
                        break;
                    }
                    this.f6659n++;
                    char[] cArr = this.f6657l;
                    int i3 = this.f6658m;
                    this.f6658m = i3 + 1;
                    i2 = cArr[i3];
                } else if (this.f6658m == this.f6644C) {
                    this.f6642A = true;
                    i2 = -1;
                    break;
                } else {
                    this.f6659n++;
                    String str = this.f6656k;
                    int i4 = this.f6658m;
                    this.f6658m = i4 + 1;
                    i2 = str.charAt(i4);
                }
                if (i2 > 127) {
                    if (i2 == 65279) {
                        break;
                    } else if (!m6631d(i2)) {
                        if (ScriptRuntime.m6389a(i2)) {
                            this.f6654i = i2;
                            i2 = 10;
                        }
                    }
                } else if (i2 == 10 || i2 == 13) {
                    this.f6654i = i2;
                    i2 = 10;
                }
            }
        } else {
            this.f6659n++;
            int[] iArr = this.f6651f;
            int i5 = this.f6652g - 1;
            this.f6652g = i5;
            i2 = iArr[i5];
        }
        if (i2 == i) {
            this.f6661p = this.f6659n;
            return true;
        }
        m6636g(i2);
        return false;
    }

    /* renamed from: g */
    private int m6635g() {
        int a = m6626a(true);
        mo19085b(a);
        return a;
    }

    /* renamed from: h */
    private int m6637h() {
        return m6626a(true);
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 142 */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008d, code lost:
        if (m6631d(r0) == false) goto L_0x008f;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m6626a(boolean r8) {
        /*
            r7 = this;
            r6 = 13
            r5 = 1
            r2 = -1
            r1 = 10
            int r0 = r7.f6652g
            if (r0 == 0) goto L_0x0039
            int r0 = r7.f6659n
            int r0 = r0 + 1
            r7.f6659n = r0
            int[] r0 = r7.f6651f
            int r1 = r7.f6652g
            int r1 = r1 + -1
            r7.f6652g = r1
            r0 = r0[r1]
        L_0x001a:
            return r0
        L_0x001b:
            int r0 = r7.f6659n
            int r0 = r0 + 1
            r7.f6659n = r0
            java.lang.String r0 = r7.f6656k
            int r3 = r7.f6658m
            int r4 = r3 + 1
            r7.f6658m = r4
            char r0 = r0.charAt(r3)
        L_0x002d:
            int r3 = r7.f6654i
            if (r3 < 0) goto L_0x0076
            int r3 = r7.f6654i
            if (r3 != r6) goto L_0x0068
            if (r0 != r1) goto L_0x0068
            r7.f6654i = r1
        L_0x0039:
            java.lang.String r0 = r7.f6656k
            if (r0 == 0) goto L_0x0047
            int r0 = r7.f6658m
            int r3 = r7.f6644C
            if (r0 != r3) goto L_0x001b
            r7.f6642A = r5
            r0 = r2
            goto L_0x001a
        L_0x0047:
            int r0 = r7.f6658m
            int r3 = r7.f6644C
            if (r0 != r3) goto L_0x0057
            boolean r0 = r7.m6639j()
            if (r0 != 0) goto L_0x0057
            r7.f6642A = r5
            r0 = r2
            goto L_0x001a
        L_0x0057:
            int r0 = r7.f6659n
            int r0 = r0 + 1
            r7.f6659n = r0
            char[] r0 = r7.f6657l
            int r3 = r7.f6658m
            int r4 = r3 + 1
            r7.f6658m = r4
            char r0 = r0[r3]
            goto L_0x002d
        L_0x0068:
            r7.f6654i = r2
            int r3 = r7.f6658m
            int r3 = r3 + -1
            r7.f6653h = r3
            int r3 = r7.f6655j
            int r3 = r3 + 1
            r7.f6655j = r3
        L_0x0076:
            r3 = 127(0x7f, float:1.78E-43)
            if (r0 > r3) goto L_0x0082
            if (r0 == r1) goto L_0x007e
            if (r0 != r6) goto L_0x001a
        L_0x007e:
            r7.f6654i = r0
            r0 = r1
            goto L_0x001a
        L_0x0082:
            r3 = 65279(0xfeff, float:9.1475E-41)
            if (r0 == r3) goto L_0x001a
            if (r8 == 0) goto L_0x008f
            boolean r3 = m6631d(r0)
            if (r3 != 0) goto L_0x0039
        L_0x008f:
            boolean r2 = org.mozilla.javascript.ScriptRuntime.m6389a(r0)
            if (r2 == 0) goto L_0x001a
            r7.f6654i = r0
            r0 = r1
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.TokenStream.m6626a(boolean):int");
    }

    /* renamed from: g */
    private void m6636g(int i) {
        int[] iArr = this.f6651f;
        int i2 = this.f6652g;
        this.f6652g = i2 + 1;
        iArr[i2] = i;
        this.f6659n--;
    }

    /* renamed from: i */
    private void m6638i() {
        int a;
        do {
            a = m6626a(true);
            if (a == -1) {
                break;
            }
        } while (a != 10);
        mo19085b(a);
        this.f6661p = this.f6659n;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final String mo19086c() {
        if (this.f6656k != null) {
            int i = this.f6658m;
            if (this.f6654i >= 0) {
                i--;
            } else {
                while (i != this.f6644C && !ScriptRuntime.m6389a((int) this.f6656k.charAt(i))) {
                    i++;
                }
            }
            return this.f6656k.substring(this.f6653h, i);
        }
        int i2 = this.f6658m - this.f6653h;
        if (this.f6654i < 0) {
            while (true) {
                int i3 = this.f6653h + i2;
                if (i3 == this.f6644C) {
                    try {
                        if (!m6639j()) {
                            break;
                        }
                        i3 = this.f6653h + i2;
                    } catch (IOException e) {
                    }
                }
                if (ScriptRuntime.m6389a((int) this.f6657l[i3])) {
                    break;
                }
                i2++;
            }
        } else {
            i2--;
        }
        return new String(this.f6657l, this.f6653h, i2);
    }

    /* renamed from: j */
    private boolean m6639j() {
        if (this.f6656k != null) {
            Kit.m5810a();
        }
        if (this.f6644C == this.f6657l.length) {
            if (this.f6653h == 0 || mo19088e()) {
                char[] cArr = new char[(this.f6657l.length * 2)];
                System.arraycopy(this.f6657l, 0, cArr, 0, this.f6644C);
                this.f6657l = cArr;
            } else {
                System.arraycopy(this.f6657l, this.f6653h, this.f6657l, 0, this.f6644C - this.f6653h);
                this.f6644C -= this.f6653h;
                this.f6658m -= this.f6653h;
                this.f6653h = 0;
            }
        }
        int read = this.f6643B.read(this.f6657l, this.f6644C, this.f6657l.length - this.f6644C);
        if (read < 0) {
            return false;
        }
        this.f6644C += read;
        return true;
    }

    /* renamed from: d */
    public final int mo19087d() {
        return this.f6661p - this.f6660o;
    }

    /* renamed from: c */
    private void m6629c(String str) {
        if (this.f6645D.f6427a.f6749l && this.f6643B != null) {
            this.f6666u = str;
            this.f6667v = this.f6658m - 1;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public final boolean mo19088e() {
        return this.f6667v != -1;
    }
}
