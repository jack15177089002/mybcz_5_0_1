package com.baicizhan.client.business.color_sentence;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import p012ch.qos.logback.core.CoreConstants;

public class ColorSentence {
    private static final String ILLEGAL_SPACES = "[\\u00A0]+";
    private static final double MAX_SIMILAR_THRESHOLD = 0.9d;
    private static final double MIDDLE_SIMILAR_THRESHOLD = 0.45d;
    private static final String SPLIT_CHARS = "[^a-zA-Z'\\-]+";
    private static final String UNPERMIT_CHARS = "[^a-zA-Z'\\-]+";
    static boolean debug = false;
    private StringLCS lcs = new StringLCS();
    private String sentence;
    private Collection<String> variants;
    private String word;

    class SearchInfo {

        /* renamed from: id */
        public int f2225id;
        public double value;

        public SearchInfo() {
        }

        public SearchInfo(int i, double d) {
            this.f2225id = i;
            this.value = d;
        }
    }

    public class Segment {
        public int end;
        public int start;

        public Segment() {
        }

        public Segment(int i, int i2) {
            set(i, i2);
        }

        public String toString() {
            return "Segment [start=" + this.start + ", end=" + this.end + "]";
        }

        public void set(int i, int i2) {
            this.start = i;
            this.end = i2;
        }
    }

    class Unify {
//        static final String[] CASES;
//        static final Map<String, String> MAP = new HashMap();
//
//        Unify() {
//        }
//
//        static String getUnify(String str) {
//            return (String) MAP.get(str);
//        }
//
//        static boolean canReplace(String str, String str2) {
//            String str3 = (String) MAP.get(str2);
//            if (str3 == null || !str3.equals(str)) {
//                return false;
//            }
//            return true;
//        }
//
//        static {
//            String[] strArr = {"be am is are was were being been", "one's my your her his our their", "oneself myself yourself herself himself ourselves yourselves themselves", "abide abode abided", "alight alighted alit", "arise arose arisen", "awake awoke awaked awoken", "bear bore born borned", "bid bade bidden", "bide bode bided", "bind bound", "blow blew blown", "break broke broken", "bring brought", "buy bought", "can could", "catch caught", "cleave clave cloven", "cling clung", "clothe clothed clad", "come came", "crow crowed crew", "dare dared durst", "dig dug", "do does did done", "draw drew drawn", "drink drank drunk", "drive drove driven", "eat ate eaten", "fall fell fallen", "feed fed", "feel felt", "fight fought", "find found", "fling flung", "fly flew flown", "freeze froze frozen", "get got gotten", "give gave given", "go went gone", "grind ground", "grow grew g rown", "hang hung hanged", "have has had", "heave heaved hove", "hold held", "keep kept", "know knew known", "lay laid", "lead led", "leave left", "lie lied lay lain", "light lit", "make made", "may might", "meet met", "pay paid", "reave reaved reft", "reeve rove reeved", "ride rode ridden", "ring rang rung", "rise rose risen", "run ran", "say said", "see saw seen", "seek sought", "sell sold", "shake shook shaken", "shall should", "shine shone shined", "sing sang sung", "sink sank sunk ", "sit sat", "slay slew slain", "sleep slept", "sling slung", "slink slunk", "smite smote smitten", "speak spoke spoken", "spin spun", "spit spat", "stand stood", "stave staved stove", "steal stole stolen", "stick stuck", "sting stung", "stink stank stunk", "swear swore sworn", "swim swam swum", "swing swung", "take took taken", "teach taught", "tear tore torn", "tell told", "think thought", "tread trod trodden", "wake woke woken", "wear wore worn", "weave wove woven", "weep wept", "will would", "win won", "wind wound", "wit wist", "wring wrung wrung"};
//            CASES = strArr;
//            for (int i = 0; i < 105; i++) {
//                try {
//                    String[] split = strArr[i].split(" ");
//                    for (String str : split) {
//                        if (str != null && !str.trim().isEmpty()) {
//                            MAP.put(str.trim(), split[0].trim());
//                        }
//                    }
//                } catch (Exception e) {
//                }
//            }
//        }
    }

    public static List<Segment> getSegments(String str, String str2, Collection<String> collection) {
        return new ColorSentence(str, str2, collection).color();
    }

