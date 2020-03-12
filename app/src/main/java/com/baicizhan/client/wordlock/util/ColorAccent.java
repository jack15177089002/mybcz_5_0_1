package com.baicizhan.client.wordlock.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import p012ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

public class ColorAccent {
    private static final AccentFinder ACCENT_FINDER = new AccentFinder();
    /* access modifiers changed from: private */
    public static final Map<String, String> ACCENT_STANDARDS;
    private static final String ALL_SIGNS = "ˈ'";
    private static final String IGNORE_ACCENT_SIGN_PATTERN = "[\\[\\]\\(\\)\\s\\u00A0ˌ]+";
    /* access modifiers changed from: private */
    public static final String[] LONG_VOWEL_ACCENT = {":", "ː", ""};
    private static final String OTHER_SIGN_PATTERN = "[ˈ']+";
    /* access modifiers changed from: private */
    public static final Set<String> R_ACCENTS = new HashSet(Arrays.asList(new String[]{"r"}));
    private static final String SECOND_ACCENTS = "ˌ";
    /* access modifiers changed from: private */
    public static final Set<Character> SEMIVOWELS = new HashSet(Arrays.asList(new Character[]{Character.valueOf('y'), Character.valueOf('r'), Character.valueOf('w')}));
    /* access modifiers changed from: private */
    public static final Map<String, Element> SPECIAL_CASE_MAP;
    private static final String STANDARD_SIGN = "ˈ";
    /* access modifiers changed from: private */
    public static final Set<Character> VOWELS = new HashSet(Arrays.asList(new Character[]{Character.valueOf('a'), Character.valueOf('e'), Character.valueOf('i'), Character.valueOf('o'), Character.valueOf('u')}));
    /* access modifiers changed from: private */
    public static final String[] VOWEL_ACCENTS = {"aɪr", "aɪə", "er", "ɑr", "oʊə", "ɒ", IntegerTokenConverter.CONVERTER_KEY, "ɪ", "ə", "ɜ", "ɜr", "ɔr", "ɒr", "ɔ", "uə", "ʊ", "u", "ʌ", "ɑ", "ɛ", "æ", "e", "aɪ", "ɔɪ", "aʊ", "o", "ɪr", "ɛr", "ʊr", "eə", "ʊə", "ɪə", "iə", "eɪ", "əl", "əʊ", "oʊ", "ɒ̃", "aʊr", "aɪər"};
    private static final WordFinder WORD_FINDER = new WordFinder();
    /* access modifiers changed from: private */
    public static final Set<String> Y_ACCENTS = new HashSet(Arrays.asList(new String[]{"aɪ", IntegerTokenConverter.CONVERTER_KEY, "ɪ"}));
    public static boolean debug = false;

    static class AccentFinder {
        AccentFinder() {
        }

        public List<Element> getAccentPos(String str) {
            if (str == null) {
                return null;
            }
            Element signPos = getSignPos(str);
            Element vowelsPos = getVowelsPos(str, signPos.end);
            ArrayList arrayList = new ArrayList();
            arrayList.add(signPos);
            arrayList.add(vowelsPos);
            return arrayList;
        }

        private Element getVowelsPos(String str, int i) {
            Element element = new Element(i, i);
            int length = str.toCharArray().length;
            for (int i2 = i; i2 < length; i2++) {
                String substring = str.substring(i2);
                int i3 = -1;
                int i4 = -1;
                int i5 = 0;
                while (i5 < ColorAccent.VOWEL_ACCENTS.length) {
                    int i6 = i3;
                    int i7 = i4;
                    for (String str2 : getPossibleVowelAccents(ColorAccent.VOWEL_ACCENTS[i5])) {
                        if (str2 != null && !str2.isEmpty() && substring.startsWith(str2) && str2.length() > i6) {
                            String substring2 = str2.substring(str2.length() - 1);
                            String substring3 = substring.substring(str2.length());
                            if (ColorAccent.R_ACCENTS.contains(substring2)) {
                                boolean z = false;
                                String[] access$600 = ColorAccent.VOWEL_ACCENTS;
                                int length2 = access$600.length;
                                int i8 = 0;
                                while (true) {
                                    if (i8 >= length2) {
                                        break;
                                    } else if (substring3.startsWith(access$600[i8])) {
                                        z = true;
                                        break;
                                    } else {
                                        i8++;
                                    }
                                }
                                if (!z) {
                                    i6 = str2.length();
                                    i7 = i2;
                                }
                            } else {
                                i6 = str2.length();
                                i7 = i2;
                            }
                        }
                    }
                    i5++;
                    i4 = i7;
                    i3 = i6;
                }
                if (i4 >= 0) {
                    element.set(i4, i4 + i3);
                    return element;
                }
            }
            return element;
        }