    public ColorSentence(String str, String str2, Collection<String> collection) {
        this.sentence = str;
        this.word = str2;
        this.variants = collection;
    }

    private List<Segment> color() {
        prepareAll();
        if (this.sentence == null || this.sentence.isEmpty() || this.word == null || this.word.isEmpty()) {
            return null;
        }
        if (this.variants != null && !this.variants.isEmpty()) {
            for (String exactMatch : this.variants) {
                List<Segment> exactMatch2 = exactMatch(this.sentence, exactMatch);
                if (exactMatch2 != null && !exactMatch2.isEmpty()) {
                    return exactMatch2;
                }
            }
        }
        return fuzzyMatch(this.sentence, this.word);
    }

    private void prepareAll() {
        if (this.sentence != null) {
//            this.sentence = this.sentence.replace(8217, CoreConstants.SINGLE_QUOTE_CHAR);
            this.sentence = this.sentence.replace("--", "  ");
            this.sentence = this.sentence.replace(" '", "  ").replace("' ", "  ");
            this.sentence = this.sentence.toLowerCase();
        }
        if (this.word != null) {
//            this.word = this.word.replace(8217, CoreConstants.SINGLE_QUOTE_CHAR);
            this.word = this.word.replaceAll(ILLEGAL_SPACES, " ");
            this.word = this.word.replaceAll("\\([^\\)]+\\)", "");
            this.word = this.word.trim();
            this.word = this.word.toLowerCase();
        }
        if (this.variants != null && !this.variants.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (String replaceAll : this.variants) {
                arrayList.add(replaceAll.replaceAll(ILLEGAL_SPACES, " ").trim().toLowerCase());
            }
            this.variants = arrayList;
        }
        if (debug) {
            System.out.println("prepare: " + this.sentence);
            System.out.println("prepare: " + this.word);
            System.out.println("prepare: " + this.variants);
        }
    }