        private List<String> getPossibleVowelAccents(String str) {
            String[] access$700;
            ArrayList arrayList = new ArrayList();
            for (String str2 : ColorAccent.LONG_VOWEL_ACCENT) {
                for (int i = 1; i <= str.length(); i++) {
                    arrayList.add(str.substring(0, i) + str2 + str.substring(i));
                }
            }
            return arrayList;
        }

        private Element getSignPos(String str) {
            int i = 0;
            Element element = new Element(0, 0);
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            while (true) {
                if (i >= length) {
                    break;
                }
//                if (ColorAccent.ALL_SIGNS.contains(charArray[i])) {
//                    element.set(i, i + 1);
//                    break;
//                }
                i++;
            }
            return element;
        }
    }

    public static class Element {
        public int end;
        public int start;

        public Element() {
        }

        public Element(int i, int i2) {
            set(i, i2);
        }

        public String toString() {
            return "Element [start=" + this.start + ", end=" + this.end + "]";
        }

        public void set(int i, int i2) {
            this.start = i;
            this.end = i2;
        }
    }

    static class WordFinder {
        WordFinder() {
        }

        public Element getWordPos(String str, String str2) {
            if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (ColorAccent.SPECIAL_CASE_MAP.containsKey(lowerCase)) {
                return (Element) ColorAccent.SPECIAL_CASE_MAP.get(lowerCase);
            }
            String replaceAll = str2.replaceAll(ColorAccent.IGNORE_ACCENT_SIGN_PATTERN, "").replaceAll(ColorAccent.OTHER_SIGN_PATTERN, ColorAccent.STANDARD_SIGN);
            String str3 = replaceAll;
            for (Entry entry : ColorAccent.ACCENT_STANDARDS.entrySet()) {
                str3 = str3.replaceAll((String) entry.getKey(), (String) entry.getValue());
            }
            return findVowelPos(lowerCase, replaceAll, findPossibleStartPos(lowerCase, str3));
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x00c3  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00e4  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x011f A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int findPossibleStartPos(String r20, String r21) {
            /*
                r19 = this;
                com.baicizhan.client.wordlock.util.StringLCS r11 = new com.baicizhan.client.wordlock.util.StringLCS
                r11.<init>()
                int r12 = r20.length()
                r9 = 0
                r3 = 0
                r4 = 4746794007244308480(0x41dfffffffc00000, double:2.147483647E9)
                r8 = 0
            L_0x0011:
                if (r8 >= r12) goto L_0x012e
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r6 = 0
                r0 = r20
                java.lang.String r6 = r0.substring(r6, r8)
                java.lang.StringBuilder r2 = r2.append(r6)
                java.lang.String r6 = "ˈ"
                java.lang.StringBuilder r2 = r2.append(r6)
                r0 = r20
                java.lang.String r6 = r0.substring(r8)
                java.lang.StringBuilder r2 = r2.append(r6)
                java.lang.String r2 = r2.toString()
                r0 = r21
                int r10 = r11.lcs(r2, r0)
                r0 = r19
                r1 = r21
                double r6 = r0.distance(r2, r1)
                if (r8 <= 0) goto L_0x0129
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                int r13 = r8 + -1
                r0 = r20
                char r13 = r0.charAt(r13)
                java.lang.StringBuilder r2 = r2.append(r13)
                java.lang.String r13 = "ˈ"
                java.lang.StringBuilder r2 = r2.append(r13)
                java.lang.String r2 = r2.toString()
            L_0x0062:
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                java.lang.String r14 = "ˈ"
                r13.<init>(r14)
                r0 = r20
                char r14 = r0.charAt(r8)
                java.lang.StringBuilder r13 = r13.append(r14)
                java.lang.String r13 = r13.toString()
                if (r2 == 0) goto L_0x0081
                r0 = r21
                boolean r2 = r0.contains(r2)
                if (r2 != 0) goto L_0x0089
            L_0x0081:
                r0 = r21
                boolean r2 = r0.contains(r13)
                if (r2 == 0) goto L_0x0094
            L_0x0089:
                r14 = 4596373779694328218(0x3fc999999999999a, double:0.2)
                int r2 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
                if (r2 >= 0) goto L_0x0094
                int r10 = r10 + 1
            L_0x0094:
                if (r8 <= 0) goto L_0x012c
                java.util.Set r2 = com.baicizhan.client.wordlock.util.ColorAccent.VOWELS
                int r13 = r8 + -1
                r0 = r20
                char r13 = r0.charAt(r13)
                java.lang.Character r13 = java.lang.Character.valueOf(r13)
                boolean r2 = r2.contains(r13)
                if (r2 == 0) goto L_0x012c
                java.util.Set r2 = com.baicizhan.client.wordlock.util.ColorAccent.VOWELS
                r0 = r20
                char r13 = r0.charAt(r8)
                java.lang.Character r13 = java.lang.Character.valueOf(r13)
                boolean r2 = r2.contains(r13)
                if (r2 == 0) goto L_0x012c
                r2 = 1
            L_0x00c1:
                if (r2 == 0) goto L_0x00c6
                r14 = 4616189618054758400(0x4010000000000000, double:4.0)
                double r6 = r6 * r14
            L_0x00c6:
                int r2 = r9 * 2
                if (r10 > r2) goto L_0x00dd
                int r2 = r9 + 2
                if (r10 >= r2) goto L_0x00dd
                if (r10 <= r9) goto L_0x00d7
                r14 = 4613937818241073152(0x4008000000000000, double:3.0)
                double r14 = r14 * r4
                int r2 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
                if (r2 < 0) goto L_0x00dd
            L_0x00d7:
                if (r10 != r9) goto L_0x0138
                int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r2 > 0) goto L_0x0138
            L_0x00dd:
                r2 = r6
                r4 = r8
                r5 = r10
            L_0x00e0:
                boolean r9 = com.baicizhan.client.wordlock.util.ColorAccent.debug
                if (r9 == 0) goto L_0x011f
                java.io.PrintStream r9 = java.lang.System.out
                java.lang.String r13 = "%d old:[%d %d %f] new:[%d %d %f]\n"
                r14 = 7
                java.lang.Object[] r14 = new java.lang.Object[r14]
                r15 = 0
                java.lang.Integer r16 = java.lang.Integer.valueOf(r8)
                r14[r15] = r16
                r15 = 1
                java.lang.Integer r16 = java.lang.Integer.valueOf(r5)
                r14[r15] = r16
                r15 = 2
                java.lang.Integer r16 = java.lang.Integer.valueOf(r4)
                r14[r15] = r16
                r15 = 3
                java.lang.Double r16 = java.lang.Double.valueOf(r2)
                r14[r15] = r16
                r15 = 4
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
                r14[r15] = r10
                r10 = 5
                java.lang.Integer r15 = java.lang.Integer.valueOf(r8)
                r14[r10] = r15
                r10 = 6
                java.lang.Double r6 = java.lang.Double.valueOf(r6)
                r14[r10] = r6
                r9.printf(r13, r14)
            L_0x011f:
                int r8 = r8 + 1
                r9 = r5
                r17 = r4
                r4 = r2
                r3 = r17
                goto L_0x0011
            L_0x0129:
                r2 = 0
                goto L_0x0062
            L_0x012c:
                r2 = 0
                goto L_0x00c1
            L_0x012e:
                boolean r2 = com.baicizhan.client.wordlock.util.ColorAccent.debug
                if (r2 == 0) goto L_0x0137
                java.io.PrintStream r2 = java.lang.System.out
                r2.println(r3)
            L_0x0137:
                return r3
            L_0x0138:
                r17 = r4
                r4 = r3
                r5 = r9
                r2 = r17
                goto L_0x00e0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baicizhan.client.wordlock.util.ColorAccent.WordFinder.findPossibleStartPos(java.lang.String, java.lang.String):int");
        }

        private int getContinueVowlsEndPos(char[] cArr, int i, String str) {
            char c;
            boolean z = true;
            int min = Math.min(cArr.length, i + 3);
            int i2 = i;
            while (true) {
                if (i2 >= min) {
                    i2 = i;
                    break;
                }
                char c2 = cArr[i2];
                if (!ColorAccent.VOWELS.contains(Character.valueOf(c2)) && !ColorAccent.SEMIVOWELS.contains(Character.valueOf(c2))) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                i2 = min;
            }
            int i3 = i;
            while (i3 < i2) {
                char c3 = cArr[i3];
                if (ColorAccent.SEMIVOWELS.contains(Character.valueOf(c3))) {
                    if ('r' == c3) {
                        char c4 = i3 > 0 ? cArr[i3 - 1] : 0;
                        if (i3 < cArr.length - 1) {
                            c = cArr[i3 + 1];
                        } else {
                            c = 0;
                        }
                        if (!ColorAccent.VOWELS.contains(Character.valueOf(c4)) || ColorAccent.VOWELS.contains(Character.valueOf(c)) || ColorAccent.SEMIVOWELS.contains(Character.valueOf(c))) {
                            try {
                                Element element = (Element) ColorAccent.getAccentPos(str).get(1);
                                String substring = str.substring(element.start, element.end);
                                if (substring == null || substring.isEmpty() || !ColorAccent.R_ACCENTS.contains(substring.substring(substring.length() - 1))) {
                                    return i3;
                                }
                            } catch (Exception e) {
                            }
                        }
                    } else if (i3 != i2 - 1) {
                        return i3;
                    }
                }
                i3++;
            }
            return i2;
        }

        private Element findVowelPos(String str, String str2, int i) {
            char c;
            Element element = new Element(i, i);
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            int i2 = i;
            while (i2 < length) {
                char c2 = charArray[i2];
                if (ColorAccent.VOWELS.contains(Character.valueOf(c2))) {
                    if ('u' == c2) {
                        char c3 = i2 > 0 ? charArray[i2 - 1] : 0;
                        if (i2 < length - 1) {
                            c = charArray[i2 + 1];
                        } else {
                            c = 0;
                        }
                        if (c3 == 'q') {
                            continue;
                        } else if (c3 == 'g' && ColorAccent.VOWELS.contains(Character.valueOf(c))) {
                        }
                    }
                    element.start = i2;
                    element.end = getContinueVowlsEndPos(charArray, i2, str2);
                    return element;
                } else if ('y' == c2) {
                    try {
                        char c4 = charArray[i2 - 1];
                        if (!ColorAccent.VOWELS.contains(Character.valueOf(c4)) && !ColorAccent.SEMIVOWELS.contains(Character.valueOf(c4))) {
                            Element element2 = (Element) ColorAccent.getAccentPos(str2).get(1);
                            if (ColorAccent.Y_ACCENTS.contains(str2.substring(element2.start, element2.end))) {
                                element.set(i2, i2 + 1);
                                return element;
                            }
                        }
                    } catch (Exception e) {
                    }
                } else {
                    continue;
                }
                i2++;
            }
            for (int i3 = length - 1; i3 >= i; i3--) {
                if (ColorAccent.SEMIVOWELS.contains(Character.valueOf(charArray[i3]))) {
                    element.start = i3;
                    element.end = getContinueVowlsEndPos(charArray, i3, str2);
                    return element;
                }
            }
            return element;
        }

        private double distance(String str, String str2) {
            String[] split = str.split(ColorAccent.STANDARD_SIGN);
            String[] strArr = str2.contains(ColorAccent.STANDARD_SIGN) ? str2.split(ColorAccent.STANDARD_SIGN) : new String[]{"", str2};
            int length = str.length();
            int length2 = str2.length();
            int i = (split == null || split.length <= 0 || split[0] == null) ? 0 : split[0].length();
            int i2 = (split == null || split.length <= 1 || split[1] == null) ? 0 : split[1].length();
            int i3 = (strArr == null || strArr.length <= 0 || strArr[0] == null) ? 0 : strArr[0].length();
            int i4 = (strArr == null || strArr.length <= 1 || strArr[1] == null) ? 0 : strArr[1].length();
            if ((i == 0 && i3 == 0) || (i2 == 0 && i4 == 0)) {
                return 0.0d;
            }
            return Math.sqrt(Math.pow(((((double) i2) * 1.0d) / ((double) length)) - ((((double) i4) * 1.0d) / ((double) length2)), 2.0d) + Math.pow(((((double) i) * 1.0d) / ((double) length)) - ((((double) i3) * 1.0d) / ((double) length2)), 2.0d));
        }
    }

    static {
        HashMap hashMap = new HashMap();
        ACCENT_STANDARDS = hashMap;
        hashMap.put("[iɪ]+", IntegerTokenConverter.CONVERTER_KEY);
        HashMap hashMap2 = new HashMap();
        SPECIAL_CASE_MAP = hashMap2;
        hashMap2.put("coercion", new Element(2, 4));
    }

    public static Element getWordPos(String str, String str2) {
        return WORD_FINDER.getWordPos(str, str2);
    }

    public static List<Element> getAccentPos(String str) {
        return ACCENT_FINDER.getAccentPos(str);
    }
}