    private List<Segment> fuzzyMatch(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String[] splitSentense = splitSentense(str);
        if (splitSentense == null || splitSentense.length == 0) {
            return null;
        }
        String[] split = str2.split("[^a-zA-Z'\\-]+");
        if (split == null || split.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (split.length == 1) {
            String str3 = split[0];
            for (int i = 0; i < splitSentense.length; i++) {
                int findPossibleFuzzyPos = findPossibleFuzzyPos(splitSentense, i, i + 1, str3, MAX_SIMILAR_THRESHOLD);
                if (findPossibleFuzzyPos >= 0 && findPossibleFuzzyPos < splitSentense.length) {
                    arrayList.add(Integer.valueOf(findPossibleFuzzyPos));
                }
            }
        }
        if (arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (String findPossibleFuzzyPosFull : split) {
                List findPossibleFuzzyPosFull2 = findPossibleFuzzyPosFull(splitSentense, 0, splitSentense.length, findPossibleFuzzyPosFull, MIDDLE_SIMILAR_THRESHOLD);
                if (findPossibleFuzzyPosFull2 != null && !findPossibleFuzzyPosFull2.isEmpty()) {
                    arrayList2.add(findPossibleFuzzyPosFull2);
                }
            }
            List searchPath = searchPath(arrayList2);
            if (searchPath != null) {
                arrayList.addAll(searchPath);
            }
        }
        if (arrayList.isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            for (String findPossibleFuzzyPosFull3 : split) {
                List findPossibleFuzzyPosFull4 = findPossibleFuzzyPosFull(splitSentense, 0, splitSentense.length, findPossibleFuzzyPosFull3, 0.0d);
                if (findPossibleFuzzyPosFull4 != null && !findPossibleFuzzyPosFull4.isEmpty()) {
                    arrayList3.add(findPossibleFuzzyPosFull4);
                }
            }
            List searchPath2 = searchPath(arrayList3);
            if (searchPath2 != null) {
                arrayList.addAll(searchPath2);
            }
        }
        if (debug) {
            System.out.println("fuzzy-result:" + arrayList);
        }
        return changeIdsToSegments(str, splitSentense, arrayList);
    }

    private List<Integer> searchPath(List<List<Integer>> list) {
        Integer[] numArr;
        int i;
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    int i2 = Integer.MAX_VALUE;
                    Integer[] numArr2 = null;
//                    for (Integer num : (List) list.get(0)) {
//                        Integer[] numArr3 = new Integer[list.size()];
//                        numArr3[0] = num;
//                        if (dfs(list, 1, numArr3)) {
//                            try {
//                                int intValue = numArr3[list.size() - 1].intValue() - numArr3[0].intValue();
//                                if (intValue < i2) {
//                                    Integer[] numArr4 = numArr3;
//                                    i = intValue;
//                                    numArr = numArr4;
//                                } else {
//                                    numArr = numArr2;
//                                    i = i2;
//                                }
//                                numArr2 = numArr;
//                                i2 = i;
//                            } catch (Exception e) {
//                            }
//                        }
//                    }
                    if (numArr2 == null) {
                        return null;
                    }
                    return Arrays.asList(numArr2);
                }
            } catch (Exception e2) {
                return null;
            }
        }
        return null;
    }

    private boolean dfs(List<List<Integer>> list, int i, Integer[] numArr) {
        while (i < list.size()) {
            List<Integer> list2 = (List) list.get(i);
            int intValue = numArr[i - 1].intValue();
            for (Integer num : list2) {
                if (num.intValue() > intValue) {
                    numArr[i] = num;
                    if (i >= list.size() - 1) {
                        return true;
                    }
                    i++;
                }
            }
            return false;
        }
        return true;
    }

    private String[] splitSentense(String str) {
        String[] split = this.sentence.split("[^a-zA-Z'\\-]+");
        if (split == null || split.length == 0) {
            return null;
        }
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].replaceAll("[^a-zA-Z'\\-]+", "");
        }
        return split;
    }

    private List<Segment> changeIdsToSegments(String str, String[] strArr, List<Integer> list) {
        if (str == null || strArr == null || list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Pattern compile = Pattern.compile("[^a-zA-Z'\\-]+");
        Pattern compile2 = Pattern.compile("[^a-zA-Z'\\-]+");
        for (Integer num : list) {
            if (num.intValue() >= 0 && num.intValue() < strArr.length) {
                Matcher matcher = compile.matcher(str);
                boolean z = false;
                for (int i = 0; i < num.intValue(); i++) {
                    if (matcher.find()) {
                        z = true;
                    }
                }
                if (z || num.intValue() <= 0) {
                    String str2 = strArr[num.intValue()];
                    int end = !z ? 0 : matcher.end();
                    boolean z2 = false;
                    int i2 = end;
                    int i3 = end;
//                    while (end < str.length()) {
//                        String str3 = str.charAt(end);
//                        if (compile.matcher(str3).matches()) {
//                            break;
//                        }
//                        if (compile2.matcher(str3).matches()) {
//                            if (z2) {
//                                break;
//                            }
//                        } else if (!z2) {
//                            z2 = true;
//                            i3 = end;
//                        }
//                        end++;
//                        i2++;
//                    }
                    if (i3 >= 0 && i2 <= str.length()) {
                        Segment segment = new Segment(i3, i2);
                        if (debug) {
                            System.out.printf("id2seg: %s => %s\n", new Object[]{str2, segment});
                        }
                        arrayList.add(segment);
                    }
                }
            }
        }
        return arrayList;
    }

    private int findPossibleFuzzyPos(String[] strArr, int i, int i2, String str, double d) {
        List findPossibleFuzzyPosFull = findPossibleFuzzyPosFull(strArr, i, i2, str, d);
        if (findPossibleFuzzyPosFull == null || findPossibleFuzzyPosFull.isEmpty()) {
            return -1;
        }
        return ((Integer) findPossibleFuzzyPosFull.get(0)).intValue();
    }

    private List<Integer> findPossibleFuzzyPosFull(String[] strArr, int i, int i2, String str, double d) {
        int i3;
        double d2;
        ArrayList arrayList = new ArrayList();
        double d3 = 0.0d;
        int i4 = 0;
        while (i < i2) {
            String str2 = strArr[i];
//            if (str2 != null && !str2.isEmpty()) {
//                if (Unify.canReplace(str, str2)) {
//                    if (debug) {
//                        System.out.printf("%s <=> %s\n", new Object[]{str2, str});
//                    }
//                    if (Math.abs(d3 - 1.0d) < 1.0E-6d) {
//                        arrayList.add(Integer.valueOf(i));
//                        i3 = i4;
//                        d2 = d3;
//                    } else if (1.0d > d3) {
//                        arrayList.clear();
//                        arrayList.add(Integer.valueOf(i));
//                        int i5 = i4;
//                        d2 = 1.0d;
//                        i3 = i5;
//                    }
//                    i++;
//                    d3 = d2;
//                    i4 = i3;
//                } else {
//                    int length = str2.length();
//                    int length2 = str.length();
//                    int lcs2 = this.lcs.lcs(str2, str);
//                    double pow = ((((double) lcs2) * 1.0d) / ((double) length)) * Math.pow((((double) lcs2) * 1.0d) / ((double) length2), 2.0d);
//                    if (str2.endsWith("ing")) {
//                        String replaceAll = str2.replaceAll("ing$", "");
//                        int lcs3 = this.lcs.lcs(replaceAll, str);
//                        double length3 = ((((double) lcs3) * 1.0d) / ((double) replaceAll.length())) * ((((double) lcs3) * 1.0d) / ((double) length2));
//                        if (debug) {
//                            System.out.println(str2 + " ==> ing replace = " + replaceAll + ":" + pow + ":" + length3);
//                        }
//                        lcs2 = Math.max(lcs2, lcs3);
//                        pow = Math.max(pow, length3);
//                    }
//                    boolean z = false;
//                    if (pow > d3 - 1.0E-6d && pow >= d) {
//                        z = true;
//                    }
//                    if (debug) {
//                        PrintStream printStream = System.out;
//                        String str3 = "fuzzy-find: %s => %s [%d] [old[%d %g] new[%d %g]] %s\n";
//                        Object[] objArr = new Object[8];
//                        objArr[0] = str;
//                        objArr[1] = strArr[i];
//                        objArr[2] = Integer.valueOf(lcs2);
//                        objArr[3] = Integer.valueOf(-1);
//                        objArr[4] = Double.valueOf(d3);
//                        objArr[5] = Integer.valueOf(i);
//                        objArr[6] = Double.valueOf(pow);
//                        objArr[7] = z ? "[replaced]" : "";
//                        printStream.printf(str3, objArr);
//                    }
//                    if (z) {
//                        if (Math.abs(pow - d3) < 1.0E-6d) {
//                            arrayList.add(Integer.valueOf(i));
//                            i3 = i4;
//                            d2 = d3;
//                        } else if (pow > d3) {
//                            arrayList.clear();
//                            arrayList.add(Integer.valueOf(i));
//                            i3 = lcs2;
//                            d2 = pow;
//                        }
//                        i++;
//                        d3 = d2;
//                        i4 = i3;
//                    }
//                }
//            }
            i3 = i4;
            d2 = d3;
            i++;
            d3 = d2;
            i4 = i3;
        }
        if (d3 >= d) {
            if (i4 >= 2) {
                return arrayList;
            }
            if (d3 > MAX_SIMILAR_THRESHOLD) {
                return arrayList;
            }
        }
        return null;
    }

    private List<Segment> exactMatch(String str, String str2) {
        boolean z;
        if (str == null || str2 == null) {
            return null;
        }
        String[] splitSentense = splitSentense(str);
        if (splitSentense == null || splitSentense.length == 0) {
            return null;
        }
        String[] split = str2.split("[^a-zA-Z'\\-]+");
        if (split == null || split.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (split.length != 1) {
            int length = split.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str3 = split[i];
                int i3 = i2;
                while (true) {
                    if (i3 >= splitSentense.length) {
                        z = false;
                        break;
                    }
                    String str4 = splitSentense[i3];
                    if (str4 != null && str4.equals(str3)) {
                        arrayList.add(Integer.valueOf(i3));
                        i2 = i3;
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (!z) {
                    arrayList.clear();
                    break;
                }
                i++;
            }
        } else {
            String str5 = split[0];
            for (int i4 = 0; i4 < splitSentense.length; i4++) {
                String str6 = splitSentense[i4];
                if (str6 != null && str6.equals(str5)) {
                    arrayList.add(Integer.valueOf(i4));
                }
            }
        }
        return changeIdsToSegments(str, splitSentense, arrayList);
    }
}
